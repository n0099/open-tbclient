package b.a.p0.a.i1.c;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a2.e;
import b.a.p0.a.e0.d;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.g1.f;
import b.a.p0.a.j2.k;
import b.a.p0.a.p.b.a.l;
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
    public static final boolean f5926i;
    public static b.a.p0.a.j2.a j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SwanAppAudioClient f5927a;

    /* renamed from: b  reason: collision with root package name */
    public Context f5928b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.p0.a.i1.c.a f5929c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.p0.a.i1.c.e.a f5930d;

    /* renamed from: e  reason: collision with root package name */
    public int f5931e;

    /* renamed from: f  reason: collision with root package name */
    public int f5932f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5933g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public b.a.p0.a.g1.a f5934h;

    /* loaded from: classes.dex */
    public class a extends b.a.p0.a.g1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5935e;

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
            this.f5935e = cVar;
        }

        @Override // b.a.p0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
                this.f5935e.f5933g = false;
                if (this.f5935e.x()) {
                    return;
                }
                this.f5935e.p();
            }
        }

        @Override // b.a.p0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                this.f5935e.f5933g = true;
                if (this.f5935e.w()) {
                    if (this.f5935e.x()) {
                        b.a.p0.a.j2.a unused = c.j = null;
                        return;
                    } else if (c.j == null) {
                        b.a.p0.a.j2.a unused2 = c.j = k.c("1044");
                        return;
                    } else {
                        return;
                    }
                }
                super.onActivityStopped(activity);
                this.f5935e.J();
                d.l("SwanAppBGAudioPlayer", "stop player without requiredBackgroundModes");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5936e;

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
            this.f5936e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            this.f5936e.v().u(this.f5936e.f5929c.c(str), str);
        }
    }

    /* renamed from: b.a.p0.a.i1.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0251c implements SwanAppAudioClient.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f5937a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f5938b;

        public C0251c(c cVar) {
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
            this.f5938b = cVar;
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
                this.f5938b.H(message, i4, this.f5938b.u() / 1000);
                switch (i2) {
                    case 1001:
                        d.g("backgroundAudio", "event onCanPlay");
                        if (this.f5938b.f5930d != null) {
                            this.f5938b.f5930d.a("onCanplay");
                        }
                        this.f5937a = true;
                        return true;
                    case 1002:
                        d.g("backgroundAudio", "event onPlay");
                        if (this.f5938b.f5930d != null) {
                            this.f5938b.f5930d.a("onPlay");
                        }
                        if (this.f5938b.f5933g) {
                            b.a.p0.a.j2.a unused = c.j = k.c("1044");
                        }
                        return true;
                    case 1003:
                        d.g("backgroundAudio", "event onPause");
                        if (this.f5938b.f5930d != null) {
                            this.f5938b.f5930d.a(MissionEvent.MESSAGE_PAUSE);
                        }
                        if (this.f5938b.f5933g) {
                            this.f5938b.p();
                        }
                        return true;
                    case 1004:
                        d.g("backgroundAudio", "event onStop");
                        if (this.f5938b.f5930d != null) {
                            this.f5938b.f5930d.a(MissionEvent.MESSAGE_STOP);
                        }
                        this.f5937a = true;
                        if (this.f5938b.f5933g) {
                            this.f5938b.p();
                        }
                        return true;
                    case 1005:
                        d.g("backgroundAudio", "event onEnd");
                        if (this.f5938b.f5930d != null) {
                            this.f5938b.f5930d.a("onEnded");
                        }
                        if (this.f5938b.f5933g) {
                            this.f5938b.p();
                        }
                        return true;
                    case 1006:
                        this.f5938b.f5931e = i4;
                        try {
                            jSONObject.putOpt("currentTime", Integer.valueOf(this.f5938b.r()));
                            jSONObject.putOpt("duration", Integer.valueOf(this.f5938b.u() / 1000));
                        } catch (JSONException e2) {
                            if (c.f5926i) {
                                e2.printStackTrace();
                            }
                        }
                        d.g("backgroundAudio", "event onTimeUpdate " + jSONObject.toString());
                        if (this.f5938b.f5930d != null) {
                            this.f5938b.f5930d.b("onTimeUpdate", jSONObject);
                        }
                        if (this.f5937a) {
                            if (this.f5938b.f5929c.k > 0) {
                                c cVar = this.f5938b;
                                cVar.G(cVar.f5929c.k);
                            }
                            this.f5937a = false;
                        }
                        return true;
                    case 1007:
                        try {
                            jSONObject.putOpt("errCode", Integer.valueOf(i3));
                        } catch (JSONException e3) {
                            if (c.f5926i) {
                                e3.printStackTrace();
                            }
                        }
                        d.g("backgroundAudio", "event onError code:" + i3);
                        if (this.f5938b.f5930d != null) {
                            this.f5938b.f5930d.b("onError", jSONObject);
                        }
                        return true;
                    case 1008:
                        int s = this.f5938b.s();
                        this.f5938b.f5932f = i3;
                        d.g("backgroundAudio", "event onDownloadProgress " + this.f5938b.f5932f);
                        if (this.f5938b.f5930d != null && s >= this.f5938b.f5932f) {
                            this.f5938b.f5930d.a("onWaiting");
                        }
                        return true;
                    case 1009:
                        d.g("backgroundAudio", "event onPrev");
                        if (this.f5938b.f5930d != null) {
                            this.f5938b.f5930d.a("onPrev");
                        }
                        return true;
                    case 1010:
                        d.g("backgroundAudio", "event onNext");
                        if (this.f5938b.f5930d != null) {
                            this.f5938b.f5930d.a("onNext");
                        }
                        return true;
                    case 1011:
                        d.g("backgroundAudio", "event onSeekEnd");
                        if (this.f5938b.f5930d != null) {
                            this.f5938b.f5930d.a("onSeeked");
                        }
                        return true;
                    case 1012:
                        d.g("backgroundAudio", "event onSeeking");
                        if (this.f5938b.f5930d != null) {
                            this.f5938b.f5930d.a("onSeeking");
                        }
                        return true;
                    default:
                        return false;
                }
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ C0251c(c cVar, a aVar) {
            this(cVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1781550731, "Lb/a/p0/a/i1/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1781550731, "Lb/a/p0/a/i1/c/c;");
                return;
            }
        }
        f5926i = b.a.p0.a.k.f6397a;
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
        this.f5929c = new b.a.p0.a.i1.c.a();
        this.f5931e = 0;
        this.f5932f = 0;
        this.f5928b = context;
    }

    public void A() {
        SwanAppAudioClient swanAppAudioClient;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (swanAppAudioClient = this.f5927a) == null) {
            return;
        }
        swanAppAudioClient.t();
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            boolean z = f5926i;
            if (this.f5929c.a()) {
                return;
            }
            I();
            String str = this.f5929c.f5910c;
            e i2 = e.i();
            if (b.a.p0.a.k2.b.s(str) == PathType.CLOUD) {
                C(str);
            } else {
                D(str, i2);
            }
            f.T().o();
        }
    }

    public final void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            b.a.p0.a.c1.a.k().b(this.f5928b, str, new b(this));
        }
    }

    public final void D(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, eVar) == null) {
            if (this.f5929c.q && eVar != null) {
                l m = b.a.p0.a.c1.b.m();
                if (this.f5930d.c()) {
                    str = m == null ? null : m.a(str);
                } else {
                    str = b.a.p0.a.k2.b.H(str, eVar);
                }
            }
            v().u(this.f5929c.c(str), str);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d.g("backgroundAudio", "release ");
            if (this.f5927a == null || w()) {
                return;
            }
            this.f5927a.v();
            f.T().b();
            this.f5927a = null;
            j = null;
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            boolean z = f5926i;
            SwanAppAudioClient swanAppAudioClient = this.f5927a;
            if (swanAppAudioClient != null) {
                swanAppAudioClient.x();
            }
        }
    }

    public void G(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || i2 < 0) {
            return;
        }
        SwanAppAudioClient swanAppAudioClient = this.f5927a;
        if (swanAppAudioClient != null) {
            swanAppAudioClient.y(i2 * 1000);
        }
        d.g("backgroundAudio", "seekTo " + i2);
        b.a.p0.a.i1.c.e.a aVar = this.f5930d;
        if (aVar != null) {
            aVar.a("onSeeking");
        }
    }

    public final void H(Message message, int i2, int i3) {
        b.a.p0.a.i1.c.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048583, this, message, i2, i3) == null) && (aVar = this.f5929c) != null && aVar.f5916i) {
            aVar.n = i2;
            aVar.o = i3;
            b.a.p0.a.c1.a.n().v(message, this.f5929c);
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f5934h != null) {
                b.a.p0.a.c1.a.b().unregisterActivityLifecycleCallbacks(this.f5934h);
            }
            this.f5934h = new a(this);
            b.a.p0.a.c1.a.b().registerActivityLifecycleCallbacks(this.f5934h);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SwanAppAudioClient swanAppAudioClient = this.f5927a;
            if (swanAppAudioClient != null) {
                swanAppAudioClient.A();
            }
            if (this.f5934h != null) {
                b.a.p0.a.c1.a.b().unregisterActivityLifecycleCallbacks(this.f5934h);
                this.f5934h = null;
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (e.i() != null && e.i().M() != null && j != null) {
                b.a M = e.i().M();
                b.a.p0.a.j2.p.f fVar = new b.a.p0.a.j2.p.f();
                fVar.f6383a = k.m(M.F());
                fVar.f6388f = M.G();
                fVar.f6385c = M.S();
                fVar.a("appid", M.G());
                fVar.a("cuid", b.a.p0.a.c1.a.a0().i(b.a.p0.a.c1.a.b()));
                JSONObject k = k.k(M.V());
                if (k != null) {
                    fVar.a("keyfeed", k.optString("keyfeed"));
                }
                k.i(j, fVar);
            }
            j = null;
        }
    }

    public b.a.p0.a.i1.c.a q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f5929c : (b.a.p0.a.i1.c.a) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f5931e : invokeV.intValue;
    }

    public final int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
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
                    return Integer.valueOf(this.f5931e);
                case 2:
                    return Boolean.valueOf(x());
                case 3:
                    return this.f5929c.f5910c;
                case 4:
                    return Integer.valueOf(this.f5929c.k);
                case 5:
                    return Integer.valueOf(this.f5932f);
                case 6:
                    return this.f5929c.f5911d;
                case 7:
                    return this.f5929c.f5912e;
                case '\b':
                    return this.f5929c.f5913f;
                case '\t':
                    return this.f5929c.f5914g;
                case '\n':
                    return this.f5929c.f5915h;
                default:
                    return "";
            }
        }
        return invokeL.objValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            SwanAppAudioClient swanAppAudioClient = this.f5927a;
            if (swanAppAudioClient != null) {
                return swanAppAudioClient.q();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void update(b.a.p0.a.i1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            if (f5926i) {
                String str = "Audio Update : " + aVar;
            }
            this.f5929c = aVar;
            b.a.p0.a.i1.c.e.a aVar2 = this.f5930d;
            if (aVar2 != null) {
                aVar2.d(aVar.p);
            }
            B();
        }
    }

    public final SwanAppAudioClient v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.f5927a == null) {
                this.f5927a = new SwanAppAudioClient(this.f5928b);
                this.f5927a.z(new C0251c(this, null));
            }
            return this.f5927a;
        }
        return (SwanAppAudioClient) invokeV.objValue;
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            SwanAppConfigData E = e.i() != null ? e.i().E() : null;
            return E != null && E.p.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO.mMode);
        }
        return invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            SwanAppAudioClient swanAppAudioClient = this.f5927a;
            if (swanAppAudioClient != null) {
                return !swanAppAudioClient.r();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void y(boolean z) {
        SwanAppAudioClient swanAppAudioClient;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (swanAppAudioClient = this.f5927a) == null) {
            return;
        }
        swanAppAudioClient.s(z);
        f.T().o();
    }

    public void z(b.a.p0.a.i1.c.a aVar, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, aVar, callbackHandler) == null) {
            boolean z = f5926i;
            this.f5929c = aVar;
            if (aVar.p != null) {
                try {
                    this.f5930d = new b.a.p0.a.i1.c.e.a(callbackHandler, new JSONObject(this.f5929c.p));
                } catch (JSONException e2) {
                    d.b("backgroundAudio", e2.toString());
                    boolean z2 = f5926i;
                }
            }
            B();
        }
    }
}
