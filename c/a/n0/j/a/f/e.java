package c.a.n0.j.a.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import c.a.n0.a.f.b.a.n;
import c.a.n0.h.a.e.g;
import c.a.n0.h.a.k.i;
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
public class e extends EventTargetImpl implements c.a.n0.j.a.f.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.n0.h.a.i.b a;
    @V8JavascriptField
    public String adUnitId;

    /* renamed from: b  reason: collision with root package name */
    public String f8571b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8572c;

    /* renamed from: d  reason: collision with root package name */
    public c f8573d;

    /* renamed from: e  reason: collision with root package name */
    public d f8574e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f8575f;

    /* renamed from: g  reason: collision with root package name */
    public g f8576g;

    /* renamed from: h  reason: collision with root package name */
    public b f8577h;
    public boolean i;
    public boolean j;
    public c.a.n0.a.q2.c k;
    public c.a.n0.h.a.i.a l;

    /* loaded from: classes2.dex */
    public class a implements c.a.n0.h.a.i.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* renamed from: c.a.n0.j.a.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0684a implements c.a.n0.a.q2.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0684a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // c.a.n0.a.q2.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                }
            }

            @Override // c.a.n0.a.q2.c
            public void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.a.i = false;
                    this.a.a.a.i0();
                }
            }

            @Override // c.a.n0.a.q2.c
            public void n() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.a.a.i = true;
                    if (this.a.a.j) {
                        this.a.a.a.N();
                    }
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.n0.h.a.i.a
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.dispatchEvent(new JSEvent("load"));
                    if (this.a.f8573d != null) {
                        this.a.f8573d.c();
                    }
                    c.a.n0.j.a.f.a.b().c(16, "");
                    c.a.n0.j.a.c.b(this.a.getType(), "success");
                    return;
                }
                if (this.a.f8573d != null) {
                    this.a.f8573d.b(str);
                }
                c.a.n0.j.a.f.a.b().c(17, str);
                c.a.n0.j.a.c.c(this.a.getType(), com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
            }
        }

        @Override // c.a.n0.h.a.i.a
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    if (this.a.f8574e != null) {
                        this.a.f8574e.c();
                    }
                    if (this.a.f8577h == null) {
                        this.a.f8577h = new b(this.a, null);
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.SCREEN_ON");
                        intentFilter.addAction("android.intent.action.SCREEN_OFF");
                        AppRuntime.getAppContext().registerReceiver(this.a.f8577h, intentFilter);
                    }
                    if (this.a.k == null) {
                        this.a.k = new C0684a(this);
                        e.M(this.a.k);
                    }
                } else if (this.a.f8574e != null) {
                    this.a.f8574e.b(str);
                }
            }
        }

        @Override // c.a.n0.h.a.i.a
        public void c(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                JSEvent jSEvent = new JSEvent(IntentConfig.CLOSE);
                jSEvent.data = f.a(z);
                this.a.dispatchEvent(jSEvent);
                c.a.n0.j.a.c.a(this.a.getType(), "pageclose", i);
                this.a.destroy();
            }
        }

        @Override // c.a.n0.h.a.i.a
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                c.a.n0.j.a.c.a(this.a.getType(), "click", i);
            }
        }

        @Override // c.a.n0.h.a.i.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = f.b(str);
                this.a.dispatchEvent(jSEvent);
                c.a.n0.h.a.j.b.k(this.a.f8575f, str);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                    this.this$0.j = true;
                    if (this.this$0.i) {
                        this.this$0.a.N();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    this.this$0.j = false;
                }
            }
        }

        public /* synthetic */ b(e eVar, a aVar) {
            this(eVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c.a.n0.a.b0.c cVar, JsObject jsObject) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, jsObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.adUnitId = "";
        this.f8575f = new TreeMap();
        this.j = true;
        this.l = new a(this);
        c.a.n0.a.o.b.a F = c.a.n0.a.o.b.a.F(jsObject);
        if (F != null) {
            this.adUnitId = F.B("adUnitId");
            this.f8571b = F.B("appSid");
        }
        if (F != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.f8571b)) {
            boolean g2 = i.g();
            this.f8572c = g2;
            if (g2) {
                this.f8571b = i.c();
                this.adUnitId = i.d();
            }
            this.f8575f = c.a.n0.h.a.j.b.a("video", "game", this.f8571b, this.adUnitId, this.f8572c);
            this.f8576g = new c.a.n0.j.a.a();
            c.a.n0.h.a.i.b bVar = new c.a.n0.h.a.i.b(c.a.n0.a.w0.f.U().getActivity(), this.f8571b, this.adUnitId, this.f8572c, this.l, this.f8576g);
            this.a = bVar;
            bVar.k0(this.f8575f);
            loadAd(null);
            return;
        }
        cVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
    }

    public static void M(c.a.n0.a.q2.c cVar) {
        n W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, cVar) == null) || (W = c.a.n0.a.w0.f.U().W()) == null) {
            return;
        }
        W.e(cVar);
    }

    public static void N(c.a.n0.a.q2.c cVar) {
        n W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, null, cVar) == null) || (W = c.a.n0.a.w0.f.U().W()) == null) {
            return;
        }
        W.f(cVar);
    }

    public final void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f8577h != null) {
                AppRuntime.getAppContext().unregisterReceiver(this.f8577h);
                this.f8577h = null;
            }
            c.a.n0.a.q2.c cVar = this.k;
            if (cVar != null) {
                N(cVar);
                this.k = null;
            }
        }
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f8572c ? "gdtvideo" : "video" : (String) invokeV.objValue;
    }

    @JavascriptInterface
    public synchronized void loadAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            synchronized (this) {
                this.f8573d = c.d(c.a.n0.a.o.b.a.F(jsObject));
                c.a.n0.j.a.f.a.b().a(this.f8573d);
                if (this.a != null) {
                    this.a.c0();
                }
            }
        }
    }

    @JavascriptInterface
    public synchronized void showAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            synchronized (this) {
                c.a.n0.j.a.c.d(getType());
                this.f8574e = d.d(c.a.n0.a.o.b.a.F(jsObject));
                if (this.a != null) {
                    this.a.l0();
                }
            }
        }
    }
}
