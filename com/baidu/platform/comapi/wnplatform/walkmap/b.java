package com.baidu.platform.comapi.wnplatform.walkmap;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class b implements BaiduMap.OnMapStatusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3160a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f3160a = aVar;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChange(MapStatus mapStatus) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        f fVar;
        f fVar2;
        fVar = this.f3160a.d;
        if (fVar != null) {
            fVar2 = this.f3160a.d;
            fVar2.a();
        }
    }
}
