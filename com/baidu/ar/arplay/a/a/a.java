package com.baidu.ar.arplay.a.a;
/* loaded from: classes3.dex */
public class a {
    private int dN;
    private boolean dO;
    private float dP;
    private String dQ;
    private long dR;
    private String id;
    private String url;

    public void B(String str) {
        this.dQ = str;
    }

    public int aA() {
        return this.dN;
    }

    public long aB() {
        return this.dR;
    }

    public String aC() {
        return this.dQ;
    }

    public boolean aD() {
        return this.dO;
    }

    public void d(long j) {
        this.dR = j;
    }

    public void g(boolean z) {
        this.dO = z;
    }

    public String getId() {
        return this.id;
    }

    public String getUrl() {
        return this.url;
    }

    public void i(int i) {
        this.dN = i;
    }

    public void setDelay(float f) {
        this.dP = f;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
