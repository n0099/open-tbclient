package com.baidu.adp.widget.ListView;
/* loaded from: classes.dex */
class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdListView f206a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(BdListView bdListView) {
        this.f206a = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        q qVar;
        e eVar;
        q qVar2;
        e eVar2;
        e eVar3;
        e eVar4;
        e eVar5;
        e eVar6;
        e eVar7;
        int i = 0;
        int i2 = -1;
        qVar = this.f206a.h;
        if (qVar != null) {
            int firstVisiblePosition = this.f206a.getFirstVisiblePosition();
            int lastVisiblePosition = this.f206a.getLastVisiblePosition();
            eVar = this.f206a.f199a;
            if (eVar != null) {
                eVar2 = this.f206a.f199a;
                if (eVar2.b() != null) {
                    eVar3 = this.f206a.f199a;
                    if (eVar3.a() > 0) {
                        eVar4 = this.f206a.f199a;
                        i2 = firstVisiblePosition - eVar4.c();
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        eVar5 = this.f206a.f199a;
                        int c = lastVisiblePosition - eVar5.c();
                        eVar6 = this.f206a.f199a;
                        if (c >= eVar6.a()) {
                            eVar7 = this.f206a.f199a;
                            c = eVar7.a() - 1;
                        }
                        if (c >= 0) {
                            i = c;
                        }
                        qVar2 = this.f206a.h;
                        qVar2.a(i2, i);
                    }
                }
            }
            i = -1;
            qVar2 = this.f206a.h;
            qVar2.a(i2, i);
        }
    }
}
