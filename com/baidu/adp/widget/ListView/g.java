package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ BdListView zp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BdListView bdListView) {
        this.zp = bdListView;
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
        dVar = this.zp.yX;
        if (dVar != null) {
            int firstVisiblePosition = this.zp.getFirstVisiblePosition();
            int lastVisiblePosition = this.zp.getLastVisiblePosition();
            eVar = this.zp.yQ;
            if (eVar != null) {
                eVar2 = this.zp.yQ;
                if (eVar2.getWrappedAdapter() != null) {
                    eVar3 = this.zp.yQ;
                    if (eVar3.jt() > 0) {
                        eVar4 = this.zp.yQ;
                        i2 = firstVisiblePosition - eVar4.getHeadersCount();
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        eVar5 = this.zp.yQ;
                        int headersCount = lastVisiblePosition - eVar5.getHeadersCount();
                        eVar6 = this.zp.yQ;
                        if (headersCount >= eVar6.jt()) {
                            eVar7 = this.zp.yQ;
                            headersCount = eVar7.jt() - 1;
                        }
                        if (headersCount >= 0) {
                            i = headersCount;
                        }
                        dVar2 = this.zp.yX;
                        dVar2.i(i2, i);
                    }
                }
            }
            i = -1;
            dVar2 = this.zp.yX;
            dVar2.i(i2, i);
        }
    }
}
