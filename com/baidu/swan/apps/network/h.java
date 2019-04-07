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
    private final ResponseBody aCp;
    private final e aCq;
    private BufferedSource aCr;

    public h(ResponseBody responseBody, e eVar) {
        this.aCp = responseBody;
        this.aCq = eVar;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.aCp.contentType();
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.aCp.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.aCr == null) {
            this.aCr = Okio.buffer(source(this.aCp.source()));
        }
        return this.aCr;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) { // from class: com.baidu.swan.apps.network.h.1
            long aCs = 0;

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                long read = super.read(buffer, j);
                this.aCs = (read != -1 ? read : 0L) + this.aCs;
                h.this.aCq.a(this.aCs, h.this.aCp.contentLength(), read == -1);
                return read;
            }
        };
    }
}
