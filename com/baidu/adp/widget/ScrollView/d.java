package com.baidu.adp.widget.ScrollView;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Timer;
/* loaded from: classes.dex */
class d implements Runnable {
    private final /* synthetic */ Timer II;
    final /* synthetic */ c IJ;
    private final /* synthetic */ View zf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view, Timer timer) {
        this.IJ = cVar;
        this.zf = view;
        this.II = timer;
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.zf.getLayoutParams();
        int i4 = layoutParams.bottomMargin;
        bVar = this.IJ.IH;
        i = bVar.Iq;
        layoutParams.bottomMargin = i4 - i;
        int i5 = layoutParams.bottomMargin;
        bVar2 = this.IJ.IH;
        i2 = bVar2.IF;
        if (i5 <= i2) {
            bVar6 = this.IJ.IH;
            i3 = bVar6.IF;
            layoutParams.bottomMargin = i3;
            this.II.cancel();
            bVar7 = this.IJ.IH;
            bVar7.IG = true;
        }
        this.zf.setLayoutParams(layoutParams);
        bVar3 = this.IJ.IH;
        z = bVar3.IG;
        if (z) {
            bVar4 = this.IJ.IH;
            gVar = bVar4.Is;
            if (gVar != null) {
                bVar5 = this.IJ.IH;
                gVar2 = bVar5.Is;
                gVar2.ls();
            }
        }
    }
}
