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
import com.baidu.wallet.router.RouterCallback;
import d.a.n0.a.a2.e;
import d.a.n0.a.g1.f;
import d.a.n0.a.h0.u.g;
import d.a.n0.a.k;
import d.a.n0.a.v2.d0;
import d.a.n0.a.v2.q0;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes3.dex */
public class SwanAppAudioPlayer implements d.a.n0.a.i1.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f11056a;

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f11057b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.a.i1.c.b f11058c;

    /* renamed from: d  reason: collision with root package name */
    public d f11059d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.a.i1.c.e.a f11060e;

    /* renamed from: f  reason: collision with root package name */
    public PlayerStatus f11061f;

    /* renamed from: g  reason: collision with root package name */
    public UserStatus f11062g;

    /* renamed from: h  reason: collision with root package name */
    public AudioManager f11063h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f11064i;
    public b j;
    public boolean k;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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
    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public class b implements AudioManager.OnAudioFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppAudioPlayer f11065a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f11066e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f11067f;

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
                this.f11067f = bVar;
                this.f11066e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f11067f.f11065a.v()) {
                    return;
                }
                int i2 = this.f11066e;
                if (i2 == -2) {
                    if (SwanAppAudioPlayer.l) {
                        Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                    }
                    this.f11067f.f11065a.a();
                    this.f11067f.f11065a.y();
                } else if (i2 != -1) {
                } else {
                    if (SwanAppAudioPlayer.l) {
                        Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                    }
                    this.f11067f.f11065a.a();
                    this.f11067f.f11065a.y();
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
            this.f11065a = swanAppAudioPlayer;
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

    /* loaded from: classes3.dex */
    public class c implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnInfoListener, MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnBufferingUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAudioPlayer f11068e;

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
            this.f11068e = swanAppAudioPlayer;
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, mediaPlayer, i2) == null) {
                if (SwanAppAudioPlayer.l) {
                    Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i2 + "%");
                }
                if (this.f11068e.f11061f != PlayerStatus.PREPARED || (i2 * this.f11068e.u().getDuration()) / 100 > this.f11068e.u().getCurrentPosition() || this.f11068e.f11060e == null) {
                    return;
                }
                this.f11068e.f11060e.a("onWaiting");
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaPlayer) == null) {
                if (SwanAppAudioPlayer.l) {
                    Log.d("SwanAppAudioPlayer", "--onCompletion");
                }
                if (!this.f11068e.u().isLooping()) {
                    this.f11068e.f11062g = UserStatus.STOP;
                }
                this.f11068e.f11061f = PlayerStatus.PREPARED;
                if (this.f11068e.f11060e != null) {
                    this.f11068e.f11060e.a("onEnded");
                }
                this.f11068e.f11059d.removeMessages(0);
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, mediaPlayer, i2, i3)) == null) {
                if (SwanAppAudioPlayer.l) {
                    Log.d("SwanAppAudioPlayer", "--onError -> what: " + i2 + " extra: " + i3);
                }
                String str = "-1";
                if (i2 != 1 && i2 == 100) {
                    str = LightappConstants.ERRCODE_INVALID_PARAMETER;
                }
                if (i3 == -1007) {
                    str = "10004";
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt(RouterCallback.KEY_ERROR_CODE, str);
                } catch (JSONException e2) {
                    if (SwanAppAudioPlayer.l) {
                        Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e2));
                    }
                }
                if (this.f11068e.f11060e != null) {
                    this.f11068e.f11060e.b("onError", jSONObject);
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
                    Log.d("SwanAppAudioPlayer", "--oninfo -> what: " + i2 + " ,extra: " + i3);
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
                if (SwanAppAudioPlayer.l) {
                    Log.d("SwanAppAudioPlayer", "--onPrepared");
                }
                this.f11068e.f11061f = PlayerStatus.PREPARED;
                if (this.f11068e.f11060e != null) {
                    this.f11068e.f11060e.a("onCanplay");
                }
                if (UserStatus.PLAY == this.f11068e.f11062g) {
                    this.f11068e.H();
                }
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, mediaPlayer) == null) {
                if (SwanAppAudioPlayer.l) {
                    Log.d("SwanAppAudioPlayer", "--onSeekComplete");
                }
                if (this.f11068e.f11060e != null) {
                    this.f11068e.f11060e.a("onSeeked");
                }
            }
        }

        public /* synthetic */ c(SwanAppAudioPlayer swanAppAudioPlayer, a aVar) {
            this(swanAppAudioPlayer);
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes3.dex */
    public class d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppAudioPlayer f11069a;

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
            this.f11069a = swanAppAudioPlayer;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Long.valueOf(this.f11069a.u().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(this.f11069a.u().getDuration() / 1000));
                    if (this.f11069a.f11060e != null) {
                        this.f11069a.f11060e.b("onTimeUpdate", jSONObject);
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
        l = k.f45831a;
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
        this.f11056a = "";
        this.f11058c = new d.a.n0.a.i1.c.b();
        this.f11061f = PlayerStatus.NONE;
        this.f11062g = UserStatus.OPEN;
        this.k = false;
        this.f11056a = str;
        d.a.n0.a.i1.b.a(this);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.k) {
                u().reset();
                E(this.f11058c.f45353c);
                this.k = false;
            }
            u().prepareAsync();
            this.f11061f = PlayerStatus.PREPARING;
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (l) {
                Log.d("SwanAppAudioPlayer", "===release");
            }
            this.f11062g = UserStatus.DESTROY;
            a();
            u().release();
            this.f11061f = PlayerStatus.NONE;
            this.f11057b = null;
            d dVar = this.f11059d;
            if (dVar != null) {
                dVar.removeMessages(0);
                this.f11059d = null;
            }
            d.a.n0.a.i1.b.j(this);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || v() || this.f11064i) {
            return;
        }
        if (this.f11063h == null) {
            AudioManager audioManager = (AudioManager) AppRuntime.getAppContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            this.f11063h = audioManager;
            if (audioManager == null) {
                return;
            }
        }
        if (this.j == null) {
            this.j = new b(this, null);
        }
        this.f11064i = this.f11063h.requestAudioFocus(this.j, 3, 1) == 1;
        if (l) {
            Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
        }
    }

    public void D(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i2) == null) && this.f11061f == PlayerStatus.PREPARED) {
            if (l) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i2);
            }
            u().seekTo((int) (i2 * 1000));
            d.a.n0.a.i1.c.e.a aVar = this.f11060e;
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
                        Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + b2);
                    }
                    hashMap.put("Referer", b2);
                }
                String Y = g.N().Y();
                if (!TextUtils.isEmpty(Y)) {
                    hashMap.put("User-Agent", Y);
                }
                String j = d.a.n0.a.l2.b.l().j(a2);
                if (!TextUtils.isEmpty(j)) {
                    hashMap.put("Cookie", j);
                    if (l) {
                        Log.d("SwanAppAudioPlayer", "addCookiesToHeader cookie: " + j);
                    }
                }
                u().setDataSource(AppRuntime.getAppContext(), Uri.parse(a2), hashMap);
                this.f11061f = PlayerStatus.IDLE;
            } catch (IOException unused) {
                if (l) {
                    Log.e("SwanAppAudioPlayer", "set data source fail");
                }
                if (this.f11060e != null) {
                    JSONObject jSONObject = new JSONObject();
                    if (SwanAppNetworkUtils.i(null)) {
                        jSONObject.optString(RouterCallback.KEY_ERROR_CODE, LightappConstants.ERRCODE_NO_PERMISSION);
                    } else {
                        jSONObject.optString(RouterCallback.KEY_ERROR_CODE, LightappConstants.ERRCODE_INNER_ERROR);
                    }
                    this.f11060e.a("onError");
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
            if (l) {
                Log.d("SwanAppAudioPlayer", "===start");
            }
            C();
            u().start();
            d dVar = this.f11059d;
            if (dVar != null) {
                dVar.sendEmptyMessage(0);
            }
            d.a.n0.a.i1.c.e.a aVar = this.f11060e;
            if (aVar != null) {
                aVar.a("onPlay");
            }
            K();
            int i2 = this.f11058c.f45354d;
            if (i2 > 0) {
                D(i2);
            }
            if (d.a.n0.a.c1.b.f().b()) {
                y();
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f11062g = UserStatus.STOP;
            if (this.f11061f == PlayerStatus.PREPARED) {
                if (l) {
                    Log.d("SwanAppAudioPlayer", "===stop");
                }
                u().stop();
                this.f11061f = PlayerStatus.IDLE;
                d dVar = this.f11059d;
                if (dVar != null) {
                    dVar.removeMessages(0);
                }
                d.a.n0.a.i1.c.e.a aVar = this.f11060e;
                if (aVar != null) {
                    aVar.a(MissionEvent.MESSAGE_STOP);
                }
            }
        }
    }

    public void J(d.a.n0.a.i1.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            if (l) {
                Log.d("SwanAppAudioPlayer", "===update -> " + bVar);
            }
            String str = this.f11058c.f45353c;
            this.f11058c = bVar;
            d.a.n0.a.i1.c.e.a aVar = this.f11060e;
            if (aVar != null) {
                aVar.d(bVar.j);
            }
            K();
            if (TextUtils.equals(bVar.f45353c, str)) {
                return;
            }
            if (l) {
                Log.d("SwanAppAudioPlayer", "update src: " + bVar.f45353c);
            }
            this.k = true;
            A();
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            F(this.f11058c.f45356f);
            G(this.f11058c.f45359i);
        }
    }

    public final void a() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.f11064i) {
            AudioManager audioManager = this.f11063h;
            if (audioManager != null && (bVar = this.j) != null) {
                audioManager.abandonAudioFocus(bVar);
                this.f11063h = null;
                this.j = null;
            }
            this.f11064i = false;
            if (l) {
                Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
            }
        }
    }

    @Override // d.a.n0.a.i1.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f11058c.f45352b : (String) invokeV.objValue;
    }

    @Override // d.a.n0.a.i1.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f11056a : (String) invokeV.objValue;
    }

    @Override // d.a.n0.a.i1.a
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.n0.a.i1.a
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this : invokeV.objValue;
    }

    @Override // d.a.n0.a.i1.a
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            if (l) {
                Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
            }
            if (z) {
                return;
            }
            y();
        }
    }

    @Override // d.a.n0.a.i1.a
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (l) {
                Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
            }
            e i2 = e.i();
            if (i2 == null || !i2.m0()) {
                return;
            }
            if (!z) {
                y();
            } else if (this.f11062g == UserStatus.PLAY) {
                z();
            }
        }
    }

    @Override // d.a.n0.a.i1.a
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.n0.a.i1.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (l) {
                Log.d("SwanAppAudioPlayer", "--onDestroy");
            }
            e i2 = e.i();
            if (i2 == null || !i2.m0()) {
                return;
            }
            B();
        }
    }

    public d.a.n0.a.i1.c.b t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f11058c : (d.a.n0.a.i1.c.b) invokeV.objValue;
    }

    public final MediaPlayer u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.f11057b == null) {
                this.f11057b = new MediaPlayer();
                c cVar = new c(this, null);
                this.f11057b.setOnPreparedListener(cVar);
                this.f11057b.setOnCompletionListener(cVar);
                this.f11057b.setOnInfoListener(cVar);
                this.f11057b.setOnErrorListener(cVar);
                this.f11057b.setOnSeekCompleteListener(cVar);
                this.f11057b.setOnBufferingUpdateListener(cVar);
                this.f11059d = new d(this, null);
            }
            return this.f11057b;
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
                Log.d("SwanAppAudioPlayer", "   isMixWithOther -> " + booleanValue);
            }
            return booleanValue;
        }
        return invokeV.booleanValue;
    }

    public void w(d.a.n0.a.i1.c.b bVar, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, bVar, callbackHandler) == null) {
            if (l) {
                Log.d("SwanAppAudioPlayer", "===openPlayer");
            }
            this.f11062g = UserStatus.OPEN;
            this.f11058c = bVar;
            if (bVar.j != null) {
                try {
                    this.f11060e = new d.a.n0.a.i1.c.e.a(callbackHandler, new JSONObject(this.f11058c.j));
                } catch (JSONException unused) {
                    if (l) {
                        Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                    }
                }
            }
            u().reset();
            E(this.f11058c.f45353c);
            A();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (l) {
                Log.d("SwanAppAudioPlayer", "===pause");
            }
            this.f11062g = UserStatus.PAUSE;
            y();
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && u().isPlaying()) {
            u().pause();
            d.a.n0.a.i1.c.e.a aVar = this.f11060e;
            if (aVar != null) {
                aVar.a(MissionEvent.MESSAGE_PAUSE);
            }
            d dVar = this.f11059d;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.f11062g = UserStatus.PLAY;
            if (d.a.n0.a.c1.b.f().b()) {
                return;
            }
            if (l) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            C();
            PlayerStatus playerStatus = this.f11061f;
            if (playerStatus == PlayerStatus.PREPARED) {
                u().start();
                d dVar = this.f11059d;
                if (dVar != null) {
                    dVar.sendEmptyMessage(0);
                }
                d.a.n0.a.i1.c.e.a aVar = this.f11060e;
                if (aVar != null) {
                    aVar.a("onPlay");
                }
            } else if (playerStatus == PlayerStatus.IDLE) {
                u().prepareAsync();
                this.f11061f = PlayerStatus.PREPARING;
            }
        }
    }
}
