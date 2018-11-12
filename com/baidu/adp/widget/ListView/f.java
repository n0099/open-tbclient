package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class f {
    private int OI;
    private com.baidu.adp.widget.b.a OJ;
    private boolean OL;
    a OM;
    int mDuration;
    View mView;
    private int OH = 1;
    Handler mHandler = new Handler();
    Runnable OO = new Runnable() { // from class: com.baidu.adp.widget.ListView.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.OM == null) {
                return;
            }
            f.this.OM.oK();
        }
    };

    public f(Context context, int i, int i2, int i3) {
        this.OL = true;
        int abs = Math.abs(i - i2);
        this.OI = i2;
        if (abs < this.OH) {
            this.OL = false;
        }
        this.OM = new a(context);
        this.mDuration = i3;
    }

    public void a(com.baidu.adp.widget.b.a aVar) {
        this.OJ = aVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int mLastFlingY;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void startCommon() {
            if (f.this.mHandler != null) {
                f.this.mHandler.removeCallbacks(f.this.OO);
            }
            if (f.this.mView != null) {
                f.this.mView.removeCallbacks(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = true;
            if (f.this.mView != null && this.mScroller != null) {
                boolean computeScrollOffset = this.mScroller.computeScrollOffset();
                if (this.mScroller.timePassed() >= f.this.mDuration) {
                    computeScrollOffset = false;
                }
                int currY = this.mScroller.getCurrY();
                int i = currY - this.mLastFlingY;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = f.this.move(i) ? false : true;
                        this.mLastFlingY = currY;
                    }
                    z = r1;
                    if (!z) {
                        f.this.mView.post(this);
                    }
                }
                if (z) {
                    f.this.mHandler.removeCallbacks(f.this.OO);
                    f.this.mHandler.post(f.this.OO);
                }
            }
        }

        public void r(int i, int i2) {
            if (f.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                startCommon();
                this.mLastFlingY = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                f.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void oK() {
            f.this.mHandler.removeCallbacks(f.this.OO);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (f.this.mView != null) {
                f.this.mView.removeCallbacks(this);
            }
            if (f.this.OJ != null) {
                f.this.OJ.onOver();
            }
        }
    }

    public void B(View view) {
        if (this.OL && this.OM != null) {
            this.mView = view;
            this.OM.r(Math.abs(this.OI), this.mDuration);
            this.mHandler.postDelayed(this.OO, this.mDuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.OI) {
            paddingTop = this.OI;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
