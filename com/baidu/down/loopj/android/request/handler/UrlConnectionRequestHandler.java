package com.baidu.down.loopj.android.request.handler;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.baidu.down.common.UrlDNSInfo;
import com.baidu.down.common.intercepter.ResponseInfo;
import com.baidu.down.loopj.android.http.BinaryHttpResponseHandler;
import com.baidu.down.loopj.android.http.exp.HandlerRetryException;
import com.baidu.down.loopj.android.http.exp.URLDNSException;
import com.baidu.down.loopj.android.urlconnection.ProxyURLConnection;
import com.baidu.down.loopj.android.urlconnection.UrlConnectionRetryHandler;
import com.baidu.down.retry.RetryRequestInfo;
import com.baidu.down.statistic.ThreadSpeedStat;
import com.baidu.down.utils.Utils;
import com.baidubce.http.Headers;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
/* loaded from: classes5.dex */
public class UrlConnectionRequestHandler implements ICommonRequestHandler {
    private static final boolean DEBUG = false;
    private static final String TAG = "UrlConnectionRequestHandler";
    private InputStream inputStream;
    private ProxyURLConnection mAsyncUrlConnection;
    private Map<String, String> mBackUpRequestHeader;
    private String mBackUpURL;
    private UrlDNSInfo mDomainNameAndIpInfo;
    private Map<String, String> mRequestHeader;
    private String mURL;
    private HttpURLConnection mURLConnectionRequest;
    private UrlConnectionRetryHandler mURLConnectionRetryHandler;
    private boolean mTlsCertSkip = false;
    private boolean mConvertDomainNameToIp = false;

