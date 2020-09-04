package com.baidu.swan.games.audio;
/* loaded from: classes8.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cyu;
    public String cyo = "";
    public String bTN = "";
    public String mUrl = "";
    public float dow = 0.0f;
    public boolean cyx = false;
    public boolean mLoop = false;
    public boolean cyy = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public String toString() {
        return "url : " + this.mUrl + "; AutoPlay : " + this.cyx + "; Volume :" + this.mVolume + "; Loop : " + this.mLoop + "; startTime : " + this.dow + "; ObeyMute : " + this.cyy + "; pos : " + this.mPos;
    }
}
