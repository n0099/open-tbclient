package com.baidu.minivideo.arface.c;

import android.util.Log;
/* loaded from: classes5.dex */
public class c {
    private long cmQ;
    private long cmR;
    private long cmS;
    private long cmT;
    private long cmV;
    private long cmW;
    public long cmX;
    public long cmY;
    private String cmZ;
    private long mLastTime;
    private String mTag;
    private long cmU = 1000;
    private boolean mDebug = false;
    private StringBuilder cna = new StringBuilder();

    public c(String str, String str2) {
        this.mTag = str;
        this.cmZ = str2;
        reset();
    }

    public void bM(long j) {
        this.cmU = j;
    }

    public void acA() {
        if (this.mLastTime == 0) {
            this.mLastTime = System.currentTimeMillis();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mLastTime;
        this.cmS += currentTimeMillis;
        this.cmT++;
        if (currentTimeMillis > this.cmQ) {
            this.cmQ = currentTimeMillis;
        } else if (currentTimeMillis < this.cmR) {
            this.cmR = currentTimeMillis;
        }
        if (this.mDebug) {
            if (this.cna.length() > 0) {
                this.cna.delete(0, this.cna.length());
            }
            this.cna.append(this.cmZ);
            for (int i = (int) ((currentTimeMillis - 33) / 5); i > 0; i--) {
                this.cna.append('.');
            }
            this.cna.append(currentTimeMillis);
            d(this.mTag, this.cna.toString());
        }
        this.cmV++;
        if (this.cmU > 0 && System.currentTimeMillis() - this.cmW > this.cmU) {
            acB();
        }
        this.mLastTime = System.currentTimeMillis();
        if (this.cmW == 0) {
            this.cmW = this.mLastTime;
            this.cmV = 0L;
        }
    }

    public void acB() {
        this.cmX = System.currentTimeMillis() - this.cmW;
        this.cmY = this.cmV;
        this.cmW = 0L;
        this.cmV = 0L;
        if (this.mDebug) {
            d(this.mTag, String.format("%s, PeriodTime: %d, Times: %d", this.cmZ, Long.valueOf(this.cmX), Long.valueOf(this.cmY)));
        }
    }

    public void reset() {
        this.mLastTime = 0L;
        this.cmS = 0L;
        this.cmT = 0L;
        this.cmQ = Long.MIN_VALUE;
        this.cmR = Long.MAX_VALUE;
    }

    public String acC() {
        String format = String.format("%s, Total: %d, Times: %d, Min: %d, Max: %d, Average：%f", this.cmZ, Long.valueOf(this.cmS), Long.valueOf(this.cmT), Long.valueOf(this.cmR), Long.valueOf(this.cmQ), Float.valueOf(((float) this.cmS) / ((float) this.cmT)));
        if (this.mDebug) {
            d(this.mTag, format);
        }
        return format;
    }

    private void d(String str, String str2) {
        Log.d(str, str2);
    }
}
