package com.baidu.android.imsdk.chatuser.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class IMUserSetRequest extends IMUserBaseHttpRequest {
    private long mAppid;
    private int mBlack;
    private int mDisturb;
    private String mKey;
    private long mUserUk;

    public IMUserSetRequest(Context context, String str, long j, long j2, int i, int i2) {
        this.mContext = context;
        this.mUserUk = j;
        this.mKey = str;
        this.mDisturb = i;
        this.mBlack = i2;
        this.mAppid = j2;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder();
        sb.append("method=update_contacter_setting");
        sb.append("&appid=").append(this.mAppid);
        sb.append("&contacter=").append(this.mUserUk);
        sb.append("&timestamp=").append(currentTimeMillis);
        if (this.mDisturb != -1) {
            sb.append("&do_not_disturb=").append(this.mDisturb);
        }
        if (this.mBlack != -1) {
            sb.append("&blacklist=").append(this.mBlack);
        }
        sb.append("&sign=").append(getMd5("" + currentTimeMillis + bduss + this.mAppid));
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        String str;
        int i3;
        String optString;
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            if (jSONObject.has("response_params")) {
                i3 = jSONObject.getJSONObject("response_params").getInt("error_code");
                optString = jSONObject.optString("error_msg", Constants.ERROR_MSG_SUCCESS);
            } else {
                i3 = jSONObject.getInt("error_code");
                optString = jSONObject.optString("error_msg", "");
            }
            str = optString;
            i2 = i3;
        } catch (JSONException e) {
            LogUtils.e("IMUserSetRequest", "JSONException", e);
            i2 = 1010;
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
        ChatUserManagerImpl.getInstance(this.mContext).onSetPrivacyResult(this.mKey, i2, str, this.mUserUk, this.mDisturb, this.mBlack);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        ChatUserManagerImpl.getInstance(this.mContext).onSetPrivacyResult(this.mKey, ((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.mUserUk, this.mDisturb, this.mBlack);
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return AccountManager.isCuidLogin(this.mContext);
    }
}
