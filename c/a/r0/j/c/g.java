package c.a.r0.j.c;

import android.webkit.JavascriptInterface;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.k;
import c.a.r0.j.c.j.a;
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
/* loaded from: classes6.dex */
public class g extends EventTargetImpl implements c.a.r0.j.c.a, c.a.r0.j.c.b {
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
    public AudioPlayer f10848e;

    /* renamed from: f  reason: collision with root package name */
    public String f10849f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.a.l0.c f10850g;
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

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f10851e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f10852f;

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
            this.f10852f = gVar;
            this.f10851e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.f10851e || this.f10852f.f10848e.I()) {
                    this.f10852f.f10848e.N(c.a.r0.j.c.f.c(this.f10852f));
                    g gVar = this.f10852f;
                    if (gVar.autoplay) {
                        gVar.f10848e.Q();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f10853e;

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
            this.f10853e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10853e.f10848e.Q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f10854e;

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
            this.f10854e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10854e.f10848e.O();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f10855e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f10856f;

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
            this.f10856f = gVar;
            this.f10855e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10856f.f10848e.U(this.f10855e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f10857e;

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
            this.f10857e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10857e.f10848e.Y();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f10858e;

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
            this.f10858e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10858e.f10848e.T();
            }
        }
    }

    /* renamed from: c.a.r0.j.c.g$g  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0734g implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        /* renamed from: c.a.r0.j.c.g$g$a */
        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f10859e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C0734g f10860f;

            public a(C0734g c0734g, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0734g, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10860f = c0734g;
                this.f10859e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f10860f.a.src = c.a.r0.a.g1.f.U().G().g(this.f10859e);
                    if (k.a) {
                        String str = "prepare path: " + this.f10860f.a.src + " autoPlay: " + this.f10860f.a.autoplay + " class: " + toString();
                    }
                    this.f10860f.a.E(true);
                }
            }
        }

        public C0734g(g gVar) {
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
            this.a = gVar;
        }

        @Override // c.a.r0.j.c.j.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.f10850g.runOnJSThread(new a(this, str));
            }
        }

        @Override // c.a.r0.j.c.j.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(c.a.r0.a.l0.c cVar) {
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
        this.f10850g = cVar;
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
            String valueOf = String.valueOf(c.a.r0.j.c.c.a());
            this.f10849f = valueOf;
            this.f10848e = C(valueOf);
            D();
        }
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AudioPlayer audioPlayer = this.f10848e;
            if (audioPlayer != null) {
                return audioPlayer.y();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f10848e == null) {
            return;
        }
        c.a.r0.j.c.e eVar = new c.a.r0.j.c.e(this, c.a.r0.j.c.f.i());
        eVar.e(this);
        this.f10848e.V(eVar);
    }

    public final void E(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || this.f10848e == null) {
            return;
        }
        c.a.r0.j.c.j.b.h().e().post(new a(this, z));
    }

    public final void F(c.a.r0.j.c.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.f10848e.update(dVar);
        }
    }

    @Override // c.a.r0.j.c.a
    @JavascriptInterface
    public void destroy() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f10848e == null) {
            return;
        }
        c.a.r0.j.c.j.b.h().e().post(new f(this));
    }

    @Override // c.a.r0.j.c.a
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AudioPlayer audioPlayer = this.f10848e;
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
            boolean z = k.a;
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
                F(c.a.r0.j.c.f.c(this));
            } else if (c2 == 2) {
                if (c.a.r0.j.c.f.b(this.volume)) {
                    F(c.a.r0.j.c.f.c(this));
                } else {
                    this.volume = this.f10848e.D();
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
    @Override // c.a.r0.j.c.b
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

    @Override // c.a.r0.j.c.a
    @JavascriptInterface
    public void pause() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f10848e == null) {
            return;
        }
        c.a.r0.j.c.j.b.h().e().post(new c(this));
    }

    @Override // c.a.r0.j.c.a
    @JavascriptInterface
    public void play() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f10848e == null) {
            return;
        }
        c.a.r0.j.c.j.b.h().e().post(new b(this));
    }

    @Override // c.a.r0.j.c.a
    @JavascriptInterface
    public void seek(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048587, this, f2) == null) || this.f10848e == null) {
            return;
        }
        c.a.r0.j.c.j.b.h().e().post(new d(this, f2));
    }

    @JavascriptInterface
    public void setDataBuffer(JsArrayBuffer jsArrayBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jsArrayBuffer) == null) {
            c.a.r0.j.c.j.b.h().m(jsArrayBuffer, new C0734g(this));
        }
    }

    @Override // c.a.r0.j.c.a
    @JavascriptInterface
    public void stop() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.f10848e == null) {
            return;
        }
        c.a.r0.j.c.j.b.h().e().post(new e(this));
    }

    @Override // c.a.r0.j.c.a
    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            AudioPlayer audioPlayer = this.f10848e;
            if (audioPlayer != null) {
                return audioPlayer.z();
            }
            return 0;
        }
        return invokeV.intValue;
    }
}
