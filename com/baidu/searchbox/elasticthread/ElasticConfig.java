package com.baidu.searchbox.elasticthread;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.google.gson.internal.bind.TypeAdapters;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class ElasticConfig {
    public static final boolean DEBUG = false;
    public static final String ELASTIC_CONFIG_FILE_DIR = "elastic_config";
    public static final String ELASTIC_CONFIG_FILE_NAME = "config_data";
    public static final int ELASTIC_QUEUE_NUM = 4;
    public static final String TAG = "ElasticConfig";
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
    public static long DREDGE_CONFIG_DOWNGRADE_STRATEGY_PROTECTION_TIME = 3000;
    public static double QUEUE_CONFIG_IMMEDIATE_PRIORITY_TASK_WEIGHT = 999.0d;
    public static double QUEUE_CONFIG_FIRST_PRIORITY_TASK_WEIGHT = 8.0d;
    public static double QUEUE_CONFIG_SECOND_PRIORITY_TASK_WEIGHT = 3.0d;
    public static double QUEUE_CONFIG_THIRD_PRIORITY_TASK_WEIGHT = 1.0d;
    public static double[] ELASTIC_QUEUE_BLOCK_WEIGHT = {999.0d, 8.0d, 3.0d, 1.0d};
    public static AtomicBoolean disableElasticExecutor = new AtomicBoolean(false);
    public static volatile boolean elasticThreadInitiated = false;
    public static volatile boolean elasticConfigUpdated = false;
    public static final Object elasticConfigMutex = new Object();

    public static boolean elasticExecutorDisabled() {
        return disableElasticExecutor.get();
    }

    public static Object getElasticConfigMutex() {
        return elasticConfigMutex;
    }

    public static void updateConfig() {
        Context appContext = AppContextHolder.getAppContext();
        if (appContext == null) {
            return;
        }
        synchronized (elasticConfigMutex) {
            if (elasticThreadInitiated) {
                return;
            }
            if (elasticConfigUpdated) {
                return;
            }
            updateFromConfigFile(appContext);
            elasticConfigUpdated = true;
        }
    }

    public static boolean checkConfigDataVersion(Context context, JSONObject jSONObject) {
        int versionCode = getVersionCode(context);
        long optInt = jSONObject.optInt("max_version", Integer.MAX_VALUE);
        long j = versionCode;
        if (j < jSONObject.optInt("min_version", 0) || j > optInt) {
            return false;
        }
        return true;
    }

    public static void deleteConfigFile(Context context) {
        new File(context.getFilesDir().getAbsolutePath() + File.separator + ELASTIC_CONFIG_FILE_DIR + File.separator + ELASTIC_CONFIG_FILE_NAME).delete();
    }

    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    public static void setElasticThreadInitiated(boolean z) {
        synchronized (elasticConfigMutex) {
            elasticThreadInitiated = z;
        }
    }

    public static void updateElasticCloudSwitch(boolean z) {
        disableElasticExecutor.set(z);
    }

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
                    try {
                        file2.createNewFile();
                        fileWriter = new FileWriter(file2);
                    } catch (IOException unused) {
                    }
                } catch (IOException unused2) {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    fileWriter.write(str);
                    fileWriter.close();
                } catch (IOException unused3) {
                    fileWriter2 = fileWriter;
                    if (fileWriter2 != null) {
                        fileWriter2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileWriter2 = fileWriter;
                    if (fileWriter2 != null) {
                        try {
                            fileWriter2.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            }
        }
    }

    public static void updateFromConfigFile(Context context) {
        File file = new File(context.getFilesDir().getAbsolutePath() + File.separator + ELASTIC_CONFIG_FILE_DIR + File.separator + ELASTIC_CONFIG_FILE_NAME);
        if (!file.exists()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        try {
                            break;
                        } catch (IOException unused) {
                        }
                    }
                } catch (IOException unused2) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            return;
                        } catch (IOException unused3) {
                            return;
                        }
                    }
                    return;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            }
            bufferedReader2.close();
            try {
                updateElasticConfig(context, new JSONObject(sb.toString()));
            } catch (JSONException unused5) {
            }
        } catch (IOException unused6) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void updateElasticConfig(Context context, JSONObject jSONObject) {
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
            QUEUE_CONFIG_SECOND_PRIORITY_TASK_WEIGHT = optJSONObject3.optDouble(TypeAdapters.AnonymousClass27.SECOND, QUEUE_CONFIG_SECOND_PRIORITY_TASK_WEIGHT);
            double optDouble = optJSONObject3.optDouble("third", QUEUE_CONFIG_THIRD_PRIORITY_TASK_WEIGHT);
            QUEUE_CONFIG_THIRD_PRIORITY_TASK_WEIGHT = optDouble;
            ELASTIC_QUEUE_BLOCK_WEIGHT = new double[]{QUEUE_CONFIG_IMMEDIATE_PRIORITY_TASK_WEIGHT, QUEUE_CONFIG_FIRST_PRIORITY_TASK_WEIGHT, QUEUE_CONFIG_SECOND_PRIORITY_TASK_WEIGHT, optDouble};
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("serial_config");
        if (optJSONObject4 != null) {
            ENABLE_SERIAL_DREDGE = optJSONObject4.optBoolean("enable_dredge", ENABLE_SERIAL_DREDGE);
            SERIAL_BLOCK_TIME_THRESHOLD = optJSONObject4.optLong("block_threshold", SERIAL_BLOCK_TIME_THRESHOLD);
        }
    }
}
