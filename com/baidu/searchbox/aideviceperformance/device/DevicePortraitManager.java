package com.baidu.searchbox.aideviceperformance.device;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.aideviceperformance.device.IDevicePortraitManager;
import com.baidu.searchbox.aideviceperformance.utils.Config;
import com.baidu.searchbox.aideviceperformance.utils.DeviceInfoSharedPreferenceWrapper;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
/* loaded from: classes3.dex */
public class DevicePortraitManager implements IDevicePortraitManager {
    public static final boolean DEBUG = Config.isDebug();
    public static float DEVICE_SCORE_CACHE = -1.0f;
    public static float DEVICE_SCORE_PERCENTAGE_CACHE = -1.0f;
    public static final String SP_KEY_MODEL_VERSION_GBDT = "model_version_gbdt";
    public static final String SP_KEY_MODEL_VERSION_LR = "model_version_lr";
    public static final String SP_KEY_MODEL_VERSION_MAPPER = "model_version_mapper";
    public static final String TAG = "DevicePortraitManager";
    public DeviceScoreModel mDeviceScoreModel;
    public IDevicePortraitResultHandler mResultHandler;
    public IDevicePortraitThresholdsConfig mThresholdsConfig;

    /* renamed from: com.baidu.searchbox.aideviceperformance.device.DevicePortraitManager$4  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$aideviceperformance$device$IDevicePortraitManager$ThresholdType;

        static {
            int[] iArr = new int[IDevicePortraitManager.ThresholdType.values().length];
            $SwitchMap$com$baidu$searchbox$aideviceperformance$device$IDevicePortraitManager$ThresholdType = iArr;
            try {
                iArr[IDevicePortraitManager.ThresholdType.LOW_MID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$aideviceperformance$device$IDevicePortraitManager$ThresholdType[IDevicePortraitManager.ThresholdType.MID_HIGH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public DevicePortraitManager(IDevicePortraitResultHandler iDevicePortraitResultHandler, IDevicePortraitThresholdsConfig iDevicePortraitThresholdsConfig, IDeviceInfoModelProvider iDeviceInfoModelProvider) {
        this.mResultHandler = iDevicePortraitResultHandler;
        this.mThresholdsConfig = iDevicePortraitThresholdsConfig;
        this.mDeviceScoreModel = new DeviceScoreModel(iDeviceInfoModelProvider);
    }

    private void postCheckStaticScoreStore(final Context context) {
        if (this.mResultHandler == null) {
            return;
        }
        ExecutorUtilsExt.delayPostOnElastic(new Runnable() { // from class: com.baidu.searchbox.aideviceperformance.device.DevicePortraitManager.3
            @Override // java.lang.Runnable
            public void run() {
                DevicePortraitManager.this.mDeviceScoreModel.checkAndUpdatePresetModel();
                long gBDTVersion = DevicePortraitManager.this.mDeviceScoreModel.getGBDTVersion();
                long lRVersion = DevicePortraitManager.this.mDeviceScoreModel.getLRVersion();
                long mapperVersion = DevicePortraitManager.this.mDeviceScoreModel.getMapperVersion();
                Long valueOf = Long.valueOf(DeviceInfoSharedPreferenceWrapper.getInstance().getLong(DevicePortraitManager.SP_KEY_MODEL_VERSION_GBDT, -1L));
                Long valueOf2 = Long.valueOf(DeviceInfoSharedPreferenceWrapper.getInstance().getLong(DevicePortraitManager.SP_KEY_MODEL_VERSION_LR, -1L));
                Long valueOf3 = Long.valueOf(DeviceInfoSharedPreferenceWrapper.getInstance().getLong(DevicePortraitManager.SP_KEY_MODEL_VERSION_MAPPER, -1L));
                if (gBDTVersion != valueOf.longValue() || lRVersion != valueOf2.longValue() || mapperVersion != valueOf3.longValue()) {
                    if (DevicePortraitManager.DEBUG) {
                        Log.d(DevicePortraitManager.TAG, "model version updated ## gbdtVersionModel:" + gBDTVersion + " ## gbdtVersionCache:" + valueOf + " ## lrVersionModel:" + lRVersion + " ## lrVersionCache:" + valueOf2 + " ## mapperVersionModel:" + mapperVersion + " ## mapperVersionCache:" + valueOf3);
                    }
                    DeviceInfoSharedPreferenceWrapper.getInstance().remove(DevicePortraitManager.SP_KEY_MODEL_VERSION_GBDT);
                    DeviceInfoSharedPreferenceWrapper.getInstance().remove(DevicePortraitManager.SP_KEY_MODEL_VERSION_LR);
                    DeviceInfoSharedPreferenceWrapper.getInstance().remove(DevicePortraitManager.SP_KEY_MODEL_VERSION_MAPPER);
                    DevicePortraitManager.this.mResultHandler.removeStaticPredictScore();
                    DevicePortraitManager.this.mResultHandler.removeStaticPredictScore();
                    float unused = DevicePortraitManager.DEVICE_SCORE_CACHE = -1.0f;
                    float unused2 = DevicePortraitManager.DEVICE_SCORE_PERCENTAGE_CACHE = -1.0f;
                    DevicePortraitManager.this.getStaticDeviceScorePercentage(context);
                }
            }
        }, "postCheckStaticScoreStore", 3, 5000L);
    }

    private void postStaticScorePercentageStore(final float f) {
        if (this.mResultHandler == null) {
            return;
        }
        ExecutorUtilsExt.delayPostOnElastic(new Runnable() { // from class: com.baidu.searchbox.aideviceperformance.device.DevicePortraitManager.2
            @Override // java.lang.Runnable
            public void run() {
                long mapperVersion = DevicePortraitManager.this.mDeviceScoreModel.getMapperVersion();
                DevicePortraitManager.this.mResultHandler.putStaticScorePercent(f);
                DeviceInfoSharedPreferenceWrapper.getInstance().putLong(DevicePortraitManager.SP_KEY_MODEL_VERSION_MAPPER, mapperVersion);
                if (DevicePortraitManager.DEBUG) {
                    Log.d(DevicePortraitManager.TAG, "save device score sp ## mapper version:" + mapperVersion);
                }
            }
        }, "postStaticScoreStore", 3, 5000L);
    }

    private void postStaticScoreStore(final float f) {
        if (this.mResultHandler == null) {
            return;
        }
        ExecutorUtilsExt.delayPostOnElastic(new Runnable() { // from class: com.baidu.searchbox.aideviceperformance.device.DevicePortraitManager.1
            @Override // java.lang.Runnable
            public void run() {
                long gBDTVersion = DevicePortraitManager.this.mDeviceScoreModel.getGBDTVersion();
                long lRVersion = DevicePortraitManager.this.mDeviceScoreModel.getLRVersion();
                DevicePortraitManager.this.mResultHandler.putStaticPredictScore(f);
                DeviceInfoSharedPreferenceWrapper.getInstance().putLong(DevicePortraitManager.SP_KEY_MODEL_VERSION_GBDT, gBDTVersion);
                DeviceInfoSharedPreferenceWrapper.getInstance().putLong(DevicePortraitManager.SP_KEY_MODEL_VERSION_LR, lRVersion);
                if (DevicePortraitManager.DEBUG) {
                    Log.d(DevicePortraitManager.TAG, "save device score sp ## gbdt version:" + gBDTVersion + " lr version: " + lRVersion + " ## score:" + f);
                }
            }
        }, "postStaticScoreStore", 3, 5000L);
    }

    @Override // com.baidu.searchbox.aideviceperformance.device.IDevicePortraitManager
    public float getDefaultScoreThreshold(IDevicePortraitManager.ThresholdType thresholdType) {
        if (this.mResultHandler == null) {
            return -1.0f;
        }
        int i = AnonymousClass4.$SwitchMap$com$baidu$searchbox$aideviceperformance$device$IDevicePortraitManager$ThresholdType[thresholdType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return -1.0f;
            }
            return this.mThresholdsConfig.getThresholdMidHigh();
        }
        return this.mThresholdsConfig.getThresholdLowMid();
    }

    @Override // com.baidu.searchbox.aideviceperformance.device.IDevicePortraitManager
    public float getStaticDeviceScore(Context context) {
        IDevicePortraitResultHandler iDevicePortraitResultHandler = this.mResultHandler;
        if (iDevicePortraitResultHandler == null) {
            return -1.0f;
        }
        if (DEVICE_SCORE_CACHE >= 0.0f) {
            if (DEBUG) {
                Log.d(TAG, "get device score from mem cache : " + DEVICE_SCORE_CACHE);
            }
            return DEVICE_SCORE_CACHE;
        }
        float staticPredictScore = iDevicePortraitResultHandler.getStaticPredictScore(-1.0f);
        if (staticPredictScore >= 0.0f) {
            if (DEBUG) {
                Log.d(TAG, "get device score from file cache : " + staticPredictScore);
            }
            DEVICE_SCORE_CACHE = staticPredictScore;
            postCheckStaticScoreStore(context);
            return DEVICE_SCORE_CACHE;
        }
        if (staticPredictScore == -1.0f) {
            this.mDeviceScoreModel.checkAndUpdatePresetModel();
        }
        float predictByModel = this.mDeviceScoreModel.predictByModel(context);
        if (predictByModel >= 0.0f) {
            if (DEBUG) {
                Log.d(TAG, "get device score from model : " + predictByModel);
            }
            DEVICE_SCORE_CACHE = predictByModel;
            postStaticScoreStore(predictByModel);
            return predictByModel;
        }
        float predictByLRInline = DeviceScoreModel.predictByLRInline();
        if (predictByLRInline < 0.0f) {
            return -1.0f;
        }
        if (DEBUG) {
            Log.d(TAG, "get device score from LR inline : " + predictByLRInline);
        }
        return predictByLRInline;
    }

    @Override // com.baidu.searchbox.aideviceperformance.device.IDevicePortraitManager
    public float getStaticDeviceScorePercentage(Context context) {
        IDevicePortraitResultHandler iDevicePortraitResultHandler = this.mResultHandler;
        if (iDevicePortraitResultHandler == null) {
            return -1.0f;
        }
        if (DEVICE_SCORE_PERCENTAGE_CACHE >= 0.0f) {
            if (DEBUG) {
                Log.d(TAG, "get device score percentage from mem cache : " + DEVICE_SCORE_PERCENTAGE_CACHE);
            }
            return DEVICE_SCORE_PERCENTAGE_CACHE;
        }
        float staticScorePercent = iDevicePortraitResultHandler.getStaticScorePercent(-1.0f);
        if (staticScorePercent >= 0.0f) {
            if (DEBUG) {
                Log.d(TAG, "get device score percentage from file cache : " + staticScorePercent);
            }
            DEVICE_SCORE_PERCENTAGE_CACHE = staticScorePercent;
            postCheckStaticScoreStore(context);
            return DEVICE_SCORE_PERCENTAGE_CACHE;
        }
        if (staticScorePercent == -1.0f) {
            this.mDeviceScoreModel.checkAndUpdatePresetModel();
        }
        float staticDeviceScore = getStaticDeviceScore(context);
        if (staticDeviceScore >= 0.0f) {
            float mapStaticScore = this.mDeviceScoreModel.mapStaticScore(staticDeviceScore);
            if (mapStaticScore >= 0.0f) {
                if (DEBUG) {
                    Log.d(TAG, "get device score percentage from model : " + mapStaticScore);
                }
                if (DEVICE_SCORE_CACHE >= 0.0f) {
                    DEVICE_SCORE_PERCENTAGE_CACHE = mapStaticScore;
                    postStaticScorePercentageStore(mapStaticScore);
                }
                return mapStaticScore;
            }
        }
        return -1.0f;
    }
}
