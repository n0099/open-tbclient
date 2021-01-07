package com.baidu.mapapi.map;

import android.text.TextUtils;
import com.baidu.mapsdkplatform.comapi.map.f;
/* loaded from: classes3.dex */
class ad implements f.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CustomMapStyleCallBack f2904a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MapCustomStyleOptions f2905b;
    final /* synthetic */ WearMapView c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(WearMapView wearMapView, CustomMapStyleCallBack customMapStyleCallBack, MapCustomStyleOptions mapCustomStyleOptions) {
        this.c = wearMapView;
        this.f2904a = customMapStyleCallBack;
        this.f2905b = mapCustomStyleOptions;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.f.a
    public void a(int i, String str, String str2) {
        boolean z;
        if (this.f2904a == null || !this.f2904a.onCustomMapStyleLoadFailed(i, str, str2)) {
            z = this.c.H;
            if (z) {
                return;
            }
            this.c.a(str2, this.f2905b);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.f.a
    public void a(String str) {
        if (this.f2904a == null || !this.f2904a.onPreLoadLastCustomMapStyle(str)) {
            this.c.H = true;
            this.c.a(str, this.f2905b);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.f.a
    public void a(boolean z, String str) {
        if ((this.f2904a == null || !this.f2904a.onCustomMapStyleLoadSuccess(z, str)) && !TextUtils.isEmpty(str)) {
            this.c.a(str, 1);
            this.c.setMapCustomStyleEnable(true);
        }
    }
}
