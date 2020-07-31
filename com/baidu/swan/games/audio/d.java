package com.baidu.swan.games.audio;
/* loaded from: classes7.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cqA;
    public String cqu = "";
    public String bOl = "";
    public String mUrl = "";
    public float dej = 0.0f;
    public boolean cqD = false;
    public boolean mLoop = false;
    public boolean cqE = true;
    public int mPos = 0;
    public float mVolume = 1.0f;

    public String toString() {
        return "url : " + this.mUrl + "; AutoPlay : " + this.cqD + "; Volume :" + this.mVolume + "; Loop : " + this.mLoop + "; startTime : " + this.dej + "; ObeyMute : " + this.cqE + "; pos : " + this.mPos;
    }
}
