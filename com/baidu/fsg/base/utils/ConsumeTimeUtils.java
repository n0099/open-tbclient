package com.baidu.fsg.base.utils;

import android.os.SystemClock;
import com.baidu.ar.util.SystemInfoUtil;
/* loaded from: classes2.dex */
public class ConsumeTimeUtils {
    TimeResult a;
    String b = "ConsumeTime";
    private String c;

    public ConsumeTimeUtils start() {
        this.a = new TimeResult();
        this.a.a = SystemClock.uptimeMillis();
        return this;
    }

    public TimeResult finish() {
        this.a.b = SystemClock.uptimeMillis();
        return this.a;
    }

    public void setTAGString(String str) {
        this.b = str;
    }

    public void setPrefix(String str) {
        this.c = str;
    }

    /* loaded from: classes2.dex */
    public final class TimeResult {
        long a = 0;
        long b = 0;
        long c = 0;
        int d = 0;

        public TimeResult() {
        }

        public long getStartTime() {
            return this.a;
        }

        public long getEndTime() {
            return this.b;
        }

        public long getDurationMesc() {
            return this.b - this.a;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.b, buildLog);
            return buildLog;
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.c != null) {
                sb.append(ConsumeTimeUtils.this.c + SystemInfoUtil.COLON);
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.b, buildLog());
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.b, buildLog());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.b, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.b, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.b, buildLog(), new Throwable());
        }
    }
}
