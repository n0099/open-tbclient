package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class r {
    private int Ip;
    private com.baidu.adp.widget.ScrollView.g Iq;
    private boolean Ir;
    a Is;
    int It;
    View mView;
    private int Io = 1;
    Handler mHandler = new Handler();
    Runnable Iu = new s(this);

    public r(Context context, int i, int i2, int i3) {
        this.Ir = true;
        int abs = Math.abs(i - i2);
        this.Ip = i2;
        if (abs < this.Io) {
            this.Ir = false;
        }
        this.Is = new a(context);
        this.It = i3;
    }

    public void a(com.baidu.adp.widget.ScrollView.g gVar) {
        this.Iq = gVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int Iw;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void ls() {
            if (r.this.mHandler != null) {
                r.this.mHandler.removeCallbacks(r.this.Iu);
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
                if (this.mScroller.timePassed() >= r.this.It) {
                    computeScrollOffset = false;
                }
                int currY = this.mScroller.getCurrY();
                int i = currY - this.Iw;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = r.this.move(i) ? false : true;
                        this.Iw = currY;
                    }
                    z = r1;
                    if (!z) {
                        r.this.mView.post(this);
                    }
                }
                if (z) {
                    r.this.mHandler.removeCallbacks(r.this.Iu);
                    r.this.mHandler.post(r.this.Iu);
                }
            }
        }

        public void s(int i, int i2) {
            if (r.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                ls();
                this.Iw = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                r.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lt() {
            r.this.mHandler.removeCallbacks(r.this.Iu);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (r.this.mView != null) {
                r.this.mView.removeCallbacks(this);
            }
            if (r.this.Iq != null) {
                r.this.Iq.lr();
            }
        }
    }

    public void r(View view) {
        if (this.Ir && this.Is != null) {
            this.mView = view;
            this.Is.s(Math.abs(this.Ip), this.It);
            this.mHandler.postDelayed(this.Iu, this.It);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.Ip) {
            paddingTop = this.Ip;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
