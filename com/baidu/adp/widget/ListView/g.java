package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ BdListView HW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BdListView bdListView) {
        this.HW = bdListView;
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
        dVar = this.HW.HE;
        if (dVar != null) {
            int firstVisiblePosition = this.HW.getFirstVisiblePosition();
            int lastVisiblePosition = this.HW.getLastVisiblePosition();
            eVar = this.HW.Hx;
            if (eVar != null) {
                eVar2 = this.HW.Hx;
                if (eVar2.getWrappedAdapter() != null) {
                    eVar3 = this.HW.Hx;
                    if (eVar3.nt() > 0) {
                        eVar4 = this.HW.Hx;
                        i2 = firstVisiblePosition - eVar4.getHeadersCount();
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        eVar5 = this.HW.Hx;
                        int headersCount = lastVisiblePosition - eVar5.getHeadersCount();
                        eVar6 = this.HW.Hx;
                        if (headersCount >= eVar6.nt()) {
                            eVar7 = this.HW.Hx;
                            headersCount = eVar7.nt() - 1;
                        }
                        if (headersCount >= 0) {
                            i = headersCount;
                        }
                        dVar2 = this.HW.HE;
                        dVar2.i(i2, i);
                    }
                }
            }
            i = -1;
            dVar2 = this.HW.HE;
            dVar2.i(i2, i);
        }
    }
}
