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
    private final ResponseBody cSK;
    private final e cSL;
    private BufferedSource cSM;

    public h(ResponseBody responseBody, e eVar) {
        this.cSK = responseBody;
        this.cSL = eVar;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.cSK.contentType();
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.cSK.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.cSM == null) {
            this.cSM = Okio.buffer(source(this.cSK.source()));
        }
        return this.cSM;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) { // from class: com.baidu.swan.apps.network.h.1
            long totalBytesRead = 0;

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                long read = super.read(buffer, j);
                this.totalBytesRead = (read != -1 ? read : 0L) + this.totalBytesRead;
                h.this.cSL.b(this.totalBytesRead, h.this.cSK.contentLength(), read == -1);
                return read;
            }
        };
    }
}
