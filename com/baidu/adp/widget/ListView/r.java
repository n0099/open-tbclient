package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class r {
    View mView;
    private com.baidu.adp.widget.ScrollView.g zA;
    private boolean zB;
    a zC;
    int zD;
    private int zz;
    private int zy = 1;
    Handler mHandler = new Handler();
    Runnable zE = new s(this);

    public r(Context context, int i, int i2, int i3) {
        this.zB = true;
        int abs = Math.abs(i - i2);
        this.zz = i2;
        if (abs < this.zy) {
            this.zB = false;
        }
        this.zC = new a(context);
        this.zD = i3;
    }

    public void a(com.baidu.adp.widget.ScrollView.g gVar) {
        this.zA = gVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private Scroller mScroller;
        private int zG;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void jF() {
            if (r.this.mHandler != null) {
                r.this.mHandler.removeCallbacks(r.this.zE);
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
                if (this.mScroller.timePassed() >= r.this.zD) {
                    computeScrollOffset = false;
                }
                int currY = this.mScroller.getCurrY();
                int i = currY - this.zG;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = r.this.move(i) ? false : true;
                        this.zG = currY;
                    }
                    z = r1;
                    if (!z) {
                        r.this.mView.post(this);
                    }
                }
                if (z) {
                    r.this.mHandler.removeCallbacks(r.this.zE);
                    r.this.mHandler.post(r.this.zE);
                }
            }
        }

        public void j(int i, int i2) {
            if (r.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                jF();
                this.zG = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                r.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void jG() {
            r.this.mHandler.removeCallbacks(r.this.zE);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (r.this.mView != null) {
                r.this.mView.removeCallbacks(this);
            }
            if (r.this.zA != null) {
                r.this.zA.jE();
            }
        }
    }

    public void t(View view) {
        if (this.zB && this.zC != null) {
            this.mView = view;
            this.zC.j(Math.abs(this.zz), this.zD);
            this.mHandler.postDelayed(this.zE, this.zD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.zz) {
            paddingTop = this.zz;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
