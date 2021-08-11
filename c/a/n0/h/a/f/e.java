package c.a.n0.h.a.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import c.a.n0.a.p.b.a.n;
import c.a.n0.f.i.r.i;
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
/* loaded from: classes3.dex */
public class e extends EventTargetImpl implements c.a.n0.h.a.f.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @V8JavascriptField
    public String adUnitId;

    /* renamed from: e  reason: collision with root package name */
    public c.a.n0.f.i.p.b f10696e;

    /* renamed from: f  reason: collision with root package name */
    public String f10697f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10698g;

    /* renamed from: h  reason: collision with root package name */
    public c f10699h;

    /* renamed from: i  reason: collision with root package name */
    public d f10700i;

    /* renamed from: j  reason: collision with root package name */
    public Map<String, String> f10701j;
    public c.a.n0.f.i.l.f k;
    public b l;
    public boolean m;
    public boolean n;
    public c.a.n0.a.w2.c o;
    public c.a.n0.f.i.p.a p;

    /* loaded from: classes3.dex */
    public class a implements c.a.n0.f.i.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f10702a;

        /* renamed from: c.a.n0.h.a.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0543a implements c.a.n0.a.w2.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f10703e;

            public C0543a(a aVar) {
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
                this.f10703e = aVar;
            }

            @Override // c.a.n0.a.w2.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                }
            }

            @Override // c.a.n0.a.w2.c
            public void m() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f10703e.f10702a.m = true;
                    if (this.f10703e.f10702a.n) {
                        this.f10703e.f10702a.f10696e.P();
                    }
                }
            }

            @Override // c.a.n0.a.w2.c
            public void onViewBackground() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f10703e.f10702a.m = false;
                    this.f10703e.f10702a.f10696e.i0();
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
            this.f10702a = eVar;
        }

        @Override // c.a.n0.f.i.p.a
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.f10702a.dispatchEvent(new JSEvent("load"));
                    if (this.f10702a.f10699h != null) {
                        this.f10702a.f10699h.c();
                    }
                    c.a.n0.h.a.f.a.b().c(16, "");
                    c.a.n0.h.a.c.b(this.f10702a.L(), "success");
                    return;
                }
                if (this.f10702a.f10699h != null) {
                    this.f10702a.f10699h.b(str);
                }
                c.a.n0.h.a.f.a.b().c(17, str);
                c.a.n0.h.a.c.c(this.f10702a.L(), com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
            }
        }

        @Override // c.a.n0.f.i.p.a
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    if (this.f10702a.f10700i != null) {
                        this.f10702a.f10700i.c();
                    }
                    if (this.f10702a.l == null) {
                        this.f10702a.l = new b(this.f10702a, null);
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.SCREEN_ON");
                        intentFilter.addAction("android.intent.action.SCREEN_OFF");
                        AppRuntime.getAppContext().registerReceiver(this.f10702a.l, intentFilter);
                    }
                    if (this.f10702a.o == null) {
                        this.f10702a.o = new C0543a(this);
                        e.M(this.f10702a.o);
                    }
                } else if (this.f10702a.f10700i != null) {
                    this.f10702a.f10700i.b(str);
                }
            }
        }

        @Override // c.a.n0.f.i.p.a
        public void c(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                JSEvent jSEvent = new JSEvent(IntentConfig.CLOSE);
                jSEvent.data = f.a(z);
                this.f10702a.dispatchEvent(jSEvent);
                c.a.n0.h.a.c.a(this.f10702a.L(), "pageclose", i2);
                this.f10702a.destroy();
            }
        }

        @Override // c.a.n0.f.i.p.a
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                c.a.n0.h.a.c.a(this.f10702a.L(), PrefetchEvent.STATE_CLICK, i2);
            }
        }

        @Override // c.a.n0.f.i.p.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = f.b(str);
                this.f10702a.dispatchEvent(jSEvent);
                c.a.n0.f.i.q.b.k(this.f10702a.f10701j, str);
                this.f10702a.destroy();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                        this.this$0.f10696e.P();
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
    public e(c.a.n0.a.l0.c cVar, JsObject jsObject) {
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
        this.f10701j = new TreeMap();
        this.n = true;
        this.p = new a(this);
        c.a.n0.a.y.b.a G = c.a.n0.a.y.b.a.G(jsObject);
        if (G != null) {
            this.adUnitId = G.C("adUnitId");
            this.f10697f = G.C("appSid");
        }
        if (G != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.f10697f)) {
            boolean g2 = i.g();
            this.f10698g = g2;
            if (g2) {
                this.f10697f = i.c();
                this.adUnitId = i.d();
            }
            this.f10701j = c.a.n0.f.i.q.b.a("video", "game", this.f10697f, this.adUnitId, this.f10698g);
            this.k = new c.a.n0.h.a.a();
            c.a.n0.f.i.p.b bVar = new c.a.n0.f.i.p.b(c.a.n0.a.g1.f.V().getActivity(), this.f10697f, this.adUnitId, this.f10698g, this.p, this.k);
            this.f10696e = bVar;
            bVar.k0(this.f10701j);
            loadAd(null);
            return;
        }
        cVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
    }

    public static void M(c.a.n0.a.w2.c cVar) {
        n X;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, cVar) == null) || (X = c.a.n0.a.g1.f.V().X()) == null) {
            return;
        }
        X.e(cVar);
    }

    public static void N(c.a.n0.a.w2.c cVar) {
        n X;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, cVar) == null) || (X = c.a.n0.a.g1.f.V().X()) == null) {
            return;
        }
        X.f(cVar);
    }

    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f10698g ? "gdtvideo" : "video" : (String) invokeV.objValue;
    }

    public final void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.l != null) {
                AppRuntime.getAppContext().unregisterReceiver(this.l);
                this.l = null;
            }
            c.a.n0.a.w2.c cVar = this.o;
            if (cVar != null) {
                N(cVar);
                this.o = null;
            }
        }
    }

    @JavascriptInterface
    public synchronized void loadAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            synchronized (this) {
                this.f10699h = c.d(c.a.n0.a.y.b.a.G(jsObject));
                c.a.n0.h.a.f.a.b().a(this.f10699h);
                if (this.f10696e != null) {
                    this.f10696e.e0();
                }
            }
        }
    }

    @JavascriptInterface
    public synchronized void showAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            synchronized (this) {
                c.a.n0.h.a.c.d(L());
                this.f10700i = d.d(c.a.n0.a.y.b.a.G(jsObject));
                if (this.f10696e != null) {
                    this.f10696e.l0();
                }
            }
        }
    }
}
