package com.baidu.minivideo.arface.c;

import android.util.Log;
/* loaded from: classes8.dex */
public class c {
    private long ceT;
    private long ceU;
    private long ceV;
    private long ceW;
    private long ceY;
    private long ceZ;
    public long cfa;
    public long cfb;
    private String cfc;
    private long mLastTime;
    private String mTag;
    private long ceX = 1000;
    private boolean mDebug = false;
    private StringBuilder cfd = new StringBuilder();

    public c(String str, String str2) {
        this.mTag = str;
        this.cfc = str2;
        reset();
    }

    public void bI(long j) {
        this.ceX = j;
    }

    public void acI() {
        if (this.mLastTime == 0) {
            this.mLastTime = System.currentTimeMillis();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mLastTime;
        this.ceV += currentTimeMillis;
        this.ceW++;
        if (currentTimeMillis > this.ceT) {
            this.ceT = currentTimeMillis;
        } else if (currentTimeMillis < this.ceU) {
            this.ceU = currentTimeMillis;
        }
        if (this.mDebug) {
            if (this.cfd.length() > 0) {
                this.cfd.delete(0, this.cfd.length());
            }
            this.cfd.append(this.cfc);
            for (int i = (int) ((currentTimeMillis - 33) / 5); i > 0; i--) {
                this.cfd.append('.');
            }
            this.cfd.append(currentTimeMillis);
            d(this.mTag, this.cfd.toString());
        }
        this.ceY++;
        if (this.ceX > 0 && System.currentTimeMillis() - this.ceZ > this.ceX) {
            acJ();
        }
        this.mLastTime = System.currentTimeMillis();
        if (this.ceZ == 0) {
            this.ceZ = this.mLastTime;
            this.ceY = 0L;
        }
    }

    public void acJ() {
        this.cfa = System.currentTimeMillis() - this.ceZ;
        this.cfb = this.ceY;
        this.ceZ = 0L;
        this.ceY = 0L;
        if (this.mDebug) {
            d(this.mTag, String.format("%s, PeriodTime: %d, Times: %d", this.cfc, Long.valueOf(this.cfa), Long.valueOf(this.cfb)));
        }
    }

    public void reset() {
        this.mLastTime = 0L;
        this.ceV = 0L;
        this.ceW = 0L;
        this.ceT = Long.MIN_VALUE;
        this.ceU = Long.MAX_VALUE;
    }

    public String acK() {
        String format = String.format("%s, Total: %d, Times: %d, Min: %d, Max: %d, Average：%f", this.cfc, Long.valueOf(this.ceV), Long.valueOf(this.ceW), Long.valueOf(this.ceU), Long.valueOf(this.ceT), Float.valueOf(((float) this.ceV) / ((float) this.ceW)));
        if (this.mDebug) {
            d(this.mTag, format);
        }
        return format;
    }

    private void d(String str, String str2) {
        Log.d(str, str2);
    }
}
