package com.baidu.swan.ubc;

import android.util.Log;
/* loaded from: classes2.dex */
class h {
    private static final boolean DEBUG = g.DEBUG;
    private static String TAG = "ControlData";
    private final int bpl;
    private int mCount;
    private final String mId;
    private final int mSize;
    private long mTime;

    public h(String str, int i, int i2) {
        this.mId = str;
        this.bpl = i;
        this.mSize = i2;
    }

    public boolean Ta() {
        if (this.bpl == 0 || this.mSize == 0) {
            return false;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (DEBUG) {
            Log.d(TAG, "id " + this.mId + " mCycle " + this.bpl + " mSize " + this.mSize + "mCount =  " + this.mCount + " duration " + ((valueOf.longValue() - this.mTime) / 1000));
        }
        if (this.mTime != 0 && (valueOf.longValue() - this.mTime) / 1000 <= this.bpl && this.mCount >= this.mSize) {
            if (DEBUG) {
                Log.d(TAG, "control");
            }
            return true;
        }
        if (this.mTime == 0) {
            this.mTime = valueOf.longValue();
        } else if ((valueOf.longValue() - this.mTime) / 1000 > this.bpl) {
            this.mTime = valueOf.longValue();
            this.mCount = 0;
            if (DEBUG) {
                Log.d(TAG, "reset");
            }
        }
        this.mCount++;
        return false;
    }

    public boolean Tb() {
        return this.mCount != 0 && this.mCount == this.mSize;
    }
}
