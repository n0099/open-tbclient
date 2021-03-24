package com.baidu.searchbox.afx.proxy;

import android.util.Log;
import android.view.Surface;
import com.baidu.searchbox.afx.callback.ErrorInfo;
import com.baidu.searchbox.afx.callback.OnReportListener;
import com.baidu.searchbox.afx.callback.OnVideoEndedListener;
import com.baidu.searchbox.afx.callback.OnVideoErrorListener;
import com.baidu.searchbox.afx.callback.OnVideoPreparedListener;
import com.baidu.searchbox.afx.callback.OnVideoStartedListener;
import com.baidu.searchbox.afx.callback.PlaySuccessInfo;
import com.baidu.searchbox.afx.decode.SpeedControl;
import com.baidu.searchbox.afx.decode.VideoPlayer;
import com.baidu.searchbox.afx.gl.GLTextureView;
import com.baidu.searchbox.afx.proxy.PlayerProxy;
import com.baidu.searchbox.afx.recode.Mp4Composer;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
/* loaded from: classes2.dex */
public class VideoPlayerProxy extends PlayerProxy {
    public static final String TAG = "VideoPlayerProxy";
    public final VideoPlayer.PlayTask mPlayTask;
    public final VideoPlayer mVideoPlayer;

    /* renamed from: com.baidu.searchbox.afx.proxy.VideoPlayerProxy$6  reason: invalid class name */
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
                $SwitchMap$com$baidu$searchbox$afx$proxy$PlayerProxy$PlayerState[PlayerProxy.PlayerState.PREPARED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$afx$proxy$PlayerProxy$PlayerState[PlayerProxy.PlayerState.STOPPED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$afx$proxy$PlayerProxy$PlayerState[PlayerProxy.PlayerState.PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public VideoPlayerProxy() {
        VideoPlayer videoPlayer = new VideoPlayer();
        this.mVideoPlayer = videoPlayer;
        videoPlayer.setFrameCallback(new SpeedControl());
        this.mVideoPlayer.setOnInfoListener(new VideoPlayer.OnInfoListener() { // from class: com.baidu.searchbox.afx.proxy.VideoPlayerProxy.1
            @Override // com.baidu.searchbox.afx.decode.VideoPlayer.OnInfoListener
            public boolean onInfo(VideoPlayer videoPlayer2, int i, int i2) {
                OnVideoStartedListener onVideoStartedListener;
                if (i == 3 && (onVideoStartedListener = VideoPlayerProxy.this.mOnVideoStartedListener) != null) {
                    onVideoStartedListener.onVideoStarted();
                    return true;
                }
                return true;
            }
        });
        this.mPlayTask = new VideoPlayer.PlayTask(this.mVideoPlayer, new OnVideoEndedListener() { // from class: com.baidu.searchbox.afx.proxy.VideoPlayerProxy.2
            @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
            public void onVideoEnded() {
                VideoPlayerProxy videoPlayerProxy = VideoPlayerProxy.this;
                videoPlayerProxy.mPlayerState = PlayerProxy.PlayerState.STOPPED;
                OnVideoEndedListener onVideoEndedListener = videoPlayerProxy.mOnVideoEndedListener;
                if (onVideoEndedListener != null) {
                    onVideoEndedListener.onVideoEnded();
                }
            }
        }, new OnVideoErrorListener() { // from class: com.baidu.searchbox.afx.proxy.VideoPlayerProxy.3
            @Override // com.baidu.searchbox.afx.callback.OnVideoErrorListener
            public boolean onError(ErrorInfo errorInfo) {
                VideoPlayerProxy videoPlayerProxy = VideoPlayerProxy.this;
                videoPlayerProxy.mPlayerState = PlayerProxy.PlayerState.STOPPED;
                OnVideoErrorListener onVideoErrorListener = videoPlayerProxy.mOnVideoErrorListener;
                return onVideoErrorListener != null && onVideoErrorListener.onError(errorInfo);
            }
        }, new OnReportListener() { // from class: com.baidu.searchbox.afx.proxy.VideoPlayerProxy.4
            @Override // com.baidu.searchbox.afx.callback.OnReportListener
            public void onError(ErrorInfo errorInfo) {
                VideoPlayerProxy videoPlayerProxy = VideoPlayerProxy.this;
                if (videoPlayerProxy.mOnReportListener == null || errorInfo == null) {
                    return;
                }
                errorInfo.mFilePath = videoPlayerProxy.getSourcePath();
                if (VideoPlayerProxy.this.mVideoPlayer != null) {
                    errorInfo.mGlVersion = VideoPlayerProxy.this.mVideoPlayer.getGlVersion();
                }
                VideoPlayerProxy.this.mOnReportListener.onError(errorInfo);
            }

            @Override // com.baidu.searchbox.afx.callback.OnReportListener
            public void onSuccess(PlaySuccessInfo playSuccessInfo) {
                VideoPlayerProxy videoPlayerProxy = VideoPlayerProxy.this;
                if (videoPlayerProxy.mOnReportListener != null) {
                    if (playSuccessInfo != null) {
                        playSuccessInfo.mFilePath = videoPlayerProxy.getSourcePath();
                    }
                    VideoPlayerProxy.this.mOnReportListener.onSuccess(playSuccessInfo);
                }
            }
        });
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void destroy() {
        VideoPlayer videoPlayer = this.mVideoPlayer;
        if (videoPlayer == null || this.mPlayTask == null) {
            return;
        }
        videoPlayer.release();
        this.mPlayTask.release();
        super.destroy();
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public long getDuration() {
        VideoPlayer videoPlayer = this.mVideoPlayer;
        if (videoPlayer == null) {
            return 0L;
        }
        return videoPlayer.getDuration();
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public int getFps() {
        VideoPlayer videoPlayer = this.mVideoPlayer;
        if (videoPlayer == null) {
            return 0;
        }
        return videoPlayer.getFps();
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void pause() {
        if (this.mVideoPlayer == null || !isPlaying()) {
            return;
        }
        this.mVideoPlayer.requestPause();
        super.pause();
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void play() {
        int i = AnonymousClass6.$SwitchMap$com$baidu$searchbox$afx$proxy$PlayerProxy$PlayerState[this.mPlayerState.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            VideoPlayer.PlayTask playTask = this.mPlayTask;
            if (playTask != null) {
                playTask.execute();
            }
        } else if (i == 4) {
            resume();
        }
        super.play();
    }

    public void prepareAsync(String str, final OnVideoPreparedListener onVideoPreparedListener) {
        final long currentTimeMillis = System.currentTimeMillis();
        File file = new File(str);
        File parentFile = file.getParentFile();
        new Mp4Composer().start(str, new File(parentFile, file.getName().replace(".mp4", "") + "_processed.mp4").getPath(), new Mp4Composer.Listener() { // from class: com.baidu.searchbox.afx.proxy.VideoPlayerProxy.5
            @Override // com.baidu.searchbox.afx.recode.Mp4Composer.Listener
            public void onCompleted() {
                OnVideoPreparedListener onVideoPreparedListener2 = onVideoPreparedListener;
                if (onVideoPreparedListener2 != null) {
                    onVideoPreparedListener2.onPrepared();
                }
            }

            @Override // com.baidu.searchbox.afx.recode.Mp4Composer.Listener
            public void onFailed(Exception exc) {
                Log.e(VideoPlayerProxy.TAG, "onFailed, exception: ", exc);
            }

            @Override // com.baidu.searchbox.afx.recode.Mp4Composer.Listener
            public void onProgress(float f2) {
            }
        });
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void resume() {
        if (this.mVideoPlayer == null || !isPaused()) {
            return;
        }
        this.mVideoPlayer.requestResume();
        super.resume();
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setGLTextureView(GLTextureView gLTextureView) {
        VideoPlayer videoPlayer = this.mVideoPlayer;
        if (videoPlayer != null) {
            videoPlayer.setGLTextureView(gLTextureView);
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void setLoopSection(long j, long j2) {
        VideoPlayer videoPlayer = this.mVideoPlayer;
        if (videoPlayer != null) {
            videoPlayer.setLoopSection(j, j2);
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setLooping(boolean z) {
        VideoPlayer videoPlayer = this.mVideoPlayer;
        if (videoPlayer != null) {
            videoPlayer.setLooping(z);
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy
    public void setSourceFD(FileDescriptor fileDescriptor) {
        try {
            if (this.mVideoPlayer != null) {
                this.mVideoPlayer.setDataSource(fileDescriptor);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setSurface(Surface surface) {
        VideoPlayer videoPlayer = this.mVideoPlayer;
        if (videoPlayer != null) {
            videoPlayer.setSurface(surface);
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void stop() {
        if (this.mVideoPlayer != null) {
            if (isPlaying() || isPaused()) {
                this.mVideoPlayer.requestStop();
                this.mPlayerState = PlayerProxy.PlayerState.STOPPED;
            }
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void setLoopSection(long j) {
        VideoPlayer videoPlayer = this.mVideoPlayer;
        if (videoPlayer != null) {
            videoPlayer.setLoopSection(j);
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy
    public void setSourceFD(FileDescriptor fileDescriptor, long j, long j2) {
        try {
            if (this.mVideoPlayer != null) {
                this.mVideoPlayer.setDataSource(fileDescriptor, j, j2);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void setLoopSection(int i, int i2) {
        VideoPlayer videoPlayer = this.mVideoPlayer;
        if (videoPlayer != null) {
            videoPlayer.setLoopSection(i, i2);
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void setLoopSection(int i) {
        VideoPlayer videoPlayer = this.mVideoPlayer;
        if (videoPlayer != null) {
            videoPlayer.setLoopSection(i);
        }
    }
}
