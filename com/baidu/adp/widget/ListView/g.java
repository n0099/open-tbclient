package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ BdListView HV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BdListView bdListView) {
        this.HV = bdListView;
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
        dVar = this.HV.HD;
        if (dVar != null) {
            int firstVisiblePosition = this.HV.getFirstVisiblePosition();
            int lastVisiblePosition = this.HV.getLastVisiblePosition();
            eVar = this.HV.Hw;
            if (eVar != null) {
                eVar2 = this.HV.Hw;
                if (eVar2.getWrappedAdapter() != null) {
                    eVar3 = this.HV.Hw;
                    if (eVar3.ns() > 0) {
                        eVar4 = this.HV.Hw;
                        i2 = firstVisiblePosition - eVar4.getHeadersCount();
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        eVar5 = this.HV.Hw;
                        int headersCount = lastVisiblePosition - eVar5.getHeadersCount();
                        eVar6 = this.HV.Hw;
                        if (headersCount >= eVar6.ns()) {
                            eVar7 = this.HV.Hw;
                            headersCount = eVar7.ns() - 1;
                        }
                        if (headersCount >= 0) {
                            i = headersCount;
                        }
                        dVar2 = this.HV.HD;
                        dVar2.i(i2, i);
                    }
                }
            }
            i = -1;
            dVar2 = this.HV.HD;
            dVar2.i(i2, i);
        }
    }
}
