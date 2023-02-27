package com.baidu.mapapi.map;

import android.text.TextUtils;
import com.baidu.mapsdkplatform.comapi.map.f;
/* loaded from: classes2.dex */
public class aa implements f.a {
    public final /* synthetic */ CustomMapStyleCallBack a;
    public final /* synthetic */ MapCustomStyleOptions b;
    public final /* synthetic */ TextureMapView c;

    public aa(TextureMapView textureMapView, CustomMapStyleCallBack customMapStyleCallBack, MapCustomStyleOptions mapCustomStyleOptions) {
        this.c = textureMapView;
        this.a = customMapStyleCallBack;
        this.b = mapCustomStyleOptions;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.f.a
    public void a(int i, String str, String str2) {
        boolean z;
        CustomMapStyleCallBack customMapStyleCallBack = this.a;
        if (customMapStyleCallBack != null && customMapStyleCallBack.onCustomMapStyleLoadFailed(i, str, str2)) {
            return;
        }
        z = this.c.B;
        if (z) {
            return;
        }
        this.c.a(str2, this.b);
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.f.a
    public void a(String str) {
        CustomMapStyleCallBack customMapStyleCallBack = this.a;
        if (customMapStyleCallBack != null && customMapStyleCallBack.onPreLoadLastCustomMapStyle(str)) {
            return;
        }
        this.c.a(str, this.b);
        this.c.B = true;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.f.a
    public void a(boolean z, String str) {
        CustomMapStyleCallBack customMapStyleCallBack = this.a;
        if ((customMapStyleCallBack != null && customMapStyleCallBack.onCustomMapStyleLoadSuccess(z, str)) || TextUtils.isEmpty(str)) {
            return;
        }
        this.c.a(str, "");
        this.c.setMapCustomStyleEnable(true);
    }
}
