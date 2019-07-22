package com.baidu.swan.apps.network;

import java.io.File;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;
/* loaded from: classes2.dex */
public class c extends RequestBody {
    private final File aEF;
    private final com.baidu.swan.apps.network.b.a aEG;
    private final String mContentType;

    public c(File file, String str, com.baidu.swan.apps.network.b.a aVar) {
        this.aEF = file;
        this.mContentType = str;
        this.aEG = aVar;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return this.aEF.length();
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return MediaType.parse(this.mContentType);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Source source = null;
        try {
            source = Okio.source(this.aEF);
            long j = 0;
            while (true) {
                long read = source.read(bufferedSink.buffer(), 2048L);
                if (read != -1) {
                    j += read;
                    bufferedSink.flush();
                    this.aEG.L(j);
                } else {
                    return;
                }
            }
        } finally {
            com.baidu.swan.c.a.c(source);
        }
    }
}
