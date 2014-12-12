package com.baidu.adp.widget.ScrollView;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Timer;
/* loaded from: classes.dex */
class d implements Runnable {
    private final /* synthetic */ View ns;
    private final /* synthetic */ Timer ya;
    final /* synthetic */ c yb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view, Timer timer) {
        this.yb = cVar;
        this.ns = view;
        this.ya = timer;
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ns.getLayoutParams();
        int i4 = layoutParams.bottomMargin;
        bVar = this.yb.xZ;
        i = bVar.xt;
        layoutParams.bottomMargin = i4 - i;
        int i5 = layoutParams.bottomMargin;
        bVar2 = this.yb.xZ;
        i2 = bVar2.xX;
        if (i5 <= i2) {
            bVar6 = this.yb.xZ;
            i3 = bVar6.xX;
            layoutParams.bottomMargin = i3;
            this.ya.cancel();
            bVar7 = this.yb.xZ;
            bVar7.xY = true;
        }
        this.ns.setLayoutParams(layoutParams);
        bVar3 = this.yb.xZ;
        z = bVar3.xY;
        if (z) {
            bVar4 = this.yb.xZ;
            gVar = bVar4.xv;
            if (gVar != null) {
                bVar5 = this.yb.xZ;
                gVar2 = bVar5.xv;
                gVar2.jO();
            }
        }
    }
}
