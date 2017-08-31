package com.baidu.sofire.rp.f;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public final class d {
    public static String a(Context context) {
        com.baidu.sofire.rp.a.a aVar = new com.baidu.sofire.rp.a.a(context);
        String string = aVar.PR.getString("xyus", "");
        if (TextUtils.isEmpty(string)) {
            String h = h(context);
            String i = i(context);
            if (TextUtils.isEmpty(i)) {
                i = "0";
            }
            String str = h + "|" + new StringBuffer(i).reverse().toString();
            aVar.PU.putString("xyus", str);
            aVar.PU.commit();
            return str;
        }
        return string;
    }

    public static String b(Context context) {
        try {
            try {
                String string = Settings.System.getString(context.getContentResolver(), "bd_setting_i");
                if (TextUtils.isEmpty(string)) {
                    string = i(context);
                }
                String i = i(context);
                if (TextUtils.isEmpty(i)) {
                    i = "0";
                }
                String stringBuffer = new StringBuffer(i).reverse().toString();
                String a = a(string);
                if (!TextUtils.isEmpty(a)) {
                    return a + "|" + stringBuffer;
                }
                return "";
            } catch (Throwable th) {
                b.a();
                return "";
            }
        } catch (Exception e) {
            return "";
        }
    }

    public static String c(Context context) {
        String str;
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            String str2 = TextUtils.isEmpty(string) ? "" : string;
            try {
                String string2 = Settings.System.getString(context.getContentResolver(), "bd_setting_i");
                if (TextUtils.isEmpty(string2)) {
                    string2 = i(context);
                }
                str = string2;
            } catch (Exception e) {
                str = "";
                b.a();
            }
            String string3 = Settings.System.getString(context.getContentResolver(), "com.baidu.deviceid");
            String string4 = TextUtils.isEmpty(string3) ? Settings.System.getString(context.getContentResolver(), a(("com.baidu" + str + str2).getBytes())) : string3;
            if (TextUtils.isEmpty(string4)) {
                return "";
            }
            String i = i(context);
            if (TextUtils.isEmpty(i)) {
                i = "0";
            }
            return string4 + "|" + new StringBuffer(i).reverse().toString();
        } catch (Throwable th) {
            b.a();
            return "";
        }
    }

    private static String h(Context context) {
        String str;
        String str2;
        String str3 = "";
        try {
            str3 = i(context);
            str2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            str = str3;
        } catch (Throwable th) {
            str = str3;
            str2 = "";
            b.a();
        }
        String a = a((str + str2 + UUID.randomUUID().toString()).getBytes());
        if (TextUtils.isEmpty(a)) {
            return "";
        }
        return a;
    }

    private static String i(Context context) {
        String str;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return "";
            }
            str = telephonyManager.getDeviceId();
            try {
                if (TextUtils.isEmpty(str)) {
                    return "";
                }
                return str;
            } catch (Throwable th) {
                b.a();
                return str;
            }
        } catch (Throwable th2) {
            str = "";
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
            byte[] decode = Base64.decode(sb.toString().getBytes(), 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec("30212102dicudiab".getBytes(), com.baidu.sapi2.utils.f.x);
            Cipher cipher = Cipher.getInstance(com.baidu.sapi2.utils.f.w);
            cipher.init(2, secretKeySpec, new IvParameterSpec("30212102dicudiab".getBytes()));
            Object[] split = new String(cipher.doFinal(decode)).split("=");
            if (split == null || split.length != 2 || !str.equals(split[0])) {
                return "";
            }
            return split[1];
        } catch (Exception e) {
            b.a();
            return "";
        }
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
            e.printStackTrace();
            return null;
        }
    }

    public static String d(Context context) {
        String str;
        if (!j.b(context, new String[]{"android.permission.READ_PHONE_STATE"})) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
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
                b.a();
                return str;
            }
        } catch (Throwable th2) {
            str = "";
        }
    }

    public static String e(Context context) {
        String str;
        if (!j.b(context, new String[]{"android.permission.READ_PHONE_STATE"})) {
            return "";
        }
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
                b.a();
                return str;
            }
        } catch (Throwable th2) {
            str = "";
        }
    }

    public static String f(Context context) {
        String str;
        if (!j.b(context, new String[]{"android.permission.READ_PHONE_STATE"})) {
            return "";
        }
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
                b.a();
                return str;
            }
        } catch (Throwable th2) {
            str = "";
        }
    }

    public static String g(Context context) {
        String str;
        if (!j.b(context, new String[]{"android.permission.ACCESS_WIFI_STATE"})) {
            return "";
        }
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
            b.a();
            return str;
        }
    }
}
