package com.baidu.swan.games.audio;
/* loaded from: classes11.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bAE;
    public String bAz = "";
    public String bci = "";
    public String mUrl = "";
    public float cjV = 0.0f;
    public boolean bAH = false;
    public boolean mLoop = false;
    public boolean bAI = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public String toString() {
        return "url : " + this.mUrl + "; AutoPlay : " + this.bAH + "; Volume :" + this.mVolume + "; Loop : " + this.mLoop + "; startTime : " + this.cjV + "; ObeyMute : " + this.bAI + "; pos : " + this.mPos;
    }
}
