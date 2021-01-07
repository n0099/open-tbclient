package com.baidu.platform.comapi.map;
/* loaded from: classes3.dex */
class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MapSurfaceView f4355a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ m f4356b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, MapSurfaceView mapSurfaceView) {
        this.f4356b = mVar;
        this.f4355a = mapSurfaceView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4355a != null) {
            this.f4355a.setBackgroundResource(0);
        }
    }
}
