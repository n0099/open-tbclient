package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
import com.baidu.adp.widget.ListView.c;
/* loaded from: classes.dex */
public class f {
    private com.baidu.adp.widget.b.a Uo;
    private c.a Up;
    a Uq;
    private boolean isReadyToStart;
    int mDuration;
    private int mToPadding;
    View mView;
    private int mStep = 1;
    Handler mHandler = new Handler();
    Runnable endAnimationRun = new Runnable() { // from class: com.baidu.adp.widget.ListView.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.Uq == null) {
                return;
            }
            f.this.Uq.endAnimation();
        }
    };

    public f(Context context, int i, int i2, int i3) {
        this.isReadyToStart = true;
        int abs = Math.abs(i - i2);
        this.mToPadding = i2;
        if (abs < this.mStep) {
            this.isReadyToStart = false;
        }
        this.Uq = new a(context);
        this.mDuration = i3;
    }

    public void a(com.baidu.adp.widget.b.a aVar) {
        this.Uo = aVar;
    }

    public void a(c.a aVar) {
        this.Up = aVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int mLastFlingY;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void startCommon() {
            if (f.this.mHandler != null) {
                f.this.mHandler.removeCallbacks(f.this.endAnimationRun);
            }
            if (f.this.mView != null) {
                f.this.mView.removeCallbacks(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = true;
            if (f.this.mView != null && this.mScroller != null) {
                boolean computeScrollOffset = this.mScroller.computeScrollOffset();
                if (this.mScroller.timePassed() >= f.this.mDuration) {
                    computeScrollOffset = false;
                }
                int currY = this.mScroller.getCurrY();
                int i = currY - this.mLastFlingY;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = f.this.move(i) ? false : true;
                        this.mLastFlingY = currY;
                    }
                    z = r1;
                    if (!z) {
                        f.this.mView.post(this);
                    }
                }
                if (z) {
                    f.this.mHandler.removeCallbacks(f.this.endAnimationRun);
                    f.this.mHandler.post(f.this.endAnimationRun);
                }
            }
        }

        public void startUsingDistance(int i, int i2) {
            if (f.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                startCommon();
                this.mLastFlingY = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                f.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void endAnimation() {
            f.this.mHandler.removeCallbacks(f.this.endAnimationRun);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (f.this.mView != null) {
                f.this.mView.removeCallbacks(this);
            }
            if (f.this.Uo != null) {
                f.this.Uo.onOver();
            }
        }
    }

    public void startAnimation(View view) {
        if (this.isReadyToStart && this.Uq != null) {
            this.mView = view;
            this.Uq.startUsingDistance(Math.abs(this.mToPadding), this.mDuration);
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
        if (this.Up != null) {
            this.Up.a(null, this.mView.getPaddingLeft(), this.mView.getPaddingRight(), this.mView.getPaddingTop() - this.mToPadding, this.mView.getPaddingBottom());
        }
        return z;
    }
}
