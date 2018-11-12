package com.baidu.platform.comapi.walknavi.g;

import android.app.Activity;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.walknavi.g.b.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class t implements c.a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(a aVar) {
        this.a = aVar;
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
            com.baidu.platform.comapi.walknavi.b.a().y().i();
            cVar = this.a.k;
            if (cVar != null) {
                cVar2 = this.a.k;
                cVar2.a(true);
            }
        } else if (bVar == com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_SEGMENTBROWSE) {
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE);
            com.baidu.platform.comapi.walknavi.b.a().y().j();
            frameLayout = this.a.r;
            frameLayout.removeAllViews();
            com.baidu.platform.comapi.walknavi.b.a().y().a(true);
            a aVar = this.a;
            activity = this.a.i;
            aVar.s = new com.baidu.platform.comapi.walknavi.segmentbrowse.widget.g(activity, this.a);
            frameLayout2 = this.a.r;
            gVar = this.a.s;
            frameLayout2.addView(gVar);
        }
    }
}
