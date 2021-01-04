package com.baidu.live.adp.widget.listview;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
import com.baidu.live.adp.widget.scrollview.BdOnAnimationOverListener;
/* loaded from: classes11.dex */
public class BdPaddingAnimation4ListView {
    private boolean isReadyToStart;
    int mDuration;
    FlingRunnable mFlinger;
    private BdOnAnimationOverListener mOverListener;
    private int mToPadding;
    View mView;
    private int mStep = 1;
    Handler mHandler = new Handler();
    Runnable endAnimationRun = new Runnable() { // from class: com.baidu.live.adp.widget.listview.BdPaddingAnimation4ListView.1
        @Override // java.lang.Runnable
        public void run() {
            if (BdPaddingAnimation4ListView.this.mFlinger == null) {
                return;
            }
            BdPaddingAnimation4ListView.this.mFlinger.endAnimation();
        }
    };

    public BdPaddingAnimation4ListView(Context context, int i, int i2, int i3) {
        this.isReadyToStart = true;
        int abs = Math.abs(i - i2);
        this.mToPadding = i2;
        if (abs < this.mStep) {
            this.isReadyToStart = false;
        }
        this.mFlinger = new FlingRunnable(context);
        this.mDuration = i3;
    }

    public void setOnAnimationOverListener(BdOnAnimationOverListener bdOnAnimationOverListener) {
        this.mOverListener = bdOnAnimationOverListener;
    }

    /* loaded from: classes11.dex */
    class FlingRunnable implements Runnable {
        private int mLastFlingY;
        private Scroller mScroller;

        FlingRunnable(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void startCommon() {
            if (BdPaddingAnimation4ListView.this.mHandler != null) {
                BdPaddingAnimation4ListView.this.mHandler.removeCallbacks(BdPaddingAnimation4ListView.this.endAnimationRun);
            }
            if (BdPaddingAnimation4ListView.this.mView != null) {
                BdPaddingAnimation4ListView.this.mView.removeCallbacks(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = true;
            if (BdPaddingAnimation4ListView.this.mView != null && this.mScroller != null) {
                boolean computeScrollOffset = this.mScroller.computeScrollOffset();
                if (this.mScroller.timePassed() >= BdPaddingAnimation4ListView.this.mDuration) {
                    computeScrollOffset = false;
                }
                int currY = this.mScroller.getCurrY();
                int i = currY - this.mLastFlingY;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = BdPaddingAnimation4ListView.this.move(i) ? false : true;
                        this.mLastFlingY = currY;
                    }
                    z = r1;
                    if (!z) {
                        BdPaddingAnimation4ListView.this.mView.post(this);
                    }
                }
                if (z) {
                    BdPaddingAnimation4ListView.this.mHandler.removeCallbacks(BdPaddingAnimation4ListView.this.endAnimationRun);
                    BdPaddingAnimation4ListView.this.mHandler.post(BdPaddingAnimation4ListView.this.endAnimationRun);
                }
            }
        }

        public void startUsingDistance(int i, int i2) {
            if (BdPaddingAnimation4ListView.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                startCommon();
                this.mLastFlingY = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                BdPaddingAnimation4ListView.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void endAnimation() {
            BdPaddingAnimation4ListView.this.mHandler.removeCallbacks(BdPaddingAnimation4ListView.this.endAnimationRun);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (BdPaddingAnimation4ListView.this.mView != null) {
                BdPaddingAnimation4ListView.this.mView.removeCallbacks(this);
            }
            if (BdPaddingAnimation4ListView.this.mOverListener != null) {
                BdPaddingAnimation4ListView.this.mOverListener.onOver();
            }
        }
    }

    public void startAnimation(View view) {
        if (this.isReadyToStart && this.mFlinger != null) {
            this.mView = view;
            this.mFlinger.startUsingDistance(Math.abs(this.mToPadding), this.mDuration);
            this.mHandler.postDelayed(this.endAnimationRun, this.mDuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.mToPadding) {
            paddingTop = this.mToPadding;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
