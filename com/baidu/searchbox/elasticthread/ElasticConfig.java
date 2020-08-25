package com.baidu.searchbox.elasticthread;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.mobstat.Config;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class ElasticConfig {
    public static final boolean DEBUG = false;
    private static final String ELASTIC_CONFIG_FILE_DIR = "elastic_config";
    private static final String ELASTIC_CONFIG_FILE_NAME = "config_data";
    public static final int ELASTIC_QUEUE_NUM = 4;
    private static final String TAG = "ElasticConfig";
    public static final String UPDATE_DISABLE_ELASTIC = "disable_elastic";
    public static final int[] ELASTIC_QUEUE_INDEX_PRIORITY_TABLE = {0, 1, 2, 3};
    public static int EXECUTOR_CONFIG_THREAD_PRIORITY_IMMEDIATE = 9;
    public static int EXECUTOR_CONFIG_THREAD_PRIORITY_USER_RELATED = 7;
    public static int EXECUTOR_CONFIG_THREAD_PRIORITY_INTIME = 5;
    public static int EXECUTOR_CONFIG_THREAD_PRIORITY_BACKGROUND = 3;
    public static int EXECUTOR_CONFIG_THREAD_PRIORITY_SERIAL = 7;
    public static long EXECUTOR_CONFIG_KEEP_ALIVE_TIME = 1000;
    public static boolean ENABLE_REAL_TIME_PRINTER = false;
    public static long REAL_TIME_PRINTER_INTERVAL = 1000;
    public static boolean ENABLE_SERIAL_DREDGE = true;
    public static long SERIAL_BLOCK_TIME_THRESHOLD = 2000;
    public static int ARTERY_CONFIG_UI_CORE_POOL_SIZE = 2;
    public static int ARTERY_CONFIG_INTIME_CORE_POOL_SIZE = 2;
    public static int ARTERY_CONFIG_BACKGROUND_CORE_POOL_SIZE = 6;
    public static int DREDGE_CONFIG_FIRST_CORE_POOL_SIZE = 4;
    public static int DREDGE_CONFIG_SECOND_CORE_POOL_SIZE = 6;
    public static int DREDGE_CONFIG_DISASTER_MAX_POOL_SIZE = 30;
    public static double DREDGE_CONFIG_UPGRADE_THRESHOLD = 10.0d;
    public static double DREDGE_CONFIG_UPGRADE_RIGHT_AWAY_THRESHOLD = 30.0d;
    public static double DREDGE_CONFIG_DOWNGRADE_THRESHOLD = 2.0d;
    public static long DREDGE_CONFIG_UPGRADE_STRATEGY_PROTECTION_TIME = 500;
    public static long DREDGE_CONFIG_DOWNGRADE_STRATEGY_PROTECTION_TIME = IMConnection.RETRY_DELAY_TIMES;
    public static double QUEUE_CONFIG_IMMEDIATE_PRIORITY_TASK_WEIGHT = 999.0d;
    public static double QUEUE_CONFIG_FIRST_PRIORITY_TASK_WEIGHT = 8.0d;
    public static double QUEUE_CONFIG_SECOND_PRIORITY_TASK_WEIGHT = 3.0d;
    public static double QUEUE_CONFIG_THIRD_PRIORITY_TASK_WEIGHT = 1.0d;
    public static double[] ELASTIC_QUEUE_BLOCK_WEIGHT = {QUEUE_CONFIG_IMMEDIATE_PRIORITY_TASK_WEIGHT, QUEUE_CONFIG_FIRST_PRIORITY_TASK_WEIGHT, QUEUE_CONFIG_SECOND_PRIORITY_TASK_WEIGHT, QUEUE_CONFIG_THIRD_PRIORITY_TASK_WEIGHT};
    private static AtomicBoolean disableElasticExecutor = new AtomicBoolean(false);
    private static volatile boolean elasticThreadInitiated = false;
    private static volatile boolean elasticConfigUpdated = false;
    private static final Object elasticConfigMutex = new Object();

    public static Object getElasticConfigMutex() {
        return elasticConfigMutex;
    }

    public static void setElasticThreadInitiated(boolean z) {
        synchronized (elasticConfigMutex) {
            elasticThreadInitiated = z;
        }
    }

    public static void updateConfig() {
        Context appContext = AppContextHolder.getAppContext();
        if (appContext != null) {
            synchronized (elasticConfigMutex) {
                if (!elasticThreadInitiated) {
                    if (!elasticConfigUpdated) {
                        updateFromConfigFile(appContext);
                        elasticConfigUpdated = true;
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [225=4] */
    private static void updateFromConfigFile(Context context) {
        BufferedReader bufferedReader;
        File file = new File(context.getFilesDir().getAbsolutePath() + File.separator + ELASTIC_CONFIG_FILE_DIR + File.separator + ELASTIC_CONFIG_FILE_NAME);
        if (!file.exists()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                } catch (IOException e) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            return;
                        } catch (IOException e2) {
                            return;
                        }
                    }
                    return;
                } catch (Throwable th) {
                    bufferedReader2 = bufferedReader;
                    th = th;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                }
            }
            try {
                updateElasticConfig(context, new JSONObject(sb.toString()));
            } catch (JSONException e5) {
            }
        } catch (IOException e6) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void updateElasticConfig(Context context, JSONObject jSONObject) {
        if (!checkConfigDataVersion(context, jSONObject)) {
            deleteConfigFile(context);
            return;
        }
        updateElasticCloudSwitch(TextUtils.equals(jSONObject.optString(UPDATE_DISABLE_ELASTIC), "1"));
        JSONObject optJSONObject = jSONObject.optJSONObject("thread_pool_size");
        if (optJSONObject != null) {
            ARTERY_CONFIG_UI_CORE_POOL_SIZE = optJSONObject.optInt("first_artery", ARTERY_CONFIG_UI_CORE_POOL_SIZE);
            ARTERY_CONFIG_INTIME_CORE_POOL_SIZE = optJSONObject.optInt("second_artery", ARTERY_CONFIG_INTIME_CORE_POOL_SIZE);
            ARTERY_CONFIG_BACKGROUND_CORE_POOL_SIZE = optJSONObject.optInt("third_artery", ARTERY_CONFIG_BACKGROUND_CORE_POOL_SIZE);
            DREDGE_CONFIG_FIRST_CORE_POOL_SIZE = optJSONObject.optInt("first_dredge", DREDGE_CONFIG_FIRST_CORE_POOL_SIZE);
            DREDGE_CONFIG_SECOND_CORE_POOL_SIZE = optJSONObject.optInt("second_dredge", DREDGE_CONFIG_SECOND_CORE_POOL_SIZE);
            DREDGE_CONFIG_DISASTER_MAX_POOL_SIZE = optJSONObject.optInt("third_dredge", DREDGE_CONFIG_DISASTER_MAX_POOL_SIZE);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("dredge_config");
        if (optJSONObject2 != null) {
            DREDGE_CONFIG_DOWNGRADE_THRESHOLD = optJSONObject2.optDouble("downgrade_threshold", DREDGE_CONFIG_DOWNGRADE_THRESHOLD);
            DREDGE_CONFIG_UPGRADE_THRESHOLD = optJSONObject2.optDouble("upgrade_threshold", DREDGE_CONFIG_UPGRADE_THRESHOLD);
            DREDGE_CONFIG_UPGRADE_RIGHT_AWAY_THRESHOLD = optJSONObject2.optDouble("upgrade_ra_threshold", DREDGE_CONFIG_UPGRADE_RIGHT_AWAY_THRESHOLD);
            DREDGE_CONFIG_DOWNGRADE_STRATEGY_PROTECTION_TIME = optJSONObject2.optLong("downgrade_protect_time", DREDGE_CONFIG_DOWNGRADE_STRATEGY_PROTECTION_TIME);
            DREDGE_CONFIG_UPGRADE_STRATEGY_PROTECTION_TIME = optJSONObject2.optLong("upgrade_protect_time", DREDGE_CONFIG_UPGRADE_STRATEGY_PROTECTION_TIME);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("block_weight");
        if (optJSONObject3 != null) {
            QUEUE_CONFIG_FIRST_PRIORITY_TASK_WEIGHT = optJSONObject3.optDouble(Config.TRACE_VISIT_FIRST, QUEUE_CONFIG_FIRST_PRIORITY_TASK_WEIGHT);
            QUEUE_CONFIG_SECOND_PRIORITY_TASK_WEIGHT = optJSONObject3.optDouble("second", QUEUE_CONFIG_SECOND_PRIORITY_TASK_WEIGHT);
            QUEUE_CONFIG_THIRD_PRIORITY_TASK_WEIGHT = optJSONObject3.optDouble("third", QUEUE_CONFIG_THIRD_PRIORITY_TASK_WEIGHT);
            ELASTIC_QUEUE_BLOCK_WEIGHT = new double[]{QUEUE_CONFIG_IMMEDIATE_PRIORITY_TASK_WEIGHT, QUEUE_CONFIG_FIRST_PRIORITY_TASK_WEIGHT, QUEUE_CONFIG_SECOND_PRIORITY_TASK_WEIGHT, QUEUE_CONFIG_THIRD_PRIORITY_TASK_WEIGHT};
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("serial_config");
        if (optJSONObject4 != null) {
            ENABLE_SERIAL_DREDGE = optJSONObject4.optBoolean("enable_dredge", ENABLE_SERIAL_DREDGE);
            SERIAL_BLOCK_TIME_THRESHOLD = optJSONObject4.optLong("block_threshold", SERIAL_BLOCK_TIME_THRESHOLD);
        }
    }

    private static boolean checkConfigDataVersion(Context context, JSONObject jSONObject) {
        int versionCode = getVersionCode(context);
        return ((long) versionCode) >= ((long) jSONObject.optInt("min_version", 0)) && ((long) versionCode) <= ((long) jSONObject.optInt("max_version", ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
    }

    private static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return 0;
        }
    }

    private static void deleteConfigFile(Context context) {
        new File(context.getFilesDir().getAbsolutePath() + File.separator + ELASTIC_CONFIG_FILE_DIR + File.separator + ELASTIC_CONFIG_FILE_NAME).delete();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [452=4] */
    public static void saveConfigFile(String str) {
        Context appContext;
        FileWriter fileWriter;
        if (AppContextHolder.getAppContext() == null) {
            Log.w(TAG, "saveConfigFile is called while sAppContext is null. Just return");
        } else if (TextUtils.isEmpty(str)) {
        } else {
            synchronized (elasticConfigMutex) {
                String str2 = appContext.getFilesDir().getAbsolutePath() + File.separator + ELASTIC_CONFIG_FILE_DIR;
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(str2 + File.separator + ELASTIC_CONFIG_FILE_NAME);
                if (file2.exists()) {
                    file2.delete();
                }
                FileWriter fileWriter2 = null;
                try {
                    file2.createNewFile();
                    fileWriter = new FileWriter(file2);
                } catch (IOException e) {
                    fileWriter = null;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    fileWriter.write(str);
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (IOException e3) {
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (Throwable th2) {
                    fileWriter2 = fileWriter;
                    th = th2;
                    if (fileWriter2 != null) {
                        try {
                            fileWriter2.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            }
        }
    }

    public static void updateElasticCloudSwitch(boolean z) {
        disableElasticExecutor.set(z);
    }

    public static boolean elasticExecutorDisabled() {
        return disableElasticExecutor.get();
    }
}
