package com.baidu.swan.apps.network;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
/* loaded from: classes3.dex */
public class h extends ResponseBody {
    private final ResponseBody cGH;
    private final e cGI;
    private BufferedSource cGJ;

    public h(ResponseBody responseBody, e eVar) {
        this.cGH = responseBody;
        this.cGI = eVar;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.cGH.contentType();
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.cGH.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.cGJ == null) {
            this.cGJ = Okio.buffer(source(this.cGH.source()));
        }
        return this.cGJ;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) { // from class: com.baidu.swan.apps.network.h.1
            long totalBytesRead = 0;

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                long read = super.read(buffer, j);
                this.totalBytesRead = (read != -1 ? read : 0L) + this.totalBytesRead;
                h.this.cGI.b(this.totalBytesRead, h.this.cGH.contentLength(), read == -1);
                return read;
            }
        };
    }
}
