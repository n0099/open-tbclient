package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import android.view.View;
import com.baidu.cyberplayer.sdk.g;
import com.baidu.cyberplayer.sdk.i;
/* loaded from: classes3.dex */
public class b extends GLTextureView implements i {
    public g a;

    @Override // com.baidu.cyberplayer.sdk.i
    public boolean e() {
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public View getView() {
        return this;
    }

    public b(Context context) {
        this(context, 0);
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setClientRotation(int i) {
        this.a.b(i);
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setCyberSurfaceListener(i.a aVar) {
        this.a.a(aVar);
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setDisplayMode(int i) {
        this.a.a(i);
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setRawFrameRotation(int i) {
        this.a.c(i);
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setZOrderMediaOverlay(boolean z) {
        CyberLog.d("CyberGLTextureView", this + "///setZOrderMediaOverlay : " + z);
    }

    public b(Context context, int i) {
        super(context);
        setEGLContextClientVersion(2);
        if (i == 256) {
            this.a = new c();
        } else {
            this.a = new g();
        }
        this.a.a(new g.a() { // from class: com.baidu.cyberplayer.sdk.b.1
            @Override // com.baidu.cyberplayer.sdk.g.a
            public void a() {
                b.this.requestRender();
            }
        });
        setRenderer(this.a);
        setRenderMode(0);
        CyberLog.d("CyberGLTextureView", this + "///mRender : " + this.a);
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public Bitmap a(float f, int i, int i2) {
        this.a.a(f, i, i2);
        return null;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void a() {
        this.a.c();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void b() {
        a();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void c() {
        this.a.a();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public Surface d() {
        return this.a.d();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void a(int i, int i2, int i3, int i4) {
        this.a.a(i, i2, i3, i4);
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public boolean a(int i, float f, float f2, float f3, float f4) {
        return this.a.a(i, f, f2, f3, f4);
    }
}
