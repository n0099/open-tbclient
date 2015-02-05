package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ BdListView xj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(BdListView bdListView) {
        this.xj = bdListView;
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
        aaVar = this.xj.wR;
        if (aaVar != null) {
            int firstVisiblePosition = this.xj.getFirstVisiblePosition();
            int lastVisiblePosition = this.xj.getLastVisiblePosition();
            kVar = this.xj.wK;
            if (kVar != null) {
                kVar2 = this.xj.wK;
                if (kVar2.getWrappedAdapter() != null) {
                    kVar3 = this.xj.wK;
                    if (kVar3.jx() > 0) {
                        kVar4 = this.xj.wK;
                        i2 = firstVisiblePosition - kVar4.getHeadersCount();
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        kVar5 = this.xj.wK;
                        int headersCount = lastVisiblePosition - kVar5.getHeadersCount();
                        kVar6 = this.xj.wK;
                        if (headersCount >= kVar6.jx()) {
                            kVar7 = this.xj.wK;
                            headersCount = kVar7.jx() - 1;
                        }
                        if (headersCount >= 0) {
                            i = headersCount;
                        }
                        aaVar2 = this.xj.wR;
                        aaVar2.h(i2, i);
                    }
                }
            }
            i = -1;
            aaVar2 = this.xj.wR;
            aaVar2.h(i2, i);
        }
    }
}
