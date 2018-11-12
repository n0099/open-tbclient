package com.baidu.sofire.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
import com.baidu.searchbox.ng.ai.apps.util.AiAppEncryptUtils;
import com.baidu.webkit.internal.ETAG;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
/* loaded from: classes.dex */
public final class g {
    public static String a(Context context) {
        try {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            String v = eVar.v();
            if (TextUtils.isEmpty(v)) {
                String d = d(context);
                String e = e(context);
                if (TextUtils.isEmpty(e)) {
                    e = "0";
                }
                String str = d + "|" + new StringBuffer(e).reverse().toString();
                eVar.b(str);
                return str;
            }
            return v;
        } catch (Throwable th) {
            e.a(th);
            return "";
        }
    }

    public static String b(Context context) {
        try {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            String O = eVar.O();
            if (TextUtils.isEmpty(O)) {
                if (Build.VERSION.SDK_INT > 25) {
                    return "";
                }
                String e = e(context);
                String f = f(context);
                if (TextUtils.isEmpty(e) && TextUtils.isEmpty(f)) {
                    return "";
                }
                byte[] bytes = (e + ":" + f).getBytes();
                for (int i = 0; i < bytes.length; i++) {
                    bytes[i] = (byte) (bytes[i] ^ 246);
                }
                String b = o.b(bytes);
                if (TextUtils.isEmpty(b)) {
                    return "";
                }
                eVar.i(b);
                return b;
            }
            return O;
        } catch (Throwable th) {
            e.a(th);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0031 A[Catch: Throwable -> 0x0066, TryCatch #2 {Throwable -> 0x0066, blocks: (B:2:0x0000, B:8:0x001d, B:10:0x0031, B:19:0x006b, B:22:0x0078, B:15:0x0062), top: B:31:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005d A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006b A[Catch: Throwable -> 0x0066, TRY_ENTER, TryCatch #2 {Throwable -> 0x0066, blocks: (B:2:0x0000, B:8:0x001d, B:10:0x0031, B:19:0x006b, B:22:0x0078, B:15:0x0062), top: B:31:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(Context context) {
        String string;
        String str;
        String str2;
        try {
            String str3 = "";
            String f = f(context);
            try {
                String string2 = Settings.System.getString(context.getContentResolver(), "bd_setting_i");
                try {
                    if (TextUtils.isEmpty(string2)) {
                        string2 = e(context);
                    }
                    str3 = string2;
                } catch (Throwable th) {
                    str3 = str2;
                    th = th;
                    e.a(th);
                    string = Settings.System.getString(context.getContentResolver(), "com.baidu.deviceid");
                    if (TextUtils.isEmpty(string)) {
                    }
                    if (str != null) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
            string = Settings.System.getString(context.getContentResolver(), "com.baidu.deviceid");
            if (TextUtils.isEmpty(string)) {
                str = string;
            } else {
                str = Settings.System.getString(context.getContentResolver(), a(("com.baidu" + str3 + f).getBytes(), true));
            }
            if (str != null) {
                return "";
            }
            String e = e(context);
            if (TextUtils.isEmpty(e)) {
                e = "0";
            }
            return str + "|" + new StringBuffer(e).reverse().toString();
        } catch (Throwable th3) {
            return "";
        }
    }

    public static String d(Context context) {
        String str;
        Throwable th;
        String str2 = "";
        try {
            str = e(context);
            try {
                str2 = f(context);
            } catch (Throwable th2) {
                th = th2;
                e.a(th);
                return a((str + str2 + UUID.randomUUID().toString()).getBytes(), true);
            }
        } catch (Throwable th3) {
            str = "";
            th = th3;
        }
        return a((str + str2 + UUID.randomUUID().toString()).getBytes(), true);
    }

    public static String e(Context context) {
        TelephonyManager telephonyManager;
        if (q.a(context) && (telephonyManager = (TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)) != null) {
            String deviceId = telephonyManager.getDeviceId();
            if (TextUtils.isEmpty(deviceId)) {
                return "";
            }
            return deviceId;
        }
        return "";
    }

    public static String f(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        return string;
    }

    public static String a(byte[] bArr, boolean z) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(AiAppEncryptUtils.ENCRYPT_MD5);
            messageDigest.reset();
            messageDigest.update(bArr);
            return a(messageDigest.digest(), "", z);
        } catch (NoSuchAlgorithmException e) {
            e.a(e);
            return null;
        }
    }

    public static String a(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (z) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString).append(str);
        }
        return sb.toString();
    }

