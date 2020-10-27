package com.baidu.swan.games.audio;
/* loaded from: classes10.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cUW;
    public String cUQ = "";
    public String cqC = "";
    public String mUrl = "";
    public float dKY = 0.0f;
    public boolean cUZ = false;
    public boolean mLoop = false;
    public boolean cVa = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public String toString() {
        return "url : " + this.mUrl + "; AutoPlay : " + this.cUZ + "; Volume :" + this.mVolume + "; Loop : " + this.mLoop + "; startTime : " + this.dKY + "; ObeyMute : " + this.cVa + "; pos : " + this.mPos;
    }
}
