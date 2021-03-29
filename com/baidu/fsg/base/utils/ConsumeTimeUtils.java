package com.baidu.fsg.base.utils;

import android.os.SystemClock;
/* loaded from: classes2.dex */
public class ConsumeTimeUtils {

    /* renamed from: a  reason: collision with root package name */
    public TimeResult f5346a;

    /* renamed from: b  reason: collision with root package name */
    public String f5347b = "ConsumeTime";

    /* renamed from: c  reason: collision with root package name */
    public String f5348c;

    /* loaded from: classes2.dex */
    public final class TimeResult {

        /* renamed from: a  reason: collision with root package name */
        public long f5349a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f5350b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f5351c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f5352d = 0;

        public TimeResult() {
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.f5348c != null) {
                sb.append(ConsumeTimeUtils.this.f5348c + ":");
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public long getDurationMesc() {
            return this.f5350b - this.f5349a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public long getEndTime() {
            return this.f5350b;
        }

        public long getStartTime() {
            return this.f5349a;
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.f5347b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.f5347b, buildLog(), new Throwable());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.f5347b, buildLog());
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.f5347b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.f5347b, buildLog());
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.f5347b, buildLog);
            return buildLog;
        }
    }

    public TimeResult finish() {
        this.f5346a.f5350b = SystemClock.uptimeMillis();
        return this.f5346a;
    }

    public void setPrefix(String str) {
        this.f5348c = str;
    }

    public void setTAGString(String str) {
        this.f5347b = str;
    }

    public ConsumeTimeUtils start() {
        TimeResult timeResult = new TimeResult();
        this.f5346a = timeResult;
        timeResult.f5349a = SystemClock.uptimeMillis();
        return this;
    }
}
