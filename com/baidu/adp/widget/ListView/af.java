package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class af implements Runnable {
    final /* synthetic */ ad Ig;
    private int Ih;
    private Scroller mScroller;

    public af(ad adVar, Context context) {
        this.Ig = adVar;
        this.mScroller = new Scroller(context);
    }

    private void nt() {
        if (this.Ig.mHandler != null) {
            this.Ig.mHandler.removeCallbacks(this.Ig.If);
        }
        if (this.Ig.mView != null) {
            this.Ig.mView.removeCallbacks(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean move;
        boolean z = true;
        if (this.Ig.mView != null && this.mScroller != null) {
            boolean computeScrollOffset = this.mScroller.computeScrollOffset();
            if (this.mScroller.timePassed() >= this.Ig.mDuration) {
                computeScrollOffset = false;
            }
            int currY = this.mScroller.getCurrY();
            int i = currY - this.Ih;
            if (computeScrollOffset) {
                if (i != 0) {
                    move = this.Ig.move(i);
                    r1 = move ? false : true;
                    this.Ih = currY;
                }
                z = r1;
                if (!z) {
                    this.Ig.mView.post(this);
                }
            }
            if (z) {
                this.Ig.mHandler.removeCallbacks(this.Ig.If);
                this.Ig.mHandler.post(this.Ig.If);
            }
        }
    }

    public void h(int i, int i2) {
        if (this.Ig.mView != null && this.mScroller != null) {
            int i3 = i == 0 ? i - 1 : i;
            nt();
            this.Ih = 0;
            this.mScroller.startScroll(0, 0, 0, i3, i2);
            this.Ig.mView.post(this);
        }
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.ListView.ae.run():void] */
    public static /* synthetic */ void a(af afVar) {
        afVar.nu();
    }

    public void nu() {
        com.baidu.adp.widget.ScrollView.g gVar;
        com.baidu.adp.widget.ScrollView.g gVar2;
        this.Ig.mHandler.removeCallbacks(this.Ig.If);
        if (this.mScroller != null) {
            this.mScroller.abortAnimation();
            this.mScroller.forceFinished(true);
        }
        if (this.Ig.mView != null) {
            this.Ig.mView.removeCallbacks(this);
        }
        gVar = this.Ig.Ic;
        if (gVar != null) {
            gVar2 = this.Ig.Ic;
            gVar2.ns();
        }
    }
}
