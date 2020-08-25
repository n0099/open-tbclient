package com.baidu.mapapi.map;

import android.text.TextUtils;
import com.baidu.mapsdkplatform.comapi.map.f;
/* loaded from: classes20.dex */
class ad implements f.a {
    final /* synthetic */ CustomMapStyleCallBack a;
    final /* synthetic */ MapCustomStyleOptions b;
    final /* synthetic */ WearMapView c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(WearMapView wearMapView, CustomMapStyleCallBack customMapStyleCallBack, MapCustomStyleOptions mapCustomStyleOptions) {
        this.c = wearMapView;
        this.a = customMapStyleCallBack;
        this.b = mapCustomStyleOptions;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.f.a
    public void a(int i, String str, String str2) {
        boolean z;
        if (this.a == null || !this.a.onCustomMapStyleLoadFailed(i, str, str2)) {
            z = this.c.H;
            if (z) {
                return;
            }
            this.c.a(str2, this.b);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.f.a
    public void a(String str) {
        if (this.a == null || !this.a.onPreLoadLastCustomMapStyle(str)) {
            this.c.H = true;
            this.c.a(str, this.b);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.f.a
    public void a(boolean z, String str) {
        if ((this.a == null || !this.a.onCustomMapStyleLoadSuccess(z, str)) && !TextUtils.isEmpty(str)) {
            this.c.a(str, 1);
            this.c.setMapCustomStyleEnable(true);
        }
    }
}
