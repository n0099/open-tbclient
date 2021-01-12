package com.baidu.swan.games.audio;
/* loaded from: classes8.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String dgk;
    public String dge = "";
    public String cBM = "";
    public String mUrl = "";
    public float ear = 0.0f;
    public boolean dgn = false;
    public boolean mLoop = false;
    public boolean dgo = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public String toString() {
        return "url : " + this.mUrl + "; AutoPlay : " + this.dgn + "; Volume :" + this.mVolume + "; Loop : " + this.mLoop + "; startTime : " + this.ear + "; ObeyMute : " + this.dgo + "; pos : " + this.mPos;
    }
}
