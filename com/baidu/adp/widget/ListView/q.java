package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class q {
    private int Jj;
    private com.baidu.adp.widget.ScrollView.g Jk;
    private boolean Jl;
    a Jm;
    int Jn;
    View mView;
    private int Ji = 1;
    Handler mHandler = new Handler();
    Runnable Jo = new r(this);

    public q(Context context, int i, int i2, int i3) {
        this.Jl = true;
        int abs = Math.abs(i - i2);
        this.Jj = i2;
        if (abs < this.Ji) {
            this.Jl = false;
        }
        this.Jm = new a(context);
        this.Jn = i3;
    }

    public void a(com.baidu.adp.widget.ScrollView.g gVar) {
        this.Jk = gVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int Jq;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void nr() {
            if (q.this.mHandler != null) {
                q.this.mHandler.removeCallbacks(q.this.Jo);
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
                if (this.mScroller.timePassed() >= q.this.Jn) {
                    computeScrollOffset = false;
                }
                int currY = this.mScroller.getCurrY();
                int i = currY - this.Jq;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = q.this.move(i) ? false : true;
                        this.Jq = currY;
                    }
                    z = r1;
                    if (!z) {
                        q.this.mView.post(this);
                    }
                }
                if (z) {
                    q.this.mHandler.removeCallbacks(q.this.Jo);
                    q.this.mHandler.post(q.this.Jo);
                }
            }
        }

        public void j(int i, int i2) {
            if (q.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                nr();
                this.Jq = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                q.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ns() {
            q.this.mHandler.removeCallbacks(q.this.Jo);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (q.this.mView != null) {
                q.this.mView.removeCallbacks(this);
            }
            if (q.this.Jk != null) {
                q.this.Jk.nq();
            }
        }
    }

    public void t(View view) {
        if (this.Jl && this.Jm != null) {
            this.mView = view;
            this.Jm.j(Math.abs(this.Jj), this.Jn);
            this.mHandler.postDelayed(this.Jo, this.Jn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.Jj) {
            paddingTop = this.Jj;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
