package c.a.q0.a.j1.c;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.d2.e;
import c.a.q0.a.f1.e.b;
import c.a.q0.a.g1.f;
import c.a.q0.a.k;
import c.a.q0.a.n2.n;
import c.a.q0.a.p.b.a.l;
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
import org.webrtc.MediaStreamTrack;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f6731i;

    /* renamed from: j  reason: collision with root package name */
    public static c.a.q0.a.n2.a f6732j;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppAudioClient a;

    /* renamed from: b  reason: collision with root package name */
    public Context f6733b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.a.j1.c.a f6734c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.a.j1.c.f.a f6735d;

    /* renamed from: e  reason: collision with root package name */
    public int f6736e;

    /* renamed from: f  reason: collision with root package name */
    public int f6737f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6738g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.a.g1.a f6739h;

    /* loaded from: classes.dex */
    public class a extends c.a.q0.a.g1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f6740e;

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
            this.f6740e = cVar;
        }

        @Override // c.a.q0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
                this.f6740e.f6738g = false;
                if (this.f6740e.x()) {
                    return;
                }
                this.f6740e.p();
            }
        }

        @Override // c.a.q0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                this.f6740e.f6738g = true;
                if (this.f6740e.w()) {
                    if (this.f6740e.x()) {
                        c.a.q0.a.n2.a unused = c.f6732j = null;
                        return;
                    } else if (c.f6732j == null) {
                        c.a.q0.a.n2.a unused2 = c.f6732j = n.c("1044");
                        return;
                    } else {
                        return;
                    }
                }
                super.onActivityStopped(activity);
                this.f6740e.L();
                c.a.q0.a.e0.d.o("SwanAppBGAudioPlayer", "stop player without requiredBackgroundModes");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.q0.a.z2.g1.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f6741e;

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
            this.f6741e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    this.f6741e.v().v(this.f6741e.f6734c.c(str), str);
                } else if (TextUtils.isEmpty(str)) {
                    c.a.q0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 3001, "cloud url is null", -1, "");
                }
            }
        }
    }

    /* renamed from: c.a.q0.a.j1.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0375c implements SwanAppAudioClient.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f6742b;

        public C0375c(c cVar) {
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
            this.f6742b = cVar;
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
                this.f6742b.H(message, i4, this.f6742b.u() / 1000);
                switch (i2) {
                    case 1001:
                        d.b("SwanAppBGAudioPlayer", "#onHandleMessage [onCanPlay]");
                        c.a.q0.a.e0.d.i("backgroundAudio", "event onCanPlay");
                        if (this.f6742b.f6735d != null) {
                            this.f6742b.f6735d.a("onCanplay");
                        }
                        this.a = true;
                        return true;
                    case 1002:
                        d.b("SwanAppBGAudioPlayer", "#onHandleMessage [onPlay]");
                        c.a.q0.a.e0.d.i("backgroundAudio", "event onPlay");
                        if (this.f6742b.f6735d != null) {
                            this.f6742b.f6735d.a("onPlay");
                        }
                        if (this.f6742b.f6738g) {
                            c.a.q0.a.n2.a unused = c.f6732j = n.c("1044");
                        }
                        return true;
                    case 1003:
                        d.b("SwanAppBGAudioPlayer", "#onHandleMessage [onPause]");
                        c.a.q0.a.e0.d.i("backgroundAudio", "event onPause");
                        if (this.f6742b.f6735d != null) {
                            this.f6742b.f6735d.a(MissionEvent.MESSAGE_PAUSE);
                        }
                        if (this.f6742b.f6738g) {
                            this.f6742b.p();
                        }
                        return true;
                    case 1004:
                        d.b("SwanAppBGAudioPlayer", "#onHandleMessage [onStop]");
                        c.a.q0.a.e0.d.i("backgroundAudio", "event onStop");
                        if (this.f6742b.f6735d != null) {
                            this.f6742b.f6735d.a(MissionEvent.MESSAGE_STOP);
                        }
                        this.a = true;
                        if (this.f6742b.f6738g) {
                            this.f6742b.p();
                        }
                        return true;
                    case 1005:
                        c.a.q0.a.e0.d.i("backgroundAudio", "event onEnd");
                        if (this.f6742b.f6735d != null) {
                            this.f6742b.f6735d.a("onEnded");
                        }
                        if (this.f6742b.f6738g) {
                            this.f6742b.p();
                        }
                        return true;
                    case 1006:
                        this.f6742b.f6736e = i4;
                        try {
                            jSONObject.putOpt("currentTime", Integer.valueOf(this.f6742b.r()));
                            jSONObject.putOpt("duration", Integer.valueOf(this.f6742b.u() / 1000));
                        } catch (JSONException e2) {
                            if (c.f6731i) {
                                e2.printStackTrace();
                            }
                        }
                        c.a.q0.a.e0.d.i("backgroundAudio", "event onTimeUpdate " + jSONObject.toString());
                        if (this.f6742b.f6735d != null) {
                            this.f6742b.f6735d.b("onTimeUpdate", jSONObject);
                        }
                        if (this.a) {
                            if (this.f6742b.f6734c.f6721k > 0) {
                                c cVar = this.f6742b;
                                cVar.G(cVar.f6734c.f6721k);
                            }
                            this.a = false;
                        }
                        return true;
                    case 1007:
                        try {
                            c.a.q0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 4000, "audio fail, src: " + this.f6742b.v().q(), i3, "");
                            jSONObject.putOpt("errCode", Integer.valueOf(i3));
                        } catch (JSONException e3) {
                            if (c.f6731i) {
                                e3.printStackTrace();
                            }
                        }
                        c.a.q0.a.e0.d.i("backgroundAudio", "event onError code:" + i3);
                        if (this.f6742b.f6735d != null) {
                            this.f6742b.f6735d.b("onError", jSONObject);
                        }
                        return true;
                    case 1008:
                        int s = this.f6742b.s();
                        this.f6742b.f6737f = i3;
                        c.a.q0.a.e0.d.i("backgroundAudio", "event onDownloadProgress " + this.f6742b.f6737f);
                        if (this.f6742b.f6735d != null && s >= this.f6742b.f6737f) {
                            this.f6742b.f6735d.a("onWaiting");
                        }
                        return true;
                    case 1009:
                        c.a.q0.a.e0.d.i("backgroundAudio", "event onPrev");
                        if (this.f6742b.f6735d != null) {
                            this.f6742b.f6735d.a("onPrev");
                        }
                        return true;
                    case 1010:
                        c.a.q0.a.e0.d.i("backgroundAudio", "event onNext");
                        if (this.f6742b.f6735d != null) {
                            this.f6742b.f6735d.a("onNext");
                        }
                        return true;
                    case 1011:
                        c.a.q0.a.e0.d.i("backgroundAudio", "event onSeekEnd");
                        if (this.f6742b.f6735d != null) {
                            this.f6742b.f6735d.a("onSeeked");
                        }
                        return true;
                    case 1012:
                        c.a.q0.a.e0.d.i("backgroundAudio", "event onSeeking");
                        if (this.f6742b.f6735d != null) {
                            this.f6742b.f6735d.a("onSeeking");
                        }
                        return true;
                    default:
                        return false;
                }
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ C0375c(c cVar, a aVar) {
            this(cVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1275498508, "Lc/a/q0/a/j1/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1275498508, "Lc/a/q0/a/j1/c/c;");
                return;
            }
        }
        f6731i = k.a;
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
        this.f6734c = new c.a.q0.a.j1.c.a();
        this.f6736e = 0;
        this.f6737f = 0;
        this.f6733b = context;
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
            boolean z = f6731i;
            if (this.f6734c.a()) {
                return;
            }
            K();
            String str = this.f6734c.f6713c;
            e L = e.L();
            if (c.a.q0.a.o2.b.s(str) == PathType.CLOUD) {
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
            c.a.q0.a.c1.a.l().b(this.f6733b, str, new b(this));
        }
    }

    public final void D(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, eVar) == null) {
            if (this.f6734c.q && eVar != null) {
                l m = c.a.q0.a.c1.b.m();
                if (this.f6735d.c()) {
                    str = m == null ? null : m.a(str);
                } else {
                    str = c.a.q0.a.o2.b.H(str, eVar);
                }
            }
            v().v(this.f6734c.c(str), str);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.q0.a.e0.d.i("backgroundAudio", "release ");
            if (this.a == null || w()) {
                return;
            }
            this.a.w();
            I("#release");
            this.a = null;
            f6732j = null;
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            boolean z = f6731i;
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
        c.a.q0.a.e0.d.i("backgroundAudio", "seekTo " + i2);
        c.a.q0.a.j1.c.f.a aVar = this.f6735d;
        if (aVar != null) {
            aVar.a("onSeeking");
        }
    }

    public final void H(Message message, int i2, int i3) {
        c.a.q0.a.j1.c.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048583, this, message, i2, i3) == null) && (aVar = this.f6734c) != null && aVar.f6719i) {
            aVar.n = i2;
            aVar.o = i3;
            c.a.q0.a.c1.a.o().x(message, this.f6734c);
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
            if (this.f6739h != null) {
                c.a.q0.a.c1.a.c().unregisterActivityLifecycleCallbacks(this.f6739h);
            }
            this.f6739h = new a(this);
            c.a.q0.a.c1.a.c().registerActivityLifecycleCallbacks(this.f6739h);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            SwanAppAudioClient swanAppAudioClient = this.a;
            if (swanAppAudioClient != null) {
                swanAppAudioClient.B();
            }
            if (this.f6739h != null) {
                c.a.q0.a.c1.a.c().unregisterActivityLifecycleCallbacks(this.f6739h);
                this.f6739h = null;
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (e.L() != null && e.L().X() != null && f6732j != null) {
                b.a X = e.L().X();
                c.a.q0.a.n2.s.f fVar = new c.a.q0.a.n2.s.f();
                fVar.a = n.n(X.G());
                fVar.f7426f = X.H();
                fVar.f7423c = X.T();
                fVar.a("appid", X.H());
                fVar.a("cuid", c.a.q0.a.c1.a.h0().i(c.a.q0.a.c1.a.c()));
                JSONObject k2 = n.k(X.W());
                if (k2 != null) {
                    fVar.a("keyfeed", k2.optString("keyfeed"));
                }
                n.i(f6732j, fVar);
            }
            f6732j = null;
        }
    }

    public c.a.q0.a.j1.c.a q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f6734c : (c.a.q0.a.j1.c.a) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f6736e : invokeV.intValue;
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
                    return Integer.valueOf(this.f6736e);
                case 2:
                    return Boolean.valueOf(x());
                case 3:
                    return this.f6734c.f6713c;
                case 4:
                    return Integer.valueOf(this.f6734c.f6721k);
                case 5:
                    return Integer.valueOf(this.f6737f);
                case 6:
                    return this.f6734c.f6714d;
                case 7:
                    return this.f6734c.f6715e;
                case '\b':
                    return this.f6734c.f6716f;
                case '\t':
                    return this.f6734c.f6717g;
                case '\n':
                    return this.f6734c.f6718h;
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

    public void update(c.a.q0.a.j1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) {
            if (f6731i) {
                String str = "Audio Update : " + aVar;
            }
            this.f6734c = aVar;
            c.a.q0.a.j1.c.f.a aVar2 = this.f6735d;
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
                this.a = new SwanAppAudioClient(this.f6733b);
                this.a.A(new C0375c(this, null));
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

    public void z(c.a.q0.a.j1.c.a aVar, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, aVar, callbackHandler) == null) {
            d.b("SwanAppBGAudioPlayer", "#openPlayer params=" + aVar);
            this.f6734c = aVar;
            if (aVar.p != null) {
                try {
                    this.f6735d = new c.a.q0.a.j1.c.f.a(callbackHandler, new JSONObject(this.f6734c.p));
                } catch (JSONException e2) {
                    c.a.q0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 2009, "open audio fail", -1, "");
                    c.a.q0.a.e0.d.c("backgroundAudio", e2.toString());
                    boolean z = f6731i;
                }
            }
            B();
        }
    }
}
