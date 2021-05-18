package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapsdkplatform.comapi.map.ab;
/* loaded from: classes2.dex */
public class m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MapView f7189a;

    public m(MapView mapView) {
        this.f7189a = mapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        com.baidu.mapsdkplatform.comapi.map.j jVar2;
        com.baidu.mapsdkplatform.comapi.map.j jVar3;
        jVar = this.f7189a.f7019e;
        float f2 = jVar.a().f7719b;
        jVar2 = this.f7189a.f7019e;
        ab E = jVar2.a().E();
        float f3 = E.f7671a - 1.0f;
        E.f7671a = f3;
        if (f3 >= f2) {
            f2 = f3;
        }
        E.f7671a = f2;
        BaiduMap.mapStatusReason |= 16;
        jVar3 = this.f7189a.f7019e;
        jVar3.a().a(E, 300);
    }
}
