package com.baidu.adp.widget.ScrollView;

import android.widget.LinearLayout;
/* loaded from: classes.dex */
class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f595a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.f595a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        boolean z;
        i iVar;
        i iVar2;
        int i3;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f595a.f594a.getLayoutParams();
        int i4 = layoutParams.topMargin;
        i = this.f595a.c.f593a;
        layoutParams.topMargin = i4 - i;
        int i5 = layoutParams.topMargin;
        i2 = this.f595a.c.c;
        if (i5 <= i2) {
            i3 = this.f595a.c.c;
            layoutParams.topMargin = i3;
            this.f595a.b.cancel();
            this.f595a.c.d = true;
        }
        this.f595a.f594a.setLayoutParams(layoutParams);
        z = this.f595a.c.d;
        if (z) {
            iVar = this.f595a.c.e;
            if (iVar != null) {
                iVar2 = this.f595a.c.e;
                iVar2.a();
            }
        }
    }
}
