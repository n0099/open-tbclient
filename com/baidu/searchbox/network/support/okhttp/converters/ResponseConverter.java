package com.baidu.searchbox.network.support.okhttp.converters;

import androidx.annotation.NonNull;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.Response;
import com.baidu.searchbox.network.outback.statistics.NetworkStatRecord;
import okhttp3.Protocol;
/* loaded from: classes2.dex */
public class ResponseConverter {
    public static Response fromOks(@NonNull Request request, @NonNull okhttp3.Response response) {
        Response.Builder builder = new Response.Builder();
        builder.protocol(ProtocolConverter.fromOks(response.protocol()));
        builder.code(response.code());
        builder.message(response.message());
        builder.headers(HeadersConverter.fromOks(response.headers()));
        if (response.body() != null) {
            builder.body(ResponseBodyConverter.fromOks(response.body()));
        }
        builder.sentRequestAtMillis(response.sentRequestAtMillis());
        builder.receivedResponseAtMillis(response.receivedResponseAtMillis());
        if (response.request() != null && response.request().tag(Request.class) != null) {
            builder.request((Request) response.request().tag(Request.class));
            builder.statRecord(((Request) response.request().tag(Request.class)).getNetworkStatRecord());
        } else {
            builder.request(request);
            builder.statRecord(request.getNetworkStatRecord());
        }
        Response build = builder.build();
        updateResponseToNetworkRecord(build, response);
        if (response.cacheResponse() != null) {
            builder.cacheResponse(fromOks(request, response.cacheResponse()));
        }
        if (response.networkResponse() != null) {
            builder.networkResponse(fromOks(request, response.networkResponse()));
        }
        if (response.priorResponse() != null) {
            builder.priorResponse(fromOks(request, response.priorResponse()));
        }
        return build;
    }

    public static void updateResponseToNetworkRecord(Response response, okhttp3.Response response2) {
        String protocol;
        response.getStatRecord().statusCode = response2.code();
        Protocol protocol2 = response2.protocol();
        NetworkStatRecord statRecord = response.getStatRecord();
        if (protocol2 == null) {
            protocol = "unknown";
        } else {
            protocol = protocol2.toString();
        }
        statRecord.protocol = protocol;
    }
}
