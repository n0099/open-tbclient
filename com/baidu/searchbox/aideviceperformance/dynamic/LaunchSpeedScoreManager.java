package com.baidu.searchbox.aideviceperformance.dynamic;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
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
import java.nio.FloatBuffer;
/* loaded from: classes3.dex */
public class LaunchSpeedScoreManager implements ILaunchSpeedScoreManager {
    public static final boolean DEBUG = Config.isDebug();
    public static final String SP_KEY_LAUNCH_SCORE_TIME = "launch_speed_score_time";
    public static final String SP_KEY_LAUNCH_SPEED_SCORE = "launch_speed_score";
    public static final String TAG = "LaunchSpeedScore";
    public static final float UPDATE_SCORE_THRESHOLD = 0.03f;
    public ModelManager mModelManager;

    @Override // com.baidu.searchbox.aideviceperformance.dynamic.ILaunchSpeedScoreManager
    public float getLaunchSpeedScore() {
        float f = DeviceInfoSharedPreferenceWrapper.getInstance().getFloat(SP_KEY_LAUNCH_SPEED_SCORE, -1.0f);
        if (DEBUG) {
            Log.d(TAG, "getLaunchSpeedScore : " + f);
        }
        return f;
    }

    public LaunchSpeedScoreManager(IDynamicModelProvider iDynamicModelProvider) {
        ModelManager modelManager = new ModelManager();
        this.mModelManager = modelManager;
        modelManager.setModelInfoProvider(iDynamicModelProvider, ModelInfoDataProvider.DevicePerformanceModelInfoType.DynamicLR);
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
                inferenceWrapper2.init(AlgorithmType.GLM_REGRESSOR, ModelManager.getDevicePerformanceModelInfo(ModelInfoDataProvider.DevicePerformanceModelInfoType.DynamicLR));
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

    @Override // com.baidu.searchbox.aideviceperformance.dynamic.ILaunchSpeedScoreManager
    public void putLaunchSpeedData(final Context context, final long j, final long j2) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.aideviceperformance.dynamic.LaunchSpeedScoreManager.1
            @Override // java.lang.Runnable
            public void run() {
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_launch_time", Long.valueOf(j));
                contentValues.put("event_time", Long.valueOf(j2));
                LaunchTimeSQLiteOpenHelper.getInstance(context).insert(contentValues);
                LaunchSpeedScoreManager.this.updateLaunchSpeedScore(context);
                if (LaunchSpeedScoreManager.DEBUG) {
                    Log.d(LaunchSpeedScoreManager.TAG, "putLaunchSpeedData : " + j);
                }
            }
        }, "putLaunchSpeedData", 2);
    }

    public boolean updateLaunchSpeedScore(Context context) {
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
}
