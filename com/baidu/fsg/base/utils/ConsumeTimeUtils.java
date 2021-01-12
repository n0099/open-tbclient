package com.baidu.fsg.base.utils;

import android.os.SystemClock;
/* loaded from: classes5.dex */
public class ConsumeTimeUtils {

    /* renamed from: a  reason: collision with root package name */
    TimeResult f1968a;

    /* renamed from: b  reason: collision with root package name */
    String f1969b = "ConsumeTime";
    private String c;

    public ConsumeTimeUtils start() {
        this.f1968a = new TimeResult();
        this.f1968a.f1970a = SystemClock.uptimeMillis();
        return this;
    }

    public TimeResult finish() {
        this.f1968a.f1971b = SystemClock.uptimeMillis();
        return this.f1968a;
    }

    public void setTAGString(String str) {
        this.f1969b = str;
    }

    public void setPrefix(String str) {
        this.c = str;
    }

    /* loaded from: classes5.dex */
    public final class TimeResult {

        /* renamed from: a  reason: collision with root package name */
        long f1970a = 0;

        /* renamed from: b  reason: collision with root package name */
        long f1971b = 0;
        long c = 0;
        int d = 0;

        public TimeResult() {
        }

        public long getStartTime() {
            return this.f1970a;
        }

        public long getEndTime() {
            return this.f1971b;
        }

        public long getDurationMesc() {
            return this.f1971b - this.f1970a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.f1969b, buildLog);
            return buildLog;
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.c != null) {
                sb.append(ConsumeTimeUtils.this.c + ":");
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.f1969b, buildLog());
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.f1969b, buildLog());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.f1969b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.f1969b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.f1969b, buildLog(), new Throwable());
        }
    }
}
