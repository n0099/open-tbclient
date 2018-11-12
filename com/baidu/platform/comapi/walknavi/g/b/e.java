package com.baidu.platform.comapi.walknavi.g.b;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG.turnDire");
        com.baidu.platform.comapi.wnplatform.c.a.a("yang13", "loc click:" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.s());
        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() != com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE) {
            i = this.a.r;
            switch (i) {
                case 1:
                    com.baidu.platform.comapi.walknavi.b.a().A().run("[3D车头向上]按钮点击");
                    return;
                case 2:
                    com.baidu.platform.comapi.walknavi.b.a().A().run("[2D正北]按钮点击");
                    return;
                case 3:
                    com.baidu.platform.comapi.walknavi.b.a().A().run("[回车位]按钮点击");
                    return;
                default:
                    return;
            }
        }
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
        com.baidu.platform.comapi.walknavi.b.a().y().i();
        this.a.a(true);
    }
}
