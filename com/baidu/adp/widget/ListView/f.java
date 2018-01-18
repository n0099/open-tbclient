package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class f {
    private int avm;
    private com.baidu.adp.widget.b.a avn;
    private boolean avo;
    a avp;
    int mDuration;
    View mView;
    private int avl = 1;
    Handler mHandler = new Handler();
    Runnable avq = new Runnable() { // from class: com.baidu.adp.widget.ListView.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.avp == null) {
                return;
            }
            f.this.avp.sE();
        }
    };

    public f(Context context, int i, int i2, int i3) {
        this.avo = true;
        int abs = Math.abs(i - i2);
        this.avm = i2;
        if (abs < this.avl) {
            this.avo = false;
        }
        this.avp = new a(context);
        this.mDuration = i3;
    }

    public void a(com.baidu.adp.widget.b.a aVar) {
        this.avn = aVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int TC;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void sD() {
            if (f.this.mHandler != null) {
                f.this.mHandler.removeCallbacks(f.this.avq);
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
                    f.this.mHandler.removeCallbacks(f.this.avq);
                    f.this.mHandler.post(f.this.avq);
                }
            }
        }

        public void aq(int i, int i2) {
            if (f.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                sD();
                this.TC = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                f.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sE() {
            f.this.mHandler.removeCallbacks(f.this.avq);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (f.this.mView != null) {
                f.this.mView.removeCallbacks(this);
            }
            if (f.this.avn != null) {
                f.this.avn.onOver();
            }
        }
    }

    public void aJ(View view) {
        if (this.avo && this.avp != null) {
            this.mView = view;
            this.avp.aq(Math.abs(this.avm), this.mDuration);
            this.mHandler.postDelayed(this.avq, this.mDuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.avm) {
            paddingTop = this.avm;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
