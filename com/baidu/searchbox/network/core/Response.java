package com.baidu.searchbox.network.core;

import android.support.annotation.Nullable;
import com.baidu.searchbox.network.core.Headers;
import com.baidu.searchbox.network.core.http.HttpHeaders;
import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import okio.Buffer;
import okio.BufferedSource;
import org.apache.http.auth.AUTH;
/* loaded from: classes12.dex */
public final class Response implements Closeable {
    @Nullable
    final ResponseBody body;
    @Nullable
    final Response cacheResponse;
    final boolean cached;
    final int code;
    final long dnsTime;
    final Headers headers;
    final boolean isConnReused;
    final String message;
    final int netEngine;
    @Nullable
    final Response networkResponse;
    @Nullable
    final Response priorResponse;
    final Protocol protocol;
    final long receivedResponseAtMillis;
    final Request request;
    final long sendTime;
    final long sentRequestAtMillis;
    final long sslTime;
    final long tcpTime;

    Response(Builder builder) {
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
    }

    public Request request() {
        return this.request;
    }

    public Protocol protocol() {
        return this.protocol;
    }

    public int code() {
        return this.code;
    }

    public boolean isSuccessful() {
        return this.code >= 200 && this.code < 300;
    }

    public String message() {
        return this.message;
    }

    public List<String> headers(String str) {
        return this.headers.values(str);
    }

    public Headers headers() {
        return this.headers;
    }

    @Nullable
    public String header(String str) {
        return header(str, null);
    }

    @Nullable
    public String header(String str, @Nullable String str2) {
        String str3 = this.headers.get(str);
        return str3 != null ? str3 : str2;
    }

    public ResponseBody peekBody(long j) throws IOException {
        Buffer buffer;
        BufferedSource source = this.body.source();
        source.request(j);
        Buffer clone = source.buffer().clone();
        if (clone.size() > j) {
            buffer = new Buffer();
            buffer.write(clone, j);
            clone.clear();
        } else {
            buffer = clone;
        }
        return ResponseBody.create(this.body.contentType(), buffer.size(), buffer);
    }

    @Nullable
    public ResponseBody body() {
        return this.body;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public boolean isRedirect() {
        switch (this.code) {
            case 300:
            case 301:
            case 302:
            case 303:
            case 307:
            case 308:
                return true;
            case 304:
            case 305:
            case 306:
            default:
                return false;
        }
    }

    @Nullable
    public Response networkResponse() {
        return this.networkResponse;
    }

    @Nullable
    public Response cacheResponse() {
        return this.cacheResponse;
    }

    @Nullable
    public Response priorResponse() {
        return this.priorResponse;
    }

    public List<Challenge> challenges() {
        String str;
        if (this.code == 401) {
            str = AUTH.WWW_AUTH;
        } else if (this.code == 407) {
            str = AUTH.PROXY_AUTH;
        } else {
            return Collections.emptyList();
        }
        return HttpHeaders.parseChallenges(headers(), str);
    }

    public long sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public long receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    public int netEngine() {
        return this.netEngine;
    }

    public boolean isConnReused() {
        return this.isConnReused;
    }

    public long dnsTime() {
        return this.dnsTime;
    }

    public long sslTime() {
        return this.sslTime;
    }

    public long sendTime() {
        return this.sendTime;
    }

    public boolean cached() {
        return this.cached;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.body == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        this.body.close();
    }

    public String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + '}';
    }

    /* loaded from: classes12.dex */
    public static class Builder {
        @Nullable
        ResponseBody body;
        @Nullable
        Response cacheResponse;
        boolean cached;
        int code;
        long dnsTime;
        Headers.Builder headers;
        boolean isConnReused;
        String message;
        int netEngine;
        @Nullable
        Response networkResponse;
        @Nullable
        Response priorResponse;
        @Nullable
        Protocol protocol;
        long receivedResponseAtMillis;
        @Nullable
        Request request;
        long sendTime;
        long sentRequestAtMillis;
        long sslTime;
        long tcpTime;

        public Builder() {
            this.code = -1;
            this.isConnReused = false;
            this.headers = new Headers.Builder();
        }

        Builder(Response response) {
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
        }

        public Builder request(Request request) {
            this.request = request;
            return this;
        }

        public Builder protocol(Protocol protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder code(int i) {
            this.code = i;
            return this;
        }

        public Builder message(String str) {
            this.message = str;
            return this;
        }

        public Builder header(String str, String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public Builder addHeader(String str, String str2) {
            this.headers.add(str, str2);
            return this;
        }

        public Builder removeHeader(String str) {
            this.headers.removeAll(str);
            return this;
        }

        public Builder headers(Headers headers) {
            this.headers = headers.newBuilder();
            return this;
        }

        public Builder body(@Nullable ResponseBody responseBody) {
            this.body = responseBody;
            return this;
        }

        public Builder networkResponse(@Nullable Response response) {
            if (response != null) {
                checkSupportResponse("networkResponse", response);
            }
            this.networkResponse = response;
            return this;
        }

        public Builder cacheResponse(@Nullable Response response) {
            if (response != null) {
                checkSupportResponse("cacheResponse", response);
            }
            this.cacheResponse = response;
            return this;
        }

        private void checkSupportResponse(String str, Response response) {
            if (response.body != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (response.networkResponse != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (response.cacheResponse != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (response.priorResponse != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public Builder priorResponse(@Nullable Response response) {
            if (response != null) {
                checkPriorResponse(response);
            }
            this.priorResponse = response;
            return this;
        }

        private void checkPriorResponse(Response response) {
            if (response.body != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public Builder sentRequestAtMillis(long j) {
            this.sentRequestAtMillis = j;
            return this;
        }

        public Builder receivedResponseAtMillis(long j) {
            this.receivedResponseAtMillis = j;
            return this;
        }

        public Builder netEngine(int i) {
            this.netEngine = i;
            return this;
        }

        public Builder isConnReused(boolean z) {
            this.isConnReused = z;
            return this;
        }

        public Builder dnsTime(long j) {
            this.dnsTime = j;
            return this;
        }

        public Builder sslTime(long j) {
            this.sslTime = j;
            return this;
        }

        public Builder tcpTime(long j) {
            this.tcpTime = j;
            return this;
        }

        public Builder sendTime(long j) {
            this.sendTime = j;
            return this;
        }

        public Builder cached(boolean z) {
            this.cached = z;
            return this;
        }

        public Response build() {
            if (this.request == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.code < 0) {
                throw new IllegalStateException("code < 0: " + this.code);
            }
            if (this.message == null) {
                throw new IllegalStateException("message == null");
            }
            return new Response(this);
        }

        public String toString() {
            return "Builder{request=" + this.request + ", protocol=" + this.protocol + ", code=" + this.code + ", message='" + this.message + "', headers=" + this.headers + ", body=" + this.body + ", networkResponse=" + this.networkResponse + ", cacheResponse=" + this.cacheResponse + ", priorResponse=" + this.priorResponse + ", sentRequestAtMillis=" + this.sentRequestAtMillis + ", receivedResponseAtMillis=" + this.receivedResponseAtMillis + ", netEngine=" + this.netEngine + ", isConnReused=" + this.isConnReused + ", dnsTime=" + this.dnsTime + ", sslTime=" + this.sslTime + ", tcpTime=" + this.tcpTime + ", sendTime=" + this.sendTime + ", cached=" + this.cached + '}';
        }
    }
}
