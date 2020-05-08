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
    private final ResponseBody cfl;
    private final e cfm;
    private BufferedSource cfn;

    public h(ResponseBody responseBody, e eVar) {
        this.cfl = responseBody;
        this.cfm = eVar;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.cfl.contentType();
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.cfl.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.cfn == null) {
            this.cfn = Okio.buffer(source(this.cfl.source()));
        }
        return this.cfn;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) { // from class: com.baidu.swan.apps.network.h.1
            long totalBytesRead = 0;

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                long read = super.read(buffer, j);
                this.totalBytesRead = (read != -1 ? read : 0L) + this.totalBytesRead;
                h.this.cfm.a(this.totalBytesRead, h.this.cfl.contentLength(), read == -1);
                return read;
            }
        };
    }
}
