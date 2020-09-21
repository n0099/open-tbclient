package com.baidu.platform.comapi.walknavi.g;

import android.app.Activity;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.walknavi.g.c.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class c implements c.a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
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
            cVar = this.a.i;
            if (cVar != null) {
                cVar2 = this.a.i;
                cVar2.a(true);
            }
        } else if (bVar == com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_SEGMENTBROWSE) {
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE);
            com.baidu.platform.comapi.walknavi.b.a().G().k();
            frameLayout = this.a.p;
            frameLayout.removeAllViews();
            com.baidu.platform.comapi.walknavi.b.a().G().a(true);
            a aVar = this.a;
            activity = this.a.g;
            aVar.q = new com.baidu.platform.comapi.walknavi.segmentbrowse.widget.e(activity, this.a);
            frameLayout2 = this.a.p;
            eVar = this.a.q;
            frameLayout2.addView(eVar);
        }
    }
}
