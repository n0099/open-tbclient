package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class f {
    private int avk;
    private com.baidu.adp.widget.b.a avl;
    private boolean avm;
    a avn;
    int mDuration;
    View mView;
    private int avj = 1;
    Handler mHandler = new Handler();
    Runnable avo = new Runnable() { // from class: com.baidu.adp.widget.ListView.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.avn == null) {
                return;
            }
            f.this.avn.sD();
        }
    };

    public f(Context context, int i, int i2, int i3) {
        this.avm = true;
        int abs = Math.abs(i - i2);
        this.avk = i2;
        if (abs < this.avj) {
            this.avm = false;
        }
        this.avn = new a(context);
        this.mDuration = i3;
    }

    public void a(com.baidu.adp.widget.b.a aVar) {
        this.avl = aVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int TB;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void sC() {
            if (f.this.mHandler != null) {
                f.this.mHandler.removeCallbacks(f.this.avo);
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
                int i = currY - this.TB;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = f.this.move(i) ? false : true;
                        this.TB = currY;
                    }
                    z = r1;
                    if (!z) {
                        f.this.mView.post(this);
                    }
                }
                if (z) {
                    f.this.mHandler.removeCallbacks(f.this.avo);
                    f.this.mHandler.post(f.this.avo);
                }
            }
        }

        public void aq(int i, int i2) {
            if (f.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                sC();
                this.TB = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                f.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sD() {
            f.this.mHandler.removeCallbacks(f.this.avo);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (f.this.mView != null) {
                f.this.mView.removeCallbacks(this);
            }
            if (f.this.avl != null) {
                f.this.avl.onOver();
            }
        }
    }

    public void aJ(View view) {
        if (this.avm && this.avn != null) {
            this.mView = view;
            this.avn.aq(Math.abs(this.avk), this.mDuration);
            this.mHandler.postDelayed(this.avo, this.mDuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.avk) {
            paddingTop = this.avk;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
