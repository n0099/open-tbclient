package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ BdListView IZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BdListView bdListView) {
        this.IZ = bdListView;
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
        dVar = this.IZ.IG;
        if (dVar != null) {
            int firstVisiblePosition = this.IZ.getFirstVisiblePosition();
            int lastVisiblePosition = this.IZ.getLastVisiblePosition();
            eVar = this.IZ.Ix;
            if (eVar != null) {
                eVar2 = this.IZ.Ix;
                if (eVar2.getWrappedAdapter() != null) {
                    eVar3 = this.IZ.Ix;
                    if (eVar3.nf() > 0) {
                        eVar4 = this.IZ.Ix;
                        i2 = firstVisiblePosition - eVar4.getHeadersCount();
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        eVar5 = this.IZ.Ix;
                        int headersCount = lastVisiblePosition - eVar5.getHeadersCount();
                        eVar6 = this.IZ.Ix;
                        if (headersCount >= eVar6.nf()) {
                            eVar7 = this.IZ.Ix;
                            headersCount = eVar7.nf() - 1;
                        }
                        if (headersCount >= 0) {
                            i = headersCount;
                        }
                        dVar2 = this.IZ.IG;
                        dVar2.i(i2, i);
                    }
                }
            }
            i = -1;
            dVar2 = this.IZ.IG;
            dVar2.i(i2, i);
        }
    }
}
