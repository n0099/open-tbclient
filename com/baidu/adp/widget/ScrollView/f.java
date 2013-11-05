package com.baidu.adp.widget.ScrollView;

import android.widget.LinearLayout;
/* loaded from: classes.dex */
class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f583a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f583a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        boolean z;
        j jVar;
        j jVar2;
        int i3;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f583a.f582a.getLayoutParams();
        int i4 = layoutParams.bottomMargin;
        i = this.f583a.c.f581a;
        layoutParams.bottomMargin = i4 - i;
        int i5 = layoutParams.bottomMargin;
        i2 = this.f583a.c.c;
        if (i5 <= i2) {
            i3 = this.f583a.c.c;
            layoutParams.bottomMargin = i3;
            this.f583a.b.cancel();
            this.f583a.c.d = true;
        }
        this.f583a.f582a.setLayoutParams(layoutParams);
        z = this.f583a.c.d;
        if (z) {
            jVar = this.f583a.c.e;
            if (jVar != null) {
                jVar2 = this.f583a.c.e;
                jVar2.a();
            }
        }
    }
}
