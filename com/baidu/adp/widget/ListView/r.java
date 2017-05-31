package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class r {
    private int If;
    private com.baidu.adp.widget.b.a Ig;
    private boolean Ih;
    a Ii;
    int Ij;
    View mView;
    private int Ie = 1;
    Handler mHandler = new Handler();
    Runnable Ik = new s(this);

    public r(Context context, int i, int i2, int i3) {
        this.Ih = true;
        int abs = Math.abs(i - i2);
        this.If = i2;
        if (abs < this.Ie) {
            this.Ih = false;
        }
        this.Ii = new a(context);
        this.Ij = i3;
    }

    public void a(com.baidu.adp.widget.b.a aVar) {
        this.Ig = aVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int Im;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void ll() {
            if (r.this.mHandler != null) {
                r.this.mHandler.removeCallbacks(r.this.Ik);
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
                if (this.mScroller.timePassed() >= r.this.Ij) {
                    computeScrollOffset = false;
                }
                int currY = this.mScroller.getCurrY();
                int i = currY - this.Im;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = r.this.move(i) ? false : true;
                        this.Im = currY;
                    }
                    z = r1;
                    if (!z) {
                        r.this.mView.post(this);
                    }
                }
                if (z) {
                    r.this.mHandler.removeCallbacks(r.this.Ik);
                    r.this.mHandler.post(r.this.Ik);
                }
            }
        }

        public void r(int i, int i2) {
            if (r.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                ll();
                this.Im = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                r.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lm() {
            r.this.mHandler.removeCallbacks(r.this.Ik);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (r.this.mView != null) {
                r.this.mView.removeCallbacks(this);
            }
            if (r.this.Ig != null) {
                r.this.Ig.onOver();
            }
        }
    }

    public void r(View view) {
        if (this.Ih && this.Ii != null) {
            this.mView = view;
            this.Ii.r(Math.abs(this.If), this.Ij);
            this.mHandler.postDelayed(this.Ik, this.Ij);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.If) {
            paddingTop = this.If;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
