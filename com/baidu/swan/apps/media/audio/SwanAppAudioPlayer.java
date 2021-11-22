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
import b.a.p0.a.d2.e;
import b.a.p0.a.g1.f;
import b.a.p0.a.h0.u.g;
import b.a.p0.a.k;
import b.a.p0.a.z2.d0;
import b.a.p0.a.z2.q0;
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
/* loaded from: classes8.dex */
public class SwanAppAudioPlayer implements b.a.p0.a.j1.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f44497a;

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f44498b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.p0.a.j1.c.b f44499c;

    /* renamed from: d  reason: collision with root package name */
    public d f44500d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.p0.a.j1.c.f.a f44501e;

    /* renamed from: f  reason: collision with root package name */
    public PlayerStatus f44502f;

    /* renamed from: g  reason: collision with root package name */
    public UserStatus f44503g;

    /* renamed from: h  reason: collision with root package name */
    public AudioManager f44504h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f44505i;
    public b j;
    public boolean k;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
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
    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class b implements AudioManager.OnAudioFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppAudioPlayer f44506a;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f44507e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f44508f;

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
                this.f44508f = bVar;
                this.f44507e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f44508f.f44506a.w()) {
                    return;
                }
                int i2 = this.f44507e;
                if (i2 == -2) {
                    boolean unused = SwanAppAudioPlayer.l;
                    this.f44508f.f44506a.a();
                    this.f44508f.f44506a.z();
                } else if (i2 != -1) {
                } else {
                    boolean unused2 = SwanAppAudioPlayer.l;
                    this.f44508f.f44506a.a();
                    this.f44508f.f44506a.z();
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
            this.f44506a = swanAppAudioPlayer;
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

    /* loaded from: classes8.dex */
    public class c implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnInfoListener, MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnBufferingUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAudioPlayer f44509e;

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
            this.f44509e = swanAppAudioPlayer;
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, mediaPlayer, i2) == null) {
                if (SwanAppAudioPlayer.l) {
                    String str = "--onBufferUpdate -> " + i2 + "%";
                }
                if (this.f44509e.f44502f != PlayerStatus.PREPARED || (i2 * this.f44509e.v().getDuration()) / 100 > this.f44509e.v().getCurrentPosition() || this.f44509e.f44501e == null) {
                    return;
                }
                this.f44509e.f44501e.a("onWaiting");
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaPlayer) == null) {
                boolean unused = SwanAppAudioPlayer.l;
                if (!this.f44509e.v().isLooping()) {
                    this.f44509e.f44503g = UserStatus.STOP;
                }
                this.f44509e.f44502f = PlayerStatus.PREPARED;
                if (this.f44509e.f44501e != null) {
                    this.f44509e.f44501e.a("onEnded");
                }
                this.f44509e.f44500d.removeMessages(0);
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
                b.a.p0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 2008, "audio fail, src: " + this.f44509e.f44499c.f6572c, Integer.parseInt(str2), "");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("errCode", str2);
                } catch (JSONException e2) {
                    if (SwanAppAudioPlayer.l) {
                        Log.getStackTraceString(e2);
                    }
                }
                if (this.f44509e.f44501e != null) {
                    this.f44509e.f44501e.b("onError", jSONObject);
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
                this.f44509e.f44502f = PlayerStatus.PREPARED;
                if (this.f44509e.f44501e != null) {
                    this.f44509e.f44501e.a("onCanplay");
                }
                if (UserStatus.PLAY == this.f44509e.f44503g) {
                    this.f44509e.I();
                }
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, mediaPlayer) == null) {
                boolean unused = SwanAppAudioPlayer.l;
                if (this.f44509e.f44501e != null) {
                    this.f44509e.f44501e.a("onSeeked");
                }
            }
        }

        public /* synthetic */ c(SwanAppAudioPlayer swanAppAudioPlayer, a aVar) {
            this(swanAppAudioPlayer);
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes8.dex */
    public class d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppAudioPlayer f44510a;

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
            this.f44510a = swanAppAudioPlayer;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Long.valueOf(this.f44510a.v().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(this.f44510a.v().getDuration() / 1000));
                    if (this.f44510a.f44501e != null) {
                        this.f44510a.f44501e.b("onTimeUpdate", jSONObject);
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
        l = k.f6863a;
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
        this.f44497a = "";
        this.f44499c = new b.a.p0.a.j1.c.b();
        this.f44502f = PlayerStatus.NONE;
        this.f44503g = UserStatus.OPEN;
        this.k = false;
        this.f44497a = str;
        b.a.p0.a.j1.b.a(this);
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f44503g = UserStatus.PLAY;
            if (b.a.p0.a.c1.b.f().b()) {
                return;
            }
            boolean z = l;
            D();
            PlayerStatus playerStatus = this.f44502f;
            if (playerStatus == PlayerStatus.PREPARED) {
                v().start();
                d dVar = this.f44500d;
                if (dVar != null) {
                    dVar.sendEmptyMessage(0);
                }
                b.a.p0.a.j1.c.f.a aVar = this.f44501e;
                if (aVar != null) {
                    aVar.a("onPlay");
                }
            } else if (playerStatus == PlayerStatus.IDLE) {
                v().prepareAsync();
                this.f44502f = PlayerStatus.PREPARING;
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.k) {
                v().reset();
                F(this.f44499c.f6572c);
                this.k = false;
            }
            v().prepareAsync();
            this.f44502f = PlayerStatus.PREPARING;
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            boolean z = l;
            this.f44503g = UserStatus.DESTROY;
            a();
            v().release();
            this.f44502f = PlayerStatus.NONE;
            this.f44498b = null;
            d dVar = this.f44500d;
            if (dVar != null) {
                dVar.removeMessages(0);
                this.f44500d = null;
            }
            b.a.p0.a.j1.b.k(this);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || w() || this.f44505i) {
            return;
        }
        if (this.f44504h == null) {
            AudioManager audioManager = (AudioManager) AppRuntime.getAppContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            this.f44504h = audioManager;
            if (audioManager == null) {
                return;
            }
        }
        if (this.j == null) {
            this.j = new b(this, null);
        }
        this.f44505i = this.f44504h.requestAudioFocus(this.j, 3, 1) == 1;
        boolean z = l;
    }

    public void E(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i2) == null) && this.f44502f == PlayerStatus.PREPARED) {
            if (l) {
                String str = "===seekTo ->" + i2;
            }
            v().seekTo((int) (i2 * 1000));
            b.a.p0.a.j1.c.f.a aVar = this.f44501e;
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
                String j = b.a.p0.a.p2.b.l().j(str);
                if (!TextUtils.isEmpty(j)) {
                    hashMap.put("Cookie", j);
                    if (l) {
                        String str3 = "addCookiesToHeader cookie: " + j;
                    }
                }
                v().setDataSource(AppRuntime.getAppContext(), Uri.parse(str), hashMap);
                this.f44502f = PlayerStatus.IDLE;
            } catch (IOException unused) {
                b.a.p0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 1001, "src replace fail, src is" + str, -1, "");
                boolean z = l;
                if (this.f44501e != null) {
                    JSONObject jSONObject = new JSONObject();
                    if (SwanAppNetworkUtils.i(null)) {
                        jSONObject.optString("errCode", LightappConstants.ERRCODE_NO_PERMISSION);
                    } else {
                        jSONObject.optString("errCode", LightappConstants.ERRCODE_INNER_ERROR);
                    }
                    this.f44501e.a("onError");
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
            d dVar = this.f44500d;
            if (dVar != null) {
                dVar.sendEmptyMessage(0);
            }
            b.a.p0.a.j1.c.f.a aVar = this.f44501e;
            if (aVar != null) {
                aVar.a("onPlay");
            }
            K();
            int i2 = this.f44499c.f6573d;
            if (i2 > 0) {
                E(i2);
            }
            if (b.a.p0.a.c1.b.f().b()) {
                z();
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f44503g = UserStatus.STOP;
            if (this.f44502f == PlayerStatus.PREPARED) {
                boolean z = l;
                v().stop();
                this.f44502f = PlayerStatus.IDLE;
                d dVar = this.f44500d;
                if (dVar != null) {
                    dVar.removeMessages(0);
                }
                b.a.p0.a.j1.c.f.a aVar = this.f44501e;
                if (aVar != null) {
                    aVar.a(MissionEvent.MESSAGE_STOP);
                }
            }
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            G(this.f44499c.f6575f);
            H(this.f44499c.f6578i);
        }
    }

    public final void a() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.f44505i) {
            AudioManager audioManager = this.f44504h;
            if (audioManager != null && (bVar = this.j) != null) {
                audioManager.abandonAudioFocus(bVar);
                this.f44504h = null;
                this.j = null;
            }
            this.f44505i = false;
            boolean z = l;
        }
    }

    @Override // b.a.p0.a.j1.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f44499c.f6571b : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.j1.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f44497a : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.j1.a
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.j1.a
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this : invokeV.objValue;
    }

    @Override // b.a.p0.a.j1.a
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

    @Override // b.a.p0.a.j1.a
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
            } else if (this.f44503g == UserStatus.PLAY) {
                A();
            }
        }
    }

    @Override // b.a.p0.a.j1.a
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.j1.a
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

    public b.a.p0.a.j1.c.b u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f44499c : (b.a.p0.a.j1.c.b) invokeV.objValue;
    }

    public void update(b.a.p0.a.j1.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bVar) == null) {
            if (l) {
                String str = "===update -> " + bVar;
            }
            String str2 = this.f44499c.f6572c;
            this.f44499c = bVar;
            b.a.p0.a.j1.c.f.a aVar = this.f44501e;
            if (aVar != null) {
                aVar.d(bVar.j);
            }
            K();
            if (TextUtils.equals(bVar.f6572c, str2)) {
                return;
            }
            if (l) {
                String str3 = "update src: " + bVar.f6572c;
            }
            this.k = true;
            B();
        }
    }

    public final MediaPlayer v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.f44498b == null) {
                this.f44498b = new MediaPlayer();
                c cVar = new c(this, null);
                this.f44498b.setOnPreparedListener(cVar);
                this.f44498b.setOnCompletionListener(cVar);
                this.f44498b.setOnInfoListener(cVar);
                this.f44498b.setOnErrorListener(cVar);
                this.f44498b.setOnSeekCompleteListener(cVar);
                this.f44498b.setOnBufferingUpdateListener(cVar);
                this.f44500d = new d(this, null);
            }
            return this.f44498b;
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

    public void x(b.a.p0.a.j1.c.b bVar, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, bVar, callbackHandler) == null) {
            boolean z = l;
            this.f44503g = UserStatus.OPEN;
            this.f44499c = bVar;
            if (bVar.j != null) {
                try {
                    this.f44501e = new b.a.p0.a.j1.c.f.a(callbackHandler, new JSONObject(this.f44499c.j));
                } catch (JSONException unused) {
                    b.a.p0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 2009, "Audio callback is not jsonObject", -1, "");
                    boolean z2 = l;
                }
            }
            v().reset();
            F(this.f44499c.f6572c);
            B();
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            boolean z = l;
            this.f44503g = UserStatus.PAUSE;
            z();
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && v().isPlaying()) {
            v().pause();
            b.a.p0.a.j1.c.f.a aVar = this.f44501e;
            if (aVar != null) {
                aVar.a(MissionEvent.MESSAGE_PAUSE);
            }
            d dVar = this.f44500d;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }
}
