package com.baidu.rtc.camera.engine.d;
/* loaded from: classes11.dex */
public final class a {
    private int csP = 0;
    private float csQ = 0.0f;
    private long mUpdateTime = 0;

    public void agG() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mUpdateTime == 0) {
            this.mUpdateTime = currentTimeMillis;
        }
        if (currentTimeMillis - this.mUpdateTime > 1000) {
            this.csQ = (this.csP / ((float) (currentTimeMillis - this.mUpdateTime))) * 1000.0f;
            this.mUpdateTime = currentTimeMillis;
            this.csP = 0;
        }
        this.csP++;
    }

    public float agH() {
        if (System.currentTimeMillis() - this.mUpdateTime > 2000) {
            return 0.0f;
        }
        return this.csQ;
    }
}
