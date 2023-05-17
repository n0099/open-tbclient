package com.baidu.searchbox.aideviceperformance.device;

import android.content.Context;
import android.util.Log;
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
import java.nio.FloatBuffer;
/* loaded from: classes3.dex */
public class DeviceScoreModel {
    public static final boolean DEBUG = Config.isDebug();
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
    public ModelManager mModelManager;

    public static float roundUpRom(float f) {
        int i = 1;
        while (f > i * 1.5d && (i = i << 1) <= 268435456) {
        }
        return i;
    }

    public void checkAndUpdatePresetModel() {
        ModelManager modelManager = this.mModelManager;
        if (modelManager != null) {
            modelManager.checkAndUpdatePresetModel();
        }
    }

    public long getGBDTVersion() {
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

    public long getLRVersion() {
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

    public long getMapperVersion() {
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

    public DeviceScoreModel(IDeviceInfoModelProvider iDeviceInfoModelProvider) {
        ModelManager modelManager = new ModelManager();
        this.mModelManager = modelManager;
        modelManager.setModelInfoProvider(iDeviceInfoModelProvider, ModelInfoDataProvider.DevicePerformanceModelInfoType.DeviceInfoGBDT);
        this.mModelManager.setModelInfoProvider(iDeviceInfoModelProvider, ModelInfoDataProvider.DevicePerformanceModelInfoType.DeviceInfoLR);
        this.mModelManager.setModelInfoProvider(iDeviceInfoModelProvider, ModelInfoDataProvider.DevicePerformanceModelInfoType.DeviceInfoMapper);
    }

    public static float mergeScore(float f, float f2) {
        float f3;
        float f4;
        float abs = Math.abs(f - f2);
        if (abs < 0.05f) {
            f3 = f * 0.8f;
            f4 = f2 * 0.2f;
        } else if (abs < 0.1f) {
            f3 = f * 0.6f;
            f4 = f2 * 0.4f;
        } else if (abs < 0.15f) {
            f3 = f * 0.4f;
            f4 = f2 * 0.6f;
        } else if (abs < 0.2f) {
            f3 = f * 0.2f;
            f4 = f2 * 0.8f;
        } else {
            return f2;
        }
        return f3 + f4;
    }

    public static float predictByLRInline() {
        float numCores = HardwareInfoUtils.getNumCores();
        float aveCpuFrequency = HardwareInfoUtils.getAveCpuFrequency();
        float totalMemory = HardwareInfoUtils.getTotalMemory();
        float totalSDCardSize = HardwareInfoUtils.getTotalSDCardSize();
        float f = 0.0f;
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
        if (round >= 0.0f) {
            f = round;
        }
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    public float mapStaticScore(float f) {
        InferenceWrapper inferenceWrapper = null;
        try {
            InferenceWrapper inferenceWrapper2 = new InferenceWrapper();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                inferenceWrapper2.init(AlgorithmType.GLM_REGRESSOR, ModelManager.getDevicePerformanceModelInfo(ModelInfoDataProvider.DevicePerformanceModelInfoType.DeviceInfoMapper));
                if (DEBUG) {
                    Log.d(TAG, "MODEL_DEVICE_SCORE_MAPPER Load Time: " + (System.currentTimeMillis() - currentTimeMillis));
                }
                float[] fArr = new float[8];
                int i = 0;
                while (i < 8) {
                    int i2 = i + 1;
                    fArr[i] = (float) Math.pow(f, i2);
                    i = i2;
                }
                Tensor createInstance = Tensor.createInstance(new long[]{8}, FloatBuffer.wrap(fArr));
                long currentTimeMillis2 = System.currentTimeMillis();
                Float f2 = (Float) inferenceWrapper2.predictForRegressorTarget(createInstance, 0.5f, Float.class);
                if (DEBUG) {
                    Log.d(TAG, "MODEL_DEVICE_SCORE_MAPPER predict Time: " + (System.currentTimeMillis() - currentTimeMillis2));
                    Log.d(TAG, "MODEL_DEVICE_SCORE_MAPPER Result: " + f2);
                }
                if (f2.floatValue() < 0.0f) {
                    f2 = Float.valueOf(0.0f);
                }
                if (f2.floatValue() > 1.0f) {
                    f2 = Float.valueOf(1.0f);
                }
                float floatValue = f2.floatValue();
                try {
                    inferenceWrapper2.close();
                } catch (Exception e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                return floatValue;
            } catch (InferenceException unused) {
                inferenceWrapper = inferenceWrapper2;
                if (inferenceWrapper != null) {
                    try {
                        inferenceWrapper.close();
                    } catch (Exception e2) {
                        if (DEBUG) {
                            e2.printStackTrace();
                        }
                    }
                }
                return -1.0f;
            } catch (ModelLoadException unused2) {
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
            } catch (IllegalStateException unused3) {
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
            } catch (Throwable th) {
                th = th;
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
        float f = round * aveCpuFrequency;
        float predictByGBDTModel = predictByGBDTModel(round, aveCpuFrequency, ceil, roundUpRom, round2, round3, f);
        float predictByLRModel = predictByLRModel(aveCpuFrequency, ceil, roundUpRom, round2, f);
        int i = (predictByLRModel > 0.0f ? 1 : (predictByLRModel == 0.0f ? 0 : -1));
        if (i < 0 && predictByGBDTModel < 0.0f) {
            return -1.0f;
        }
        if (i < 0) {
            return predictByGBDTModel;
        }
        if (predictByGBDTModel < 0.0f) {
            return predictByLRModel;
        }
        return mergeScore(predictByGBDTModel, predictByLRModel);
    }

    public float predictByGBDTModel(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        InferenceWrapper inferenceWrapper;
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
            Tensor createInstance = Tensor.createInstance(new long[]{7}, FloatBuffer.wrap(new float[]{f, f2, f3, f4, f5, f6, f7}));
            long currentTimeMillis2 = System.currentTimeMillis();
            Float f8 = (Float) inferenceWrapper.predictForRegressorTarget(createInstance, 0.5f, Float.class);
            if (DEBUG) {
                Log.d(TAG, "MODEL_DEVICE_SCORE_GBDT predict Time: " + (System.currentTimeMillis() - currentTimeMillis2));
                Log.d(TAG, "MODEL_DEVICE_SCORE_GBDT Result: " + f8);
            }
            if (f8.floatValue() < 0.0f) {
                f8 = Float.valueOf(0.0f);
            }
            if (f8.floatValue() > 1.0f) {
                f8 = Float.valueOf(1.0f);
            }
            float floatValue = f8.floatValue();
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

    public float predictByLRModel(float f, float f2, float f3, float f4, float f5) {
        InferenceWrapper inferenceWrapper = null;
        try {
            InferenceWrapper inferenceWrapper2 = new InferenceWrapper();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                inferenceWrapper2.init(AlgorithmType.GLM_REGRESSOR, ModelManager.getDevicePerformanceModelInfo(ModelInfoDataProvider.DevicePerformanceModelInfoType.DeviceInfoLR));
                if (DEBUG) {
                    Log.d(TAG, "MODEL_DEVICE_SCORE_LR Load Time: " + (System.currentTimeMillis() - currentTimeMillis));
                }
                Tensor createInstance = Tensor.createInstance(new long[]{5}, FloatBuffer.wrap(new float[]{f, f2, f3, f4, f5}));
                long currentTimeMillis2 = System.currentTimeMillis();
                Float f6 = (Float) inferenceWrapper2.predictForRegressorTarget(createInstance, 0.5f, Float.class);
                if (DEBUG) {
                    Log.d(TAG, "MODEL_DEVICE_SCORE_LR predict Time: " + (System.currentTimeMillis() - currentTimeMillis2));
                    Log.d(TAG, "MODEL_DEVICE_SCORE_LR Result: " + f6);
                }
                if (f6.floatValue() < 0.0f) {
                    f6 = Float.valueOf(0.0f);
                }
                if (f6.floatValue() > 1.0f) {
                    f6 = Float.valueOf(1.0f);
                }
                float floatValue = f6.floatValue();
                try {
                    inferenceWrapper2.close();
                } catch (Exception e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                return floatValue;
            } catch (InferenceException unused) {
                inferenceWrapper = inferenceWrapper2;
                if (inferenceWrapper != null) {
                    try {
                        inferenceWrapper.close();
                    } catch (Exception e2) {
                        if (DEBUG) {
                            e2.printStackTrace();
                        }
                    }
                }
                return -1.0f;
            } catch (ModelLoadException unused2) {
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
            } catch (IllegalStateException unused3) {
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
            } catch (Throwable th) {
                th = th;
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
                throw th;
            }
        } catch (InferenceException unused4) {
        } catch (ModelLoadException unused5) {
        } catch (IllegalStateException unused6) {
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
