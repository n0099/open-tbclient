package com.baidu.adp.widget.ScrollView;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Timer;
/* loaded from: classes.dex */
class d implements Runnable {
    private final /* synthetic */ Timer Ju;
    final /* synthetic */ c Jv;
    private final /* synthetic */ View yW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view, Timer timer) {
        this.Jv = cVar;
        this.yW = view;
        this.Ju = timer;
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.yW.getLayoutParams();
        int i4 = layoutParams.bottomMargin;
        bVar = this.Jv.Jt;
        i = bVar.Jc;
        layoutParams.bottomMargin = i4 - i;
        int i5 = layoutParams.bottomMargin;
        bVar2 = this.Jv.Jt;
        i2 = bVar2.Jr;
        if (i5 <= i2) {
            bVar6 = this.Jv.Jt;
            i3 = bVar6.Jr;
            layoutParams.bottomMargin = i3;
            this.Ju.cancel();
            bVar7 = this.Jv.Jt;
            bVar7.Js = true;
        }
        this.yW.setLayoutParams(layoutParams);
        bVar3 = this.Jv.Jt;
        z = bVar3.Js;
        if (z) {
            bVar4 = this.Jv.Jt;
            gVar = bVar4.Je;
            if (gVar != null) {
                bVar5 = this.Jv.Jt;
                gVar2 = bVar5.Je;
                gVar2.nz();
            }
        }
    }
}
