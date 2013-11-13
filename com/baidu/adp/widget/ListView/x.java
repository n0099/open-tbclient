package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class x implements Runnable {

    /* renamed from: a */
    final /* synthetic */ v f580a;
    private int b;
    private Scroller c;

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.ListView.w.run():void] */
    public static /* synthetic */ void a(x xVar) {
        xVar.b();
    }

    public x(v vVar, Context context) {
        this.f580a = vVar;
        this.c = new Scroller(context);
    }

    private void a() {
        if (this.f580a.d != null) {
            this.f580a.d.removeCallbacks(this.f580a.e);
        }
        if (this.f580a.c != null) {
            this.f580a.c.removeCallbacks(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean a2;
        boolean z = true;
        if (this.f580a.c != null && this.c != null) {
            boolean computeScrollOffset = this.c.computeScrollOffset();
            if (this.c.timePassed() >= this.f580a.b) {
                computeScrollOffset = false;
            }
            int currY = this.c.getCurrY();
            int i = currY - this.b;
            if (computeScrollOffset) {
                if (i != 0) {
                    a2 = this.f580a.a(i);
                    r1 = a2 ? false : true;
                    this.b = currY;
                }
                z = r1;
                if (!z) {
                    this.f580a.c.post(this);
                }
            }
            if (z) {
                this.f580a.d.removeCallbacks(this.f580a.e);
                this.f580a.d.post(this.f580a.e);
            }
        }
    }

    public void a(int i, int i2) {
        if (this.f580a.c != null && this.c != null) {
            int i3 = i == 0 ? i - 1 : i;
            a();
            this.b = 0;
            this.c.startScroll(0, 0, 0, i3, i2);
            this.f580a.c.post(this);
        }
    }

    public void b() {
        com.baidu.adp.widget.ScrollView.i iVar;
        com.baidu.adp.widget.ScrollView.i iVar2;
        this.f580a.d.removeCallbacks(this.f580a.e);
        if (this.c != null) {
            this.c.abortAnimation();
            this.c.forceFinished(true);
        }
        if (this.f580a.c != null) {
            this.f580a.c.removeCallbacks(this);
        }
        iVar = this.f580a.h;
        if (iVar != null) {
            iVar2 = this.f580a.h;
            iVar2.a();
        }
    }
}
