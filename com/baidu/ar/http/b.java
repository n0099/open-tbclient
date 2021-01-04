package com.baidu.ar.http;

import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
class b implements k {
    private Charset qI;
    private StringBuilder qJ = new StringBuilder();

    @Override // com.baidu.ar.http.k
    public void a(Charset charset) {
        this.qI = charset;
    }

    @Override // com.baidu.ar.http.k
    public InputStream[] eI() {
        return this.qJ.length() > 0 ? new InputStream[]{new ByteArrayInputStream(this.qJ.toString().getBytes(this.qI))} : new InputStream[0];
    }

    public void f(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        if (this.qJ.length() > 0) {
            this.qJ.append(ETAG.ITEM_SEPARATOR);
        }
        this.qJ.append(j.a(str, this.qI)).append("=").append(j.a(str2, this.qI));
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
