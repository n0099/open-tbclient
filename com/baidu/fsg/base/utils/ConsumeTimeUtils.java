package com.baidu.fsg.base.utils;

import android.os.SystemClock;
/* loaded from: classes5.dex */
public class ConsumeTimeUtils {

    /* renamed from: a  reason: collision with root package name */
    TimeResult f1966a;

    /* renamed from: b  reason: collision with root package name */
    String f1967b = "ConsumeTime";
    private String c;

    public ConsumeTimeUtils start() {
        this.f1966a = new TimeResult();
        this.f1966a.f1968a = SystemClock.uptimeMillis();
        return this;
    }

    public TimeResult finish() {
        this.f1966a.f1969b = SystemClock.uptimeMillis();
        return this.f1966a;
    }

    public void setTAGString(String str) {
        this.f1967b = str;
    }

    public void setPrefix(String str) {
        this.c = str;
    }

    /* loaded from: classes5.dex */
    public final class TimeResult {

        /* renamed from: a  reason: collision with root package name */
        long f1968a = 0;

        /* renamed from: b  reason: collision with root package name */
        long f1969b = 0;
        long c = 0;
        int d = 0;

        public TimeResult() {
        }

        public long getStartTime() {
            return this.f1968a;
        }

        public long getEndTime() {
            return this.f1969b;
        }

        public long getDurationMesc() {
            return this.f1969b - this.f1968a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.f1967b, buildLog);
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
            LogUtil.v(ConsumeTimeUtils.this.f1967b, buildLog());
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.f1967b, buildLog());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.f1967b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.f1967b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.f1967b, buildLog(), new Throwable());
        }
    }
}
