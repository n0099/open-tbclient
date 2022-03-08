package com.baidu.nadcore.player;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.i.a;
import c.a.b0.v.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
import java.io.IOException;
import java.net.HttpCookie;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class SysMediaPlayer implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final MediaPlayer f35673e;

    /* renamed from: f  reason: collision with root package name */
    public o f35674f;

    /* renamed from: g  reason: collision with root package name */
    public State f35675g;

    /* renamed from: h  reason: collision with root package name */
    public MediaPlayer.OnPreparedListener f35676h;

    /* renamed from: i  reason: collision with root package name */
    public MediaPlayer.OnVideoSizeChangedListener f35677i;

    /* renamed from: j  reason: collision with root package name */
    public MediaPlayer.OnCompletionListener f35678j;
    public MediaPlayer.OnSeekCompleteListener k;
    public MediaPlayer.OnBufferingUpdateListener l;
    public MediaPlayer.OnErrorListener m;
    public MediaPlayer.OnInfoListener n;
    public final Context o;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1614821899, "Lcom/baidu/nadcore/player/SysMediaPlayer$State;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1614821899, "Lcom/baidu/nadcore/player/SysMediaPlayer$State;");
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

    public SysMediaPlayer(Context context) {
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
        this.o = context;
        this.f35673e = new MediaPlayer();
        e();
    }

    public void A(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, context, i2) == null) {
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a.e("MediaPlayer", "start=" + this.f35675g);
            State state = this.f35675g;
            if (state == State.PREPARED || state == State.PAUSED || state == State.PLAYBACKCOMPLETED) {
                this.f35673e.start();
                this.f35675g = State.STARTED;
            }
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            State state = this.f35675g;
            if (state == State.STARTED || state == State.PREPARED || state == State.PAUSED || state == State.PLAYBACKCOMPLETED) {
                this.f35673e.stop();
                this.f35675g = State.STOPPED;
            }
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            State state = this.f35675g;
            if (state == State.IDLE || state == State.INITIALIZED || state == State.PREPARED || state == State.STARTED || state == State.PAUSED || state == State.STOPPED || state == State.PLAYBACKCOMPLETED) {
                return this.f35673e.getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            State state = this.f35675g;
            if (state == State.PREPARED || state == State.STARTED || state == State.PAUSED || state == State.STOPPED || state == State.PLAYBACKCOMPLETED) {
                return this.f35673e.getDuration();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f35675g == State.ERROR) {
                return 0;
            }
            return this.f35673e.getVideoHeight();
        }
        return invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f35675g == State.ERROR) {
                return 0;
            }
            return this.f35673e.getVideoWidth();
        }
        return invokeV.intValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f35675g = State.IDLE;
            this.f35673e.setAudioStreamType(3);
            this.f35673e.setOnPreparedListener(this);
            this.f35673e.setOnCompletionListener(this);
            this.f35673e.setOnVideoSizeChangedListener(this);
            this.f35673e.setOnBufferingUpdateListener(this);
            this.f35673e.setOnSeekCompleteListener(this);
            this.f35673e.setOnErrorListener(this);
            this.f35673e.setOnInfoListener(this);
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                this.f35673e.setVolume(0.0f, 0.0f);
            } else {
                this.f35673e.setVolume(1.0f, 1.0f);
            }
        }
    }

    public final void g(int i2) {
        o oVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (oVar = this.f35674f) == null) {
            return;
        }
        oVar.a(i2);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            a.e("MediaPlayer", "pause=" + this.f35675g);
            State state = this.f35675g;
            if (state == State.STARTED || state == State.PLAYBACKCOMPLETED) {
                this.f35673e.pause();
                this.f35675g = State.PAUSED;
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f35673e.prepareAsync();
            this.f35675g = State.PREPARING;
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f35675g = State.IDLE;
            this.f35673e.reset();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            B();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0044 -> B:25:0x005c). Please submit an issue!!! */
    public void l(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i2, i3) == null) {
            State state = this.f35675g;
            if (state != State.PREPARED && state != State.STARTED && state != State.PAUSED && state != State.PLAYBACKCOMPLETED) {
                a.e("MediaPlayer", "seekto不合法，mCurState=" + this.f35675g);
                return;
            }
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f35673e.seekTo(i2, i3);
                } else {
                    this.f35673e.seekTo(i2);
                }
            } catch (Exception e2) {
                a.e("MediaPlayer", "seekTo异常" + e2.getMessage());
            }
        }
    }

    public void m(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, map) == null) {
            n(str, map, null);
        }
    }

    public void n(@NonNull String str, @Nullable Map<String, String> map, @Nullable List<HttpCookie> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, str, map, list) == null) {
            try {
                this.f35673e.reset();
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f35673e.setDataSource(this.o, Uri.parse(str), map, list);
                } else {
                    this.f35673e.setDataSource(this.o, Uri.parse(str), map);
                }
                this.f35675g = State.INITIALIZED;
                i();
            } catch (IOException e2) {
                a.e("MediaPlayer", "setVideoPath异常" + e2.getMessage());
            }
        }
    }

    public void o(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, surfaceHolder) == null) {
            this.f35673e.setDisplay(surfaceHolder);
            this.f35673e.setScreenOnWhilePlaying(true);
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
        MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048594, this, mediaPlayer, i2) == null) || (onBufferingUpdateListener = this.l) == null) {
            return;
        }
        onBufferingUpdateListener.onBufferingUpdate(mediaPlayer, i2);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, mediaPlayer) == null) {
            a.e("MediaPlayer", "onCompletion" + this.f35675g);
            this.f35675g = State.PLAYBACKCOMPLETED;
            g(256);
            MediaPlayer.OnCompletionListener onCompletionListener = this.f35678j;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion(mediaPlayer);
            }
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048596, this, mediaPlayer, i2, i3)) == null) {
            a.e("MediaPlayer", "onError" + this.f35675g);
            this.f35675g = State.ERROR;
            g(257);
            MediaPlayer.OnErrorListener onErrorListener = this.m;
            if (onErrorListener != null) {
                onErrorListener.onError(mediaPlayer, i2, i3);
                return true;
            }
            return true;
        }
        return invokeLII.booleanValue;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048597, this, mediaPlayer, i2, i3)) == null) {
            if (i2 == 3) {
                g(260);
            } else if (i2 == 701) {
                g(w0.F);
            } else if (i2 == 702) {
                g(262);
            }
            MediaPlayer.OnInfoListener onInfoListener = this.n;
            if (onInfoListener != null) {
                onInfoListener.onInfo(mediaPlayer, i2, i3);
                return false;
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, mediaPlayer) == null) {
            this.f35675g = State.PREPARED;
            g(258);
            MediaPlayer.OnPreparedListener onPreparedListener = this.f35676h;
            if (onPreparedListener != null) {
                onPreparedListener.onPrepared(mediaPlayer);
            }
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, mediaPlayer) == null) {
            g(259);
            MediaPlayer.OnSeekCompleteListener onSeekCompleteListener = this.k;
            if (onSeekCompleteListener != null) {
                onSeekCompleteListener.onSeekComplete(mediaPlayer);
            }
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
        MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048600, this, mediaPlayer, i2, i3) == null) || (onVideoSizeChangedListener = this.f35677i) == null) {
            return;
        }
        onVideoSizeChangedListener.onVideoSizeChanged(mediaPlayer, i2, i3);
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.f35673e.setLooping(z);
        }
    }

    public void q(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, onBufferingUpdateListener) == null) {
            this.l = onBufferingUpdateListener;
        }
    }

    public void r(MediaPlayer.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onCompletionListener) == null) {
            this.f35678j = onCompletionListener;
        }
    }

    public void s(MediaPlayer.OnErrorListener onErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, onErrorListener) == null) {
            this.m = onErrorListener;
        }
    }

    public void t(MediaPlayer.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onInfoListener) == null) {
            this.n = onInfoListener;
        }
    }

    public void u(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, oVar) == null) {
            this.f35674f = oVar;
        }
    }

    public void v(MediaPlayer.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, onPreparedListener) == null) {
            this.f35676h = onPreparedListener;
        }
    }

    public void w(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onSeekCompleteListener) == null) {
            this.k = onSeekCompleteListener;
        }
    }

    public void x(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, onVideoSizeChangedListener) == null) {
            this.f35677i = onVideoSizeChangedListener;
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.f35673e.setScreenOnWhilePlaying(z);
        }
    }

    public void z(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, surface) == null) {
            this.f35673e.setSurface(surface);
        }
    }
}
