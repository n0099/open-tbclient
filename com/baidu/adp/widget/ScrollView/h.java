package com.baidu.adp.widget.ScrollView;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Timer;
/* loaded from: classes.dex */
final class h implements Runnable {
    final /* synthetic */ g a;
    private final /* synthetic */ View b;
    private final /* synthetic */ Timer c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, View view, Timer timer) {
        this.a = gVar;
        this.b = view;
        this.c = timer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        int i;
        f fVar2;
        int i2;
        f fVar3;
        boolean z;
        f fVar4;
        i iVar;
        f fVar5;
        i iVar2;
        f fVar6;
        int i3;
        f fVar7;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
        int i4 = layoutParams.topMargin;
        fVar = this.a.a;
        i = fVar.a;
        layoutParams.topMargin = i4 - i;
        int i5 = layoutParams.topMargin;
        fVar2 = this.a.a;
        i2 = fVar2.c;
        if (i5 <= i2) {
            fVar6 = this.a.a;
            i3 = fVar6.c;
            layoutParams.topMargin = i3;
            this.c.cancel();
            fVar7 = this.a.a;
            fVar7.d = true;
        }
        this.b.setLayoutParams(layoutParams);
        fVar3 = this.a.a;
        z = fVar3.d;
        if (z) {
            fVar4 = this.a.a;
            iVar = fVar4.e;
            if (iVar != null) {
                fVar5 = this.a.a;
                iVar2 = fVar5.e;
                iVar2.a();
            }
        }
    }
}
