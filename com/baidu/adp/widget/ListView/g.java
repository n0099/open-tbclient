package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ BdListView Cf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BdListView bdListView) {
        this.Cf = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView.d dVar;
        e eVar;
        BdListView.d dVar2;
        e eVar2;
        e eVar3;
        e eVar4;
        e eVar5;
        e eVar6;
        e eVar7;
        int i = 0;
        int i2 = -1;
        dVar = this.Cf.BN;
        if (dVar != null) {
            int firstVisiblePosition = this.Cf.getFirstVisiblePosition();
            int lastVisiblePosition = this.Cf.getLastVisiblePosition();
            eVar = this.Cf.BG;
            if (eVar != null) {
                eVar2 = this.Cf.BG;
                if (eVar2.getWrappedAdapter() != null) {
                    eVar3 = this.Cf.BG;
                    if (eVar3.kq() > 0) {
                        eVar4 = this.Cf.BG;
                        i2 = firstVisiblePosition - eVar4.getHeadersCount();
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        eVar5 = this.Cf.BG;
                        int headersCount = lastVisiblePosition - eVar5.getHeadersCount();
                        eVar6 = this.Cf.BG;
                        if (headersCount >= eVar6.kq()) {
                            eVar7 = this.Cf.BG;
                            headersCount = eVar7.kq() - 1;
                        }
                        if (headersCount >= 0) {
                            i = headersCount;
                        }
                        dVar2 = this.Cf.BN;
                        dVar2.k(i2, i);
                    }
                }
            }
            i = -1;
            dVar2 = this.Cf.BN;
            dVar2.k(i2, i);
        }
    }
}
