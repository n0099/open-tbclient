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
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMGetPaidByAppidRequest extends BaseHttpRequest {
    public long mAppid;
    public String mBduss;
    public String mKey;

    public IMGetPaidByAppidRequest(Context context, long j, String str, String str2) {
        this.mContext = context;
        this.mKey = str2;
        this.mAppid = j;
        this.mBduss = str;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put("Cookie", "BDUSS=" + this.mBduss);
        return hashMap;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        int readIntData = Utility.readIntData(this.mContext, Constants.KEY_ENV, 0);
        if (readIntData != 0) {
            if (readIntData == 1 || readIntData == 2) {
                return "https://rd-im-server.bcc-szth.baidu.com:8444/rest/2.0/im/zhidahao";
            }
            if (readIntData != 3) {
                return null;
            }
            return "http://180.97.36.95:8080/rest/2.0/im/zhidahao";
        }
        return "https://pim.baidu.com/rest/2.0/im/zhidahao";
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

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
        AccountManagerImpl.getInstance(this.mContext).onSetZhidaAppidResult(this.mKey, ((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.mAppid, -1L);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        String str;
        long j;
        int i3;
        int i4;
        String string;
        String str2 = new String(bArr);
        LogUtils.d("IMGetPaidByAppidRequest", str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.has("response_params")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
                i4 = jSONObject2.getInt("error_code");
                r1 = i4 == 0 ? jSONObject2.getLong("pa_uid") : -1L;
                string = Constants.ERROR_MSG_SUCCESS;
            } else {
                i4 = jSONObject.getInt("error_code");
                string = jSONObject.getString("error_msg");
            }
            str = string;
            i3 = i4;
            j = r1;
        } catch (JSONException e2) {
            LogUtils.e("IMGetPaidByAppidRequest", e2.getMessage(), e2);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            j = -1;
            i3 = 1010;
        }
        AccountManagerImpl.getInstance(this.mContext).onSetZhidaAppidResult(this.mKey, i3, str, this.mAppid, j);
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
