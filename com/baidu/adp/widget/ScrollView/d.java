package com.baidu.adp.widget.ScrollView;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Timer;
/* loaded from: classes.dex */
class d implements Runnable {
    private final /* synthetic */ Timer Jf;
    final /* synthetic */ c Jg;
    private final /* synthetic */ View yO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view, Timer timer) {
        this.Jg = cVar;
        this.yO = view;
        this.Jf = timer;
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.yO.getLayoutParams();
        int i4 = layoutParams.bottomMargin;
        bVar = this.Jg.Je;
        i = bVar.IM;
        layoutParams.bottomMargin = i4 - i;
        int i5 = layoutParams.bottomMargin;
        bVar2 = this.Jg.Je;
        i2 = bVar2.Jc;
        if (i5 <= i2) {
            bVar6 = this.Jg.Je;
            i3 = bVar6.Jc;
            layoutParams.bottomMargin = i3;
            this.Jf.cancel();
            bVar7 = this.Jg.Je;
            bVar7.Jd = true;
        }
        this.yO.setLayoutParams(layoutParams);
        bVar3 = this.Jg.Je;
        z = bVar3.Jd;
        if (z) {
            bVar4 = this.Jg.Je;
            gVar = bVar4.IO;
            if (gVar != null) {
                bVar5 = this.Jg.Je;
                gVar2 = bVar5.IO;
                gVar2.nf();
            }
        }
    }
}
