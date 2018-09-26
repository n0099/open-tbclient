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
            String string = eVar.b.getString("xyus", "");
            if (TextUtils.isEmpty(string)) {
                String l = l(context);
                String d = d(context);
                if (TextUtils.isEmpty(d)) {
                    d = "0";
                }
                String str = l + "|" + new StringBuffer(d).reverse().toString();
                eVar.d.putString("xyus", str);
                eVar.d.commit();
                return str;
            }
            return string;
        } catch (Throwable th) {
            e.a(th);
            return "";
        }
    }

    public static String b(Context context) {
        try {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            String string = eVar.b.getString("sgud", "");
            if (TextUtils.isEmpty(string)) {
                if (Build.VERSION.SDK_INT > 25) {
                    return "";
                }
                String d = d(context);
                String string2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
                if (TextUtils.isEmpty(string2)) {
                    string2 = "";
                }
                if (TextUtils.isEmpty(d) && TextUtils.isEmpty(string2)) {
                    return "";
                }
                byte[] bytes = (d + ":" + string2).getBytes();
                for (int i = 0; i < bytes.length; i++) {
                    bytes[i] = (byte) (bytes[i] ^ 246);
                }
                String a = n.a(bytes);
                if (TextUtils.isEmpty(a)) {
                    return "";
                }
                eVar.d.putString("sgud", a);
                eVar.d.commit();
                return a;
            }
            return string;
        } catch (Throwable th) {
            e.a(th);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003f A[Catch: Throwable -> 0x006f, TryCatch #1 {Throwable -> 0x006f, blocks: (B:2:0x0000, B:11:0x002e, B:13:0x003f, B:22:0x0074, B:25:0x0081, B:18:0x006b), top: B:33:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0066 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0074 A[Catch: Throwable -> 0x006f, TRY_ENTER, TryCatch #1 {Throwable -> 0x006f, blocks: (B:2:0x0000, B:11:0x002e, B:13:0x003f, B:22:0x0074, B:25:0x0081, B:18:0x006b), top: B:33:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(Context context) {
        String string;
        String string2;
        String str;
        try {
            String str2 = "";
            String string3 = Settings.Secure.getString(context.getContentResolver(), "android_id");
            String str3 = TextUtils.isEmpty(string3) ? "" : string3;
            try {
                string2 = Settings.System.getString(context.getContentResolver(), "bd_setting_i");
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (TextUtils.isEmpty(string2)) {
                    string2 = d(context);
                }
                str2 = string2;
            } catch (Throwable th2) {
                str2 = str;
                th = th2;
                e.a(th);
                String string4 = Settings.System.getString(context.getContentResolver(), "com.baidu.deviceid");
                if (!TextUtils.isEmpty(string4)) {
                }
                if (string != null) {
                }
            }
            String string42 = Settings.System.getString(context.getContentResolver(), "com.baidu.deviceid");
            string = !TextUtils.isEmpty(string42) ? Settings.System.getString(context.getContentResolver(), a(("com.baidu" + str2 + str3).getBytes())) : string42;
            if (string != null) {
                return "";
            }
            String d = d(context);
            if (TextUtils.isEmpty(d)) {
                d = "0";
            }
            return string + "|" + new StringBuffer(d).reverse().toString();
        } catch (Throwable th3) {
            return "";
        }
    }

    private static String l(Context context) {
        String str;
        String str2;
        String str3 = "";
        try {
            str3 = d(context);
            str2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            str = str3;
        } catch (Throwable th) {
            e.a(th);
            str = str3;
            str2 = "";
        }
        return a((str + str2 + UUID.randomUUID().toString()).getBytes());
    }

    public static String d(Context context) {
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

    private static String a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                String upperCase = Integer.toHexString(b & 255).toUpperCase();
                if (upperCase.length() == 1) {
                    sb.append("0");
                }
                sb.append(upperCase).append("");
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.a(e);
            return null;
        }
    }

    public static String e(Context context) {
        try {
            try {
                String string = Settings.System.getString(context.getContentResolver(), "bd_setting_i");
                if (TextUtils.isEmpty(string)) {
                    string = d(context);
                }
                String d = d(context);
                if (TextUtils.isEmpty(d)) {
                    d = "0";
                }
                String stringBuffer = new StringBuffer(d).reverse().toString();
                String a = a(string);
                if (!TextUtils.isEmpty(a)) {
                    return a + "|" + stringBuffer;
                }
                return "";
            } catch (Throwable th) {
                e.a(th);
                return "";
            }
        } catch (Exception e) {
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
            Object[] split = new String(a.a("30212102dicudiab", "30212102dicudiab", Base64.decode(sb.toString().getBytes(), 0))).split("=");
            if (split == null || split.length != 2 || !str.equals(split[0])) {
                return "";
            }
            return split[1];
        } catch (Exception e) {
            e.a(e);
            return "";
        }
    }

    public static String f(Context context) {
        String str;
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
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

    public static String g(Context context) {
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

    public static String h(Context context) {
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

    public static String i(Context context) {
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

    public static String j(Context context) {
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

    public static String k(Context context) {
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

    public static String a() {
        String b = b();
        if (TextUtils.isEmpty(b)) {
            try {
                return c().toUpperCase().substring(0, 17);
            } catch (Throwable th) {
                e.a(th);
                return b;
            }
        }
        return b;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private static java.lang.String b() {
        /*
            r3 = 0
            java.lang.String r1 = ""
            java.lang.String r0 = ""
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L3d
            java.lang.String r4 = "cat /sys/class/net/wlan0/address"
            java.lang.Process r2 = r2.exec(r4)     // Catch: java.lang.Throwable -> L3d
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3d
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Throwable -> L3d
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L3d
            java.io.LineNumberReader r2 = new java.io.LineNumberReader     // Catch: java.lang.Throwable -> L77
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L77
        L20:
            if (r1 == 0) goto L2c
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L7b
            if (r1 == 0) goto L20
            java.lang.String r0 = r1.trim()     // Catch: java.lang.Throwable -> L7b
        L2c:
            r4.close()     // Catch: java.lang.Throwable -> L33
        L2f:
            r2.close()     // Catch: java.io.IOException -> L38
        L32:
            return r0
        L33:
            r1 = move-exception
            com.baidu.sofire.b.e.a(r1)
            goto L2f
        L38:
            r1 = move-exception
            com.baidu.sofire.b.e.a(r1)
            goto L32
        L3d:
            r1 = move-exception
            r2 = r3
        L3f:
            com.baidu.sofire.b.e.a(r1)     // Catch: java.lang.Throwable -> L73
            if (r3 == 0) goto L47
            r3.close()     // Catch: java.lang.Throwable -> L52
        L47:
            if (r2 == 0) goto L32
            r2.close()     // Catch: java.io.IOException -> L4d
            goto L32
        L4d:
            r1 = move-exception
            com.baidu.sofire.b.e.a(r1)
            goto L32
        L52:
            r1 = move-exception
            com.baidu.sofire.b.e.a(r1)
            goto L47
        L57:
            r0 = move-exception
            r4 = r3
        L59:
            if (r4 == 0) goto L5e
            r4.close()     // Catch: java.lang.Throwable -> L64
        L5e:
            if (r3 == 0) goto L63
            r3.close()     // Catch: java.io.IOException -> L69
        L63:
            throw r0
        L64:
            r1 = move-exception
            com.baidu.sofire.b.e.a(r1)
            goto L5e
        L69:
            r1 = move-exception
            com.baidu.sofire.b.e.a(r1)
            goto L63
        L6e:
            r0 = move-exception
            goto L59
        L70:
            r0 = move-exception
            r3 = r2
            goto L59
        L73:
            r0 = move-exception
            r4 = r3
            r3 = r2
            goto L59
        L77:
            r1 = move-exception
            r2 = r3
            r3 = r4
            goto L3f
        L7b:
            r1 = move-exception
            r3 = r4
            goto L3f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.g.b():java.lang.String");
    }

    private static String c() {
        FileReader fileReader;
        String str = "";
        try {
            fileReader = new FileReader("/sys/class/net/eth0/address");
        } catch (Throwable th) {
            th = th;
            fileReader = null;
        }
        try {
            str = a(fileReader);
            try {
                fileReader.close();
            } catch (Throwable th2) {
                e.a(th2);
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                e.a(th);
                return str;
            } finally {
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable th4) {
                        e.a(th4);
                    }
                }
            }
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
