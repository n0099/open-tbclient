package com.baidu.fsg.base.restnet.beans.business.core.utils;

import android.os.SystemClock;
import com.baidu.fsg.base.utils.LogUtil;
/* loaded from: classes4.dex */
public class ConsumeTimeUtils {
    String mTAG = "ConsumeTime";
    TimeResult mTimeResult;
    private String prefix;

    public ConsumeTimeUtils start() {
        this.mTimeResult = new TimeResult();
        this.mTimeResult.startTime = SystemClock.uptimeMillis();
        return this;
    }

    public TimeResult finish() {
        this.mTimeResult.endTime = SystemClock.uptimeMillis();
        return this.mTimeResult;
    }

    public void setTAGString(String str) {
        this.mTAG = str;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    /* loaded from: classes4.dex */
    public final class TimeResult {
        long startTime = 0;
        long endTime = 0;
        long durationMesc = 0;
        int durationSecond = 0;

        public TimeResult() {
        }

        public long getStartTime() {
            return this.startTime;
        }

        public long getEndTime() {
            return this.endTime;
        }

        public long getDurationMesc() {
            return this.endTime - this.startTime;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.mTAG, buildLog);
            return buildLog;
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.prefix != null) {
                sb.append(ConsumeTimeUtils.this.prefix + ":");
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.mTAG, buildLog());
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.mTAG, buildLog());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.mTAG, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.mTAG, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.mTAG, buildLog(), new Throwable());
        }
    }
}
