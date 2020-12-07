package com.baidu.android.imsdk.account.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatuser.request.IMUserBaseHttpRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class IMUserQueryPrivacyRequest extends IMUserBaseHttpRequest {
    private long mAppid;

    public IMUserQueryPrivacyRequest(Context context, long j) {
        this.mContext = context;
        this.mAppid = j;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() {
        StringBuilder sb = new StringBuilder();
        sb.append("method=read_user_setting");
        sb.append("&appid=").append(this.mAppid);
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        String str = new String(bArr);
        int i3 = 0;
        String str2 = Constants.ERROR_MSG_SUCCESS;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("response_params")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
                i2 = jSONObject2.getInt("error_code");
                i3 = jSONObject2.getJSONObject("user_setting").optInt("push_privacy");
            } else {
                i2 = jSONObject.getInt("error_code");
                str2 = jSONObject.optString(AlaRecorderLog.KEY_ERROR_MSG, "");
            }
        } catch (JSONException e) {
            LogUtils.e("IMUserQueryPrivacyRequest", "JSONException", e);
            i2 = 1010;
            str2 = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
        AccountManagerImpl.getInstance(this.mContext).onQueryPrivacyResult(i2, str2, i3);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        AccountManagerImpl.getInstance(this.mContext).onQueryPrivacyResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, 0);
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return AccountManager.isCuidLogin(this.mContext);
    }
}
