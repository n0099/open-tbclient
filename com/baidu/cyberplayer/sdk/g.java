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
    public i.a f4942a;

    /* renamed from: b  reason: collision with root package name */
    public a f4943b;

    /* renamed from: c  reason: collision with root package name */
    public Surface f4944c;

    /* loaded from: classes2.dex */
    public class a implements SurfaceHolder.Callback {
        public a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            CyberLog.d("SurfaceCallback", "BVideoView surfaceCreated mCyberSurfaceListener:" + g.this.f4942a);
            if (g.this.f4942a != null) {
                g.this.f4942a.a(2);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            CyberLog.d("SurfaceCallback", "surfaceDestroyed mCyberSurfaceListener:" + g.this.f4942a);
        }
    }

    public g(Context context) {
        super(context);
        CyberLog.d("CyberSurfaceView", "CyberSurfaceView constructor called");
        getHolder().setType(0);
        this.f4943b = new a();
        getHolder().addCallback(this.f4943b);
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public Bitmap a(float f2, int i, int i2) {
        return null;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void a() {
        Surface surface = this.f4944c;
        if (surface != null) {
            surface.release();
        }
        this.f4944c = null;
        CyberLog.d("BVideoView", "release mSurface:" + this.f4944c);
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void a(int i, int i2, int i3, int i4) {
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
        this.f4944c = surface;
        return surface;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public boolean e() {
        return true;
    }

    public void finalize() throws Throwable {
        super.finalize();
        CyberLog.d("CyberSurfaceView", "CyberSurfaceView finalize called mSurface:" + this.f4944c);
        Surface surface = this.f4944c;
        if (surface != null) {
            surface.release();
            this.f4944c = null;
            getHolder().removeCallback(this.f4943b);
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
    public void setClientRotation(int i) {
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setCyberSurfaceListener(i.a aVar) {
        this.f4942a = aVar;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setDisplayMode(int i) {
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setRawFrameRotation(int i) {
    }
}
