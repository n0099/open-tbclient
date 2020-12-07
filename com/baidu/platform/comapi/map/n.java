package com.baidu.platform.comapi.map;
/* loaded from: classes26.dex */
class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MapSurfaceView f2928a;
    final /* synthetic */ m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, MapSurfaceView mapSurfaceView) {
        this.b = mVar;
        this.f2928a = mapSurfaceView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f2928a != null) {
            this.f2928a.setBackgroundResource(0);
        }
    }
}
