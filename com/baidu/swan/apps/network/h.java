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
    private final ResponseBody aEK;
    private final e aEL;
    private BufferedSource aEM;

    public h(ResponseBody responseBody, e eVar) {
        this.aEK = responseBody;
        this.aEL = eVar;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.aEK.contentType();
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.aEK.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.aEM == null) {
            this.aEM = Okio.buffer(source(this.aEK.source()));
        }
        return this.aEM;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) { // from class: com.baidu.swan.apps.network.h.1
            long aEN = 0;

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                long read = super.read(buffer, j);
                this.aEN = (read != -1 ? read : 0L) + this.aEN;
                h.this.aEL.a(this.aEN, h.this.aEK.contentLength(), read == -1);
                return read;
            }
        };
    }
}
