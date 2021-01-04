package com.baidu.android.imrtc.request;

import android.content.Context;
import com.baidu.android.imrtc.request.BIMRtcTokenListener;
import com.baidu.android.imrtc.utils.IMJni;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imrtc.utils.RtcConstants;
import com.baidu.android.imrtc.utils.RtcUtility;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import com.baidu.sapi2.SapiContext;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class BIMRtcCreateRoomRequest extends BaseHttpRequest {
    private static final String TAG = "BIMRtcCreateRoomRequest";
    private static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private BIMRtcTokenListener mListener;
    private String mRtcRoomId = "";
    private String mSource;

    public BIMRtcCreateRoomRequest(Context context, String str, BIMRtcTokenListener bIMRtcTokenListener) {
        this.mContext = context;
        this.mListener = bIMRtcTokenListener;
        this.mSource = str;
    }

    @Override // com.baidu.android.imrtc.request.BaseHttpRequest, com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public String getHost() {
        return Utility.readIntData(this.mContext, Constants.KEY_ENV, 0) != 0 ? HttpConstants.TEST_URL + "rtc/rest/1.0/room/create" : "https://pim.baidu.com/rtc/rest/1.0/room/create";
    }

    @Override // com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public boolean shouldAbort() {
        return false;
    }

    @Override // com.baidu.android.imrtc.request.BaseHttpRequest, com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public String getMethod() {
        return "POST";
    }

    @Override // com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public byte[] getRequestParameter() {
        try {
            long appId = RtcUtility.getAppId(this.mContext);
            String cuid = RtcUtility.getCuid(this.mContext);
            long j = RtcConstants.RTC_VERSION;
            long uk = Utility.getUK(this.mContext);
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", appId);
            jSONObject.put("shoubai_uk", IMJni.transBDUID("" + Utility.getBuid(this.mContext)));
            jSONObject.put("uk", uk);
            jSONObject.put("rtc_device_id", cuid);
            jSONObject.put(SapiContext.KEY_SDK_VERSION, "" + IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            jSONObject.put("signal_sdk_version", j);
            jSONObject.put("unique_key", "" + currentTimeMillis);
            jSONObject.put("source", this.mSource);
            jSONObject.put("ts", currentTimeMillis);
            jSONObject.put("sign", getMd5("imrtc:" + appId + currentTimeMillis + uk));
            LogUtils.d(TAG, "RtcGetTokenRequest msg :" + jSONObject.toString());
            return jSONObject.toString().getBytes();
        } catch (Exception e) {
            LogUtils.e(TAG, "RtcGetTokenRequest exception :", e);
            return new byte[0];
        }
    }

    private String getMd5(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
        messageDigest.update(str.getBytes());
        return byte2Hex(messageDigest.digest());
    }

    private static String byte2Hex(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            char c = hexDigits[(b2 & 240) >> 4];
            char c2 = hexDigits[b2 & 15];
            sb.append(c);
            sb.append(c2);
        }
        return sb.toString();
    }

    @Override // com.baidu.android.imrtc.request.BaseHttpRequest, com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public Map<String, String> getHeaders() {
        return new HashMap();
    }

    @Override // com.baidu.android.imrtc.request.HttpExecutor.ResponseHandler
    public void onSuccess(byte[] bArr) {
        String str;
        int i;
        long j = -1;
        String str2 = new String(bArr);
        LogUtils.e(TAG, "onSuccess :" + str2);
        String str3 = "";
        String str4 = "";
        try {
            JSONObject jSONObject = new JSONObject(str2);
            i = jSONObject.optInt("error_code", -1);
            str = jSONObject.optString("error_msg", "");
            j = jSONObject.optLong("rtc_userid", -1L);
            RtcUtility.setRtcUserId(this.mContext, j);
            this.mRtcRoomId = jSONObject.optString("rtc_room_id", "");
            RtcUtility.setRtcRoomId(this.mContext, this.mRtcRoomId);
            str3 = jSONObject.optString("rtc_room_token", "");
            RtcUtility.setRtcRoomToken(this.mContext, str3);
            str4 = jSONObject.optString("rtc_appid", "");
            RtcUtility.setRtcAppId(this.mContext, str4);
        } catch (JSONException e) {
            LogUtils.e(TAG, "JSONException", e);
            str = "ERROR_MSG_JSON_PARSE_EXCEPTION";
            i = -1;
        }
        if (this.mListener != null) {
            BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult = new BIMRtcTokenListener.BIMRTCGetTokeResult();
            bIMRTCGetTokeResult.roomId = this.mRtcRoomId;
            bIMRTCGetTokeResult.useId = j;
            bIMRTCGetTokeResult.token = str3;
            bIMRTCGetTokeResult.rtcAppId = str4;
            this.mListener.onResult(i, str, bIMRTCGetTokeResult);
            trackRequest(i, "room/create");
        }
    }

    @Override // com.baidu.android.imrtc.request.HttpExecutor.ResponseHandler
    public void onFailure(int i, String str) {
        if (this.mListener != null) {
            this.mListener.onResult(i, str, new BIMRtcTokenListener.BIMRTCGetTokeResult());
            trackRequest(i, "room/create");
        }
    }
}
