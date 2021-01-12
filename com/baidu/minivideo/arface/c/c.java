package com.baidu.minivideo.arface.c;

import android.util.Log;
/* loaded from: classes5.dex */
public class c {
    private long chd;
    private long che;
    private long chf;
    private long chg;
    private long chi;
    private long chj;
    public long chk;
    public long chl;
    private String chm;
    private long mLastTime;
    private String mTag;
    private long chh = 1000;
    private boolean mDebug = false;
    private StringBuilder chn = new StringBuilder();

    public c(String str, String str2) {
        this.mTag = str;
        this.chm = str2;
        reset();
    }

    public void bI(long j) {
        this.chh = j;
    }

    public void aaJ() {
        if (this.mLastTime == 0) {
            this.mLastTime = System.currentTimeMillis();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mLastTime;
        this.chf += currentTimeMillis;
        this.chg++;
        if (currentTimeMillis > this.chd) {
            this.chd = currentTimeMillis;
        } else if (currentTimeMillis < this.che) {
            this.che = currentTimeMillis;
        }
        if (this.mDebug) {
            if (this.chn.length() > 0) {
                this.chn.delete(0, this.chn.length());
            }
            this.chn.append(this.chm);
            for (int i = (int) ((currentTimeMillis - 33) / 5); i > 0; i--) {
                this.chn.append('.');
            }
            this.chn.append(currentTimeMillis);
            d(this.mTag, this.chn.toString());
        }
        this.chi++;
        if (this.chh > 0 && System.currentTimeMillis() - this.chj > this.chh) {
            aaK();
        }
        this.mLastTime = System.currentTimeMillis();
        if (this.chj == 0) {
            this.chj = this.mLastTime;
            this.chi = 0L;
        }
    }

    public void aaK() {
        this.chk = System.currentTimeMillis() - this.chj;
        this.chl = this.chi;
        this.chj = 0L;
        this.chi = 0L;
        if (this.mDebug) {
            d(this.mTag, String.format("%s, PeriodTime: %d, Times: %d", this.chm, Long.valueOf(this.chk), Long.valueOf(this.chl)));
        }
    }

    public void reset() {
        this.mLastTime = 0L;
        this.chf = 0L;
        this.chg = 0L;
        this.chd = Long.MIN_VALUE;
        this.che = Long.MAX_VALUE;
    }

    public String aaL() {
        String format = String.format("%s, Total: %d, Times: %d, Min: %d, Max: %d, Average：%f", this.chm, Long.valueOf(this.chf), Long.valueOf(this.chg), Long.valueOf(this.che), Long.valueOf(this.chd), Float.valueOf(((float) this.chf) / ((float) this.chg)));
        if (this.mDebug) {
            d(this.mTag, format);
        }
        return format;
    }

    private void d(String str, String str2) {
        Log.d(str, str2);
    }
}
