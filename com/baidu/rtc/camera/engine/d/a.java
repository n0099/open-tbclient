package com.baidu.rtc.camera.engine.d;
/* loaded from: classes6.dex */
public final class a {
    private int bvu = 0;
    private float bvv = 0.0f;
    private long mUpdateTime = 0;

    public void Nh() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mUpdateTime == 0) {
            this.mUpdateTime = currentTimeMillis;
        }
        if (currentTimeMillis - this.mUpdateTime > 1000) {
            this.bvv = (this.bvu / ((float) (currentTimeMillis - this.mUpdateTime))) * 1000.0f;
            this.mUpdateTime = currentTimeMillis;
            this.bvu = 0;
        }
        this.bvu++;
    }

    public float Ni() {
        if (System.currentTimeMillis() - this.mUpdateTime > 2000) {
            return 0.0f;
        }
        return this.bvv;
    }
}
