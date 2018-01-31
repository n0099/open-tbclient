package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class f {
    private int avp;
    private com.baidu.adp.widget.b.a avq;
    private boolean avr;
    a avs;
    int mDuration;
    View mView;
    private int avo = 1;
    Handler mHandler = new Handler();
    Runnable avt = new Runnable() { // from class: com.baidu.adp.widget.ListView.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.avs == null) {
                return;
            }
            f.this.avs.sF();
        }
    };

    public f(Context context, int i, int i2, int i3) {
        this.avr = true;
        int abs = Math.abs(i - i2);
        this.avp = i2;
        if (abs < this.avo) {
            this.avr = false;
        }
        this.avs = new a(context);
        this.mDuration = i3;
    }

    public void a(com.baidu.adp.widget.b.a aVar) {
        this.avq = aVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int TC;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void sE() {
            if (f.this.mHandler != null) {
                f.this.mHandler.removeCallbacks(f.this.avt);
            }
            if (f.this.mView != null) {
                f.this.mView.removeCallbacks(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = true;
            if (f.this.mView != null && this.mScroller != null) {
                boolean computeScrollOffset = this.mScroller.computeScrollOffset();
                if (this.mScroller.timePassed() >= f.this.mDuration) {
                    computeScrollOffset = false;
                }
                int currY = this.mScroller.getCurrY();
                int i = currY - this.TC;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = f.this.move(i) ? false : true;
                        this.TC = currY;
                    }
                    z = r1;
                    if (!z) {
                        f.this.mView.post(this);
                    }
                }
                if (z) {
                    f.this.mHandler.removeCallbacks(f.this.avt);
                    f.this.mHandler.post(f.this.avt);
                }
            }
        }

        public void aq(int i, int i2) {
            if (f.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                sE();
                this.TC = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                f.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sF() {
            f.this.mHandler.removeCallbacks(f.this.avt);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (f.this.mView != null) {
                f.this.mView.removeCallbacks(this);
            }
            if (f.this.avq != null) {
                f.this.avq.onOver();
            }
        }
    }

    public void aJ(View view) {
        if (this.avr && this.avs != null) {
            this.mView = view;
            this.avs.aq(Math.abs(this.avp), this.mDuration);
            this.mHandler.postDelayed(this.avt, this.mDuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.avp) {
            paddingTop = this.avp;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
