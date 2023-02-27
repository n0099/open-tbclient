package com.baidu.searchbox.dns.transmit.transmitter;

import android.text.TextUtils;
import com.baidu.searchbox.dns.transmit.transmitter.exception.RetryException;
import com.baidu.searchbox.dns.util.DnsUtil;
import java.net.HttpURLConnection;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class HttpGetDataTransmitter<T> extends HttpDataTransmitter<T> {
    public static final String TAG = "HttpGetDataTransmitter";

    public abstract String getHttpUrl();

    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpDataTransmitter
    public void postHandleConnection(HttpURLConnection httpURLConnection) throws RetryException {
    }

    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpDataTransmitter
    public String getUrl() {
        StringBuilder sb = new StringBuilder();
        String httpUrl = getHttpUrl();
        Map<String, Object> parameters = getParameters();
        String str = "?";
        if (httpUrl.contains("?")) {
            str = "&";
        }
        sb.append(str);
        String buildParametersString = buildParametersString(parameters);
        if (!TextUtils.isEmpty(buildParametersString)) {
            sb.append(buildParametersString);
        }
        String str2 = httpUrl + sb.toString();
        if (DnsUtil.DEBUG && !TextUtils.isEmpty(DnsUtil.httpDnsDebugExtraQueryParams)) {
            return str2 + "&" + DnsUtil.httpDnsDebugExtraQueryParams;
        }
        return str2;
    }
}
