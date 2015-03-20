package com.baidu.location.a.a;

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
/* loaded from: classes.dex */
public final class b {
    public static String S(Context context) {
        return c.T(context).f27if;
    }

    public static String a(Context context) {
        a(context, "android.permission.WRITE_SETTINGS");
        a(context, "android.permission.READ_PHONE_STATE");
        a(context, "android.permission.WRITE_EXTERNAL_STORAGE");
        c T = c.T(context);
        String str = T.f27if;
        boolean z = !T.a;
        String m66if = m66if(context);
        if (z) {
            return d.a(("com.baidu" + m66if).getBytes(), true);
        }
        String str2 = null;
        String string = Settings.System.getString(context.getContentResolver(), "com.baidu.deviceid");
        if (TextUtils.isEmpty(string)) {
            str2 = d.a(("com.baidu" + str + m66if).getBytes(), true);
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
            String a = d.a((str + m66if + UUID.randomUUID().toString()).getBytes(), true);
            Settings.System.putString(context.getContentResolver(), str2, a);
            Settings.System.putString(context.getContentResolver(), "com.baidu.deviceid", a);
            a(str, a);
            return a;
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
                sb.append("\r\n");
            }
            bufferedReader.close();
            Object[] split = new String(com.baidu.location.a.b.a.a("30212102dicudiab", "30212102dicudiab", com.baidu.location.a.b.b.a(sb.toString().getBytes()))).split("=");
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
            fileWriter.write(com.baidu.location.a.b.b.a(com.baidu.location.a.b.a.e("30212102dicudiab", "30212102dicudiab", (str + "=" + str2).getBytes()), "utf-8"));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
        } catch (Exception e2) {
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static String m66if(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        return TextUtils.isEmpty(string) ? "" : string;
    }
}
