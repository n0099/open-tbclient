package com.baidu.android.imsdk.account.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.ISetMsgSettingSwitchListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class IMSetMsgSettingSwitchRequest extends BaseHttpRequest {
    private static final String TAG = "IMSetMsgSettingSwitchRequest";
    private ISetMsgSettingSwitchListener mListener;
    private int mStatus;
    private int mSwitchCategory;

    public IMSetMsgSettingSwitchRequest(Context context, int i, int i2, ISetMsgSettingSwitchListener iSetMsgSettingSwitchListener) {
        this.mContext = context;
        this.mSwitchCategory = i;
        this.mStatus = i2;
        this.mListener = iSetMsgSettingSwitchListener;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() {
        try {
            long appid = AccountManager.getAppid(this.mContext);
            long uk = AccountManager.getUK(this.mContext);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", appid);
            jSONObject.put("uk", uk);
            jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
            jSONObject.put(SapiContext.KEY_SDK_VERSION, IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
            jSONObject.put(HttpConstants.DEVICE_TYPE, 2);
            jSONObject.put("timestamp", currentTimeMillis);
            jSONObject.put("sign", getMd5("" + currentTimeMillis + uk + appid));
            jSONObject.put("account_type", AccountManager.isCuidLogin(this.mContext) ? 1 : 0);
            if (this.mSwitchCategory == 1) {
                jSONObject.put("push_privacy", this.mStatus);
            } else if (this.mSwitchCategory == 0) {
                jSONObject.put("block_stranger", this.mStatus);
            }
            LogUtils.d(TAG, "IMSetMsgSettingSwitchRequest getRequestParameter :" + jSONObject.toString());
            return jSONObject.toString().getBytes();
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return HttpHelper.CONTENT_JSON;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        String str;
        String str2 = new String(bArr);
        LogUtils.e(TAG, "IMSetMsgSettingSwitchRequest onSuccess :" + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            i2 = jSONObject.getInt("error_code");
            str = jSONObject.optString("error_msg", "");
        } catch (JSONException e) {
            LogUtils.e(TAG, "JSONException", e);
            i2 = 1010;
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
        }
        if (this.mListener != null) {
            this.mListener.onSetMsgSettingSwitch(i2, str);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        if (this.mListener != null) {
            this.mListener.onSetMsgSettingSwitch(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        String str = null;
        switch (Utility.readIntData(this.mContext, Constants.KEY_ENV, 0)) {
            case 0:
                if (!Utility.isPeakTime()) {
                    str = Constants.URL_HTTP_ONLINE;
                    break;
                } else {
                    str = Constants.URL_HTTP_ONLINE.replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "http://");
                    break;
                }
            case 1:
                str = Constants.URL_HTTP_RD;
                break;
            case 2:
                str = "http://10.232.27.22:8090/";
                break;
            case 3:
                str = Constants.URL_HTTP_BOX;
                break;
        }
        return TextUtils.isEmpty(str) ? str : str + "rest/3.0/im/set_user_setting";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        return new HashMap();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "POST";
    }
}
