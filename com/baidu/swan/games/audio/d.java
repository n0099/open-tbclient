package com.baidu.swan.games.audio;
/* loaded from: classes11.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bZd;
    public String bYY = "";
    public String bAP = "";
    public String mUrl = "";
    public float cJi = 0.0f;
    public boolean bZg = false;
    public boolean mLoop = false;
    public boolean bZh = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public String toString() {
        return "url : " + this.mUrl + "; AutoPlay : " + this.bZg + "; Volume :" + this.mVolume + "; Loop : " + this.mLoop + "; startTime : " + this.cJi + "; ObeyMute : " + this.bZh + "; pos : " + this.mPos;
    }
}
