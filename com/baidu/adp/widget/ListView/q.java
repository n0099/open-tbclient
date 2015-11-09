package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class q {
    private int If;
    private com.baidu.adp.widget.ScrollView.g Ig;
    private boolean Ih;
    a Ii;
    int Ij;
    View mView;
    private int Ie = 1;
    Handler mHandler = new Handler();
    Runnable Ik = new r(this);

    public q(Context context, int i, int i2, int i3) {
        this.Ih = true;
        int abs = Math.abs(i - i2);
        this.If = i2;
        if (abs < this.Ie) {
            this.Ih = false;
        }
        this.Ii = new a(context);
        this.Ij = i3;
    }

    public void a(com.baidu.adp.widget.ScrollView.g gVar) {
        this.Ig = gVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int Im;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void nC() {
            if (q.this.mHandler != null) {
                q.this.mHandler.removeCallbacks(q.this.Ik);
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
                if (this.mScroller.timePassed() >= q.this.Ij) {
                    computeScrollOffset = false;
                }
                int currY = this.mScroller.getCurrY();
                int i = currY - this.Im;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = q.this.move(i) ? false : true;
                        this.Im = currY;
                    }
                    z = r1;
                    if (!z) {
                        q.this.mView.post(this);
                    }
                }
                if (z) {
                    q.this.mHandler.removeCallbacks(q.this.Ik);
                    q.this.mHandler.post(q.this.Ik);
                }
            }
        }

        public void j(int i, int i2) {
            if (q.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                nC();
                this.Im = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                q.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void endAnimation() {
            q.this.mHandler.removeCallbacks(q.this.Ik);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (q.this.mView != null) {
                q.this.mView.removeCallbacks(this);
            }
            if (q.this.Ig != null) {
                q.this.Ig.nB();
            }
        }
    }

    public void h(View view) {
        if (this.Ih && this.Ii != null) {
            this.mView = view;
            this.Ii.j(Math.abs(this.If), this.Ij);
            this.mHandler.postDelayed(this.Ik, this.Ij);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.If) {
            paddingTop = this.If;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
