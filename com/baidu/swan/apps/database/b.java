package com.baidu.swan.apps.database;
/* loaded from: classes7.dex */
public final class b {
    private String appTitle;
    public int cPA;
    private String cPw;
    private String cPx;
    private String cPy;
    public String cPz;

    public b(String str) {
        this.cPw = str;
    }

    public String getAppID() {
        return this.cPw;
    }

    public void setAppID(String str) {
        this.cPw = str;
    }

    public String arW() {
        return this.appTitle;
    }

    public void nF(String str) {
        this.appTitle = str;
    }

    public String arX() {
        return this.cPy;
    }

    public void nG(String str) {
        this.cPy = str;
    }

    public void in(String str) {
        this.cPz = str;
    }

    public void nH(String str) {
        this.cPx = str;
    }

    public void setAppFrameType(int i) {
        this.cPA = i;
    }
}
