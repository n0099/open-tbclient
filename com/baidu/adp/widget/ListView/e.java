package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class e {
    private int Hk;
    private com.baidu.adp.widget.b.a Hl;
    private boolean Hm;
    a Hn;
    int mDuration;
    View mView;
    private int Hj = 1;
    Handler mHandler = new Handler();
    Runnable Ho = new Runnable() { // from class: com.baidu.adp.widget.ListView.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.Hn == null) {
                return;
            }
            e.this.Hn.lf();
        }
    };

    public e(Context context, int i, int i2, int i3) {
        this.Hm = true;
        int abs = Math.abs(i - i2);
        this.Hk = i2;
        if (abs < this.Hj) {
            this.Hm = false;
        }
        this.Hn = new a(context);
        this.mDuration = i3;
    }

    public void a(com.baidu.adp.widget.b.a aVar) {
        this.Hl = aVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int Hq;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void le() {
            if (e.this.mHandler != null) {
                e.this.mHandler.removeCallbacks(e.this.Ho);
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
                int i = currY - this.Hq;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = e.this.move(i) ? false : true;
                        this.Hq = currY;
                    }
                    z = r1;
                    if (!z) {
                        e.this.mView.post(this);
                    }
                }
                if (z) {
                    e.this.mHandler.removeCallbacks(e.this.Ho);
                    e.this.mHandler.post(e.this.Ho);
                }
            }
        }

        public void r(int i, int i2) {
            if (e.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                le();
                this.Hq = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                e.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lf() {
            e.this.mHandler.removeCallbacks(e.this.Ho);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (e.this.mView != null) {
                e.this.mView.removeCallbacks(this);
            }
            if (e.this.Hl != null) {
                e.this.Hl.onOver();
            }
        }
    }

    public void r(View view) {
        if (this.Hm && this.Hn != null) {
            this.mView = view;
            this.Hn.r(Math.abs(this.Hk), this.mDuration);
            this.mHandler.postDelayed(this.Ho, this.mDuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.Hk) {
            paddingTop = this.Hk;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
