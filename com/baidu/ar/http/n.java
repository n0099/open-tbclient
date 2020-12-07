package com.baidu.ar.http;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
/* loaded from: classes10.dex */
class n implements k {
    private byte[] lc;

    @Override // com.baidu.ar.http.k
    public void a(Charset charset) {
    }

    @Override // com.baidu.ar.http.k
    public InputStream[] eI() {
        return (this.lc == null || this.lc.length <= 0) ? new InputStream[0] : new InputStream[]{new ByteArrayInputStream(this.lc)};
    }

    @Override // com.baidu.ar.http.k
    public String getContentType() {
        return null;
    }

    @Override // com.baidu.ar.http.k
    public int getSize() {
        if (this.lc == null) {
            return 0;
        }
        return this.lc.length;
    }

    public void setData(byte[] bArr) {
        this.lc = bArr;
    }
}
