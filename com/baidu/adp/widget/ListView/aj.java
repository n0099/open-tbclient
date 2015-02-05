package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class aj implements Runnable {
    private Scroller mScroller;
    final /* synthetic */ ah xw;
    private int xx;

    public aj(ah ahVar, Context context) {
        this.xw = ahVar;
        this.mScroller = new Scroller(context);
    }

    private void jH() {
        if (this.xw.mHandler != null) {
            this.xw.mHandler.removeCallbacks(this.xw.xv);
        }
        if (this.xw.mView != null) {
            this.xw.mView.removeCallbacks(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean move;
        boolean z = true;
        if (this.xw.mView != null && this.mScroller != null) {
            boolean computeScrollOffset = this.mScroller.computeScrollOffset();
            if (this.mScroller.timePassed() >= this.xw.mDuration) {
                computeScrollOffset = false;
            }
            int currY = this.mScroller.getCurrY();
            int i = currY - this.xx;
            if (computeScrollOffset) {
                if (i != 0) {
                    move = this.xw.move(i);
                    r1 = move ? false : true;
                    this.xx = currY;
                }
                z = r1;
                if (!z) {
                    this.xw.mView.post(this);
                }
            }
            if (z) {
                this.xw.mHandler.removeCallbacks(this.xw.xv);
                this.xw.mHandler.post(this.xw.xv);
            }
        }
    }

    public void i(int i, int i2) {
        if (this.xw.mView != null && this.mScroller != null) {
            int i3 = i == 0 ? i - 1 : i;
            jH();
            this.xx = 0;
            this.mScroller.startScroll(0, 0, 0, i3, i2);
            this.xw.mView.post(this);
        }
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.ListView.ai.run():void] */
    public static /* synthetic */ void a(aj ajVar) {
        ajVar.jI();
    }

    public void jI() {
        com.baidu.adp.widget.ScrollView.g gVar;
        com.baidu.adp.widget.ScrollView.g gVar2;
        this.xw.mHandler.removeCallbacks(this.xw.xv);
        if (this.mScroller != null) {
            this.mScroller.abortAnimation();
            this.mScroller.forceFinished(true);
        }
        if (this.xw.mView != null) {
            this.xw.mView.removeCallbacks(this);
        }
        gVar = this.xw.xs;
        if (gVar != null) {
            gVar2 = this.xw.xs;
            gVar2.jG();
        }
    }
}
