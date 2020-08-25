package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import com.baidu.mapapi.map.BaiduMap;
/* loaded from: classes20.dex */
class g implements com.baidu.platform.comapi.map.c {
    final /* synthetic */ BaiduMap a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BaiduMap baiduMap) {
        this.a = baiduMap;
    }

    @Override // com.baidu.platform.comapi.map.c
    public void a(Bitmap bitmap) {
        BaiduMap.SnapshotReadyCallback snapshotReadyCallback;
        snapshotReadyCallback = this.a.B;
        snapshotReadyCallback.onSnapshotReady(bitmap);
    }
}
