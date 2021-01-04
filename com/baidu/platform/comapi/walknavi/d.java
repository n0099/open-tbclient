package com.baidu.platform.comapi.walknavi;

import com.baidu.mapapi.map.BaiduMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f4415a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.f4415a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.wnplatform.model.c cVar;
        com.baidu.platform.comapi.wnplatform.model.c cVar2;
        com.baidu.platform.comapi.wnplatform.model.c cVar3;
        this.f4415a.I().runEntryState();
        if (com.baidu.platform.comapi.wnplatform.a.a().d()) {
            cVar = this.f4415a.F;
            if (cVar != null) {
                BaiduMap map = b.a().J().a().getMap();
                cVar2 = this.f4415a.F;
                String b2 = cVar2.b();
                cVar3 = this.f4415a.F;
                map.switchBaseIndoorMapFloor(b2, cVar3.a());
            }
        }
    }
}
