package com.baidu.platform.comapi.wnplatform.walkmap;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
/* loaded from: classes2.dex */
public class b implements BaiduMap.OnMapStatusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f10389a;

    public b(a aVar) {
        this.f10389a = aVar;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChange(MapStatus mapStatus) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        f fVar;
        f fVar2;
        fVar = this.f10389a.f10388d;
        if (fVar == null) {
            return;
        }
        fVar2 = this.f10389a.f10388d;
        fVar2.a();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
    }
}
