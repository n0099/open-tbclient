package com.baidu.tbadk.aladin.a;
/* loaded from: classes.dex */
public class a {
    private String method;
    private String url;
    private String xk;

    public a(String str) {
        String[] split;
        if (str != null && (split = str.split(" ")) != null && split.length == 3) {
            this.method = split[0];
            this.url = split[1];
            this.xk = split[2];
        }
    }

    public String getMethod() {
        return this.method;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String iJ() {
        return this.xk;
    }
}
