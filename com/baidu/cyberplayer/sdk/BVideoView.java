package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Region;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.ICyberVideoView;
import com.baidu.cyberplayer.sdk.a;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.e;
import com.baidu.cyberplayer.sdk.i;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes.dex */
public class BVideoView extends GLSurfaceView implements CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnMediaSourceChangedListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnVideoSizeChangedListener, ICyberVideoView {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "BVideoView";
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public boolean B;
    public boolean C;
    public float D;
    public long E;
    public String F;
    public String G;
    public i.a H;
    public Context b;
    public CyberPlayer c;
    public Uri d;
    public Map<String, String> e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public HashMap<String, String> m;
    public CyberPlayerManager.HttpDNS n;
    public boolean o;
    public CyberPlayerManager.OnPreparedListener p;
    public CyberPlayerManager.OnVideoSizeChangedListener q;
    public CyberPlayerManager.OnCompletionListener r;
    public CyberPlayerManager.OnSeekCompleteListener s;
    public CyberPlayerManager.OnBufferingUpdateListener t;
    public CyberPlayerManager.OnErrorListener u;
    public CyberPlayerManager.OnInfoListener v;
    public CyberPlayerManager.OnMediaSourceChangedListener w;
    public e x;
    public a y;
    public ArrayList<ICyberVideoView.OnSnapShotCompleteListener> z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-315620699, "Lcom/baidu/cyberplayer/sdk/BVideoView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-315620699, "Lcom/baidu/cyberplayer/sdk/BVideoView;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BVideoView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.g = 3;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = new HashMap<>();
        this.o = true;
        this.A = 0;
        this.D = 1.0f;
        this.E = 0L;
        this.F = null;
        this.G = null;
        this.H = new i.a(this) { // from class: com.baidu.cyberplayer.sdk.BVideoView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BVideoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeII(1048576, this, i3, i4) == null) || this.a.c == null) {
                    return;
                }
                try {
                    this.a.c.updateDisplaySize(i3, i4);
                } catch (Exception unused) {
                }
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(int i3, int i4, Buffer buffer) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, i4, buffer) == null) {
                    CyberTaskExcutor.getInstance().execute(new Runnable(this, buffer, i3, i4) { // from class: com.baidu.cyberplayer.sdk.BVideoView.2.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Buffer a;
                        public final /* synthetic */ int b;
                        public final /* synthetic */ int c;
                        public final /* synthetic */ AnonymousClass2 d;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr3 = {this, buffer, Integer.valueOf(i3), Integer.valueOf(i4)};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i5 = newInitContext2.flag;
                                if ((i5 & 1) != 0) {
                                    int i6 = i5 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.d = this;
                            this.a = buffer;
                            this.b = i3;
                            this.c = i4;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.a == null) {
                                return;
                            }
                            Bitmap createBitmap = Bitmap.createBitmap(this.b, this.c, Bitmap.Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(this.a);
                            Bitmap a2 = o.a(createBitmap);
                            CyberLog.d(BVideoView.a, "onTakeSnapShot rotate bmp finished");
                            synchronized (this.d.a.z) {
                                for (int i5 = 0; i5 < this.d.a.z.size(); i5++) {
                                    ((ICyberVideoView.OnSnapShotCompleteListener) this.d.a.z.get(i5)).onSnapShotComplete(a2);
                                }
                                this.d.a.z.clear();
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable(this, j) { // from class: com.baidu.cyberplayer.sdk.BVideoView.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ long a;
                        public final /* synthetic */ AnonymousClass2 b;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr3 = {this, Long.valueOf(j)};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i3 = newInitContext2.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.b = this;
                            this.a = j;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                if (this.b.a.c != null && Build.VERSION.SDK_INT <= 16 && this.b.a.c.getDecodeMode() == 4) {
                                    this.b.a.c.sendCommand(1002, 0, this.a, null);
                                }
                                if (this.b.a.c == null || this.b.a.E <= 0) {
                                    return;
                                }
                                long j2 = this.a - this.b.a.E;
                                HashMap hashMap = new HashMap();
                                hashMap.put("type", "20513");
                                hashMap.put("surface_drawed", "" + j2);
                                this.b.a.c.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public boolean a(int i3) {
                InterceptResult invokeI;
                Surface c;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048579, this, i3)) == null) {
                    String str = BVideoView.a;
                    CyberLog.d(str, "onSurfaceReady renderType:" + i3);
                    if (i3 != 0 || Build.VERSION.SDK_INT >= 16) {
                        return false;
                    }
                    if (this.a.c == null || this.a.x == null || (c = this.a.x.c()) == null) {
                        return true;
                    }
                    this.a.c.setSurface(c);
                    return true;
                }
                return invokeI.booleanValue;
            }
        };
        this.b = context.getApplicationContext();
        this.y = new a();
        this.z = new ArrayList<>();
        reset();
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            if (CyberCfgManager.getInstance().a("videoview_auto_requestfocus", false)) {
                setFocusable(true);
                setFocusableInTouchMode(true);
                requestFocus();
            }
            this.i = 0;
            this.j = 0;
            this.k = 0;
            this.l = 0;
            setEGLContextClientVersion(2);
            e eVar = new e();
            this.x = eVar;
            setRenderer(eVar);
            setRenderMode(0);
            this.x.a(this.H);
            this.x.a(new e.a(this) { // from class: com.baidu.cyberplayer.sdk.BVideoView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BVideoView a;

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
                    this.a = this;
                }

                @Override // com.baidu.cyberplayer.sdk.e.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.requestRender();
                    }
                }
            });
        }
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            try {
                if (CyberCfgManager.getInstance().a("enable_hls_force_mediaplayer", false) && str.split("\\?")[0].endsWith(".m3u8")) {
                    CyberLog.d(a, "force mediaplayer");
                    return true;
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void b() {
        Surface c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || this.d == null) {
            return;
        }
        this.E = System.currentTimeMillis();
        l.b();
        d();
        try {
            if (a(this.d.toString())) {
                this.A = 4;
            }
            CyberPlayer cyberPlayer = new CyberPlayer(this.A, this.n, this.o);
            this.c = cyberPlayer;
            cyberPlayer.setOnPreparedListener(this);
            this.c.setOnCompletionListener(this);
            this.c.setOnVideoSizeChangedListener(this);
            this.c.setOnSeekCompleteListener(this);
            this.c.setOnBufferingUpdateListener(this);
            this.c.setOnErrorListener(this);
            this.c.setOnInfoListener(this);
            this.c.setOnMediaSourceChangedListener(this);
            if (this.m != null) {
                for (String str : this.m.keySet()) {
                    this.c.setOption(str, this.m.get(str));
                }
            }
            if (this.F != null) {
                this.c.setPlayJson(this.F);
            }
            if (this.G != null) {
                this.c.setClarityInfo(this.G);
            }
            CyberPlayer cyberPlayer2 = this.c;
            cyberPlayer2.setOption(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME, "" + this.E);
            this.c.setDataSource(this.b, this.d, this.e);
            this.c.prepareAsync();
            this.i = 1;
            if (this.x != null && (c = this.x.c()) != null) {
                this.c.setSurface(c);
            }
            this.c.setScreenOnWhilePlaying(true);
            if (this.B) {
                this.c.muteOrUnmuteAudio(this.B);
            }
            if (this.C) {
                this.c.setLooping(this.C);
            }
            if (this.D != 1.0f) {
                this.c.setSpeed(this.D);
            }
            c();
        } catch (Exception e) {
            e.printStackTrace();
            onError(-111, 0, null);
        }
    }

    private void c() {
        ArrayList<a.C0085a> b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || this.c == null || (b = this.y.b()) == null) {
            return;
        }
        int size = b.size();
        for (int i = 0; i < size; i++) {
            a.C0085a c0085a = b.get(i);
            if (c0085a != null && c0085a.a() != null) {
                this.c.setExternalInfo(c0085a.a(), c0085a.b());
            }
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            CyberPlayer cyberPlayer = this.c;
            if (cyberPlayer != null) {
                if (cyberPlayer.getDecodeMode() == 4) {
                    this.c.reset();
                }
                this.c.release();
                this.c = null;
                this.i = 0;
                this.j = 0;
                this.k = 0;
                this.l = 0;
            }
            e eVar = this.x;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    private boolean e() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? (this.c == null || (i = this.i) == -1 || i == 0 || i == 1) ? false : true : invokeV.booleanValue;
    }

    private boolean f() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) ? (this.c == null || (i = this.i) == 0 || i == 1) ? false : true : invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void changeProxyDynamic(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.c != null && TextUtils.isEmpty(o.c())) {
            HashMap<String, String> hashMap = this.m;
            String str2 = hashMap != null ? hashMap.get(CyberPlayerManager.OPT_HTTP_PROXY) : null;
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.c.changeProxyDynamic(null, false);
            } else if (str.equals(str2)) {
                return;
            } else {
                this.c.changeProxyDynamic(str, true);
            }
            this.c.seekTo(getCurrentPosition() - 500);
            HashMap<String, String> hashMap2 = this.m;
            if (hashMap2 != null) {
                hashMap2.put(CyberPlayerManager.OPT_HTTP_PROXY, str);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            CyberLog.i(a, "destory called");
            d();
            HashMap<String, String> hashMap = this.m;
            if (hashMap != null) {
                hashMap.clear();
                this.m = null;
            }
            a aVar = this.y;
            if (aVar != null) {
                aVar.a();
                this.y = null;
            }
            synchronized (this.z) {
                if (this.z != null) {
                    this.z.clear();
                }
            }
            Map<String, String> map = this.e;
            if (map != null) {
                map.clear();
                this.e = null;
            }
            this.n = null;
            this.p = null;
            this.q = null;
            this.r = null;
            this.s = null;
            this.t = null;
            this.u = null;
            this.v = null;
            this.w = null;
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, region)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (f()) {
                return this.c.getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getCurrentPositionSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (f()) {
                return this.c.getCurrentPositionSync();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public CyberPlayer getCyberPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.c : (CyberPlayer) invokeV.objValue;
    }

    public int getDecodeMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            CyberPlayer cyberPlayer = this.c;
            return cyberPlayer != null ? cyberPlayer.getDecodeMode() : this.A;
        }
        return invokeV.intValue;
    }

    public long getDownloadSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            CyberPlayer cyberPlayer = this.c;
            if (cyberPlayer == null || this.i == 0) {
                return -1L;
            }
            return cyberPlayer.getDownloadSpeed();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (f()) {
                return this.c.getDuration();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public long getPlayedTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (f()) {
                return this.c.getPlayedTime();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.l : invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.k : invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? e() && this.i == 3 : invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void muteOrUnmuteAudio(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.B = z;
            String str = a;
            CyberLog.i(str, "muteOrUnmuteAudio flag:" + z);
            CyberPlayer cyberPlayer = this.c;
            if (cyberPlayer != null) {
                cyberPlayer.muteOrUnmuteAudio(z);
            } else {
                CyberLog.i(a, "muteOrUnmuteAudio must call after setVideoPath or setVideoURI");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i) {
        CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i) == null) || (onBufferingUpdateListener = this.t) == null) {
            return;
        }
        onBufferingUpdateListener.onBufferingUpdate(i);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.i = 5;
            this.j = 5;
            CyberPlayerManager.OnCompletionListener onCompletionListener = this.r;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048593, this, i, i2, obj)) == null) {
            this.i = -1;
            this.j = -1;
            CyberPlayerManager.OnErrorListener onErrorListener = this.u;
            if (onErrorListener != null) {
                return onErrorListener.onError(i, i2, obj);
            }
            return true;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        CyberPlayer cyberPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048594, this, i, i2, obj)) == null) {
            if (i == 10001 && (cyberPlayer = this.c) != null && cyberPlayer.getDecodeMode() != 4) {
                this.x.c(i2);
            }
            CyberPlayerManager.OnInfoListener onInfoListener = this.v;
            return onInfoListener != null && onInfoListener.onInfo(i, i2, obj);
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048595, this, i, i2, obj)) == null) {
            CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener = this.w;
            return onMediaSourceChangedListener != null && onMediaSourceChangedListener.onMediaSourceChanged(i, i2, obj);
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.i = 2;
            CyberPlayerManager.OnPreparedListener onPreparedListener = this.p;
            if (onPreparedListener != null) {
                onPreparedListener.onPrepared();
            }
            int i = this.f;
            if (i > 0) {
                seekTo(i, this.g);
            }
            this.f = -1;
            int i2 = this.h;
            if (i2 != Integer.MIN_VALUE) {
                switchMediaSource(i2);
                this.h = Integer.MIN_VALUE;
            }
            String str = a;
            CyberLog.i(str, "onPrepared mTargetState::" + this.j);
            if (this.j == 3 && this.i == 2) {
                start();
            } else if (this.j == 4 && this.i == 2) {
                pause();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (onSeekCompleteListener = this.s) == null) {
            return;
        }
        onSeekCompleteListener.onSeekComplete();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048598, this, i, i2, i3, i4) == null) {
            this.k = i;
            this.l = i2;
            e eVar = this.x;
            if (eVar != null) {
                eVar.a(i, i2, i3, i4);
            }
            CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener = this.q;
            if (onVideoSizeChangedListener != null) {
                onVideoSizeChangedListener.onVideoSizeChanged(i, i2, i3, i4);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (e()) {
                this.c.pause();
                this.i = 4;
            } else {
                CyberPlayer cyberPlayer = this.c;
                if (cyberPlayer != null) {
                    cyberPlayer.sendCommand(1000, 0, 0L, null);
                }
            }
            this.j = 4;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void reset() {
        CyberPlayer cyberPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.B = false;
            this.o = true;
            this.C = false;
            this.D = 1.0f;
            this.f = -1;
            this.h = Integer.MIN_VALUE;
            this.d = null;
            this.e = null;
            this.n = null;
            this.G = null;
            this.F = null;
            if (this.i == -1 && (cyberPlayer = this.c) != null) {
                cyberPlayer.release();
                this.c = null;
            }
            this.A = 0;
            this.i = 0;
            this.j = 0;
            this.k = 0;
            this.l = 0;
            CyberPlayer cyberPlayer2 = this.c;
            if (cyberPlayer2 != null) {
                cyberPlayer2.reset();
            }
            e eVar = this.x;
            if (eVar != null) {
                eVar.b();
            }
            HashMap<String, String> hashMap = this.m;
            if (hashMap != null) {
                hashMap.clear();
            }
            a aVar = this.y;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048601, this, i) == null) || this.c == null) {
            return;
        }
        if (e()) {
            this.c.seekTo(i);
        } else {
            this.f = i;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048602, this, i, i2) == null) || this.c == null) {
            return;
        }
        if (e()) {
            this.c.seekTo(i, i2);
            return;
        }
        this.g = i2;
        this.f = i;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setClarityInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                CyberLog.w(a, "setClarityInfo is null");
                return;
            }
            CyberPlayer cyberPlayer = this.c;
            if (cyberPlayer != null) {
                cyberPlayer.setClarityInfo(str);
            } else {
                this.G = str;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setDecodeMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.A = i;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setExternalInfo(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048605, this, str, obj) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        CyberPlayer cyberPlayer = this.c;
        if (cyberPlayer != null) {
            cyberPlayer.setExternalInfo(str, obj);
        } else {
            this.y.a(str, obj);
        }
    }

    public void setHttpDns(CyberPlayerManager.HttpDNS httpDNS) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, httpDNS) == null) {
            this.n = httpDNS;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.C = z;
            CyberPlayer cyberPlayer = this.c;
            if (cyberPlayer != null) {
                cyberPlayer.setLooping(z);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onBufferingUpdateListener) == null) {
            this.t = onBufferingUpdateListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, onCompletionListener) == null) {
            this.r = onCompletionListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, onErrorListener) == null) {
            this.u = onErrorListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, onInfoListener) == null) {
            this.v = onInfoListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, onMediaSourceChangedListener) == null) {
            this.w = onMediaSourceChangedListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, onPreparedListener) == null) {
            this.p = onPreparedListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, onSeekCompleteListener) == null) {
            this.s = onSeekCompleteListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, onVideoSizeChangedListener) == null) {
            this.q = onVideoSizeChangedListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOption(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, str, str2) == null) {
            if (this.i != 0) {
                CyberLog.i(a, "Do not set option when the video player playing");
                return;
            }
            HashMap<String, String> hashMap = this.m;
            if (hashMap != null) {
                hashMap.put(str, str2);
            }
            if (this.c != null) {
                if (str == null || !str.equals(CyberPlayerManager.OPT_HTTP_PROXY) || TextUtils.isEmpty(o.c())) {
                    this.c.setOption(str, str2);
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setPlayJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                CyberLog.w(a, "setPlayJson is null");
                return;
            }
            CyberPlayer cyberPlayer = this.c;
            if (cyberPlayer != null) {
                cyberPlayer.setPlayJson(str);
            } else {
                this.F = str;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setRemote(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.o = z;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setSpeed(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048619, this, f) == null) {
            CyberLog.i(a, "setSpeed()");
            this.D = f;
            CyberPlayer cyberPlayer = this.c;
            if (cyberPlayer != null) {
                cyberPlayer.setSpeed(f);
            } else {
                CyberLog.i(a, "setSpeed must call after setVideoPath or setVideoURI");
            }
        }
    }

    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            setVideoURI(Uri.parse(str));
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoRotation(int i) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048621, this, i) == null) || (eVar = this.x) == null) {
            return;
        }
        eVar.b(i);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoScalingMode(int i) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048622, this, i) == null) || (eVar = this.x) == null) {
            return;
        }
        eVar.a(i);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, uri) == null) {
            setVideoURI(uri, null);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048624, this, uri, map) == null) {
            this.d = uri;
            this.e = map;
            this.f = -1;
            b();
            requestLayout();
            invalidate();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            String str = a;
            CyberLog.i(str, "start mCyberPlayer:" + this.c + " mCurrentState:" + this.i);
            if (e()) {
                this.c.start();
                this.i = 3;
            } else {
                CyberPlayer cyberPlayer = this.c;
                if (cyberPlayer != null) {
                    cyberPlayer.sendCommand(1000, 1, 0L, null);
                }
            }
            this.j = 3;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            CyberPlayer cyberPlayer = this.c;
            if (cyberPlayer != null) {
                cyberPlayer.setOnPreparedListener(null);
                this.c.setOnCompletionListener(null);
                this.c.setOnVideoSizeChangedListener(null);
                this.c.setOnSeekCompleteListener(null);
                this.c.setOnBufferingUpdateListener(null);
                this.c.setOnErrorListener(null);
                this.c.setOnInfoListener(null);
                this.c.setOnMediaSourceChangedListener(null);
                this.c.stop();
                this.c.release();
                this.c = null;
                this.i = 0;
                this.j = 0;
            }
            HashMap<String, String> hashMap = this.m;
            if (hashMap != null) {
                hashMap.clear();
            }
            e eVar = this.x;
            if (eVar != null) {
                eVar.a();
            }
            a aVar = this.y;
            if (aVar != null) {
                aVar.a();
            }
            this.F = null;
            this.G = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void switchMediaSource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i) == null) {
            if (e()) {
                this.c.switchMediaSource(i);
            } else {
                this.h = i;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, onSnapShotCompleteListener)) == null) ? takeSnapshotAsync(onSnapShotCompleteListener, 1.0f, 0, 0) : invokeL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener, float f, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048629, this, new Object[]{onSnapShotCompleteListener, Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (onSnapShotCompleteListener == null) {
                return false;
            }
            CyberLog.d(a, "takeSnapshotAsync called");
            if (this.x != null) {
                synchronized (this.z) {
                    if (this.z.isEmpty()) {
                        this.x.a(f, i, i2);
                    }
                    this.z.add(onSnapShotCompleteListener);
                }
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
