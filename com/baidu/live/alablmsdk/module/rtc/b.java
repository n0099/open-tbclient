package com.baidu.live.alablmsdk.module.rtc;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.baidu.live.alablmsdk.a.d;
import com.baidu.live.alablmsdk.d.c;
/* loaded from: classes4.dex */
public class b implements TextureView.SurfaceTextureListener {
    public long aAe;
    public a aAf;
    public c azx;
    public Context mContext;
    public int mHeight;
    public Surface mSurface;
    public TextureView mTextureView;
    public int mWidth;

    /* loaded from: classes4.dex */
    public interface a {
        void af(long j);
    }

    public b(Context context, c cVar, long j) {
        com.baidu.live.alablmsdk.a.b.ag(" ExternalTextureInfo construct id=" + j, "");
        this.azx = cVar;
        this.aAe = j;
        this.mContext = context;
        this.mTextureView = new TextureView(this.mContext);
        this.mTextureView.setSurfaceTextureListener(this);
    }

    public void a(a aVar) {
        com.baidu.live.alablmsdk.a.b.fD(" setSurfaceDestroyedListener ");
        this.aAf = aVar;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        com.baidu.live.alablmsdk.a.b.ag(" onSurfaceTextureAvailable mRemoteUid=" + this.aAe + " width=" + i + " , height=" + i2, "");
        this.mSurface = new Surface(surfaceTexture);
        this.mWidth = i;
        this.mHeight = i2;
        d.Ay().post(new Runnable() { // from class: com.baidu.live.alablmsdk.module.rtc.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.live.alablmsdk.a.b.ag(" setExternalSurface remoteUid=" + b.this.aAe + " tempSurface=" + b.this.mSurface, "");
                b.this.azx.setExternalSurface(b.this.aAe, b.this.mSurface);
                b.this.azx.changeSurfaceSize(b.this.aAe, b.this.mWidth, b.this.mHeight);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
        com.baidu.live.alablmsdk.a.b.ag(" onSurfaceTextureSizeChanged mRemoteUid=" + this.aAe + " width=" + i + " , height=" + i2, "");
        d.Ay().post(new Runnable() { // from class: com.baidu.live.alablmsdk.module.rtc.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.azx.changeSurfaceSize(b.this.aAe, b.this.mWidth, b.this.mHeight);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        com.baidu.live.alablmsdk.a.b.ag(" onSurfaceTextureDestroyed mRemoteUid=" + this.aAe, "");
        d.Ay().post(new Runnable() { // from class: com.baidu.live.alablmsdk.module.rtc.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.azx.destroyExternalSurface(b.this.aAe, b.this.mSurface);
            }
        });
        if (this.aAf != null) {
            this.aAf.af(this.aAe);
            return false;
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void release() {
        this.aAf = null;
        com.baidu.live.alablmsdk.a.b.ag(" external texture info release not, mRemoteUid=" + this.aAe + " ,mSurface=" + this.mSurface, "");
    }

    public String toString() {
        return " mRemoteUid=" + this.aAe + ", mTextureView=" + this.mTextureView + " , mSurface=" + this.mSurface + " mWidth=" + this.mWidth + " , mHeight=" + this.mHeight;
    }
}
