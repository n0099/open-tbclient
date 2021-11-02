package b.a.p0.h.a.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import b.a.p0.a.p.b.a.n;
import b.a.p0.f.i.r.i;
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
public class e extends EventTargetImpl implements b.a.p0.h.a.f.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @V8JavascriptField
    public String adUnitId;

    /* renamed from: e  reason: collision with root package name */
    public b.a.p0.f.i.p.b f10183e;

    /* renamed from: f  reason: collision with root package name */
    public String f10184f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10185g;

    /* renamed from: h  reason: collision with root package name */
    public c f10186h;

    /* renamed from: i  reason: collision with root package name */
    public d f10187i;
    public Map<String, String> j;
    public b.a.p0.f.i.l.f k;
    public b l;
    public boolean m;
    public boolean n;
    public b.a.p0.a.w2.c o;
    public b.a.p0.f.i.p.a p;

    /* loaded from: classes4.dex */
    public class a implements b.a.p0.f.i.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f10188a;

        /* renamed from: b.a.p0.h.a.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0548a implements b.a.p0.a.w2.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f10189e;

            public C0548a(a aVar) {
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
                this.f10189e = aVar;
            }

            @Override // b.a.p0.a.w2.c
            public void l() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f10189e.f10188a.m = true;
                    if (this.f10189e.f10188a.n) {
                        this.f10189e.f10188a.f10183e.P();
                    }
                }
            }

            @Override // b.a.p0.a.w2.c
            public void onViewBackground() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f10189e.f10188a.m = false;
                    this.f10189e.f10188a.f10183e.i0();
                }
            }

            @Override // b.a.p0.a.w2.c
            public void onViewDestroy() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
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
            this.f10188a = eVar;
        }

        @Override // b.a.p0.f.i.p.a
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.f10188a.dispatchEvent(new JSEvent("load"));
                    if (this.f10188a.f10186h != null) {
                        this.f10188a.f10186h.c();
                    }
                    b.a.p0.h.a.f.a.b().c(16, "");
                    b.a.p0.h.a.c.b(this.f10188a.getType(), "success");
                    return;
                }
                if (this.f10188a.f10186h != null) {
                    this.f10188a.f10186h.b(str);
                }
                b.a.p0.h.a.f.a.b().c(17, str);
                b.a.p0.h.a.c.c(this.f10188a.getType(), com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
            }
        }

        @Override // b.a.p0.f.i.p.a
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    if (this.f10188a.f10187i != null) {
                        this.f10188a.f10187i.c();
                    }
                    if (this.f10188a.l == null) {
                        this.f10188a.l = new b(this.f10188a, null);
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.SCREEN_ON");
                        intentFilter.addAction("android.intent.action.SCREEN_OFF");
                        AppRuntime.getAppContext().registerReceiver(this.f10188a.l, intentFilter);
                    }
                    if (this.f10188a.o == null) {
                        this.f10188a.o = new C0548a(this);
                        e.K(this.f10188a.o);
                    }
                } else if (this.f10188a.f10187i != null) {
                    this.f10188a.f10187i.b(str);
                }
            }
        }

        @Override // b.a.p0.f.i.p.a
        public void c(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                JSEvent jSEvent = new JSEvent(IntentConfig.CLOSE);
                jSEvent.data = f.a(z);
                this.f10188a.dispatchEvent(jSEvent);
                b.a.p0.h.a.c.a(this.f10188a.getType(), "pageclose", i2);
                this.f10188a.destroy();
            }
        }

        @Override // b.a.p0.f.i.p.a
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                b.a.p0.h.a.c.a(this.f10188a.getType(), PrefetchEvent.STATE_CLICK, i2);
            }
        }

        @Override // b.a.p0.f.i.p.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = f.b(str);
                this.f10188a.dispatchEvent(jSEvent);
                b.a.p0.f.i.q.b.k(this.f10188a.j, str);
                this.f10188a.destroy();
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
                        this.this$0.f10183e.P();
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
            this.f10184f = F.B("appSid");
        }
        if (F != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.f10184f)) {
            boolean g2 = i.g();
            this.f10185g = g2;
            if (g2) {
                this.f10184f = i.c();
                this.adUnitId = i.d();
            }
            this.j = b.a.p0.f.i.q.b.a("video", "game", this.f10184f, this.adUnitId, this.f10185g);
            this.k = new b.a.p0.h.a.a();
            b.a.p0.f.i.p.b bVar = new b.a.p0.f.i.p.b(b.a.p0.a.g1.f.T().getActivity(), this.f10184f, this.adUnitId, this.f10185g, this.p, this.k);
            this.f10183e = bVar;
            bVar.k0(this.j);
            loadAd(null);
            return;
        }
        cVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
    }

    public static void K(b.a.p0.a.w2.c cVar) {
        n V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, cVar) == null) || (V = b.a.p0.a.g1.f.T().V()) == null) {
            return;
        }
        V.e(cVar);
    }

    public static void L(b.a.p0.a.w2.c cVar) {
        n V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, cVar) == null) || (V = b.a.p0.a.g1.f.T().V()) == null) {
            return;
        }
        V.f(cVar);
    }

    public final void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.l != null) {
                AppRuntime.getAppContext().unregisterReceiver(this.l);
                this.l = null;
            }
            b.a.p0.a.w2.c cVar = this.o;
            if (cVar != null) {
                L(cVar);
                this.o = null;
            }
        }
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f10185g ? "gdtvideo" : "video" : (String) invokeV.objValue;
    }

    @JavascriptInterface
    public synchronized void loadAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            synchronized (this) {
                this.f10186h = c.d(b.a.p0.a.y.b.a.F(jsObject));
                b.a.p0.h.a.f.a.b().a(this.f10186h);
                if (this.f10183e != null) {
                    this.f10183e.e0();
                }
            }
        }
    }

    @JavascriptInterface
    public synchronized void showAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            synchronized (this) {
                b.a.p0.h.a.c.d(getType());
                this.f10187i = d.d(b.a.p0.a.y.b.a.F(jsObject));
                if (this.f10183e != null) {
                    this.f10183e.l0();
                }
            }
        }
    }
}
