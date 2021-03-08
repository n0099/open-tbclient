package com.baidu.swan.games.audio;
/* loaded from: classes8.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String djZ;
    public String djT = "";
    public String cFI = "";
    public String mUrl = "";
    public float edZ = 0.0f;
    public boolean dkc = false;
    public boolean mLoop = false;
    public boolean dkd = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public String toString() {
        return "url : " + this.mUrl + "; AutoPlay : " + this.dkc + "; Volume :" + this.mVolume + "; Loop : " + this.mLoop + "; startTime : " + this.edZ + "; ObeyMute : " + this.dkd + "; pos : " + this.mPos;
    }
}
