package com.baidu.adp.widget.ScrollView;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Timer;
/* loaded from: classes.dex */
class d implements Runnable {
    private final /* synthetic */ Timer Jg;
    final /* synthetic */ c Jh;
    private final /* synthetic */ View zB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view, Timer timer) {
        this.Jh = cVar;
        this.zB = view;
        this.Jg = timer;
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.zB.getLayoutParams();
        int i4 = layoutParams.bottomMargin;
        bVar = this.Jh.Jf;
        i = bVar.IO;
        layoutParams.bottomMargin = i4 - i;
        int i5 = layoutParams.bottomMargin;
        bVar2 = this.Jh.Jf;
        i2 = bVar2.Jd;
        if (i5 <= i2) {
            bVar6 = this.Jh.Jf;
            i3 = bVar6.Jd;
            layoutParams.bottomMargin = i3;
            this.Jg.cancel();
            bVar7 = this.Jh.Jf;
            bVar7.Je = true;
        }
        this.zB.setLayoutParams(layoutParams);
        bVar3 = this.Jh.Jf;
        z = bVar3.Je;
        if (z) {
            bVar4 = this.Jh.Jf;
            gVar = bVar4.IQ;
            if (gVar != null) {
                bVar5 = this.Jh.Jf;
                gVar2 = bVar5.IQ;
                gVar2.ln();
            }
        }
    }
}
