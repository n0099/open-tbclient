package com.baidu.searchbox.network.outback.core;

import androidx.annotation.Nullable;
import com.baidu.searchbox.network.outback.core.Headers;
import com.baidu.searchbox.network.outback.statistics.NetworkStatRecord;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
/* loaded from: classes2.dex */
public final class Response implements Closeable {
    @Nullable
    public ResponseBody body;
    @Nullable
    public final Response cacheResponse;
    public final boolean cached;
    public final int code;
    public final long dnsTime;
    public final Headers headers;
    public final boolean isConnReused;
    public final String message;
    public final int netEngine;
    @Nullable
    public final Response networkResponse;
    @Nullable
    public final Response priorResponse;
    public final Protocol protocol;
    public final long receivedResponseAtMillis;
    public final Request request;
    public final long sendTime;
    public final long sentRequestAtMillis;
    public final long sslTime;
    @Nullable
    public final NetworkStatRecord statRecord;
    public final long tcpTime;

    /* loaded from: classes2.dex */
    public static class Builder {
        @Nullable
        public ResponseBody body;
        @Nullable
        public Response cacheResponse;
        public boolean cached;
        public int code;
        public long dnsTime;
        public Headers.Builder headers;
        public boolean isConnReused;
        public String message;
        public int netEngine;
        @Nullable
        public Response networkResponse;
        @Nullable
        public Response priorResponse;
        @Nullable
        public Protocol protocol;
        public long receivedResponseAtMillis;
        @Nullable
        public Request request;
        public long sendTime;
        public long sentRequestAtMillis;
        public long sslTime;
        public NetworkStatRecord statRecord;
        public long tcpTime;

        public Builder() {
            this.code = -1;
            this.isConnReused = false;
            this.headers = new Headers.Builder();
        }

        public Builder(Response response) {
            this.code = -1;
            this.isConnReused = false;
            this.request = response.request;
            this.protocol = response.protocol;
            this.code = response.code;
            this.message = response.message;
            this.headers = response.headers.newBuilder();
            this.body = response.body;
            this.networkResponse = response.networkResponse;
            this.cacheResponse = response.cacheResponse;
            this.priorResponse = response.priorResponse;
            this.sentRequestAtMillis = response.sentRequestAtMillis;
            this.receivedResponseAtMillis = response.receivedResponseAtMillis;
            this.netEngine = response.netEngine;
            this.isConnReused = response.isConnReused;
            this.dnsTime = response.dnsTime;
            this.sslTime = response.sslTime;
            this.tcpTime = response.tcpTime;
            this.sendTime = response.sendTime;
            this.cached = response.cached;
            this.statRecord = response.statRecord;
        }

        private void checkPriorResponse(Response response) {
            if (response.body == null) {
                return;
            }
            throw new IllegalArgumentException("priorResponse.body != null");
        }

        public Builder body(@Nullable ResponseBody responseBody) {
            this.body = responseBody;
            return this;
        }

        public Builder cacheResponse(@Nullable Response response) {
            if (response != null) {
                checkSupportResponse("cacheResponse", response);
            }
            this.cacheResponse = response;
            return this;
        }

        public Builder cached(boolean z) {
            this.cached = z;
            return this;
        }

        public Builder code(int i) {
            this.code = i;
            return this;
        }

        public Builder dnsTime(long j) {
            this.dnsTime = j;
            return this;
        }

        public Builder headers(Headers headers) {
            this.headers = headers.newBuilder();
            return this;
        }

        public Builder isConnReused(boolean z) {
            this.isConnReused = z;
            return this;
        }

        public Builder message(String str) {
            this.message = str;
            return this;
        }

        public Builder netEngine(int i) {
            this.netEngine = i;
            return this;
        }

        public Builder networkResponse(@Nullable Response response) {
            if (response != null) {
                checkSupportResponse("networkResponse", response);
            }
            this.networkResponse = response;
            return this;
        }

        public Builder priorResponse(@Nullable Response response) {
            if (response != null) {
                checkPriorResponse(response);
            }
            this.priorResponse = response;
            return this;
        }

