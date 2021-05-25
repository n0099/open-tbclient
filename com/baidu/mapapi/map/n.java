package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapsdkplatform.comapi.map.ab;
/* loaded from: classes2.dex */
public class n implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MapView f7090a;

    public n(MapView mapView) {
        this.f7090a = mapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        com.baidu.mapsdkplatform.comapi.map.j jVar2;
        com.baidu.mapsdkplatform.comapi.map.j jVar3;
        jVar = this.f7090a.f6919e;
        float f2 = jVar.a().f7618a;
        jVar2 = this.f7090a.f6919e;
        ab E = jVar2.a().E();
        float f3 = E.f7571a + 1.0f;
        E.f7571a = f3;
        if (f3 <= f2) {
            f2 = f3;
        }
        E.f7571a = f2;
        BaiduMap.mapStatusReason |= 16;
        jVar3 = this.f7090a.f6919e;
        jVar3.a().a(E, 300);
    }
}
