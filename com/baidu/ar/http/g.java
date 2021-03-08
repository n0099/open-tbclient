package com.baidu.ar.http;

import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
/* loaded from: classes3.dex */
class g {
    public String method;
    public Charset rb;
    public h rc;
    public Map<String, String> rd;
    public k re;
    private StringBuilder rf = new StringBuilder();
    public URL url;

    public void ap(String str) {
        this.rf.append(str + "\r\n");
    }

    public String eN() {
        return this.rf.toString();
    }

    public boolean hasError() {
        return this.rf.length() > 0;
    }
}
