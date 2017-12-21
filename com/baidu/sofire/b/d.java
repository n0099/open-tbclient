package com.baidu.sofire.b;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.rp.Report;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class d {
    public static String b;
    public static String c;
    public static boolean a = false;
    public static MyReceiver Qm = null;

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

    public static void a(Context context, byte[] bArr) {
        try {
            String[] e = e(context);
            if (e == null || e.length != 2 || TextUtils.isEmpty(e[0]) || TextUtils.isEmpty(e[1]) || !"200080".equals(e[0]) || !"com.baidu.BaiduMap".equals(context.getPackageName()) || bArr == null) {
                return;
            }
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) (bArr[i] ^ 246);
            }
        } catch (Throwable th) {
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
        boolean J = J("771", str);
        new StringBuilder().append(str).append(",s=").append(J);
        if (z) {
            String absolutePath = new File(str).getParentFile().getAbsolutePath();
            J("771", absolutePath);
            new StringBuilder().append(absolutePath).append(",s=").append(J);
        }
    }

    private static boolean J(String str, String str2) {
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
            com.baidu.sofire.a.a an = com.baidu.sofire.a.a.an(context);
            Map<Integer, String> b2 = an.b();
            jSONObject.put("0", b2.keySet());
            jSONObject.put("1", b2.values());
            jSONObject.toString();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("1003003", jSONObject);
            jSONObject2.put("0", jSONObject3);
            Map<Integer, String> c2 = an.c();
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
        if (!TextUtils.isEmpty("3.0.6.1")) {
            Report report = Report.getInstance(context);
            try {
                a(context);
                report.i("sofire", "com.baidu.sofire", "3.0.6.1", "1003003", "1003002");
            } catch (Throwable th) {
                th.getMessage();
            }
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
                jSONObject2.put("8", "sofire");
                jSONObject2.put("9", "3.0.6.1");
                jSONObject2.put("10", str);
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
        if (TextUtils.isEmpty(b) || TextUtils.isEmpty(c)) {
            String string = new com.baidu.sofire.e(context).a.getString("svi", "");
            if (!TextUtils.isEmpty(string)) {
                String[] split = string.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split == null || split.length != 2) {
                    return new String[2];
                }
                b = split[0];
                c = split[1];
                return split;
            }
            return new String[2];
        }
        return new String[]{b, c};
    }

    public static boolean a(Context context, int i) {
        if (i == 1) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!(activeNetworkInfo != null && 1 == activeNetworkInfo.getType())) {
                IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                if (Qm == null) {
                    Qm = new MyReceiver().a();
                }
                context.getApplicationContext().registerReceiver(Qm, intentFilter);
                a = true;
                return false;
            }
        }
        return true;
    }

    public static void f(Context context) {
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
                    PublicKey bW = c.bW(str2);
                    PublicKey publicKey = (bW != null || packageInfo.signatures == null || packageInfo.signatures.length <= 0 || packageInfo.signatures[0] == null) ? bW : CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray())).getPublicKey();
                    if (publicKey != null && (encoded = publicKey.getEncoded()) != null) {
                        a(context, encoded);
                        str = j.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", ""));
                    }
                }
                boolean z = false;
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("p");
                    String optString2 = optJSONObject.optString("s");
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
                            hashMap.put("2", j.a(file));
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
                PublicKey bW = c.bW(packageInfo.applicationInfo.sourceDir);
                PublicKey publicKey = (bW != null || packageInfo.signatures == null || packageInfo.signatures.length <= 0 || packageInfo.signatures[0] == null) ? bW : CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray())).getPublicKey();
                if (publicKey != null) {
                    byte[] encoded = publicKey.getEncoded();
                    if (encoded != null) {
                        a(context, encoded);
                        str2 = j.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", ""));
                    }
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        String optString = optJSONObject.optString("p");
                        String optString2 = optJSONObject.optString("s");
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

    public static void g(Context context) {
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

    public static int ao(Context context) {
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
}
