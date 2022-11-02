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
import com.baidu.mapapi.UIMsg;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.ad3;
import com.baidu.tieba.cr2;
import com.baidu.tieba.dr2;
import com.baidu.tieba.e43;
import com.baidu.tieba.fr2;
import com.baidu.tieba.kb3;
import com.baidu.tieba.kr2;
import com.baidu.tieba.lh3;
import com.baidu.tieba.mn2;
import com.baidu.tieba.ok1;
import com.baidu.tieba.rp2;
import com.baidu.tieba.ya2;
import com.baidu.tieba.yh3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SwanAppAudioPlayer implements cr2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public MediaPlayer b;
    public fr2 c;
    public d d;
    public kr2 e;
    public PlayerStatus f;
    public UserStatus g;
    public AudioManager h;
    public boolean i;
    public b j;
    public boolean k;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Override // com.baidu.tieba.cr2
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cr2
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this : invokeV.objValue;
    }

    @Override // com.baidu.tieba.cr2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes3.dex */
    public class b implements AudioManager.OnAudioFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAudioPlayer a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ b b;

            public a(b bVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b.a.w()) {
                    return;
                }
                int i = this.a;
                if (i != -2) {
                    if (i == -1) {
                        if (SwanAppAudioPlayer.l) {
                            Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS");
                        }
                        this.b.a.a();
                        this.b.a.z();
                        return;
                    }
                    return;
                }
                if (SwanAppAudioPlayer.l) {
                    Log.d("SwanAppAudioPlayer", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                }
                this.b.a.a();
                this.b.a.z();
            }
        }

        public b(SwanAppAudioPlayer swanAppAudioPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioPlayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAudioPlayer;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                yh3.e0(new a(this, i));
            }
        }

        public /* synthetic */ b(SwanAppAudioPlayer swanAppAudioPlayer, a aVar) {
            this(swanAppAudioPlayer);
        }
    }

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
            NONE = new PlayerStatus(HlsPlaylistParser.METHOD_NONE, 0);
            IDLE = new PlayerStatus("IDLE", 1);
            PREPARING = new PlayerStatus("PREPARING", 2);
            PlayerStatus playerStatus = new PlayerStatus("PREPARED", 3);
            PREPARED = playerStatus;
            $VALUES = new PlayerStatus[]{NONE, IDLE, PREPARING, playerStatus};
        }

        public PlayerStatus(String str, int i) {
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

        public static PlayerStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (PlayerStatus) Enum.valueOf(PlayerStatus.class, str);
            }
            return (PlayerStatus) invokeL.objValue;
        }

        public static PlayerStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (PlayerStatus[]) $VALUES.clone();
            }
            return (PlayerStatus[]) invokeV.objValue;
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
            PAUSE = new UserStatus("PAUSE", 2);
            STOP = new UserStatus("STOP", 3);
            UserStatus userStatus = new UserStatus("DESTROY", 4);
            DESTROY = userStatus;
            $VALUES = new UserStatus[]{OPEN, PLAY, PAUSE, STOP, userStatus};
        }

        public UserStatus(String str, int i) {
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

        public static UserStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (UserStatus) Enum.valueOf(UserStatus.class, str);
            }
            return (UserStatus) invokeL.objValue;
        }

        public static UserStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (UserStatus[]) $VALUES.clone();
            }
            return (UserStatus[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnInfoListener, MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnBufferingUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAudioPlayer a;

        public c(SwanAppAudioPlayer swanAppAudioPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioPlayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAudioPlayer;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, mediaPlayer) == null) {
                if (SwanAppAudioPlayer.l) {
                    Log.d("SwanAppAudioPlayer", "--onSeekComplete");
                }
                if (this.a.e != null) {
                    this.a.e.a("onSeeked");
                }
            }
        }

        public /* synthetic */ c(SwanAppAudioPlayer swanAppAudioPlayer, a aVar) {
            this(swanAppAudioPlayer);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, mediaPlayer, i) == null) {
                if (SwanAppAudioPlayer.l) {
                    Log.d("SwanAppAudioPlayer", "--onBufferUpdate -> " + i + "%");
                }
                if (this.a.f == PlayerStatus.PREPARED && (i * this.a.v().getDuration()) / 100 <= this.a.v().getCurrentPosition() && this.a.e != null) {
                    this.a.e.a("onWaiting");
                }
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaPlayer) == null) {
                if (SwanAppAudioPlayer.l) {
                    Log.d("SwanAppAudioPlayer", "--onCompletion");
                }
                if (!this.a.v().isLooping()) {
                    this.a.g = UserStatus.STOP;
                }
                this.a.f = PlayerStatus.PREPARED;
                if (this.a.e != null) {
                    this.a.e.a("onEnded");
                }
                this.a.d.removeMessages(0);
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, mediaPlayer, i, i2)) == null) {
                if (SwanAppAudioPlayer.l) {
                    Log.d("SwanAppAudioPlayer", "--onError -> what: " + i + " extra: " + i2);
                }
                String str = "-1";
                if (i != 1 && i == 100) {
                    str = "10001";
                }
                if (i2 == -1007) {
                    str = "10004";
                }
                kb3.b("audio", 2008, "audio fail, src: " + this.a.c.c, Integer.parseInt(str), "");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt(StatConstants.KEY_EXT_ERR_CODE, str);
                } catch (JSONException e) {
                    if (SwanAppAudioPlayer.l) {
                        Log.d("SwanAppAudioPlayer", Log.getStackTraceString(e));
                    }
                }
                if (this.a.e != null) {
                    this.a.e.b("onError", jSONObject);
                }
                return true;
            }
            return invokeLII.booleanValue;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, mediaPlayer, i, i2)) == null) {
                if (SwanAppAudioPlayer.l) {
                    Log.d("SwanAppAudioPlayer", "--oninfo -> what: " + i + " ,extra: " + i2);
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
                this.a.f = PlayerStatus.PREPARED;
                if (this.a.e != null) {
                    this.a.e.a("onCanplay");
                }
                if (UserStatus.PLAY == this.a.g) {
                    this.a.I();
                }
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAudioPlayer;
        }

        public /* synthetic */ d(SwanAppAudioPlayer swanAppAudioPlayer, a aVar) {
            this(swanAppAudioPlayer);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("currentTime", Long.valueOf(this.a.v().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(this.a.v().getDuration() / 1000));
                    if (this.a.e != null) {
                        this.a.e.b("onTimeUpdate", jSONObject);
                    }
                } catch (JSONException e) {
                    if (SwanAppAudioPlayer.l) {
                        e.printStackTrace();
                    }
                }
                sendEmptyMessageDelayed(0, 1000L);
            }
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
        l = ok1.a;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.k) {
                v().reset();
                F(this.c.c);
                this.k = false;
            }
            v().prepareAsync();
            this.f = PlayerStatus.PREPARING;
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            G(this.c.f);
            H(this.c.i);
        }
    }

    @Override // com.baidu.tieba.cr2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.c.b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cr2
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cr2
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (l) {
                Log.d("SwanAppAudioPlayer", "--onDestroy");
            }
            e43 M = e43.M();
            if (M != null && M.w0()) {
                C();
            }
        }
    }

    public fr2 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.c;
        }
        return (fr2) invokeV.objValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (l) {
                Log.d("SwanAppAudioPlayer", "===pause");
            }
            this.g = UserStatus.PAUSE;
            z();
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && v().isPlaying()) {
            v().pause();
            kr2 kr2Var = this.e;
            if (kr2Var != null) {
                kr2Var.a(MissionEvent.MESSAGE_PAUSE);
            }
            d dVar = this.d;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }

    public SwanAppAudioPlayer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "";
        this.c = new fr2();
        this.f = PlayerStatus.NONE;
        this.g = UserStatus.OPEN;
        this.k = false;
        this.a = str;
        dr2.a(this);
    }

    public void update(fr2 fr2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, fr2Var) == null) {
            if (l) {
                Log.d("SwanAppAudioPlayer", "===update -> " + fr2Var);
            }
            String str = this.c.c;
            this.c = fr2Var;
            kr2 kr2Var = this.e;
            if (kr2Var != null) {
                kr2Var.d(fr2Var.j);
            }
            K();
            if (!TextUtils.equals(fr2Var.c, str)) {
                if (l) {
                    Log.d("SwanAppAudioPlayer", "update src: " + fr2Var.c);
                }
                this.k = true;
                B();
            }
        }
    }

    public final void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            v().setLooping(z);
        }
    }

    public final void H(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f) == null) {
            if (f > 1.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = 0.0f;
            }
            v().setVolume(f, f);
        }
    }

    @Override // com.baidu.tieba.cr2
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            if (l) {
                Log.d("SwanAppAudioPlayer", "--onAppForegroundChanged -> " + z);
            }
            if (!z) {
                z();
            }
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g = UserStatus.PLAY;
            if (mn2.f().b()) {
                return;
            }
            if (l) {
                Log.d("SwanAppAudioPlayer", "===play");
            }
            D();
            PlayerStatus playerStatus = this.f;
            if (playerStatus == PlayerStatus.PREPARED) {
                v().start();
                d dVar = this.d;
                if (dVar != null) {
                    dVar.sendEmptyMessage(0);
                }
                kr2 kr2Var = this.e;
                if (kr2Var != null) {
                    kr2Var.a("onPlay");
                }
            } else if (playerStatus == PlayerStatus.IDLE) {
                v().prepareAsync();
                this.f = PlayerStatus.PREPARING;
            }
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || w() || this.i) {
            return;
        }
        if (this.h == null) {
            AudioManager audioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
            this.h = audioManager;
            if (audioManager == null) {
                return;
            }
        }
        if (this.j == null) {
            this.j = new b(this, null);
        }
        boolean z = true;
        if (this.h.requestAudioFocus(this.j, 3, 1) != 1) {
            z = false;
        }
        this.i = z;
        if (l) {
            Log.d("SwanAppAudioPlayer", "   requestAudioFocus");
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (l) {
                Log.d("SwanAppAudioPlayer", "===start");
            }
            D();
            v().start();
            d dVar = this.d;
            if (dVar != null) {
                dVar.sendEmptyMessage(0);
            }
            kr2 kr2Var = this.e;
            if (kr2Var != null) {
                kr2Var.a("onPlay");
            }
            K();
            int i = this.c.d;
            if (i > 0) {
                E(i);
            }
            if (mn2.f().b()) {
                z();
            }
        }
    }

    public final MediaPlayer v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.b == null) {
                this.b = new MediaPlayer();
                c cVar = new c(this, null);
                this.b.setOnPreparedListener(cVar);
                this.b.setOnCompletionListener(cVar);
                this.b.setOnInfoListener(cVar);
                this.b.setOnErrorListener(cVar);
                this.b.setOnSeekCompleteListener(cVar);
                this.b.setOnBufferingUpdateListener(cVar);
                this.d = new d(this, null);
            }
            return this.b;
        }
        return (MediaPlayer) invokeV.objValue;
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (l) {
                Log.d("SwanAppAudioPlayer", "===release");
            }
            this.g = UserStatus.DESTROY;
            a();
            v().release();
            this.f = PlayerStatus.NONE;
            this.b = null;
            d dVar = this.d;
            if (dVar != null) {
                dVar.removeMessages(0);
                this.d = null;
            }
            dr2.k(this);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.g = UserStatus.STOP;
            if (this.f == PlayerStatus.PREPARED) {
                if (l) {
                    Log.d("SwanAppAudioPlayer", "===stop");
                }
                v().stop();
                this.f = PlayerStatus.IDLE;
                d dVar = this.d;
                if (dVar != null) {
                    dVar.removeMessages(0);
                }
                kr2 kr2Var = this.e;
                if (kr2Var != null) {
                    kr2Var.a(MissionEvent.MESSAGE_STOP);
                }
            }
        }
    }

    public final void a() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || !this.i) {
            return;
        }
        AudioManager audioManager = this.h;
        if (audioManager != null && (bVar = this.j) != null) {
            audioManager.abandonAudioFocus(bVar);
            this.h = null;
            this.j = null;
        }
        this.i = false;
        if (l) {
            Log.d("SwanAppAudioPlayer", "   abandonAudioFocus");
        }
    }

    public final boolean w() {
        InterceptResult invokeV;
        boolean booleanValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            e43 M = e43.M();
            if (M == null) {
                booleanValue = false;
            } else {
                booleanValue = M.U().c("key_audio_is_mix_with_other", Boolean.FALSE).booleanValue();
            }
            if (l) {
                Log.d("SwanAppAudioPlayer", "   isMixWithOther -> " + booleanValue);
            }
            return booleanValue;
        }
        return invokeV.booleanValue;
    }

    public void E(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && this.f == PlayerStatus.PREPARED) {
            if (l) {
                Log.d("SwanAppAudioPlayer", "===seekTo ->" + i);
            }
            v().seekTo((int) (i * 1000));
            kr2 kr2Var = this.e;
            if (kr2Var != null) {
                kr2Var.a("onSeeking");
            }
        }
    }

    @Override // com.baidu.tieba.cr2
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (l) {
                Log.d("SwanAppAudioPlayer", "--onForegroundChanged -> " + z);
            }
            e43 M = e43.M();
            if (M != null && M.w0()) {
                if (!z) {
                    z();
                } else if (this.g == UserStatus.PLAY) {
                    A();
                }
            }
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            try {
                str = rp2.U().G().a(str);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                HashMap hashMap = new HashMap();
                String b2 = lh3.b();
                if (!TextUtils.isEmpty(b2) && lh3.c(str)) {
                    if (l) {
                        Log.d("SwanAppAudioPlayer", "set referer for AudioPlayer; referer is" + b2);
                    }
                    hashMap.put("Referer", b2);
                }
                String g0 = ya2.U().g0();
                if (!TextUtils.isEmpty(g0)) {
                    hashMap.put("User-Agent", g0);
                }
                String j = ad3.l().j(str);
                if (!TextUtils.isEmpty(j)) {
                    hashMap.put("Cookie", j);
                    if (l) {
                        Log.d("SwanAppAudioPlayer", "addCookiesToHeader cookie: " + j);
                    }
                }
                v().setDataSource(AppRuntime.getAppContext(), Uri.parse(str), hashMap);
                this.f = PlayerStatus.IDLE;
            } catch (IOException unused) {
                kb3.b("audio", 1001, "src replace fail, src is" + str, -1, "");
                if (l) {
                    Log.e("SwanAppAudioPlayer", "set data source fail");
                }
                if (this.e != null) {
                    JSONObject jSONObject = new JSONObject();
                    if (SwanAppNetworkUtils.i(null)) {
                        jSONObject.optString(StatConstants.KEY_EXT_ERR_CODE, "10002");
                    } else {
                        jSONObject.optString(StatConstants.KEY_EXT_ERR_CODE, "10003");
                    }
                    this.e.a("onError");
                }
            }
        }
    }

    public void x(fr2 fr2Var, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, fr2Var, callbackHandler) == null) {
            if (l) {
                Log.d("SwanAppAudioPlayer", "===openPlayer");
            }
            this.g = UserStatus.OPEN;
            this.c = fr2Var;
            if (fr2Var.j != null) {
                try {
                    this.e = new kr2(callbackHandler, new JSONObject(this.c.j));
                } catch (JSONException unused) {
                    kb3.b("audio", UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, "Audio callback is not jsonObject", -1, "");
                    if (l) {
                        Log.e("SwanAppAudioPlayer", "Audio callback is not jsonObject");
                    }
                }
            }
            v().reset();
            F(this.c.c);
            B();
        }
    }
}
