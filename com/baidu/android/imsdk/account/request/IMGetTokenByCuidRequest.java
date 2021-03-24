package com.baidu.android.imsdk.account.request;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class IMGetTokenByCuidRequest extends BaseHttpRequest {
    public static final String TAG = "IMGenTokenByCuidRequest";
    public long mAppid;
    public String mCuid;
    public String mKey;
    public int mAccountType = 6;
    public int mDeviceType = 2;

    public IMGetTokenByCuidRequest(Context context, long j, String str, String str2) {
        this.mContext = context;
        this.mAppid = j;
        this.mCuid = str;
        this.mKey = str2;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        return new HashMap();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        int readIntData = Utility.readIntData(this.mContext, Constants.KEY_ENV, 0);
        if (readIntData == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(Utility.isPeakTime() ? "https://pim.baidu.com/".replace("https://", "http://") : "https://pim.baidu.com/");
            sb.append("rest/3.0/im/generate_token");
            return sb.toString();
        } else if (readIntData != 1) {
            if (readIntData != 2) {
                if (readIntData != 3) {
                    return null;
                }
                return "http://180.97.36.95:8080/rest/3.0/im/generate_token";
            }
            return "http://10.64.132.67:8080/rest/3.0/im/generate_token";
        } else {
            return "http://rd-im-server.bcc-szth.baidu.com:8080/rest/3.0/im/generate_token";
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
        sb.append("&sign=");
        sb.append(getMd5(this.mAppid + "" + this.mAccountType + "" + this.mCuid + "" + this.mDeviceType + "" + currentTimeMillis));
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        String str = new String(bArr);
        LogUtils.e(TAG, "errorCode = " + i + ", result = " + str);
        AccountManagerImpl.getInstance(this.mContext).onGetTokenByCuidResult(this.mKey, i, str, null);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        String str;
        String str2 = new String(bArr);
        LogUtils.d(TAG, str2);
        String str3 = null;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            boolean has = jSONObject.has("error_code");
            str = Constants.ERROR_MSG_SUCCESS;
            if (has) {
                i2 = jSONObject.getInt("error_code");
                if (jSONObject.has("error_msg")) {
                    str = jSONObject.getString("error_msg");
                }
                if (i2 == 0) {
                    str3 = jSONObject.getString("token");
                    if (!TextUtils.isEmpty(str3)) {
                        Utility.writeCuidAccessToken(this.mContext, str3);
                    }
                }
            } else {
                i2 = 0;
            }
        } catch (JSONException e2) {
            LogUtils.e(TAG, e2.getMessage(), e2);
            i2 = 1010;
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
        }
        AccountManagerImpl.getInstance(this.mContext).onGetTokenByCuidResult(this.mKey, i2, str, str3);
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
