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
    private final ResponseBody aYf;
    private final e aYg;
    private BufferedSource aYh;

    public h(ResponseBody responseBody, e eVar) {
        this.aYf = responseBody;
        this.aYg = eVar;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.aYf.contentType();
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.aYf.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.aYh == null) {
            this.aYh = Okio.buffer(source(this.aYf.source()));
        }
        return this.aYh;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) { // from class: com.baidu.swan.apps.network.h.1
            long aYi = 0;

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                long read = super.read(buffer, j);
                this.aYi = (read != -1 ? read : 0L) + this.aYi;
                h.this.aYg.a(this.aYi, h.this.aYf.contentLength(), read == -1);
                return read;
            }
        };
    }
}
