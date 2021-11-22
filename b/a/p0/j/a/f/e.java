package b.a.p0.j.a.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import b.a.p0.a.p.b.a.n;
import b.a.p0.h.i.m.g;
import b.a.p0.h.i.s.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes4.dex */
public class e extends EventTargetImpl implements b.a.p0.j.a.f.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @V8JavascriptField
    public String adUnitId;

    /* renamed from: e  reason: collision with root package name */
    public b.a.p0.h.i.q.b f10852e;

    /* renamed from: f  reason: collision with root package name */
    public String f10853f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10854g;

    /* renamed from: h  reason: collision with root package name */
    public c f10855h;

    /* renamed from: i  reason: collision with root package name */
    public d f10856i;
    public Map<String, String> j;
    public g k;
    public b l;
    public boolean m;
    public boolean n;
    public b.a.p0.a.a3.c o;
    public b.a.p0.h.i.q.a p;

    /* loaded from: classes4.dex */
    public class a implements b.a.p0.h.i.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f10857a;

        /* renamed from: b.a.p0.j.a.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0576a implements b.a.p0.a.a3.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f10858e;

            public C0576a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10858e = aVar;
            }

            @Override // b.a.p0.a.a3.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                }
            }

            @Override // b.a.p0.a.a3.c
            public void m() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f10858e.f10857a.m = true;
                    if (this.f10858e.f10857a.n) {
                        this.f10858e.f10857a.f10852e.N();
                    }
                }
            }

            @Override // b.a.p0.a.a3.c
            public void onViewBackground() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f10858e.f10857a.m = false;
                    this.f10858e.f10857a.f10852e.i0();
                }
            }
        }

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10857a = eVar;
        }

        @Override // b.a.p0.h.i.q.a
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.f10857a.dispatchEvent(new JSEvent("load"));
                    if (this.f10857a.f10855h != null) {
                        this.f10857a.f10855h.c();
                    }
                    b.a.p0.j.a.f.a.b().c(16, "");
                    b.a.p0.j.a.c.b(this.f10857a.getType(), "success");
                    return;
                }
                if (this.f10857a.f10855h != null) {
                    this.f10857a.f10855h.b(str);
                }
                b.a.p0.j.a.f.a.b().c(17, str);
                b.a.p0.j.a.c.c(this.f10857a.getType(), com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
            }
        }

        @Override // b.a.p0.h.i.q.a
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    if (this.f10857a.f10856i != null) {
                        this.f10857a.f10856i.c();
                    }
                    if (this.f10857a.l == null) {
                        this.f10857a.l = new b(this.f10857a, null);
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.SCREEN_ON");
                        intentFilter.addAction("android.intent.action.SCREEN_OFF");
                        AppRuntime.getAppContext().registerReceiver(this.f10857a.l, intentFilter);
                    }
                    if (this.f10857a.o == null) {
                        this.f10857a.o = new C0576a(this);
                        e.L(this.f10857a.o);
                    }
                } else if (this.f10857a.f10856i != null) {
                    this.f10857a.f10856i.b(str);
                }
            }
        }

        @Override // b.a.p0.h.i.q.a
        public void c(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                JSEvent jSEvent = new JSEvent(IntentConfig.CLOSE);
                jSEvent.data = f.a(z);
                this.f10857a.dispatchEvent(jSEvent);
                b.a.p0.j.a.c.a(this.f10857a.getType(), "pageclose", i2);
                this.f10857a.destroy();
            }
        }

        @Override // b.a.p0.h.i.q.a
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                b.a.p0.j.a.c.a(this.f10857a.getType(), PrefetchEvent.STATE_CLICK, i2);
            }
        }

        @Override // b.a.p0.h.i.q.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = f.b(str);
                this.f10857a.dispatchEvent(jSEvent);
                b.a.p0.h.i.r.b.k(this.f10857a.j, str);
                this.f10857a.destroy();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e this$0;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = eVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                    this.this$0.n = true;
                    if (this.this$0.m) {
                        this.this$0.f10852e.N();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    this.this$0.n = false;
                }
            }
        }

        public /* synthetic */ b(e eVar, a aVar) {
            this(eVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(b.a.p0.a.l0.c cVar, JsObject jsObject) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, jsObject};
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
        this.adUnitId = "";
        this.j = new TreeMap();
        this.n = true;
        this.p = new a(this);
        b.a.p0.a.y.b.a F = b.a.p0.a.y.b.a.F(jsObject);
        if (F != null) {
            this.adUnitId = F.B("adUnitId");
            this.f10853f = F.B("appSid");
        }
        if (F != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.f10853f)) {
            boolean g2 = i.g();
            this.f10854g = g2;
            if (g2) {
                this.f10853f = i.c();
                this.adUnitId = i.d();
            }
            this.j = b.a.p0.h.i.r.b.a("video", "game", this.f10853f, this.adUnitId, this.f10854g);
            this.k = new b.a.p0.j.a.a();
            b.a.p0.h.i.q.b bVar = new b.a.p0.h.i.q.b(b.a.p0.a.g1.f.U().getActivity(), this.f10853f, this.adUnitId, this.f10854g, this.p, this.k);
            this.f10852e = bVar;
            bVar.k0(this.j);
            loadAd(null);
            return;
        }
        cVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
    }

    public static void L(b.a.p0.a.a3.c cVar) {
        n W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, cVar) == null) || (W = b.a.p0.a.g1.f.U().W()) == null) {
            return;
        }
        W.e(cVar);
    }

    public static void M(b.a.p0.a.a3.c cVar) {
        n W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, cVar) == null) || (W = b.a.p0.a.g1.f.U().W()) == null) {
            return;
        }
        W.f(cVar);
    }

    public final void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.l != null) {
                AppRuntime.getAppContext().unregisterReceiver(this.l);
                this.l = null;
            }
            b.a.p0.a.a3.c cVar = this.o;
            if (cVar != null) {
                M(cVar);
                this.o = null;
            }
        }
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f10854g ? "gdtvideo" : "video" : (String) invokeV.objValue;
    }

    @JavascriptInterface
    public synchronized void loadAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            synchronized (this) {
                this.f10855h = c.d(b.a.p0.a.y.b.a.F(jsObject));
                b.a.p0.j.a.f.a.b().a(this.f10855h);
                if (this.f10852e != null) {
                    this.f10852e.c0();
                }
            }
        }
    }

    @JavascriptInterface
    public synchronized void showAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            synchronized (this) {
                b.a.p0.j.a.c.d(getType());
                this.f10856i = d.d(b.a.p0.a.y.b.a.F(jsObject));
                if (this.f10852e != null) {
                    this.f10852e.l0();
                }
            }
        }
    }
}
