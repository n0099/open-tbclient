package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.chatmessage.BindStateManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.pushservice.PushConstants;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.cookie.SM;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class IMUnBindPushRequest extends BaseHttpRequest {
    private Long mAppid;
    private String mBduss;
    private String mDeviceId;
    private Long mUk;

    public IMUnBindPushRequest(Context context, long j, String str, String str2, Long l) {
        this.mContext = context;
        this.mAppid = Long.valueOf(j);
        this.mBduss = str;
        this.mDeviceId = str2;
        this.mUk = l;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        JSONException jSONException;
        long j;
        int i2;
        String str;
        JSONObject jSONObject;
        String str2 = new String(bArr);
        LogUtils.d("IMUnBindPushRequest", str2);
        try {
            jSONObject = new JSONObject(str2);
            j = jSONObject.optLong("requestid");
        } catch (JSONException e) {
            jSONException = e;
            j = 0;
        }
        try {
            i2 = jSONObject.optInt("error_code", 0);
            if (i2 == 0) {
                str = Constants.ERROR_MSG_SUCCESS;
            } else {
                str = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
            }
            if (i2 == 0) {
                BindStateManager.clearUnBindInfo(this.mContext);
            }
        } catch (JSONException e2) {
            jSONException = e2;
            LogUtils.e("IMUnBindPushRequest", jSONException.getMessage(), jSONException);
            i2 = 1010;
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(jSONException)).build();
            LogUtils.d("IMUnBindPushRequest", "requestid : " + j + " , resultCode: " + i2 + " , resultMsg : " + str);
        }
        LogUtils.d("IMUnBindPushRequest", "requestid : " + j + " , resultCode: " + i2 + " , resultMsg : " + str);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        LogUtils.d("IMUnBindPushRequest", "  errorCode: " + transErrorCode(i, bArr, th).first);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        return getHostUrl(this.mContext) + "rest/2.0/im/bind_push?method=unbind";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "POST";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder("method=unbind");
        sb.append("&appid=").append(this.mAppid);
        sb.append("&device_id=").append(this.mDeviceId);
        sb.append("&uk=").append(this.mUk);
        sb.append("&timestamp=").append(currentTimeMillis);
        sb.append("&sdk_version=").append(IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
        sb.append("&sign=").append(getMd5("" + currentTimeMillis + this.mBduss + this.mAppid));
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put(SM.COOKIE, "BDUSS=" + this.mBduss);
        return hashMap;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
