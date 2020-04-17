package com.baidu.rtc.camera.engine.d;
/* loaded from: classes6.dex */
public final class a {
    private int bvp = 0;
    private float bvq = 0.0f;
    private long mUpdateTime = 0;

    public void Ni() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mUpdateTime == 0) {
            this.mUpdateTime = currentTimeMillis;
        }
        if (currentTimeMillis - this.mUpdateTime > 1000) {
            this.bvq = (this.bvp / ((float) (currentTimeMillis - this.mUpdateTime))) * 1000.0f;
            this.mUpdateTime = currentTimeMillis;
            this.bvp = 0;
        }
        this.bvp++;
    }

    public float Nj() {
        if (System.currentTimeMillis() - this.mUpdateTime > 2000) {
            return 0.0f;
        }
        return this.bvq;
    }
}
