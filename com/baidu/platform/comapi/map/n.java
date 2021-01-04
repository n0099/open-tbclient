package com.baidu.platform.comapi.map;
/* loaded from: classes15.dex */
class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MapSurfaceView f4354a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ m f4355b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, MapSurfaceView mapSurfaceView) {
        this.f4355b = mVar;
        this.f4354a = mapSurfaceView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4354a != null) {
            this.f4354a.setBackgroundResource(0);
        }
    }
}
