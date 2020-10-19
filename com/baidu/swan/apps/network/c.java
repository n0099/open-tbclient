package com.baidu.swan.apps.network;

import java.io.File;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;
/* loaded from: classes10.dex */
public class c extends RequestBody {
    private final File cSF;
    private final com.baidu.swan.apps.network.b.a cSG;
    private final String mContentType;

    public c(File file, String str, com.baidu.swan.apps.network.b.a aVar) {
        this.cSF = file;
        this.mContentType = str;
        this.cSG = aVar;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return this.cSF.length();
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return MediaType.parse(this.mContentType);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Source source = null;
        try {
            source = Okio.source(this.cSF);
            long j = 0;
            while (true) {
                long read = source.read(bufferedSink.buffer(), 2048L);
                if (read != -1) {
                    j += read;
                    bufferedSink.flush();
                    this.cSG.bx(j);
                } else {
                    return;
                }
            }
        } finally {
            com.baidu.swan.c.d.closeSafely(source);
        }
    }
}
