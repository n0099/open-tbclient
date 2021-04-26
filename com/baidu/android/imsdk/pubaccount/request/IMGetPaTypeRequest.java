package com.baidu.android.imsdk.pubaccount.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.retrieve.RetrieveReportRequest;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.bumptech.glide.load.engine.GlideException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMGetPaTypeRequest extends PaBaseHttpRequest {
    public String mKey;
    public long mPaId;

    public IMGetPaTypeRequest(Context context, String str, long j) {
        this.mContext = context;
        this.mPaId = j;
        this.mKey = str;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.pubaccount.request.PaBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        String hostUrl = getHostUrl();
        if (hostUrl == null) {
            return null;
        }
        return hostUrl + "rest/2.0/im/zhidahao";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() {
        return ("method=get_pa_type&pa_uid=" + this.mPaId + "&bduss=" + AccountManager.getUid(this.mContext)).getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        LogUtils.d(RetrieveReportRequest.APP_NAME, "IMGetPaTypeRequest " + this.mPaId + GlideException.IndentedAppendable.INDENT + i2 + " " + bArr);
        Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
        PaManagerImpl.getInstance(this.mContext).onGetPaTypeResult(this.mKey, ((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.mPaId, -1);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        String str;
        int i3;
        int i4;
        int i5;
        String optString;
        LogUtils.d(RetrieveReportRequest.APP_NAME, "IMGetPaTypeRequest " + this.mPaId + GlideException.IndentedAppendable.INDENT + i2 + " " + bArr);
        String str2 = new String(bArr);
        LogUtils.d(RetrieveReportRequest.APP_NAME, "IMGetPaTypeRequest " + this.mPaId + GlideException.IndentedAppendable.INDENT + i2 + " " + str2);
        int i6 = -1;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.has("response_params")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
                i5 = jSONObject2.getInt("error_code");
                i6 = jSONObject2.optInt("type");
                optString = Constants.ERROR_MSG_SUCCESS;
            } else {
                i5 = jSONObject.getInt("error_code");
                optString = jSONObject.optString("error_msg", "");
            }
            i4 = i6;
            str = optString;
            i3 = i5;
        } catch (JSONException e2) {
            LogUtils.e("IMQueryZhidaSubscribedStateRequest", "JSONException", e2);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            i3 = 1010;
            i4 = -1;
        }
        PaManagerImpl.getInstance(this.mContext).onGetPaTypeResult(this.mKey, i3, str, this.mPaId, i4);
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return AccountManager.isCuidLogin(this.mContext);
    }
}
