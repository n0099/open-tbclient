package com.baidu.adp.widget.ScrollView;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Timer;
/* loaded from: classes.dex */
class d implements Runnable {
    private final /* synthetic */ Timer CF;
    final /* synthetic */ c CG;
    private final /* synthetic */ View sq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view, Timer timer) {
        this.CG = cVar;
        this.sq = view;
        this.CF = timer;
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
        bVar = this.CG.CE;
        i = bVar.Cn;
        layoutParams.bottomMargin = i4 - i;
        int i5 = layoutParams.bottomMargin;
        bVar2 = this.CG.CE;
        i2 = bVar2.CC;
        if (i5 <= i2) {
            bVar6 = this.CG.CE;
            i3 = bVar6.CC;
            layoutParams.bottomMargin = i3;
            this.CF.cancel();
            bVar7 = this.CG.CE;
            bVar7.CD = true;
        }
        this.sq.setLayoutParams(layoutParams);
        bVar3 = this.CG.CE;
        z = bVar3.CD;
        if (z) {
            bVar4 = this.CG.CE;
            gVar = bVar4.Cp;
            if (gVar != null) {
                bVar5 = this.CG.CE;
                gVar2 = bVar5.Cp;
                gVar2.kB();
            }
        }
    }
}
