package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
import com.baidu.adp.widget.ListView.c;
/* loaded from: classes.dex */
public class f {
    private int MU;
    private com.baidu.adp.widget.b.a MV;
    private c.a MW;
    private boolean MX;
    a MY;
    int mDuration;
    View mView;
    private int MT = 1;
    Handler mHandler = new Handler();
    Runnable MZ = new Runnable() { // from class: com.baidu.adp.widget.ListView.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.MY == null) {
                return;
            }
            f.this.MY.nM();
        }
    };

    public f(Context context, int i, int i2, int i3) {
        this.MX = true;
        int abs = Math.abs(i - i2);
        this.MU = i2;
        if (abs < this.MT) {
            this.MX = false;
        }
        this.MY = new a(context);
        this.mDuration = i3;
    }

    public void a(com.baidu.adp.widget.b.a aVar) {
        this.MV = aVar;
    }

    public void a(c.a aVar) {
        this.MW = aVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int mLastFlingY;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void nL() {
            if (f.this.mHandler != null) {
                f.this.mHandler.removeCallbacks(f.this.MZ);
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
                    f.this.mHandler.removeCallbacks(f.this.MZ);
                    f.this.mHandler.post(f.this.MZ);
                }
            }
        }

        public void p(int i, int i2) {
            if (f.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                nL();
                this.mLastFlingY = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                f.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void nM() {
            f.this.mHandler.removeCallbacks(f.this.MZ);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (f.this.mView != null) {
                f.this.mView.removeCallbacks(this);
            }
            if (f.this.MV != null) {
                f.this.MV.onOver();
            }
        }
    }

    public void B(View view) {
        if (this.MX && this.MY != null) {
            this.mView = view;
            this.MY.p(Math.abs(this.MU), this.mDuration);
            this.mHandler.postDelayed(this.MZ, this.mDuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop > this.MU) {
            z = true;
        } else {
            paddingTop = this.MU;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        if (this.MW != null) {
            this.MW.a(null, this.mView.getPaddingLeft(), this.mView.getPaddingRight(), this.mView.getPaddingTop() - this.MU, this.mView.getPaddingBottom());
        }
        return z;
    }
}
