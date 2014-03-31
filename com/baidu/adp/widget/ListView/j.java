package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j implements Runnable {
    final /* synthetic */ BdListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BdListView bdListView) {
        this.a = bdListView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s sVar;
        g gVar;
        s sVar2;
        g gVar2;
        g gVar3;
        g gVar4;
        g gVar5;
        g gVar6;
        g gVar7;
        sVar = this.a.h;
        if (sVar != null) {
            this.a.getFirstVisiblePosition();
            int lastVisiblePosition = this.a.getLastVisiblePosition();
            gVar = this.a.a;
            if (gVar != null) {
                gVar2 = this.a.a;
                if (gVar2.b() != null) {
                    gVar3 = this.a.a;
                    if (gVar3.a() > 0) {
                        gVar4 = this.a.a;
                        gVar4.c();
                        gVar5 = this.a.a;
                        int c = lastVisiblePosition - gVar5.c();
                        gVar6 = this.a.a;
                        if (c >= gVar6.a()) {
                            gVar7 = this.a.a;
                            gVar7.a();
                        }
                    }
                }
            }
            sVar2 = this.a.h;
            sVar2.a();
        }
    }
}
