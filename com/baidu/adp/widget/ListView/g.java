package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ BdListView HU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BdListView bdListView) {
        this.HU = bdListView;
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
        dVar = this.HU.HC;
        if (dVar != null) {
            int firstVisiblePosition = this.HU.getFirstVisiblePosition();
            int lastVisiblePosition = this.HU.getLastVisiblePosition();
            eVar = this.HU.Hv;
            if (eVar != null) {
                eVar2 = this.HU.Hv;
                if (eVar2.getWrappedAdapter() != null) {
                    eVar3 = this.HU.Hv;
                    if (eVar3.nu() > 0) {
                        eVar4 = this.HU.Hv;
                        i2 = firstVisiblePosition - eVar4.getHeadersCount();
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        eVar5 = this.HU.Hv;
                        int headersCount = lastVisiblePosition - eVar5.getHeadersCount();
                        eVar6 = this.HU.Hv;
                        if (headersCount >= eVar6.nu()) {
                            eVar7 = this.HU.Hv;
                            headersCount = eVar7.nu() - 1;
                        }
                        if (headersCount >= 0) {
                            i = headersCount;
                        }
                        dVar2 = this.HU.HC;
                        dVar2.i(i2, i);
                    }
                }
            }
            i = -1;
            dVar2 = this.HU.HC;
            dVar2.i(i2, i);
        }
    }
}
