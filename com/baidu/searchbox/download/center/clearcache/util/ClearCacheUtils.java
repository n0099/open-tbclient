package com.baidu.searchbox.download.center.clearcache.util;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.download.center.clearcache.MainClearCache;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes11.dex */
public class ClearCacheUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long DEFAULT_LAST_CLEAR_TIME = 0;
    public static final long DISPLAY_THRESHOLD = 5242880;
    public static final int DIVIDER = 1024;
    public static final long DO_CLEAR_PERIOD = 14400000;
    public static final String LAST_DO_CLEAR_CACHE_COUNT_TIME = "last_do_clear_cache_count_time";
    public static final String PATH_SIGN = "% / ";
    public static final String TAG = "ClearCacheUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public ClearCacheUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void doClearCacheJob() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            if (System.currentTimeMillis() - DefaultSharedPrefsWrapper.getInstance().getLong(LAST_DO_CLEAR_CACHE_COUNT_TIME, 0L) >= DO_CLEAR_PERIOD) {
                new MainClearCache().calculateCacheSize(null);
            }
        }
    }

    public static String formatSize(long j2) {
        InterceptResult invokeJ;
        double d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j2)) == null) {
            double d3 = j2;
            String str = "KB";
            if (d3 >= 1024.0d) {
                d2 = d3 / 1024.0d;
                if (d2 >= 1024.0d) {
                    d2 /= 1024.0d;
                    if (d2 >= 1024.0d) {
                        d2 /= 1024.0d;
                        str = "GB";
                    } else {
                        str = "MB";
                    }
                }
            } else {
                d2 = 0.0d;
            }
            if (!TextUtils.equals(str, "GB")) {
                String str2 = "0" + str;
                try {
                    return String.format(Locale.CHINESE, "%d%s", Long.valueOf(Math.round(d2)), str);
                } catch (Throwable th) {
                    if (AppConfig.isDebug()) {
                        String str3 = "formatSize: " + th.getMessage();
                        th.printStackTrace();
                    }
                    return Math.round(d2) + str;
                }
            }
            String str4 = "0" + str;
            try {
                String format = String.format(Locale.CHINESE, "%.1f%s", Double.valueOf(d2), str);
                return format.substring(format.length() + (-3), format.length() - 2).equals("0") ? String.format(Locale.CHINESE, "%.0f%s", Double.valueOf(d2), str) : format;
            } catch (Throwable th2) {
                if (AppConfig.isDebug()) {
                    String str5 = "formatSize: " + th2.getMessage();
                    th2.printStackTrace();
                }
                return Math.round(d2) + str;
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String getAppVersionName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                return context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void markDoneClearJob() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            DefaultSharedPrefsWrapper.getInstance().putLong(LAST_DO_CLEAR_CACHE_COUNT_TIME, System.currentTimeMillis());
        }
    }
}
