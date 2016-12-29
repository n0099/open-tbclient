package com.baidu.adp.widget.ScrollView;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Timer;
/* loaded from: classes.dex */
class d implements Runnable {
    private final /* synthetic */ Timer CG;
    final /* synthetic */ c CH;
    private final /* synthetic */ View sq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view, Timer timer) {
        this.CH = cVar;
        this.sq = view;
        this.CG = timer;
    }

    @Override // java.lang.Runnable
    public void run() {
        b bVar;
        int i;
        b bVar2;
        int i2;
        b bVar3;
        boolean z;
        b bVar4;
        g gVar;
        b bVar5;
        g gVar2;
        b bVar6;
        int i3;
        b bVar7;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.sq.getLayoutParams();
        int i4 = layoutParams.bottomMargin;
        bVar = this.CH.CF;
        i = bVar.Co;
        layoutParams.bottomMargin = i4 - i;
        int i5 = layoutParams.bottomMargin;
        bVar2 = this.CH.CF;
        i2 = bVar2.CD;
        if (i5 <= i2) {
            bVar6 = this.CH.CF;
            i3 = bVar6.CD;
            layoutParams.bottomMargin = i3;
            this.CG.cancel();
            bVar7 = this.CH.CF;
            bVar7.CE = true;
        }
        this.sq.setLayoutParams(layoutParams);
        bVar3 = this.CH.CF;
        z = bVar3.CE;
        if (z) {
            bVar4 = this.CH.CF;
            gVar = bVar4.Cq;
            if (gVar != null) {
                bVar5 = this.CH.CF;
                gVar2 = bVar5.Cq;
                gVar2.kB();
            }
        }
    }
}
