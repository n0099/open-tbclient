package com.baidu.platform.comapi.wnplatform.walkmap;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class b implements BaiduMap.OnMapStatusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4708a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f4708a = aVar;
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
        fVar = this.f4708a.d;
        if (fVar != null) {
            fVar2 = this.f4708a.d;
            fVar2.a();
        }
    }
}