    public static String g(Context context) {
        try {
            try {
                String string = Settings.System.getString(context.getContentResolver(), "bd_setting_i");
                if (TextUtils.isEmpty(string)) {
                    string = e(context);
                }
                String e = e(context);
                if (TextUtils.isEmpty(e)) {
                    e = "0";
                }
                String stringBuffer = new StringBuffer(e).reverse().toString();
                String a = a(string);
                if (!TextUtils.isEmpty(a)) {
                    return a + "|" + stringBuffer;
                }
                return "";
            } catch (Throwable th) {
                e.a(th);
                return "";
            }
        } catch (Exception e2) {
            return "";
        }
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Environment.getExternalStorageDirectory(), "baidu/.cuid")));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append(SystemInfoUtil.LINE_END);
            }
            bufferedReader.close();
            Object[] split = new String(a.a("30212102dicudiab", "30212102dicudiab", Base64.decode(sb.toString().getBytes(), 0))).split(ETAG.EQUAL);
            if (split == null || split.length != 2 || !str.equals(split[0])) {
                return "";
            }
            return split[1];
        } catch (Exception e) {
            e.a(e);
            return "";
        }
    }

    public static String a() {
        return Build.DISPLAY;
    }

    public static String b() {
        return Build.VERSION.SDK_INT > 7 ? Build.HARDWARE : "";
    }

    public static String c() {
        return Build.MANUFACTURER;
    }

    public static String d() {
        return Build.MODEL;
    }

    public static String e() {
        return Build.VERSION.RELEASE;
    }

    public static String h(Context context) {
        String str;
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService(WindowConfig.JSON_WINDOW_KEY)).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            if (displayMetrics.widthPixels < displayMetrics.heightPixels) {
                str = displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
            } else {
                str = displayMetrics.heightPixels + "*" + displayMetrics.widthPixels;
            }
            return str;
        } catch (Exception e) {
            e.a(e);
            return "";
        }
    }

    public static String i(Context context) {
        String j = j(context);
        if (TextUtils.isEmpty(j)) {
            return "";
        }
        if (j.startsWith("46000") || j.startsWith("46002")) {
            return "1";
        }
        if (j.startsWith("46001")) {
            return "2";
        }
        if (j.startsWith("46003")) {
            return "3";
        }
        return "";
    }

    public static String j(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
            if (telephonyManager != null) {
                return telephonyManager.getSubscriberId();
            }
        } catch (Throwable th) {
            e.a(th);
        }
        return "";
    }

    public static String k(Context context) {
        String str;
        Throwable th;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
            if (telephonyManager == null) {
                return "";
            }
            str = telephonyManager.getSimSerialNumber();
            try {
                if (TextUtils.isEmpty(str)) {
                    return "";
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                e.a(th);
                return str;
            }
        } catch (Throwable th3) {
            str = "";
            th = th3;
        }
    }

    public static String l(Context context) {
        String str;
        Throwable th;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
            if (telephonyManager == null) {
                return "";
            }
            str = telephonyManager.getSimOperatorName();
            try {
                if (TextUtils.isEmpty(str)) {
                    return "";
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                e.a(th);
                return str;
            }
        } catch (Throwable th3) {
            str = "";
            th = th3;
        }
    }

    public static String m(Context context) {
        String str;
        Throwable th;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
            if (telephonyManager == null) {
                return "";
            }
            str = telephonyManager.getNetworkOperator();
            try {
                if (TextUtils.isEmpty(str)) {
                    return "";
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                e.a(th);
                return str;
            }
        } catch (Throwable th3) {
            str = "";
            th = th3;
        }
    }

    public static String n(Context context) {
        String str;
        Throwable th;
        try {
            str = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getBSSID();
        } catch (Throwable th2) {
            str = "";
            th = th2;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
            e.a(th);
            return str;
        }
    }

    public static String f() {
        String g = g();
        if (TextUtils.isEmpty(g)) {
            try {
                return h().toUpperCase().substring(0, 17);
            } catch (Throwable th) {
                e.a(th);
                return g;
            }
        }
        return g;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [461=4] */
    public static java.lang.String g() {
        /*
            r3 = 0
            java.lang.String r1 = ""
            java.lang.String r0 = ""
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L41
            java.lang.String r4 = "cat /sys/class/net/wlan0/address"
            java.lang.Process r2 = r2.exec(r4)     // Catch: java.lang.Throwable -> L41
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L41
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Throwable -> L41
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L41
            java.io.LineNumberReader r2 = new java.io.LineNumberReader     // Catch: java.lang.Throwable -> L7b
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L7b
        L20:
            if (r1 == 0) goto L2c
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L7f
            if (r1 == 0) goto L20
            java.lang.String r0 = r1.trim()     // Catch: java.lang.Throwable -> L7f
        L2c:
            if (r4 == 0) goto L31
            r4.close()     // Catch: java.lang.Throwable -> L37
        L31:
            if (r2 == 0) goto L36
            r2.close()     // Catch: java.io.IOException -> L3c
        L36:
            return r0
        L37:
            r1 = move-exception
            com.baidu.sofire.b.e.a(r1)
            goto L31
        L3c:
            r1 = move-exception
            com.baidu.sofire.b.e.a(r1)
            goto L36
        L41:
            r1 = move-exception
            r2 = r3
        L43:
            com.baidu.sofire.b.e.a(r1)     // Catch: java.lang.Throwable -> L77
            if (r3 == 0) goto L4b
            r3.close()     // Catch: java.lang.Throwable -> L56
        L4b:
            if (r2 == 0) goto L36
            r2.close()     // Catch: java.io.IOException -> L51
            goto L36
        L51:
            r1 = move-exception
            com.baidu.sofire.b.e.a(r1)
            goto L36
        L56:
            r1 = move-exception
            com.baidu.sofire.b.e.a(r1)
            goto L4b
        L5b:
            r0 = move-exception
            r4 = r3
        L5d:
            if (r4 == 0) goto L62
            r4.close()     // Catch: java.lang.Throwable -> L68
        L62:
            if (r3 == 0) goto L67
            r3.close()     // Catch: java.io.IOException -> L6d
        L67:
            throw r0
        L68:
            r1 = move-exception
            com.baidu.sofire.b.e.a(r1)
            goto L62
        L6d:
            r1 = move-exception
            com.baidu.sofire.b.e.a(r1)
            goto L67
        L72:
            r0 = move-exception
            goto L5d
        L74:
            r0 = move-exception
            r3 = r2
            goto L5d
        L77:
            r0 = move-exception
            r4 = r3
            r3 = r2
            goto L5d
        L7b:
            r1 = move-exception
            r2 = r3
            r3 = r4
            goto L43
        L7f:
            r1 = move-exception
            r3 = r4
            goto L43
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.g.g():java.lang.String");
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [491=4] */
    public static String h() {
        FileReader fileReader;
        String str = "";
        try {
            fileReader = new FileReader("/sys/class/net/eth0/address");
            if (fileReader != null) {
                try {
                    str = a(fileReader);
                } catch (Throwable th) {
                    th = th;
                    try {
                        e.a(th);
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Throwable th2) {
                                e.a(th2);
                            }
                        }
                        return str;
                    } finally {
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Throwable th3) {
                                e.a(th3);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
        }
        return str;
    }

    private static String a(Reader reader) {
        try {
            StringBuilder sb = new StringBuilder();
            char[] cArr = new char[4096];
            int read = reader.read(cArr);
            while (read >= 0) {
                sb.append(cArr, 0, read);
                read = reader.read(cArr);
            }
            return sb.toString();
        } catch (Throwable th) {
            e.a(th);
            return null;
        }
    }
}
