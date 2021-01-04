package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import com.baidu.mapapi.map.BaiduMap;
/* loaded from: classes15.dex */
class i implements com.baidu.platform.comapi.map.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaiduMap f2918a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(BaiduMap baiduMap) {
        this.f2918a = baiduMap;
    }

    @Override // com.baidu.platform.comapi.map.c
    public void a(Bitmap bitmap) {
        BaiduMap.SnapshotReadyCallback snapshotReadyCallback;
        snapshotReadyCallback = this.f2918a.B;
        snapshotReadyCallback.onSnapshotReady(bitmap);
    }
}
