package com.baidu.searchbox.elasticthread;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.app.statistic.c;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static int ARTERY_CONFIG_BACKGROUND_CORE_POOL_SIZE = 0;
    public static int ARTERY_CONFIG_INTIME_CORE_POOL_SIZE = 0;
    public static int ARTERY_CONFIG_UI_CORE_POOL_SIZE = 0;
    public static final boolean DEBUG = false;
    public static int DREDGE_CONFIG_DISASTER_MAX_POOL_SIZE = 0;
    public static long DREDGE_CONFIG_DOWNGRADE_STRATEGY_PROTECTION_TIME = 0;
    public static double DREDGE_CONFIG_DOWNGRADE_THRESHOLD = 0.0d;
    public static int DREDGE_CONFIG_FIRST_CORE_POOL_SIZE = 0;
    public static int DREDGE_CONFIG_SECOND_CORE_POOL_SIZE = 0;
    public static double DREDGE_CONFIG_UPGRADE_RIGHT_AWAY_THRESHOLD = 0.0d;
    public static long DREDGE_CONFIG_UPGRADE_STRATEGY_PROTECTION_TIME = 0;
    public static double DREDGE_CONFIG_UPGRADE_THRESHOLD = 0.0d;
    public static final String ELASTIC_CONFIG_FILE_DIR = "elastic_config";
    public static final String ELASTIC_CONFIG_FILE_NAME = "config_data";
    public static double[] ELASTIC_QUEUE_BLOCK_WEIGHT = null;
    public static final int[] ELASTIC_QUEUE_INDEX_PRIORITY_TABLE;
    public static final int ELASTIC_QUEUE_NUM = 4;
    public static boolean ENABLE_REAL_TIME_PRINTER = false;
    public static boolean ENABLE_SERIAL_DREDGE = false;
    public static long EXECUTOR_CONFIG_KEEP_ALIVE_TIME = 0;
    public static int EXECUTOR_CONFIG_THREAD_PRIORITY_BACKGROUND = 0;
    public static int EXECUTOR_CONFIG_THREAD_PRIORITY_IMMEDIATE = 0;
    public static int EXECUTOR_CONFIG_THREAD_PRIORITY_INTIME = 0;
    public static int EXECUTOR_CONFIG_THREAD_PRIORITY_SERIAL = 0;
    public static int EXECUTOR_CONFIG_THREAD_PRIORITY_USER_RELATED = 0;
    public static double QUEUE_CONFIG_FIRST_PRIORITY_TASK_WEIGHT = 0.0d;
    public static double QUEUE_CONFIG_IMMEDIATE_PRIORITY_TASK_WEIGHT = 0.0d;
    public static double QUEUE_CONFIG_SECOND_PRIORITY_TASK_WEIGHT = 0.0d;
    public static double QUEUE_CONFIG_THIRD_PRIORITY_TASK_WEIGHT = 0.0d;
    public static long REAL_TIME_PRINTER_INTERVAL = 0;
    public static long SERIAL_BLOCK_TIME_THRESHOLD = 0;
    public static final String TAG = "ElasticConfig";
    public static final String UPDATE_DISABLE_ELASTIC = "disable_elastic";
    public static AtomicBoolean disableElasticExecutor;
    public static final Object elasticConfigMutex;
    public static volatile boolean elasticConfigUpdated;
    public static volatile boolean elasticThreadInitiated;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2073467822, "Lcom/baidu/searchbox/elasticthread/ElasticConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2073467822, "Lcom/baidu/searchbox/elasticthread/ElasticConfig;");
                return;
            }
        }
        ELASTIC_QUEUE_INDEX_PRIORITY_TABLE = new int[]{0, 1, 2, 3};
        EXECUTOR_CONFIG_THREAD_PRIORITY_IMMEDIATE = 9;
        EXECUTOR_CONFIG_THREAD_PRIORITY_USER_RELATED = 7;
        EXECUTOR_CONFIG_THREAD_PRIORITY_INTIME = 5;
        EXECUTOR_CONFIG_THREAD_PRIORITY_BACKGROUND = 3;
        EXECUTOR_CONFIG_THREAD_PRIORITY_SERIAL = 7;
        EXECUTOR_CONFIG_KEEP_ALIVE_TIME = 1000L;
        ENABLE_REAL_TIME_PRINTER = false;
        REAL_TIME_PRINTER_INTERVAL = 1000L;
        ENABLE_SERIAL_DREDGE = true;
        SERIAL_BLOCK_TIME_THRESHOLD = 2000L;
        ARTERY_CONFIG_UI_CORE_POOL_SIZE = 2;
        ARTERY_CONFIG_INTIME_CORE_POOL_SIZE = 2;
        ARTERY_CONFIG_BACKGROUND_CORE_POOL_SIZE = 6;
        DREDGE_CONFIG_FIRST_CORE_POOL_SIZE = 4;
        DREDGE_CONFIG_SECOND_CORE_POOL_SIZE = 6;
        DREDGE_CONFIG_DISASTER_MAX_POOL_SIZE = 30;
        DREDGE_CONFIG_UPGRADE_THRESHOLD = 10.0d;
        DREDGE_CONFIG_UPGRADE_RIGHT_AWAY_THRESHOLD = 30.0d;
        DREDGE_CONFIG_DOWNGRADE_THRESHOLD = 2.0d;
        DREDGE_CONFIG_UPGRADE_STRATEGY_PROTECTION_TIME = 500L;
        DREDGE_CONFIG_DOWNGRADE_STRATEGY_PROTECTION_TIME = 3000L;
        QUEUE_CONFIG_IMMEDIATE_PRIORITY_TASK_WEIGHT = 999.0d;
        QUEUE_CONFIG_FIRST_PRIORITY_TASK_WEIGHT = 8.0d;
        QUEUE_CONFIG_SECOND_PRIORITY_TASK_WEIGHT = 3.0d;
        QUEUE_CONFIG_THIRD_PRIORITY_TASK_WEIGHT = 1.0d;
        ELASTIC_QUEUE_BLOCK_WEIGHT = new double[]{999.0d, 8.0d, 3.0d, 1.0d};
        disableElasticExecutor = new AtomicBoolean(false);
        elasticThreadInitiated = false;
        elasticConfigUpdated = false;
        elasticConfigMutex = new Object();
    }

    public ElasticConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean checkConfigDataVersion(Context context, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, jSONObject)) == null) {
            long versionCode = getVersionCode(context);
            return versionCode >= ((long) jSONObject.optInt("min_version", 0)) && versionCode <= ((long) jSONObject.optInt("max_version", Integer.MAX_VALUE));
        }
        return invokeLL.booleanValue;
    }

    public static void deleteConfigFile(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            new File(context.getFilesDir().getAbsolutePath() + File.separator + ELASTIC_CONFIG_FILE_DIR + File.separator + ELASTIC_CONFIG_FILE_NAME).delete();
        }
    }

    public static boolean elasticExecutorDisabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? disableElasticExecutor.get() : invokeV.booleanValue;
    }

    public static Object getElasticConfigMutex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? elasticConfigMutex : invokeV.objValue;
    }

    public static int getVersionCode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static void saveConfigFile(String str) {
        Context appContext;
        FileWriter fileWriter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
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
    }

    public static void setElasticThreadInitiated(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, null, z) == null) {
            synchronized (elasticConfigMutex) {
                elasticThreadInitiated = z;
            }
        }
    }

    public static void updateConfig() {
        Context appContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, null) == null) || (appContext = AppContextHolder.getAppContext()) == null) {
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

    public static void updateElasticCloudSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, null, z) == null) {
            disableElasticExecutor.set(z);
        }
    }

    public static void updateElasticConfig(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, context, jSONObject) == null) {
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
                double optDouble = optJSONObject3.optDouble(c.f1827e, QUEUE_CONFIG_THIRD_PRIORITY_TASK_WEIGHT);
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

    public static void updateFromConfigFile(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65548, null, context) != null) {
            return;
        }
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
}
