package com.baidu.searchbox.network.support.okhttp.converters;

import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes2.dex */
public class RequestConverter {
    public static Request toOks(com.baidu.searchbox.network.outback.core.Request request) {
        ConverterUtils.requireNonNull(request, "request should not be null");
        request.getNetworkStatRecord().netEngine = 6;
        Request.Builder builder = new Request.Builder();
        HttpUrl oks = HttpUrlConverter.toOks(request.url());
        String method = request.method();
        if (request.headers() != null) {
            builder.headers(HeadersConverter.toOks(request.headers()));
        }
        Map<Class<?>, Object> tags = request.getTags();
        RequestBody requestBody = null;
        if (request.body() != null) {
            requestBody = RequestBodyConverter.toOks(request.body());
        }
        builder.method(method, requestBody);
        builder.url(oks);
        if (tags != null) {
            for (Map.Entry<Class<?>, Object> entry : tags.entrySet()) {
                builder.tag(entry.getKey(), entry.getValue());
            }
        }
        builder.tag(com.baidu.searchbox.network.outback.core.Request.class, request);
        return builder.build();
    }
}
