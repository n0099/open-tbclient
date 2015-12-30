package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class q {
    private int IN;
    private com.baidu.adp.widget.ScrollView.g IO;
    private boolean IP;
    a IQ;
    int IR;
    View mView;
    private int IM = 1;
    Handler mHandler = new Handler();
    Runnable IS = new r(this);

    public q(Context context, int i, int i2, int i3) {
        this.IP = true;
        int abs = Math.abs(i - i2);
        this.IN = i2;
        if (abs < this.IM) {
            this.IP = false;
        }
        this.IQ = new a(context);
        this.IR = i3;
    }

    public void a(com.baidu.adp.widget.ScrollView.g gVar) {
        this.IO = gVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int IU;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void ng() {
            if (q.this.mHandler != null) {
                q.this.mHandler.removeCallbacks(q.this.IS);
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
                if (this.mScroller.timePassed() >= q.this.IR) {
                    computeScrollOffset = false;
                }
                int currY = this.mScroller.getCurrY();
                int i = currY - this.IU;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = q.this.move(i) ? false : true;
                        this.IU = currY;
                    }
                    z = r1;
                    if (!z) {
                        q.this.mView.post(this);
                    }
                }
                if (z) {
                    q.this.mHandler.removeCallbacks(q.this.IS);
                    q.this.mHandler.post(q.this.IS);
                }
            }
        }

        public void i(int i, int i2) {
            if (q.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                ng();
                this.IU = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                q.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void endAnimation() {
            q.this.mHandler.removeCallbacks(q.this.IS);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (q.this.mView != null) {
                q.this.mView.removeCallbacks(this);
            }
            if (q.this.IO != null) {
                q.this.IO.nf();
            }
        }
    }

    public void h(View view) {
        if (this.IP && this.IQ != null) {
            this.mView = view;
            this.IQ.i(Math.abs(this.IN), this.IR);
            this.mHandler.postDelayed(this.IS, this.IR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.IN) {
            paddingTop = this.IN;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
