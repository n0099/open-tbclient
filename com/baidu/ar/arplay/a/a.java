package com.baidu.ar.arplay.a;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.message.ARPMessage;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final String TAG;
    public static a cL;
    public static ConcurrentHashMap cO;
    public static HandlerThread cP;
    public static Handler cQ;
    public static b cR;
    public static Map cT;
    public static Timer cU;
    public static TimerTask cV;
    public static Runnable cW;
    public transient /* synthetic */ FieldHolder $fh;
    public int cM;
    public boolean cN;
    public Map cS;
    public Handler.Callback cX;
    public Handler mHandler;

    /* renamed from: com.baidu.ar.arplay.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0048a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public MediaPlayer df;
        public com.baidu.ar.arplay.a.a.b dg;

        public C0048a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.dg = new com.baidu.ar.arplay.a.a.b();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(Exception exc);

        void onResult(boolean z);
    }

    /* loaded from: classes.dex */
    public class c implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a da;

        public c(a aVar, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.da = aVar;
            b unused = a.cR = bVar;
        }

        @Override // com.baidu.ar.arplay.a.a.b
        public void a(Exception exc) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, exc) == null) || a.cR == null) {
                return;
            }
            a.cQ.post(new Runnable(this, exc) { // from class: com.baidu.ar.arplay.a.a.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c dh;
                public final /* synthetic */ Exception di;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, exc};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.dh = this;
                    this.di = exc;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || a.cR == null) {
                        return;
                    }
                    a.cR.a(this.di);
                }
            });
        }

        @Override // com.baidu.ar.arplay.a.a.b
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || a.cR == null) {
                return;
            }
            a.cQ.post(new Runnable(this, z) { // from class: com.baidu.ar.arplay.a.a.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean aY;
                public final /* synthetic */ c dh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.dh = this;
                    this.aY = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || a.cR == null) {
                        return;
                    }
                    a.cR.onResult(this.aY);
                }
            });
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1109143806, "Lcom/baidu/ar/arplay/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1109143806, "Lcom/baidu/ar/arplay/a/a;");
                return;
            }
        }
        cQ = new Handler(Looper.getMainLooper());
        TAG = a.class.getSimpleName();
        cW = new Runnable() { // from class: com.baidu.ar.arplay.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || a.cP == null) {
                    return;
                }
                a.cP.quit();
                HandlerThread unused = a.cP = null;
            }
        };
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.cM = 0;
        this.cN = false;
        this.cX = new Handler.Callback(this) { // from class: com.baidu.ar.arplay.a.a.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a da;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.da = this;
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, message)) == null) {
                    if (ARPEngine.getInstance().isEngineCanAccess()) {
                        switch (message.what) {
                            case 3004:
                                this.da.a(message);
                                break;
                            case 3005:
                                this.da.b(message);
                                break;
                            case 3006:
                                this.da.c(message);
                                break;
                            case 3007:
                                this.da.e(message);
                                break;
                            case 3008:
                                this.da.f(message);
                                break;
                            case 3009:
                                this.da.d(message);
                                break;
                        }
                        return false;
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }
        };
        synchronized (a.class) {
            if (cP == null) {
                HandlerThread handlerThread = new HandlerThread("MediaPlayerThread");
                cP = handlerThread;
                handlerThread.start();
            } else {
                cQ.removeCallbacks(cW);
            }
        }
        this.mHandler = new Handler(cP.getLooper(), this.cX);
        this.cS = new Hashtable();
        cT = new Hashtable();
    }

    public static int a(Map map, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, map, str)) == null) {
            Integer num = (Integer) map.get(str);
            if (num == null) {
                return 0;
            }
            return num.intValue();
        }
        return invokeLL.intValue;
    }

    private C0048a a(MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, onCompletionListener, onErrorListener)) == null) {
            com.baidu.ar.arplay.c.b.b(TAG, "initMediaPlayerInMsg start()");
            try {
                C0048a c0048a = new C0048a();
                MediaPlayer mediaPlayer = new MediaPlayer();
                c0048a.df = mediaPlayer;
                mediaPlayer.setAudioStreamType(3);
                if (onCompletionListener == null) {
                    onCompletionListener = new MediaPlayer.OnCompletionListener(this) { // from class: com.baidu.ar.arplay.a.a.9
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ a da;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.da = this;
                        }

                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public void onCompletion(MediaPlayer mediaPlayer2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaPlayer2) == null) {
                                com.baidu.ar.arplay.c.b.b(a.TAG, "initMediaPlayerInMsg onCompletion()");
                                if (mediaPlayer2 != null) {
                                    mediaPlayer2.release();
                                }
                            }
                        }
                    };
                }
                mediaPlayer.setOnCompletionListener(onCompletionListener);
                if (onErrorListener == null) {
                    onErrorListener = new MediaPlayer.OnErrorListener(this, c0048a) { // from class: com.baidu.ar.arplay.a.a.10
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ a da;
                        public final /* synthetic */ C0048a db;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, c0048a};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.da = this;
                            this.db = c0048a;
                        }

                        @Override // android.media.MediaPlayer.OnErrorListener
                        public boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
                            InterceptResult invokeLII;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, mediaPlayer2, i, i2)) == null) {
                                String str = a.TAG;
                                com.baidu.ar.arplay.c.b.b(str, "onError: " + i);
                                C0048a c0048a2 = this.db;
                                com.baidu.ar.arplay.a.a.b bVar = c0048a2.dg;
                                bVar.dX = "ERROR";
                                bVar.dY = i;
                                a.a(c0048a2);
                                this.da.b(new b(this) { // from class: com.baidu.ar.arplay.a.a.10.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass10 dc;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i3 = newInitContext.flag;
                                            if ((i3 & 1) != 0) {
                                                int i4 = i3 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.dc = this;
                                    }

                                    @Override // com.baidu.ar.arplay.a.a.b
                                    public void a(Exception exc) {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeL(1048576, this, exc) == null) {
                                            this.dc.da.c(1010, (HashMap) null);
                                        }
                                    }

                                    @Override // com.baidu.ar.arplay.a.a.b
                                    public void onResult(boolean z) {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                                        }
                                    }
                                }, this.db.dg.dW);
                                return false;
                            }
                            return invokeLII.booleanValue;
                        }
                    };
                }
                mediaPlayer.setOnErrorListener(onErrorListener);
                return c0048a;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (C0048a) invokeLL.objValue;
    }

    public static C0048a a(C0048a c0048a, String str, String str2, AssetFileDescriptor assetFileDescriptor, MediaPlayer.OnCompletionListener onCompletionListener, int i, String str3, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{c0048a, str, str2, assetFileDescriptor, onCompletionListener, Integer.valueOf(i), str3, Long.valueOf(j)})) == null) {
            if ((TextUtils.isEmpty(str2) && assetFileDescriptor == null) || c0048a == null) {
                return c0048a;
            }
            c0048a.dg.dT = com.baidu.ar.arplay.c.c.a((Object) str, 0L);
            com.baidu.ar.arplay.a.a.b bVar = c0048a.dg;
            bVar.dW = str;
            bVar.dU = str3;
            MediaPlayer mediaPlayer = c0048a.df;
            if (onCompletionListener != null) {
                mediaPlayer.setOnCompletionListener(onCompletionListener);
            }
            try {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.seekTo(0);
                    mediaPlayer.stop();
                }
                mediaPlayer.setAudioStreamType(3);
                mediaPlayer.reset();
                if (!TextUtils.isEmpty(str2)) {
                    mediaPlayer.setDataSource(str2);
                } else if (assetFileDescriptor != null) {
                    mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
                }
                mediaPlayer.prepareAsync();
                mediaPlayer.setLooping(false);
                com.baidu.ar.arplay.c.b.b(TAG, "wrapper.mMediaPlayer.prepareAsync()");
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener(c0048a, str, j) { // from class: com.baidu.ar.arplay.a.a.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ C0048a db;
                    public final /* synthetic */ String dd;
                    public final /* synthetic */ long de;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {c0048a, str, Long.valueOf(j)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.db = c0048a;
                        this.dd = str;
                        this.de = j;
                    }

                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaPlayer2) == null) {
                            com.baidu.ar.arplay.c.b.b(a.TAG, "mMediaPlayer onPrepared");
                            C0048a c0048a2 = this.db;
                            com.baidu.ar.arplay.a.a.b bVar2 = c0048a2.dg;
                            bVar2.dX = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                            bVar2.dZ = DpStatConstants.KEY_PREPARED;
                            a.a(c0048a2);
                            if (ARPEngine.getInstance().isPaused() || a.cT == null || a.cT.get(this.dd) == null) {
                                return;
                            }
                            if (((Integer) a.cT.get(this.dd)).intValue() == 3004 || ((Integer) a.cT.get(this.dd)).intValue() == 3007) {
                                a.aC();
                                try {
                                    if (this.db.df.getDuration() >= 0) {
                                        if (this.db.df.getDuration() > this.de && this.de >= 0) {
                                            this.db.df.seekTo((int) this.de);
                                        }
                                        this.db.df.seekTo(0);
                                    }
                                    com.baidu.ar.arplay.c.b.b(a.TAG, "mMediaPlayer start");
                                    this.db.df.start();
                                    this.db.dg.dZ = "playing";
                                } catch (Exception e) {
                                    a.a(this.db.df);
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                });
                c0048a.df.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener(c0048a) { // from class: com.baidu.ar.arplay.a.a.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ C0048a db;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {c0048a};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.db = c0048a;
                    }

                    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
                    public void onBufferingUpdate(MediaPlayer mediaPlayer2, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, mediaPlayer2, i2) == null) {
                            C0048a c0048a2 = this.db;
                            com.baidu.ar.arplay.a.a.b bVar2 = c0048a2.dg;
                            bVar2.dX = "INFO";
                            bVar2.eb = i2;
                            a.a(c0048a2);
                        }
                    }
                });
                c0048a.df.setOnInfoListener(new MediaPlayer.OnInfoListener(c0048a) { // from class: com.baidu.ar.arplay.a.a.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ C0048a db;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {c0048a};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.db = c0048a;
                    }

                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i2, int i3) {
                        InterceptResult invokeLII;
                        String str4;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, mediaPlayer2, i2, i3)) == null) {
                            C0048a c0048a2 = this.db;
                            com.baidu.ar.arplay.a.a.b bVar2 = c0048a2.dg;
                            bVar2.dX = "INFO";
                            if (i2 == 701) {
                                str4 = "buffer_start";
                            } else if (i2 != 702) {
                                return false;
                            } else {
                                str4 = "buffer_end";
                            }
                            bVar2.ea = str4;
                            a.a(c0048a2);
                            return false;
                        }
                        return invokeLII.booleanValue;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            } catch (IllegalStateException e3) {
                e3.printStackTrace();
            } catch (SecurityException e4) {
                e4.printStackTrace();
            }
            return c0048a;
        }
        return (C0048a) invokeCommon.objValue;
    }

    public static void a(MediaPlayer mediaPlayer) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, mediaPlayer) == null) || mediaPlayer == null) {
            return;
        }
        try {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(C0048a c0048a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, c0048a) == null) || c0048a == null) {
            return;
        }
        b(c0048a);
        a(c0048a.dg);
        com.baidu.ar.arplay.a.a.b bVar = c0048a.dg;
        HashMap hashMap = new HashMap();
        hashMap.put("id", Integer.valueOf((int) ARPMessageType.MSG_TYPE_AUDIO));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("action_id", String.valueOf(bVar.dT));
        hashMap2.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "android");
        hashMap2.put("type", bVar.dX);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("error_code", Integer.valueOf(bVar.dY));
        hashMap3.put("buffer_status", bVar.ea);
        hashMap3.put("buffer_progress", Integer.valueOf(bVar.eb));
        hashMap3.put("play_status", bVar.dZ);
        hashMap3.put("play_progress", Integer.valueOf((int) (bVar.ec * 100.0f)));
        hashMap2.put("data", hashMap3);
        hashMap.put("msg_data", hashMap2);
        ARPMessage.getInstance().sendMessage(1902, hashMap);
    }

    private void a(b bVar, String str, String str2, AssetFileDescriptor assetFileDescriptor, MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener, int i, String str3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{bVar, str, str2, assetFileDescriptor, onCompletionListener, onErrorListener, Integer.valueOf(i), str3, Long.valueOf(j)}) == null) {
            try {
                C0048a a = a(str, onCompletionListener, onErrorListener);
                if (a != null) {
                    a(a, str, str2, assetFileDescriptor, onCompletionListener, i, str3, j);
                }
                if (bVar != null) {
                    bVar.onResult(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
                C0048a z = z(str);
                A(str);
                try {
                    if (z.df != null) {
                        z.df.release();
                    }
                    try {
                        C0048a a2 = aA().a(str, onCompletionListener, onErrorListener);
                        if (a2 != null) {
                            a(a2, str, str2, assetFileDescriptor, onCompletionListener, i, str3, j);
                        }
                        if (bVar != null) {
                            bVar.onResult(true);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        if (bVar != null) {
                            bVar.a(e2);
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    if (bVar != null) {
                        bVar.a(e3);
                    }
                }
            }
        }
    }

    public static void a(com.baidu.ar.arplay.a.a.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, bVar) == null) || bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("id", String.valueOf(bVar.dT));
        hashMap.put("target", bVar.dU);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("play_status", bVar.dZ);
        hashMap2.put("buffer_status", bVar.ea);
        hashMap2.put("duration", String.valueOf(bVar.dV));
        hashMap2.put("buffer_progress", String.valueOf(bVar.eb));
        hashMap2.put("play_progress", String.valueOf((int) (bVar.ec * 100.0f)));
        hashMap.put("msg_data", hashMap2);
        ARPMessage.getInstance().sendMessage(1011, hashMap);
    }

    public static synchronized a aA() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            synchronized (a.class) {
                if (cL == null) {
                    cL = new a();
                }
                aVar = cL;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public static synchronized void aC() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            synchronized (a.class) {
                if (cU == null) {
                    cU = new Timer();
                    TimerTask timerTask = new TimerTask() { // from class: com.baidu.ar.arplay.a.a.14
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                }
                            }
                        }

                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            C0048a c0048a;
                            com.baidu.ar.arplay.a.a.b bVar;
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || a.cO == null) {
                                return;
                            }
                            for (Map.Entry entry : a.cO.entrySet()) {
                                if (entry != null && (c0048a = (C0048a) entry.getValue()) != null && (bVar = c0048a.dg) != null && bVar.dZ == "playing") {
                                    a.a((C0048a) entry.getValue());
                                }
                            }
                        }
                    };
                    cV = timerTask;
                    cU.scheduleAtFixedRate(timerTask, 0L, 200L);
                }
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0040 -> B:33:0x0043). Please submit an issue!!! */
    public static void b(C0048a c0048a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65556, null, c0048a) == null) || c0048a == null || c0048a.df == null) {
            return;
        }
        com.baidu.ar.arplay.a.a.b bVar = c0048a.dg;
        String str = bVar.dZ;
        if (str == "playing" || str == "paused") {
            try {
                int duration = c0048a.df.getDuration();
                bVar.dV = duration;
                if (duration <= 0) {
                    bVar.ec = 0.0f;
                } else {
                    bVar.ec = (c0048a.df.getCurrentPosition() * 1.0f) / bVar.dV;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (str == "finished") {
            bVar.ec = 1.0f;
        }
        if (bVar.ec > 1.0f) {
            bVar.ec = 1.0f;
        }
        if (bVar.ec < 0.0f) {
            bVar.ec = 0.0f;
        }
    }

    private void b(b bVar, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i, String str3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, this, new Object[]{bVar, str, str2, onCompletionListener, Integer.valueOf(i), str3, Long.valueOf(j)}) == null) {
            C0048a z = z(str);
            A(str);
            if (z != null) {
                try {
                    if (z.df != null) {
                        z.df.release();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (bVar != null) {
                        bVar.a(e);
                        return;
                    }
                    return;
                }
            }
            try {
                C0048a a = a(str, onCompletionListener, null);
                if (a != null) {
                    a(a, str, str2, null, onCompletionListener, i, str3, j);
                }
                if (bVar != null) {
                    bVar.onResult(true);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (bVar != null) {
                    bVar.a(e2);
                }
            }
        }
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || cO == null || TextUtils.isEmpty(str) || !cO.containsKey(str)) {
            return;
        }
        cO.remove(str);
    }

    public C0048a a(String str, MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, onCompletionListener, onErrorListener)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            ConcurrentHashMap concurrentHashMap = cO;
            if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
                C0048a a = a(onCompletionListener, onErrorListener);
                if (a == null) {
                    return null;
                }
                if (cO == null) {
                    cO = new ConcurrentHashMap();
                }
                cO.put(str, a);
                return a;
            }
            return (C0048a) cO.get(str);
        }
        return (C0048a) invokeLLL.objValue;
    }

    public void a(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
            Object[] objArr = (Object[]) message.obj;
            b bVar = (b) objArr[0];
            String str = (String) objArr[1];
            long longValue = ((Long) objArr[6]).longValue();
            cT.put(str, 3004);
            a(bVar, str, (String) objArr[2], null, (MediaPlayer.OnCompletionListener) objArr[3], null, ((Integer) objArr[4]).intValue(), (String) objArr[5], longValue);
        }
    }

    public void a(b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bVar, str) == null) {
            Message obtainMessage = this.mHandler.obtainMessage(3006);
            obtainMessage.obj = new Object[]{new c(this, bVar), str};
            obtainMessage.sendToTarget();
        }
    }

    public void a(b bVar, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{bVar, str, str2, onCompletionListener, Integer.valueOf(i)}) == null) {
            Message obtainMessage = this.mHandler.obtainMessage(3007);
            obtainMessage.obj = new Object[]{new c(this, bVar), str, str2, onCompletionListener, Integer.valueOf(i)};
            obtainMessage.sendToTarget();
        }
    }

    public void a(b bVar, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i, String str3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{bVar, str, str2, onCompletionListener, Integer.valueOf(i), str3, Long.valueOf(j)}) == null) {
            Message obtainMessage = this.mHandler.obtainMessage(3004);
            obtainMessage.obj = new Object[]{new c(this, bVar), str, str2, onCompletionListener, Integer.valueOf(i), str3, Long.valueOf(j)};
            obtainMessage.sendToTarget();
        }
    }

    public void a(com.baidu.ar.arplay.a.a.a aVar, HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, aVar, hashMap) == null) {
            if (aVar.aN() > 1) {
                this.cS.put(aVar.getId(), Integer.valueOf(aVar.aN()));
            }
            c(1002, hashMap);
            a(new b(this, hashMap) { // from class: com.baidu.ar.arplay.a.a.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HashMap cZ;
                public final /* synthetic */ a da;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, hashMap};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.da = this;
                    this.cZ = hashMap;
                }

                @Override // com.baidu.ar.arplay.a.a.b
                public void a(Exception exc) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, exc) == null) {
                        this.da.c(1010, this.cZ);
                    }
                }

                @Override // com.baidu.ar.arplay.a.a.b
                public void onResult(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    }
                }
            }, aVar.getId(), aVar.getUrl(), new MediaPlayer.OnCompletionListener(this, aVar, hashMap) { // from class: com.baidu.ar.arplay.a.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.baidu.ar.arplay.a.a.a cY;
                public final /* synthetic */ HashMap cZ;
                public final /* synthetic */ a da;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar, hashMap};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.da = this;
                    this.cY = aVar;
                    this.cZ = hashMap;
                }

                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    int a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaPlayer) == null) {
                        com.baidu.ar.arplay.c.b.b(a.TAG, "openAudio mMediaPlayer onCompletion");
                        if (this.da.cS == null) {
                            return;
                        }
                        C0048a z = this.da.z(this.cY.getId());
                        if (z == null || z.dg.dZ != "paused") {
                            if (z != null) {
                                com.baidu.ar.arplay.a.a.b bVar = z.dg;
                                bVar.dX = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                                bVar.dZ = "finished";
                                a.a(z);
                                if (this.cY.aQ()) {
                                    com.baidu.ar.arplay.c.b.b(a.TAG, "openAudio mMediaPlayer onCompletion  isLoopForever open！");
                                    this.da.a(this.cY, this.cZ);
                                    return;
                                }
                            }
                            if (this.da.cS.size() <= 0 || (a = a.a(this.da.cS, this.cY.getId())) <= 1) {
                                this.da.c(1009, this.cZ);
                                mediaPlayer.release();
                                return;
                            }
                            com.baidu.ar.arplay.c.b.b(a.TAG, "openAudio mMediaPlayer onCompletion  count open ！");
                            this.da.a(this.cY, this.cZ);
                            int i = a - 1;
                            this.da.cS.put(this.cY.getId(), Integer.valueOf(i));
                            this.cY.i(i);
                        }
                    }
                }
            }, aVar.aN(), aVar.aP(), aVar.aO());
        }
    }

    public void aB() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.cX = null;
            Timer timer = cU;
            if (timer != null) {
                timer.cancel();
                cU.purge();
                cU = null;
                cV.cancel();
                cV = null;
            }
            Map map = cT;
            if (map != null) {
                map.clear();
            }
            ConcurrentHashMap concurrentHashMap = cO;
            if (concurrentHashMap != null) {
                try {
                    for (C0048a c0048a : concurrentHashMap.values()) {
                        c0048a.dg.dX = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                        c0048a.dg.dZ = "unstarted";
                        a(c0048a.df);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ConcurrentHashMap concurrentHashMap2 = cO;
                if (concurrentHashMap2 != null) {
                    concurrentHashMap2.clear();
                }
            }
            Map map2 = this.cS;
            if (map2 != null) {
                map2.clear();
            }
        }
    }

    public void b(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, message) == null) {
            Object[] objArr = (Object[]) message.obj;
            b bVar = (b) objArr[0];
            String str = (String) objArr[1];
            cT.put(str, 3005);
            C0048a z = z(str);
            if (z != null) {
                try {
                    z.dg.dX = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                    z.dg.dZ = "unstarted";
                    a(z);
                    com.baidu.ar.arplay.c.b.b(TAG, "mMediaPlayer stopPlay");
                    a(z.df);
                    z.df = null;
                    A(str);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (bVar != null) {
                        bVar.a(e);
                        return;
                    }
                    return;
                }
            }
            if (bVar != null) {
                bVar.onResult(true);
            }
        }
    }

    public void b(b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bVar, str) == null) {
            Message obtainMessage = this.mHandler.obtainMessage(3005);
            obtainMessage.obj = new Object[]{new c(this, bVar), str};
            obtainMessage.sendToTarget();
        }
    }

    public void b(com.baidu.ar.arplay.a.a.a aVar, HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, aVar, hashMap) == null) {
            c(1004, hashMap);
            a(new b(this, hashMap) { // from class: com.baidu.ar.arplay.a.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HashMap cZ;
                public final /* synthetic */ a da;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, hashMap};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.da = this;
                    this.cZ = hashMap;
                }

                @Override // com.baidu.ar.arplay.a.a.b
                public void a(Exception exc) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, exc) == null) {
                        this.da.c(1010, this.cZ);
                    }
                }

                @Override // com.baidu.ar.arplay.a.a.b
                public void onResult(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    }
                }
            }, aVar.getId());
        }
    }

    public void c(int i, HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i, hashMap) == null) {
            ARPMessage.getInstance().sendMessage(i, hashMap);
        }
    }

    public void c(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, message) == null) {
            Object[] objArr = (Object[]) message.obj;
            b bVar = (b) objArr[0];
            String str = (String) objArr[1];
            cT.put(str, 3006);
            try {
                C0048a z = z(str);
                if (z.df != null && z.dg.dZ != "unstarted" && z.df.isPlaying()) {
                    z.dg.dX = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                    z.dg.dZ = "paused";
                    a(z);
                    com.baidu.ar.arplay.c.b.b(TAG, "mMediaPlayer pause");
                    z.df.pause();
                }
                if (bVar != null) {
                    bVar.onResult(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (bVar != null) {
                    bVar.a(e);
                }
            }
        }
    }

    public void c(b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, bVar, str) == null) {
            Message obtainMessage = this.mHandler.obtainMessage(3009);
            obtainMessage.obj = new Object[]{new c(this, bVar), str};
            obtainMessage.sendToTarget();
        }
    }

    public void c(com.baidu.ar.arplay.a.a.a aVar, HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, aVar, hashMap) == null) {
            c(1006, hashMap);
            a(new b(this, hashMap) { // from class: com.baidu.ar.arplay.a.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HashMap cZ;
                public final /* synthetic */ a da;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, hashMap};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.da = this;
                    this.cZ = hashMap;
                }

                @Override // com.baidu.ar.arplay.a.a.b
                public void a(Exception exc) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, exc) == null) {
                        this.da.c(1010, this.cZ);
                    }
                }

                @Override // com.baidu.ar.arplay.a.a.b
                public void onResult(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    }
                }
            }, aVar.getId(), aVar.getUrl(), new MediaPlayer.OnCompletionListener(this, aVar, hashMap) { // from class: com.baidu.ar.arplay.a.a.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.baidu.ar.arplay.a.a.a cY;
                public final /* synthetic */ HashMap cZ;
                public final /* synthetic */ a da;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar, hashMap};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.da = this;
                    this.cY = aVar;
                    this.cZ = hashMap;
                }

                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    int a;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, mediaPlayer) == null) || this.da.cS == null) {
                        return;
                    }
                    C0048a z = this.da.z(this.cY.getId());
                    if (z != null) {
                        com.baidu.ar.arplay.a.a.b bVar = z.dg;
                        bVar.dX = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                        bVar.dZ = "finished";
                        a.a(z);
                        if (this.cY.aQ()) {
                            this.da.a(this.cY, this.cZ);
                            return;
                        }
                    }
                    if (this.da.cS.size() <= 0 || (a = a.a(this.da.cS, this.cY.getId())) <= 1) {
                        this.da.c(1009, this.cZ);
                        return;
                    }
                    this.da.a(this.cY, this.cZ);
                    int i = a - 1;
                    this.da.cS.put(this.cY.getId(), Integer.valueOf(i));
                    this.cY.i(i);
                }
            }, aVar.aN());
        }
    }

    public void d(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, message) == null) {
            Object[] objArr = (Object[]) message.obj;
            if (objArr.length < 2) {
                return;
            }
            b bVar = (b) objArr[0];
            String str = (String) objArr[1];
            cT.put(str, 3009);
            try {
                C0048a z = z(str);
                if (z == null || z.dg.dZ == "unstarted") {
                    return;
                }
                z.df.seekTo(0);
            } catch (Exception e) {
                e.printStackTrace();
                if (bVar != null) {
                    bVar.a(e);
                }
            }
        }
    }

    public void d(com.baidu.ar.arplay.a.a.a aVar, HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, aVar, hashMap) == null) {
            c(1008, hashMap);
            b(new b(this, hashMap) { // from class: com.baidu.ar.arplay.a.a.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HashMap cZ;
                public final /* synthetic */ a da;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, hashMap};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.da = this;
                    this.cZ = hashMap;
                }

                @Override // com.baidu.ar.arplay.a.a.b
                public void a(Exception exc) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, exc) == null) {
                        this.da.c(1010, this.cZ);
                    }
                }

                @Override // com.baidu.ar.arplay.a.a.b
                public void onResult(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    }
                }
            }, aVar.getId());
        }
    }

    public void e(Message message) {
        long j;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, message) == null) || ARPEngine.getInstance().isPaused()) {
            return;
        }
        Object[] objArr = (Object[]) message.obj;
        if (objArr.length < 5) {
            return;
        }
        b bVar = (b) objArr[0];
        String str2 = (String) objArr[1];
        String str3 = (String) objArr[2];
        MediaPlayer.OnCompletionListener onCompletionListener = (MediaPlayer.OnCompletionListener) objArr[3];
        int intValue = ((Integer) objArr[4]).intValue();
        if (objArr.length > 6) {
            j = ((Long) objArr[6]).longValue();
            str = (String) objArr[5];
        } else {
            j = 0;
            str = null;
        }
        cT.put(str2, 3007);
        try {
            C0048a z = z(str2);
            if (z != null && !z.df.isPlaying() && z.dg.dZ != "unstarted") {
                z.dg.dX = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                z.dg.dZ = "playing";
                a(z);
                com.baidu.ar.arplay.c.b.b(TAG, "MediaPlayer resume");
                z.df.seekTo(z.df.getCurrentPosition());
                z.df.start();
            }
            if (bVar != null) {
                bVar.onResult(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            b(bVar, str2, str3, onCompletionListener, intValue, str, j);
        }
    }

    public void e(com.baidu.ar.arplay.a.a.a aVar, HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, aVar, hashMap) == null) {
            c(1013, hashMap);
            c(new b(this, hashMap) { // from class: com.baidu.ar.arplay.a.a.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HashMap cZ;
                public final /* synthetic */ a da;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, hashMap};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.da = this;
                    this.cZ = hashMap;
                }

                @Override // com.baidu.ar.arplay.a.a.b
                public void a(Exception exc) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, exc) == null) {
                        this.da.c(1010, this.cZ);
                    }
                }

                @Override // com.baidu.ar.arplay.a.a.b
                public void onResult(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    }
                }
            }, aVar.getId());
        }
    }

    public void f(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, message) == null) {
            b bVar = (b) ((Object[]) message.obj)[0];
            this.cN = false;
            this.cM = 0;
            ConcurrentHashMap concurrentHashMap = cO;
            if (concurrentHashMap != null) {
                try {
                    for (C0048a c0048a : concurrentHashMap.values()) {
                        if (c0048a != null) {
                            c0048a.df.release();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                cO.clear();
            }
            if (bVar != null) {
                bVar.onResult(true);
            }
        }
    }

    public C0048a z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            if (cO == null || TextUtils.isEmpty(str)) {
                return null;
            }
            return (C0048a) cO.get(str);
        }
        return (C0048a) invokeL.objValue;
    }
}
