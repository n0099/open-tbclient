package com.baidu.platform.comapi.walknavi.g;

import android.app.Activity;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.walknavi.g.b.c;
/* loaded from: classes2.dex */
public class c implements c.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f10041a;

    public c(a aVar) {
        this.f10041a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.g.b.c.a
    public void a(com.baidu.platform.comapi.walknavi.segmentbrowse.b bVar) {
        FrameLayout frameLayout;
        Activity activity;
        FrameLayout frameLayout2;
        com.baidu.platform.comapi.walknavi.segmentbrowse.widget.g gVar;
        com.baidu.platform.comapi.walknavi.g.b.c cVar;
        com.baidu.platform.comapi.walknavi.g.b.c cVar2;
        com.baidu.platform.comapi.walknavi.segmentbrowse.b bVar2 = com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE;
        if (bVar == bVar2) {
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(bVar2);
            com.baidu.platform.comapi.walknavi.b.a().D().j();
            cVar = this.f10041a.k;
            if (cVar != null) {
                cVar2 = this.f10041a.k;
                cVar2.a(true);
            }
        } else if (bVar == com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_SEGMENTBROWSE) {
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE);
            com.baidu.platform.comapi.walknavi.b.a().D().k();
            frameLayout = this.f10041a.r;
            frameLayout.removeAllViews();
            com.baidu.platform.comapi.walknavi.b.a().D().a(true);
            a aVar = this.f10041a;
            activity = this.f10041a.f9980i;
            aVar.s = new com.baidu.platform.comapi.walknavi.segmentbrowse.widget.g(activity, this.f10041a);
            frameLayout2 = this.f10041a.r;
            gVar = this.f10041a.s;
            frameLayout2.addView(gVar);
        }
    }
}
