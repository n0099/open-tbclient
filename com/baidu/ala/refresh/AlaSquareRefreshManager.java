package com.baidu.ala.refresh;

import android.os.Handler;
/* loaded from: classes.dex */
public class AlaSquareRefreshManager {
    public long[] mCurRefreshTimes;
    public Handler mHandler;
    public long[] mPageRefreshInterval;
    public RefreshRunnable[] mPageRefreshRunnables;
    public ISquareRefreshHandler mSquareRefreshHandler;

    private boolean checkIndex(int i2) {
        long[] jArr;
        return i2 >= 0 && (jArr = this.mPageRefreshInterval) != null && jArr.length > i2;
    }

    private void createPageRefreshRunnables() {
        long[] jArr = this.mPageRefreshInterval;
        int length = jArr.length;
        this.mPageRefreshRunnables = new RefreshRunnable[jArr.length];
        for (int i2 = 0; i2 < length; i2++) {
            RefreshRunnable refreshRunnable = new RefreshRunnable(i2, getTimeByIndex(this.mPageRefreshInterval, i2));
            refreshRunnable.postDelay();
            this.mPageRefreshRunnables[i2] = refreshRunnable;
        }
    }

    private long getTimeByIndex(long[] jArr, int i2) {
        if (jArr == null || i2 < 0 || jArr.length <= i2) {
            return -1L;
        }
        return jArr[i2];
    }

    private void releasePageRefreshRunnables() {
        int length = this.mPageRefreshRunnables.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.mHandler.removeCallbacks(this.mPageRefreshRunnables[i2]);
        }
    }

    public void init(ISquareRefreshHandler iSquareRefreshHandler, long[] jArr) {
        if (iSquareRefreshHandler == null || jArr == null || jArr.length == 0) {
            return;
        }
        this.mSquareRefreshHandler = iSquareRefreshHandler;
        if (this.mHandler == null) {
            this.mHandler = new Handler();
        }
        if (this.mPageRefreshInterval != null) {
            releasePageRefreshRunnables();
        }
        this.mPageRefreshInterval = jArr;
        this.mCurRefreshTimes = new long[jArr.length];
        if (this.mPageRefreshRunnables == null) {
            createPageRefreshRunnables();
        }
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mPageRefreshRunnables = null;
        this.mPageRefreshInterval = null;
        this.mCurRefreshTimes = null;
    }

    public void onPageForeground(int i2) {
        if (checkIndex(i2)) {
            long currentTimeMillis = System.currentTimeMillis() - this.mCurRefreshTimes[i2];
            if (currentTimeMillis > this.mPageRefreshInterval[i2]) {
                this.mPageRefreshRunnables[i2].post();
            } else {
                this.mPageRefreshRunnables[i2].postDelay(currentTimeMillis);
            }
        }
    }

    public void onPause() {
        for (RefreshRunnable refreshRunnable : this.mPageRefreshRunnables) {
            this.mHandler.removeCallbacks(refreshRunnable);
        }
    }

    public void reset(int i2) {
        if (checkIndex(i2)) {
            this.mHandler.removeCallbacks(this.mPageRefreshRunnables[i2]);
            this.mPageRefreshRunnables[i2].postDelay();
        }
    }

    /* loaded from: classes.dex */
    public class RefreshRunnable implements Runnable {
        public int mIndex;
        public long mInterval;

        public RefreshRunnable(int i2, long j) {
            this.mIndex = 0;
            this.mInterval = 0L;
            this.mIndex = i2;
            this.mInterval = j;
        }

        public void post() {
            if (this.mInterval > 0) {
                AlaSquareRefreshManager.this.mHandler.removeCallbacks(this);
                AlaSquareRefreshManager.this.mHandler.post(this);
            }
        }

        public void postDelay() {
            if (this.mInterval > 0) {
                AlaSquareRefreshManager.this.mHandler.removeCallbacks(this);
                AlaSquareRefreshManager.this.mHandler.postDelayed(this, this.mInterval);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaSquareRefreshManager.this.mSquareRefreshHandler == null || !AlaSquareRefreshManager.this.mSquareRefreshHandler.isForeGround(this.mIndex)) {
                return;
            }
            AlaSquareRefreshManager.this.mCurRefreshTimes[this.mIndex] = System.currentTimeMillis();
            AlaSquareRefreshManager.this.mSquareRefreshHandler.startRefresh(this.mIndex);
            postDelay();
        }

        public void postDelay(long j) {
            if (this.mInterval > 0) {
                AlaSquareRefreshManager.this.mHandler.removeCallbacks(this);
                AlaSquareRefreshManager.this.mHandler.postDelayed(this, j);
            }
        }
    }
}
