package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class f {
    private int Pl;
    private com.baidu.adp.widget.b.a Pm;
    private boolean Pn;
    a Po;
    int mDuration;
    View mView;
    private int Pk = 1;
    Handler mHandler = new Handler();
    Runnable Pp = new Runnable() { // from class: com.baidu.adp.widget.ListView.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.Po == null) {
                return;
            }
            f.this.Po.oS();
        }
    };

    public f(Context context, int i, int i2, int i3) {
        this.Pn = true;
        int abs = Math.abs(i - i2);
        this.Pl = i2;
        if (abs < this.Pk) {
            this.Pn = false;
        }
        this.Po = new a(context);
        this.mDuration = i3;
    }

    public void a(com.baidu.adp.widget.b.a aVar) {
        this.Pm = aVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int mLastFlingY;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void oR() {
            if (f.this.mHandler != null) {
                f.this.mHandler.removeCallbacks(f.this.Pp);
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
                int i = currY - this.mLastFlingY;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = f.this.move(i) ? false : true;
                        this.mLastFlingY = currY;
                    }
                    z = r1;
                    if (!z) {
                        f.this.mView.post(this);
                    }
                }
                if (z) {
                    f.this.mHandler.removeCallbacks(f.this.Pp);
                    f.this.mHandler.post(f.this.Pp);
                }
            }
        }

        public void r(int i, int i2) {
            if (f.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                oR();
                this.mLastFlingY = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                f.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void oS() {
            f.this.mHandler.removeCallbacks(f.this.Pp);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (f.this.mView != null) {
                f.this.mView.removeCallbacks(this);
            }
            if (f.this.Pm != null) {
                f.this.Pm.onOver();
            }
        }
    }

    public void B(View view) {
        if (this.Pn && this.Po != null) {
            this.mView = view;
            this.Po.r(Math.abs(this.Pl), this.mDuration);
            this.mHandler.postDelayed(this.Pp, this.mDuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.Pl) {
            paddingTop = this.Pl;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
