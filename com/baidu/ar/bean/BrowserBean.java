package com.baidu.ar.bean;
/* loaded from: classes3.dex */
public class BrowserBean {
    public static final String TYPE = "type";
    public static final String URL = "url";
    private int a;
    private String b;

    /* loaded from: classes3.dex */
    public enum OPENTYPE {
        DEFAULT_TYPE,
        SHOUBAI_O2O_TYPE,
        INTERNAL_TYPE
    }

    public int getType() {
        return this.a;
    }

    public String getUrl() {
        return this.b;
    }

    public void setType(int i) {
        this.a = i;
    }

    public void setUrl(String str) {
        this.b = str;
    }
}
