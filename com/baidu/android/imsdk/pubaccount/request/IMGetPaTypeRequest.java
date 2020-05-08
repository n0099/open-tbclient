package com.baidu.android.imsdk.pubaccount.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IMGetPaTypeRequest extends PaBaseHttpRequest {
    private String mKey;
    private long mPaId;

    public IMGetPaTypeRequest(Context context, String str, long j) {
        this.mContext = context;
        this.mPaId = j;
        this.mKey = str;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() {
        return ("method=get_pa_type&pa_uid=" + this.mPaId + "&bduss=" + AccountManager.getUid(this.mContext)).getBytes();
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
        LogUtils.d("imsdk", "IMGetPaTypeRequest " + this.mPaId + "  " + i + " " + bArr);
        String str2 = new String(bArr);
        LogUtils.d("imsdk", "IMGetPaTypeRequest " + this.mPaId + "  " + i + " " + str2);
        String str3 = Constants.ERROR_MSG_SUCCESS;
        int i4 = -1;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.has("response_params")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
                i2 = jSONObject2.getInt("error_code");
                i4 = jSONObject2.optInt("type");
            } else {
                i2 = jSONObject.getInt("error_code");
                str3 = jSONObject.optString("error_msg", "");
            }
            i3 = i4;
            str = str3;
        } catch (JSONException e) {
            LogUtils.e("IMQueryZhidaSubscribedStateRequest", "JSONException", e);
            i2 = 1010;
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
            i3 = -1;
        }
        PaManagerImpl.getInstance(this.mContext).onGetPaTypeResult(this.mKey, i2, str, this.mPaId, i3);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        LogUtils.d("imsdk", "IMGetPaTypeRequest " + this.mPaId + "  " + i + " " + bArr);
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        PaManagerImpl.getInstance(this.mContext).onGetPaTypeResult(this.mKey, ((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.mPaId, -1);
    }

    @Override // com.baidu.android.imsdk.pubaccount.request.PaBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        String hostUrl = getHostUrl();
        if (hostUrl == null) {
            return null;
        }
        return hostUrl + "rest/2.0/im/zhidahao";
    }
}
