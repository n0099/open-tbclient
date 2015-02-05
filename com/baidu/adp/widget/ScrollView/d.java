package com.baidu.adp.widget.ScrollView;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Timer;
/* loaded from: classes.dex */
class d implements Runnable {
    private final /* synthetic */ View nv;
    private final /* synthetic */ Timer xX;
    final /* synthetic */ c xY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view, Timer timer) {
        this.xY = cVar;
        this.nv = view;
        this.xX = timer;
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.nv.getLayoutParams();
        int i4 = layoutParams.bottomMargin;
        bVar = this.xY.xW;
        i = bVar.xq;
        layoutParams.bottomMargin = i4 - i;
        int i5 = layoutParams.bottomMargin;
        bVar2 = this.xY.xW;
        i2 = bVar2.xU;
        if (i5 <= i2) {
            bVar6 = this.xY.xW;
            i3 = bVar6.xU;
            layoutParams.bottomMargin = i3;
            this.xX.cancel();
            bVar7 = this.xY.xW;
            bVar7.xV = true;
        }
        this.nv.setLayoutParams(layoutParams);
        bVar3 = this.xY.xW;
        z = bVar3.xV;
        if (z) {
            bVar4 = this.xY.xW;
            gVar = bVar4.xs;
            if (gVar != null) {
                bVar5 = this.xY.xW;
                gVar2 = bVar5.xs;
                gVar2.jG();
            }
        }
    }
}
