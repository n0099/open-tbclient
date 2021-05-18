package com.baidu.fsg.base.utils;

import android.os.SystemClock;
/* loaded from: classes2.dex */
public class ConsumeTimeUtils {

    /* renamed from: a  reason: collision with root package name */
    public TimeResult f5373a;

    /* renamed from: b  reason: collision with root package name */
    public String f5374b = "ConsumeTime";

    /* renamed from: c  reason: collision with root package name */
    public String f5375c;

    /* loaded from: classes2.dex */
    public final class TimeResult {

        /* renamed from: a  reason: collision with root package name */
        public long f5376a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f5377b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f5378c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f5379d = 0;

        public TimeResult() {
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.f5375c != null) {
                sb.append(ConsumeTimeUtils.this.f5375c + ":");
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public long getDurationMesc() {
            return this.f5377b - this.f5376a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public long getEndTime() {
            return this.f5377b;
        }

        public long getStartTime() {
            return this.f5376a;
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.f5374b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.f5374b, buildLog(), new Throwable());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.f5374b, buildLog());
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.f5374b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.f5374b, buildLog());
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.f5374b, buildLog);
            return buildLog;
        }
    }

    public TimeResult finish() {
        this.f5373a.f5377b = SystemClock.uptimeMillis();
        return this.f5373a;
    }

    public void setPrefix(String str) {
        this.f5375c = str;
    }

    public void setTAGString(String str) {
        this.f5374b = str;
    }

    public ConsumeTimeUtils start() {
        TimeResult timeResult = new TimeResult();
        this.f5373a = timeResult;
        timeResult.f5376a = SystemClock.uptimeMillis();
        return this;
    }
}
