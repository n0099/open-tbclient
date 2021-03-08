package com.baidu.platform.comapi.walknavi.g;

import android.app.Activity;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.walknavi.g.b.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c implements c.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f2997a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f2997a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.g.b.c.a
    public void a(com.baidu.platform.comapi.walknavi.segmentbrowse.b bVar) {
        FrameLayout frameLayout;
        Activity activity;
        FrameLayout frameLayout2;
        com.baidu.platform.comapi.walknavi.segmentbrowse.widget.g gVar;
        com.baidu.platform.comapi.walknavi.g.b.c cVar;
        com.baidu.platform.comapi.walknavi.g.b.c cVar2;
        if (bVar == com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE) {
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
            com.baidu.platform.comapi.walknavi.b.a().D().j();
            cVar = this.f2997a.k;
            if (cVar != null) {
                cVar2 = this.f2997a.k;
                cVar2.a(true);
            }
        } else if (bVar == com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_SEGMENTBROWSE) {
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE);
            com.baidu.platform.comapi.walknavi.b.a().D().k();
            frameLayout = this.f2997a.r;
            frameLayout.removeAllViews();
            com.baidu.platform.comapi.walknavi.b.a().D().a(true);
            a aVar = this.f2997a;
            activity = this.f2997a.i;
            aVar.s = new com.baidu.platform.comapi.walknavi.segmentbrowse.widget.g(activity, this.f2997a);
            frameLayout2 = this.f2997a.r;
            gVar = this.f2997a.s;
            frameLayout2.addView(gVar);
        }
    }
}
