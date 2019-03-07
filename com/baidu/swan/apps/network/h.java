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
    private final ResponseBody aCl;
    private final e aCm;
    private BufferedSource aCn;

    public h(ResponseBody responseBody, e eVar) {
        this.aCl = responseBody;
        this.aCm = eVar;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.aCl.contentType();
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.aCl.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.aCn == null) {
            this.aCn = Okio.buffer(source(this.aCl.source()));
        }
        return this.aCn;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) { // from class: com.baidu.swan.apps.network.h.1
            long aCo = 0;

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                long read = super.read(buffer, j);
                this.aCo = (read != -1 ? read : 0L) + this.aCo;
                h.this.aCm.a(this.aCo, h.this.aCl.contentLength(), read == -1);
                return read;
            }
        };
    }
}
