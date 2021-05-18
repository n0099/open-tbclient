package com.baidu.mapapi.map;

import com.baidu.mapapi.map.InfoWindow;
/* loaded from: classes2.dex */
public class b implements InfoWindow.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaiduMap f7172a;

    public b(BaiduMap baiduMap) {
        this.f7172a = baiduMap;
    }

    @Override // com.baidu.mapapi.map.InfoWindow.a
    public void a(InfoWindow infoWindow) {
        this.f7172a.hideInfoWindow(infoWindow);
    }

    @Override // com.baidu.mapapi.map.InfoWindow.a
    public void b(InfoWindow infoWindow) {
        this.f7172a.a(infoWindow);
    }
}
