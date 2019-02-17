package com.baidu.mapapi.walknavi.controllers.a;

import android.view.MotionEvent;
import com.baidu.mapapi.map.BaiduMap;
/* loaded from: classes4.dex */
class c implements BaiduMap.OnMapTouchListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapTouchListener
    public void onTouch(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                com.baidu.platform.comapi.walknavi.b.a().a(1, false);
                return;
            default:
                return;
        }
    }
}
