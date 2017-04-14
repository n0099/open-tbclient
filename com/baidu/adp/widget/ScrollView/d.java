package com.baidu.adp.widget.ScrollView;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Timer;
/* loaded from: classes.dex */
class d implements Runnable {
    private final /* synthetic */ Timer IG;
    final /* synthetic */ c IH;
    private final /* synthetic */ View zc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view, Timer timer) {
        this.IH = cVar;
        this.zc = view;
        this.IG = timer;
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.zc.getLayoutParams();
        int i4 = layoutParams.bottomMargin;
        bVar = this.IH.IF;
        i = bVar.Io;
        layoutParams.bottomMargin = i4 - i;
        int i5 = layoutParams.bottomMargin;
        bVar2 = this.IH.IF;
        i2 = bVar2.IC;
        if (i5 <= i2) {
            bVar6 = this.IH.IF;
            i3 = bVar6.IC;
            layoutParams.bottomMargin = i3;
            this.IG.cancel();
            bVar7 = this.IH.IF;
            bVar7.IE = true;
        }
        this.zc.setLayoutParams(layoutParams);
        bVar3 = this.IH.IF;
        z = bVar3.IE;
        if (z) {
            bVar4 = this.IH.IF;
            gVar = bVar4.Iq;
            if (gVar != null) {
                bVar5 = this.IH.IF;
                gVar2 = bVar5.Iq;
                gVar2.lr();
            }
        }
    }
}
