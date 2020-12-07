package com.baidu.mapapi.map;

import android.text.TextUtils;
import com.baidu.mapsdkplatform.comapi.map.f;
/* loaded from: classes26.dex */
class p implements f.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CustomMapStyleCallBack f2082a;
    final /* synthetic */ MapCustomStyleOptions b;
    final /* synthetic */ MapView c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(MapView mapView, CustomMapStyleCallBack customMapStyleCallBack, MapCustomStyleOptions mapCustomStyleOptions) {
        this.c = mapView;
        this.f2082a = customMapStyleCallBack;
        this.b = mapCustomStyleOptions;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.f.a
    public void a(int i, String str, String str2) {
        boolean z;
        if (this.f2082a == null || !this.f2082a.onCustomMapStyleLoadFailed(i, str, str2)) {
            z = this.c.B;
            if (z) {
                return;
            }
            this.c.a(str2, this.b);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.f.a
    public void a(String str) {
        if (this.f2082a == null || !this.f2082a.onPreLoadLastCustomMapStyle(str)) {
            this.c.a(str, this.b);
            this.c.B = true;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.f.a
    public void a(boolean z, String str) {
        if ((this.f2082a == null || !this.f2082a.onCustomMapStyleLoadSuccess(z, str)) && z && !TextUtils.isEmpty(str)) {
            this.c.a(str, 1);
            this.c.setMapCustomStyleEnable(true);
        }
    }
}
