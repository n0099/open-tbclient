package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ BdListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdListView bdListView) {
        this.a = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        g gVar;
        w wVar2;
        g gVar2;
        g gVar3;
        g gVar4;
        g gVar5;
        g gVar6;
        g gVar7;
        int i = 0;
        int i2 = -1;
        wVar = this.a.i;
        if (wVar != null) {
            int firstVisiblePosition = this.a.getFirstVisiblePosition();
            int lastVisiblePosition = this.a.getLastVisiblePosition();
            gVar = this.a.b;
            if (gVar != null) {
                gVar2 = this.a.b;
                if (gVar2.b() != null) {
                    gVar3 = this.a.b;
                    if (gVar3.a() > 0) {
                        gVar4 = this.a.b;
                        i2 = firstVisiblePosition - gVar4.c();
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        gVar5 = this.a.b;
                        int c = lastVisiblePosition - gVar5.c();
                        gVar6 = this.a.b;
                        if (c >= gVar6.a()) {
                            gVar7 = this.a.b;
                            c = gVar7.a() - 1;
                        }
                        if (c >= 0) {
                            i = c;
                        }
                        wVar2 = this.a.i;
                        wVar2.a(i2, i);
                    }
                }
            }
            i = -1;
            wVar2 = this.a.i;
            wVar2.a(i2, i);
        }
    }
}
