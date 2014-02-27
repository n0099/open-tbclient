package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.widget.Scroller;
/* loaded from: classes.dex */
public final class y implements Runnable {
    final /* synthetic */ w a;
    private int b;
    private Scroller c;

    public y(w wVar, Context context) {
        this.a = wVar;
        this.c = new Scroller(context);
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = true;
        if (this.a.c != null && this.c != null) {
            boolean computeScrollOffset = this.c.computeScrollOffset();
            if (this.c.timePassed() >= this.a.b) {
                computeScrollOffset = false;
            }
            int currY = this.c.getCurrY();
            int i = currY - this.b;
            if (computeScrollOffset) {
                if (i != 0) {
                    r1 = w.a(this.a, i) ? false : true;
                    this.b = currY;
                }
                z = r1;
                if (!z) {
                    this.a.c.post(this);
                }
            }
            if (z) {
                this.a.d.removeCallbacks(this.a.e);
                this.a.d.post(this.a.e);
            }
        }
    }

    public final void a(int i, int i2) {
        if (this.a.c != null && this.c != null) {
            int i3 = i == 0 ? i - 1 : i;
            if (this.a.d != null) {
                this.a.d.removeCallbacks(this.a.e);
            }
            if (this.a.c != null) {
                this.a.c.removeCallbacks(this);
            }
            this.b = 0;
            this.c.startScroll(0, 0, 0, i3, i2);
            this.a.c.post(this);
        }
    }

    public static /* synthetic */ void a(y yVar) {
        com.baidu.adp.widget.ScrollView.i iVar;
        com.baidu.adp.widget.ScrollView.i iVar2;
        yVar.a.d.removeCallbacks(yVar.a.e);
        if (yVar.c != null) {
            yVar.c.abortAnimation();
            yVar.c.forceFinished(true);
        }
        if (yVar.a.c != null) {
            yVar.a.c.removeCallbacks(yVar);
        }
        iVar = yVar.a.h;
        if (iVar != null) {
            iVar2 = yVar.a.h;
            iVar2.a();
        }
    }
}
