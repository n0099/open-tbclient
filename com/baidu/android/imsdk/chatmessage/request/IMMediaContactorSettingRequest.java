package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.chatmessage.IMediaContactorSettingListener;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMMediaContactorSettingRequest extends IMMediaBaseHttpRequest {
    public static final String TAG = "IMMediaContactorSettingRequest";
    public long mContacter;
    public long mContactorPauid;
    public String mContactorThirdid;
    public int mContactorType;
    public String mKey;
    public int mOperation;

    public IMMediaContactorSettingRequest(Context context, long j, int i2, String str) {
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContacter = j;
        this.mOperation = i2;
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
        return getHostUrl() + "rest/3.0/im/b_set_contacter_setting";
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
            jSONObject.put(AppDownloadNetworkStateReceiver.KEY_OPERATION, this.mOperation);
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
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
        LogUtils.d(TAG, "onFailure error = " + transErrorCode.first + " errormsg = " + ((String) transErrorCode.second));
        IMediaContactorSettingListener iMediaContactorSettingListener = (IMediaContactorSettingListener) ListenerManager.getInstance().removeListener(this.mKey);
        if (iMediaContactorSettingListener != null) {
            iMediaContactorSettingListener.onMediaContactorSettingResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, -1);
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
        if (i3 == 0 && this.mContactorType == 2) {
            int i4 = this.mOperation;
            if (i4 == 1) {
                GroupInfoDAOImpl.updateGroupMarkTop(this.mContext, this.mContacter, 0, System.currentTimeMillis() / 1000);
            } else if (i4 == 2) {
                GroupInfoDAOImpl.updateGroupMarkTop(this.mContext, this.mContacter, 1, System.currentTimeMillis() / 1000);
            }
        }
        IMediaContactorSettingListener iMediaContactorSettingListener = (IMediaContactorSettingListener) ListenerManager.getInstance().removeListener(this.mKey);
        if (iMediaContactorSettingListener != null) {
            iMediaContactorSettingListener.onMediaContactorSettingResult(i3, str, -1);
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ boolean shouldAbort() {
        return super.shouldAbort();
    }

    public IMMediaContactorSettingRequest(Context context, long j, int i2, long j2, String str, int i3, String str2) {
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContacter = j;
        this.mOperation = i3;
        this.mKey = str2;
        this.mContactorType = i2;
        this.mContactorPauid = j2;
        this.mContactorThirdid = str;
    }
}
