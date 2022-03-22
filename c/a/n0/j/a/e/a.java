package c.a.n0.j.a.e;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import c.a.n0.h.a.a.f;
import c.a.n0.h.a.e.g;
import c.a.n0.h.a.k.i;
import c.a.n0.j.a.e.c;
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
    public String a;
    @V8JavascriptField
    public String adUnitId;

    /* renamed from: b  reason: collision with root package name */
    public c.a.n0.a.b0.c f8561b;

    /* renamed from: c  reason: collision with root package name */
    public String f8562c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8563d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.n0.h.a.a.b f8564e;

    /* renamed from: f  reason: collision with root package name */
    public g f8565f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f8566g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f8567h;
    public c.a.n0.j.a.f.d i;
    public f j;
    @V8JavascriptField
    public c style;

    /* renamed from: c.a.n0.j.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0683a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0683a(a aVar) {
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

        @Override // c.a.n0.h.a.a.f
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.dispatchEvent(new JSEvent("load"));
                    c.a.n0.j.a.c.b(this.a.f8566g ? "gdtbanner" : SpeedStatsUtils.UBC_VALUE_BANNER, "success");
                    return;
                }
                c.a.n0.j.a.c.c(this.a.f8566g ? "gdtbanner" : SpeedStatsUtils.UBC_VALUE_BANNER, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
            }
        }

        @Override // c.a.n0.h.a.a.f
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.a.i == null) {
                return;
            }
            if (z) {
                this.a.i.c();
            } else {
                this.a.i.b("3010010");
            }
        }

        @Override // c.a.n0.h.a.a.f
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
                JSEvent jSEvent = new JSEvent("resize");
                jSEvent.data = c.a.n0.j.a.e.b.b(i, i2);
                this.a.dispatchEvent(jSEvent);
            }
        }

        @Override // c.a.n0.h.a.a.f
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.f8566g) {
                c.a.n0.j.a.c.b("gdtbanner", "click");
            }
        }

        @Override // c.a.n0.h.a.a.f
        public void onClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a.destroy();
                c.a.n0.j.n0.d A = c.a.n0.j.n0.d.A();
                String str = this.a.adUnitId;
                A.K(str, "" + System.currentTimeMillis());
                c.a.n0.j.a.c.b(this.a.f8566g ? "gdtbanner" : SpeedStatsUtils.UBC_VALUE_BANNER, IntentConfig.CLOSE);
            }
        }

        @Override // c.a.n0.h.a.a.f
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = c.a.n0.j.a.e.b.a(str);
                this.a.dispatchEvent(jSEvent);
                c.a.n0.h.a.j.b.k(this.a.f8567h, str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = c.a.n0.j.a.e.b.a(this.a.f8562c);
                this.a.dispatchEvent(jSEvent);
                c.a.n0.h.a.j.b.k(this.a.f8567h, this.a.f8562c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.n0.a.b0.c cVar, JsObject jsObject) {
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
        this.style = null;
        this.f8567h = new TreeMap();
        this.j = new C0683a(this);
        this.f8561b = cVar;
        c.a.n0.a.o.b.a F = c.a.n0.a.o.b.a.F(jsObject);
        if (F != null) {
            this.adUnitId = F.B("adUnitId");
            this.a = F.B("appSid");
            c.a.n0.a.o.b.a w = F.w("style");
            if (w != null) {
                this.style = new c(w);
            }
        }
        boolean e2 = i.e();
        this.f8566g = e2;
        if (e2) {
            this.a = i.a();
            this.adUnitId = i.b();
        }
        String str = this.a;
        String str2 = this.adUnitId;
        boolean z = this.f8566g;
        String str3 = SpeedStatsUtils.UBC_VALUE_BANNER;
        Map<String, String> a = c.a.n0.h.a.j.b.a(SpeedStatsUtils.UBC_VALUE_BANNER, "game", str, str2, z);
        this.f8567h = a;
        c.a.n0.h.a.j.b.m("loadApi", a);
        if (C()) {
            if (F != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.a) && this.style != null) {
                c.a.n0.j.a.a aVar = new c.a.n0.j.a.a();
                this.f8565f = aVar;
                c.a.n0.h.a.a.b bVar = new c.a.n0.h.a.a.b(this.a, this.adUnitId, this.j, aVar);
                this.f8564e = bVar;
                bVar.F(this.f8567h);
                c cVar2 = this.style;
                if (cVar2 != null) {
                    this.f8564e.E(cVar2.left, cVar2.top, cVar2.width, cVar2.height);
                    this.style.b(this);
                }
                c.a.n0.j.a.c.b(this.f8566g ? "gdtbanner" : str3, null);
                return;
            }
            cVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
        }
    }

    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.f8562c)) {
                c.a.n0.j.n0.d A = c.a.n0.j.n0.d.A();
                if (!A.k()) {
                    if (!A.l()) {
                        if (A.t(this.adUnitId)) {
                            this.f8562c = "3010011";
                        }
                    } else {
                        this.f8562c = "3010013";
                    }
                } else {
                    this.f8562c = "3010012";
                }
            }
            if (TextUtils.isEmpty(this.f8562c)) {
                return true;
            }
            this.f8561b.postOnJSThread(new b(this));
            c.a.n0.j.a.c.c(SpeedStatsUtils.UBC_VALUE_BANNER, "reject", this.f8562c);
            return false;
        }
        return invokeV.booleanValue;
    }

    @JavascriptInterface
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f8563d = true;
            removeEventListener("error", null);
            removeEventListener("load", null);
            removeEventListener("resize", null);
            c.a.n0.h.a.a.b bVar = this.f8564e;
            if (bVar != null) {
                bVar.y();
                this.f8564e = null;
            }
        }
    }

    @JavascriptInterface
    public void hide() {
        c.a.n0.h.a.a.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bVar = this.f8564e) == null) {
            return;
        }
        bVar.B();
    }

    @Override // c.a.n0.j.a.e.c.a
    public void j(String str) {
        c.a.n0.h.a.a.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f8563d || TextUtils.isEmpty(str) || str.equals("height") || this.style == null || (bVar = this.f8564e) == null) {
            return;
        }
        bVar.H(str);
    }

    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) {
            c.a.n0.j.a.c.d(this.f8566g ? "gdtbanner" : SpeedStatsUtils.UBC_VALUE_BANNER);
            c.a.n0.h.a.j.b.m("showApi", this.f8567h);
            if (!C() || this.f8564e == null) {
                return;
            }
            c.a.n0.j.n0.d.A().E();
            this.i = c.a.n0.j.a.f.d.d(c.a.n0.a.o.b.a.F(jsObject));
            this.f8564e.G(jsObject);
        }
    }
}
