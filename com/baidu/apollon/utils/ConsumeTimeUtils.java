package com.baidu.apollon.utils;

import android.os.SystemClock;
/* loaded from: classes.dex */
public class ConsumeTimeUtils {

    /* renamed from: a  reason: collision with root package name */
    public TimeResult f3966a;

    /* renamed from: b  reason: collision with root package name */
    public String f3967b = "ConsumeTime";

    /* renamed from: c  reason: collision with root package name */
    public String f3968c;

    /* loaded from: classes.dex */
    public final class TimeResult {

        /* renamed from: a  reason: collision with root package name */
        public long f3969a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f3970b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f3971c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f3972d = 0;

        public TimeResult() {
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.f3968c != null) {
                sb.append(ConsumeTimeUtils.this.f3968c + ":");
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public long getDurationMesc() {
            return this.f3970b - this.f3969a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public long getEndTime() {
            return this.f3970b;
        }

        public long getStartTime() {
            return this.f3969a;
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.f3967b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.f3967b, buildLog(), new Throwable());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.f3967b, buildLog());
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.f3967b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.f3967b, buildLog());
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.f3967b, buildLog);
            return buildLog;
        }
    }

    public TimeResult finish() {
        this.f3966a.f3970b = SystemClock.uptimeMillis();
        return this.f3966a;
    }

    public void setPrefix(String str) {
        this.f3968c = str;
    }

    public void setTAGString(String str) {
        this.f3967b = str;
    }

    public ConsumeTimeUtils start() {
        TimeResult timeResult = new TimeResult();
        this.f3966a = timeResult;
        timeResult.f3969a = SystemClock.uptimeMillis();
        return this;
    }
}
