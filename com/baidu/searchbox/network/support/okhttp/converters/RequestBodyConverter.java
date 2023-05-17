package com.baidu.searchbox.network.support.okhttp.converters;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
/* loaded from: classes3.dex */
public class RequestBodyConverter {
    public static RequestBody toOks(final com.baidu.searchbox.network.outback.core.RequestBody requestBody) {
        ConverterUtils.requireNonNull(requestBody, "requestBody should not be null");
        return new RequestBody() { // from class: com.baidu.searchbox.network.support.okhttp.converters.RequestBodyConverter.1
            @Override // okhttp3.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                com.baidu.searchbox.network.outback.core.RequestBody.this.writeTo(bufferedSink.outputStream());
            }

            @Override // okhttp3.RequestBody
            public long contentLength() throws IOException {
                return com.baidu.searchbox.network.outback.core.RequestBody.this.contentLength();
            }

            @Override // okhttp3.RequestBody
            public MediaType contentType() {
                if (com.baidu.searchbox.network.outback.core.RequestBody.this.contentType() != null) {
                    return MediaTypeConverter.toOks(com.baidu.searchbox.network.outback.core.RequestBody.this.contentType());
                }
                return null;
            }
        };
    }
}
