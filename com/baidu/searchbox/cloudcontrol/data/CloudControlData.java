package com.baidu.searchbox.cloudcontrol.data;

import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CloudControlData {
    public HashMap<String, Object> mCheckDatas;
    public CloudControlErrorBean mCloudControlErrorBean;
    public CloudControlUBCData mCloudControlUBCData;
    public HashMap<String, Boolean> mIsForceDispatchs;
    public JSONObject mOptionsData;
    public JSONObject mServiceDatas;

    public CloudControlData(JSONObject jSONObject) {
        this.mServiceDatas = jSONObject;
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

    public void setCheckDatas(HashMap<String, Object> hashMap) {
        this.mCheckDatas = hashMap;
    }

    public void setCloudControlErrorBean(CloudControlErrorBean cloudControlErrorBean) {
        this.mCloudControlErrorBean = cloudControlErrorBean;
    }

    public void setCloudControlUBCData(CloudControlUBCData cloudControlUBCData) {
        this.mCloudControlUBCData = cloudControlUBCData;
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

    public CloudControlData() {
    }
}
