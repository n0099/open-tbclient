package com.baidu.ar.http;

import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
/* loaded from: classes10.dex */
class b implements k {
    private Charset qs;
    private StringBuilder qt = new StringBuilder();

    @Override // com.baidu.ar.http.k
    public void a(Charset charset) {
        this.qs = charset;
    }

    @Override // com.baidu.ar.http.k
    public InputStream[] eJ() {
        return this.qt.length() > 0 ? new InputStream[]{new ByteArrayInputStream(this.qt.toString().getBytes(this.qs))} : new InputStream[0];
    }

    public void f(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        if (this.qt.length() > 0) {
            this.qt.append(ETAG.ITEM_SEPARATOR);
        }
        this.qt.append(j.a(str, this.qs)).append(ETAG.EQUAL).append(j.a(str2, this.qs));
    }

    @Override // com.baidu.ar.http.k
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.ar.http.k
    public int getSize() {
        return 0;
    }
}
