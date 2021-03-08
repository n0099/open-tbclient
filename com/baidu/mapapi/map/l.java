package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapsdkplatform.comapi.map.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MapView f2069a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(MapView mapView) {
        this.f2069a = mapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        com.baidu.mapsdkplatform.comapi.map.j jVar2;
        com.baidu.mapsdkplatform.comapi.map.j jVar3;
        jVar = this.f2069a.d;
        float f = jVar.a().b;
        jVar2 = this.f2069a.d;
        ab E = jVar2.a().E();
        E.f2214a -= 1.0f;
        if (E.f2214a >= f) {
            f = E.f2214a;
        }
        E.f2214a = f;
        BaiduMap.mapStatusReason |= 16;
        jVar3 = this.f2069a.d;
        jVar3.a().a(E, 300);
    }
}
