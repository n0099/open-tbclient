package com.baidu.searchbox.cloudcontrol.router;

import android.util.Log;
import com.baidu.searchbox.cloudcontrol.CloudControlManager;
import com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack;
import com.baidu.searchbox.cloudcontrol.data.CloudControlData;
import com.baidu.searchbox.cloudcontrol.data.CloudControlErrorBean;
import com.baidu.searchbox.cloudcontrol.data.CloudControlResponseInfo;
import com.baidu.searchbox.cloudcontrol.data.CloudControlUBCData;
import com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor;
import com.baidu.searchbox.cloudcontrol.utils.CloudControlUBCUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class DataRouter {
    private static final String TAG = "DataRouter";
    private String mErrorMsg;
    private volatile JSONObject mServiceInfo;

    public void routeServiceData(final CloudControlData cloudControlData) {
        if (cloudControlData != null) {
            final JSONObject serviceData = cloudControlData.getServiceData();
            final JSONObject optionsData = cloudControlData.getOptionsData();
            final HashMap<String, Object> checkDatas = cloudControlData.getCheckDatas();
            final HashMap<String, Boolean> isForceDispatchs = cloudControlData.getIsForceDispatchs();
            final CloudControlErrorBean cloudControlErrorBean = cloudControlData.getCloudControlErrorBean();
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.cloudcontrol.router.DataRouter.1
                @Override // java.lang.Runnable
                public void run() {
                    HashMap<String, ICloudControlProcessor> processors = CloudControlManager.getInstance().getProcessors();
                    final CountDownLatch countDownLatch = new CountDownLatch(serviceData != null ? serviceData.length() : 0);
                    DataRouter.this.mServiceInfo = new JSONObject();
                    for (Map.Entry<String, ICloudControlProcessor> entry : processors.entrySet()) {
                        final String key = entry.getKey();
                        boolean has = serviceData != null ? serviceData.has(key) : false;
                        ICloudControlProcessor value = entry.getValue();
                        Object obj = checkDatas.get(key);
                        if (has) {
                            try {
                                JSONObject optJSONObject = serviceData.optJSONObject(key);
                                synchronized (DataRouter.class) {
                                    value.processServiceData(new CloudControlResponseInfo(key, optJSONObject, optionsData, obj, cloudControlErrorBean), new ICloudControlUBCCallBack() { // from class: com.baidu.searchbox.cloudcontrol.router.DataRouter.1.1
                                        @Override // com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack
                                        public void setServiceInfo(JSONObject jSONObject) {
                                            if (jSONObject != null) {
                                                try {
                                                    DataRouter.this.mServiceInfo.put(key, jSONObject);
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
                                            public void setServiceInfo(JSONObject jSONObject) {
                                            }
                                        });
                                    } else {
                                        value.processServiceData(new CloudControlResponseInfo(key, null, optionsData, obj, cloudControlErrorBean), new ICloudControlUBCCallBack() { // from class: com.baidu.searchbox.cloudcontrol.router.DataRouter.1.3
                                            @Override // com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack
                                            public void setServiceInfo(JSONObject jSONObject) {
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
                        countDownLatch.await(10L, TimeUnit.SECONDS);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(String str) {
        this.mErrorMsg += str;
    }

    public String getErrorMsg() {
        return this.mErrorMsg != null ? this.mErrorMsg : "";
    }
}
