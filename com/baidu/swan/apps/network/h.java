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
    private final ResponseBody cED;
    private final e cEE;
    private BufferedSource cEF;

    public h(ResponseBody responseBody, e eVar) {
        this.cED = responseBody;
        this.cEE = eVar;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.cED.contentType();
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.cED.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.cEF == null) {
            this.cEF = Okio.buffer(source(this.cED.source()));
        }
        return this.cEF;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) { // from class: com.baidu.swan.apps.network.h.1
            long totalBytesRead = 0;

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                long read = super.read(buffer, j);
                this.totalBytesRead = (read != -1 ? read : 0L) + this.totalBytesRead;
                h.this.cEE.b(this.totalBytesRead, h.this.cED.contentLength(), read == -1);
                return read;
            }
        };
    }
}
