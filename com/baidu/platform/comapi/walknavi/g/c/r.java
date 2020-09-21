package com.baidu.platform.comapi.walknavi.g.c;

import android.view.View;
/* loaded from: classes3.dex */
class r implements View.OnClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.platform.comapi.walknavi.b.a().a((com.baidu.platform.comapi.wnplatform.a.a().e() & 4) | 2, false);
        com.baidu.platform.comapi.walknavi.b.a().G().j();
        com.baidu.platform.comapi.walknavi.b.a().G().a(false);
        com.baidu.platform.comapi.walknavi.b.a().G().c(0);
    }
}
