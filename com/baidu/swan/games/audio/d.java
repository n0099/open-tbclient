package com.baidu.swan.games.audio;
/* loaded from: classes2.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String aAA;
    public String aAu = "";
    public String aAv = "";
    public String mUrl = "";
    public float bed = 0.0f;
    public boolean aAD = false;
    public boolean mLoop = false;
    public boolean aAE = true;
    public int mPos = 0;
    public float aAF = 1.0f;

    public String toString() {
        return "playerId : " + this.aAu + "; slaveId : " + this.aAv + "; url : " + this.mUrl + "; AutoPlay : " + this.aAD + "; Loop : " + this.mLoop + "; startTime : " + this.bed + "; ObeyMute : " + this.aAE + "; pos : " + this.mPos;
    }
}
