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
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BIMRtcGetTokenRequest extends BaseHttpRequest {
    public static final String TAG = "BIMRtcGetTokenRequest";
    public static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public BIMRtcTokenListener mListener;
    public String mRtcRoomId;
    public long mRtcUserId;
    public String mSource;

    public BIMRtcGetTokenRequest(Context context, String str, String str2, long j, BIMRtcTokenListener bIMRtcTokenListener) {
        this.mSource = "";
        this.mRtcRoomId = "";
        this.mRtcUserId = -1L;
        this.mContext = context;
        this.mListener = bIMRtcTokenListener;
        this.mSource = str;
        this.mRtcRoomId = str2;
        this.mRtcUserId = j;
    }

    public static String byte2Hex(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            char[] cArr = hexDigits;
            char c2 = cArr[(b2 & 240) >> 4];
            char c3 = cArr[b2 & 15];
            sb.append(c2);
            sb.append(c3);
        }
        return sb.toString();
    }

    private String getMd5(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(str.getBytes());
        return byte2Hex(messageDigest.digest());
    }

    @Override // com.baidu.android.imrtc.request.BaseHttpRequest, com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        hashMap.put("Cookie", "BDUSS=" + bduss);
        return hashMap;
    }

    @Override // com.baidu.android.imrtc.request.BaseHttpRequest, com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public String getHost() {
        if (Utility.readIntData(this.mContext, Constants.KEY_ENV, 0) != 0) {
            return "http://rd-im-server.bcc-szth.baidu.com:8080/rtc/rest/1.0/room/get_rtc_token";
        }
        return "https://pim.baidu.com/rtc/rest/1.0/room/get_rtc_token";
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
            long uk = Utility.getUK(this.mContext);
            int sDKVersionValue = IMConfigInternal.getInstance().getSDKVersionValue(this.mContext);
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", appId);
            jSONObject.put("room_id", this.mRtcRoomId);
            RtcUtility.setRtcRoomId(this.mContext, this.mRtcRoomId);
            jSONObject.put(RtcUtility.KEY_RTC_USER_ID, this.mRtcUserId);
            RtcUtility.setRtcUserId(this.mContext, this.mRtcUserId);
            jSONObject.put("shoubai_uk", IMJni.transBDUID("" + Utility.getBuid(this.mContext)));
            jSONObject.put("rtc_device_id", cuid);
            jSONObject.put("sdk_version", sDKVersionValue);
            jSONObject.put("signal_sdk_version", (long) RtcConstants.RTC_VERSION);
            jSONObject.put("unique_key", "" + currentTimeMillis);
            jSONObject.put("source", this.mSource);
            jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, currentTimeMillis);
            jSONObject.put("sign", getMd5("imrtc:" + appId + currentTimeMillis + uk));
            StringBuilder sb = new StringBuilder();
            sb.append("RtcGetTokenRequest msg :");
            sb.append(jSONObject.toString());
            LogUtils.d(TAG, sb.toString());
            return jSONObject.toString().getBytes();
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    @Override // com.baidu.android.imrtc.request.HttpExecutor.ResponseHandler
    public void onFailure(int i, String str) {
        if (this.mListener != null) {
            report(-11, i);
            this.mListener.onResult(i, str, new BIMRtcTokenListener.BIMRTCGetTokeResult());
            trackRequest(i, "room/get_rtc_token");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.android.imrtc.request.HttpExecutor.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(byte[] bArr) {
        JSONException jSONException;
        String str;
        String str2;
        String str3;
        String str4 = "";
        String str5 = new String(bArr);
        LogUtils.e(TAG, "onSuccess :" + str5);
        int i = -1;
        try {
            JSONObject jSONObject = new JSONObject(str5);
            int optInt = jSONObject.optInt("error_code", -1);
            str2 = jSONObject.optString("error_msg", "");
            str3 = jSONObject.optString(RtcUtility.KEY_RTC_ROOM_TOKEN, "");
            try {
                RtcUtility.setRtcRoomToken(this.mContext, str3);
                str4 = jSONObject.optString("rtc_appid", "");
                RtcUtility.setRtcAppId(this.mContext, str4);
                i = optInt;
            } catch (JSONException e2) {
                jSONException = e2;
                str = str4;
                str4 = str3;
                LogUtils.e(TAG, "JSONException", jSONException);
                str2 = "ERROR_MSG_JSON_PARSE_EXCEPTION";
                str3 = str4;
                str4 = str;
                if (this.mListener == null) {
                }
            }
        } catch (JSONException e3) {
            jSONException = e3;
            str = "";
        }
        if (this.mListener == null) {
            BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult = new BIMRtcTokenListener.BIMRTCGetTokeResult();
            bIMRTCGetTokeResult.roomId = this.mRtcRoomId;
            bIMRTCGetTokeResult.useId = this.mRtcUserId;
            bIMRTCGetTokeResult.token = str3;
            bIMRTCGetTokeResult.rtcAppId = str4;
            report(-11, i);
            this.mListener.onResult(i, str2, bIMRTCGetTokeResult);
            trackRequest(i, "room/get_rtc_token");
        }
    }

    @Override // com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public boolean shouldAbort() {
        return false;
    }
}
