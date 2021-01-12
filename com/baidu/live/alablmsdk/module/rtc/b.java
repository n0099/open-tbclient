package com.baidu.live.alablmsdk.module.rtc;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.baidu.live.alablmsdk.d.c;
/* loaded from: classes10.dex */
public class b implements TextureView.SurfaceTextureListener {
    public c axF;
    public long ayo;
    public a ayp;
    public Context mContext;
    public int mHeight;
    public Surface mSurface;
    public TextureView mTextureView;
    public int mWidth;

    /* loaded from: classes10.dex */
    public interface a {
        void aC(long j);
    }

    public b(Context context, c cVar, long j) {
        com.baidu.live.alablmsdk.a.b.a.ai(" ExternalTextureInfo construct id=" + j, "");
        this.axF = cVar;
        this.ayo = j;
        this.mContext = context;
        this.mTextureView = new TextureView(this.mContext);
        this.mTextureView.setSurfaceTextureListener(this);
    }

    public void a(a aVar) {
        com.baidu.live.alablmsdk.a.b.a.ew(" setSurfaceDestroyedListener ");
        this.ayp = aVar;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        com.baidu.live.alablmsdk.a.b.a.ai(" onSurfaceTextureAvailable mRemoteUid=" + this.ayo + " width=" + i + " , height=" + i2, "");
        this.mSurface = new Surface(surfaceTexture);
        this.mWidth = i;
        this.mHeight = i2;
        com.baidu.live.alablmsdk.a.c.xo().post(new Runnable() { // from class: com.baidu.live.alablmsdk.module.rtc.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.live.alablmsdk.a.b.a.ai(" setExternalSurface remoteUid=" + b.this.ayo + " tempSurface=" + b.this.mSurface, "");
                b.this.axF.setExternalSurface(b.this.ayo, b.this.mSurface);
                b.this.axF.changeSurfaceSize(b.this.ayo, b.this.mWidth, b.this.mHeight);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
        com.baidu.live.alablmsdk.a.b.a.ai(" onSurfaceTextureSizeChanged mRemoteUid=" + this.ayo + " width=" + i + " , height=" + i2, "");
        com.baidu.live.alablmsdk.a.c.xo().post(new Runnable() { // from class: com.baidu.live.alablmsdk.module.rtc.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.axF.changeSurfaceSize(b.this.ayo, b.this.mWidth, b.this.mHeight);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        com.baidu.live.alablmsdk.a.b.a.ai(" onSurfaceTextureDestroyed mRemoteUid=" + this.ayo, "");
        com.baidu.live.alablmsdk.a.c.xo().post(new Runnable() { // from class: com.baidu.live.alablmsdk.module.rtc.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.axF.destroyExternalSurface(b.this.ayo, b.this.mSurface);
            }
        });
        if (this.ayp != null) {
            this.ayp.aC(this.ayo);
            return false;
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void release() {
        this.ayp = null;
        com.baidu.live.alablmsdk.a.b.a.ai(" external texture info release not, mRemoteUid=" + this.ayo + " ,mSurface=" + this.mSurface, "");
    }

    public String toString() {
        return " mRemoteUid=" + this.ayo + ", mTextureView=" + this.mTextureView + " , mSurface=" + this.mSurface + " mWidth=" + this.mWidth + " , mHeight=" + this.mHeight;
    }
}
