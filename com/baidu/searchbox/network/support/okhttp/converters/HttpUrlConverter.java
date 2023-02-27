package com.baidu.searchbox.network.support.okhttp.converters;

import com.baidu.searchbox.network.outback.core.UrlWrapper;
import okhttp3.HttpUrl;
/* loaded from: classes2.dex */
public class HttpUrlConverter {
    public static HttpUrl.Builder deepCopyBuilder(com.baidu.searchbox.network.outback.core.HttpUrl httpUrl) {
        HttpUrl.Builder builder = new HttpUrl.Builder();
        builder.scheme(httpUrl.scheme());
        builder.port(httpUrl.port());
        builder.host(httpUrl.host());
        builder.encodedUsername(httpUrl.encodedUsername());
        builder.encodedPassword(httpUrl.encodedPassword());
        builder.encodedFragment(httpUrl.encodedFragment());
        builder.query(httpUrl.encodedQuery());
        for (String str : httpUrl.pathSegments()) {
            builder.addPathSegment(str);
        }
        return builder;
    }

    public static com.baidu.searchbox.network.outback.core.HttpUrl fromOks(HttpUrl httpUrl) {
        ConverterUtils.requireNonNull(httpUrl, "ok httpUrl should not be null");
        return com.baidu.searchbox.network.outback.core.HttpUrl.parse(httpUrl.toString());
    }

    public static HttpUrl toOks(UrlWrapper urlWrapper) {
        ConverterUtils.requireNonNull(urlWrapper, "httpUrl should not be null");
        if (urlWrapper.getDefaultHttpUrl() != null) {
            return deepCopyBuilder(urlWrapper.getDefaultHttpUrl()).build();
        }
        return HttpUrl.parse(urlWrapper.toString());
    }
}
