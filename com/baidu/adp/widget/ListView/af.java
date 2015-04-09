package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class af implements Runnable {
    final /* synthetic */ ad Iq;
    private int Ir;
    private Scroller mScroller;

    public af(ad adVar, Context context) {
        this.Iq = adVar;
        this.mScroller = new Scroller(context);
    }

    private void nc() {
        if (this.Iq.mHandler != null) {
            this.Iq.mHandler.removeCallbacks(this.Iq.Ip);
        }
        if (this.Iq.mView != null) {
            this.Iq.mView.removeCallbacks(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean move;
        boolean z = true;
        if (this.Iq.mView != null && this.mScroller != null) {
            boolean computeScrollOffset = this.mScroller.computeScrollOffset();
            if (this.mScroller.timePassed() >= this.Iq.mDuration) {
                computeScrollOffset = false;
            }
            int currY = this.mScroller.getCurrY();
            int i = currY - this.Ir;
            if (computeScrollOffset) {
                if (i != 0) {
                    move = this.Iq.move(i);
                    r1 = move ? false : true;
                    this.Ir = currY;
                }
                z = r1;
                if (!z) {
                    this.Iq.mView.post(this);
                }
            }
            if (z) {
                this.Iq.mHandler.removeCallbacks(this.Iq.Ip);
                this.Iq.mHandler.post(this.Iq.Ip);
            }
        }
    }

    public void h(int i, int i2) {
        if (this.Iq.mView != null && this.mScroller != null) {
            int i3 = i == 0 ? i - 1 : i;
            nc();
            this.Ir = 0;
            this.mScroller.startScroll(0, 0, 0, i3, i2);
            this.Iq.mView.post(this);
        }
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.ListView.ae.run():void] */
    public static /* synthetic */ void a(af afVar) {
        afVar.nd();
    }

    public void nd() {
        com.baidu.adp.widget.ScrollView.g gVar;
        com.baidu.adp.widget.ScrollView.g gVar2;
        this.Iq.mHandler.removeCallbacks(this.Iq.Ip);
        if (this.mScroller != null) {
            this.mScroller.abortAnimation();
            this.mScroller.forceFinished(true);
        }
        if (this.Iq.mView != null) {
            this.Iq.mView.removeCallbacks(this);
        }
        gVar = this.Iq.Im;
        if (gVar != null) {
            gVar2 = this.Iq.Im;
            gVar2.nb();
        }
    }
}
