package com.baidu.mobads.container.widget.player;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.PermissionUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BaseMediaPlayer implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnSeekCompleteListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BaseMediaPlayer";
    public transient /* synthetic */ FieldHolder $fh;
    public RemoteXAdLogger mAdLogger;
    public State mCurState;
    public MediaPlayer mVideoPlayer;
    public Surface mVideoSurface;
    public SurfaceHolder mVideoSurfaceHolder;
    public OnPlayStateListener playStateListener;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class State {
        public static final /* synthetic */ State[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final State END;
        public static final State ERROR;
        public static final State IDLE;
        public static final State INITIALIZED;
        public static final State PAUSED;
        public static final State PLAYBACKCOMPLETED;
        public static final State PREPARED;
        public static final State PREPARING;
        public static final State STARTED;
        public static final State STOPPED;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(408156540, "Lcom/baidu/mobads/container/widget/player/BaseMediaPlayer$State;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(408156540, "Lcom/baidu/mobads/container/widget/player/BaseMediaPlayer$State;");
                    return;
                }
            }
            IDLE = new State("IDLE", 0);
            INITIALIZED = new State("INITIALIZED", 1);
            PREPARING = new State("PREPARING", 2);
            PREPARED = new State("PREPARED", 3);
            STARTED = new State("STARTED", 4);
            PAUSED = new State("PAUSED", 5);
            STOPPED = new State("STOPPED", 6);
            PLAYBACKCOMPLETED = new State("PLAYBACKCOMPLETED", 7);
            END = new State("END", 8);
            State state = new State("ERROR", 9);
            ERROR = state;
            $VALUES = new State[]{IDLE, INITIALIZED, PREPARING, PREPARED, STARTED, PAUSED, STOPPED, PLAYBACKCOMPLETED, END, state};
        }

        public State(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static State valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (State) Enum.valueOf(State.class, str) : (State) invokeL.objValue;
        }

        public static State[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (State[]) $VALUES.clone() : (State[]) invokeV.objValue;
        }
    }

    public BaseMediaPlayer(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAdLogger = RemoteXAdLogger.getInstance();
        initPlayer();
    }

    private void initPlayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
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
    }

    private void notifyPlayerEvent(int i2) {
        OnPlayStateListener onPlayStateListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65538, this, i2) == null) || (onPlayStateListener = this.playStateListener) == null) {
            return;
        }
        onPlayStateListener.playStateChanged(i2);
    }

    private void prepare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mVideoPlayer.prepareAsync();
            this.mCurState = State.PREPARING;
        }
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            State state = this.mCurState;
            if ((state == State.IDLE || state == State.INITIALIZED || state == State.PREPARED || state == State.STARTED || state == State.PAUSED || state == State.STOPPED || state == State.PLAYBACKCOMPLETED) && (mediaPlayer = this.mVideoPlayer) != null) {
                return mediaPlayer.getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getDuration() {
        InterceptResult invokeV;
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            State state = this.mCurState;
            if ((state == State.PREPARED || state == State.STARTED || state == State.PAUSED || state == State.STOPPED || state == State.PLAYBACKCOMPLETED) && (mediaPlayer = this.mVideoPlayer) != null) {
                return mediaPlayer.getDuration();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getVideoHeight() {
        InterceptResult invokeV;
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mCurState == State.ERROR || (mediaPlayer = this.mVideoPlayer) == null) {
                return 0;
            }
            return mediaPlayer.getVideoHeight();
        }
        return invokeV.intValue;
    }

    public int getVideoWidth() {
        InterceptResult invokeV;
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mCurState == State.ERROR || (mediaPlayer = this.mVideoPlayer) == null) {
                return 0;
            }
            return mediaPlayer.getVideoWidth();
        }
        return invokeV.intValue;
    }

    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            State state = this.mCurState;
            return state == State.IDLE || state == State.PLAYBACKCOMPLETED || state == State.ERROR;
        }
        return invokeV.booleanValue;
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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
        return invokeV.booleanValue;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mediaPlayer) == null) {
            RemoteXAdLogger remoteXAdLogger = this.mAdLogger;
            remoteXAdLogger.i(TAG, "onCompletion" + this.mCurState);
            this.mCurState = State.PLAYBACKCOMPLETED;
            notifyPlayerEvent(256);
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048583, this, mediaPlayer, i2, i3)) == null) {
            RemoteXAdLogger remoteXAdLogger = this.mAdLogger;
            remoteXAdLogger.i(TAG, "onError" + this.mCurState);
            this.mCurState = State.ERROR;
            notifyPlayerEvent(257);
            return true;
        }
        return invokeLII.booleanValue;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, mediaPlayer, i2, i3)) == null) {
            if (i2 == 3) {
                notifyPlayerEvent(260);
                return false;
            } else if (i2 == 701) {
                notifyPlayerEvent(PlayerEvent.PLAY_LOADING_START);
                return false;
            } else if (i2 != 702) {
                return false;
            } else {
                notifyPlayerEvent(PlayerEvent.PLAY_LOADING_END);
                return false;
            }
        }
        return invokeLII.booleanValue;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, mediaPlayer) == null) {
            this.mCurState = State.PREPARED;
            notifyPlayerEvent(258);
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, mediaPlayer) == null) {
            Log.e(AdVideoView.TAG, "onSeekComplete");
            notifyPlayerEvent(259);
        }
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
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
    }

    public void release() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (mediaPlayer = this.mVideoPlayer) == null) {
            return;
        }
        mediaPlayer.release();
        this.mCurState = State.END;
        this.mVideoPlayer.setOnSeekCompleteListener(null);
        this.mVideoPlayer.setOnInfoListener(null);
        this.mVideoPlayer.setOnErrorListener(null);
        this.mVideoPlayer.setOnPreparedListener(null);
        this.mVideoPlayer.setOnCompletionListener(null);
    }

    public void reset() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (mediaPlayer = this.mVideoPlayer) == null) {
            return;
        }
        this.mCurState = State.IDLE;
        mediaPlayer.reset();
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            start();
        }
    }

    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            State state = this.mCurState;
            if (state != State.PREPARED && state != State.STARTED && state != State.PAUSED && state != State.PLAYBACKCOMPLETED) {
                RemoteXAdLogger remoteXAdLogger = this.mAdLogger;
                remoteXAdLogger.i(TAG, "seekto不合法，mCurState=" + this.mCurState);
                return;
            }
            MediaPlayer mediaPlayer = this.mVideoPlayer;
            if (mediaPlayer != null) {
                try {
                    mediaPlayer.seekTo(i2);
                } catch (Exception e2) {
                    RemoteXAdLogger remoteXAdLogger2 = this.mAdLogger;
                    remoteXAdLogger2.i(TAG, "seekTo异常" + e2.getMessage());
                }
            }
        }
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, surfaceHolder) == null) {
            this.mVideoSurfaceHolder = surfaceHolder;
            MediaPlayer mediaPlayer = this.mVideoPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.setDisplay(surfaceHolder);
                this.mVideoPlayer.setScreenOnWhilePlaying(true);
            }
        }
    }

    public void setOnPlayStateListener(OnPlayStateListener onPlayStateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onPlayStateListener) == null) {
            this.playStateListener = onPlayStateListener;
        }
    }

    public void setPlayBackSpeed(float f2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048594, this, f2) == null) || this.mCurState == State.ERROR || (mediaPlayer = this.mVideoPlayer) == null) {
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
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || (mediaPlayer = this.mVideoPlayer) == null) {
            return;
        }
        mediaPlayer.setScreenOnWhilePlaying(z);
    }

    public void setSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, surface) == null) {
            this.mVideoSurface = surface;
            MediaPlayer mediaPlayer = this.mVideoPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.setSurface(surface);
            }
        }
    }

    public void setVideoPath(String str) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, str) == null) || (mediaPlayer = this.mVideoPlayer) == null) {
            return;
        }
        try {
            mediaPlayer.setDataSource(str);
            this.mCurState = State.INITIALIZED;
            prepare();
        } catch (Exception e2) {
            RemoteXAdLogger remoteXAdLogger = this.mAdLogger;
            remoteXAdLogger.i(TAG, "setVideoPath异常" + e2.getMessage());
        }
    }

    public void setVolume(float f2, float f3) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || this.mCurState == State.ERROR || (mediaPlayer = this.mVideoPlayer) == null) {
            return;
        }
        mediaPlayer.setVolume(f2, f3);
    }

    public void setWakeMode(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048599, this, context, i2) == null) || this.mVideoPlayer == null || context == null || !PermissionUtils.checkPermission(context, "android.permission.WAKE_LOCK")) {
            return;
        }
        this.mVideoPlayer.setWakeMode(context.getApplicationContext(), i2);
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
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
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || this.mVideoPlayer == null) {
            return;
        }
        State state = this.mCurState;
        if (state == State.STARTED || state == State.PREPARED || state == State.PAUSED || state == State.PLAYBACKCOMPLETED) {
            this.mVideoPlayer.stop();
            this.mCurState = State.STOPPED;
        }
    }
}
