package com.baidu.swan.apps.network;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
/* loaded from: classes2.dex */
public class h extends ResponseBody {
    private final ResponseBody aCq;
    private final e aCr;
    private BufferedSource aCs;

    public h(ResponseBody responseBody, e eVar) {
        this.aCq = responseBody;
        this.aCr = eVar;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.aCq.contentType();
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.aCq.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.aCs == null) {
            this.aCs = Okio.buffer(source(this.aCq.source()));
        }
        return this.aCs;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) { // from class: com.baidu.swan.apps.network.h.1
            long aCt = 0;

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                long read = super.read(buffer, j);
                this.aCt = (read != -1 ? read : 0L) + this.aCt;
                h.this.aCr.a(this.aCt, h.this.aCq.contentLength(), read == -1);
                return read;
            }
        };
    }
}
