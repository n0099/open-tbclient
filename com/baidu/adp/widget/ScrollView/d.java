package com.baidu.adp.widget.ScrollView;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Timer;
/* loaded from: classes.dex */
class d implements Runnable {
    private final /* synthetic */ Timer JA;
    final /* synthetic */ c JB;
    private final /* synthetic */ View zn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view, Timer timer) {
        this.JB = cVar;
        this.zn = view;
        this.JA = timer;
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.zn.getLayoutParams();
        int i4 = layoutParams.bottomMargin;
        bVar = this.JB.Jz;
        i = bVar.Ji;
        layoutParams.bottomMargin = i4 - i;
        int i5 = layoutParams.bottomMargin;
        bVar2 = this.JB.Jz;
        i2 = bVar2.Jx;
        if (i5 <= i2) {
            bVar6 = this.JB.Jz;
            i3 = bVar6.Jx;
            layoutParams.bottomMargin = i3;
            this.JA.cancel();
            bVar7 = this.JB.Jz;
            bVar7.Jy = true;
        }
        this.zn.setLayoutParams(layoutParams);
        bVar3 = this.JB.Jz;
        z = bVar3.Jy;
        if (z) {
            bVar4 = this.JB.Jz;
            gVar = bVar4.Jk;
            if (gVar != null) {
                bVar5 = this.JB.Jz;
                gVar2 = bVar5.Jk;
                gVar2.nq();
            }
        }
    }
}
