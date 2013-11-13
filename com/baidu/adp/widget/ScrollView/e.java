package com.baidu.adp.widget.ScrollView;

import android.widget.LinearLayout;
/* loaded from: classes.dex */
class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f588a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f588a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        boolean z;
        i iVar;
        i iVar2;
        int i3;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f588a.f587a.getLayoutParams();
        int i4 = layoutParams.bottomMargin;
        i = this.f588a.c.f586a;
        layoutParams.bottomMargin = i4 - i;
        int i5 = layoutParams.bottomMargin;
        i2 = this.f588a.c.c;
        if (i5 <= i2) {
            i3 = this.f588a.c.c;
            layoutParams.bottomMargin = i3;
            this.f588a.b.cancel();
            this.f588a.c.d = true;
        }
        this.f588a.f587a.setLayoutParams(layoutParams);
        z = this.f588a.c.d;
        if (z) {
            iVar = this.f588a.c.e;
            if (iVar != null) {
                iVar2 = this.f588a.c.e;
                iVar2.a();
            }
        }
    }
}
