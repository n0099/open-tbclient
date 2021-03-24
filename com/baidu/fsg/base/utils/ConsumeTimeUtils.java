package com.baidu.fsg.base.utils;

import android.os.SystemClock;
/* loaded from: classes2.dex */
public class ConsumeTimeUtils {

    /* renamed from: a  reason: collision with root package name */
    public TimeResult f5345a;

    /* renamed from: b  reason: collision with root package name */
    public String f5346b = "ConsumeTime";

    /* renamed from: c  reason: collision with root package name */
    public String f5347c;

    /* loaded from: classes2.dex */
    public final class TimeResult {

        /* renamed from: a  reason: collision with root package name */
        public long f5348a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f5349b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f5350c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f5351d = 0;

        public TimeResult() {
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.f5347c != null) {
                sb.append(ConsumeTimeUtils.this.f5347c + ":");
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public long getDurationMesc() {
            return this.f5349b - this.f5348a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public long getEndTime() {
            return this.f5349b;
        }

        public long getStartTime() {
            return this.f5348a;
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.f5346b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.f5346b, buildLog(), new Throwable());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.f5346b, buildLog());
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.f5346b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.f5346b, buildLog());
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.f5346b, buildLog);
            return buildLog;
        }
    }

    public TimeResult finish() {
        this.f5345a.f5349b = SystemClock.uptimeMillis();
        return this.f5345a;
    }

    public void setPrefix(String str) {
        this.f5347c = str;
    }

    public void setTAGString(String str) {
        this.f5346b = str;
    }

    public ConsumeTimeUtils start() {
        TimeResult timeResult = new TimeResult();
        this.f5345a = timeResult;
        timeResult.f5348a = SystemClock.uptimeMillis();
        return this;
    }
}
