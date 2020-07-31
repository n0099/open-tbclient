package com.baidu.ar.http;

import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
/* loaded from: classes11.dex */
class b implements k {
    private Charset pN;
    private StringBuilder pO = new StringBuilder();

    @Override // com.baidu.ar.http.k
    public void a(Charset charset) {
        this.pN = charset;
    }

    public void d(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        if (this.pO.length() > 0) {
            this.pO.append(ETAG.ITEM_SEPARATOR);
        }
        this.pO.append(j.a(str, this.pN)).append(ETAG.EQUAL).append(j.a(str2, this.pN));
    }

    @Override // com.baidu.ar.http.k
    public InputStream[] dz() {
        return this.pO.length() > 0 ? new InputStream[]{new ByteArrayInputStream(this.pO.toString().getBytes(this.pN))} : new InputStream[0];
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
