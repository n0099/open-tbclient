package com.baidu.searchbox.network.core.http;

import com.baidu.searchbox.network.core.Cookie;
import com.baidu.searchbox.network.core.CookieJar;
import com.baidu.searchbox.network.core.Interceptor;
import com.baidu.searchbox.network.core.MediaType;
import com.baidu.searchbox.network.core.Request;
import com.baidu.searchbox.network.core.RequestBody;
import com.baidu.searchbox.network.core.Response;
import com.baidu.searchbox.network.core.internal.Util;
import com.baidu.searchbox.network.core.internal.Version;
import com.baidubce.http.Headers;
import java.io.IOException;
import java.util.List;
import org.apache.http.cookie.SM;
import org.apache.http.protocol.HTTP;
/* loaded from: classes15.dex */
public final class BridgeInterceptor implements Interceptor {
    private final CookieJar cookieJar;

    public BridgeInterceptor(CookieJar cookieJar) {
        this.cookieJar = cookieJar;
    }

    @Override // com.baidu.searchbox.network.core.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        boolean z = false;
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        RequestBody body = request.body();
        if (body != null) {
            MediaType contentType = body.contentType();
            if (contentType != null) {
                newBuilder.header("Content-Type", contentType.toString());
            }
            long contentLength = body.contentLength();
            if (contentLength != -1) {
                newBuilder.header("Content-Length", Long.toString(contentLength));
                newBuilder.removeHeader("Transfer-Encoding");
            } else {
                newBuilder.header("Transfer-Encoding", HTTP.CHUNK_CODING);
                newBuilder.removeHeader("Content-Length");
            }
        }
        if (request.header("Host") == null) {
            newBuilder.header("Host", Util.hostHeader(request.url(), false));
        }
        if (request.header(HTTP.CONN_DIRECTIVE) == null) {
            newBuilder.header(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        }
        if (request.header(Headers.ACCEPT_ENCODING) == null && request.header(Headers.RANGE) == null) {
            z = true;
            newBuilder.header(Headers.ACCEPT_ENCODING, "gzip");
        }
        List<Cookie> loadForRequest = this.cookieJar.loadForRequest(request);
        if (!loadForRequest.isEmpty()) {
            newBuilder.header(SM.COOKIE, cookieHeader(loadForRequest));
        }
        String header = request.header("User-Agent");
        if (request.httpRequest().getHeaders().get("User-Agent") == null) {
            if (header == null) {
                newBuilder.header("User-Agent", Version.userAgent());
            } else {
                newBuilder.header("User-Agent", Version.userAgent() + " " + header);
            }
        }
        Response proceed = chain.proceed(newBuilder.build());
        HttpHeaders.receiveHeaders(this.cookieJar, request, proceed.headers());
        Response.Builder request2 = proceed.newBuilder().request(request);
        if (z && "gzip".equalsIgnoreCase(proceed.header("Content-Encoding")) && HttpHeaders.hasBody(proceed)) {
            request2.headers(proceed.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build());
            request2.body(proceed.body());
        }
        return request2.build();
    }

    private String cookieHeader(List<Cookie> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            Cookie cookie = list.get(i);
            sb.append(cookie.name()).append('=').append(cookie.value());
        }
        return sb.toString();
    }
}
