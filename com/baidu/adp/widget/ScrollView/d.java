package com.baidu.adp.widget.ScrollView;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Timer;
/* loaded from: classes.dex */
class d implements Runnable {
    private final /* synthetic */ Timer IO;
    final /* synthetic */ c IP;
    private final /* synthetic */ View yM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view, Timer timer) {
        this.IP = cVar;
        this.yM = view;
        this.IO = timer;
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.yM.getLayoutParams();
        int i4 = layoutParams.bottomMargin;
        bVar = this.IP.IN;
        i = bVar.Iv;
        layoutParams.bottomMargin = i4 - i;
        int i5 = layoutParams.bottomMargin;
        bVar2 = this.IP.IN;
        i2 = bVar2.IL;
        if (i5 <= i2) {
            bVar6 = this.IP.IN;
            i3 = bVar6.IL;
            layoutParams.bottomMargin = i3;
            this.IO.cancel();
            bVar7 = this.IP.IN;
            bVar7.IM = true;
        }
        this.yM.setLayoutParams(layoutParams);
        bVar3 = this.IP.IN;
        z = bVar3.IM;
        if (z) {
            bVar4 = this.IP.IN;
            gVar = bVar4.Ix;
            if (gVar != null) {
                bVar5 = this.IP.IN;
                gVar2 = bVar5.Ix;
                gVar2.nH();
            }
        }
    }
}
