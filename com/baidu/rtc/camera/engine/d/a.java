package com.baidu.rtc.camera.engine.d;
/* loaded from: classes6.dex */
public final class a {
    private int bCX = 0;
    private float bCY = 0.0f;
    private long mUpdateTime = 0;

    public void Pu() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mUpdateTime == 0) {
            this.mUpdateTime = currentTimeMillis;
        }
        if (currentTimeMillis - this.mUpdateTime > 1000) {
            this.bCY = (this.bCX / ((float) (currentTimeMillis - this.mUpdateTime))) * 1000.0f;
            this.mUpdateTime = currentTimeMillis;
            this.bCX = 0;
        }
        this.bCX++;
    }

    public float Pv() {
        if (System.currentTimeMillis() - this.mUpdateTime > 2000) {
            return 0.0f;
        }
        return this.bCY;
    }
}
