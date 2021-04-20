package com.baidu.fsg.base.utils;

import android.os.SystemClock;
/* loaded from: classes2.dex */
public class ConsumeTimeUtils {

    /* renamed from: a  reason: collision with root package name */
    public TimeResult f5381a;

    /* renamed from: b  reason: collision with root package name */
    public String f5382b = "ConsumeTime";

    /* renamed from: c  reason: collision with root package name */
    public String f5383c;

    /* loaded from: classes2.dex */
    public final class TimeResult {

        /* renamed from: a  reason: collision with root package name */
        public long f5384a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f5385b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f5386c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f5387d = 0;

        public TimeResult() {
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.f5383c != null) {
                sb.append(ConsumeTimeUtils.this.f5383c + ":");
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public long getDurationMesc() {
            return this.f5385b - this.f5384a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public long getEndTime() {
            return this.f5385b;
        }

        public long getStartTime() {
            return this.f5384a;
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.f5382b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.f5382b, buildLog(), new Throwable());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.f5382b, buildLog());
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.f5382b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.f5382b, buildLog());
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.f5382b, buildLog);
            return buildLog;
        }
    }

    public TimeResult finish() {
        this.f5381a.f5385b = SystemClock.uptimeMillis();
        return this.f5381a;
    }

    public void setPrefix(String str) {
        this.f5383c = str;
    }

    public void setTAGString(String str) {
        this.f5382b = str;
    }

    public ConsumeTimeUtils start() {
        TimeResult timeResult = new TimeResult();
        this.f5381a = timeResult;
        timeResult.f5384a = SystemClock.uptimeMillis();
        return this;
    }
}
