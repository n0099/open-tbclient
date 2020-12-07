package com.baidu.swan.apps.network;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
/* loaded from: classes25.dex */
public class h extends ResponseBody {
    private final ResponseBody dmv;
    private final e dmw;
    private BufferedSource dmx;

    public h(ResponseBody responseBody, e eVar) {
        this.dmv = responseBody;
        this.dmw = eVar;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.dmv.contentType();
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.dmv.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.dmx == null) {
            this.dmx = Okio.buffer(source(this.dmv.source()));
        }
        return this.dmx;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) { // from class: com.baidu.swan.apps.network.h.1
            long totalBytesRead = 0;

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                long read = super.read(buffer, j);
                this.totalBytesRead = (read != -1 ? read : 0L) + this.totalBytesRead;
                h.this.dmw.b(this.totalBytesRead, h.this.dmv.contentLength(), read == -1);
                return read;
            }
        };
    }
}
