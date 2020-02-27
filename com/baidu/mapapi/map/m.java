package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapsdkplatform.comapi.map.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ MapView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(MapView mapView) {
        this.a = mapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        com.baidu.mapsdkplatform.comapi.map.j jVar2;
        com.baidu.mapsdkplatform.comapi.map.j jVar3;
        jVar = this.a.d;
        float f = jVar.a().a;
        jVar2 = this.a.d;
        ab E = jVar2.a().E();
        E.a += 1.0f;
        if (E.a <= f) {
            f = E.a;
        }
        E.a = f;
        BaiduMap.mapStatusReason |= 16;
        jVar3 = this.a.d;
        jVar3.a().a(E, 300);
    }
}
