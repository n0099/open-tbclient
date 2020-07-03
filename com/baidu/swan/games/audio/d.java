package com.baidu.swan.games.audio;
/* loaded from: classes11.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cov;
    public String cop = "";
    public String bNv = "";
    public String mUrl = "";
    public float cYz = 0.0f;
    public boolean coy = false;
    public boolean mLoop = false;
    public boolean coz = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public String toString() {
        return "url : " + this.mUrl + "; AutoPlay : " + this.coy + "; Volume :" + this.mVolume + "; Loop : " + this.mLoop + "; startTime : " + this.cYz + "; ObeyMute : " + this.coz + "; pos : " + this.mPos;
    }
}
