package com.baidu.ala.player;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.baidu.ala.helper.AlaLiveUtilHelper;
/* loaded from: classes5.dex */
public class AlaVideoPlayer extends TextureView implements TextureView.SurfaceTextureListener {
    private VideoPlayerCallback mCallback;
    private SurfaceHolder mHolder;
    private AlaLivePlayerData mPlayerData;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;

    /* loaded from: classes5.dex */
    public interface SurfaceHolder {
        Surface getSurface();
    }

    /* loaded from: classes5.dex */
    public interface VideoPlayerCallback {
        void onAttachedToWindow();

        void onDetachedFromWindow();

        void onSurfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3);

        void onSurfaceCreated(SurfaceHolder surfaceHolder);

        void onSurfaceDestroyed(SurfaceHolder surfaceHolder);
    }

    public AlaVideoPlayer(Context context, int i) {
        super(context);
        this.mHolder = new SurfaceHolder() { // from class: com.baidu.ala.player.AlaVideoPlayer.1
            @Override // com.baidu.ala.player.AlaVideoPlayer.SurfaceHolder
            public Surface getSurface() {
                return AlaVideoPlayer.this.mSurface;
            }
        };
        setSurfaceTextureListener(this);
        this.mPlayerData = new AlaLivePlayerData(i);
        this.mPlayerData.mStartBaseInfo.mAppVer = AlaLiveUtilHelper.getApkVersionName(context);
    }

    public void setPlayerCallback(VideoPlayerCallback videoPlayerCallback) {
        this.mCallback = videoPlayerCallback;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.mSurfaceTexture != null) {
            setSurfaceTexture(this.mSurfaceTexture);
            if (this.mSurface == null) {
                this.mSurface = new Surface(this.mSurfaceTexture);
            }
            if (this.mCallback != null) {
                this.mCallback.onSurfaceCreated(this.mHolder);
                this.mCallback.onSurfaceChanged(this.mHolder, 0, i, i2);
            }
        } else {
            this.mSurfaceTexture = surfaceTexture;
            this.mSurface = new Surface(surfaceTexture);
            if (this.mCallback != null) {
                this.mCallback.onSurfaceCreated(this.mHolder);
                this.mCallback.onSurfaceChanged(this.mHolder, 0, i, i2);
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        if (this.mCallback != null) {
            this.mCallback.onSurfaceDestroyed(this.mHolder);
        }
        return this.mSurfaceTexture == null;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.mSurfaceTexture == surfaceTexture && this.mCallback != null) {
            this.mCallback.onSurfaceChanged(this.mHolder, 0, i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void runInForeground() {
    }

    public void runInBackground() {
    }

    public void release() {
        try {
            if (this.mSurface != null) {
                this.mSurface.release();
                this.mSurface = null;
            }
            if (this.mSurfaceTexture != null) {
                this.mSurfaceTexture.release();
                this.mSurfaceTexture = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mCallback != null) {
            this.mCallback.onAttachedToWindow();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mCallback != null) {
            this.mCallback.onDetachedFromWindow();
        }
    }

    public AlaLivePlayerData getPlayerData() {
        return this.mPlayerData;
    }
}
