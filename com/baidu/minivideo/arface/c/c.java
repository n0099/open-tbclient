package com.baidu.minivideo.arface.c;

import android.util.Log;
/* loaded from: classes6.dex */
public class c {
    private long clQ;
    private long clR;
    private long clS;
    private long clT;
    private long clV;
    private long clW;
    public long clX;
    public long clY;
    private String clZ;
    private long mLastTime;
    private String mTag;
    private long clU = 1000;
    private boolean mDebug = false;
    private StringBuilder cma = new StringBuilder();

    public c(String str, String str2) {
        this.mTag = str;
        this.clZ = str2;
        reset();
    }

    public void bI(long j) {
        this.clU = j;
    }

    public void aeB() {
        if (this.mLastTime == 0) {
            this.mLastTime = System.currentTimeMillis();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mLastTime;
        this.clS += currentTimeMillis;
        this.clT++;
        if (currentTimeMillis > this.clQ) {
            this.clQ = currentTimeMillis;
        } else if (currentTimeMillis < this.clR) {
            this.clR = currentTimeMillis;
        }
        if (this.mDebug) {
            if (this.cma.length() > 0) {
                this.cma.delete(0, this.cma.length());
            }
            this.cma.append(this.clZ);
            for (int i = (int) ((currentTimeMillis - 33) / 5); i > 0; i--) {
                this.cma.append('.');
            }
            this.cma.append(currentTimeMillis);
            d(this.mTag, this.cma.toString());
        }
        this.clV++;
        if (this.clU > 0 && System.currentTimeMillis() - this.clW > this.clU) {
            aeC();
        }
        this.mLastTime = System.currentTimeMillis();
        if (this.clW == 0) {
            this.clW = this.mLastTime;
            this.clV = 0L;
        }
    }

    public void aeC() {
        this.clX = System.currentTimeMillis() - this.clW;
        this.clY = this.clV;
        this.clW = 0L;
        this.clV = 0L;
        if (this.mDebug) {
            d(this.mTag, String.format("%s, PeriodTime: %d, Times: %d", this.clZ, Long.valueOf(this.clX), Long.valueOf(this.clY)));
        }
    }

    public void reset() {
        this.mLastTime = 0L;
        this.clS = 0L;
        this.clT = 0L;
        this.clQ = Long.MIN_VALUE;
        this.clR = Long.MAX_VALUE;
    }

    public String aeD() {
        String format = String.format("%s, Total: %d, Times: %d, Min: %d, Max: %d, Average：%f", this.clZ, Long.valueOf(this.clS), Long.valueOf(this.clT), Long.valueOf(this.clR), Long.valueOf(this.clQ), Float.valueOf(((float) this.clS) / ((float) this.clT)));
        if (this.mDebug) {
            d(this.mTag, format);
        }
        return format;
    }

    private void d(String str, String str2) {
        Log.d(str, str2);
    }
}
