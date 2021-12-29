package com.baidu.sdk.container.player;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import c.a.m0.a.j.e;
import c.a.m0.a.l.b;
import c.a.m0.a.l.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
/* loaded from: classes10.dex */
public class BaseMediaPlayer implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnSeekCompleteListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayer f39543e;

    /* renamed from: f  reason: collision with root package name */
    public Surface f39544f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceHolder f39545g;

    /* renamed from: h  reason: collision with root package name */
    public e f39546h;

    /* renamed from: i  reason: collision with root package name */
    public State f39547i;

    /* renamed from: j  reason: collision with root package name */
    public b f39548j;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-22464105, "Lcom/baidu/sdk/container/player/BaseMediaPlayer$State;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-22464105, "Lcom/baidu/sdk/container/player/BaseMediaPlayer$State;");
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
        this.f39548j = b.i();
        e();
    }

    public int a() {
        InterceptResult invokeV;
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            State state = this.f39547i;
            if ((state == State.IDLE || state == State.INITIALIZED || state == State.PREPARED || state == State.STARTED || state == State.PAUSED || state == State.STOPPED || state == State.PLAYBACKCOMPLETED) && (mediaPlayer = this.f39543e) != null) {
                return mediaPlayer.getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            State state = this.f39547i;
            if ((state == State.PREPARED || state == State.STARTED || state == State.PAUSED || state == State.STOPPED || state == State.PLAYBACKCOMPLETED) && (mediaPlayer = this.f39543e) != null) {
                return mediaPlayer.getDuration();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f39547i == State.ERROR || (mediaPlayer = this.f39543e) == null) {
                return 0;
            }
            return mediaPlayer.getVideoHeight();
        }
        return invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f39547i == State.ERROR || (mediaPlayer = this.f39543e) == null) {
                return 0;
            }
            return mediaPlayer.getVideoWidth();
        }
        return invokeV.intValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f39543e = mediaPlayer;
            this.f39547i = State.IDLE;
            mediaPlayer.setAudioStreamType(3);
            this.f39543e.setOnPreparedListener(this);
            this.f39543e.setOnCompletionListener(this);
            this.f39543e.setOnErrorListener(this);
            this.f39543e.setOnInfoListener(this);
            this.f39543e.setOnSeekCompleteListener(this);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                if ((this.f39547i == State.IDLE || this.f39547i == State.INITIALIZED || this.f39547i == State.PREPARED || this.f39547i == State.STARTED || this.f39547i == State.PAUSED || this.f39547i == State.STOPPED || this.f39547i == State.PLAYBACKCOMPLETED) && this.f39543e != null) {
                    return this.f39543e.isPlaying();
                }
                return false;
            } catch (Exception e2) {
                b bVar = this.f39548j;
                bVar.j("BaseMediaPlayer", "isPlaying异常" + e2.getMessage());
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final void g(int i2) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (eVar = this.f39546h) == null) {
            return;
        }
        eVar.a(i2);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b bVar = this.f39548j;
            bVar.j("BaseMediaPlayer", "pause=" + this.f39547i);
            if (this.f39543e != null) {
                State state = this.f39547i;
                if (state == State.STARTED || state == State.PLAYBACKCOMPLETED) {
                    this.f39543e.pause();
                    this.f39547i = State.PAUSED;
                }
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f39543e.prepareAsync();
            this.f39547i = State.PREPARING;
        }
    }

    public void j() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (mediaPlayer = this.f39543e) == null) {
            return;
        }
        mediaPlayer.release();
        this.f39547i = State.END;
        this.f39543e.setOnSeekCompleteListener(null);
        this.f39543e.setOnInfoListener(null);
        this.f39543e.setOnErrorListener(null);
        this.f39543e.setOnPreparedListener(null);
        this.f39543e.setOnCompletionListener(null);
    }

    public void k() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (mediaPlayer = this.f39543e) == null) {
            return;
        }
        this.f39547i = State.IDLE;
        mediaPlayer.reset();
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            State state = this.f39547i;
            if (state != State.PREPARED && state != State.STARTED && state != State.PAUSED && state != State.PLAYBACKCOMPLETED) {
                b bVar = this.f39548j;
                bVar.j("BaseMediaPlayer", "seekto不合法，mCurState=" + this.f39547i);
                return;
            }
            MediaPlayer mediaPlayer = this.f39543e;
            if (mediaPlayer != null) {
                try {
                    mediaPlayer.seekTo(i2);
                } catch (Exception e2) {
                    b bVar2 = this.f39548j;
                    bVar2.j("BaseMediaPlayer", "seekTo异常" + e2.getMessage());
                }
            }
        }
    }

    public void m(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, surfaceHolder) == null) {
            this.f39545g = surfaceHolder;
            MediaPlayer mediaPlayer = this.f39543e;
            if (mediaPlayer != null) {
                mediaPlayer.setDisplay(surfaceHolder);
                this.f39543e.setScreenOnWhilePlaying(true);
            }
        }
    }

    public void n(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) {
            this.f39546h = eVar;
        }
    }

    public void o(boolean z) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (mediaPlayer = this.f39543e) == null) {
            return;
        }
        mediaPlayer.setScreenOnWhilePlaying(z);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, mediaPlayer) == null) {
            b bVar = this.f39548j;
            bVar.j("BaseMediaPlayer", "onCompletion" + this.f39547i);
            this.f39547i = State.PLAYBACKCOMPLETED;
            g(256);
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048592, this, mediaPlayer, i2, i3)) == null) {
            b bVar = this.f39548j;
            bVar.j("BaseMediaPlayer", "onError" + this.f39547i);
            this.f39547i = State.ERROR;
            g(257);
            return true;
        }
        return invokeLII.booleanValue;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048593, this, mediaPlayer, i2, i3)) == null) {
            if (i2 == 3) {
                g(260);
                return false;
            } else if (i2 == 701) {
                g(w0.F);
                return false;
            } else if (i2 != 702) {
                return false;
            } else {
                g(262);
                return false;
            }
        }
        return invokeLII.booleanValue;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, mediaPlayer) == null) {
            this.f39547i = State.PREPARED;
            g(258);
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, mediaPlayer) == null) {
            g(259);
        }
    }

    public void p(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, surface) == null) {
            this.f39544f = surface;
            MediaPlayer mediaPlayer = this.f39543e;
            if (mediaPlayer != null) {
                mediaPlayer.setSurface(surface);
            }
        }
    }

    public void q(String str) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, str) == null) || (mediaPlayer = this.f39543e) == null) {
            return;
        }
        try {
            mediaPlayer.setDataSource(str);
            this.f39547i = State.INITIALIZED;
            i();
        } catch (Exception e2) {
            b bVar = this.f39548j;
            bVar.j("BaseMediaPlayer", "setVideoPath异常" + e2.getMessage());
        }
    }

    public void r(float f2, float f3) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || this.f39547i == State.ERROR || (mediaPlayer = this.f39543e) == null) {
            return;
        }
        mediaPlayer.setVolume(f2, f3);
    }

    public void s(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048599, this, context, i2) == null) || this.f39543e == null || context == null || !f.a(context, "android.permission.WAKE_LOCK")) {
            return;
        }
        this.f39543e.setWakeMode(context.getApplicationContext(), i2);
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            b bVar = this.f39548j;
            bVar.j("BaseMediaPlayer", "start=" + this.f39547i);
            if (this.f39543e != null) {
                State state = this.f39547i;
                if (state == State.PREPARED || state == State.PAUSED || state == State.PLAYBACKCOMPLETED) {
                    this.f39543e.start();
                    this.f39547i = State.STARTED;
                }
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || this.f39543e == null) {
            return;
        }
        State state = this.f39547i;
        if (state == State.STARTED || state == State.PREPARED || state == State.PAUSED || state == State.PLAYBACKCOMPLETED) {
            this.f39543e.stop();
            this.f39547i = State.STOPPED;
        }
    }
}
