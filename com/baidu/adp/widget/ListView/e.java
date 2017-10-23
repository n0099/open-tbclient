package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class e {
    private int HR;
    private com.baidu.adp.widget.a.a HS;
    private boolean HT;
    a HU;
    int HV;
    View mView;
    private int HQ = 1;
    Handler mHandler = new Handler();
    Runnable HW = new Runnable() { // from class: com.baidu.adp.widget.ListView.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.HU == null) {
                return;
            }
            e.this.HU.ll();
        }
    };

    public e(Context context, int i, int i2, int i3) {
        this.HT = true;
        int abs = Math.abs(i - i2);
        this.HR = i2;
        if (abs < this.HQ) {
            this.HT = false;
        }
        this.HU = new a(context);
        this.HV = i3;
    }

    public void a(com.baidu.adp.widget.a.a aVar) {
        this.HS = aVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int HY;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void lk() {
            if (e.this.mHandler != null) {
                e.this.mHandler.removeCallbacks(e.this.HW);
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
                if (this.mScroller.timePassed() >= e.this.HV) {
                    computeScrollOffset = false;
                }
                int currY = this.mScroller.getCurrY();
                int i = currY - this.HY;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = e.this.move(i) ? false : true;
                        this.HY = currY;
                    }
                    z = r1;
                    if (!z) {
                        e.this.mView.post(this);
                    }
                }
                if (z) {
                    e.this.mHandler.removeCallbacks(e.this.HW);
                    e.this.mHandler.post(e.this.HW);
                }
            }
        }

        public void r(int i, int i2) {
            if (e.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                lk();
                this.HY = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                e.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ll() {
            e.this.mHandler.removeCallbacks(e.this.HW);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (e.this.mView != null) {
                e.this.mView.removeCallbacks(this);
            }
            if (e.this.HS != null) {
                e.this.HS.onOver();
            }
        }
    }

    public void r(View view) {
        if (this.HT && this.HU != null) {
            this.mView = view;
            this.HU.r(Math.abs(this.HR), this.HV);
            this.mHandler.postDelayed(this.HW, this.HV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.HR) {
            paddingTop = this.HR;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
