package c.a.p0.a.i1.c;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.a2.e;
import c.a.p0.a.e0.d;
import c.a.p0.a.f1.e.b;
import c.a.p0.a.g1.f;
import c.a.p0.a.j2.k;
import c.a.p0.a.p.b.a.l;
import com.baidu.android.imsdk.internal.Constants;
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
    public static final boolean f6593i;

    /* renamed from: j  reason: collision with root package name */
    public static c.a.p0.a.j2.a f6594j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SwanAppAudioClient f6595a;

    /* renamed from: b  reason: collision with root package name */
    public Context f6596b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.a.i1.c.a f6597c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.a.i1.c.e.a f6598d;

    /* renamed from: e  reason: collision with root package name */
    public int f6599e;

    /* renamed from: f  reason: collision with root package name */
    public int f6600f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6601g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.a.g1.a f6602h;

    /* loaded from: classes.dex */
    public class a extends c.a.p0.a.g1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f6603e;

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
            this.f6603e = cVar;
        }

        @Override // c.a.p0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
                this.f6603e.f6601g = false;
                if (this.f6603e.x()) {
                    return;
                }
                this.f6603e.p();
            }
        }

        @Override // c.a.p0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                this.f6603e.f6601g = true;
                if (this.f6603e.w()) {
                    if (this.f6603e.x()) {
                        c.a.p0.a.j2.a unused = c.f6594j = null;
                        return;
                    } else if (c.f6594j == null) {
                        c.a.p0.a.j2.a unused2 = c.f6594j = k.c("1044");
                        return;
                    } else {
                        return;
                    }
                }
                super.onActivityStopped(activity);
                this.f6603e.J();
                d.l("SwanAppBGAudioPlayer", "stop player without requiredBackgroundModes");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f6604e;

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
            this.f6604e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            this.f6604e.v().v(this.f6604e.f6597c.c(str), str);
        }
    }

    /* renamed from: c.a.p0.a.i1.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0256c implements SwanAppAudioClient.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f6605a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f6606b;

        public C0256c(c cVar) {
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
            this.f6606b = cVar;
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
                this.f6606b.H(message, i4, this.f6606b.u() / 1000);
                switch (i2) {
                    case 1001:
                        d.g("backgroundAudio", "event onCanPlay");
                        if (this.f6606b.f6598d != null) {
                            this.f6606b.f6598d.a("onCanplay");
                        }
                        this.f6605a = true;
                        return true;
                    case 1002:
                        d.g("backgroundAudio", "event onPlay");
                        if (this.f6606b.f6598d != null) {
                            this.f6606b.f6598d.a("onPlay");
                        }
                        if (this.f6606b.f6601g) {
                            c.a.p0.a.j2.a unused = c.f6594j = k.c("1044");
                        }
                        return true;
                    case 1003:
                        d.g("backgroundAudio", "event onPause");
                        if (this.f6606b.f6598d != null) {
                            this.f6606b.f6598d.a(MissionEvent.MESSAGE_PAUSE);
                        }
                        if (this.f6606b.f6601g) {
                            this.f6606b.p();
                        }
                        return true;
                    case 1004:
                        d.g("backgroundAudio", "event onStop");
                        if (this.f6606b.f6598d != null) {
                            this.f6606b.f6598d.a(MissionEvent.MESSAGE_STOP);
                        }
                        this.f6605a = true;
                        if (this.f6606b.f6601g) {
                            this.f6606b.p();
                        }
                        return true;
                    case 1005:
                        d.g("backgroundAudio", "event onEnd");
                        if (this.f6606b.f6598d != null) {
                            this.f6606b.f6598d.a("onEnded");
                        }
                        if (this.f6606b.f6601g) {
                            this.f6606b.p();
                        }
                        return true;
                    case 1006:
                        this.f6606b.f6599e = i4;
                        try {
                            jSONObject.putOpt("currentTime", Integer.valueOf(this.f6606b.r()));
                            jSONObject.putOpt("duration", Integer.valueOf(this.f6606b.u() / 1000));
                        } catch (JSONException e2) {
                            if (c.f6593i) {
                                e2.printStackTrace();
                            }
                        }
                        d.g("backgroundAudio", "event onTimeUpdate " + jSONObject.toString());
                        if (this.f6606b.f6598d != null) {
                            this.f6606b.f6598d.b("onTimeUpdate", jSONObject);
                        }
                        if (this.f6605a) {
                            if (this.f6606b.f6597c.k > 0) {
                                c cVar = this.f6606b;
                                cVar.G(cVar.f6597c.k);
                            }
                            this.f6605a = false;
                        }
                        return true;
                    case 1007:
                        try {
                            jSONObject.putOpt("errCode", Integer.valueOf(i3));
                        } catch (JSONException e3) {
                            if (c.f6593i) {
                                e3.printStackTrace();
                            }
                        }
                        d.g("backgroundAudio", "event onError code:" + i3);
                        if (this.f6606b.f6598d != null) {
                            this.f6606b.f6598d.b("onError", jSONObject);
                        }
                        return true;
                    case 1008:
                        int s = this.f6606b.s();
                        this.f6606b.f6600f = i3;
                        d.g("backgroundAudio", "event onDownloadProgress " + this.f6606b.f6600f);
                        if (this.f6606b.f6598d != null && s >= this.f6606b.f6600f) {
                            this.f6606b.f6598d.a("onWaiting");
                        }
                        return true;
                    case 1009:
                        d.g("backgroundAudio", "event onPrev");
                        if (this.f6606b.f6598d != null) {
                            this.f6606b.f6598d.a("onPrev");
                        }
                        return true;
                    case 1010:
                        d.g("backgroundAudio", "event onNext");
                        if (this.f6606b.f6598d != null) {
                            this.f6606b.f6598d.a("onNext");
                        }
                        return true;
                    case 1011:
                        d.g("backgroundAudio", "event onSeekEnd");
                        if (this.f6606b.f6598d != null) {
                            this.f6606b.f6598d.a("onSeeked");
                        }
                        return true;
                    case 1012:
                        d.g("backgroundAudio", "event onSeeking");
                        if (this.f6606b.f6598d != null) {
                            this.f6606b.f6598d.a("onSeeking");
                        }
                        return true;
                    default:
                        return false;
                }
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ C0256c(c cVar, a aVar) {
            this(cVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2002882388, "Lc/a/p0/a/i1/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2002882388, "Lc/a/p0/a/i1/c/c;");
                return;
            }
        }
        f6593i = c.a.p0.a.k.f7077a;
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
        this.f6597c = new c.a.p0.a.i1.c.a();
        this.f6599e = 0;
        this.f6600f = 0;
        this.f6596b = context;
    }

    public void A() {
        SwanAppAudioClient swanAppAudioClient;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (swanAppAudioClient = this.f6595a) == null) {
            return;
        }
        swanAppAudioClient.u();
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            boolean z = f6593i;
            if (this.f6597c.a()) {
                return;
            }
            I();
            String str = this.f6597c.f6575c;
            e i2 = e.i();
            if (c.a.p0.a.k2.b.s(str) == PathType.CLOUD) {
                C(str);
            } else {
                D(str, i2);
            }
            f.V().p();
        }
    }

    public final void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            c.a.p0.a.c1.a.k().b(this.f6596b, str, new b(this));
        }
    }

    public final void D(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, eVar) == null) {
            if (this.f6597c.q && eVar != null) {
                l m = c.a.p0.a.c1.b.m();
                if (this.f6598d.c()) {
                    str = m == null ? null : m.a(str);
                } else {
                    str = c.a.p0.a.k2.b.H(str, eVar);
                }
            }
            v().v(this.f6597c.c(str), str);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d.g("backgroundAudio", "release ");
            if (this.f6595a == null || w()) {
                return;
            }
            this.f6595a.w();
            f.V().b();
            this.f6595a = null;
            f6594j = null;
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            boolean z = f6593i;
            SwanAppAudioClient swanAppAudioClient = this.f6595a;
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
        SwanAppAudioClient swanAppAudioClient = this.f6595a;
        if (swanAppAudioClient != null) {
            swanAppAudioClient.z(i2 * 1000);
        }
        d.g("backgroundAudio", "seekTo " + i2);
        c.a.p0.a.i1.c.e.a aVar = this.f6598d;
        if (aVar != null) {
            aVar.a("onSeeking");
        }
    }

    public final void H(Message message, int i2, int i3) {
        c.a.p0.a.i1.c.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048583, this, message, i2, i3) == null) && (aVar = this.f6597c) != null && aVar.f6581i) {
            aVar.n = i2;
            aVar.o = i3;
            c.a.p0.a.c1.a.n().v(message, this.f6597c);
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f6602h != null) {
                c.a.p0.a.c1.a.b().unregisterActivityLifecycleCallbacks(this.f6602h);
            }
            this.f6602h = new a(this);
            c.a.p0.a.c1.a.b().registerActivityLifecycleCallbacks(this.f6602h);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SwanAppAudioClient swanAppAudioClient = this.f6595a;
            if (swanAppAudioClient != null) {
                swanAppAudioClient.C();
            }
            if (this.f6602h != null) {
                c.a.p0.a.c1.a.b().unregisterActivityLifecycleCallbacks(this.f6602h);
                this.f6602h = null;
            }
        }
    }

    public void K(c.a.p0.a.i1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            if (f6593i) {
                String str = "Audio Update : " + aVar;
            }
            this.f6597c = aVar;
            c.a.p0.a.i1.c.e.a aVar2 = this.f6598d;
            if (aVar2 != null) {
                aVar2.d(aVar.p);
            }
            B();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (e.i() != null && e.i().N() != null && f6594j != null) {
                b.a N = e.i().N();
                c.a.p0.a.j2.p.f fVar = new c.a.p0.a.j2.p.f();
                fVar.f7063a = k.m(N.G());
                fVar.f7068f = N.H();
                fVar.f7065c = N.T();
                fVar.a("appid", N.H());
                fVar.a("cuid", c.a.p0.a.c1.a.a0().i(c.a.p0.a.c1.a.b()));
                JSONObject k = k.k(N.W());
                if (k != null) {
                    fVar.a("keyfeed", k.optString("keyfeed"));
                }
                k.i(f6594j, fVar);
            }
            f6594j = null;
        }
    }

    public c.a.p0.a.i1.c.a q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f6597c : (c.a.p0.a.i1.c.a) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f6599e : invokeV.intValue;
    }

    public final int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            switch (str.hashCode()) {
                case -2129294769:
                    if (str.equals("startTime")) {
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
                    return Integer.valueOf(this.f6599e);
                case 2:
                    return Boolean.valueOf(x());
                case 3:
                    return this.f6597c.f6575c;
                case 4:
                    return Integer.valueOf(this.f6597c.k);
                case 5:
                    return Integer.valueOf(this.f6600f);
                case 6:
                    return this.f6597c.f6576d;
                case 7:
                    return this.f6597c.f6577e;
                case '\b':
                    return this.f6597c.f6578f;
                case '\t':
                    return this.f6597c.f6579g;
                case '\n':
                    return this.f6597c.f6580h;
                default:
                    return "";
            }
        }
        return invokeL.objValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            SwanAppAudioClient swanAppAudioClient = this.f6595a;
            if (swanAppAudioClient != null) {
                return swanAppAudioClient.r();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final SwanAppAudioClient v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.f6595a == null) {
                this.f6595a = new SwanAppAudioClient(this.f6596b);
                this.f6595a.A(new C0256c(this, null));
            }
            return this.f6595a;
        }
        return (SwanAppAudioClient) invokeV.objValue;
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            SwanAppConfigData F = e.i() != null ? e.i().F() : null;
            return F != null && F.p.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO.mMode);
        }
        return invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            SwanAppAudioClient swanAppAudioClient = this.f6595a;
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
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (swanAppAudioClient = this.f6595a) == null) {
            return;
        }
        swanAppAudioClient.t(z);
        f.V().p();
    }

    public void z(c.a.p0.a.i1.c.a aVar, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, aVar, callbackHandler) == null) {
            boolean z = f6593i;
            this.f6597c = aVar;
            if (aVar.p != null) {
                try {
                    this.f6598d = new c.a.p0.a.i1.c.e.a(callbackHandler, new JSONObject(this.f6597c.p));
                } catch (JSONException e2) {
                    d.b("backgroundAudio", e2.toString());
                    boolean z2 = f6593i;
                }
            }
            B();
        }
    }
}
