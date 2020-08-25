package com.baidu.searchbox.network.core.http;

import android.text.TextUtils;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.searchbox.network.core.Headers;
import com.baidu.searchbox.network.core.Interceptor;
import com.baidu.searchbox.network.core.Protocol;
import com.baidu.searchbox.network.core.Request;
import com.baidu.searchbox.network.core.Response;
import com.baidu.searchbox.network.core.ResponseBody;
import com.baidu.searchbox.network.core.connect.Connection;
import com.baidu.searchbox.network.core.internal.Util;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.Okio;
import okio.Source;
/* loaded from: classes14.dex */
public final class CallServerInterceptor implements Interceptor {
    private static final String TAG = CallServerInterceptor.class.getSimpleName();
    private Connection mConnection;
    private long sentRequestMillis;

    @Override // com.baidu.searchbox.network.core.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        this.mConnection = chain.connection();
        return readResponse(chain.request());
    }

    private Response readResponse(Request request) throws IOException {
        try {
            return parseResponse(request, this.mConnection.getHeaders());
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    private Response parseResponse(Request request, Map<String, List<String>> map) throws IOException {
        Response.Builder builder = new Response.Builder();
        builder.request(request);
        int netEngine = this.mConnection.getNetEngine();
        builder.netEngine(netEngine);
        try {
            this.sentRequestMillis = System.currentTimeMillis();
            builder.sentRequestAtMillis(this.sentRequestMillis).code(this.mConnection.getCode()).message(this.mConnection.getMessage());
            Headers.Builder builder2 = new Headers.Builder();
            int i = 0;
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                if (netEngine == 1 && i == 0) {
                    parseUrlConnectionProperties(builder, entry.getValue().get(0).toString());
                    i++;
                }
                if (entry.getKey() != null) {
                    builder2.namesAndValues.add(entry.getKey());
                    builder2.namesAndValues.add(TextUtils.join("; ", entry.getValue()));
                }
            }
            Headers build = builder2.build();
            builder.body(openResponseBody(build));
            builder.isConnReused(TextUtils.equals(build.get("socket-reused"), "1"));
            if (netEngine == 3) {
                parseCronetProperties(builder, build);
            }
            builder.headers(build).receivedResponseAtMillis(System.currentTimeMillis());
            return builder.build();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void parseUrlConnectionProperties(Response.Builder builder, String str) throws IOException {
        builder.protocol(StatusLine.parse(str).protocol);
    }

    private void parseCronetProperties(Response.Builder builder, Headers headers) {
        try {
            builder.dnsTime(Long.parseLong(headers.get("dns")) / 1000);
            builder.sslTime(Long.parseLong(headers.get("ssl")) / 1000);
            builder.tcpTime(Long.parseLong(headers.get("tcp")) / 1000);
            builder.sendTime(Long.parseLong(headers.get(UbcStatConstant.ContentType.UBC_TYPE_IM_SEND)));
            builder.cached(TextUtils.equals(headers.get("cached"), "1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        builder.protocol(Protocol.get(headers.get("protocol")));
    }

    public ResponseBody openResponseBody(Headers headers) throws IOException {
        String str = headers.get("Content-Type");
        long contentLength = HttpHeaders.contentLength(headers);
        Source source = null;
        try {
            source = Okio.source(this.mConnection.getInputStream());
            return new RealResponseBody(str, contentLength, Okio.buffer(source));
        } catch (IOException e) {
            e.printStackTrace();
            Util.closeQuietly(source);
            throw new IOException(e);
        }
    }
}
