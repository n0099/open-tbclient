package com.baidu.a.a.a.b;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public final class b {
    public static String a(Context context) {
        a(context, "android.permission.WRITE_SETTINGS");
        a(context, "android.permission.READ_PHONE_STATE");
        a(context, "android.permission.WRITE_EXTERNAL_STORAGE");
        c a = c.a(context);
        String str = a.a;
        boolean z = !a.b;
        String c = c(context);
        if (z) {
            return com.baidu.a.a.a.a.c.a(("com.baidu" + c).getBytes(), true);
        }
        String str2 = null;
        String string = Settings.System.getString(context.getContentResolver(), "com.baidu.deviceid");
        if (TextUtils.isEmpty(string)) {
            str2 = com.baidu.a.a.a.a.c.a(("com.baidu" + str + c).getBytes(), true);
            string = Settings.System.getString(context.getContentResolver(), str2);
            if (!TextUtils.isEmpty(string)) {
                Settings.System.putString(context.getContentResolver(), "com.baidu.deviceid", string);
                a(str, string);
            }
        }
        if (TextUtils.isEmpty(string)) {
            string = a(str);
            if (!TextUtils.isEmpty(string)) {
                Settings.System.putString(context.getContentResolver(), str2, string);
                Settings.System.putString(context.getContentResolver(), "com.baidu.deviceid", string);
            }
        }
        if (TextUtils.isEmpty(string)) {
            String a2 = com.baidu.a.a.a.a.c.a((str + c + UUID.randomUUID().toString()).getBytes(), true);
            Settings.System.putString(context.getContentResolver(), str2, a2);
            Settings.System.putString(context.getContentResolver(), "com.baidu.deviceid", a2);
            a(str, a2);
            return a2;
        }
        return string;
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
                sb.append(IOUtils.LINE_SEPARATOR_WINDOWS);
            }
            bufferedReader.close();
            Object[] split = new String(com.baidu.a.a.a.a.a.b("30212102dicudiab", "30212102dicudiab", com.baidu.a.a.a.a.b.a(sb.toString().getBytes()))).split("=");
            return (split != null && split.length == 2 && str.equals(split[0])) ? split[1] : "";
        } catch (FileNotFoundException e) {
            return "";
        } catch (IOException e2) {
            return "";
        } catch (Exception e3) {
            return "";
        }
    }

    private static void a(Context context, String str) {
        if (!(context.checkCallingOrSelfPermission(str) == 0)) {
            throw new SecurityException("Permission Denial: requires permission " + str);
        }
    }

    private static void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
        try {
            new File(file.getParent()).mkdirs();
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write(com.baidu.a.a.a.a.b.a(com.baidu.a.a.a.a.a.a("30212102dicudiab", "30212102dicudiab", (str + "=" + str2).getBytes()), "utf-8"));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
        } catch (Exception e2) {
        }
    }

    public static String b(Context context) {
        return c.a(context).a;
    }

    public static String c(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        return TextUtils.isEmpty(string) ? "" : string;
    }
}
