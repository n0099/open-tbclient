package com.baidu.adp.widget.ScrollView;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Timer;
/* loaded from: classes.dex */
class d implements Runnable {
    private final /* synthetic */ Timer Iv;
    final /* synthetic */ c Iw;
    private final /* synthetic */ View yG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view, Timer timer) {
        this.Iw = cVar;
        this.yG = view;
        this.Iv = timer;
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
        bVar = this.Iw.Iu;
        i = bVar.Id;
        layoutParams.bottomMargin = i4 - i;
        int i5 = layoutParams.bottomMargin;
        bVar2 = this.Iw.Iu;
        i2 = bVar2.Is;
        if (i5 <= i2) {
            bVar6 = this.Iw.Iu;
            i3 = bVar6.Is;
            layoutParams.bottomMargin = i3;
            this.Iv.cancel();
            bVar7 = this.Iw.Iu;
            bVar7.It = true;
        }
        this.yG.setLayoutParams(layoutParams);
        bVar3 = this.Iw.Iu;
        z = bVar3.It;
        if (z) {
            bVar4 = this.Iw.Iu;
            gVar = bVar4.If;
            if (gVar != null) {
                bVar5 = this.Iw.Iu;
                gVar2 = bVar5.If;
                gVar2.nA();
            }
        }
    }
}
