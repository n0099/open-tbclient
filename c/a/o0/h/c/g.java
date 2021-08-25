package c.a.o0.h.c;

import android.webkit.JavascriptInterface;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.k;
import c.a.o0.h.c.j.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.audio.AudioPlayer;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends EventTargetImpl implements c.a.o0.h.c.a, c.a.o0.h.c.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @V8JavascriptField
    public boolean autoplay;
    @V8JavascriptField
    public int buffered;
    @V8JavascriptField
    public double currentTime;
    @V8JavascriptField
    public long duration;

    /* renamed from: e  reason: collision with root package name */
    public AudioPlayer f11020e;

    /* renamed from: f  reason: collision with root package name */
    public String f11021f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.o0.a.l0.c f11022g;
    @V8JavascriptField
    public boolean loop;
    @V8JavascriptField
    public boolean obeyMuteSwitch;
    @V8JavascriptField
    public boolean paused;
    @V8JavascriptField
    public String src;
    @V8JavascriptField
    public float startTime;
    @V8JavascriptField
    public float volume;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f11023e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f11024f;

        public a(g gVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11024f = gVar;
            this.f11023e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.f11023e || this.f11024f.f11020e.I()) {
                    this.f11024f.f11020e.N(c.a.o0.h.c.f.c(this.f11024f));
                    g gVar = this.f11024f;
                    if (gVar.autoplay) {
                        gVar.f11020e.Q();
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f11025e;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11025e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11025e.f11020e.Q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f11026e;

        public c(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11026e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11026e.f11020e.O();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f11027e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f11028f;

        public d(g gVar, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11028f = gVar;
            this.f11027e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11028f.f11020e.U(this.f11027e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f11029e;

        public e(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11029e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11029e.f11020e.Y();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f11030e;

        public f(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11030e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11030e.f11020e.T();
            }
        }
    }

    /* renamed from: c.a.o0.h.c.g$g  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0556g implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f11031a;

        /* renamed from: c.a.o0.h.c.g$g$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f11032e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C0556g f11033f;

            public a(C0556g c0556g, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0556g, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11033f = c0556g;
                this.f11032e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f11033f.f11031a.src = c.a.o0.a.g1.f.V().I().g(this.f11032e);
                    if (k.f7049a) {
                        String str = "prepare path: " + this.f11033f.f11031a.src + " autoPlay: " + this.f11033f.f11031a.autoplay + " class: " + toString();
                    }
                    this.f11033f.f11031a.E(true);
                }
            }
        }

        public C0556g(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11031a = gVar;
        }

        @Override // c.a.o0.h.c.j.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f11031a.f11022g.runOnJSThread(new a(this, str));
            }
        }

        @Override // c.a.o0.h.c.j.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(c.a.o0.a.l0.c cVar) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.src = "";
        this.volume = 1.0f;
        this.obeyMuteSwitch = true;
        this.paused = true;
        this.f11022g = cVar;
        A();
    }

    public static AudioPlayer C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? new AudioPlayer(str) : (AudioPlayer) invokeL.objValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String valueOf = String.valueOf(c.a.o0.h.c.c.a());
            this.f11021f = valueOf;
            this.f11020e = C(valueOf);
            D();
        }
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AudioPlayer audioPlayer = this.f11020e;
            if (audioPlayer != null) {
                return audioPlayer.y();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f11020e == null) {
            return;
        }
        c.a.o0.h.c.e eVar = new c.a.o0.h.c.e(this, c.a.o0.h.c.f.i());
        eVar.e(this);
        this.f11020e.V(eVar);
    }

    public final void E(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || this.f11020e == null) {
            return;
        }
        c.a.o0.h.c.j.b.h().e().post(new a(this, z));
    }

    public final void F(c.a.o0.h.c.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.f11020e.Z(dVar);
        }
    }

    @Override // c.a.o0.h.c.a
    @JavascriptInterface
    public void destroy() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f11020e == null) {
            return;
        }
        c.a.o0.h.c.j.b.h().e().post(new f(this));
    }

    @Override // c.a.o0.h.c.a
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AudioPlayer audioPlayer = this.f11020e;
            if (audioPlayer != null) {
                return (int) audioPlayer.A();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            boolean z = k.f7049a;
            char c2 = 65535;
            switch (str.hashCode()) {
                case -2129294769:
                    if (str.equals("startTime")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -810883302:
                    if (str.equals("volume")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 114148:
                    if (str.equals("src")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3327652:
                    if (str.equals("loop")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1439562083:
                    if (str.equals("autoplay")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            if (c2 == 0 || c2 == 1) {
                F(c.a.o0.h.c.f.c(this));
            } else if (c2 == 2) {
                if (c.a.o0.h.c.f.b(this.volume)) {
                    F(c.a.o0.h.c.f.c(this));
                } else {
                    this.volume = this.f11020e.D();
                }
            } else if (c2 != 3) {
                if (c2 == 4 && this.autoplay) {
                    play();
                }
            } else {
                E(false);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.o0.h.c.b
    public void p(String str, JSONObject jSONObject) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, jSONObject) == null) {
            switch (str.hashCode()) {
                case -1522036513:
                    if (str.equals("buffered")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3443508:
                    if (str.equals("play")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3540994:
                    if (str.equals(IntentConfig.STOP)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 96651962:
                    if (str.equals("ended")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 96784904:
                    if (str.equals("error")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 106440182:
                    if (str.equals("pause")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 550609668:
                    if (str.equals("canplay")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1762557398:
                    if (str.equals("timeupdate")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    this.buffered = B();
                    return;
                case 1:
                    if (jSONObject != null) {
                        this.duration = getDuration() / 1000;
                        this.currentTime = v() / 1000.0d;
                        return;
                    }
                    return;
                case 2:
                    this.paused = false;
                    return;
                case 3:
                case 4:
                case 5:
                case 6:
                    this.paused = true;
                    return;
                case 7:
                    this.duration = getDuration() / 1000;
                    return;
                default:
                    return;
            }
        }
    }

    @Override // c.a.o0.h.c.a
    @JavascriptInterface
    public void pause() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f11020e == null) {
            return;
        }
        c.a.o0.h.c.j.b.h().e().post(new c(this));
    }

    @Override // c.a.o0.h.c.a
    @JavascriptInterface
    public void play() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f11020e == null) {
            return;
        }
        c.a.o0.h.c.j.b.h().e().post(new b(this));
    }

    @Override // c.a.o0.h.c.a
    @JavascriptInterface
    public void seek(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048587, this, f2) == null) || this.f11020e == null) {
            return;
        }
        c.a.o0.h.c.j.b.h().e().post(new d(this, f2));
    }

    @JavascriptInterface
    public void setDataBuffer(JsArrayBuffer jsArrayBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jsArrayBuffer) == null) {
            c.a.o0.h.c.j.b.h().m(jsArrayBuffer, new C0556g(this));
        }
    }

    @Override // c.a.o0.h.c.a
    @JavascriptInterface
    public void stop() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.f11020e == null) {
            return;
        }
        c.a.o0.h.c.j.b.h().e().post(new e(this));
    }

    @Override // c.a.o0.h.c.a
    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            AudioPlayer audioPlayer = this.f11020e;
            if (audioPlayer != null) {
                return audioPlayer.z();
            }
            return 0;
        }
        return invokeV.intValue;
    }
}
