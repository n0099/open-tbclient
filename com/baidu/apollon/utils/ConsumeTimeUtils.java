package com.baidu.apollon.utils;

import android.os.SystemClock;
/* loaded from: classes.dex */
public class ConsumeTimeUtils {

    /* renamed from: a  reason: collision with root package name */
    public TimeResult f3931a;

    /* renamed from: b  reason: collision with root package name */
    public String f3932b = "ConsumeTime";

    /* renamed from: c  reason: collision with root package name */
    public String f3933c;

    /* loaded from: classes.dex */
    public final class TimeResult {

        /* renamed from: a  reason: collision with root package name */
        public long f3934a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f3935b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f3936c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f3937d = 0;

        public TimeResult() {
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.f3933c != null) {
                sb.append(ConsumeTimeUtils.this.f3933c + ":");
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public long getDurationMesc() {
            return this.f3935b - this.f3934a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public long getEndTime() {
            return this.f3935b;
        }

        public long getStartTime() {
            return this.f3934a;
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.f3932b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.f3932b, buildLog(), new Throwable());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.f3932b, buildLog());
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.f3932b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.f3932b, buildLog());
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.f3932b, buildLog);
            return buildLog;
        }
    }

    public TimeResult finish() {
        this.f3931a.f3935b = SystemClock.uptimeMillis();
        return this.f3931a;
    }

    public void setPrefix(String str) {
        this.f3933c = str;
    }

    public void setTAGString(String str) {
        this.f3932b = str;
    }

    public ConsumeTimeUtils start() {
        TimeResult timeResult = new TimeResult();
        this.f3931a = timeResult;
        timeResult.f3934a = SystemClock.uptimeMillis();
        return this;
    }
}
