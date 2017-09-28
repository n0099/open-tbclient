package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class e {
    private int HQ;
    private com.baidu.adp.widget.a.a HR;
    private boolean HS;
    a HT;
    int HU;
    View mView;
    private int HP = 1;
    Handler mHandler = new Handler();
    Runnable HV = new Runnable() { // from class: com.baidu.adp.widget.ListView.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.HT == null) {
                return;
            }
            e.this.HT.ll();
        }
    };

    public e(Context context, int i, int i2, int i3) {
        this.HS = true;
        int abs = Math.abs(i - i2);
        this.HQ = i2;
        if (abs < this.HP) {
            this.HS = false;
        }
        this.HT = new a(context);
        this.HU = i3;
    }

    public void a(com.baidu.adp.widget.a.a aVar) {
        this.HR = aVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int HX;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void lk() {
            if (e.this.mHandler != null) {
                e.this.mHandler.removeCallbacks(e.this.HV);
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
                if (this.mScroller.timePassed() >= e.this.HU) {
                    computeScrollOffset = false;
                }
                int currY = this.mScroller.getCurrY();
                int i = currY - this.HX;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = e.this.move(i) ? false : true;
                        this.HX = currY;
                    }
                    z = r1;
                    if (!z) {
                        e.this.mView.post(this);
                    }
                }
                if (z) {
                    e.this.mHandler.removeCallbacks(e.this.HV);
                    e.this.mHandler.post(e.this.HV);
                }
            }
        }

        public void r(int i, int i2) {
            if (e.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                lk();
                this.HX = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                e.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ll() {
            e.this.mHandler.removeCallbacks(e.this.HV);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (e.this.mView != null) {
                e.this.mView.removeCallbacks(this);
            }
            if (e.this.HR != null) {
                e.this.HR.onOver();
            }
        }
    }

    public void r(View view) {
        if (this.HS && this.HT != null) {
            this.mView = view;
            this.HT.r(Math.abs(this.HQ), this.HU);
            this.mHandler.postDelayed(this.HV, this.HU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.HQ) {
            paddingTop = this.HQ;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
