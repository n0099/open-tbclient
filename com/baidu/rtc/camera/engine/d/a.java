package com.baidu.rtc.camera.engine.d;
/* loaded from: classes6.dex */
public final class a {
    private int aWF = 0;
    private float aWG = 0.0f;
    private long mUpdateTime = 0;

    public void Fp() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mUpdateTime == 0) {
            this.mUpdateTime = currentTimeMillis;
        }
        if (currentTimeMillis - this.mUpdateTime > 1000) {
            this.aWG = (this.aWF / ((float) (currentTimeMillis - this.mUpdateTime))) * 1000.0f;
            this.mUpdateTime = currentTimeMillis;
            this.aWF = 0;
        }
        this.aWF++;
    }

    public float Fq() {
        if (System.currentTimeMillis() - this.mUpdateTime > 2000) {
            return 0.0f;
        }
        return this.aWG;
    }
}
