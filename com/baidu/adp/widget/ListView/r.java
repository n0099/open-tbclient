package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class r {
    private int Ie;
    private com.baidu.adp.widget.b.a If;
    private boolean Ig;
    a Ih;
    int Ii;
    View mView;
    private int Id = 1;
    Handler mHandler = new Handler();
    Runnable Ij = new s(this);

    public r(Context context, int i, int i2, int i3) {
        this.Ig = true;
        int abs = Math.abs(i - i2);
        this.Ie = i2;
        if (abs < this.Id) {
            this.Ig = false;
        }
        this.Ih = new a(context);
        this.Ii = i3;
    }

    public void a(com.baidu.adp.widget.b.a aVar) {
        this.If = aVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int Il;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void lj() {
            if (r.this.mHandler != null) {
                r.this.mHandler.removeCallbacks(r.this.Ij);
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
                if (this.mScroller.timePassed() >= r.this.Ii) {
                    computeScrollOffset = false;
                }
                int currY = this.mScroller.getCurrY();
                int i = currY - this.Il;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = r.this.move(i) ? false : true;
                        this.Il = currY;
                    }
                    z = r1;
                    if (!z) {
                        r.this.mView.post(this);
                    }
                }
                if (z) {
                    r.this.mHandler.removeCallbacks(r.this.Ij);
                    r.this.mHandler.post(r.this.Ij);
                }
            }
        }

        public void r(int i, int i2) {
            if (r.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                lj();
                this.Il = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                r.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lk() {
            r.this.mHandler.removeCallbacks(r.this.Ij);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (r.this.mView != null) {
                r.this.mView.removeCallbacks(this);
            }
            if (r.this.If != null) {
                r.this.If.onOver();
            }
        }
    }

    public void r(View view) {
        if (this.Ig && this.Ih != null) {
            this.mView = view;
            this.Ih.r(Math.abs(this.Ie), this.Ii);
            this.mHandler.postDelayed(this.Ij, this.Ii);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.Ie) {
            paddingTop = this.Ie;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
