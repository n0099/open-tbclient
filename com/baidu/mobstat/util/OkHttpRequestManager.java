package com.baidu.mobstat.util;

import android.text.TextUtils;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;
/* loaded from: classes2.dex */
public class OkHttpRequestManager {

    /* loaded from: classes2.dex */
    public class GzipRequestInterceptor implements Interceptor {
        public GzipRequestInterceptor() {
        }

        private RequestBody forceContentLength(final RequestBody requestBody) throws IOException {
            final Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);
            return new RequestBody() { // from class: com.baidu.mobstat.util.OkHttpRequestManager.GzipRequestInterceptor.1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return buffer.size();
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return requestBody.contentType();
                }

                @Override // okhttp3.RequestBody
                public void writeTo(BufferedSink bufferedSink) throws IOException {
                    bufferedSink.write(buffer.snapshot());
                }
            };
        }

        private RequestBody gzip(final RequestBody requestBody, final String str) {
            return new RequestBody() { // from class: com.baidu.mobstat.util.OkHttpRequestManager.GzipRequestInterceptor.2
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return -1L;
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return requestBody.contentType();
                }

                @Override // okhttp3.RequestBody
                public void writeTo(BufferedSink bufferedSink) throws IOException {
                    BufferedSink buffer = Okio.buffer(new GzipSink(bufferedSink));
                    if (!TextUtils.isEmpty(str) && str.contains("bplus.gif")) {
                        buffer.write(new byte[]{72, 77, 48, 49});
                        buffer.write(new byte[]{0, 0, 0, 1});
                        buffer.write(new byte[]{0, 0, 3, -14});
                        buffer.write(new byte[]{0, 0, 0, 0, 0, 0, 0, 0});
                        buffer.write(new byte[]{0, 2});
                        buffer.write(new byte[]{0, 0});
                        buffer.write(new byte[]{72, 77, 48, 49});
                    }
                    requestBody.writeTo(buffer);
                    buffer.close();
                }
            };
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            if (request.body() == null) {
                return chain.proceed(request.newBuilder().header("Content-Encoding", "gzip").build());
            }
            if (request.header("Content-Encoding") != null) {
                return chain.proceed(request);
            }
            return chain.proceed(request.newBuilder().header("Content-Encoding", "gzip").method(request.method(), forceContentLength(gzip(request.body(), request.url().toString()))).build());
        }
    }
}
