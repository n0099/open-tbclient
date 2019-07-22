package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
import com.baidu.adp.widget.ListView.c;
/* loaded from: classes.dex */
public class f {
    private int Nl;
    private com.baidu.adp.widget.b.a Nm;
    private c.a Nn;
    private boolean No;
    a Np;
    int mDuration;
    View mView;
    private int Nk = 1;
    Handler mHandler = new Handler();
    Runnable Nq = new Runnable() { // from class: com.baidu.adp.widget.ListView.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.Np == null) {
                return;
            }
            f.this.Np.oi();
        }
    };

    public f(Context context, int i, int i2, int i3) {
        this.No = true;
        int abs = Math.abs(i - i2);
        this.Nl = i2;
        if (abs < this.Nk) {
            this.No = false;
        }
        this.Np = new a(context);
        this.mDuration = i3;
    }

    public void a(com.baidu.adp.widget.b.a aVar) {
        this.Nm = aVar;
    }

    public void a(c.a aVar) {
        this.Nn = aVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int mLastFlingY;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void oh() {
            if (f.this.mHandler != null) {
                f.this.mHandler.removeCallbacks(f.this.Nq);
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
                    f.this.mHandler.removeCallbacks(f.this.Nq);
                    f.this.mHandler.post(f.this.Nq);
                }
            }
        }

        public void s(int i, int i2) {
            if (f.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                oh();
                this.mLastFlingY = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                f.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void oi() {
            f.this.mHandler.removeCallbacks(f.this.Nq);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (f.this.mView != null) {
                f.this.mView.removeCallbacks(this);
            }
            if (f.this.Nm != null) {
                f.this.Nm.onOver();
            }
        }
    }

    public void D(View view) {
        if (this.No && this.Np != null) {
            this.mView = view;
            this.Np.s(Math.abs(this.Nl), this.mDuration);
            this.mHandler.postDelayed(this.Nq, this.mDuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop > this.Nl) {
            z = true;
        } else {
            paddingTop = this.Nl;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        if (this.Nn != null) {
            this.Nn.a(null, this.mView.getPaddingLeft(), this.mView.getPaddingRight(), this.mView.getPaddingTop() - this.Nl, this.mView.getPaddingBottom());
        }
        return z;
    }
}
