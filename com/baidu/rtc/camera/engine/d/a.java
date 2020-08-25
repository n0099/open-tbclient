package com.baidu.rtc.camera.engine.d;
/* loaded from: classes11.dex */
public final class a {
    private int bNL = 0;
    private float bNM = 0.0f;
    private long mUpdateTime = 0;

    public void WL() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mUpdateTime == 0) {
            this.mUpdateTime = currentTimeMillis;
        }
        if (currentTimeMillis - this.mUpdateTime > 1000) {
            this.bNM = (this.bNL / ((float) (currentTimeMillis - this.mUpdateTime))) * 1000.0f;
            this.mUpdateTime = currentTimeMillis;
            this.bNL = 0;
        }
        this.bNL++;
    }

    public float WM() {
        if (System.currentTimeMillis() - this.mUpdateTime > 2000) {
            return 0.0f;
        }
        return this.bNM;
    }
}
