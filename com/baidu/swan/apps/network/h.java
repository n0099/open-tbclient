package com.baidu.swan.apps.network;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
/* loaded from: classes11.dex */
public class h extends ResponseBody {
    private final ResponseBody bGj;
    private final e bGk;
    private BufferedSource bGl;

    public h(ResponseBody responseBody, e eVar) {
        this.bGj = responseBody;
        this.bGk = eVar;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.bGj.contentType();
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.bGj.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.bGl == null) {
            this.bGl = Okio.buffer(source(this.bGj.source()));
        }
        return this.bGl;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) { // from class: com.baidu.swan.apps.network.h.1
            long totalBytesRead = 0;

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                long read = super.read(buffer, j);
                this.totalBytesRead = (read != -1 ? read : 0L) + this.totalBytesRead;
                h.this.bGk.a(this.totalBytesRead, h.this.bGj.contentLength(), read == -1);
                return read;
            }
        };
    }
}
