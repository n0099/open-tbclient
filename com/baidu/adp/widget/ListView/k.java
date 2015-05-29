package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ BdListView HT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdListView bdListView) {
        this.HT = bdListView;
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
        wVar = this.HT.HB;
        if (wVar != null) {
            int firstVisiblePosition = this.HT.getFirstVisiblePosition();
            int lastVisiblePosition = this.HT.getLastVisiblePosition();
            gVar = this.HT.Hu;
            if (gVar != null) {
                gVar2 = this.HT.Hu;
                if (gVar2.getWrappedAdapter() != null) {
                    gVar3 = this.HT.Hu;
                    if (gVar3.nk() > 0) {
                        gVar4 = this.HT.Hu;
                        i2 = firstVisiblePosition - gVar4.getHeadersCount();
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        gVar5 = this.HT.Hu;
                        int headersCount = lastVisiblePosition - gVar5.getHeadersCount();
                        gVar6 = this.HT.Hu;
                        if (headersCount >= gVar6.nk()) {
                            gVar7 = this.HT.Hu;
                            headersCount = gVar7.nk() - 1;
                        }
                        if (headersCount >= 0) {
                            i = headersCount;
                        }
                        wVar2 = this.HT.HB;
                        wVar2.g(i2, i);
                    }
                }
            }
            i = -1;
            wVar2 = this.HT.HB;
            wVar2.g(i2, i);
        }
    }
}
