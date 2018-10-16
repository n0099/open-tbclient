package com.baidu.searchbox.http.interceptor;

import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.searchbox.dns.DnsParseResult;
import com.baidu.searchbox.http.dns.HttpDns;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.statistics.NetworkStat;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import java.io.IOException;
import java.net.InetAddress;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
/* loaded from: classes2.dex */
public class NetworkStatInterceptor implements Interceptor {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface ReadOverCallback {
        void onReadOver(long j);
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        NetworkStatRecord networkStatRecord;
        InetAddress localAddress;
        InetAddress inetAddress;
        Request request = chain.request();
        Object tag = request.tag();
        NetworkStat<Request> networkStat = null;
        if (!(tag instanceof HttpRequest)) {
            networkStatRecord = null;
        } else {
            NetworkStatRecord requestNetStat = ((HttpRequest) tag).getRequestNetStat();
            networkStat = ((HttpRequest) tag).getNetworkStat();
            networkStatRecord = requestNetStat;
        }
        if (networkStat == null && networkStatRecord == null) {
            return chain.proceed(request);
        }
        HttpRequest httpRequest = (HttpRequest) request.tag();
        Request okRequest = httpRequest != null ? httpRequest.getOkRequest() : request;
        long currentTimeMillis = System.currentTimeMillis();
        Connection connection = chain.connection();
        String protocol = connection.protocol().toString();
        HttpDns httpDns = (HttpDns) connection.route().address().dns();
        long dnsStartTime = httpDns.getDnsStartTime();
        long dnsEndTime = httpDns.getDnsEndTime();
        DnsParseResult dnsParseResult = httpDns.getDnsParseResult();
        String str = connection.socket().getLocalAddress() != null ? localAddress.getHostAddress() + ":" + connection.socket().getLocalPort() : "";
        String str2 = connection.socket().getInetAddress() != null ? inetAddress.getHostAddress() + ":" + connection.socket().getPort() : "";
        long contentLength = request.body() != null ? request.body().contentLength() : 0L;
        if (networkStat != null) {
            networkStat.onDnsParse(okRequest, dnsStartTime, dnsEndTime, dnsParseResult);
            networkStat.onConnect(okRequest, currentTimeMillis, protocol);
            networkStat.onReceiveLocalIp(okRequest, str);
            networkStat.onReceiveRemoteIp(okRequest, str2);
            networkStat.onRequestBodyLength(okRequest, contentLength);
        }
        Response wrapStatResponseBody = wrapStatResponseBody(okRequest, chain.proceed(request), networkStat, networkStatRecord);
        long currentTimeMillis2 = System.currentTimeMillis();
        long sentRequestAtMillis = wrapStatResponseBody.sentRequestAtMillis();
        long receivedResponseAtMillis = wrapStatResponseBody.receivedResponseAtMillis();
        ResponseBody body = wrapStatResponseBody.body();
        long contentLength2 = body != null ? body.contentLength() : 0L;
        int code = wrapStatResponseBody.code();
        String header = wrapStatResponseBody.header(NetworkStatRecord.HEAD_X_BFE_SVBBRERS);
        if (networkStat != null) {
            networkStat.onSendHeader(okRequest, sentRequestAtMillis);
            networkStat.onReceiveHeader(okRequest, receivedResponseAtMillis, wrapStatResponseBody.headers());
            networkStat.onResponse(okRequest, currentTimeMillis2);
            networkStat.onResponseBodyLength(okRequest, contentLength2);
            networkStat.onStatusCode(okRequest, code);
            if (wrapStatResponseBody.isRedirect()) {
                String header2 = wrapStatResponseBody.header("Location");
                if (!TextUtils.isEmpty(header2)) {
                    networkStat.onRedirect(okRequest, header2);
                }
            }
        }
        String errHeader = code >= 400 ? errHeader(wrapStatResponseBody) : "";
        if (networkStat != null && !TextUtils.isEmpty(errHeader)) {
            networkStat.onServerErrorHeader(okRequest, errHeader);
        }
        if (networkStatRecord != null) {
            if (wrapStatResponseBody.isRedirect()) {
                String header3 = wrapStatResponseBody.header("Location");
                if (!TextUtils.isEmpty(header3)) {
                    networkStatRecord.url = header3;
                }
            }
            networkStatRecord.dnsStartTs = dnsStartTime;
            networkStatRecord.dnsEndTs = dnsEndTime;
            if (dnsParseResult != null) {
                networkStatRecord.dnsDetail = dnsParseResult.toJson();
            }
            networkStatRecord.connTs = currentTimeMillis;
            networkStatRecord.localIP = str;
            networkStatRecord.remoteIP = str2;
            networkStatRecord.protocol = protocol;
            networkStatRecord.requestBodyLength = contentLength;
            networkStatRecord.responseTs = currentTimeMillis2;
            networkStatRecord.sendHeaderTs = sentRequestAtMillis;
            networkStatRecord.receiveHeaderTs = receivedResponseAtMillis;
            networkStatRecord.responseLength = contentLength2;
            networkStatRecord.statusCode = code;
            networkStatRecord.errheaders = errHeader;
            networkStatRecord.clientIP = header;
            networkStatRecord.isConnReused = httpRequest != null && httpRequest.isConnReused;
        }
        return wrapStatResponseBody;
    }

