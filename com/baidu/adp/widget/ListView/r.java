package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class r {
    private int Ir;
    private com.baidu.adp.widget.ScrollView.g Is;
    private boolean It;
    a Iu;
    int Iv;
    View mView;
    private int Iq = 1;
    Handler mHandler = new Handler();
    Runnable Iw = new s(this);

    public r(Context context, int i, int i2, int i3) {
        this.It = true;
        int abs = Math.abs(i - i2);
        this.Ir = i2;
        if (abs < this.Iq) {
            this.It = false;
        }
        this.Iu = new a(context);
        this.Iv = i3;
    }

    public void a(com.baidu.adp.widget.ScrollView.g gVar) {
        this.Is = gVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int Iy;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void lt() {
            if (r.this.mHandler != null) {
                r.this.mHandler.removeCallbacks(r.this.Iw);
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
                if (this.mScroller.timePassed() >= r.this.Iv) {
                    computeScrollOffset = false;
                }
                int currY = this.mScroller.getCurrY();
                int i = currY - this.Iy;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = r.this.move(i) ? false : true;
                        this.Iy = currY;
                    }
                    z = r1;
                    if (!z) {
                        r.this.mView.post(this);
                    }
                }
                if (z) {
                    r.this.mHandler.removeCallbacks(r.this.Iw);
                    r.this.mHandler.post(r.this.Iw);
                }
            }
        }

        public void s(int i, int i2) {
            if (r.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                lt();
                this.Iy = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                r.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lu() {
            r.this.mHandler.removeCallbacks(r.this.Iw);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (r.this.mView != null) {
                r.this.mView.removeCallbacks(this);
            }
            if (r.this.Is != null) {
                r.this.Is.ls();
            }
        }
    }

    public void r(View view) {
        if (this.It && this.Iu != null) {
            this.mView = view;
            this.Iu.s(Math.abs(this.Ir), this.Iv);
            this.mHandler.postDelayed(this.Iw, this.Iv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.Ir) {
            paddingTop = this.Ir;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
