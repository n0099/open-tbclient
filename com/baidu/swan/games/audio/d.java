package com.baidu.swan.games.audio;
/* loaded from: classes9.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bvH;
    public String bvC = "";
    public String aXf = "";
    public String mUrl = "";
    public float cfD = 0.0f;
    public boolean bvK = false;
    public boolean bvL = false;
    public boolean bvM = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public String toString() {
        return "url : " + this.mUrl + "; AutoPlay : " + this.bvK + "; Volume :" + this.mVolume + "; Loop : " + this.bvL + "; startTime : " + this.cfD + "; ObeyMute : " + this.bvM + "; pos : " + this.mPos;
    }
}
