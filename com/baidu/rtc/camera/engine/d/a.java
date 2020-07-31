package com.baidu.rtc.camera.engine.d;
/* loaded from: classes7.dex */
public final class a {
    private int bIk = 0;
    private float bIl = 0.0f;
    private long mUpdateTime = 0;

    public void QP() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mUpdateTime == 0) {
            this.mUpdateTime = currentTimeMillis;
        }
        if (currentTimeMillis - this.mUpdateTime > 1000) {
            this.bIl = (this.bIk / ((float) (currentTimeMillis - this.mUpdateTime))) * 1000.0f;
            this.mUpdateTime = currentTimeMillis;
            this.bIk = 0;
        }
        this.bIk++;
    }

    public float QQ() {
        if (System.currentTimeMillis() - this.mUpdateTime > 2000) {
            return 0.0f;
        }
        return this.bIl;
    }
}
