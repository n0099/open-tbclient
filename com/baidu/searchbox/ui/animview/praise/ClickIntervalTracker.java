package com.baidu.searchbox.ui.animview.praise;

import android.util.Log;
import com.baidu.searchbox.ui.animview.util.DebugUtil;
/* loaded from: classes6.dex */
public class ClickIntervalTracker {
    private static final boolean DEBUG = DebugUtil.isApkInDebug();
    private static final String TAG = "ClickIntervalTracker";
    private long mInitialClickCounts;
    private long mLastClickTimeMs;
    private long mLastIntervalTimeMs = 2147483647L;
    private long mTotalClickCounts;

    /* loaded from: classes6.dex */
    public enum SpeedLevel {
        V0(-1, "NONE"),
        V1(1000, "V1"),
        V2(250, "V2"),
        V3(0, "V3");
        
        private String mInfo;
        private long mInterval;

        SpeedLevel(long j, String str) {
            this.mInterval = j;
            this.mInfo = str;
        }

        public long getInterval() {
            return this.mInterval;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.mInfo;
        }

        public static SpeedLevel instantiate(long j, long j2) {
            if (j2 == 1 || j2 % 10 == 0) {
                return V3;
            }
            if (j < V2.getInterval()) {
                return V2;
            }
            return V1;
        }
    }

    public void setInitialClickCounts(long j) {
        this.mInitialClickCounts = j;
    }

    public void addClick() {
        this.mLastIntervalTimeMs = System.currentTimeMillis() - this.mLastClickTimeMs;
        this.mTotalClickCounts++;
        this.mLastClickTimeMs = System.currentTimeMillis();
    }

    public SpeedLevel getSpeedLevel() {
        if (DEBUG) {
            Log.d(TAG, "LastIntervalTimeMs:" + this.mLastIntervalTimeMs + ", TotalClickCounts" + (this.mInitialClickCounts + this.mTotalClickCounts));
        }
        return SpeedLevel.instantiate(this.mLastIntervalTimeMs, this.mInitialClickCounts + this.mTotalClickCounts);
    }

    public void reset() {
        this.mTotalClickCounts = 0L;
        this.mLastClickTimeMs = 0L;
        this.mInitialClickCounts = 0L;
        this.mLastIntervalTimeMs = 2147483647L;
    }
}
