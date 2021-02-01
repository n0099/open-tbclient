package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapsdkplatform.comapi.map.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MapView f2798a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(MapView mapView) {
        this.f2798a = mapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        com.baidu.mapsdkplatform.comapi.map.j jVar2;
        com.baidu.mapsdkplatform.comapi.map.j jVar3;
        jVar = this.f2798a.d;
        float f = jVar.a().f3050a;
        jVar2 = this.f2798a.d;
        ab E = jVar2.a().E();
        E.f3038a += 1.0f;
        if (E.f3038a <= f) {
            f = E.f3038a;
        }
        E.f3038a = f;
        BaiduMap.mapStatusReason |= 16;
        jVar3 = this.f2798a.d;
        jVar3.a().a(E, 300);
    }
}
