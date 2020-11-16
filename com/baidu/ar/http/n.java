package com.baidu.ar.http;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
/* loaded from: classes12.dex */
class n implements k {
    private byte[] kN;

    @Override // com.baidu.ar.http.k
    public void a(Charset charset) {
    }

    @Override // com.baidu.ar.http.k
    public InputStream[] eJ() {
        return (this.kN == null || this.kN.length <= 0) ? new InputStream[0] : new InputStream[]{new ByteArrayInputStream(this.kN)};
    }

    @Override // com.baidu.ar.http.k
    public String getContentType() {
        return null;
    }

    @Override // com.baidu.ar.http.k
    public int getSize() {
        if (this.kN == null) {
            return 0;
        }
        return this.kN.length;
    }

    public void setData(byte[] bArr) {
        this.kN = bArr;
    }
}
