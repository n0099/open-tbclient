package com.baidu.mapapi.map;

import com.baidu.mapapi.map.InfoWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class c implements InfoWindow.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaiduMap f2913a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BaiduMap baiduMap) {
        this.f2913a = baiduMap;
    }

    @Override // com.baidu.mapapi.map.InfoWindow.a
    public void a(InfoWindow infoWindow) {
        this.f2913a.hideInfoWindow(infoWindow);
    }

    @Override // com.baidu.mapapi.map.InfoWindow.a
    public void b(InfoWindow infoWindow) {
        this.f2913a.a(infoWindow);
    }
}
