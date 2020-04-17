package com.baidu.ar.http;

import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
/* loaded from: classes3.dex */
class g {
    public String method;
    public Charset pH;
    public h pI;
    public Map<String, String> pJ;
    public k pK;
    private StringBuilder pL = new StringBuilder();
    public URL url;

    public void ah(String str) {
        this.pL.append(str + "\r\n");
    }

    /* renamed from: do  reason: not valid java name */
    public String m19do() {
        return this.pL.toString();
    }

    public boolean hasError() {
        return this.pL.length() > 0;
    }
}
