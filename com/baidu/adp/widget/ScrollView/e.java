package com.baidu.adp.widget.ScrollView;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Timer;
/* loaded from: classes.dex */
class e implements Runnable {
    private final /* synthetic */ View nt;
    private final /* synthetic */ Timer vY;
    final /* synthetic */ d vZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, View view, Timer timer) {
        this.vZ = dVar;
        this.nt = view;
        this.vY = timer;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        int i;
        c cVar2;
        int i2;
        c cVar3;
        boolean z;
        c cVar4;
        h hVar;
        c cVar5;
        h hVar2;
        c cVar6;
        int i3;
        c cVar7;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.nt.getLayoutParams();
        int i4 = layoutParams.bottomMargin;
        cVar = this.vZ.vX;
        i = cVar.vp;
        layoutParams.bottomMargin = i4 - i;
        int i5 = layoutParams.bottomMargin;
        cVar2 = this.vZ.vX;
        i2 = cVar2.vV;
        if (i5 <= i2) {
            cVar6 = this.vZ.vX;
            i3 = cVar6.vV;
            layoutParams.bottomMargin = i3;
            this.vY.cancel();
            cVar7 = this.vZ.vX;
            cVar7.vW = true;
        }
        this.nt.setLayoutParams(layoutParams);
        cVar3 = this.vZ.vX;
        z = cVar3.vW;
        if (z) {
            cVar4 = this.vZ.vX;
            hVar = cVar4.vr;
            if (hVar != null) {
                cVar5 = this.vZ.vX;
                hVar2 = cVar5.vr;
                hVar2.hU();
            }
        }
    }
}
