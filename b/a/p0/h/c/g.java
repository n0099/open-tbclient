package b.a.p0.h.c;

import android.webkit.JavascriptInterface;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.h.c.j.a;
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
/* loaded from: classes4.dex */
public class g extends EventTargetImpl implements b.a.p0.h.c.a, b.a.p0.h.c.b {
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
    public AudioPlayer f10258e;

    /* renamed from: f  reason: collision with root package name */
    public String f10259f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.p0.a.l0.c f10260g;
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

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f10261e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f10262f;

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
            this.f10262f = gVar;
            this.f10261e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.f10261e || this.f10262f.f10258e.I()) {
                    this.f10262f.f10258e.N(b.a.p0.h.c.f.c(this.f10262f));
                    g gVar = this.f10262f;
                    if (gVar.autoplay) {
                        gVar.f10258e.Q();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f10263e;

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
            this.f10263e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10263e.f10258e.Q();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f10264e;

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
            this.f10264e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10264e.f10258e.O();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f10265e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f10266f;

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
            this.f10266f = gVar;
            this.f10265e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10266f.f10258e.U(this.f10265e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f10267e;

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
            this.f10267e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10267e.f10258e.Y();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f10268e;

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
            this.f10268e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10268e.f10258e.T();
            }
        }
    }

    /* renamed from: b.a.p0.h.c.g$g  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0553g implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f10269a;

        /* renamed from: b.a.p0.h.c.g$g$a */
        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f10270e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C0553g f10271f;

            public a(C0553g c0553g, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0553g, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10271f = c0553g;
                this.f10270e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f10271f.f10269a.src = b.a.p0.a.g1.f.T().G().g(this.f10270e);
                    if (k.f6397a) {
                        String str = "prepare path: " + this.f10271f.f10269a.src + " autoPlay: " + this.f10271f.f10269a.autoplay + " class: " + toString();
                    }
                    this.f10271f.f10269a.D(true);
                }
            }
        }

        public C0553g(g gVar) {
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
            this.f10269a = gVar;
        }

        @Override // b.a.p0.h.c.j.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f10269a.f10260g.runOnJSThread(new a(this, str));
            }
        }

        @Override // b.a.p0.h.c.j.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(b.a.p0.a.l0.c cVar) {
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
        this.f10260g = cVar;
        z();
    }

    public static AudioPlayer B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? new AudioPlayer(str) : (AudioPlayer) invokeL.objValue;
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AudioPlayer audioPlayer = this.f10258e;
            if (audioPlayer != null) {
                return audioPlayer.y();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f10258e == null) {
            return;
        }
        b.a.p0.h.c.e eVar = new b.a.p0.h.c.e(this, b.a.p0.h.c.f.i());
        eVar.e(this);
        this.f10258e.V(eVar);
    }

    public final void D(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.f10258e == null) {
            return;
        }
        b.a.p0.h.c.j.b.h().e().post(new a(this, z));
    }

    public final void E(b.a.p0.h.c.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.f10258e.update(dVar);
        }
    }

    @Override // b.a.p0.h.c.a
    @JavascriptInterface
    public void destroy() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f10258e == null) {
            return;
        }
        b.a.p0.h.c.j.b.h().e().post(new f(this));
    }

    @Override // b.a.p0.h.c.a
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AudioPlayer audioPlayer = this.f10258e;
            if (audioPlayer != null) {
                return (int) audioPlayer.A();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // b.a.p0.h.c.b
    public void o(String str, JSONObject jSONObject) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, jSONObject) == null) {
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
                    this.buffered = A();
                    return;
                case 1:
                    if (jSONObject != null) {
                        this.duration = getDuration() / 1000;
                        this.currentTime = u() / 1000.0d;
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

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            boolean z = k.f6397a;
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
                E(b.a.p0.h.c.f.c(this));
            } else if (c2 == 2) {
                if (b.a.p0.h.c.f.b(this.volume)) {
                    E(b.a.p0.h.c.f.c(this));
                } else {
                    this.volume = this.f10258e.D();
                }
            } else if (c2 != 3) {
                if (c2 == 4 && this.autoplay) {
                    play();
                }
            } else {
                D(false);
            }
        }
    }

    @Override // b.a.p0.h.c.a
    @JavascriptInterface
    public void pause() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f10258e == null) {
            return;
        }
        b.a.p0.h.c.j.b.h().e().post(new c(this));
    }

    @Override // b.a.p0.h.c.a
    @JavascriptInterface
    public void play() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f10258e == null) {
            return;
        }
        b.a.p0.h.c.j.b.h().e().post(new b(this));
    }

    @Override // b.a.p0.h.c.a
    @JavascriptInterface
    public void seek(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048586, this, f2) == null) || this.f10258e == null) {
            return;
        }
        b.a.p0.h.c.j.b.h().e().post(new d(this, f2));
    }

    @JavascriptInterface
    public void setDataBuffer(JsArrayBuffer jsArrayBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jsArrayBuffer) == null) {
            b.a.p0.h.c.j.b.h().m(jsArrayBuffer, new C0553g(this));
        }
    }

    @Override // b.a.p0.h.c.a
    @JavascriptInterface
    public void stop() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f10258e == null) {
            return;
        }
        b.a.p0.h.c.j.b.h().e().post(new e(this));
    }

    @Override // b.a.p0.h.c.a
    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            AudioPlayer audioPlayer = this.f10258e;
            if (audioPlayer != null) {
                return audioPlayer.z();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            String valueOf = String.valueOf(b.a.p0.h.c.c.a());
            this.f10259f = valueOf;
            this.f10258e = B(valueOf);
            C();
        }
    }
}
