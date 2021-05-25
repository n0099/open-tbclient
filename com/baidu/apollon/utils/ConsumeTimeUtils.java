package com.baidu.apollon.utils;

import android.os.SystemClock;
/* loaded from: classes.dex */
public class ConsumeTimeUtils {

    /* renamed from: a  reason: collision with root package name */
    public TimeResult f4025a;

    /* renamed from: b  reason: collision with root package name */
    public String f4026b = "ConsumeTime";

    /* renamed from: c  reason: collision with root package name */
    public String f4027c;

    /* loaded from: classes.dex */
    public final class TimeResult {

        /* renamed from: a  reason: collision with root package name */
        public long f4028a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f4029b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f4030c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f4031d = 0;

        public TimeResult() {
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.f4027c != null) {
                sb.append(ConsumeTimeUtils.this.f4027c + ":");
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public long getDurationMesc() {
            return this.f4029b - this.f4028a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public long getEndTime() {
            return this.f4029b;
        }

        public long getStartTime() {
            return this.f4028a;
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.f4026b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.f4026b, buildLog(), new Throwable());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.f4026b, buildLog());
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.f4026b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.f4026b, buildLog());
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.f4026b, buildLog);
            return buildLog;
        }
    }

    public TimeResult finish() {
        this.f4025a.f4029b = SystemClock.uptimeMillis();
        return this.f4025a;
    }

    public void setPrefix(String str) {
        this.f4027c = str;
    }

    public void setTAGString(String str) {
        this.f4026b = str;
    }

    public ConsumeTimeUtils start() {
        TimeResult timeResult = new TimeResult();
        this.f4025a = timeResult;
        timeResult.f4028a = SystemClock.uptimeMillis();
        return this;
    }
}
