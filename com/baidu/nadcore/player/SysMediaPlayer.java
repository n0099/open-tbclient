package com.baidu.nadcore.player;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.i.a;
import c.a.a0.v.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.titan.sdk.verifier.ApkSignatureSchemeV2Verifier;
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
    public final MediaPlayer a;

    /* renamed from: b  reason: collision with root package name */
    public o f27552b;

    /* renamed from: c  reason: collision with root package name */
    public State f27553c;

    /* renamed from: d  reason: collision with root package name */
    public MediaPlayer.OnPreparedListener f27554d;

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayer.OnVideoSizeChangedListener f27555e;

    /* renamed from: f  reason: collision with root package name */
    public MediaPlayer.OnCompletionListener f27556f;

    /* renamed from: g  reason: collision with root package name */
    public MediaPlayer.OnSeekCompleteListener f27557g;

    /* renamed from: h  reason: collision with root package name */
    public MediaPlayer.OnBufferingUpdateListener f27558h;
    public MediaPlayer.OnErrorListener i;
    public MediaPlayer.OnInfoListener j;
    public final Context k;

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = context;
        this.a = new MediaPlayer();
        e();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a.e("MediaPlayer", "start=" + this.f27553c);
            State state = this.f27553c;
            if (state == State.PREPARED || state == State.PAUSED || state == State.PLAYBACKCOMPLETED) {
                this.a.start();
                this.f27553c = State.STARTED;
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            State state = this.f27553c;
            if (state == State.STARTED || state == State.PREPARED || state == State.PAUSED || state == State.PLAYBACKCOMPLETED) {
                this.a.stop();
                this.f27553c = State.STOPPED;
            }
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            State state = this.f27553c;
            if (state == State.IDLE || state == State.INITIALIZED || state == State.PREPARED || state == State.STARTED || state == State.PAUSED || state == State.STOPPED || state == State.PLAYBACKCOMPLETED) {
                return this.a.getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            State state = this.f27553c;
            if (state == State.PREPARED || state == State.STARTED || state == State.PAUSED || state == State.STOPPED || state == State.PLAYBACKCOMPLETED) {
                return this.a.getDuration();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f27553c == State.ERROR) {
                return 0;
            }
            return this.a.getVideoHeight();
        }
        return invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f27553c == State.ERROR) {
                return 0;
            }
            return this.a.getVideoWidth();
        }
        return invokeV.intValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f27553c = State.IDLE;
            this.a.setAudioStreamType(3);
            this.a.setOnPreparedListener(this);
            this.a.setOnCompletionListener(this);
            this.a.setOnVideoSizeChangedListener(this);
            this.a.setOnBufferingUpdateListener(this);
            this.a.setOnSeekCompleteListener(this);
            this.a.setOnErrorListener(this);
            this.a.setOnInfoListener(this);
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                this.a.setVolume(0.0f, 0.0f);
            } else {
                this.a.setVolume(1.0f, 1.0f);
            }
        }
    }

    public final void g(int i) {
        o oVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || (oVar = this.f27552b) == null) {
            return;
        }
        oVar.a(i);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            a.e("MediaPlayer", "pause=" + this.f27553c);
            State state = this.f27553c;
            if (state == State.STARTED || state == State.PLAYBACKCOMPLETED) {
                this.a.pause();
                this.f27553c = State.PAUSED;
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.a.prepareAsync();
            this.f27553c = State.PREPARING;
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f27553c = State.IDLE;
            this.a.reset();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0044 -> B:25:0x005c). Please submit an issue!!! */
    public void k(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) {
            State state = this.f27553c;
            if (state != State.PREPARED && state != State.STARTED && state != State.PAUSED && state != State.PLAYBACKCOMPLETED) {
                a.e("MediaPlayer", "seekto不合法，mCurState=" + this.f27553c);
                return;
            }
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    this.a.seekTo(i, i2);
                } else {
                    this.a.seekTo(i);
                }
            } catch (Exception e2) {
                a.e("MediaPlayer", "seekTo异常" + e2.getMessage());
            }
        }
    }

    public void l(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, map) == null) {
            m(str, map, null);
        }
    }

    public void m(@NonNull String str, @Nullable Map<String, String> map, @Nullable List<HttpCookie> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, str, map, list) == null) {
            try {
                this.a.reset();
                if (Build.VERSION.SDK_INT >= 26) {
                    this.a.setDataSource(this.k, Uri.parse(str), map, list);
                } else {
                    this.a.setDataSource(this.k, Uri.parse(str), map);
                }
                this.f27553c = State.INITIALIZED;
                i();
            } catch (IOException e2) {
                a.e("MediaPlayer", "setVideoPath异常" + e2.getMessage());
            }
        }
    }

    public void n(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, surfaceHolder) == null) {
            this.a.setDisplay(surfaceHolder);
            this.a.setScreenOnWhilePlaying(true);
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.a.setLooping(z);
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048593, this, mediaPlayer, i) == null) || (onBufferingUpdateListener = this.f27558h) == null) {
            return;
        }
        onBufferingUpdateListener.onBufferingUpdate(mediaPlayer, i);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, mediaPlayer) == null) {
            a.e("MediaPlayer", "onCompletion" + this.f27553c);
            this.f27553c = State.PLAYBACKCOMPLETED;
            g(256);
            MediaPlayer.OnCompletionListener onCompletionListener = this.f27556f;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion(mediaPlayer);
            }
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048595, this, mediaPlayer, i, i2)) == null) {
            a.e("MediaPlayer", "onError" + this.f27553c);
            this.f27553c = State.ERROR;
            g(257);
            MediaPlayer.OnErrorListener onErrorListener = this.i;
            if (onErrorListener != null) {
                onErrorListener.onError(mediaPlayer, i, i2);
                return true;
            }
            return true;
        }
        return invokeLII.booleanValue;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048596, this, mediaPlayer, i, i2)) == null) {
            if (i == 3) {
                g(260);
            } else if (i == 701) {
                g(w0.F);
            } else if (i == 702) {
                g(262);
            }
            MediaPlayer.OnInfoListener onInfoListener = this.j;
            if (onInfoListener != null) {
                onInfoListener.onInfo(mediaPlayer, i, i2);
                return false;
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, mediaPlayer) == null) {
            this.f27553c = State.PREPARED;
            g(ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PSS_WITH_SHA512);
            MediaPlayer.OnPreparedListener onPreparedListener = this.f27554d;
            if (onPreparedListener != null) {
                onPreparedListener.onPrepared(mediaPlayer);
            }
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, mediaPlayer) == null) {
            Log.e("AdVideoView", "onSeekComplete");
            g(ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256);
            MediaPlayer.OnSeekCompleteListener onSeekCompleteListener = this.f27557g;
            if (onSeekCompleteListener != null) {
                onSeekCompleteListener.onSeekComplete(mediaPlayer);
            }
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048599, this, mediaPlayer, i, i2) == null) || (onVideoSizeChangedListener = this.f27555e) == null) {
            return;
        }
        onVideoSizeChangedListener.onVideoSizeChanged(mediaPlayer, i, i2);
    }

    public void p(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onBufferingUpdateListener) == null) {
            this.f27558h = onBufferingUpdateListener;
        }
    }

    public void q(MediaPlayer.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onCompletionListener) == null) {
            this.f27556f = onCompletionListener;
        }
    }

    public void r(MediaPlayer.OnErrorListener onErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, onErrorListener) == null) {
            this.i = onErrorListener;
        }
    }

    public void s(MediaPlayer.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onInfoListener) == null) {
            this.j = onInfoListener;
        }
    }

    public void t(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, oVar) == null) {
            this.f27552b = oVar;
        }
    }

    public void u(MediaPlayer.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onPreparedListener) == null) {
            this.f27554d = onPreparedListener;
        }
    }

    public void v(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, onSeekCompleteListener) == null) {
            this.f27557g = onSeekCompleteListener;
        }
    }

    public void w(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, onVideoSizeChangedListener) == null) {
            this.f27555e = onVideoSizeChangedListener;
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.a.setScreenOnWhilePlaying(z);
        }
    }

    public void y(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, surface) == null) {
            this.a.setSurface(surface);
        }
    }

    public void z(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048610, this, context, i) == null) {
        }
    }
}
