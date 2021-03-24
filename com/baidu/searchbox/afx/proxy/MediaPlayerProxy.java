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
import java.io.IOException;
/* loaded from: classes2.dex */
public class MediaPlayerProxy extends PlayerProxy {
    public static final String TAG = "MediaPlayerProxy";
    public GLTextureView mGLTextureView;
    public MediaPlayer mMediaPlayer;
    public long mPrepareTime = -1;
    public long mStartTimeMs;

    /* renamed from: com.baidu.searchbox.afx.proxy.MediaPlayerProxy$6  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass6 {
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

    public MediaPlayerProxy() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.mMediaPlayer = mediaPlayer;
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.searchbox.afx.proxy.MediaPlayerProxy.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer2) {
                MediaPlayerProxy.this.mMediaPlayer.stop();
                MediaPlayerProxy.super.stop();
                if (MediaPlayerProxy.this.mGLTextureView != null) {
                    MediaPlayerProxy.this.mGLTextureView.post(new Runnable() { // from class: com.baidu.searchbox.afx.proxy.MediaPlayerProxy.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (MediaPlayerProxy.this.mGLTextureView != null) {
                                MediaPlayerProxy.this.mGLTextureView.setRenderMode(0);
                            }
                        }
                    });
                }
                if (MediaPlayerProxy.this.mOnReportListener != null) {
                    String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                    String valueOf2 = String.valueOf(MediaPlayerProxy.this.mPrepareTime / 1000);
                    MediaPlayerProxy mediaPlayerProxy = MediaPlayerProxy.this;
                    mediaPlayerProxy.mOnReportListener.onSuccess(new PlaySuccessInfo(mediaPlayerProxy.mSourcePath, valueOf, valueOf2));
                }
            }
        });
        this.mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.searchbox.afx.proxy.MediaPlayerProxy.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
                String valueOf = mediaPlayer2 != null ? String.valueOf(mediaPlayer2.getCurrentPosition()) : "-1";
                String glVersion = MediaPlayerProxy.this.getGlVersion();
                String sourcePath = MediaPlayerProxy.this.getSourcePath();
                String valueOf2 = String.valueOf(System.currentTimeMillis() / 1000);
                RuntimeException runtimeException = new RuntimeException("MediaPlayer Error (" + i + "," + i2 + SmallTailInfo.EMOTION_SUFFIX);
                OnReportListener onReportListener = MediaPlayerProxy.this.mOnReportListener;
                if (onReportListener != null) {
                    onReportListener.onError(new ErrorInfo(16, ErrorInfo.MEDIAPLAYER_DECODING_ERROR_ERRORMSG, runtimeException, valueOf, glVersion, sourcePath, valueOf2));
                }
                OnVideoErrorListener onVideoErrorListener = MediaPlayerProxy.this.mOnVideoErrorListener;
                return onVideoErrorListener != null && onVideoErrorListener.onError(new ErrorInfo(16, ErrorInfo.MEDIAPLAYER_DECODING_ERROR_ERRORMSG, runtimeException, valueOf, glVersion, sourcePath, valueOf2));
            }
        });
        this.mMediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.searchbox.afx.proxy.MediaPlayerProxy.3
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                OnVideoStartedListener onVideoStartedListener;
                if (i == 3 && (onVideoStartedListener = MediaPlayerProxy.this.mOnVideoStartedListener) != null) {
                    onVideoStartedListener.onVideoStarted();
                    return false;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getGlVersion() {
        ActivityManager activityManager;
        ConfigurationInfo deviceConfigurationInfo;
        GLTextureView gLTextureView = this.mGLTextureView;
        if (gLTextureView == null || (activityManager = (ActivityManager) gLTextureView.getContext().getSystemService("activity")) == null || (deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo()) == null) {
            return null;
        }
        return deviceConfigurationInfo.getGlEsVersion();
    }

    private void prepareAsync(MediaPlayer.OnPreparedListener onPreparedListener) {
        if (this.mMediaPlayer != null) {
            if (isNotPrepared() || isStopped()) {
                this.mMediaPlayer.setOnPreparedListener(onPreparedListener);
                try {
                    this.mMediaPlayer.prepareAsync();
                    this.mPlayerState = PlayerProxy.PlayerState.PREPARING;
                } catch (IllegalStateException e2) {
                    String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                    OnReportListener onReportListener = this.mOnReportListener;
                    if (onReportListener != null) {
                        onReportListener.onError(new ErrorInfo(2, ErrorInfo.OPENGL_ENVIRONMENT_ERROR_ERRORMSG, e2, "-1", null, getSourcePath(), valueOf));
                    }
                    OnVideoErrorListener onVideoErrorListener = this.mOnVideoErrorListener;
                    if (onVideoErrorListener != null) {
                        onVideoErrorListener.onError(new ErrorInfo(2, ErrorInfo.OPENGL_ENVIRONMENT_ERROR_ERRORMSG, e2, "-1", null, getSourcePath(), valueOf));
                    }
                    throw e2;
                }
            }
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void destroy() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.mMediaPlayer = null;
            this.mGLTextureView = null;
            super.destroy();
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public long getDuration() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            return 0L;
        }
        return mediaPlayer.getDuration();
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public int getFps() {
        return 0;
    }

    public MediaPlayer getMediaPlayer() {
        return this.mMediaPlayer;
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void pause() {
        if (this.mMediaPlayer == null || !isPlaying()) {
            return;
        }
        this.mMediaPlayer.pause();
        GLTextureView gLTextureView = this.mGLTextureView;
        if (gLTextureView != null) {
            gLTextureView.setRenderMode(0);
        }
        super.pause();
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void play() {
        if (this.mMediaPlayer != null) {
            try {
                int i = AnonymousClass6.$SwitchMap$com$baidu$searchbox$afx$proxy$PlayerProxy$PlayerState[this.mPlayerState.ordinal()];
                if (i == 1 || i == 2) {
                    prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.searchbox.afx.proxy.MediaPlayerProxy.4
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            MediaPlayerProxy mediaPlayerProxy = MediaPlayerProxy.this;
                            mediaPlayerProxy.mPlayerState = PlayerProxy.PlayerState.PREPARED;
                            if (mediaPlayerProxy.mGLTextureView != null) {
                                MediaPlayerProxy.this.mGLTextureView.setRenderMode(1);
                            }
                            MediaPlayerProxy.this.mPrepareTime = System.currentTimeMillis();
                            MediaPlayerProxy.this.mMediaPlayer.start();
                            MediaPlayerProxy.super.play();
                        }
                    });
                } else if (i == 3 || i == 4) {
                    if (this.mGLTextureView != null) {
                        this.mGLTextureView.setRenderMode(1);
                    }
                    this.mMediaPlayer.start();
                    super.play();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                String glVersion = getGlVersion();
                String sourcePath = getSourcePath();
                String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                OnReportListener onReportListener = this.mOnReportListener;
                if (onReportListener != null) {
                    onReportListener.onError(new ErrorInfo(1, ErrorInfo.MEDIAPLAYER_PLAY_SOURCE_ERROR_ERRORMSG, e2, "-1", glVersion, sourcePath, valueOf));
                }
                OnVideoErrorListener onVideoErrorListener = this.mOnVideoErrorListener;
                if (onVideoErrorListener != null) {
                    onVideoErrorListener.onError(new ErrorInfo(1, ErrorInfo.MEDIAPLAYER_PLAY_SOURCE_ERROR_ERRORMSG, e2, "-1", glVersion, sourcePath, valueOf));
                }
            }
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy
    public void reset() {
        if (this.mMediaPlayer == null || isDestroyed()) {
            return;
        }
        this.mMediaPlayer.reset();
        super.reset();
    }

    public void seekTo(int i) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(i);
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
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setSurface(Surface surface) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void stop() {
        if (this.mMediaPlayer != null) {
            if (isPlaying() || isPaused()) {
                if (Build.VERSION.SDK_INT <= 19) {
                    seekTo(0);
                }
                this.mMediaPlayer.stop();
                super.stop();
                GLTextureView gLTextureView = this.mGLTextureView;
                if (gLTextureView != null) {
                    gLTextureView.post(new Runnable() { // from class: com.baidu.searchbox.afx.proxy.MediaPlayerProxy.5
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

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy
    public void setSourceFD(FileDescriptor fileDescriptor, long j, long j2) {
        try {
            reset();
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.setDataSource(fileDescriptor, j, j2);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
