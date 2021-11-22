package com.baidu.swan.apps.adaptation.implementation;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.a.p.d.s;
import b.a.p0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes7.dex */
public class DefaultSwanAppBgMusicPlayer implements s {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f44211h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile DefaultSwanAppBgMusicPlayer f44212i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MediaPlayer f44213a;

    /* renamed from: b  reason: collision with root package name */
    public PlayerStatus f44214b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.p0.a.j1.c.g.a f44215c;

    /* renamed from: d  reason: collision with root package name */
    public AudioManager f44216d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f44217e;

    /* renamed from: f  reason: collision with root package name */
    public b f44218f;

    /* renamed from: g  reason: collision with root package name */
    public d f44219g;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b implements AudioManager.OnAudioFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DefaultSwanAppBgMusicPlayer f44220a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f44221e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f44222f;

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
                this.f44222f = bVar;
                this.f44221e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i2 = this.f44221e;
                    if (i2 == -2 || i2 == -1) {
                        boolean unused = DefaultSwanAppBgMusicPlayer.f44211h;
                        this.f44222f.f44220a.b();
                        this.f44222f.f44220a.pause();
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
            this.f44220a = defaultSwanAppBgMusicPlayer;
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

    /* loaded from: classes7.dex */
    public class c implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnBufferingUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DefaultSwanAppBgMusicPlayer f44223e;

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
            this.f44223e = defaultSwanAppBgMusicPlayer;
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, mediaPlayer, i2) == null) {
                if (DefaultSwanAppBgMusicPlayer.f44211h) {
                    String str = "--onBufferUpdate -> " + i2 + "%";
                }
                this.f44223e.f44215c.onGetDownloadProgress(i2);
                if (this.f44223e.f44214b != PlayerStatus.PREPARED || (i2 * this.f44223e.k().getDuration()) / 100 > this.f44223e.k().getCurrentPosition()) {
                    return;
                }
                this.f44223e.f44215c.onStateChanged(BgMusicPlayState.LOADING);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaPlayer) == null) {
                boolean unused = DefaultSwanAppBgMusicPlayer.f44211h;
                this.f44223e.f44214b = PlayerStatus.PREPARED;
                this.f44223e.f44215c.onStateChanged(BgMusicPlayState.END);
                if (this.f44223e.f44219g != null) {
                    this.f44223e.f44219g.removeMessages(0);
                }
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, mediaPlayer, i2, i3)) == null) {
                if (DefaultSwanAppBgMusicPlayer.f44211h) {
                    String str = "--onError -> what: " + i2 + " extra: " + i3;
                }
                b.a.p0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 2008, "--onError -> what: " + i2 + " extra: " + i3, -1, "");
                return true;
            }
            return invokeLII.booleanValue;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, mediaPlayer) == null) {
                boolean unused = DefaultSwanAppBgMusicPlayer.f44211h;
                this.f44223e.f44214b = PlayerStatus.PREPARED;
                this.f44223e.f44215c.onStateChanged(BgMusicPlayState.READY);
                this.f44223e.play();
            }
        }

        public /* synthetic */ c(DefaultSwanAppBgMusicPlayer defaultSwanAppBgMusicPlayer, a aVar) {
            this(defaultSwanAppBgMusicPlayer);
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes7.dex */
    public class d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DefaultSwanAppBgMusicPlayer f44224a;

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
            this.f44224a = defaultSwanAppBgMusicPlayer;
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
                int duration = this.f44224a.k().getDuration();
                int currentPosition = this.f44224a.k().getCurrentPosition();
                this.f44224a.f44215c.onGetDuration(duration);
                this.f44224a.f44215c.onGetPosition(currentPosition, a(duration, currentPosition));
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
        f44211h = k.f6863a;
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
        this.f44214b = PlayerStatus.NONE;
    }

    public static DefaultSwanAppBgMusicPlayer j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f44212i == null) {
                synchronized (DefaultSwanAppBgMusicPlayer.class) {
                    if (f44212i == null) {
                        f44212i = new DefaultSwanAppBgMusicPlayer();
                    }
                }
            }
            return f44212i;
        }
        return (DefaultSwanAppBgMusicPlayer) invokeV.objValue;
    }

    @Override // b.a.p0.a.p.d.s
    public void a(String str, b.a.p0.a.j1.c.g.a aVar) {
        String str2;
        b.a.p0.a.j1.c.a b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f44215c = aVar;
        try {
            b2 = b.a.p0.a.j1.c.a.b(new JSONObject(str), new b.a.p0.a.j1.c.a());
            str2 = b2.f6563c;
        } catch (IOException | JSONException e2) {
            e = e2;
            str2 = "";
        }
        try {
            if (this.f44214b != PlayerStatus.NONE) {
                k().reset();
            }
            k().setDataSource(b2.f6563c);
            this.f44214b = PlayerStatus.IDLE;
            this.f44215c.onGetCurrentSong(b2.f6563c);
            play();
        } catch (IOException e3) {
            e = e3;
            b.a.p0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 1001, "audio src error, src is" + str2, -1, "");
            e.printStackTrace();
            this.f44215c.onInvokeFailed();
        } catch (JSONException e4) {
            e = e4;
            b.a.p0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 1001, "audio src error, src is" + str2, -1, "");
            e.printStackTrace();
            this.f44215c.onInvokeFailed();
        }
    }

    public final void b() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f44217e) {
            AudioManager audioManager = this.f44216d;
            if (audioManager != null && (bVar = this.f44218f) != null) {
                audioManager.abandonAudioFocus(bVar);
                this.f44216d = null;
                this.f44218f = null;
            }
            this.f44217e = false;
            boolean z = f44211h;
        }
    }

    @Override // b.a.p0.a.p.d.s
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? k().getDuration() : invokeV.intValue;
    }

    @Override // b.a.p0.a.p.d.s
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? k().isPlaying() : invokeV.booleanValue;
    }

    public final MediaPlayer k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f44213a == null) {
                this.f44213a = new MediaPlayer();
                c cVar = new c(this, null);
                this.f44213a.setOnPreparedListener(cVar);
                this.f44213a.setOnCompletionListener(cVar);
                this.f44213a.setOnErrorListener(cVar);
                this.f44213a.setOnBufferingUpdateListener(cVar);
                this.f44213a.setAudioStreamType(3);
                this.f44219g = new d(this, null);
            }
            return this.f44213a;
        }
        return (MediaPlayer) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                k().prepareAsync();
                this.f44214b = PlayerStatus.PREPARING;
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                this.f44215c.onInvokeFailed();
                onRelease();
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f44217e) {
            return;
        }
        if (this.f44216d == null) {
            AudioManager audioManager = (AudioManager) AppRuntime.getAppContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            this.f44216d = audioManager;
            if (audioManager == null) {
                return;
            }
        }
        if (this.f44218f == null) {
            this.f44218f = new b(this, null);
        }
        this.f44217e = this.f44216d.requestAudioFocus(this.f44218f, 3, 1) == 1;
        boolean z = f44211h;
    }

    @Override // b.a.p0.a.p.d.s
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b();
            k().release();
            this.f44213a = null;
            this.f44214b = PlayerStatus.NONE;
            d dVar = this.f44219g;
            if (dVar != null) {
                dVar.removeMessages(0);
                this.f44219g = null;
            }
        }
    }

    @Override // b.a.p0.a.p.d.s
    public void pause() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && k().isPlaying()) {
            k().pause();
            this.f44215c.onStateChanged(BgMusicPlayState.PAUSE);
            d dVar = this.f44219g;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }

    @Override // b.a.p0.a.p.d.s
    public void play() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            PlayerStatus playerStatus = this.f44214b;
            if (playerStatus == PlayerStatus.PREPARED) {
                m();
                k().start();
                this.f44215c.onStateChanged(BgMusicPlayState.PLAY);
                d dVar = this.f44219g;
                if (dVar != null) {
                    dVar.sendEmptyMessage(0);
                }
            } else if (playerStatus == PlayerStatus.IDLE) {
                l();
            }
        }
    }

    @Override // b.a.p0.a.p.d.s
    public void seek(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            k().seekTo(i2);
        }
    }

    @Override // b.a.p0.a.p.d.s
    public void stop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.f44214b == PlayerStatus.PREPARED) {
            boolean z = f44211h;
            k().stop();
            this.f44214b = PlayerStatus.IDLE;
            this.f44215c.onStateChanged(BgMusicPlayState.STOP);
            d dVar = this.f44219g;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }
}
