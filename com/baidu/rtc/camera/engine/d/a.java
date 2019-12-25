package com.baidu.rtc.camera.engine.d;
/* loaded from: classes4.dex */
public final class a {
    private int aRo = 0;
    private float aRp = 0.0f;
    private long mUpdateTime = 0;

    public void Cx() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mUpdateTime == 0) {
            this.mUpdateTime = currentTimeMillis;
        }
        if (currentTimeMillis - this.mUpdateTime > 1000) {
            this.aRp = (this.aRo / ((float) (currentTimeMillis - this.mUpdateTime))) * 1000.0f;
            this.mUpdateTime = currentTimeMillis;
            this.aRo = 0;
        }
        this.aRo++;
    }

    public float Cy() {
        if (System.currentTimeMillis() - this.mUpdateTime > 2000) {
            return 0.0f;
        }
        return this.aRp;
    }
}
