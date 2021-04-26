package com.baidu.fsg.base.utils;

import android.os.SystemClock;
/* loaded from: classes2.dex */
public class ConsumeTimeUtils {

    /* renamed from: a  reason: collision with root package name */
    public TimeResult f5519a;

    /* renamed from: b  reason: collision with root package name */
    public String f5520b = "ConsumeTime";

    /* renamed from: c  reason: collision with root package name */
    public String f5521c;

    /* loaded from: classes2.dex */
    public final class TimeResult {

        /* renamed from: a  reason: collision with root package name */
        public long f5522a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f5523b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f5524c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f5525d = 0;

        public TimeResult() {
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.f5521c != null) {
                sb.append(ConsumeTimeUtils.this.f5521c + ":");
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public long getDurationMesc() {
            return this.f5523b - this.f5522a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public long getEndTime() {
            return this.f5523b;
        }

        public long getStartTime() {
            return this.f5522a;
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.f5520b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.f5520b, buildLog(), new Throwable());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.f5520b, buildLog());
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.f5520b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.f5520b, buildLog());
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.f5520b, buildLog);
            return buildLog;
        }
    }

    public TimeResult finish() {
        this.f5519a.f5523b = SystemClock.uptimeMillis();
        return this.f5519a;
    }

    public void setPrefix(String str) {
        this.f5521c = str;
    }

    public void setTAGString(String str) {
        this.f5520b = str;
    }

    public ConsumeTimeUtils start() {
        TimeResult timeResult = new TimeResult();
        this.f5519a = timeResult;
        timeResult.f5522a = SystemClock.uptimeMillis();
        return this;
    }
}
