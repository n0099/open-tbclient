package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class r {
    private int Co;
    private com.baidu.adp.widget.ScrollView.g Cp;
    private boolean Cq;
    a Cr;
    int Cs;
    View mView;
    private int Cn = 1;
    Handler mHandler = new Handler();
    Runnable Ct = new s(this);

    public r(Context context, int i, int i2, int i3) {
        this.Cq = true;
        int abs = Math.abs(i - i2);
        this.Co = i2;
        if (abs < this.Cn) {
            this.Cq = false;
        }
        this.Cr = new a(context);
        this.Cs = i3;
    }

    public void a(com.baidu.adp.widget.ScrollView.g gVar) {
        this.Cp = gVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int Cv;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void kC() {
            if (r.this.mHandler != null) {
                r.this.mHandler.removeCallbacks(r.this.Ct);
            }
            if (r.this.mView != null) {
                r.this.mView.removeCallbacks(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = true;
            if (r.this.mView != null && this.mScroller != null) {
                boolean computeScrollOffset = this.mScroller.computeScrollOffset();
                if (this.mScroller.timePassed() >= r.this.Cs) {
                    computeScrollOffset = false;
                }
                int currY = this.mScroller.getCurrY();
                int i = currY - this.Cv;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = r.this.move(i) ? false : true;
                        this.Cv = currY;
                    }
                    z = r1;
                    if (!z) {
                        r.this.mView.post(this);
                    }
                }
                if (z) {
                    r.this.mHandler.removeCallbacks(r.this.Ct);
                    r.this.mHandler.post(r.this.Ct);
                }
            }
        }

        public void l(int i, int i2) {
            if (r.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                kC();
                this.Cv = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                r.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void kD() {
            r.this.mHandler.removeCallbacks(r.this.Ct);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (r.this.mView != null) {
                r.this.mView.removeCallbacks(this);
            }
            if (r.this.Cp != null) {
                r.this.Cp.kB();
            }
        }
    }

    public void t(View view) {
        if (this.Cq && this.Cr != null) {
            this.mView = view;
            this.Cr.l(Math.abs(this.Co), this.Cs);
            this.mHandler.postDelayed(this.Ct, this.Cs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.Co) {
            paddingTop = this.Co;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
