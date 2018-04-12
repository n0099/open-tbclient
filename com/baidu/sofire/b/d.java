package com.baidu.sofire.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.rp.Report;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.tencent.connect.common.Constants;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class d {
    public static String b;
    public static String c;
    public static boolean a = false;
    public static MyReceiver d = null;

    public static void a(Throwable th) {
        com.baidu.sofire.b.b(th);
    }

    public static String a() {
        try {
            return new String(F.getInstance().ad(Base64.decode("2s3neoRGrtMfJHEASAvJDkdImW3sImg0pRReW5cWEQQB2HfrzauSCia/ssvfdE6q", 0), "30212102dicudiab".getBytes()));
        } catch (Throwable th) {
            return "";
        }
    }

    public static void a(String str, String str2) {
        b = str;
        c = str2;
    }

    public static void b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            a(new File(str), new File(str2));
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static void a(java.io.File r5, java.io.File r6) {
        /*
            r2 = 0
            if (r5 == 0) goto Lb
            if (r6 == 0) goto Lb
            boolean r0 = a(r5)
            if (r0 != 0) goto Lc
        Lb:
            return
        Lc:
            boolean r0 = r6.exists()
            if (r0 == 0) goto L15
            r6.delete()
        L15:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L98
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L98
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L9b
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L9b
            r0 = 8192(0x2000, float:1.148E-41)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L2f
        L23:
            int r2 = r3.read(r0)     // Catch: java.lang.Throwable -> L2f
            r4 = -1
            if (r2 == r4) goto L44
            r4 = 0
            r1.write(r0, r4, r2)     // Catch: java.lang.Throwable -> L2f
            goto L23
        L2f:
            r0 = move-exception
            r2 = r3
        L31:
            com.baidu.sofire.b.b(r0)     // Catch: java.lang.Throwable -> L95
            if (r2 == 0) goto L39
            r2.close()     // Catch: java.io.IOException -> L73
        L39:
            if (r1 == 0) goto Lb
            r1.close()     // Catch: java.io.IOException -> L3f
            goto Lb
        L3f:
            r0 = move-exception
            r0.getMessage()
            goto Lb
        L44:
            r1.flush()     // Catch: java.lang.Throwable -> L2f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2f
            r0.<init>()     // Catch: java.lang.Throwable -> L2f
            java.lang.String r2 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L2f
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r2 = " > "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r2 = r6.getAbsolutePath()     // Catch: java.lang.Throwable -> L2f
            r0.append(r2)     // Catch: java.lang.Throwable -> L2f
            r3.close()     // Catch: java.io.IOException -> L6e
        L65:
            r1.close()     // Catch: java.io.IOException -> L69
            goto Lb
        L69:
            r0 = move-exception
            r0.getMessage()
            goto Lb
        L6e:
            r0 = move-exception
            r0.getMessage()
            goto L65
        L73:
            r0 = move-exception
            r0.getMessage()
            goto L39
        L78:
            r0 = move-exception
            r1 = r2
            r3 = r2
        L7b:
            if (r3 == 0) goto L80
            r3.close()     // Catch: java.io.IOException -> L86
        L80:
            if (r1 == 0) goto L85
            r1.close()     // Catch: java.io.IOException -> L8b
        L85:
            throw r0
        L86:
            r2 = move-exception
            r2.getMessage()
            goto L80
        L8b:
            r1 = move-exception
            r1.getMessage()
            goto L85
        L90:
            r0 = move-exception
            r1 = r2
            goto L7b
        L93:
            r0 = move-exception
            goto L7b
        L95:
            r0 = move-exception
            r3 = r2
            goto L7b
        L98:
            r0 = move-exception
            r1 = r2
            goto L31
        L9b:
            r0 = move-exception
            r1 = r2
            r2 = r3
            goto L31
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.d.a(java.io.File, java.io.File):void");
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return a(new File(str));
    }

    public static boolean a(File file) {
        return file != null && file.exists() && file.isFile() && file.canRead() && file.length() > 0;
    }

    public static void b(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (file.exists()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length > 0) {
                        for (File file2 : listFiles) {
                            if (file2.isDirectory()) {
                                b(file2.getAbsolutePath());
                            } else {
                                new StringBuilder().append(file2.getAbsolutePath()).append(" d:").append(file2.delete());
                            }
                        }
                    }
                    new StringBuilder().append(file.getAbsolutePath()).append(" d:").append(file.delete());
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.b(th);
        }
    }

    public static Object a(Object obj, String str, Class<?>[] clsArr, Object... objArr) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method;
        if (obj == null || TextUtils.isEmpty(str)) {
            throw new NoSuchMethodException("object=" + obj + ", methodName=" + str);
        }
        if (clsArr != null && objArr != null && clsArr.length != objArr.length) {
            throw new NoSuchMethodException("paramTypes or args fail");
        }
        Method[] declaredMethods = obj.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                method = null;
                break;
            }
            method = declaredMethods[i];
            if (a(method, str, clsArr)) {
                break;
            }
            i++;
        }
        if (method == null) {
            throw new NoSuchMethodException("cannot find method in target methodName=" + str);
        }
        return method.invoke(obj, objArr);
    }

    private static boolean a(Method method, String str, Class<?>[] clsArr) {
        if (str.equals(method.getName())) {
            new StringBuilder().append(str);
            Class<?>[] parameterTypes = method.getParameterTypes();
            if ((parameterTypes == null || parameterTypes.length == 0) && (clsArr == null || clsArr.length == 0)) {
                return true;
            }
            if ((clsArr == null || clsArr.length == 0) && parameterTypes != null && parameterTypes.length > 0) {
                return false;
            }
            if (((parameterTypes == null || parameterTypes.length == 0) && clsArr != null && clsArr.length > 0) || parameterTypes.length != clsArr.length) {
                return false;
            }
            for (int i = 0; i < parameterTypes.length; i++) {
                if (parameterTypes[i] != clsArr[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void a(String str, boolean z) {
        boolean d2 = d("771", str);
        new StringBuilder().append(str).append(",s=").append(d2);
        if (z) {
            String absolutePath = new File(str).getParentFile().getAbsolutePath();
            d("771", absolutePath);
            new StringBuilder().append(absolutePath).append(",s=").append(d2);
        }
    }

    private static boolean d(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !new File(str2).exists()) {
            return false;
        }
        try {
            Runtime.getRuntime().exec("chmod " + str + " " + str2 + "\n").waitFor();
            return true;
        } catch (Throwable th) {
            com.baidu.sofire.b.b(th);
            return false;
        }
    }

    public static void a(Context context) {
        try {
            Report report = Report.getInstance(context);
            JSONObject jSONObject = new JSONObject();
            com.baidu.sofire.a.a a2 = com.baidu.sofire.a.a.a(context);
            Map<Integer, String> b2 = a2.b();
            jSONObject.put("0", b2.keySet());
            jSONObject.put("1", b2.values());
            jSONObject.toString();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("1003003", jSONObject);
            jSONObject2.put("0", jSONObject3);
            Map<Integer, String> c2 = a2.c();
            JSONArray jSONArray = new JSONArray();
            for (String str : c2.values()) {
                jSONArray.put(str);
            }
            jSONArray.put("com.baidu.sofire");
            jSONObject2.put("2", jSONArray);
            report.w(jSONObject2.toString());
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public static void b(Context context) {
        if (!TextUtils.isEmpty("3.1.0")) {
            Report report = Report.getInstance(context);
            try {
                a(context);
                report.i("sofire", "com.baidu.sofire", "3.1.0", "1003003", "1003002");
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    public static String c(String str) {
        try {
            int length = str.length();
            int i = 0;
            while (i < length && (str.charAt(i) <= ' ' || str.charAt(i) == 160)) {
                i++;
            }
            if (i > 0) {
                return str.substring(i);
            }
            return str;
        } catch (Throwable th) {
            com.baidu.sofire.b.b(th);
            return "";
        }
    }

    public static void a(Context context, String str, Map<String, Object> map) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("0", System.currentTimeMillis());
                jSONObject2.put("1", "");
                jSONObject2.put("2", "");
                String[] e = e(context);
                if (e != null && e.length == 2 && !TextUtils.isEmpty(e[0]) && !TextUtils.isEmpty(e[1])) {
                    str2 = e[0];
                } else {
                    str2 = "3";
                }
                jSONObject2.put("3", str2);
                jSONObject2.put("4", 0);
                jSONObject2.put("5", 0);
                jSONObject2.put("6", 1);
                jSONObject2.put("7", 0);
                jSONObject2.put(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, "sofire");
                jSONObject2.put("9", "3.1.0");
                jSONObject2.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, str);
                jSONObject.put("Common_section", jSONObject2);
                if (map.size() > 0) {
                    jSONObject.put("Module_section", new JSONObject(map));
                } else {
                    jSONObject.put("Module_section", new JSONObject());
                }
                Report report = Report.getInstance(context);
                String jSONObject3 = jSONObject.toString();
                new StringBuilder().append(jSONObject3);
                report.s(jSONObject3);
            } catch (Throwable th) {
                com.baidu.sofire.b.b(th);
            }
        }
    }

    public static String a(Context context, String str, String str2) {
        String str3 = "";
        try {
            Properties properties = new Properties();
            InputStream inputStream = null;
            try {
                inputStream = context.getAssets().open(str);
                properties.load(inputStream);
                str3 = properties.getProperty(str2);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.getMessage();
                    }
                }
            } catch (IOException e2) {
                e2.getMessage();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e3.getMessage();
                    }
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.b(th);
        }
        return str3;
    }

    public static boolean c(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && 1 == activeNetworkInfo.getType()) {
            return true;
        }
        return false;
    }

    public static boolean d(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Throwable th) {
            com.baidu.sofire.b.b(th);
            return false;
        }
    }

    public static String[] e(Context context) {
        String[] split;
        String[] split2;
        String str = b;
        String str2 = c;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                String string = new com.baidu.sofire.e(context).a.getString("svi_n", "");
                if (!TextUtils.isEmpty(string) && (split = string.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)) != null && split.length == 2) {
                    return split;
                }
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                String string2 = new com.baidu.sofire.e(context).a.getString("svi", "");
                if (!TextUtils.isEmpty(string2) && (split2 = string2.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)) != null && split2.length == 2) {
                    return split2;
                }
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                str = "3";
                str2 = "925fc15df8a49bed0b3eca8d2b44cb7b";
            }
            return new String[]{str, str2};
        }
        return new String[]{str, str2};
    }

    public static String[] f(Context context) {
        if (TextUtils.isEmpty(b) || TextUtils.isEmpty(c)) {
            String string = new com.baidu.sofire.e(context).a.getString("svi_n", "");
            if (!TextUtils.isEmpty(string)) {
                String[] split = string.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split == null || split.length != 2) {
                    return new String[2];
                }
                b = split[0];
                c = split[1];
                return split;
            }
            return null;
        }
        return new String[]{b, c};
    }

    private static Map<String, Integer> e(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, (Integer) jSONObject.get(next));
            }
            return hashMap;
        } catch (Throwable th) {
            com.baidu.sofire.b.b(th);
            return null;
        }
    }

    public static void d(String str) {
        Map<String, Integer> map;
        try {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(com.baidu.sofire.core.c.b);
            String string = eVar.a.getString("ses_ic", "");
            if (TextUtils.isEmpty(string)) {
                map = new HashMap<>();
                map.put(str, 1);
            } else {
                Map<String, Integer> e = e(string);
                if (e != null && e.size() > 0) {
                    if (e.get(str) != null) {
                        e.put(str, Integer.valueOf(e.get(str).intValue() + 1));
                        map = e;
                    } else {
                        e.put(str, 1);
                    }
                }
                map = e;
            }
            if (map != null && map.size() > 0) {
                eVar.c.putString("ses_ic", new JSONObject(map).toString());
                eVar.c.commit();
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.b(th);
        }
    }

    public static void g(Context context) {
        Map<String, Integer> e;
        try {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(com.baidu.sofire.core.c.b);
            String string = eVar.a.getString("ses_ic", "");
            if (!TextUtils.isEmpty(string) && (e = e(string)) != null && e.size() > 0) {
                HashMap hashMap = new HashMap();
                for (int i = 0; i < 15; i++) {
                    Integer num = e.get(Integer.toString(i));
                    hashMap.put(Integer.toString(i), num == null ? "" : num.toString());
                }
                a(context, "1003137", hashMap);
                eVar.c.putString("ses_ic", "");
                eVar.c.commit();
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.b(th);
        }
    }

    public static boolean a(Context context, int i) {
        if (i == 1) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!(activeNetworkInfo != null && 1 == activeNetworkInfo.getType())) {
                IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                if (d == null) {
                    d = new MyReceiver().a();
                }
                context.getApplicationContext().registerReceiver(d, intentFilter);
                a = true;
                return false;
            }
        }
        return true;
    }

    public static void h(Context context) {
        byte[] encoded;
        try {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            String a2 = eVar.a();
            long j = eVar.a.getLong("lslt", 0L);
            if (!TextUtils.isEmpty(a2) || j != 0) {
                String packageName = context.getPackageName();
                JSONArray jSONArray = new JSONArray(a2);
                String str = "";
                String str2 = "";
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 64);
                if (packageInfo != null) {
                    str2 = packageInfo.applicationInfo.sourceDir;
                    PublicKey a3 = c.a(str2);
                    PublicKey publicKey = (a3 != null || packageInfo.signatures == null || packageInfo.signatures.length <= 0 || packageInfo.signatures[0] == null) ? a3 : CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray())).getPublicKey();
                    if (publicKey != null && (encoded = publicKey.getEncoded()) != null) {
                        a(context, encoded);
                        str = l.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", ""));
                    }
                }
                boolean z = false;
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("p");
                    String optString2 = optJSONObject.optString(NotifyType.SOUND);
                    if (packageName.equals(optString) && !TextUtils.isEmpty(str) && str.equalsIgnoreCase(optString2)) {
                        z = true;
                    }
                }
                new StringBuilder().append(z);
                eVar.c.putBoolean("hac", z);
                eVar.c.commit();
                if (!z) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", packageName);
                    hashMap.put("1", str);
                    if (!TextUtils.isEmpty(str2)) {
                        File file = new File(str2);
                        if (file.exists()) {
                            hashMap.put("2", l.a(file));
                        } else {
                            hashMap.put("2", "");
                        }
                    } else {
                        hashMap.put("2", "");
                    }
                    a(context.getApplicationContext(), "1003120", hashMap);
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.b(th);
        }
    }

    public static boolean a(Context context, String str) {
        try {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            String a2 = eVar.a();
            long j = eVar.a.getLong("lslt", 0L);
            if (TextUtils.isEmpty(a2) && j == 0) {
                return false;
            }
            JSONArray jSONArray = new JSONArray(a2);
            String str2 = "";
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null) {
                PublicKey a3 = c.a(packageInfo.applicationInfo.sourceDir);
                PublicKey publicKey = (a3 != null || packageInfo.signatures == null || packageInfo.signatures.length <= 0 || packageInfo.signatures[0] == null) ? a3 : CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray())).getPublicKey();
                if (publicKey != null) {
                    byte[] encoded = publicKey.getEncoded();
                    if (encoded != null) {
                        a(context, encoded);
                        str2 = l.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", ""));
                    }
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        String optString = optJSONObject.optString("p");
                        String optString2 = optJSONObject.optString(NotifyType.SOUND);
                        if (str.equals(optString) && !TextUtils.isEmpty(str2) && str2.equalsIgnoreCase(optString2)) {
                            return true;
                        }
                    }
                    return false;
                }
                return true;
            }
            return true;
        } catch (Throwable th) {
            com.baidu.sofire.b.b(th);
            return true;
        }
    }

    public static void a(Context context, byte[] bArr) {
        try {
            String[] e = e(context);
            if (e == null || e.length != 2 || TextUtils.isEmpty(e[0]) || TextUtils.isEmpty(e[1]) || !"200080".equals(e[0]) || !context.getPackageName().equals("com.baidu.BaiduMap") || bArr == null) {
                return;
            }
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) (bArr[i] ^ 246);
            }
        } catch (Throwable th) {
        }
    }

    public static void i(Context context) {
        com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
        long currentTimeMillis = System.currentTimeMillis();
        long j = eVar.a.getLong("se_ae_fd", 0L);
        if (j == 0) {
            j = System.currentTimeMillis();
            eVar.c.putLong("se_ae_fd", System.currentTimeMillis());
            eVar.c.commit();
        }
        if (currentTimeMillis - j > 86400000) {
            HashMap hashMap = new HashMap();
            hashMap.put("0", Integer.valueOf(eVar.a.getInt("mo_ae_fa_ct", 0) + 1));
            eVar.c.putInt("mo_ae_fa_ct", 0);
            eVar.c.commit();
            eVar.c.putLong("se_ae_fd", System.currentTimeMillis());
            eVar.c.commit();
            a(context, "1003119", hashMap);
            return;
        }
        eVar.c.putInt("mo_ae_fa_ct", eVar.a.getInt("mo_ae_fa_ct", 0) + 1);
        eVar.c.commit();
    }

    public static boolean c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            for (int i = 0; i < split.length && i < split2.length; i++) {
                int intValue = Integer.valueOf(split[i]).intValue() - Integer.valueOf(split2[i]).intValue();
                if (intValue != 0) {
                    return intValue > 0;
                }
            }
            return split.length > split2.length;
        } catch (Throwable th) {
            return false;
        }
    }

    public static int j(Context context) {
        ConnectivityManager connectivityManager;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Throwable th) {
            com.baidu.sofire.b.b(th);
        }
        if (connectivityManager == null) {
            return -1;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
            if (activeNetworkInfo.getType() == 1) {
                return 4;
            }
            if (activeNetworkInfo.getType() == 0) {
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                        return 1;
                    case 2:
                        return 1;
                    case 3:
                        return 2;
                    case 4:
                        return 1;
                    case 5:
                        return 2;
                    case 6:
                        return 2;
                    case 7:
                        return 1;
                    case 8:
                        return 2;
                    case 9:
                        return 2;
                    case 10:
                        return 2;
                    case 11:
                        return 1;
                    case 12:
                        return 2;
                    case 13:
                        return 3;
                    case 14:
                        return 2;
                    case 15:
                        return 2;
                    default:
                        return 5;
                }
            }
            return -2;
        }
        return -1;
    }

    private static String m(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "1.0.0";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x011b A[Catch: Exception -> 0x0153, TryCatch #0 {Exception -> 0x0153, blocks: (B:3:0x0005, B:6:0x000f, B:9:0x001c, B:11:0x0024, B:15:0x002e, B:18:0x003b, B:21:0x0048, B:24:0x0055, B:27:0x0062, B:30:0x006f, B:33:0x0086, B:36:0x0093, B:39:0x00aa, B:41:0x00cd, B:43:0x00d6, B:51:0x012b, B:46:0x00e2, B:48:0x011b, B:58:0x0149, B:54:0x0138), top: B:62:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0149 A[Catch: Exception -> 0x0153, TRY_LEAVE, TryCatch #0 {Exception -> 0x0153, blocks: (B:3:0x0005, B:6:0x000f, B:9:0x001c, B:11:0x0024, B:15:0x002e, B:18:0x003b, B:21:0x0048, B:24:0x0055, B:27:0x0062, B:30:0x006f, B:33:0x0086, B:36:0x0093, B:39:0x00aa, B:41:0x00cd, B:43:0x00d6, B:51:0x012b, B:46:0x00e2, B:48:0x011b, B:58:0x0149, B:54:0x0138), top: B:62:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject k(Context context) {
        String str;
        String g;
        String str2;
        TimeZone timeZone;
        JSONObject jSONObject = new JSONObject();
        try {
            String str3 = Build.BOARD;
            if (str3 == null) {
                str3 = "";
            }
            jSONObject.put("0", str3);
            String str4 = Build.DEVICE;
            if (str4 == null) {
                str4 = "";
            }
            jSONObject.put("1", str4);
            if (Build.VERSION.SDK_INT > 7) {
                str = Build.HARDWARE;
            } else {
                str = "";
            }
            if (str == null) {
                str = "";
            }
            jSONObject.put("2", str);
            String str5 = Build.HOST;
            if (str5 == null) {
                str5 = "";
            }
            jSONObject.put("3", str5);
            String str6 = Build.DISPLAY;
            if (str6 == null) {
                str6 = "";
            }
            jSONObject.put("4", str6);
            String str7 = Build.PRODUCT;
            if (str7 == null) {
                str7 = "";
            }
            jSONObject.put("5", str7);
            String str8 = Build.VERSION.CODENAME;
            if (str8 == null) {
                str8 = "";
            }
            jSONObject.put("6", str8);
            String str9 = Build.VERSION.INCREMENTAL;
            if (str9 == null) {
                str9 = "";
            }
            jSONObject.put("7", str9);
            jSONObject.put(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, f.a(context));
            String str10 = Build.MANUFACTURER;
            if (str10 == null) {
                str10 = "";
            }
            jSONObject.put("9", str10);
            String str11 = Build.MODEL;
            if (str11 == null) {
                str11 = "";
            }
            jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, str11);
            jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, f.f(context));
            String str12 = Build.VERSION.RELEASE;
            if (str12 == null) {
                str12 = "";
            }
            jSONObject.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, str12);
            jSONObject.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, f.b(context));
            jSONObject.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "");
            g = f.g(context);
        } catch (Exception e) {
            com.baidu.sofire.b.b(e);
        }
        if (!TextUtils.isEmpty(g)) {
            if (g.startsWith("46000") || g.startsWith("46002")) {
                str2 = "1";
            } else if (g.startsWith("46001")) {
                str2 = "2";
            } else if (g.startsWith("46003")) {
                str2 = "3";
            }
            jSONObject.put(Constants.VIA_REPORT_TYPE_WPA_STATE, str2);
            jSONObject.put(Constants.VIA_REPORT_TYPE_START_WAP, f.h(context));
            jSONObject.put(Constants.VIA_REPORT_TYPE_START_GROUP, f.i(context));
            jSONObject.put("18", f.j(context));
            jSONObject.put(Constants.VIA_ACT_TYPE_NINETEEN, f.k(context));
            jSONObject.put("20", Build.VERSION.SDK_INT);
            timeZone = TimeZone.getDefault();
            if (timeZone == null) {
                jSONObject.put(Constants.VIA_REPORT_TYPE_QQFAVORITES, timeZone.getID());
            } else {
                jSONObject.put(Constants.VIA_REPORT_TYPE_QQFAVORITES, WeiboAuthException.DEFAULT_AUTH_ERROR_CODE);
            }
            return jSONObject;
        }
        str2 = "";
        jSONObject.put(Constants.VIA_REPORT_TYPE_WPA_STATE, str2);
        jSONObject.put(Constants.VIA_REPORT_TYPE_START_WAP, f.h(context));
        jSONObject.put(Constants.VIA_REPORT_TYPE_START_GROUP, f.i(context));
        jSONObject.put("18", f.j(context));
        jSONObject.put(Constants.VIA_ACT_TYPE_NINETEEN, f.k(context));
        jSONObject.put("20", Build.VERSION.SDK_INT);
        timeZone = TimeZone.getDefault();
        if (timeZone == null) {
        }
        return jSONObject;
    }

    public static JSONObject a(Context context, com.baidu.sofire.rp.a.a aVar, String str, boolean z) {
        return a(context, aVar.a, aVar.c, z ? aVar.d : aVar.e, str);
    }

    public static int l(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            new StringBuilder("sj-trigger info ").append(e.toString());
            com.baidu.sofire.b.b(e);
            networkInfo = null;
        }
        if (networkInfo == null) {
            return 0;
        }
        if (1 == networkInfo.getType()) {
            return 2;
        }
        return networkInfo.getType() == 0 ? 1 : 1;
    }

    public static JSONObject a(Context context, JSONObject jSONObject) {
        String str;
        JSONObject jSONObject2 = new JSONObject();
        System.currentTimeMillis();
        JSONObject jSONObject3 = null;
        try {
            jSONObject3 = jSONObject.getJSONObject("Common_section");
        } catch (Exception e) {
            com.baidu.sofire.b.b(e);
        }
        String optString = jSONObject3.optString(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        long optLong = jSONObject3.optLong("0");
        String optString2 = jSONObject3.optString("1");
        String optString3 = jSONObject3.optString("3");
        String optString4 = jSONObject3.optString(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO);
        String optString5 = jSONObject3.optString("9");
        try {
            try {
                str = context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
            } catch (Exception e2) {
                com.baidu.sofire.b.b(e2);
                str = "";
            }
            jSONObject2.put("1", str);
            jSONObject2.put("2", context.getPackageName());
            jSONObject2.put("3", m(context));
            jSONObject2.put("4", f.a(context));
            jSONObject2.put("5", optString);
            jSONObject2.put("6", optLong);
            jSONObject2.put("7", optString2);
            jSONObject2.put(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, optString3);
            jSONObject2.put("9", optString4);
            jSONObject2.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, optString5);
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            jSONObject2.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, eVar.e.getString("re_a_cv", ""));
            jSONObject2.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, eVar.e.getString("re_a_lc", ""));
            jSONObject2.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, eVar.a.getBoolean("hac", false) ? 1 : 0);
            if (j(context) == 4) {
                jSONObject2.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, 1);
            } else {
                jSONObject2.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, 2);
            }
            jSONObject2.put("20", f.d(context));
            jSONObject2.put(Constants.VIA_REPORT_TYPE_QQFAVORITES, f.e(context));
            jSONObject2.put(Constants.VIA_REPORT_TYPE_DATALINE, f.b(context));
            Object obj = jSONObject.get("Module_section");
            if (obj instanceof JSONArray) {
                jSONObject2.put("module_section", obj);
            } else {
                jSONObject2.put("module_section", new JSONArray().put(obj));
            }
        } catch (Exception e3) {
            com.baidu.sofire.b.b(e3);
        }
        return jSONObject2;
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        int indexOf;
        com.baidu.sofire.rp.a.a aVar;
        e.a(context).a();
        e a2 = e.a(context);
        Message message = new Message();
        message.what = 8;
        a2.a.a.sendMessage(message);
        com.baidu.sofire.rp.a.a aVar2 = new com.baidu.sofire.rp.a.a();
        aVar2.a = str;
        aVar2.b = str2;
        aVar2.c = str3;
        aVar2.d = str4;
        aVar2.e = str5;
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            List<com.baidu.sofire.rp.a.a> d2 = eVar.d();
            if (d2 == null) {
                eVar.a(aVar2);
            } else if (!d2.contains(aVar2)) {
                eVar.a(aVar2);
            } else {
                if (d2 != null && (indexOf = d2.indexOf(aVar2)) != -1 && (aVar = d2.get(indexOf)) != null) {
                    eVar.f.putString("re_con", eVar.e.getString("re_con", "").replace(com.baidu.sofire.rp.a.a.a(aVar), com.baidu.sofire.rp.a.a.a(aVar2)));
                    eVar.f.commit();
                }
                com.baidu.sofire.rp.e.a aVar3 = e.a(context).a;
                Message message2 = new Message();
                message2.what = 7;
                aVar3.a.sendMessage(message2);
                return;
            }
            if (!eVar.e.getBoolean("re_net_ins_" + aVar2.e, false)) {
                e a3 = e.a(context);
                Message message3 = new Message();
                message3.what = 3;
                message3.obj = aVar2;
                a3.a.a.sendMessage(message3);
            }
            com.baidu.sofire.rp.e.a aVar4 = e.a(context).a;
            Message message4 = new Message();
            message4.what = 7;
            aVar4.a.sendMessage(message4);
            e a4 = e.a(context);
            Message message5 = new Message();
            message5.what = 2;
            a4.a.a.sendMessage(message5);
        }
    }

    public static void b(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            System.currentTimeMillis();
            eVar.e.getInt("re_net_ty", 2);
            JSONObject optJSONObject = jSONObject.optJSONObject("Common_section");
            long optLong = optJSONObject.optLong("0");
            String optString = optJSONObject.optString(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
            int optInt = optJSONObject.optInt("5");
            int optInt2 = optJSONObject.optInt("6");
            int optInt3 = optJSONObject.optInt("7");
            int optInt4 = optJSONObject.optInt(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
            String optString2 = optJSONObject.optString(Constants.VIA_REPORT_TYPE_SET_AVATAR, "");
            int i = optInt2 != 0 ? optInt2 : 1;
            com.baidu.sofire.rp.c.a aVar = new com.baidu.sofire.rp.c.a();
            aVar.d = str;
            aVar.b = optString;
            aVar.g = optInt;
            aVar.c = 3;
            aVar.e = optLong;
            aVar.f = i;
            aVar.h = optInt3;
            aVar.i = optInt4;
            aVar.j = optString2;
            e a2 = e.a(context);
            Message message = new Message();
            message.what = 1;
            message.obj = aVar;
            a2.a.a.sendMessage(message);
        } catch (Exception e) {
            com.baidu.sofire.b.b(e);
        }
    }

    public static void c(Context context, String str) {
        com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("0");
                if (optJSONObject != null) {
                    String str2 = "";
                    while (optJSONObject.keys().hasNext()) {
                        str2 = String.valueOf(optJSONObject.keys().next());
                        if (!TextUtils.isEmpty(str2)) {
                            break;
                        }
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        eVar.f.putString("al_da" + str2, optJSONObject.optString(str2));
                        eVar.f.commit();
                    }
                }
            } catch (Exception e) {
                com.baidu.sofire.b.b(e);
            }
            try {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("1");
                if (optJSONObject2 != null) {
                    String str3 = "";
                    while (optJSONObject2.keys().hasNext()) {
                        str3 = String.valueOf(optJSONObject2.keys().next());
                        if (!TextUtils.isEmpty(str3)) {
                            break;
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        eVar.f.putString("in_da" + str3, optJSONObject2.optString(str3));
                        eVar.f.commit();
                    }
                }
            } catch (Exception e2) {
                com.baidu.sofire.b.b(e2);
            }
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("2");
                if (optJSONArray != null) {
                    eVar.f.putString("li_pk_s", optJSONArray.toString());
                    eVar.f.commit();
                }
            } catch (Exception e3) {
                com.baidu.sofire.b.b(e3);
            }
        } catch (Exception e4) {
            com.baidu.sofire.b.b(e4);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r1v1 int), (r2v1 int), (wrap: int : 0x000f: INVOKE  (r0v1 int A[REMOVE]) = (r0v0 java.util.Calendar), (5 int) type: VIRTUAL call: java.util.Calendar.get(int):int)] */
    public static String b() {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        return new StringBuilder().append(i).append(i2).append(calendar.get(5)).toString();
    }

    public static JSONObject a(Context context, String str, String str2, String str3, String str4) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject = new JSONObject();
            jSONObject.put("0", System.currentTimeMillis());
            jSONObject.put("1", "0");
            jSONObject.put("2", "0");
            String[] e = e(context);
            if (e != null && e.length == 2) {
                jSONObject.put("3", e[0]);
            } else {
                jSONObject.put("3", "3");
            }
            jSONObject.put("4", 0);
            jSONObject.put("5", 0);
            jSONObject.put("6", 1);
            jSONObject.put("7", 0);
            jSONObject.put(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, str);
            jSONObject.put("9", str2);
            jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, str3);
            jSONObject2 = new JSONObject();
        } catch (Exception e2) {
            com.baidu.sofire.b.b(e2);
        }
        if (!TextUtils.isEmpty(str4)) {
            try {
                jSONObject3 = new JSONObject(str4);
            } catch (Exception e3) {
                com.baidu.sofire.b.b(e3);
            }
            jSONObject4.put("Common_section", jSONObject);
            jSONObject4.put("Module_section", jSONObject3);
            return jSONObject4;
        }
        jSONObject3 = jSONObject2;
        jSONObject4.put("Common_section", jSONObject);
        jSONObject4.put("Module_section", jSONObject3);
        return jSONObject4;
    }

    public static void a(Context context, long j) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 101, new Intent("com.b.r.p"), 134217728);
        try {
            alarmManager.cancel(broadcast);
        } catch (Throwable th) {
            com.baidu.sofire.b.b(th);
        }
        try {
            alarmManager.set(0, System.currentTimeMillis() + j, broadcast);
        } catch (Exception e) {
            com.baidu.sofire.b.b(e);
        }
    }

    public static void a(final Context context, final String str, final String str2, final int... iArr) {
        try {
            new Thread(new Runnable() { // from class: com.baidu.sofire.b.d.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        f.a(context);
                        new com.baidu.sofire.e(context).a(iArr);
                        com.baidu.sofire.core.c a2 = com.baidu.sofire.core.c.a(context);
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                            a2.a(str, str2);
                        }
                        com.baidu.sofire.core.c.a(1);
                        a2.a((Callback) null);
                    } catch (Throwable th) {
                        d.a(th);
                    }
                }
            }).start();
        } catch (Throwable th) {
            com.baidu.sofire.b.b(th);
        }
    }

    public static String a(byte[] bArr) {
        String str = "";
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            str = str + hexString.toUpperCase();
        }
        return str;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.baidu.sofire.core.c$3] */
    public static boolean a(final int i, final String str, final Callback callback, final Class<?>[] clsArr, final Object... objArr) {
        try {
            final com.baidu.sofire.core.c a2 = com.baidu.sofire.core.c.a();
            if (a2 == null) {
                for (int i2 = 0; i2 < 20; i2++) {
                    try {
                        Thread.sleep(50L);
                    } catch (InterruptedException e) {
                        com.baidu.sofire.b.b(e);
                    }
                    a2 = com.baidu.sofire.core.c.a();
                    if (a2 != null) {
                        break;
                    }
                }
                if (a2 == null) {
                    return false;
                }
            }
            new StringBuilder().append(str);
            HashMap hashMap = new HashMap();
            hashMap.put("0", Integer.toString(i));
            hashMap.put("1", !TextUtils.isEmpty(str) ? str : " ");
            hashMap.put("2", "0");
            a(com.baidu.sofire.core.c.b, "1003136", hashMap);
            if (TextUtils.isEmpty(str)) {
                if (callback != null) {
                    callback.onError(1);
                }
            } else {
                new Thread() { // from class: com.baidu.sofire.core.c.3
                    @Override // java.lang.Thread, java.lang.Runnable
                    public final void run() {
                        ApkInfo apkInfo;
                        boolean z;
                        ApkInfo apkInfo2 = null;
                        super.run();
                        try {
                            if (callback != null) {
                                callback.onBegin(new Object[0]);
                            }
                            if (c.this.c.d(i)) {
                                long currentTimeMillis = System.currentTimeMillis();
                                while (c.this.c.d(i) && System.currentTimeMillis() - currentTimeMillis < 10000) {
                                    SystemClock.sleep(300L);
                                }
                            }
                            if (!c.this.c.d(i)) {
                                if (!c.this.e) {
                                    c.a(3);
                                    c.this.a((Callback) null);
                                }
                                e a3 = e.a(c.b.getApplicationContext());
                                long currentTimeMillis2 = System.currentTimeMillis();
                                while (System.currentTimeMillis() - currentTimeMillis2 <= 120000) {
                                    apkInfo2 = c.this.c.a(i);
                                    if (apkInfo2 != null) {
                                        if (a3.d(apkInfo2.packageName) == null) {
                                            if (apkInfo2.initStatus == -1) {
                                                break;
                                            }
                                        } else {
                                            apkInfo = apkInfo2;
                                            z = true;
                                            break;
                                        }
                                    }
                                    SystemClock.sleep(1000L);
                                }
                                apkInfo = apkInfo2;
                                z = false;
                                if (!z) {
                                    if (callback != null) {
                                        callback.onError(4);
                                        return;
                                    }
                                    return;
                                }
                                Class<?> a4 = ((d) a3.d(apkInfo.packageName).classLoader).a("com.baidu.sofire.engine.EngineImpl");
                                Object a5 = com.baidu.sofire.b.d.a(a4.getDeclaredMethod("getInstance", Context.class).invoke(a4, c.b), str, clsArr, objArr);
                                try {
                                    new StringBuilder().append(a5);
                                } catch (Throwable th) {
                                    com.baidu.sofire.b.d.a(th);
                                }
                                if (callback != null) {
                                    callback.onEnd(a5);
                                }
                            } else if (callback != null) {
                                callback.onError(3);
                            }
                        } catch (IllegalAccessException e2) {
                            e2.getMessage();
                            if (callback != null) {
                                callback.onError(2);
                            }
                        } catch (IllegalArgumentException e3) {
                            e3.getMessage();
                            if (callback != null) {
                                callback.onError(2);
                            }
                        } catch (NoSuchMethodException e4) {
                            e4.getMessage();
                            if (callback != null) {
                                callback.onError(2);
                            }
                        } catch (InvocationTargetException e5) {
                            e5.getMessage();
                            if (callback != null) {
                                callback.onError(2);
                            }
                        } catch (Throwable th2) {
                            th2.getMessage();
                            if (callback != null) {
                                callback.onError(3);
                            }
                        }
                    }
                }.start();
            }
            return true;
        } catch (Throwable th) {
            com.baidu.sofire.b.b(th);
            return false;
        }
    }
}
