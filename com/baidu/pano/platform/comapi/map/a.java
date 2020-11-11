package com.baidu.pano.platform.comapi.map;

import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes7.dex */
class a implements GLSurfaceView.Renderer {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaseGLMapView f2679a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaseGLMapView baseGLMapView) {
        this.f2679a = baseGLMapView;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
    }
}
