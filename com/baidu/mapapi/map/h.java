package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import com.baidu.mapapi.map.BaiduMap;
/* loaded from: classes7.dex */
class h implements com.baidu.platform.comapi.map.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaiduMap f2071a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(BaiduMap baiduMap) {
        this.f2071a = baiduMap;
    }

    @Override // com.baidu.platform.comapi.map.c
    public void a(Bitmap bitmap) {
        BaiduMap.SnapshotReadyCallback snapshotReadyCallback;
        snapshotReadyCallback = this.f2071a.B;
        snapshotReadyCallback.onSnapshotReady(bitmap);
    }
}
