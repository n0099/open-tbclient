package com.baidu.platform.comapi.walknavi;

import com.baidu.mapapi.map.BaiduMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2961a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.f2961a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.wnplatform.model.c cVar;
        com.baidu.platform.comapi.wnplatform.model.c cVar2;
        com.baidu.platform.comapi.wnplatform.model.c cVar3;
        this.f2961a.I().runEntryState();
        if (com.baidu.platform.comapi.wnplatform.a.a().d()) {
            cVar = this.f2961a.F;
            if (cVar != null) {
                BaiduMap map = b.a().J().a().getMap();
                cVar2 = this.f2961a.F;
                String b = cVar2.b();
                cVar3 = this.f2961a.F;
                map.switchBaseIndoorMapFloor(b, cVar3.a());
            }
        }
    }
}
