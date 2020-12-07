package com.baidu.android.imsdk.account.request;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.sapi2.utils.SapiUtils;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class IMGetTokenByCuidRequest extends BaseHttpRequest {
    private static final String TAG = "IMGenTokenByCuidRequest";
    private long mAppid;
    private String mCuid;
    private String mKey;
    private int mAccountType = 6;
    private int mDeviceType = 2;

    public IMGetTokenByCuidRequest(Context context, long j, String str, String str2) {
        this.mContext = context;
        this.mAppid = j;
        this.mCuid = str;
        this.mKey = str2;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        String str = new String(bArr);
        LogUtils.d(TAG, str);
        int i2 = 0;
        String str2 = Constants.ERROR_MSG_SUCCESS;
        String str3 = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("error_code")) {
                i2 = jSONObject.getInt("error_code");
                if (jSONObject.has(AlaRecorderLog.KEY_ERROR_MSG)) {
                    str2 = jSONObject.getString(AlaRecorderLog.KEY_ERROR_MSG);
                }
                if (i2 == 0) {
                    str3 = jSONObject.getString("token");
                    if (!TextUtils.isEmpty(str3)) {
                        Utility.writeCuidAccessToken(this.mContext, str3);
                    }
                }
            }
        } catch (JSONException e) {
            LogUtils.e(TAG, e.getMessage(), e);
            i2 = 1010;
            str2 = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
        }
        AccountManagerImpl.getInstance(this.mContext).onGetTokenByCuidResult(this.mKey, i2, str2, str3);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        String str = new String(bArr);
        LogUtils.e(TAG, "errorCode = " + i + ", result = " + str);
        AccountManagerImpl.getInstance(this.mContext).onGetTokenByCuidResult(this.mKey, i, str, null);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        switch (Utility.readIntData(this.mContext, Constants.KEY_ENV, 0)) {
            case 0:
                return (Utility.isPeakTime() ? "https://pim.baidu.com/".replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "http://") : "https://pim.baidu.com/") + "rest/3.0/im/generate_token";
            case 1:
                return "http://rd-im-server.bcc-szth.baidu.com:8080/rest/3.0/im/generate_token";
            case 2:
                return "http://10.64.132.67:8080/rest/3.0/im/generate_token";
            case 3:
                return "http://180.97.36.95:8080/rest/3.0/im/generate_token";
            default:
                return null;
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "POST";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder();
        sb.append("appid=" + this.mAppid);
        sb.append("&account_type=" + this.mAccountType);
        sb.append("&cuid=" + this.mCuid);
        sb.append("&device_type=" + this.mDeviceType);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        sb.append("&timestamp=" + currentTimeMillis);
        if (!TextUtils.isEmpty(Utility.getCuidAccessToken(this.mContext))) {
            sb.append("&token=" + Utility.getCuidAccessToken(this.mContext));
        }
        sb.append("&sign=").append(getMd5(this.mAppid + "" + this.mAccountType + "" + this.mCuid + "" + this.mDeviceType + "" + currentTimeMillis));
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        return new HashMap();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
