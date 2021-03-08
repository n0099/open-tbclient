package com.baidu.android.imrtc.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Looper;
/* loaded from: classes3.dex */
public class RtcUtility {
    private static final String KEY_APPID = "appid";
    private static final String KEY_BDUID = "bduid";
    private static final String KEY_CUID = "cuid";
    private static final String KEY_RTC_APP_ID = "rtc_app_id";
    private static final String KEY_RTC_DEBUG = "rtc_debug";
    private static final String KEY_RTC_ROOM_DES = "rtc_room_des";
    private static final String KEY_RTC_ROOM_ID = "rtc_room_id";
    private static final String KEY_RTC_ROOM_NAME = "rtc_room_name";
    private static final String KEY_RTC_ROOM_TOKEN = "rtc_room_token";
    private static final String KEY_RTC_USER_ID = "rtc_user_id";
    private static final String KEY_UK = "uk";
    private static final String PREF_COMMON_DATA = "bim_rtc_sp";
    private static final String TAG = "Utility";

    public static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            LogUtils.e(TAG, "getAppVersionName NameNotFoundException", e);
            return null;
        }
    }

    public static void setRtcRoomId(Context context, String str) {
        writeStringData(context, "rtc_room_id", str);
    }

    public static String getRtcRoomId(Context context) {
        return readStringData(context, "rtc_room_id", "");
    }

    public static void setRtcRoomToken(Context context, String str) {
        writeStringData(context, KEY_RTC_ROOM_TOKEN, str);
    }

    public static String getRtcRoomToken(Context context) {
        return readStringData(context, KEY_RTC_ROOM_TOKEN, "");
    }

    public static void setRtcAppId(Context context, String str) {
        writeStringData(context, KEY_RTC_APP_ID, str);
    }

    public static String getRtcAppId(Context context) {
        return readStringData(context, KEY_RTC_APP_ID, "");
    }

    public static void setRtcRoomName(Context context, String str) {
        writeStringData(context, KEY_RTC_ROOM_NAME, str);
    }

    public static String getRtcRoomName(Context context) {
        return readStringData(context, KEY_RTC_ROOM_NAME, "");
    }

    public static void setRtcUserId(Context context, long j) {
        writeLongData(context, KEY_RTC_USER_ID, j);
    }

    public static long getRtcUserId(Context context) {
        return readLongData(context, KEY_RTC_USER_ID, 0L);
    }

    public static void setRtcRoomDes(Context context, String str) {
        writeStringData(context, KEY_RTC_ROOM_DES, str);
    }

    public static String getRtcRoomDes(Context context) {
        return readStringData(context, KEY_RTC_ROOM_DES, "");
    }

    public static void setRtcDebug(Context context, boolean z) {
        writeBooleanData(context, KEY_RTC_DEBUG, z);
    }

    public static boolean isRtcDebug(Context context) {
        return readBooleanData(context, KEY_RTC_DEBUG, false);
    }

    public static void setIMUK(Context context, long j) {
        writeLongData(context, "uk", j);
    }

    public static long getIMUK(Context context) {
        return readLongData(context, "uk", -1L);
    }

    public static void setCuid(Context context, String str) {
        writeStringData(context, "cuid", str);
    }

    public static String getCuid(Context context) {
        return readStringData(context, "cuid", "");
    }

    public static void setAppId(Context context, long j) {
        writeLongData(context, "appid", j);
    }

    public static long getAppId(Context context) {
        return readLongData(context, "appid", -1L);
    }

    public static void setBduid(Context context, String str) {
        writeStringData(context, "bduid", str);
    }

    public static String getBduid(Context context) {
        return readStringData(context, "bduid", "");
    }

    private static String readStringData(Context context, String str, String str2) {
        if (context == null) {
            return "";
        }
        return context.getSharedPreferences(PREF_COMMON_DATA, 0).getString(str, str2);
    }

    private static void writeStringData(Context context, String str, String str2) {
        writeSPData(context, str, str2);
    }

    private static long readLongData(Context context, String str, long j) {
        if (context == null) {
            return -1L;
        }
        return context.getSharedPreferences(PREF_COMMON_DATA, 0).getLong(str, j);
    }

    private static void writeLongData(Context context, String str, long j) {
        writeSPData(context, str, Long.valueOf(j));
    }

    private static boolean readBooleanData(Context context, String str, boolean z) {
        if (context == null) {
            return false;
        }
        return context.getSharedPreferences(PREF_COMMON_DATA, 0).getBoolean(str, z);
    }

    private static void writeBooleanData(Context context, String str, boolean z) {
        writeSPData(context, str, Boolean.valueOf(z));
    }

    private static void writeSPData(Context context, final String str, final Object obj) {
        if (context != null) {
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
                LogUtils.e(TAG, th.getMessage());
            }
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

    private static int readIntData(Context context, String str, int i) {
        if (context == null) {
            return -1;
        }
        return context.getSharedPreferences(PREF_COMMON_DATA, 0).getInt(str, i);
    }

    private static void writeIntData(Context context, String str, int i) {
        writeSPData(context, str, Integer.valueOf(i));
    }
}
