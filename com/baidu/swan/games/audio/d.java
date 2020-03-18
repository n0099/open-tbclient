package com.baidu.swan.games.audio;
/* loaded from: classes11.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bAQ;
    public String bAL = "";
    public String bcw = "";
    public String mUrl = "";
    public float ckh = 0.0f;
    public boolean bAT = false;
    public boolean mLoop = false;
    public boolean bAU = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public String toString() {
        return "url : " + this.mUrl + "; AutoPlay : " + this.bAT + "; Volume :" + this.mVolume + "; Loop : " + this.mLoop + "; startTime : " + this.ckh + "; ObeyMute : " + this.bAU + "; pos : " + this.mPos;
    }
}
