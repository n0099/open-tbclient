package com.baidu.down.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes2.dex */
public final class DownPrefUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static String HOST_TYPE_IP = "1";
    public static String HOST_TYPE_NAME = "0";
    public static String HTTP_LIB_TYPE_HTTPCLIENT = "0";
    public static String HTTP_LIB_TYPE_URLCONNECTION = "1";
    public static final String PREF_CDN_HOST = "pref_cdn_host";
    public static final String PREF_CONFIG_CDN_URL_TIMEOUT = "pref_config_cdn_url_timeout";
    public static final String PREF_CONFIG_DOWNINFO_URL_TIMEOUT = "pref_config_downinfo_url_timeout";
    public static final String PREF_CONFIG_DOWNLOAD_SPEED_OFFSET_MAX = "pref_config_download_speed_offset_max";
    public static final String PREF_CONFIG_DOWNLOAD_SPEED_OFFSET_MIN = "pref_config_download_speed_offset_min";
    public static final String PREF_CONFIG_REQUEST_INTERVAL = "pref_config_request_interval";
    public static final String PREF_CONFIG_REQUEST_TIME = "pref_config_request_time";
    public static final String PREF_CONFIG_TEST_SPEED_DATA_SIZE = "pref_config_test_speed_data_size";
    public static final String PREF_CONFIG_TEST_SPEED_DURATION = "pref_config_test_speed_duration";
    public static final String PREF_CONFIG_TEST_SPEED_IP_NUM = "pref_config_test_speed_ip_num";
    public static final String PREF_CONFIG_TEST_SPEED_THRESHOLD = "pref_config_test_speed_threshold";
    public static final String PREF_CONFI_HOST_TYPE = "pref_config_host_type";
    public static final String PREF_CONFI_HTTP_LIB_TYPE = "pref_config_http_lib_type";
    public static final String PREF_CONFI_IS_INFO_TYPE = "pref_config_info_type";
    public static final String PREF_CONFI_IS_UPLOAD_LOG = "pref_config_is_upload_log";
    public static final String PREF_DOWNLOAD_INFO_HOST = "pref_download_info_host";
    public static final String PREF_DOWNLOAD_NAME = "pref_download_setting";
    public static final String PREF_LOG_HOST = "pref_log_host";
    public static String PREF_SPEED_CONFIG_ACQUIRE_TIME_KEY = "pref_speed_config_acquire_time_key";
    public static String PREF_SPEED_CONFIG_KEY = "pref_speed_config_key";
    public static final String TAG = "DownPrefUtils";
    public static long mCDNUrlTimeout = -1;
    public static long mSpeedOffsetMax = -1;
    public static long mSpeedOffsetMin = -1;
    public static long mTestSpeedDataSize = -1;
    public static long mTestSpeedDuration = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(902521132, "Lcom/baidu/down/utils/DownPrefUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(902521132, "Lcom/baidu/down/utils/DownPrefUtils;");
        }
    }

    public DownPrefUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, context, str, z)) == null) {
            return context.getSharedPreferences(PREF_DOWNLOAD_NAME, 0).getBoolean(str, z);
        }
        return invokeLLZ.booleanValue;
    }

    public static float getFloat(Context context, String str, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, str, Float.valueOf(f)})) == null) {
            return context.getSharedPreferences(PREF_DOWNLOAD_NAME, 0).getFloat(str, f);
        }
        return invokeCommon.floatValue;
    }

    public static int getInt(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, i)) == null) {
            return context.getSharedPreferences(PREF_DOWNLOAD_NAME, 0).getInt(str, i);
        }
        return invokeLLI.intValue;
    }

    public static long getLong(Context context, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{context, str, Long.valueOf(j)})) == null) {
            return context.getSharedPreferences(PREF_DOWNLOAD_NAME, 0).getLong(str, j);
        }
        return invokeCommon.longValue;
    }

    public static String getString(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, context, str, str2)) == null) {
            return context.getSharedPreferences(PREF_DOWNLOAD_NAME, 0).getString(str, str2);
        }
        return (String) invokeLLL.objValue;
    }

    public static void setBoolean(Context context, String str, boolean z) {
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(65544, null, context, str, z) == null) && context != null && str != null && (sharedPreferences = context.getSharedPreferences(PREF_DOWNLOAD_NAME, 0)) != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(str, z);
            edit.commit();
        }
    }

    public static void setInt(Context context, String str, int i) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65546, null, context, str, i) == null) && context != null && str != null && (sharedPreferences = context.getSharedPreferences(PREF_DOWNLOAD_NAME, 0)) != null && (edit = sharedPreferences.edit()) != null) {
            edit.putInt(str, i);
            edit.commit();
        }
    }

    public static void setString(Context context, String str, String str2) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65548, null, context, str, str2) == null) && context != null && str != null && (sharedPreferences = context.getSharedPreferences(PREF_DOWNLOAD_NAME, 0)) != null && (edit = sharedPreferences.edit()) != null) {
            edit.putString(str, str2);
            edit.commit();
        }
    }

    public static long testConfigurationGetLong(Context context, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{context, str, Long.valueOf(j)})) == null) {
            return context.getSharedPreferences(PREF_DOWNLOAD_NAME, 0).getLong(str, j);
        }
        return invokeCommon.longValue;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00d7 -> B:51:0x00da). Please submit an issue!!! */
    public static void loadProperties(Context context) {
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
            System.currentTimeMillis();
            File file = new File(Environment.getExternalStorageDirectory(), "appsearch.cfg");
            if (!file.exists() && context != null) {
                file = new File(context.getFilesDir() + "/appsearch.cfg");
            }
            if (file.exists()) {
                Properties properties = new Properties();
                FileInputStream fileInputStream2 = null;
                try {
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    properties.load(fileInputStream);
                    if (properties.getProperty("onSpeedOffsetMin") != null) {
                        mSpeedOffsetMin = Long.valueOf(properties.getProperty("onSpeedOffsetMin")).longValue();
                    }
                    if (properties.getProperty("onSpeedOffsetMax") != null) {
                        mSpeedOffsetMax = Long.valueOf(properties.getProperty("onSpeedOffsetMax")).longValue();
                    }
                    if (properties.getProperty("cdnUrlTimeout") != null) {
                        mCDNUrlTimeout = Long.valueOf(properties.getProperty("cdnUrlTimeout")).longValue();
                    }
                    if (properties.getProperty("testSpeedDuration") != null) {
                        mTestSpeedDuration = Long.valueOf(properties.getProperty("testSpeedDuration")).longValue();
                    }
                    if (properties.getProperty("testSpeedDataSize") != null) {
                        mTestSpeedDataSize = Long.valueOf(properties.getProperty("testSpeedDataSize")).longValue();
                    }
                    fileInputStream.close();
                } catch (Exception unused2) {
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        }
    }

    public static void setFloat(Context context, String str, float f) {
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, str, Float.valueOf(f)}) == null) && context != null && str != null && (sharedPreferences = context.getSharedPreferences(PREF_DOWNLOAD_NAME, 0)) != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putFloat(str, f);
            edit.commit();
        }
    }

    public static void setLong(Context context, String str, long j) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{context, str, Long.valueOf(j)}) == null) && context != null && (sharedPreferences = context.getSharedPreferences(PREF_DOWNLOAD_NAME, 0)) != null && (edit = sharedPreferences.edit()) != null) {
            edit.putLong(str, j);
            edit.commit();
        }
    }
}
