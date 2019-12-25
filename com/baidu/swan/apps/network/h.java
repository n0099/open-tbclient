package com.baidu.swan.apps.network;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
/* loaded from: classes9.dex */
public class h extends ResponseBody {
    private final ResponseBody bBq;
    private final e bBr;
    private BufferedSource bBs;

    public h(ResponseBody responseBody, e eVar) {
        this.bBq = responseBody;
        this.bBr = eVar;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.bBq.contentType();
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.bBq.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.bBs == null) {
            this.bBs = Okio.buffer(source(this.bBq.source()));
        }
        return this.bBs;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) { // from class: com.baidu.swan.apps.network.h.1
            long totalBytesRead = 0;

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                long read = super.read(buffer, j);
                this.totalBytesRead = (read != -1 ? read : 0L) + this.totalBytesRead;
                h.this.bBr.a(this.totalBytesRead, h.this.bBq.contentLength(), read == -1);
                return read;
            }
        };
    }
}
