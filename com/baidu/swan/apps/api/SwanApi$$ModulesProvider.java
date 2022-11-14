package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.tieba.at1;
import com.baidu.tieba.au1;
import com.baidu.tieba.av1;
import com.baidu.tieba.bt1;
import com.baidu.tieba.bu1;
import com.baidu.tieba.cb3;
import com.baidu.tieba.ct1;
import com.baidu.tieba.cx2;
import com.baidu.tieba.dt1;
import com.baidu.tieba.du1;
import com.baidu.tieba.dw1;
import com.baidu.tieba.et1;
import com.baidu.tieba.eu1;
import com.baidu.tieba.ew1;
import com.baidu.tieba.ft1;
import com.baidu.tieba.fv1;
import com.baidu.tieba.fw1;
import com.baidu.tieba.g82;
import com.baidu.tieba.gs1;
import com.baidu.tieba.gt1;
import com.baidu.tieba.gu1;
import com.baidu.tieba.gv1;
import com.baidu.tieba.gw1;
import com.baidu.tieba.ht1;
import com.baidu.tieba.hu1;
import com.baidu.tieba.hv1;
import com.baidu.tieba.ig3;
import com.baidu.tieba.ih2;
import com.baidu.tieba.is1;
import com.baidu.tieba.it1;
import com.baidu.tieba.iv1;
import com.baidu.tieba.js1;
import com.baidu.tieba.jt1;
import com.baidu.tieba.ju1;
import com.baidu.tieba.jv1;
import com.baidu.tieba.k83;
import com.baidu.tieba.ku1;
import com.baidu.tieba.kv1;
import com.baidu.tieba.l73;
import com.baidu.tieba.ls1;
import com.baidu.tieba.lv1;
import com.baidu.tieba.m62;
import com.baidu.tieba.ms1;
import com.baidu.tieba.mt1;
import com.baidu.tieba.mu1;
import com.baidu.tieba.mv1;
import com.baidu.tieba.ns1;
import com.baidu.tieba.nu1;
import com.baidu.tieba.nv1;
import com.baidu.tieba.nz2;
import com.baidu.tieba.os1;
import com.baidu.tieba.ou1;
import com.baidu.tieba.ov1;
import com.baidu.tieba.ps1;
import com.baidu.tieba.pu1;
import com.baidu.tieba.qu1;
import com.baidu.tieba.qv1;
import com.baidu.tieba.rs1;
import com.baidu.tieba.ru1;
import com.baidu.tieba.st1;
import com.baidu.tieba.su1;
import com.baidu.tieba.sw2;
import com.baidu.tieba.ts1;
import com.baidu.tieba.tt1;
import com.baidu.tieba.tu1;
import com.baidu.tieba.us1;
import com.baidu.tieba.uu1;
import com.baidu.tieba.ve3;
import com.baidu.tieba.vr1;
import com.baidu.tieba.vu1;
import com.baidu.tieba.wk1;
import com.baidu.tieba.wt2;
import com.baidu.tieba.xs1;
import com.baidu.tieba.xt1;
import com.baidu.tieba.y62;
import com.baidu.tieba.yt1;
import com.baidu.tieba.yt2;
import com.baidu.tieba.yu1;
import com.baidu.tieba.zs1;
import com.baidu.tieba.zt1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
@Keep
/* loaded from: classes2.dex */
public class SwanApi$$ModulesProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SwanApi$$ModulesProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Map<String, Object> getV8ApiModules(final gs1 gs1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, gs1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    ms1 ms1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof ms1)) {
                            ms1Var = (ms1) obj;
                        } else {
                            ms1Var = new ms1(this.mSwanApiContext);
                            this.mApis.put("1930258908", ms1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ms1Var, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Account.checkSession")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = ms1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    ns1 ns1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ns1)) {
                            ns1Var = (ns1) obj;
                        } else {
                            ns1Var = new ns1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ns1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ns1Var, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Account.getLoginCode")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 C = ns1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    os1 os1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof os1)) {
                            os1Var = (os1) obj;
                        } else {
                            os1Var = new os1(this.mSwanApiContext);
                            this.mApis.put("1754780133", os1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(os1Var, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Account.getOpenId")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = os1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    vr1 vr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof vr1)) {
                            vr1Var = (vr1) obj;
                        } else {
                            vr1Var = new vr1(this.mSwanApiContext);
                            this.mApis.put("-343998465", vr1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(vr1Var, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Account.getUnionBDUSS")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = vr1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    ns1 ns1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ns1)) {
                            ns1Var = (ns1) obj;
                        } else {
                            ns1Var = new ns1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ns1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ns1Var, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Account.login")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 I = ns1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    ls1 ls1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof ls1)) {
                            ls1Var = (ls1) obj;
                        } else {
                            ls1Var = new ls1(this.mSwanApiContext);
                            this.mApis.put("-337742792", ls1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ls1Var, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Account.isBaiduAccountSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = ls1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    ns1 ns1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ns1)) {
                            ns1Var = (ns1) obj;
                        } else {
                            ns1Var = new ns1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ns1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ns1Var, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Account.isLoginSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 H = ns1Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    ps1 ps1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof ps1)) {
                            ps1Var = (ps1) obj;
                        } else {
                            ps1Var = new ps1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", ps1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ps1Var, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Basic.loadSubPackage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 F = ps1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    ps1 ps1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof ps1)) {
                            ps1Var = (ps1) obj;
                        } else {
                            ps1Var = new ps1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", ps1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ps1Var, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Basic.loadSubPackages")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 G = ps1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    wk1 wk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof wk1)) {
                            wk1Var = (wk1) obj;
                        } else {
                            wk1Var = new wk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", wk1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(wk1Var, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Bookshelf.deleteBookshelf")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 K = wk1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    wk1 wk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof wk1)) {
                            wk1Var = (wk1) obj;
                        } else {
                            wk1Var = new wk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", wk1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(wk1Var, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Bookshelf.insertBookshelf")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 P = wk1Var.P(str);
                        if (P == null) {
                            return "";
                        }
                        return P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    wk1 wk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof wk1)) {
                            wk1Var = (wk1) obj;
                        } else {
                            wk1Var = new wk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", wk1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(wk1Var, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Bookshelf.navigateToBookshelf")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 U = wk1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    wk1 wk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof wk1)) {
                            wk1Var = (wk1) obj;
                        } else {
                            wk1Var = new wk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", wk1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(wk1Var, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Bookshelf.queryBookshelf")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 V = wk1Var.V(str);
                        if (V == null) {
                            return "";
                        }
                        return V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    wk1 wk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof wk1)) {
                            wk1Var = (wk1) obj;
                        } else {
                            wk1Var = new wk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", wk1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(wk1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Bookshelf.updateBookshelfReadTime")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 X = wk1Var.X(str);
                        if (X == null) {
                            return "";
                        }
                        return X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    js1 js1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof js1)) {
                            js1Var = (js1) obj;
                        } else {
                            js1Var = new js1(this.mSwanApiContext);
                            this.mApis.put("-277316359", js1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(js1Var, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Coupon.getPlatformCoupons")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = js1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    js1 js1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof js1)) {
                            js1Var = (js1) obj;
                        } else {
                            js1Var = new js1(this.mSwanApiContext);
                            this.mApis.put("-277316359", js1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(js1Var, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Coupon.getUserCoupons")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 z = js1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    js1 js1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof js1)) {
                            js1Var = (js1) obj;
                        } else {
                            js1Var = new js1(this.mSwanApiContext);
                            this.mApis.put("-277316359", js1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(js1Var, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Coupon.takeCoupons")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 C = js1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    rs1 rs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof rs1)) {
                            rs1Var = (rs1) obj;
                        } else {
                            rs1Var = new rs1(this.mSwanApiContext);
                            this.mApis.put("-1225406515", rs1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(rs1Var, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Favorite.getFavorStatus")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = rs1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showFavoriteGuide(String str) {
                    ShowFavoriteGuideApi showFavoriteGuideApi;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("269275578");
                        if (obj != null && (obj instanceof ShowFavoriteGuideApi)) {
                            showFavoriteGuideApi = (ShowFavoriteGuideApi) obj;
                        } else {
                            showFavoriteGuideApi = new ShowFavoriteGuideApi(this.mSwanApiContext);
                            this.mApis.put("269275578", showFavoriteGuideApi);
                        }
                        Pair<Boolean, ew1> a = gw1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Favorite.showFavoriteGuide")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 G = showFavoriteGuideApi.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    ts1 ts1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof ts1)) {
                            ts1Var = (ts1) obj;
                        } else {
                            ts1Var = new ts1(this.mSwanApiContext);
                            this.mApis.put("-2057135077", ts1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ts1Var, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "File.shareFile")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = ts1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    ih2 ih2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof ih2)) {
                            ih2Var = (ih2) obj;
                        } else {
                            ih2Var = new ih2(this.mSwanApiContext);
                            this.mApis.put("2077414795", ih2Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ih2Var, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = ih2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    ih2 ih2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof ih2)) {
                            ih2Var = (ih2) obj;
                        } else {
                            ih2Var = new ih2(this.mSwanApiContext);
                            this.mApis.put("2077414795", ih2Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ih2Var, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessageSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = ih2Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String download(String str) {
                    us1 us1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof us1)) {
                            us1Var = (us1) obj;
                        } else {
                            us1Var = new us1(this.mSwanApiContext);
                            this.mApis.put("-170124576", us1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(us1Var, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "HostDownloadManager.download")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = us1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    us1 us1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof us1)) {
                            us1Var = (us1) obj;
                        } else {
                            us1Var = new us1(this.mSwanApiContext);
                            this.mApis.put("-170124576", us1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(us1Var, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "HostDownloadManager.openFile")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 z = us1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    us1 us1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof us1)) {
                            us1Var = (us1) obj;
                        } else {
                            us1Var = new us1(this.mSwanApiContext);
                            this.mApis.put("-170124576", us1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(us1Var, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "HostDownloadManager.query")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 query = us1Var.query(str);
                        if (query == null) {
                            return "";
                        }
                        return query.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    us1 us1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof us1)) {
                            us1Var = (us1) obj;
                        } else {
                            us1Var = new us1(this.mSwanApiContext);
                            this.mApis.put("-170124576", us1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(us1Var, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "HostDownloadManager.openDownloadCenter")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = us1Var.y();
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naImage", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    wt2 wt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof wt2)) {
                            wt2Var = (wt2) obj;
                        } else {
                            wt2Var = new wt2(this.mSwanApiContext);
                            this.mApis.put("1445003743", wt2Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(wt2Var, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Image.callImageMenu")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = wt2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    xs1 xs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof xs1)) {
                            xs1Var = (xs1) obj;
                        } else {
                            xs1Var = new xs1(this.mSwanApiContext);
                            this.mApis.put("-1252730367", xs1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(xs1Var, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Image.compressImage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = xs1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    ft1 ft1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ft1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ft1Var, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.closeTabBar")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = ft1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    ft1 ft1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ft1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ft1Var, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.closeTabBarRedDot")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = ft1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    bt1 bt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof bt1)) {
                            bt1Var = (bt1) obj;
                        } else {
                            bt1Var = new bt1(this.mSwanApiContext);
                            this.mApis.put("-246386074", bt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(bt1Var, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.hideNavigationBarLoading")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = bt1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    dt1 dt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof dt1)) {
                            dt1Var = (dt1) obj;
                        } else {
                            dt1Var = new dt1(this.mSwanApiContext);
                            this.mApis.put("-108978463", dt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(dt1Var, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.openMultiPicker")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 G = dt1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    dt1 dt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof dt1)) {
                            dt1Var = (dt1) obj;
                        } else {
                            dt1Var = new dt1(this.mSwanApiContext);
                            this.mApis.put("-108978463", dt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(dt1Var, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.openPicker")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 H = dt1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    ft1 ft1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ft1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ft1Var, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.openTabBar")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 C = ft1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    ct1 ct1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof ct1)) {
                            ct1Var = (ct1) obj;
                        } else {
                            ct1Var = new ct1(this.mSwanApiContext);
                            this.mApis.put("-1750613704", ct1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ct1Var, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.pageScrollTo")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = ct1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    bt1 bt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof bt1)) {
                            bt1Var = (bt1) obj;
                        } else {
                            bt1Var = new bt1(this.mSwanApiContext);
                            this.mApis.put("-246386074", bt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(bt1Var, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarColor")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 z = bt1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    bt1 bt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof bt1)) {
                            bt1Var = (bt1) obj;
                        } else {
                            bt1Var = new bt1(this.mSwanApiContext);
                            this.mApis.put("-246386074", bt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(bt1Var, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarTitle")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = bt1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    ft1 ft1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ft1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ft1Var, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.setTabBarItem")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 D = ft1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    dt1 dt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof dt1)) {
                            dt1Var = (dt1) obj;
                        } else {
                            dt1Var = new dt1(this.mSwanApiContext);
                            this.mApis.put("-108978463", dt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(dt1Var, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.showDatePickerView")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 L = dt1Var.L(str);
                        if (L == null) {
                            return "";
                        }
                        return L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    ht1 ht1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof ht1)) {
                            ht1Var = (ht1) obj;
                        } else {
                            ht1Var = new ht1(this.mSwanApiContext);
                            this.mApis.put("1172469410", ht1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ht1Var, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.showHalfScreenWebview")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 K = ht1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    zs1 zs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("5236036", zs1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(zs1Var, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.showLoading")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = zs1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    at1 at1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("1913747800", at1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(at1Var, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.showModal")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = at1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    bt1 bt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof bt1)) {
                            bt1Var = (bt1) obj;
                        } else {
                            bt1Var = new bt1(this.mSwanApiContext);
                            this.mApis.put("-246386074", bt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(bt1Var, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.showNavigationBarLoading")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 B = bt1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    gt1 gt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof gt1)) {
                            gt1Var = (gt1) obj;
                        } else {
                            gt1Var = new gt1(this.mSwanApiContext);
                            this.mApis.put("1159492510", gt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(gt1Var, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.showToast")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 Q = gt1Var.Q(str);
                        if (Q == null) {
                            return "";
                        }
                        return Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    et1 et1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof et1)) {
                            et1Var = (et1) obj;
                        } else {
                            et1Var = new et1(this.mSwanApiContext);
                            this.mApis.put("1165118609", et1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(et1Var, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.stopPullDownRefresh")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = et1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    dt1 dt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof dt1)) {
                            dt1Var = (dt1) obj;
                        } else {
                            dt1Var = new dt1(this.mSwanApiContext);
                            this.mApis.put("-108978463", dt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(dt1Var, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.updateMultiPicker")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 M = dt1Var.M(str);
                        if (M == null) {
                            return "";
                        }
                        return M.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    zs1 zs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("5236036", zs1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(zs1Var, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.hideLoading")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = zs1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    gt1 gt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof gt1)) {
                            gt1Var = (gt1) obj;
                        } else {
                            gt1Var = new gt1(this.mSwanApiContext);
                            this.mApis.put("1159492510", gt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(gt1Var, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.hideToast")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 K = gt1Var.K();
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    it1 it1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof it1)) {
                            it1Var = (it1) obj;
                        } else {
                            it1Var = new it1(this.mSwanApiContext);
                            this.mApis.put("-137346255", it1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(it1Var, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Keyboard.startKeyboardHeightChange")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 C = it1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    it1 it1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof it1)) {
                            it1Var = (it1) obj;
                        } else {
                            it1Var = new it1(this.mSwanApiContext);
                            this.mApis.put("-137346255", it1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(it1Var, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Keyboard.stopKeyboardHeightChange")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 D = it1Var.D();
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    jt1 jt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof jt1)) {
                            jt1Var = (jt1) obj;
                        } else {
                            jt1Var = new jt1(this.mSwanApiContext);
                            this.mApis.put("-397373095", jt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(jt1Var, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "LocationService.getLocation")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = jt1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    jt1 jt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof jt1)) {
                            jt1Var = (jt1) obj;
                        } else {
                            jt1Var = new jt1(this.mSwanApiContext);
                            this.mApis.put("-397373095", jt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(jt1Var, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "LocationService.startLocationUpdate")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = jt1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    jt1 jt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof jt1)) {
                            jt1Var = (jt1) obj;
                        } else {
                            jt1Var = new jt1(this.mSwanApiContext);
                            this.mApis.put("-397373095", jt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(jt1Var, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "LocationService.stopLocationUpdate")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 B = jt1Var.B();
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    av1 av1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof av1)) {
                            av1Var = (av1) obj;
                        } else {
                            av1Var = new av1(this.mSwanApiContext);
                            this.mApis.put("538070032", av1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(av1Var, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = av1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String callService(String str) {
                    mt1 mt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("-1076509454", mt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(mt1Var, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Network.callService")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = mt1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    tt1 tt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof tt1)) {
                            tt1Var = (tt1) obj;
                        } else {
                            tt1Var = new tt1(this.mSwanApiContext);
                            this.mApis.put("968563034", tt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(tt1Var, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Network.cancelRequest")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 D = tt1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    st1 st1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof st1)) {
                            st1Var = (st1) obj;
                        } else {
                            st1Var = new st1(this.mSwanApiContext);
                            this.mApis.put("453220699", st1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(st1Var, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Network.networkStatusChange")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = st1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    st1 st1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof st1)) {
                            st1Var = (st1) obj;
                        } else {
                            st1Var = new st1(this.mSwanApiContext);
                            this.mApis.put("453220699", st1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(st1Var, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Network.getNetworkType")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = st1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                @JavascriptInterface
                public String request(JsObject jsObject) {
                    InterceptResult invokeL2;
                    tt1 tt1Var;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, jsObject)) == null) {
                        try {
                            dw1.c().a("request");
                            Object obj = this.mApis.get("968563034");
                            if (obj != null && (obj instanceof tt1)) {
                                tt1Var = (tt1) obj;
                            } else {
                                tt1Var = new tt1(this.mSwanApiContext);
                                this.mApis.put("968563034", tt1Var);
                            }
                            Pair<Boolean, ew1> a2 = gw1.a(tt1Var, "swanAPI/request");
                            if (((Boolean) a2.first).booleanValue()) {
                                a = ((ew1) a2.second).a();
                            } else if (m62.a(this.mSwanApiContext.f(), "Network.request")) {
                                a = new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            } else {
                                Pair<ew1, JSONObject> t = is1.t(jsObject);
                                if (!((ew1) t.first).isSuccess()) {
                                    a = ((ew1) t.first).a();
                                } else {
                                    JSONObject jSONObject = (JSONObject) t.second;
                                    if (jSONObject == null) {
                                        a = ew1.a.a();
                                    } else {
                                        fw1 V = tt1Var.V(jSONObject);
                                        if (V == null) {
                                            a = "";
                                        } else {
                                            a = V.a();
                                        }
                                    }
                                }
                            }
                            return a;
                        } finally {
                        }
                    } else {
                        return (String) invokeL2.objValue;
                    }
                }
            });
            hashMap.put("_naPayment", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    cx2 cx2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof cx2)) {
                            cx2Var = (cx2) obj;
                        } else {
                            cx2Var = new cx2(this.mSwanApiContext);
                            this.mApis.put("-336396851", cx2Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(cx2Var, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Payment.chooseCoupon")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = cx2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    cx2 cx2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof cx2)) {
                            cx2Var = (cx2) obj;
                        } else {
                            cx2Var = new cx2(this.mSwanApiContext);
                            this.mApis.put("-336396851", cx2Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(cx2Var, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Payment.getPaymentInfo")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = cx2Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    sw2 sw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof sw2)) {
                            sw2Var = (sw2) obj;
                        } else {
                            sw2Var = new sw2(this.mSwanApiContext);
                            this.mApis.put("1854689529", sw2Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(sw2Var, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Payment.requestThirdPayment")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = sw2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    cx2 cx2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof cx2)) {
                            cx2Var = (cx2) obj;
                        } else {
                            cx2Var = new cx2(this.mSwanApiContext);
                            this.mApis.put("-336396851", cx2Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(cx2Var, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Payment.setPaymentInfo")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 z = cx2Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    nz2 nz2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof nz2)) {
                            nz2Var = (nz2) obj;
                        } else {
                            nz2Var = new nz2(this.mSwanApiContext);
                            this.mApis.put("-254510461", nz2Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(nz2Var, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Plugin.invokePluginChooseAddress")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = nz2Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    nz2 nz2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof nz2)) {
                            nz2Var = (nz2) obj;
                        } else {
                            nz2Var = new nz2(this.mSwanApiContext);
                            this.mApis.put("-254510461", nz2Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(nz2Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 z = nz2Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    nz2 nz2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof nz2)) {
                            nz2Var = (nz2) obj;
                        } else {
                            nz2Var = new nz2(this.mSwanApiContext);
                            this.mApis.put("-254510461", nz2Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(nz2Var, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Plugin.invokePluginPayment")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = nz2Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    g82 g82Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof g82)) {
                            g82Var = (g82) obj;
                        } else {
                            g82Var = new g82(this.mSwanApiContext);
                            this.mApis.put("-2068479848", g82Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(g82Var, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Prefetch.prefetchResources")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = g82Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    y62 y62Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof y62)) {
                            y62Var = (y62) obj;
                        } else {
                            y62Var = new y62(this.mSwanApiContext);
                            this.mApis.put("423661539", y62Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(y62Var, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Preload.preloadStatus")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = y62Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    ig3 ig3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof ig3)) {
                            ig3Var = (ig3) obj;
                        } else {
                            ig3Var = new ig3(this.mSwanApiContext);
                            this.mApis.put("-1929343869", ig3Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ig3Var, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "PrivateFile.uploadFileToBos")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 C = ig3Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    xt1 xt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof xt1)) {
                            xt1Var = (xt1) obj;
                        } else {
                            xt1Var = new xt1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", xt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(xt1Var, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Router.hideModalPage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = xt1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    xt1 xt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof xt1)) {
                            xt1Var = (xt1) obj;
                        } else {
                            xt1Var = new xt1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", xt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(xt1Var, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Router.navigateBack")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 B = xt1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    yt1 yt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof yt1)) {
                            yt1Var = (yt1) obj;
                        } else {
                            yt1Var = new yt1(this.mSwanApiContext);
                            this.mApis.put("1968522584", yt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(yt1Var, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Router.navigateTo")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 H = yt1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    au1 au1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof au1)) {
                            au1Var = (au1) obj;
                        } else {
                            au1Var = new au1(this.mSwanApiContext);
                            this.mApis.put("1317280190", au1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(au1Var, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Router.reLaunch")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = au1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    bu1 bu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof bu1)) {
                            bu1Var = (bu1) obj;
                        } else {
                            bu1Var = new bu1(this.mSwanApiContext);
                            this.mApis.put("-420075743", bu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(bu1Var, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Router.reLoadErrorPage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = bu1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    zt1 zt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof zt1)) {
                            zt1Var = (zt1) obj;
                        } else {
                            zt1Var = new zt1(this.mSwanApiContext);
                            this.mApis.put("1792515533", zt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(zt1Var, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Router.redirectTo")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 D = zt1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    yt1 yt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof yt1)) {
                            yt1Var = (yt1) obj;
                        } else {
                            yt1Var = new yt1(this.mSwanApiContext);
                            this.mApis.put("1968522584", yt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(yt1Var, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Router.showModalPage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 J = yt1Var.J(str);
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    eu1 eu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof eu1)) {
                            eu1Var = (eu1) obj;
                        } else {
                            eu1Var = new eu1(this.mSwanApiContext);
                            this.mApis.put("-594895721", eu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(eu1Var, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Setting.getAppInfoSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 F = eu1Var.F();
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    eu1 eu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof eu1)) {
                            eu1Var = (eu1) obj;
                        } else {
                            eu1Var = new eu1(this.mSwanApiContext);
                            this.mApis.put("-594895721", eu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(eu1Var, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Setting.getSlaveIdSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 H = eu1Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    du1 du1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof du1)) {
                            du1Var = (du1) obj;
                        } else {
                            du1Var = new du1(this.mSwanApiContext);
                            this.mApis.put("450273045", du1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(du1Var, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Setting.isAllowedAdOpenAppSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = du1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    eu1 eu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof eu1)) {
                            eu1Var = (eu1) obj;
                        } else {
                            eu1Var = new eu1(this.mSwanApiContext);
                            this.mApis.put("-594895721", eu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(eu1Var, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Setting.getSetting")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 G = eu1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    eu1 eu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof eu1)) {
                            eu1Var = (eu1) obj;
                        } else {
                            eu1Var = new eu1(this.mSwanApiContext);
                            this.mApis.put("-594895721", eu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(eu1Var, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Setting.getSwanId")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 I = eu1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    eu1 eu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof eu1)) {
                            eu1Var = (eu1) obj;
                        } else {
                            eu1Var = new eu1(this.mSwanApiContext);
                            this.mApis.put("-594895721", eu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(eu1Var, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Setting.getUserInfo")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 J = eu1Var.J(str);
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    cb3 cb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof cb3)) {
                            cb3Var = (cb3) obj;
                        } else {
                            cb3Var = new cb3(this.mSwanApiContext);
                            this.mApis.put("712777136", cb3Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(cb3Var, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = cb3Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    hu1 hu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", hu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(hu1Var, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = hu1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    hu1 hu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", hu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(hu1Var, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorageSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 C = hu1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    gu1 gu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("130910081", gu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(gu1Var, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.clearStorage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = gu1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    gu1 gu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("130910081", gu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(gu1Var, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.clearStorageSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 C = gu1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    hu1 hu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", hu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(hu1Var, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfo")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 G = hu1Var.G();
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    hu1 hu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", hu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(hu1Var, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfoSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 J = hu1Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    gu1 gu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("130910081", gu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(gu1Var, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.getStorageInfo")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 G = gu1Var.G();
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    gu1 gu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("130910081", gu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(gu1Var, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.getStorageInfoSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 J = gu1Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    hu1 hu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", hu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(hu1Var, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.getGlobalStorage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 D = hu1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    hu1 hu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", hu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(hu1Var, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 K = hu1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    gu1 gu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("130910081", gu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(gu1Var, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.getStorage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 D = gu1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    gu1 gu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("130910081", gu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(gu1Var, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.getStorageInfoAsync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 H = gu1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    gu1 gu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("130910081", gu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(gu1Var, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.getStorageSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 K = gu1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    hu1 hu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", hu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(hu1Var, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 R = hu1Var.R(str);
                        if (R == null) {
                            return "";
                        }
                        return R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    hu1 hu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", hu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(hu1Var, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorageSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 T = hu1Var.T(str);
                        if (T == null) {
                            return "";
                        }
                        return T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    gu1 gu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("130910081", gu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(gu1Var, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.removeStorage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 R = gu1Var.R(str);
                        if (R == null) {
                            return "";
                        }
                        return R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    gu1 gu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("130910081", gu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(gu1Var, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.removeStorageSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 T = gu1Var.T(str);
                        if (T == null) {
                            return "";
                        }
                        return T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    hu1 hu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", hu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(hu1Var, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.setGlobalStorage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 U = hu1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    hu1 hu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", hu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(hu1Var, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.setGlobalStorageSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 W = hu1Var.W(str);
                        if (W == null) {
                            return "";
                        }
                        return W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    gu1 gu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("130910081", gu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(gu1Var, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.setStorage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 U = gu1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    gu1 gu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("130910081", gu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(gu1Var, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.setStorageSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 W = gu1Var.W(str);
                        if (W == null) {
                            return "";
                        }
                        return W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    ju1 ju1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof ju1)) {
                            ju1Var = (ju1) obj;
                        } else {
                            ju1Var = new ju1(this.mSwanApiContext);
                            this.mApis.put("823117982", ju1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ju1Var, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Subscription.requestSubscribeFormId")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 E = ju1Var.E(str);
                        if (E == null) {
                            return "";
                        }
                        return E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    ku1 ku1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof ku1)) {
                            ku1Var = (ku1) obj;
                        } else {
                            ku1Var = new ku1(this.mSwanApiContext);
                            this.mApis.put("-947445811", ku1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ku1Var, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Subscription.subscribeService")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 F = ku1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    ru1 ru1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof ru1)) {
                            ru1Var = (ru1) obj;
                        } else {
                            ru1Var = new ru1(this.mSwanApiContext);
                            this.mApis.put("1936205521", ru1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ru1Var, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.exitFullScreen")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = ru1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    qu1 qu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof qu1)) {
                            qu1Var = (qu1) obj;
                        } else {
                            qu1Var = new qu1(this.mSwanApiContext);
                            this.mApis.put("1694151270", qu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(qu1Var, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.getDeviceInfo")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = qu1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    su1 su1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof su1)) {
                            su1Var = (su1) obj;
                        } else {
                            su1Var = new su1(this.mSwanApiContext);
                            this.mApis.put("-1321681619", su1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(su1Var, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.getDeviceProfile")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = su1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    tu1 tu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof tu1)) {
                            tu1Var = (tu1) obj;
                        } else {
                            tu1Var = new tu1(this.mSwanApiContext);
                            this.mApis.put("-1569246082", tu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(tu1Var, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.makePhoneCall")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = tu1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    vu1 vu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof vu1)) {
                            vu1Var = (vu1) obj;
                        } else {
                            vu1Var = new vu1(this.mSwanApiContext);
                            this.mApis.put("1099851202", vu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(vu1Var, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.openSMSPanel")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = vu1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    uu1 uu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof uu1)) {
                            uu1Var = (uu1) obj;
                        } else {
                            uu1Var = new uu1(this.mSwanApiContext);
                            this.mApis.put("-1707203360", uu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(uu1Var, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.requestFullScreen")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 F = uu1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    ou1 ou1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof ou1)) {
                            ou1Var = (ou1) obj;
                        } else {
                            ou1Var = new ou1(this.mSwanApiContext);
                            this.mApis.put("-518757484", ou1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ou1Var, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.setClipboardData")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = ou1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    yt2 yt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof yt2)) {
                            yt2Var = (yt2) obj;
                        } else {
                            yt2Var = new yt2(this.mSwanApiContext);
                            this.mApis.put("1161486049", yt2Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(yt2Var, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.setErrorPageType")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = yt2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    yu1 yu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof yu1)) {
                            yu1Var = (yu1) obj;
                        } else {
                            yu1Var = new yu1(this.mSwanApiContext);
                            this.mApis.put("447234992", yu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(yu1Var, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.setMediaVolume")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 z = yu1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    mu1 mu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof mu1)) {
                            mu1Var = (mu1) obj;
                        } else {
                            mu1Var = new mu1(this.mSwanApiContext);
                            this.mApis.put("1372680763", mu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(mu1Var, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.startAccelerometer")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = mu1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    pu1 pu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof pu1)) {
                            pu1Var = (pu1) obj;
                        } else {
                            pu1Var = new pu1(this.mSwanApiContext);
                            this.mApis.put("1689255576", pu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(pu1Var, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.startCompass")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = pu1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    nu1 nu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof nu1)) {
                            nu1Var = (nu1) obj;
                        } else {
                            nu1Var = new nu1(this.mSwanApiContext);
                            this.mApis.put("99997465", nu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(nu1Var, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.getBrightness")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = nu1Var.y();
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    ou1 ou1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof ou1)) {
                            ou1Var = (ou1) obj;
                        } else {
                            ou1Var = new ou1(this.mSwanApiContext);
                            this.mApis.put("-518757484", ou1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ou1Var, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.getClipboardData")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = ou1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    yu1 yu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof yu1)) {
                            yu1Var = (yu1) obj;
                        } else {
                            yu1Var = new yu1(this.mSwanApiContext);
                            this.mApis.put("447234992", yu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(yu1Var, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.getMediaVolume")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = yu1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    mu1 mu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof mu1)) {
                            mu1Var = (mu1) obj;
                        } else {
                            mu1Var = new mu1(this.mSwanApiContext);
                            this.mApis.put("1372680763", mu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(mu1Var, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.stopAccelerometer")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 B = mu1Var.B();
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    pu1 pu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof pu1)) {
                            pu1Var = (pu1) obj;
                        } else {
                            pu1Var = new pu1(this.mSwanApiContext);
                            this.mApis.put("1689255576", pu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(pu1Var, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.stopCompass")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 z = pu1Var.z();
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    jv1 jv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof jv1)) {
                            jv1Var = (jv1) obj;
                        } else {
                            jv1Var = new jv1(this.mSwanApiContext);
                            this.mApis.put("201194468", jv1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(jv1Var, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.addToDesktop")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 B = jv1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    fv1 fv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof fv1)) {
                            fv1Var = (fv1) obj;
                        } else {
                            fv1Var = new fv1(this.mSwanApiContext);
                            this.mApis.put("-1412306947", fv1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(fv1Var, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.calcMD5")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = fv1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    gv1 gv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof gv1)) {
                            gv1Var = (gv1) obj;
                        } else {
                            gv1Var = new gv1(this.mSwanApiContext);
                            this.mApis.put("1626415364", gv1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(gv1Var, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.checkAppInstalled")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = gv1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    iv1 iv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof iv1)) {
                            iv1Var = (iv1) obj;
                        } else {
                            iv1Var = new iv1(this.mSwanApiContext);
                            this.mApis.put("-836768778", iv1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(iv1Var, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfo")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = iv1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    kv1 kv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof kv1)) {
                            kv1Var = (kv1) obj;
                        } else {
                            kv1Var = new kv1(this.mSwanApiContext);
                            this.mApis.put("-810858308", kv1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(kv1Var, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.getPerformanceLevel")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = kv1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    ov1 ov1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof ov1)) {
                            ov1Var = (ov1) obj;
                        } else {
                            ov1Var = new ov1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", ov1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ov1Var, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.getSystemInfoAsync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 I = ov1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    lv1 lv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof lv1)) {
                            lv1Var = (lv1) obj;
                        } else {
                            lv1Var = new lv1(this.mSwanApiContext);
                            this.mApis.put("-2097727681", lv1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(lv1Var, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.handleException")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = lv1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    hv1 hv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof hv1)) {
                            hv1Var = (hv1) obj;
                        } else {
                            hv1Var = new hv1(this.mSwanApiContext);
                            this.mApis.put("2084449317", hv1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(hv1Var, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.hasCloseHandler")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = hv1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    k83 k83Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof k83)) {
                            k83Var = (k83) obj;
                        } else {
                            k83Var = new k83(this.mSwanApiContext);
                            this.mApis.put("1031678042", k83Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(k83Var, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.hideCaptureScreenShareDialog")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = k83Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    mv1 mv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof mv1)) {
                            mv1Var = (mv1) obj;
                        } else {
                            mv1Var = new mv1(this.mSwanApiContext);
                            this.mApis.put("1751900130", mv1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(mv1Var, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.logToFile")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = mv1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    l73 l73Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof l73)) {
                            l73Var = (l73) obj;
                        } else {
                            l73Var = new l73(this.mSwanApiContext);
                            this.mApis.put("1748196865", l73Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(l73Var, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.preloadPackage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = l73Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    nv1 nv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof nv1)) {
                            nv1Var = (nv1) obj;
                        } else {
                            nv1Var = new nv1(this.mSwanApiContext);
                            this.mApis.put("589529211", nv1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(nv1Var, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.previewImage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 B = nv1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    qv1 qv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof qv1)) {
                            qv1Var = (qv1) obj;
                        } else {
                            qv1Var = new qv1(this.mSwanApiContext);
                            this.mApis.put("-577481801", qv1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(qv1Var, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.ubcFlowJar")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 I = qv1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    ov1 ov1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof ov1)) {
                            ov1Var = (ov1) obj;
                        } else {
                            ov1Var = new ov1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", ov1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ov1Var, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfoSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 E = ov1Var.E();
                        if (E == null) {
                            return "";
                        }
                        return E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    ov1 ov1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof ov1)) {
                            ov1Var = (ov1) obj;
                        } else {
                            ov1Var = new ov1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", ov1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ov1Var, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.getSystemInfo")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 H = ov1Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    ov1 ov1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof ov1)) {
                            ov1Var = (ov1) obj;
                        } else {
                            ov1Var = new ov1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", ov1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ov1Var, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.getSystemInfoSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 J = ov1Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    ve3 ve3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ve3)) {
                            ve3Var = (ve3) obj;
                        } else {
                            ve3Var = new ve3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ve3Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ve3Var, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Wifi.connectWifi")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = ve3Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    ve3 ve3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ve3)) {
                            ve3Var = (ve3) obj;
                        } else {
                            ve3Var = new ve3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ve3Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ve3Var, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Wifi.getConnectedWifi")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 B = ve3Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    ve3 ve3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ve3)) {
                            ve3Var = (ve3) obj;
                        } else {
                            ve3Var = new ve3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ve3Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ve3Var, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Wifi.getWifiList")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 C = ve3Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    ve3 ve3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ve3)) {
                            ve3Var = (ve3) obj;
                        } else {
                            ve3Var = new ve3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ve3Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ve3Var, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Wifi.startWifi")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 G = ve3Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    ve3 ve3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ve3)) {
                            ve3Var = (ve3) obj;
                        } else {
                            ve3Var = new ve3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ve3Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ve3Var, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Wifi.stopWifi")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 H = ve3Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static Map<String, Object> getWebviewApiModules(final gs1 gs1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, gs1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    ms1 ms1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof ms1)) {
                            ms1Var = (ms1) obj;
                        } else {
                            ms1Var = new ms1(this.mSwanApiContext);
                            this.mApis.put("1930258908", ms1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ms1Var, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Account.checkSession")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = ms1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    ns1 ns1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ns1)) {
                            ns1Var = (ns1) obj;
                        } else {
                            ns1Var = new ns1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ns1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ns1Var, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Account.getLoginCode")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 C = ns1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    os1 os1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof os1)) {
                            os1Var = (os1) obj;
                        } else {
                            os1Var = new os1(this.mSwanApiContext);
                            this.mApis.put("1754780133", os1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(os1Var, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Account.getOpenId")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = os1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    vr1 vr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof vr1)) {
                            vr1Var = (vr1) obj;
                        } else {
                            vr1Var = new vr1(this.mSwanApiContext);
                            this.mApis.put("-343998465", vr1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(vr1Var, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Account.getUnionBDUSS")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = vr1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    ns1 ns1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ns1)) {
                            ns1Var = (ns1) obj;
                        } else {
                            ns1Var = new ns1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ns1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ns1Var, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Account.login")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 I = ns1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    ls1 ls1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof ls1)) {
                            ls1Var = (ls1) obj;
                        } else {
                            ls1Var = new ls1(this.mSwanApiContext);
                            this.mApis.put("-337742792", ls1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ls1Var, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Account.isBaiduAccountSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = ls1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    ns1 ns1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ns1)) {
                            ns1Var = (ns1) obj;
                        } else {
                            ns1Var = new ns1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ns1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ns1Var, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Account.isLoginSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 H = ns1Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    ps1 ps1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof ps1)) {
                            ps1Var = (ps1) obj;
                        } else {
                            ps1Var = new ps1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", ps1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ps1Var, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Basic.loadSubPackage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 F = ps1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    ps1 ps1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof ps1)) {
                            ps1Var = (ps1) obj;
                        } else {
                            ps1Var = new ps1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", ps1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ps1Var, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Basic.loadSubPackages")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 G = ps1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    wk1 wk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof wk1)) {
                            wk1Var = (wk1) obj;
                        } else {
                            wk1Var = new wk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", wk1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(wk1Var, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Bookshelf.deleteBookshelf")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 K = wk1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    wk1 wk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof wk1)) {
                            wk1Var = (wk1) obj;
                        } else {
                            wk1Var = new wk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", wk1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(wk1Var, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Bookshelf.insertBookshelf")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 P = wk1Var.P(str);
                        if (P == null) {
                            return "";
                        }
                        return P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    wk1 wk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof wk1)) {
                            wk1Var = (wk1) obj;
                        } else {
                            wk1Var = new wk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", wk1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(wk1Var, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Bookshelf.navigateToBookshelf")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 U = wk1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    wk1 wk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof wk1)) {
                            wk1Var = (wk1) obj;
                        } else {
                            wk1Var = new wk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", wk1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(wk1Var, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Bookshelf.queryBookshelf")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 V = wk1Var.V(str);
                        if (V == null) {
                            return "";
                        }
                        return V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    wk1 wk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof wk1)) {
                            wk1Var = (wk1) obj;
                        } else {
                            wk1Var = new wk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", wk1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(wk1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Bookshelf.updateBookshelfReadTime")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 X = wk1Var.X(str);
                        if (X == null) {
                            return "";
                        }
                        return X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    js1 js1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof js1)) {
                            js1Var = (js1) obj;
                        } else {
                            js1Var = new js1(this.mSwanApiContext);
                            this.mApis.put("-277316359", js1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(js1Var, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Coupon.getPlatformCoupons")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = js1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    js1 js1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof js1)) {
                            js1Var = (js1) obj;
                        } else {
                            js1Var = new js1(this.mSwanApiContext);
                            this.mApis.put("-277316359", js1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(js1Var, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Coupon.getUserCoupons")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 z = js1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    js1 js1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof js1)) {
                            js1Var = (js1) obj;
                        } else {
                            js1Var = new js1(this.mSwanApiContext);
                            this.mApis.put("-277316359", js1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(js1Var, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Coupon.takeCoupons")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 C = js1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    rs1 rs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof rs1)) {
                            rs1Var = (rs1) obj;
                        } else {
                            rs1Var = new rs1(this.mSwanApiContext);
                            this.mApis.put("-1225406515", rs1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(rs1Var, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Favorite.getFavorStatus")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = rs1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showFavoriteGuide(String str) {
                    ShowFavoriteGuideApi showFavoriteGuideApi;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("269275578");
                        if (obj != null && (obj instanceof ShowFavoriteGuideApi)) {
                            showFavoriteGuideApi = (ShowFavoriteGuideApi) obj;
                        } else {
                            showFavoriteGuideApi = new ShowFavoriteGuideApi(this.mSwanApiContext);
                            this.mApis.put("269275578", showFavoriteGuideApi);
                        }
                        Pair<Boolean, ew1> a = gw1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Favorite.showFavoriteGuide")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 G = showFavoriteGuideApi.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    ts1 ts1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof ts1)) {
                            ts1Var = (ts1) obj;
                        } else {
                            ts1Var = new ts1(this.mSwanApiContext);
                            this.mApis.put("-2057135077", ts1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ts1Var, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "File.shareFile")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = ts1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    ih2 ih2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof ih2)) {
                            ih2Var = (ih2) obj;
                        } else {
                            ih2Var = new ih2(this.mSwanApiContext);
                            this.mApis.put("2077414795", ih2Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ih2Var, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = ih2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    ih2 ih2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof ih2)) {
                            ih2Var = (ih2) obj;
                        } else {
                            ih2Var = new ih2(this.mSwanApiContext);
                            this.mApis.put("2077414795", ih2Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ih2Var, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessageSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = ih2Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String download(String str) {
                    us1 us1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof us1)) {
                            us1Var = (us1) obj;
                        } else {
                            us1Var = new us1(this.mSwanApiContext);
                            this.mApis.put("-170124576", us1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(us1Var, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "HostDownloadManager.download")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = us1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    us1 us1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof us1)) {
                            us1Var = (us1) obj;
                        } else {
                            us1Var = new us1(this.mSwanApiContext);
                            this.mApis.put("-170124576", us1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(us1Var, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "HostDownloadManager.openFile")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 z = us1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    us1 us1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof us1)) {
                            us1Var = (us1) obj;
                        } else {
                            us1Var = new us1(this.mSwanApiContext);
                            this.mApis.put("-170124576", us1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(us1Var, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "HostDownloadManager.query")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 query = us1Var.query(str);
                        if (query == null) {
                            return "";
                        }
                        return query.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    us1 us1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof us1)) {
                            us1Var = (us1) obj;
                        } else {
                            us1Var = new us1(this.mSwanApiContext);
                            this.mApis.put("-170124576", us1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(us1Var, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "HostDownloadManager.openDownloadCenter")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = us1Var.y();
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naImage", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    wt2 wt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof wt2)) {
                            wt2Var = (wt2) obj;
                        } else {
                            wt2Var = new wt2(this.mSwanApiContext);
                            this.mApis.put("1445003743", wt2Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(wt2Var, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Image.callImageMenu")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = wt2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    xs1 xs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof xs1)) {
                            xs1Var = (xs1) obj;
                        } else {
                            xs1Var = new xs1(this.mSwanApiContext);
                            this.mApis.put("-1252730367", xs1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(xs1Var, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Image.compressImage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = xs1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    ft1 ft1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ft1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ft1Var, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.closeTabBar")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = ft1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    ft1 ft1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ft1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ft1Var, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.closeTabBarRedDot")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = ft1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    bt1 bt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof bt1)) {
                            bt1Var = (bt1) obj;
                        } else {
                            bt1Var = new bt1(this.mSwanApiContext);
                            this.mApis.put("-246386074", bt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(bt1Var, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.hideNavigationBarLoading")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = bt1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    dt1 dt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof dt1)) {
                            dt1Var = (dt1) obj;
                        } else {
                            dt1Var = new dt1(this.mSwanApiContext);
                            this.mApis.put("-108978463", dt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(dt1Var, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.openMultiPicker")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 G = dt1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    dt1 dt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof dt1)) {
                            dt1Var = (dt1) obj;
                        } else {
                            dt1Var = new dt1(this.mSwanApiContext);
                            this.mApis.put("-108978463", dt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(dt1Var, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.openPicker")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 H = dt1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    ft1 ft1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ft1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ft1Var, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.openTabBar")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 C = ft1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    ct1 ct1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof ct1)) {
                            ct1Var = (ct1) obj;
                        } else {
                            ct1Var = new ct1(this.mSwanApiContext);
                            this.mApis.put("-1750613704", ct1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ct1Var, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.pageScrollTo")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = ct1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    bt1 bt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof bt1)) {
                            bt1Var = (bt1) obj;
                        } else {
                            bt1Var = new bt1(this.mSwanApiContext);
                            this.mApis.put("-246386074", bt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(bt1Var, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarColor")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 z = bt1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    bt1 bt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof bt1)) {
                            bt1Var = (bt1) obj;
                        } else {
                            bt1Var = new bt1(this.mSwanApiContext);
                            this.mApis.put("-246386074", bt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(bt1Var, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarTitle")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = bt1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    ft1 ft1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ft1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ft1Var, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.setTabBarItem")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 D = ft1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    dt1 dt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof dt1)) {
                            dt1Var = (dt1) obj;
                        } else {
                            dt1Var = new dt1(this.mSwanApiContext);
                            this.mApis.put("-108978463", dt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(dt1Var, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.showDatePickerView")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 L = dt1Var.L(str);
                        if (L == null) {
                            return "";
                        }
                        return L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    ht1 ht1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof ht1)) {
                            ht1Var = (ht1) obj;
                        } else {
                            ht1Var = new ht1(this.mSwanApiContext);
                            this.mApis.put("1172469410", ht1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ht1Var, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.showHalfScreenWebview")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 K = ht1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    zs1 zs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("5236036", zs1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(zs1Var, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.showLoading")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = zs1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    at1 at1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("1913747800", at1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(at1Var, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.showModal")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = at1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    bt1 bt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof bt1)) {
                            bt1Var = (bt1) obj;
                        } else {
                            bt1Var = new bt1(this.mSwanApiContext);
                            this.mApis.put("-246386074", bt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(bt1Var, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.showNavigationBarLoading")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 B = bt1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    gt1 gt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof gt1)) {
                            gt1Var = (gt1) obj;
                        } else {
                            gt1Var = new gt1(this.mSwanApiContext);
                            this.mApis.put("1159492510", gt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(gt1Var, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.showToast")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 Q = gt1Var.Q(str);
                        if (Q == null) {
                            return "";
                        }
                        return Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    et1 et1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof et1)) {
                            et1Var = (et1) obj;
                        } else {
                            et1Var = new et1(this.mSwanApiContext);
                            this.mApis.put("1165118609", et1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(et1Var, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.stopPullDownRefresh")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = et1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    dt1 dt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof dt1)) {
                            dt1Var = (dt1) obj;
                        } else {
                            dt1Var = new dt1(this.mSwanApiContext);
                            this.mApis.put("-108978463", dt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(dt1Var, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.updateMultiPicker")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 M = dt1Var.M(str);
                        if (M == null) {
                            return "";
                        }
                        return M.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    zs1 zs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("5236036", zs1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(zs1Var, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.hideLoading")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = zs1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    gt1 gt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof gt1)) {
                            gt1Var = (gt1) obj;
                        } else {
                            gt1Var = new gt1(this.mSwanApiContext);
                            this.mApis.put("1159492510", gt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(gt1Var, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Interaction.hideToast")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 K = gt1Var.K();
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    it1 it1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof it1)) {
                            it1Var = (it1) obj;
                        } else {
                            it1Var = new it1(this.mSwanApiContext);
                            this.mApis.put("-137346255", it1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(it1Var, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Keyboard.startKeyboardHeightChange")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 C = it1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    it1 it1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof it1)) {
                            it1Var = (it1) obj;
                        } else {
                            it1Var = new it1(this.mSwanApiContext);
                            this.mApis.put("-137346255", it1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(it1Var, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Keyboard.stopKeyboardHeightChange")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 D = it1Var.D();
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    jt1 jt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof jt1)) {
                            jt1Var = (jt1) obj;
                        } else {
                            jt1Var = new jt1(this.mSwanApiContext);
                            this.mApis.put("-397373095", jt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(jt1Var, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "LocationService.getLocation")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = jt1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    jt1 jt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof jt1)) {
                            jt1Var = (jt1) obj;
                        } else {
                            jt1Var = new jt1(this.mSwanApiContext);
                            this.mApis.put("-397373095", jt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(jt1Var, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "LocationService.startLocationUpdate")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = jt1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    jt1 jt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof jt1)) {
                            jt1Var = (jt1) obj;
                        } else {
                            jt1Var = new jt1(this.mSwanApiContext);
                            this.mApis.put("-397373095", jt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(jt1Var, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "LocationService.stopLocationUpdate")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 B = jt1Var.B();
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    av1 av1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof av1)) {
                            av1Var = (av1) obj;
                        } else {
                            av1Var = new av1(this.mSwanApiContext);
                            this.mApis.put("538070032", av1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(av1Var, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = av1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String callService(String str) {
                    mt1 mt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("-1076509454", mt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(mt1Var, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Network.callService")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = mt1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    tt1 tt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof tt1)) {
                            tt1Var = (tt1) obj;
                        } else {
                            tt1Var = new tt1(this.mSwanApiContext);
                            this.mApis.put("968563034", tt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(tt1Var, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Network.cancelRequest")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 D = tt1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    st1 st1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof st1)) {
                            st1Var = (st1) obj;
                        } else {
                            st1Var = new st1(this.mSwanApiContext);
                            this.mApis.put("453220699", st1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(st1Var, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Network.networkStatusChange")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = st1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    st1 st1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof st1)) {
                            st1Var = (st1) obj;
                        } else {
                            st1Var = new st1(this.mSwanApiContext);
                            this.mApis.put("453220699", st1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(st1Var, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Network.getNetworkType")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = st1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                @JavascriptInterface
                public String request(String str) {
                    InterceptResult invokeL2;
                    tt1 tt1Var;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        try {
                            dw1.c().a("request");
                            Object obj = this.mApis.get("968563034");
                            if (obj != null && (obj instanceof tt1)) {
                                tt1Var = (tt1) obj;
                            } else {
                                tt1Var = new tt1(this.mSwanApiContext);
                                this.mApis.put("968563034", tt1Var);
                            }
                            Pair<Boolean, ew1> a2 = gw1.a(tt1Var, "swanAPI/request");
                            if (((Boolean) a2.first).booleanValue()) {
                                a = ((ew1) a2.second).a();
                            } else if (m62.a(this.mSwanApiContext.f(), "Network.request")) {
                                a = new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            } else {
                                Pair<ew1, JSONObject> u = is1.u(str);
                                if (!((ew1) u.first).isSuccess()) {
                                    a = ((ew1) u.first).a();
                                } else {
                                    JSONObject jSONObject = (JSONObject) u.second;
                                    if (jSONObject == null) {
                                        a = ew1.a.a();
                                    } else {
                                        fw1 V = tt1Var.V(jSONObject);
                                        if (V == null) {
                                            a = "";
                                        } else {
                                            a = V.a();
                                        }
                                    }
                                }
                            }
                            return a;
                        } finally {
                        }
                    } else {
                        return (String) invokeL2.objValue;
                    }
                }
            });
            hashMap.put("_naPayment", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    cx2 cx2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof cx2)) {
                            cx2Var = (cx2) obj;
                        } else {
                            cx2Var = new cx2(this.mSwanApiContext);
                            this.mApis.put("-336396851", cx2Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(cx2Var, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Payment.chooseCoupon")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = cx2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    cx2 cx2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof cx2)) {
                            cx2Var = (cx2) obj;
                        } else {
                            cx2Var = new cx2(this.mSwanApiContext);
                            this.mApis.put("-336396851", cx2Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(cx2Var, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Payment.getPaymentInfo")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = cx2Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    sw2 sw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof sw2)) {
                            sw2Var = (sw2) obj;
                        } else {
                            sw2Var = new sw2(this.mSwanApiContext);
                            this.mApis.put("1854689529", sw2Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(sw2Var, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Payment.requestThirdPayment")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = sw2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    cx2 cx2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof cx2)) {
                            cx2Var = (cx2) obj;
                        } else {
                            cx2Var = new cx2(this.mSwanApiContext);
                            this.mApis.put("-336396851", cx2Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(cx2Var, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Payment.setPaymentInfo")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 z = cx2Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    nz2 nz2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof nz2)) {
                            nz2Var = (nz2) obj;
                        } else {
                            nz2Var = new nz2(this.mSwanApiContext);
                            this.mApis.put("-254510461", nz2Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(nz2Var, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Plugin.invokePluginChooseAddress")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = nz2Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    nz2 nz2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof nz2)) {
                            nz2Var = (nz2) obj;
                        } else {
                            nz2Var = new nz2(this.mSwanApiContext);
                            this.mApis.put("-254510461", nz2Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(nz2Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 z = nz2Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    nz2 nz2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof nz2)) {
                            nz2Var = (nz2) obj;
                        } else {
                            nz2Var = new nz2(this.mSwanApiContext);
                            this.mApis.put("-254510461", nz2Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(nz2Var, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Plugin.invokePluginPayment")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = nz2Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    g82 g82Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof g82)) {
                            g82Var = (g82) obj;
                        } else {
                            g82Var = new g82(this.mSwanApiContext);
                            this.mApis.put("-2068479848", g82Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(g82Var, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Prefetch.prefetchResources")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = g82Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    y62 y62Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof y62)) {
                            y62Var = (y62) obj;
                        } else {
                            y62Var = new y62(this.mSwanApiContext);
                            this.mApis.put("423661539", y62Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(y62Var, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Preload.preloadStatus")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = y62Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    ig3 ig3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof ig3)) {
                            ig3Var = (ig3) obj;
                        } else {
                            ig3Var = new ig3(this.mSwanApiContext);
                            this.mApis.put("-1929343869", ig3Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ig3Var, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "PrivateFile.uploadFileToBos")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 C = ig3Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    xt1 xt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof xt1)) {
                            xt1Var = (xt1) obj;
                        } else {
                            xt1Var = new xt1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", xt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(xt1Var, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Router.hideModalPage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = xt1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    xt1 xt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof xt1)) {
                            xt1Var = (xt1) obj;
                        } else {
                            xt1Var = new xt1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", xt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(xt1Var, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Router.navigateBack")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 B = xt1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    yt1 yt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof yt1)) {
                            yt1Var = (yt1) obj;
                        } else {
                            yt1Var = new yt1(this.mSwanApiContext);
                            this.mApis.put("1968522584", yt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(yt1Var, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Router.navigateTo")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 H = yt1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    au1 au1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof au1)) {
                            au1Var = (au1) obj;
                        } else {
                            au1Var = new au1(this.mSwanApiContext);
                            this.mApis.put("1317280190", au1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(au1Var, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Router.reLaunch")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = au1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    bu1 bu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof bu1)) {
                            bu1Var = (bu1) obj;
                        } else {
                            bu1Var = new bu1(this.mSwanApiContext);
                            this.mApis.put("-420075743", bu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(bu1Var, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Router.reLoadErrorPage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = bu1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    zt1 zt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof zt1)) {
                            zt1Var = (zt1) obj;
                        } else {
                            zt1Var = new zt1(this.mSwanApiContext);
                            this.mApis.put("1792515533", zt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(zt1Var, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Router.redirectTo")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 D = zt1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    yt1 yt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof yt1)) {
                            yt1Var = (yt1) obj;
                        } else {
                            yt1Var = new yt1(this.mSwanApiContext);
                            this.mApis.put("1968522584", yt1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(yt1Var, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Router.showModalPage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 J = yt1Var.J(str);
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    eu1 eu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof eu1)) {
                            eu1Var = (eu1) obj;
                        } else {
                            eu1Var = new eu1(this.mSwanApiContext);
                            this.mApis.put("-594895721", eu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(eu1Var, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Setting.getAppInfoSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 F = eu1Var.F();
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    eu1 eu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof eu1)) {
                            eu1Var = (eu1) obj;
                        } else {
                            eu1Var = new eu1(this.mSwanApiContext);
                            this.mApis.put("-594895721", eu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(eu1Var, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Setting.getSlaveIdSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 H = eu1Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    du1 du1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof du1)) {
                            du1Var = (du1) obj;
                        } else {
                            du1Var = new du1(this.mSwanApiContext);
                            this.mApis.put("450273045", du1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(du1Var, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Setting.isAllowedAdOpenAppSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = du1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    eu1 eu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof eu1)) {
                            eu1Var = (eu1) obj;
                        } else {
                            eu1Var = new eu1(this.mSwanApiContext);
                            this.mApis.put("-594895721", eu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(eu1Var, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Setting.getSetting")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 G = eu1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    eu1 eu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof eu1)) {
                            eu1Var = (eu1) obj;
                        } else {
                            eu1Var = new eu1(this.mSwanApiContext);
                            this.mApis.put("-594895721", eu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(eu1Var, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Setting.getSwanId")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 I = eu1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    eu1 eu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof eu1)) {
                            eu1Var = (eu1) obj;
                        } else {
                            eu1Var = new eu1(this.mSwanApiContext);
                            this.mApis.put("-594895721", eu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(eu1Var, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Setting.getUserInfo")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 J = eu1Var.J(str);
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    cb3 cb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof cb3)) {
                            cb3Var = (cb3) obj;
                        } else {
                            cb3Var = new cb3(this.mSwanApiContext);
                            this.mApis.put("712777136", cb3Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(cb3Var, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = cb3Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    hu1 hu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", hu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(hu1Var, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = hu1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    hu1 hu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", hu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(hu1Var, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorageSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 C = hu1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    gu1 gu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("130910081", gu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(gu1Var, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.clearStorage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = gu1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    gu1 gu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("130910081", gu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(gu1Var, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.clearStorageSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 C = gu1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    hu1 hu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", hu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(hu1Var, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfo")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 G = hu1Var.G();
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    hu1 hu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", hu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(hu1Var, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfoSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 J = hu1Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    gu1 gu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("130910081", gu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(gu1Var, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.getStorageInfo")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 G = gu1Var.G();
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    gu1 gu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("130910081", gu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(gu1Var, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.getStorageInfoSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 J = gu1Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    hu1 hu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", hu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(hu1Var, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.getGlobalStorage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 D = hu1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    hu1 hu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", hu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(hu1Var, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 K = hu1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    gu1 gu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("130910081", gu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(gu1Var, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.getStorage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 D = gu1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    gu1 gu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("130910081", gu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(gu1Var, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.getStorageInfoAsync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 H = gu1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    gu1 gu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("130910081", gu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(gu1Var, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.getStorageSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 K = gu1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    hu1 hu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", hu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(hu1Var, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 R = hu1Var.R(str);
                        if (R == null) {
                            return "";
                        }
                        return R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    hu1 hu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", hu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(hu1Var, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorageSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 T = hu1Var.T(str);
                        if (T == null) {
                            return "";
                        }
                        return T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    gu1 gu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("130910081", gu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(gu1Var, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.removeStorage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 R = gu1Var.R(str);
                        if (R == null) {
                            return "";
                        }
                        return R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    gu1 gu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("130910081", gu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(gu1Var, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.removeStorageSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 T = gu1Var.T(str);
                        if (T == null) {
                            return "";
                        }
                        return T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    hu1 hu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", hu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(hu1Var, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.setGlobalStorage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 U = hu1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    hu1 hu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", hu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(hu1Var, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.setGlobalStorageSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 W = hu1Var.W(str);
                        if (W == null) {
                            return "";
                        }
                        return W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    gu1 gu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("130910081", gu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(gu1Var, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.setStorage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 U = gu1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    gu1 gu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("130910081", gu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(gu1Var, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Storage.setStorageSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 W = gu1Var.W(str);
                        if (W == null) {
                            return "";
                        }
                        return W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    ju1 ju1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof ju1)) {
                            ju1Var = (ju1) obj;
                        } else {
                            ju1Var = new ju1(this.mSwanApiContext);
                            this.mApis.put("823117982", ju1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ju1Var, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Subscription.requestSubscribeFormId")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 E = ju1Var.E(str);
                        if (E == null) {
                            return "";
                        }
                        return E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    ku1 ku1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof ku1)) {
                            ku1Var = (ku1) obj;
                        } else {
                            ku1Var = new ku1(this.mSwanApiContext);
                            this.mApis.put("-947445811", ku1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ku1Var, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Subscription.subscribeService")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 F = ku1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    ru1 ru1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof ru1)) {
                            ru1Var = (ru1) obj;
                        } else {
                            ru1Var = new ru1(this.mSwanApiContext);
                            this.mApis.put("1936205521", ru1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ru1Var, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.exitFullScreen")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = ru1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    qu1 qu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof qu1)) {
                            qu1Var = (qu1) obj;
                        } else {
                            qu1Var = new qu1(this.mSwanApiContext);
                            this.mApis.put("1694151270", qu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(qu1Var, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.getDeviceInfo")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = qu1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    su1 su1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof su1)) {
                            su1Var = (su1) obj;
                        } else {
                            su1Var = new su1(this.mSwanApiContext);
                            this.mApis.put("-1321681619", su1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(su1Var, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.getDeviceProfile")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = su1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    tu1 tu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof tu1)) {
                            tu1Var = (tu1) obj;
                        } else {
                            tu1Var = new tu1(this.mSwanApiContext);
                            this.mApis.put("-1569246082", tu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(tu1Var, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.makePhoneCall")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = tu1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    vu1 vu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof vu1)) {
                            vu1Var = (vu1) obj;
                        } else {
                            vu1Var = new vu1(this.mSwanApiContext);
                            this.mApis.put("1099851202", vu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(vu1Var, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.openSMSPanel")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = vu1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    uu1 uu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof uu1)) {
                            uu1Var = (uu1) obj;
                        } else {
                            uu1Var = new uu1(this.mSwanApiContext);
                            this.mApis.put("-1707203360", uu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(uu1Var, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.requestFullScreen")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 F = uu1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    ou1 ou1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof ou1)) {
                            ou1Var = (ou1) obj;
                        } else {
                            ou1Var = new ou1(this.mSwanApiContext);
                            this.mApis.put("-518757484", ou1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ou1Var, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.setClipboardData")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = ou1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    yt2 yt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof yt2)) {
                            yt2Var = (yt2) obj;
                        } else {
                            yt2Var = new yt2(this.mSwanApiContext);
                            this.mApis.put("1161486049", yt2Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(yt2Var, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.setErrorPageType")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = yt2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    yu1 yu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof yu1)) {
                            yu1Var = (yu1) obj;
                        } else {
                            yu1Var = new yu1(this.mSwanApiContext);
                            this.mApis.put("447234992", yu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(yu1Var, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.setMediaVolume")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 z = yu1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    mu1 mu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof mu1)) {
                            mu1Var = (mu1) obj;
                        } else {
                            mu1Var = new mu1(this.mSwanApiContext);
                            this.mApis.put("1372680763", mu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(mu1Var, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.startAccelerometer")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = mu1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    pu1 pu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof pu1)) {
                            pu1Var = (pu1) obj;
                        } else {
                            pu1Var = new pu1(this.mSwanApiContext);
                            this.mApis.put("1689255576", pu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(pu1Var, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.startCompass")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = pu1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    nu1 nu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof nu1)) {
                            nu1Var = (nu1) obj;
                        } else {
                            nu1Var = new nu1(this.mSwanApiContext);
                            this.mApis.put("99997465", nu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(nu1Var, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.getBrightness")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = nu1Var.y();
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    ou1 ou1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof ou1)) {
                            ou1Var = (ou1) obj;
                        } else {
                            ou1Var = new ou1(this.mSwanApiContext);
                            this.mApis.put("-518757484", ou1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ou1Var, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.getClipboardData")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = ou1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    yu1 yu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof yu1)) {
                            yu1Var = (yu1) obj;
                        } else {
                            yu1Var = new yu1(this.mSwanApiContext);
                            this.mApis.put("447234992", yu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(yu1Var, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.getMediaVolume")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = yu1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    mu1 mu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof mu1)) {
                            mu1Var = (mu1) obj;
                        } else {
                            mu1Var = new mu1(this.mSwanApiContext);
                            this.mApis.put("1372680763", mu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(mu1Var, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.stopAccelerometer")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 B = mu1Var.B();
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    pu1 pu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof pu1)) {
                            pu1Var = (pu1) obj;
                        } else {
                            pu1Var = new pu1(this.mSwanApiContext);
                            this.mApis.put("1689255576", pu1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(pu1Var, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "System.stopCompass")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 z = pu1Var.z();
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    jv1 jv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof jv1)) {
                            jv1Var = (jv1) obj;
                        } else {
                            jv1Var = new jv1(this.mSwanApiContext);
                            this.mApis.put("201194468", jv1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(jv1Var, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.addToDesktop")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 B = jv1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    fv1 fv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof fv1)) {
                            fv1Var = (fv1) obj;
                        } else {
                            fv1Var = new fv1(this.mSwanApiContext);
                            this.mApis.put("-1412306947", fv1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(fv1Var, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.calcMD5")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = fv1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    gv1 gv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof gv1)) {
                            gv1Var = (gv1) obj;
                        } else {
                            gv1Var = new gv1(this.mSwanApiContext);
                            this.mApis.put("1626415364", gv1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(gv1Var, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.checkAppInstalled")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = gv1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    iv1 iv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof iv1)) {
                            iv1Var = (iv1) obj;
                        } else {
                            iv1Var = new iv1(this.mSwanApiContext);
                            this.mApis.put("-836768778", iv1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(iv1Var, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfo")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = iv1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    kv1 kv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof kv1)) {
                            kv1Var = (kv1) obj;
                        } else {
                            kv1Var = new kv1(this.mSwanApiContext);
                            this.mApis.put("-810858308", kv1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(kv1Var, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.getPerformanceLevel")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = kv1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    ov1 ov1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof ov1)) {
                            ov1Var = (ov1) obj;
                        } else {
                            ov1Var = new ov1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", ov1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ov1Var, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.getSystemInfoAsync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 I = ov1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    lv1 lv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof lv1)) {
                            lv1Var = (lv1) obj;
                        } else {
                            lv1Var = new lv1(this.mSwanApiContext);
                            this.mApis.put("-2097727681", lv1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(lv1Var, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.handleException")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = lv1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    hv1 hv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof hv1)) {
                            hv1Var = (hv1) obj;
                        } else {
                            hv1Var = new hv1(this.mSwanApiContext);
                            this.mApis.put("2084449317", hv1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(hv1Var, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.hasCloseHandler")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = hv1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    k83 k83Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof k83)) {
                            k83Var = (k83) obj;
                        } else {
                            k83Var = new k83(this.mSwanApiContext);
                            this.mApis.put("1031678042", k83Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(k83Var, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.hideCaptureScreenShareDialog")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 x = k83Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    mv1 mv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof mv1)) {
                            mv1Var = (mv1) obj;
                        } else {
                            mv1Var = new mv1(this.mSwanApiContext);
                            this.mApis.put("1751900130", mv1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(mv1Var, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.logToFile")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = mv1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    l73 l73Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof l73)) {
                            l73Var = (l73) obj;
                        } else {
                            l73Var = new l73(this.mSwanApiContext);
                            this.mApis.put("1748196865", l73Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(l73Var, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.preloadPackage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = l73Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    nv1 nv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof nv1)) {
                            nv1Var = (nv1) obj;
                        } else {
                            nv1Var = new nv1(this.mSwanApiContext);
                            this.mApis.put("589529211", nv1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(nv1Var, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.previewImage")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 B = nv1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    qv1 qv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof qv1)) {
                            qv1Var = (qv1) obj;
                        } else {
                            qv1Var = new qv1(this.mSwanApiContext);
                            this.mApis.put("-577481801", qv1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(qv1Var, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.ubcFlowJar")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 I = qv1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    ov1 ov1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof ov1)) {
                            ov1Var = (ov1) obj;
                        } else {
                            ov1Var = new ov1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", ov1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ov1Var, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfoSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 E = ov1Var.E();
                        if (E == null) {
                            return "";
                        }
                        return E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    ov1 ov1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof ov1)) {
                            ov1Var = (ov1) obj;
                        } else {
                            ov1Var = new ov1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", ov1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ov1Var, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.getSystemInfo")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 H = ov1Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    ov1 ov1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof ov1)) {
                            ov1Var = (ov1) obj;
                        } else {
                            ov1Var = new ov1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", ov1Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ov1Var, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Utils.getSystemInfoSync")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 J = ov1Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    ve3 ve3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ve3)) {
                            ve3Var = (ve3) obj;
                        } else {
                            ve3Var = new ve3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ve3Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ve3Var, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Wifi.connectWifi")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 A = ve3Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    ve3 ve3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ve3)) {
                            ve3Var = (ve3) obj;
                        } else {
                            ve3Var = new ve3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ve3Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ve3Var, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Wifi.getConnectedWifi")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 B = ve3Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    ve3 ve3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ve3)) {
                            ve3Var = (ve3) obj;
                        } else {
                            ve3Var = new ve3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ve3Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ve3Var, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Wifi.getWifiList")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 C = ve3Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    ve3 ve3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ve3)) {
                            ve3Var = (ve3) obj;
                        } else {
                            ve3Var = new ve3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ve3Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ve3Var, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Wifi.startWifi")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 G = ve3Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    ve3 ve3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ve3)) {
                            ve3Var = (ve3) obj;
                        } else {
                            ve3Var = new ve3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ve3Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ve3Var, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "Wifi.stopWifi")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 H = ve3Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}
