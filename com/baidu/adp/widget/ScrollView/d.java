package com.baidu.adp.widget.ScrollView;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Timer;
/* loaded from: classes.dex */
class d implements Runnable {
    private final /* synthetic */ Timer Ar;
    final /* synthetic */ c As;
    private final /* synthetic */ View qa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view, Timer timer) {
        this.As = cVar;
        this.qa = view;
        this.Ar = timer;
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.qa.getLayoutParams();
        int i4 = layoutParams.bottomMargin;
        bVar = this.As.Aq;
        i = bVar.zY;
        layoutParams.bottomMargin = i4 - i;
        int i5 = layoutParams.bottomMargin;
        bVar2 = this.As.Aq;
        i2 = bVar2.Ao;
        if (i5 <= i2) {
            bVar6 = this.As.Aq;
            i3 = bVar6.Ao;
            layoutParams.bottomMargin = i3;
            this.Ar.cancel();
            bVar7 = this.As.Aq;
            bVar7.Ap = true;
        }
        this.qa.setLayoutParams(layoutParams);
        bVar3 = this.As.Aq;
        z = bVar3.Ap;
        if (z) {
            bVar4 = this.As.Aq;
            gVar = bVar4.Aa;
            if (gVar != null) {
                bVar5 = this.As.Aq;
                gVar2 = bVar5.Aa;
                gVar2.jG();
            }
        }
    }
}
