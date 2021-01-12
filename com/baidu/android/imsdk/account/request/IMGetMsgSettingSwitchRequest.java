package com.baidu.android.imsdk.account.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.IGetMsgSettingSwitchListener;
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
/* loaded from: classes3.dex */
public class IMGetMsgSettingSwitchRequest extends BaseHttpRequest {
    private static final String TAG = "IMGetMsgSettingSwitchRequest";
    private IGetMsgSettingSwitchListener mListener;

    public IMGetMsgSettingSwitchRequest(Context context, IGetMsgSettingSwitchListener iGetMsgSettingSwitchListener) {
        this.mContext = context;
        this.mListener = iGetMsgSettingSwitchListener;
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
            LogUtils.d(TAG, "IMGetMsgSettingSwitchRequest getRequestParameter :" + jSONObject.toString());
            return jSONObject.toString().getBytes();
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return HttpHelper.CONTENT_JSON;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003e  */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFailure(int i, byte[] bArr, Throwable th) {
        int i2;
        int i3;
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        String str = new String(bArr);
        LogUtils.e(TAG, "IMGetMsgSettingSwitchRequest onFailure :" + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            i2 = jSONObject.optInt("push_privacy", 0);
            try {
                i3 = jSONObject.optInt("block_stranger", 0);
            } catch (JSONException e) {
                e = e;
                LogUtils.e(TAG, "onFailure JSONException", e);
                i3 = 0;
                if (this.mListener == null) {
                }
            }
        } catch (JSONException e2) {
            e = e2;
            i2 = 0;
        }
        if (this.mListener == null) {
            this.mListener.onGetMsgSettingSwitch(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, i3, i2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x004a  */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        int i3;
        String str;
        int i4 = 0;
        String str2 = new String(bArr);
        LogUtils.e(TAG, "IMGetMsgSettingSwitchRequest onSuccess :" + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            i3 = jSONObject.getInt("error_code");
            str = jSONObject.optString("error_msg", "");
            i2 = jSONObject.optInt("push_privacy", 0);
            try {
                i4 = jSONObject.optInt("block_stranger", 0);
            } catch (JSONException e) {
                e = e;
                LogUtils.e(TAG, "JSONException", e);
                i3 = 1010;
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                if (this.mListener == null) {
                }
            }
        } catch (JSONException e2) {
            e = e2;
            i2 = 0;
        }
        if (this.mListener == null) {
            this.mListener.onGetMsgSettingSwitch(i3, str, i4, i2);
        }
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

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        String str = null;
        switch (Utility.readIntData(this.mContext, Constants.KEY_ENV, 0)) {
            case 0:
                if (!Utility.isPeakTime()) {
                    str = "https://pim.baidu.com/";
                    break;
                } else {
                    str = "https://pim.baidu.com/".replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "http://");
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
        return TextUtils.isEmpty(str) ? str : str + "rest/3.0/im/read_user_setting";
    }
}
