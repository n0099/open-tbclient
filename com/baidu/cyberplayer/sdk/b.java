package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.view.Surface;
import android.view.View;
import com.baidu.cyberplayer.sdk.e;
import com.baidu.cyberplayer.sdk.i;
/* loaded from: classes6.dex */
public class b extends GLSurfaceView implements i {

    /* renamed from: a  reason: collision with root package name */
    private e f1779a;

    public b(Context context) {
        super(context);
        setEGLContextClientVersion(2);
        this.f1779a = new e();
        this.f1779a.a(new e.a() { // from class: com.baidu.cyberplayer.sdk.b.1
            @Override // com.baidu.cyberplayer.sdk.e.a
            public void a() {
                b.this.requestRender();
            }
        });
        setRenderer(this.f1779a);
        setRenderMode(0);
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public Bitmap a(float f, int i, int i2) {
        this.f1779a.a(f, i, i2);
        return null;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void a() {
        this.f1779a.a();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void a(int i, int i2, int i3, int i4) {
        this.f1779a.a(i, i2, i3, i4);
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void b() {
        a();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void c() {
        this.f1779a.b();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public Surface d() {
        return this.f1779a.c();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public boolean e() {
        return true;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.f1779a.d();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public View getView() {
        return this;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setClientRotation(int i) {
        this.f1779a.b(i);
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setCyberSurfaceListener(i.a aVar) {
        this.f1779a.a(aVar);
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setDisplayMode(int i) {
        this.f1779a.a(i);
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setRawFrameRotation(int i) {
        this.f1779a.c(i);
    }

    @Override // android.view.SurfaceView, com.baidu.cyberplayer.sdk.i
    public void setZOrderMediaOverlay(boolean z) {
        super.setZOrderMediaOverlay(z);
    }
}
