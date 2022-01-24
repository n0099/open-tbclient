package com.baidu.swan.apps.adaptation.implementation;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.k;
import c.a.r0.a.p.d.s;
import c.a.r0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.media.audio.service.BgMusicPlayState;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes11.dex */
public class DefaultSwanAppBgMusicPlayer implements s {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f38621h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile DefaultSwanAppBgMusicPlayer f38622i;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaPlayer a;

    /* renamed from: b  reason: collision with root package name */
    public PlayerStatus f38623b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.a.j1.c.g.a f38624c;

    /* renamed from: d  reason: collision with root package name */
    public AudioManager f38625d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f38626e;

    /* renamed from: f  reason: collision with root package name */
    public b f38627f;

    /* renamed from: g  reason: collision with root package name */
    public d f38628g;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1275615880, "Lcom/baidu/swan/apps/adaptation/implementation/DefaultSwanAppBgMusicPlayer$PlayerStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1275615880, "Lcom/baidu/swan/apps/adaptation/implementation/DefaultSwanAppBgMusicPlayer$PlayerStatus;");
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

    /* loaded from: classes11.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public class b implements AudioManager.OnAudioFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DefaultSwanAppBgMusicPlayer a;

        /* loaded from: classes11.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f38629e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f38630f;

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
                this.f38630f = bVar;
                this.f38629e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i2 = this.f38629e;
                    if (i2 == -2 || i2 == -1) {
                        boolean unused = DefaultSwanAppBgMusicPlayer.f38621h;
                        this.f38630f.a.b();
                        this.f38630f.a.pause();
                    }
                }
            }
        }

        public b(DefaultSwanAppBgMusicPlayer defaultSwanAppBgMusicPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {defaultSwanAppBgMusicPlayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = defaultSwanAppBgMusicPlayer;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                q0.e0(new a(this, i2));
            }
        }

        public /* synthetic */ b(DefaultSwanAppBgMusicPlayer defaultSwanAppBgMusicPlayer, a aVar) {
            this(defaultSwanAppBgMusicPlayer);
        }
    }

    /* loaded from: classes11.dex */
    public class c implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnBufferingUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DefaultSwanAppBgMusicPlayer f38631e;

        public c(DefaultSwanAppBgMusicPlayer defaultSwanAppBgMusicPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {defaultSwanAppBgMusicPlayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38631e = defaultSwanAppBgMusicPlayer;
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, mediaPlayer, i2) == null) {
                if (DefaultSwanAppBgMusicPlayer.f38621h) {
                    String str = "--onBufferUpdate -> " + i2 + "%";
                }
                this.f38631e.f38624c.onGetDownloadProgress(i2);
                if (this.f38631e.f38623b != PlayerStatus.PREPARED || (i2 * this.f38631e.k().getDuration()) / 100 > this.f38631e.k().getCurrentPosition()) {
                    return;
                }
                this.f38631e.f38624c.onStateChanged(BgMusicPlayState.LOADING);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaPlayer) == null) {
                boolean unused = DefaultSwanAppBgMusicPlayer.f38621h;
                this.f38631e.f38623b = PlayerStatus.PREPARED;
                this.f38631e.f38624c.onStateChanged(BgMusicPlayState.END);
                if (this.f38631e.f38628g != null) {
                    this.f38631e.f38628g.removeMessages(0);
                }
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, mediaPlayer, i2, i3)) == null) {
                if (DefaultSwanAppBgMusicPlayer.f38621h) {
                    String str = "--onError -> what: " + i2 + " extra: " + i3;
                }
                c.a.r0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 2008, "--onError -> what: " + i2 + " extra: " + i3, -1, "");
                return true;
            }
            return invokeLII.booleanValue;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, mediaPlayer) == null) {
                boolean unused = DefaultSwanAppBgMusicPlayer.f38621h;
                this.f38631e.f38623b = PlayerStatus.PREPARED;
                this.f38631e.f38624c.onStateChanged(BgMusicPlayState.READY);
                this.f38631e.play();
            }
        }

        public /* synthetic */ c(DefaultSwanAppBgMusicPlayer defaultSwanAppBgMusicPlayer, a aVar) {
            this(defaultSwanAppBgMusicPlayer);
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes11.dex */
    public class d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DefaultSwanAppBgMusicPlayer a;

        public d(DefaultSwanAppBgMusicPlayer defaultSwanAppBgMusicPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {defaultSwanAppBgMusicPlayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = defaultSwanAppBgMusicPlayer;
        }

        public final int a(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
                if (i3 > i2) {
                    i3 = i2;
                }
                if (i2 > 0) {
                    return (int) ((((i3 * 100) * 1.0f) / i2) + 0.5f);
                }
                return 0;
            }
            return invokeII.intValue;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) && message.what == 0) {
                int duration = this.a.k().getDuration();
                int currentPosition = this.a.k().getCurrentPosition();
                this.a.f38624c.onGetDuration(duration);
                this.a.f38624c.onGetPosition(currentPosition, a(duration, currentPosition));
                sendEmptyMessageDelayed(0, 200L);
            }
        }

        public /* synthetic */ d(DefaultSwanAppBgMusicPlayer defaultSwanAppBgMusicPlayer, a aVar) {
            this(defaultSwanAppBgMusicPlayer);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-665712169, "Lcom/baidu/swan/apps/adaptation/implementation/DefaultSwanAppBgMusicPlayer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-665712169, "Lcom/baidu/swan/apps/adaptation/implementation/DefaultSwanAppBgMusicPlayer;");
                return;
            }
        }
        f38621h = k.a;
    }

    public DefaultSwanAppBgMusicPlayer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38623b = PlayerStatus.NONE;
    }

    public static DefaultSwanAppBgMusicPlayer j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f38622i == null) {
                synchronized (DefaultSwanAppBgMusicPlayer.class) {
                    if (f38622i == null) {
                        f38622i = new DefaultSwanAppBgMusicPlayer();
                    }
                }
            }
            return f38622i;
        }
        return (DefaultSwanAppBgMusicPlayer) invokeV.objValue;
    }

    @Override // c.a.r0.a.p.d.s
    public void a(String str, c.a.r0.a.j1.c.g.a aVar) {
        String str2;
        c.a.r0.a.j1.c.a b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f38624c = aVar;
        try {
            b2 = c.a.r0.a.j1.c.a.b(new JSONObject(str), new c.a.r0.a.j1.c.a());
            str2 = b2.f7426c;
        } catch (IOException | JSONException e2) {
            e = e2;
            str2 = "";
        }
        try {
            if (this.f38623b != PlayerStatus.NONE) {
                k().reset();
            }
            k().setDataSource(b2.f7426c);
            this.f38623b = PlayerStatus.IDLE;
            this.f38624c.onGetCurrentSong(b2.f7426c);
            play();
        } catch (IOException e3) {
            e = e3;
            c.a.r0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 1001, "audio src error, src is" + str2, -1, "");
            e.printStackTrace();
            this.f38624c.onInvokeFailed();
        } catch (JSONException e4) {
            e = e4;
            c.a.r0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 1001, "audio src error, src is" + str2, -1, "");
            e.printStackTrace();
            this.f38624c.onInvokeFailed();
        }
    }

    public final void b() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f38626e) {
            AudioManager audioManager = this.f38625d;
            if (audioManager != null && (bVar = this.f38627f) != null) {
                audioManager.abandonAudioFocus(bVar);
                this.f38625d = null;
                this.f38627f = null;
            }
            this.f38626e = false;
            boolean z = f38621h;
        }
    }

    @Override // c.a.r0.a.p.d.s
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? k().getDuration() : invokeV.intValue;
    }

    @Override // c.a.r0.a.p.d.s
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? k().isPlaying() : invokeV.booleanValue;
    }

    public final MediaPlayer k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a == null) {
                this.a = new MediaPlayer();
                c cVar = new c(this, null);
                this.a.setOnPreparedListener(cVar);
                this.a.setOnCompletionListener(cVar);
                this.a.setOnErrorListener(cVar);
                this.a.setOnBufferingUpdateListener(cVar);
                this.a.setAudioStreamType(3);
                this.f38628g = new d(this, null);
            }
            return this.a;
        }
        return (MediaPlayer) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                k().prepareAsync();
                this.f38623b = PlayerStatus.PREPARING;
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                this.f38624c.onInvokeFailed();
                onRelease();
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f38626e) {
            return;
        }
        if (this.f38625d == null) {
            AudioManager audioManager = (AudioManager) AppRuntime.getAppContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            this.f38625d = audioManager;
            if (audioManager == null) {
                return;
            }
        }
        if (this.f38627f == null) {
            this.f38627f = new b(this, null);
        }
        this.f38626e = this.f38625d.requestAudioFocus(this.f38627f, 3, 1) == 1;
        boolean z = f38621h;
    }

    @Override // c.a.r0.a.p.d.s
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b();
            k().release();
            this.a = null;
            this.f38623b = PlayerStatus.NONE;
            d dVar = this.f38628g;
            if (dVar != null) {
                dVar.removeMessages(0);
                this.f38628g = null;
            }
        }
    }

    @Override // c.a.r0.a.p.d.s
    public void pause() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && k().isPlaying()) {
            k().pause();
            this.f38624c.onStateChanged(BgMusicPlayState.PAUSE);
            d dVar = this.f38628g;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }

    @Override // c.a.r0.a.p.d.s
    public void play() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            PlayerStatus playerStatus = this.f38623b;
            if (playerStatus == PlayerStatus.PREPARED) {
                m();
                k().start();
                this.f38624c.onStateChanged(BgMusicPlayState.PLAY);
                d dVar = this.f38628g;
                if (dVar != null) {
                    dVar.sendEmptyMessage(0);
                }
            } else if (playerStatus == PlayerStatus.IDLE) {
                l();
            }
        }
    }

    @Override // c.a.r0.a.p.d.s
    public void seek(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            k().seekTo(i2);
        }
    }

    @Override // c.a.r0.a.p.d.s
    public void stop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.f38623b == PlayerStatus.PREPARED) {
            boolean z = f38621h;
            k().stop();
            this.f38623b = PlayerStatus.IDLE;
            this.f38624c.onStateChanged(BgMusicPlayState.STOP);
            d dVar = this.f38628g;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }
}
