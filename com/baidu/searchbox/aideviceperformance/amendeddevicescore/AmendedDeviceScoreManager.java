package com.baidu.searchbox.aideviceperformance.amendeddevicescore;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ai.AlgorithmType;
import com.baidu.searchbox.ai.InferenceException;
import com.baidu.searchbox.ai.Tensor;
import com.baidu.searchbox.aideviceperformance.inference.DevicePerformanceModelInfo;
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
public class AmendedDeviceScoreManager implements IAmendedDeviceScoreManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String SP_KEY_AMENDED_DEVICE_SCORE = "amended_device_score";
    public static final String SP_KEY_AMENDED_DEVICE_SCORE_MODEL_VERSION = "amended_device_score_model_version";
    public static final String SP_KEY_AMENDED_DEVICE_SCORE_TIME = "amended_device_score_time";
    public static final String TAG = "AmendedDeviceScore";
    public static float amendedDeviceScoreCache;
    public transient /* synthetic */ FieldHolder $fh;
    public ModelManager mModelManager;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-547446586, "Lcom/baidu/searchbox/aideviceperformance/amendeddevicescore/AmendedDeviceScoreManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-547446586, "Lcom/baidu/searchbox/aideviceperformance/amendeddevicescore/AmendedDeviceScoreManager;");
                return;
            }
        }
        DEBUG = Config.isDebug();
        amendedDeviceScoreCache = -1.0f;
    }

    @Override // com.baidu.searchbox.aideviceperformance.amendeddevicescore.IAmendedDeviceScoreManager
    public long getModelVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                InferenceWrapper inferenceWrapper = new InferenceWrapper();
                DevicePerformanceModelInfo devicePerformanceModelInfo = ModelManager.getDevicePerformanceModelInfo(ModelInfoDataProvider.DevicePerformanceModelInfoType.AmendedDeviceScore);
                boolean innerCheck = inferenceWrapper.innerCheck(AlgorithmType.GLM_REGRESSOR, devicePerformanceModelInfo);
                if (devicePerformanceModelInfo == null || !innerCheck) {
                    return -1L;
                }
                return devicePerformanceModelInfo.versionCode;
            } catch (ModelLoadException unused) {
                return -1L;
            }
        }
        return invokeV.longValue;
    }

    public AmendedDeviceScoreManager(IAmendedDeviceScoreModelProvider iAmendedDeviceScoreModelProvider) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iAmendedDeviceScoreModelProvider};
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
        modelManager.setModelInfoProvider(iAmendedDeviceScoreModelProvider, ModelInfoDataProvider.DevicePerformanceModelInfoType.AmendedDeviceScore);
    }

    private void postCheckAmendedStaticScoreStore(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            ExecutorUtilsExt.delayPostOnElastic(new Runnable(this, context) { // from class: com.baidu.searchbox.aideviceperformance.amendeddevicescore.AmendedDeviceScoreManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AmendedDeviceScoreManager this$0;
                public final /* synthetic */ Context val$cx;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context};
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
                    this.val$cx = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                        return;
                    }
                    this.this$0.updateAmendedDeviceScore(this.val$cx);
                }
            }, "postCheckAmendedDeviceScoreStore", 3, 5000L);
        }
    }

    private void postStaticScoreStore(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65541, this, f) == null) {
            ExecutorUtilsExt.delayPostOnElastic(new Runnable(this, f) { // from class: com.baidu.searchbox.aideviceperformance.amendeddevicescore.AmendedDeviceScoreManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AmendedDeviceScoreManager this$0;
                public final /* synthetic */ float val$amendedDeviceScore;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Float.valueOf(f)};
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
                    this.val$amendedDeviceScore = f;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        DeviceInfoSharedPreferenceWrapper.getInstance().putFloat(AmendedDeviceScoreManager.SP_KEY_AMENDED_DEVICE_SCORE, this.val$amendedDeviceScore);
                        long modelVersion = this.this$0.getModelVersion();
                        DeviceInfoSharedPreferenceWrapper.getInstance().putLong(AmendedDeviceScoreManager.SP_KEY_AMENDED_DEVICE_SCORE_MODEL_VERSION, modelVersion);
                        DeviceInfoSharedPreferenceWrapper.getInstance().putLong(AmendedDeviceScoreManager.SP_KEY_AMENDED_DEVICE_SCORE_TIME, System.currentTimeMillis());
                        if (AmendedDeviceScoreManager.DEBUG) {
                            Log.d(AmendedDeviceScoreManager.TAG, "save amended device score sp ## model version:" + modelVersion + " ## score:" + this.val$amendedDeviceScore);
                        }
                    }
                }
            }, "postStaticScoreStore", 3, 5000L);
        }
    }

    private float predictByLRModel(Context context) {
        InterceptResult invokeL;
        InferenceWrapper inferenceWrapper;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, context)) == null) {
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
                inferenceWrapper.init(AlgorithmType.GLM_REGRESSOR, ModelManager.getDevicePerformanceModelInfo(ModelInfoDataProvider.DevicePerformanceModelInfoType.AmendedDeviceScore));
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
                return -3.0f;
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
                return -2.0f;
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
                return -4.0f;
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateAmendedDeviceScore(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, context)) == null) {
            long j = DeviceInfoSharedPreferenceWrapper.getInstance().getLong(SP_KEY_AMENDED_DEVICE_SCORE_TIME, -1L);
            if (System.currentTimeMillis() > j && System.currentTimeMillis() - j < 604800000) {
                if (DEBUG) {
                    Log.d(TAG, "amended device score cache hasn't expired.");
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
            DeviceInfoSharedPreferenceWrapper.getInstance().putFloat(SP_KEY_AMENDED_DEVICE_SCORE, predictByLRModel);
            if (DEBUG) {
                Log.d(TAG, "amended device score updated.  amendedDeviceScore:" + predictByLRModel);
            }
            DeviceInfoSharedPreferenceWrapper.getInstance().putLong(SP_KEY_AMENDED_DEVICE_SCORE_TIME, System.currentTimeMillis());
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.aideviceperformance.amendeddevicescore.IAmendedDeviceScoreManager
    public float getAmendedDeviceScore(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (amendedDeviceScoreCache >= 0.0f) {
                if (DEBUG) {
                    Log.d(TAG, "get amended device score from mem cache : " + amendedDeviceScoreCache);
                }
                return amendedDeviceScoreCache;
            }
            float f = DeviceInfoSharedPreferenceWrapper.getInstance().getFloat(SP_KEY_AMENDED_DEVICE_SCORE, -1.0f);
            if (f >= 0.0f) {
                if (DEBUG) {
                    Log.d(TAG, "get amended device score from file cache : " + f);
                }
                amendedDeviceScoreCache = f;
                postCheckAmendedStaticScoreStore(context);
                return amendedDeviceScoreCache;
            }
            if (f == -1.0f) {
                this.mModelManager.checkAndUpdatePresetModel();
            }
            float predictByLRModel = predictByLRModel(context);
            if (predictByLRModel < 0.0f) {
                return -1.0f;
            }
            if (DEBUG) {
                Log.d(TAG, "get amended device score from model : " + predictByLRModel);
            }
            amendedDeviceScoreCache = predictByLRModel;
            postStaticScoreStore(predictByLRModel);
            return predictByLRModel;
        }
        return invokeL.floatValue;
    }
}
