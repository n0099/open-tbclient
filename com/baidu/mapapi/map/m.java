package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapsdkplatform.comapi.map.ab;
/* loaded from: classes2.dex */
public class m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MapView f7080a;

    public m(MapView mapView) {
        this.f7080a = mapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        com.baidu.mapsdkplatform.comapi.map.j jVar2;
        com.baidu.mapsdkplatform.comapi.map.j jVar3;
        jVar = this.f7080a.f6922d;
        float f2 = jVar.a().f7612a;
        jVar2 = this.f7080a.f6922d;
        ab E = jVar2.a().E();
        float f3 = E.f7569a + 1.0f;
        E.f7569a = f3;
        if (f3 <= f2) {
            f2 = f3;
        }
        E.f7569a = f2;
        BaiduMap.mapStatusReason |= 16;
        jVar3 = this.f7080a.f6922d;
        jVar3.a().a(E, 300);
    }
}
