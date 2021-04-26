package com.baidu.apollon.utils;

import android.os.SystemClock;
/* loaded from: classes.dex */
public class ConsumeTimeUtils {

    /* renamed from: a  reason: collision with root package name */
    public TimeResult f4021a;

    /* renamed from: b  reason: collision with root package name */
    public String f4022b = "ConsumeTime";

    /* renamed from: c  reason: collision with root package name */
    public String f4023c;

    /* loaded from: classes.dex */
    public final class TimeResult {

        /* renamed from: a  reason: collision with root package name */
        public long f4024a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f4025b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f4026c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f4027d = 0;

        public TimeResult() {
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.f4023c != null) {
                sb.append(ConsumeTimeUtils.this.f4023c + ":");
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public long getDurationMesc() {
            return this.f4025b - this.f4024a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public long getEndTime() {
            return this.f4025b;
        }

        public long getStartTime() {
            return this.f4024a;
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.f4022b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.f4022b, buildLog(), new Throwable());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.f4022b, buildLog());
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.f4022b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.f4022b, buildLog());
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.f4022b, buildLog);
            return buildLog;
        }
    }

    public TimeResult finish() {
        this.f4021a.f4025b = SystemClock.uptimeMillis();
        return this.f4021a;
    }

    public void setPrefix(String str) {
        this.f4023c = str;
    }

    public void setTAGString(String str) {
        this.f4022b = str;
    }

    public ConsumeTimeUtils start() {
        TimeResult timeResult = new TimeResult();
        this.f4021a = timeResult;
        timeResult.f4024a = SystemClock.uptimeMillis();
        return this;
    }
}
