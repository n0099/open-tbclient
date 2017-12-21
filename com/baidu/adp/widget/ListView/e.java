package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class e {
    private int Hl;
    private com.baidu.adp.widget.b.a Hm;
    private boolean Hn;
    a Ho;
    int mDuration;
    View mView;
    private int Hk = 1;
    Handler mHandler = new Handler();
    Runnable Hp = new Runnable() { // from class: com.baidu.adp.widget.ListView.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.Ho == null) {
                return;
            }
            e.this.Ho.lf();
        }
    };

    public e(Context context, int i, int i2, int i3) {
        this.Hn = true;
        int abs = Math.abs(i - i2);
        this.Hl = i2;
        if (abs < this.Hk) {
            this.Hn = false;
        }
        this.Ho = new a(context);
        this.mDuration = i3;
    }

    public void a(com.baidu.adp.widget.b.a aVar) {
        this.Hm = aVar;
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private int Hr;
        private Scroller mScroller;

        a(Context context) {
            this.mScroller = new Scroller(context);
        }

        private void le() {
            if (e.this.mHandler != null) {
                e.this.mHandler.removeCallbacks(e.this.Hp);
            }
            if (e.this.mView != null) {
                e.this.mView.removeCallbacks(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = true;
            if (e.this.mView != null && this.mScroller != null) {
                boolean computeScrollOffset = this.mScroller.computeScrollOffset();
                if (this.mScroller.timePassed() >= e.this.mDuration) {
                    computeScrollOffset = false;
                }
                int currY = this.mScroller.getCurrY();
                int i = currY - this.Hr;
                if (computeScrollOffset) {
                    if (i != 0) {
                        r1 = e.this.move(i) ? false : true;
                        this.Hr = currY;
                    }
                    z = r1;
                    if (!z) {
                        e.this.mView.post(this);
                    }
                }
                if (z) {
                    e.this.mHandler.removeCallbacks(e.this.Hp);
                    e.this.mHandler.post(e.this.Hp);
                }
            }
        }

        public void r(int i, int i2) {
            if (e.this.mView != null && this.mScroller != null) {
                int i3 = i == 0 ? i - 1 : i;
                le();
                this.Hr = 0;
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                e.this.mView.post(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lf() {
            e.this.mHandler.removeCallbacks(e.this.Hp);
            if (this.mScroller != null) {
                this.mScroller.abortAnimation();
                this.mScroller.forceFinished(true);
            }
            if (e.this.mView != null) {
                e.this.mView.removeCallbacks(this);
            }
            if (e.this.Hm != null) {
                e.this.Hm.onOver();
            }
        }
    }

    public void r(View view) {
        if (this.Hn && this.Ho != null) {
            this.mView = view;
            this.Ho.r(Math.abs(this.Hl), this.mDuration);
            this.mHandler.postDelayed(this.Hp, this.mDuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.Hl) {
            paddingTop = this.Hl;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
