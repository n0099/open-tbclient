package com.baidu.android.imrtc.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Looper;
/* loaded from: classes.dex */
public class RtcUtility {
    public static final String KEY_APPID = "appid";
    public static final String KEY_BDUID = "bduid";
    public static final String KEY_CUID = "cuid";
    public static final String KEY_RTC_APP_ID = "rtc_app_id";
    public static final String KEY_RTC_DEBUG = "rtc_debug";
    public static final String KEY_RTC_ROOM_DES = "rtc_room_des";
    public static final String KEY_RTC_ROOM_ID = "rtc_room_id";
    public static final String KEY_RTC_ROOM_NAME = "rtc_room_name";
    public static final String KEY_RTC_ROOM_TOKEN = "rtc_room_token";
    public static final String KEY_RTC_USER_ID = "rtc_user_id";
    public static final String KEY_UK = "uk";
    public static final String PREF_COMMON_DATA = "bim_rtc_sp";
    public static final String TAG = "Utility";

    public static long getAppId(Context context) {
        return readLongData(context, "appid", -1L);
    }

    public static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            LogUtils.e("Utility", "getAppVersionName NameNotFoundException", e2);
            return null;
        }
    }

    public static String getBduid(Context context) {
        return readStringData(context, "bduid", "");
    }

    public static String getCuid(Context context) {
        return readStringData(context, "cuid", "");
    }

    public static long getIMUK(Context context) {
        return readLongData(context, "uk", -1L);
    }

    public static String getRtcAppId(Context context) {
        return readStringData(context, KEY_RTC_APP_ID, "");
    }

    public static String getRtcRoomDes(Context context) {
        return readStringData(context, KEY_RTC_ROOM_DES, "");
    }

    public static String getRtcRoomId(Context context) {
        return readStringData(context, "rtc_room_id", "");
    }

    public static String getRtcRoomName(Context context) {
        return readStringData(context, KEY_RTC_ROOM_NAME, "");
    }

    public static String getRtcRoomToken(Context context) {
        return readStringData(context, KEY_RTC_ROOM_TOKEN, "");
    }

    public static long getRtcUserId(Context context) {
        return readLongData(context, KEY_RTC_USER_ID, 0L);
    }

    public static boolean isRtcDebug(Context context) {
        return readBooleanData(context, KEY_RTC_DEBUG, false);
    }

    public static boolean readBooleanData(Context context, String str, boolean z) {
        if (context == null) {
            return false;
        }
        return context.getSharedPreferences(PREF_COMMON_DATA, 0).getBoolean(str, z);
    }

    public static int readIntData(Context context, String str, int i) {
        if (context == null) {
            return -1;
        }
        return context.getSharedPreferences(PREF_COMMON_DATA, 0).getInt(str, i);
    }

    public static long readLongData(Context context, String str, long j) {
        if (context == null) {
            return -1L;
        }
        return context.getSharedPreferences(PREF_COMMON_DATA, 0).getLong(str, j);
    }

    public static String readStringData(Context context, String str, String str2) {
        return context == null ? "" : context.getSharedPreferences(PREF_COMMON_DATA, 0).getString(str, str2);
    }

    public static void setAppId(Context context, long j) {
        writeLongData(context, "appid", j);
    }

    public static void setBduid(Context context, String str) {
        writeStringData(context, "bduid", str);
    }

    public static void setCuid(Context context, String str) {
        writeStringData(context, "cuid", str);
    }

    public static void setIMUK(Context context, long j) {
        writeLongData(context, "uk", j);
    }

    public static void setRtcAppId(Context context, String str) {
        writeStringData(context, KEY_RTC_APP_ID, str);
    }

    public static void setRtcDebug(Context context, boolean z) {
        writeBooleanData(context, KEY_RTC_DEBUG, z);
    }

    public static void setRtcRoomDes(Context context, String str) {
        writeStringData(context, KEY_RTC_ROOM_DES, str);
    }

    public static void setRtcRoomId(Context context, String str) {
        writeStringData(context, "rtc_room_id", str);
    }

    public static void setRtcRoomName(Context context, String str) {
        writeStringData(context, KEY_RTC_ROOM_NAME, str);
    }

    public static void setRtcRoomToken(Context context, String str) {
        writeStringData(context, KEY_RTC_ROOM_TOKEN, str);
    }

    public static void setRtcUserId(Context context, long j) {
        writeLongData(context, KEY_RTC_USER_ID, j);
    }

    public static void writeBooleanData(Context context, String str, boolean z) {
        writeSPData(context, str, Boolean.valueOf(z));
    }

    public static void writeIntData(Context context, String str, int i) {
        writeSPData(context, str, Integer.valueOf(i));
    }

    public static void writeLongData(Context context, String str, long j) {
        writeSPData(context, str, Long.valueOf(j));
    }

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

    public static void writeSPData(Context context, final String str, final Object obj) {
        if (context == null) {
            return;
        }
        try {
            final SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_COMMON_DATA, 0);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                TaskManager.getInstance().submitForNetWork(new Runnable() { // from class: com.baidu.android.imrtc.utils.RtcUtility.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RtcUtility.writeObjectData(sharedPreferences, str, obj);
                    }
                });
            } else {
                writeObjectData(sharedPreferences, str, obj);
            }
        } catch (Throwable th) {
            LogUtils.e("Utility", th.getMessage());
        }
    }

    public static void writeStringData(Context context, String str, String str2) {
        writeSPData(context, str, str2);
    }
}
