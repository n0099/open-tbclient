package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.baidu.cyberplayer.sdk.i;
/* loaded from: classes2.dex */
public class g extends SurfaceView implements i {

    /* renamed from: a  reason: collision with root package name */
    public i.a f5102a;

    /* renamed from: b  reason: collision with root package name */
    public a f5103b;

    /* renamed from: c  reason: collision with root package name */
    public Surface f5104c;

    /* loaded from: classes2.dex */
    public class a implements SurfaceHolder.Callback {
        public a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            CyberLog.d("SurfaceCallback", "BVideoView surfaceCreated mCyberSurfaceListener:" + g.this.f5102a);
            if (g.this.f5102a != null) {
                g.this.f5102a.a(2);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            CyberLog.d("SurfaceCallback", "surfaceDestroyed mCyberSurfaceListener:" + g.this.f5102a);
        }
    }

    public g(Context context) {
        super(context);
        CyberLog.d("CyberSurfaceView", "CyberSurfaceView constructor called");
        getHolder().setType(0);
        this.f5103b = new a();
        getHolder().addCallback(this.f5103b);
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public Bitmap a(float f2, int i2, int i3) {
        return null;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void a() {
        Surface surface = this.f5104c;
        if (surface != null) {
            surface.release();
        }
        this.f5104c = null;
        CyberLog.d("BVideoView", "release mSurface:" + this.f5104c);
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void a(int i2, int i3, int i4, int i5) {
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void b() {
        a();
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void c() {
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public Surface d() {
        Surface surface = getHolder().getSurface();
        this.f5104c = surface;
        return surface;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public boolean e() {
        return true;
    }

    public void finalize() throws Throwable {
        super.finalize();
        CyberLog.d("CyberSurfaceView", "CyberSurfaceView finalize called mSurface:" + this.f5104c);
        Surface surface = this.f5104c;
        if (surface != null) {
            surface.release();
            this.f5104c = null;
            getHolder().removeCallback(this.f5103b);
        }
    }

    public SurfaceTexture getSurfaceTexture() {
        return null;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public View getView() {
        return this;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setClientRotation(int i2) {
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setCyberSurfaceListener(i.a aVar) {
        this.f5102a = aVar;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setDisplayMode(int i2) {
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setRawFrameRotation(int i2) {
    }
}
