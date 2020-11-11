package com.baidu.mapapi.map;

import android.text.TextUtils;
import com.baidu.mapsdkplatform.comapi.map.f;
/* loaded from: classes7.dex */
class p implements f.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CustomMapStyleCallBack f2080a;
    final /* synthetic */ MapCustomStyleOptions b;
    final /* synthetic */ MapView c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(MapView mapView, CustomMapStyleCallBack customMapStyleCallBack, MapCustomStyleOptions mapCustomStyleOptions) {
        this.c = mapView;
        this.f2080a = customMapStyleCallBack;
        this.b = mapCustomStyleOptions;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.f.a
    public void a(int i, String str, String str2) {
        boolean z;
        if (this.f2080a == null || !this.f2080a.onCustomMapStyleLoadFailed(i, str, str2)) {
            z = this.c.B;
            if (z) {
                return;
            }
            this.c.a(str2, this.b);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.f.a
    public void a(String str) {
        if (this.f2080a == null || !this.f2080a.onPreLoadLastCustomMapStyle(str)) {
            this.c.a(str, this.b);
            this.c.B = true;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.f.a
    public void a(boolean z, String str) {
        if ((this.f2080a == null || !this.f2080a.onCustomMapStyleLoadSuccess(z, str)) && z && !TextUtils.isEmpty(str)) {
            this.c.a(str, 1);
            this.c.setMapCustomStyleEnable(true);
        }
    }
}
