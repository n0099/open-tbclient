package com.baidu.searchbox.afx.proxy;

import android.util.Log;
import android.view.Surface;
import com.baidu.searchbox.afx.callback.ErrorInfo;
import com.baidu.searchbox.afx.callback.OnReportListener;
import com.baidu.searchbox.afx.callback.OnVideoEndedListener;
import com.baidu.searchbox.afx.callback.OnVideoErrorListener;
import com.baidu.searchbox.afx.callback.OnVideoPreparedListener;
import com.baidu.searchbox.afx.callback.PlaySuccessInfo;
import com.baidu.searchbox.afx.decode.SpeedControl;
import com.baidu.searchbox.afx.decode.VideoPlayer;
import com.baidu.searchbox.afx.gl.GLTextureView;
import com.baidu.searchbox.afx.proxy.PlayerProxy;
import com.baidu.searchbox.afx.recode.Mp4Composer;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
/* loaded from: classes5.dex */
public class VideoPlayerProxy extends PlayerProxy {
    private static final String TAG = "VideoPlayerProxy";
    private final VideoPlayer.PlayTask mPlayTask;
    private final VideoPlayer mVideoPlayer = new VideoPlayer();

    public VideoPlayerProxy() {
        this.mVideoPlayer.setFrameCallback(new SpeedControl());
        this.mVideoPlayer.setOnInfoListener(new VideoPlayer.OnInfoListener() { // from class: com.baidu.searchbox.afx.proxy.VideoPlayerProxy.1
            @Override // com.baidu.searchbox.afx.decode.VideoPlayer.OnInfoListener
            public boolean onInfo(VideoPlayer videoPlayer, int i, int i2) {
                switch (i) {
                    case 3:
                        if (VideoPlayerProxy.this.mOnVideoStartedListener != null) {
                            VideoPlayerProxy.this.mOnVideoStartedListener.onVideoStarted();
                            return true;
                        }
                        return true;
                    default:
                        return true;
                }
            }
        });
        this.mPlayTask = new VideoPlayer.PlayTask(this.mVideoPlayer, new OnVideoEndedListener() { // from class: com.baidu.searchbox.afx.proxy.VideoPlayerProxy.2
            @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
            public void onVideoEnded() {
                VideoPlayerProxy.this.mPlayerState = PlayerProxy.PlayerState.STOPPED;
                if (VideoPlayerProxy.this.mOnVideoEndedListener != null) {
                    VideoPlayerProxy.this.mOnVideoEndedListener.onVideoEnded();
                }
            }
        }, new OnVideoErrorListener() { // from class: com.baidu.searchbox.afx.proxy.VideoPlayerProxy.3
            @Override // com.baidu.searchbox.afx.callback.OnVideoErrorListener
            public boolean onError(ErrorInfo errorInfo) {
                VideoPlayerProxy.this.mPlayerState = PlayerProxy.PlayerState.STOPPED;
                return VideoPlayerProxy.this.mOnVideoErrorListener != null && VideoPlayerProxy.this.mOnVideoErrorListener.onError(errorInfo);
            }
        }, new OnReportListener() { // from class: com.baidu.searchbox.afx.proxy.VideoPlayerProxy.4
            @Override // com.baidu.searchbox.afx.callback.OnReportListener
            public void onSuccess(PlaySuccessInfo playSuccessInfo) {
                if (VideoPlayerProxy.this.mOnReportListener != null) {
                    if (playSuccessInfo != null) {
                        playSuccessInfo.mFilePath = VideoPlayerProxy.this.getSourcePath();
                    }
                    VideoPlayerProxy.this.mOnReportListener.onSuccess(playSuccessInfo);
                }
            }

            @Override // com.baidu.searchbox.afx.callback.OnReportListener
            public void onError(ErrorInfo errorInfo) {
                if (VideoPlayerProxy.this.mOnReportListener != null && errorInfo != null) {
                    errorInfo.mFilePath = VideoPlayerProxy.this.getSourcePath();
                    if (VideoPlayerProxy.this.mVideoPlayer != null) {
                        errorInfo.mGlVersion = VideoPlayerProxy.this.mVideoPlayer.getGlVersion();
                    }
                    VideoPlayerProxy.this.mOnReportListener.onError(errorInfo);
                }
            }
        });
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setSurface(Surface surface) {
        if (this.mVideoPlayer != null) {
            this.mVideoPlayer.setSurface(surface);
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy
    public void setSourceFD(FileDescriptor fileDescriptor) {
        try {
            if (this.mVideoPlayer != null) {
                this.mVideoPlayer.setDataSource(fileDescriptor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy
    public void setSourceFD(FileDescriptor fileDescriptor, long j, long j2) {
        try {
            if (this.mVideoPlayer != null) {
                this.mVideoPlayer.setDataSource(fileDescriptor, j, j2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void setLoopSection(long j, long j2) {
        if (this.mVideoPlayer != null) {
            this.mVideoPlayer.setLoopSection(j, j2);
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void setLoopSection(long j) {
        if (this.mVideoPlayer != null) {
            this.mVideoPlayer.setLoopSection(j);
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void setLoopSection(int i, int i2) {
        if (this.mVideoPlayer != null) {
            this.mVideoPlayer.setLoopSection(i, i2);
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void setLoopSection(int i) {
        if (this.mVideoPlayer != null) {
            this.mVideoPlayer.setLoopSection(i);
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setLooping(boolean z) {
        if (this.mVideoPlayer != null) {
            this.mVideoPlayer.setLooping(z);
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setGLTextureView(GLTextureView gLTextureView) {
        if (this.mVideoPlayer != null) {
            this.mVideoPlayer.setGLTextureView(gLTextureView);
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void play() {
        switch (this.mPlayerState) {
            case NOT_PREPARED:
            case PREPARED:
            case STOPPED:
                if (this.mPlayTask != null) {
                    this.mPlayTask.execute();
                    break;
                }
                break;
            case PAUSED:
                resume();
                break;
        }
        super.play();
    }

    public void prepareAsync(String str, final OnVideoPreparedListener onVideoPreparedListener) {
        final long currentTimeMillis = System.currentTimeMillis();
        File file = new File(str);
        new Mp4Composer().start(str, new File(file.getParentFile(), file.getName().replace(".mp4", "") + "_processed.mp4").getPath(), new Mp4Composer.Listener() { // from class: com.baidu.searchbox.afx.proxy.VideoPlayerProxy.5
            @Override // com.baidu.searchbox.afx.recode.Mp4Composer.Listener
            public void onProgress(float f) {
            }

            @Override // com.baidu.searchbox.afx.recode.Mp4Composer.Listener
            public void onCompleted() {
                if (onVideoPreparedListener != null) {
                    onVideoPreparedListener.onPrepared();
                }
            }

            @Override // com.baidu.searchbox.afx.recode.Mp4Composer.Listener
            public void onFailed(Exception exc) {
                Log.e(VideoPlayerProxy.TAG, "onFailed, exception: ", exc);
            }
        });
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void pause() {
        if (this.mVideoPlayer != null && isPlaying()) {
            this.mVideoPlayer.requestPause();
            super.pause();
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void resume() {
        if (this.mVideoPlayer != null && isPaused()) {
            this.mVideoPlayer.requestResume();
            super.resume();
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
    public void destroy() {
        if (this.mVideoPlayer != null && this.mPlayTask != null) {
            this.mVideoPlayer.release();
            this.mPlayTask.release();
            super.destroy();
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public long getDuration() {
        if (this.mVideoPlayer == null) {
            return 0L;
        }
        return this.mVideoPlayer.getDuration();
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public int getFps() {
        if (this.mVideoPlayer == null) {
            return 0;
        }
        return this.mVideoPlayer.getFps();
    }
}
