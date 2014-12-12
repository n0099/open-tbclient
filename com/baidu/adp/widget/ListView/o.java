package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ BdListView xm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(BdListView bdListView) {
        this.xm = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        aa aaVar;
        k kVar;
        aa aaVar2;
        k kVar2;
        k kVar3;
        k kVar4;
        k kVar5;
        k kVar6;
        k kVar7;
        int i = 0;
        int i2 = -1;
        aaVar = this.xm.wU;
        if (aaVar != null) {
            int firstVisiblePosition = this.xm.getFirstVisiblePosition();
            int lastVisiblePosition = this.xm.getLastVisiblePosition();
            kVar = this.xm.wN;
            if (kVar != null) {
                kVar2 = this.xm.wN;
                if (kVar2.getWrappedAdapter() != null) {
                    kVar3 = this.xm.wN;
                    if (kVar3.jF() > 0) {
                        kVar4 = this.xm.wN;
                        i2 = firstVisiblePosition - kVar4.getHeadersCount();
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        kVar5 = this.xm.wN;
                        int headersCount = lastVisiblePosition - kVar5.getHeadersCount();
                        kVar6 = this.xm.wN;
                        if (headersCount >= kVar6.jF()) {
                            kVar7 = this.xm.wN;
                            headersCount = kVar7.jF() - 1;
                        }
                        if (headersCount >= 0) {
                            i = headersCount;
                        }
                        aaVar2 = this.xm.wU;
                        aaVar2.h(i2, i);
                    }
                }
            }
            i = -1;
            aaVar2 = this.xm.wU;
            aaVar2.h(i2, i);
        }
    }
}
