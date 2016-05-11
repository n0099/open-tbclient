package com.baidu.adp.widget.ScrollView;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Timer;
/* loaded from: classes.dex */
class d implements Runnable {
    private final /* synthetic */ View py;
    private final /* synthetic */ Timer zQ;
    final /* synthetic */ c zR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view, Timer timer) {
        this.zR = cVar;
        this.py = view;
        this.zQ = timer;
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.py.getLayoutParams();
        int i4 = layoutParams.bottomMargin;
        bVar = this.zR.zP;
        i = bVar.zy;
        layoutParams.bottomMargin = i4 - i;
        int i5 = layoutParams.bottomMargin;
        bVar2 = this.zR.zP;
        i2 = bVar2.zN;
        if (i5 <= i2) {
            bVar6 = this.zR.zP;
            i3 = bVar6.zN;
            layoutParams.bottomMargin = i3;
            this.zQ.cancel();
            bVar7 = this.zR.zP;
            bVar7.zO = true;
        }
        this.py.setLayoutParams(layoutParams);
        bVar3 = this.zR.zP;
        z = bVar3.zO;
        if (z) {
            bVar4 = this.zR.zP;
            gVar = bVar4.zA;
            if (gVar != null) {
                bVar5 = this.zR.zP;
                gVar2 = bVar5.zA;
                gVar2.jE();
            }
        }
    }
}
