package com.baidu.searchbox.cloudcontrol.data;

import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class CloudControlData {
    private HashMap<String, Object> mCheckDatas;
    private CloudControlErrorBean mCloudControlErrorBean;
    private CloudControlUBCData mCloudControlUBCData;
    private HashMap<String, Boolean> mIsForceDispatchs;
    private JSONObject mOptionsData;
    private JSONObject mServiceDatas;

    public CloudControlData(JSONObject jSONObject) {
        this.mServiceDatas = jSONObject;
    }

    public CloudControlData() {
    }

    public HashMap<String, Object> getCheckDatas() {
        if (this.mCheckDatas == null) {
            this.mCheckDatas = new HashMap<>();
        }
        return this.mCheckDatas;
    }

    public void setCheckDatas(HashMap<String, Object> hashMap) {
        this.mCheckDatas = hashMap;
    }

    public JSONObject getOptionsData() {
        return this.mOptionsData;
    }

    public void setOptionsData(JSONObject jSONObject) {
        this.mOptionsData = jSONObject;
    }

    public JSONObject getServiceData() {
        return this.mServiceDatas;
    }

    public void setServiceData(JSONObject jSONObject) {
        this.mServiceDatas = jSONObject;
    }

    public CloudControlErrorBean getCloudControlErrorBean() {
        return this.mCloudControlErrorBean;
    }

    public void setCloudControlErrorBean(CloudControlErrorBean cloudControlErrorBean) {
        this.mCloudControlErrorBean = cloudControlErrorBean;
    }

    public HashMap<String, Boolean> getIsForceDispatchs() {
        if (this.mIsForceDispatchs == null) {
            this.mIsForceDispatchs = new HashMap<>();
        }
        return this.mIsForceDispatchs;
    }

    public void setIsForceDispatchs(HashMap<String, Boolean> hashMap) {
        this.mIsForceDispatchs = hashMap;
    }

    public CloudControlUBCData getCloudControlUBCData() {
        if (this.mCloudControlUBCData == null) {
            this.mCloudControlUBCData = new CloudControlUBCData();
        }
        return this.mCloudControlUBCData;
    }

    public void setCloudControlUBCData(CloudControlUBCData cloudControlUBCData) {
        this.mCloudControlUBCData = cloudControlUBCData;
    }
}
