package com.baidu.fsg.base.utils;

import android.os.SystemClock;
/* loaded from: classes6.dex */
public class ConsumeTimeUtils {

    /* renamed from: a  reason: collision with root package name */
    TimeResult f2018a;

    /* renamed from: b  reason: collision with root package name */
    String f2019b = "ConsumeTime";
    private String c;

    public ConsumeTimeUtils start() {
        this.f2018a = new TimeResult();
        this.f2018a.f2020a = SystemClock.uptimeMillis();
        return this;
    }

    public TimeResult finish() {
        this.f2018a.f2021b = SystemClock.uptimeMillis();
        return this.f2018a;
    }

    public void setTAGString(String str) {
        this.f2019b = str;
    }

    public void setPrefix(String str) {
        this.c = str;
    }

    /* loaded from: classes6.dex */
    public final class TimeResult {

        /* renamed from: a  reason: collision with root package name */
        long f2020a = 0;

        /* renamed from: b  reason: collision with root package name */
        long f2021b = 0;
        long c = 0;
        int d = 0;

        public TimeResult() {
        }

        public long getStartTime() {
            return this.f2020a;
        }

        public long getEndTime() {
            return this.f2021b;
        }

        public long getDurationMesc() {
            return this.f2021b - this.f2020a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.f2019b, buildLog);
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
            LogUtil.v(ConsumeTimeUtils.this.f2019b, buildLog());
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.f2019b, buildLog());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.f2019b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.f2019b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.f2019b, buildLog(), new Throwable());
        }
    }
}
