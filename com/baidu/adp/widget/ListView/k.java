package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ BdListView Ib;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdListView bdListView) {
        this.Ib = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        g gVar;
        w wVar2;
        g gVar2;
        g gVar3;
        g gVar4;
        g gVar5;
        g gVar6;
        g gVar7;
        int i = 0;
        int i2 = -1;
        wVar = this.Ib.HJ;
        if (wVar != null) {
            int firstVisiblePosition = this.Ib.getFirstVisiblePosition();
            int lastVisiblePosition = this.Ib.getLastVisiblePosition();
            gVar = this.Ib.HC;
            if (gVar != null) {
                gVar2 = this.Ib.HC;
                if (gVar2.getWrappedAdapter() != null) {
                    gVar3 = this.Ib.HC;
                    if (gVar3.mS() > 0) {
                        gVar4 = this.Ib.HC;
                        i2 = firstVisiblePosition - gVar4.getHeadersCount();
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        gVar5 = this.Ib.HC;
                        int headersCount = lastVisiblePosition - gVar5.getHeadersCount();
                        gVar6 = this.Ib.HC;
                        if (headersCount >= gVar6.mS()) {
                            gVar7 = this.Ib.HC;
                            headersCount = gVar7.mS() - 1;
                        }
                        if (headersCount >= 0) {
                            i = headersCount;
                        }
                        wVar2 = this.Ib.HJ;
                        wVar2.g(i2, i);
                    }
                }
            }
            i = -1;
            wVar2 = this.Ib.HJ;
            wVar2.g(i2, i);
        }
    }
}
