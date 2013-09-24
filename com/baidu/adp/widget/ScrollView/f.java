package com.baidu.adp.widget.ScrollView;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Timer;
/* loaded from: classes.dex */
class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f503a;
    private final /* synthetic */ View b;
    private final /* synthetic */ Timer c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, View view, Timer timer) {
        this.f503a = eVar;
        this.b = view;
        this.c = timer;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar;
        int i;
        d dVar2;
        int i2;
        d dVar3;
        boolean z;
        d dVar4;
        j jVar;
        d dVar5;
        j jVar2;
        d dVar6;
        int i3;
        d dVar7;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
        int i4 = layoutParams.bottomMargin;
        dVar = this.f503a.f502a;
        i = dVar.f501a;
        layoutParams.bottomMargin = i4 - i;
        int i5 = layoutParams.bottomMargin;
        dVar2 = this.f503a.f502a;
        i2 = dVar2.c;
        if (i5 <= i2) {
            dVar6 = this.f503a.f502a;
            i3 = dVar6.c;
            layoutParams.bottomMargin = i3;
            this.c.cancel();
            dVar7 = this.f503a.f502a;
            dVar7.d = true;
        }
        this.b.setLayoutParams(layoutParams);
        dVar3 = this.f503a.f502a;
        z = dVar3.d;
        if (z) {
            dVar4 = this.f503a.f502a;
            jVar = dVar4.e;
            if (jVar != null) {
                dVar5 = this.f503a.f502a;
                jVar2 = dVar5.e;
                jVar2.a();
            }
        }
    }
}
