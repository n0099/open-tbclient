package com.baidu.rtc.camera.engine.d;
/* loaded from: classes15.dex */
public final class a {
    private int bPP = 0;
    private float bPQ = 0.0f;
    private long mUpdateTime = 0;

    public void Xu() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mUpdateTime == 0) {
            this.mUpdateTime = currentTimeMillis;
        }
        if (currentTimeMillis - this.mUpdateTime > 1000) {
            this.bPQ = (this.bPP / ((float) (currentTimeMillis - this.mUpdateTime))) * 1000.0f;
            this.mUpdateTime = currentTimeMillis;
            this.bPP = 0;
        }
        this.bPP++;
    }

    public float Xv() {
        if (System.currentTimeMillis() - this.mUpdateTime > 2000) {
            return 0.0f;
        }
        return this.bPQ;
    }
}
