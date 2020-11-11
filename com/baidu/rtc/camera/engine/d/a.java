package com.baidu.rtc.camera.engine.d;
/* loaded from: classes11.dex */
public final class a {
    private int cnF = 0;
    private float cnG = 0.0f;
    private long mUpdateTime = 0;

    public void aeg() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mUpdateTime == 0) {
            this.mUpdateTime = currentTimeMillis;
        }
        if (currentTimeMillis - this.mUpdateTime > 1000) {
            this.cnG = (this.cnF / ((float) (currentTimeMillis - this.mUpdateTime))) * 1000.0f;
            this.mUpdateTime = currentTimeMillis;
            this.cnF = 0;
        }
        this.cnF++;
    }

    public float aeh() {
        if (System.currentTimeMillis() - this.mUpdateTime > 2000) {
            return 0.0f;
        }
        return this.cnG;
    }
}
