package com.baidu.searchbox.aideviceperformance.device;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aideviceperformance.device.IDevicePortraitManager;
import com.baidu.searchbox.aideviceperformance.utils.Config;
import com.baidu.searchbox.aideviceperformance.utils.DeviceInfoSharedPreferenceWrapper;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class DevicePortraitManager implements IDevicePortraitManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static float DEVICE_SCORE_CACHE = 0.0f;
    public static float DEVICE_SCORE_PERCENTAGE_CACHE = 0.0f;
    public static final String SP_KEY_MODEL_VERSION_GBDT = "model_version_gbdt";
    public static final String SP_KEY_MODEL_VERSION_LR = "model_version_lr";
    public static final String SP_KEY_MODEL_VERSION_MAPPER = "model_version_mapper";
    public static final String TAG = "DevicePortraitManager";
    public transient /* synthetic */ FieldHolder $fh;
    public DeviceScoreModel mDeviceScoreModel;
    public IDevicePortraitResultHandler mResultHandler;
    public IDevicePortraitThresholdsConfig mThresholdsConfig;

    /* renamed from: com.baidu.searchbox.aideviceperformance.device.DevicePortraitManager$4  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$aideviceperformance$device$IDevicePortraitManager$ThresholdType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1227407055, "Lcom/baidu/searchbox/aideviceperformance/device/DevicePortraitManager$4;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1227407055, "Lcom/baidu/searchbox/aideviceperformance/device/DevicePortraitManager$4;");
                    return;
                }
            }
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-975577791, "Lcom/baidu/searchbox/aideviceperformance/device/DevicePortraitManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-975577791, "Lcom/baidu/searchbox/aideviceperformance/device/DevicePortraitManager;");
                return;
            }
        }
        DEBUG = Config.isDebug();
        DEVICE_SCORE_CACHE = -1.0f;
        DEVICE_SCORE_PERCENTAGE_CACHE = -1.0f;
    }

    public DevicePortraitManager(IDevicePortraitResultHandler iDevicePortraitResultHandler, IDevicePortraitThresholdsConfig iDevicePortraitThresholdsConfig, IDeviceInfoModelProvider iDeviceInfoModelProvider) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iDevicePortraitResultHandler, iDevicePortraitThresholdsConfig, iDeviceInfoModelProvider};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mResultHandler = iDevicePortraitResultHandler;
        this.mThresholdsConfig = iDevicePortraitThresholdsConfig;
        this.mDeviceScoreModel = new DeviceScoreModel(iDeviceInfoModelProvider);
    }

    private void postCheckStaticScoreStore(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, context) == null) || this.mResultHandler == null) {
            return;
        }
        ExecutorUtilsExt.delayPostOnElastic(new Runnable(this, context) { // from class: com.baidu.searchbox.aideviceperformance.device.DevicePortraitManager.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DevicePortraitManager this$0;
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
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.mDeviceScoreModel.checkAndUpdatePresetModel();
                    long gBDTVersion = this.this$0.mDeviceScoreModel.getGBDTVersion();
                    long lRVersion = this.this$0.mDeviceScoreModel.getLRVersion();
                    long mapperVersion = this.this$0.mDeviceScoreModel.getMapperVersion();
                    Long valueOf = Long.valueOf(DeviceInfoSharedPreferenceWrapper.getInstance().getLong(DevicePortraitManager.SP_KEY_MODEL_VERSION_GBDT, -1L));
                    Long valueOf2 = Long.valueOf(DeviceInfoSharedPreferenceWrapper.getInstance().getLong(DevicePortraitManager.SP_KEY_MODEL_VERSION_LR, -1L));
                    Long valueOf3 = Long.valueOf(DeviceInfoSharedPreferenceWrapper.getInstance().getLong(DevicePortraitManager.SP_KEY_MODEL_VERSION_MAPPER, -1L));
                    if (gBDTVersion == valueOf.longValue() && lRVersion == valueOf2.longValue() && mapperVersion == valueOf3.longValue()) {
                        return;
                    }
                    if (DevicePortraitManager.DEBUG) {
                        Log.d(DevicePortraitManager.TAG, "model version updated ## gbdtVersionModel:" + gBDTVersion + " ## gbdtVersionCache:" + valueOf + " ## lrVersionModel:" + lRVersion + " ## lrVersionCache:" + valueOf2 + " ## mapperVersionModel:" + mapperVersion + " ## mapperVersionCache:" + valueOf3);
                    }
                    DeviceInfoSharedPreferenceWrapper.getInstance().remove(DevicePortraitManager.SP_KEY_MODEL_VERSION_GBDT);
                    DeviceInfoSharedPreferenceWrapper.getInstance().remove(DevicePortraitManager.SP_KEY_MODEL_VERSION_LR);
                    DeviceInfoSharedPreferenceWrapper.getInstance().remove(DevicePortraitManager.SP_KEY_MODEL_VERSION_MAPPER);
                    this.this$0.mResultHandler.removeStaticPredictScore();
                    this.this$0.mResultHandler.removeStaticPredictScore();
                    float unused = DevicePortraitManager.DEVICE_SCORE_CACHE = -1.0f;
                    float unused2 = DevicePortraitManager.DEVICE_SCORE_PERCENTAGE_CACHE = -1.0f;
                    this.this$0.getStaticDeviceScorePercentage(this.val$cx);
                }
            }
        }, "postCheckStaticScoreStore", 3, 5000L);
    }

    private void postStaticScorePercentageStore(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(65544, this, f2) == null) || this.mResultHandler == null) {
            return;
        }
        ExecutorUtilsExt.delayPostOnElastic(new Runnable(this, f2) { // from class: com.baidu.searchbox.aideviceperformance.device.DevicePortraitManager.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DevicePortraitManager this$0;
            public final /* synthetic */ float val$deviceScorePercent;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Float.valueOf(f2)};
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
                this.val$deviceScorePercent = f2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    long mapperVersion = this.this$0.mDeviceScoreModel.getMapperVersion();
                    this.this$0.mResultHandler.putStaticScorePercent(this.val$deviceScorePercent);
                    DeviceInfoSharedPreferenceWrapper.getInstance().putLong(DevicePortraitManager.SP_KEY_MODEL_VERSION_MAPPER, mapperVersion);
                    if (DevicePortraitManager.DEBUG) {
                        Log.d(DevicePortraitManager.TAG, "save device score sp ## mapper version:" + mapperVersion);
                    }
                }
            }
        }, "postStaticScoreStore", 3, 5000L);
    }

    private void postStaticScoreStore(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(65545, this, f2) == null) || this.mResultHandler == null) {
            return;
        }
        ExecutorUtilsExt.delayPostOnElastic(new Runnable(this, f2) { // from class: com.baidu.searchbox.aideviceperformance.device.DevicePortraitManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DevicePortraitManager this$0;
            public final /* synthetic */ float val$deviceScore;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Float.valueOf(f2)};
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
                this.val$deviceScore = f2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    long gBDTVersion = this.this$0.mDeviceScoreModel.getGBDTVersion();
                    long lRVersion = this.this$0.mDeviceScoreModel.getLRVersion();
                    this.this$0.mResultHandler.putStaticPredictScore(this.val$deviceScore);
                    DeviceInfoSharedPreferenceWrapper.getInstance().putLong(DevicePortraitManager.SP_KEY_MODEL_VERSION_GBDT, gBDTVersion);
                    DeviceInfoSharedPreferenceWrapper.getInstance().putLong(DevicePortraitManager.SP_KEY_MODEL_VERSION_LR, lRVersion);
                    if (DevicePortraitManager.DEBUG) {
                        Log.d(DevicePortraitManager.TAG, "save device score sp ## gbdt version:" + gBDTVersion + " lr version: " + lRVersion + " ## score:" + this.val$deviceScore);
                    }
                }
            }
        }, "postStaticScoreStore", 3, 5000L);
    }

    @Override // com.baidu.searchbox.aideviceperformance.device.IDevicePortraitManager
    public float getDefaultScoreThreshold(IDevicePortraitManager.ThresholdType thresholdType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, thresholdType)) == null) {
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
        return invokeL.floatValue;
    }

    @Override // com.baidu.searchbox.aideviceperformance.device.IDevicePortraitManager
    public float getStaticDeviceScore(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
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
            if (predictByLRInline >= 0.0f) {
                if (DEBUG) {
                    Log.d(TAG, "get device score from LR inline : " + predictByLRInline);
                }
                return predictByLRInline;
            }
            return -1.0f;
        }
        return invokeL.floatValue;
    }

    @Override // com.baidu.searchbox.aideviceperformance.device.IDevicePortraitManager
    public float getStaticDeviceScorePercentage(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
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
        return invokeL.floatValue;
    }
}
