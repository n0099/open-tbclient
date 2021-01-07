package com.baidu.platform.comapi.walknavi.g.c;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class w implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f4545a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(c cVar) {
        this.f4545a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        com.baidu.platform.comapi.wnplatform.l.a.a().a("FootNaviPG.turnDire");
        com.baidu.platform.comapi.wnplatform.d.a.a("yang13", "loc click:" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.p());
        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.p() != com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE) {
            i = this.f4545a.v;
            switch (i) {
                case 1:
                    com.baidu.platform.comapi.walknavi.b.a().I().run("[3D车头向上]按钮点击");
                    return;
                case 2:
                    com.baidu.platform.comapi.walknavi.b.a().I().run("[2D正北]按钮点击");
                    return;
                case 3:
                    com.baidu.platform.comapi.walknavi.b.a().I().run("[回车位]按钮点击");
                    return;
                default:
                    return;
            }
        }
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
        com.baidu.platform.comapi.walknavi.b.a().G().j();
        this.f4545a.a(true);
    }
}
