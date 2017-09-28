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
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
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
    public static MyReceiver PN = null;

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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [107=4] */
    public static void a(java.io.File r5, java.io.File r6) {
        /*
            r2 = 0
            if (r5 == 0) goto Lb
            if (r6 == 0) goto Lb
            boolean r0 = o(r5)
            if (r0 != 0) goto Lc
        Lb:
            return
        Lc:
            boolean r0 = r6.exists()
            if (r0 == 0) goto L15
            r6.delete()
        L15:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> Lb1
            r3.<init>(r5)     // Catch: java.lang.Throwable -> Lb1
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> Lb5
            r1.<init>(r6)     // Catch: java.lang.Throwable -> Lb5
            r0 = 8192(0x2000, float:1.148E-41)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L2f
        L23:
            int r2 = r3.read(r0)     // Catch: java.lang.Throwable -> L2f
            r4 = -1
            if (r2 == r4) goto L47
            r4 = 0
            r1.write(r0, r4, r2)     // Catch: java.lang.Throwable -> L2f
            goto L23
        L2f:
            r0 = move-exception
            r2 = r3
        L31:
            com.baidu.sofire.b.b(r0)     // Catch: java.lang.Throwable -> Lae
            if (r2 == 0) goto L39
            r2.close()     // Catch: java.io.IOException -> L83
        L39:
            if (r1 == 0) goto Lb
            r1.close()     // Catch: java.io.IOException -> L3f
            goto Lb
        L3f:
            r0 = move-exception
            r0.getMessage()
            com.baidu.sofire.b.b()
            goto Lb
        L47:
            r1.flush()     // Catch: java.lang.Throwable -> L2f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2f
            r0.<init>()     // Catch: java.lang.Throwable -> L2f
            java.lang.String r2 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L2f
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r2 = " > "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r2 = r6.getAbsolutePath()     // Catch: java.lang.Throwable -> L2f
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L2f
            r0.toString()     // Catch: java.lang.Throwable -> L2f
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> L2f
            r3.close()     // Catch: java.io.IOException -> L7b
        L6f:
            r1.close()     // Catch: java.io.IOException -> L73
            goto Lb
        L73:
            r0 = move-exception
            r0.getMessage()
            com.baidu.sofire.b.b()
            goto Lb
        L7b:
            r0 = move-exception
            r0.getMessage()
            com.baidu.sofire.b.b()
            goto L6f
        L83:
            r0 = move-exception
            r0.getMessage()
            com.baidu.sofire.b.b()
            goto L39
        L8b:
            r0 = move-exception
            r1 = r2
            r3 = r2
        L8e:
            if (r3 == 0) goto L93
            r3.close()     // Catch: java.io.IOException -> L99
        L93:
            if (r1 == 0) goto L98
            r1.close()     // Catch: java.io.IOException -> La1
        L98:
            throw r0
        L99:
            r2 = move-exception
            r2.getMessage()
            com.baidu.sofire.b.b()
            goto L93
        La1:
            r1 = move-exception
            r1.getMessage()
            com.baidu.sofire.b.b()
            goto L98
        La9:
            r0 = move-exception
            r1 = r2
            goto L8e
        Lac:
            r0 = move-exception
            goto L8e
        Lae:
            r0 = move-exception
            r3 = r2
            goto L8e
        Lb1:
            r0 = move-exception
            r1 = r2
            goto L31
        Lb5:
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
        return o(new File(str));
    }

    public static boolean o(File file) {
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
                                String str2 = file2.getAbsolutePath() + " d:" + file2.delete();
                                com.baidu.sofire.b.a();
                            }
                        }
                    }
                    String str3 = file.getAbsolutePath() + " d:" + file.delete();
                    com.baidu.sofire.b.a();
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.b(th);
        }
    }

    public static Object a(Object obj, String str, Class<?>[] clsArr, Object... objArr) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method;
        if (obj == null || TextUtils.isEmpty(str)) {
            com.baidu.sofire.b.a();
            throw new NoSuchMethodException("object=" + obj + ", methodName=" + str);
        } else if (clsArr != null && objArr != null && clsArr.length != objArr.length) {
            com.baidu.sofire.b.a();
            throw new NoSuchMethodException("paramTypes or args fail");
        } else {
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
                com.baidu.sofire.b.a();
                throw new NoSuchMethodException("cannot find method in target methodName=" + str);
            }
            return method.invoke(obj, objArr);
        }
    }

    private static boolean a(Method method, String str, Class<?>[] clsArr) {
        if (str.equals(method.getName())) {
            String str2 = str;
            com.baidu.sofire.b.a();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if ((parameterTypes == null || parameterTypes.length == 0) && (clsArr == null || clsArr.length == 0)) {
                com.baidu.sofire.b.a();
                return true;
            } else if ((clsArr == null || clsArr.length == 0) && parameterTypes != null && parameterTypes.length > 0) {
                com.baidu.sofire.b.a();
                return false;
            } else if ((parameterTypes == null || parameterTypes.length == 0) && clsArr != null && clsArr.length > 0) {
                com.baidu.sofire.b.a();
                return false;
            } else if (parameterTypes.length != clsArr.length) {
                com.baidu.sofire.b.a();
                return false;
            } else {
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (parameterTypes[i] != clsArr[i]) {
                        com.baidu.sofire.b.a();
                        return false;
                    }
                }
                com.baidu.sofire.b.a();
                return true;
            }
        }
        return false;
    }

    public static void a(String str, boolean z) {
        boolean K = K("771", str);
        String str2 = str + ",s=" + K;
        com.baidu.sofire.b.a();
        if (z) {
            String absolutePath = new File(str).getParentFile().getAbsolutePath();
            K("771", absolutePath);
            r0 = absolutePath + ",s=" + K;
            com.baidu.sofire.b.a();
        }
    }

    private static boolean K(String str, String str2) {
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
            com.baidu.sofire.a.a ao = com.baidu.sofire.a.a.ao(context);
            Map<Integer, String> nn = ao.nn();
            jSONObject.put("0", nn.keySet());
            jSONObject.put("1", nn.values());
            jSONObject.toString();
            com.baidu.sofire.b.a();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("1003003", jSONObject);
            jSONObject2.put("0", jSONObject3);
            Map<Integer, String> no = ao.no();
            JSONArray jSONArray = new JSONArray();
            for (String str : no.values()) {
                jSONArray.put(str);
            }
            jSONArray.put("com.baidu.sofire");
            jSONObject2.put("2", jSONArray);
            report.w(jSONObject2.toString());
        } catch (Throwable th) {
            th.getMessage();
            com.baidu.sofire.b.b();
        }
    }

    public static void b(Context context) {
        String str = "v=2.0.8";
        com.baidu.sofire.b.a();
        if (!TextUtils.isEmpty("2.0.8")) {
            Report report = Report.getInstance(context);
            try {
                a(context);
                report.i("sofire", "com.baidu.sofire", "2.0.8", "1003003", "1003002");
            } catch (Throwable th) {
                th.getMessage();
                com.baidu.sofire.b.b();
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
                    str2 = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
                }
                jSONObject2.put(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE, str2);
                jSONObject2.put("4", 0);
                jSONObject2.put("5", 0);
                jSONObject2.put("6", 1);
                jSONObject2.put(NewWriteModel.THREAD_TYPE_LBS, 0);
                jSONObject2.put("8", "sofire");
                jSONObject2.put("9", "2.0.8");
                jSONObject2.put("10", str);
                jSONObject.put("Common_section", jSONObject2);
                if (map != null && map.size() > 0) {
                    jSONObject.put("Module_section", new JSONObject(map));
                } else {
                    jSONObject.put("Module_section", new JSONObject());
                }
                Report report = Report.getInstance(context);
                String jSONObject3 = jSONObject.toString();
                String str3 = jSONObject3;
                com.baidu.sofire.b.a();
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
                        com.baidu.sofire.b.b();
                    }
                }
            } catch (IOException e2) {
                e2.getMessage();
                com.baidu.sofire.b.b();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e3.getMessage();
                        com.baidu.sofire.b.b();
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

    public static boolean g(Context context, int i) {
        if (i == 1) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!(activeNetworkInfo != null && 1 == activeNetworkInfo.getType())) {
                IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                if (PN == null) {
                    PN = new MyReceiver().a();
                }
                context.getApplicationContext().registerReceiver(PN, intentFilter);
                a = true;
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v4 boolean)] */
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
                    PublicKey bR = c.bR(str2);
                    PublicKey publicKey = (bR != null || packageInfo.signatures == null || packageInfo.signatures.length <= 0 || packageInfo.signatures[0] == null) ? bR : CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray())).getPublicKey();
                    if (publicKey != null && (encoded = publicKey.getEncoded()) != null) {
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
                new StringBuilder().append(z).toString();
                com.baidu.sofire.b.a();
                eVar.Qe.putBoolean("hac", z);
                eVar.Qe.commit();
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

    public static void g(Context context) {
        com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
        long currentTimeMillis = System.currentTimeMillis();
        long j = eVar.a.getLong("se_ae_fd", 0L);
        if (j == 0) {
            j = System.currentTimeMillis();
            eVar.Qe.putLong("se_ae_fd", System.currentTimeMillis());
            eVar.Qe.commit();
        }
        if (currentTimeMillis - j > 86400000) {
            HashMap hashMap = new HashMap();
            hashMap.put("0", Integer.valueOf(eVar.a.getInt("mo_ae_fa_ct", 0) + 1));
            eVar.Qe.putInt("mo_ae_fa_ct", 0);
            eVar.Qe.commit();
            eVar.Qe.putLong("se_ae_fd", System.currentTimeMillis());
            eVar.Qe.commit();
            a(context, "1003119", hashMap);
            return;
        }
        eVar.Qe.putInt("mo_ae_fa_ct", eVar.a.getInt("mo_ae_fa_ct", 0) + 1);
        eVar.Qe.commit();
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

    public static int ap(Context context) {
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
