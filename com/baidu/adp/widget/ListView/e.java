package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class e {
    private int Ie;
    private com.baidu.adp.widget.b.a If;
    private boolean Ig;
    a Ih;
    int Ii;
    View mView;
    private int Id = 1;
    Handler mHandler = new Handler();
    Runnable Ij = new Runnable() { // from class: com.baidu.adp.widget.ListView.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.Ih == null) {
                return;
            }
            e.this.Ih.li();
        }
    };

    public e(Context context, int i, int i2, int i3) {
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

        private void lh() {
            if (e.this.mHandler != null) {
                e.this.mHandler.removeCallbacks(e.this.Ij);
            }
            if (e.this.mView != null) {
                e.this.mView.removeCallbacks(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = true;
            if (e.this.mView != null && this.mScroller != null) {
                boolean computeScrollOffset = this.mScroller.computeScrollOffset();
                if (this.mScroller.timePassed() >= e.this.Ii) {
                    computeScrollOffset = false;
                }
                int currY = this.mScroller.getCurrY();
                int i = currY - this.Il;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = e.this.move(i) ? false : true;
                        this.Il = currY;
                    }
                    z = r1;
                    if (!z) {
                        e.this.mView.post(this);
                    }
                }
                if (z) {
                    e.this.mHandler.removeCallbacks(e.this.Ij);
                    e.this.mHandler.post(e.this.Ij);
                }
            }
        }

        public void r(int i, int i2) {
            if (e.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                lh();
                this.Il = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                e.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void li() {
            e.this.mHandler.removeCallbacks(e.this.Ij);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (e.this.mView != null) {
                e.this.mView.removeCallbacks(this);
            }
            if (e.this.If != null) {
                e.this.If.onOver();
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
