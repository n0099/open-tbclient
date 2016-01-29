package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ BdListView IS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BdListView bdListView) {
        this.IS = bdListView;
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
        dVar = this.IS.Iy;
        if (dVar != null) {
            int firstVisiblePosition = this.IS.getFirstVisiblePosition();
            int lastVisiblePosition = this.IS.getLastVisiblePosition();
            eVar = this.IS.Ir;
            if (eVar != null) {
                eVar2 = this.IS.Ir;
                if (eVar2.getWrappedAdapter() != null) {
                    eVar3 = this.IS.Ir;
                    if (eVar3.nn() > 0) {
                        eVar4 = this.IS.Ir;
                        i2 = firstVisiblePosition - eVar4.getHeadersCount();
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        eVar5 = this.IS.Ir;
                        int headersCount = lastVisiblePosition - eVar5.getHeadersCount();
                        eVar6 = this.IS.Ir;
                        if (headersCount >= eVar6.nn()) {
                            eVar7 = this.IS.Ir;
                            headersCount = eVar7.nn() - 1;
                        }
                        if (headersCount >= 0) {
                            i = headersCount;
                        }
                        dVar2 = this.IS.Iy;
                        dVar2.i(i2, i);
                    }
                }
            }
            i = -1;
            dVar2 = this.IS.Iy;
            dVar2.i(i2, i);
        }
    }
}
