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
    private final ResponseBody cff;
    private final e cfg;
    private BufferedSource cfh;

    public h(ResponseBody responseBody, e eVar) {
        this.cff = responseBody;
        this.cfg = eVar;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.cff.contentType();
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.cff.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.cfh == null) {
            this.cfh = Okio.buffer(source(this.cff.source()));
        }
        return this.cfh;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) { // from class: com.baidu.swan.apps.network.h.1
            long totalBytesRead = 0;

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                long read = super.read(buffer, j);
                this.totalBytesRead = (read != -1 ? read : 0L) + this.totalBytesRead;
                h.this.cfg.a(this.totalBytesRead, h.this.cff.contentLength(), read == -1);
                return read;
            }
        };
    }
}
