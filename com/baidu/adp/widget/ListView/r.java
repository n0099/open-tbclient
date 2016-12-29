package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class r {
    private int Cp;
    private com.baidu.adp.widget.ScrollView.g Cq;
    private boolean Cr;
    a Cs;
    int Ct;
    View mView;
    private int Co = 1;
    Handler mHandler = new Handler();
    Runnable Cu = new s(this);

    public r(Context context, int i, int i2, int i3) {
        this.Cr = true;
        int abs = Math.abs(i - i2);
        this.Cp = i2;
        if (abs < this.Co) {
            this.Cr = false;
        }
        this.Cs = new a(context);
        this.Ct = i3;
    }

    public void a(com.baidu.adp.widget.ScrollView.g gVar) {
        this.Cq = gVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int Cw;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void kC() {
            if (r.this.mHandler != null) {
                r.this.mHandler.removeCallbacks(r.this.Cu);
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
                if (this.mScroller.timePassed() >= r.this.Ct) {
                    computeScrollOffset = false;
                }
                int currY = this.mScroller.getCurrY();
                int i = currY - this.Cw;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = r.this.move(i) ? false : true;
                        this.Cw = currY;
                    }
                    z = r1;
                    if (!z) {
                        r.this.mView.post(this);
                    }
                }
                if (z) {
                    r.this.mHandler.removeCallbacks(r.this.Cu);
                    r.this.mHandler.post(r.this.Cu);
                }
            }
        }

        public void l(int i, int i2) {
            if (r.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                kC();
                this.Cw = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                r.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void kD() {
            r.this.mHandler.removeCallbacks(r.this.Cu);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (r.this.mView != null) {
                r.this.mView.removeCallbacks(this);
            }
            if (r.this.Cq != null) {
                r.this.Cq.kB();
            }
        }
    }

    public void t(View view) {
        if (this.Cr && this.Cs != null) {
            this.mView = view;
            this.Cs.l(Math.abs(this.Cp), this.Ct);
            this.mHandler.postDelayed(this.Cu, this.Ct);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.Cp) {
            paddingTop = this.Cp;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
