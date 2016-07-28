package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ BdListView zP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BdListView bdListView) {
        this.zP = bdListView;
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
        dVar = this.zP.zx;
        if (dVar != null) {
            int firstVisiblePosition = this.zP.getFirstVisiblePosition();
            int lastVisiblePosition = this.zP.getLastVisiblePosition();
            eVar = this.zP.zq;
            if (eVar != null) {
                eVar2 = this.zP.zq;
                if (eVar2.getWrappedAdapter() != null) {
                    eVar3 = this.zP.zq;
                    if (eVar3.jv() > 0) {
                        eVar4 = this.zP.zq;
                        i2 = firstVisiblePosition - eVar4.getHeadersCount();
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        eVar5 = this.zP.zq;
                        int headersCount = lastVisiblePosition - eVar5.getHeadersCount();
                        eVar6 = this.zP.zq;
                        if (headersCount >= eVar6.jv()) {
                            eVar7 = this.zP.zq;
                            headersCount = eVar7.jv() - 1;
                        }
                        if (headersCount >= 0) {
                            i = headersCount;
                        }
                        dVar2 = this.zP.zx;
                        dVar2.i(i2, i);
                    }
                }
            }
            i = -1;
            dVar2 = this.zP.zx;
            dVar2.i(i2, i);
        }
    }
}
