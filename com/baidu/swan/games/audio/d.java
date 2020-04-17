package com.baidu.swan.games.audio;
/* loaded from: classes11.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bYX;
    public String bYS = "";
    public String bAK = "";
    public String mUrl = "";
    public float cJc = 0.0f;
    public boolean bZa = false;
    public boolean mLoop = false;
    public boolean bZb = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public String toString() {
        return "url : " + this.mUrl + "; AutoPlay : " + this.bZa + "; Volume :" + this.mVolume + "; Loop : " + this.mLoop + "; startTime : " + this.cJc + "; ObeyMute : " + this.bZb + "; pos : " + this.mPos;
    }
}
