package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ BdListView vg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(BdListView bdListView) {
        this.vg = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        z zVar;
        j jVar;
        z zVar2;
        j jVar2;
        j jVar3;
        j jVar4;
        j jVar5;
        j jVar6;
        j jVar7;
        int i = 0;
        int i2 = -1;
        zVar = this.vg.uO;
        if (zVar != null) {
            int firstVisiblePosition = this.vg.getFirstVisiblePosition();
            int lastVisiblePosition = this.vg.getLastVisiblePosition();
            jVar = this.vg.uH;
            if (jVar != null) {
                jVar2 = this.vg.uH;
                if (jVar2.getWrappedAdapter() != null) {
                    jVar3 = this.vg.uH;
                    if (jVar3.hJ() > 0) {
                        jVar4 = this.vg.uH;
                        i2 = firstVisiblePosition - jVar4.getHeadersCount();
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        jVar5 = this.vg.uH;
                        int headersCount = lastVisiblePosition - jVar5.getHeadersCount();
                        jVar6 = this.vg.uH;
                        if (headersCount >= jVar6.hJ()) {
                            jVar7 = this.vg.uH;
                            headersCount = jVar7.hJ() - 1;
                        }
                        if (headersCount >= 0) {
                            i = headersCount;
                        }
                        zVar2 = this.vg.uO;
                        zVar2.f(i2, i);
                    }
                }
            }
            i = -1;
            zVar2 = this.vg.uO;
            zVar2.f(i2, i);
        }
    }
}
