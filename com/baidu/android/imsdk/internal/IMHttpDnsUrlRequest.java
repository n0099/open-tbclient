package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.util.ArrayMap;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IMHttpDnsUrlRequest extends BaseHttpRequest {
    public static final String HTTP_DNS_HOST = "https://httpsdns.baidu.com/";
    private static final String HTTP_DNS_URL = "https://180.76.76.112/v6/0025";
    private static final String HTTP_DNS_URL_IPV6 = "https://[240c:4006::6666]/v6/0025";
    private static final String TAG = "IMHttpDnsUrlRequest";

    public IMHttpDnsUrlRequest(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        ArrayList arrayList;
        String str = new String(bArr);
        LogUtils.d(TAG, "onSuccess----ip of " + Constants.URL_SOCKET_SERVER + " is " + str);
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("data").getJSONObject(Constants.URL_SOCKET_SERVER);
            JSONArray optJSONArray = jSONObject.optJSONArray(TableDefine.UserInfoColumns.COLUMN_IP);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("ipv6");
            int length = optJSONArray2 == null ? 0 : optJSONArray2.length();
            int length2 = optJSONArray == null ? 0 : optJSONArray.length();
            if (length2 + length <= 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                if (optJSONArray != null && length2 > 0) {
                    try {
                        arrayList.add(optJSONArray.getString(0));
                    } catch (Exception e) {
                        e = e;
                        LogUtils.e(TAG, "HttpDnsRequester ip parse exception " + e.getMessage());
                        IMSocketAddrProvider.getInstance(this.mContext).onGetHttpDNSAddressResult(arrayList);
                    }
                }
                if (optJSONArray2 != null && length > 0) {
                    arrayList.add(optJSONArray2.getString(0));
                }
            }
        } catch (Exception e2) {
            e = e2;
            arrayList = null;
        }
        IMSocketAddrProvider.getInstance(this.mContext).onGetHttpDNSAddressResult(arrayList);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        LogUtils.d(TAG, "onFailure errorCode :" + i);
        IMSocketAddrProvider.getInstance(this.mContext).onGetHttpDNSAddressResult(null);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        return !Utility.isIpv4Reachable() ? HTTP_DNS_URL_IPV6 : HTTP_DNS_URL;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() {
        return ("type=ipv4,ipv6&dn=" + Constants.URL_SOCKET_SERVER).getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("Host", HTTP_DNS_HOST);
        return arrayMap;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public int getConnectTimeout() {
        return 5000;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }
}
