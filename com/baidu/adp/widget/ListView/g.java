package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ BdListView IF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BdListView bdListView) {
        this.IF = bdListView;
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
        dVar = this.IF.mOnScrollStopDelayedListener;
        if (dVar != null) {
            int firstVisiblePosition = this.IF.getFirstVisiblePosition();
            int lastVisiblePosition = this.IF.getLastVisiblePosition();
            eVar = this.IF.mBdListAdpter;
            if (eVar != null) {
                eVar2 = this.IF.mBdListAdpter;
                if (eVar2.getWrappedAdapter() != null) {
                    eVar3 = this.IF.mBdListAdpter;
                    if (eVar3.lg() > 0) {
                        eVar4 = this.IF.mBdListAdpter;
                        i2 = firstVisiblePosition - eVar4.getHeadersCount();
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        eVar5 = this.IF.mBdListAdpter;
                        int headersCount = lastVisiblePosition - eVar5.getHeadersCount();
                        eVar6 = this.IF.mBdListAdpter;
                        if (headersCount >= eVar6.lg()) {
                            eVar7 = this.IF.mBdListAdpter;
                            headersCount = eVar7.lg() - 1;
                        }
                        if (headersCount >= 0) {
                            i = headersCount;
                        }
                        dVar2 = this.IF.mOnScrollStopDelayedListener;
                        dVar2.r(i2, i);
                    }
                }
            }
            i = -1;
            dVar2 = this.IF.mOnScrollStopDelayedListener;
            dVar2.r(i2, i);
        }
    }
}
