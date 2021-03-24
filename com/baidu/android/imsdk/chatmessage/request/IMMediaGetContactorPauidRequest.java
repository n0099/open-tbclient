package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.IMediaGetContactorPauidListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class IMMediaGetContactorPauidRequest extends IMMediaBaseHttpRequest {
    public static final String TAG = "IMMediaGetContactorPauidRequest";
    public long mContacter;
    public long mContactorPauid;
    public String mContactorThirdid;
    public int mContactorType;
    public String mKey;

    public IMMediaGetContactorPauidRequest(Context context, long j, String str) {
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContacter = j;
        this.mKey = str;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/json";
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ Map getHeaders() {
        return super.getHeaders();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        if (getHostUrl() == null) {
            return null;
        }
        return getHostUrl() + "rest/3.0/im/b_get_contacter_pauid";
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ String getMethod() {
        return super.getMethod();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        JSONObject jSONObject = new JSONObject();
        try {
            putCommonParams(jSONObject);
            if (this.mContacter > 0) {
                jSONObject.put("contacter", Utility.transBDUID(String.valueOf(this.mContacter)));
            }
            if (this.mContactorType >= 0) {
                jSONObject.put("contacter_type", this.mContactorType);
            }
            if (this.mContactorPauid > 0) {
                jSONObject.put("contacter_pa_uid", this.mContactorPauid);
            }
            if (!TextUtils.isEmpty(this.mContactorThirdid)) {
                jSONObject.put("contacter_third_id", this.mContactorThirdid);
            }
            jSONObject.put("sign", generateSign(jSONObject));
        } catch (JSONException e2) {
            LogUtils.e(TAG, "getRequestParameter Exception ", e2);
        }
        return jSONObject.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        LogUtils.d(TAG, "onFailure error = " + transErrorCode.first + " errormsg = " + ((String) transErrorCode.second));
        IMediaGetContactorPauidListener iMediaGetContactorPauidListener = (IMediaGetContactorPauidListener) ListenerManager.getInstance().removeListener(this.mKey);
        if (iMediaGetContactorPauidListener != null) {
            iMediaGetContactorPauidListener.onMediaGetContactorPauidResult(((Integer) transErrorCode.first).intValue(), -1L, -1, (String) transErrorCode.second);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        long j;
        String str;
        int i2;
        int i3;
        String str2 = new String(bArr);
        LogUtils.d(TAG, "onSuccess resultContent = " + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int optInt = jSONObject.optInt("error_code", 0);
            String optString = jSONObject.optString("error_msg");
            long optLong = jSONObject.optLong("pa_uid", -1L);
            i3 = jSONObject.optInt("is_buser", -1);
            str = optString;
            j = optLong;
            i2 = optInt;
        } catch (JSONException e2) {
            LogUtils.e(TAG, "IMMediaSetSessionReadRequest JSONException", e2);
            j = -1;
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            i2 = 1010;
            i3 = -1;
        }
        IMediaGetContactorPauidListener iMediaGetContactorPauidListener = (IMediaGetContactorPauidListener) ListenerManager.getInstance().removeListener(this.mKey);
        if (iMediaGetContactorPauidListener != null) {
            iMediaGetContactorPauidListener.onMediaGetContactorPauidResult(i2, j, i3, str);
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return AccountManager.isCuidLogin(this.mContext);
    }

    public IMMediaGetContactorPauidRequest(Context context, long j, int i, long j2, String str, String str2) {
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContacter = j;
        this.mKey = str2;
        this.mContactorType = i;
        this.mContactorPauid = j2;
        this.mContactorThirdid = str;
    }
}
