package com.baidu.adp.widget.ScrollView;

import android.widget.LinearLayout;
/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f586a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f586a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        boolean z;
        j jVar;
        j jVar2;
        int i3;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f586a.f585a.getLayoutParams();
        int i4 = layoutParams.topMargin;
        i = this.f586a.c.f584a;
        layoutParams.topMargin = i4 - i;
        int i5 = layoutParams.topMargin;
        i2 = this.f586a.c.c;
        if (i5 <= i2) {
            i3 = this.f586a.c.c;
            layoutParams.topMargin = i3;
            this.f586a.b.cancel();
            this.f586a.c.d = true;
        }
        this.f586a.f585a.setLayoutParams(layoutParams);
        z = this.f586a.c.d;
        if (z) {
            jVar = this.f586a.c.e;
            if (jVar != null) {
                jVar2 = this.f586a.c.e;
                jVar2.a();
            }
        }
    }
}
