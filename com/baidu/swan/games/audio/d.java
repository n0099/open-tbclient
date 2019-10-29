package com.baidu.swan.games.audio;
/* loaded from: classes2.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String aUU;
    public String aUO = "";
    public String aUP = "";
    public String mUrl = "";
    public float byj = 0.0f;
    public boolean aUX = false;
    public boolean aUY = false;
    public boolean aUZ = true;
    public int mPos = 0;
    public float aVa = 1.0f;

    public String toString() {
        return "playerId : " + this.aUO + "; slaveId : " + this.aUP + "; url : " + this.mUrl + "; AutoPlay : " + this.aUX + "; Loop : " + this.aUY + "; startTime : " + this.byj + "; ObeyMute : " + this.aUZ + "; pos : " + this.mPos;
    }
}
