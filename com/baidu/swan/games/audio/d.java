package com.baidu.swan.games.audio;
/* loaded from: classes3.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cAv;
    public String cAp = "";
    public String bVN = "";
    public String mUrl = "";
    public float dqx = 0.0f;
    public boolean cAy = false;
    public boolean mLoop = false;
    public boolean cAz = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public String toString() {
        return "url : " + this.mUrl + "; AutoPlay : " + this.cAy + "; Volume :" + this.mVolume + "; Loop : " + this.mLoop + "; startTime : " + this.dqx + "; ObeyMute : " + this.cAz + "; pos : " + this.mPos;
    }
}