        public Builder protocol(Protocol protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder receivedResponseAtMillis(long j) {
            this.receivedResponseAtMillis = j;
            return this;
        }

        public Builder removeHeader(String str) {
            this.headers.removeAll(str);
            return this;
        }

        public Builder request(Request request) {
            this.request = request;
            return this;
        }

        public Builder sendTime(long j) {
            this.sendTime = j;
            return this;
        }

        public Builder sentRequestAtMillis(long j) {
            this.sentRequestAtMillis = j;
            return this;
        }

        public Builder sslTime(long j) {
            this.sslTime = j;
            return this;
        }

        public Builder statRecord(@Nullable NetworkStatRecord networkStatRecord) {
            this.statRecord = networkStatRecord;
            return this;
        }

        public Builder tcpTime(long j) {
            this.tcpTime = j;
            return this;
        }

        private void checkSupportResponse(String str, Response response) {
            if (response.body == null) {
                if (response.networkResponse == null) {
                    if (response.cacheResponse == null) {
                        if (response.priorResponse == null) {
                            return;
                        }
                        throw new IllegalArgumentException(str + ".priorResponse != null");
                    }
                    throw new IllegalArgumentException(str + ".cacheResponse != null");
                }
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            throw new IllegalArgumentException(str + ".body != null");
        }

        public Builder addHeader(String str, String str2) {
            this.headers.add(str, str2);
            return this;
        }

        public Builder header(String str, String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public Response build() {
            if (this.request != null) {
                if (this.code >= 0) {
                    if (this.message != null) {
                        return new Response(this);
                    }
                    throw new IllegalStateException("message == null");
                }
                throw new IllegalStateException("code < 0: " + this.code);
            }
            throw new IllegalStateException("request == null");
        }

        public String toString() {
            return "Builder{request=" + this.request + ", protocol=" + this.protocol + ", code=" + this.code + ", message='" + this.message + "', headers=" + this.headers + ", body=" + this.body + ", networkResponse=" + this.networkResponse + ", cacheResponse=" + this.cacheResponse + ", priorResponse=" + this.priorResponse + ", sentRequestAtMillis=" + this.sentRequestAtMillis + ", receivedResponseAtMillis=" + this.receivedResponseAtMillis + ", netEngine=" + this.netEngine + ", isConnReused=" + this.isConnReused + ", dnsTime=" + this.dnsTime + ", sslTime=" + this.sslTime + ", tcpTime=" + this.tcpTime + ", sendTime=" + this.sendTime + ", cached=" + this.cached + '}';
        }
    }

    public Response(Builder builder) {
        this.request = builder.request;
        this.protocol = builder.protocol;
        this.code = builder.code;
        this.message = builder.message;
        this.headers = builder.headers.build();
        this.body = builder.body;
        this.networkResponse = builder.networkResponse;
        this.cacheResponse = builder.cacheResponse;
        this.priorResponse = builder.priorResponse;
        this.sentRequestAtMillis = builder.sentRequestAtMillis;
        this.receivedResponseAtMillis = builder.receivedResponseAtMillis;
        this.netEngine = builder.netEngine;
        this.isConnReused = builder.isConnReused;
        this.dnsTime = builder.dnsTime;
        this.sslTime = builder.sslTime;
        this.tcpTime = builder.tcpTime;
        this.sendTime = builder.sendTime;
        this.cached = builder.cached;
        this.statRecord = builder.statRecord;
    }

    @Nullable
    public ResponseBody body() {
        return this.body;
    }

    @Nullable
    public Response cacheResponse() {
        return this.cacheResponse;
    }

    public boolean cached() {
        return this.cached;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ResponseBody responseBody = this.body;
        if (responseBody != null) {
            responseBody.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public int code() {
        return this.code;
    }

    public long dnsTime() {
        return this.dnsTime;
    }

    @Nullable
    public NetworkStatRecord getStatRecord() {
        return this.statRecord;
    }

    public Headers headers() {
        return this.headers;
    }

    public boolean isConnReused() {
        return this.isConnReused;
    }

    public boolean isRedirect() {
        int i = this.code;
        if (i == 307 || i == 308) {
            return true;
        }
        switch (i) {
            case 300:
            case 301:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    public boolean isSuccessful() {
        int i = this.code;
        if (i >= 200 && i < 300) {
            return true;
        }
        return false;
    }

    public String message() {
        return this.message;
    }

    public int netEngine() {
        return this.netEngine;
    }

    @Nullable
    public Response networkResponse() {
        return this.networkResponse;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    @Nullable
    public Response priorResponse() {
        return this.priorResponse;
    }

    public Protocol protocol() {
        return this.protocol;
    }

    public long receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    public Request request() {
        return this.request;
    }

    public long sendTime() {
        return this.sendTime;
    }

    public long sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public long sslTime() {
        return this.sslTime;
    }

    public long tcpTime() {
        return this.tcpTime;
    }

    @Nullable
    public String header(String str) {
        return header(str, null);
    }

    public List<String> headers(String str) {
        return this.headers.values(str);
    }

    @Nullable
    public String header(String str, @Nullable String str2) {
        String str3 = this.headers.get(str);
        if (str3 != null) {
            return str3;
        }
        return str2;
    }

    public ResponseBody peekBody(long j) throws IOException {
        int i = (int) j;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(this.body.inputStream(), i);
        byte[] bArr = new byte[i];
        bufferedInputStream.mark(0);
        int read = bufferedInputStream.read(bArr);
        if (read < j) {
            byte[] bArr2 = new byte[read];
            System.arraycopy(bArr, 0, bArr2, 0, read);
            bArr = bArr2;
        }
        bufferedInputStream.reset();
        ResponseBody create = ResponseBody.create(this.body.contentType(), this.body.contentLength(), bufferedInputStream);
        this.body = create;
        return ResponseBody.create(create.contentType(), bArr);
    }

    public String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + '}';
    }
}
