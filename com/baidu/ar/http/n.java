package com.baidu.ar.http;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
/* loaded from: classes3.dex */
class n implements k {
    private byte[] ke;

    @Override // com.baidu.ar.http.k
    public void a(Charset charset) {
    }

    @Override // com.baidu.ar.http.k
    public InputStream[] dz() {
        return (this.ke == null || this.ke.length <= 0) ? new InputStream[0] : new InputStream[]{new ByteArrayInputStream(this.ke)};
    }

    @Override // com.baidu.ar.http.k
    public String getContentType() {
        return null;
    }

    @Override // com.baidu.ar.http.k
    public int getSize() {
        if (this.ke == null) {
            return 0;
        }
        return this.ke.length;
    }

    public void setData(byte[] bArr) {
        this.ke = bArr;
    }
}
