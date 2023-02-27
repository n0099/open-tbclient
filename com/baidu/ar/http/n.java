package com.baidu.ar.http;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public class n implements k {
    public byte[] lc;

    @Override // com.baidu.ar.http.k
    public void a(Charset charset) {
    }

    @Override // com.baidu.ar.http.k
    public InputStream[] eI() {
        byte[] bArr = this.lc;
        return (bArr == null || bArr.length <= 0) ? new InputStream[0] : new InputStream[]{new ByteArrayInputStream(this.lc)};
    }

    @Override // com.baidu.ar.http.k
    public String getContentType() {
        return null;
    }

    @Override // com.baidu.ar.http.k
    public int getSize() {
        byte[] bArr = this.lc;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public void setData(byte[] bArr) {
        this.lc = bArr;
    }
}
