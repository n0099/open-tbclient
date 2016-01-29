package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class q {
    private int Jd;
    private com.baidu.adp.widget.ScrollView.g Je;
    private boolean Jf;
    a Jg;
    int Jh;
    View mView;
    private int Jc = 1;
    Handler mHandler = new Handler();
    Runnable Ji = new r(this);

    public q(Context context, int i, int i2, int i3) {
        this.Jf = true;
        int abs = Math.abs(i - i2);
        this.Jd = i2;
        if (abs < this.Jc) {
            this.Jf = false;
        }
        this.Jg = new a(context);
        this.Jh = i3;
    }

    public void a(com.baidu.adp.widget.ScrollView.g gVar) {
        this.Je = gVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int Jk;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void nA() {
            if (q.this.mHandler != null) {
                q.this.mHandler.removeCallbacks(q.this.Ji);
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
                if (this.mScroller.timePassed() >= q.this.Jh) {
                    computeScrollOffset = false;
                }
                int currY = this.mScroller.getCurrY();
                int i = currY - this.Jk;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = q.this.move(i) ? false : true;
                        this.Jk = currY;
                    }
                    z = r1;
                    if (!z) {
                        q.this.mView.post(this);
                    }
                }
                if (z) {
                    q.this.mHandler.removeCallbacks(q.this.Ji);
                    q.this.mHandler.post(q.this.Ji);
                }
            }
        }

        public void j(int i, int i2) {
            if (q.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                nA();
                this.Jk = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                q.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void endAnimation() {
            q.this.mHandler.removeCallbacks(q.this.Ji);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (q.this.mView != null) {
                q.this.mView.removeCallbacks(this);
            }
            if (q.this.Je != null) {
                q.this.Je.nz();
            }
        }
    }

    public void t(View view) {
        if (this.Jf && this.Jg != null) {
            this.mView = view;
            this.Jg.j(Math.abs(this.Jd), this.Jh);
            this.mHandler.postDelayed(this.Ji, this.Jh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.Jd) {
            paddingTop = this.Jd;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
