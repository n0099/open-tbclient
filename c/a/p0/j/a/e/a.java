package c.a.p0.j.a.e;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import c.a.p0.h.a.a.f;
import c.a.p0.h.a.e.g;
import c.a.p0.h.a.k.i;
import c.a.p0.j.a.e.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
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
public class a extends EventTargetImpl implements d, c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @V8JavascriptField
    public String adUnitId;

    /* renamed from: e  reason: collision with root package name */
    public String f10228e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.a.b0.c f10229f;

    /* renamed from: g  reason: collision with root package name */
    public String f10230g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f10231h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.h.a.a.b f10232i;

    /* renamed from: j  reason: collision with root package name */
    public g f10233j;
    public boolean k;
    public Map<String, String> l;
    public c.a.p0.j.a.f.d m;
    public f n;
    @V8JavascriptField
    public c style;

    /* renamed from: c.a.p0.j.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0689a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0689a(a aVar) {
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
            this.a = aVar;
        }

        @Override // c.a.p0.h.a.a.f
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.dispatchEvent(new JSEvent("load"));
                    c.a.p0.j.a.c.b(this.a.k ? "gdtbanner" : SpeedStatsUtils.UBC_VALUE_BANNER, "success");
                    return;
                }
                c.a.p0.j.a.c.c(this.a.k ? "gdtbanner" : SpeedStatsUtils.UBC_VALUE_BANNER, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
            }
        }

        @Override // c.a.p0.h.a.a.f
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.a.m == null) {
                return;
            }
            if (z) {
                this.a.m.c();
            } else {
                this.a.m.b("3010010");
            }
        }

        @Override // c.a.p0.h.a.a.f
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
                JSEvent jSEvent = new JSEvent("resize");
                jSEvent.data = c.a.p0.j.a.e.b.b(i2, i3);
                this.a.dispatchEvent(jSEvent);
            }
        }

        @Override // c.a.p0.h.a.a.f
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.k) {
                c.a.p0.j.a.c.b("gdtbanner", "click");
            }
        }

        @Override // c.a.p0.h.a.a.f
        public void onClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a.destroy();
                c.a.p0.j.n0.d A = c.a.p0.j.n0.d.A();
                String str = this.a.adUnitId;
                A.K(str, "" + System.currentTimeMillis());
                c.a.p0.j.a.c.b(this.a.k ? "gdtbanner" : SpeedStatsUtils.UBC_VALUE_BANNER, IntentConfig.CLOSE);
            }
        }

        @Override // c.a.p0.h.a.a.f
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = c.a.p0.j.a.e.b.a(str);
                this.a.dispatchEvent(jSEvent);
                c.a.p0.h.a.j.b.k(this.a.l, str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10234e;

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
            this.f10234e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = c.a.p0.j.a.e.b.a(this.f10234e.f10230g);
                this.f10234e.dispatchEvent(jSEvent);
                c.a.p0.h.a.j.b.k(this.f10234e.l, this.f10234e.f10230g);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.p0.a.b0.c cVar, JsObject jsObject) {
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
        this.n = new C0689a(this);
        this.f10229f = cVar;
        c.a.p0.a.o.b.a F = c.a.p0.a.o.b.a.F(jsObject);
        if (F != null) {
            this.adUnitId = F.B("adUnitId");
            this.f10228e = F.B("appSid");
            c.a.p0.a.o.b.a w = F.w("style");
            if (w != null) {
                this.style = new c(w);
            }
        }
        boolean e2 = i.e();
        this.k = e2;
        if (e2) {
            this.f10228e = i.a();
            this.adUnitId = i.b();
        }
        String str = this.f10228e;
        String str2 = this.adUnitId;
        boolean z = this.k;
        String str3 = SpeedStatsUtils.UBC_VALUE_BANNER;
        Map<String, String> a = c.a.p0.h.a.j.b.a(SpeedStatsUtils.UBC_VALUE_BANNER, "game", str, str2, z);
        this.l = a;
        c.a.p0.h.a.j.b.m("loadApi", a);
        if (B()) {
            if (F != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.f10228e) && this.style != null) {
                c.a.p0.j.a.a aVar = new c.a.p0.j.a.a();
                this.f10233j = aVar;
                c.a.p0.h.a.a.b bVar = new c.a.p0.h.a.a.b(this.f10228e, this.adUnitId, this.n, aVar);
                this.f10232i = bVar;
                bVar.F(this.l);
                c cVar2 = this.style;
                if (cVar2 != null) {
                    this.f10232i.E(cVar2.left, cVar2.top, cVar2.width, cVar2.height);
                    this.style.b(this);
                }
                c.a.p0.j.a.c.b(this.k ? "gdtbanner" : str3, null);
                return;
            }
            cVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
        }
    }

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.f10230g)) {
                c.a.p0.j.n0.d A = c.a.p0.j.n0.d.A();
                if (!A.k()) {
                    if (!A.l()) {
                        if (A.t(this.adUnitId)) {
                            this.f10230g = "3010011";
                        }
                    } else {
                        this.f10230g = "3010013";
                    }
                } else {
                    this.f10230g = "3010012";
                }
            }
            if (TextUtils.isEmpty(this.f10230g)) {
                return true;
            }
            this.f10229f.postOnJSThread(new b(this));
            c.a.p0.j.a.c.c(SpeedStatsUtils.UBC_VALUE_BANNER, "reject", this.f10230g);
            return false;
        }
        return invokeV.booleanValue;
    }

    @JavascriptInterface
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f10231h = true;
            removeEventListener("error", null);
            removeEventListener("load", null);
            removeEventListener("resize", null);
            c.a.p0.h.a.a.b bVar = this.f10232i;
            if (bVar != null) {
                bVar.y();
                this.f10232i = null;
            }
        }
    }

    @JavascriptInterface
    public void hide() {
        c.a.p0.h.a.a.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bVar = this.f10232i) == null) {
            return;
        }
        bVar.B();
    }

    @Override // c.a.p0.j.a.e.c.a
    public void i(String str) {
        c.a.p0.h.a.a.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f10231h || TextUtils.isEmpty(str) || str.equals("height") || this.style == null || (bVar = this.f10232i) == null) {
            return;
        }
        bVar.H(str);
    }

    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) {
            c.a.p0.j.a.c.d(this.k ? "gdtbanner" : SpeedStatsUtils.UBC_VALUE_BANNER);
            c.a.p0.h.a.j.b.m("showApi", this.l);
            if (!B() || this.f10232i == null) {
                return;
            }
            c.a.p0.j.n0.d.A().E();
            this.m = c.a.p0.j.a.f.d.d(c.a.p0.a.o.b.a.F(jsObject));
            this.f10232i.G(jsObject);
        }
    }
}
