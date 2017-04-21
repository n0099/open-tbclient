package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ BdListView Ih;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BdListView bdListView) {
        this.Ih = bdListView;
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
        dVar = this.Ih.mOnScrollStopDelayedListener;
        if (dVar != null) {
            int firstVisiblePosition = this.Ih.getFirstVisiblePosition();
            int lastVisiblePosition = this.Ih.getLastVisiblePosition();
            eVar = this.Ih.mBdListAdpter;
            if (eVar != null) {
                eVar2 = this.Ih.mBdListAdpter;
                if (eVar2.getWrappedAdapter() != null) {
                    eVar3 = this.Ih.mBdListAdpter;
                    if (eVar3.ll() > 0) {
                        eVar4 = this.Ih.mBdListAdpter;
                        i2 = firstVisiblePosition - eVar4.getHeadersCount();
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        eVar5 = this.Ih.mBdListAdpter;
                        int headersCount = lastVisiblePosition - eVar5.getHeadersCount();
                        eVar6 = this.Ih.mBdListAdpter;
                        if (headersCount >= eVar6.ll()) {
                            eVar7 = this.Ih.mBdListAdpter;
                            headersCount = eVar7.ll() - 1;
                        }
                        if (headersCount >= 0) {
                            i = headersCount;
                        }
                        dVar2 = this.Ih.mOnScrollStopDelayedListener;
                        dVar2.r(i2, i);
                    }
                }
            }
            i = -1;
            dVar2 = this.Ih.mOnScrollStopDelayedListener;
            dVar2.r(i2, i);
        }
    }
}
