package com.baidu.adp.widget.ScrollView;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Timer;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ c IA;
    private final /* synthetic */ Timer Iz;
    private final /* synthetic */ View yS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view, Timer timer) {
        this.IA = cVar;
        this.yS = view;
        this.Iz = timer;
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
        bVar = this.IA.Iy;
        i = bVar.Ii;
        layoutParams.bottomMargin = i4 - i;
        int i5 = layoutParams.bottomMargin;
        bVar2 = this.IA.Iy;
        i2 = bVar2.Iw;
        if (i5 <= i2) {
            bVar6 = this.IA.Iy;
            i3 = bVar6.Iw;
            layoutParams.bottomMargin = i3;
            this.Iz.cancel();
            bVar7 = this.IA.Iy;
            bVar7.Ix = true;
        }
        this.yS.setLayoutParams(layoutParams);
        bVar3 = this.IA.Iy;
        z = bVar3.Ix;
        if (z) {
            bVar4 = this.IA.Iy;
            gVar = bVar4.Ik;
            if (gVar != null) {
                bVar5 = this.IA.Iy;
                gVar2 = bVar5.Ik;
                gVar2.nb();
            }
        }
    }
}
