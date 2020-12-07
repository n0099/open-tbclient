package com.baidu.searchbox.ui.animview.praise;
/* loaded from: classes6.dex */
public class ClickTracker {
    private int mClickCounts;
    private long mFirstClickTimeMs;
    private int mLastClickCounts;
    private int mTotalClickCounts;

    /* loaded from: classes6.dex */
    public enum SpeedLevel {
        V0(-1, "NONE"),
        V1(5, "V1"),
        V2(10, "V2"),
        V3(Long.MAX_VALUE, "V3");
        
        private String mInfo;
        private long mMaxCounts;

        SpeedLevel(long j, String str) {
            this.mMaxCounts = j;
            this.mInfo = str;
        }

        public long getMaxLevelCounts() {
            return this.mMaxCounts;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.mInfo;
        }

        public static SpeedLevel instantiate(long j, long j2) {
            if (j2 == 10 || j2 == 100 || j2 == 500 || j2 == 1000 || j2 == 1500) {
                return V3;
            }
            if (j <= V1.getMaxLevelCounts()) {
                return V1;
            }
            return V2;
        }
    }

    public void addClick() {
        resetClickCountsIfNeeded();
        this.mClickCounts++;
        this.mTotalClickCounts++;
    }

    public SpeedLevel getSpeedLevel() {
        return SpeedLevel.instantiate(this.mLastClickCounts, this.mTotalClickCounts);
    }

    public void reset() {
        this.mFirstClickTimeMs = 0L;
        this.mClickCounts = 0;
        this.mLastClickCounts = 0;
        this.mTotalClickCounts = 0;
    }

    private void resetClickCountsIfNeeded() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mFirstClickTimeMs >= 1000) {
            this.mFirstClickTimeMs = currentTimeMillis;
            this.mLastClickCounts = this.mClickCounts;
            this.mClickCounts = 0;
        }
    }
}
