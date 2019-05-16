package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
import com.baidu.adp.widget.ListView.c;
/* loaded from: classes.dex */
public class f {
    private int MV;
    private com.baidu.adp.widget.b.a MW;
    private c.a MX;
    private boolean MY;
    a MZ;
    int mDuration;
    View mView;
    private int MU = 1;
    Handler mHandler = new Handler();
    Runnable Na = new Runnable() { // from class: com.baidu.adp.widget.ListView.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.MZ == null) {
                return;
            }
            f.this.MZ.nM();
        }
    };

    public f(Context context, int i, int i2, int i3) {
        this.MY = true;
        int abs = Math.abs(i - i2);
        this.MV = i2;
        if (abs < this.MU) {
            this.MY = false;
        }
        this.MZ = new a(context);
        this.mDuration = i3;
    }

    public void a(com.baidu.adp.widget.b.a aVar) {
        this.MW = aVar;
    }

    public void a(c.a aVar) {
        this.MX = aVar;
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
                f.this.mHandler.removeCallbacks(f.this.Na);
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
                    f.this.mHandler.removeCallbacks(f.this.Na);
                    f.this.mHandler.post(f.this.Na);
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
            f.this.mHandler.removeCallbacks(f.this.Na);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (f.this.mView != null) {
                f.this.mView.removeCallbacks(this);
            }
            if (f.this.MW != null) {
                f.this.MW.onOver();
            }
        }
    }

    public void B(View view) {
        if (this.MY && this.MZ != null) {
            this.mView = view;
            this.MZ.p(Math.abs(this.MV), this.mDuration);
            this.mHandler.postDelayed(this.Na, this.mDuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop > this.MV) {
            z = true;
        } else {
            paddingTop = this.MV;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        if (this.MX != null) {
            this.MX.a(null, this.mView.getPaddingLeft(), this.mView.getPaddingRight(), this.mView.getPaddingTop() - this.MV, this.mView.getPaddingBottom());
        }
        return z;
    }
}
