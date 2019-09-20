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
    private final ResponseBody aFi;
    private final e aFj;
    private BufferedSource aFk;

    public h(ResponseBody responseBody, e eVar) {
        this.aFi = responseBody;
        this.aFj = eVar;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.aFi.contentType();
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.aFi.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.aFk == null) {
            this.aFk = Okio.buffer(source(this.aFi.source()));
        }
        return this.aFk;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) { // from class: com.baidu.swan.apps.network.h.1
            long aFl = 0;

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                long read = super.read(buffer, j);
                this.aFl = (read != -1 ? read : 0L) + this.aFl;
                h.this.aFj.a(this.aFl, h.this.aFi.contentLength(), read == -1);
                return read;
            }
        };
    }
}
