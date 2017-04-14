package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ BdListView If;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BdListView bdListView) {
        this.If = bdListView;
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
        dVar = this.If.mOnScrollStopDelayedListener;
        if (dVar != null) {
            int firstVisiblePosition = this.If.getFirstVisiblePosition();
            int lastVisiblePosition = this.If.getLastVisiblePosition();
            eVar = this.If.mBdListAdpter;
            if (eVar != null) {
                eVar2 = this.If.mBdListAdpter;
                if (eVar2.getWrappedAdapter() != null) {
                    eVar3 = this.If.mBdListAdpter;
                    if (eVar3.lk() > 0) {
                        eVar4 = this.If.mBdListAdpter;
                        i2 = firstVisiblePosition - eVar4.getHeadersCount();
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        eVar5 = this.If.mBdListAdpter;
                        int headersCount = lastVisiblePosition - eVar5.getHeadersCount();
                        eVar6 = this.If.mBdListAdpter;
                        if (headersCount >= eVar6.lk()) {
                            eVar7 = this.If.mBdListAdpter;
                            headersCount = eVar7.lk() - 1;
                        }
                        if (headersCount >= 0) {
                            i = headersCount;
                        }
                        dVar2 = this.If.mOnScrollStopDelayedListener;
                        dVar2.r(i2, i);
                    }
                }
            }
            i = -1;
            dVar2 = this.If.mOnScrollStopDelayedListener;
            dVar2.r(i2, i);
        }
    }
}
