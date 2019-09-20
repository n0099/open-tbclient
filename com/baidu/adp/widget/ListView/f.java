package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
import com.baidu.adp.widget.ListView.c;
/* loaded from: classes.dex */
public class f {
    private int Nm;
    private com.baidu.adp.widget.b.a Nn;
    private c.a No;
    private boolean Np;
    a Nq;
    int mDuration;
    View mView;
    private int Nl = 1;
    Handler mHandler = new Handler();
    Runnable Nr = new Runnable() { // from class: com.baidu.adp.widget.ListView.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.Nq == null) {
                return;
            }
            f.this.Nq.oj();
        }
    };

    public f(Context context, int i, int i2, int i3) {
        this.Np = true;
        int abs = Math.abs(i - i2);
        this.Nm = i2;
        if (abs < this.Nl) {
            this.Np = false;
        }
        this.Nq = new a(context);
        this.mDuration = i3;
    }

    public void a(com.baidu.adp.widget.b.a aVar) {
        this.Nn = aVar;
    }

    public void a(c.a aVar) {
        this.No = aVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int mLastFlingY;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void oi() {
            if (f.this.mHandler != null) {
                f.this.mHandler.removeCallbacks(f.this.Nr);
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
                    f.this.mHandler.removeCallbacks(f.this.Nr);
                    f.this.mHandler.post(f.this.Nr);
                }
            }
        }

        public void s(int i, int i2) {
            if (f.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                oi();
                this.mLastFlingY = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                f.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void oj() {
            f.this.mHandler.removeCallbacks(f.this.Nr);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (f.this.mView != null) {
                f.this.mView.removeCallbacks(this);
            }
            if (f.this.Nn != null) {
                f.this.Nn.onOver();
            }
        }
    }

    public void D(View view) {
        if (this.Np && this.Nq != null) {
            this.mView = view;
            this.Nq.s(Math.abs(this.Nm), this.mDuration);
            this.mHandler.postDelayed(this.Nr, this.mDuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop > this.Nm) {
            z = true;
        } else {
            paddingTop = this.Nm;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        if (this.No != null) {
            this.No.a(null, this.mView.getPaddingLeft(), this.mView.getPaddingRight(), this.mView.getPaddingTop() - this.Nm, this.mView.getPaddingBottom());
        }
        return z;
    }
}
