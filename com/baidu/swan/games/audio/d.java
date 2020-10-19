package com.baidu.swan.games.audio;
/* loaded from: classes10.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cMA;
    public String cMu = "";
    public String cib = "";
    public String mUrl = "";
    public float dCB = 0.0f;
    public boolean cMD = false;
    public boolean mLoop = false;
    public boolean cME = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public String toString() {
        return "url : " + this.mUrl + "; AutoPlay : " + this.cMD + "; Volume :" + this.mVolume + "; Loop : " + this.mLoop + "; startTime : " + this.dCB + "; ObeyMute : " + this.cME + "; pos : " + this.mPos;
    }
}
