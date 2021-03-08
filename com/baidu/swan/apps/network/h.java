package com.baidu.swan.apps.network;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
/* loaded from: classes8.dex */
public class h extends ResponseBody {
    private final ResponseBody dqt;
    private final e dqu;
    private BufferedSource dqv;

    public h(ResponseBody responseBody, e eVar) {
        this.dqt = responseBody;
        this.dqu = eVar;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.dqt.contentType();
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.dqt.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.dqv == null) {
            this.dqv = Okio.buffer(source(this.dqt.source()));
        }
        return this.dqv;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) { // from class: com.baidu.swan.apps.network.h.1
            long totalBytesRead = 0;

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                long read = super.read(buffer, j);
                this.totalBytesRead = (read != -1 ? read : 0L) + this.totalBytesRead;
                h.this.dqu.c(this.totalBytesRead, h.this.dqt.contentLength(), read == -1);
                return read;
            }
        };
    }
}
