package com.baidu.searchbox.ng.ai.apps.network;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
/* loaded from: classes2.dex */
public class ProgressResponseBody extends ResponseBody {
    private BufferedSource mBufferedSource;
    private final IProgressListener mProgressListener;
    private final ResponseBody mResponseBody;

    public ProgressResponseBody(ResponseBody responseBody, IProgressListener iProgressListener) {
        this.mResponseBody = responseBody;
        this.mProgressListener = iProgressListener;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.mResponseBody.contentType();
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.mResponseBody.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.mBufferedSource == null) {
            this.mBufferedSource = Okio.buffer(source(this.mResponseBody.source()));
        }
        return this.mBufferedSource;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) { // from class: com.baidu.searchbox.ng.ai.apps.network.ProgressResponseBody.1
            long totalBytesRead = 0;

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                long read = super.read(buffer, j);
                this.totalBytesRead = (read != -1 ? read : 0L) + this.totalBytesRead;
                ProgressResponseBody.this.mProgressListener.onProgress(this.totalBytesRead, ProgressResponseBody.this.mResponseBody.contentLength(), read == -1);
                return read;
            }
        };
    }
}
