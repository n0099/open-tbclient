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
    private final ResponseBody bCc;
    private final e bCd;
    private BufferedSource bCe;

    public h(ResponseBody responseBody, e eVar) {
        this.bCc = responseBody;
        this.bCd = eVar;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.bCc.contentType();
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.bCc.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.bCe == null) {
            this.bCe = Okio.buffer(source(this.bCc.source()));
        }
        return this.bCe;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) { // from class: com.baidu.swan.apps.network.h.1
            long totalBytesRead = 0;

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                long read = super.read(buffer, j);
                this.totalBytesRead = (read != -1 ? read : 0L) + this.totalBytesRead;
                h.this.bCd.a(this.totalBytesRead, h.this.bCc.contentLength(), read == -1);
                return read;
            }
        };
    }
}
