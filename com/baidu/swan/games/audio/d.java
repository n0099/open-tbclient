package com.baidu.swan.games.audio;
/* loaded from: classes11.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bAF;
    public String bAA = "";
    public String bcj = "";
    public String mUrl = "";
    public float cjW = 0.0f;
    public boolean bAI = false;
    public boolean mLoop = false;
    public boolean bAJ = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public String toString() {
        return "url : " + this.mUrl + "; AutoPlay : " + this.bAI + "; Volume :" + this.mVolume + "; Loop : " + this.mLoop + "; startTime : " + this.cjW + "; ObeyMute : " + this.bAJ + "; pos : " + this.mPos;
    }
}
