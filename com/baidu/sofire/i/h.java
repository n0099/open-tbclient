package com.baidu.sofire.i;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.webkit.internal.ETAG;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
/* loaded from: classes20.dex */
public final class h {
    private static final String[] a = {"On7h9W1_KIkIa50wk9Fnl1friw1cdOsubmr_O-Hrgss=", "73Ry_SRX9WDHPoeAkGWfJbuntGR7RQ3rde1s6KyyCoo=", "iQirV45vitYDQfzxgr68ylBY1DWLBKje2Pl428sE27Q=", "czwe2zUrt14MfnaeH474T5prOCIik3agOnBud_KwFa0=", "JzLix2JtXzSSsVkQFD0Cnf37028Rco5rGb7_-t_C8Qk=", "lUApGLCwwTIqYrpC4ZaqkVItjc8DeoJ5fB_pxizrjnc=", "6PzPHS4JINi0q8yUj180JTMbpq1Q44DuQggknxVmVPA=", "fCbyLrInjq1BOByP4wH4mUGBidquiIKIy6zcJCBuKtk=", "qEeaB7chq_oSIUyWhq_EwETFQIu3w3myIFyGD80p_u8=", "UNzyljxPfmKANfePasqvdfmpLS4aJ1v0S1Aj2BGl75o="};
    private static String b = "";

    public static void a(Context context) {
        try {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            String m = eVar.m();
            if (!TextUtils.isEmpty(m)) {
                String f = e.f(m);
                if (!TextUtils.isEmpty(f) && !f.equals(eVar.l())) {
                    eVar.a(f);
                }
            }
        } catch (Throwable th) {
            e.a();
        }
    }

    public static synchronized String b(Context context) {
        String str;
        synchronized (h.class) {
            try {
                if (!TextUtils.isEmpty(b)) {
                    str = b;
                } else {
                    com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
                    String m = eVar.m();
                    if (!TextUtils.isEmpty(m)) {
                        str = e.f(m);
                        if (!TextUtils.isEmpty(str)) {
                            b = str;
                        }
                    }
                    str = eVar.l();
                    if (!TextUtils.isEmpty(str)) {
                        eVar.b(new String(Base64.encode(a.a("30212102dicudiab".getBytes(), str.getBytes("UTF-8")), 10), "UTF-8"));
                        b = str;
                    } else {
                        String k = k(context);
                        String e = e(context);
                        if (TextUtils.isEmpty(e)) {
                            e = "0";
                        }
                        str = k + "|" + new StringBuffer(e).reverse().toString();
                        String str2 = new String(Base64.encode(a.a("30212102dicudiab".getBytes(), str.getBytes("UTF-8")), 10), "UTF-8");
                        String l = eVar.l();
                        if (TextUtils.isEmpty(l)) {
                            eVar.a(str);
                            eVar.b(str2);
                            b = str;
                        } else {
                            b = l;
                            str = l;
                        }
                    }
                }
            } catch (Throwable th) {
                e.a();
                str = "";
            }
        }
        return str;
    }

    public static String c(Context context) {
        try {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            String string = eVar.b.getString("sgud", "");
            if (TextUtils.isEmpty(string)) {
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
                String a2 = p.a(bytes);
                if (TextUtils.isEmpty(a2)) {
                    return "";
                }
                eVar.d.putString("sgud", a2);
                eVar.d.commit();
                return a2;
            }
            return string;
        } catch (Throwable th) {
            e.a();
            return "";
        }
    }

    public static String d(Context context) {
        String str;
        try {
            String f = f(context);
            String string = Settings.System.getString(context.getContentResolver(), e.f("ARQJ8IArCy4jLSUJ6i4PbDdNue2ww1CwfUTDQn8F4ug="));
            if (TextUtils.isEmpty(string)) {
                string = e(context);
            }
            String str2 = string;
            String string2 = Settings.System.getString(context.getContentResolver(), e.f("FLI7RPHK558lhmIMdK5V18TV2libLOeHJlQPRa8lKBaxRs4pujQo1mXKtiCUFVkg"));
            if (TextUtils.isEmpty(string2)) {
                str = Settings.System.getString(context.getContentResolver(), a((e.f("q6R8gqLUgHDSsH6dbL27xN7Qr9sa0MxMqXTV66AWUUE=") + str2 + f).getBytes(), true));
            } else {
                str = string2;
            }
            if (str == null) {
                return "";
            }
            String e = e(context);
            if (TextUtils.isEmpty(e)) {
                e = "0";
            }
            return str + "|" + new StringBuffer(e).reverse().toString();
        } catch (Throwable th) {
            return "";
        }
    }

    private static String k(Context context) {
        String str = "";
        String str2 = "";
        try {
            str = e(context);
            str2 = f(context);
        } catch (Throwable th) {
            e.a();
        }
        return a((str + str2 + UUID.randomUUID().toString()).getBytes(), true);
    }

    public static String e(Context context) {
        try {
            if ("com.baidu.input_huawei".equals(context.getPackageName())) {
                return "";
            }
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            if (eVar.a.getInt("appinv_sai", 0) == 0 || !eVar.b.getBoolean("s_a_pl", false)) {
                return "";
            }
            return com.baidu.sofire.a.a.a(context);
        } catch (Throwable th) {
            e.a();
            return "";
        }
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
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                String hexString = Integer.toHexString(b2 & 255);
                if (z) {
                    hexString = hexString.toUpperCase();
                }
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString).append("");
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.a();
            return null;
        }
    }

    public static String g(Context context) {
        try {
            try {
                String string = Settings.System.getString(context.getContentResolver(), e.f("ARQJ8IArCy4jLSUJ6i4PbDdNue2ww1CwfUTDQn8F4ug="));
                if (TextUtils.isEmpty(string)) {
                    string = e(context);
                }
                String e = e(context);
                if (TextUtils.isEmpty(e)) {
                    e = "0";
                }
                String stringBuffer = new StringBuffer(e).reverse().toString();
                String a2 = a(string);
                if (!TextUtils.isEmpty(a2)) {
                    return a2 + "|" + stringBuffer;
                }
                return "";
            } catch (Throwable th) {
                e.a();
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
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Environment.getExternalStorageDirectory(), e.f("u_lhldj5Nkwulw6YvIU2wr_ieZRcYQnQZ7zSlbUYnYY=") + "/" + e.f("u2fjUEpcZJL7IE6RlBqIRmFJW_FjZrNApjdMKDgt7FM="))));
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
            Object[] split = new String(a.a("30212102dicudiab", "30212102dicudiab", Base64.decode(sb.toString().getBytes(), 0))).split(ETAG.EQUAL);
            if (split == null || split.length != 2 || !str.equals(split[0])) {
                return "";
            }
            return split[1];
        } catch (Exception e) {
            e.a();
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

    public static String i(Context context) {
        String str;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
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

    public static String j(Context context) {
        String str;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
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
}
