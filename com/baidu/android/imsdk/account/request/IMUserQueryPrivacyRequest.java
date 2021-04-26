package com.baidu.android.imsdk.account.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatuser.request.IMUserBaseHttpRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMUserQueryPrivacyRequest extends IMUserBaseHttpRequest {
    public long mAppid;

    public IMUserQueryPrivacyRequest(Context context, long j) {
        this.mContext = context;
        this.mAppid = j;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() {
        return ("method=read_user_setting&appid=" + this.mAppid).getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
        AccountManagerImpl.getInstance(this.mContext).onQueryPrivacyResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, 0);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        int i3;
        String str;
        String str2 = new String(bArr);
        int i4 = 0;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.has("response_params")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
                i3 = jSONObject2.getInt("error_code");
                i4 = jSONObject2.getJSONObject("user_setting").optInt("push_privacy");
                str = Constants.ERROR_MSG_SUCCESS;
            } else {
                i3 = jSONObject.getInt("error_code");
                str = jSONObject.optString("error_msg", "");
            }
        } catch (JSONException e2) {
            LogUtils.e("IMUserQueryPrivacyRequest", "JSONException", e2);
            i3 = 1010;
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
        }
        AccountManagerImpl.getInstance(this.mContext).onQueryPrivacyResult(i3, str, i4);
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return AccountManager.isCuidLogin(this.mContext);
    }
}
