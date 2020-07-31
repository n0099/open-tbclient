package com.baidu.searchbox.cloudcontrol.processor;

import com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack;
import com.baidu.searchbox.cloudcontrol.data.CloudControlRequestInfo;
import com.baidu.searchbox.cloudcontrol.data.CloudControlResponseInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public interface ICloudControlProcessor {
    CloudControlRequestInfo getPostData(String str, boolean z, JSONObject jSONObject);

    void processServiceData(CloudControlResponseInfo cloudControlResponseInfo, ICloudControlUBCCallBack iCloudControlUBCCallBack) throws JSONException;
}
