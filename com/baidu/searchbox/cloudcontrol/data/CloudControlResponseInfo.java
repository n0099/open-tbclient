package com.baidu.searchbox.cloudcontrol.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CloudControlResponseInfo {
    public Object mCheckData;
    public CloudControlErrorBean mCloudControlErrorBean;
    public JSONObject mOption;
    public JSONObject mServiceData;
    public String mServiceName;

    public CloudControlResponseInfo(String str, JSONObject jSONObject, JSONObject jSONObject2, Object obj, CloudControlErrorBean cloudControlErrorBean) {
        this.mServiceName = str;
        this.mServiceData = jSONObject;
        this.mOption = jSONObject2;
        this.mCheckData = obj;
        this.mCloudControlErrorBean = cloudControlErrorBean;
    }

    public Object getCheckData() {
        return this.mCheckData;
    }

    public CloudControlErrorBean getCloudControlErrorBean() {
        return this.mCloudControlErrorBean;
    }

    public JSONObject getOption() {
        return this.mOption;
    }

    public JSONObject getServiceData() {
        return this.mServiceData;
    }

    public String getServiceName() {
        return this.mServiceName;
    }
}
