package com.baidu.ar.http;

import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
/* loaded from: classes3.dex */
class g {
    public String method;
    public Charset qg;
    public h qh;
    public Map<String, String> qi;
    public k qj;
    private StringBuilder qk = new StringBuilder();
    public URL url;

    public void ai(String str) {
        this.qk.append(str + "\r\n");
    }

    public String dE() {
        return this.qk.toString();
    }

    public boolean hasError() {
        return this.qk.length() > 0;
    }
}
