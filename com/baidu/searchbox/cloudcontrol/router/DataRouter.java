package com.baidu.searchbox.cloudcontrol.router;

import android.util.Log;
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
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DataRouter {
    public static final String TAG = "DataRouter";
    public String mErrorMsg;
    public volatile JSONObject mServiceInfo;

    public String getErrorMsg() {
        String str = this.mErrorMsg;
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(String str) {
        this.mErrorMsg += str;
    }

    public void routeServiceData(final CloudControlData cloudControlData) {
        if (cloudControlData == null) {
            return;
        }
        final JSONObject serviceData = cloudControlData.getServiceData();
        final JSONObject optionsData = cloudControlData.getOptionsData();
        final HashMap<String, Object> checkDatas = cloudControlData.getCheckDatas();
        final HashMap<String, Boolean> isForceDispatchs = cloudControlData.getIsForceDispatchs();
        final HashMap<String, IProcessorDataInterceptor> dataInterceptors = cloudControlData.getDataInterceptors();
        final CloudControlErrorBean cloudControlErrorBean = cloudControlData.getCloudControlErrorBean();
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.cloudcontrol.router.DataRouter.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                boolean z;
                HashMap<String, ICloudControlProcessor> processors = CloudControlManager.getInstance().getProcessors();
                JSONObject jSONObject = serviceData;
                if (jSONObject != null) {
                    i = jSONObject.length();
                } else {
                    i = 0;
                }
                final CountDownLatch countDownLatch = new CountDownLatch(i);
                DataRouter.this.mServiceInfo = new JSONObject();
                for (Map.Entry<String, ICloudControlProcessor> entry : processors.entrySet()) {
                    final String key = entry.getKey();
                    JSONObject jSONObject2 = serviceData;
                    if (jSONObject2 != null) {
                        z = jSONObject2.has(key);
                    } else {
                        z = false;
                    }
                    ICloudControlProcessor value = entry.getValue();
                    Object obj = checkDatas.get(key);
                    IProcessorDataInterceptor iProcessorDataInterceptor = (IProcessorDataInterceptor) dataInterceptors.get(key);
                    if (iProcessorDataInterceptor != null) {
                        iProcessorDataInterceptor.onIntercept(serviceData);
                    }
                    if (z) {
                        try {
                            JSONObject optJSONObject = serviceData.optJSONObject(key);
                            synchronized (DataRouter.class) {
                                value.processServiceData(new CloudControlResponseInfo(key, optJSONObject, optionsData, obj, cloudControlErrorBean), new ICloudControlUBCCallBack() { // from class: com.baidu.searchbox.cloudcontrol.router.DataRouter.1.1
                                    @Override // com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack
                                    public void setServiceInfo(JSONObject jSONObject3) {
                                        if (jSONObject3 != null) {
                                            try {
                                                DataRouter.this.mServiceInfo.put(key, jSONObject3);
                                            } catch (JSONException e) {
                                                if (AppConfig.isDebug()) {
                                                    Log.d(DataRouter.TAG, "routeServiceData back json is error" + e.toString());
                                                }
                                            }
                                        }
                                        countDownLatch.countDown();
                                    }
                                });
                            }
                        } catch (Exception e) {
                            DataRouter.this.onError(e.getMessage());
                        }
                    } else {
                        Boolean bool = (Boolean) isForceDispatchs.get(key);
                        if (bool != null && bool.booleanValue()) {
                            try {
                                if (serviceData != null) {
                                    CloudControlErrorBean cloudControlErrorBean2 = new CloudControlErrorBean();
                                    cloudControlErrorBean2.setErrorCode(3);
                                    cloudControlErrorBean2.setSubErrorCode(31);
                                    value.processServiceData(new CloudControlResponseInfo(key, null, optionsData, obj, cloudControlErrorBean2), new ICloudControlUBCCallBack() { // from class: com.baidu.searchbox.cloudcontrol.router.DataRouter.1.2
                                        @Override // com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack
                                        public void setServiceInfo(JSONObject jSONObject3) {
                                        }
                                    });
                                } else {
                                    value.processServiceData(new CloudControlResponseInfo(key, null, optionsData, obj, cloudControlErrorBean), new ICloudControlUBCCallBack() { // from class: com.baidu.searchbox.cloudcontrol.router.DataRouter.1.3
                                        @Override // com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack
                                        public void setServiceInfo(JSONObject jSONObject3) {
                                        }
                                    });
                                }
                            } catch (JSONException e2) {
                                DataRouter.this.onError(e2.getMessage());
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
                CloudControlUBCData cloudControlUBCData = cloudControlData.getCloudControlUBCData();
                cloudControlUBCData.collectServiceInfo(DataRouter.this.mServiceInfo);
                new CloudControlUBCUtils().doStatistics(cloudControlUBCData);
            }
        }, "routeServiceData", 0);
    }
}
