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
    private AlaNDKPlayerAdapter bII;
    private WeakReference<Context> mContext;
    private Map<Integer, RtcVideoPlayer> mPlayersMap = new ConcurrentHashMap();
    private RtcConfig mRtcConfig;

    public RtcVideoPlayController(Context context, AlaNDKPlayerAdapter alaNDKPlayerAdapter, RtcConfig rtcConfig) {
        this.bII = null;
        this.mContext = null;
        this.bII = alaNDKPlayerAdapter;
        this.mContext = new WeakReference<>(context);
        this.mRtcConfig = rtcConfig;
    }

    public RtcVideoPlayer Ra() {
        if (el(1) == null) {
            this.mPlayersMap.put(1, new RtcVideoPlayer(this.mContext.get(), 1));
        }
        return el(1);
    }

    public int c(RtcConfig rtcConfig) {
        this.mRtcConfig = rtcConfig;
        if (this.bII != null && this.bII.getNativeObject() != 0) {
            this.bII.setVideoFillModel(1, 2);
            return 0;
        }
        return 0;
    }

    public RtcVideoPlayer el(int i) {
        if (!this.mPlayersMap.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.mPlayersMap.get(Integer.valueOf(i));
    }

    public int stopPlay() {
        for (Map.Entry<Integer, RtcVideoPlayer> entry : this.mPlayersMap.entrySet()) {
            RtcVideoPlayer value = entry.getValue();
            if (this.bII.getNativeObject() != 0) {
                this.bII.stopNative(value.mIndex);
            }
            this.mPlayersMap.remove(entry.getKey());
            value.release();
        }
        return 0;
    }

    /* loaded from: classes6.dex */
    public class RtcVideoPlayer extends TextureView implements TextureView.SurfaceTextureListener {
        private boolean bJc;
        private boolean bJd;
        private boolean bJe;
        private int mHeight;
        private int mIndex;
        private Surface mSurface;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;

        public RtcVideoPlayer(Context context, int i) {
            super(context);
            this.bJc = false;
            this.bJd = false;
            this.mWidth = 0;
            this.mHeight = 0;
            this.bJe = false;
            this.mIndex = i;
            setSurfaceTextureListener(this);
        }

        public void Rb() {
            this.bJe = true;
            if (this.bJc) {
                Rc();
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

        private void Rc() {
            if (!this.bJd && RtcVideoPlayController.this.bII.createSurfaceNative(this.mIndex, this.mSurface, RtcVideoPlayController.this.mRtcConfig.enableAudio, RtcVideoPlayController.this.mRtcConfig.enableVideo) == 0) {
                this.bJd = true;
            }
            if (this.bJd) {
                RtcVideoPlayController.this.bII.surfaceChangedNative(this.mIndex, this.mWidth, this.mHeight, this.mSurface);
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
            this.bJc = true;
            this.mWidth = i;
            this.mHeight = i2;
            if (this.bJe) {
                Rc();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            boolean z;
            synchronized (this) {
                if (this.bJd) {
                    RtcVideoPlayController.this.bII.destroySurfaceNative(this.mIndex);
                    this.bJd = false;
                }
                this.bJc = false;
                z = this.mSurfaceTexture == null;
            }
            return z;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public synchronized void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            if (this.mSurfaceTexture == surfaceTexture) {
                this.mWidth = i;
                this.mHeight = i2;
                if (this.bJe) {
                    Rc();
                }
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public synchronized void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }
}
