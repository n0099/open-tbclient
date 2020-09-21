package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import com.baidu.mapapi.map.BaiduMap;
/* loaded from: classes3.dex */
class h implements com.baidu.platform.comapi.map.c {
    final /* synthetic */ BaiduMap a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(BaiduMap baiduMap) {
        this.a = baiduMap;
    }

    @Override // com.baidu.platform.comapi.map.c
    public void a(Bitmap bitmap) {
        BaiduMap.SnapshotReadyCallback snapshotReadyCallback;
        snapshotReadyCallback = this.a.B;
        snapshotReadyCallback.onSnapshotReady(bitmap);
    }
}
