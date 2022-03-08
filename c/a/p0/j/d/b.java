package c.a.p0.j.d;

import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.b0.c;
import c.a.p0.a.f.b.a.k;
import c.a.p0.a.h0.e;
import c.a.p0.j.a0.d;
import c.a.p0.j.c.g;
import c.a.p0.j.c.h;
import c.a.p0.j.f.f;
import c.a.p0.j.l0.j;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
/* loaded from: classes2.dex */
public final class b extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean y;
    public transient /* synthetic */ FieldHolder $fh;
    @V8JavascriptField
    public final String domain;

    /* renamed from: e  reason: collision with root package name */
    public c f10393e;
    @V8JavascriptField
    public c.a.p0.a.h0.a env;

    /* renamed from: f  reason: collision with root package name */
    public e f10394f;

    /* renamed from: g  reason: collision with root package name */
    public d f10395g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.j.a0.b f10396h;

    /* renamed from: i  reason: collision with root package name */
    public JsObject f10397i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.j.a0.e f10398j;
    public c.a.p0.j.v.a k;
    public c.a.p0.j.v.b l;
    public c.a.p0.j.h0.b m;
    public c.a.p0.j.m0.d n;
    public c.a.p0.j.a.f.b o;
    public c.a.p0.j.z.h.a p;
    public f q;
    public c.a.p0.j.e0.a r;
    public DesktopGuideApi s;
    public c.a.p0.j.c0.a t;
    public c.a.p0.j.p0.h.a u;
    public c.a.p0.j.b.b v;
    public c.a.p0.j.i.a w;
    public c.a.p0.j.b0.a x;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1101509966, "Lc/a/p0/j/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1101509966, "Lc/a/p0/j/d/b;");
                return;
            }
        }
        y = c.a.p0.a.a.a;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.domain = "main";
        this.f10397i = null;
        this.f10398j = null;
        this.k = null;
        this.l = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.f10393e = cVar;
        this.env = new c.a.p0.a.h0.a();
        y();
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) {
            c.a.p0.j.l.a.b(jsObject);
        }
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            if (this.f10396h == null) {
                this.f10396h = new c.a.p0.j.a0.b(this.f10393e);
            }
            this.f10396h.checkIsUserAdvisedToRest(jsObject);
        }
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            x().h(jsObject);
        }
    }

    @JavascriptInterface
    public void clearStorageSync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.p0.j.h0.f.d.a(this.f10393e, "clearStorageSync", "", x().a());
        }
    }

    @JavascriptInterface
    public c.a.p0.j.z.h.c connectSocket(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jsObject)) == null) {
            if (this.p == null) {
                this.p = new c.a.p0.j.z.h.a(this.f10393e);
            }
            return this.p.a(jsObject);
        }
        return (c.a.p0.j.z.h.c) invokeL.objValue;
    }

    @JavascriptInterface
    public c.a.p0.j.a.e.d createBannerAd(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jsObject)) == null) ? new c.a.p0.j.a.e.a(this.f10393e, jsObject) : (c.a.p0.j.a.e.d) invokeL.objValue;
    }

    @JavascriptInterface
    public g createInnerAudioContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new g(this.f10393e) : (g) invokeV.objValue;
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject)) == null) ? new RecommendButtonApiProxy(this.f10393e, jsObject) : (RecommendButtonApiProxy) invokeL.objValue;
    }

    @JavascriptInterface
    public c.a.p0.j.a.f.b createRewardedVideoAd(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, jsObject)) == null) {
            if (this.o == null) {
                this.o = new c.a.p0.j.a.f.e(this.f10393e, jsObject);
            }
            return this.o;
        }
        return (c.a.p0.j.a.f.b) invokeL.objValue;
    }

    @JavascriptInterface
    public c.a.p0.j.l0.g createUDPSocket() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? j.f10532c.b(this.f10393e) : (c.a.p0.j.l0.g) invokeV.objValue;
    }

    @JavascriptInterface
    public c.a.p0.j.p0.d.b.b createUserInfoButton(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, jsObject)) == null) ? new c.a.p0.j.p0.d.b.b(jsObject, this.f10393e) : (c.a.p0.j.p0.d.b.b) invokeL.objValue;
    }

    @JavascriptInterface
    public c.a.p0.j.z.d.b downloadFile(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, jsObject)) == null) {
            c.a.p0.a.o.b.a F = c.a.p0.a.o.b.a.F(jsObject);
            c.a.p0.j.z.a d2 = c.a.p0.j.z.e.b.b().d(this.f10393e, F, 2);
            if (d2 instanceof c.a.p0.j.z.d.b) {
                c.a.p0.j.z.d.b bVar = (c.a.p0.j.z.d.b) d2;
                bVar.H(F);
                return bVar;
            }
            c.a.p0.j.z.d.b bVar2 = new c.a.p0.j.z.d.b(this.f10393e, F);
            bVar2.start();
            return bVar2;
        }
        return (c.a.p0.j.z.d.b) invokeL.objValue;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jsObject) == null) {
            if (y) {
                this.f10393e.z().b("exit from java side.");
            }
            if (jsObject == null) {
                return;
            }
            c.a.p0.j.d.c.b bVar = new c.a.p0.j.d.c.b();
            c.a.p0.j.d.c.a e2 = c.a.p0.j.d.c.a.e(c.a.p0.a.o.b.a.F(jsObject));
            SwanAppActivity activity = c.a.p0.a.w0.f.U().getActivity();
            if (activity == null) {
                bVar.errMsg = String.format("%s:%s", "exit", com.alipay.sdk.util.f.f29566j);
                e2.b(bVar);
                return;
            }
            bVar.errMsg = String.format("%s:%s", "exit", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
            e2.d(bVar);
            activity.finishAndRemoveTask();
        }
    }

    @JavascriptInterface
    public void exitVoIPChat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jsObject) == null) {
            if (this.x == null) {
                this.x = c.a.p0.j.b0.b.a.a();
            }
            this.x.d(jsObject);
        }
    }

    @JavascriptInterface
    public String getAPIs(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            if (y) {
                return c.a.p0.a.n1.a.a.p() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i2) : "";
            }
            return SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i2);
        }
        return (String) invokeI.objValue;
    }

    @JavascriptInterface
    public c.a.p0.j.b.b getAntiAddiction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.v == null) {
                this.v = new c.a.p0.j.b.b(this.f10393e);
            }
            return this.v;
        }
        return (c.a.p0.j.b.b) invokeV.objValue;
    }

    @JavascriptInterface
    public c.a.p0.j.i.a getDownloadApp(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, jsObject)) == null) {
            if (this.w == null) {
                this.w = new c.a.p0.j.i.a(this.f10393e, c.a.p0.a.o.b.a.F(jsObject));
            }
            return this.w;
        }
        return (c.a.p0.j.i.a) invokeL.objValue;
    }

    @JavascriptInterface
    public String getEnvVariables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? c.a.p0.a.t0.b.b.a(this.f10393e) : (String) invokeV.objValue;
    }

    @JavascriptInterface
    public e getFileSystemManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.f10394f == null) {
                this.f10394f = new e((c.a.p0.a.b0.a) this.f10393e);
            }
            return this.f10394f;
        }
        return (e) invokeV.objValue;
    }

    @JavascriptInterface
    public d getOpenData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.f10395g == null) {
                this.f10395g = new d((c.a.p0.a.b0.a) this.f10393e);
            }
            return this.f10395g;
        }
        return (d) invokeV.objValue;
    }

    @JavascriptInterface
    public c.a.p0.j.a0.e getOpenDataContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.f10398j == null) {
                c.a.p0.j.a0.e eVar = new c.a.p0.j.a0.e(this.f10393e);
                this.f10398j = eVar;
                eVar.canvas = this.f10397i;
                this.f10397i = null;
            }
            return this.f10398j;
        }
        return (c.a.p0.j.a0.e) invokeV.objValue;
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, jsObject) == null) {
            x().k(jsObject);
        }
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, jsObject) == null) {
            x().l(jsObject);
        }
    }

    @JavascriptInterface
    public c.a.p0.j.h0.f.c getStorageInfoSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? x().b() : (c.a.p0.j.h0.f.c) invokeV.objValue;
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) ? c.a.p0.j.h0.f.d.a(this.f10393e, "getStorageSync", str, x().c(str)) : invokeL.objValue;
    }

    @JavascriptInterface
    public void getSwanGameDuration(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, jsObject) == null) {
            c.a.p0.j.j.a.a(jsObject);
        }
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, jsObject) == null) {
            c.a.p0.j.o0.a.d(jsObject);
        }
    }

    @JavascriptInterface
    public c.a.p0.j.m0.d getUpdateManager(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, jsObject)) == null) {
            if (this.n == null) {
                this.n = new c.a.p0.j.m0.d(jsObject);
            }
            return this.n;
        }
        return (c.a.p0.j.m0.d) invokeL.objValue;
    }

    @JavascriptInterface
    public c.a.p0.j.e0.a getVideoRecorderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.r == null) {
                this.r = new c.a.p0.j.e0.a(this.f10393e);
            }
            return this.r;
        }
        return (c.a.p0.j.e0.a) invokeV.objValue;
    }

    @JavascriptInterface
    public c.a.p0.j.p0.h.a getWebViewManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.u == null) {
                this.u = new c.a.p0.j.p0.h.a(this.f10393e);
            }
            return this.u;
        }
        return (c.a.p0.j.p0.h.a) invokeV.objValue;
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        c.a.p0.j.v.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, jsObject) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.k(jsObject);
    }

    @JavascriptInterface
    public void joinVoIPChat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, jsObject) == null) {
            if (this.x == null) {
                this.x = c.a.p0.j.b0.b.a.a();
            }
            this.x.b(jsObject);
        }
    }

    @JavascriptInterface
    public c.a.p0.j.j0.c loadSubpackage(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, jsObject)) == null) {
            c.a.p0.j.j0.c cVar = new c.a.p0.j.j0.c(this.f10393e);
            cVar.E(jsObject);
            return cVar;
        }
        return (c.a.p0.j.j0.c) invokeL.objValue;
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        k F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, jsObject) == null) || (F = c.a.p0.a.w0.f.U().F()) == null) {
            return;
        }
        F.a(c.a.p0.a.o.b.a.F(jsObject));
    }

    @JavascriptInterface
    public void offVoIPChatInterrupted(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, jsObject) == null) {
            if (this.x == null) {
                this.x = c.a.p0.j.b0.b.a.a();
            }
            this.x.a(jsObject);
        }
    }

    @JavascriptInterface
    public void offVoIPChatMembersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, jsObject) == null) {
            if (this.x == null) {
                this.x = c.a.p0.j.b0.b.a.a();
            }
            this.x.g(jsObject);
        }
    }

    @JavascriptInterface
    public void offVoIPChatSpeakersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, jsObject) == null) {
            if (this.x == null) {
                this.x = c.a.p0.j.b0.b.a.a();
            }
            this.x.i(jsObject);
        }
    }

    @JavascriptInterface
    public void onVoIPChatInterrupted(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, jsObject) == null) {
            if (this.x == null) {
                this.x = c.a.p0.j.b0.b.a.a();
            }
            this.x.c(jsObject);
        }
    }

    @JavascriptInterface
    public void onVoIPChatMembersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, jsObject) == null) {
            if (this.x == null) {
                this.x = c.a.p0.j.b0.b.a.a();
            }
            this.x.h(jsObject);
        }
    }

    @JavascriptInterface
    public void onVoIPChatSpeakersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, jsObject) == null) {
            if (this.x == null) {
                this.x = c.a.p0.j.b0.b.a.a();
            }
            this.x.k(jsObject);
        }
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, jsObject) == null) {
            c.a.p0.j.g.a.a((b) this.f10393e.o(), jsObject);
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, jsObject) == null) {
            if (this.t == null) {
                this.t = new c.a.p0.j.c0.a();
            }
            this.t.d(jsObject);
        }
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, jsObject) == null) {
            x().o(jsObject);
        }
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            c.a.p0.j.h0.f.d.a(this.f10393e, "removeStorageSync", str, x().e(str));
        }
    }

    @JavascriptInterface
    public c.a.p0.j.z.f.c request(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, jsObject)) == null) {
            c.a.p0.a.o.b.a F = c.a.p0.a.o.b.a.F(jsObject);
            c.a.p0.j.z.a d2 = c.a.p0.j.z.e.b.b().d(this.f10393e, F, 1);
            if (d2 instanceof c.a.p0.j.z.f.c) {
                c.a.p0.j.z.f.c cVar = (c.a.p0.j.z.f.c) d2;
                cVar.H(F);
                return cVar;
            }
            c.a.p0.j.z.f.c cVar2 = new c.a.p0.j.z.f.c(this.f10393e, F);
            cVar2.start();
            return cVar2;
        }
        return (c.a.p0.j.z.f.c) invokeL.objValue;
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, jsObject) == null) {
            if (this.q == null) {
                this.q = new f(this.f10393e);
            }
            this.q.i(jsObject);
        }
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, jsObject) == null) {
            new h(jsObject);
        }
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Short.valueOf(s)}) == null) || s < 1 || s > 60) {
            return;
        }
        this.f10393e.setPreferredFramesPerSecond(s);
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, jsObject) == null) {
            x().p(jsObject);
        }
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048629, this, str, jsSerializeValue) == null) {
            c.a.p0.j.h0.f.d.a(this.f10393e, "setStorageSync", str, x().f(str, jsSerializeValue));
        }
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, jsObject) == null) {
            new c.a.p0.j.f0.b.a(jsObject).m();
        }
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, jsObject) == null) {
            if (this.s == null) {
                this.s = new DesktopGuideApi(this.f10393e);
            }
            this.s.v(jsObject);
        }
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, jsObject) == null) {
            if (this.k == null) {
                this.k = new c.a.p0.j.v.a(this.f10393e, this.l);
            }
            this.k.l(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        c.a.p0.j.v.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048636, this, jsObject) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.m(jsObject);
    }

    @JavascriptInterface
    public void updateVoIPChatMuteConfig(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, jsObject) == null) {
            if (this.x == null) {
                this.x = c.a.p0.j.b0.b.a.a();
            }
            this.x.e(jsObject);
        }
    }

    @JavascriptInterface
    public c.a.p0.j.z.g.b uploadFile(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, jsObject)) == null) {
            c.a.p0.j.z.g.b bVar = new c.a.p0.j.z.g.b(this.f10393e, c.a.p0.a.o.b.a.F(jsObject));
            bVar.start();
            return bVar;
        }
        return (c.a.p0.j.z.g.b) invokeL.objValue;
    }

    @NonNull
    public final c.a.p0.j.h0.b x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            if (this.m == null) {
                this.m = new c.a.p0.j.h0.b(this.f10393e);
            }
            return this.m;
        }
        return (c.a.p0.j.h0.b) invokeV.objValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            this.l = new c.a.p0.j.v.b(this.f10393e);
        }
    }

    public void z(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, jsObject) == null) {
            this.f10397i = jsObject;
        }
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? createRecommendationButton(null) : (RecommendButtonApiProxy) invokeV.objValue;
    }

    @JavascriptInterface
    public void hideKeyboard() {
        c.a.p0.j.v.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.k(null);
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            c.a.p0.j.h0.f.d.a(this.f10393e, "setStorageSync", str, x().f(str, null));
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        c.a.p0.j.v.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048635, this) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.m(null);
    }

    @JavascriptInterface
    public void reload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            reload(null);
        }
    }

    @JavascriptInterface
    public void showAddToDesktopGuide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            showAddToDesktopGuide(null);
        }
    }

    @JavascriptInterface
    public void showKeyboard() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            if (this.k == null) {
                this.k = new c.a.p0.j.v.a(this.f10393e, this.l);
            }
            this.k.l(null);
        }
    }
}
