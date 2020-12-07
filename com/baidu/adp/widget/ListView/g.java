package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
import com.baidu.adp.widget.ListView.d;
/* loaded from: classes.dex */
public class g {
    private com.baidu.adp.widget.b.a Xb;
    private d.a Xc;
    a Xe;
    private boolean isReadyToStart;
    int mDuration;
    private int mToPadding;
    View mView;
    private int mStep = 1;
    Handler mHandler = new Handler();
    Runnable endAnimationRun = new Runnable() { // from class: com.baidu.adp.widget.ListView.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.Xe == null) {
                return;
            }
            g.this.Xe.endAnimation();
        }
    };

    public g(Context context, int i, int i2, int i3) {
        this.isReadyToStart = true;
        int abs = Math.abs(i - i2);
        this.mToPadding = i2;
        if (abs < this.mStep) {
            this.isReadyToStart = false;
        }
        this.Xe = new a(context);
        this.mDuration = i3;
    }

    public void a(com.baidu.adp.widget.b.a aVar) {
        this.Xb = aVar;
    }

    public void a(d.a aVar) {
        this.Xc = aVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int mLastFlingY;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void startCommon() {
            if (g.this.mHandler != null) {
                g.this.mHandler.removeCallbacks(g.this.endAnimationRun);
            }
            if (g.this.mView != null) {
                g.this.mView.removeCallbacks(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = true;
            if (g.this.mView != null && this.mScroller != null) {
                boolean computeScrollOffset = this.mScroller.computeScrollOffset();
                if (this.mScroller.timePassed() >= g.this.mDuration) {
                    computeScrollOffset = false;
                }
                int currY = this.mScroller.getCurrY();
                int i = currY - this.mLastFlingY;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = g.this.move(i) ? false : true;
                        this.mLastFlingY = currY;
                    }
                    z = r1;
                    if (!z) {
                        g.this.mView.post(this);
                    }
                }
                if (z) {
                    g.this.mHandler.removeCallbacks(g.this.endAnimationRun);
                    g.this.mHandler.post(g.this.endAnimationRun);
                }
            }
        }

        public void startUsingDistance(int i, int i2) {
            if (g.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                startCommon();
                this.mLastFlingY = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                g.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void endAnimation() {
            g.this.mHandler.removeCallbacks(g.this.endAnimationRun);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (g.this.mView != null) {
                g.this.mView.removeCallbacks(this);
            }
            if (g.this.Xb != null) {
                g.this.Xb.onOver();
            }
        }
    }

    public void startAnimation(View view) {
        if (this.isReadyToStart && this.Xe != null) {
            this.mView = view;
            this.Xe.startUsingDistance(Math.abs(this.mToPadding), this.mDuration);
            this.mHandler.postDelayed(this.endAnimationRun, this.mDuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop > this.mToPadding) {
            z = true;
        } else {
            paddingTop = this.mToPadding;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        if (this.Xc != null) {
            this.Xc.a(null, this.mView.getPaddingLeft(), this.mView.getPaddingRight(), this.mView.getPaddingTop() - this.mToPadding, this.mView.getPaddingBottom());
        }
        return z;
    }
}
