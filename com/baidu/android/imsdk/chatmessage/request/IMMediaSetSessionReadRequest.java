package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.chatmessage.IMediaSetSessionReadListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMMediaSetSessionReadRequest extends IMMediaBaseHttpRequest {
    public static final String TAG = "IMMediaSetSessionReadRequest";
    public long mContacter;
    public long mContactorPauid;
    public String mContactorThirdid;
    public int mContactorType;
    public String mKey;
    public long mLastTime;

    public IMMediaSetSessionReadRequest(Context context, long j, long j2, String str) {
        this.mContactorType = -2;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContacter = j;
        this.mLastTime = j2;
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
        return getHostUrl() + "rest/3.0/im/mark_msg_read_status";
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
            if (this.mContactorType >= -1) {
                jSONObject.put("contacter_type", this.mContactorType);
            }
            if (this.mContactorPauid > 0) {
                jSONObject.put("contacter_pa_uid", this.mContactorPauid);
            }
            if (!TextUtils.isEmpty(this.mContactorThirdid)) {
                jSONObject.put("contacter_third_id", this.mContactorThirdid);
            }
            jSONObject.put("lastmsg_time", this.mLastTime);
            jSONObject.put("sign", generateSign(jSONObject));
        } catch (JSONException e2) {
            LogUtils.e(TAG, "getRequestParameter Exception ", e2);
        }
        return jSONObject.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
        LogUtils.d(TAG, "onFailure error = " + transErrorCode.first + " errormsg = " + ((String) transErrorCode.second));
        IMediaSetSessionReadListener iMediaSetSessionReadListener = (IMediaSetSessionReadListener) ListenerManager.getInstance().removeListener(this.mKey);
        if (iMediaSetSessionReadListener != null) {
            iMediaSetSessionReadListener.onMediaSetSessionReadResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        int i3;
        String str;
        String str2 = new String(bArr);
        LogUtils.d(TAG, "onSuccess resultContent = " + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            i3 = jSONObject.optInt("error_code", 0);
            str = jSONObject.optString("error_msg");
        } catch (JSONException e2) {
            LogUtils.e(TAG, "IMMediaSetSessionReadRequest JSONException", e2);
            i3 = 1010;
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
        }
        IMediaSetSessionReadListener iMediaSetSessionReadListener = (IMediaSetSessionReadListener) ListenerManager.getInstance().removeListener(this.mKey);
        if (iMediaSetSessionReadListener != null) {
            iMediaSetSessionReadListener.onMediaSetSessionReadResult(i3, str);
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ boolean shouldAbort() {
        return super.shouldAbort();
    }

    public IMMediaSetSessionReadRequest(Context context, long j, int i2, long j2, String str, long j3, String str2) {
        this.mContactorType = -2;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContacter = j;
        this.mLastTime = j3;
        this.mKey = str2;
        this.mContactorType = i2;
        this.mContactorPauid = j2;
        this.mContactorThirdid = str;
    }
}
