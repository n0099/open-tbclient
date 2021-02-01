package com.baidu.swan.apps.network;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
/* loaded from: classes9.dex */
public class h extends ResponseBody {
    private final ResponseBody doR;
    private final e doS;
    private BufferedSource doT;

    public h(ResponseBody responseBody, e eVar) {
        this.doR = responseBody;
        this.doS = eVar;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.doR.contentType();
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.doR.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.doT == null) {
            this.doT = Okio.buffer(source(this.doR.source()));
        }
        return this.doT;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) { // from class: com.baidu.swan.apps.network.h.1
            long totalBytesRead = 0;

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                long read = super.read(buffer, j);
                this.totalBytesRead = (read != -1 ? read : 0L) + this.totalBytesRead;
                h.this.doS.c(this.totalBytesRead, h.this.doR.contentLength(), read == -1);
                return read;
            }
        };
    }
}
