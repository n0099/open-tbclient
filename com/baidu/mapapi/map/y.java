package com.baidu.mapapi.map;

import android.text.TextUtils;
import com.baidu.mapsdkplatform.comapi.map.f;
/* loaded from: classes26.dex */
class y implements f.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CustomMapStyleCallBack f2091a;
    final /* synthetic */ MapCustomStyleOptions b;
    final /* synthetic */ TextureMapView c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(TextureMapView textureMapView, CustomMapStyleCallBack customMapStyleCallBack, MapCustomStyleOptions mapCustomStyleOptions) {
        this.c = textureMapView;
        this.f2091a = customMapStyleCallBack;
        this.b = mapCustomStyleOptions;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.f.a
    public void a(int i, String str, String str2) {
        boolean z;
        if (this.f2091a == null || !this.f2091a.onCustomMapStyleLoadFailed(i, str, str2)) {
            z = this.c.B;
            if (z) {
                return;
            }
            this.c.a(str2, this.b);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.f.a
    public void a(String str) {
        if (this.f2091a == null || !this.f2091a.onPreLoadLastCustomMapStyle(str)) {
            this.c.a(str, this.b);
            this.c.B = true;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.f.a
    public void a(boolean z, String str) {
        if ((this.f2091a == null || !this.f2091a.onCustomMapStyleLoadSuccess(z, str)) && !TextUtils.isEmpty(str)) {
            this.c.a(str, 1);
            this.c.setMapCustomStyleEnable(true);
        }
    }
}
