package c.a.o0.h.a.e;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import c.a.o0.f.i.l.f;
import c.a.o0.f.i.r.i;
import c.a.o0.h.a.e.c;
import com.baidu.android.imsdk.internal.Constants;
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
public class a extends EventTargetImpl implements d, c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @V8JavascriptField
    public String adUnitId;

    /* renamed from: e  reason: collision with root package name */
    public String f10927e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.o0.a.l0.c f10928f;

    /* renamed from: g  reason: collision with root package name */
    public String f10929g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f10930h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.o0.f.i.i.b f10931i;

    /* renamed from: j  reason: collision with root package name */
    public f f10932j;
    public boolean k;
    public Map<String, String> l;
    public c.a.o0.h.a.f.d m;
    public c.a.o0.f.i.i.f n;
    @V8JavascriptField
    public c style;

    /* renamed from: c.a.o0.h.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0550a implements c.a.o0.f.i.i.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f10933a;

        public C0550a(a aVar) {
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
            this.f10933a = aVar;
        }

        @Override // c.a.o0.f.i.i.f
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.f10933a.dispatchEvent(new JSEvent("load"));
                    c.a.o0.h.a.c.b(this.f10933a.k ? "gdtbanner" : "banner", "success");
                    return;
                }
                c.a.o0.h.a.c.c(this.f10933a.k ? "gdtbanner" : "banner", com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
            }
        }

        @Override // c.a.o0.f.i.i.f
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                JSEvent jSEvent = new JSEvent("resize");
                jSEvent.data = c.a.o0.h.a.e.b.b(i2, i3);
                this.f10933a.dispatchEvent(jSEvent);
            }
        }

        @Override // c.a.o0.f.i.i.f
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f10933a.k) {
                c.a.o0.h.a.c.b("gdtbanner", PrefetchEvent.STATE_CLICK);
            }
        }

        @Override // c.a.o0.f.i.i.f
        public void onClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f10933a.destroy();
                c.a.o0.h.m0.d A = c.a.o0.h.m0.d.A();
                String str = this.f10933a.adUnitId;
                A.K(str, "" + System.currentTimeMillis());
                c.a.o0.h.a.c.b(this.f10933a.k ? "gdtbanner" : "banner", IntentConfig.CLOSE);
            }
        }

        @Override // c.a.o0.f.i.i.f
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = c.a.o0.h.a.e.b.a(str);
                this.f10933a.dispatchEvent(jSEvent);
                c.a.o0.f.i.q.b.k(this.f10933a.l, str);
            }
        }

        @Override // c.a.o0.f.i.i.f
        public void onShow(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || this.f10933a.m == null) {
                return;
            }
            if (z) {
                this.f10933a.m.c();
            } else {
                this.f10933a.m.b("3010010");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10934e;

        public b(a aVar) {
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
            this.f10934e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = c.a.o0.h.a.e.b.a(this.f10934e.f10929g);
                this.f10934e.dispatchEvent(jSEvent);
                c.a.o0.f.i.q.b.k(this.f10934e.l, this.f10934e.f10929g);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.o0.a.l0.c cVar, JsObject jsObject) {
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
        this.style = null;
        this.l = new TreeMap();
        this.n = new C0550a(this);
        this.f10928f = cVar;
        c.a.o0.a.y.b.a G = c.a.o0.a.y.b.a.G(jsObject);
        if (G != null) {
            this.adUnitId = G.C("adUnitId");
            this.f10927e = G.C("appSid");
            c.a.o0.a.y.b.a x = G.x("style");
            if (x != null) {
                this.style = new c(x);
            }
        }
        boolean e2 = i.e();
        this.k = e2;
        if (e2) {
            this.f10927e = i.a();
            this.adUnitId = i.b();
        }
        Map<String, String> a2 = c.a.o0.f.i.q.b.a("banner", "game", this.f10927e, this.adUnitId, this.k);
        this.l = a2;
        c.a.o0.f.i.q.b.m("loadApi", a2);
        if (B()) {
            if (G != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.f10927e) && this.style != null) {
                c.a.o0.h.a.a aVar = new c.a.o0.h.a.a();
                this.f10932j = aVar;
                c.a.o0.f.i.i.b bVar = new c.a.o0.f.i.i.b(this.f10927e, this.adUnitId, this.n, aVar);
                this.f10931i = bVar;
                bVar.F(this.l);
                c cVar2 = this.style;
                if (cVar2 != null) {
                    this.f10931i.E(cVar2.left, cVar2.top, cVar2.width, cVar2.height);
                    this.style.b(this);
                }
                c.a.o0.h.a.c.b(this.k ? "gdtbanner" : "banner", null);
                return;
            }
            cVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
        }
    }

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.f10929g)) {
                c.a.o0.h.m0.d A = c.a.o0.h.m0.d.A();
                if (!A.k()) {
                    if (!A.l()) {
                        if (A.t(this.adUnitId)) {
                            this.f10929g = "3010011";
                        }
                    } else {
                        this.f10929g = "3010013";
                    }
                } else {
                    this.f10929g = "3010012";
                }
            }
            if (TextUtils.isEmpty(this.f10929g)) {
                return true;
            }
            this.f10928f.postOnJSThread(new b(this));
            c.a.o0.h.a.c.c("banner", "reject", this.f10929g);
            return false;
        }
        return invokeV.booleanValue;
    }

    @JavascriptInterface
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f10930h = true;
            removeEventListener("error", null);
            removeEventListener("load", null);
            removeEventListener("resize", null);
            c.a.o0.f.i.i.b bVar = this.f10931i;
            if (bVar != null) {
                bVar.y();
                this.f10931i = null;
            }
        }
    }

    @JavascriptInterface
    public void hide() {
        c.a.o0.f.i.i.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bVar = this.f10931i) == null) {
            return;
        }
        bVar.B();
    }

    @Override // c.a.o0.h.a.e.c.a
    public void i(String str) {
        c.a.o0.f.i.i.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f10930h || TextUtils.isEmpty(str) || str.equals("height") || this.style == null || (bVar = this.f10931i) == null) {
            return;
        }
        bVar.H(str);
    }

    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) {
            c.a.o0.h.a.c.d(this.k ? "gdtbanner" : "banner");
            c.a.o0.f.i.q.b.m("showApi", this.l);
            if (!B() || this.f10931i == null) {
                return;
            }
            c.a.o0.h.m0.d.A().E();
            this.m = c.a.o0.h.a.f.d.d(c.a.o0.a.y.b.a.G(jsObject));
            this.f10931i.G(jsObject);
        }
    }
}
