package b.a.p0.h.a.e;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import b.a.p0.f.i.l.f;
import b.a.p0.f.i.r.i;
import b.a.p0.h.a.e.c;
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
/* loaded from: classes4.dex */
public class a extends EventTargetImpl implements d, c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @V8JavascriptField
    public String adUnitId;

    /* renamed from: e  reason: collision with root package name */
    public String f10169e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.p0.a.l0.c f10170f;

    /* renamed from: g  reason: collision with root package name */
    public String f10171g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f10172h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.p0.f.i.i.b f10173i;
    public f j;
    public boolean k;
    public Map<String, String> l;
    public b.a.p0.h.a.f.d m;
    public b.a.p0.f.i.i.f n;
    @V8JavascriptField
    public c style;

    /* renamed from: b.a.p0.h.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0547a implements b.a.p0.f.i.i.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f10174a;

        public C0547a(a aVar) {
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
            this.f10174a = aVar;
        }

        @Override // b.a.p0.f.i.i.f
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.f10174a.dispatchEvent(new JSEvent("load"));
                    b.a.p0.h.a.c.b(this.f10174a.k ? "gdtbanner" : "banner", "success");
                    return;
                }
                b.a.p0.h.a.c.c(this.f10174a.k ? "gdtbanner" : "banner", com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
            }
        }

        @Override // b.a.p0.f.i.i.f
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                JSEvent jSEvent = new JSEvent("resize");
                jSEvent.data = b.a.p0.h.a.e.b.b(i2, i3);
                this.f10174a.dispatchEvent(jSEvent);
            }
        }

        @Override // b.a.p0.f.i.i.f
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f10174a.k) {
                b.a.p0.h.a.c.b("gdtbanner", PrefetchEvent.STATE_CLICK);
            }
        }

        @Override // b.a.p0.f.i.i.f
        public void onClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f10174a.destroy();
                b.a.p0.h.m0.d A = b.a.p0.h.m0.d.A();
                String str = this.f10174a.adUnitId;
                A.K(str, "" + System.currentTimeMillis());
                b.a.p0.h.a.c.b(this.f10174a.k ? "gdtbanner" : "banner", IntentConfig.CLOSE);
            }
        }

        @Override // b.a.p0.f.i.i.f
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = b.a.p0.h.a.e.b.a(str);
                this.f10174a.dispatchEvent(jSEvent);
                b.a.p0.f.i.q.b.k(this.f10174a.l, str);
            }
        }

        @Override // b.a.p0.f.i.i.f
        public void onShow(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || this.f10174a.m == null) {
                return;
            }
            if (z) {
                this.f10174a.m.c();
            } else {
                this.f10174a.m.b("3010010");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10175e;

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
            this.f10175e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = b.a.p0.h.a.e.b.a(this.f10175e.f10171g);
                this.f10175e.dispatchEvent(jSEvent);
                b.a.p0.f.i.q.b.k(this.f10175e.l, this.f10175e.f10171g);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b.a.p0.a.l0.c cVar, JsObject jsObject) {
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
        this.n = new C0547a(this);
        this.f10170f = cVar;
        b.a.p0.a.y.b.a F = b.a.p0.a.y.b.a.F(jsObject);
        if (F != null) {
            this.adUnitId = F.B("adUnitId");
            this.f10169e = F.B("appSid");
            b.a.p0.a.y.b.a w = F.w("style");
            if (w != null) {
                this.style = new c(w);
            }
        }
        boolean e2 = i.e();
        this.k = e2;
        if (e2) {
            this.f10169e = i.a();
            this.adUnitId = i.b();
        }
        Map<String, String> a2 = b.a.p0.f.i.q.b.a("banner", "game", this.f10169e, this.adUnitId, this.k);
        this.l = a2;
        b.a.p0.f.i.q.b.m("loadApi", a2);
        if (A()) {
            if (F != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.f10169e) && this.style != null) {
                b.a.p0.h.a.a aVar = new b.a.p0.h.a.a();
                this.j = aVar;
                b.a.p0.f.i.i.b bVar = new b.a.p0.f.i.i.b(this.f10169e, this.adUnitId, this.n, aVar);
                this.f10173i = bVar;
                bVar.F(this.l);
                c cVar2 = this.style;
                if (cVar2 != null) {
                    this.f10173i.E(cVar2.left, cVar2.top, cVar2.width, cVar2.height);
                    this.style.b(this);
                }
                b.a.p0.h.a.c.b(this.k ? "gdtbanner" : "banner", null);
                return;
            }
            cVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
        }
    }

    public final boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.f10171g)) {
                b.a.p0.h.m0.d A = b.a.p0.h.m0.d.A();
                if (!A.k()) {
                    if (!A.l()) {
                        if (A.t(this.adUnitId)) {
                            this.f10171g = "3010011";
                        }
                    } else {
                        this.f10171g = "3010013";
                    }
                } else {
                    this.f10171g = "3010012";
                }
            }
            if (TextUtils.isEmpty(this.f10171g)) {
                return true;
            }
            this.f10170f.postOnJSThread(new b(this));
            b.a.p0.h.a.c.c("banner", "reject", this.f10171g);
            return false;
        }
        return invokeV.booleanValue;
    }

    @JavascriptInterface
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f10172h = true;
            removeEventListener("error", null);
            removeEventListener("load", null);
            removeEventListener("resize", null);
            b.a.p0.f.i.i.b bVar = this.f10173i;
            if (bVar != null) {
                bVar.y();
                this.f10173i = null;
            }
        }
    }

    @Override // b.a.p0.h.a.e.c.a
    public void h(String str) {
        b.a.p0.f.i.i.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f10172h || TextUtils.isEmpty(str) || str.equals("height") || this.style == null || (bVar = this.f10173i) == null) {
            return;
        }
        bVar.H(str);
    }

    @JavascriptInterface
    public void hide() {
        b.a.p0.f.i.i.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bVar = this.f10173i) == null) {
            return;
        }
        bVar.B();
    }

    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) {
            b.a.p0.h.a.c.d(this.k ? "gdtbanner" : "banner");
            b.a.p0.f.i.q.b.m("showApi", this.l);
            if (!A() || this.f10173i == null) {
                return;
            }
            b.a.p0.h.m0.d.A().E();
            this.m = b.a.p0.h.a.f.d.d(b.a.p0.a.y.b.a.F(jsObject));
            this.f10173i.G(jsObject);
        }
    }
}
