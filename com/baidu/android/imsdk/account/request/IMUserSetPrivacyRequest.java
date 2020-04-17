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
import com.baidu.android.pushservice.PushConstants;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IMUserSetPrivacyRequest extends IMUserBaseHttpRequest {
    private long mAppid;
    private String mKey;
    private int mPrivacy;

    public IMUserSetPrivacyRequest(Context context, String str, long j, int i) {
        this.mPrivacy = 0;
        this.mContext = context;
        this.mPrivacy = i;
        this.mKey = str;
        this.mAppid = j;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder();
        sb.append("method=update_user_setting");
        sb.append("&appid=").append(this.mAppid);
        sb.append("&push_privacy=").append(this.mPrivacy);
        sb.append("&timestamp=").append(currentTimeMillis);
        sb.append("&sign=").append(getMd5("" + currentTimeMillis + bduss + this.mAppid));
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        String str;
        String str2 = new String(bArr);
        LogUtils.d(" ", " DEBUG " + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.has("response_params")) {
                i2 = jSONObject.getJSONObject("response_params").getInt("error_code");
                str = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE, Constants.ERROR_MSG_SUCCESS);
            } else {
                i2 = jSONObject.getInt("error_code");
                str = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE, "");
            }
        } catch (JSONException e) {
            LogUtils.e("IMUserSetPrivacyRequest", "JSONException", e);
            i2 = 1010;
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
        AccountManagerImpl.getInstance(this.mContext).onSetPrivacyResult(this.mKey, i2, str, this.mPrivacy);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        AccountManagerImpl.getInstance(this.mContext).onSetPrivacyResult(this.mKey, ((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, 0);
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return AccountManager.isCuidLogin(this.mContext);
    }
}
