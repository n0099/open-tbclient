package com.baidu.android.imsdk.shield.request;

import android.content.Context;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.shield.ShieldAndTopManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMForbidRequest extends IMSettingBaseHttpRequest {
    public static final String TAG = "IMForbidRequest";
    public String key;
    public long touk;
    public int type;
    public long uid;

    public IMForbidRequest(Context context, long j, long j2, int i2, String str) {
        this.mContext = context;
        this.uid = j2;
        this.type = i2;
        this.key = str;
        this.touk = j;
    }

    private int getReportType() {
        if (AccountManager.getMediaRole(this.mContext)) {
            int i2 = this.type;
            if (i2 == 0) {
                return 3;
            }
            if (i2 == 7) {
                return 4;
            }
        } else {
            int i3 = this.type;
            if (i3 == 0) {
                return 0;
            }
            if (i3 == 7) {
                return 1;
            }
            if (i3 == 3) {
                return 2;
            }
        }
        return 0;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/json";
    }

    @Override // com.baidu.android.imsdk.shield.request.IMSettingBaseHttpRequest
    public String getHostUrl() {
        int readIntData = Utility.readIntData(this.mContext, Constants.KEY_ENV, 0);
        if (readIntData != 0) {
            if (readIntData != 1) {
                if (readIntData != 2) {
                    if (readIntData != 3) {
                        return null;
                    }
                    return Constants.URL_HTTP_BOX;
                }
                return Constants.URL_HTTP_QA;
            }
            return "http://rd-im-server.bcc-szth.baidu.com:8111/";
        }
        return "https://pim.baidu.com/";
    }

    @Override // com.baidu.android.imsdk.shield.request.IMSettingBaseHttpRequest
    public String getHostUrlParam() {
        return "chat_report";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() {
        try {
            long appid = AccountManager.getAppid(this.mContext);
            long uk = AccountManager.getUK(this.mContext);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", appid);
            jSONObject.put("uk_from", uk);
            jSONObject.put("uk_to", this.touk);
            jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
            jSONObject.put(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
            jSONObject.put("device_type", 2);
            jSONObject.put("timestamp", currentTimeMillis);
            int i2 = 1;
            jSONObject.put("reason", 1);
            int reportType = getReportType();
            jSONObject.put("report_type", reportType);
            if (reportType == 0 || reportType == 3) {
                jSONObject.put("bduk_to", Utility.transBDUID(this.uid + ""));
            }
            jSONObject.put("sign", getMd5("" + currentTimeMillis + uk + appid));
            if (!AccountManager.isCuidLogin(this.mContext)) {
                i2 = 0;
            }
            jSONObject.put("account_type", i2);
            LogUtils.d(TAG, "IMForbidRequest msg :" + jSONObject.toString());
            return jSONObject.toString().getBytes();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
        ShieldAndTopManager.getInstance(this.mContext).onForbidResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, true, "", this.key);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        String str;
        boolean z;
        String str2;
        int i3;
        String str3 = new String(bArr);
        LogUtils.e(TAG, "IMForbidRequest onSuccess :" + str3);
        boolean z2 = true;
        try {
            JSONObject jSONObject = new JSONObject(str3);
            int optInt = jSONObject.optInt("error_code");
            String optString = jSONObject.optString("error_msg");
            z2 = jSONObject.optBoolean("display_toast", false);
            str = z2 ? jSONObject.optString("toast", "") : "";
            z = z2;
            i3 = optInt;
            str2 = optString;
        } catch (JSONException e2) {
            LogUtils.e(TAG, "JSONException", e2);
            str = "";
            z = z2;
            str2 = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            i3 = 1010;
        }
        ShieldAndTopManager.getInstance(this.mContext).onForbidResult(i3, str2, z, str, this.key);
    }
}
