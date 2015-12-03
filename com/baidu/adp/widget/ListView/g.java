package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ BdListView In;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BdListView bdListView) {
        this.In = bdListView;
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
        dVar = this.In.HV;
        if (dVar != null) {
            int firstVisiblePosition = this.In.getFirstVisiblePosition();
            int lastVisiblePosition = this.In.getLastVisiblePosition();
            eVar = this.In.HO;
            if (eVar != null) {
                eVar2 = this.In.HO;
                if (eVar2.getWrappedAdapter() != null) {
                    eVar3 = this.In.HO;
                    if (eVar3.nz() > 0) {
                        eVar4 = this.In.HO;
                        i2 = firstVisiblePosition - eVar4.getHeadersCount();
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        eVar5 = this.In.HO;
                        int headersCount = lastVisiblePosition - eVar5.getHeadersCount();
                        eVar6 = this.In.HO;
                        if (headersCount >= eVar6.nz()) {
                            eVar7 = this.In.HO;
                            headersCount = eVar7.nz() - 1;
                        }
                        if (headersCount >= 0) {
                            i = headersCount;
                        }
                        dVar2 = this.In.HV;
                        dVar2.i(i2, i);
                    }
                }
            }
            i = -1;
            dVar2 = this.In.HV;
            dVar2.i(i2, i);
        }
    }
}
