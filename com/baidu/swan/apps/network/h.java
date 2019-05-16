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
    private final ResponseBody aEc;
    private final e aEd;
    private BufferedSource aEe;

    public h(ResponseBody responseBody, e eVar) {
        this.aEc = responseBody;
        this.aEd = eVar;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.aEc.contentType();
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.aEc.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.aEe == null) {
            this.aEe = Okio.buffer(source(this.aEc.source()));
        }
        return this.aEe;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) { // from class: com.baidu.swan.apps.network.h.1
            long aEf = 0;

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                long read = super.read(buffer, j);
                this.aEf = (read != -1 ? read : 0L) + this.aEf;
                h.this.aEd.a(this.aEf, h.this.aEc.contentLength(), read == -1);
                return read;
            }
        };
    }
}
