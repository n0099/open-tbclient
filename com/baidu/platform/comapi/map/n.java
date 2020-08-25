package com.baidu.platform.comapi.map;
/* loaded from: classes20.dex */
class n implements Runnable {
    final /* synthetic */ MapSurfaceView a;
    final /* synthetic */ m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, MapSurfaceView mapSurfaceView) {
        this.b = mVar;
        this.a = mapSurfaceView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a != null) {
            this.a.setBackgroundResource(0);
        }
    }
}
