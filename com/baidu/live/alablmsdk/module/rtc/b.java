package com.baidu.live.alablmsdk.module.rtc;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.baidu.live.alablmsdk.d.c;
/* loaded from: classes4.dex */
public class b implements TextureView.SurfaceTextureListener {
    public long aCK;
    public a aCL;
    public c aCb;
    public Context mContext;
    public int mHeight;
    public Surface mSurface;
    public TextureView mTextureView;
    public int mWidth;

    /* loaded from: classes4.dex */
    public interface a {
        void aD(long j);
    }

    public b(Context context, c cVar, long j) {
        com.baidu.live.alablmsdk.a.b.a.ak(" ExternalTextureInfo construct id=" + j, "");
        this.aCb = cVar;
        this.aCK = j;
        this.mContext = context;
        this.mTextureView = new TextureView(this.mContext);
        this.mTextureView.setSurfaceTextureListener(this);
    }

    public void a(a aVar) {
        com.baidu.live.alablmsdk.a.b.a.fY(" setSurfaceDestroyedListener ");
        this.aCL = aVar;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        com.baidu.live.alablmsdk.a.b.a.ak(" onSurfaceTextureAvailable mRemoteUid=" + this.aCK + " width=" + i + " , height=" + i2, "");
        this.mSurface = new Surface(surfaceTexture);
        this.mWidth = i;
        this.mHeight = i2;
        com.baidu.live.alablmsdk.a.c.BS().post(new Runnable() { // from class: com.baidu.live.alablmsdk.module.rtc.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.live.alablmsdk.a.b.a.ak(" setExternalSurface remoteUid=" + b.this.aCK + " tempSurface=" + b.this.mSurface, "");
                b.this.aCb.setExternalSurface(b.this.aCK, b.this.mSurface);
                b.this.aCb.changeSurfaceSize(b.this.aCK, b.this.mWidth, b.this.mHeight);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
        com.baidu.live.alablmsdk.a.b.a.ak(" onSurfaceTextureSizeChanged mRemoteUid=" + this.aCK + " width=" + i + " , height=" + i2, "");
        com.baidu.live.alablmsdk.a.c.BS().post(new Runnable() { // from class: com.baidu.live.alablmsdk.module.rtc.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.aCb.changeSurfaceSize(b.this.aCK, b.this.mWidth, b.this.mHeight);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        com.baidu.live.alablmsdk.a.b.a.ak(" onSurfaceTextureDestroyed mRemoteUid=" + this.aCK, "");
        com.baidu.live.alablmsdk.a.c.BS().post(new Runnable() { // from class: com.baidu.live.alablmsdk.module.rtc.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.aCb.destroyExternalSurface(b.this.aCK, b.this.mSurface);
            }
        });
        if (this.aCL != null) {
            this.aCL.aD(this.aCK);
            return false;
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void release() {
        this.aCL = null;
        com.baidu.live.alablmsdk.a.b.a.ak(" external texture info release not, mRemoteUid=" + this.aCK + " ,mSurface=" + this.mSurface, "");
    }

    public String toString() {
        return " mRemoteUid=" + this.aCK + ", mTextureView=" + this.mTextureView + " , mSurface=" + this.mSurface + " mWidth=" + this.mWidth + " , mHeight=" + this.mHeight;
    }
}
