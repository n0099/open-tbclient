package com.baidu.sapi2.utils;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public final class e {
    private static final String a = "bd_setting_i";
    private static final String b = "com.baidu.deviceid";
    private static final String c = "30212102dicudiab";
    private static final String d = "baidu/.cuid";
    private static final String e = "AES/CBC/PKCS5Padding";
    private static final String f = "AES";

    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        Throwable th;
        String str;
        a(context, "android.permission.WRITE_SETTINGS");
        a(context, "android.permission.READ_PHONE_STATE");
        a(context, "android.permission.WRITE_EXTERNAL_STORAGE");
        boolean z = false;
        String str2 = "";
        try {
            str2 = Settings.System.getString(context.getContentResolver(), a);
            str = str2 == null ? b(context) : str2;
        } catch (Throwable th2) {
            th = th2;
            str = str2;
        }
        try {
            Settings.System.putString(context.getContentResolver(), a, str);
        } catch (Throwable th3) {
            th = th3;
            L.e(th);
            z = true;
            String c2 = c(context);
            if (!z) {
            }
        }
        String c22 = c(context);
        if (!z) {
            return com.baidu.sapi2.utils.b.b.a(("com.baidu" + c22).getBytes(), true);
        }
        String str3 = null;
        String string = Settings.System.getString(context.getContentResolver(), b);
        if (TextUtils.isEmpty(string)) {
            str3 = com.baidu.sapi2.utils.b.b.a(("com.baidu" + str + c22).getBytes(), true);
            string = Settings.System.getString(context.getContentResolver(), str3);
            if (!TextUtils.isEmpty(string)) {
                Settings.System.putString(context.getContentResolver(), b, string);
                a(str, string);
            }
        }
        if (TextUtils.isEmpty(string)) {
            string = a(str);
            if (!TextUtils.isEmpty(string)) {
                Settings.System.putString(context.getContentResolver(), str3, string);
                Settings.System.putString(context.getContentResolver(), b, string);
            }
        }
        if (TextUtils.isEmpty(string)) {
            String a2 = com.baidu.sapi2.utils.b.b.a((str + c22 + UUID.randomUUID().toString()).getBytes(), true);
            Settings.System.putString(context.getContentResolver(), str3, a2);
            Settings.System.putString(context.getContentResolver(), b, a2);
            a(str, a2);
            return a2;
        }
        return string;
    }

    private static String b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        String deviceId = telephonyManager.getDeviceId();
        if (TextUtils.isEmpty(deviceId)) {
            return "";
        }
        return deviceId;
    }

    private static String c(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        return string;
    }

    private static void a(Context context, String str) {
        if (!(context.checkCallingOrSelfPermission(str) == 0)) {
            throw new SecurityException("Permission Denial: requires permission " + str);
        }
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Environment.getExternalStorageDirectory(), d)));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append(IOUtils.LINE_SEPARATOR_WINDOWS);
            }
            bufferedReader.close();
            Object[] split = new String(b(c, c, com.baidu.sapi2.utils.b.c.a(sb.toString()))).split("=");
            if (split.length != 2 || !str.equals(split[0])) {
                return "";
            }
            return split[1];
        } catch (FileNotFoundException e2) {
            L.e(e2);
            return "";
        } catch (IOException e3) {
            L.e(e3);
            return "";
        } catch (Throwable th) {
            L.e(th);
            return "";
        }
    }

    private static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(Environment.getExternalStorageDirectory(), d);
            try {
                new File(file.getParent()).mkdirs();
                FileWriter fileWriter = new FileWriter(file, false);
                fileWriter.write(com.baidu.sapi2.utils.b.c.a(a(c, c, (str + "=" + str2).getBytes())));
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e2) {
                L.e(e2);
            } catch (Throwable th) {
                L.e(th);
            }
        }
    }

    private static byte[] a(String str, String str2, byte[] bArr) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), f);
        Cipher cipher = Cipher.getInstance(e);
        cipher.init(1, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return cipher.doFinal(bArr);
    }

    private static byte[] b(String str, String str2, byte[] bArr) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), f);
        Cipher cipher = Cipher.getInstance(e);
        cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return cipher.doFinal(bArr);
    }
}
