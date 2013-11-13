package com.baidu.android.systemmonitor.d;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static short f802a = 1;

    public static long a(Context context, boolean z) {
        try {
            FileInputStream openFileInput = context.openFileInput(z ? "poweron" : "poweroff");
            byte[] bArr = new byte[256];
            int read = openFileInput.read(bArr);
            r0 = read > 0 ? Long.parseLong(new String(bArr, 0, read)) : 0L;
            openFileInput.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e2) {
        } catch (NumberFormatException e3) {
        }
        return r0;
    }

    public static String a(Context context) {
        return context.getSharedPreferences("tj", 0).getString("active_event_data", "");
    }

    public static void a(Context context, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences("tj", 0).edit();
        edit.putInt("freq_statistic_type", i);
        edit.commit();
    }

    public static void a(Context context, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences("tj", 0).edit();
        edit.putLong("freq_statistic_upload_time", j);
        edit.commit();
    }

    public static void a(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("tj", 0).edit();
        edit.putString("active_event_data", str);
        edit.commit();
    }

    public static boolean a(Context context, long j, boolean z) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput(z ? "poweron" : "poweroff", 0);
            openFileOutput.write(String.valueOf(j).getBytes());
            openFileOutput.close();
            return true;
        } catch (FileNotFoundException e) {
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    public static void b(Context context, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences("tj", 0).edit();
        edit.putLong("get_storeinfo_time", j);
        edit.commit();
    }

    public static void b(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("tj", 0).edit();
        edit.putString("imei", str);
        edit.commit();
    }

    public static void b(Context context, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences("tj", 0).edit();
        edit.putBoolean("active_event_posted", z);
        edit.commit();
    }

    public static boolean b(Context context) {
        return context.getSharedPreferences("tj", 0).getBoolean("active_event_posted", false);
    }

    public static int c(Context context) {
        return context.getSharedPreferences("tj", 0).getInt("freq_statistic_type", -1);
    }

    public static String d(Context context) {
        return context.getSharedPreferences("tj", 0).getString("imei", "");
    }

    public static void e(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("tj", 0).edit();
        edit.putLong("freq_statistic_upload_time", System.currentTimeMillis());
        edit.commit();
    }

    public static Boolean f(Context context) {
        return Boolean.valueOf(context.getSharedPreferences("tj", 0).getBoolean("freq_statistic_db_inited", false));
    }

    public static void g(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("tj", 0).edit();
        edit.putBoolean("freq_statistic_db_inited", true);
        edit.commit();
    }

    public static long h(Context context) {
        return context.getSharedPreferences("tj", 0).getLong("freq_statistic_upload_time", System.currentTimeMillis());
    }

    public static long i(Context context) {
        return context.getSharedPreferences("tj", 0).getLong("get_storeinfo_time", 0L);
    }
}
