package com.baidu.swan.games.audio;
/* loaded from: classes2.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String aBG;
    public String aBA = "";
    public String aBB = "";
    public String mUrl = "";
    public float bfq = 0.0f;
    public boolean aBJ = false;
    public boolean mLoop = false;
    public boolean aBK = true;
    public int mPos = 0;
    public float aBL = 1.0f;

    public String toString() {
        return "playerId : " + this.aBA + "; slaveId : " + this.aBB + "; url : " + this.mUrl + "; AutoPlay : " + this.aBJ + "; Loop : " + this.mLoop + "; startTime : " + this.bfq + "; ObeyMute : " + this.aBK + "; pos : " + this.mPos;
    }
}
