package com.baidu.swan.apps.media.audio;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.a2.e;
import c.a.p0.a.g1.f;
import c.a.p0.a.h0.u.g;
import c.a.p0.a.k;
import c.a.p0.a.v2.d0;
import c.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.info.XDeviceInfo;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
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
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes6.dex */
public class SwanAppAudioPlayer implements c.a.p0.a.i1.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f46106a;

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f46107b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.a.i1.c.b f46108c;

    /* renamed from: d  reason: collision with root package name */
    public d f46109d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.a.i1.c.e.a f46110e;

    /* renamed from: f  reason: collision with root package name */
    public PlayerStatus f46111f;

    /* renamed from: g  reason: collision with root package name */
    public UserStatus f46112g;

    /* renamed from: h  reason: collision with root package name */
    public AudioManager f46113h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f46114i;

    /* renamed from: j  reason: collision with root package name */
    public b f46115j;
    public boolean k;

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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1465349220, "Lcom/baidu/swan/apps/media/audio/SwanAppAudioPlayer$PlayerStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1465349220, "Lcom/baidu/swan/apps/media/audio/SwanAppAudioPlayer$PlayerStatus;");
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1271694222, "Lcom/baidu/swan/apps/media/audio/SwanAppAudioPlayer$UserStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1271694222, "Lcom/baidu/swan/apps/media/audio/SwanAppAudioPlayer$UserStatus;");
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
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b implements AudioManager.OnAudioFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppAudioPlayer f46116a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f46117e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f46118f;

            public a(b bVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f46118f = bVar;
                this.f46117e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f46118f.f46116a.v()) {
                    return;
                }
                int i2 = this.f46117e;
                if (i2 == -2) {
                    boolean unused = SwanAppAudioPlayer.l;
                    this.f46118f.f46116a.a();
                    this.f46118f.f46116a.y();
                } else if (i2 != -1) {
                } else {
                    boolean unused2 = SwanAppAudioPlayer.l;
                    this.f46118f.f46116a.a();
                    this.f46118f.f46116a.y();
                }
            }
        }

        public b(SwanAppAudioPlayer swanAppAudioPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioPlayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46116a = swanAppAudioPlayer;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                q0.b0(new a(this, i2));
            }
        }

        public /* synthetic */ b(SwanAppAudioPlayer swanAppAudioPlayer, a aVar) {
            this(swanAppAudioPlayer);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnInfoListener, MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnBufferingUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAudioPlayer f46119e;

        public c(SwanAppAudioPlayer swanAppAudioPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioPlayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46119e = swanAppAudioPlayer;
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, mediaPlayer, i2) == null) {
                if (SwanAppAudioPlayer.l) {
                    String str = "--onBufferUpdate -> " + i2 + "%";
                }
                if (this.f46119e.f46111f != PlayerStatus.PREPARED || (i2 * this.f46119e.u().getDuration()) / 100 > this.f46119e.u().getCurrentPosition() || this.f46119e.f46110e == null) {
                    return;
                }
                this.f46119e.f46110e.a("onWaiting");
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaPlayer) == null) {
                boolean unused = SwanAppAudioPlayer.l;
                if (!this.f46119e.u().isLooping()) {
                    this.f46119e.f46112g = UserStatus.STOP;
                }
                this.f46119e.f46111f = PlayerStatus.PREPARED;
                if (this.f46119e.f46110e != null) {
                    this.f46119e.f46110e.a("onEnded");
                }
                this.f46119e.f46109d.removeMessages(0);
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, mediaPlayer, i2, i3)) == null) {
                if (SwanAppAudioPlayer.l) {
                    String str = "--onError -> what: " + i2 + " extra: " + i3;
                }
                String str2 = "-1";
                if (i2 != 1 && i2 == 100) {
                    str2 = LightappConstants.ERRCODE_INVALID_PARAMETER;
                }
                if (i3 == -1007) {
                    str2 = "10004";
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("errCode", str2);
                } catch (JSONException e2) {
                    if (SwanAppAudioPlayer.l) {
                        Log.getStackTraceString(e2);
                    }
                }
                if (this.f46119e.f46110e != null) {
                    this.f46119e.f46110e.b("onError", jSONObject);
                }
                return true;
            }
            return invokeLII.booleanValue;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, mediaPlayer, i2, i3)) == null) {
                if (SwanAppAudioPlayer.l) {
                    String str = "--oninfo -> what: " + i2 + " ,extra: " + i3;
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
                boolean unused = SwanAppAudioPlayer.l;
                this.f46119e.f46111f = PlayerStatus.PREPARED;
                if (this.f46119e.f46110e != null) {
                    this.f46119e.f46110e.a("onCanplay");
                }
                if (UserStatus.PLAY == this.f46119e.f46112g) {
                    this.f46119e.H();
                }
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, mediaPlayer) == null) {
                boolean unused = SwanAppAudioPlayer.l;
                if (this.f46119e.f46110e != null) {
                    this.f46119e.f46110e.a("onSeeked");
                }
            }
        }

        public /* synthetic */ c(SwanAppAudioPlayer swanAppAudioPlayer, a aVar) {
            this(swanAppAudioPlayer);
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes6.dex */
    public class d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppAudioPlayer f46120a;

        public d(SwanAppAudioPlayer swanAppAudioPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioPlayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46120a = swanAppAudioPlayer;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Long.valueOf(this.f46120a.u().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(this.f46120a.u().getDuration() / 1000));
                    if (this.f46120a.f46110e != null) {
                        this.f46120a.f46110e.b("onTimeUpdate", jSONObject);
                    }
                } catch (JSONException e2) {
                    if (SwanAppAudioPlayer.l) {
                        e2.printStackTrace();
                    }
                }
                sendEmptyMessageDelayed(0, 1000L);
            }
        }

        public /* synthetic */ d(SwanAppAudioPlayer swanAppAudioPlayer, a aVar) {
            this(swanAppAudioPlayer);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(290695235, "Lcom/baidu/swan/apps/media/audio/SwanAppAudioPlayer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(290695235, "Lcom/baidu/swan/apps/media/audio/SwanAppAudioPlayer;");
                return;
            }
        }
        l = k.f7085a;
    }

    public SwanAppAudioPlayer(String str) {
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
        this.f46106a = "";
        this.f46108c = new c.a.p0.a.i1.c.b();
        this.f46111f = PlayerStatus.NONE;
        this.f46112g = UserStatus.OPEN;
        this.k = false;
        this.f46106a = str;
        c.a.p0.a.i1.b.a(this);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.k) {
                u().reset();
                E(this.f46108c.f6593c);
                this.k = false;
            }
            u().prepareAsync();
            this.f46111f = PlayerStatus.PREPARING;
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            boolean z = l;
            this.f46112g = UserStatus.DESTROY;
            a();
            u().release();
            this.f46111f = PlayerStatus.NONE;
            this.f46107b = null;
            d dVar = this.f46109d;
            if (dVar != null) {
                dVar.removeMessages(0);
                this.f46109d = null;
            }
            c.a.p0.a.i1.b.j(this);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || v() || this.f46114i) {
            return;
        }
        if (this.f46113h == null) {
            AudioManager audioManager = (AudioManager) AppRuntime.getAppContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            this.f46113h = audioManager;
            if (audioManager == null) {
                return;
            }
        }
        if (this.f46115j == null) {
            this.f46115j = new b(this, null);
        }
        this.f46114i = this.f46113h.requestAudioFocus(this.f46115j, 3, 1) == 1;
        boolean z = l;
    }

    public void D(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i2) == null) && this.f46111f == PlayerStatus.PREPARED) {
            if (l) {
                String str = "===seekTo ->" + i2;
            }
            u().seekTo((int) (i2 * 1000));
            c.a.p0.a.i1.c.e.a aVar = this.f46110e;
            if (aVar != null) {
                aVar.a("onSeeking");
            }
        }
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            try {
                String a2 = f.V().I().a(str);
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                HashMap hashMap = new HashMap();
                String b2 = d0.b();
                if (!TextUtils.isEmpty(b2) && d0.c(a2)) {
                    if (l) {
                        String str2 = "set referer for AudioPlayer; referer is" + b2;
                    }
                    hashMap.put("Referer", b2);
                }
                String Y = g.N().Y();
                if (!TextUtils.isEmpty(Y)) {
                    hashMap.put("User-Agent", Y);
                }
                String j2 = c.a.p0.a.l2.b.l().j(a2);
                if (!TextUtils.isEmpty(j2)) {
                    hashMap.put("Cookie", j2);
                    if (l) {
                        String str3 = "addCookiesToHeader cookie: " + j2;
                    }
                }
                u().setDataSource(AppRuntime.getAppContext(), Uri.parse(a2), hashMap);
                this.f46111f = PlayerStatus.IDLE;
            } catch (IOException unused) {
                boolean z = l;
                if (this.f46110e != null) {
                    JSONObject jSONObject = new JSONObject();
                    if (SwanAppNetworkUtils.i(null)) {
                        jSONObject.optString("errCode", LightappConstants.ERRCODE_NO_PERMISSION);
                    } else {
                        jSONObject.optString("errCode", LightappConstants.ERRCODE_INNER_ERROR);
                    }
                    this.f46110e.a("onError");
                }
            }
        }
    }

    public final void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            u().setLooping(z);
        }
    }

    public final void G(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            if (f2 > 1.0f) {
                f2 = 1.0f;
            } else if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            u().setVolume(f2, f2);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            boolean z = l;
            C();
            u().start();
            d dVar = this.f46109d;
            if (dVar != null) {
                dVar.sendEmptyMessage(0);
            }
            c.a.p0.a.i1.c.e.a aVar = this.f46110e;
            if (aVar != null) {
                aVar.a("onPlay");
            }
            K();
            int i2 = this.f46108c.f6594d;
            if (i2 > 0) {
                D(i2);
            }
            if (c.a.p0.a.c1.b.f().b()) {
                y();
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f46112g = UserStatus.STOP;
            if (this.f46111f == PlayerStatus.PREPARED) {
                boolean z = l;
                u().stop();
                this.f46111f = PlayerStatus.IDLE;
                d dVar = this.f46109d;
                if (dVar != null) {
                    dVar.removeMessages(0);
                }
                c.a.p0.a.i1.c.e.a aVar = this.f46110e;
                if (aVar != null) {
                    aVar.a(MissionEvent.MESSAGE_STOP);
                }
            }
        }
    }

    public void J(c.a.p0.a.i1.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            if (l) {
                String str = "===update -> " + bVar;
            }
            String str2 = this.f46108c.f6593c;
            this.f46108c = bVar;
            c.a.p0.a.i1.c.e.a aVar = this.f46110e;
            if (aVar != null) {
                aVar.d(bVar.f6600j);
            }
            K();
            if (TextUtils.equals(bVar.f6593c, str2)) {
                return;
            }
            if (l) {
                String str3 = "update src: " + bVar.f6593c;
            }
            this.k = true;
            A();
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            F(this.f46108c.f6596f);
            G(this.f46108c.f6599i);
        }
    }

    public final void a() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.f46114i) {
            AudioManager audioManager = this.f46113h;
            if (audioManager != null && (bVar = this.f46115j) != null) {
                audioManager.abandonAudioFocus(bVar);
                this.f46113h = null;
                this.f46115j = null;
            }
            this.f46114i = false;
            boolean z = l;
        }
    }

    @Override // c.a.p0.a.i1.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f46108c.f6592b : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.i1.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f46106a : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.i1.a
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.i1.a
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this : invokeV.objValue;
    }

    @Override // c.a.p0.a.i1.a
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            if (l) {
                String str = "--onAppForegroundChanged -> " + z;
            }
            if (z) {
                return;
            }
            y();
        }
    }

    @Override // c.a.p0.a.i1.a
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (l) {
                String str = "--onForegroundChanged -> " + z;
            }
            e i2 = e.i();
            if (i2 == null || !i2.m0()) {
                return;
            }
            if (!z) {
                y();
            } else if (this.f46112g == UserStatus.PLAY) {
                z();
            }
        }
    }

    @Override // c.a.p0.a.i1.a
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.i1.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            boolean z = l;
            e i2 = e.i();
            if (i2 == null || !i2.m0()) {
                return;
            }
            B();
        }
    }

    public c.a.p0.a.i1.c.b t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f46108c : (c.a.p0.a.i1.c.b) invokeV.objValue;
    }

    public final MediaPlayer u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.f46107b == null) {
                this.f46107b = new MediaPlayer();
                c cVar = new c(this, null);
                this.f46107b.setOnPreparedListener(cVar);
                this.f46107b.setOnCompletionListener(cVar);
                this.f46107b.setOnInfoListener(cVar);
                this.f46107b.setOnErrorListener(cVar);
                this.f46107b.setOnSeekCompleteListener(cVar);
                this.f46107b.setOnBufferingUpdateListener(cVar);
                this.f46109d = new d(this, null);
            }
            return this.f46107b;
        }
        return (MediaPlayer) invokeV.objValue;
    }

    public final boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            e i2 = e.i();
            boolean booleanValue = i2 == null ? false : i2.J().c("key_audio_is_mix_with_other", Boolean.FALSE).booleanValue();
            if (l) {
                String str = "   isMixWithOther -> " + booleanValue;
            }
            return booleanValue;
        }
        return invokeV.booleanValue;
    }

    public void w(c.a.p0.a.i1.c.b bVar, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, bVar, callbackHandler) == null) {
            boolean z = l;
            this.f46112g = UserStatus.OPEN;
            this.f46108c = bVar;
            if (bVar.f6600j != null) {
                try {
                    this.f46110e = new c.a.p0.a.i1.c.e.a(callbackHandler, new JSONObject(this.f46108c.f6600j));
                } catch (JSONException unused) {
                    boolean z2 = l;
                }
            }
            u().reset();
            E(this.f46108c.f6593c);
            A();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            boolean z = l;
            this.f46112g = UserStatus.PAUSE;
            y();
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && u().isPlaying()) {
            u().pause();
            c.a.p0.a.i1.c.e.a aVar = this.f46110e;
            if (aVar != null) {
                aVar.a(MissionEvent.MESSAGE_PAUSE);
            }
            d dVar = this.f46109d;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.f46112g = UserStatus.PLAY;
            if (c.a.p0.a.c1.b.f().b()) {
                return;
            }
            boolean z = l;
            C();
            PlayerStatus playerStatus = this.f46111f;
            if (playerStatus == PlayerStatus.PREPARED) {
                u().start();
                d dVar = this.f46109d;
                if (dVar != null) {
                    dVar.sendEmptyMessage(0);
                }
                c.a.p0.a.i1.c.e.a aVar = this.f46110e;
                if (aVar != null) {
                    aVar.a("onPlay");
                }
            } else if (playerStatus == PlayerStatus.IDLE) {
                u().prepareAsync();
                this.f46111f = PlayerStatus.PREPARING;
            }
        }
    }
}
