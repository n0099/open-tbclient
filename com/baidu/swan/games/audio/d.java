package com.baidu.swan.games.audio;
/* loaded from: classes2.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String aUC;
    public String aUw = "";
    public String aUx = "";
    public String mUrl = "";
    public float bxs = 0.0f;
    public boolean aUF = false;
    public boolean aUG = false;
    public boolean aUH = true;
    public int mPos = 0;
    public float aUI = 1.0f;

    public String toString() {
        return "playerId : " + this.aUw + "; slaveId : " + this.aUx + "; url : " + this.mUrl + "; AutoPlay : " + this.aUF + "; Loop : " + this.aUG + "; startTime : " + this.bxs + "; ObeyMute : " + this.aUH + "; pos : " + this.mPos;
    }
}
