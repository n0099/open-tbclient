package c.a.n0.j.d;

import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.b0.c;
import c.a.n0.a.f.b.a.k;
import c.a.n0.a.h0.e;
import c.a.n0.j.a0.d;
import c.a.n0.j.c.g;
import c.a.n0.j.c.h;
import c.a.n0.j.f.f;
import c.a.n0.j.l0.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.games.view.desktopguide.DesktopGuideApi;
import com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy;
import com.baidu.tieba.account.AccountRestoreActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class b extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean u;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* renamed from: b  reason: collision with root package name */
    public e f8681b;

    /* renamed from: c  reason: collision with root package name */
    public d f8682c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.n0.j.a0.b f8683d;
    @V8JavascriptField
    public final String domain;

    /* renamed from: e  reason: collision with root package name */
    public JsObject f8684e;
    @V8JavascriptField
    public c.a.n0.a.h0.a env;

    /* renamed from: f  reason: collision with root package name */
    public c.a.n0.j.a0.e f8685f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.n0.j.v.a f8686g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.n0.j.v.b f8687h;
    public c.a.n0.j.h0.b i;
    public c.a.n0.j.m0.d j;
    public c.a.n0.j.a.f.b k;
    public c.a.n0.j.z.h.a l;
    public f m;
    public c.a.n0.j.e0.a n;
    public DesktopGuideApi o;
    public c.a.n0.j.c0.a p;
    public c.a.n0.j.p0.h.a q;
    public c.a.n0.j.b.b r;
    public c.a.n0.j.i.a s;
    public c.a.n0.j.b0.a t;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1781568336, "Lc/a/n0/j/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1781568336, "Lc/a/n0/j/d/b;");
                return;
            }
        }
        u = c.a.n0.a.a.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.domain = "main";
        this.f8684e = null;
        this.f8685f = null;
        this.f8686g = null;
        this.f8687h = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.a = cVar;
        this.env = new c.a.n0.a.h0.a();
        z();
    }

    public void A(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) {
            this.f8684e = jsObject;
        }
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            c.a.n0.j.l.a.b(jsObject);
        }
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            if (this.f8683d == null) {
                this.f8683d = new c.a.n0.j.a0.b(this.a);
            }
            this.f8683d.checkIsUserAdvisedToRest(jsObject);
        }
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            y().h(jsObject);
        }
    }

    @JavascriptInterface
    public void clearStorageSync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.n0.j.h0.f.d.a(this.a, "clearStorageSync", "", y().a());
        }
    }

    @JavascriptInterface
    public c.a.n0.j.z.h.c connectSocket(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jsObject)) == null) {
            if (this.l == null) {
                this.l = new c.a.n0.j.z.h.a(this.a);
            }
            return this.l.a(jsObject);
        }
        return (c.a.n0.j.z.h.c) invokeL.objValue;
    }

    @JavascriptInterface
    public c.a.n0.j.a.e.d createBannerAd(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jsObject)) == null) ? new c.a.n0.j.a.e.a(this.a, jsObject) : (c.a.n0.j.a.e.d) invokeL.objValue;
    }

    @JavascriptInterface
    public g createInnerAudioContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new g(this.a) : (g) invokeV.objValue;
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, jsObject)) == null) ? new RecommendButtonApiProxy(this.a, jsObject) : (RecommendButtonApiProxy) invokeL.objValue;
    }

    @JavascriptInterface
    public c.a.n0.j.a.f.b createRewardedVideoAd(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, jsObject)) == null) {
            if (this.k == null) {
                this.k = new c.a.n0.j.a.f.e(this.a, jsObject);
            }
            return this.k;
        }
        return (c.a.n0.j.a.f.b) invokeL.objValue;
    }

    @JavascriptInterface
    public c.a.n0.j.l0.g createUDPSocket() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? j.f8810c.b(this.a) : (c.a.n0.j.l0.g) invokeV.objValue;
    }

    @JavascriptInterface
    public c.a.n0.j.p0.d.b.b createUserInfoButton(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, jsObject)) == null) ? new c.a.n0.j.p0.d.b.b(jsObject, this.a) : (c.a.n0.j.p0.d.b.b) invokeL.objValue;
    }

    @JavascriptInterface
    public c.a.n0.j.z.d.b downloadFile(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, jsObject)) == null) {
            c.a.n0.a.o.b.a F = c.a.n0.a.o.b.a.F(jsObject);
            c.a.n0.j.z.a d2 = c.a.n0.j.z.e.b.b().d(this.a, F, 2);
            if (d2 instanceof c.a.n0.j.z.d.b) {
                c.a.n0.j.z.d.b bVar = (c.a.n0.j.z.d.b) d2;
                bVar.I(F);
                return bVar;
            }
            c.a.n0.j.z.d.b bVar2 = new c.a.n0.j.z.d.b(this.a, F);
            bVar2.start();
            return bVar2;
        }
        return (c.a.n0.j.z.d.b) invokeL.objValue;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jsObject) == null) {
            if (u) {
                this.a.A().b("exit from java side.");
            }
            if (jsObject == null) {
                return;
            }
            c.a.n0.j.d.c.b bVar = new c.a.n0.j.d.c.b();
            c.a.n0.j.d.c.a e2 = c.a.n0.j.d.c.a.e(c.a.n0.a.o.b.a.F(jsObject));
            SwanAppActivity activity = c.a.n0.a.w0.f.U().getActivity();
            if (activity == null) {
                bVar.errMsg = String.format("%s:%s", AccountRestoreActivity.JS_PROMPT_ACCOUNT_METHOD_EXIT, "failed");
                e2.b(bVar);
                return;
            }
            bVar.errMsg = String.format("%s:%s", AccountRestoreActivity.JS_PROMPT_ACCOUNT_METHOD_EXIT, "ok");
            e2.d(bVar);
            activity.finishAndRemoveTask();
        }
    }

    @JavascriptInterface
    public void exitVoIPChat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) {
            if (this.t == null) {
                this.t = c.a.n0.j.b0.b.a.a();
            }
            this.t.d(jsObject);
        }
    }

    @JavascriptInterface
    public String getAPIs(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            if (u) {
                return c.a.n0.a.n1.a.a.p() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "";
            }
            return SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i);
        }
        return (String) invokeI.objValue;
    }

    @JavascriptInterface
    public c.a.n0.j.b.b getAntiAddiction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.r == null) {
                this.r = new c.a.n0.j.b.b(this.a);
            }
            return this.r;
        }
        return (c.a.n0.j.b.b) invokeV.objValue;
    }

    @JavascriptInterface
    public c.a.n0.j.i.a getDownloadApp(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, jsObject)) == null) {
            if (this.s == null) {
                this.s = new c.a.n0.j.i.a(this.a, c.a.n0.a.o.b.a.F(jsObject));
            }
            return this.s;
        }
        return (c.a.n0.j.i.a) invokeL.objValue;
    }

    @JavascriptInterface
    public String getEnvVariables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? c.a.n0.a.t0.b.b.a(this.a) : (String) invokeV.objValue;
    }

    @JavascriptInterface
    public e getFileSystemManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.f8681b == null) {
                this.f8681b = new e((c.a.n0.a.b0.a) this.a);
            }
            return this.f8681b;
        }
        return (e) invokeV.objValue;
    }

    @JavascriptInterface
    public d getOpenData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.f8682c == null) {
                this.f8682c = new d((c.a.n0.a.b0.a) this.a);
            }
            return this.f8682c;
        }
        return (d) invokeV.objValue;
    }

    @JavascriptInterface
    public c.a.n0.j.a0.e getOpenDataContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.f8685f == null) {
                c.a.n0.j.a0.e eVar = new c.a.n0.j.a0.e(this.a);
                this.f8685f = eVar;
                eVar.canvas = this.f8684e;
                this.f8684e = null;
            }
            return this.f8685f;
        }
        return (c.a.n0.j.a0.e) invokeV.objValue;
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, jsObject) == null) {
            y().k(jsObject);
        }
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, jsObject) == null) {
            y().l(jsObject);
        }
    }

    @JavascriptInterface
    public c.a.n0.j.h0.f.c getStorageInfoSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? y().b() : (c.a.n0.j.h0.f.c) invokeV.objValue;
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) ? c.a.n0.j.h0.f.d.a(this.a, "getStorageSync", str, y().c(str)) : invokeL.objValue;
    }

    @JavascriptInterface
    public void getSwanGameDuration(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, jsObject) == null) {
            c.a.n0.j.j.a.a(jsObject);
        }
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, jsObject) == null) {
            c.a.n0.j.o0.a.d(jsObject);
        }
    }

    @JavascriptInterface
    public c.a.n0.j.m0.d getUpdateManager(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, jsObject)) == null) {
            if (this.j == null) {
                this.j = new c.a.n0.j.m0.d(jsObject);
            }
            return this.j;
        }
        return (c.a.n0.j.m0.d) invokeL.objValue;
    }

    @JavascriptInterface
    public c.a.n0.j.e0.a getVideoRecorderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.n == null) {
                this.n = new c.a.n0.j.e0.a(this.a);
            }
            return this.n;
        }
        return (c.a.n0.j.e0.a) invokeV.objValue;
    }

    @JavascriptInterface
    public c.a.n0.j.p0.h.a getWebViewManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.q == null) {
                this.q = new c.a.n0.j.p0.h.a(this.a);
            }
            return this.q;
        }
        return (c.a.n0.j.p0.h.a) invokeV.objValue;
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        c.a.n0.j.v.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, jsObject) == null) || (aVar = this.f8686g) == null) {
            return;
        }
        aVar.k(jsObject);
    }

    @JavascriptInterface
    public void joinVoIPChat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, jsObject) == null) {
            if (this.t == null) {
                this.t = c.a.n0.j.b0.b.a.a();
            }
            this.t.b(jsObject);
        }
    }

    @JavascriptInterface
    public c.a.n0.j.j0.c loadSubpackage(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, jsObject)) == null) {
            c.a.n0.j.j0.c cVar = new c.a.n0.j.j0.c(this.a);
            cVar.F(jsObject);
            return cVar;
        }
        return (c.a.n0.j.j0.c) invokeL.objValue;
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        k F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, jsObject) == null) || (F = c.a.n0.a.w0.f.U().F()) == null) {
            return;
        }
        F.a(c.a.n0.a.o.b.a.F(jsObject));
    }

    @JavascriptInterface
    public void offVoIPChatInterrupted(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, jsObject) == null) {
            if (this.t == null) {
                this.t = c.a.n0.j.b0.b.a.a();
            }
            this.t.a(jsObject);
        }
    }

    @JavascriptInterface
    public void offVoIPChatMembersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, jsObject) == null) {
            if (this.t == null) {
                this.t = c.a.n0.j.b0.b.a.a();
            }
            this.t.g(jsObject);
        }
    }

    @JavascriptInterface
    public void offVoIPChatSpeakersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, jsObject) == null) {
            if (this.t == null) {
                this.t = c.a.n0.j.b0.b.a.a();
            }
            this.t.i(jsObject);
        }
    }

    @JavascriptInterface
    public void onVoIPChatInterrupted(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, jsObject) == null) {
            if (this.t == null) {
                this.t = c.a.n0.j.b0.b.a.a();
            }
            this.t.c(jsObject);
        }
    }

    @JavascriptInterface
    public void onVoIPChatMembersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, jsObject) == null) {
            if (this.t == null) {
                this.t = c.a.n0.j.b0.b.a.a();
            }
            this.t.h(jsObject);
        }
    }

    @JavascriptInterface
    public void onVoIPChatSpeakersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, jsObject) == null) {
            if (this.t == null) {
                this.t = c.a.n0.j.b0.b.a.a();
            }
            this.t.k(jsObject);
        }
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, jsObject) == null) {
            c.a.n0.j.g.a.a((b) this.a.p(), jsObject);
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, jsObject) == null) {
            if (this.p == null) {
                this.p = new c.a.n0.j.c0.a();
            }
            this.p.d(jsObject);
        }
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, jsObject) == null) {
            y().o(jsObject);
        }
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            c.a.n0.j.h0.f.d.a(this.a, "removeStorageSync", str, y().e(str));
        }
    }

    @JavascriptInterface
    public c.a.n0.j.z.f.c request(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, jsObject)) == null) {
            c.a.n0.a.o.b.a F = c.a.n0.a.o.b.a.F(jsObject);
            c.a.n0.j.z.a d2 = c.a.n0.j.z.e.b.b().d(this.a, F, 1);
            if (d2 instanceof c.a.n0.j.z.f.c) {
                c.a.n0.j.z.f.c cVar = (c.a.n0.j.z.f.c) d2;
                cVar.I(F);
                return cVar;
            }
            c.a.n0.j.z.f.c cVar2 = new c.a.n0.j.z.f.c(this.a, F);
            cVar2.start();
            return cVar2;
        }
        return (c.a.n0.j.z.f.c) invokeL.objValue;
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, jsObject) == null) {
            if (this.m == null) {
                this.m = new f(this.a);
            }
            this.m.i(jsObject);
        }
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, jsObject) == null) {
            new h(jsObject);
        }
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{Short.valueOf(s)}) == null) || s < 1 || s > 60) {
            return;
        }
        this.a.setPreferredFramesPerSecond(s);
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, jsObject) == null) {
            y().p(jsObject);
        }
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048630, this, str, jsSerializeValue) == null) {
            c.a.n0.j.h0.f.d.a(this.a, "setStorageSync", str, y().f(str, jsSerializeValue));
        }
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, jsObject) == null) {
            new c.a.n0.j.f0.b.a(jsObject).m();
        }
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, jsObject) == null) {
            if (this.o == null) {
                this.o = new DesktopGuideApi(this.a);
            }
            this.o.v(jsObject);
        }
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, jsObject) == null) {
            if (this.f8686g == null) {
                this.f8686g = new c.a.n0.j.v.a(this.a, this.f8687h);
            }
            this.f8686g.l(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        c.a.n0.j.v.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048637, this, jsObject) == null) || (aVar = this.f8686g) == null) {
            return;
        }
        aVar.m(jsObject);
    }

    @JavascriptInterface
    public void updateVoIPChatMuteConfig(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, jsObject) == null) {
            if (this.t == null) {
                this.t = c.a.n0.j.b0.b.a.a();
            }
            this.t.e(jsObject);
        }
    }

    @JavascriptInterface
    public c.a.n0.j.z.g.b uploadFile(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, jsObject)) == null) {
            c.a.n0.j.z.g.b bVar = new c.a.n0.j.z.g.b(this.a, c.a.n0.a.o.b.a.F(jsObject));
            bVar.start();
            return bVar;
        }
        return (c.a.n0.j.z.g.b) invokeL.objValue;
    }

    @NonNull
    public final c.a.n0.j.h0.b y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            if (this.i == null) {
                this.i = new c.a.n0.j.h0.b(this.a);
            }
            return this.i;
        }
        return (c.a.n0.j.h0.b) invokeV.objValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            this.f8687h = new c.a.n0.j.v.b(this.a);
        }
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? createRecommendationButton(null) : (RecommendButtonApiProxy) invokeV.objValue;
    }

    @JavascriptInterface
    public void hideKeyboard() {
        c.a.n0.j.v.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (aVar = this.f8686g) == null) {
            return;
        }
        aVar.k(null);
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            c.a.n0.j.h0.f.d.a(this.a, "setStorageSync", str, y().f(str, null));
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        c.a.n0.j.v.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048636, this) == null) || (aVar = this.f8686g) == null) {
            return;
        }
        aVar.m(null);
    }

    @JavascriptInterface
    public void reload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            reload(null);
        }
    }

    @JavascriptInterface
    public void showAddToDesktopGuide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            showAddToDesktopGuide(null);
        }
    }

    @JavascriptInterface
    public void showKeyboard() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            if (this.f8686g == null) {
                this.f8686g = new c.a.n0.j.v.a(this.a, this.f8687h);
            }
            this.f8686g.l(null);
        }
    }
}
