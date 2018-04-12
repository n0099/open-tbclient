package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class f {
    private int FO;
    private com.baidu.adp.widget.a.a FP;
    private boolean FQ;
    a FR;
    int mDuration;
    View mView;
    private int FN = 1;
    Handler mHandler = new Handler();
    Runnable FT = new Runnable() { // from class: com.baidu.adp.widget.ListView.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.FR == null) {
                return;
            }
            f.this.FR.kK();
        }
    };

    public f(Context context, int i, int i2, int i3) {
        this.FQ = true;
        int abs = Math.abs(i - i2);
        this.FO = i2;
        if (abs < this.FN) {
            this.FQ = false;
        }
        this.FR = new a(context);
        this.mDuration = i3;
    }

    public void a(com.baidu.adp.widget.a.a aVar) {
        this.FP = aVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int mLastFlingY;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void kJ() {
            if (f.this.mHandler != null) {
                f.this.mHandler.removeCallbacks(f.this.FT);
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
                    f.this.mHandler.removeCallbacks(f.this.FT);
                    f.this.mHandler.post(f.this.FT);
                }
            }
        }

        public void p(int i, int i2) {
            if (f.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                kJ();
                this.mLastFlingY = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                f.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void kK() {
            f.this.mHandler.removeCallbacks(f.this.FT);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (f.this.mView != null) {
                f.this.mView.removeCallbacks(this);
            }
            if (f.this.FP != null) {
                f.this.FP.onOver();
            }
        }
    }

    public void r(View view2) {
        if (this.FQ && this.FR != null) {
            this.mView = view2;
            this.FR.p(Math.abs(this.FO), this.mDuration);
            this.mHandler.postDelayed(this.FT, this.mDuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.FO) {
            paddingTop = this.FO;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
