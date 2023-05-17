package com.baidu.searchbox.afx.proxy;

import android.app.ActivityManager;
import android.content.pm.ConfigurationInfo;
import android.media.MediaPlayer;
import android.os.Build;
import android.view.Surface;
import com.baidu.searchbox.afx.callback.ErrorInfo;
import com.baidu.searchbox.afx.callback.OnReportListener;
import com.baidu.searchbox.afx.callback.OnVideoErrorListener;
import com.baidu.searchbox.afx.callback.OnVideoStartedListener;
import com.baidu.searchbox.afx.callback.PlaySuccessInfo;
import com.baidu.searchbox.afx.gl.GLTextureView;
import com.baidu.searchbox.afx.proxy.PlayerProxy;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class MediaPlayerProxy extends PlayerProxy {
    public static final String TAG = "MediaPlayerProxy";
    public GLTextureView mGLTextureView;
    public MediaPlayer mMediaPlayer;
    public long mStartTimeMs;
    public long mPrepareTime = -1;
    public boolean mCompletion = false;
    public boolean mIsLooping = false;

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public int getFps() {
        return 0;
    }

    /* renamed from: com.baidu.searchbox.afx.proxy.MediaPlayerProxy$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$afx$proxy$PlayerProxy$PlayerState;

        static {
            int[] iArr = new int[PlayerProxy.PlayerState.values().length];
            $SwitchMap$com$baidu$searchbox$afx$proxy$PlayerProxy$PlayerState = iArr;
            try {
                iArr[PlayerProxy.PlayerState.NOT_PREPARED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$afx$proxy$PlayerProxy$PlayerState[PlayerProxy.PlayerState.STOPPED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$afx$proxy$PlayerProxy$PlayerState[PlayerProxy.PlayerState.PREPARED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$afx$proxy$PlayerProxy$PlayerState[PlayerProxy.PlayerState.PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class OnCompletionListener implements MediaPlayer.OnCompletionListener {
        public WeakReference<MediaPlayerProxy> mPlayerProxyRef;

        public OnCompletionListener(MediaPlayerProxy mediaPlayerProxy) {
            this.mPlayerProxyRef = new WeakReference<>(mediaPlayerProxy);
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            final MediaPlayerProxy mediaPlayerProxy = this.mPlayerProxyRef.get();
            if (mediaPlayerProxy == null || mediaPlayerProxy.mMediaPlayer == null) {
                return;
            }
            mediaPlayerProxy.mCompletion = true;
            try {
                mediaPlayerProxy.mMediaPlayer.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
            mediaPlayerProxy.callSuperStop();
            if (mediaPlayerProxy.mGLTextureView != null) {
                mediaPlayerProxy.mGLTextureView.post(new Runnable() { // from class: com.baidu.searchbox.afx.proxy.MediaPlayerProxy.OnCompletionListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (mediaPlayerProxy.mGLTextureView != null) {
                            mediaPlayerProxy.mGLTextureView.setRenderMode(0);
                        }
                    }
                });
            }
            if (mediaPlayerProxy.mOnReportListener != null) {
                mediaPlayerProxy.mOnReportListener.onSuccess(new PlaySuccessInfo(mediaPlayerProxy.mSourcePath, String.valueOf(System.currentTimeMillis() / 1000), String.valueOf(mediaPlayerProxy.mPrepareTime / 1000)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class OnErrorListener implements MediaPlayer.OnErrorListener {
        public WeakReference<MediaPlayerProxy> mPlayerProxyRef;

        public OnErrorListener(MediaPlayerProxy mediaPlayerProxy) {
            this.mPlayerProxyRef = new WeakReference<>(mediaPlayerProxy);
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            String str;
            MediaPlayerProxy mediaPlayerProxy = this.mPlayerProxyRef.get();
            if (mediaPlayerProxy == null) {
                return true;
            }
            if (mediaPlayer != null) {
                str = String.valueOf(mediaPlayer.getCurrentPosition());
            } else {
                str = "-1";
            }
            String glVersion = mediaPlayerProxy.getGlVersion();
            String sourcePath = mediaPlayerProxy.getSourcePath();
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            RuntimeException runtimeException = new RuntimeException("MediaPlayer Error (" + i + "," + i2 + SmallTailInfo.EMOTION_SUFFIX);
            OnReportListener onReportListener = mediaPlayerProxy.mOnReportListener;
            if (onReportListener != null) {
                onReportListener.onError(new ErrorInfo(16, ErrorInfo.MEDIAPLAYER_DECODING_ERROR_ERRORMSG, runtimeException, str, glVersion, sourcePath, valueOf));
            }
            OnVideoErrorListener onVideoErrorListener = mediaPlayerProxy.mOnVideoErrorListener;
            if (onVideoErrorListener != null && onVideoErrorListener.onError(new ErrorInfo(16, ErrorInfo.MEDIAPLAYER_DECODING_ERROR_ERRORMSG, runtimeException, str, glVersion, sourcePath, valueOf))) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static class OnInfoListener implements MediaPlayer.OnInfoListener {
        public WeakReference<MediaPlayerProxy> mPlayerProxyRef;

        public OnInfoListener(MediaPlayerProxy mediaPlayerProxy) {
            this.mPlayerProxyRef = new WeakReference<>(mediaPlayerProxy);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            OnVideoStartedListener onVideoStartedListener;
            MediaPlayerProxy mediaPlayerProxy = this.mPlayerProxyRef.get();
            if (mediaPlayerProxy == null) {
                return true;
            }
            if (i == 3 && (onVideoStartedListener = mediaPlayerProxy.mOnVideoStartedListener) != null) {
                onVideoStartedListener.onVideoStarted();
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static class OnPrepareListener implements MediaPlayer.OnPreparedListener {
        public WeakReference<MediaPlayerProxy> mPlayerProxyRef;

        public OnPrepareListener(MediaPlayerProxy mediaPlayerProxy) {
            this.mPlayerProxyRef = new WeakReference<>(mediaPlayerProxy);
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            MediaPlayerProxy mediaPlayerProxy = this.mPlayerProxyRef.get();
            if (mediaPlayerProxy != null && mediaPlayerProxy.mMediaPlayer != null) {
                mediaPlayerProxy.mPlayerState = PlayerProxy.PlayerState.PREPARED;
                if (mediaPlayerProxy.mGLTextureView != null) {
                    mediaPlayerProxy.mGLTextureView.setRenderMode(1);
                }
                mediaPlayerProxy.mPrepareTime = System.currentTimeMillis();
                try {
                    mediaPlayerProxy.mMediaPlayer.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mediaPlayerProxy.checkLooping();
                mediaPlayerProxy.callSuperPlay();
            }
        }
    }

    public MediaPlayerProxy() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.mMediaPlayer = mediaPlayer;
        mediaPlayer.setOnCompletionListener(new OnCompletionListener(this));
        this.mMediaPlayer.setOnErrorListener(new OnErrorListener(this));
        this.mMediaPlayer.setOnInfoListener(new OnInfoListener(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callSuperPlay() {
        super.play();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callSuperStop() {
        super.stop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkLooping() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            return;
        }
        boolean isLooping = mediaPlayer.isLooping();
        boolean z = this.mIsLooping;
        if (isLooping != z) {
            this.mMediaPlayer.setLooping(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getGlVersion() {
        ActivityManager activityManager;
        ConfigurationInfo deviceConfigurationInfo;
        GLTextureView gLTextureView = this.mGLTextureView;
        if (gLTextureView != null && (activityManager = (ActivityManager) gLTextureView.getContext().getSystemService("activity")) != null && (deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo()) != null) {
            return deviceConfigurationInfo.getGlEsVersion();
        }
        return null;
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void destroy() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.mGLTextureView = null;
            super.destroy();
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public int getCurrentPosition() {
        if (this.mMediaPlayer != null && getState() != PlayerProxy.PlayerState.NOT_PREPARED) {
            if (this.mCompletion) {
                return this.mMediaPlayer.getDuration();
            }
            return this.mMediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public long getDuration() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            return 0L;
        }
        return mediaPlayer.getDuration();
    }

    public MediaPlayer getMediaPlayer() {
        return this.mMediaPlayer;
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void pause() {
        if (this.mMediaPlayer != null && isPlaying()) {
            try {
                this.mMediaPlayer.pause();
            } catch (Exception e) {
                e.printStackTrace();
            }
            GLTextureView gLTextureView = this.mGLTextureView;
            if (gLTextureView != null) {
                gLTextureView.setRenderMode(0);
            }
            super.pause();
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy
    public void reset() {
        if (this.mMediaPlayer != null && !isDestroyed()) {
            this.mMediaPlayer.reset();
            super.reset();
        }
    }

    public void seekTo(int i) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setGLTextureView(GLTextureView gLTextureView) {
        this.mGLTextureView = gLTextureView;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setLooping(boolean z) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            this.mIsLooping = z;
            mediaPlayer.setLooping(z);
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy
    public void setSourceFD(FileDescriptor fileDescriptor) {
        try {
            reset();
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.setDataSource(fileDescriptor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setSurface(Surface surface) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
        }
    }

    private void prepareAsync(MediaPlayer.OnPreparedListener onPreparedListener) {
        if (this.mMediaPlayer != null) {
            if (isNotPrepared() || isStopped()) {
                this.mMediaPlayer.setOnPreparedListener(onPreparedListener);
                try {
                    this.mMediaPlayer.prepareAsync();
                    this.mPlayerState = PlayerProxy.PlayerState.PREPARING;
                } catch (IllegalStateException e) {
                    String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                    OnReportListener onReportListener = this.mOnReportListener;
                    if (onReportListener != null) {
                        onReportListener.onError(new ErrorInfo(2, ErrorInfo.OPENGL_ENVIRONMENT_ERROR_ERRORMSG, e, "-1", null, getSourcePath(), valueOf));
                    }
                    OnVideoErrorListener onVideoErrorListener = this.mOnVideoErrorListener;
                    if (onVideoErrorListener != null) {
                        onVideoErrorListener.onError(new ErrorInfo(2, ErrorInfo.OPENGL_ENVIRONMENT_ERROR_ERRORMSG, e, "-1", null, getSourcePath(), valueOf));
                    }
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void play() {
        if (this.mMediaPlayer != null) {
            try {
                int i = AnonymousClass2.$SwitchMap$com$baidu$searchbox$afx$proxy$PlayerProxy$PlayerState[this.mPlayerState.ordinal()];
                if (i != 1 && i != 2) {
                    if (i == 3 || i == 4) {
                        if (this.mGLTextureView != null) {
                            this.mGLTextureView.setRenderMode(1);
                        }
                        this.mMediaPlayer.start();
                        super.play();
                        return;
                    }
                    return;
                }
                prepareAsync(new OnPrepareListener(this));
            } catch (Exception e) {
                e.printStackTrace();
                String glVersion = getGlVersion();
                String sourcePath = getSourcePath();
                String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                OnReportListener onReportListener = this.mOnReportListener;
                if (onReportListener != null) {
                    onReportListener.onError(new ErrorInfo(1, ErrorInfo.MEDIAPLAYER_PLAY_SOURCE_ERROR_ERRORMSG, e, "-1", glVersion, sourcePath, valueOf));
                }
                OnVideoErrorListener onVideoErrorListener = this.mOnVideoErrorListener;
                if (onVideoErrorListener != null) {
                    onVideoErrorListener.onError(new ErrorInfo(1, ErrorInfo.MEDIAPLAYER_PLAY_SOURCE_ERROR_ERRORMSG, e, "-1", glVersion, sourcePath, valueOf));
                }
            }
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy
    public void setSourceFD(FileDescriptor fileDescriptor, long j, long j2) {
        try {
            reset();
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.setDataSource(fileDescriptor, j, j2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void stop() {
        if (this.mMediaPlayer != null) {
            if (isPlaying() || isPaused()) {
                if (Build.VERSION.SDK_INT <= 19) {
                    seekTo(0);
                }
                try {
                    this.mMediaPlayer.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                super.stop();
                GLTextureView gLTextureView = this.mGLTextureView;
                if (gLTextureView != null) {
                    gLTextureView.post(new Runnable() { // from class: com.baidu.searchbox.afx.proxy.MediaPlayerProxy.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (MediaPlayerProxy.this.mGLTextureView != null) {
                                MediaPlayerProxy.this.mGLTextureView.setRenderMode(0);
                            }
                        }
                    });
                }
            }
        }
    }
}
