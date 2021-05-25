package com.baidu.fsg.base.utils;

import android.os.SystemClock;
/* loaded from: classes2.dex */
public class ConsumeTimeUtils {

    /* renamed from: a  reason: collision with root package name */
    public TimeResult f5273a;

    /* renamed from: b  reason: collision with root package name */
    public String f5274b = "ConsumeTime";

    /* renamed from: c  reason: collision with root package name */
    public String f5275c;

    /* loaded from: classes2.dex */
    public final class TimeResult {

        /* renamed from: a  reason: collision with root package name */
        public long f5276a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f5277b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f5278c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f5279d = 0;

        public TimeResult() {
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.f5275c != null) {
                sb.append(ConsumeTimeUtils.this.f5275c + ":");
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public long getDurationMesc() {
            return this.f5277b - this.f5276a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public long getEndTime() {
            return this.f5277b;
        }

        public long getStartTime() {
            return this.f5276a;
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.f5274b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.f5274b, buildLog(), new Throwable());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.f5274b, buildLog());
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.f5274b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.f5274b, buildLog());
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.f5274b, buildLog);
            return buildLog;
        }
    }

    public TimeResult finish() {
        this.f5273a.f5277b = SystemClock.uptimeMillis();
        return this.f5273a;
    }

    public void setPrefix(String str) {
        this.f5275c = str;
    }

    public void setTAGString(String str) {
        this.f5274b = str;
    }

    public ConsumeTimeUtils start() {
        TimeResult timeResult = new TimeResult();
        this.f5273a = timeResult;
        timeResult.f5276a = SystemClock.uptimeMillis();
        return this;
    }
}
