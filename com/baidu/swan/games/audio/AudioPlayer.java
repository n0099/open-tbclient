package com.baidu.swan.games.audio;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.g1.f;
import c.a.o0.a.h0.g.g;
import c.a.o0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.info.XDeviceInfo;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.base.LightappConstants;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AudioPlayer implements c.a.o0.a.i1.a, c.a.o0.l.a.c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.o0.a.i1.c.e.a f46887a;

    /* renamed from: b  reason: collision with root package name */
    public PlayerStatus f46888b;

    /* renamed from: c  reason: collision with root package name */
    public UserStatus f46889c;

    /* renamed from: d  reason: collision with root package name */
    public String f46890d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.h.c.j.c f46891e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.o0.h.c.d f46892f;

    /* renamed from: g  reason: collision with root package name */
    public e f46893g;

    /* renamed from: h  reason: collision with root package name */
    public int f46894h;

    /* renamed from: i  reason: collision with root package name */
    public String f46895i;

    /* renamed from: j  reason: collision with root package name */
    public String f46896j;
    public d k;
    public float l;
    public boolean m;
    public long n;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class PlayerStatus {
        public static final /* synthetic */ PlayerStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final PlayerStatus IDLE;
        public static final PlayerStatus NONE;
        public static final PlayerStatus PREPARED;
        public static final PlayerStatus PREPARING;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-210795548, "Lcom/baidu/swan/games/audio/AudioPlayer$PlayerStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-210795548, "Lcom/baidu/swan/games/audio/AudioPlayer$PlayerStatus;");
                    return;
                }
            }
            NONE = new PlayerStatus("NONE", 0);
            IDLE = new PlayerStatus("IDLE", 1);
            PREPARING = new PlayerStatus("PREPARING", 2);
            PlayerStatus playerStatus = new PlayerStatus("PREPARED", 3);
            PREPARED = playerStatus;
            $VALUES = new PlayerStatus[]{NONE, IDLE, PREPARING, playerStatus};
        }

        public PlayerStatus(String str, int i2) {
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

        public static PlayerStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PlayerStatus) Enum.valueOf(PlayerStatus.class, str) : (PlayerStatus) invokeL.objValue;
        }

        public static PlayerStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PlayerStatus[]) $VALUES.clone() : (PlayerStatus[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class UserStatus {
        public static final /* synthetic */ UserStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final UserStatus DESTROY;
        public static final UserStatus OPEN;
        public static final UserStatus PAUSE;
        public static final UserStatus PLAY;
        public static final UserStatus STOP;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-345250118, "Lcom/baidu/swan/games/audio/AudioPlayer$UserStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-345250118, "Lcom/baidu/swan/games/audio/AudioPlayer$UserStatus;");
                    return;
                }
            }
            OPEN = new UserStatus("OPEN", 0);
            PLAY = new UserStatus("PLAY", 1);
            PAUSE = new UserStatus(XDeviceInfo.ABILITY_PAUSE, 2);
            STOP = new UserStatus("STOP", 3);
            UserStatus userStatus = new UserStatus("DESTROY", 4);
            DESTROY = userStatus;
            $VALUES = new UserStatus[]{OPEN, PLAY, PAUSE, STOP, userStatus};
        }

        public UserStatus(String str, int i2) {
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

        public static UserStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (UserStatus) Enum.valueOf(UserStatus.class, str) : (UserStatus) invokeL.objValue;
        }

        public static UserStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (UserStatus[]) $VALUES.clone() : (UserStatus[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class a implements TypedCallbackHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AudioPlayer f46897e;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f46898e;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f46898e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f46898e.f46897e.P();
                }
            }
        }

        public b(AudioPlayer audioPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {audioPlayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46897e = audioPlayer;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.o0.h.c.j.b.h().e().post(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements c.a.o0.h.c.i.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AudioPlayer f46899a;

        public c(AudioPlayer audioPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {audioPlayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46899a = audioPlayer;
        }

        @Override // c.a.o0.h.c.i.a
        public void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
                this.f46899a.f46896j = str2;
                this.f46899a.w();
            }
        }

        @Override // c.a.o0.h.c.i.a
        public void fail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f46899a.L(!SwanAppNetworkUtils.i(null) ? LightappConstants.ERRCODE_INNER_ERROR : LightappConstants.ERRCODE_NO_PERMISSION);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnInfoListener, MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnBufferingUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AudioPlayer f46900e;

        public d(AudioPlayer audioPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {audioPlayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46900e = audioPlayer;
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, mediaPlayer, i2) == null) {
                try {
                    if (AudioPlayer.o) {
                        String str = "onBufferUpdate : " + i2 + "%";
                    }
                    if (this.f46900e.H()) {
                        this.f46900e.f46894h = (((int) this.f46900e.A()) * i2) / 100;
                        if (this.f46900e.f46887a != null) {
                            this.f46900e.J("onBufferingUpdate");
                            if (this.f46900e.f46888b != PlayerStatus.PREPARED || this.f46900e.f46889c == UserStatus.STOP || (i2 * this.f46900e.A()) / 100 > this.f46900e.z()) {
                                return;
                            }
                            this.f46900e.J("onWaiting");
                        }
                    }
                } catch (Exception e2) {
                    if (AudioPlayer.o) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaPlayer) == null) {
                boolean unused = AudioPlayer.o;
                try {
                    if (!this.f46900e.f46892f.f11011f) {
                        this.f46900e.f46889c = UserStatus.STOP;
                        this.f46900e.F();
                    }
                    this.f46900e.J("onEnded");
                } catch (Exception e2) {
                    if (AudioPlayer.o) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, mediaPlayer, i2, i3)) == null) {
                if (AudioPlayer.o) {
                    String str = "onError : what is " + i2 + " extra is " + i3;
                    String str2 = "Audio Error = " + i2 + "playerId = " + this.f46900e.f46892f.f11006a + " url = " + this.f46900e.f46892f.f11008c;
                }
                String str3 = "-1";
                if (i2 != 1 && i2 == 100) {
                    str3 = LightappConstants.ERRCODE_INVALID_PARAMETER;
                }
                if (i3 == -1007) {
                    str3 = "10004";
                }
                this.f46900e.L(str3);
                this.f46900e.F();
                return true;
            }
            return invokeLII.booleanValue;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, mediaPlayer, i2, i3)) == null) {
                if (AudioPlayer.o) {
                    String str = "oninfo : what is " + i2 + " extra is " + i3;
                    return false;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, mediaPlayer) == null) {
                boolean unused = AudioPlayer.o;
                AudioPlayer audioPlayer = this.f46900e;
                audioPlayer.f46888b = PlayerStatus.PREPARED;
                if (!audioPlayer.m) {
                    this.f46900e.J("onCanplay");
                }
                if (AudioPlayer.o) {
                    String str = "prepare 2 path: " + this.f46900e.f46896j;
                }
                this.f46900e.m = true;
                UserStatus userStatus = UserStatus.PLAY;
                AudioPlayer audioPlayer2 = this.f46900e;
                if (userStatus == audioPlayer2.f46889c) {
                    audioPlayer2.Q();
                }
                try {
                    if (this.f46900e.f46892f.f11009d > 0.0f) {
                        this.f46900e.B().seek(this.f46900e.f46892f.f11009d);
                    } else if (this.f46900e.l >= 0.0f) {
                        this.f46900e.B().seek(this.f46900e.l);
                        this.f46900e.l = -1.0f;
                    }
                } catch (Exception e2) {
                    if (AudioPlayer.o) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, mediaPlayer) == null) {
                boolean unused = AudioPlayer.o;
                this.f46900e.J("onSeeked");
            }
        }

        public /* synthetic */ d(AudioPlayer audioPlayer, a aVar) {
            this(audioPlayer);
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes6.dex */
    public class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AudioPlayer f46901a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AudioPlayer audioPlayer) {
            super(c.a.o0.h.c.j.b.h().e().getLooper());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {audioPlayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46901a = audioPlayer;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0 && this.f46901a.f46888b == PlayerStatus.PREPARED) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Double.valueOf(this.f46901a.z() / 1000.0d));
                    jSONObject.putOpt("duration", Long.valueOf(this.f46901a.A() / 1000));
                    this.f46901a.K("onTimeUpdate", jSONObject);
                } catch (Exception e2) {
                    if (AudioPlayer.o) {
                        e2.printStackTrace();
                    }
                }
                sendEmptyMessageDelayed(0, 1000L);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-130622725, "Lcom/baidu/swan/games/audio/AudioPlayer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-130622725, "Lcom/baidu/swan/games/audio/AudioPlayer;");
                return;
            }
        }
        o = k.f7049a;
    }

    public AudioPlayer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f46888b = PlayerStatus.NONE;
        this.f46889c = UserStatus.OPEN;
        this.f46890d = "";
        this.f46892f = new c.a.o0.h.c.d();
        this.f46893g = new e(this);
        this.l = -1.0f;
        this.f46890d = str;
    }

    public long A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                if (0 == this.n && this.f46891e != null) {
                    return this.f46891e.getDuration();
                }
            } catch (Exception e2) {
                if (o) {
                    e2.printStackTrace();
                }
            }
            return this.n;
        }
        return invokeV.longValue;
    }

    public c.a.o0.h.c.j.c B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.o0.h.c.j.c cVar = this.f46891e;
            if (cVar == null || cVar.s()) {
                this.f46891e = c.a.o0.h.c.j.b.h().d(this.f46896j, this.f46892f.f11011f);
                S();
            }
            return this.f46891e;
        }
        return (c.a.o0.h.c.j.c) invokeV.objValue;
    }

    public final c.a.o0.a.l0.a C() {
        InterceptResult invokeV;
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.o0.a.a2.e i2 = c.a.o0.a.a2.e.i();
            if (i2 == null || !i2.m0() || (x = i2.x()) == null) {
                return null;
            }
            c.a.o0.a.t0.c frame = x.getFrame();
            if (frame instanceof c.a.o0.h.o.d) {
                return ((c.a.o0.h.o.d) frame).X0();
            }
            return null;
        }
        return (c.a.o0.a.l0.a) invokeV.objValue;
    }

    public float D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.o0.h.c.d dVar = this.f46892f;
            if (dVar != null) {
                return dVar.f11014i;
            }
            return 1.0f;
        }
        return invokeV.floatValue;
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            J(MissionEvent.MESSAGE_PAUSE);
            this.f46893g.removeMessages(0);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f46888b = PlayerStatus.IDLE;
            c.a.o0.h.c.j.c cVar = this.f46891e;
            if (cVar != null) {
                cVar.destroy();
                this.f46891e = null;
            }
            this.f46893g.removeMessages(0);
        }
    }

    public final boolean G() {
        InterceptResult invokeV;
        c.a.o0.a.h0.g.d m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (c.a.o0.a.a2.e.i() == null || !c.a.o0.a.a2.e.i().m0()) {
                return false;
            }
            g W = f.V().W();
            if (W == null || (m = W.m()) == null || !(m instanceof c.a.o0.h.n.a)) {
                return true;
            }
            return ((c.a.o0.h.n.a) m).n3();
        }
        return invokeV.booleanValue;
    }

    public final boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f46891e != null && this.f46888b == PlayerStatus.PREPARED : invokeV.booleanValue;
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            UserStatus userStatus = UserStatus.STOP;
            UserStatus userStatus2 = this.f46889c;
            return (userStatus == userStatus2 || UserStatus.DESTROY == userStatus2) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            K(str, null);
        }
    }

    public final void K(String str, JSONObject jSONObject) {
        c.a.o0.a.i1.c.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, str, jSONObject) == null) || (aVar = this.f46887a) == null) {
            return;
        }
        aVar.b(str, jSONObject);
    }

    public final void L(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || this.f46887a == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("errCode", str);
        } catch (JSONException e2) {
            if (o) {
                Log.getStackTraceString(e2);
            }
        }
        this.f46887a.b("onError", jSONObject);
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            try {
                if (this.f46895i.contains("http")) {
                    c.a.o0.h.c.j.b h2 = c.a.o0.h.c.j.b.h();
                    File file = new File(h2.g(this.f46895i));
                    if (file.exists() && !file.isDirectory()) {
                        this.f46896j = file.getAbsolutePath();
                        w();
                        return;
                    }
                    h2.j(this.f46895i, new c(this));
                    return;
                }
                this.f46896j = this.f46895i;
                w();
            } catch (Exception e2) {
                if (o) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void N(c.a.o0.h.c.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            boolean z = o;
            if (this.f46891e != null) {
                F();
            }
            this.f46889c = UserStatus.OPEN;
            this.f46892f = dVar;
            this.f46894h = 0;
            this.f46895i = f.V().I().a(this.f46892f.f11008c);
            this.f46888b = PlayerStatus.IDLE;
            J("onWaiting");
            M();
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f46889c = UserStatus.PAUSE;
            P();
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && H()) {
            this.f46891e.pause();
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f46889c = UserStatus.PLAY;
            if (this.m) {
                try {
                    if (!G() && x()) {
                        if (o) {
                            String str = "play music first: " + this.f46896j;
                        }
                        if (this.f46888b == PlayerStatus.PREPARED) {
                            this.f46893g.sendEmptyMessage(0);
                            a0();
                            if (o) {
                                String str2 = "play music: " + this.f46896j;
                            }
                            B().play();
                            J("onPlay");
                        } else if (this.f46888b == PlayerStatus.IDLE) {
                            try {
                                B().d(this.f46896j);
                                this.f46888b = PlayerStatus.PREPARING;
                            } catch (Exception e2) {
                                if (o) {
                                    e2.printStackTrace();
                                }
                                L(!SwanAppNetworkUtils.i(null) ? LightappConstants.ERRCODE_INNER_ERROR : LightappConstants.ERRCODE_NO_PERMISSION);
                            }
                        }
                    }
                } catch (Exception e3) {
                    if (o) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            try {
                File file = new File(this.f46896j);
                if (file.exists() && !file.isDirectory()) {
                    long f2 = c.a.o0.h.c.j.b.h().f(this.f46896j);
                    this.n = f2;
                    if (0 != f2) {
                        B().d(this.f46896j);
                        if (o) {
                            String str = "setSrc path: " + this.f46896j;
                            return;
                        }
                        return;
                    }
                }
            } catch (Exception e2) {
                if (o) {
                    e2.printStackTrace();
                }
            }
            L(LightappConstants.ERRCODE_INNER_ERROR);
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.k == null) {
                this.k = new d(this, null);
            }
            this.f46891e.j(this.k);
            this.f46891e.q(this.k);
            this.f46891e.g(this.k);
            this.f46891e.k(this.k);
            this.f46891e.h(this.k);
            this.f46891e.n(this.k);
            this.f46891e.f(this);
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            F();
            this.m = false;
            this.f46889c = UserStatus.DESTROY;
            this.f46888b = PlayerStatus.NONE;
        }
    }

    public void U(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048596, this, f2) == null) {
            try {
                J("onSeeking");
                int i2 = (int) (f2 * 1000.0f);
                if (H()) {
                    if (i2 >= 0 && i2 <= A()) {
                        this.f46891e.seek(i2);
                    }
                    this.l = -1.0f;
                    return;
                }
                if (this.m && this.f46888b == PlayerStatus.IDLE) {
                    R();
                }
                this.l = i2;
            } catch (Exception e2) {
                if (o) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void V(c.a.o0.a.i1.c.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, aVar) == null) {
            this.f46887a = aVar;
        }
    }

    public final void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            try {
                if (H()) {
                    this.f46891e.a(z);
                }
            } catch (Exception e2) {
                if (o) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void X(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048599, this, f2) == null) && H()) {
            if (f2 > 1.0f) {
                f2 = 1.0f;
            } else if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            try {
                this.f46891e.setVolume(f2);
            } catch (Exception e2) {
                if (o) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.f46889c = UserStatus.STOP;
            if (H()) {
                this.f46891e.stop();
            }
            F();
            J(MissionEvent.MESSAGE_STOP);
        }
    }

    public void Z(c.a.o0.h.c.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, dVar) == null) {
            this.f46892f = dVar;
            c.a.o0.a.i1.c.e.a aVar = this.f46887a;
            if (aVar != null) {
                aVar.d(dVar.f11015j);
            }
            a0();
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (o) {
                String str = "update AudioPlayer params : " + this.f46892f.toString();
            }
            W(this.f46892f.f11011f);
            X(this.f46892f.f11014i);
        }
    }

    @Override // c.a.o0.a.i1.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f46892f.f11007b : (String) invokeV.objValue;
    }

    @Override // c.a.o0.a.i1.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f46890d : (String) invokeV.objValue;
    }

    @Override // c.a.o0.a.i1.a
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.o0.a.i1.a
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this : invokeV.objValue;
    }

    @Override // c.a.o0.a.i1.a
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
        }
    }

    @Override // c.a.o0.a.i1.a
    public void k(boolean z) {
        c.a.o0.a.a2.e i2;
        c.a.o0.a.l0.a C;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048608, this, z) == null) || (i2 = c.a.o0.a.a2.e.i()) == null || !i2.m0() || z || (C = C()) == null || C.s0()) {
            return;
        }
        C.runOnJSThread(new b(this));
    }

    @Override // c.a.o0.a.i1.a
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.o0.a.i1.a
    public void onDestroy() {
        c.a.o0.a.a2.e i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && (i2 = c.a.o0.a.a2.e.i()) != null && i2.m0()) {
            T();
        }
    }

    @Override // c.a.o0.l.a.c
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            E();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            R();
        }
    }

    public final boolean x() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            File file = new File(this.f46896j);
            if (!file.exists() || file.isDirectory()) {
                L(LightappConstants.ERRCODE_INNER_ERROR);
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f46894h : invokeV.intValue;
    }

    public int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (H()) {
                return this.f46891e.v();
            }
            return 0;
        }
        return invokeV.intValue;
    }
}
