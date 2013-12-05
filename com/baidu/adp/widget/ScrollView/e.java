package com.baidu.adp.widget.ScrollView;

import android.widget.LinearLayout;
/* loaded from: classes.dex */
class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f592a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f592a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        boolean z;
        i iVar;
        i iVar2;
        int i3;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f592a.f591a.getLayoutParams();
        int i4 = layoutParams.bottomMargin;
        i = this.f592a.c.f590a;
        layoutParams.bottomMargin = i4 - i;
        int i5 = layoutParams.bottomMargin;
        i2 = this.f592a.c.c;
        if (i5 <= i2) {
            i3 = this.f592a.c.c;
            layoutParams.bottomMargin = i3;
            this.f592a.b.cancel();
            this.f592a.c.d = true;
        }
        this.f592a.f591a.setLayoutParams(layoutParams);
        z = this.f592a.c.d;
        if (z) {
            iVar = this.f592a.c.e;
            if (iVar != null) {
                iVar2 = this.f592a.c.e;
                iVar2.a();
            }
        }
    }
}
