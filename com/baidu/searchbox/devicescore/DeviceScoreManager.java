package com.baidu.searchbox.devicescore;

import android.content.Context;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aideviceperformanceboxproxy.device.DevicePortraitManagerSingleton;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.devicescore.dynamic.DynamicScoreFactory;
import com.baidu.searchbox.devicescore.dynamic.IDynamicScoreManager;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.math.BigDecimal;
import java.math.RoundingMode;
/* loaded from: classes11.dex */
public class DeviceScoreManager implements IDeviceScore, IScoreMetaDataCollect, IDeviceScoreConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String SP_KEY_FINAL_DYNAMIC_SCORE = "device_store_final_dynamic_score_float";
    public static final String SP_KEY_FINAL_SCORE_FLOAT = "device_store_final_score_float";
    public static final String TAG = "DeviceScoreManager";
    public static volatile DeviceScoreManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public float mDynamicScore;
    public float mFloatFinalScore;
    public float mStaticScore;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(388849981, "Lcom/baidu/searchbox/devicescore/DeviceScoreManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(388849981, "Lcom/baidu/searchbox/devicescore/DeviceScoreManager;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
        sInstance = null;
    }

    public DeviceScoreManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mStaticScore = -1.0f;
        this.mDynamicScore = -1.0f;
        this.mFloatFinalScore = -1.0f;
    }

    public static DeviceScoreManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (sInstance == null) {
                synchronized (DeviceScoreManager.class) {
                    if (sInstance == null) {
                        sInstance = new DeviceScoreManager();
                    }
                }
            }
            return sInstance;
        }
        return (DeviceScoreManager) invokeV.objValue;
    }

    private float getStaticScoreFloat(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, context)) == null) {
            float staticDeviceScore = DevicePortraitManagerSingleton.getInstance().getStaticDeviceScore(context);
            if (Float.compare(staticDeviceScore, 0.0f) >= 0) {
                float floatValue = new BigDecimal(String.valueOf(staticDeviceScore)).setScale(4, RoundingMode.DOWN).floatValue();
                if (DEBUG) {
                    String str = "getStaticScoreFloat: " + staticDeviceScore + " float: " + floatValue;
                }
                return floatValue;
            }
            return -1.0f;
        }
        return invokeL.floatValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerUpdateScore(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, context) == null) {
            float staticScoreFloat = getStaticScoreFloat(context);
            if (Float.compare(staticScoreFloat, 0.0f) >= 0) {
                QuickPersistConfig.getInstance().putFloat(SP_KEY_FINAL_SCORE_FLOAT, staticScoreFloat);
            }
        }
    }

    @Override // com.baidu.searchbox.devicescore.IDeviceScore
    public float getDynamicScore(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            float f2 = this.mDynamicScore;
            if (f2 >= 0.0f) {
                return f2;
            }
            float f3 = QuickPersistConfig.getInstance().getFloat(SP_KEY_FINAL_DYNAMIC_SCORE, -1.0f);
            this.mDynamicScore = f3;
            return f3;
        }
        return invokeL.floatValue;
    }

    @Override // com.baidu.searchbox.devicescore.IDeviceScore
    public float getDynamicScoreByType(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            IDynamicScoreManager dynamicScoreManager = DynamicScoreFactory.getDynamicScoreManager(str);
            float score = dynamicScoreManager != null ? dynamicScoreManager.getScore(context) : -1.0f;
            if (DEBUG) {
                String str2 = "getDynamicScoreByType type:" + str + " score:" + score;
            }
            return score;
        }
        return invokeLL.floatValue;
    }

    @Override // com.baidu.searchbox.devicescore.IDeviceScore
    public float getFinalScore(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            if (Float.compare(this.mFloatFinalScore, 0.0f) >= 0) {
                if (DEBUG) {
                    String str = "getFloatFinalScore from mem:" + this.mFloatFinalScore;
                }
                return this.mFloatFinalScore;
            }
            float f2 = QuickPersistConfig.getInstance().getFloat(SP_KEY_FINAL_SCORE_FLOAT, -1.0f);
            this.mFloatFinalScore = f2;
            if (Float.compare(f2, 0.0f) >= 0) {
                if (DEBUG) {
                    String str2 = "getFloatFinalScore from sp:" + this.mFloatFinalScore;
                }
                return this.mFloatFinalScore;
            }
            this.mFloatFinalScore = getStaticScoreFloat(context);
            if (DEBUG) {
                String str3 = "getFloatFinalScore:" + this.mFloatFinalScore;
            }
            updateScore(context);
            return this.mFloatFinalScore;
        }
        return invokeL.floatValue;
    }

    @Override // com.baidu.searchbox.devicescore.IDeviceScore
    public int getScoreLevel(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            float finalScore = getFinalScore(context);
            float lowThreshold = DeviceScoreStrategy.getLowThreshold();
            if (Float.compare(finalScore, lowThreshold) <= 0) {
                return 1;
            }
            return (Float.compare(finalScore, lowThreshold) <= 0 || Float.compare(finalScore, DeviceScoreStrategy.getMidThreshold()) > 0) ? 3 : 2;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.searchbox.devicescore.IDeviceScore
    public float getStaticScore(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            float f2 = this.mStaticScore;
            if (f2 >= 0.0f) {
                return f2;
            }
            float staticScoreFloat = getStaticScoreFloat(context);
            this.mStaticScore = staticScoreFloat;
            if (DEBUG) {
                Float.compare(staticScoreFloat, 0.0f);
                String str = "getStaticScore:" + this.mStaticScore;
            }
            return this.mStaticScore;
        }
        return invokeL.floatValue;
    }

    @Override // com.baidu.searchbox.devicescore.IScoreMetaDataCollect
    public void putScoreMetaData(Context context, ScoreMetaData scoreMetaData) {
        IDynamicScoreManager dynamicScoreManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, context, scoreMetaData) == null) || scoreMetaData == null || (dynamicScoreManager = DynamicScoreFactory.getDynamicScoreManager(scoreMetaData.type)) == null) {
            return;
        }
        dynamicScoreManager.putMetaData(context, scoreMetaData);
    }

    @Override // com.baidu.searchbox.devicescore.IDeviceScoreConfig
    public void updateConfig(DeviceScoreConfig deviceScoreConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, deviceScoreConfig) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                ExecutorUtilsExt.postOnElastic(new Runnable(this, deviceScoreConfig) { // from class: com.baidu.searchbox.devicescore.DeviceScoreManager.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DeviceScoreManager this$0;
                    public final /* synthetic */ DeviceScoreConfig val$config;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, deviceScoreConfig};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$config = deviceScoreConfig;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (DeviceScoreManager.DEBUG) {
                                String str = "updateConfig:" + this.val$config;
                            }
                            DeviceScoreStrategy.updateStrategy(this.val$config);
                        }
                    }
                }, "updateConfig", 3);
            } else {
                DeviceScoreStrategy.updateStrategy(deviceScoreConfig);
            }
        }
    }

    @Override // com.baidu.searchbox.devicescore.IDeviceScore
    public void updateScore(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                ExecutorUtilsExt.postOnElastic(new Runnable(this, context) { // from class: com.baidu.searchbox.devicescore.DeviceScoreManager.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DeviceScoreManager this$0;
                    public final /* synthetic */ Context val$c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$c = context;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.innerUpdateScore(this.val$c);
                        }
                    }
                }, "updateScore", 3);
            } else {
                innerUpdateScore(context);
            }
        }
    }
}
