package com.baidu.swan.games.audio;
/* loaded from: classes2.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String aBi;
    public String aBc = "";
    public String aBd = "";
    public String mUrl = "";
    public float beR = 0.0f;
    public boolean aBl = false;
    public boolean mLoop = false;
    public boolean aBm = true;
    public int mPos = 0;
    public float aBn = 1.0f;

    public String toString() {
        return "playerId : " + this.aBc + "; slaveId : " + this.aBd + "; url : " + this.mUrl + "; AutoPlay : " + this.aBl + "; Loop : " + this.mLoop + "; startTime : " + this.beR + "; ObeyMute : " + this.aBm + "; pos : " + this.mPos;
    }
}
