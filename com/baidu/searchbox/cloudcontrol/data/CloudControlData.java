package com.baidu.searchbox.cloudcontrol.data;

import com.baidu.searchbox.cloudcontrol.processor.IProcessorDataInterceptor;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CloudControlData {
    public HashMap<String, Object> mCheckDatas;
    public CloudControlErrorBean mCloudControlErrorBean;
    public CloudControlUBCData mCloudControlUBCData;
    public HashMap<String, IProcessorDataInterceptor> mDataInterceptors;
    public HashMap<String, Boolean> mIsForceDispatchs;
    public JSONObject mOptionsData;
    public JSONObject mServiceDatas;

    public CloudControlData() {
    }

    public HashMap<String, Object> getCheckDatas() {
        if (this.mCheckDatas == null) {
            this.mCheckDatas = new HashMap<>();
        }
        return this.mCheckDatas;
    }

    public CloudControlErrorBean getCloudControlErrorBean() {
        return this.mCloudControlErrorBean;
    }

    public CloudControlUBCData getCloudControlUBCData() {
        if (this.mCloudControlUBCData == null) {
            this.mCloudControlUBCData = new CloudControlUBCData();
        }
        return this.mCloudControlUBCData;
    }

    public HashMap<String, IProcessorDataInterceptor> getDataInterceptors() {
        HashMap<String, IProcessorDataInterceptor> hashMap = this.mDataInterceptors;
        if (hashMap == null) {
            return new HashMap<>();
        }
        return hashMap;
    }

    public HashMap<String, Boolean> getIsForceDispatchs() {
        if (this.mIsForceDispatchs == null) {
            this.mIsForceDispatchs = new HashMap<>();
        }
        return this.mIsForceDispatchs;
    }

    public JSONObject getOptionsData() {
        return this.mOptionsData;
    }

    public JSONObject getServiceData() {
        return this.mServiceDatas;
    }

    public CloudControlData(JSONObject jSONObject) {
        this.mServiceDatas = jSONObject;
    }

    public void setCheckDatas(HashMap<String, Object> hashMap) {
        this.mCheckDatas = hashMap;
    }

    public void setCloudControlErrorBean(CloudControlErrorBean cloudControlErrorBean) {
        this.mCloudControlErrorBean = cloudControlErrorBean;
    }

    public void setCloudControlUBCData(CloudControlUBCData cloudControlUBCData) {
        this.mCloudControlUBCData = cloudControlUBCData;
    }

    public void setDataInterceptor(HashMap<String, IProcessorDataInterceptor> hashMap) {
        this.mDataInterceptors = hashMap;
    }

    public void setIsForceDispatchs(HashMap<String, Boolean> hashMap) {
        this.mIsForceDispatchs = hashMap;
    }

    public void setOptionsData(JSONObject jSONObject) {
        this.mOptionsData = jSONObject;
    }

    public void setServiceData(JSONObject jSONObject) {
        this.mServiceDatas = jSONObject;
    }
}
