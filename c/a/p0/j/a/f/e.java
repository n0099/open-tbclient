package c.a.p0.j.a.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import c.a.p0.a.f.b.a.n;
import c.a.p0.h.a.e.g;
import c.a.p0.h.a.k.i;
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
/* loaded from: classes2.dex */
public class e extends EventTargetImpl implements c.a.p0.j.a.f.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @V8JavascriptField
    public String adUnitId;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.h.a.i.b f10238e;

    /* renamed from: f  reason: collision with root package name */
    public String f10239f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10240g;

    /* renamed from: h  reason: collision with root package name */
    public c f10241h;

    /* renamed from: i  reason: collision with root package name */
    public d f10242i;

    /* renamed from: j  reason: collision with root package name */
    public Map<String, String> f10243j;
    public g k;
    public b l;
    public boolean m;
    public boolean n;
    public c.a.p0.a.q2.c o;
    public c.a.p0.h.a.i.a p;

    /* loaded from: classes2.dex */
    public class a implements c.a.p0.h.a.i.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* renamed from: c.a.p0.j.a.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0690a implements c.a.p0.a.q2.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f10244e;

            public C0690a(a aVar) {
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
                this.f10244e = aVar;
            }

            @Override // c.a.p0.a.q2.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                }
            }

            @Override // c.a.p0.a.q2.c
            public void m() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f10244e.a.m = true;
                    if (this.f10244e.a.n) {
                        this.f10244e.a.f10238e.N();
                    }
                }
            }

            @Override // c.a.p0.a.q2.c
            public void onViewBackground() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f10244e.a.m = false;
                    this.f10244e.a.f10238e.i0();
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

        @Override // c.a.p0.h.a.i.a
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.dispatchEvent(new JSEvent("load"));
                    if (this.a.f10241h != null) {
                        this.a.f10241h.c();
                    }
                    c.a.p0.j.a.f.a.b().c(16, "");
                    c.a.p0.j.a.c.b(this.a.getType(), "success");
                    return;
                }
                if (this.a.f10241h != null) {
                    this.a.f10241h.b(str);
                }
                c.a.p0.j.a.f.a.b().c(17, str);
                c.a.p0.j.a.c.c(this.a.getType(), com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
            }
        }

        @Override // c.a.p0.h.a.i.a
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    if (this.a.f10242i != null) {
                        this.a.f10242i.c();
                    }
                    if (this.a.l == null) {
                        this.a.l = new b(this.a, null);
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.SCREEN_ON");
                        intentFilter.addAction("android.intent.action.SCREEN_OFF");
                        AppRuntime.getAppContext().registerReceiver(this.a.l, intentFilter);
                    }
                    if (this.a.o == null) {
                        this.a.o = new C0690a(this);
                        e.L(this.a.o);
                    }
                } else if (this.a.f10242i != null) {
                    this.a.f10242i.b(str);
                }
            }
        }

        @Override // c.a.p0.h.a.i.a
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

        @Override // c.a.p0.h.a.i.a
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                c.a.p0.j.a.c.a(this.a.getType(), "click", i2);
            }
        }

        @Override // c.a.p0.h.a.i.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = f.b(str);
                this.a.dispatchEvent(jSEvent);
                c.a.p0.h.a.j.b.k(this.a.f10243j, str);
                this.a.destroy();
            }
        }
    }

    /* loaded from: classes2.dex */
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
                        this.this$0.f10238e.N();
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
    public e(c.a.p0.a.b0.c cVar, JsObject jsObject) {
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
        this.f10243j = new TreeMap();
        this.n = true;
        this.p = new a(this);
        c.a.p0.a.o.b.a F = c.a.p0.a.o.b.a.F(jsObject);
        if (F != null) {
            this.adUnitId = F.B("adUnitId");
            this.f10239f = F.B("appSid");
        }
        if (F != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.f10239f)) {
            boolean g2 = i.g();
            this.f10240g = g2;
            if (g2) {
                this.f10239f = i.c();
                this.adUnitId = i.d();
            }
            this.f10243j = c.a.p0.h.a.j.b.a("video", "game", this.f10239f, this.adUnitId, this.f10240g);
            this.k = new c.a.p0.j.a.a();
            c.a.p0.h.a.i.b bVar = new c.a.p0.h.a.i.b(c.a.p0.a.w0.f.U().getActivity(), this.f10239f, this.adUnitId, this.f10240g, this.p, this.k);
            this.f10238e = bVar;
            bVar.k0(this.f10243j);
            loadAd(null);
            return;
        }
        cVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
    }

    public static void L(c.a.p0.a.q2.c cVar) {
        n W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, cVar) == null) || (W = c.a.p0.a.w0.f.U().W()) == null) {
            return;
        }
        W.e(cVar);
    }

    public static void M(c.a.p0.a.q2.c cVar) {
        n W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, cVar) == null) || (W = c.a.p0.a.w0.f.U().W()) == null) {
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
            c.a.p0.a.q2.c cVar = this.o;
            if (cVar != null) {
                M(cVar);
                this.o = null;
            }
        }
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f10240g ? "gdtvideo" : "video" : (String) invokeV.objValue;
    }

    @JavascriptInterface
    public synchronized void loadAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            synchronized (this) {
                this.f10241h = c.d(c.a.p0.a.o.b.a.F(jsObject));
                c.a.p0.j.a.f.a.b().a(this.f10241h);
                if (this.f10238e != null) {
                    this.f10238e.c0();
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
                this.f10242i = d.d(c.a.p0.a.o.b.a.F(jsObject));
                if (this.f10238e != null) {
                    this.f10238e.l0();
                }
            }
        }
    }
}
