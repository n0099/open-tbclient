package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ BdListView Ia;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BdListView bdListView) {
        this.Ia = bdListView;
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
        dVar = this.Ia.mOnScrollStopDelayedListener;
        if (dVar != null) {
            int firstVisiblePosition = this.Ia.getFirstVisiblePosition();
            int lastVisiblePosition = this.Ia.getLastVisiblePosition();
            eVar = this.Ia.mBdListAdpter;
            if (eVar != null) {
                eVar2 = this.Ia.mBdListAdpter;
                if (eVar2.getWrappedAdapter() != null) {
                    eVar3 = this.Ia.mBdListAdpter;
                    if (eVar3.getWrappedCount() > 0) {
                        eVar4 = this.Ia.mBdListAdpter;
                        i2 = firstVisiblePosition - eVar4.getHeadersCount();
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        eVar5 = this.Ia.mBdListAdpter;
                        int headersCount = lastVisiblePosition - eVar5.getHeadersCount();
                        eVar6 = this.Ia.mBdListAdpter;
                        if (headersCount >= eVar6.getWrappedCount()) {
                            eVar7 = this.Ia.mBdListAdpter;
                            headersCount = eVar7.getWrappedCount() - 1;
                        }
                        if (headersCount >= 0) {
                            i = headersCount;
                        }
                        dVar2 = this.Ia.mOnScrollStopDelayedListener;
                        dVar2.onScrollStop(i2, i);
                    }
                }
            }
            i = -1;
            dVar2 = this.Ia.mOnScrollStopDelayedListener;
            dVar2.onScrollStop(i2, i);
        }
    }
}
