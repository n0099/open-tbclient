package com.baidu.ar.arplay.a;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.c.e;
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
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "e";
    public static e dD;
    public transient /* synthetic */ FieldHolder $fh;
    public int cM;
    public boolean cN;
    public Timer cU;
    public TimerTask cV;
    public ConcurrentHashMap<String, b> dE;
    public Map<String, Integer> dF;
    public com.baidu.ar.arplay.c.a dG;

    /* loaded from: classes.dex */
    public interface a {
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String dK;
        public SurfaceTexture dL;
        public int dM;
        public boolean dN;
        public MediaPlayer df;
        public com.baidu.ar.arplay.a.a.b dg;

        public b() {
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
            this.dN = false;
            this.dg = new com.baidu.ar.arplay.a.a.b();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1109143682, "Lcom/baidu/ar/arplay/a/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1109143682, "Lcom/baidu/ar/arplay/a/e;");
        }
    }

    public e() {
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
        this.dE = new ConcurrentHashMap<>();
        this.dG = new com.baidu.ar.arplay.c.a(this) { // from class: com.baidu.ar.arplay.a.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e dH;

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
                this.dH = this;
            }

            @Override // com.baidu.ar.arplay.c.a
            public void a(e.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.dH.b((a) null, true);
                }
            }

            @Override // com.baidu.ar.arplay.c.a
            public void aM() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.dH.a((a) null, true);
                }
            }
        };
        this.dF = new Hashtable();
        com.baidu.ar.arplay.c.d.a(this.dG);
    }

    private void A(String str) {
        ConcurrentHashMap<String, b> concurrentHashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, str) == null) || (concurrentHashMap = this.dE) == null || concurrentHashMap.get(str) == null) {
            return;
        }
        this.dE.remove(str);
    }

    private MediaPlayer B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            ConcurrentHashMap<String, b> concurrentHashMap = this.dE;
            if (concurrentHashMap == null || concurrentHashMap.get(str) == null) {
                return null;
            }
            return this.dE.get(str).df;
        }
        return (MediaPlayer) invokeL.objValue;
    }

    private void a(a aVar, String str, String str2, int i, MediaPlayer.OnCompletionListener onCompletionListener, boolean z, String str3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{aVar, str, str2, Integer.valueOf(i), onCompletionListener, Boolean.valueOf(z), str3, Long.valueOf(j)}) == null) {
            try {
                if (this.dE.containsKey(str)) {
                    b bVar = this.dE.get(str);
                    if (bVar == null) {
                        return;
                    }
                    if (bVar.df != null) {
                        bVar.df.reset();
                        bVar.df.setDataSource(str2);
                        bVar.df.setLooping(z);
                        bVar.df.setOnCompletionListener(onCompletionListener);
                        bVar.df.prepareAsync();
                        bVar.dK = str2;
                    }
                } else {
                    b bVar2 = new b();
                    bVar2.dK = str2;
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    bVar2.df = mediaPlayer;
                    mediaPlayer.setDataSource(str2);
                    bVar2.dM = i;
                    bVar2.dL = new SurfaceTexture(i);
                    bVar2.dg.dT = Long.valueOf(str).longValue();
                    bVar2.dg.dU = str3;
                    bVar2.df.setSurface(new Surface(bVar2.dL));
                    bVar2.df.setOnCompletionListener(onCompletionListener);
                    bVar2.df.setOnErrorListener(new MediaPlayer.OnErrorListener(this, bVar2) { // from class: com.baidu.ar.arplay.a.e.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ e dH;
                        public final /* synthetic */ b dI;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, bVar2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.dH = this;
                            this.dI = bVar2;
                        }

                        @Override // android.media.MediaPlayer.OnErrorListener
                        public boolean onError(MediaPlayer mediaPlayer2, int i2, int i3) {
                            InterceptResult invokeLII;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, mediaPlayer2, i2, i3)) == null) {
                                b bVar3 = this.dI;
                                com.baidu.ar.arplay.a.a.b bVar4 = bVar3.dg;
                                bVar4.dX = "ERROR";
                                bVar4.dY = i2;
                                e.a(bVar3);
                                return true;
                            }
                            return invokeLII.booleanValue;
                        }
                    });
                    bVar2.df.setLooping(z);
                    bVar2.df.prepareAsync();
                    com.baidu.ar.arplay.c.b.b(TAG, "wrapper.mMediaPlayer.prepareAsync()");
                    bVar2.df.setOnPreparedListener(new MediaPlayer.OnPreparedListener(this, bVar2, j) { // from class: com.baidu.ar.arplay.a.e.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ e dH;
                        public final /* synthetic */ b dI;
                        public final /* synthetic */ long de;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, bVar2, Long.valueOf(j)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.dH = this;
                            this.dI = bVar2;
                            this.de = j;
                        }

                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaPlayer2) == null) {
                                com.baidu.ar.arplay.c.b.b(e.TAG, "mMediaPlayer onPrepared");
                                b bVar3 = this.dI;
                                com.baidu.ar.arplay.a.a.b bVar4 = bVar3.dg;
                                bVar4.dX = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                                bVar4.dZ = DpStatConstants.KEY_PREPARED;
                                e.a(bVar3);
                                if (ARPEngine.getInstance().isEngineCanAccess() && !ARPEngine.getInstance().isPaused()) {
                                    this.dH.aC();
                                    try {
                                        if (this.dI.df.getDuration() >= 0) {
                                            if (this.dI.df.getDuration() > this.de && this.de >= 0) {
                                                this.dI.df.seekTo((int) this.de);
                                            }
                                            this.dI.df.seekTo(0);
                                        }
                                        com.baidu.ar.arplay.c.b.b(e.TAG, "mMediaPlayer start");
                                        this.dI.df.start();
                                        this.dI.dg.dZ = "playing";
                                    } catch (Exception e) {
                                        e.fillInStackTrace();
                                    }
                                }
                            }
                        }
                    });
                    bVar2.df.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener(this, bVar2) { // from class: com.baidu.ar.arplay.a.e.6
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ e dH;
                        public final /* synthetic */ b dI;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, bVar2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.dH = this;
                            this.dI = bVar2;
                        }

                        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
                        public void onBufferingUpdate(MediaPlayer mediaPlayer2, int i2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLI(1048576, this, mediaPlayer2, i2) == null) {
                                b bVar3 = this.dI;
                                com.baidu.ar.arplay.a.a.b bVar4 = bVar3.dg;
                                bVar4.dX = "INFO";
                                bVar4.eb = i2;
                                e.a(bVar3);
                            }
                        }
                    });
                    bVar2.df.setOnInfoListener(new MediaPlayer.OnInfoListener(this, bVar2) { // from class: com.baidu.ar.arplay.a.e.7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ e dH;
                        public final /* synthetic */ b dI;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, bVar2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.dH = this;
                            this.dI = bVar2;
                        }

                        @Override // android.media.MediaPlayer.OnInfoListener
                        public boolean onInfo(MediaPlayer mediaPlayer2, int i2, int i3) {
                            InterceptResult invokeLII;
                            String str4;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, mediaPlayer2, i2, i3)) == null) {
                                b bVar3 = this.dI;
                                com.baidu.ar.arplay.a.a.b bVar4 = bVar3.dg;
                                bVar4.dX = "INFO";
                                if (i2 == 701) {
                                    str4 = "buffer_start";
                                } else if (i2 != 702) {
                                    return false;
                                } else {
                                    str4 = "buffer_end";
                                }
                                bVar4.ea = str4;
                                e.a(bVar3);
                                return false;
                            }
                            return invokeLII.booleanValue;
                        }
                    });
                    if (this.dE != null && str != null) {
                        this.dE.put(str, bVar2);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, bVar) == null) || bVar == null) {
            return;
        }
        b(bVar);
        b(bVar.dg);
        com.baidu.ar.arplay.a.a.b bVar2 = bVar.dg;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", Integer.valueOf((int) ARPMessageType.MSG_TYPE_VIDEO));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("action_id", String.valueOf(bVar2.dT));
        hashMap2.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "android");
        hashMap2.put("type", bVar2.dX);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("error_code", Integer.valueOf(bVar2.dY));
        hashMap3.put("buffer_status", bVar2.ea);
        hashMap3.put("buffer_progress", Integer.valueOf(bVar2.eb));
        hashMap3.put("play_status", bVar2.dZ);
        hashMap3.put("play_progress", Integer.valueOf((int) (bVar2.ec * 100.0f)));
        hashMap2.put("data", hashMap3);
        hashMap.put("msg_data", hashMap2);
        ARPMessage.getInstance().sendMessage(1902, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aC() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            synchronized (this) {
                if (this.cU == null) {
                    this.cU = new Timer();
                    TimerTask timerTask = new TimerTask(this) { // from class: com.baidu.ar.arplay.a.e.8
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ e dH;

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
                            this.dH = this;
                        }

                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            b bVar;
                            com.baidu.ar.arplay.a.a.b bVar2;
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.dH.dE == null) {
                                return;
                            }
                            for (Map.Entry entry : this.dH.dE.entrySet()) {
                                if (entry != null && (bVar = (b) entry.getValue()) != null && (bVar2 = bVar.dg) != null && bVar2.dZ == "playing") {
                                    e.a((b) entry.getValue());
                                }
                            }
                        }
                    };
                    this.cV = timerTask;
                    this.cU.scheduleAtFixedRate(timerTask, 0L, 200L);
                }
            }
        }
    }

    public static synchronized e aL() {
        InterceptResult invokeV;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            synchronized (e.class) {
                if (dD == null) {
                    dD = new e();
                }
                eVar = dD;
            }
            return eVar;
        }
        return (e) invokeV.objValue;
    }

    public static void b(com.baidu.ar.arplay.a.a.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, bVar) == null) || bVar == null) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", String.valueOf(bVar.dT));
        hashMap.put("target", bVar.dU);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("play_status", bVar.dZ);
        hashMap2.put("buffer_status", bVar.ea);
        hashMap2.put("duration", String.valueOf(bVar.dV));
        hashMap2.put("buffer_progress", String.valueOf(bVar.eb));
        hashMap2.put("play_progress", String.valueOf((int) (bVar.ec * 100.0f)));
        hashMap.put("msg_data", hashMap2);
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_VIDEO_PLAY_INFO_UPDATE, hashMap);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0040 -> B:33:0x0043). Please submit an issue!!! */
    public static void b(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, bVar) == null) || bVar == null || bVar.df == null) {
            return;
        }
        com.baidu.ar.arplay.a.a.b bVar2 = bVar.dg;
        String str = bVar2.dZ;
        if (str == "playing" || str == "paused") {
            try {
                int duration = bVar.df.getDuration();
                bVar2.dV = duration;
                if (duration <= 0) {
                    bVar2.ec = 0.0f;
                } else {
                    bVar2.ec = (bVar.df.getCurrentPosition() * 1.0f) / bVar2.dV;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (str == "finished") {
            bVar2.ec = 1.0f;
        }
        if (bVar2.ec > 1.0f) {
            bVar2.ec = 1.0f;
        }
        if (bVar2.ec < 0.0f) {
            bVar2.ec = 0.0f;
        }
    }

    public static void releaseInstance() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            dD = null;
        }
    }

    public b C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            ConcurrentHashMap<String, b> concurrentHashMap = this.dE;
            if (concurrentHashMap != null) {
                return concurrentHashMap.get(str);
            }
            return null;
        }
        return (b) invokeL.objValue;
    }

    public int D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            b C = C(str);
            if (C != null) {
                return C.dM;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public SurfaceTexture E(String str) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            ConcurrentHashMap<String, b> concurrentHashMap = this.dE;
            if (concurrentHashMap == null || (bVar = concurrentHashMap.get(str)) == null) {
                return null;
            }
            return bVar.dL;
        }
        return (SurfaceTexture) invokeL.objValue;
    }

    public int a(Map<String, Integer> map, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, map, str)) == null) {
            Integer num = map.get(str);
            if (num == null) {
                return 0;
            }
            return num.intValue();
        }
        return invokeLL.intValue;
    }

    public void a(com.baidu.ar.arplay.a.a.e eVar, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, eVar, hashMap) == null) {
            if (eVar.aN() > 1) {
                this.dF.put(eVar.getId(), Integer.valueOf(eVar.aN()));
            }
            c(1022, hashMap);
            a(new a(this, hashMap) { // from class: com.baidu.ar.arplay.a.e.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HashMap cZ;
                public final /* synthetic */ e dH;

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
                    this.dH = this;
                    this.cZ = hashMap;
                }
            }, eVar.getId(), eVar.getUrl(), new MediaPlayer.OnCompletionListener(this, eVar, hashMap) { // from class: com.baidu.ar.arplay.a.e.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HashMap cZ;
                public final /* synthetic */ e dH;
                public final /* synthetic */ com.baidu.ar.arplay.a.a.e dJ;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, eVar, hashMap};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.dH = this;
                    this.dJ = eVar;
                    this.cZ = hashMap;
                }

                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    com.baidu.ar.arplay.a.a.e eVar2;
                    e eVar3;
                    int a2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, mediaPlayer) == null) || this.dH.dF == null || (eVar2 = this.dJ) == null) {
                        return;
                    }
                    b C = this.dH.C(eVar2.getId());
                    if (C != null) {
                        com.baidu.ar.arplay.a.a.b bVar = C.dg;
                        bVar.dX = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                        bVar.dZ = "finished";
                        e.a(C);
                        if (this.dJ.aQ()) {
                            this.dH.a(this.dJ, this.cZ);
                            return;
                        }
                    }
                    if (this.dH.dF.size() <= 0 || (a2 = (eVar3 = this.dH).a(eVar3.dF, this.dJ.getId())) <= 1) {
                        this.dH.c(ARPMessageType.MSG_TYPE_VIDEO_PLAY_FINISH, this.cZ);
                        return;
                    }
                    int i = a2 - 1;
                    this.dH.dF.put(this.dJ.getId(), Integer.valueOf(i));
                    this.dJ.i(i);
                    this.dH.a(this.dJ, this.cZ);
                }
            }, eVar.aR(), eVar.aN(), eVar.aP(), eVar.aO());
        }
    }

    public void a(a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, aVar, str) == null) {
            b C = C(str);
            if (C != null) {
                com.baidu.ar.arplay.a.a.b bVar = C.dg;
                bVar.dX = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                bVar.dZ = "unstarted";
                a(C);
            }
            MediaPlayer B = B(str);
            if (B != null) {
                com.baidu.ar.arplay.c.b.b(TAG, "mMediaPlayer stopPlay");
                com.baidu.ar.arplay.a.a.a(B);
                A(str);
            }
        }
    }

    public void a(a aVar, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i, int i2, String str3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{aVar, str, str2, onCompletionListener, Integer.valueOf(i), Integer.valueOf(i2), str3, Long.valueOf(j)}) == null) {
            a(aVar, str, str2, i, onCompletionListener, false, str3, j);
        }
    }

    public void a(a aVar, String str, boolean z) {
        MediaPlayer B;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048583, this, aVar, str, z) == null) || (B = B(str)) == null) {
            return;
        }
        try {
            if (B.isPlaying()) {
                b C = C(str);
                if (C != null) {
                    C.dg.dX = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                    C.dg.dZ = "paused";
                    C.dN = z;
                    a(C);
                }
                com.baidu.ar.arplay.c.b.b(TAG, "mMediaPlayer pause");
                B.pause();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(a aVar, boolean z) {
        ConcurrentHashMap<String, b> concurrentHashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar, z) == null) || (concurrentHashMap = this.dE) == null) {
            return;
        }
        for (Map.Entry<String, b> entry : concurrentHashMap.entrySet()) {
            a(aVar, entry.getKey(), z);
        }
    }

    public void a(String str, int i) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048585, this, str, i) == null) || (bVar = this.dE.get(str)) == null) {
            return;
        }
        bVar.dL = new SurfaceTexture(i);
        try {
            bVar.df.setSurface(new Surface(bVar.dL));
        } catch (Exception unused) {
            Log.i("VideoPlayerManager", "MediaPlayer setSurface failed.");
        }
        bVar.dM = i;
    }

    public void aB() {
        ConcurrentHashMap<String, b> concurrentHashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (concurrentHashMap = this.dE) == null) {
            return;
        }
        for (Map.Entry<String, b> entry : concurrentHashMap.entrySet()) {
            if (entry != null) {
                a((a) null, entry.getKey());
                entry.getValue().dL = null;
                entry.getValue().dg.dX = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                entry.getValue().dg.dZ = "unstarted";
                entry.getValue().dN = false;
                a(entry.getValue());
                MediaPlayer mediaPlayer = entry.getValue().df;
                if (mediaPlayer != null) {
                    try {
                        com.baidu.ar.arplay.c.b.b(TAG, "releaseMediaPlayer");
                        mediaPlayer.release();
                    } catch (Exception unused) {
                        System.out.println("player release Exception");
                    }
                }
            }
        }
        this.dE.clear();
    }

    public void b(com.baidu.ar.arplay.a.a.e eVar, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, eVar, hashMap) == null) {
            c(1024, hashMap);
            a(new a(this, hashMap) { // from class: com.baidu.ar.arplay.a.e.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HashMap cZ;
                public final /* synthetic */ e dH;

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
                    this.dH = this;
                    this.cZ = hashMap;
                }
            }, eVar.getId(), false);
        }
    }

    public void b(a aVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, aVar, str) == null) || ARPEngine.getInstance().isPaused()) {
            return;
        }
        MediaPlayer B = B(str);
        b C = C(str);
        if (C == null) {
            return;
        }
        String str2 = C.dg.dZ;
        if ((str2 == "paused" || str2 == DpStatConstants.KEY_PREPARED) && B != null) {
            com.baidu.ar.arplay.c.b.b(TAG, "mMediaPlayer start");
            aC();
            B.start();
            com.baidu.ar.arplay.a.a.b bVar = C.dg;
            bVar.dX = DownloadConstants.DownloadColumns.COLUMN_STATUS;
            bVar.dZ = "playing";
            a(C);
        }
    }

    public void b(a aVar, boolean z) {
        ConcurrentHashMap<String, b> concurrentHashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048589, this, aVar, z) == null) || (concurrentHashMap = this.dE) == null) {
            return;
        }
        for (Map.Entry<String, b> entry : concurrentHashMap.entrySet()) {
            if (!z || (entry != null && entry.getValue() != null && entry.getValue().dN)) {
                b(aVar, entry.getKey());
            }
        }
    }

    public void c(int i, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i, hashMap) == null) {
            ARPMessage.getInstance().sendMessage(i, hashMap);
        }
    }

    public void c(com.baidu.ar.arplay.a.a.e eVar, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, eVar, hashMap) == null) {
            c(1026, hashMap);
            com.baidu.ar.arplay.c.b.b(TAG, "mMediaPlayer resumeVideo");
            b(new a(this, hashMap) { // from class: com.baidu.ar.arplay.a.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HashMap cZ;
                public final /* synthetic */ e dH;

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
                    this.dH = this;
                    this.cZ = hashMap;
                }
            }, eVar.getId());
        }
    }

    public void d(com.baidu.ar.arplay.a.a.e eVar, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, eVar, hashMap) == null) {
            c(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES, hashMap);
            a(new a(this, hashMap) { // from class: com.baidu.ar.arplay.a.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HashMap cZ;
                public final /* synthetic */ e dH;

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
                    this.dH = this;
                    this.cZ = hashMap;
                }
            }, eVar.getId());
        }
    }

    public synchronized void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            synchronized (this) {
                if (this.cU != null) {
                    this.cU.cancel();
                    this.cU.purge();
                    this.cU = null;
                    if (this.cV != null) {
                        this.cV.cancel();
                        this.cV = null;
                    }
                }
                com.baidu.ar.arplay.c.d.b(this.dG);
                aB();
                releaseInstance();
            }
        }
    }
}
