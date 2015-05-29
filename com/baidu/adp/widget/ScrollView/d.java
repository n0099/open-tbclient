package com.baidu.adp.widget.ScrollView;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Timer;
/* loaded from: classes.dex */
class d implements Runnable {
    private final /* synthetic */ Timer Ir;
    final /* synthetic */ c Is;
    private final /* synthetic */ View yH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view, Timer timer) {
        this.Is = cVar;
        this.yH = view;
        this.Ir = timer;
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.yH.getLayoutParams();
        int i4 = layoutParams.bottomMargin;
        bVar = this.Is.Iq;
        i = bVar.Ia;
        layoutParams.bottomMargin = i4 - i;
        int i5 = layoutParams.bottomMargin;
        bVar2 = this.Is.Iq;
        i2 = bVar2.Io;
        if (i5 <= i2) {
            bVar6 = this.Is.Iq;
            i3 = bVar6.Io;
            layoutParams.bottomMargin = i3;
            this.Ir.cancel();
            bVar7 = this.Is.Iq;
            bVar7.Ip = true;
        }
        this.yH.setLayoutParams(layoutParams);
        bVar3 = this.Is.Iq;
        z = bVar3.Ip;
        if (z) {
            bVar4 = this.Is.Iq;
            gVar = bVar4.Ic;
            if (gVar != null) {
                bVar5 = this.Is.Iq;
                gVar2 = bVar5.Ic;
                gVar2.ns();
            }
        }
    }
}
