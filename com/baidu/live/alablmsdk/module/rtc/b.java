package com.baidu.live.alablmsdk.module.rtc;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.baidu.live.alablmsdk.a.d;
import com.baidu.live.alablmsdk.d.c;
/* loaded from: classes4.dex */
public class b implements TextureView.SurfaceTextureListener {
    public long aBP;
    public a aBQ;
    public c aBi;
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
        com.baidu.live.alablmsdk.a.b.ah(" ExternalTextureInfo construct id=" + j, "");
        this.aBi = cVar;
        this.aBP = j;
        this.mContext = context;
        this.mTextureView = new TextureView(this.mContext);
        this.mTextureView.setSurfaceTextureListener(this);
    }

    public void a(a aVar) {
        com.baidu.live.alablmsdk.a.b.fJ(" setSurfaceDestroyedListener ");
        this.aBQ = aVar;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        com.baidu.live.alablmsdk.a.b.ah(" onSurfaceTextureAvailable mRemoteUid=" + this.aBP + " width=" + i + " , height=" + i2, "");
        this.mSurface = new Surface(surfaceTexture);
        this.mWidth = i;
        this.mHeight = i2;
        d.Bh().post(new Runnable() { // from class: com.baidu.live.alablmsdk.module.rtc.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.live.alablmsdk.a.b.ah(" setExternalSurface remoteUid=" + b.this.aBP + " tempSurface=" + b.this.mSurface, "");
                b.this.aBi.setExternalSurface(b.this.aBP, b.this.mSurface);
                b.this.aBi.changeSurfaceSize(b.this.aBP, b.this.mWidth, b.this.mHeight);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
        com.baidu.live.alablmsdk.a.b.ah(" onSurfaceTextureSizeChanged mRemoteUid=" + this.aBP + " width=" + i + " , height=" + i2, "");
        d.Bh().post(new Runnable() { // from class: com.baidu.live.alablmsdk.module.rtc.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.aBi.changeSurfaceSize(b.this.aBP, b.this.mWidth, b.this.mHeight);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        com.baidu.live.alablmsdk.a.b.ah(" onSurfaceTextureDestroyed mRemoteUid=" + this.aBP, "");
        d.Bh().post(new Runnable() { // from class: com.baidu.live.alablmsdk.module.rtc.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.aBi.destroyExternalSurface(b.this.aBP, b.this.mSurface);
            }
        });
        if (this.aBQ != null) {
            this.aBQ.af(this.aBP);
            return false;
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void release() {
        this.aBQ = null;
        com.baidu.live.alablmsdk.a.b.ah(" external texture info release not, mRemoteUid=" + this.aBP + " ,mSurface=" + this.mSurface, "");
    }

    public String toString() {
        return " mRemoteUid=" + this.aBP + ", mTextureView=" + this.mTextureView + " , mSurface=" + this.mSurface + " mWidth=" + this.mWidth + " , mHeight=" + this.mHeight;
    }
}
