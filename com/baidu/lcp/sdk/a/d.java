package com.baidu.lcp.sdk.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class d {
    private static String readStringData(Context context, String str, String str2) {
        return context.getSharedPreferences("track_sp", 0).getString(str, str2);
    }

    private static void writeStringData(Context context, String str, String str2) {
        writeSPData(context, str, str2);
    }

    private static long readLongData(Context context, String str, long j) {
        return context.getSharedPreferences("track_sp", 0).getLong(str, j);
    }

    private static void writeLongData(Context context, String str, long j) {
        writeSPData(context, str, Long.valueOf(j));
    }

    private static int readIntData(Context context, String str, int i) {
        return context.getSharedPreferences("track_sp", 0).getInt(str, i);
    }

    private static void writeIntData(Context context, String str, int i) {
        writeSPData(context, str, Integer.valueOf(i));
    }

    private static void writeSPData(Context context, final String str, final Object obj) {
        try {
            final SharedPreferences sharedPreferences = context.getSharedPreferences("track_sp", 0);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                com.baidu.lcp.sdk.c.a.aE(context).submitForNetWork(new Runnable() { // from class: com.baidu.lcp.sdk.a.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.writeObjectData(sharedPreferences, str, obj);
                    }
                });
            } else {
                writeObjectData(sharedPreferences, str, obj);
            }
        } catch (Throwable th) {
            com.baidu.lcp.sdk.d.d.e("TrackUtils", th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeObjectData(SharedPreferences sharedPreferences, String str, Object obj) {
        if (obj instanceof Boolean) {
            sharedPreferences.edit().putBoolean(str, ((Boolean) obj).booleanValue()).apply();
        } else if (obj instanceof Integer) {
            sharedPreferences.edit().putInt(str, ((Integer) obj).intValue()).apply();
        } else if (obj instanceof Long) {
            sharedPreferences.edit().putLong(str, ((Long) obj).longValue()).apply();
        } else if (obj instanceof Float) {
            sharedPreferences.edit().putFloat(str, ((Float) obj).floatValue()).apply();
        } else if (obj instanceof String) {
            sharedPreferences.edit().putString(str, (String) obj).apply();
        }
    }

    private static Set<String> a(Context context, String str, Set<String> set) {
        return context.getSharedPreferences("track_sp", 0).getStringSet(str, set);
    }

    @SuppressLint({"CommitPrefEdits"})
    private static void b(final Context context, final String str, final Set<String> set) {
        try {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                com.baidu.lcp.sdk.c.a.aE(context).submitForNetWork(new Runnable() { // from class: com.baidu.lcp.sdk.a.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        context.getSharedPreferences("track_sp", 0).edit().putStringSet(str, set).apply();
                    }
                });
            } else {
                context.getSharedPreferences("track_sp", 0).edit().putStringSet(str, set).apply();
            }
        } catch (Throwable th) {
            com.baidu.lcp.sdk.d.d.e("TrackUtils", th.getMessage());
        }
    }

    public static void as(Context context) {
        writeLongData(context, "track_upload_time", System.currentTimeMillis());
    }

    public static boolean at(Context context) {
        long readLongData = readLongData(context, "track_upload_time", -1L);
        if (readLongData > 0) {
            return System.currentTimeMillis() - readLongData >= 21600000;
        }
        as(context);
        return false;
    }

    public static void g(Context context, int i) {
        writeIntData(context, "track_upload_state_fail_count", i);
    }

    public static int au(Context context) {
        return readIntData(context, "track_upload_state_fail_count", 1);
    }

    public static void h(Context context, int i) {
        writeIntData(context, "track_upload_state", i);
    }

    public static boolean av(Context context) {
        return readIntData(context, "track_upload_state", 1) == 1;
    }

    public static void b(Context context, int i, int i2) {
        writeIntData(context, i + "real_time_track", i2);
    }

    public static boolean i(Context context, int i) {
        return readIntData(context, new StringBuilder().append(i).append("real_time_track").toString(), 0) == 1;
    }

    public static void writeLoginFlag(Context context, String str, String str2) {
        if (av(context)) {
            writeStringData(context, Constants.KEY_LOGIN_FLAG, System.currentTimeMillis() + ":" + str + ":" + str2);
        }
    }

    public static String[] getLoginFlag(Context context) {
        return readStringData(context, Constants.KEY_LOGIN_FLAG, "0:1Y:ext").split(":");
    }

    public static long getLoginCallTime(Context context) {
        return readLongData(context, Constants.KEY_LOGIN_CALL_TIME, 0L);
    }

    public static void writeLoginCallTime(Context context) {
        writeLongData(context, Constants.KEY_LOGIN_CALL_TIME, System.currentTimeMillis());
    }

    public static int getLoginOpenType(Context context) {
        return readIntData(context, Constants.KEY_LOGIN_OPEN_TYPE, -1);
    }

    public static void writeLoginOpenType(Context context, int i) {
        writeIntData(context, Constants.KEY_LOGIN_OPEN_TYPE, i);
    }

    public static Set<String> aw(Context context) {
        return a(context, "track_connection", new HashSet());
    }

    public static void a(Context context, Set<String> set) {
        b(context, "track_connection", set);
    }

    public static Set<String> ax(Context context) {
        return a(context, "track_request", new HashSet());
    }

    public static void b(Context context, Set<String> set) {
        b(context, "track_request", set);
    }

    public static void ay(Context context) {
        b(context, "track_connection", new HashSet());
        b(context, "track_request", new HashSet());
    }
}
