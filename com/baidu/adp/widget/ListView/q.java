package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class q {
    private int Id;
    private com.baidu.adp.widget.ScrollView.g Ie;
    private boolean If;
    a Ig;
    int Ih;
    View mView;
    private int Ic = 1;
    Handler mHandler = new Handler();
    Runnable Ii = new r(this);

    public q(Context context, int i, int i2, int i3) {
        this.If = true;
        int abs = Math.abs(i - i2);
        this.Id = i2;
        if (abs < this.Ic) {
            this.If = false;
        }
        this.Ig = new a(context);
        this.Ih = i3;
    }

    public void a(com.baidu.adp.widget.ScrollView.g gVar) {
        this.Ie = gVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int Ik;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void nD() {
            if (q.this.mHandler != null) {
                q.this.mHandler.removeCallbacks(q.this.Ii);
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
                if (this.mScroller.timePassed() >= q.this.Ih) {
                    computeScrollOffset = false;
                }
                int currY = this.mScroller.getCurrY();
                int i = currY - this.Ik;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = q.this.move(i) ? false : true;
                        this.Ik = currY;
                    }
                    z = r1;
                    if (!z) {
                        q.this.mView.post(this);
                    }
                }
                if (z) {
                    q.this.mHandler.removeCallbacks(q.this.Ii);
                    q.this.mHandler.post(q.this.Ii);
                }
            }
        }

        public void j(int i, int i2) {
            if (q.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                nD();
                this.Ik = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                q.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void endAnimation() {
            q.this.mHandler.removeCallbacks(q.this.Ii);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (q.this.mView != null) {
                q.this.mView.removeCallbacks(this);
            }
            if (q.this.Ie != null) {
                q.this.Ie.nC();
            }
        }
    }

    public void h(View view) {
        if (this.If && this.Ig != null) {
            this.mView = view;
            this.Ig.j(Math.abs(this.Id), this.Ih);
            this.mHandler.postDelayed(this.Ii, this.Ih);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.Id) {
            paddingTop = this.Id;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
