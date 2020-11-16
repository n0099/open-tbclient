package com.baidu.ar.http;

import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
/* loaded from: classes12.dex */
class g {
    public String method;
    public Charset qL;
    public h qM;
    public Map<String, String> qN;
    public k qO;
    private StringBuilder qP = new StringBuilder();
    public URL url;

    public void am(String str) {
        this.qP.append(str + "\r\n");
    }

    public String eO() {
        return this.qP.toString();
    }

    public boolean hasError() {
        return this.qP.length() > 0;
    }
}
