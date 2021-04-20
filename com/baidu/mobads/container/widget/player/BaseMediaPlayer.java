package com.baidu.mobads.container.widget.player;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.mobads.container.util.PermissionUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
/* loaded from: classes2.dex */
public class BaseMediaPlayer implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnSeekCompleteListener {
    public static final String TAG = "BaseMediaPlayer";
    public RemoteXAdLogger mAdLogger = RemoteXAdLogger.getInstance();
    public State mCurState;
    public MediaPlayer mVideoPlayer;
    public Surface mVideoSurface;
    public SurfaceHolder mVideoSurfaceHolder;
    public OnPlayStateListener playStateListener;

    /* loaded from: classes2.dex */
    public enum State {
        IDLE,
        INITIALIZED,
        PREPARING,
        PREPARED,
        STARTED,
        PAUSED,
        STOPPED,
        PLAYBACKCOMPLETED,
        END,
        ERROR
    }

    public BaseMediaPlayer(Context context) {
        initPlayer();
    }

    private void initPlayer() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.mVideoPlayer = mediaPlayer;
        this.mCurState = State.IDLE;
        mediaPlayer.setAudioStreamType(3);
        this.mVideoPlayer.setOnPreparedListener(this);
        this.mVideoPlayer.setOnCompletionListener(this);
        this.mVideoPlayer.setOnErrorListener(this);
        this.mVideoPlayer.setOnInfoListener(this);
        this.mVideoPlayer.setOnSeekCompleteListener(this);
    }

    private void notifyPlayerEvent(int i) {
        OnPlayStateListener onPlayStateListener = this.playStateListener;
        if (onPlayStateListener != null) {
            onPlayStateListener.playStateChanged(i);
        }
    }

    private void prepare() {
        this.mVideoPlayer.prepareAsync();
        this.mCurState = State.PREPARING;
    }

    public int getCurrentPosition() {
        MediaPlayer mediaPlayer;
        State state = this.mCurState;
        if ((state == State.IDLE || state == State.INITIALIZED || state == State.PREPARED || state == State.STARTED || state == State.PAUSED || state == State.STOPPED || state == State.PLAYBACKCOMPLETED) && (mediaPlayer = this.mVideoPlayer) != null) {
            return mediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        MediaPlayer mediaPlayer;
        State state = this.mCurState;
        if ((state == State.PREPARED || state == State.STARTED || state == State.PAUSED || state == State.STOPPED || state == State.PLAYBACKCOMPLETED) && (mediaPlayer = this.mVideoPlayer) != null) {
            return mediaPlayer.getDuration();
        }
        return 0;
    }

    public int getVideoHeight() {
        MediaPlayer mediaPlayer;
        if (this.mCurState == State.ERROR || (mediaPlayer = this.mVideoPlayer) == null) {
            return 0;
        }
        return mediaPlayer.getVideoHeight();
    }

    public int getVideoWidth() {
        MediaPlayer mediaPlayer;
        if (this.mCurState == State.ERROR || (mediaPlayer = this.mVideoPlayer) == null) {
            return 0;
        }
        return mediaPlayer.getVideoWidth();
    }

    public boolean isEnd() {
        State state = this.mCurState;
        return state == State.IDLE || state == State.PLAYBACKCOMPLETED || state == State.ERROR;
    }

    public boolean isPlaying() {
        try {
            if ((this.mCurState == State.IDLE || this.mCurState == State.INITIALIZED || this.mCurState == State.PREPARED || this.mCurState == State.STARTED || this.mCurState == State.PAUSED || this.mCurState == State.STOPPED || this.mCurState == State.PLAYBACKCOMPLETED) && this.mVideoPlayer != null) {
                return this.mVideoPlayer.isPlaying();
            }
            return false;
        } catch (Exception e2) {
            RemoteXAdLogger remoteXAdLogger = this.mAdLogger;
            remoteXAdLogger.i(TAG, "isPlaying异常" + e2.getMessage());
            return false;
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        RemoteXAdLogger remoteXAdLogger = this.mAdLogger;
        remoteXAdLogger.i(TAG, "onCompletion" + this.mCurState);
        this.mCurState = State.PLAYBACKCOMPLETED;
        notifyPlayerEvent(256);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        RemoteXAdLogger remoteXAdLogger = this.mAdLogger;
        remoteXAdLogger.i(TAG, "onError" + this.mCurState);
        this.mCurState = State.ERROR;
        notifyPlayerEvent(257);
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 3) {
            notifyPlayerEvent(260);
            return false;
        } else if (i == 701) {
            notifyPlayerEvent(PlayerEvent.PLAY_LOADING_START);
            return false;
        } else if (i != 702) {
            return false;
        } else {
            notifyPlayerEvent(PlayerEvent.PLAY_LOADING_END);
            return false;
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.mCurState = State.PREPARED;
        notifyPlayerEvent(258);
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        Log.e(AdVideoView.TAG, "onSeekComplete");
        notifyPlayerEvent(259);
    }

    public void pause() {
        RemoteXAdLogger remoteXAdLogger = this.mAdLogger;
        remoteXAdLogger.i(TAG, "pause=" + this.mCurState);
        if (this.mVideoPlayer != null) {
            State state = this.mCurState;
            if (state == State.STARTED || state == State.PLAYBACKCOMPLETED) {
                this.mVideoPlayer.pause();
                this.mCurState = State.PAUSED;
            }
        }
    }

    public void release() {
        MediaPlayer mediaPlayer = this.mVideoPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.mCurState = State.END;
            this.mVideoPlayer.setOnSeekCompleteListener(null);
            this.mVideoPlayer.setOnInfoListener(null);
            this.mVideoPlayer.setOnErrorListener(null);
            this.mVideoPlayer.setOnPreparedListener(null);
            this.mVideoPlayer.setOnCompletionListener(null);
        }
    }

    public void reset() {
        MediaPlayer mediaPlayer = this.mVideoPlayer;
        if (mediaPlayer != null) {
            this.mCurState = State.IDLE;
            mediaPlayer.reset();
        }
    }

    public void resume() {
        start();
    }

    public void seekTo(int i) {
        State state = this.mCurState;
        if (state != State.PREPARED && state != State.STARTED && state != State.PAUSED && state != State.PLAYBACKCOMPLETED) {
            RemoteXAdLogger remoteXAdLogger = this.mAdLogger;
            remoteXAdLogger.i(TAG, "seekto不合法，mCurState=" + this.mCurState);
            return;
        }
        MediaPlayer mediaPlayer = this.mVideoPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.seekTo(i);
            } catch (Exception e2) {
                RemoteXAdLogger remoteXAdLogger2 = this.mAdLogger;
                remoteXAdLogger2.i(TAG, "seekTo异常" + e2.getMessage());
            }
        }
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.mVideoSurfaceHolder = surfaceHolder;
        MediaPlayer mediaPlayer = this.mVideoPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setDisplay(surfaceHolder);
            this.mVideoPlayer.setScreenOnWhilePlaying(true);
        }
    }

    public void setOnPlayStateListener(OnPlayStateListener onPlayStateListener) {
        this.playStateListener = onPlayStateListener;
    }

    public void setPlayBackSpeed(float f2) {
        MediaPlayer mediaPlayer;
        if (this.mCurState == State.ERROR || (mediaPlayer = this.mVideoPlayer) == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                mediaPlayer.setPlaybackParams(mediaPlayer.getPlaybackParams().setSpeed(f2));
            }
        } catch (Exception e2) {
            RemoteXAdLogger remoteXAdLogger = this.mAdLogger;
            remoteXAdLogger.i(TAG, "setPlayBackSpeed异常" + e2.getMessage());
        }
    }

    public void setScreenOnWhilePlaying(boolean z) {
        MediaPlayer mediaPlayer = this.mVideoPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setScreenOnWhilePlaying(z);
        }
    }

    public void setSurface(Surface surface) {
        this.mVideoSurface = surface;
        MediaPlayer mediaPlayer = this.mVideoPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
        }
    }

    public void setVideoPath(String str) {
        MediaPlayer mediaPlayer = this.mVideoPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setDataSource(str);
                this.mCurState = State.INITIALIZED;
                prepare();
            } catch (Exception e2) {
                RemoteXAdLogger remoteXAdLogger = this.mAdLogger;
                remoteXAdLogger.i(TAG, "setVideoPath异常" + e2.getMessage());
            }
        }
    }

    public void setVolume(float f2, float f3) {
        MediaPlayer mediaPlayer;
        if (this.mCurState == State.ERROR || (mediaPlayer = this.mVideoPlayer) == null) {
            return;
        }
        mediaPlayer.setVolume(f2, f3);
    }

    public void setWakeMode(Context context, int i) {
        if (this.mVideoPlayer == null || context == null || !PermissionUtils.checkPermission(context, "android.permission.WAKE_LOCK")) {
            return;
        }
        this.mVideoPlayer.setWakeMode(context.getApplicationContext(), i);
    }

    public void start() {
        RemoteXAdLogger remoteXAdLogger = this.mAdLogger;
        remoteXAdLogger.i(TAG, "start=" + this.mCurState);
        if (this.mVideoPlayer != null) {
            State state = this.mCurState;
            if (state == State.PREPARED || state == State.PAUSED || state == State.PLAYBACKCOMPLETED) {
                this.mVideoPlayer.start();
                this.mCurState = State.STARTED;
            }
        }
    }

    public void stop() {
        if (this.mVideoPlayer != null) {
            State state = this.mCurState;
            if (state == State.STARTED || state == State.PREPARED || state == State.PAUSED || state == State.PLAYBACKCOMPLETED) {
                this.mVideoPlayer.stop();
                this.mCurState = State.STOPPED;
            }
        }
    }
}
