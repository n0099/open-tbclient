package com.baidu.rtc.camera.engine.d;
/* loaded from: classes11.dex */
public final class a {
    private int chJ = 0;
    private float chK = 0.0f;
    private long mUpdateTime = 0;

    public void abG() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mUpdateTime == 0) {
            this.mUpdateTime = currentTimeMillis;
        }
        if (currentTimeMillis - this.mUpdateTime > 1000) {
            this.chK = (this.chJ / ((float) (currentTimeMillis - this.mUpdateTime))) * 1000.0f;
            this.mUpdateTime = currentTimeMillis;
            this.chJ = 0;
        }
        this.chJ++;
    }

    public float abH() {
        if (System.currentTimeMillis() - this.mUpdateTime > 2000) {
            return 0.0f;
        }
        return this.chK;
    }
}
