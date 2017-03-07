package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class r {
    private int IP;
    private com.baidu.adp.widget.ScrollView.g IQ;
    private boolean IR;
    a IS;
    int IT;
    View mView;
    private int IO = 1;
    Handler mHandler = new Handler();
    Runnable IU = new s(this);

    public r(Context context, int i, int i2, int i3) {
        this.IR = true;
        int abs = Math.abs(i - i2);
        this.IP = i2;
        if (abs < this.IO) {
            this.IR = false;
        }
        this.IS = new a(context);
        this.IT = i3;
    }

    public void a(com.baidu.adp.widget.ScrollView.g gVar) {
        this.IQ = gVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int IX;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void lo() {
            if (r.this.mHandler != null) {
                r.this.mHandler.removeCallbacks(r.this.IU);
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
                if (this.mScroller.timePassed() >= r.this.IT) {
                    computeScrollOffset = false;
                }
                int currY = this.mScroller.getCurrY();
                int i = currY - this.IX;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = r.this.move(i) ? false : true;
                        this.IX = currY;
                    }
                    z = r1;
                    if (!z) {
                        r.this.mView.post(this);
                    }
                }
                if (z) {
                    r.this.mHandler.removeCallbacks(r.this.IU);
                    r.this.mHandler.post(r.this.IU);
                }
            }
        }

        public void s(int i, int i2) {
            if (r.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                lo();
                this.IX = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                r.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lp() {
            r.this.mHandler.removeCallbacks(r.this.IU);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (r.this.mView != null) {
                r.this.mView.removeCallbacks(this);
            }
            if (r.this.IQ != null) {
                r.this.IQ.ln();
            }
        }
    }

    public void r(View view) {
        if (this.IR && this.IS != null) {
            this.mView = view;
            this.IS.s(Math.abs(this.IP), this.IT);
            this.mHandler.postDelayed(this.IU, this.IT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.IP) {
            paddingTop = this.IP;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
