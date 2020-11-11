package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import com.baidu.mapapi.map.BaiduMap;
/* loaded from: classes7.dex */
class j implements com.baidu.platform.comapi.map.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaiduMap f2075a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BaiduMap baiduMap) {
        this.f2075a = baiduMap;
    }

    @Override // com.baidu.platform.comapi.map.c
    public void a(Bitmap bitmap) {
        BaiduMap.SnapshotReadyCallback snapshotReadyCallback;
        snapshotReadyCallback = this.f2075a.B;
        snapshotReadyCallback.onSnapshotReady(bitmap);
    }
}
