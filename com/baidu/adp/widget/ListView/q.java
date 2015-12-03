package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class q {
    int IA;
    private int Iw;
    private com.baidu.adp.widget.ScrollView.g Ix;
    private boolean Iy;
    a Iz;
    View mView;
    private int Iv = 1;
    Handler mHandler = new Handler();
    Runnable IB = new r(this);

    public q(Context context, int i, int i2, int i3) {
        this.Iy = true;
        int abs = Math.abs(i - i2);
        this.Iw = i2;
        if (abs < this.Iv) {
            this.Iy = false;
        }
        this.Iz = new a(context);
        this.IA = i3;
    }

    public void a(com.baidu.adp.widget.ScrollView.g gVar) {
        this.Ix = gVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int IE;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void nI() {
            if (q.this.mHandler != null) {
                q.this.mHandler.removeCallbacks(q.this.IB);
            }
            if (q.this.mView != null) {
                q.this.mView.removeCallbacks(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = true;
            if (q.this.mView != null && this.mScroller != null) {
                boolean computeScrollOffset = this.mScroller.computeScrollOffset();
                if (this.mScroller.timePassed() >= q.this.IA) {
                    computeScrollOffset = false;
                }
                int currY = this.mScroller.getCurrY();
                int i = currY - this.IE;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = q.this.move(i) ? false : true;
                        this.IE = currY;
                    }
                    z = r1;
                    if (!z) {
                        q.this.mView.post(this);
                    }
                }
                if (z) {
                    q.this.mHandler.removeCallbacks(q.this.IB);
                    q.this.mHandler.post(q.this.IB);
                }
            }
        }

        public void j(int i, int i2) {
            if (q.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                nI();
                this.IE = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                q.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void endAnimation() {
            q.this.mHandler.removeCallbacks(q.this.IB);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (q.this.mView != null) {
                q.this.mView.removeCallbacks(this);
            }
            if (q.this.Ix != null) {
                q.this.Ix.nH();
            }
        }
    }

    public void h(View view) {
        if (this.Iy && this.Iz != null) {
            this.mView = view;
            this.Iz.j(Math.abs(this.Iw), this.IA);
            this.mHandler.postDelayed(this.IB, this.IA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.Iw) {
            paddingTop = this.Iw;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
