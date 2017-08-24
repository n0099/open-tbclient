package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class e {
    private int JH;
    private com.baidu.adp.widget.b.a JI;
    private boolean JJ;
    a JK;
    int mDuration;
    View mView;
    private int JG = 1;
    Handler mHandler = new Handler();
    Runnable JL = new Runnable() { // from class: com.baidu.adp.widget.ListView.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.JK == null) {
                return;
            }
            e.this.JK.lr();
        }
    };

    public e(Context context, int i, int i2, int i3) {
        this.JJ = true;
        int abs = Math.abs(i - i2);
        this.JH = i2;
        if (abs < this.JG) {
            this.JJ = false;
        }
        this.JK = new a(context);
        this.mDuration = i3;
    }

    public void a(com.baidu.adp.widget.b.a aVar) {
        this.JI = aVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int JN;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void lq() {
            if (e.this.mHandler != null) {
                e.this.mHandler.removeCallbacks(e.this.JL);
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
                if (this.mScroller.timePassed() >= e.this.mDuration) {
                    computeScrollOffset = false;
                }
                int currY = this.mScroller.getCurrY();
                int i = currY - this.JN;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = e.this.move(i) ? false : true;
                        this.JN = currY;
                    }
                    z = r1;
                    if (!z) {
                        e.this.mView.post(this);
                    }
                }
                if (z) {
                    e.this.mHandler.removeCallbacks(e.this.JL);
                    e.this.mHandler.post(e.this.JL);
                }
            }
        }

        public void s(int i, int i2) {
            if (e.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                lq();
                this.JN = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                e.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lr() {
            e.this.mHandler.removeCallbacks(e.this.JL);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (e.this.mView != null) {
                e.this.mView.removeCallbacks(this);
            }
            if (e.this.JI != null) {
                e.this.JI.onOver();
            }
        }
    }

    public void r(View view) {
        if (this.JJ && this.JK != null) {
            this.mView = view;
            this.JK.s(Math.abs(this.JH), this.mDuration);
            this.mHandler.postDelayed(this.JL, this.mDuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.JH) {
            paddingTop = this.JH;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
