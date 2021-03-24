package com.baidu.apollon.utils;

import android.os.SystemClock;
/* loaded from: classes2.dex */
public class ConsumeTimeUtils {

    /* renamed from: a  reason: collision with root package name */
    public TimeResult f3930a;

    /* renamed from: b  reason: collision with root package name */
    public String f3931b = "ConsumeTime";

    /* renamed from: c  reason: collision with root package name */
    public String f3932c;

    /* loaded from: classes2.dex */
    public final class TimeResult {

        /* renamed from: a  reason: collision with root package name */
        public long f3933a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f3934b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f3935c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f3936d = 0;

        public TimeResult() {
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.f3932c != null) {
                sb.append(ConsumeTimeUtils.this.f3932c + ":");
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public long getDurationMesc() {
            return this.f3934b - this.f3933a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public long getEndTime() {
            return this.f3934b;
        }

        public long getStartTime() {
            return this.f3933a;
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.f3931b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.f3931b, buildLog(), new Throwable());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.f3931b, buildLog());
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.f3931b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.f3931b, buildLog());
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.f3931b, buildLog);
            return buildLog;
        }
    }

    public TimeResult finish() {
        this.f3930a.f3934b = SystemClock.uptimeMillis();
        return this.f3930a;
    }

    public void setPrefix(String str) {
        this.f3932c = str;
    }

    public void setTAGString(String str) {
        this.f3931b = str;
    }

    public ConsumeTimeUtils start() {
        TimeResult timeResult = new TimeResult();
        this.f3930a = timeResult;
        timeResult.f3933a = SystemClock.uptimeMillis();
        return this;
    }
}
