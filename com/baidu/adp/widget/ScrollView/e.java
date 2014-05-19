package com.baidu.adp.widget.ScrollView;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Timer;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ d a;
    private final /* synthetic */ View b;
    private final /* synthetic */ Timer c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, View view, Timer timer) {
        this.a = dVar;
        this.b = view;
        this.c = timer;
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
        i iVar;
        c cVar5;
        i iVar2;
        c cVar6;
        int i3;
        c cVar7;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
        int i4 = layoutParams.bottomMargin;
        cVar = this.a.a;
        i = cVar.a;
        layoutParams.bottomMargin = i4 - i;
        int i5 = layoutParams.bottomMargin;
        cVar2 = this.a.a;
        i2 = cVar2.c;
        if (i5 <= i2) {
            cVar6 = this.a.a;
            i3 = cVar6.c;
            layoutParams.bottomMargin = i3;
            this.c.cancel();
            cVar7 = this.a.a;
            cVar7.d = true;
        }
        this.b.setLayoutParams(layoutParams);
        cVar3 = this.a.a;
        z = cVar3.d;
        if (z) {
            cVar4 = this.a.a;
            iVar = cVar4.e;
            if (iVar != null) {
                cVar5 = this.a.a;
                iVar2 = cVar5.e;
                iVar2.a();
            }
        }
    }
}
