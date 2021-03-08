package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapsdkplatform.comapi.map.ab;
import com.baidu.mapsdkplatform.comapi.map.ac;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class u implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TextureMapView f2080a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(TextureMapView textureMapView) {
        this.f2080a = textureMapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ac acVar;
        ac acVar2;
        ac acVar3;
        acVar = this.f2080a.b;
        float f = acVar.b().f2221a;
        acVar2 = this.f2080a.b;
        ab E = acVar2.b().E();
        E.f2214a += 1.0f;
        if (E.f2214a <= f) {
            f = E.f2214a;
        }
        E.f2214a = f;
        BaiduMap.mapStatusReason |= 16;
        acVar3 = this.f2080a.b;
        acVar3.b().a(E, 300);
    }
}
