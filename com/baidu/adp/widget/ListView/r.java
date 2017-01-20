package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class r {
    private int BB;
    private com.baidu.adp.widget.ScrollView.g BC;
    private boolean BD;
    a BE;
    int BF;
    View mView;
    private int BA = 1;
    Handler mHandler = new Handler();
    Runnable BG = new s(this);

    public r(Context context, int i, int i2, int i3) {
        this.BD = true;
        int abs = Math.abs(i - i2);
        this.BB = i2;
        if (abs < this.BA) {
            this.BD = false;
        }
        this.BE = new a(context);
        this.BF = i3;
    }

    public void a(com.baidu.adp.widget.ScrollView.g gVar) {
        this.BC = gVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int BI;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void ku() {
            if (r.this.mHandler != null) {
                r.this.mHandler.removeCallbacks(r.this.BG);
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
                if (this.mScroller.timePassed() >= r.this.BF) {
                    computeScrollOffset = false;
                }
                int currY = this.mScroller.getCurrY();
                int i = currY - this.BI;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = r.this.move(i) ? false : true;
                        this.BI = currY;
                    }
                    z = r1;
                    if (!z) {
                        r.this.mView.post(this);
                    }
                }
                if (z) {
                    r.this.mHandler.removeCallbacks(r.this.BG);
                    r.this.mHandler.post(r.this.BG);
                }
            }
        }

        public void l(int i, int i2) {
            if (r.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                ku();
                this.BI = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                r.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void kv() {
            r.this.mHandler.removeCallbacks(r.this.BG);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (r.this.mView != null) {
                r.this.mView.removeCallbacks(this);
            }
            if (r.this.BC != null) {
                r.this.BC.kt();
            }
        }
    }

    public void r(View view) {
        if (this.BD && this.BE != null) {
            this.mView = view;
            this.BE.l(Math.abs(this.BB), this.BF);
            this.mHandler.postDelayed(this.BG, this.BF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.BB) {
            paddingTop = this.BB;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
