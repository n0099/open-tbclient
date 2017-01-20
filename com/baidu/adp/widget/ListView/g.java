package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ BdListView Br;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BdListView bdListView) {
        this.Br = bdListView;
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
        dVar = this.Br.mOnScrollStopDelayedListener;
        if (dVar != null) {
            int firstVisiblePosition = this.Br.getFirstVisiblePosition();
            int lastVisiblePosition = this.Br.getLastVisiblePosition();
            eVar = this.Br.mBdListAdpter;
            if (eVar != null) {
                eVar2 = this.Br.mBdListAdpter;
                if (eVar2.getWrappedAdapter() != null) {
                    eVar3 = this.Br.mBdListAdpter;
                    if (eVar3.km() > 0) {
                        eVar4 = this.Br.mBdListAdpter;
                        i2 = firstVisiblePosition - eVar4.getHeadersCount();
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        eVar5 = this.Br.mBdListAdpter;
                        int headersCount = lastVisiblePosition - eVar5.getHeadersCount();
                        eVar6 = this.Br.mBdListAdpter;
                        if (headersCount >= eVar6.km()) {
                            eVar7 = this.Br.mBdListAdpter;
                            headersCount = eVar7.km() - 1;
                        }
                        if (headersCount >= 0) {
                            i = headersCount;
                        }
                        dVar2 = this.Br.mOnScrollStopDelayedListener;
                        dVar2.k(i2, i);
                    }
                }
            }
            i = -1;
            dVar2 = this.Br.mOnScrollStopDelayedListener;
            dVar2.k(i2, i);
        }
    }
}
