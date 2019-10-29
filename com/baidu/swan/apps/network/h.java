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
    private final ResponseBody aYx;
    private final e aYy;
    private BufferedSource aYz;

    public h(ResponseBody responseBody, e eVar) {
        this.aYx = responseBody;
        this.aYy = eVar;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.aYx.contentType();
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.aYx.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.aYz == null) {
            this.aYz = Okio.buffer(source(this.aYx.source()));
        }
        return this.aYz;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) { // from class: com.baidu.swan.apps.network.h.1
            long aYA = 0;

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                long read = super.read(buffer, j);
                this.aYA = (read != -1 ? read : 0L) + this.aYA;
                h.this.aYy.a(this.aYA, h.this.aYx.contentLength(), read == -1);
                return read;
            }
        };
    }
}
