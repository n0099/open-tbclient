package com.baidu.swan.apps.adaptation.implementation;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.media.audio.service.BgMusicPlayState;
import com.baidu.tieba.fh3;
import com.baidu.tieba.lq2;
import com.baidu.tieba.nn1;
import com.baidu.tieba.ra3;
import com.baidu.tieba.sq2;
import com.baidu.tieba.vj1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DefaultSwanAppBgMusicPlayer implements nn1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public static volatile DefaultSwanAppBgMusicPlayer i;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaPlayer a;
    public PlayerStatus b;
    public sq2 c;
    public AudioManager d;
    public boolean e;
    public b f;
    public d g;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PlayerStatus) Enum.valueOf(PlayerStatus.class, str) : (PlayerStatus) invokeL.objValue;
        }

        public static PlayerStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PlayerStatus[]) $VALUES.clone() : (PlayerStatus[]) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class b implements AudioManager.OnAudioFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DefaultSwanAppBgMusicPlayer a;

        /* loaded from: classes2.dex */
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
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i = this.a;
                    if (i == -2 || i == -1) {
                        if (DefaultSwanAppBgMusicPlayer.h) {
                            Log.d("AudioPlayerListener", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                        }
                        this.b.a.b();
                        this.b.a.pause();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = defaultSwanAppBgMusicPlayer;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                fh3.e0(new a(this, i));
            }
        }

        public /* synthetic */ b(DefaultSwanAppBgMusicPlayer defaultSwanAppBgMusicPlayer, a aVar) {
            this(defaultSwanAppBgMusicPlayer);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnBufferingUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DefaultSwanAppBgMusicPlayer a;

        public c(DefaultSwanAppBgMusicPlayer defaultSwanAppBgMusicPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {defaultSwanAppBgMusicPlayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = defaultSwanAppBgMusicPlayer;
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, mediaPlayer, i) == null) {
                if (DefaultSwanAppBgMusicPlayer.h) {
                    Log.d("AudioPlayerListener", "--onBufferUpdate -> " + i + "%");
                }
                this.a.c.onGetDownloadProgress(i);
                if (this.a.b != PlayerStatus.PREPARED || (i * this.a.k().getDuration()) / 100 > this.a.k().getCurrentPosition()) {
                    return;
                }
                this.a.c.onStateChanged(BgMusicPlayState.LOADING);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaPlayer) == null) {
                if (DefaultSwanAppBgMusicPlayer.h) {
                    Log.d("AudioPlayerListener", "--onCompletion");
                }
                this.a.b = PlayerStatus.PREPARED;
                this.a.c.onStateChanged(BgMusicPlayState.END);
                if (this.a.g != null) {
                    this.a.g.removeMessages(0);
                }
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, mediaPlayer, i, i2)) == null) {
                if (DefaultSwanAppBgMusicPlayer.h) {
                    Log.d("AudioPlayerListener", "--onError -> what: " + i + " extra: " + i2);
                }
                ra3.b("audio", 2008, "--onError -> what: " + i + " extra: " + i2, -1, "");
                return true;
            }
            return invokeLII.booleanValue;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, mediaPlayer) == null) {
                if (DefaultSwanAppBgMusicPlayer.h) {
                    Log.d("AudioPlayerListener", "--onPrepared");
                }
                this.a.b = PlayerStatus.PREPARED;
                this.a.c.onStateChanged(BgMusicPlayState.READY);
                this.a.play();
            }
        }

        public /* synthetic */ c(DefaultSwanAppBgMusicPlayer defaultSwanAppBgMusicPlayer, a aVar) {
            this(defaultSwanAppBgMusicPlayer);
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = defaultSwanAppBgMusicPlayer;
        }

        public final int a(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
                if (i2 > i) {
                    i2 = i;
                }
                if (i > 0) {
                    return (int) ((((i2 * 100) * 1.0f) / i) + 0.5f);
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
                this.a.c.onGetDuration(duration);
                this.a.c.onGetPosition(currentPosition, a(duration, currentPosition));
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
        h = vj1.a;
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
        this.b = PlayerStatus.NONE;
    }

    public static DefaultSwanAppBgMusicPlayer j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (i == null) {
                synchronized (DefaultSwanAppBgMusicPlayer.class) {
                    if (i == null) {
                        i = new DefaultSwanAppBgMusicPlayer();
                    }
                }
            }
            return i;
        }
        return (DefaultSwanAppBgMusicPlayer) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nn1
    public void a(String str, sq2 sq2Var) {
        String str2;
        lq2 b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, sq2Var) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.c = sq2Var;
        try {
            b2 = lq2.b(new JSONObject(str), new lq2());
            str2 = b2.c;
        } catch (IOException | JSONException e) {
            e = e;
            str2 = "";
        }
        try {
            if (this.b != PlayerStatus.NONE) {
                k().reset();
            }
            k().setDataSource(b2.c);
            this.b = PlayerStatus.IDLE;
            this.c.onGetCurrentSong(b2.c);
            play();
        } catch (IOException e2) {
            e = e2;
            ra3.b("audio", 1001, "audio src error, src is" + str2, -1, "");
            e.printStackTrace();
            this.c.onInvokeFailed();
        } catch (JSONException e3) {
            e = e3;
            ra3.b("audio", 1001, "audio src error, src is" + str2, -1, "");
            e.printStackTrace();
            this.c.onInvokeFailed();
        }
    }

    public final void b() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.e) {
            AudioManager audioManager = this.d;
            if (audioManager != null && (bVar = this.f) != null) {
                audioManager.abandonAudioFocus(bVar);
                this.d = null;
                this.f = null;
            }
            this.e = false;
            if (h) {
                Log.d("AudioPlayerListener", "   abandonAudioFocus");
            }
        }
    }

    @Override // com.baidu.tieba.nn1
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? k().getDuration() : invokeV.intValue;
    }

    @Override // com.baidu.tieba.nn1
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
                this.g = new d(this, null);
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
                this.b = PlayerStatus.PREPARING;
            } catch (IllegalStateException e) {
                e.printStackTrace();
                this.c.onInvokeFailed();
                onRelease();
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.e) {
            return;
        }
        if (this.d == null) {
            AudioManager audioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
            this.d = audioManager;
            if (audioManager == null) {
                return;
            }
        }
        if (this.f == null) {
            this.f = new b(this, null);
        }
        this.e = this.d.requestAudioFocus(this.f, 3, 1) == 1;
        if (h) {
            Log.d("AudioPlayerListener", "   requestAudioFocus");
        }
    }

    @Override // com.baidu.tieba.nn1
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b();
            k().release();
            this.a = null;
            this.b = PlayerStatus.NONE;
            d dVar = this.g;
            if (dVar != null) {
                dVar.removeMessages(0);
                this.g = null;
            }
        }
    }

    @Override // com.baidu.tieba.nn1
    public void pause() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && k().isPlaying()) {
            k().pause();
            this.c.onStateChanged(BgMusicPlayState.PAUSE);
            d dVar = this.g;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }

    @Override // com.baidu.tieba.nn1
    public void play() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            PlayerStatus playerStatus = this.b;
            if (playerStatus == PlayerStatus.PREPARED) {
                m();
                k().start();
                this.c.onStateChanged(BgMusicPlayState.PLAY);
                d dVar = this.g;
                if (dVar != null) {
                    dVar.sendEmptyMessage(0);
                }
            } else if (playerStatus == PlayerStatus.IDLE) {
                l();
            }
        }
    }

    @Override // com.baidu.tieba.nn1
    public void seek(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            k().seekTo(i2);
        }
    }

    @Override // com.baidu.tieba.nn1
    public void stop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.b == PlayerStatus.PREPARED) {
            if (h) {
                Log.d("AudioPlayerListener", "===stop");
            }
            k().stop();
            this.b = PlayerStatus.IDLE;
            this.c.onStateChanged(BgMusicPlayState.STOP);
            d dVar = this.g;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }
}
