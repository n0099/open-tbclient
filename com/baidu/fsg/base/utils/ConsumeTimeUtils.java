package com.baidu.fsg.base.utils;

import android.os.SystemClock;
/* loaded from: classes16.dex */
public class ConsumeTimeUtils {

    /* renamed from: a  reason: collision with root package name */
    TimeResult f1508a;
    String b = "ConsumeTime";
    private String c;

    public ConsumeTimeUtils start() {
        this.f1508a = new TimeResult();
        this.f1508a.f1509a = SystemClock.uptimeMillis();
        return this;
    }

    public TimeResult finish() {
        this.f1508a.b = SystemClock.uptimeMillis();
        return this.f1508a;
    }

    public void setTAGString(String str) {
        this.b = str;
    }

    public void setPrefix(String str) {
        this.c = str;
    }

    /* loaded from: classes16.dex */
    public final class TimeResult {

        /* renamed from: a  reason: collision with root package name */
        long f1509a = 0;
        long b = 0;
        long c = 0;
        int d = 0;

        public TimeResult() {
        }

        public long getStartTime() {
            return this.f1509a;
        }

        public long getEndTime() {
            return this.b;
        }

        public long getDurationMesc() {
            return this.b - this.f1509a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.b, buildLog);
            return buildLog;
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.c != null) {
                sb.append(ConsumeTimeUtils.this.c + ":");
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.b, buildLog());
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.b, buildLog());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.b, buildLog(), new Throwable());
        }
    }
}
