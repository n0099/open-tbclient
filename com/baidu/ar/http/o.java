package com.baidu.ar.http;

import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
/* loaded from: classes3.dex */
class o {
    private Charset qI = StandardCharsets.UTF_8;
    private String rq;
    private StringBuilder rr;

    public void a(Charset charset) {
        this.qI = charset;
    }

    public void au(String str) {
        this.rq = str;
    }

    public URL eO() {
        String str = this.rq == null ? "" : this.rq;
        if (this.rr != null && this.rr.length() > 0) {
            str = str + (str.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + this.rr.toString();
        }
        return new URL(str);
    }

    public void i(String str, String str2) {
        if (str2 == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (this.rr == null) {
            this.rr = new StringBuilder();
        } else if (this.rr.length() > 0) {
            this.rr.append(ETAG.ITEM_SEPARATOR);
        }
        this.rr.append(j.a(str, this.qI));
        this.rr.append("=");
        this.rr.append(j.a(str2, this.qI));
    }
}
