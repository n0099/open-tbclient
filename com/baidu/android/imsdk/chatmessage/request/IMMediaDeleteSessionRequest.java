package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.chatmessage.IMediaDeleteChatSessionListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class IMMediaDeleteSessionRequest extends IMMediaBaseHttpRequest {
    private static final String TAG = "IMMediaDeleteSessionRequest";
    private long mContacter;
    private long mContactorPauid;
    private String mContactorThirdid;
    private int mContactorType;
    private String mKey;
    private long mLastTime;

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ Map getHeaders() {
        return super.getHeaders();
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ String getMethod() {
        return super.getMethod();
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ boolean shouldAbort() {
        return super.shouldAbort();
    }

    public IMMediaDeleteSessionRequest(Context context, long j, long j2, String str) {
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContacter = j;
        this.mLastTime = j2;
        this.mKey = str;
    }

    public IMMediaDeleteSessionRequest(Context context, long j, int i, long j2, String str, long j3, String str2) {
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContacter = j;
        this.mLastTime = j3;
        this.mKey = str2;
        this.mContactorType = i;
        this.mContactorPauid = j2;
        this.mContactorThirdid = str;
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
            jSONObject.put("lastmsg_time", this.mLastTime);
            jSONObject.put("sign", generateSign(jSONObject));
        } catch (JSONException e) {
            LogUtils.e(TAG, "getRequestParameter Exception ", e);
        }
        return jSONObject.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return HttpHelper.CONTENT_JSON;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        if (getHostUrl() == null) {
            return null;
        }
        return getHostUrl() + "rest/3.0/im/delete_session";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        String str;
        String str2 = new String(bArr);
        LogUtils.d(TAG, "onSuccess resultContent = " + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int optInt = jSONObject.optInt("error_code", 0);
            String optString = jSONObject.optString("error_msg");
            i2 = optInt;
            str = optString;
        } catch (JSONException e) {
            LogUtils.e(TAG, "IMMediaDeleteSessionRequest JSONException", e);
            i2 = 1010;
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
        }
        IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener = (IMediaDeleteChatSessionListener) ListenerManager.getInstance().removeListener(this.mKey);
        if (iMediaDeleteChatSessionListener != null) {
            iMediaDeleteChatSessionListener.onMediaDeleteChatSessionResult(i2, str);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        LogUtils.d(TAG, "onFailure error = " + transErrorCode.first + " errormsg = " + ((String) transErrorCode.second));
        IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener = (IMediaDeleteChatSessionListener) ListenerManager.getInstance().removeListener(this.mKey);
        if (iMediaDeleteChatSessionListener != null) {
            iMediaDeleteChatSessionListener.onMediaDeleteChatSessionResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second);
        }
    }
}
