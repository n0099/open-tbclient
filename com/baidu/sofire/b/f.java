package com.baidu.sofire.b;

import android.content.Context;
import android.net.wifi.WifiManager;
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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
/* loaded from: classes.dex */
public final class f {
    public static String a(Context context) {
        try {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            String string = eVar.b.getString("xyus", "");
            if (TextUtils.isEmpty(string)) {
                String l = l(context);
                String m = m(context);
                if (TextUtils.isEmpty(m)) {
                    m = "0";
                }
                String str = l + "|" + new StringBuffer(m).reverse().toString();
                eVar.d.putString("xyus", str);
                eVar.d.commit();
                return str;
            }
            return string;
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public static String b(Context context) {
        try {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            String string = eVar.a.getString("sgud", "");
            if (TextUtils.isEmpty(string)) {
                String m = m(context);
                String string2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
                if (TextUtils.isEmpty(string2)) {
                    string2 = "";
                }
                if (TextUtils.isEmpty(m) && TextUtils.isEmpty(string2)) {
                    return "";
                }
                byte[] bytes = (m + SystemInfoUtil.COLON + string2).getBytes();
                for (int i = 0; i < bytes.length; i++) {
                    bytes[i] = (byte) (bytes[i] ^ 246);
                }
                String a = l.a(bytes);
                if (TextUtils.isEmpty(a)) {
                    return "";
                }
                eVar.c.putString("sgud", a);
                eVar.c.commit();
                return a;
            }
            return string;
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public static String c(Context context) {
        try {
            return "1|" + b(context);
        } catch (Throwable th) {
            d.a(th);
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
    public static String d(Context context) {
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
                    string2 = m(context);
                }
                str2 = string2;
            } catch (Throwable th2) {
                str2 = str;
                th = th2;
                d.a(th);
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
            String m = m(context);
            if (TextUtils.isEmpty(m)) {
                m = "0";
            }
            return string + "|" + new StringBuffer(m).reverse().toString();
        } catch (Throwable th3) {
            return "";
        }
    }

    private static String l(Context context) {
        String str;
        String str2;
        String str3 = "";
        try {
            str3 = m(context);
            str2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            str = str3;
        } catch (Throwable th) {
            d.a(th);
            str = str3;
            str2 = "";
        }
        return a((str + str2 + UUID.randomUUID().toString()).getBytes());
    }

    private static String m(Context context) {
        TelephonyManager telephonyManager;
        if (n.a(context) && (telephonyManager = (TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)) != null) {
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
            d.a(e);
            return null;
        }
    }

    public static String e(Context context) {
        try {
            try {
                String string = Settings.System.getString(context.getContentResolver(), "bd_setting_i");
                if (TextUtils.isEmpty(string)) {
                    string = m(context);
                }
                String m = m(context);
                if (TextUtils.isEmpty(m)) {
                    m = "0";
                }
                String stringBuffer = new StringBuffer(m).reverse().toString();
                String a = a(string);
                if (!TextUtils.isEmpty(a)) {
                    return a + "|" + stringBuffer;
                }
                return "";
            } catch (Throwable th) {
                d.a(th);
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
            d.a(e);
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
            d.a(e);
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
            d.a(th);
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
                d.a(th);
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
                d.a(th);
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
                d.a(th);
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
            d.a(th);
            return str;
        }
    }
}
