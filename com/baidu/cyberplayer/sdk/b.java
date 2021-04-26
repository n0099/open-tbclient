package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.view.Surface;
import android.view.View;
import com.baidu.cyberplayer.sdk.e;
import com.baidu.cyberplayer.sdk.i;
/* loaded from: classes2.dex */
public class b extends GLSurfaceView implements i {

    /* renamed from: a  reason: collision with root package name */
    public e f5011a;

    public b(Context context) {
        super(context);
        setEGLContextClientVersion(2);
        e eVar = new e();
        this.f5011a = eVar;
        eVar.a(new e.a() { // from class: com.baidu.cyberplayer.sdk.b.1
            @Override // com.baidu.cyberplayer.sdk.e.a
            public void a() {
                b.this.requestRender();
            }
        });
        setRenderer(this.f5011a);
        setRenderMode(0);
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public Bitmap a(float f2, int i2, int i3) {
        this.f5011a.a(f2, i2, i3);
        return null;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void a() {
        this.f5011a.a();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void a(int i2, int i3, int i4, int i5) {
        this.f5011a.a(i2, i3, i4, i5);
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void b() {
        a();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void c() {
        this.f5011a.b();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public Surface d() {
        return this.f5011a.c();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public boolean e() {
        return true;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.f5011a.d();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public View getView() {
        return this;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setClientRotation(int i2) {
        this.f5011a.b(i2);
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setCyberSurfaceListener(i.a aVar) {
        this.f5011a.a(aVar);
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setDisplayMode(int i2) {
        this.f5011a.a(i2);
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setRawFrameRotation(int i2) {
        this.f5011a.c(i2);
    }

    @Override // android.view.SurfaceView, com.baidu.cyberplayer.sdk.i
    public void setZOrderMediaOverlay(boolean z) {
        super.setZOrderMediaOverlay(z);
    }
}
