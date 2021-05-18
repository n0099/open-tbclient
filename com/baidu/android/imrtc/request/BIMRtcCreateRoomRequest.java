package com.baidu.android.imrtc.request;

import android.content.Context;
import com.baidu.android.imrtc.request.BIMRtcTokenListener;
import com.baidu.android.imrtc.utils.IMJni;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imrtc.utils.RtcUtility;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BIMRtcCreateRoomRequest extends BaseHttpRequest {
    public static final String TAG = "BIMRtcCreateRoomRequest";
    public static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public BIMRtcTokenListener mListener;
    public String mResourceId;
    public String mSource;

    public BIMRtcCreateRoomRequest(Context context, String str, BIMRtcTokenListener bIMRtcTokenListener) {
        this.mContext = context;
        this.mListener = bIMRtcTokenListener;
        this.mSource = str;
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
        return new HashMap();
    }

    @Override // com.baidu.android.imrtc.request.BaseHttpRequest, com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public String getHost() {
        if (Utility.readIntData(this.mContext, Constants.KEY_ENV, 0) != 0) {
            return "http://rd-im-server.bcc-szth.baidu.com:8080/rtc/rest/1.0/room/create";
        }
        return "https://pim.baidu.com/rtc/rest/1.0/room/create";
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
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", appId);
            jSONObject.put("shoubai_uk", IMJni.transBDUID(Utility.readUid(this.mContext)));
            jSONObject.put("uk", uk);
            jSONObject.put("rtc_device_id", cuid);
            jSONObject.put(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, "" + IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            jSONObject.put("signal_sdk_version", 103010L);
            jSONObject.put("unique_key", "" + currentTimeMillis);
            jSONObject.put("source", this.mSource);
            jSONObject.put(TiebaStatic.Params.RESOURCE_ID, this.mResourceId);
            jSONObject.put("ts", currentTimeMillis);
            jSONObject.put("sign", getMd5("imrtc:" + appId + currentTimeMillis + uk));
            StringBuilder sb = new StringBuilder();
            sb.append("RtcGetTokenRequest msg :");
            sb.append(jSONObject.toString());
            LogUtils.d(TAG, sb.toString());
            return jSONObject.toString().getBytes();
        } catch (Exception e2) {
            LogUtils.e(TAG, "RtcGetTokenRequest exception :", e2);
            return new byte[0];
        }
    }

    @Override // com.baidu.android.imrtc.request.HttpExecutor.ResponseHandler
    public void onFailure(int i2, String str) {
        if (this.mListener != null) {
            report(-10, i2);
            this.mListener.onResult(i2, str, new BIMRtcTokenListener.BIMRTCGetTokeResult());
            trackRequest(i2, "room/create");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.android.imrtc.request.HttpExecutor.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(byte[] bArr) {
        long j;
        JSONException jSONException;
        String str;
        String str2;
        String str3;
        String str4 = "";
        String str5 = new String(bArr);
        LogUtils.e(TAG, "onSuccess :" + str5);
        int i2 = -1;
        long j2 = -1;
        try {
            JSONObject jSONObject = new JSONObject(str5);
            int optInt = jSONObject.optInt("error_code", -1);
            str2 = jSONObject.optString("error_msg", "");
            j2 = jSONObject.optLong("rtc_userid", -1L);
            RtcUtility.setRtcUserId(this.mContext, j2);
            String optString = jSONObject.optString("rtc_room_id", "");
            this.mRtcRoomId = optString;
            RtcUtility.setRtcRoomId(this.mContext, optString);
            str3 = jSONObject.optString(RtcUtility.KEY_RTC_ROOM_TOKEN, "");
            try {
                RtcUtility.setRtcRoomToken(this.mContext, str3);
                str4 = jSONObject.optString("rtc_appid", "");
                RtcUtility.setRtcAppId(this.mContext, str4);
                i2 = optInt;
            } catch (JSONException e2) {
                j = j2;
                jSONException = e2;
                str = str4;
                str4 = str3;
                LogUtils.e(TAG, "JSONException", jSONException);
                str2 = "ERROR_MSG_JSON_PARSE_EXCEPTION";
                str3 = str4;
                str4 = str;
                j2 = j;
                if (this.mListener == null) {
                }
            }
        } catch (JSONException e3) {
            j = j2;
            jSONException = e3;
            str = "";
        }
        if (this.mListener == null) {
            BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult = new BIMRtcTokenListener.BIMRTCGetTokeResult();
            bIMRTCGetTokeResult.roomId = this.mRtcRoomId;
            bIMRTCGetTokeResult.useId = j2;
            bIMRTCGetTokeResult.token = str3;
            bIMRTCGetTokeResult.rtcAppId = str4;
            report(-10, i2);
            this.mListener.onResult(i2, str2, bIMRTCGetTokeResult);
            trackRequest(i2, "room/create");
        }
    }

    @Override // com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public boolean shouldAbort() {
        return false;
    }

    public BIMRtcCreateRoomRequest(Context context, String str, String str2, BIMRtcTokenListener bIMRtcTokenListener) {
        this.mContext = context;
        this.mListener = bIMRtcTokenListener;
        this.mSource = str;
        this.mResourceId = str2;
    }
}
