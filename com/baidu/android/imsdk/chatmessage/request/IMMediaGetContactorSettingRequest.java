package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.chatmessage.IMediaContactorSettingListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IMMediaGetContactorSettingRequest extends IMMediaBaseHttpRequest {
    private static final String TAG = "IMMediaGetContactorSettingRequest";
    private long mContacter;
    private long mContactorPauid;
    private String mContactorThirdid;
    private int mContactorType;
    private String mKey;
    private int mSetting;

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

    public IMMediaGetContactorSettingRequest(Context context, long j, int i, String str) {
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContacter = j;
        this.mSetting = i;
        this.mKey = str;
    }

    public IMMediaGetContactorSettingRequest(Context context, long j, int i, long j2, String str, int i2, String str2) {
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContacter = j;
        this.mSetting = i2;
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
            jSONObject.put("setting", this.mSetting);
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
        return getHostUrl() + "rest/3.0/im/b_get_contacter_setting";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        String str;
        int i3;
        String str2 = new String(bArr);
        LogUtils.d(TAG, "onSuccess resultContent = " + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int optInt = jSONObject.optInt("error_code", 0);
            String optString = jSONObject.optString("error_msg");
            int optInt2 = jSONObject.optInt("status", -1);
            i2 = optInt;
            str = optString;
            i3 = optInt2;
        } catch (JSONException e) {
            LogUtils.e(TAG, "IMMediaGetContactorSettingRequest JSONException", e);
            i2 = 1010;
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            i3 = -1;
        }
        IMediaContactorSettingListener iMediaContactorSettingListener = (IMediaContactorSettingListener) ListenerManager.getInstance().removeListener(this.mKey);
        if (iMediaContactorSettingListener != null) {
            iMediaContactorSettingListener.onMediaContactorSettingResult(i2, str, i3);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        LogUtils.d(TAG, "onFailure error = " + transErrorCode.first + " errormsg = " + ((String) transErrorCode.second));
        IMediaContactorSettingListener iMediaContactorSettingListener = (IMediaContactorSettingListener) ListenerManager.getInstance().removeListener(this.mKey);
        if (iMediaContactorSettingListener != null) {
            iMediaContactorSettingListener.onMediaContactorSettingResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, -1);
        }
    }
}
