package com.baidu.swan.apps.network;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
/* loaded from: classes10.dex */
public class h extends ResponseBody {
    private final ResponseBody dbi;
    private final e dbj;
    private BufferedSource dbk;

    public h(ResponseBody responseBody, e eVar) {
        this.dbi = responseBody;
        this.dbj = eVar;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.dbi.contentType();
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.dbi.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.dbk == null) {
            this.dbk = Okio.buffer(source(this.dbi.source()));
        }
        return this.dbk;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) { // from class: com.baidu.swan.apps.network.h.1
            long totalBytesRead = 0;

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                long read = super.read(buffer, j);
                this.totalBytesRead = (read != -1 ? read : 0L) + this.totalBytesRead;
                h.this.dbj.b(this.totalBytesRead, h.this.dbi.contentLength(), read == -1);
                return read;
            }
        };
    }
}
