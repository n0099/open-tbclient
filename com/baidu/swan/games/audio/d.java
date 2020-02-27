package com.baidu.swan.games.audio;
/* loaded from: classes11.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bAD;
    public String bAy = "";
    public String bch = "";
    public String mUrl = "";
    public float cjU = 0.0f;
    public boolean bAG = false;
    public boolean mLoop = false;
    public boolean bAH = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public String toString() {
        return "url : " + this.mUrl + "; AutoPlay : " + this.bAG + "; Volume :" + this.mVolume + "; Loop : " + this.mLoop + "; startTime : " + this.cjU + "; ObeyMute : " + this.bAH + "; pos : " + this.mPos;
    }
}
