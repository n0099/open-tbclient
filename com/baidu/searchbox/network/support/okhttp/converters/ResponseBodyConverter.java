package com.baidu.searchbox.network.support.okhttp.converters;

import com.baidu.searchbox.network.outback.core.ResponseBody;
/* loaded from: classes4.dex */
public class ResponseBodyConverter {
    public static ResponseBody fromOks(okhttp3.ResponseBody responseBody) {
        return ResponseBody.create(MediaTypeConverter.fromOks(responseBody.contentType()), responseBody.contentLength(), responseBody.source().inputStream());
    }
}
