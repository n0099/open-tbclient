package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapsdkplatform.comapi.map.ab;
import com.baidu.mapsdkplatform.comapi.map.ac;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class t implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TextureMapView f2813a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(TextureMapView textureMapView) {
        this.f2813a = textureMapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ac acVar;
        ac acVar2;
        ac acVar3;
        acVar = this.f2813a.f2773b;
        float f = acVar.b().f3053b;
        acVar2 = this.f2813a.f2773b;
        ab E = acVar2.b().E();
        E.f3040a -= 1.0f;
        if (E.f3040a >= f) {
            f = E.f3040a;
        }
        E.f3040a = f;
        BaiduMap.mapStatusReason |= 16;
        acVar3 = this.f2813a.f2773b;
        acVar3.b().a(E, 300);
    }
}
