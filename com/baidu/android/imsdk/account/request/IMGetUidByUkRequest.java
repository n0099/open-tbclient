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
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMGetUidByUkRequest implements HttpHelper.Request, HttpHelper.ResponseHandler {
    public Context mContext;
    public String mKey;
    public long[] mUks;

    public IMGetUidByUkRequest(Context context, long[] jArr, String str) {
        this.mContext = context;
        this.mKey = str;
        this.mUks = jArr;
    }

    private String contactWithComma(long[] jArr) {
        StringBuilder sb = new StringBuilder("" + jArr[0]);
        for (int i2 = 1; i2 < jArr.length; i2++) {
            sb.append(",");
            sb.append(jArr[i2]);
        }
        return sb.toString();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public int getConnectTimeout() {
        return 15000;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put("Cookie", "BDUSS=" + AccountManagerImpl.getInstance(this.mContext).getToken());
        return hashMap;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        int readIntData = Utility.readIntData(this.mContext, Constants.KEY_ENV, 0);
        if (readIntData != 0) {
            if (readIntData != 1) {
                if (readIntData != 2) {
                    if (readIntData != 3) {
                        return null;
                    }
                    return "http://180.97.36.95:8080/rest/2.0/im/zhidahao";
                }
                return "http://10.64.132.67:8080/rest/2.0/im/zhidahao";
            }
            return "http://rd-im-server.bcc-szth.baidu.com:8080/rest/2.0/im/zhidahao";
        }
        return "https://pim.baidu.com/rest/2.0/im/zhidahao";
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "GET";
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public int getReadTimeout() {
        return 15000;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() {
        StringBuilder sb = new StringBuilder("method=get_baidu_id");
        sb.append("&uks=" + contactWithComma(this.mUks));
        sb.append("&hsc=1");
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
        AccountManagerImpl.getInstance(this.mContext).onGetUidByUkResult(this.mKey, ((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.mUks, null);
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        TreeMap treeMap;
        String str;
        int i3;
        int i4;
        String string;
        long[] jArr;
        String str2 = new String(bArr);
        LogUtils.d("IMGetUidByUkRequest", str2);
        TreeMap treeMap2 = null;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.has("response_params")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
                i4 = jSONObject2.getInt("error_code");
                if (i4 == 0) {
                    TreeMap treeMap3 = new TreeMap();
                    try {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("info");
                        for (long j : this.mUks) {
                            treeMap3.put(Long.valueOf(j), Long.valueOf(jSONObject3.optLong("" + j, -1L)));
                        }
                        treeMap2 = treeMap3;
                    } catch (JSONException e2) {
                        e = e2;
                        treeMap2 = treeMap3;
                        LogUtils.e("IMGetUidByUkRequest", e.getMessage(), e);
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                        str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                        treeMap = treeMap2;
                        i3 = 1010;
                        AccountManagerImpl.getInstance(this.mContext).onGetUidByUkResult(this.mKey, i3, str, this.mUks, treeMap);
                    }
                }
                string = Constants.ERROR_MSG_SUCCESS;
            } else {
                i4 = jSONObject.getInt("error_code");
                string = jSONObject.getString("error_msg");
            }
            str = string;
            i3 = i4;
            treeMap = treeMap2;
        } catch (JSONException e3) {
            e = e3;
        }
        AccountManagerImpl.getInstance(this.mContext).onGetUidByUkResult(this.mKey, i3, str, this.mUks, treeMap);
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }

    public Pair<Integer, String> transErrorCode(int i2, byte[] bArr, Throwable th) {
        String str;
        if (th != null) {
            i2 = 1012;
            str = Constants.ERROR_MSG_HTTP_IOEXCEPTION_ERROR;
        } else if (i2 == 1005) {
            str = new String(bArr);
        } else {
            str = "http response is error! response code:" + i2;
            i2 = 1011;
        }
        return new Pair<>(Integer.valueOf(i2), str);
    }
}
