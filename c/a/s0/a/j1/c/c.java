package c.a.s0.a.j1.c;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.d2.e;
import c.a.s0.a.f1.e.b;
import c.a.s0.a.g1.f;
import c.a.s0.a.k;
import c.a.s0.a.n2.n;
import c.a.s0.a.p.b.a.l;
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
import org.webrtc.MediaStreamTrack;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f7543i;

    /* renamed from: j  reason: collision with root package name */
    public static c.a.s0.a.n2.a f7544j;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppAudioClient a;

    /* renamed from: b  reason: collision with root package name */
    public Context f7545b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.s0.a.j1.c.a f7546c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.s0.a.j1.c.f.a f7547d;

    /* renamed from: e  reason: collision with root package name */
    public int f7548e;

    /* renamed from: f  reason: collision with root package name */
    public int f7549f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7550g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public c.a.s0.a.g1.a f7551h;

    /* loaded from: classes.dex */
    public class a extends c.a.s0.a.g1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f7552e;

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
            this.f7552e = cVar;
        }

        @Override // c.a.s0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
                this.f7552e.f7550g = false;
                if (this.f7552e.x()) {
                    return;
                }
                this.f7552e.p();
            }
        }

        @Override // c.a.s0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                this.f7552e.f7550g = true;
                if (this.f7552e.w()) {
                    if (this.f7552e.x()) {
                        c.a.s0.a.n2.a unused = c.f7544j = null;
                        return;
                    } else if (c.f7544j == null) {
                        c.a.s0.a.n2.a unused2 = c.f7544j = n.c("1044");
                        return;
                    } else {
                        return;
                    }
                }
                super.onActivityStopped(activity);
                this.f7552e.L();
                c.a.s0.a.e0.d.o("SwanAppBGAudioPlayer", "stop player without requiredBackgroundModes");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.s0.a.z2.g1.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f7553e;

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
            this.f7553e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    this.f7553e.v().v(this.f7553e.f7546c.c(str), str);
                } else if (TextUtils.isEmpty(str)) {
                    c.a.s0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 3001, "cloud url is null", -1, "");
                }
            }
        }
    }

    /* renamed from: c.a.s0.a.j1.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0454c implements SwanAppAudioClient.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f7554b;

        public C0454c(c cVar) {
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
            this.f7554b = cVar;
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
                this.f7554b.H(message, i4, this.f7554b.u() / 1000);
                switch (i2) {
                    case 1001:
                        d.b("SwanAppBGAudioPlayer", "#onHandleMessage [onCanPlay]");
                        c.a.s0.a.e0.d.i("backgroundAudio", "event onCanPlay");
                        if (this.f7554b.f7547d != null) {
                            this.f7554b.f7547d.a("onCanplay");
                        }
                        this.a = true;
                        return true;
                    case 1002:
                        d.b("SwanAppBGAudioPlayer", "#onHandleMessage [onPlay]");
                        c.a.s0.a.e0.d.i("backgroundAudio", "event onPlay");
                        if (this.f7554b.f7547d != null) {
                            this.f7554b.f7547d.a("onPlay");
                        }
                        if (this.f7554b.f7550g) {
                            c.a.s0.a.n2.a unused = c.f7544j = n.c("1044");
                        }
                        return true;
                    case 1003:
                        d.b("SwanAppBGAudioPlayer", "#onHandleMessage [onPause]");
                        c.a.s0.a.e0.d.i("backgroundAudio", "event onPause");
                        if (this.f7554b.f7547d != null) {
                            this.f7554b.f7547d.a(MissionEvent.MESSAGE_PAUSE);
                        }
                        if (this.f7554b.f7550g) {
                            this.f7554b.p();
                        }
                        return true;
                    case 1004:
                        d.b("SwanAppBGAudioPlayer", "#onHandleMessage [onStop]");
                        c.a.s0.a.e0.d.i("backgroundAudio", "event onStop");
                        if (this.f7554b.f7547d != null) {
                            this.f7554b.f7547d.a(MissionEvent.MESSAGE_STOP);
                        }
                        this.a = true;
                        if (this.f7554b.f7550g) {
                            this.f7554b.p();
                        }
                        return true;
                    case 1005:
                        c.a.s0.a.e0.d.i("backgroundAudio", "event onEnd");
                        if (this.f7554b.f7547d != null) {
                            this.f7554b.f7547d.a("onEnded");
                        }
                        if (this.f7554b.f7550g) {
                            this.f7554b.p();
                        }
                        return true;
                    case 1006:
                        this.f7554b.f7548e = i4;
                        try {
                            jSONObject.putOpt("currentTime", Integer.valueOf(this.f7554b.r()));
                            jSONObject.putOpt("duration", Integer.valueOf(this.f7554b.u() / 1000));
                        } catch (JSONException e2) {
                            if (c.f7543i) {
                                e2.printStackTrace();
                            }
                        }
                        c.a.s0.a.e0.d.i("backgroundAudio", "event onTimeUpdate " + jSONObject.toString());
                        if (this.f7554b.f7547d != null) {
                            this.f7554b.f7547d.b("onTimeUpdate", jSONObject);
                        }
                        if (this.a) {
                            if (this.f7554b.f7546c.k > 0) {
                                c cVar = this.f7554b;
                                cVar.G(cVar.f7546c.k);
                            }
                            this.a = false;
                        }
                        return true;
                    case 1007:
                        try {
                            c.a.s0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 4000, "audio fail, src: " + this.f7554b.v().q(), i3, "");
                            jSONObject.putOpt("errCode", Integer.valueOf(i3));
                        } catch (JSONException e3) {
                            if (c.f7543i) {
                                e3.printStackTrace();
                            }
                        }
                        c.a.s0.a.e0.d.i("backgroundAudio", "event onError code:" + i3);
                        if (this.f7554b.f7547d != null) {
                            this.f7554b.f7547d.b("onError", jSONObject);
                        }
                        return true;
                    case 1008:
                        int s = this.f7554b.s();
                        this.f7554b.f7549f = i3;
                        c.a.s0.a.e0.d.i("backgroundAudio", "event onDownloadProgress " + this.f7554b.f7549f);
                        if (this.f7554b.f7547d != null && s >= this.f7554b.f7549f) {
                            this.f7554b.f7547d.a("onWaiting");
                        }
                        return true;
                    case 1009:
                        c.a.s0.a.e0.d.i("backgroundAudio", "event onPrev");
                        if (this.f7554b.f7547d != null) {
                            this.f7554b.f7547d.a("onPrev");
                        }
                        return true;
                    case 1010:
                        c.a.s0.a.e0.d.i("backgroundAudio", "event onNext");
                        if (this.f7554b.f7547d != null) {
                            this.f7554b.f7547d.a("onNext");
                        }
                        return true;
                    case 1011:
                        c.a.s0.a.e0.d.i("backgroundAudio", "event onSeekEnd");
                        if (this.f7554b.f7547d != null) {
                            this.f7554b.f7547d.a("onSeeked");
                        }
                        return true;
                    case 1012:
                        c.a.s0.a.e0.d.i("backgroundAudio", "event onSeeking");
                        if (this.f7554b.f7547d != null) {
                            this.f7554b.f7547d.a("onSeeking");
                        }
                        return true;
                    default:
                        return false;
                }
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ C0454c(c cVar, a aVar) {
            this(cVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1017333070, "Lc/a/s0/a/j1/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1017333070, "Lc/a/s0/a/j1/c/c;");
                return;
            }
        }
        f7543i = k.a;
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
        this.f7546c = new c.a.s0.a.j1.c.a();
        this.f7548e = 0;
        this.f7549f = 0;
        this.f7545b = context;
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
            boolean z = f7543i;
            if (this.f7546c.a()) {
                return;
            }
            K();
            String str = this.f7546c.f7526c;
            e L = e.L();
            if (c.a.s0.a.o2.b.s(str) == PathType.CLOUD) {
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
            c.a.s0.a.c1.a.l().b(this.f7545b, str, new b(this));
        }
    }

    public final void D(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, eVar) == null) {
            if (this.f7546c.q && eVar != null) {
                l m = c.a.s0.a.c1.b.m();
                if (this.f7547d.c()) {
                    str = m == null ? null : m.a(str);
                } else {
                    str = c.a.s0.a.o2.b.H(str, eVar);
                }
            }
            v().v(this.f7546c.c(str), str);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.s0.a.e0.d.i("backgroundAudio", "release ");
            if (this.a == null || w()) {
                return;
            }
            this.a.w();
            I("#release");
            this.a = null;
            f7544j = null;
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            boolean z = f7543i;
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
        c.a.s0.a.e0.d.i("backgroundAudio", "seekTo " + i2);
        c.a.s0.a.j1.c.f.a aVar = this.f7547d;
        if (aVar != null) {
            aVar.a("onSeeking");
        }
    }

    public final void H(Message message, int i2, int i3) {
        c.a.s0.a.j1.c.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048583, this, message, i2, i3) == null) && (aVar = this.f7546c) != null && aVar.f7532i) {
            aVar.n = i2;
            aVar.o = i3;
            c.a.s0.a.c1.a.o().x(message, this.f7546c);
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
            if (this.f7551h != null) {
                c.a.s0.a.c1.a.c().unregisterActivityLifecycleCallbacks(this.f7551h);
            }
            this.f7551h = new a(this);
            c.a.s0.a.c1.a.c().registerActivityLifecycleCallbacks(this.f7551h);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            SwanAppAudioClient swanAppAudioClient = this.a;
            if (swanAppAudioClient != null) {
                swanAppAudioClient.B();
            }
            if (this.f7551h != null) {
                c.a.s0.a.c1.a.c().unregisterActivityLifecycleCallbacks(this.f7551h);
                this.f7551h = null;
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (e.L() != null && e.L().X() != null && f7544j != null) {
                b.a X = e.L().X();
                c.a.s0.a.n2.s.f fVar = new c.a.s0.a.n2.s.f();
                fVar.a = n.n(X.G());
                fVar.f8223f = X.H();
                fVar.f8220c = X.T();
                fVar.a("appid", X.H());
                fVar.a("cuid", c.a.s0.a.c1.a.h0().i(c.a.s0.a.c1.a.c()));
                JSONObject k = n.k(X.W());
                if (k != null) {
                    fVar.a("keyfeed", k.optString("keyfeed"));
                }
                n.i(f7544j, fVar);
            }
            f7544j = null;
        }
    }

    public c.a.s0.a.j1.c.a q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f7546c : (c.a.s0.a.j1.c.a) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f7548e : invokeV.intValue;
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
                    return Integer.valueOf(this.f7548e);
                case 2:
                    return Boolean.valueOf(x());
                case 3:
                    return this.f7546c.f7526c;
                case 4:
                    return Integer.valueOf(this.f7546c.k);
                case 5:
                    return Integer.valueOf(this.f7549f);
                case 6:
                    return this.f7546c.f7527d;
                case 7:
                    return this.f7546c.f7528e;
                case '\b':
                    return this.f7546c.f7529f;
                case '\t':
                    return this.f7546c.f7530g;
                case '\n':
                    return this.f7546c.f7531h;
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

    public void update(c.a.s0.a.j1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) {
            if (f7543i) {
                String str = "Audio Update : " + aVar;
            }
            this.f7546c = aVar;
            c.a.s0.a.j1.c.f.a aVar2 = this.f7547d;
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
                this.a = new SwanAppAudioClient(this.f7545b);
                this.a.A(new C0454c(this, null));
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

    public void z(c.a.s0.a.j1.c.a aVar, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, aVar, callbackHandler) == null) {
            d.b("SwanAppBGAudioPlayer", "#openPlayer params=" + aVar);
            this.f7546c = aVar;
            if (aVar.p != null) {
                try {
                    this.f7547d = new c.a.s0.a.j1.c.f.a(callbackHandler, new JSONObject(this.f7546c.p));
                } catch (JSONException e2) {
                    c.a.s0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 2009, "open audio fail", -1, "");
                    c.a.s0.a.e0.d.c("backgroundAudio", e2.toString());
                    boolean z = f7543i;
                }
            }
            B();
        }
    }
}
