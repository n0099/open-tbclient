package com.baidu.searchbox.aideviceperformance.amendeddevicescore;

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
import com.baidu.searchbox.aideviceperformance.utils.DeviceInfoSharedPreferenceWrapper;
import com.baidu.searchbox.aideviceperformance.utils.LaunchSpeedReadUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import java.nio.FloatBuffer;
/* loaded from: classes3.dex */
public class AmendedDeviceScoreManager implements IAmendedDeviceScoreManager {
    public static final String SP_KEY_AMENDED_DEVICE_SCORE = "amended_device_score";
    public static final String SP_KEY_AMENDED_DEVICE_SCORE_MODEL_VERSION = "amended_device_score_model_version";
    public static final String SP_KEY_AMENDED_DEVICE_SCORE_TIME = "amended_device_score_time";
    public static final String TAG = "AmendedDeviceScore";
    public ModelManager mModelManager;
    public static final boolean DEBUG = Config.isDebug();
    public static float amendedDeviceScoreCache = -1.0f;

    @Override // com.baidu.searchbox.aideviceperformance.amendeddevicescore.IAmendedDeviceScoreManager
    public long getModelVersion() {
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

    public AmendedDeviceScoreManager(IAmendedDeviceScoreModelProvider iAmendedDeviceScoreModelProvider) {
        ModelManager modelManager = new ModelManager();
        this.mModelManager = modelManager;
        modelManager.setModelInfoProvider(iAmendedDeviceScoreModelProvider, ModelInfoDataProvider.DevicePerformanceModelInfoType.AmendedDeviceScore);
    }

    private void postCheckAmendedStaticScoreStore(final Context context) {
        ExecutorUtilsExt.delayPostOnElastic(new Runnable() { // from class: com.baidu.searchbox.aideviceperformance.amendeddevicescore.AmendedDeviceScoreManager.2
            @Override // java.lang.Runnable
            public void run() {
                AmendedDeviceScoreManager.this.updateAmendedDeviceScore(context);
            }
        }, "postCheckAmendedDeviceScoreStore", 3, 5000L);
    }

    private void postStaticScoreStore(final float f) {
        ExecutorUtilsExt.delayPostOnElastic(new Runnable() { // from class: com.baidu.searchbox.aideviceperformance.amendeddevicescore.AmendedDeviceScoreManager.1
            @Override // java.lang.Runnable
            public void run() {
                DeviceInfoSharedPreferenceWrapper.getInstance().putFloat(AmendedDeviceScoreManager.SP_KEY_AMENDED_DEVICE_SCORE, f);
                long modelVersion = AmendedDeviceScoreManager.this.getModelVersion();
                DeviceInfoSharedPreferenceWrapper.getInstance().putLong(AmendedDeviceScoreManager.SP_KEY_AMENDED_DEVICE_SCORE_MODEL_VERSION, modelVersion);
                DeviceInfoSharedPreferenceWrapper.getInstance().putLong(AmendedDeviceScoreManager.SP_KEY_AMENDED_DEVICE_SCORE_TIME, System.currentTimeMillis());
                if (AmendedDeviceScoreManager.DEBUG) {
                    Log.d(AmendedDeviceScoreManager.TAG, "save amended device score sp ## model version:" + modelVersion + " ## score:" + f);
                }
            }
        }, "postStaticScoreStore", 3, 5000L);
    }

    private float predictByLRModel(Context context) {
        float calculateAverageLaunchTime = new LaunchSpeedReadUtil().calculateAverageLaunchTime(context);
        if (calculateAverageLaunchTime == -1.0f) {
            return -1.0f;
        }
        InferenceWrapper inferenceWrapper = null;
        try {
            InferenceWrapper inferenceWrapper2 = new InferenceWrapper();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                inferenceWrapper2.init(AlgorithmType.GLM_REGRESSOR, ModelManager.getDevicePerformanceModelInfo(ModelInfoDataProvider.DevicePerformanceModelInfoType.AmendedDeviceScore));
                if (DEBUG) {
                    Log.d(TAG, "MML Load Time: " + (System.currentTimeMillis() - currentTimeMillis));
                }
                double d = calculateAverageLaunchTime;
                Tensor createInstance = Tensor.createInstance(new long[]{4}, FloatBuffer.wrap(new float[]{calculateAverageLaunchTime, (float) Math.pow(d, 2.0d), (float) Math.pow(d, 3.0d), (float) Math.pow(d, 4.0d)}));
                long currentTimeMillis2 = System.currentTimeMillis();
                Float f = (Float) inferenceWrapper2.predictForRegressorTarget(createInstance, 0.5f, Float.class);
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
                return -3.0f;
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
                return -2.0f;
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
                return -4.0f;
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateAmendedDeviceScore(Context context) {
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

    @Override // com.baidu.searchbox.aideviceperformance.amendeddevicescore.IAmendedDeviceScoreManager
    public float getAmendedDeviceScore(Context context) {
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
}
