package com.baidu.searchbox.http.okurlconnection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Timeout;
/* loaded from: classes2.dex */
public abstract class OutputStreamRequestBody extends RequestBody {
    public boolean closed;
    public long expectedContentLength;
    public volatile boolean needFlush = false;
    public OutputStream outputStream;
    public Timeout timeout;

    @Override // okhttp3.RequestBody
    public final MediaType contentType() {
        return null;
    }

    public Request prepareToSendRequest(Request request) throws IOException {
        return request;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        return this.expectedContentLength;
    }

    public final boolean isClosed() {
        return this.closed;
    }

    public final OutputStream outputStream() {
        return this.outputStream;
    }

    public final Timeout timeout() {
        return this.timeout;
    }

    public void initOutputStream(final BufferedSink bufferedSink, final long j) {
        this.timeout = bufferedSink.timeout();
        this.expectedContentLength = j;
        this.outputStream = new OutputStream() { // from class: com.baidu.searchbox.http.okurlconnection.OutputStreamRequestBody.1
            public long bytesReceived;

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                OutputStreamRequestBody.this.closed = true;
                long j2 = j;
                if (j2 != -1 && this.bytesReceived < j2) {
                    throw new ProtocolException("expected " + j + " bytes but received " + this.bytesReceived);
                }
                bufferedSink.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                if (OutputStreamRequestBody.this.closed) {
                    return;
                }
                bufferedSink.flush();
                OutputStreamRequestBody.this.needFlush = true;
            }

            @Override // java.io.OutputStream
            public void write(int i) throws IOException {
                write(new byte[]{(byte) i}, 0, 1);
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) throws IOException {
                if (!OutputStreamRequestBody.this.closed) {
                    long j2 = j;
                    if (j2 != -1 && this.bytesReceived + i2 > j2) {
                        throw new ProtocolException("expected " + j + " bytes but received " + this.bytesReceived + i2);
                    }
                    this.bytesReceived += i2;
                    try {
                        bufferedSink.write(bArr, i, i2);
                        return;
                    } catch (InterruptedIOException e) {
                        throw new SocketTimeoutException(e.getMessage());
                    }
                }
                throw new IOException("closed");
            }
        };
    }
}
