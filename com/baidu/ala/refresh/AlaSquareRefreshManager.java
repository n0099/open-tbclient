package com.baidu.ala.refresh;

import android.os.Handler;
/* loaded from: classes10.dex */
public class AlaSquareRefreshManager {
    private long[] mCurRefreshTimes;
    private Handler mHandler;
    private long[] mPageRefreshInterval;
    private RefreshRunnable[] mPageRefreshRunnables;
    private ISquareRefreshHandler mSquareRefreshHandler;

    public void init(ISquareRefreshHandler iSquareRefreshHandler, long[] jArr) {
        if (iSquareRefreshHandler != null && jArr != null && jArr.length != 0) {
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
    }

    public void reset(int i) {
        if (checkIndex(i)) {
            this.mHandler.removeCallbacks(this.mPageRefreshRunnables[i]);
            this.mPageRefreshRunnables[i].postDelay();
        }
    }

    public void onPageForeground(int i) {
        if (checkIndex(i)) {
            long currentTimeMillis = System.currentTimeMillis() - this.mCurRefreshTimes[i];
            if (currentTimeMillis > this.mPageRefreshInterval[i]) {
                this.mPageRefreshRunnables[i].post();
            } else {
                this.mPageRefreshRunnables[i].postDelay(currentTimeMillis);
            }
        }
    }

    public void onPause() {
        for (RefreshRunnable refreshRunnable : this.mPageRefreshRunnables) {
            this.mHandler.removeCallbacks(refreshRunnable);
        }
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mPageRefreshRunnables = null;
        this.mPageRefreshInterval = null;
        this.mCurRefreshTimes = null;
    }

    private void createPageRefreshRunnables() {
        int length = this.mPageRefreshInterval.length;
        this.mPageRefreshRunnables = new RefreshRunnable[this.mPageRefreshInterval.length];
        for (int i = 0; i < length; i++) {
            RefreshRunnable refreshRunnable = new RefreshRunnable(i, getTimeByIndex(this.mPageRefreshInterval, i));
            refreshRunnable.postDelay();
            this.mPageRefreshRunnables[i] = refreshRunnable;
        }
    }

    private void releasePageRefreshRunnables() {
        int length = this.mPageRefreshRunnables.length;
        for (int i = 0; i < length; i++) {
            this.mHandler.removeCallbacks(this.mPageRefreshRunnables[i]);
        }
    }

    private long getTimeByIndex(long[] jArr, int i) {
        if (jArr == null || i < 0 || jArr.length <= i) {
            return -1L;
        }
        return jArr[i];
    }

    private boolean checkIndex(int i) {
        return i >= 0 && this.mPageRefreshInterval != null && this.mPageRefreshInterval.length > i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class RefreshRunnable implements Runnable {
        private int mIndex;
        private long mInterval;

        public RefreshRunnable(int i, long j) {
            this.mIndex = 0;
            this.mInterval = 0L;
            this.mIndex = i;
            this.mInterval = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaSquareRefreshManager.this.mSquareRefreshHandler != null && AlaSquareRefreshManager.this.mSquareRefreshHandler.isForeGround(this.mIndex)) {
                AlaSquareRefreshManager.this.mCurRefreshTimes[this.mIndex] = System.currentTimeMillis();
                AlaSquareRefreshManager.this.mSquareRefreshHandler.startRefresh(this.mIndex);
                postDelay();
            }
        }

        public void postDelay() {
            if (this.mInterval > 0) {
                AlaSquareRefreshManager.this.mHandler.removeCallbacks(this);
                AlaSquareRefreshManager.this.mHandler.postDelayed(this, this.mInterval);
            }
        }

        public void postDelay(long j) {
            if (this.mInterval > 0) {
                AlaSquareRefreshManager.this.mHandler.removeCallbacks(this);
                AlaSquareRefreshManager.this.mHandler.postDelayed(this, j);
            }
        }

        public void post() {
            if (this.mInterval > 0) {
                AlaSquareRefreshManager.this.mHandler.removeCallbacks(this);
                AlaSquareRefreshManager.this.mHandler.post(this);
            }
        }
    }
}
