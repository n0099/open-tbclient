package com.baidu.searchbox.cloudcontrol.router;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.CloudControlManager;
import com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack;
import com.baidu.searchbox.cloudcontrol.data.CloudControlData;
import com.baidu.searchbox.cloudcontrol.data.CloudControlErrorBean;
import com.baidu.searchbox.cloudcontrol.data.CloudControlResponseInfo;
import com.baidu.searchbox.cloudcontrol.data.CloudControlUBCData;
import com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor;
import com.baidu.searchbox.cloudcontrol.processor.IProcessorDataInterceptor;
import com.baidu.searchbox.cloudcontrol.utils.CloudControlUBCUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DataRouter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DataRouter";
    public transient /* synthetic */ FieldHolder $fh;
    public String mErrorMsg;
    public volatile JSONObject mServiceInfo;

    public DataRouter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String getErrorMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = this.mErrorMsg;
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
            this.mErrorMsg += str;
        }
    }

    public void routeServiceData(CloudControlData cloudControlData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cloudControlData) != null) || cloudControlData == null) {
            return;
        }
        JSONObject serviceData = cloudControlData.getServiceData();
        JSONObject optionsData = cloudControlData.getOptionsData();
        ExecutorUtilsExt.postOnElastic(new Runnable(this, serviceData, cloudControlData.getCheckDatas(), cloudControlData.getDataInterceptors(), optionsData, cloudControlData.getCloudControlErrorBean(), cloudControlData.getIsForceDispatchs(), cloudControlData) { // from class: com.baidu.searchbox.cloudcontrol.router.DataRouter.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DataRouter this$0;
            public final /* synthetic */ HashMap val$checkDatas;
            public final /* synthetic */ CloudControlData val$cloudControlData;
            public final /* synthetic */ CloudControlErrorBean val$cloudControlErrorBean;
            public final /* synthetic */ HashMap val$dataInterceptors;
            public final /* synthetic */ HashMap val$forceDispatchs;
            public final /* synthetic */ JSONObject val$options;
            public final /* synthetic */ JSONObject val$serviceData;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, serviceData, r8, r9, optionsData, r11, r12, cloudControlData};
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
                this.val$serviceData = serviceData;
                this.val$checkDatas = r8;
                this.val$dataInterceptors = r9;
                this.val$options = optionsData;
                this.val$cloudControlErrorBean = r11;
                this.val$forceDispatchs = r12;
                this.val$cloudControlData = cloudControlData;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i;
                boolean z;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    HashMap<String, ICloudControlProcessor> processors = CloudControlManager.getInstance().getProcessors();
                    JSONObject jSONObject = this.val$serviceData;
                    if (jSONObject != null) {
                        i = jSONObject.length();
                    } else {
                        i = 0;
                    }
                    CountDownLatch countDownLatch = new CountDownLatch(i);
                    this.this$0.mServiceInfo = new JSONObject();
                    for (Map.Entry<String, ICloudControlProcessor> entry : processors.entrySet()) {
                        String key = entry.getKey();
                        JSONObject jSONObject2 = this.val$serviceData;
                        if (jSONObject2 != null) {
                            z = jSONObject2.has(key);
                        } else {
                            z = false;
                        }
                        ICloudControlProcessor value = entry.getValue();
                        Object obj = this.val$checkDatas.get(key);
                        IProcessorDataInterceptor iProcessorDataInterceptor = (IProcessorDataInterceptor) this.val$dataInterceptors.get(key);
                        if (iProcessorDataInterceptor != null) {
                            iProcessorDataInterceptor.onIntercept(this.val$serviceData);
                        }
                        if (z) {
                            try {
                                JSONObject optJSONObject = this.val$serviceData.optJSONObject(key);
                                synchronized (DataRouter.class) {
                                    value.processServiceData(new CloudControlResponseInfo(key, optJSONObject, this.val$options, obj, this.val$cloudControlErrorBean), new ICloudControlUBCCallBack(this, key, countDownLatch) { // from class: com.baidu.searchbox.cloudcontrol.router.DataRouter.1.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass1 this$1;
                                        public final /* synthetic */ CountDownLatch val$countDownLatch;
                                        public final /* synthetic */ String val$serviceName;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, key, countDownLatch};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$1 = this;
                                            this.val$serviceName = key;
                                            this.val$countDownLatch = countDownLatch;
                                        }

                                        @Override // com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack
                                        public void setServiceInfo(JSONObject jSONObject3) {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeL(1048576, this, jSONObject3) == null) {
                                                if (jSONObject3 != null) {
                                                    try {
                                                        this.this$1.this$0.mServiceInfo.put(this.val$serviceName, jSONObject3);
                                                    } catch (JSONException e) {
                                                        if (AppConfig.isDebug()) {
                                                            Log.d(DataRouter.TAG, "routeServiceData back json is error" + e.toString());
                                                        }
                                                    }
                                                }
                                                this.val$countDownLatch.countDown();
                                            }
                                        }
                                    });
                                }
                            } catch (Exception e) {
                                this.this$0.onError(e.getMessage());
                            }
                        } else {
                            Boolean bool = (Boolean) this.val$forceDispatchs.get(key);
                            if (bool != null && bool.booleanValue()) {
                                try {
                                    if (this.val$serviceData != null) {
                                        CloudControlErrorBean cloudControlErrorBean = new CloudControlErrorBean();
                                        cloudControlErrorBean.setErrorCode(3);
                                        cloudControlErrorBean.setSubErrorCode(31);
                                        value.processServiceData(new CloudControlResponseInfo(key, null, this.val$options, obj, cloudControlErrorBean), new ICloudControlUBCCallBack(this) { // from class: com.baidu.searchbox.cloudcontrol.router.DataRouter.1.2
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;
                                            public final /* synthetic */ AnonymousClass1 this$1;

                                            @Override // com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack
                                            public void setServiceInfo(JSONObject jSONObject3) {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, jSONObject3) == null) {
                                                }
                                            }

                                            {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 != null) {
                                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                                    newInitContext.initArgs = r2;
                                                    Object[] objArr = {this};
                                                    interceptable3.invokeUnInit(65536, newInitContext);
                                                    int i2 = newInitContext.flag;
                                                    if ((i2 & 1) != 0) {
                                                        int i3 = i2 & 2;
                                                        newInitContext.thisArg = this;
                                                        interceptable3.invokeInitBody(65536, newInitContext);
                                                        return;
                                                    }
                                                }
                                                this.this$1 = this;
                                            }
                                        });
                                    } else {
                                        value.processServiceData(new CloudControlResponseInfo(key, null, this.val$options, obj, this.val$cloudControlErrorBean), new ICloudControlUBCCallBack(this) { // from class: com.baidu.searchbox.cloudcontrol.router.DataRouter.1.3
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;
                                            public final /* synthetic */ AnonymousClass1 this$1;

                                            @Override // com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack
                                            public void setServiceInfo(JSONObject jSONObject3) {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, jSONObject3) == null) {
                                                }
                                            }

                                            {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 != null) {
                                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                                    newInitContext.initArgs = r2;
                                                    Object[] objArr = {this};
                                                    interceptable3.invokeUnInit(65536, newInitContext);
                                                    int i2 = newInitContext.flag;
                                                    if ((i2 & 1) != 0) {
                                                        int i3 = i2 & 2;
                                                        newInitContext.thisArg = this;
                                                        interceptable3.invokeInitBody(65536, newInitContext);
                                                        return;
                                                    }
                                                }
                                                this.this$1 = this;
                                            }
                                        });
                                    }
                                } catch (JSONException e2) {
                                    this.this$0.onError(e2.getMessage());
                                }
                            }
                        }
                    }
                    try {
                        countDownLatch.await(15L, TimeUnit.SECONDS);
                    } catch (InterruptedException e3) {
                        if (AppConfig.isDebug()) {
                            Log.d(DataRouter.TAG, "processServiceData method need call  cloudControlUBCCallBack " + e3.toString());
                            e3.printStackTrace();
                        }
                    }
                    CloudControlUBCData cloudControlUBCData = this.val$cloudControlData.getCloudControlUBCData();
                    cloudControlUBCData.collectServiceInfo(this.this$0.mServiceInfo);
                    new CloudControlUBCUtils().doStatistics(cloudControlUBCData);
                }
            }
        }, "routeServiceData", 0);
    }
}
