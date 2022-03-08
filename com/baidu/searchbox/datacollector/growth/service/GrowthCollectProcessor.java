package com.baidu.searchbox.datacollector.growth.service;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.datacollector.growth.model.ActiveData;
import com.baidu.searchbox.datacollector.growth.model.ChannelData;
import com.baidu.searchbox.datacollector.growth.model.ClipBoardData;
import com.baidu.searchbox.datacollector.growth.utils.DeviceUtil;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.datacollector.growth.utils.IDeviceCallback;
import com.baidu.searchbox.datacollector.growth.utils.PackageUtil;
import com.baidu.searchbox.datacollector.growth.utils.UBCEncryptor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GrowthCollectProcessor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "GrowthCollect";
    public static volatile GrowthCollectProcessor sSingleton;
    public transient /* synthetic */ FieldHolder $fh;
    public ExecutorService mExecutorService;
    public long mLastDeviceRecordTime;
    public UBCManager ubcManager;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-222377136, "Lcom/baidu/searchbox/datacollector/growth/service/GrowthCollectProcessor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-222377136, "Lcom/baidu/searchbox/datacollector/growth/service/GrowthCollectProcessor;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public GrowthCollectProcessor() {
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
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void generateActiveStatistic(ActiveData activeData, Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, this, activeData, context, str) == null) {
            String type = activeData.getType();
            if (TextUtils.isEmpty(type)) {
                type = GrowthConstant.UBC_VALUE_TYPE_DEFAULT;
            }
            String firstInstallTime = PackageUtil.getFirstInstallTime(context);
            String lastUpdateTime = PackageUtil.getLastUpdateTime(context);
            UBCEncryptor.MixedEncryptedResult encryptByRSAAndAESMixed = UBCEncryptor.encryptByRSAAndAESMixed(generateDeviceInfo(activeData, context, str));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", type);
                jSONObject.put(GrowthConstant.UBC_KEY_FIT, firstInstallTime);
                jSONObject.put(GrowthConstant.UBC_KEY_LUT, lastUpdateTime);
                jSONObject.put(GrowthConstant.UBC_KEY_AES_KEY, encryptByRSAAndAESMixed.encryptedAESKeys);
                jSONObject.put(GrowthConstant.UBC_KEY_USS, encryptByRSAAndAESMixed.encryptedInput);
                JSONObject extend = activeData.getExtend();
                if (extend != null) {
                    jSONObject.put("ext", extend);
                }
                if (DEBUG) {
                    String str2 = "active content: " + jSONObject;
                }
                this.ubcManager.onEvent(GrowthConstant.UBC_ID_ACTIVE, jSONObject);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private String generateDeviceIdInfo(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, context, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("imei", DeviceUtil.getIMei(context));
                jSONObject.put("oaid", str);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeLL.objValue;
    }

    private String generateDeviceInfo(ActiveData activeData, Context context, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, this, activeData, context, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            String channel = activeData.getChannel();
            String iMei = DeviceUtil.getIMei(context);
            try {
                jSONObject.put("channel", channel);
                jSONObject.put("imei", iMei);
                jSONObject.put("oaid", str);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void generateDeviceStatistic(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, this, context, str) == null) {
            UBCEncryptor.MixedEncryptedResult encryptByRSAAndAESMixed = UBCEncryptor.encryptByRSAAndAESMixed(generateDeviceIdInfo(context, str));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO);
                jSONObject.put(GrowthConstant.UBC_KEY_AES_KEY, encryptByRSAAndAESMixed.encryptedAESKeys);
                jSONObject.put(GrowthConstant.UBC_KEY_USS, encryptByRSAAndAESMixed.encryptedInput);
                if (DEBUG) {
                    String str2 = "device content: " + jSONObject;
                }
                this.ubcManager.onEvent(GrowthConstant.UBC_ID_DEVICE, jSONObject);
                SharedPreferences.Editor edit = context.getSharedPreferences(GrowthConstant.PREF_NAME, 0).edit();
                long currentTimeMillis = System.currentTimeMillis();
                edit.putLong(GrowthConstant.SP_KEY_LAST_DEVICE_RECORD_TIME, currentTimeMillis);
                edit.apply();
                this.mLastDeviceRecordTime = currentTimeMillis;
                if (DEBUG) {
                    String str3 = "update device record time: " + currentTimeMillis;
                }
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static GrowthCollectProcessor getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            if (sSingleton == null) {
                synchronized (GrowthCollectProcessor.class) {
                    if (sSingleton == null) {
                        sSingleton = new GrowthCollectProcessor();
                    }
                }
            }
            return sSingleton;
        }
        return (GrowthCollectProcessor) invokeV.objValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            this.mExecutorService = new ThreadPoolExecutor(1, 1, 600000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
            this.ubcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeActiveStatistic(ActiveData activeData, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65553, this, activeData, context) == null) || this.ubcManager == null) {
            return;
        }
        DeviceUtil.generateOaid(!(context instanceof Application) ? context.getApplicationContext() : context, new IDeviceCallback(this, activeData, context) { // from class: com.baidu.searchbox.datacollector.growth.service.GrowthCollectProcessor.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ GrowthCollectProcessor this$0;
            public final /* synthetic */ ActiveData val$activeData;
            public final /* synthetic */ Context val$context;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, activeData, context};
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
                this.val$activeData = activeData;
                this.val$context = context;
            }

            @Override // com.baidu.searchbox.datacollector.growth.utils.IDeviceCallback
            public void onFail() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    boolean unused = GrowthCollectProcessor.DEBUG;
                    this.this$0.invokeGenerateActiveStatistic(this.val$activeData, this.val$context, "");
                }
            }

            @Override // com.baidu.searchbox.datacollector.growth.utils.IDeviceCallback
            public void onSuccess(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    if (GrowthCollectProcessor.DEBUG) {
                        String str2 = "oaid: " + str;
                    }
                    this.this$0.invokeGenerateActiveStatistic(this.val$activeData, this.val$context, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelStatistic(ChannelData channelData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, this, channelData) == null) || this.ubcManager == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", channelData.getType());
            jSONObject.put("source", channelData.getSource());
            jSONObject.put(GrowthConstant.UBC_KEY_LAUNCH_CH, channelData.getLaunchChannel());
            jSONObject.put(GrowthConstant.UBC_KEY_DOWN_CH, channelData.getDownChannel());
            jSONObject.put("schema", channelData.getSchema());
            JSONObject extend = channelData.getExtend();
            if (extend != null) {
                jSONObject.put("ext", extend);
            }
            if (DEBUG) {
                String str = "channel content: " + jSONObject;
            }
            this.ubcManager.onEvent(GrowthConstant.UBC_ID_CHANNEL, jSONObject);
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeClipBoardStatistic(ClipBoardData clipBoardData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, this, clipBoardData) == null) || this.ubcManager == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
            jSONObject.put("source", clipBoardData.getSource());
            jSONObject.put(GrowthConstant.UBC_KEY_LAUNCH_CH, clipBoardData.getLaunchChanel());
            jSONObject.put(GrowthConstant.UBC_KEY_DOWN_CH, clipBoardData.getDownChannel());
            jSONObject.put("schema", clipBoardData.getSchema());
            JSONObject extend = clipBoardData.getExtend();
            if (extend != null) {
                jSONObject.put("ext", extend);
            }
            if (DEBUG) {
                String str = "clip board content: " + jSONObject;
            }
            this.ubcManager.onEvent(GrowthConstant.UBC_ID_CLIP_BOARD, jSONObject);
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeDeviceStatistic(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65556, this, context) == null) || this.ubcManager == null || context == null) {
            return;
        }
        if (this.mLastDeviceRecordTime == 0) {
            this.mLastDeviceRecordTime = context.getSharedPreferences(GrowthConstant.PREF_NAME, 0).getLong(GrowthConstant.SP_KEY_LAST_DEVICE_RECORD_TIME, 0L);
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mLastDeviceRecordTime;
        if (currentTimeMillis <= 86400000) {
            if (DEBUG) {
                String str = "diffTime: " + currentTimeMillis + ", not record this data";
                return;
            }
            return;
        }
        DeviceUtil.generateOaid(!(context instanceof Application) ? context.getApplicationContext() : context, new IDeviceCallback(this, context) { // from class: com.baidu.searchbox.datacollector.growth.service.GrowthCollectProcessor.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ GrowthCollectProcessor this$0;
            public final /* synthetic */ Context val$context;

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
                this.val$context = context;
            }

            @Override // com.baidu.searchbox.datacollector.growth.utils.IDeviceCallback
            public void onFail() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.invokeGenerateDeviceStatistic(this.val$context, "");
                }
            }

            @Override // com.baidu.searchbox.datacollector.growth.utils.IDeviceCallback
            public void onSuccess(String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) {
                    this.this$0.invokeGenerateDeviceStatistic(this.val$context, str2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeGenerateActiveStatistic(ActiveData activeData, Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65557, this, activeData, context, str) == null) {
            this.mExecutorService.execute(new Runnable(this, activeData, context, str) { // from class: com.baidu.searchbox.datacollector.growth.service.GrowthCollectProcessor.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ GrowthCollectProcessor this$0;
                public final /* synthetic */ ActiveData val$activeData;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ String val$oaid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, activeData, context, str};
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
                    this.val$activeData = activeData;
                    this.val$context = context;
                    this.val$oaid = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.generateActiveStatistic(this.val$activeData, this.val$context, this.val$oaid);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeGenerateDeviceStatistic(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, this, context, str) == null) {
            this.mExecutorService.execute(new Runnable(this, context, str) { // from class: com.baidu.searchbox.datacollector.growth.service.GrowthCollectProcessor.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ GrowthCollectProcessor this$0;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ String val$oaid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, str};
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
                    this.val$context = context;
                    this.val$oaid = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.generateDeviceStatistic(this.val$context, this.val$oaid);
                    }
                }
            });
        }
    }

    public void statisticActiveData(ActiveData activeData, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, activeData, context) == null) || activeData == null || context == null) {
            return;
        }
        this.mExecutorService.execute(new Runnable(this, activeData, context) { // from class: com.baidu.searchbox.datacollector.growth.service.GrowthCollectProcessor.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ GrowthCollectProcessor this$0;
            public final /* synthetic */ ActiveData val$activeData;
            public final /* synthetic */ Context val$context;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, activeData, context};
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
                this.val$activeData = activeData;
                this.val$context = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.invokeActiveStatistic(this.val$activeData, this.val$context);
                }
            }
        });
    }

    public void statisticChannelData(ChannelData channelData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, channelData) == null) || channelData == null) {
            return;
        }
        this.mExecutorService.execute(new Runnable(this, channelData) { // from class: com.baidu.searchbox.datacollector.growth.service.GrowthCollectProcessor.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ GrowthCollectProcessor this$0;
            public final /* synthetic */ ChannelData val$channelData;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, channelData};
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
                this.val$channelData = channelData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.invokeChannelStatistic(this.val$channelData);
                }
            }
        });
    }

    public void statisticClipBoardData(ClipBoardData clipBoardData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, clipBoardData) == null) || clipBoardData == null) {
            return;
        }
        this.mExecutorService.execute(new Runnable(this, clipBoardData) { // from class: com.baidu.searchbox.datacollector.growth.service.GrowthCollectProcessor.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ GrowthCollectProcessor this$0;
            public final /* synthetic */ ClipBoardData val$clipBoardData;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, clipBoardData};
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
                this.val$clipBoardData = clipBoardData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.invokeClipBoardStatistic(this.val$clipBoardData);
                }
            }
        });
    }

    public void statisticDeviceData(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, context) == null) || context == null) {
            return;
        }
        this.mExecutorService.execute(new Runnable(this, context) { // from class: com.baidu.searchbox.datacollector.growth.service.GrowthCollectProcessor.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ GrowthCollectProcessor this$0;
            public final /* synthetic */ Context val$context;

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
                this.val$context = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.invokeDeviceStatistic(this.val$context);
                }
            }
        });
    }
}
