package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ BdListView zo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BdListView bdListView) {
        this.zo = bdListView;
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
        dVar = this.zo.yW;
        if (dVar != null) {
            int firstVisiblePosition = this.zo.getFirstVisiblePosition();
            int lastVisiblePosition = this.zo.getLastVisiblePosition();
            eVar = this.zo.yP;
            if (eVar != null) {
                eVar2 = this.zo.yP;
                if (eVar2.getWrappedAdapter() != null) {
                    eVar3 = this.zo.yP;
                    if (eVar3.jw() > 0) {
                        eVar4 = this.zo.yP;
                        i2 = firstVisiblePosition - eVar4.getHeadersCount();
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        eVar5 = this.zo.yP;
                        int headersCount = lastVisiblePosition - eVar5.getHeadersCount();
                        eVar6 = this.zo.yP;
                        if (headersCount >= eVar6.jw()) {
                            eVar7 = this.zo.yP;
                            headersCount = eVar7.jw() - 1;
                        }
                        if (headersCount >= 0) {
                            i = headersCount;
                        }
                        dVar2 = this.zo.yW;
                        dVar2.i(i2, i);
                    }
                }
            }
            i = -1;
            dVar2 = this.zo.yW;
            dVar2.i(i2, i);
        }
    }
}
