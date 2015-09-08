package com.baidu.adp.widget.ScrollView;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Timer;
/* loaded from: classes.dex */
class d implements Runnable {
    private final /* synthetic */ Timer Iu;
    final /* synthetic */ c Iv;
    private final /* synthetic */ View yF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view, Timer timer) {
        this.Iv = cVar;
        this.yF = view;
        this.Iu = timer;
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.yF.getLayoutParams();
        int i4 = layoutParams.bottomMargin;
        bVar = this.Iv.It;
        i = bVar.Ic;
        layoutParams.bottomMargin = i4 - i;
        int i5 = layoutParams.bottomMargin;
        bVar2 = this.Iv.It;
        i2 = bVar2.Ir;
        if (i5 <= i2) {
            bVar6 = this.Iv.It;
            i3 = bVar6.Ir;
            layoutParams.bottomMargin = i3;
            this.Iu.cancel();
            bVar7 = this.Iv.It;
            bVar7.Is = true;
        }
        this.yF.setLayoutParams(layoutParams);
        bVar3 = this.Iv.It;
        z = bVar3.Is;
        if (z) {
            bVar4 = this.Iv.It;
            gVar = bVar4.Ie;
            if (gVar != null) {
                bVar5 = this.Iv.It;
                gVar2 = bVar5.Ie;
                gVar2.nz();
            }
        }
    }
}
