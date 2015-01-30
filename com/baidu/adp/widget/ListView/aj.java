package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class aj implements Runnable {
    private Scroller mScroller;
    private int xA;
    final /* synthetic */ ah xz;

    public aj(ah ahVar, Context context) {
        this.xz = ahVar;
        this.mScroller = new Scroller(context);
    }

    private void jO() {
        if (this.xz.mHandler != null) {
            this.xz.mHandler.removeCallbacks(this.xz.xy);
        }
        if (this.xz.mView != null) {
            this.xz.mView.removeCallbacks(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean move;
        boolean z = true;
        if (this.xz.mView != null && this.mScroller != null) {
            boolean computeScrollOffset = this.mScroller.computeScrollOffset();
            if (this.mScroller.timePassed() >= this.xz.mDuration) {
                computeScrollOffset = false;
            }
            int currY = this.mScroller.getCurrY();
            int i = currY - this.xA;
            if (computeScrollOffset) {
                if (i != 0) {
                    move = this.xz.move(i);
                    r1 = move ? false : true;
                    this.xA = currY;
                }
                z = r1;
                if (!z) {
                    this.xz.mView.post(this);
                }
            }
            if (z) {
                this.xz.mHandler.removeCallbacks(this.xz.xy);
                this.xz.mHandler.post(this.xz.xy);
            }
        }
    }

    public void i(int i, int i2) {
        if (this.xz.mView != null && this.mScroller != null) {
            int i3 = i == 0 ? i - 1 : i;
            jO();
            this.xA = 0;
            this.mScroller.startScroll(0, 0, 0, i3, i2);
            this.xz.mView.post(this);
        }
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.ListView.ai.run():void] */
    public static /* synthetic */ void a(aj ajVar) {
        ajVar.jP();
    }

    public void jP() {
        com.baidu.adp.widget.ScrollView.g gVar;
        com.baidu.adp.widget.ScrollView.g gVar2;
        this.xz.mHandler.removeCallbacks(this.xz.xy);
        if (this.mScroller != null) {
            this.mScroller.abortAnimation();
            this.mScroller.forceFinished(true);
        }
        if (this.xz.mView != null) {
            this.xz.mView.removeCallbacks(this);
        }
        gVar = this.xz.xv;
        if (gVar != null) {
            gVar2 = this.xz.xv;
            gVar2.jN();
        }
    }
}
