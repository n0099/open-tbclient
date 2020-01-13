package com.baidu.rtc.camera.engine.d;
/* loaded from: classes5.dex */
public final class a {
    private int aSg = 0;
    private float aSh = 0.0f;
    private long mUpdateTime = 0;

    public void CT() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mUpdateTime == 0) {
            this.mUpdateTime = currentTimeMillis;
        }
        if (currentTimeMillis - this.mUpdateTime > 1000) {
            this.aSh = (this.aSg / ((float) (currentTimeMillis - this.mUpdateTime))) * 1000.0f;
            this.mUpdateTime = currentTimeMillis;
            this.aSg = 0;
        }
        this.aSg++;
    }

    public float CU() {
        if (System.currentTimeMillis() - this.mUpdateTime > 2000) {
            return 0.0f;
        }
        return this.aSh;
    }
}
