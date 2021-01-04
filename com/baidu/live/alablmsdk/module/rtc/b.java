package com.baidu.live.alablmsdk.module.rtc;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.baidu.live.alablmsdk.d.c;
/* loaded from: classes11.dex */
public class b implements TextureView.SurfaceTextureListener {
    public c aCs;
    public long aDb;
    public a aDc;
    public Context mContext;
    public int mHeight;
    public Surface mSurface;
    public TextureView mTextureView;
    public int mWidth;

    /* loaded from: classes11.dex */
    public interface a {
        void aC(long j);
    }

    public b(Context context, c cVar, long j) {
        com.baidu.live.alablmsdk.a.b.a.aj(" ExternalTextureInfo construct id=" + j, "");
        this.aCs = cVar;
        this.aDb = j;
        this.mContext = context;
        this.mTextureView = new TextureView(this.mContext);
        this.mTextureView.setSurfaceTextureListener(this);
    }

    public void a(a aVar) {
        com.baidu.live.alablmsdk.a.b.a.fI(" setSurfaceDestroyedListener ");
        this.aDc = aVar;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        com.baidu.live.alablmsdk.a.b.a.aj(" onSurfaceTextureAvailable mRemoteUid=" + this.aDb + " width=" + i + " , height=" + i2, "");
        this.mSurface = new Surface(surfaceTexture);
        this.mWidth = i;
        this.mHeight = i2;
        com.baidu.live.alablmsdk.a.c.Bj().post(new Runnable() { // from class: com.baidu.live.alablmsdk.module.rtc.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.live.alablmsdk.a.b.a.aj(" setExternalSurface remoteUid=" + b.this.aDb + " tempSurface=" + b.this.mSurface, "");
                b.this.aCs.setExternalSurface(b.this.aDb, b.this.mSurface);
                b.this.aCs.changeSurfaceSize(b.this.aDb, b.this.mWidth, b.this.mHeight);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
        com.baidu.live.alablmsdk.a.b.a.aj(" onSurfaceTextureSizeChanged mRemoteUid=" + this.aDb + " width=" + i + " , height=" + i2, "");
        com.baidu.live.alablmsdk.a.c.Bj().post(new Runnable() { // from class: com.baidu.live.alablmsdk.module.rtc.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.aCs.changeSurfaceSize(b.this.aDb, b.this.mWidth, b.this.mHeight);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        com.baidu.live.alablmsdk.a.b.a.aj(" onSurfaceTextureDestroyed mRemoteUid=" + this.aDb, "");
        com.baidu.live.alablmsdk.a.c.Bj().post(new Runnable() { // from class: com.baidu.live.alablmsdk.module.rtc.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.aCs.destroyExternalSurface(b.this.aDb, b.this.mSurface);
            }
        });
        if (this.aDc != null) {
            this.aDc.aC(this.aDb);
            return false;
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void release() {
        this.aDc = null;
        com.baidu.live.alablmsdk.a.b.a.aj(" external texture info release not, mRemoteUid=" + this.aDb + " ,mSurface=" + this.mSurface, "");
    }

    public String toString() {
        return " mRemoteUid=" + this.aDb + ", mTextureView=" + this.mTextureView + " , mSurface=" + this.mSurface + " mWidth=" + this.mWidth + " , mHeight=" + this.mHeight;
    }
}
