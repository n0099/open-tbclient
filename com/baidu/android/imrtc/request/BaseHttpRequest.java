package com.baidu.android.imrtc.request;

import android.content.Context;
import com.baidu.android.imrtc.BIMRtcManager;
import com.baidu.android.imrtc.request.HttpExecutor;
import com.baidu.android.imrtc.upload.BIMRtcTrack;
import com.baidu.android.imrtc.utils.RtcUtility;
import com.baidu.android.imsdk.utils.Utility;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class BaseHttpRequest implements HttpExecutor.HttpRequest, HttpExecutor.ResponseHandler {
    public Context mContext;
    public String mRtcRoomId = "";

    private String trackExt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.APP_ID, RtcUtility.getAppId(this.mContext));
            jSONObject.put("room_id", this.mRtcRoomId);
            jSONObject.put("uk", Utility.getUK(this.mContext));
            jSONObject.put("cseq_id", -1);
            jSONObject.put("sseq_id", -1);
            jSONObject.put("des", "c_client_response");
            jSONObject.put("ext", "-1");
            return jSONObject.toString();
        } catch (Exception unused) {
            return "trackExt Exception";
        }
    }

    @Override // com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public abstract Map<String, String> getHeaders();

    @Override // com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public abstract String getHost();

    @Override // com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public String getMediaType() {
        return "application/json";
    }

    @Override // com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public String getMethod() {
        return "POST";
    }

    public void report(int i, int i2) {
        if (BIMRtcManager.mBIMRtcEvent != null) {
            BIMRtcManager.mBIMRtcEvent.sdkAction = i;
            BIMRtcManager.mBIMRtcEvent.sdkRoomId = i2 == 0 ? this.mRtcRoomId : "-2";
            BIMRtcManager.mBIMRtcEvent.sdkSeqId = i2;
        }
    }

    public void trackRequest(int i, String str) {
        new BIMRtcTrack.RequestBuilder(this.mContext).method(str).requestId("-1").requestTime(System.currentTimeMillis()).responseTime(System.nanoTime()).aliasId(501210L).errorCode(i).ext(trackExt()).build();
    }
}
