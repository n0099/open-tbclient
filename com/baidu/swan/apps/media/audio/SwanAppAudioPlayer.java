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
import c.a.p0.a.d2.e;
import c.a.p0.a.g1.f;
import c.a.p0.a.h0.u.g;
import c.a.p0.a.k;
import c.a.p0.a.z2.d0;
import c.a.p0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PolyActivity;
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
/* loaded from: classes9.dex */
public class SwanAppAudioPlayer implements c.a.p0.a.j1.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f39525b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.a.j1.c.b f39526c;

    /* renamed from: d  reason: collision with root package name */
    public d f39527d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.a.j1.c.f.a f39528e;

    /* renamed from: f  reason: collision with root package name */
    public PlayerStatus f39529f;

    /* renamed from: g  reason: collision with root package name */
    public UserStatus f39530g;

    /* renamed from: h  reason: collision with root package name */
    public AudioManager f39531h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f39532i;

    /* renamed from: j  reason: collision with root package name */
    public b f39533j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f39534k;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
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
            NONE = new PlayerStatus(PolyActivity.NONE_PANEL_TYPE, 0);
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
    /* loaded from: classes9.dex */
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
            PAUSE = new UserStatus("PAUSE", 2);
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

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public class b implements AudioManager.OnAudioFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAudioPlayer a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f39535e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f39536f;

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
                this.f39536f = bVar;
                this.f39535e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f39536f.a.w()) {
                    return;
                }
                int i2 = this.f39535e;
                if (i2 == -2) {
                    boolean unused = SwanAppAudioPlayer.l;
                    this.f39536f.a.a();
                    this.f39536f.a.z();
                } else if (i2 != -1) {
                } else {
                    boolean unused2 = SwanAppAudioPlayer.l;
                    this.f39536f.a.a();
                    this.f39536f.a.z();
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
            this.a = swanAppAudioPlayer;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                q0.e0(new a(this, i2));
            }
        }

        public /* synthetic */ b(SwanAppAudioPlayer swanAppAudioPlayer, a aVar) {
            this(swanAppAudioPlayer);
        }
    }

    /* loaded from: classes9.dex */
    public class c implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnInfoListener, MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnBufferingUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAudioPlayer f39537e;

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
            this.f39537e = swanAppAudioPlayer;
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, mediaPlayer, i2) == null) {
                if (SwanAppAudioPlayer.l) {
                    String str = "--onBufferUpdate -> " + i2 + "%";
                }
                if (this.f39537e.f39529f != PlayerStatus.PREPARED || (i2 * this.f39537e.v().getDuration()) / 100 > this.f39537e.v().getCurrentPosition() || this.f39537e.f39528e == null) {
                    return;
                }
                this.f39537e.f39528e.a("onWaiting");
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaPlayer) == null) {
                boolean unused = SwanAppAudioPlayer.l;
                if (!this.f39537e.v().isLooping()) {
                    this.f39537e.f39530g = UserStatus.STOP;
                }
                this.f39537e.f39529f = PlayerStatus.PREPARED;
                if (this.f39537e.f39528e != null) {
                    this.f39537e.f39528e.a("onEnded");
                }
                this.f39537e.f39527d.removeMessages(0);
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
                c.a.p0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 2008, "audio fail, src: " + this.f39537e.f39526c.f6414c, Integer.parseInt(str2), "");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("errCode", str2);
                } catch (JSONException e2) {
                    if (SwanAppAudioPlayer.l) {
                        Log.getStackTraceString(e2);
                    }
                }
                if (this.f39537e.f39528e != null) {
                    this.f39537e.f39528e.b("onError", jSONObject);
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
                this.f39537e.f39529f = PlayerStatus.PREPARED;
                if (this.f39537e.f39528e != null) {
                    this.f39537e.f39528e.a("onCanplay");
                }
                if (UserStatus.PLAY == this.f39537e.f39530g) {
                    this.f39537e.I();
                }
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, mediaPlayer) == null) {
                boolean unused = SwanAppAudioPlayer.l;
                if (this.f39537e.f39528e != null) {
                    this.f39537e.f39528e.a("onSeeked");
                }
            }
        }

        public /* synthetic */ c(SwanAppAudioPlayer swanAppAudioPlayer, a aVar) {
            this(swanAppAudioPlayer);
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes9.dex */
    public class d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAudioPlayer a;

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
            this.a = swanAppAudioPlayer;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Long.valueOf(this.a.v().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(this.a.v().getDuration() / 1000));
                    if (this.a.f39528e != null) {
                        this.a.f39528e.b("onTimeUpdate", jSONObject);
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
        l = k.a;
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
        this.a = "";
        this.f39526c = new c.a.p0.a.j1.c.b();
        this.f39529f = PlayerStatus.NONE;
        this.f39530g = UserStatus.OPEN;
        this.f39534k = false;
        this.a = str;
        c.a.p0.a.j1.b.a(this);
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f39530g = UserStatus.PLAY;
            if (c.a.p0.a.c1.b.f().b()) {
                return;
            }
            boolean z = l;
            D();
            PlayerStatus playerStatus = this.f39529f;
            if (playerStatus == PlayerStatus.PREPARED) {
                v().start();
                d dVar = this.f39527d;
                if (dVar != null) {
                    dVar.sendEmptyMessage(0);
                }
                c.a.p0.a.j1.c.f.a aVar = this.f39528e;
                if (aVar != null) {
                    aVar.a("onPlay");
                }
            } else if (playerStatus == PlayerStatus.IDLE) {
                v().prepareAsync();
                this.f39529f = PlayerStatus.PREPARING;
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f39534k) {
                v().reset();
                F(this.f39526c.f6414c);
                this.f39534k = false;
            }
            v().prepareAsync();
            this.f39529f = PlayerStatus.PREPARING;
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            boolean z = l;
            this.f39530g = UserStatus.DESTROY;
            a();
            v().release();
            this.f39529f = PlayerStatus.NONE;
            this.f39525b = null;
            d dVar = this.f39527d;
            if (dVar != null) {
                dVar.removeMessages(0);
                this.f39527d = null;
            }
            c.a.p0.a.j1.b.k(this);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || w() || this.f39532i) {
            return;
        }
        if (this.f39531h == null) {
            AudioManager audioManager = (AudioManager) AppRuntime.getAppContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            this.f39531h = audioManager;
            if (audioManager == null) {
                return;
            }
        }
        if (this.f39533j == null) {
            this.f39533j = new b(this, null);
        }
        this.f39532i = this.f39531h.requestAudioFocus(this.f39533j, 3, 1) == 1;
        boolean z = l;
    }

    public void E(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i2) == null) && this.f39529f == PlayerStatus.PREPARED) {
            if (l) {
                String str = "===seekTo ->" + i2;
            }
            v().seekTo((int) (i2 * 1000));
            c.a.p0.a.j1.c.f.a aVar = this.f39528e;
            if (aVar != null) {
                aVar.a("onSeeking");
            }
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            try {
                str = f.U().G().a(str);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                HashMap hashMap = new HashMap();
                String b2 = d0.b();
                if (!TextUtils.isEmpty(b2) && d0.c(str)) {
                    if (l) {
                        String str2 = "set referer for AudioPlayer; referer is" + b2;
                    }
                    hashMap.put("Referer", b2);
                }
                String g0 = g.U().g0();
                if (!TextUtils.isEmpty(g0)) {
                    hashMap.put("User-Agent", g0);
                }
                String j2 = c.a.p0.a.p2.b.l().j(str);
                if (!TextUtils.isEmpty(j2)) {
                    hashMap.put("Cookie", j2);
                    if (l) {
                        String str3 = "addCookiesToHeader cookie: " + j2;
                    }
                }
                v().setDataSource(AppRuntime.getAppContext(), Uri.parse(str), hashMap);
                this.f39529f = PlayerStatus.IDLE;
            } catch (IOException unused) {
                c.a.p0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 1001, "src replace fail, src is" + str, -1, "");
                boolean z = l;
                if (this.f39528e != null) {
                    JSONObject jSONObject = new JSONObject();
                    if (SwanAppNetworkUtils.i(null)) {
                        jSONObject.optString("errCode", LightappConstants.ERRCODE_NO_PERMISSION);
                    } else {
                        jSONObject.optString("errCode", LightappConstants.ERRCODE_INNER_ERROR);
                    }
                    this.f39528e.a("onError");
                }
            }
        }
    }

    public final void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            v().setLooping(z);
        }
    }

    public final void H(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            if (f2 > 1.0f) {
                f2 = 1.0f;
            } else if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            v().setVolume(f2, f2);
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            boolean z = l;
            D();
            v().start();
            d dVar = this.f39527d;
            if (dVar != null) {
                dVar.sendEmptyMessage(0);
            }
            c.a.p0.a.j1.c.f.a aVar = this.f39528e;
            if (aVar != null) {
                aVar.a("onPlay");
            }
            K();
            int i2 = this.f39526c.f6415d;
            if (i2 > 0) {
                E(i2);
            }
            if (c.a.p0.a.c1.b.f().b()) {
                z();
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f39530g = UserStatus.STOP;
            if (this.f39529f == PlayerStatus.PREPARED) {
                boolean z = l;
                v().stop();
                this.f39529f = PlayerStatus.IDLE;
                d dVar = this.f39527d;
                if (dVar != null) {
                    dVar.removeMessages(0);
                }
                c.a.p0.a.j1.c.f.a aVar = this.f39528e;
                if (aVar != null) {
                    aVar.a(MissionEvent.MESSAGE_STOP);
                }
            }
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            G(this.f39526c.f6417f);
            H(this.f39526c.f6420i);
        }
    }

    public final void a() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.f39532i) {
            AudioManager audioManager = this.f39531h;
            if (audioManager != null && (bVar = this.f39533j) != null) {
                audioManager.abandonAudioFocus(bVar);
                this.f39531h = null;
                this.f39533j = null;
            }
            this.f39532i = false;
            boolean z = l;
        }
    }

    @Override // c.a.p0.a.j1.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f39526c.f6413b : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.j1.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.j1.a
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.j1.a
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this : invokeV.objValue;
    }

    @Override // c.a.p0.a.j1.a
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            if (l) {
                String str = "--onAppForegroundChanged -> " + z;
            }
            if (z) {
                return;
            }
            z();
        }
    }

    @Override // c.a.p0.a.j1.a
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (l) {
                String str = "--onForegroundChanged -> " + z;
            }
            e L = e.L();
            if (L == null || !L.v0()) {
                return;
            }
            if (!z) {
                z();
            } else if (this.f39530g == UserStatus.PLAY) {
                A();
            }
        }
    }

    @Override // c.a.p0.a.j1.a
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.j1.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            boolean z = l;
            e L = e.L();
            if (L == null || !L.v0()) {
                return;
            }
            C();
        }
    }

    public c.a.p0.a.j1.c.b u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f39526c : (c.a.p0.a.j1.c.b) invokeV.objValue;
    }

    public void update(c.a.p0.a.j1.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bVar) == null) {
            if (l) {
                String str = "===update -> " + bVar;
            }
            String str2 = this.f39526c.f6414c;
            this.f39526c = bVar;
            c.a.p0.a.j1.c.f.a aVar = this.f39528e;
            if (aVar != null) {
                aVar.d(bVar.f6421j);
            }
            K();
            if (TextUtils.equals(bVar.f6414c, str2)) {
                return;
            }
            if (l) {
                String str3 = "update src: " + bVar.f6414c;
            }
            this.f39534k = true;
            B();
        }
    }

    public final MediaPlayer v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.f39525b == null) {
                this.f39525b = new MediaPlayer();
                c cVar = new c(this, null);
                this.f39525b.setOnPreparedListener(cVar);
                this.f39525b.setOnCompletionListener(cVar);
                this.f39525b.setOnInfoListener(cVar);
                this.f39525b.setOnErrorListener(cVar);
                this.f39525b.setOnSeekCompleteListener(cVar);
                this.f39525b.setOnBufferingUpdateListener(cVar);
                this.f39527d = new d(this, null);
            }
            return this.f39525b;
        }
        return (MediaPlayer) invokeV.objValue;
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            e L = e.L();
            boolean booleanValue = L == null ? false : L.T().c("key_audio_is_mix_with_other", Boolean.FALSE).booleanValue();
            if (l) {
                String str = "   isMixWithOther -> " + booleanValue;
            }
            return booleanValue;
        }
        return invokeV.booleanValue;
    }

    public void x(c.a.p0.a.j1.c.b bVar, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, bVar, callbackHandler) == null) {
            boolean z = l;
            this.f39530g = UserStatus.OPEN;
            this.f39526c = bVar;
            if (bVar.f6421j != null) {
                try {
                    this.f39528e = new c.a.p0.a.j1.c.f.a(callbackHandler, new JSONObject(this.f39526c.f6421j));
                } catch (JSONException unused) {
                    c.a.p0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 2009, "Audio callback is not jsonObject", -1, "");
                    boolean z2 = l;
                }
            }
            v().reset();
            F(this.f39526c.f6414c);
            B();
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            boolean z = l;
            this.f39530g = UserStatus.PAUSE;
            z();
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && v().isPlaying()) {
            v().pause();
            c.a.p0.a.j1.c.f.a aVar = this.f39528e;
            if (aVar != null) {
                aVar.a(MissionEvent.MESSAGE_PAUSE);
            }
            d dVar = this.f39527d;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }
}
