package com.baidu.android.imsdk.account.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.android.pushservice.PushConstants;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.cookie.SM;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IMGetPaidByAppidRequest extends BaseHttpRequest {
    private long mAppid;
    private String mBduss;
    private String mKey;

    public IMGetPaidByAppidRequest(Context context, long j, String str, String str2) {
        this.mContext = context;
        this.mKey = str2;
        this.mAppid = j;
        this.mBduss = str;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        String str;
        long j;
        int i3;
        String str2 = new String(bArr);
        LogUtils.d("IMGetPaidByAppidRequest", str2);
        String str3 = Constants.ERROR_MSG_SUCCESS;
        long j2 = -1;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.has("response_params")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
                i3 = jSONObject2.getInt("error_code");
                if (i3 == 0) {
                    j2 = jSONObject2.getLong("pa_uid");
                }
            } else {
                i3 = jSONObject.getInt("error_code");
                str3 = jSONObject.getString(PushConstants.EXTRA_ERROR_CODE);
            }
            j = j2;
            String str4 = str3;
            i2 = i3;
            str = str4;
        } catch (JSONException e) {
            LogUtils.e("IMGetPaidByAppidRequest", e.getMessage(), e);
            i2 = 1010;
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
            j = -1;
        }
        AccountManagerImpl.getInstance(this.mContext).onSetZhidaAppidResult(this.mKey, i2, str, this.mAppid, j);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        AccountManagerImpl.getInstance(this.mContext).onSetZhidaAppidResult(this.mKey, ((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.mAppid, -1L);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        switch (Utility.readIntData(this.mContext, Constants.KEY_ENV, 0)) {
            case 0:
                return "https://pim.baidu.com/rest/2.0/im/zhidahao";
            case 1:
            case 2:
                return "https://cp01-ocean-749.epc.baidu.com:8444/rest/2.0/im/zhidahao";
            case 3:
                return "http://180.97.36.95:8080/rest/2.0/im/zhidahao";
            default:
                return null;
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "GET";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() {
        StringBuilder sb = new StringBuilder("method=get_pa_by_appid");
        sb.append("&hsc=1");
        sb.append("&appid=" + this.mAppid);
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put(SM.COOKIE, "BDUSS=" + this.mBduss);
        return hashMap;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
