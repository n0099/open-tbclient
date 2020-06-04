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
/* loaded from: classes6.dex */
public class RtcVideoPlayController {
    private AlaNDKPlayerAdapter bDU;
    private WeakReference<Context> mContext;
    private Map<Integer, RtcVideoPlayer> mPlayersMap = new ConcurrentHashMap();
    private RtcConfig mRtcConfig;

    public RtcVideoPlayController(Context context, AlaNDKPlayerAdapter alaNDKPlayerAdapter, RtcConfig rtcConfig) {
        this.bDU = null;
        this.mContext = null;
        this.bDU = alaNDKPlayerAdapter;
        this.mContext = new WeakReference<>(context);
        this.mRtcConfig = rtcConfig;
    }

    public RtcVideoPlayer PU() {
        if (ea(1) == null) {
            this.mPlayersMap.put(1, new RtcVideoPlayer(this.mContext.get(), 1));
        }
        return ea(1);
    }

    public int c(RtcConfig rtcConfig) {
        this.mRtcConfig = rtcConfig;
        if (this.bDU != null && this.bDU.getNativeObject() != 0) {
            this.bDU.setVideoFillModel(1, 2);
            return 0;
        }
        return 0;
    }

    public RtcVideoPlayer ea(int i) {
        if (!this.mPlayersMap.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.mPlayersMap.get(Integer.valueOf(i));
    }

    public int stopPlay() {
        for (Map.Entry<Integer, RtcVideoPlayer> entry : this.mPlayersMap.entrySet()) {
            RtcVideoPlayer value = entry.getValue();
            if (this.bDU.getNativeObject() != 0) {
                this.bDU.stopNative(value.mIndex);
            }
            this.mPlayersMap.remove(entry.getKey());
            value.release();
        }
        return 0;
    }

    /* loaded from: classes6.dex */
    public class RtcVideoPlayer extends TextureView implements TextureView.SurfaceTextureListener {
        private boolean bEo;
        private boolean bEp;
        private boolean bEq;
        private int mHeight;
        private int mIndex;
        private Surface mSurface;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;

        public RtcVideoPlayer(Context context, int i) {
            super(context);
            this.bEo = false;
            this.bEp = false;
            this.mWidth = 0;
            this.mHeight = 0;
            this.bEq = false;
            this.mIndex = i;
            setSurfaceTextureListener(this);
        }

        public void PV() {
            this.bEq = true;
            if (this.bEo) {
                PW();
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

        private void PW() {
            if (!this.bEp && RtcVideoPlayController.this.bDU.createSurfaceNative(this.mIndex, this.mSurface, RtcVideoPlayController.this.mRtcConfig.enableAudio, RtcVideoPlayController.this.mRtcConfig.enableVideo) == 0) {
                this.bEp = true;
            }
            if (this.bEp) {
                RtcVideoPlayController.this.bDU.surfaceChangedNative(this.mIndex, this.mWidth, this.mHeight, this.mSurface);
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
            this.bEo = true;
            this.mWidth = i;
            this.mHeight = i2;
            if (this.bEq) {
                PW();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            boolean z;
            synchronized (this) {
                if (this.bEp) {
                    RtcVideoPlayController.this.bDU.destroySurfaceNative(this.mIndex);
                    this.bEp = false;
                }
                this.bEo = false;
                z = this.mSurfaceTexture == null;
            }
            return z;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public synchronized void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            if (this.mSurfaceTexture == surfaceTexture) {
                this.mWidth = i;
                this.mHeight = i2;
                if (this.bEq) {
                    PW();
                }
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public synchronized void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }
}
