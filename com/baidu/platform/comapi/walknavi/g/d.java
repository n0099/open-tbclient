package com.baidu.platform.comapi.walknavi.g;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class d implements BaiduMap.OnBaseIndoorMapListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4548a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.f4548a = aVar;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnBaseIndoorMapListener
    public void onBaseIndoorMapMode(boolean z, MapBaseIndoorMapInfo mapBaseIndoorMapInfo) {
        com.baidu.platform.comapi.walknavi.g.a.a aVar;
        com.baidu.platform.comapi.walknavi.g.a.a aVar2;
        if (!z || mapBaseIndoorMapInfo == null) {
            aVar = this.f4548a.B;
            aVar.c();
        } else if (com.baidu.platform.comapi.wnplatform.a.a().d()) {
            aVar2 = this.f4548a.B;
            aVar2.a(mapBaseIndoorMapInfo);
        }
    }
}
