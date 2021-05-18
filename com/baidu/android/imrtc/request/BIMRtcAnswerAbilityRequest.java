package com.baidu.android.imrtc.request;

import android.content.Context;
import com.baidu.android.imrtc.request.BIMRtcAnswerAbilityListener;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imrtc.utils.RtcUtility;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.Utility;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BIMRtcAnswerAbilityRequest extends BaseHttpRequest {
    public static final String TAG = "BIMRtcAnswerAbilityRequest";
    public BIMRtcAnswerAbilityListener mListener;
    public String mSource;

    public BIMRtcAnswerAbilityRequest(Context context, String str, String str2, BIMRtcAnswerAbilityListener bIMRtcAnswerAbilityListener) {
        this.mContext = context;
        this.mListener = bIMRtcAnswerAbilityListener;
        this.mSource = str;
        this.mRtcRoomId = str2;
    }

    @Override // com.baidu.android.imrtc.request.BaseHttpRequest, com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public Map<String, String> getHeaders() {
        return new HashMap();
    }

    @Override // com.baidu.android.imrtc.request.BaseHttpRequest, com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public String getHost() {
        if (Utility.readIntData(this.mContext, Constants.KEY_ENV, 0) != 0) {
            return "http://rd-im-server.bcc-szth.baidu.com:8080/rtc/rest/1.0/room/check_answer_ability";
        }
        return "https://pim.baidu.com/rtc/rest/1.0/room/check_answer_ability";
    }

    @Override // com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public byte[] getRequestParameter() {
        long appId = RtcUtility.getAppId(this.mContext);
        long uk = Utility.getUK(this.mContext);
        String cuid = RtcUtility.getCuid(this.mContext);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", appId);
            jSONObject.put("uk", uk);
            jSONObject.put("cuid", cuid);
            jSONObject.put("room_id", this.mRtcRoomId);
            jSONObject.put("source", this.mSource);
            LogUtils.d(TAG, "RtcGetTokenRequest msg :" + jSONObject.toString());
            return jSONObject.toString().getBytes();
        } catch (JSONException e2) {
            LogUtils.e(TAG, "RtcGetTokenRequest exception :", e2);
            return new byte[0];
        }
    }

    @Override // com.baidu.android.imrtc.request.HttpExecutor.ResponseHandler
    public void onFailure(int i2, String str) {
        LogUtils.e(TAG, "onFailure : errorCOde = " + i2 + " , errorMsg =  " + str);
        this.mListener.onResult(i2, str, null);
    }

    @Override // com.baidu.android.imrtc.request.HttpExecutor.ResponseHandler
    public void onSuccess(byte[] bArr) {
        String str = new String(bArr);
        LogUtils.e(TAG, "onSuccess :" + str);
        BIMRtcAnswerAbilityListener.BIMRtcAnswerAbilityResult bIMRtcAnswerAbilityResult = new BIMRtcAnswerAbilityListener.BIMRtcAnswerAbilityResult();
        String str2 = "";
        int i2 = -1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            i2 = jSONObject.optInt("error_code");
            str2 = jSONObject.optString("error_msg");
            JSONObject optJSONObject = jSONObject.optJSONObject("payload");
            bIMRtcAnswerAbilityResult.ability = optJSONObject.optInt("ability");
            bIMRtcAnswerAbilityResult.rtcToken = optJSONObject.optString("token");
            bIMRtcAnswerAbilityResult.rtcAppId = optJSONObject.optString("rtc_appid");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.mListener.onResult(i2, str2, bIMRtcAnswerAbilityResult);
    }

    @Override // com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public boolean shouldAbort() {
        return false;
    }
}
