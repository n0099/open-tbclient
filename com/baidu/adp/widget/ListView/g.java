package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ BdListView IE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BdListView bdListView) {
        this.IE = bdListView;
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
        dVar = this.IE.Il;
        if (dVar != null) {
            int firstVisiblePosition = this.IE.getFirstVisiblePosition();
            int lastVisiblePosition = this.IE.getLastVisiblePosition();
            eVar = this.IE.Ie;
            if (eVar != null) {
                eVar2 = this.IE.Ie;
                if (eVar2.getWrappedAdapter() != null) {
                    eVar3 = this.IE.Ie;
                    if (eVar3.mX() > 0) {
                        eVar4 = this.IE.Ie;
                        i2 = firstVisiblePosition - eVar4.getHeadersCount();
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        eVar5 = this.IE.Ie;
                        int headersCount = lastVisiblePosition - eVar5.getHeadersCount();
                        eVar6 = this.IE.Ie;
                        if (headersCount >= eVar6.mX()) {
                            eVar7 = this.IE.Ie;
                            headersCount = eVar7.mX() - 1;
                        }
                        if (headersCount >= 0) {
                            i = headersCount;
                        }
                        dVar2 = this.IE.Il;
                        dVar2.h(i2, i);
                    }
                }
            }
            i = -1;
            dVar2 = this.IE.Il;
            dVar2.h(i2, i);
        }
    }
}
