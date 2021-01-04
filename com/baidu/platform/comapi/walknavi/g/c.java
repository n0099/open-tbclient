package com.baidu.platform.comapi.walknavi.g;

import android.app.Activity;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.walknavi.g.c.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class c implements c.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4507a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f4507a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.g.c.c.a
    public void a(com.baidu.platform.comapi.walknavi.segmentbrowse.b bVar) {
        FrameLayout frameLayout;
        Activity activity;
        FrameLayout frameLayout2;
        com.baidu.platform.comapi.walknavi.segmentbrowse.widget.e eVar;
        com.baidu.platform.comapi.walknavi.g.c.c cVar;
        com.baidu.platform.comapi.walknavi.g.c.c cVar2;
        if (bVar == com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE) {
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
            com.baidu.platform.comapi.walknavi.b.a().G().j();
            cVar = this.f4507a.i;
            if (cVar != null) {
                cVar2 = this.f4507a.i;
                cVar2.a(true);
            }
        } else if (bVar == com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_SEGMENTBROWSE) {
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE);
            com.baidu.platform.comapi.walknavi.b.a().G().k();
            frameLayout = this.f4507a.p;
            frameLayout.removeAllViews();
            com.baidu.platform.comapi.walknavi.b.a().G().a(true);
            a aVar = this.f4507a;
            activity = this.f4507a.g;
            aVar.q = new com.baidu.platform.comapi.walknavi.segmentbrowse.widget.e(activity, this.f4507a);
            frameLayout2 = this.f4507a.p;
            eVar = this.f4507a.q;
            frameLayout2.addView(eVar);
        }
    }
}
