package com.baidu.adp.widget.ScrollView;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Timer;
/* loaded from: classes.dex */
class d implements Runnable {
    private final /* synthetic */ Timer BR;
    final /* synthetic */ c BS;
    private final /* synthetic */ View sg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view, Timer timer) {
        this.BS = cVar;
        this.sg = view;
        this.BR = timer;
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.sg.getLayoutParams();
        int i4 = layoutParams.bottomMargin;
        bVar = this.BS.BQ;
        i = bVar.BA;
        layoutParams.bottomMargin = i4 - i;
        int i5 = layoutParams.bottomMargin;
        bVar2 = this.BS.BQ;
        i2 = bVar2.BO;
        if (i5 <= i2) {
            bVar6 = this.BS.BQ;
            i3 = bVar6.BO;
            layoutParams.bottomMargin = i3;
            this.BR.cancel();
            bVar7 = this.BS.BQ;
            bVar7.BP = true;
        }
        this.sg.setLayoutParams(layoutParams);
        bVar3 = this.BS.BQ;
        z = bVar3.BP;
        if (z) {
            bVar4 = this.BS.BQ;
            gVar = bVar4.BC;
            if (gVar != null) {
                bVar5 = this.BS.BQ;
                gVar2 = bVar5.BC;
                gVar2.kt();
            }
        }
    }
}
