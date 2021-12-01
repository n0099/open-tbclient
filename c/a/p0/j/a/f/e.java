package c.a.p0.j.a.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import c.a.p0.a.p.b.a.n;
import c.a.p0.h.i.m.g;
import c.a.p0.h.i.s.i;
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
/* loaded from: classes5.dex */
public class e extends EventTargetImpl implements c.a.p0.j.a.f.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @V8JavascriptField
    public String adUnitId;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.h.i.q.b f9972e;

    /* renamed from: f  reason: collision with root package name */
    public String f9973f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f9974g;

    /* renamed from: h  reason: collision with root package name */
    public c f9975h;

    /* renamed from: i  reason: collision with root package name */
    public d f9976i;

    /* renamed from: j  reason: collision with root package name */
    public Map<String, String> f9977j;

    /* renamed from: k  reason: collision with root package name */
    public g f9978k;
    public b l;
    public boolean m;
    public boolean n;
    public c.a.p0.a.a3.c o;
    public c.a.p0.h.i.q.a p;

    /* loaded from: classes5.dex */
    public class a implements c.a.p0.h.i.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* renamed from: c.a.p0.j.a.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0632a implements c.a.p0.a.a3.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f9979e;

            public C0632a(a aVar) {
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
                this.f9979e = aVar;
            }

            @Override // c.a.p0.a.a3.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                }
            }

            @Override // c.a.p0.a.a3.c
            public void m() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f9979e.a.m = true;
                    if (this.f9979e.a.n) {
                        this.f9979e.a.f9972e.N();
                    }
                }
            }

            @Override // c.a.p0.a.a3.c
            public void onViewBackground() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f9979e.a.m = false;
                    this.f9979e.a.f9972e.i0();
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

        @Override // c.a.p0.h.i.q.a
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.dispatchEvent(new JSEvent("load"));
                    if (this.a.f9975h != null) {
                        this.a.f9975h.c();
                    }
                    c.a.p0.j.a.f.a.b().c(16, "");
                    c.a.p0.j.a.c.b(this.a.getType(), "success");
                    return;
                }
                if (this.a.f9975h != null) {
                    this.a.f9975h.b(str);
                }
                c.a.p0.j.a.f.a.b().c(17, str);
                c.a.p0.j.a.c.c(this.a.getType(), com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
            }
        }

        @Override // c.a.p0.h.i.q.a
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    if (this.a.f9976i != null) {
                        this.a.f9976i.c();
                    }
                    if (this.a.l == null) {
                        this.a.l = new b(this.a, null);
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.SCREEN_ON");
                        intentFilter.addAction("android.intent.action.SCREEN_OFF");
                        AppRuntime.getAppContext().registerReceiver(this.a.l, intentFilter);
                    }
                    if (this.a.o == null) {
                        this.a.o = new C0632a(this);
                        e.L(this.a.o);
                    }
                } else if (this.a.f9976i != null) {
                    this.a.f9976i.b(str);
                }
            }
        }

        @Override // c.a.p0.h.i.q.a
        public void c(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                JSEvent jSEvent = new JSEvent(IntentConfig.CLOSE);
                jSEvent.data = f.a(z);
                this.a.dispatchEvent(jSEvent);
                c.a.p0.j.a.c.a(this.a.getType(), "pageclose", i2);
                this.a.destroy();
            }
        }

        @Override // c.a.p0.h.i.q.a
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                c.a.p0.j.a.c.a(this.a.getType(), "click", i2);
            }
        }

        @Override // c.a.p0.h.i.q.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = f.b(str);
                this.a.dispatchEvent(jSEvent);
                c.a.p0.h.i.r.b.k(this.a.f9977j, str);
                this.a.destroy();
            }
        }
    }

    /* loaded from: classes5.dex */
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
                        this.this$0.f9972e.N();
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
    public e(c.a.p0.a.l0.c cVar, JsObject jsObject) {
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
        this.f9977j = new TreeMap();
        this.n = true;
        this.p = new a(this);
        c.a.p0.a.y.b.a F = c.a.p0.a.y.b.a.F(jsObject);
        if (F != null) {
            this.adUnitId = F.B("adUnitId");
            this.f9973f = F.B("appSid");
        }
        if (F != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.f9973f)) {
            boolean g2 = i.g();
            this.f9974g = g2;
            if (g2) {
                this.f9973f = i.c();
                this.adUnitId = i.d();
            }
            this.f9977j = c.a.p0.h.i.r.b.a("video", "game", this.f9973f, this.adUnitId, this.f9974g);
            this.f9978k = new c.a.p0.j.a.a();
            c.a.p0.h.i.q.b bVar = new c.a.p0.h.i.q.b(c.a.p0.a.g1.f.U().getActivity(), this.f9973f, this.adUnitId, this.f9974g, this.p, this.f9978k);
            this.f9972e = bVar;
            bVar.k0(this.f9977j);
            loadAd(null);
            return;
        }
        cVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
    }

    public static void L(c.a.p0.a.a3.c cVar) {
        n W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, cVar) == null) || (W = c.a.p0.a.g1.f.U().W()) == null) {
            return;
        }
        W.e(cVar);
    }

    public static void M(c.a.p0.a.a3.c cVar) {
        n W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, cVar) == null) || (W = c.a.p0.a.g1.f.U().W()) == null) {
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
            c.a.p0.a.a3.c cVar = this.o;
            if (cVar != null) {
                M(cVar);
                this.o = null;
            }
        }
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f9974g ? "gdtvideo" : "video" : (String) invokeV.objValue;
    }

    @JavascriptInterface
    public synchronized void loadAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            synchronized (this) {
                this.f9975h = c.d(c.a.p0.a.y.b.a.F(jsObject));
                c.a.p0.j.a.f.a.b().a(this.f9975h);
                if (this.f9972e != null) {
                    this.f9972e.c0();
                }
            }
        }
    }

    @JavascriptInterface
    public synchronized void showAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            synchronized (this) {
                c.a.p0.j.a.c.d(getType());
                this.f9976i = d.d(c.a.p0.a.y.b.a.F(jsObject));
                if (this.f9972e != null) {
                    this.f9972e.l0();
                }
            }
        }
    }
}
