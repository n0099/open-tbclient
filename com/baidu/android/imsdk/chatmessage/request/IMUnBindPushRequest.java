package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.chatmessage.BindStateManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.util.io.BaseJsonData;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class IMUnBindPushRequest extends BaseHttpRequest {
    public Long mAppid;
    public String mBduss;
    public String mDeviceId;
    public Long mUk;

    public IMUnBindPushRequest(Context context, long j, String str, String str2, Long l) {
        this.mContext = context;
        this.mAppid = Long.valueOf(j);
        this.mBduss = str;
        this.mDeviceId = str2;
        this.mUk = l;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put("Cookie", "BDUSS=" + this.mBduss);
        return hashMap;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        return BaseHttpRequest.getHostUrl(this.mContext) + "rest/2.0/im/bind_push?method=unbind";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "POST";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return ("method=unbind&appid=" + this.mAppid + "&device_id=" + this.mDeviceId + "&uk=" + this.mUk + "&timestamp=" + currentTimeMillis + "&sdk_version=" + IMConfigInternal.getInstance().getSDKVersionValue(this.mContext) + "&sign=" + getMd5("" + currentTimeMillis + this.mBduss + this.mAppid)).getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        LogUtils.d("IMUnBindPushRequest", "  errorCode: " + transErrorCode.first);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        String str;
        int i2;
        String str2 = new String(bArr);
        LogUtils.d("IMUnBindPushRequest", str2);
        long j = 0;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            j = jSONObject.optLong(BaseJsonData.TAG_REQUESTID);
            i2 = jSONObject.optInt("error_code", 0);
            str = i2 != 0 ? jSONObject.optString("error_msg") : Constants.ERROR_MSG_SUCCESS;
            if (i2 == 0) {
                BindStateManager.clearUnBindInfo(this.mContext);
            }
        } catch (JSONException e2) {
            LogUtils.e("IMUnBindPushRequest", e2.getMessage(), e2);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            i2 = 1010;
        }
        LogUtils.d("IMUnBindPushRequest", "requestid : " + j + " , resultCode: " + i2 + " , resultMsg : " + str);
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
