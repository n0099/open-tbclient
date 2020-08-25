package com.baidu.rtc.player;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.baidu.rtc.RtcConfig;
import com.baidu.rtc.ndk.AlaNDKPlayerAdapter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class RtcVideoPlayController {
    private AlaNDKPlayerAdapter bOF;
    private WeakReference<Context> mContext;
    private Map<Integer, RtcVideoPlayer> mPlayersMap = new ConcurrentHashMap();
    private RtcConfig mRtcConfig;

    public RtcVideoPlayController(Context context, AlaNDKPlayerAdapter alaNDKPlayerAdapter, RtcConfig rtcConfig) {
        this.bOF = null;
        this.mContext = null;
        this.bOF = alaNDKPlayerAdapter;
        this.mContext = new WeakReference<>(context);
        this.mRtcConfig = rtcConfig;
    }

    public RtcVideoPlayer Xk() {
        if (gi(1) == null) {
            this.mPlayersMap.put(1, new RtcVideoPlayer(this.mContext.get(), 1));
        }
        return gi(1);
    }

    public int c(RtcConfig rtcConfig) {
        this.mRtcConfig = rtcConfig;
        if (this.bOF != null && this.bOF.getNativeObject() != 0) {
            this.bOF.setVideoFillModel(1, 2);
            return 0;
        }
        return 0;
    }

    public RtcVideoPlayer gi(int i) {
        if (!this.mPlayersMap.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.mPlayersMap.get(Integer.valueOf(i));
    }

    public int stopPlay() {
        for (Map.Entry<Integer, RtcVideoPlayer> entry : this.mPlayersMap.entrySet()) {
            RtcVideoPlayer value = entry.getValue();
            if (this.bOF.getNativeObject() != 0) {
                this.bOF.stopNative(value.mIndex);
            }
            this.mPlayersMap.remove(entry.getKey());
            value.release();
        }
        return 0;
    }

    /* loaded from: classes11.dex */
    public class RtcVideoPlayer extends TextureView implements TextureView.SurfaceTextureListener {
        private boolean bOZ;
        private boolean bPa;
        private boolean bPb;
        private int mHeight;
        private int mIndex;
        private Surface mSurface;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;

        public RtcVideoPlayer(Context context, int i) {
            super(context);
            this.bOZ = false;
            this.bPa = false;
            this.mWidth = 0;
            this.mHeight = 0;
            this.bPb = false;
            this.mIndex = i;
            setSurfaceTextureListener(this);
        }

        public void Xl() {
            this.bPb = true;
            if (this.bOZ) {
                Xm();
            }
        }

        public void release() {
            try {
                if (this.mSurfaceTexture != null) {
                    this.mSurfaceTexture.release();
                    this.mSurfaceTexture = null;
                }
                if (this.mSurface != null) {
                    this.mSurface.release();
                    this.mSurface = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void Xm() {
            if (!this.bPa && RtcVideoPlayController.this.bOF.createSurfaceNative(this.mIndex, this.mSurface, RtcVideoPlayController.this.mRtcConfig.enableAudio, RtcVideoPlayController.this.mRtcConfig.enableVideo) == 0) {
                this.bPa = true;
            }
            if (this.bPa) {
                RtcVideoPlayController.this.bOF.surfaceChangedNative(this.mIndex, this.mWidth, this.mHeight, this.mSurface);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public synchronized void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            if (this.mSurfaceTexture != null) {
                setSurfaceTexture(this.mSurfaceTexture);
                if (this.mSurface == null) {
                    this.mSurface = new Surface(this.mSurfaceTexture);
                }
            } else {
                this.mSurfaceTexture = surfaceTexture;
                this.mSurface = new Surface(surfaceTexture);
            }
            this.bOZ = true;
            this.mWidth = i;
            this.mHeight = i2;
            if (this.bPb) {
                Xm();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            boolean z;
            synchronized (this) {
                if (this.bPa) {
                    RtcVideoPlayController.this.bOF.destroySurfaceNative(this.mIndex);
                    this.bPa = false;
                }
                this.bOZ = false;
                z = this.mSurfaceTexture == null;
            }
            return z;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public synchronized void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            if (this.mSurfaceTexture == surfaceTexture) {
                this.mWidth = i;
                this.mHeight = i2;
                if (this.bPb) {
                    Xm();
                }
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public synchronized void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }
}
