package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.baidu.cyberplayer.sdk.h;
/* loaded from: classes.dex */
public class f extends SurfaceView implements h {
    private h.a a;
    private a b;
    private Surface c;

    /* loaded from: classes.dex */
    private class a implements SurfaceHolder.Callback {
        private a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            CyberLog.d("SurfaceCallback", "BVideoView surfaceCreated mCyberSurfaceListener:" + f.this.a);
            if (f.this.a != null) {
                f.this.a.a(2);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            CyberLog.d("SurfaceCallback", "surfaceDestroyed mCyberSurfaceListener:" + f.this.a);
        }
    }

    public f(Context context) {
        super(context);
        CyberLog.d("CyberSurfaceView", "CyberSurfaceView constructor called");
        getHolder().setType(0);
        this.b = new a();
        getHolder().addCallback(this.b);
    }

    @Override // com.baidu.cyberplayer.sdk.h
    public Bitmap a(float f, int i, int i2) {
        return null;
    }

    @Override // com.baidu.cyberplayer.sdk.h
    public void a() {
        if (this.c != null) {
            this.c.release();
        }
        this.c = null;
        CyberLog.d("BVideoView", "release mSurface:" + this.c);
    }

    @Override // com.baidu.cyberplayer.sdk.h
    public void a(int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.cyberplayer.sdk.h
    public void b() {
        a();
    }

    @Override // com.baidu.cyberplayer.sdk.h
    public void c() {
    }

    @Override // com.baidu.cyberplayer.sdk.h
    public Surface d() {
        this.c = getHolder().getSurface();
        return this.c;
    }

    @Override // com.baidu.cyberplayer.sdk.h
    public boolean e() {
        return true;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        CyberLog.d("CyberSurfaceView", "CyberSurfaceView finalize called mSurface:" + this.c);
        if (this.c != null) {
            this.c.release();
            this.c = null;
            getHolder().removeCallback(this.b);
        }
    }

    public SurfaceTexture getSurfaceTexture() {
        return null;
    }

    @Override // com.baidu.cyberplayer.sdk.h
    public View getView() {
        return this;
    }

    @Override // com.baidu.cyberplayer.sdk.h
    public void setClientRotation(int i) {
    }

    @Override // com.baidu.cyberplayer.sdk.h
    public void setCyberSurfaceListener(h.a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.cyberplayer.sdk.h
    public void setDisplayMode(int i) {
    }

    @Override // com.baidu.cyberplayer.sdk.h
    public void setRawFrameRotation(int i) {
    }
}
