package com.baidu.android.imsdk.account.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatuser.request.IMUserBaseHttpRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class IMUserSetPrivacyRequest extends IMUserBaseHttpRequest {
    public long mAppid;
    public String mKey;
    public int mPrivacy;

    public IMUserSetPrivacyRequest(Context context, String str, long j, int i) {
        this.mPrivacy = 0;
        this.mContext = context;
        this.mPrivacy = i;
        this.mKey = str;
        this.mAppid = j;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return ("method=update_user_setting&appid=" + this.mAppid + "&push_privacy=" + this.mPrivacy + "&timestamp=" + currentTimeMillis + "&sign=" + getMd5("" + currentTimeMillis + bduss + this.mAppid)).getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        AccountManagerImpl.getInstance(this.mContext).onSetPrivacyResult(this.mKey, ((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, 0);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        String str;
        int i2;
        String str2 = new String(bArr);
        LogUtils.d(" ", " DEBUG " + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.has("response_params")) {
                i2 = jSONObject.getJSONObject("response_params").getInt("error_code");
                str = jSONObject.optString("error_msg", Constants.ERROR_MSG_SUCCESS);
            } else {
                i2 = jSONObject.getInt("error_code");
                str = jSONObject.optString("error_msg", "");
            }
        } catch (JSONException e2) {
            LogUtils.e("IMUserSetPrivacyRequest", "JSONException", e2);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            i2 = 1010;
        }
        AccountManagerImpl.getInstance(this.mContext).onSetPrivacyResult(this.mKey, i2, str, this.mPrivacy);
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return AccountManager.isCuidLogin(this.mContext);
    }
}
