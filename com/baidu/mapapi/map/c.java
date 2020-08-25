package com.baidu.mapapi.map;

import com.baidu.mapapi.map.InfoWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class c implements InfoWindow.a {
    final /* synthetic */ BaiduMap a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BaiduMap baiduMap) {
        this.a = baiduMap;
    }

    @Override // com.baidu.mapapi.map.InfoWindow.a
    public void a(InfoWindow infoWindow) {
        this.a.hideInfoWindow(infoWindow);
    }

    @Override // com.baidu.mapapi.map.InfoWindow.a
    public void b(InfoWindow infoWindow) {
        this.a.a(infoWindow);
    }
}
