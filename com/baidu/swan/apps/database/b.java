package com.baidu.swan.apps.database;
/* loaded from: classes8.dex */
public final class b {
    private String appTitle;
    public int cWA;
    private String cWw;
    private String cWx;
    private String cWy;
    public String cWz;

    public b(String str) {
        this.cWw = str;
    }

    public String getAppID() {
        return this.cWw;
    }

    public void setAppID(String str) {
        this.cWw = str;
    }

    public String asE() {
        return this.appTitle;
    }

    public void mU(String str) {
        this.appTitle = str;
    }

    public String asF() {
        return this.cWy;
    }

    public void mV(String str) {
        this.cWy = str;
    }

    public void hv(String str) {
        this.cWz = str;
    }

    public void mW(String str) {
        this.cWx = str;
    }

    public void setAppFrameType(int i) {
        this.cWA = i;
    }
}
