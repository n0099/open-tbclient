package com.baidu.apollon.utils;

import android.os.SystemClock;
/* loaded from: classes.dex */
public class ConsumeTimeUtils {

    /* renamed from: a  reason: collision with root package name */
    public TimeResult f4022a;

    /* renamed from: b  reason: collision with root package name */
    public String f4023b = "ConsumeTime";

    /* renamed from: c  reason: collision with root package name */
    public String f4024c;

    /* loaded from: classes.dex */
    public final class TimeResult {

        /* renamed from: a  reason: collision with root package name */
        public long f4025a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f4026b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f4027c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f4028d = 0;

        public TimeResult() {
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.f4024c != null) {
                sb.append(ConsumeTimeUtils.this.f4024c + ":");
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public long getDurationMesc() {
            return this.f4026b - this.f4025a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public long getEndTime() {
            return this.f4026b;
        }

        public long getStartTime() {
            return this.f4025a;
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.f4023b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.f4023b, buildLog(), new Throwable());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.f4023b, buildLog());
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.f4023b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.f4023b, buildLog());
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.f4023b, buildLog);
            return buildLog;
        }
    }

    public TimeResult finish() {
        this.f4022a.f4026b = SystemClock.uptimeMillis();
        return this.f4022a;
    }

    public void setPrefix(String str) {
        this.f4024c = str;
    }

    public void setTAGString(String str) {
        this.f4023b = str;
    }

    public ConsumeTimeUtils start() {
        TimeResult timeResult = new TimeResult();
        this.f4022a = timeResult;
        timeResult.f4025a = SystemClock.uptimeMillis();
        return this;
    }
}
