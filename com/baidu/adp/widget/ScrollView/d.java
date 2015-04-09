package com.baidu.adp.widget.ScrollView;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Timer;
/* loaded from: classes.dex */
class d implements Runnable {
    private final /* synthetic */ Timer IB;
    final /* synthetic */ c IC;
    private final /* synthetic */ View yS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view, Timer timer) {
        this.IC = cVar;
        this.yS = view;
        this.IB = timer;
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.yS.getLayoutParams();
        int i4 = layoutParams.bottomMargin;
        bVar = this.IC.IA;
        i = bVar.Ik;
        layoutParams.bottomMargin = i4 - i;
        int i5 = layoutParams.bottomMargin;
        bVar2 = this.IC.IA;
        i2 = bVar2.Iy;
        if (i5 <= i2) {
            bVar6 = this.IC.IA;
            i3 = bVar6.Iy;
            layoutParams.bottomMargin = i3;
            this.IB.cancel();
            bVar7 = this.IC.IA;
            bVar7.Iz = true;
        }
        this.yS.setLayoutParams(layoutParams);
        bVar3 = this.IC.IA;
        z = bVar3.Iz;
        if (z) {
            bVar4 = this.IC.IA;
            gVar = bVar4.Im;
            if (gVar != null) {
                bVar5 = this.IC.IA;
                gVar2 = bVar5.Im;
                gVar2.nb();
            }
        }
    }
}
