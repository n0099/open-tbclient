package com.baidu.location.a.a;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;
/* loaded from: classes.dex */
public final class b {

    /* loaded from: classes.dex */
    static final class a {
        public final boolean a;

        /* renamed from: if  reason: not valid java name */
        public final String f27if;

        private a(String str, boolean z) {
            this.f27if = str;
            this.a = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        static a V(Context context) {
            String str;
            Exception e;
            boolean z;
            String str2 = "";
            try {
                str2 = Settings.System.getString(context.getContentResolver(), "bd_setting_i");
                str = TextUtils.isEmpty(str2) ? a(context, "") : str2;
            } catch (Exception e2) {
                str = str2;
                e = e2;
            }
            try {
                Settings.System.putString(context.getContentResolver(), "bd_setting_i", str);
                z = false;
            } catch (Exception e3) {
                e = e3;
                Log.e("DeviceId", "Settings.System.getString or putString failed", e);
                if (TextUtils.isEmpty(str)) {
                    str = a(context, "");
                    z = true;
                } else {
                    z = true;
                }
                return new a(str, z ? false : true);
            }
            return new a(str, z ? false : true);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0015 A[ORIG_RETURN, RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static String a(Context context, String str) {
            String str2;
            TelephonyManager telephonyManager;
            try {
                telephonyManager = (TelephonyManager) context.getSystemService("phone");
            } catch (Exception e) {
                Log.e("DeviceId", "Read IMEI failed", e);
            }
            if (telephonyManager != null) {
                str2 = telephonyManager.getDeviceId();
                return !TextUtils.isEmpty(str2) ? str : str2;
            }
            str2 = null;
            if (!TextUtils.isEmpty(str2)) {
            }
        }
    }

    public static String U(Context context) {
        return a.V(context).f27if;
    }

    public static String a(Context context) {
        a(context, "android.permission.WRITE_SETTINGS");
        a(context, "android.permission.READ_PHONE_STATE");
        a(context, "android.permission.WRITE_EXTERNAL_STORAGE");
        a V = a.V(context);
        String str = V.f27if;
        boolean z = !V.a;
        String m66if = m66if(context);
        if (z) {
            return c.a(("com.baidu" + m66if).getBytes(), true);
        }
        String str2 = null;
        String string = Settings.System.getString(context.getContentResolver(), "com.baidu.deviceid");
        if (TextUtils.isEmpty(string)) {
            str2 = c.a(("com.baidu" + str + m66if).getBytes(), true);
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
            String a2 = c.a((str + m66if + UUID.randomUUID().toString()).getBytes(), true);
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
