package com.baidu.ar.http;

import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
/* loaded from: classes3.dex */
class o {
    private Charset pN = StandardCharsets.UTF_8;
    private String qv;
    private StringBuilder qw;

    public void a(Charset charset) {
        this.pN = charset;
    }

    public void an(String str) {
        this.qv = str;
    }

    public URL dF() {
        String str = this.qv == null ? "" : this.qv;
        if (this.qw != null && this.qw.length() > 0) {
            str = str + (str.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + this.qw.toString();
        }
        return new URL(str);
    }

    public void g(String str, String str2) {
        if (str2 == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (this.qw == null) {
            this.qw = new StringBuilder();
        } else if (this.qw.length() > 0) {
            this.qw.append(ETAG.ITEM_SEPARATOR);
        }
        this.qw.append(j.a(str, this.pN));
        this.qw.append(ETAG.EQUAL);
        this.qw.append(j.a(str2, this.pN));
    }
}
