package com.baidu.searchbox.ui.animview.praise;

import android.util.Log;
import com.baidu.searchbox.ui.animview.util.DebugUtil;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
/* loaded from: classes4.dex */
public class ClickIntervalTracker {
    public static final boolean DEBUG = DebugUtil.isApkInDebug();
    public static final String TAG = "ClickIntervalTracker";
    public long mInitialClickCounts;
    public long mLastClickTimeMs;
    public long mLastIntervalTimeMs = 2147483647L;
    public long mTotalClickCounts;

    public void addClick() {
        this.mLastIntervalTimeMs = System.currentTimeMillis() - this.mLastClickTimeMs;
        this.mTotalClickCounts++;
        this.mLastClickTimeMs = System.currentTimeMillis();
    }

    public void reset() {
        this.mTotalClickCounts = 0L;
        this.mLastClickTimeMs = 0L;
        this.mInitialClickCounts = 0L;
        this.mLastIntervalTimeMs = 2147483647L;
    }

    /* loaded from: classes4.dex */
    public enum SpeedLevel {
        V0(-1, HlsPlaylistParser.METHOD_NONE),
        V1(1000, "V1"),
        V2(250, "V2"),
        V3(0, "V3");
        
        public String mInfo;
        public long mInterval;

        SpeedLevel(long j, String str) {
            this.mInterval = j;
            this.mInfo = str;
        }

        public static SpeedLevel instantiate(long j, long j2) {
            if (j2 != 1 && j2 % 10 != 0) {
                if (j < V2.getInterval()) {
                    return V2;
                }
                return V1;
            }
            return V3;
        }

        public long getInterval() {
            return this.mInterval;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.mInfo;
        }
    }

    public SpeedLevel getSpeedLevel() {
        if (DEBUG) {
            Log.d(TAG, "LastIntervalTimeMs:" + this.mLastIntervalTimeMs + ", TotalClickCounts" + (this.mInitialClickCounts + this.mTotalClickCounts));
        }
        return SpeedLevel.instantiate(this.mLastIntervalTimeMs, this.mInitialClickCounts + this.mTotalClickCounts);
    }

    public void setInitialClickCounts(long j) {
        this.mInitialClickCounts = j;
    }
}
