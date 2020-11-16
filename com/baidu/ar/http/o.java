package com.baidu.ar.http;

import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
/* loaded from: classes12.dex */
class o {
    private Charset qs = StandardCharsets.UTF_8;
    private String ra;
    private StringBuilder rb;

    public void a(Charset charset) {
        this.qs = charset;
    }

    public void ar(String str) {
        this.ra = str;
    }

    public URL eP() {
        String str = this.ra == null ? "" : this.ra;
        if (this.rb != null && this.rb.length() > 0) {
            str = str + (str.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + this.rb.toString();
        }
        return new URL(str);
    }

    public void i(String str, String str2) {
        if (str2 == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (this.rb == null) {
            this.rb = new StringBuilder();
        } else if (this.rb.length() > 0) {
            this.rb.append(ETAG.ITEM_SEPARATOR);
        }
        this.rb.append(j.a(str, this.qs));
        this.rb.append(ETAG.EQUAL);
        this.rb.append(j.a(str2, this.qs));
    }
}
