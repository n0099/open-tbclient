package c.a.p0.a.z0.c;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.d2.n;
import c.a.p0.a.f.b.a.l;
import c.a.p0.a.t1.e;
import c.a.p0.a.v0.e.b;
import c.a.p0.a.w0.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.media.audio.SwanAppAudioClient;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f9276i;

    /* renamed from: j  reason: collision with root package name */
    public static c.a.p0.a.d2.a f9277j;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppAudioClient a;

    /* renamed from: b  reason: collision with root package name */
    public Context f9278b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.a.z0.c.a f9279c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.a.z0.c.f.a f9280d;

    /* renamed from: e  reason: collision with root package name */
    public int f9281e;

    /* renamed from: f  reason: collision with root package name */
    public int f9282f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f9283g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.a.w0.a f9284h;

    /* loaded from: classes.dex */
    public class a extends c.a.p0.a.w0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9285e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9285e = cVar;
        }

        @Override // c.a.p0.a.w0.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
                this.f9285e.f9283g = false;
                if (this.f9285e.x()) {
                    return;
                }
                this.f9285e.p();
            }
        }

        @Override // c.a.p0.a.w0.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                this.f9285e.f9283g = true;
                if (this.f9285e.w()) {
                    if (this.f9285e.x()) {
                        c.a.p0.a.d2.a unused = c.f9277j = null;
                        return;
                    } else if (c.f9277j == null) {
                        c.a.p0.a.d2.a unused2 = c.f9277j = n.c("1044");
                        return;
                    } else {
                        return;
                    }
                }
                super.onActivityStopped(activity);
                this.f9285e.L();
                c.a.p0.a.u.d.o("SwanAppBGAudioPlayer", "stop player without requiredBackgroundModes");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.p2.g1.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9286e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9286e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    this.f9286e.v().v(this.f9286e.f9279c.c(str), str);
                } else if (TextUtils.isEmpty(str)) {
                    c.a.p0.a.d2.u.a.b("audio", 3001, "cloud url is null", -1, "");
                }
            }
        }
    }

    /* renamed from: c.a.p0.a.z0.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0608c implements SwanAppAudioClient.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f9287b;

        public C0608c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9287b = cVar;
        }

        @Override // com.baidu.swan.apps.media.audio.SwanAppAudioClient.c
        public boolean a(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i2 = message.what;
                int i3 = message.arg1;
                int i4 = message.arg2;
                JSONObject jSONObject = new JSONObject();
                this.f9287b.H(message, i4, this.f9287b.u() / 1000);
                switch (i2) {
                    case 1001:
                        d.b("SwanAppBGAudioPlayer", "#onHandleMessage [onCanPlay]");
                        c.a.p0.a.u.d.i("backgroundAudio", "event onCanPlay");
                        if (this.f9287b.f9280d != null) {
                            this.f9287b.f9280d.a("onCanplay");
                        }
                        this.a = true;
                        return true;
                    case 1002:
                        d.b("SwanAppBGAudioPlayer", "#onHandleMessage [onPlay]");
                        c.a.p0.a.u.d.i("backgroundAudio", "event onPlay");
                        if (this.f9287b.f9280d != null) {
                            this.f9287b.f9280d.a("onPlay");
                        }
                        if (this.f9287b.f9283g) {
                            c.a.p0.a.d2.a unused = c.f9277j = n.c("1044");
                        }
                        return true;
                    case 1003:
                        d.b("SwanAppBGAudioPlayer", "#onHandleMessage [onPause]");
                        c.a.p0.a.u.d.i("backgroundAudio", "event onPause");
                        if (this.f9287b.f9280d != null) {
                            this.f9287b.f9280d.a(MissionEvent.MESSAGE_PAUSE);
                        }
                        if (this.f9287b.f9283g) {
                            this.f9287b.p();
                        }
                        return true;
                    case 1004:
                        d.b("SwanAppBGAudioPlayer", "#onHandleMessage [onStop]");
                        c.a.p0.a.u.d.i("backgroundAudio", "event onStop");
                        if (this.f9287b.f9280d != null) {
                            this.f9287b.f9280d.a(MissionEvent.MESSAGE_STOP);
                        }
                        this.a = true;
                        if (this.f9287b.f9283g) {
                            this.f9287b.p();
                        }
                        return true;
                    case 1005:
                        c.a.p0.a.u.d.i("backgroundAudio", "event onEnd");
                        if (this.f9287b.f9280d != null) {
                            this.f9287b.f9280d.a("onEnded");
                        }
                        if (this.f9287b.f9283g) {
                            this.f9287b.p();
                        }
                        return true;
                    case 1006:
                        this.f9287b.f9281e = i4;
                        try {
                            jSONObject.putOpt("currentTime", Integer.valueOf(this.f9287b.r()));
                            jSONObject.putOpt("duration", Integer.valueOf(this.f9287b.u() / 1000));
                        } catch (JSONException e2) {
                            if (c.f9276i) {
                                e2.printStackTrace();
                            }
                        }
                        c.a.p0.a.u.d.i("backgroundAudio", "event onTimeUpdate " + jSONObject.toString());
                        if (this.f9287b.f9280d != null) {
                            this.f9287b.f9280d.b("onTimeUpdate", jSONObject);
                        }
                        if (this.a) {
                            if (this.f9287b.f9279c.k > 0) {
                                c cVar = this.f9287b;
                                cVar.G(cVar.f9279c.k);
                            }
                            this.a = false;
                        }
                        return true;
                    case 1007:
                        try {
                            c.a.p0.a.d2.u.a.b("audio", 4000, "audio fail, src: " + this.f9287b.v().q(), i3, "");
                            jSONObject.putOpt("errCode", Integer.valueOf(i3));
                        } catch (JSONException e3) {
                            if (c.f9276i) {
                                e3.printStackTrace();
                            }
                        }
                        c.a.p0.a.u.d.i("backgroundAudio", "event onError code:" + i3);
                        if (this.f9287b.f9280d != null) {
                            this.f9287b.f9280d.b("onError", jSONObject);
                        }
                        return true;
                    case 1008:
                        int s = this.f9287b.s();
                        this.f9287b.f9282f = i3;
                        c.a.p0.a.u.d.i("backgroundAudio", "event onDownloadProgress " + this.f9287b.f9282f);
                        if (this.f9287b.f9280d != null && s >= this.f9287b.f9282f) {
                            this.f9287b.f9280d.a("onWaiting");
                        }
                        return true;
                    case 1009:
                        c.a.p0.a.u.d.i("backgroundAudio", "event onPrev");
                        if (this.f9287b.f9280d != null) {
                            this.f9287b.f9280d.a("onPrev");
                        }
                        return true;
                    case 1010:
                        c.a.p0.a.u.d.i("backgroundAudio", "event onNext");
                        if (this.f9287b.f9280d != null) {
                            this.f9287b.f9280d.a("onNext");
                        }
                        return true;
                    case 1011:
                        c.a.p0.a.u.d.i("backgroundAudio", "event onSeekEnd");
                        if (this.f9287b.f9280d != null) {
                            this.f9287b.f9280d.a("onSeeked");
                        }
                        return true;
                    case 1012:
                        c.a.p0.a.u.d.i("backgroundAudio", "event onSeeking");
                        if (this.f9287b.f9280d != null) {
                            this.f9287b.f9280d.a("onSeeking");
                        }
                        return true;
                    default:
                        return false;
                }
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ C0608c(c cVar, a aVar) {
            this(cVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-118053370, "Lc/a/p0/a/z0/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-118053370, "Lc/a/p0/a/z0/c/c;");
                return;
            }
        }
        f9276i = c.a.p0.a.a.a;
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9279c = new c.a.p0.a.z0.c.a();
        this.f9281e = 0;
        this.f9282f = 0;
        this.f9278b = context;
    }

    public void A() {
        SwanAppAudioClient swanAppAudioClient;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (swanAppAudioClient = this.a) == null) {
            return;
        }
        swanAppAudioClient.u();
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            boolean z = f9276i;
            if (this.f9279c.a()) {
                return;
            }
            K();
            String str = this.f9279c.f9259c;
            e L = e.L();
            if (c.a.p0.a.e2.b.s(str) == PathType.CLOUD) {
                C(str);
            } else {
                D(str, L);
            }
            J("#play");
        }
    }

    public final void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            c.a.p0.a.s0.a.l().b(this.f9278b, str, new b(this));
        }
    }

    public final void D(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, eVar) == null) {
            if (this.f9279c.q && eVar != null) {
                l m = c.a.p0.a.s0.b.m();
                if (this.f9280d.c()) {
                    str = m == null ? null : m.a(str);
                } else {
                    str = c.a.p0.a.e2.b.H(str, eVar);
                }
            }
            v().v(this.f9279c.c(str), str);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.p0.a.u.d.i("backgroundAudio", "release ");
            if (this.a == null || w()) {
                return;
            }
            this.a.w();
            I("#release");
            this.a = null;
            f9277j = null;
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            boolean z = f9276i;
            SwanAppAudioClient swanAppAudioClient = this.a;
            if (swanAppAudioClient != null) {
                swanAppAudioClient.y();
            }
        }
    }

    public void G(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || i2 < 0) {
            return;
        }
        SwanAppAudioClient swanAppAudioClient = this.a;
        if (swanAppAudioClient != null) {
            swanAppAudioClient.z(i2 * 1000);
        }
        c.a.p0.a.u.d.i("backgroundAudio", "seekTo " + i2);
        c.a.p0.a.z0.c.f.a aVar = this.f9280d;
        if (aVar != null) {
            aVar.a("onSeeking");
        }
    }

    public final void H(Message message, int i2, int i3) {
        c.a.p0.a.z0.c.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048583, this, message, i2, i3) == null) && (aVar = this.f9279c) != null && aVar.f9265i) {
            aVar.n = i2;
            aVar.o = i3;
            c.a.p0.a.s0.a.o().x(message, this.f9279c);
        }
    }

    public final void I(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            d.c("SwanAppBGAudioPlayer", "#policyContinueFlag", new Exception(str));
            f.U().c();
        }
    }

    public final void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            d.c("SwanAppBGAudioPlayer", "#setPolicyStopFlag", new Exception(str));
            f.U().p();
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.f9284h != null) {
                c.a.p0.a.s0.a.c().unregisterActivityLifecycleCallbacks(this.f9284h);
            }
            this.f9284h = new a(this);
            c.a.p0.a.s0.a.c().registerActivityLifecycleCallbacks(this.f9284h);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            SwanAppAudioClient swanAppAudioClient = this.a;
            if (swanAppAudioClient != null) {
                swanAppAudioClient.B();
            }
            if (this.f9284h != null) {
                c.a.p0.a.s0.a.c().unregisterActivityLifecycleCallbacks(this.f9284h);
                this.f9284h = null;
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (e.L() != null && e.L().X() != null && f9277j != null) {
                b.a X = e.L().X();
                c.a.p0.a.d2.s.f fVar = new c.a.p0.a.d2.s.f();
                fVar.a = n.n(X.G());
                fVar.f4951f = X.H();
                fVar.f4948c = X.T();
                fVar.a("appid", X.H());
                fVar.a("cuid", c.a.p0.a.s0.a.h0().i(c.a.p0.a.s0.a.c()));
                JSONObject k = n.k(X.W());
                if (k != null) {
                    fVar.a("keyfeed", k.optString("keyfeed"));
                }
                n.i(f9277j, fVar);
            }
            f9277j = null;
        }
    }

    public c.a.p0.a.z0.c.a q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f9279c : (c.a.p0.a.z0.c.a) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f9281e : invokeV.intValue;
    }

    public final int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int u = u();
            if (u <= 0) {
                return 0;
            }
            return (int) ((r() / u) * 100.0f);
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public Object t(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            switch (str.hashCode()) {
                case -2129294769:
                    if (str.equals(FetchLog.START_TIME)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1992012396:
                    if (str.equals("duration")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1522036513:
                    if (str.equals("buffered")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1296614986:
                    if (str.equals("epname")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1094703982:
                    if (str.equals("lrcURL")) {
                        c2 = '\n';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -995321554:
                    if (str.equals("paused")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -902265988:
                    if (str.equals("singer")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -453814973:
                    if (str.equals("coverImgUrl")) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 114148:
                    if (str.equals("src")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 110371416:
                    if (str.equals("title")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 601235430:
                    if (str.equals("currentTime")) {
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
                    return Integer.valueOf(u() / 1000);
                case 1:
                    return Integer.valueOf(this.f9281e);
                case 2:
                    return Boolean.valueOf(x());
                case 3:
                    return this.f9279c.f9259c;
                case 4:
                    return Integer.valueOf(this.f9279c.k);
                case 5:
                    return Integer.valueOf(this.f9282f);
                case 6:
                    return this.f9279c.f9260d;
                case 7:
                    return this.f9279c.f9261e;
                case '\b':
                    return this.f9279c.f9262f;
                case '\t':
                    return this.f9279c.f9263g;
                case '\n':
                    return this.f9279c.f9264h;
                default:
                    return "";
            }
        }
        return invokeL.objValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            SwanAppAudioClient swanAppAudioClient = this.a;
            if (swanAppAudioClient != null) {
                return swanAppAudioClient.r();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void update(c.a.p0.a.z0.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) {
            if (f9276i) {
                String str = "Audio Update : " + aVar;
            }
            this.f9279c = aVar;
            c.a.p0.a.z0.c.f.a aVar2 = this.f9280d;
            if (aVar2 != null) {
                aVar2.d(aVar.p);
            }
            B();
        }
    }

    public final SwanAppAudioClient v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.a == null) {
                this.a = new SwanAppAudioClient(this.f9278b);
                this.a.A(new C0608c(this, null));
            }
            return this.a;
        }
        return (SwanAppAudioClient) invokeV.objValue;
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            SwanAppConfigData P = e.L() != null ? e.L().P() : null;
            return P != null && P.q.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO.mMode);
        }
        return invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            SwanAppAudioClient swanAppAudioClient = this.a;
            if (swanAppAudioClient != null) {
                return !swanAppAudioClient.s();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void y(boolean z) {
        SwanAppAudioClient swanAppAudioClient;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || (swanAppAudioClient = this.a) == null) {
            return;
        }
        swanAppAudioClient.t(z);
        J("#onForegroundChanged foreground=" + z);
    }

    public void z(c.a.p0.a.z0.c.a aVar, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, aVar, callbackHandler) == null) {
            d.b("SwanAppBGAudioPlayer", "#openPlayer params=" + aVar);
            this.f9279c = aVar;
            if (aVar.p != null) {
                try {
                    this.f9280d = new c.a.p0.a.z0.c.f.a(callbackHandler, new JSONObject(this.f9279c.p));
                } catch (JSONException e2) {
                    c.a.p0.a.d2.u.a.b("audio", 2009, "open audio fail", -1, "");
                    c.a.p0.a.u.d.c("backgroundAudio", e2.toString());
                    boolean z = f9276i;
                }
            }
            B();
        }
    }
}
