package com.baidu.swan.games.audio;
/* loaded from: classes8.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cyq;
    public String cyk = "";
    public String bTJ = "";
    public String mUrl = "";
    public float dos = 0.0f;
    public boolean cyt = false;
    public boolean mLoop = false;
    public boolean cyu = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public String toString() {
        return "url : " + this.mUrl + "; AutoPlay : " + this.cyt + "; Volume :" + this.mVolume + "; Loop : " + this.mLoop + "; startTime : " + this.dos + "; ObeyMute : " + this.cyu + "; pos : " + this.mPos;
    }
}
