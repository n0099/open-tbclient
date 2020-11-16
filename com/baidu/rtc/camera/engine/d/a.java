package com.baidu.rtc.camera.engine.d;
/* loaded from: classes16.dex */
public final class a {
    private int clT = 0;
    private float clU = 0.0f;
    private long mUpdateTime = 0;

    public void ady() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mUpdateTime == 0) {
            this.mUpdateTime = currentTimeMillis;
        }
        if (currentTimeMillis - this.mUpdateTime > 1000) {
            this.clU = (this.clT / ((float) (currentTimeMillis - this.mUpdateTime))) * 1000.0f;
            this.mUpdateTime = currentTimeMillis;
            this.clT = 0;
        }
        this.clT++;
    }

    public float adz() {
        if (System.currentTimeMillis() - this.mUpdateTime > 2000) {
            return 0.0f;
        }
        return this.clU;
    }
}
