package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class f {
    private int LW;
    private com.baidu.adp.widget.a.a LX;
    private boolean LY;
    a LZ;
    int mDuration;
    View mView;
    private int LV = 1;
    Handler mHandler = new Handler();
    Runnable Ma = new Runnable() { // from class: com.baidu.adp.widget.ListView.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.LZ == null) {
                return;
            }
            f.this.LZ.nx();
        }
    };

    public f(Context context, int i, int i2, int i3) {
        this.LY = true;
        int abs = Math.abs(i - i2);
        this.LW = i2;
        if (abs < this.LV) {
            this.LY = false;
        }
        this.LZ = new a(context);
        this.mDuration = i3;
    }

    public void a(com.baidu.adp.widget.a.a aVar) {
        this.LX = aVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int mLastFlingY;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void nw() {
            if (f.this.mHandler != null) {
                f.this.mHandler.removeCallbacks(f.this.Ma);
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
                    f.this.mHandler.removeCallbacks(f.this.Ma);
                    f.this.mHandler.post(f.this.Ma);
                }
            }
        }

        public void p(int i, int i2) {
            if (f.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                nw();
                this.mLastFlingY = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                f.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void nx() {
            f.this.mHandler.removeCallbacks(f.this.Ma);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (f.this.mView != null) {
                f.this.mView.removeCallbacks(this);
            }
            if (f.this.LX != null) {
                f.this.LX.onOver();
            }
        }
    }

    public void r(View view) {
        if (this.LY && this.LZ != null) {
            this.mView = view;
            this.LZ.p(Math.abs(this.LW), this.mDuration);
            this.mHandler.postDelayed(this.Ma, this.mDuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.LW) {
            paddingTop = this.LW;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
