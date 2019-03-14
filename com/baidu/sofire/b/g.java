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
import com.baidu.mobstat.Config;
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
            String o = eVar.o();
            if (TextUtils.isEmpty(o)) {
                String m = m(context);
                String d = d(context);
                if (TextUtils.isEmpty(d)) {
                    d = "0";
                }
                String str = m + "|" + new StringBuffer(d).reverse().toString();
                eVar.a(str);
                return str;
            }
            return o;
        } catch (Throwable th) {
            e.a();
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
                String e = e(context);
                if (TextUtils.isEmpty(d) && TextUtils.isEmpty(e)) {
                    return "";
                }
                byte[] bytes = (d + Config.TRACE_TODAY_VISIT_SPLIT + e).getBytes();
                for (int i = 0; i < bytes.length; i++) {
                    bytes[i] = (byte) (bytes[i] ^ 246);
                }
                String a = o.a(bytes);
                if (TextUtils.isEmpty(a)) {
                    return "";
                }
                eVar.d.putString("sgud", a);
                eVar.d.commit();
                return a;
            }
            return string;
        } catch (Throwable th) {
            e.a();
            return "";
        }
    }

    public static String c(Context context) {
        String str;
        try {
            String e = e(context);
            String string = Settings.System.getString(context.getContentResolver(), "bd_setting_i");
            if (TextUtils.isEmpty(string)) {
                string = d(context);
            }
            String str2 = string;
            String string2 = Settings.System.getString(context.getContentResolver(), "com.baidu.deviceid");
            if (TextUtils.isEmpty(string2)) {
                str = Settings.System.getString(context.getContentResolver(), a(("com.baidu" + str2 + e).getBytes()));
            } else {
                str = string2;
            }
            if (str == null) {
                return "";
            }
            String d = d(context);
            if (TextUtils.isEmpty(d)) {
                d = "0";
            }
            return str + "|" + new StringBuffer(d).reverse().toString();
        } catch (Throwable th) {
            return "";
        }
    }

    private static String m(Context context) {
        String str = "";
        String str2 = "";
        try {
            str = d(context);
            str2 = e(context);
        } catch (Throwable th) {
            e.a();
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

    public static String e(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        return string;
    }

    public static String a(byte[] bArr) {
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
            e.a();
            return null;
        }
    }

    public static String f(Context context) {
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
                e.a();
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
                sb.append("\r\n");
            }
            bufferedReader.close();
            Object[] split = new String(a.a("30212102dicudiab", "30212102dicudiab", Base64.decode(sb.toString().getBytes(), 0))).split("=");
            if (split == null || split.length != 2 || !str.equals(split[0])) {
                return "";
            }
            return split[1];
        } catch (Exception e) {
            e.a();
            return "";
        }
    }

    public static String g(Context context) {
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
            e.a();
            return "";
        }
    }

    public static String h(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
            if (telephonyManager != null) {
                return telephonyManager.getSubscriberId();
            }
        } catch (Throwable th) {
            e.a();
        }
        return "";
    }

    public static String i(Context context) {
        String str;
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
            } catch (Throwable th) {
                e.a();
                return str;
            }
        } catch (Throwable th2) {
            str = "";
        }
    }

    public static String j(Context context) {
        String str;
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
            } catch (Throwable th) {
                e.a();
                return str;
            }
        } catch (Throwable th2) {
            str = "";
        }
    }

    public static String k(Context context) {
        String str;
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
            } catch (Throwable th) {
                e.a();
                return str;
            }
        } catch (Throwable th2) {
            str = "";
        }
    }

    public static String l(Context context) {
        String str;
        try {
            str = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getBSSID();
        } catch (Throwable th) {
            str = "";
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return str;
        } catch (Throwable th2) {
            e.a();
            return str;
        }
    }

    public static String a() {
        String b = b();
        if (TextUtils.isEmpty(b)) {
            try {
                return c().toUpperCase().substring(0, 17);
            } catch (Throwable th) {
                e.a();
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
            r2 = 0
            java.lang.String r4 = ""
            java.lang.String r0 = ""
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L3e
            java.lang.String r3 = "cat /sys/class/net/wlan0/address"
            java.lang.Process r1 = r1.exec(r3)     // Catch: java.lang.Throwable -> L3e
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3e
            java.io.InputStream r1 = r1.getInputStream()     // Catch: java.lang.Throwable -> L3e
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L3e
            java.io.LineNumberReader r1 = new java.io.LineNumberReader     // Catch: java.lang.Throwable -> L78
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L78
            r2 = r4
        L21:
            if (r2 == 0) goto L2d
            java.lang.String r2 = r1.readLine()     // Catch: java.lang.Throwable -> L7c
            if (r2 == 0) goto L21
            java.lang.String r0 = r2.trim()     // Catch: java.lang.Throwable -> L7c
        L2d:
            r3.close()     // Catch: java.lang.Throwable -> L34
        L30:
            r1.close()     // Catch: java.io.IOException -> L39
        L33:
            return r0
        L34:
            r2 = move-exception
            com.baidu.sofire.b.e.a()
            goto L30
        L39:
            r1 = move-exception
            com.baidu.sofire.b.e.a()
            goto L33
        L3e:
            r1 = move-exception
            r1 = r2
        L40:
            com.baidu.sofire.b.e.a()     // Catch: java.lang.Throwable -> L74
            if (r2 == 0) goto L48
            r2.close()     // Catch: java.lang.Throwable -> L53
        L48:
            if (r1 == 0) goto L33
            r1.close()     // Catch: java.io.IOException -> L4e
            goto L33
        L4e:
            r1 = move-exception
            com.baidu.sofire.b.e.a()
            goto L33
        L53:
            r2 = move-exception
            com.baidu.sofire.b.e.a()
            goto L48
        L58:
            r0 = move-exception
            r3 = r2
        L5a:
            if (r3 == 0) goto L5f
            r3.close()     // Catch: java.lang.Throwable -> L65
        L5f:
            if (r2 == 0) goto L64
            r2.close()     // Catch: java.io.IOException -> L6a
        L64:
            throw r0
        L65:
            r1 = move-exception
            com.baidu.sofire.b.e.a()
            goto L5f
        L6a:
            r1 = move-exception
            com.baidu.sofire.b.e.a()
            goto L64
        L6f:
            r0 = move-exception
            goto L5a
        L71:
            r0 = move-exception
            r2 = r1
            goto L5a
        L74:
            r0 = move-exception
            r3 = r2
            r2 = r1
            goto L5a
        L78:
            r1 = move-exception
            r1 = r2
            r2 = r3
            goto L40
        L7c:
            r2 = move-exception
            r2 = r3
            goto L40
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.g.b():java.lang.String");
    }

    private static String c() {
        FileReader fileReader;
        String str = "";
        try {
            fileReader = new FileReader("/sys/class/net/eth0/address");
        } catch (Throwable th) {
            fileReader = null;
        }
        try {
            str = a(fileReader);
            try {
                fileReader.close();
            } catch (Throwable th2) {
                e.a();
            }
        } catch (Throwable th3) {
            try {
                e.a();
                return str;
            } finally {
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable th4) {
                        e.a();
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
            e.a();
            return null;
        }
    }
}
