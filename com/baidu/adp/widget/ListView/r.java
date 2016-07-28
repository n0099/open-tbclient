package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class r {
    private com.baidu.adp.widget.ScrollView.g Aa;
    private boolean Ab;
    a Ac;
    int Ae;
    View mView;
    private int zZ;
    private int zY = 1;
    Handler mHandler = new Handler();
    Runnable Af = new s(this);

    public r(Context context, int i, int i2, int i3) {
        this.Ab = true;
        int abs = Math.abs(i - i2);
        this.zZ = i2;
        if (abs < this.zY) {
            this.Ab = false;
        }
        this.Ac = new a(context);
        this.Ae = i3;
    }

    public void a(com.baidu.adp.widget.ScrollView.g gVar) {
        this.Aa = gVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int Ah;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void jH() {
            if (r.this.mHandler != null) {
                r.this.mHandler.removeCallbacks(r.this.Af);
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
                if (this.mScroller.timePassed() >= r.this.Ae) {
                    computeScrollOffset = false;
                }
                int currY = this.mScroller.getCurrY();
                int i = currY - this.Ah;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = r.this.move(i) ? false : true;
                        this.Ah = currY;
                    }
                    z = r1;
                    if (!z) {
                        r.this.mView.post(this);
                    }
                }
                if (z) {
                    r.this.mHandler.removeCallbacks(r.this.Af);
                    r.this.mHandler.post(r.this.Af);
                }
            }
        }

        public void j(int i, int i2) {
            if (r.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                jH();
                this.Ah = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                r.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void jI() {
            r.this.mHandler.removeCallbacks(r.this.Af);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (r.this.mView != null) {
                r.this.mView.removeCallbacks(this);
            }
            if (r.this.Aa != null) {
                r.this.Aa.jG();
            }
        }
    }

    public void t(View view) {
        if (this.Ab && this.Ac != null) {
            this.mView = view;
            this.Ac.j(Math.abs(this.zZ), this.Ae);
            this.mHandler.postDelayed(this.Af, this.Ae);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.zZ) {
            paddingTop = this.zZ;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
