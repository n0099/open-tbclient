package com.baidu.fsg.base.restnet.beans.business.core.utils;

import android.os.SystemClock;
import com.baidu.fsg.base.utils.LogUtil;
/* loaded from: classes2.dex */
public class ConsumeTimeUtils {
    public String mTAG = "ConsumeTime";
    public TimeResult mTimeResult;
    public String prefix;

    /* loaded from: classes2.dex */
    public final class TimeResult {
        public long startTime = 0;
        public long endTime = 0;
        public long durationMesc = 0;
        public int durationSecond = 0;

        public TimeResult() {
        }

        public String buildLog() {
            StringBuilder sb = new StringBuilder();
            if (ConsumeTimeUtils.this.prefix != null) {
                sb.append(ConsumeTimeUtils.this.prefix + ":");
            }
            sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
            return sb.toString();
        }

        public long getDurationMesc() {
            return this.endTime - this.startTime;
        }

        public int getDurationSecond() {
            return (int) (getDurationMesc() / 1000);
        }

        public long getEndTime() {
            return this.endTime;
        }

        public long getStartTime() {
            return this.startTime;
        }

        public void logd() {
            LogUtil.d(ConsumeTimeUtils.this.mTAG, buildLog());
        }

        public void loge() {
            LogUtil.e(ConsumeTimeUtils.this.mTAG, buildLog(), new Throwable());
        }

        public void logi() {
            LogUtil.i(ConsumeTimeUtils.this.mTAG, buildLog());
        }

        public void logv() {
            LogUtil.v(ConsumeTimeUtils.this.mTAG, buildLog());
        }

        public void logw() {
            LogUtil.w(ConsumeTimeUtils.this.mTAG, buildLog());
        }

        public String toString() {
            String buildLog = buildLog();
            LogUtil.v(ConsumeTimeUtils.this.mTAG, buildLog);
            return buildLog;
        }
    }

    public TimeResult finish() {
        this.mTimeResult.endTime = SystemClock.uptimeMillis();
        return this.mTimeResult;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public void setTAGString(String str) {
        this.mTAG = str;
    }

    public ConsumeTimeUtils start() {
        TimeResult timeResult = new TimeResult();
        this.mTimeResult = timeResult;
        timeResult.startTime = SystemClock.uptimeMillis();
        return this;
    }
}
