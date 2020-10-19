package com.baidu.searchbox.afx.proxy;

import android.app.ActivityManager;
import android.content.pm.ConfigurationInfo;
import android.media.MediaPlayer;
import android.os.Build;
import android.view.Surface;
import com.baidu.searchbox.afx.callback.ErrorInfo;
import com.baidu.searchbox.afx.callback.PlaySuccessInfo;
import com.baidu.searchbox.afx.gl.GLTextureView;
import com.baidu.searchbox.afx.proxy.PlayerProxy;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.FileDescriptor;
import java.io.IOException;
/* loaded from: classes17.dex */
public class MediaPlayerProxy extends PlayerProxy {
    private static final String TAG = "MediaPlayerProxy";
    private GLTextureView mGLTextureView;
    private long mStartTimeMs;
    private long mPrepareTime = -1;
    private MediaPlayer mMediaPlayer = new MediaPlayer();

    public MediaPlayerProxy() {
        this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.searchbox.afx.proxy.MediaPlayerProxy.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
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
                    MediaPlayerProxy.this.mOnReportListener.onSuccess(new PlaySuccessInfo(MediaPlayerProxy.this.mSourcePath, String.valueOf(System.currentTimeMillis() / 1000), String.valueOf(MediaPlayerProxy.this.mPrepareTime / 1000)));
                }
            }
        });
        this.mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.searchbox.afx.proxy.MediaPlayerProxy.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                String str = "-1";
                if (mediaPlayer != null) {
                    str = String.valueOf(mediaPlayer.getCurrentPosition());
                }
                String glVersion = MediaPlayerProxy.this.getGlVersion();
                String sourcePath = MediaPlayerProxy.this.getSourcePath();
                String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                RuntimeException runtimeException = new RuntimeException("MediaPlayer Error (" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2 + ")");
                if (MediaPlayerProxy.this.mOnReportListener != null) {
                    MediaPlayerProxy.this.mOnReportListener.onError(new ErrorInfo(16, ErrorInfo.MEDIAPLAYER_DECODING_ERROR_ERRORMSG, runtimeException, str, glVersion, sourcePath, valueOf));
                }
                return MediaPlayerProxy.this.mOnVideoErrorListener != null && MediaPlayerProxy.this.mOnVideoErrorListener.onError(new ErrorInfo(16, ErrorInfo.MEDIAPLAYER_DECODING_ERROR_ERRORMSG, runtimeException, str, glVersion, sourcePath, valueOf));
            }
        });
        this.mMediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.searchbox.afx.proxy.MediaPlayerProxy.3
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                switch (i) {
                    case 3:
                        if (MediaPlayerProxy.this.mOnVideoStartedListener != null) {
                            MediaPlayerProxy.this.mOnVideoStartedListener.onVideoStarted();
                            return false;
                        }
                        return false;
                    default:
                        return false;
                }
            }
        });
    }

    public MediaPlayer getMediaPlayer() {
        return this.mMediaPlayer;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setSurface(Surface surface) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setSurface(surface);
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy
    public void setSourceFD(FileDescriptor fileDescriptor) {
        try {
            reset();
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.setDataSource(fileDescriptor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy
    public void setSourceFD(FileDescriptor fileDescriptor, long j, long j2) {
        try {
            reset();
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.setDataSource(fileDescriptor, j, j2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setLooping(boolean z) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setLooping(z);
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setGLTextureView(GLTextureView gLTextureView) {
        this.mGLTextureView = gLTextureView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getGlVersion() {
        ActivityManager activityManager;
        ConfigurationInfo deviceConfigurationInfo;
        if (this.mGLTextureView == null || (activityManager = (ActivityManager) this.mGLTextureView.getContext().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) == null || (deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo()) == null) {
            return null;
        }
        return deviceConfigurationInfo.getGlEsVersion();
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void play() {
        if (this.mMediaPlayer != null) {
            try {
                switch (this.mPlayerState) {
                    case NOT_PREPARED:
                    case STOPPED:
                        prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.searchbox.afx.proxy.MediaPlayerProxy.4
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                MediaPlayerProxy.this.mPlayerState = PlayerProxy.PlayerState.PREPARED;
                                if (MediaPlayerProxy.this.mGLTextureView != null) {
                                    MediaPlayerProxy.this.mGLTextureView.setRenderMode(1);
                                }
                                MediaPlayerProxy.this.mPrepareTime = System.currentTimeMillis();
                                MediaPlayerProxy.this.mMediaPlayer.start();
                                MediaPlayerProxy.super.play();
                            }
                        });
                        return;
                    case PREPARED:
                    case PAUSED:
                        if (this.mGLTextureView != null) {
                            this.mGLTextureView.setRenderMode(1);
                        }
                        this.mMediaPlayer.start();
                        super.play();
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                String glVersion = getGlVersion();
                String sourcePath = getSourcePath();
                String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                if (this.mOnReportListener != null) {
                    this.mOnReportListener.onError(new ErrorInfo(1, ErrorInfo.MEDIAPLAYER_PLAY_SOURCE_ERROR_ERRORMSG, e, "-1", glVersion, sourcePath, valueOf));
                }
                if (this.mOnVideoErrorListener != null) {
                    this.mOnVideoErrorListener.onError(new ErrorInfo(1, ErrorInfo.MEDIAPLAYER_PLAY_SOURCE_ERROR_ERRORMSG, e, "-1", glVersion, sourcePath, valueOf));
                }
            }
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
                    if (this.mOnReportListener != null) {
                        this.mOnReportListener.onError(new ErrorInfo(2, ErrorInfo.OPENGL_ENVIRONMENT_ERROR_ERRORMSG, e, "-1", null, getSourcePath(), valueOf));
                    }
                    if (this.mOnVideoErrorListener != null) {
                        this.mOnVideoErrorListener.onError(new ErrorInfo(2, ErrorInfo.OPENGL_ENVIRONMENT_ERROR_ERRORMSG, e, "-1", null, getSourcePath(), valueOf));
                    }
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void pause() {
        if (this.mMediaPlayer != null && isPlaying()) {
            this.mMediaPlayer.pause();
            if (this.mGLTextureView != null) {
                this.mGLTextureView.setRenderMode(0);
            }
            super.pause();
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
                if (this.mGLTextureView != null) {
                    this.mGLTextureView.post(new Runnable() { // from class: com.baidu.searchbox.afx.proxy.MediaPlayerProxy.5
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
    public void reset() {
        if (this.mMediaPlayer != null && !isDestroyed()) {
            this.mMediaPlayer.reset();
            super.reset();
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void destroy() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.mGLTextureView = null;
            super.destroy();
        }
    }

    public void seekTo(int i) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.seekTo(i);
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public long getDuration() {
        if (this.mMediaPlayer == null) {
            return 0L;
        }
        return this.mMediaPlayer.getDuration();
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public int getFps() {
        return 0;
    }
}
