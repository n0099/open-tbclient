package com.baidu.rtc.camera.engine.d;
/* loaded from: classes6.dex */
public final class a {
    private int aWH = 0;
    private float aWI = 0.0f;
    private long mUpdateTime = 0;

    public void Fr() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mUpdateTime == 0) {
            this.mUpdateTime = currentTimeMillis;
        }
        if (currentTimeMillis - this.mUpdateTime > 1000) {
            this.aWI = (this.aWH / ((float) (currentTimeMillis - this.mUpdateTime))) * 1000.0f;
            this.mUpdateTime = currentTimeMillis;
            this.aWH = 0;
        }
        this.aWH++;
    }

    public float Fs() {
        if (System.currentTimeMillis() - this.mUpdateTime > 2000) {
            return 0.0f;
        }
        return this.aWI;
    }
}
