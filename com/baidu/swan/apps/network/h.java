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
    private final ResponseBody aCm;
    private final e aCn;
    private BufferedSource aCo;

    public h(ResponseBody responseBody, e eVar) {
        this.aCm = responseBody;
        this.aCn = eVar;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.aCm.contentType();
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.aCm.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.aCo == null) {
            this.aCo = Okio.buffer(source(this.aCm.source()));
        }
        return this.aCo;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) { // from class: com.baidu.swan.apps.network.h.1
            long aCp = 0;

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                long read = super.read(buffer, j);
                this.aCp = (read != -1 ? read : 0L) + this.aCp;
                h.this.aCn.a(this.aCp, h.this.aCm.contentLength(), read == -1);
                return read;
            }
        };
    }
}