    private long parseTimeString(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            return 0L;
        }
    }

    private String errHeader(Response response) {
        Headers headers = response.headers();
        StringBuilder sb = new StringBuilder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            sb.append(headers.name(i));
            sb.append(":");
            sb.append(headers.value(i));
            sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        }
        return sb.toString();
    }

    private Response wrapStatResponseBody(final Request request, Response response, final NetworkStat<Request> networkStat, final NetworkStatRecord networkStatRecord) {
        final ResponseBody body;
        if (response == null || response.isRedirect() || (body = response.body()) == null) {
            return response;
        }
        return response.newBuilder().body(new ResponseBody() { // from class: com.baidu.searchbox.http.interceptor.NetworkStatInterceptor.1
            @Override // okhttp3.ResponseBody
            public MediaType contentType() {
                return body.contentType();
            }

            @Override // okhttp3.ResponseBody
            public long contentLength() {
                return body.contentLength();
            }

            @Override // okhttp3.ResponseBody
            public BufferedSource source() {
                return NetworkStatInterceptor.this.getWrapSource(body.source(), new ReadOverCallback() { // from class: com.baidu.searchbox.http.interceptor.NetworkStatInterceptor.1.1
                    @Override // com.baidu.searchbox.http.interceptor.NetworkStatInterceptor.ReadOverCallback
                    public void onReadOver(long j) {
                        if (networkStat != null) {
                            networkStat.onFinishReadContent(request, j);
                        }
                        if (networkStatRecord != null) {
                            networkStatRecord.realResponseLength = j;
                            networkStatRecord.readOverTs = System.currentTimeMillis();
                        }
                    }
                });
            }
        }).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BufferedSource getWrapSource(Source source, final ReadOverCallback readOverCallback) {
        return Okio.buffer(new ForwardingSource(source) { // from class: com.baidu.searchbox.http.interceptor.NetworkStatInterceptor.2
            boolean isReadOver;
            long sumBytes = 0;

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                try {
                    long read = super.read(buffer, j);
                    this.sumBytes = (read != -1 ? read : 0L) + this.sumBytes;
                    if (read == -1 && readOverCallback != null) {
                        readOverCallback.onReadOver(this.sumBytes);
                        this.isReadOver = true;
                    }
                    return read;
                } catch (Exception e) {
                    if (readOverCallback != null) {
                        readOverCallback.onReadOver(this.sumBytes);
                    }
                    throw e;
                }
            }

            @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                try {
                    super.close();
                } finally {
                    if (readOverCallback != null && !this.isReadOver) {
                        readOverCallback.onReadOver(this.sumBytes);
                    }
                }
            }
        });
    }
}
