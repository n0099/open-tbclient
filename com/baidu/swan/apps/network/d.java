package com.baidu.swan.apps.network;

import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
/* loaded from: classes2.dex */
public final class d extends RequestBody {
    private final FormBody aEH;
    private MediaType contentType;

    public static d a(FormBody formBody, MediaType mediaType) {
        d dVar = new d(formBody);
        dVar.a(mediaType);
        return dVar;
    }

    private d(FormBody formBody) {
        this.aEH = formBody;
    }

    public void a(MediaType mediaType) {
        this.contentType = mediaType;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.contentType == null ? this.aEH.contentType() : this.contentType;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return this.aEH.contentLength();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        this.aEH.writeTo(bufferedSink);
    }
}
