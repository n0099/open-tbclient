package com.baidu.pano.platform.comapi.map;

import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes8.dex */
class a implements GLSurfaceView.Renderer {
    final /* synthetic */ BaseGLMapView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaseGLMapView baseGLMapView) {
        this.a = baseGLMapView;
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
