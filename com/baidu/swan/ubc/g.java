package com.baidu.swan.ubc;
/* loaded from: classes2.dex */
class g {
    private static String TAG = "ControlData";
    private final int bpm;
    private int mCount;
    private final String mId;
    private final int mSize;
    private long mTime;

    public g(String str, int i, int i2) {
        this.mId = str;
        this.bpm = i;
        this.mSize = i2;
    }

    public boolean Ta() {
        if (this.bpm == 0 || this.mSize == 0) {
            return false;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (this.mTime != 0 && (valueOf.longValue() - this.mTime) / 1000 <= this.bpm && this.mCount >= this.mSize) {
            return true;
        }
        if (this.mTime == 0) {
            this.mTime = valueOf.longValue();
        } else if ((valueOf.longValue() - this.mTime) / 1000 > this.bpm) {
            this.mTime = valueOf.longValue();
            this.mCount = 0;
        }
        this.mCount++;
        return false;
    }

    public boolean Tb() {
        return this.mCount != 0 && this.mCount == this.mSize;
    }
}
