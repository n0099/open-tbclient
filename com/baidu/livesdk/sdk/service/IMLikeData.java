package com.baidu.livesdk.sdk.service;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.wallet.base.iddetect.IdCardActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class IMLikeData {
    public String appVersion;
    public int callFlag;
    public String cuid;
    public long num;
    public long roomId;
    public int sourceType;
    public long uid;
    public int version = 1;

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("room_id", this.roomId);
        jSONObject.put("source_type", 0);
        jSONObject.put("uid", this.uid);
        jSONObject.put(IdCardActivity.KEY_NUMBER, this.num);
        jSONObject.put("app_version", this.appVersion);
        jSONObject.put("source_type", this.sourceType);
        jSONObject.put("caller_flag", this.callFlag);
        jSONObject.put("version", this.version);
        jSONObject.put(Constants.KEY_DEVICE_ID, this.cuid);
        return jSONObject.toString();
    }
}
