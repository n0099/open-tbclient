package com.baidu.platform.comapi.walknavi;

import com.baidu.mapapi.map.BaiduMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class d implements Runnable {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.wnplatform.model.c cVar;
        com.baidu.platform.comapi.wnplatform.model.c cVar2;
        com.baidu.platform.comapi.wnplatform.model.c cVar3;
        this.a.I().runEntryState();
        if (com.baidu.platform.comapi.wnplatform.a.a().d()) {
            cVar = this.a.F;
            if (cVar != null) {
                BaiduMap map = b.a().J().a().getMap();
                cVar2 = this.a.F;
                String b = cVar2.b();
                cVar3 = this.a.F;
                map.switchBaseIndoorMapFloor(b, cVar3.a());
            }
        }
    }
}
