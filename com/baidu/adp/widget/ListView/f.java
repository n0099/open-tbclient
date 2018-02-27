package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class f {
    private int avb;
    private com.baidu.adp.widget.b.a avc;
    private boolean avd;
    a ave;
    int mDuration;
    View mView;
    private int ava = 1;
    Handler mHandler = new Handler();
    Runnable avf = new Runnable() { // from class: com.baidu.adp.widget.ListView.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.ave == null) {
                return;
            }
            f.this.ave.sD();
        }
    };

    public f(Context context, int i, int i2, int i3) {
        this.avd = true;
        int abs = Math.abs(i - i2);
        this.avb = i2;
        if (abs < this.ava) {
            this.avd = false;
        }
        this.ave = new a(context);
        this.mDuration = i3;
    }

    public void a(com.baidu.adp.widget.b.a aVar) {
        this.avc = aVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int Tv;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void sC() {
            if (f.this.mHandler != null) {
                f.this.mHandler.removeCallbacks(f.this.avf);
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
                int i = currY - this.Tv;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = f.this.move(i) ? false : true;
                        this.Tv = currY;
                    }
                    z = r1;
                    if (!z) {
                        f.this.mView.post(this);
                    }
                }
                if (z) {
                    f.this.mHandler.removeCallbacks(f.this.avf);
                    f.this.mHandler.post(f.this.avf);
                }
            }
        }

        public void aq(int i, int i2) {
            if (f.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                sC();
                this.Tv = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                f.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sD() {
            f.this.mHandler.removeCallbacks(f.this.avf);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (f.this.mView != null) {
                f.this.mView.removeCallbacks(this);
            }
            if (f.this.avc != null) {
                f.this.avc.onOver();
            }
        }
    }

    public void aJ(View view) {
        if (this.avd && this.ave != null) {
            this.mView = view;
            this.ave.aq(Math.abs(this.avb), this.mDuration);
            this.mHandler.postDelayed(this.avf, this.mDuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.avb) {
            paddingTop = this.avb;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
