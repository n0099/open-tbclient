package com.baidu.searchbox.aideviceperformance.device;

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
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.FloatBuffer;
/* loaded from: classes4.dex */
public class DeviceScoreModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final float DEFAULT_CPU_FREQUENCY = 1.7859616f;
    public static final float DEFAULT_CPU_NUMBER = 6.9822063f;
    public static final float DEFAULT_MEM_SIZE = 3.5425532f;
    public static final float DEFAULT_ROM_SIZE = 51.957294f;
    public static final float DEFAULT_SCREEN_DENSITY = 375.48398f;
    public static final float DEFAULT_SCREEN_RESOLUTION = 1904175.1f;
    public static final int MAPPER_POW_INDEX = 8;
    public static final String TAG = "DeviceScore-GBDT";
    public static final float WEIGHT_CPU_ABILITY = 0.01155649f;
    public static final float WEIGHT_LR_OFFSET = -0.0231852f;
    public static final float WEIGHT_MEM_SIZE = 0.0572301f;
    public static final float WEIGHT_ROM_SIZE = 4.1613E-4f;
    public transient /* synthetic */ FieldHolder $fh;
    public ModelManager mModelManager;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-650500596, "Lcom/baidu/searchbox/aideviceperformance/device/DeviceScoreModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-650500596, "Lcom/baidu/searchbox/aideviceperformance/device/DeviceScoreModel;");
                return;
            }
        }
        DEBUG = Config.isDebug();
    }

    public DeviceScoreModel(IDeviceInfoModelProvider iDeviceInfoModelProvider) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iDeviceInfoModelProvider};
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
        modelManager.setModelInfoProvider(iDeviceInfoModelProvider, ModelInfoDataProvider.DevicePerformanceModelInfoType.DeviceInfoGBDT);
        this.mModelManager.setModelInfoProvider(iDeviceInfoModelProvider, ModelInfoDataProvider.DevicePerformanceModelInfoType.DeviceInfoLR);
        this.mModelManager.setModelInfoProvider(iDeviceInfoModelProvider, ModelInfoDataProvider.DevicePerformanceModelInfoType.DeviceInfoMapper);
    }

    public static float mergeScore(float f2, float f3) {
        InterceptResult invokeCommon;
        float f4;
        float f5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float abs = Math.abs(f2 - f3);
            if (abs < 0.05f) {
                f4 = f2 * 0.8f;
                f5 = f3 * 0.2f;
            } else if (abs < 0.1f) {
                f4 = f2 * 0.6f;
                f5 = f3 * 0.4f;
            } else if (abs < 0.15f) {
                f4 = f2 * 0.4f;
                f5 = f3 * 0.6f;
            } else if (abs >= 0.2f) {
                return f3;
            } else {
                f4 = f2 * 0.2f;
                f5 = f3 * 0.8f;
            }
            return f4 + f5;
        }
        return invokeCommon.floatValue;
    }

    public static float predictByLRInline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            float numCores = HardwareInfoUtils.getNumCores();
            float aveCpuFrequency = HardwareInfoUtils.getAveCpuFrequency();
            float totalMemory = HardwareInfoUtils.getTotalMemory();
            float totalSDCardSize = HardwareInfoUtils.getTotalSDCardSize();
            if (numCores <= 0.0f) {
                numCores = 6.9822063f;
            }
            if (aveCpuFrequency <= 0.0f) {
                aveCpuFrequency = 1.7859616f;
            }
            if (totalMemory <= 0.0f) {
                totalMemory = 3.5425532f;
            }
            if (totalSDCardSize < 0.0f) {
                totalSDCardSize = 51.957294f;
            }
            float round = (((Math.round(totalMemory) * 0.0572301f) + (roundUpRom(totalSDCardSize) * 4.1613E-4f)) + ((Math.round(numCores) * aveCpuFrequency) * 0.01155649f)) - (-0.0231852f);
            if (DEBUG) {
                Log.d(TAG, "predictByLRInline Result: " + round);
            }
            float f2 = round >= 0.0f ? round : 0.0f;
            if (f2 > 1.0f) {
                return 1.0f;
            }
            return f2;
        }
        return invokeV.floatValue;
    }

    public static float roundUpRom(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(InputDeviceCompat.SOURCE_TRACKBALL, null, f2)) == null) {
            int i = 1;
            while (f2 > i * 1.5d && (i = i << 1) <= 268435456) {
            }
            return i;
        }
        return invokeF.floatValue;
    }

    public void checkAndUpdatePresetModel() {
        ModelManager modelManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (modelManager = this.mModelManager) == null) {
            return;
        }
        modelManager.checkAndUpdatePresetModel();
    }

    public long getGBDTVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                InferenceWrapper inferenceWrapper = new InferenceWrapper();
                DevicePerformanceModelInfo devicePerformanceModelInfo = ModelManager.getDevicePerformanceModelInfo(ModelInfoDataProvider.DevicePerformanceModelInfoType.DeviceInfoGBDT);
                boolean innerCheck = inferenceWrapper.innerCheck(AlgorithmType.GBDT_REGRESSOR, devicePerformanceModelInfo);
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

    public long getLRVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                InferenceWrapper inferenceWrapper = new InferenceWrapper();
                DevicePerformanceModelInfo devicePerformanceModelInfo = ModelManager.getDevicePerformanceModelInfo(ModelInfoDataProvider.DevicePerformanceModelInfoType.DeviceInfoLR);
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

    public long getMapperVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                InferenceWrapper inferenceWrapper = new InferenceWrapper();
                DevicePerformanceModelInfo devicePerformanceModelInfo = ModelManager.getDevicePerformanceModelInfo(ModelInfoDataProvider.DevicePerformanceModelInfoType.DeviceInfoMapper);
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

    public float mapStaticScore(float f2) {
        InterceptResult invokeF;
        InferenceWrapper inferenceWrapper;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f2)) == null) {
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
                inferenceWrapper.init(AlgorithmType.GLM_REGRESSOR, ModelManager.getDevicePerformanceModelInfo(ModelInfoDataProvider.DevicePerformanceModelInfoType.DeviceInfoMapper));
                if (DEBUG) {
                    Log.d(TAG, "MODEL_DEVICE_SCORE_MAPPER Load Time: " + (System.currentTimeMillis() - currentTimeMillis));
                }
                float[] fArr = new float[8];
                int i = 0;
                while (i < 8) {
                    int i2 = i + 1;
                    fArr[i] = (float) Math.pow(f2, i2);
                    i = i2;
                }
                Tensor createInstance = Tensor.createInstance(new long[]{8}, FloatBuffer.wrap(fArr));
                long currentTimeMillis2 = System.currentTimeMillis();
                Float f3 = (Float) inferenceWrapper.predictForRegressorTarget(createInstance, 0.5f, Float.class);
                if (DEBUG) {
                    Log.d(TAG, "MODEL_DEVICE_SCORE_MAPPER predict Time: " + (System.currentTimeMillis() - currentTimeMillis2));
                    Log.d(TAG, "MODEL_DEVICE_SCORE_MAPPER Result: " + f3);
                }
                if (f3.floatValue() < 0.0f) {
                    f3 = Float.valueOf(0.0f);
                }
                if (f3.floatValue() > 1.0f) {
                    f3 = Float.valueOf(1.0f);
                }
                float floatValue = f3.floatValue();
                try {
                    inferenceWrapper.close();
                } catch (Exception e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
                return floatValue;
            } catch (InferenceException unused4) {
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
            } catch (ModelLoadException unused5) {
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
            } catch (IllegalStateException unused6) {
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
                return -1.0f;
            } catch (Throwable th2) {
                th = th2;
                inferenceWrapper2 = inferenceWrapper;
                if (inferenceWrapper2 != null) {
                    try {
                        inferenceWrapper2.close();
                    } catch (Exception e6) {
                        if (DEBUG) {
                            e6.printStackTrace();
                        }
                    }
                }
                throw th;
            }
        }
        return invokeF.floatValue;
    }

    public float predictByGBDTModel(float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        InterceptResult invokeCommon;
        InferenceWrapper inferenceWrapper;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8)})) == null) {
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
                inferenceWrapper.init(AlgorithmType.GBDT_REGRESSOR, ModelManager.getDevicePerformanceModelInfo(ModelInfoDataProvider.DevicePerformanceModelInfoType.DeviceInfoGBDT));
                if (DEBUG) {
                    Log.d(TAG, "MODEL_DEVICE_SCORE_GBDT Load Time: " + (System.currentTimeMillis() - currentTimeMillis));
                }
                Tensor createInstance = Tensor.createInstance(new long[]{7}, FloatBuffer.wrap(new float[]{f2, f3, f4, f5, f6, f7, f8}));
                long currentTimeMillis2 = System.currentTimeMillis();
                Float f9 = (Float) inferenceWrapper.predictForRegressorTarget(createInstance, 0.5f, Float.class);
                if (DEBUG) {
                    Log.d(TAG, "MODEL_DEVICE_SCORE_GBDT predict Time: " + (System.currentTimeMillis() - currentTimeMillis2));
                    Log.d(TAG, "MODEL_DEVICE_SCORE_GBDT Result: " + f9);
                }
                if (f9.floatValue() < 0.0f) {
                    f9 = Float.valueOf(0.0f);
                }
                if (f9.floatValue() > 1.0f) {
                    f9 = Float.valueOf(1.0f);
                }
                float floatValue = f9.floatValue();
                try {
                    inferenceWrapper.close();
                } catch (Exception e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
                return floatValue;
            } catch (InferenceException unused4) {
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
            } catch (ModelLoadException unused5) {
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
            } catch (IllegalStateException unused6) {
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
                return -1.0f;
            } catch (Throwable th2) {
                th = th2;
                inferenceWrapper2 = inferenceWrapper;
                if (inferenceWrapper2 != null) {
                    try {
                        inferenceWrapper2.close();
                    } catch (Exception e6) {
                        if (DEBUG) {
                            e6.printStackTrace();
                        }
                    }
                }
                throw th;
            }
        }
        return invokeCommon.floatValue;
    }

    public float predictByLRModel(float f2, float f3, float f4, float f5, float f6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)})) != null) {
            return invokeCommon.floatValue;
        }
        InferenceWrapper inferenceWrapper = null;
        try {
            InferenceWrapper inferenceWrapper2 = new InferenceWrapper();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                inferenceWrapper2.init(AlgorithmType.GLM_REGRESSOR, ModelManager.getDevicePerformanceModelInfo(ModelInfoDataProvider.DevicePerformanceModelInfoType.DeviceInfoLR));
                if (DEBUG) {
                    Log.d(TAG, "MODEL_DEVICE_SCORE_LR Load Time: " + (System.currentTimeMillis() - currentTimeMillis));
                }
                Tensor createInstance = Tensor.createInstance(new long[]{5}, FloatBuffer.wrap(new float[]{f2, f3, f4, f5, f6}));
                long currentTimeMillis2 = System.currentTimeMillis();
                Float f7 = (Float) inferenceWrapper2.predictForRegressorTarget(createInstance, 0.5f, Float.class);
                if (DEBUG) {
                    Log.d(TAG, "MODEL_DEVICE_SCORE_LR predict Time: " + (System.currentTimeMillis() - currentTimeMillis2));
                    Log.d(TAG, "MODEL_DEVICE_SCORE_LR Result: " + f7);
                }
                if (f7.floatValue() < 0.0f) {
                    f7 = Float.valueOf(0.0f);
                }
                if (f7.floatValue() > 1.0f) {
                    f7 = Float.valueOf(1.0f);
                }
                float floatValue = f7.floatValue();
                try {
                    inferenceWrapper2.close();
                } catch (Exception e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
                return floatValue;
            } catch (InferenceException unused) {
                inferenceWrapper = inferenceWrapper2;
                if (inferenceWrapper != null) {
                    try {
                        inferenceWrapper.close();
                    } catch (Exception e3) {
                        if (DEBUG) {
                            e3.printStackTrace();
                        }
                    }
                }
                return -1.0f;
            } catch (ModelLoadException unused2) {
                inferenceWrapper = inferenceWrapper2;
                if (inferenceWrapper != null) {
                    try {
                        inferenceWrapper.close();
                    } catch (Exception e4) {
                        if (DEBUG) {
                            e4.printStackTrace();
                        }
                    }
                }
                return -1.0f;
            } catch (IllegalStateException unused3) {
                inferenceWrapper = inferenceWrapper2;
                if (inferenceWrapper != null) {
                    try {
                        inferenceWrapper.close();
                    } catch (Exception e5) {
                        if (DEBUG) {
                            e5.printStackTrace();
                        }
                    }
                }
                return -1.0f;
            } catch (Throwable th) {
                th = th;
                inferenceWrapper = inferenceWrapper2;
                if (inferenceWrapper != null) {
                    try {
                        inferenceWrapper.close();
                    } catch (Exception e6) {
                        if (DEBUG) {
                            e6.printStackTrace();
                        }
                    }
                }
                throw th;
            }
        } catch (InferenceException unused4) {
        } catch (ModelLoadException unused5) {
        } catch (IllegalStateException unused6) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public float predictByModel(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            float numCores = HardwareInfoUtils.getNumCores();
            float aveCpuFrequency = HardwareInfoUtils.getAveCpuFrequency();
            float totalMemory = HardwareInfoUtils.getTotalMemory();
            float totalSDCardSize = HardwareInfoUtils.getTotalSDCardSize();
            float screenResolution = (float) HardwareInfoUtils.getScreenResolution(context);
            float screenDensity = HardwareInfoUtils.getScreenDensity(context);
            if (DEBUG) {
                Log.d(TAG, "cpuNumber:" + numCores + "; cpuFrequency:" + aveCpuFrequency + "; memSize:" + totalMemory + "; romSize:" + totalSDCardSize + "; screenResolution:" + screenResolution + "; screenDensity:" + screenDensity);
            }
            if (numCores <= 0.0f) {
                numCores = 6.9822063f;
            }
            if (aveCpuFrequency <= 0.0f) {
                aveCpuFrequency = 1.7859616f;
            }
            if (totalMemory <= 0.0f) {
                totalMemory = 3.5425532f;
            }
            if (totalSDCardSize < 0.0f) {
                totalSDCardSize = 51.957294f;
            }
            if (screenResolution <= 0.0f) {
                screenResolution = 1904175.1f;
            }
            if (screenDensity <= 0.0f) {
                screenDensity = 375.48398f;
            }
            float round = Math.round(numCores);
            float ceil = (float) Math.ceil(totalMemory);
            float roundUpRom = roundUpRom(totalSDCardSize);
            float round2 = Math.round(screenResolution);
            float round3 = Math.round(screenDensity);
            float f2 = round * aveCpuFrequency;
            float predictByGBDTModel = predictByGBDTModel(round, aveCpuFrequency, ceil, roundUpRom, round2, round3, f2);
            float predictByLRModel = predictByLRModel(aveCpuFrequency, ceil, roundUpRom, round2, f2);
            int i = (predictByLRModel > 0.0f ? 1 : (predictByLRModel == 0.0f ? 0 : -1));
            if (i >= 0 || predictByGBDTModel >= 0.0f) {
                return i < 0 ? predictByGBDTModel : predictByGBDTModel < 0.0f ? predictByLRModel : mergeScore(predictByGBDTModel, predictByLRModel);
            }
            return -1.0f;
        }
        return invokeL.floatValue;
    }
}