    public UrlConnectionRequestHandler(ProxyURLConnection proxyURLConnection, String str, Map<String, String> map) {
        this.mURL = str;
        this.mAsyncUrlConnection = proxyURLConnection;
        this.mRequestHeader = map;
        this.mURLConnectionRetryHandler = this.mAsyncUrlConnection.getRetryHandler();
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public String onGetRequestHeader(String str) {
        return this.mRequestHeader.get(str);
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public void onSetRequestHeader(String str, String str2) {
        this.mRequestHeader.put(str, str2);
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public boolean onContainsRequestHeader(String str) {
        return this.mRequestHeader.containsKey(str);
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public void onRemoveRequestHeader(String str) {
        this.mRequestHeader.remove(str);
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public String onGetResponseHeader(String str) {
        return !isHttpRequestNull() ? this.mURLConnectionRequest.getHeaderField(str) : "";
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public String onGetHttpHeader(boolean z) throws IOException {
        Map<String, List<String>> headerFields;
        StringBuilder sb = new StringBuilder();
        if (!isHttpRequestNull()) {
            if (!z) {
                sb.append("Url:" + this.mURLConnectionRequest.getURL().toString() + " " + this.mURLConnectionRequest.getResponseCode() + "\n");
            } else {
                sb.append("Uri:" + this.mURLConnectionRequest.getURL().toString() + "\n");
            }
        } else {
            sb.append("Uri: null\n");
        }
        if (this.mRequestHeader != null) {
            for (String str : this.mRequestHeader.keySet()) {
                sb.append(str + ":" + this.mRequestHeader.get(str) + "\n");
            }
        }
        if (!isHttpRequestNull()) {
            sb.append(this.mURLConnectionRequest.getResponseMessage() + ": \n");
        }
        if (!z && !isHttpRequestNull() && (headerFields = this.mURLConnectionRequest.getHeaderFields()) != null) {
            for (String str2 : headerFields.keySet()) {
                if (str2 == null) {
                    sb.append(headerFields.get(str2).toString() + "\n");
                } else {
                    sb.append(str2.toString() + ":" + headerFields.get(str2).toString() + "\n");
                }
            }
        }
        return sb.toString();
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public void onExeHttpConnect(BinaryHttpResponseHandler binaryHttpResponseHandler, ThreadSpeedStat threadSpeedStat, boolean z) throws IOException {
        String str = this.mURL;
        if (Build.VERSION.SDK_INT < 21 && z) {
            str = Utils.getURLEncoderString(this.mURL);
        }
        String convertUrlDomainNameToIp = convertUrlDomainNameToIp(str);
        requestConnect(convertUrlDomainNameToIp);
        if (getHttpStatus() > 207 && this.mAsyncUrlConnection.usingDNSProxy()) {
            this.mURLConnectionRequest.disconnect();
            this.mAsyncUrlConnection.setUsingDNSProxy(false);
            requestConnect(convertUrlDomainNameToIp);
        }
        if (this.mConvertDomainNameToIp) {
            binaryHttpResponseHandler.saveDomainNameAndIpInfo(this.mDomainNameAndIpInfo);
            if (threadSpeedStat != null) {
                threadSpeedStat.ip = this.mDomainNameAndIpInfo.ip;
                threadSpeedStat.dt = this.mDomainNameAndIpInfo.dnsTime;
                threadSpeedStat.url = this.mURLConnectionRequest.getURL().toString();
                onSetRequestHeader(ThreadSpeedStat.CLIENT_REQUEST_ID_HEADER_NAME, threadSpeedStat.cqid);
            }
        } else if (threadSpeedStat != null) {
            threadSpeedStat.url = this.mURLConnectionRequest.getURL().toString();
            threadSpeedStat.ip = "";
            threadSpeedStat.dt = 0L;
            onSetRequestHeader(ThreadSpeedStat.CLIENT_REQUEST_ID_HEADER_NAME, threadSpeedStat.cqid);
        }
    }

    private void requestConnect(String str) throws IOException {
        if (this.mAsyncUrlConnection.usingDNSProxy()) {
            try {
                this.mRequestHeader.put("Host", new URI(str).getHost());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        if (this.mTlsCertSkip && URLUtil.isHttpsUrl(str)) {
            this.mURLConnectionRequest = this.mAsyncUrlConnection.getHttpURLConnection(str, this.mRequestHeader, true);
        } else if (this.mConvertDomainNameToIp && URLUtil.isHttpsUrl(str)) {
            this.mURLConnectionRequest = this.mAsyncUrlConnection.getHttpURLConnection(str, this.mRequestHeader, false, true);
        } else {
            this.mURLConnectionRequest = this.mAsyncUrlConnection.getHttpURLConnection(str, this.mRequestHeader, true, true);
        }
        this.mURLConnectionRequest.connect();
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public void onHandleFollowRedirect(HashSet<String> hashSet) throws RedirectException {
        String headerField = this.mURLConnectionRequest.getHeaderField(Headers.LOCATION);
        if (!TextUtils.isEmpty(headerField)) {
            Utils.removeMapKeyIgnoreCase(this.mRequestHeader, "Host");
            try {
                if (hashSet.contains(headerField)) {
                    throw new RedirectException("### Redirect circle : " + hashSet);
                }
                try {
                    URI uri = new URI(headerField);
                    URI uri2 = new URI(this.mURL);
                    if (TextUtils.isEmpty(uri.getHost())) {
                        headerField = this.mURL.replace(uri2.getPath(), headerField).replace(uri2.getQuery(), "");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                cloneRequest(headerField);
                hashSet.add(headerField);
                throw new HandlerRetryException("Redirect");
            } catch (IllegalArgumentException e2) {
                throw new RedirectException("Invalid uri: " + this.mURLConnectionRequest.getURL());
            }
        }
        throw new RedirectException("### Redirect null Location : " + this.mURLConnectionRequest.getURL());
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public boolean onRetryRequest(IOException iOException, int i, int i2) {
        return !isHttpRequestNull() ? this.mURLConnectionRetryHandler.retryRequest(iOException, i, this.mURLConnectionRequest.getURL().getHost(), i2) : this.mURLConnectionRetryHandler.retryRequest(iOException, i, "", i2);
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public int getHttpStatus() throws IOException {
        if (isHttpRequestNull()) {
            return 0;
        }
        return this.mURLConnectionRequest.getResponseCode();
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public ResponseInfo getResponseInfo() throws IOException {
        if (!isHttpRequestNull()) {
            ResponseInfo responseInfo = new ResponseInfo(this.mURLConnectionRequest.getRequestMethod(), this.mURL, this.mURLConnectionRequest.getResponseCode());
            for (String str : this.mRequestHeader.keySet()) {
                responseInfo.requestHeaders.put(str, this.mRequestHeader.get(str));
            }
            Map<String, List<String>> headerFields = this.mURLConnectionRequest.getHeaderFields();
            for (String str2 : headerFields.keySet()) {
                if (str2 == null) {
                    responseInfo.responseHeaders.put("null", headerFields.get(str2).get(0));
                } else {
                    responseInfo.responseHeaders.put(str2, headerFields.get(str2).get(0));
                }
            }
            return responseInfo;
        }
        return new ResponseInfo("", "", 0);
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public String getUrl() {
        return this.mURL;
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public boolean isHttpRequestNull() {
        return this.mURLConnectionRequest == null;
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public void cancelRequest() {
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public boolean cloneRequest(String str) {
        this.mURL = str;
        return true;
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public InputStream getInputStream() throws IllegalStateException, IOException {
        if (isGzip(this.mURLConnectionRequest.getContentEncoding())) {
            this.inputStream = new GZIPInputStream(this.mURLConnectionRequest.getInputStream());
        } else {
            this.inputStream = this.mURLConnectionRequest.getInputStream();
        }
        return this.inputStream;
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public long getContentLength() {
        return this.mURLConnectionRequest.getContentLength();
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public void closeConnection() {
    }

    private boolean isGzip(String str) {
        return str != null && str.contains("gzip");
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public void saveRequest() {
        this.mBackUpRequestHeader = this.mRequestHeader;
        this.mBackUpURL = this.mURL;
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public void restoreRequest() {
        if (this.mBackUpRequestHeader != null) {
            this.mRequestHeader = this.mBackUpRequestHeader;
            this.mBackUpRequestHeader = null;
            this.mURL = this.mBackUpURL;
            this.mBackUpURL = null;
        }
        if (this.mAsyncUrlConnection.usingDNSProxy()) {
            this.mAsyncUrlConnection.setUsingDNSProxy(false);
        }
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public void replaceRequest(RetryRequestInfo retryRequestInfo) {
        if (this.mBackUpRequestHeader != null) {
            this.mRequestHeader = new HashMap();
            for (String str : this.mBackUpRequestHeader.keySet()) {
                this.mRequestHeader.put(str, this.mBackUpRequestHeader.get(str));
            }
            this.mURL = retryRequestInfo.url;
            if (!retryRequestInfo.header.isEmpty()) {
                for (String str2 : retryRequestInfo.header.keySet()) {
                    if (TextUtils.isEmpty(retryRequestInfo.header.get(str2))) {
                        this.mRequestHeader.remove(str2);
                    } else {
                        this.mRequestHeader.put(str2, retryRequestInfo.header.get(str2));
                    }
                }
            }
        }
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public void closeInputStream() {
        try {
            if (this.inputStream != null) {
                this.inputStream.close();
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.down.loopj.android.request.handler.ICommonRequestHandler
    public void setTlsCertSkip(boolean z) {
        this.mTlsCertSkip = z;
    }

    @SuppressLint({"LongLogTag"})
    private String convertUrlDomainNameToIp(String str) throws URLDNSException {
        if (!isConvertUrlDomainNameToIp()) {
            this.mConvertDomainNameToIp = false;
            return str;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String host = new URI(str).getHost();
            InetAddress[] allByName = InetAddress.getAllByName(host);
            if (allByName == null || allByName.length == 0 || TextUtils.isEmpty(host)) {
                throw new URLDNSException("Dns failed");
            }
            if (!host.equalsIgnoreCase(allByName[0].getHostAddress())) {
                String replace = str.replace(host, allByName[0].getHostAddress());
                try {
                    new URL(replace);
                    try {
                        Utils.removeMapKeyIgnoreCase(this.mRequestHeader, "Host");
                        this.mRequestHeader.put("Host", host);
                        this.mDomainNameAndIpInfo = new UrlDNSInfo();
                        this.mDomainNameAndIpInfo.host = host;
                        this.mDomainNameAndIpInfo.ip = allByName[0].getHostAddress();
                        this.mDomainNameAndIpInfo.dnsTime = System.currentTimeMillis() - currentTimeMillis;
                        this.mConvertDomainNameToIp = true;
                        return replace;
                    } catch (Exception e) {
                        str = replace;
                        e = e;
                        e.printStackTrace();
                        this.mConvertDomainNameToIp = false;
                        return str;
                    }
                } catch (MalformedURLException e2) {
                    e2.printStackTrace();
                    this.mConvertDomainNameToIp = false;
                    return str;
                }
            }
            this.mConvertDomainNameToIp = false;
            return str;
        } catch (Exception e3) {
            e = e3;
        }
    }

    private boolean isConvertUrlDomainNameToIp() {
        return false;
    }
}
