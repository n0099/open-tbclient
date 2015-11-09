package com.baidu.adp.widget.ScrollView;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Timer;
/* loaded from: classes.dex */
class d implements Runnable {
    private final /* synthetic */ Timer Iw;
    final /* synthetic */ c Ix;
    private final /* synthetic */ View yG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view, Timer timer) {
        this.Ix = cVar;
        this.yG = view;
        this.Iw = timer;
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.yG.getLayoutParams();
        int i4 = layoutParams.bottomMargin;
        bVar = this.Ix.Iv;
        i = bVar.Ie;
        layoutParams.bottomMargin = i4 - i;
        int i5 = layoutParams.bottomMargin;
        bVar2 = this.Ix.Iv;
        i2 = bVar2.It;
        if (i5 <= i2) {
            bVar6 = this.Ix.Iv;
            i3 = bVar6.It;
            layoutParams.bottomMargin = i3;
            this.Iw.cancel();
            bVar7 = this.Ix.Iv;
            bVar7.Iu = true;
        }
        this.yG.setLayoutParams(layoutParams);
        bVar3 = this.Ix.Iv;
        z = bVar3.Iu;
        if (z) {
            bVar4 = this.Ix.Iv;
            gVar = bVar4.Ig;
            if (gVar != null) {
                bVar5 = this.Ix.Iv;
                gVar2 = bVar5.Ig;
                gVar2.nB();
            }
        }
    }
}
