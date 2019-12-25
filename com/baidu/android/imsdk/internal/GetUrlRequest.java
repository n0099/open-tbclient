package com.baidu.android.imsdk.internal;

import com.baidu.android.imsdk.internal.IMUrlProvider;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
/* loaded from: classes2.dex */
public class GetUrlRequest extends BaseHttpRequest {
    private static final String HTTPDNSURL = "https://httpsdns.baidu.com/";
    private String mKey;
    private IMUrlProvider.HttpDNSUrlProvider mProvider;
    private String mUrl;

    public GetUrlRequest(String str, IMUrlProvider.HttpDNSUrlProvider httpDNSUrlProvider, String str2) {
        this.mUrl = "";
        this.mKey = "";
        this.mProvider = null;
        this.mKey = str2;
        this.mUrl = str;
        this.mProvider = httpDNSUrlProvider;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        String str = new String(bArr);
        LogUtils.d("GetUrlRequest", "----ip of " + this.mUrl + " is " + str);
        this.mProvider.onGetUrlResult(i, Constants.ERROR_MSG_SUCCESS, str.split("\\s"), this.mKey);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        this.mProvider.onGetUrlResult(i, new String(bArr), null, this.mKey);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        return HTTPDNSURL;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        return ("dn=" + this.mUrl).getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        return null;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
