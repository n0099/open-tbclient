package com.baidu.ar.http;

import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
/* loaded from: classes3.dex */
class b implements k {
    private Charset po;
    private StringBuilder pp = new StringBuilder();

    @Override // com.baidu.ar.http.k
    public void a(Charset charset) {
        this.po = charset;
    }

    public void d(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        if (this.pp.length() > 0) {
            this.pp.append(ETAG.ITEM_SEPARATOR);
        }
        this.pp.append(j.a(str, this.po)).append(ETAG.EQUAL).append(j.a(str2, this.po));
    }

    @Override // com.baidu.ar.http.k
    public InputStream[] dj() {
        return this.pp.length() > 0 ? new InputStream[]{new ByteArrayInputStream(this.pp.toString().getBytes(this.po))} : new InputStream[0];
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
