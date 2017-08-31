package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class e {
    private com.baidu.adp.widget.b.a HA;
    private boolean HB;
    a HC;
    int HD;
    private int Hz;
    View mView;
    private int Hy = 1;
    Handler mHandler = new Handler();
    Runnable HE = new Runnable() { // from class: com.baidu.adp.widget.ListView.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.HC == null) {
                return;
            }
            e.this.HC.lj();
        }
    };

    public e(Context context, int i, int i2, int i3) {
        this.HB = true;
        int abs = Math.abs(i - i2);
        this.Hz = i2;
        if (abs < this.Hy) {
            this.HB = false;
        }
        this.HC = new a(context);
        this.HD = i3;
    }

    public void a(com.baidu.adp.widget.b.a aVar) {
        this.HA = aVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int HG;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void li() {
            if (e.this.mHandler != null) {
                e.this.mHandler.removeCallbacks(e.this.HE);
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
                if (this.mScroller.timePassed() >= e.this.HD) {
                    computeScrollOffset = false;
                }
                int currY = this.mScroller.getCurrY();
                int i = currY - this.HG;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = e.this.move(i) ? false : true;
                        this.HG = currY;
                    }
                    z = r1;
                    if (!z) {
                        e.this.mView.post(this);
                    }
                }
                if (z) {
                    e.this.mHandler.removeCallbacks(e.this.HE);
                    e.this.mHandler.post(e.this.HE);
                }
            }
        }

        public void r(int i, int i2) {
            if (e.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                li();
                this.HG = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                e.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lj() {
            e.this.mHandler.removeCallbacks(e.this.HE);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (e.this.mView != null) {
                e.this.mView.removeCallbacks(this);
            }
            if (e.this.HA != null) {
                e.this.HA.onOver();
            }
        }
    }

    public void r(View view) {
        if (this.HB && this.HC != null) {
            this.mView = view;
            this.HC.r(Math.abs(this.Hz), this.HD);
            this.mHandler.postDelayed(this.HE, this.HD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.Hz) {
            paddingTop = this.Hz;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
