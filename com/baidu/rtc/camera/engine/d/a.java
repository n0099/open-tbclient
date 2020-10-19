package com.baidu.rtc.camera.engine.d;
/* loaded from: classes11.dex */
public final class a {
    private int bZl = 0;
    private float bZm = 0.0f;
    private long mUpdateTime = 0;

    public void ZM() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mUpdateTime == 0) {
            this.mUpdateTime = currentTimeMillis;
        }
        if (currentTimeMillis - this.mUpdateTime > 1000) {
            this.bZm = (this.bZl / ((float) (currentTimeMillis - this.mUpdateTime))) * 1000.0f;
            this.mUpdateTime = currentTimeMillis;
            this.bZl = 0;
        }
        this.bZl++;
    }

    public float ZN() {
        if (System.currentTimeMillis() - this.mUpdateTime > 2000) {
            return 0.0f;
        }
        return this.bZm;
    }
}
