package com.baidu.searchbox.download.center.clearcache.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.download.center.clearcache.MainClearCache;
import java.util.Locale;
/* loaded from: classes3.dex */
public class ClearCacheUtils {
    public static final long DEFAULT_LAST_CLEAR_TIME = 0;
    public static final long DISPLAY_THRESHOLD = 5242880;
    public static final int DIVIDER = 1024;
    public static final long DO_CLEAR_PERIOD = 14400000;
    public static final String LAST_DO_CLEAR_CACHE_COUNT_TIME = "last_do_clear_cache_count_time";
    public static final String PATH_SIGN = "% / ";
    public static final String TAG = "ClearCacheUtils";

    public static void doClearCacheJob() {
        if (System.currentTimeMillis() - DefaultSharedPrefsWrapper.getInstance().getLong(LAST_DO_CLEAR_CACHE_COUNT_TIME, 0L) >= DO_CLEAR_PERIOD) {
            new MainClearCache().calculateCacheSize(null);
        }
    }

    public static void markDoneClearJob() {
        DefaultSharedPrefsWrapper.getInstance().putLong(LAST_DO_CLEAR_CACHE_COUNT_TIME, System.currentTimeMillis());
    }

    public static String formatSize(long j) {
        double d;
        double d2 = j;
        String str = "KB";
        if (d2 >= 1024.0d) {
            d = d2 / 1024.0d;
            if (d >= 1024.0d) {
                d /= 1024.0d;
                if (d >= 1024.0d) {
                    d /= 1024.0d;
                    str = "GB";
                } else {
                    str = "MB";
                }
            }
        } else {
            d = 0.0d;
        }
        if (!TextUtils.equals(str, "GB")) {
            String str2 = "0" + str;
            try {
                return String.format(Locale.CHINESE, "%d%s", Long.valueOf(Math.round(d)), str);
            } catch (Throwable th) {
                if (AppConfig.isDebug()) {
                    Log.w(TAG, "formatSize: " + th.getMessage());
                    th.printStackTrace();
                }
                return Math.round(d) + str;
            }
        }
        String str3 = "0" + str;
        try {
            String format = String.format(Locale.CHINESE, "%.1f%s", Double.valueOf(d), str);
            if (format.substring(format.length() - 3, format.length() - 2).equals("0")) {
                return String.format(Locale.CHINESE, "%.0f%s", Double.valueOf(d), str);
            }
            return format;
        } catch (Throwable th2) {
            if (AppConfig.isDebug()) {
                Log.w(TAG, "formatSize: " + th2.getMessage());
                th2.printStackTrace();
            }
            return Math.round(d) + str;
        }
    }

    public static String getAppVersionName(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
