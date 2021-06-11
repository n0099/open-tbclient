package com.baidu.apollon.utils;

import android.os.SystemClock;
/* loaded from: classes.dex */
public class ConsumeTimeUtils {

    /* renamed from: a  reason: collision with root package name */
    public TimeResult f4044a;

    /* renamed from: b  reason: collision with root package name */
    public String f4045b = "ConsumeTime";

    /* renamed from: c  reason: collision with root package name */
    public String f4046c;

    /* loaded from: classes.dex */
    public final class TimeResult {

        /* renamed from: a  reason: collision with root package name */
        public long f4047a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f4048b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f4049c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f4050d = 0;

        public TimeResult() {
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.f4046c != null) {
                sb.append(ConsumeTimeUtils.this.f4046c + ":");
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public long getDurationMesc() {
            return this.f4048b - this.f4047a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public long getEndTime() {
            return this.f4048b;
        }

        public long getStartTime() {
            return this.f4047a;
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.f4045b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.f4045b, buildLog(), new Throwable());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.f4045b, buildLog());
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.f4045b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.f4045b, buildLog());
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.f4045b, buildLog);
            return buildLog;
        }
    }

    public TimeResult finish() {
        this.f4044a.f4048b = SystemClock.uptimeMillis();
        return this.f4044a;
    }

    public void setPrefix(String str) {
        this.f4046c = str;
    }

    public void setTAGString(String str) {
        this.f4045b = str;
    }

    public ConsumeTimeUtils start() {
        TimeResult timeResult = new TimeResult();
        this.f4044a = timeResult;
        timeResult.f4047a = SystemClock.uptimeMillis();
        return this;
    }
}
