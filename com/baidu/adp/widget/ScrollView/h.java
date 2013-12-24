package com.baidu.adp.widget.ScrollView;

import android.widget.LinearLayout;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        boolean z;
        i iVar;
        i iVar2;
        int i3;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.a.getLayoutParams();
        int i4 = layoutParams.topMargin;
        i = this.a.c.a;
        layoutParams.topMargin = i4 - i;
        int i5 = layoutParams.topMargin;
        i2 = this.a.c.c;
        if (i5 <= i2) {
            i3 = this.a.c.c;
            layoutParams.topMargin = i3;
            this.a.b.cancel();
            this.a.c.d = true;
        }
        this.a.a.setLayoutParams(layoutParams);
        z = this.a.c.d;
        if (z) {
            iVar = this.a.c.e;
            if (iVar != null) {
                iVar2 = this.a.c.e;
                iVar2.a();
            }
        }
    }
}
