package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class y implements Runnable {

    /* renamed from: a */
    final /* synthetic */ w f584a;
    private int b;
    private Scroller c;

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.ListView.x.run():void] */
    public static /* synthetic */ void a(y yVar) {
        yVar.b();
    }

    public y(w wVar, Context context) {
        this.f584a = wVar;
        this.c = new Scroller(context);
    }

    private void a() {
        if (this.f584a.d != null) {
            this.f584a.d.removeCallbacks(this.f584a.e);
        }
        if (this.f584a.c != null) {
            this.f584a.c.removeCallbacks(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean a2;
        boolean z = true;
        if (this.f584a.c != null && this.c != null) {
            boolean computeScrollOffset = this.c.computeScrollOffset();
            if (this.c.timePassed() >= this.f584a.b) {
                computeScrollOffset = false;
            }
            int currY = this.c.getCurrY();
            int i = currY - this.b;
            if (computeScrollOffset) {
                if (i != 0) {
                    a2 = this.f584a.a(i);
                    r1 = a2 ? false : true;
                    this.b = currY;
                }
                z = r1;
                if (!z) {
                    this.f584a.c.post(this);
                }
            }
            if (z) {
                this.f584a.d.removeCallbacks(this.f584a.e);
                this.f584a.d.post(this.f584a.e);
            }
        }
    }

    public void a(int i, int i2) {
        if (this.f584a.c != null && this.c != null) {
            int i3 = i == 0 ? i - 1 : i;
            a();
            this.b = 0;
            this.c.startScroll(0, 0, 0, i3, i2);
            this.f584a.c.post(this);
        }
    }

    public void b() {
        com.baidu.adp.widget.ScrollView.i iVar;
        com.baidu.adp.widget.ScrollView.i iVar2;
        this.f584a.d.removeCallbacks(this.f584a.e);
        if (this.c != null) {
            this.c.abortAnimation();
            this.c.forceFinished(true);
        }
        if (this.f584a.c != null) {
            this.f584a.c.removeCallbacks(this);
        }
        iVar = this.f584a.h;
        if (iVar != null) {
            iVar2 = this.f584a.h;
            iVar2.a();
        }
    }
}
