package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class r {
    View mView;
    private boolean zA;
    a zB;
    int zC;
    private int zy;
    private com.baidu.adp.widget.ScrollView.g zz;
    private int zx = 1;
    Handler mHandler = new Handler();
    Runnable zD = new s(this);

    public r(Context context, int i, int i2, int i3) {
        this.zA = true;
        int abs = Math.abs(i - i2);
        this.zy = i2;
        if (abs < this.zx) {
            this.zA = false;
        }
        this.zB = new a(context);
        this.zC = i3;
    }

    public void a(com.baidu.adp.widget.ScrollView.g gVar) {
        this.zz = gVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private Scroller mScroller;
        private int zF;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void jI() {
            if (r.this.mHandler != null) {
                r.this.mHandler.removeCallbacks(r.this.zD);
            }
            if (r.this.mView != null) {
                r.this.mView.removeCallbacks(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = true;
            if (r.this.mView != null && this.mScroller != null) {
                boolean computeScrollOffset = this.mScroller.computeScrollOffset();
                if (this.mScroller.timePassed() >= r.this.zC) {
                    computeScrollOffset = false;
                }
                int currY = this.mScroller.getCurrY();
                int i = currY - this.zF;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = r.this.move(i) ? false : true;
                        this.zF = currY;
                    }
                    z = r1;
                    if (!z) {
                        r.this.mView.post(this);
                    }
                }
                if (z) {
                    r.this.mHandler.removeCallbacks(r.this.zD);
                    r.this.mHandler.post(r.this.zD);
                }
            }
        }

        public void j(int i, int i2) {
            if (r.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                jI();
                this.zF = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                r.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void jJ() {
            r.this.mHandler.removeCallbacks(r.this.zD);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (r.this.mView != null) {
                r.this.mView.removeCallbacks(this);
            }
            if (r.this.zz != null) {
                r.this.zz.jH();
            }
        }
    }

    public void t(View view) {
        if (this.zA && this.zB != null) {
            this.mView = view;
            this.zB.j(Math.abs(this.zy), this.zC);
            this.mHandler.postDelayed(this.zD, this.zC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.zy) {
            paddingTop = this.zy;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
