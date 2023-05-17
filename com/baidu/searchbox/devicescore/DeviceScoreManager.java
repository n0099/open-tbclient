package com.baidu.searchbox.devicescore;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.baidu.searchbox.aideviceperformanceboxproxy.device.DevicePortraitManagerSingleton;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.devicescore.dynamic.DynamicScoreFactory;
import com.baidu.searchbox.devicescore.dynamic.IDynamicScoreManager;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import java.math.BigDecimal;
import java.math.RoundingMode;
/* loaded from: classes3.dex */
public class DeviceScoreManager implements IDeviceScore, IScoreMetaDataCollect, IDeviceScoreConfig {
    public static final String SP_KEY_FINAL_DYNAMIC_SCORE = "device_store_final_dynamic_score_float";
    public static final String SP_KEY_FINAL_SCORE_FLOAT = "device_store_final_score_float";
    public static final String TAG = "DeviceScoreManager";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static volatile DeviceScoreManager sInstance = null;
    public float mStaticScore = -1.0f;
    public float mDynamicScore = -1.0f;
    public float mFloatFinalScore = -1.0f;

    public static DeviceScoreManager getInstance() {
        if (sInstance == null) {
            synchronized (DeviceScoreManager.class) {
                if (sInstance == null) {
                    sInstance = new DeviceScoreManager();
                }
            }
        }
        return sInstance;
    }

    @Override // com.baidu.searchbox.devicescore.IDeviceScore
    public float getDynamicScoreByType(Context context, String str) {
        float f;
        IDynamicScoreManager dynamicScoreManager = DynamicScoreFactory.getDynamicScoreManager(str);
        if (dynamicScoreManager != null) {
            f = dynamicScoreManager.getScore(context);
        } else {
            f = -1.0f;
        }
        if (DEBUG) {
            Log.d(TAG, "getDynamicScoreByType type:" + str + " score:" + f);
        }
        return f;
    }

    @Override // com.baidu.searchbox.devicescore.IScoreMetaDataCollect
    public void putScoreMetaData(Context context, ScoreMetaData scoreMetaData) {
        IDynamicScoreManager dynamicScoreManager;
        if (scoreMetaData != null && (dynamicScoreManager = DynamicScoreFactory.getDynamicScoreManager(scoreMetaData.type)) != null) {
            dynamicScoreManager.putMetaData(context, scoreMetaData);
        }
    }

    private float getStaticScoreFloat(Context context) {
        float staticDeviceScore = DevicePortraitManagerSingleton.getInstance().getStaticDeviceScore(context);
        if (Float.compare(staticDeviceScore, 0.0f) >= 0) {
            float floatValue = new BigDecimal(String.valueOf(staticDeviceScore)).setScale(4, RoundingMode.DOWN).floatValue();
            if (DEBUG) {
                Log.d(TAG, "getStaticScoreFloat: " + staticDeviceScore + " float: " + floatValue);
            }
            return floatValue;
        }
        Log.e(TAG, "getStaticScoreFloat error!");
        return -1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerUpdateScore(Context context) {
        float staticScoreFloat = getStaticScoreFloat(context);
        if (Float.compare(staticScoreFloat, 0.0f) >= 0) {
            QuickPersistConfig.getInstance().putFloat(SP_KEY_FINAL_SCORE_FLOAT, staticScoreFloat);
        }
    }

    @Override // com.baidu.searchbox.devicescore.IDeviceScore
    public float getDynamicScore(Context context) {
        float f = this.mDynamicScore;
        if (f >= 0.0f) {
            return f;
        }
        float f2 = QuickPersistConfig.getInstance().getFloat(SP_KEY_FINAL_DYNAMIC_SCORE, -1.0f);
        this.mDynamicScore = f2;
        return f2;
    }

    @Override // com.baidu.searchbox.devicescore.IDeviceScore
    public int getScoreLevel(Context context) {
        float finalScore = getFinalScore(context);
        float lowThreshold = DeviceScoreStrategy.getLowThreshold();
        if (Float.compare(finalScore, lowThreshold) <= 0) {
            return 1;
        }
        if (Float.compare(finalScore, lowThreshold) > 0 && Float.compare(finalScore, DeviceScoreStrategy.getMidThreshold()) <= 0) {
            return 2;
        }
        return 3;
    }

    @Override // com.baidu.searchbox.devicescore.IDeviceScoreConfig
    public void updateConfig(final DeviceScoreConfig deviceScoreConfig) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.devicescore.DeviceScoreManager.2
                @Override // java.lang.Runnable
                public void run() {
                    if (DeviceScoreManager.DEBUG) {
                        Log.d(DeviceScoreManager.TAG, "updateConfig:" + deviceScoreConfig);
                    }
                    DeviceScoreStrategy.updateStrategy(deviceScoreConfig);
                }
            }, "updateConfig", 3);
        } else {
            DeviceScoreStrategy.updateStrategy(deviceScoreConfig);
        }
    }

    @Override // com.baidu.searchbox.devicescore.IDeviceScore
    public void updateScore(final Context context) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.devicescore.DeviceScoreManager.1
                @Override // java.lang.Runnable
                public void run() {
                    DeviceScoreManager.this.innerUpdateScore(context);
                }
            }, "updateScore", 3);
        } else {
            innerUpdateScore(context);
        }
    }

    @Override // com.baidu.searchbox.devicescore.IDeviceScore
    public float getFinalScore(Context context) {
        if (Float.compare(this.mFloatFinalScore, 0.0f) >= 0) {
            if (DEBUG) {
                Log.d(TAG, "getFloatFinalScore from mem:" + this.mFloatFinalScore);
            }
            return this.mFloatFinalScore;
        }
        float f = QuickPersistConfig.getInstance().getFloat(SP_KEY_FINAL_SCORE_FLOAT, -1.0f);
        this.mFloatFinalScore = f;
        if (Float.compare(f, 0.0f) >= 0) {
            if (DEBUG) {
                Log.d(TAG, "getFloatFinalScore from sp:" + this.mFloatFinalScore);
            }
            return this.mFloatFinalScore;
        }
        this.mFloatFinalScore = getStaticScoreFloat(context);
        if (DEBUG) {
            Log.d(TAG, "getFloatFinalScore:" + this.mFloatFinalScore);
        }
        updateScore(context);
        return this.mFloatFinalScore;
    }

    @Override // com.baidu.searchbox.devicescore.IDeviceScore
    public float getStaticScore(Context context) {
        float f = this.mStaticScore;
        if (f >= 0.0f) {
            return f;
        }
        float staticScoreFloat = getStaticScoreFloat(context);
        this.mStaticScore = staticScoreFloat;
        if (DEBUG) {
            if (Float.compare(staticScoreFloat, 0.0f) < 0) {
                Log.e(TAG, "getStaticScore failed!");
            }
            Log.d(TAG, "getStaticScore:" + this.mStaticScore);
        }
        return this.mStaticScore;
    }
}
