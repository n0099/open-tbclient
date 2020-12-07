package com.baidu.down.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes6.dex */
public final class DownPrefUtils {
    private static final boolean DEBUG = false;
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
    private static final String TAG = "DownPrefUtils";
    private static long mSpeedOffsetMin = -1;
    private static long mSpeedOffsetMax = -1;
    private static long mCDNUrlTimeout = -1;
    private static long mTestSpeedDuration = -1;
    private static long mTestSpeedDataSize = -1;
    public static String HOST_TYPE_NAME = "0";
    public static String HOST_TYPE_IP = "1";
    public static String HTTP_LIB_TYPE_HTTPCLIENT = "0";
    public static String HTTP_LIB_TYPE_URLCONNECTION = "1";
    public static String PREF_SPEED_CONFIG_KEY = "pref_speed_config_key";
    public static String PREF_SPEED_CONFIG_ACQUIRE_TIME_KEY = "pref_speed_config_acquire_time_key";

    private DownPrefUtils() {
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        return context.getSharedPreferences(PREF_DOWNLOAD_NAME, 0).getBoolean(str, z);
    }

    public static void setBoolean(Context context, String str, boolean z) {
        SharedPreferences sharedPreferences;
        if (context != null && str != null && (sharedPreferences = context.getSharedPreferences(PREF_DOWNLOAD_NAME, 0)) != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(str, z);
            edit.commit();
        }
    }

    public static float getFloat(Context context, String str, float f) {
        return context.getSharedPreferences(PREF_DOWNLOAD_NAME, 0).getFloat(str, f);
    }

    public static void setFloat(Context context, String str, float f) {
        SharedPreferences sharedPreferences;
        if (context != null && str != null && (sharedPreferences = context.getSharedPreferences(PREF_DOWNLOAD_NAME, 0)) != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putFloat(str, f);
            edit.commit();
        }
    }

    public static int getInt(Context context, String str, int i) {
        return context.getSharedPreferences(PREF_DOWNLOAD_NAME, 0).getInt(str, i);
    }

    public static void setInt(Context context, String str, int i) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (context != null && str != null && (sharedPreferences = context.getSharedPreferences(PREF_DOWNLOAD_NAME, 0)) != null && (edit = sharedPreferences.edit()) != null) {
            edit.putInt(str, i);
            edit.commit();
        }
    }

    public static long getLong(Context context, String str, long j) {
        return context.getSharedPreferences(PREF_DOWNLOAD_NAME, 0).getLong(str, j);
    }

    public static long testConfigurationGetLong(Context context, String str, long j) {
        return context.getSharedPreferences(PREF_DOWNLOAD_NAME, 0).getLong(str, j);
    }

    public static void setLong(Context context, String str, long j) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (context != null && (sharedPreferences = context.getSharedPreferences(PREF_DOWNLOAD_NAME, 0)) != null && (edit = sharedPreferences.edit()) != null) {
            edit.putLong(str, j);
            edit.commit();
        }
    }

    public static String getString(Context context, String str, String str2) {
        return context.getSharedPreferences(PREF_DOWNLOAD_NAME, 0).getString(str, str2);
    }

    public static void setString(Context context, String str, String str2) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (context != null && str != null && (sharedPreferences = context.getSharedPreferences(PREF_DOWNLOAD_NAME, 0)) != null && (edit = sharedPreferences.edit()) != null) {
            edit.putString(str, str2);
            edit.commit();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [360=4] */
    public static void loadProperties(Context context) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        System.currentTimeMillis();
        File file = new File(Environment.getExternalStorageDirectory(), "appsearch.cfg");
        if (!file.exists() && context != null) {
            file = new File(context.getFilesDir() + "/appsearch.cfg");
        }
        if (file.exists()) {
            Properties properties = new Properties();
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception e) {
                fileInputStream2 = null;
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
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
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }
}
