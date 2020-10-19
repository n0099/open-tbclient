package com.baidu.swan.ubc;
/* loaded from: classes9.dex */
class h {
    private static String TAG = "ControlData";
    private final int dXP;
    private int mCount;
    private final String mId;
    private final int mSize;
    private long mTime;

    public h(String str, int i, int i2) {
        this.mId = str;
        this.dXP = i;
        this.mSize = i2;
    }

    public boolean aZi() {
        if (this.dXP == 0 || this.mSize == 0) {
            return false;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (this.mTime != 0 && (valueOf.longValue() - this.mTime) / 1000 <= this.dXP && this.mCount >= this.mSize) {
            return true;
        }
        if (this.mTime == 0) {
            this.mTime = valueOf.longValue();
        } else if ((valueOf.longValue() - this.mTime) / 1000 > this.dXP) {
            this.mTime = valueOf.longValue();
            this.mCount = 0;
        }
        this.mCount++;
        return false;
    }

    public boolean aZj() {
        return this.mCount != 0 && this.mCount == this.mSize;
    }

    public String getId() {
        return this.mId;
    }
}
