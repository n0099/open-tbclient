package com.baidu.platform.comapi.walknavi.g.b;

import android.view.View;
/* loaded from: classes2.dex */
public class w implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f9677a;

    public w(c cVar) {
        this.f9677a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG.turnDire");
        com.baidu.platform.comapi.wnplatform.d.a.a("yang13", "loc click:" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.s());
        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() != com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE) {
            i = this.f9677a.v;
            if (i == 1) {
                com.baidu.platform.comapi.walknavi.b.a().F().run("[3D车头向上]按钮点击");
                return;
            } else if (i == 2) {
                com.baidu.platform.comapi.walknavi.b.a().F().run("[2D正北]按钮点击");
                return;
            } else if (i != 3) {
                return;
            } else {
                com.baidu.platform.comapi.walknavi.b.a().F().run("[回车位]按钮点击");
                return;
            }
        }
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
        com.baidu.platform.comapi.walknavi.b.a().D().j();
        this.f9677a.a(true);
    }
}
