package com.baidu.ar.http;

import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    public String method;
    public Charset rb;
    public h rc;
    public Map<String, String> rd;
    public k re;
    public StringBuilder rf = new StringBuilder();
    public URL url;

    public void ap(String str) {
        StringBuilder sb = this.rf;
        sb.append(str + "\r\n");
    }

    public String eN() {
        return this.rf.toString();
    }

    public boolean hasError() {
        return this.rf.length() > 0;
    }
}
