package com.baidu.android.imsdk.account.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.ISetMsgSettingSwitchListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMSetMsgSettingSwitchRequest extends BaseHttpRequest {
    public static final String TAG = "IMSetMsgSettingSwitchRequest";
    public ISetMsgSettingSwitchListener mListener;
    public int mStatus;
    public int mSwitchCategory;

    public IMSetMsgSettingSwitchRequest(Context context, int i2, int i3, ISetMsgSettingSwitchListener iSetMsgSettingSwitchListener) {
        this.mContext = context;
        this.mSwitchCategory = i2;
        this.mStatus = i3;
        this.mListener = iSetMsgSettingSwitchListener;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/json";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        return new HashMap();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        String replace;
        int readIntData = Utility.readIntData(this.mContext, Constants.KEY_ENV, 0);
        if (readIntData != 0) {
            replace = readIntData != 1 ? readIntData != 2 ? readIntData != 3 ? null : Constants.URL_HTTP_BOX : "http://10.232.27.22:8090/" : "http://rd-im-server.bcc-szth.baidu.com:8080/";
        } else {
            replace = Utility.isPeakTime() ? "https://pim.baidu.com/".replace("https://", "http://") : "https://pim.baidu.com/";
        }
        if (TextUtils.isEmpty(replace)) {
            return replace;
        }
        return replace + "rest/3.0/im/set_user_setting";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "POST";
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
            jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
            jSONObject.put("device_type", 2);
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
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
        ISetMsgSettingSwitchListener iSetMsgSettingSwitchListener = this.mListener;
        if (iSetMsgSettingSwitchListener != null) {
            iSetMsgSettingSwitchListener.onSetMsgSettingSwitch(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        int i3;
        String str;
        String str2 = new String(bArr);
        LogUtils.e(TAG, "IMSetMsgSettingSwitchRequest onSuccess :" + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            i3 = jSONObject.getInt("error_code");
            str = jSONObject.optString("error_msg", "");
        } catch (JSONException e2) {
            LogUtils.e(TAG, "JSONException", e2);
            i3 = 1010;
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
        }
        ISetMsgSettingSwitchListener iSetMsgSettingSwitchListener = this.mListener;
        if (iSetMsgSettingSwitchListener != null) {
            iSetMsgSettingSwitchListener.onSetMsgSettingSwitch(i3, str);
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
