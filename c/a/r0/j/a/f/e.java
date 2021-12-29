package c.a.r0.j.a.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import c.a.r0.a.p.b.a.n;
import c.a.r0.h.i.m.g;
import c.a.r0.h.i.s.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class e extends EventTargetImpl implements c.a.r0.j.a.f.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @V8JavascriptField
    public String adUnitId;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.h.i.q.b f11016e;

    /* renamed from: f  reason: collision with root package name */
    public String f11017f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11018g;

    /* renamed from: h  reason: collision with root package name */
    public c f11019h;

    /* renamed from: i  reason: collision with root package name */
    public d f11020i;

    /* renamed from: j  reason: collision with root package name */
    public Map<String, String> f11021j;

    /* renamed from: k  reason: collision with root package name */
    public g f11022k;
    public b l;
    public boolean m;
    public boolean n;
    public c.a.r0.a.a3.c o;
    public c.a.r0.h.i.q.a p;

    /* loaded from: classes6.dex */
    public class a implements c.a.r0.h.i.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* renamed from: c.a.r0.j.a.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0716a implements c.a.r0.a.a3.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f11023e;

            public C0716a(a aVar) {
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
                this.f11023e = aVar;
            }

            @Override // c.a.r0.a.a3.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                }
            }

            @Override // c.a.r0.a.a3.c
            public void m() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f11023e.a.m = true;
                    if (this.f11023e.a.n) {
                        this.f11023e.a.f11016e.N();
                    }
                }
            }

            @Override // c.a.r0.a.a3.c
            public void onViewBackground() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f11023e.a.m = false;
                    this.f11023e.a.f11016e.i0();
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
            this.a = eVar;
        }

        @Override // c.a.r0.h.i.q.a
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.dispatchEvent(new JSEvent("load"));
                    if (this.a.f11019h != null) {
                        this.a.f11019h.c();
                    }
                    c.a.r0.j.a.f.a.b().c(16, "");
                    c.a.r0.j.a.c.b(this.a.getType(), "success");
                    return;
                }
                if (this.a.f11019h != null) {
                    this.a.f11019h.b(str);
                }
                c.a.r0.j.a.f.a.b().c(17, str);
                c.a.r0.j.a.c.c(this.a.getType(), com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
            }
        }

        @Override // c.a.r0.h.i.q.a
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    if (this.a.f11020i != null) {
                        this.a.f11020i.c();
                    }
                    if (this.a.l == null) {
                        this.a.l = new b(this.a, null);
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.SCREEN_ON");
                        intentFilter.addAction("android.intent.action.SCREEN_OFF");
                        AppRuntime.getAppContext().registerReceiver(this.a.l, intentFilter);
                    }
                    if (this.a.o == null) {
                        this.a.o = new C0716a(this);
                        e.L(this.a.o);
                    }
                } else if (this.a.f11020i != null) {
                    this.a.f11020i.b(str);
                }
            }
        }

        @Override // c.a.r0.h.i.q.a
        public void c(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                JSEvent jSEvent = new JSEvent(IntentConfig.CLOSE);
                jSEvent.data = f.a(z);
                this.a.dispatchEvent(jSEvent);
                c.a.r0.j.a.c.a(this.a.getType(), "pageclose", i2);
                this.a.destroy();
            }
        }

        @Override // c.a.r0.h.i.q.a
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                c.a.r0.j.a.c.a(this.a.getType(), "click", i2);
            }
        }

        @Override // c.a.r0.h.i.q.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = f.b(str);
                this.a.dispatchEvent(jSEvent);
                c.a.r0.h.i.r.b.k(this.a.f11021j, str);
                this.a.destroy();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                        this.this$0.f11016e.N();
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
    public e(c.a.r0.a.l0.c cVar, JsObject jsObject) {
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
        this.f11021j = new TreeMap();
        this.n = true;
        this.p = new a(this);
        c.a.r0.a.y.b.a F = c.a.r0.a.y.b.a.F(jsObject);
        if (F != null) {
            this.adUnitId = F.B("adUnitId");
            this.f11017f = F.B("appSid");
        }
        if (F != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.f11017f)) {
            boolean g2 = i.g();
            this.f11018g = g2;
            if (g2) {
                this.f11017f = i.c();
                this.adUnitId = i.d();
            }
            this.f11021j = c.a.r0.h.i.r.b.a("video", "game", this.f11017f, this.adUnitId, this.f11018g);
            this.f11022k = new c.a.r0.j.a.a();
            c.a.r0.h.i.q.b bVar = new c.a.r0.h.i.q.b(c.a.r0.a.g1.f.U().getActivity(), this.f11017f, this.adUnitId, this.f11018g, this.p, this.f11022k);
            this.f11016e = bVar;
            bVar.k0(this.f11021j);
            loadAd(null);
            return;
        }
        cVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
    }

    public static void L(c.a.r0.a.a3.c cVar) {
        n W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, cVar) == null) || (W = c.a.r0.a.g1.f.U().W()) == null) {
            return;
        }
        W.e(cVar);
    }

    public static void M(c.a.r0.a.a3.c cVar) {
        n W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, cVar) == null) || (W = c.a.r0.a.g1.f.U().W()) == null) {
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
            c.a.r0.a.a3.c cVar = this.o;
            if (cVar != null) {
                M(cVar);
                this.o = null;
            }
        }
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11018g ? "gdtvideo" : "video" : (String) invokeV.objValue;
    }

    @JavascriptInterface
    public synchronized void loadAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            synchronized (this) {
                this.f11019h = c.d(c.a.r0.a.y.b.a.F(jsObject));
                c.a.r0.j.a.f.a.b().a(this.f11019h);
                if (this.f11016e != null) {
                    this.f11016e.c0();
                }
            }
        }
    }

    @JavascriptInterface
    public synchronized void showAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            synchronized (this) {
                c.a.r0.j.a.c.d(getType());
                this.f11020i = d.d(c.a.r0.a.y.b.a.F(jsObject));
                if (this.f11016e != null) {
                    this.f11016e.l0();
                }
            }
        }
    }
}
