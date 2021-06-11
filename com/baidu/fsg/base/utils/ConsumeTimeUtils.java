package com.baidu.fsg.base.utils;

import android.os.SystemClock;
/* loaded from: classes2.dex */
public class ConsumeTimeUtils {

    /* renamed from: a  reason: collision with root package name */
    public TimeResult f5316a;

    /* renamed from: b  reason: collision with root package name */
    public String f5317b = "ConsumeTime";

    /* renamed from: c  reason: collision with root package name */
    public String f5318c;

    /* loaded from: classes2.dex */
    public final class TimeResult {

        /* renamed from: a  reason: collision with root package name */
        public long f5319a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f5320b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f5321c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f5322d = 0;

        public TimeResult() {
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.f5318c != null) {
                sb.append(ConsumeTimeUtils.this.f5318c + ":");
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public long getDurationMesc() {
            return this.f5320b - this.f5319a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public long getEndTime() {
            return this.f5320b;
        }

        public long getStartTime() {
            return this.f5319a;
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.f5317b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.f5317b, buildLog(), new Throwable());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.f5317b, buildLog());
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.f5317b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.f5317b, buildLog());
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.f5317b, buildLog);
            return buildLog;
        }
    }

    public TimeResult finish() {
        this.f5316a.f5320b = SystemClock.uptimeMillis();
        return this.f5316a;
    }

    public void setPrefix(String str) {
        this.f5318c = str;
    }

    public void setTAGString(String str) {
        this.f5317b = str;
    }

    public ConsumeTimeUtils start() {
        TimeResult timeResult = new TimeResult();
        this.f5316a = timeResult;
        timeResult.f5319a = SystemClock.uptimeMillis();
        return this;
    }
}
