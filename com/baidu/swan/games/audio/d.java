package com.baidu.swan.games.audio;
/* loaded from: classes11.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cjG;
    public String cjA = "";
    public String bIH = "";
    public String mUrl = "";
    public float cTP = 0.0f;
    public boolean cjJ = false;
    public boolean mLoop = false;
    public boolean cjK = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public String toString() {
        return "url : " + this.mUrl + "; AutoPlay : " + this.cjJ + "; Volume :" + this.mVolume + "; Loop : " + this.mLoop + "; startTime : " + this.cTP + "; ObeyMute : " + this.cjK + "; pos : " + this.mPos;
    }
}
