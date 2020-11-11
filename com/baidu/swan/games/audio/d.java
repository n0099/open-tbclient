package com.baidu.swan.games.audio;
/* loaded from: classes10.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String daQ;
    public String daK = "";
    public String cwA = "";
    public String mUrl = "";
    public float dQQ = 0.0f;
    public boolean daT = false;
    public boolean mLoop = false;
    public boolean daU = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public String toString() {
        return "url : " + this.mUrl + "; AutoPlay : " + this.daT + "; Volume :" + this.mVolume + "; Loop : " + this.mLoop + "; startTime : " + this.dQQ + "; ObeyMute : " + this.daU + "; pos : " + this.mPos;
    }
}
