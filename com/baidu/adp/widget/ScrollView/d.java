package com.baidu.adp.widget.ScrollView;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Timer;
/* loaded from: classes.dex */
class d implements Runnable {
    private final /* synthetic */ View py;
    private final /* synthetic */ Timer zP;
    final /* synthetic */ c zQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view, Timer timer) {
        this.zQ = cVar;
        this.py = view;
        this.zP = timer;
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
        bVar = this.zQ.zO;
        i = bVar.zx;
        layoutParams.bottomMargin = i4 - i;
        int i5 = layoutParams.bottomMargin;
        bVar2 = this.zQ.zO;
        i2 = bVar2.zM;
        if (i5 <= i2) {
            bVar6 = this.zQ.zO;
            i3 = bVar6.zM;
            layoutParams.bottomMargin = i3;
            this.zP.cancel();
            bVar7 = this.zQ.zO;
            bVar7.zN = true;
        }
        this.py.setLayoutParams(layoutParams);
        bVar3 = this.zQ.zO;
        z = bVar3.zN;
        if (z) {
            bVar4 = this.zQ.zO;
            gVar = bVar4.zz;
            if (gVar != null) {
                bVar5 = this.zQ.zO;
                gVar2 = bVar5.zz;
                gVar2.jH();
            }
        }
    }
}
