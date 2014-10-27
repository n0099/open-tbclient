package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class ai implements Runnable {
    private Scroller mScroller;
    final /* synthetic */ ag vw;
    private int vx;

    public ai(ag agVar, Context context) {
        this.vw = agVar;
        this.mScroller = new Scroller(context);
    }

    private void hV() {
        if (this.vw.mHandler != null) {
            this.vw.mHandler.removeCallbacks(this.vw.vv);
        }
        if (this.vw.mView != null) {
            this.vw.mView.removeCallbacks(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean move;
        boolean z = true;
        if (this.vw.mView != null && this.mScroller != null) {
            boolean computeScrollOffset = this.mScroller.computeScrollOffset();
            if (this.mScroller.timePassed() >= this.vw.vu) {
                computeScrollOffset = false;
            }
            int currY = this.mScroller.getCurrY();
            int i = currY - this.vx;
            if (computeScrollOffset) {
                if (i != 0) {
                    move = this.vw.move(i);
                    r1 = move ? false : true;
                    this.vx = currY;
                }
                z = r1;
                if (!z) {
                    this.vw.mView.post(this);
                }
            }
            if (z) {
                this.vw.mHandler.removeCallbacks(this.vw.vv);
                this.vw.mHandler.post(this.vw.vv);
            }
        }
    }

    public void g(int i, int i2) {
        if (this.vw.mView != null && this.mScroller != null) {
            int i3 = i == 0 ? i - 1 : i;
            hV();
            this.vx = 0;
            this.mScroller.startScroll(0, 0, 0, i3, i2);
            this.vw.mView.post(this);
        }
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.ListView.ah.run():void] */
    public static /* synthetic */ void a(ai aiVar) {
        aiVar.hW();
    }

    public void hW() {
        com.baidu.adp.widget.ScrollView.h hVar;
        com.baidu.adp.widget.ScrollView.h hVar2;
        this.vw.mHandler.removeCallbacks(this.vw.vv);
        if (this.mScroller != null) {
            this.mScroller.abortAnimation();
            this.mScroller.forceFinished(true);
        }
        if (this.vw.mView != null) {
            this.vw.mView.removeCallbacks(this);
        }
        hVar = this.vw.vr;
        if (hVar != null) {
            hVar2 = this.vw.vr;
            hVar2.hU();
        }
    }
}
