package com.baidu.swan.games.audio;
/* loaded from: classes9.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String dkZ;
    public String dkT = "";
    public String cGy = "";
    public String mUrl = "";
    public float efd = 0.0f;
    public boolean dlc = false;
    public boolean mLoop = false;
    public boolean dld = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public String toString() {
        return "url : " + this.mUrl + "; AutoPlay : " + this.dlc + "; Volume :" + this.mVolume + "; Loop : " + this.mLoop + "; startTime : " + this.efd + "; ObeyMute : " + this.dld + "; pos : " + this.mPos;
    }
}
