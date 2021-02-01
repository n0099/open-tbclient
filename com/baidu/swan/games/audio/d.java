package com.baidu.swan.games.audio;
/* loaded from: classes9.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String diy;
    public String diq = "";
    public String cEi = "";
    public String mUrl = "";
    public float ecy = 0.0f;
    public boolean diB = false;
    public boolean mLoop = false;
    public boolean diC = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public String toString() {
        return "url : " + this.mUrl + "; AutoPlay : " + this.diB + "; Volume :" + this.mVolume + "; Loop : " + this.mLoop + "; startTime : " + this.ecy + "; ObeyMute : " + this.diC + "; pos : " + this.mPos;
    }
}
