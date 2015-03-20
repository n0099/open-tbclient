package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class af implements Runnable {
    final /* synthetic */ ad Io;
    private int Ip;
    private Scroller mScroller;

    public af(ad adVar, Context context) {
        this.Io = adVar;
        this.mScroller = new Scroller(context);
    }

    private void nc() {
        if (this.Io.mHandler != null) {
            this.Io.mHandler.removeCallbacks(this.Io.In);
        }
        if (this.Io.mView != null) {
            this.Io.mView.removeCallbacks(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean move;
        boolean z = true;
        if (this.Io.mView != null && this.mScroller != null) {
            boolean computeScrollOffset = this.mScroller.computeScrollOffset();
            if (this.mScroller.timePassed() >= this.Io.mDuration) {
                computeScrollOffset = false;
            }
            int currY = this.mScroller.getCurrY();
            int i = currY - this.Ip;
            if (computeScrollOffset) {
                if (i != 0) {
                    move = this.Io.move(i);
                    r1 = move ? false : true;
                    this.Ip = currY;
                }
                z = r1;
                if (!z) {
                    this.Io.mView.post(this);
                }
            }
            if (z) {
                this.Io.mHandler.removeCallbacks(this.Io.In);
                this.Io.mHandler.post(this.Io.In);
            }
        }
    }

    public void h(int i, int i2) {
        if (this.Io.mView != null && this.mScroller != null) {
            int i3 = i == 0 ? i - 1 : i;
            nc();
            this.Ip = 0;
            this.mScroller.startScroll(0, 0, 0, i3, i2);
            this.Io.mView.post(this);
        }
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.ListView.ae.run():void] */
    public static /* synthetic */ void a(af afVar) {
        afVar.nd();
    }

    public void nd() {
        com.baidu.adp.widget.ScrollView.g gVar;
        com.baidu.adp.widget.ScrollView.g gVar2;
        this.Io.mHandler.removeCallbacks(this.Io.In);
        if (this.mScroller != null) {
            this.mScroller.abortAnimation();
            this.mScroller.forceFinished(true);
        }
        if (this.Io.mView != null) {
            this.Io.mView.removeCallbacks(this);
        }
        gVar = this.Io.Ik;
        if (gVar != null) {
            gVar2 = this.Io.Ik;
            gVar2.nb();
        }
    }
}
