package com.baidu.adp.widget.ScrollView;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Timer;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ h a;
    private final /* synthetic */ View b;
    private final /* synthetic */ Timer c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, View view, Timer timer) {
        this.a = hVar;
        this.b = view;
        this.c = timer;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        int i;
        g gVar2;
        int i2;
        g gVar3;
        boolean z;
        g gVar4;
        j jVar;
        g gVar5;
        j jVar2;
        g gVar6;
        int i3;
        g gVar7;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
        int i4 = layoutParams.topMargin;
        gVar = this.a.a;
        i = gVar.a;
        layoutParams.topMargin = i4 - i;
        int i5 = layoutParams.topMargin;
        gVar2 = this.a.a;
        i2 = gVar2.c;
        if (i5 <= i2) {
            gVar6 = this.a.a;
            i3 = gVar6.c;
            layoutParams.topMargin = i3;
            this.c.cancel();
            gVar7 = this.a.a;
            gVar7.d = true;
        }
        this.b.setLayoutParams(layoutParams);
        gVar3 = this.a.a;
        z = gVar3.d;
        if (z) {
            gVar4 = this.a.a;
            jVar = gVar4.e;
            if (jVar != null) {
                gVar5 = this.a.a;
                jVar2 = gVar5.e;
                jVar2.a();
            }
        }
    }
}
