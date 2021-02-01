package com.baidu.minivideo.arface.c;

import android.util.Log;
/* loaded from: classes3.dex */
public class c {
    private long clp;
    private long clq;
    private long clr;
    private long cls;
    private long clu;
    private long clv;
    public long clw;
    public long clx;
    private String cly;
    private long mLastTime;
    private String mTag;
    private long clt = 1000;
    private boolean mDebug = false;
    private StringBuilder clz = new StringBuilder();

    public c(String str, String str2) {
        this.mTag = str;
        this.cly = str2;
        reset();
    }

    public void bM(long j) {
        this.clt = j;
    }

    public void acx() {
        if (this.mLastTime == 0) {
            this.mLastTime = System.currentTimeMillis();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mLastTime;
        this.clr += currentTimeMillis;
        this.cls++;
        if (currentTimeMillis > this.clp) {
            this.clp = currentTimeMillis;
        } else if (currentTimeMillis < this.clq) {
            this.clq = currentTimeMillis;
        }
        if (this.mDebug) {
            if (this.clz.length() > 0) {
                this.clz.delete(0, this.clz.length());
            }
            this.clz.append(this.cly);
            for (int i = (int) ((currentTimeMillis - 33) / 5); i > 0; i--) {
                this.clz.append('.');
            }
            this.clz.append(currentTimeMillis);
            d(this.mTag, this.clz.toString());
        }
        this.clu++;
        if (this.clt > 0 && System.currentTimeMillis() - this.clv > this.clt) {
            acy();
        }
        this.mLastTime = System.currentTimeMillis();
        if (this.clv == 0) {
            this.clv = this.mLastTime;
            this.clu = 0L;
        }
    }

    public void acy() {
        this.clw = System.currentTimeMillis() - this.clv;
        this.clx = this.clu;
        this.clv = 0L;
        this.clu = 0L;
        if (this.mDebug) {
            d(this.mTag, String.format("%s, PeriodTime: %d, Times: %d", this.cly, Long.valueOf(this.clw), Long.valueOf(this.clx)));
        }
    }

    public void reset() {
        this.mLastTime = 0L;
        this.clr = 0L;
        this.cls = 0L;
        this.clp = Long.MIN_VALUE;
        this.clq = Long.MAX_VALUE;
    }

    public String acz() {
        String format = String.format("%s, Total: %d, Times: %d, Min: %d, Max: %d, Average：%f", this.cly, Long.valueOf(this.clr), Long.valueOf(this.cls), Long.valueOf(this.clq), Long.valueOf(this.clp), Float.valueOf(((float) this.clr) / ((float) this.cls)));
        if (this.mDebug) {
            d(this.mTag, format);
        }
        return format;
    }

    private void d(String str, String str2) {
        Log.d(str, str2);
    }
}
