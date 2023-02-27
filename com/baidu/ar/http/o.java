package com.baidu.ar.http;

import android.text.TextUtils;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
/* loaded from: classes.dex */
public class o {
    public Charset qI = StandardCharsets.UTF_8;
    public String rq;
    public StringBuilder rr;

    public void a(Charset charset) {
        this.qI = charset;
    }

    public void au(String str) {
        this.rq = str;
    }

    public URL eO() {
        String str = this.rq;
        if (str == null) {
            str = "";
        }
        StringBuilder sb = this.rr;
        if (sb != null && sb.length() > 0) {
            str = str + (str.contains("?") ? "&" : "?") + this.rr.toString();
        }
        return new URL(str);
    }

    public void i(String str, String str2) {
        if (str2 == null || TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sb = this.rr;
        if (sb == null) {
            this.rr = new StringBuilder();
        } else if (sb.length() > 0) {
            this.rr.append("&");
        }
        this.rr.append(j.a(str, this.qI));
        this.rr.append("=");
        this.rr.append(j.a(str2, this.qI));
    }
}
