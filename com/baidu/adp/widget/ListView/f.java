package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class f {
    private int FK;
    private com.baidu.adp.widget.a.a FL;
    private boolean FM;
    a FN;
    int mDuration;
    View mView;
    private int FJ = 1;
    Handler mHandler = new Handler();
    Runnable FO = new Runnable() { // from class: com.baidu.adp.widget.ListView.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.FN == null) {
                return;
            }
            f.this.FN.kJ();
        }
    };

    public f(Context context, int i, int i2, int i3) {
        this.FM = true;
        int abs = Math.abs(i - i2);
        this.FK = i2;
        if (abs < this.FJ) {
            this.FM = false;
        }
        this.FN = new a(context);
        this.mDuration = i3;
    }

    public void a(com.baidu.adp.widget.a.a aVar) {
        this.FL = aVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int mLastFlingY;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void kI() {
            if (f.this.mHandler != null) {
                f.this.mHandler.removeCallbacks(f.this.FO);
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
                    f.this.mHandler.removeCallbacks(f.this.FO);
                    f.this.mHandler.post(f.this.FO);
                }
            }
        }

        public void p(int i, int i2) {
            if (f.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                kI();
                this.mLastFlingY = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                f.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void kJ() {
            f.this.mHandler.removeCallbacks(f.this.FO);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (f.this.mView != null) {
                f.this.mView.removeCallbacks(this);
            }
            if (f.this.FL != null) {
                f.this.FL.onOver();
            }
        }
    }

    public void r(View view2) {
        if (this.FM && this.FN != null) {
            this.mView = view2;
            this.FN.p(Math.abs(this.FK), this.mDuration);
            this.mHandler.postDelayed(this.FO, this.mDuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.FK) {
            paddingTop = this.FK;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
