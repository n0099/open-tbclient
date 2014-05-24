package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class ae implements Runnable {
    final /* synthetic */ ac a;
    private int b;
    private Scroller c;

    public ae(ac acVar, Context context) {
        this.a = acVar;
        this.c = new Scroller(context);
    }

    private void a() {
        if (this.a.d != null) {
            this.a.d.removeCallbacks(this.a.e);
        }
        if (this.a.c != null) {
            this.a.c.removeCallbacks(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean a;
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
                    a = this.a.a(i);
                    r1 = a ? false : true;
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

    public void a(int i, int i2) {
        if (this.a.c != null && this.c != null) {
            int i3 = i == 0 ? i - 1 : i;
            a();
            this.b = 0;
            this.c.startScroll(0, 0, 0, i3, i2);
            this.a.c.post(this);
        }
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.ListView.ad.run():void] */
    public static /* synthetic */ void a(ae aeVar) {
        aeVar.b();
    }

    public void b() {
        com.baidu.adp.widget.ScrollView.i iVar;
        com.baidu.adp.widget.ScrollView.i iVar2;
        this.a.d.removeCallbacks(this.a.e);
        if (this.c != null) {
            this.c.abortAnimation();
            this.c.forceFinished(true);
        }
        if (this.a.c != null) {
            this.a.c.removeCallbacks(this);
        }
        iVar = this.a.h;
        if (iVar != null) {
            iVar2 = this.a.h;
            iVar2.a();
        }
    }
}
