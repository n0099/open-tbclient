package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h implements Runnable {
    final /* synthetic */ BdListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(BdListView bdListView) {
        this.a = bdListView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q qVar;
        e eVar;
        q qVar2;
        e eVar2;
        e eVar3;
        e eVar4;
        e eVar5;
        e eVar6;
        e eVar7;
        qVar = this.a.h;
        if (qVar != null) {
            this.a.getFirstVisiblePosition();
            int lastVisiblePosition = this.a.getLastVisiblePosition();
            eVar = this.a.a;
            if (eVar != null) {
                eVar2 = this.a.a;
                if (eVar2.b() != null) {
                    eVar3 = this.a.a;
                    if (eVar3.a() > 0) {
                        eVar4 = this.a.a;
                        eVar4.c();
                        eVar5 = this.a.a;
                        int c = lastVisiblePosition - eVar5.c();
                        eVar6 = this.a.a;
                        if (c >= eVar6.a()) {
                            eVar7 = this.a.a;
                            eVar7.a();
                        }
                    }
                }
            }
            qVar2 = this.a.h;
            qVar2.a();
        }
    }
}
