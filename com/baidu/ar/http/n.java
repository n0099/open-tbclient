package com.baidu.ar.http;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
/* loaded from: classes3.dex */
class n implements k {
    private byte[] jM;

    @Override // com.baidu.ar.http.k
    public void a(Charset charset) {
    }

    @Override // com.baidu.ar.http.k
    public InputStream[] dj() {
        return (this.jM == null || this.jM.length <= 0) ? new InputStream[0] : new InputStream[]{new ByteArrayInputStream(this.jM)};
    }

    @Override // com.baidu.ar.http.k
    public String getContentType() {
        return null;
    }

    @Override // com.baidu.ar.http.k
    public int getSize() {
        if (this.jM == null) {
            return 0;
        }
        return this.jM.length;
    }

    public void setData(byte[] bArr) {
        this.jM = bArr;
    }
}
