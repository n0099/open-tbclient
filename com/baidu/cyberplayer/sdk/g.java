package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.baidu.cyberplayer.sdk.i;
/* loaded from: classes6.dex */
public class g extends SurfaceView implements i {

    /* renamed from: a  reason: collision with root package name */
    private i.a f1819a;

    /* renamed from: b  reason: collision with root package name */
    private a f1820b;
    private Surface c;

    /* loaded from: classes6.dex */
    private class a implements SurfaceHolder.Callback {
        private a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            CyberLog.d("SurfaceCallback", "BVideoView surfaceCreated mCyberSurfaceListener:" + g.this.f1819a);
            if (g.this.f1819a != null) {
                g.this.f1819a.a(2);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            CyberLog.d("SurfaceCallback", "surfaceDestroyed mCyberSurfaceListener:" + g.this.f1819a);
        }
    }

    public g(Context context) {
        super(context);
        CyberLog.d("CyberSurfaceView", "CyberSurfaceView constructor called");
        getHolder().setType(0);
        this.f1820b = new a();
        getHolder().addCallback(this.f1820b);
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public Bitmap a(float f, int i, int i2) {
        return null;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void a() {
        if (this.c != null) {
            this.c.release();
        }
        this.c = null;
        CyberLog.d("BVideoView", "release mSurface:" + this.c);
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
        this.c = getHolder().getSurface();
        return this.c;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public boolean e() {
        return true;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        CyberLog.d("CyberSurfaceView", "CyberSurfaceView finalize called mSurface:" + this.c);
        if (this.c != null) {
            this.c.release();
            this.c = null;
            getHolder().removeCallback(this.f1820b);
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
        this.f1819a = aVar;
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setDisplayMode(int i) {
    }

    @Override // com.baidu.cyberplayer.sdk.i
    public void setRawFrameRotation(int i) {
    }
}
