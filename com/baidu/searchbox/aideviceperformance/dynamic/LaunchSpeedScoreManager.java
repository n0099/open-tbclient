package com.baidu.searchbox.aideviceperformance.dynamic;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ai.AlgorithmType;
import com.baidu.searchbox.ai.InferenceException;
import com.baidu.searchbox.ai.Tensor;
import com.baidu.searchbox.aideviceperformance.data.LaunchTimeSQLiteOpenHelper;
import com.baidu.searchbox.aideviceperformance.inference.InferenceWrapper;
import com.baidu.searchbox.aideviceperformance.inference.ModelLoadException;
import com.baidu.searchbox.aideviceperformance.model.ModelInfoDataProvider;
import com.baidu.searchbox.aideviceperformance.model.ModelManager;
import com.baidu.searchbox.aideviceperformance.utils.Config;
import com.baidu.searchbox.aideviceperformance.utils.DeviceInfoSharedPreferenceWrapper;
import com.baidu.searchbox.aideviceperformance.utils.LaunchSpeedReadUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.FloatBuffer;
/* loaded from: classes2.dex */
public class LaunchSpeedScoreManager implements ILaunchSpeedScoreManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String SP_KEY_LAUNCH_SCORE_TIME = "launch_speed_score_time";
    public static final String SP_KEY_LAUNCH_SPEED_SCORE = "launch_speed_score";
    public static final String TAG = "LaunchSpeedScore";
    public static final float UPDATE_SCORE_THRESHOLD = 0.03f;
    public transient /* synthetic */ FieldHolder $fh;
    public ModelManager mModelManager;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(575018579, "Lcom/baidu/searchbox/aideviceperformance/dynamic/LaunchSpeedScoreManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(575018579, "Lcom/baidu/searchbox/aideviceperformance/dynamic/LaunchSpeedScoreManager;");
                return;
            }
        }
        DEBUG = Config.isDebug();
    }

    public LaunchSpeedScoreManager(IDynamicModelProvider iDynamicModelProvider) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iDynamicModelProvider};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ModelManager modelManager = new ModelManager();
        this.mModelManager = modelManager;
        modelManager.setModelInfoProvider(iDynamicModelProvider, ModelInfoDataProvider.DevicePerformanceModelInfoType.DynamicLR);
    }

    private float predictByLRModel(Context context) {
        InterceptResult invokeL;
        InferenceWrapper inferenceWrapper;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, context)) == null) {
            float calculateAverageLaunchTime = new LaunchSpeedReadUtil().calculateAverageLaunchTime(context);
            if (calculateAverageLaunchTime == -1.0f) {
                return -1.0f;
            }
            InferenceWrapper inferenceWrapper2 = null;
            try {
                inferenceWrapper = new InferenceWrapper();
            } catch (InferenceException unused) {
            } catch (ModelLoadException unused2) {
            } catch (IllegalStateException unused3) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                long currentTimeMillis = System.currentTimeMillis();
                inferenceWrapper.init(AlgorithmType.GLM_REGRESSOR, ModelManager.getDevicePerformanceModelInfo(ModelInfoDataProvider.DevicePerformanceModelInfoType.DynamicLR));
                if (DEBUG) {
                    Log.d(TAG, "MML Load Time: " + (System.currentTimeMillis() - currentTimeMillis));
                }
                double d = calculateAverageLaunchTime;
                Tensor createInstance = Tensor.createInstance(new long[]{4}, FloatBuffer.wrap(new float[]{calculateAverageLaunchTime, (float) Math.pow(d, 2.0d), (float) Math.pow(d, 3.0d), (float) Math.pow(d, 4.0d)}));
                long currentTimeMillis2 = System.currentTimeMillis();
                Float f = (Float) inferenceWrapper.predictForRegressorTarget(createInstance, 0.5f, Float.class);
                if (DEBUG) {
                    Log.d(TAG, "predict Time: " + (System.currentTimeMillis() - currentTimeMillis2));
                    Log.d(TAG, "predictByLRModel Result: " + f);
                }
                if (f.floatValue() < 0.0f) {
                    f = Float.valueOf(0.0f);
                }
                if (f.floatValue() > 1.0f) {
                    f = Float.valueOf(1.0f);
                }
                float floatValue = f.floatValue();
                try {
                    inferenceWrapper.close();
                } catch (Exception e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                return floatValue;
            } catch (InferenceException unused4) {
                inferenceWrapper2 = inferenceWrapper;
                if (inferenceWrapper2 != null) {
                    try {
                        inferenceWrapper2.close();
                    } catch (Exception e2) {
                        if (DEBUG) {
                            e2.printStackTrace();
                        }
                    }
                }
                return -1.0f;
            } catch (ModelLoadException unused5) {
                inferenceWrapper2 = inferenceWrapper;
                if (inferenceWrapper2 != null) {
                    try {
                        inferenceWrapper2.close();
                    } catch (Exception e3) {
                        if (DEBUG) {
                            e3.printStackTrace();
                        }
                    }
                }
                return -1.0f;
            } catch (IllegalStateException unused6) {
                inferenceWrapper2 = inferenceWrapper;
                if (inferenceWrapper2 != null) {
                    try {
                        inferenceWrapper2.close();
                    } catch (Exception e4) {
                        if (DEBUG) {
                            e4.printStackTrace();
                        }
                    }
                }
                return -1.0f;
            } catch (Throwable th2) {
                th = th2;
                inferenceWrapper2 = inferenceWrapper;
                if (inferenceWrapper2 != null) {
                    try {
                        inferenceWrapper2.close();
                    } catch (Exception e5) {
                        if (DEBUG) {
                            e5.printStackTrace();
                        }
                    }
                }
                throw th;
            }
        }
        return invokeL.floatValue;
    }

    @Override // com.baidu.searchbox.aideviceperformance.dynamic.ILaunchSpeedScoreManager
    public float getLaunchSpeedScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            float f = DeviceInfoSharedPreferenceWrapper.getInstance().getFloat(SP_KEY_LAUNCH_SPEED_SCORE, -1.0f);
            if (DEBUG) {
                Log.d(TAG, "getLaunchSpeedScore : " + f);
            }
            return f;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.searchbox.aideviceperformance.dynamic.ILaunchSpeedScoreManager
    public void putLaunchSpeedData(Context context, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            ExecutorUtilsExt.postOnElastic(new Runnable(this, j, j2, context) { // from class: com.baidu.searchbox.aideviceperformance.dynamic.LaunchSpeedScoreManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LaunchSpeedScoreManager this$0;
                public final /* synthetic */ Context val$cx;
                public final /* synthetic */ long val$launchTime;
                public final /* synthetic */ long val$timestamp;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j), Long.valueOf(j2), context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$launchTime = j;
                    this.val$timestamp = j2;
                    this.val$cx = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("app_launch_time", Long.valueOf(this.val$launchTime));
                        contentValues.put("event_time", Long.valueOf(this.val$timestamp));
                        LaunchTimeSQLiteOpenHelper.getInstance(this.val$cx).insert(contentValues);
                        this.this$0.updateLaunchSpeedScore(this.val$cx);
                        if (LaunchSpeedScoreManager.DEBUG) {
                            Log.d(LaunchSpeedScoreManager.TAG, "putLaunchSpeedData : " + this.val$launchTime);
                        }
                    }
                }
            }, "putLaunchSpeedData", 2);
        }
    }

    public boolean updateLaunchSpeedScore(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            long j = DeviceInfoSharedPreferenceWrapper.getInstance().getLong(SP_KEY_LAUNCH_SCORE_TIME, -1L);
            if (System.currentTimeMillis() > j && System.currentTimeMillis() - j < 604800000) {
                if (DEBUG) {
                    Log.d(TAG, "launch speed score cache hasn't expired.");
                }
                return false;
            }
            this.mModelManager.checkAndUpdatePresetModel();
            float predictByLRModel = predictByLRModel(context);
            if (predictByLRModel < 0.0f) {
                if (DEBUG) {
                    Log.d(TAG, "predictByLRModel return invalid value");
                }
                return false;
            }
            float f = DeviceInfoSharedPreferenceWrapper.getInstance().getFloat(SP_KEY_LAUNCH_SPEED_SCORE, -1.0f);
            if (Math.abs(predictByLRModel - f) > 0.03f) {
                DeviceInfoSharedPreferenceWrapper.getInstance().putFloat(SP_KEY_LAUNCH_SPEED_SCORE, predictByLRModel);
                if (DEBUG) {
                    Log.d(TAG, "launch speed score updated.  launchSpeedScore:" + predictByLRModel);
                }
            } else if (DEBUG) {
                Log.d(TAG, "launch speed score diff insignificant : launchSpeedScore:" + predictByLRModel + "  launchSpeedScoreCache:" + f);
            }
            DeviceInfoSharedPreferenceWrapper.getInstance().putLong(SP_KEY_LAUNCH_SCORE_TIME, System.currentTimeMillis());
            return true;
        }
        return invokeL.booleanValue;
    }
}
