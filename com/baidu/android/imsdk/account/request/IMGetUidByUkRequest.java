package com.baidu.android.imsdk.account.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.android.pushservice.PushConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.cookie.SM;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class IMGetUidByUkRequest implements HttpHelper.Request, HttpHelper.ResponseHandler {
    private Context mContext;
    private String mKey;
    private long[] mUks;

    public IMGetUidByUkRequest(Context context, long[] jArr, String str) {
        this.mContext = context;
        this.mKey = str;
        this.mUks = jArr;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        TreeMap treeMap;
        int i2;
        String str;
        String string;
        TreeMap treeMap2;
        long[] jArr;
        String str2 = new String(bArr);
        LogUtils.d("IMGetUidByUkRequest", str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.has("response_params")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
                int i3 = jSONObject2.getInt("error_code");
                if (i3 != 0) {
                    treeMap2 = null;
                } else {
                    treeMap2 = new TreeMap();
                    try {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("info");
                        for (long j : this.mUks) {
                            treeMap2.put(Long.valueOf(j), Long.valueOf(jSONObject3.optLong("" + j, -1L)));
                        }
                    } catch (JSONException e) {
                        treeMap = treeMap2;
                        e = e;
                        LogUtils.e("IMGetUidByUkRequest", e.getMessage(), e);
                        i2 = 1010;
                        str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                        AccountManagerImpl.getInstance(this.mContext).onGetUidByUkResult(this.mKey, i2, str, this.mUks, treeMap);
                    }
                }
                string = Constants.ERROR_MSG_SUCCESS;
                i2 = i3;
            } else {
                i2 = jSONObject.getInt("error_code");
                string = jSONObject.getString(PushConstants.EXTRA_ERROR_CODE);
                treeMap2 = null;
            }
            treeMap = treeMap2;
            str = string;
        } catch (JSONException e2) {
            e = e2;
            treeMap = null;
        }
        AccountManagerImpl.getInstance(this.mContext).onGetUidByUkResult(this.mKey, i2, str, this.mUks, treeMap);
    }

    public Pair<Integer, String> transErrorCode(int i, byte[] bArr, Throwable th) {
        String str;
        if (th == null) {
            if (i == 1005) {
                str = new String(bArr);
            } else {
                str = "http response is error! response code:" + i;
                i = 1011;
            }
        } else {
            i = 1012;
            str = Constants.ERROR_MSG_HTTP_IOEXCEPTION_ERROR;
        }
        return new Pair<>(Integer.valueOf(i), str);
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        AccountManagerImpl.getInstance(this.mContext).onGetUidByUkResult(this.mKey, ((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.mUks, null);
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
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

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "GET";
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() {
        StringBuilder sb = new StringBuilder("method=get_baidu_id");
        sb.append("&uks=" + contactWithComma(this.mUks));
        sb.append("&hsc=1");
        return sb.toString().getBytes();
    }

    private String contactWithComma(long[] jArr) {
        StringBuilder sb = new StringBuilder("" + jArr[0]);
        for (int i = 1; i < jArr.length; i++) {
            sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append(jArr[i]);
        }
        return sb.toString();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put(SM.COOKIE, "BDUSS=" + AccountManagerImpl.getInstance(this.mContext).getToken());
        return hashMap;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
