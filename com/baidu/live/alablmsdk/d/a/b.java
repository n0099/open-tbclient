package com.baidu.live.alablmsdk.d.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
/* loaded from: classes10.dex */
public class b implements TextureView.SurfaceTextureListener, com.baidu.live.alablmsdk.c.b.c {
    public com.baidu.live.alablmsdk.c.b.d aAA;
    public long aAz;
    public com.baidu.live.alablmsdk.d.c azs;
    public Context mContext;
    public int mHeight;
    public Surface mSurface;
    public TextureView mTextureView;
    public int mWidth;

    public b(Context context, com.baidu.live.alablmsdk.d.c cVar, long j) {
        com.baidu.live.alablmsdk.a.b.a.ag(" ExternalTextureInfo construct id=" + j, "");
        this.azs = cVar;
        this.aAz = j;
        this.mContext = context;
        this.mTextureView = new TextureView(this.mContext);
        this.mTextureView.setSurfaceTextureListener(this);
        com.baidu.live.alablmsdk.a.b.a.ag(" ExternalTextureInfo end ", "");
    }

    @Override // com.baidu.live.alablmsdk.c.b.c
    public void a(com.baidu.live.alablmsdk.c.b.d dVar) {
        com.baidu.live.alablmsdk.a.b.a.eG(" setSurfaceDestroyedListener ");
        this.aAA = dVar;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        com.baidu.live.alablmsdk.a.b.a.ag(" onSurfaceTextureAvailable mRemoteUid=" + this.aAz + " width=" + i + " , height=" + i2, "");
        this.mSurface = new Surface(surfaceTexture);
        this.mWidth = i;
        this.mHeight = i2;
        com.baidu.live.alablmsdk.a.c.xr().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.live.alablmsdk.a.b.a.ag(" setExternalSurface remoteUid=" + b.this.aAz + " tempSurface=" + b.this.mSurface, "");
                b.this.azs.setExternalSurface(b.this.aAz, b.this.mSurface);
                b.this.azs.changeSurfaceSize(b.this.aAz, b.this.mWidth, b.this.mHeight);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
        com.baidu.live.alablmsdk.a.b.a.ag(" onSurfaceTextureSizeChanged mRemoteUid=" + this.aAz + " width=" + i + " , height=" + i2, "");
        com.baidu.live.alablmsdk.a.c.xr().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.azs.changeSurfaceSize(b.this.aAz, b.this.mWidth, b.this.mHeight);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        com.baidu.live.alablmsdk.a.b.a.ag(" onSurfaceTextureDestroyed mRemoteUid=" + this.aAz, "");
        com.baidu.live.alablmsdk.a.c.xr().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.azs.destroyExternalSurface(b.this.aAz, b.this.mSurface);
            }
        });
        if (this.aAA != null) {
            this.aAA.ay(this.aAz);
            return false;
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // com.baidu.live.alablmsdk.c.b.c
    public boolean xP() {
        return (this.mTextureView == null || this.mSurface == null) ? false : true;
    }

    @Override // com.baidu.live.alablmsdk.c.b.c
    public View yk() {
        return this.mTextureView;
    }

    @Override // com.baidu.live.alablmsdk.c.b.c
    public void release() {
        this.aAA = null;
        com.baidu.live.alablmsdk.a.b.a.ag(" external texture info release not, mRemoteUid=" + this.aAz + " ,mSurface=" + this.mSurface, "");
    }

    public String toString() {
        return " mRemoteUid=" + this.aAz + ", mTextureView=" + this.mTextureView + " , mSurface=" + this.mSurface + " mWidth=" + this.mWidth + " , mHeight=" + this.mHeight;
    }
}
