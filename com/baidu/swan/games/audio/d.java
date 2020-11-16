package com.baidu.swan.games.audio;
/* loaded from: classes7.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cZg;
    public String cZa = "";
    public String cuQ = "";
    public String mUrl = "";
    public float dPi = 0.0f;
    public boolean cZj = false;
    public boolean mLoop = false;
    public boolean cZk = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public String toString() {
        return "url : " + this.mUrl + "; AutoPlay : " + this.cZj + "; Volume :" + this.mVolume + "; Loop : " + this.mLoop + "; startTime : " + this.dPi + "; ObeyMute : " + this.cZk + "; pos : " + this.mPos;
    }
}
