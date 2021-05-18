package com.baidu.android.imsdk.account.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.IGetMsgSettingSwitchListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMGetMsgSettingSwitchRequest extends BaseHttpRequest {
    public static final String TAG = "IMGetMsgSettingSwitchRequest";
    public IGetMsgSettingSwitchListener mListener;

    public IMGetMsgSettingSwitchRequest(Context context, IGetMsgSettingSwitchListener iGetMsgSettingSwitchListener) {
        this.mContext = context;
        this.mListener = iGetMsgSettingSwitchListener;
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
        return replace + "rest/3.0/im/read_user_setting";
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
            jSONObject.put(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
            jSONObject.put("device_type", 2);
            jSONObject.put("timestamp", currentTimeMillis);
            jSONObject.put("sign", getMd5("" + currentTimeMillis + uk + appid));
            jSONObject.put("account_type", AccountManager.isCuidLogin(this.mContext) ? 1 : 0);
            LogUtils.d(TAG, "IMGetMsgSettingSwitchRequest getRequestParameter :" + jSONObject.toString());
            return jSONObject.toString().getBytes();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        int i3;
        IGetMsgSettingSwitchListener iGetMsgSettingSwitchListener;
        Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
        String str = new String(bArr);
        LogUtils.e(TAG, "IMGetMsgSettingSwitchRequest onFailure :" + str);
        int i4 = 0;
        try {
            JSONObject jSONObject = new JSONObject(str);
            i3 = jSONObject.optInt("push_privacy", 0);
            try {
                i4 = jSONObject.optInt("block_stranger", 0);
            } catch (JSONException e2) {
                e = e2;
                LogUtils.e(TAG, "onFailure JSONException", e);
                iGetMsgSettingSwitchListener = this.mListener;
                if (iGetMsgSettingSwitchListener == null) {
                }
            }
        } catch (JSONException e3) {
            e = e3;
            i3 = 0;
        }
        iGetMsgSettingSwitchListener = this.mListener;
        if (iGetMsgSettingSwitchListener == null) {
            iGetMsgSettingSwitchListener.onGetMsgSettingSwitch(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, i4, i3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(int i2, byte[] bArr) {
        int i3;
        int i4;
        String str;
        IGetMsgSettingSwitchListener iGetMsgSettingSwitchListener;
        String str2 = new String(bArr);
        LogUtils.e(TAG, "IMGetMsgSettingSwitchRequest onSuccess :" + str2);
        int i5 = 0;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            i4 = jSONObject.getInt("error_code");
            str = jSONObject.optString("error_msg", "");
            i3 = jSONObject.optInt("push_privacy", 0);
            try {
                i5 = jSONObject.optInt("block_stranger", 0);
            } catch (JSONException e2) {
                e = e2;
                LogUtils.e(TAG, "JSONException", e);
                i4 = 1010;
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                iGetMsgSettingSwitchListener = this.mListener;
                if (iGetMsgSettingSwitchListener == null) {
                }
            }
        } catch (JSONException e3) {
            e = e3;
            i3 = 0;
        }
        iGetMsgSettingSwitchListener = this.mListener;
        if (iGetMsgSettingSwitchListener == null) {
            iGetMsgSettingSwitchListener.onGetMsgSettingSwitch(i4, str, i5, i3);
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
