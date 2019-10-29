package com.baidu.android.imsdk.pubaccount.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.pushservice.PushConstants;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class IMPaSetDisturbRequest extends PaBaseHttpRequest {
    private long mAppid;
    private int mDisturb;
    private String mKey;
    private long mPaid;

    public IMPaSetDisturbRequest(Context context, String str, long j, long j2, int i) {
        this.mDisturb = 0;
        this.mContext = context;
        this.mAppid = j;
        this.mKey = str;
        this.mPaid = j2;
        this.mDisturb = i;
    }

    @Override // com.baidu.android.imsdk.pubaccount.request.PaBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        if (getHostUrl() == null) {
            return null;
        }
        return getHostUrl() + "rest/2.0/im/user_setting";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder();
        sb.append("method=update_pa_setting");
        sb.append("&appid=").append(this.mAppid);
        sb.append("&pa_uid=").append(this.mPaid);
        sb.append("&timestamp=").append(currentTimeMillis);
        sb.append("&do_not_disturb=").append(this.mDisturb);
        sb.append("&sign=").append(getMd5("" + currentTimeMillis + bduss + this.mAppid));
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return AccountManager.isCuidLogin(this.mContext);
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
                optString = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE, Constants.ERROR_MSG_SUCCESS);
            } else {
                i3 = jSONObject.getInt("error_code");
                optString = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE, "");
            }
            str = optString;
            i2 = i3;
        } catch (JSONException e) {
            LogUtils.e("IMPaSetDisturbRequest", "JSONException", e);
            i2 = 1010;
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
        PaManagerImpl.getInstance(this.mContext).onSetDisturResult(this.mKey, i2, str, this.mDisturb, this.mPaid);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        PaManagerImpl.getInstance(this.mContext).onSetDisturResult(this.mKey, ((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.mDisturb, this.mPaid);
    }
}
