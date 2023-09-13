package com.baidu.sdk.container.player;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b71;
import com.baidu.tieba.em1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.titan.sdk.verifier.ApkSignatureSchemeV2Verifier;
/* loaded from: classes3.dex */
public class BaseMediaPlayer implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnSeekCompleteListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaPlayer a;
    public Surface b;
    public SurfaceHolder c;
    public em1 d;
    public State e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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

        public State(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (State) Enum.valueOf(State.class, str);
            }
            return (State) invokeL.objValue;
        }

        public static State[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (State[]) $VALUES.clone();
            }
            return (State[]) invokeV.objValue;
        }
    }

    public BaseMediaPlayer(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        e();
    }

    public final void f(int i) {
        em1 em1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (em1Var = this.d) != null) {
            em1Var.a(i);
        }
    }

    public void k(int i) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            State state = this.e;
            if ((state == State.PREPARED || state == State.STARTED || state == State.PAUSED || state == State.PLAYBACKCOMPLETED) && (mediaPlayer = this.a) != null) {
                try {
                    mediaPlayer.seekTo(i);
                } catch (Exception unused) {
                }
            }
        }
    }

    public void l(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, surfaceHolder) == null) {
            this.c = surfaceHolder;
            MediaPlayer mediaPlayer = this.a;
            if (mediaPlayer != null) {
                mediaPlayer.setDisplay(surfaceHolder);
                this.a.setScreenOnWhilePlaying(true);
            }
        }
    }

    public void m(em1 em1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, em1Var) == null) {
            this.d = em1Var;
        }
    }

    public void n(boolean z) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (mediaPlayer = this.a) != null) {
            mediaPlayer.setScreenOnWhilePlaying(z);
        }
    }

    public void o(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, surface) == null) {
            this.b = surface;
            MediaPlayer mediaPlayer = this.a;
            if (mediaPlayer != null) {
                mediaPlayer.setSurface(surface);
            }
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, mediaPlayer) == null) {
            this.e = State.PLAYBACKCOMPLETED;
            f(256);
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, mediaPlayer) == null) {
            this.e = State.PREPARED;
            f(ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PSS_WITH_SHA512);
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, mediaPlayer) == null) {
            Log.e("AdVideoView", "onSeekComplete");
            f(ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256);
        }
    }

    public void p(String str) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, str) == null) && (mediaPlayer = this.a) != null) {
            try {
                mediaPlayer.setDataSource(str);
                this.e = State.INITIALIZED;
                h();
            } catch (Exception unused) {
            }
        }
    }

    public int a() {
        InterceptResult invokeV;
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            State state = this.e;
            if ((state == State.IDLE || state == State.INITIALIZED || state == State.PREPARED || state == State.STARTED || state == State.PAUSED || state == State.STOPPED || state == State.PLAYBACKCOMPLETED) && (mediaPlayer = this.a) != null) {
                return mediaPlayer.getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.a = mediaPlayer;
            this.e = State.IDLE;
            mediaPlayer.setAudioStreamType(3);
            this.a.setOnPreparedListener(this);
            this.a.setOnCompletionListener(this);
            this.a.setOnErrorListener(this);
            this.a.setOnInfoListener(this);
            this.a.setOnSeekCompleteListener(this);
        }
    }

    public void i() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (mediaPlayer = this.a) != null) {
            mediaPlayer.release();
            this.e = State.END;
            this.a.setOnSeekCompleteListener(null);
            this.a.setOnInfoListener(null);
            this.a.setOnErrorListener(null);
            this.a.setOnPreparedListener(null);
            this.a.setOnCompletionListener(null);
        }
    }

    public int b() {
        InterceptResult invokeV;
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            State state = this.e;
            if ((state == State.PREPARED || state == State.STARTED || state == State.PAUSED || state == State.STOPPED || state == State.PLAYBACKCOMPLETED) && (mediaPlayer = this.a) != null) {
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
            if (this.e == State.ERROR || (mediaPlayer = this.a) == null) {
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
            if (this.e == State.ERROR || (mediaPlayer = this.a) == null) {
                return 0;
            }
            return mediaPlayer.getVideoWidth();
        }
        return invokeV.intValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.a != null) {
            State state = this.e;
            if (state == State.STARTED || state == State.PLAYBACKCOMPLETED) {
                this.a.pause();
                this.e = State.PAUSED;
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.prepareAsync();
            this.e = State.PREPARING;
        }
    }

    public void j() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (mediaPlayer = this.a) != null) {
            this.e = State.IDLE;
            mediaPlayer.reset();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.a != null) {
            State state = this.e;
            if (state == State.PREPARED || state == State.PAUSED || state == State.PLAYBACKCOMPLETED) {
                this.a.start();
                this.e = State.STARTED;
            }
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.a != null) {
            State state = this.e;
            if (state == State.STARTED || state == State.PREPARED || state == State.PAUSED || state == State.PLAYBACKCOMPLETED) {
                this.a.stop();
                this.e = State.STOPPED;
            }
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048592, this, mediaPlayer, i, i2)) == null) {
            this.e = State.ERROR;
            f(257);
            return true;
        }
        return invokeLII.booleanValue;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048593, this, mediaPlayer, i, i2)) == null) {
            if (i != 3) {
                if (i != 701) {
                    if (i == 702) {
                        f(262);
                        return false;
                    }
                    return false;
                }
                f(261);
                return false;
            }
            f(260);
            return false;
        }
        return invokeLII.booleanValue;
    }

    public void q(float f, float f2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) && this.e != State.ERROR && (mediaPlayer = this.a) != null) {
            mediaPlayer.setVolume(f, f2);
        }
    }

    public void r(Context context, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048598, this, context, i) == null) && this.a != null && context != null && b71.a(context, "android.permission.WAKE_LOCK")) {
            this.a.setWakeMode(context.getApplicationContext(), i);
        }
    }
}
