package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapsdkplatform.comapi.map.ab;
import com.baidu.mapsdkplatform.comapi.map.ac;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ TextureMapView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(TextureMapView textureMapView) {
        this.a = textureMapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ac acVar;
        ac acVar2;
        ac acVar3;
        acVar = this.a.b;
        float f = acVar.b().a;
        acVar2 = this.a.b;
        ab E = acVar2.b().E();
        E.a += 1.0f;
        if (E.a <= f) {
            f = E.a;
        }
        E.a = f;
        BaiduMap.mapStatusReason |= 16;
        acVar3 = this.a.b;
        acVar3.b().a(E, 300);
    }
}
