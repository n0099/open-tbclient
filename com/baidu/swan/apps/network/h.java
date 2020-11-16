package com.baidu.swan.apps.network;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
/* loaded from: classes7.dex */
public class h extends ResponseBody {
    private final ResponseBody dfw;
    private final e dfx;
    private BufferedSource dfy;

    public h(ResponseBody responseBody, e eVar) {
        this.dfw = responseBody;
        this.dfx = eVar;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.dfw.contentType();
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.dfw.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.dfy == null) {
            this.dfy = Okio.buffer(source(this.dfw.source()));
        }
        return this.dfy;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) { // from class: com.baidu.swan.apps.network.h.1
            long totalBytesRead = 0;

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                long read = super.read(buffer, j);
                this.totalBytesRead = (read != -1 ? read : 0L) + this.totalBytesRead;
                h.this.dfx.b(this.totalBytesRead, h.this.dfw.contentLength(), read == -1);
                return read;
            }
        };
    }
}
