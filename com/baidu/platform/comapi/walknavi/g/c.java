package com.baidu.platform.comapi.walknavi.g;

import android.app.Activity;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.walknavi.g.c.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class c implements c.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3024a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f3024a = aVar;
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
            cVar = this.f3024a.i;
            if (cVar != null) {
                cVar2 = this.f3024a.i;
                cVar2.a(true);
            }
        } else if (bVar == com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_SEGMENTBROWSE) {
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE);
            com.baidu.platform.comapi.walknavi.b.a().G().k();
            frameLayout = this.f3024a.p;
            frameLayout.removeAllViews();
            com.baidu.platform.comapi.walknavi.b.a().G().a(true);
            a aVar = this.f3024a;
            activity = this.f3024a.g;
            aVar.q = new com.baidu.platform.comapi.walknavi.segmentbrowse.widget.e(activity, this.f3024a);
            frameLayout2 = this.f3024a.p;
            eVar = this.f3024a.q;
            frameLayout2.addView(eVar);
        }
    }
}
