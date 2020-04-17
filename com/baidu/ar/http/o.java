package com.baidu.ar.http;

import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
/* loaded from: classes3.dex */
class o {
    private String pW;
    private StringBuilder pX;
    private Charset po = StandardCharsets.UTF_8;

    public void a(Charset charset) {
        this.po = charset;
    }

    public void am(String str) {
        this.pW = str;
    }

    public URL dp() {
        String str = this.pW == null ? "" : this.pW;
        if (this.pX != null && this.pX.length() > 0) {
            str = str + (str.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + this.pX.toString();
        }
        return new URL(str);
    }

    public void g(String str, String str2) {
        if (str2 == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (this.pX == null) {
            this.pX = new StringBuilder();
        } else if (this.pX.length() > 0) {
            this.pX.append(ETAG.ITEM_SEPARATOR);
        }
        this.pX.append(j.a(str, this.po));
        this.pX.append(ETAG.EQUAL);
        this.pX.append(j.a(str2, this.po));
    }
}
