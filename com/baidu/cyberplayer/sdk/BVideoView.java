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
/* loaded from: classes10.dex */
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

    /* renamed from: b  reason: collision with root package name */
    public Context f33605b;

    /* renamed from: c  reason: collision with root package name */
    public CyberPlayer f33606c;

    /* renamed from: d  reason: collision with root package name */
    public Uri f33607d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f33608e;

    /* renamed from: f  reason: collision with root package name */
    public int f33609f;

    /* renamed from: g  reason: collision with root package name */
    public int f33610g;

    /* renamed from: h  reason: collision with root package name */
    public int f33611h;

    /* renamed from: i  reason: collision with root package name */
    public int f33612i;

    /* renamed from: j  reason: collision with root package name */
    public int f33613j;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f33610g = 3;
        this.f33612i = 0;
        this.f33613j = 0;
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeII(1048576, this, i4, i5) == null) || this.a.f33606c == null) {
                    return;
                }
                try {
                    this.a.f33606c.updateDisplaySize(i4, i5);
                } catch (Exception unused) {
                }
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(int i4, int i5, Buffer buffer) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, i5, buffer) == null) {
                    CyberTaskExcutor.getInstance().execute(new Runnable(this, buffer, i4, i5) { // from class: com.baidu.cyberplayer.sdk.BVideoView.2.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Buffer a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ int f33615b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ int f33616c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass2 f33617d;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr3 = {this, buffer, Integer.valueOf(i4), Integer.valueOf(i5)};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i6 = newInitContext2.flag;
                                if ((i6 & 1) != 0) {
                                    int i7 = i6 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.f33617d = this;
                            this.a = buffer;
                            this.f33615b = i4;
                            this.f33616c = i5;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.a == null) {
                                return;
                            }
                            Bitmap createBitmap = Bitmap.createBitmap(this.f33615b, this.f33616c, Bitmap.Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(this.a);
                            Bitmap a2 = o.a(createBitmap);
                            CyberLog.d(BVideoView.a, "onTakeSnapShot rotate bmp finished");
                            synchronized (this.f33617d.a.z) {
                                for (int i6 = 0; i6 < this.f33617d.a.z.size(); i6++) {
                                    ((ICyberVideoView.OnSnapShotCompleteListener) this.f33617d.a.z.get(i6)).onSnapShotComplete(a2);
                                }
                                this.f33617d.a.z.clear();
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable(this, j2) { // from class: com.baidu.cyberplayer.sdk.BVideoView.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ long a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass2 f33614b;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr3 = {this, Long.valueOf(j2)};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i4 = newInitContext2.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.f33614b = this;
                            this.a = j2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                if (this.f33614b.a.f33606c != null && Build.VERSION.SDK_INT <= 16 && this.f33614b.a.f33606c.getDecodeMode() == 4) {
                                    this.f33614b.a.f33606c.sendCommand(1002, 0, this.a, null);
                                }
                                if (this.f33614b.a.f33606c == null || this.f33614b.a.E <= 0) {
                                    return;
                                }
                                long j3 = this.a - this.f33614b.a.E;
                                HashMap hashMap = new HashMap();
                                hashMap.put("type", "20513");
                                hashMap.put("surface_drawed", "" + j3);
                                this.f33614b.a.f33606c.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public boolean a(int i4) {
                InterceptResult invokeI;
                Surface c2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048579, this, i4)) == null) {
                    String str = BVideoView.a;
                    CyberLog.d(str, "onSurfaceReady renderType:" + i4);
                    if (i4 != 0 || Build.VERSION.SDK_INT >= 16) {
                        return false;
                    }
                    if (this.a.f33606c == null || this.a.x == null || (c2 = this.a.x.c()) == null) {
                        return true;
                    }
                    this.a.f33606c.setSurface(c2);
                    return true;
                }
                return invokeI.booleanValue;
            }
        };
        this.f33605b = context.getApplicationContext();
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
            this.f33612i = 0;
            this.f33613j = 0;
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
        Surface c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || this.f33607d == null) {
            return;
        }
        this.E = System.currentTimeMillis();
        l.b();
        d();
        try {
            if (a(this.f33607d.toString())) {
                this.A = 4;
            }
            CyberPlayer cyberPlayer = new CyberPlayer(this.A, this.n, this.o);
            this.f33606c = cyberPlayer;
            cyberPlayer.setOnPreparedListener(this);
            this.f33606c.setOnCompletionListener(this);
            this.f33606c.setOnVideoSizeChangedListener(this);
            this.f33606c.setOnSeekCompleteListener(this);
            this.f33606c.setOnBufferingUpdateListener(this);
            this.f33606c.setOnErrorListener(this);
            this.f33606c.setOnInfoListener(this);
            this.f33606c.setOnMediaSourceChangedListener(this);
            if (this.m != null) {
                for (String str : this.m.keySet()) {
                    this.f33606c.setOption(str, this.m.get(str));
                }
            }
            if (this.F != null) {
                this.f33606c.setPlayJson(this.F);
            }
            if (this.G != null) {
                this.f33606c.setClarityInfo(this.G);
            }
            CyberPlayer cyberPlayer2 = this.f33606c;
            cyberPlayer2.setOption(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME, "" + this.E);
            this.f33606c.setDataSource(this.f33605b, this.f33607d, this.f33608e);
            this.f33606c.prepareAsync();
            this.f33612i = 1;
            if (this.x != null && (c2 = this.x.c()) != null) {
                this.f33606c.setSurface(c2);
            }
            this.f33606c.setScreenOnWhilePlaying(true);
            if (this.B) {
                this.f33606c.muteOrUnmuteAudio(this.B);
            }
            if (this.C) {
                this.f33606c.setLooping(this.C);
            }
            if (this.D != 1.0f) {
                this.f33606c.setSpeed(this.D);
            }
            c();
        } catch (Exception e2) {
            e2.printStackTrace();
            onError(-111, 0, null);
        }
    }

    private void c() {
        ArrayList<a.C1809a> b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || this.f33606c == null || (b2 = this.y.b()) == null) {
            return;
        }
        int size = b2.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.C1809a c1809a = b2.get(i2);
            if (c1809a != null && c1809a.a() != null) {
                this.f33606c.setExternalInfo(c1809a.a(), c1809a.b());
            }
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            CyberPlayer cyberPlayer = this.f33606c;
            if (cyberPlayer != null) {
                if (cyberPlayer.getDecodeMode() == 4) {
                    this.f33606c.reset();
                }
                this.f33606c.release();
                this.f33606c = null;
                this.f33612i = 0;
                this.f33613j = 0;
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
        int i2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? (this.f33606c == null || (i2 = this.f33612i) == -1 || i2 == 0 || i2 == 1) ? false : true : invokeV.booleanValue;
    }

    private boolean f() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) ? (this.f33606c == null || (i2 = this.f33612i) == 0 || i2 == 1) ? false : true : invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void changeProxyDynamic(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f33606c != null && TextUtils.isEmpty(o.c())) {
            HashMap<String, String> hashMap = this.m;
            String str2 = hashMap != null ? hashMap.get(CyberPlayerManager.OPT_HTTP_PROXY) : null;
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.f33606c.changeProxyDynamic(null, false);
            } else if (str.equals(str2)) {
                return;
            } else {
                this.f33606c.changeProxyDynamic(str, true);
            }
            this.f33606c.seekTo(getCurrentPosition() - 500);
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
            Map<String, String> map = this.f33608e;
            if (map != null) {
                map.clear();
                this.f33608e = null;
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
                return this.f33606c.getCurrentPosition();
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
                return this.f33606c.getCurrentPositionSync();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public CyberPlayer getCyberPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f33606c : (CyberPlayer) invokeV.objValue;
    }

    public int getDecodeMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            CyberPlayer cyberPlayer = this.f33606c;
            return cyberPlayer != null ? cyberPlayer.getDecodeMode() : this.A;
        }
        return invokeV.intValue;
    }

    public long getDownloadSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            CyberPlayer cyberPlayer = this.f33606c;
            if (cyberPlayer == null || this.f33612i == 0) {
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
                return this.f33606c.getDuration();
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
                return this.f33606c.getPlayedTime();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? e() && this.f33612i == 3 : invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void muteOrUnmuteAudio(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.B = z;
            String str = a;
            CyberLog.i(str, "muteOrUnmuteAudio flag:" + z);
            CyberPlayer cyberPlayer = this.f33606c;
            if (cyberPlayer != null) {
                cyberPlayer.muteOrUnmuteAudio(z);
            } else {
                CyberLog.i(a, "muteOrUnmuteAudio must call after setVideoPath or setVideoURI");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i2) {
        CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || (onBufferingUpdateListener = this.t) == null) {
            return;
        }
        onBufferingUpdateListener.onBufferingUpdate(i2);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f33612i = 5;
            this.f33613j = 5;
            CyberPlayerManager.OnCompletionListener onCompletionListener = this.r;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048593, this, i2, i3, obj)) == null) {
            this.f33612i = -1;
            this.f33613j = -1;
            CyberPlayerManager.OnErrorListener onErrorListener = this.u;
            if (onErrorListener != null) {
                return onErrorListener.onError(i2, i3, obj);
            }
            return true;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        CyberPlayer cyberPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048594, this, i2, i3, obj)) == null) {
            if (i2 == 10001 && (cyberPlayer = this.f33606c) != null && cyberPlayer.getDecodeMode() != 4) {
                this.x.c(i3);
            }
            CyberPlayerManager.OnInfoListener onInfoListener = this.v;
            return onInfoListener != null && onInfoListener.onInfo(i2, i3, obj);
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048595, this, i2, i3, obj)) == null) {
            CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener = this.w;
            return onMediaSourceChangedListener != null && onMediaSourceChangedListener.onMediaSourceChanged(i2, i3, obj);
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f33612i = 2;
            CyberPlayerManager.OnPreparedListener onPreparedListener = this.p;
            if (onPreparedListener != null) {
                onPreparedListener.onPrepared();
            }
            int i2 = this.f33609f;
            if (i2 > 0) {
                seekTo(i2, this.f33610g);
            }
            this.f33609f = -1;
            int i3 = this.f33611h;
            if (i3 != Integer.MIN_VALUE) {
                switchMediaSource(i3);
                this.f33611h = Integer.MIN_VALUE;
            }
            String str = a;
            CyberLog.i(str, "onPrepared mTargetState::" + this.f33613j);
            if (this.f33613j == 3 && this.f33612i == 2) {
                start();
            } else if (this.f33613j == 4 && this.f33612i == 2) {
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
    public void onVideoSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048598, this, i2, i3, i4, i5) == null) {
            this.k = i2;
            this.l = i3;
            e eVar = this.x;
            if (eVar != null) {
                eVar.a(i2, i3, i4, i5);
            }
            CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener = this.q;
            if (onVideoSizeChangedListener != null) {
                onVideoSizeChangedListener.onVideoSizeChanged(i2, i3, i4, i5);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (e()) {
                this.f33606c.pause();
                this.f33612i = 4;
            } else {
                CyberPlayer cyberPlayer = this.f33606c;
                if (cyberPlayer != null) {
                    cyberPlayer.sendCommand(1000, 0, 0L, null);
                }
            }
            this.f33613j = 4;
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
            this.f33609f = -1;
            this.f33611h = Integer.MIN_VALUE;
            this.f33607d = null;
            this.f33608e = null;
            this.n = null;
            this.G = null;
            this.F = null;
            if (this.f33612i == -1 && (cyberPlayer = this.f33606c) != null) {
                cyberPlayer.release();
                this.f33606c = null;
            }
            this.A = 0;
            this.f33612i = 0;
            this.f33613j = 0;
            this.k = 0;
            this.l = 0;
            CyberPlayer cyberPlayer2 = this.f33606c;
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
    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048601, this, i2) == null) || this.f33606c == null) {
            return;
        }
        if (e()) {
            this.f33606c.seekTo(i2);
        } else {
            this.f33609f = i2;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048602, this, i2, i3) == null) || this.f33606c == null) {
            return;
        }
        if (e()) {
            this.f33606c.seekTo(i2, i3);
            return;
        }
        this.f33610g = i3;
        this.f33609f = i2;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setClarityInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                CyberLog.w(a, "setClarityInfo is null");
                return;
            }
            CyberPlayer cyberPlayer = this.f33606c;
            if (cyberPlayer != null) {
                cyberPlayer.setClarityInfo(str);
            } else {
                this.G = str;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setDecodeMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.A = i2;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setExternalInfo(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048605, this, str, obj) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        CyberPlayer cyberPlayer = this.f33606c;
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
            CyberPlayer cyberPlayer = this.f33606c;
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
            if (this.f33612i != 0) {
                CyberLog.i(a, "Do not set option when the video player playing");
                return;
            }
            HashMap<String, String> hashMap = this.m;
            if (hashMap != null) {
                hashMap.put(str, str2);
            }
            if (this.f33606c != null) {
                if (str == null || !str.equals(CyberPlayerManager.OPT_HTTP_PROXY) || TextUtils.isEmpty(o.c())) {
                    this.f33606c.setOption(str, str2);
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
            CyberPlayer cyberPlayer = this.f33606c;
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
    public void setSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048619, this, f2) == null) {
            CyberLog.i(a, "setSpeed()");
            this.D = f2;
            CyberPlayer cyberPlayer = this.f33606c;
            if (cyberPlayer != null) {
                cyberPlayer.setSpeed(f2);
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
    public void setVideoRotation(int i2) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048621, this, i2) == null) || (eVar = this.x) == null) {
            return;
        }
        eVar.b(i2);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoScalingMode(int i2) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048622, this, i2) == null) || (eVar = this.x) == null) {
            return;
        }
        eVar.a(i2);
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
            this.f33607d = uri;
            this.f33608e = map;
            this.f33609f = -1;
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
            CyberLog.i(str, "start mCyberPlayer:" + this.f33606c + " mCurrentState:" + this.f33612i);
            if (e()) {
                this.f33606c.start();
                this.f33612i = 3;
            } else {
                CyberPlayer cyberPlayer = this.f33606c;
                if (cyberPlayer != null) {
                    cyberPlayer.sendCommand(1000, 1, 0L, null);
                }
            }
            this.f33613j = 3;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            CyberPlayer cyberPlayer = this.f33606c;
            if (cyberPlayer != null) {
                cyberPlayer.setOnPreparedListener(null);
                this.f33606c.setOnCompletionListener(null);
                this.f33606c.setOnVideoSizeChangedListener(null);
                this.f33606c.setOnSeekCompleteListener(null);
                this.f33606c.setOnBufferingUpdateListener(null);
                this.f33606c.setOnErrorListener(null);
                this.f33606c.setOnInfoListener(null);
                this.f33606c.setOnMediaSourceChangedListener(null);
                this.f33606c.stop();
                this.f33606c.release();
                this.f33606c = null;
                this.f33612i = 0;
                this.f33613j = 0;
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
    public void switchMediaSource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i2) == null) {
            if (e()) {
                this.f33606c.switchMediaSource(i2);
            } else {
                this.f33611h = i2;
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
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener, float f2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048629, this, new Object[]{onSnapShotCompleteListener, Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (onSnapShotCompleteListener == null) {
                return false;
            }
            CyberLog.d(a, "takeSnapshotAsync called");
            if (this.x != null) {
                synchronized (this.z) {
                    if (this.z.isEmpty()) {
                        this.x.a(f2, i2, i3);
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
