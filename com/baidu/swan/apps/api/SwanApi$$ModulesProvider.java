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
import com.baidu.tieba.bb3;
import com.baidu.tieba.bt1;
import com.baidu.tieba.bx2;
import com.baidu.tieba.ct1;
import com.baidu.tieba.cu1;
import com.baidu.tieba.cw1;
import com.baidu.tieba.dt1;
import com.baidu.tieba.du1;
import com.baidu.tieba.dw1;
import com.baidu.tieba.et1;
import com.baidu.tieba.ev1;
import com.baidu.tieba.ew1;
import com.baidu.tieba.f82;
import com.baidu.tieba.fs1;
import com.baidu.tieba.ft1;
import com.baidu.tieba.fu1;
import com.baidu.tieba.fv1;
import com.baidu.tieba.fw1;
import com.baidu.tieba.gt1;
import com.baidu.tieba.gu1;
import com.baidu.tieba.gv1;
import com.baidu.tieba.hg3;
import com.baidu.tieba.hh2;
import com.baidu.tieba.hs1;
import com.baidu.tieba.ht1;
import com.baidu.tieba.hv1;
import com.baidu.tieba.is1;
import com.baidu.tieba.it1;
import com.baidu.tieba.iu1;
import com.baidu.tieba.iv1;
import com.baidu.tieba.j83;
import com.baidu.tieba.ju1;
import com.baidu.tieba.jv1;
import com.baidu.tieba.k73;
import com.baidu.tieba.ks1;
import com.baidu.tieba.kv1;
import com.baidu.tieba.l62;
import com.baidu.tieba.ls1;
import com.baidu.tieba.lt1;
import com.baidu.tieba.lu1;
import com.baidu.tieba.lv1;
import com.baidu.tieba.ms1;
import com.baidu.tieba.mu1;
import com.baidu.tieba.mv1;
import com.baidu.tieba.mz2;
import com.baidu.tieba.ns1;
import com.baidu.tieba.nu1;
import com.baidu.tieba.nv1;
import com.baidu.tieba.os1;
import com.baidu.tieba.ou1;
import com.baidu.tieba.pu1;
import com.baidu.tieba.pv1;
import com.baidu.tieba.qs1;
import com.baidu.tieba.qu1;
import com.baidu.tieba.rt1;
import com.baidu.tieba.ru1;
import com.baidu.tieba.rw2;
import com.baidu.tieba.ss1;
import com.baidu.tieba.st1;
import com.baidu.tieba.su1;
import com.baidu.tieba.ts1;
import com.baidu.tieba.tu1;
import com.baidu.tieba.ue3;
import com.baidu.tieba.ur1;
import com.baidu.tieba.uu1;
import com.baidu.tieba.vk1;
import com.baidu.tieba.vt2;
import com.baidu.tieba.ws1;
import com.baidu.tieba.wt1;
import com.baidu.tieba.x62;
import com.baidu.tieba.xt1;
import com.baidu.tieba.xt2;
import com.baidu.tieba.xu1;
import com.baidu.tieba.ys1;
import com.baidu.tieba.yt1;
import com.baidu.tieba.zs1;
import com.baidu.tieba.zt1;
import com.baidu.tieba.zu1;
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

    public static Map<String, Object> getV8ApiModules(final fs1 fs1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fs1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    ls1 ls1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof ls1)) {
                            ls1Var = (ls1) obj;
                        } else {
                            ls1Var = new ls1(this.mSwanApiContext);
                            this.mApis.put("1930258908", ls1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ls1Var, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Account.checkSession")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = ls1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    ms1 ms1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ms1)) {
                            ms1Var = (ms1) obj;
                        } else {
                            ms1Var = new ms1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ms1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ms1Var, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Account.getLoginCode")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 C = ms1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    ns1 ns1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof ns1)) {
                            ns1Var = (ns1) obj;
                        } else {
                            ns1Var = new ns1(this.mSwanApiContext);
                            this.mApis.put("1754780133", ns1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ns1Var, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Account.getOpenId")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = ns1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    ur1 ur1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof ur1)) {
                            ur1Var = (ur1) obj;
                        } else {
                            ur1Var = new ur1(this.mSwanApiContext);
                            this.mApis.put("-343998465", ur1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ur1Var, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Account.getUnionBDUSS")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = ur1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    ms1 ms1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ms1)) {
                            ms1Var = (ms1) obj;
                        } else {
                            ms1Var = new ms1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ms1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ms1Var, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Account.login")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 I = ms1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    ks1 ks1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof ks1)) {
                            ks1Var = (ks1) obj;
                        } else {
                            ks1Var = new ks1(this.mSwanApiContext);
                            this.mApis.put("-337742792", ks1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ks1Var, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Account.isBaiduAccountSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = ks1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    ms1 ms1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ms1)) {
                            ms1Var = (ms1) obj;
                        } else {
                            ms1Var = new ms1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ms1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ms1Var, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Account.isLoginSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 H = ms1Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    os1 os1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof os1)) {
                            os1Var = (os1) obj;
                        } else {
                            os1Var = new os1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", os1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(os1Var, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Basic.loadSubPackage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 F = os1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    os1 os1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof os1)) {
                            os1Var = (os1) obj;
                        } else {
                            os1Var = new os1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", os1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(os1Var, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Basic.loadSubPackages")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 G = os1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    vk1 vk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof vk1)) {
                            vk1Var = (vk1) obj;
                        } else {
                            vk1Var = new vk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", vk1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(vk1Var, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Bookshelf.deleteBookshelf")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 K = vk1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    vk1 vk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof vk1)) {
                            vk1Var = (vk1) obj;
                        } else {
                            vk1Var = new vk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", vk1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(vk1Var, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Bookshelf.insertBookshelf")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 P = vk1Var.P(str);
                        if (P == null) {
                            return "";
                        }
                        return P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    vk1 vk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof vk1)) {
                            vk1Var = (vk1) obj;
                        } else {
                            vk1Var = new vk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", vk1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(vk1Var, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Bookshelf.navigateToBookshelf")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 U = vk1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    vk1 vk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof vk1)) {
                            vk1Var = (vk1) obj;
                        } else {
                            vk1Var = new vk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", vk1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(vk1Var, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Bookshelf.queryBookshelf")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 V = vk1Var.V(str);
                        if (V == null) {
                            return "";
                        }
                        return V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    vk1 vk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof vk1)) {
                            vk1Var = (vk1) obj;
                        } else {
                            vk1Var = new vk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", vk1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(vk1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Bookshelf.updateBookshelfReadTime")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 X = vk1Var.X(str);
                        if (X == null) {
                            return "";
                        }
                        return X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    is1 is1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof is1)) {
                            is1Var = (is1) obj;
                        } else {
                            is1Var = new is1(this.mSwanApiContext);
                            this.mApis.put("-277316359", is1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(is1Var, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Coupon.getPlatformCoupons")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = is1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    is1 is1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof is1)) {
                            is1Var = (is1) obj;
                        } else {
                            is1Var = new is1(this.mSwanApiContext);
                            this.mApis.put("-277316359", is1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(is1Var, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Coupon.getUserCoupons")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 z = is1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    is1 is1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof is1)) {
                            is1Var = (is1) obj;
                        } else {
                            is1Var = new is1(this.mSwanApiContext);
                            this.mApis.put("-277316359", is1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(is1Var, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Coupon.takeCoupons")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 C = is1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    qs1 qs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof qs1)) {
                            qs1Var = (qs1) obj;
                        } else {
                            qs1Var = new qs1(this.mSwanApiContext);
                            this.mApis.put("-1225406515", qs1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(qs1Var, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Favorite.getFavorStatus")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = qs1Var.x(str);
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
                        Pair<Boolean, dw1> a = fw1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Favorite.showFavoriteGuide")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 G = showFavoriteGuideApi.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    ss1 ss1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof ss1)) {
                            ss1Var = (ss1) obj;
                        } else {
                            ss1Var = new ss1(this.mSwanApiContext);
                            this.mApis.put("-2057135077", ss1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ss1Var, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "File.shareFile")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = ss1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    hh2 hh2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof hh2)) {
                            hh2Var = (hh2) obj;
                        } else {
                            hh2Var = new hh2(this.mSwanApiContext);
                            this.mApis.put("2077414795", hh2Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(hh2Var, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = hh2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    hh2 hh2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof hh2)) {
                            hh2Var = (hh2) obj;
                        } else {
                            hh2Var = new hh2(this.mSwanApiContext);
                            this.mApis.put("2077414795", hh2Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(hh2Var, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessageSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = hh2Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String download(String str) {
                    ts1 ts1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof ts1)) {
                            ts1Var = (ts1) obj;
                        } else {
                            ts1Var = new ts1(this.mSwanApiContext);
                            this.mApis.put("-170124576", ts1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ts1Var, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "HostDownloadManager.download")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = ts1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    ts1 ts1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof ts1)) {
                            ts1Var = (ts1) obj;
                        } else {
                            ts1Var = new ts1(this.mSwanApiContext);
                            this.mApis.put("-170124576", ts1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ts1Var, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "HostDownloadManager.openFile")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 z = ts1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    ts1 ts1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof ts1)) {
                            ts1Var = (ts1) obj;
                        } else {
                            ts1Var = new ts1(this.mSwanApiContext);
                            this.mApis.put("-170124576", ts1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ts1Var, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "HostDownloadManager.query")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 query = ts1Var.query(str);
                        if (query == null) {
                            return "";
                        }
                        return query.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    ts1 ts1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof ts1)) {
                            ts1Var = (ts1) obj;
                        } else {
                            ts1Var = new ts1(this.mSwanApiContext);
                            this.mApis.put("-170124576", ts1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ts1Var, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "HostDownloadManager.openDownloadCenter")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = ts1Var.y();
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naImage", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    vt2 vt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof vt2)) {
                            vt2Var = (vt2) obj;
                        } else {
                            vt2Var = new vt2(this.mSwanApiContext);
                            this.mApis.put("1445003743", vt2Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(vt2Var, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Image.callImageMenu")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = vt2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    ws1 ws1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof ws1)) {
                            ws1Var = (ws1) obj;
                        } else {
                            ws1Var = new ws1(this.mSwanApiContext);
                            this.mApis.put("-1252730367", ws1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ws1Var, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Image.compressImage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = ws1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    et1 et1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof et1)) {
                            et1Var = (et1) obj;
                        } else {
                            et1Var = new et1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", et1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(et1Var, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.closeTabBar")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = et1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    et1 et1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof et1)) {
                            et1Var = (et1) obj;
                        } else {
                            et1Var = new et1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", et1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(et1Var, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.closeTabBarRedDot")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = et1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    at1 at1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("-246386074", at1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(at1Var, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.hideNavigationBarLoading")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = at1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    ct1 ct1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ct1)) {
                            ct1Var = (ct1) obj;
                        } else {
                            ct1Var = new ct1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ct1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ct1Var, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.openMultiPicker")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 G = ct1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    ct1 ct1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ct1)) {
                            ct1Var = (ct1) obj;
                        } else {
                            ct1Var = new ct1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ct1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ct1Var, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.openPicker")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 H = ct1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    et1 et1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof et1)) {
                            et1Var = (et1) obj;
                        } else {
                            et1Var = new et1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", et1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(et1Var, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.openTabBar")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 C = et1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    bt1 bt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof bt1)) {
                            bt1Var = (bt1) obj;
                        } else {
                            bt1Var = new bt1(this.mSwanApiContext);
                            this.mApis.put("-1750613704", bt1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(bt1Var, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.pageScrollTo")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = bt1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    at1 at1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("-246386074", at1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(at1Var, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarColor")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 z = at1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    at1 at1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("-246386074", at1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(at1Var, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarTitle")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = at1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    et1 et1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof et1)) {
                            et1Var = (et1) obj;
                        } else {
                            et1Var = new et1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", et1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(et1Var, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.setTabBarItem")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 D = et1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    ct1 ct1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ct1)) {
                            ct1Var = (ct1) obj;
                        } else {
                            ct1Var = new ct1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ct1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ct1Var, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.showDatePickerView")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 L = ct1Var.L(str);
                        if (L == null) {
                            return "";
                        }
                        return L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    gt1 gt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof gt1)) {
                            gt1Var = (gt1) obj;
                        } else {
                            gt1Var = new gt1(this.mSwanApiContext);
                            this.mApis.put("1172469410", gt1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(gt1Var, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.showHalfScreenWebview")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 K = gt1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    ys1 ys1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof ys1)) {
                            ys1Var = (ys1) obj;
                        } else {
                            ys1Var = new ys1(this.mSwanApiContext);
                            this.mApis.put("5236036", ys1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ys1Var, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.showLoading")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = ys1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    zs1 zs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("1913747800", zs1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(zs1Var, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.showModal")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = zs1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    at1 at1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("-246386074", at1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(at1Var, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.showNavigationBarLoading")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 B = at1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    ft1 ft1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("1159492510", ft1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ft1Var, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.showToast")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 Q = ft1Var.Q(str);
                        if (Q == null) {
                            return "";
                        }
                        return Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    dt1 dt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof dt1)) {
                            dt1Var = (dt1) obj;
                        } else {
                            dt1Var = new dt1(this.mSwanApiContext);
                            this.mApis.put("1165118609", dt1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(dt1Var, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.stopPullDownRefresh")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = dt1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    ct1 ct1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ct1)) {
                            ct1Var = (ct1) obj;
                        } else {
                            ct1Var = new ct1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ct1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ct1Var, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.updateMultiPicker")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 M = ct1Var.M(str);
                        if (M == null) {
                            return "";
                        }
                        return M.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    ys1 ys1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof ys1)) {
                            ys1Var = (ys1) obj;
                        } else {
                            ys1Var = new ys1(this.mSwanApiContext);
                            this.mApis.put("5236036", ys1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ys1Var, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.hideLoading")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = ys1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    ft1 ft1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("1159492510", ft1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ft1Var, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.hideToast")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 K = ft1Var.K();
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    ht1 ht1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof ht1)) {
                            ht1Var = (ht1) obj;
                        } else {
                            ht1Var = new ht1(this.mSwanApiContext);
                            this.mApis.put("-137346255", ht1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ht1Var, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Keyboard.startKeyboardHeightChange")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 C = ht1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    ht1 ht1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof ht1)) {
                            ht1Var = (ht1) obj;
                        } else {
                            ht1Var = new ht1(this.mSwanApiContext);
                            this.mApis.put("-137346255", ht1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ht1Var, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Keyboard.stopKeyboardHeightChange")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 D = ht1Var.D();
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    it1 it1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof it1)) {
                            it1Var = (it1) obj;
                        } else {
                            it1Var = new it1(this.mSwanApiContext);
                            this.mApis.put("-397373095", it1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(it1Var, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "LocationService.getLocation")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = it1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    it1 it1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof it1)) {
                            it1Var = (it1) obj;
                        } else {
                            it1Var = new it1(this.mSwanApiContext);
                            this.mApis.put("-397373095", it1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(it1Var, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "LocationService.startLocationUpdate")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = it1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    it1 it1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof it1)) {
                            it1Var = (it1) obj;
                        } else {
                            it1Var = new it1(this.mSwanApiContext);
                            this.mApis.put("-397373095", it1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(it1Var, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "LocationService.stopLocationUpdate")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 B = it1Var.B();
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    zu1 zu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof zu1)) {
                            zu1Var = (zu1) obj;
                        } else {
                            zu1Var = new zu1(this.mSwanApiContext);
                            this.mApis.put("538070032", zu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(zu1Var, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = zu1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String callService(String str) {
                    lt1 lt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof lt1)) {
                            lt1Var = (lt1) obj;
                        } else {
                            lt1Var = new lt1(this.mSwanApiContext);
                            this.mApis.put("-1076509454", lt1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(lt1Var, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Network.callService")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = lt1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    st1 st1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof st1)) {
                            st1Var = (st1) obj;
                        } else {
                            st1Var = new st1(this.mSwanApiContext);
                            this.mApis.put("968563034", st1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(st1Var, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Network.cancelRequest")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 D = st1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    rt1 rt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof rt1)) {
                            rt1Var = (rt1) obj;
                        } else {
                            rt1Var = new rt1(this.mSwanApiContext);
                            this.mApis.put("453220699", rt1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(rt1Var, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Network.networkStatusChange")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = rt1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    rt1 rt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof rt1)) {
                            rt1Var = (rt1) obj;
                        } else {
                            rt1Var = new rt1(this.mSwanApiContext);
                            this.mApis.put("453220699", rt1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(rt1Var, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Network.getNetworkType")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = rt1Var.x();
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
                    st1 st1Var;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, jsObject)) == null) {
                        try {
                            cw1.c().a("request");
                            Object obj = this.mApis.get("968563034");
                            if (obj != null && (obj instanceof st1)) {
                                st1Var = (st1) obj;
                            } else {
                                st1Var = new st1(this.mSwanApiContext);
                                this.mApis.put("968563034", st1Var);
                            }
                            Pair<Boolean, dw1> a2 = fw1.a(st1Var, "swanAPI/request");
                            if (((Boolean) a2.first).booleanValue()) {
                                a = ((dw1) a2.second).a();
                            } else if (l62.a(this.mSwanApiContext.f(), "Network.request")) {
                                a = new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            } else {
                                Pair<dw1, JSONObject> t = hs1.t(jsObject);
                                if (!((dw1) t.first).isSuccess()) {
                                    a = ((dw1) t.first).a();
                                } else {
                                    JSONObject jSONObject = (JSONObject) t.second;
                                    if (jSONObject == null) {
                                        a = dw1.a.a();
                                    } else {
                                        ew1 V = st1Var.V(jSONObject);
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
            hashMap.put("_naPayment", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    bx2 bx2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof bx2)) {
                            bx2Var = (bx2) obj;
                        } else {
                            bx2Var = new bx2(this.mSwanApiContext);
                            this.mApis.put("-336396851", bx2Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(bx2Var, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Payment.chooseCoupon")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = bx2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    bx2 bx2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof bx2)) {
                            bx2Var = (bx2) obj;
                        } else {
                            bx2Var = new bx2(this.mSwanApiContext);
                            this.mApis.put("-336396851", bx2Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(bx2Var, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Payment.getPaymentInfo")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = bx2Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    rw2 rw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof rw2)) {
                            rw2Var = (rw2) obj;
                        } else {
                            rw2Var = new rw2(this.mSwanApiContext);
                            this.mApis.put("1854689529", rw2Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(rw2Var, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Payment.requestThirdPayment")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = rw2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    bx2 bx2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof bx2)) {
                            bx2Var = (bx2) obj;
                        } else {
                            bx2Var = new bx2(this.mSwanApiContext);
                            this.mApis.put("-336396851", bx2Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(bx2Var, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Payment.setPaymentInfo")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 z = bx2Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    mz2 mz2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof mz2)) {
                            mz2Var = (mz2) obj;
                        } else {
                            mz2Var = new mz2(this.mSwanApiContext);
                            this.mApis.put("-254510461", mz2Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(mz2Var, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Plugin.invokePluginChooseAddress")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = mz2Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    mz2 mz2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof mz2)) {
                            mz2Var = (mz2) obj;
                        } else {
                            mz2Var = new mz2(this.mSwanApiContext);
                            this.mApis.put("-254510461", mz2Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(mz2Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 z = mz2Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    mz2 mz2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof mz2)) {
                            mz2Var = (mz2) obj;
                        } else {
                            mz2Var = new mz2(this.mSwanApiContext);
                            this.mApis.put("-254510461", mz2Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(mz2Var, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Plugin.invokePluginPayment")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = mz2Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    f82 f82Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof f82)) {
                            f82Var = (f82) obj;
                        } else {
                            f82Var = new f82(this.mSwanApiContext);
                            this.mApis.put("-2068479848", f82Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(f82Var, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Prefetch.prefetchResources")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = f82Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    x62 x62Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof x62)) {
                            x62Var = (x62) obj;
                        } else {
                            x62Var = new x62(this.mSwanApiContext);
                            this.mApis.put("423661539", x62Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(x62Var, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Preload.preloadStatus")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = x62Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    hg3 hg3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof hg3)) {
                            hg3Var = (hg3) obj;
                        } else {
                            hg3Var = new hg3(this.mSwanApiContext);
                            this.mApis.put("-1929343869", hg3Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(hg3Var, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "PrivateFile.uploadFileToBos")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 C = hg3Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    wt1 wt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof wt1)) {
                            wt1Var = (wt1) obj;
                        } else {
                            wt1Var = new wt1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", wt1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(wt1Var, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Router.hideModalPage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = wt1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    wt1 wt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof wt1)) {
                            wt1Var = (wt1) obj;
                        } else {
                            wt1Var = new wt1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", wt1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(wt1Var, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Router.navigateBack")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 B = wt1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    xt1 xt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof xt1)) {
                            xt1Var = (xt1) obj;
                        } else {
                            xt1Var = new xt1(this.mSwanApiContext);
                            this.mApis.put("1968522584", xt1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(xt1Var, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Router.navigateTo")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 H = xt1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    zt1 zt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof zt1)) {
                            zt1Var = (zt1) obj;
                        } else {
                            zt1Var = new zt1(this.mSwanApiContext);
                            this.mApis.put("1317280190", zt1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(zt1Var, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Router.reLaunch")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = zt1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    au1 au1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof au1)) {
                            au1Var = (au1) obj;
                        } else {
                            au1Var = new au1(this.mSwanApiContext);
                            this.mApis.put("-420075743", au1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(au1Var, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Router.reLoadErrorPage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = au1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    yt1 yt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof yt1)) {
                            yt1Var = (yt1) obj;
                        } else {
                            yt1Var = new yt1(this.mSwanApiContext);
                            this.mApis.put("1792515533", yt1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(yt1Var, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Router.redirectTo")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 D = yt1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    xt1 xt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof xt1)) {
                            xt1Var = (xt1) obj;
                        } else {
                            xt1Var = new xt1(this.mSwanApiContext);
                            this.mApis.put("1968522584", xt1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(xt1Var, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Router.showModalPage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 J = xt1Var.J(str);
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    du1 du1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof du1)) {
                            du1Var = (du1) obj;
                        } else {
                            du1Var = new du1(this.mSwanApiContext);
                            this.mApis.put("-594895721", du1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(du1Var, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Setting.getAppInfoSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 F = du1Var.F();
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    du1 du1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof du1)) {
                            du1Var = (du1) obj;
                        } else {
                            du1Var = new du1(this.mSwanApiContext);
                            this.mApis.put("-594895721", du1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(du1Var, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Setting.getSlaveIdSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 H = du1Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    cu1 cu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof cu1)) {
                            cu1Var = (cu1) obj;
                        } else {
                            cu1Var = new cu1(this.mSwanApiContext);
                            this.mApis.put("450273045", cu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(cu1Var, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Setting.isAllowedAdOpenAppSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = cu1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    du1 du1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof du1)) {
                            du1Var = (du1) obj;
                        } else {
                            du1Var = new du1(this.mSwanApiContext);
                            this.mApis.put("-594895721", du1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(du1Var, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Setting.getSetting")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 G = du1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    du1 du1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof du1)) {
                            du1Var = (du1) obj;
                        } else {
                            du1Var = new du1(this.mSwanApiContext);
                            this.mApis.put("-594895721", du1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(du1Var, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Setting.getSwanId")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 I = du1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    du1 du1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof du1)) {
                            du1Var = (du1) obj;
                        } else {
                            du1Var = new du1(this.mSwanApiContext);
                            this.mApis.put("-594895721", du1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(du1Var, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Setting.getUserInfo")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 J = du1Var.J(str);
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    bb3 bb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof bb3)) {
                            bb3Var = (bb3) obj;
                        } else {
                            bb3Var = new bb3(this.mSwanApiContext);
                            this.mApis.put("712777136", bb3Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(bb3Var, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = bb3Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    gu1 gu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", gu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(gu1Var, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = gu1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    gu1 gu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", gu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(gu1Var, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorageSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 C = gu1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    fu1 fu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("130910081", fu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(fu1Var, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.clearStorage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = fu1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    fu1 fu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("130910081", fu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(fu1Var, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.clearStorageSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 C = fu1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    gu1 gu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", gu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(gu1Var, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfo")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 G = gu1Var.G();
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    gu1 gu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", gu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(gu1Var, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfoSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 J = gu1Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    fu1 fu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("130910081", fu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(fu1Var, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.getStorageInfo")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 G = fu1Var.G();
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    fu1 fu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("130910081", fu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(fu1Var, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.getStorageInfoSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 J = fu1Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    gu1 gu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", gu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(gu1Var, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.getGlobalStorage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 D = gu1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    gu1 gu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", gu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(gu1Var, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 K = gu1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    fu1 fu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("130910081", fu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(fu1Var, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.getStorage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 D = fu1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    fu1 fu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("130910081", fu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(fu1Var, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.getStorageInfoAsync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 H = fu1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    fu1 fu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("130910081", fu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(fu1Var, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.getStorageSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 K = fu1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    gu1 gu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", gu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(gu1Var, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 R = gu1Var.R(str);
                        if (R == null) {
                            return "";
                        }
                        return R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    gu1 gu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", gu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(gu1Var, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorageSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 T = gu1Var.T(str);
                        if (T == null) {
                            return "";
                        }
                        return T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    fu1 fu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("130910081", fu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(fu1Var, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.removeStorage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 R = fu1Var.R(str);
                        if (R == null) {
                            return "";
                        }
                        return R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    fu1 fu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("130910081", fu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(fu1Var, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.removeStorageSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 T = fu1Var.T(str);
                        if (T == null) {
                            return "";
                        }
                        return T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    gu1 gu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", gu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(gu1Var, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.setGlobalStorage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 U = gu1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    gu1 gu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", gu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(gu1Var, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.setGlobalStorageSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 W = gu1Var.W(str);
                        if (W == null) {
                            return "";
                        }
                        return W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    fu1 fu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("130910081", fu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(fu1Var, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.setStorage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 U = fu1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    fu1 fu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("130910081", fu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(fu1Var, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.setStorageSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 W = fu1Var.W(str);
                        if (W == null) {
                            return "";
                        }
                        return W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    iu1 iu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof iu1)) {
                            iu1Var = (iu1) obj;
                        } else {
                            iu1Var = new iu1(this.mSwanApiContext);
                            this.mApis.put("823117982", iu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(iu1Var, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Subscription.requestSubscribeFormId")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 E = iu1Var.E(str);
                        if (E == null) {
                            return "";
                        }
                        return E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    ju1 ju1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof ju1)) {
                            ju1Var = (ju1) obj;
                        } else {
                            ju1Var = new ju1(this.mSwanApiContext);
                            this.mApis.put("-947445811", ju1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ju1Var, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Subscription.subscribeService")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 F = ju1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    qu1 qu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof qu1)) {
                            qu1Var = (qu1) obj;
                        } else {
                            qu1Var = new qu1(this.mSwanApiContext);
                            this.mApis.put("1936205521", qu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(qu1Var, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.exitFullScreen")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = qu1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    pu1 pu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof pu1)) {
                            pu1Var = (pu1) obj;
                        } else {
                            pu1Var = new pu1(this.mSwanApiContext);
                            this.mApis.put("1694151270", pu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(pu1Var, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.getDeviceInfo")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = pu1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    ru1 ru1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof ru1)) {
                            ru1Var = (ru1) obj;
                        } else {
                            ru1Var = new ru1(this.mSwanApiContext);
                            this.mApis.put("-1321681619", ru1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ru1Var, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.getDeviceProfile")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = ru1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    su1 su1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof su1)) {
                            su1Var = (su1) obj;
                        } else {
                            su1Var = new su1(this.mSwanApiContext);
                            this.mApis.put("-1569246082", su1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(su1Var, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.makePhoneCall")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = su1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    uu1 uu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof uu1)) {
                            uu1Var = (uu1) obj;
                        } else {
                            uu1Var = new uu1(this.mSwanApiContext);
                            this.mApis.put("1099851202", uu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(uu1Var, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.openSMSPanel")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = uu1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    tu1 tu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof tu1)) {
                            tu1Var = (tu1) obj;
                        } else {
                            tu1Var = new tu1(this.mSwanApiContext);
                            this.mApis.put("-1707203360", tu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(tu1Var, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.requestFullScreen")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 F = tu1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    nu1 nu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof nu1)) {
                            nu1Var = (nu1) obj;
                        } else {
                            nu1Var = new nu1(this.mSwanApiContext);
                            this.mApis.put("-518757484", nu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(nu1Var, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.setClipboardData")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = nu1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    xt2 xt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof xt2)) {
                            xt2Var = (xt2) obj;
                        } else {
                            xt2Var = new xt2(this.mSwanApiContext);
                            this.mApis.put("1161486049", xt2Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(xt2Var, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.setErrorPageType")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = xt2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    xu1 xu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof xu1)) {
                            xu1Var = (xu1) obj;
                        } else {
                            xu1Var = new xu1(this.mSwanApiContext);
                            this.mApis.put("447234992", xu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(xu1Var, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.setMediaVolume")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 z = xu1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    lu1 lu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof lu1)) {
                            lu1Var = (lu1) obj;
                        } else {
                            lu1Var = new lu1(this.mSwanApiContext);
                            this.mApis.put("1372680763", lu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(lu1Var, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.startAccelerometer")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = lu1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    ou1 ou1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof ou1)) {
                            ou1Var = (ou1) obj;
                        } else {
                            ou1Var = new ou1(this.mSwanApiContext);
                            this.mApis.put("1689255576", ou1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ou1Var, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.startCompass")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = ou1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    mu1 mu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof mu1)) {
                            mu1Var = (mu1) obj;
                        } else {
                            mu1Var = new mu1(this.mSwanApiContext);
                            this.mApis.put("99997465", mu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(mu1Var, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.getBrightness")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = mu1Var.y();
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    nu1 nu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof nu1)) {
                            nu1Var = (nu1) obj;
                        } else {
                            nu1Var = new nu1(this.mSwanApiContext);
                            this.mApis.put("-518757484", nu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(nu1Var, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.getClipboardData")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = nu1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    xu1 xu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof xu1)) {
                            xu1Var = (xu1) obj;
                        } else {
                            xu1Var = new xu1(this.mSwanApiContext);
                            this.mApis.put("447234992", xu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(xu1Var, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.getMediaVolume")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = xu1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    lu1 lu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof lu1)) {
                            lu1Var = (lu1) obj;
                        } else {
                            lu1Var = new lu1(this.mSwanApiContext);
                            this.mApis.put("1372680763", lu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(lu1Var, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.stopAccelerometer")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 B = lu1Var.B();
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    ou1 ou1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof ou1)) {
                            ou1Var = (ou1) obj;
                        } else {
                            ou1Var = new ou1(this.mSwanApiContext);
                            this.mApis.put("1689255576", ou1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ou1Var, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.stopCompass")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 z = ou1Var.z();
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    iv1 iv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof iv1)) {
                            iv1Var = (iv1) obj;
                        } else {
                            iv1Var = new iv1(this.mSwanApiContext);
                            this.mApis.put("201194468", iv1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(iv1Var, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.addToDesktop")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 B = iv1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    ev1 ev1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof ev1)) {
                            ev1Var = (ev1) obj;
                        } else {
                            ev1Var = new ev1(this.mSwanApiContext);
                            this.mApis.put("-1412306947", ev1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ev1Var, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.calcMD5")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = ev1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    fv1 fv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof fv1)) {
                            fv1Var = (fv1) obj;
                        } else {
                            fv1Var = new fv1(this.mSwanApiContext);
                            this.mApis.put("1626415364", fv1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(fv1Var, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.checkAppInstalled")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = fv1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    hv1 hv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof hv1)) {
                            hv1Var = (hv1) obj;
                        } else {
                            hv1Var = new hv1(this.mSwanApiContext);
                            this.mApis.put("-836768778", hv1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(hv1Var, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfo")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = hv1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    jv1 jv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof jv1)) {
                            jv1Var = (jv1) obj;
                        } else {
                            jv1Var = new jv1(this.mSwanApiContext);
                            this.mApis.put("-810858308", jv1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(jv1Var, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.getPerformanceLevel")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = jv1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    nv1 nv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof nv1)) {
                            nv1Var = (nv1) obj;
                        } else {
                            nv1Var = new nv1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", nv1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(nv1Var, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.getSystemInfoAsync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 I = nv1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    kv1 kv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof kv1)) {
                            kv1Var = (kv1) obj;
                        } else {
                            kv1Var = new kv1(this.mSwanApiContext);
                            this.mApis.put("-2097727681", kv1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(kv1Var, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.handleException")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = kv1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    gv1 gv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof gv1)) {
                            gv1Var = (gv1) obj;
                        } else {
                            gv1Var = new gv1(this.mSwanApiContext);
                            this.mApis.put("2084449317", gv1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(gv1Var, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.hasCloseHandler")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = gv1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    j83 j83Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof j83)) {
                            j83Var = (j83) obj;
                        } else {
                            j83Var = new j83(this.mSwanApiContext);
                            this.mApis.put("1031678042", j83Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(j83Var, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.hideCaptureScreenShareDialog")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = j83Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    lv1 lv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof lv1)) {
                            lv1Var = (lv1) obj;
                        } else {
                            lv1Var = new lv1(this.mSwanApiContext);
                            this.mApis.put("1751900130", lv1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(lv1Var, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.logToFile")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = lv1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    k73 k73Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof k73)) {
                            k73Var = (k73) obj;
                        } else {
                            k73Var = new k73(this.mSwanApiContext);
                            this.mApis.put("1748196865", k73Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(k73Var, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.preloadPackage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = k73Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    mv1 mv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof mv1)) {
                            mv1Var = (mv1) obj;
                        } else {
                            mv1Var = new mv1(this.mSwanApiContext);
                            this.mApis.put("589529211", mv1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(mv1Var, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.previewImage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 B = mv1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    pv1 pv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof pv1)) {
                            pv1Var = (pv1) obj;
                        } else {
                            pv1Var = new pv1(this.mSwanApiContext);
                            this.mApis.put("-577481801", pv1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(pv1Var, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.ubcFlowJar")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 I = pv1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    nv1 nv1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof nv1)) {
                            nv1Var = (nv1) obj;
                        } else {
                            nv1Var = new nv1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", nv1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(nv1Var, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfoSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 E = nv1Var.E();
                        if (E == null) {
                            return "";
                        }
                        return E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    nv1 nv1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof nv1)) {
                            nv1Var = (nv1) obj;
                        } else {
                            nv1Var = new nv1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", nv1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(nv1Var, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.getSystemInfo")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 H = nv1Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    nv1 nv1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof nv1)) {
                            nv1Var = (nv1) obj;
                        } else {
                            nv1Var = new nv1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", nv1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(nv1Var, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.getSystemInfoSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 J = nv1Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    ue3 ue3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ue3)) {
                            ue3Var = (ue3) obj;
                        } else {
                            ue3Var = new ue3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ue3Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ue3Var, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Wifi.connectWifi")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = ue3Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    ue3 ue3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ue3)) {
                            ue3Var = (ue3) obj;
                        } else {
                            ue3Var = new ue3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ue3Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ue3Var, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Wifi.getConnectedWifi")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 B = ue3Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    ue3 ue3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ue3)) {
                            ue3Var = (ue3) obj;
                        } else {
                            ue3Var = new ue3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ue3Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ue3Var, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Wifi.getWifiList")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 C = ue3Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    ue3 ue3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ue3)) {
                            ue3Var = (ue3) obj;
                        } else {
                            ue3Var = new ue3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ue3Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ue3Var, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Wifi.startWifi")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 G = ue3Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    ue3 ue3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ue3)) {
                            ue3Var = (ue3) obj;
                        } else {
                            ue3Var = new ue3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ue3Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ue3Var, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Wifi.stopWifi")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 H = ue3Var.H(str);
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

    public static Map<String, Object> getWebviewApiModules(final fs1 fs1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, fs1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    ls1 ls1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof ls1)) {
                            ls1Var = (ls1) obj;
                        } else {
                            ls1Var = new ls1(this.mSwanApiContext);
                            this.mApis.put("1930258908", ls1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ls1Var, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Account.checkSession")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = ls1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    ms1 ms1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ms1)) {
                            ms1Var = (ms1) obj;
                        } else {
                            ms1Var = new ms1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ms1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ms1Var, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Account.getLoginCode")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 C = ms1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    ns1 ns1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof ns1)) {
                            ns1Var = (ns1) obj;
                        } else {
                            ns1Var = new ns1(this.mSwanApiContext);
                            this.mApis.put("1754780133", ns1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ns1Var, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Account.getOpenId")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = ns1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    ur1 ur1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof ur1)) {
                            ur1Var = (ur1) obj;
                        } else {
                            ur1Var = new ur1(this.mSwanApiContext);
                            this.mApis.put("-343998465", ur1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ur1Var, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Account.getUnionBDUSS")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = ur1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    ms1 ms1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ms1)) {
                            ms1Var = (ms1) obj;
                        } else {
                            ms1Var = new ms1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ms1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ms1Var, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Account.login")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 I = ms1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    ks1 ks1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof ks1)) {
                            ks1Var = (ks1) obj;
                        } else {
                            ks1Var = new ks1(this.mSwanApiContext);
                            this.mApis.put("-337742792", ks1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ks1Var, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Account.isBaiduAccountSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = ks1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    ms1 ms1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ms1)) {
                            ms1Var = (ms1) obj;
                        } else {
                            ms1Var = new ms1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ms1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ms1Var, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Account.isLoginSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 H = ms1Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    os1 os1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof os1)) {
                            os1Var = (os1) obj;
                        } else {
                            os1Var = new os1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", os1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(os1Var, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Basic.loadSubPackage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 F = os1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    os1 os1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof os1)) {
                            os1Var = (os1) obj;
                        } else {
                            os1Var = new os1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", os1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(os1Var, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Basic.loadSubPackages")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 G = os1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    vk1 vk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof vk1)) {
                            vk1Var = (vk1) obj;
                        } else {
                            vk1Var = new vk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", vk1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(vk1Var, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Bookshelf.deleteBookshelf")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 K = vk1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    vk1 vk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof vk1)) {
                            vk1Var = (vk1) obj;
                        } else {
                            vk1Var = new vk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", vk1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(vk1Var, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Bookshelf.insertBookshelf")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 P = vk1Var.P(str);
                        if (P == null) {
                            return "";
                        }
                        return P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    vk1 vk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof vk1)) {
                            vk1Var = (vk1) obj;
                        } else {
                            vk1Var = new vk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", vk1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(vk1Var, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Bookshelf.navigateToBookshelf")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 U = vk1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    vk1 vk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof vk1)) {
                            vk1Var = (vk1) obj;
                        } else {
                            vk1Var = new vk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", vk1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(vk1Var, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Bookshelf.queryBookshelf")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 V = vk1Var.V(str);
                        if (V == null) {
                            return "";
                        }
                        return V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    vk1 vk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof vk1)) {
                            vk1Var = (vk1) obj;
                        } else {
                            vk1Var = new vk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", vk1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(vk1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Bookshelf.updateBookshelfReadTime")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 X = vk1Var.X(str);
                        if (X == null) {
                            return "";
                        }
                        return X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    is1 is1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof is1)) {
                            is1Var = (is1) obj;
                        } else {
                            is1Var = new is1(this.mSwanApiContext);
                            this.mApis.put("-277316359", is1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(is1Var, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Coupon.getPlatformCoupons")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = is1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    is1 is1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof is1)) {
                            is1Var = (is1) obj;
                        } else {
                            is1Var = new is1(this.mSwanApiContext);
                            this.mApis.put("-277316359", is1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(is1Var, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Coupon.getUserCoupons")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 z = is1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    is1 is1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof is1)) {
                            is1Var = (is1) obj;
                        } else {
                            is1Var = new is1(this.mSwanApiContext);
                            this.mApis.put("-277316359", is1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(is1Var, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Coupon.takeCoupons")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 C = is1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    qs1 qs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof qs1)) {
                            qs1Var = (qs1) obj;
                        } else {
                            qs1Var = new qs1(this.mSwanApiContext);
                            this.mApis.put("-1225406515", qs1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(qs1Var, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Favorite.getFavorStatus")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = qs1Var.x(str);
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
                        Pair<Boolean, dw1> a = fw1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Favorite.showFavoriteGuide")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 G = showFavoriteGuideApi.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    ss1 ss1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof ss1)) {
                            ss1Var = (ss1) obj;
                        } else {
                            ss1Var = new ss1(this.mSwanApiContext);
                            this.mApis.put("-2057135077", ss1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ss1Var, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "File.shareFile")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = ss1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    hh2 hh2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof hh2)) {
                            hh2Var = (hh2) obj;
                        } else {
                            hh2Var = new hh2(this.mSwanApiContext);
                            this.mApis.put("2077414795", hh2Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(hh2Var, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = hh2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    hh2 hh2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof hh2)) {
                            hh2Var = (hh2) obj;
                        } else {
                            hh2Var = new hh2(this.mSwanApiContext);
                            this.mApis.put("2077414795", hh2Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(hh2Var, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessageSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = hh2Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String download(String str) {
                    ts1 ts1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof ts1)) {
                            ts1Var = (ts1) obj;
                        } else {
                            ts1Var = new ts1(this.mSwanApiContext);
                            this.mApis.put("-170124576", ts1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ts1Var, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "HostDownloadManager.download")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = ts1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    ts1 ts1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof ts1)) {
                            ts1Var = (ts1) obj;
                        } else {
                            ts1Var = new ts1(this.mSwanApiContext);
                            this.mApis.put("-170124576", ts1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ts1Var, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "HostDownloadManager.openFile")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 z = ts1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    ts1 ts1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof ts1)) {
                            ts1Var = (ts1) obj;
                        } else {
                            ts1Var = new ts1(this.mSwanApiContext);
                            this.mApis.put("-170124576", ts1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ts1Var, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "HostDownloadManager.query")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 query = ts1Var.query(str);
                        if (query == null) {
                            return "";
                        }
                        return query.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    ts1 ts1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof ts1)) {
                            ts1Var = (ts1) obj;
                        } else {
                            ts1Var = new ts1(this.mSwanApiContext);
                            this.mApis.put("-170124576", ts1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ts1Var, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "HostDownloadManager.openDownloadCenter")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = ts1Var.y();
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naImage", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    vt2 vt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof vt2)) {
                            vt2Var = (vt2) obj;
                        } else {
                            vt2Var = new vt2(this.mSwanApiContext);
                            this.mApis.put("1445003743", vt2Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(vt2Var, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Image.callImageMenu")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = vt2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    ws1 ws1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof ws1)) {
                            ws1Var = (ws1) obj;
                        } else {
                            ws1Var = new ws1(this.mSwanApiContext);
                            this.mApis.put("-1252730367", ws1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ws1Var, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Image.compressImage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = ws1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    et1 et1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof et1)) {
                            et1Var = (et1) obj;
                        } else {
                            et1Var = new et1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", et1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(et1Var, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.closeTabBar")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = et1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    et1 et1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof et1)) {
                            et1Var = (et1) obj;
                        } else {
                            et1Var = new et1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", et1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(et1Var, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.closeTabBarRedDot")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = et1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    at1 at1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("-246386074", at1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(at1Var, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.hideNavigationBarLoading")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = at1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    ct1 ct1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ct1)) {
                            ct1Var = (ct1) obj;
                        } else {
                            ct1Var = new ct1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ct1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ct1Var, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.openMultiPicker")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 G = ct1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    ct1 ct1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ct1)) {
                            ct1Var = (ct1) obj;
                        } else {
                            ct1Var = new ct1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ct1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ct1Var, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.openPicker")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 H = ct1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    et1 et1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof et1)) {
                            et1Var = (et1) obj;
                        } else {
                            et1Var = new et1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", et1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(et1Var, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.openTabBar")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 C = et1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    bt1 bt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof bt1)) {
                            bt1Var = (bt1) obj;
                        } else {
                            bt1Var = new bt1(this.mSwanApiContext);
                            this.mApis.put("-1750613704", bt1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(bt1Var, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.pageScrollTo")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = bt1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    at1 at1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("-246386074", at1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(at1Var, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarColor")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 z = at1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    at1 at1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("-246386074", at1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(at1Var, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarTitle")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = at1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    et1 et1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof et1)) {
                            et1Var = (et1) obj;
                        } else {
                            et1Var = new et1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", et1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(et1Var, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.setTabBarItem")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 D = et1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    ct1 ct1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ct1)) {
                            ct1Var = (ct1) obj;
                        } else {
                            ct1Var = new ct1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ct1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ct1Var, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.showDatePickerView")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 L = ct1Var.L(str);
                        if (L == null) {
                            return "";
                        }
                        return L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    gt1 gt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof gt1)) {
                            gt1Var = (gt1) obj;
                        } else {
                            gt1Var = new gt1(this.mSwanApiContext);
                            this.mApis.put("1172469410", gt1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(gt1Var, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.showHalfScreenWebview")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 K = gt1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    ys1 ys1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof ys1)) {
                            ys1Var = (ys1) obj;
                        } else {
                            ys1Var = new ys1(this.mSwanApiContext);
                            this.mApis.put("5236036", ys1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ys1Var, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.showLoading")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = ys1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    zs1 zs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("1913747800", zs1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(zs1Var, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.showModal")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = zs1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    at1 at1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("-246386074", at1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(at1Var, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.showNavigationBarLoading")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 B = at1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    ft1 ft1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("1159492510", ft1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ft1Var, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.showToast")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 Q = ft1Var.Q(str);
                        if (Q == null) {
                            return "";
                        }
                        return Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    dt1 dt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof dt1)) {
                            dt1Var = (dt1) obj;
                        } else {
                            dt1Var = new dt1(this.mSwanApiContext);
                            this.mApis.put("1165118609", dt1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(dt1Var, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.stopPullDownRefresh")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = dt1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    ct1 ct1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ct1)) {
                            ct1Var = (ct1) obj;
                        } else {
                            ct1Var = new ct1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ct1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ct1Var, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.updateMultiPicker")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 M = ct1Var.M(str);
                        if (M == null) {
                            return "";
                        }
                        return M.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    ys1 ys1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof ys1)) {
                            ys1Var = (ys1) obj;
                        } else {
                            ys1Var = new ys1(this.mSwanApiContext);
                            this.mApis.put("5236036", ys1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ys1Var, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.hideLoading")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = ys1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    ft1 ft1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("1159492510", ft1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ft1Var, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Interaction.hideToast")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 K = ft1Var.K();
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    ht1 ht1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof ht1)) {
                            ht1Var = (ht1) obj;
                        } else {
                            ht1Var = new ht1(this.mSwanApiContext);
                            this.mApis.put("-137346255", ht1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ht1Var, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Keyboard.startKeyboardHeightChange")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 C = ht1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    ht1 ht1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof ht1)) {
                            ht1Var = (ht1) obj;
                        } else {
                            ht1Var = new ht1(this.mSwanApiContext);
                            this.mApis.put("-137346255", ht1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ht1Var, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Keyboard.stopKeyboardHeightChange")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 D = ht1Var.D();
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    it1 it1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof it1)) {
                            it1Var = (it1) obj;
                        } else {
                            it1Var = new it1(this.mSwanApiContext);
                            this.mApis.put("-397373095", it1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(it1Var, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "LocationService.getLocation")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = it1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    it1 it1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof it1)) {
                            it1Var = (it1) obj;
                        } else {
                            it1Var = new it1(this.mSwanApiContext);
                            this.mApis.put("-397373095", it1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(it1Var, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "LocationService.startLocationUpdate")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = it1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    it1 it1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof it1)) {
                            it1Var = (it1) obj;
                        } else {
                            it1Var = new it1(this.mSwanApiContext);
                            this.mApis.put("-397373095", it1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(it1Var, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "LocationService.stopLocationUpdate")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 B = it1Var.B();
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    zu1 zu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof zu1)) {
                            zu1Var = (zu1) obj;
                        } else {
                            zu1Var = new zu1(this.mSwanApiContext);
                            this.mApis.put("538070032", zu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(zu1Var, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = zu1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String callService(String str) {
                    lt1 lt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof lt1)) {
                            lt1Var = (lt1) obj;
                        } else {
                            lt1Var = new lt1(this.mSwanApiContext);
                            this.mApis.put("-1076509454", lt1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(lt1Var, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Network.callService")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = lt1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    st1 st1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof st1)) {
                            st1Var = (st1) obj;
                        } else {
                            st1Var = new st1(this.mSwanApiContext);
                            this.mApis.put("968563034", st1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(st1Var, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Network.cancelRequest")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 D = st1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    rt1 rt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof rt1)) {
                            rt1Var = (rt1) obj;
                        } else {
                            rt1Var = new rt1(this.mSwanApiContext);
                            this.mApis.put("453220699", rt1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(rt1Var, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Network.networkStatusChange")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = rt1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    rt1 rt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof rt1)) {
                            rt1Var = (rt1) obj;
                        } else {
                            rt1Var = new rt1(this.mSwanApiContext);
                            this.mApis.put("453220699", rt1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(rt1Var, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Network.getNetworkType")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = rt1Var.x();
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
                    st1 st1Var;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        try {
                            cw1.c().a("request");
                            Object obj = this.mApis.get("968563034");
                            if (obj != null && (obj instanceof st1)) {
                                st1Var = (st1) obj;
                            } else {
                                st1Var = new st1(this.mSwanApiContext);
                                this.mApis.put("968563034", st1Var);
                            }
                            Pair<Boolean, dw1> a2 = fw1.a(st1Var, "swanAPI/request");
                            if (((Boolean) a2.first).booleanValue()) {
                                a = ((dw1) a2.second).a();
                            } else if (l62.a(this.mSwanApiContext.f(), "Network.request")) {
                                a = new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            } else {
                                Pair<dw1, JSONObject> u = hs1.u(str);
                                if (!((dw1) u.first).isSuccess()) {
                                    a = ((dw1) u.first).a();
                                } else {
                                    JSONObject jSONObject = (JSONObject) u.second;
                                    if (jSONObject == null) {
                                        a = dw1.a.a();
                                    } else {
                                        ew1 V = st1Var.V(jSONObject);
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
            hashMap.put("_naPayment", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    bx2 bx2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof bx2)) {
                            bx2Var = (bx2) obj;
                        } else {
                            bx2Var = new bx2(this.mSwanApiContext);
                            this.mApis.put("-336396851", bx2Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(bx2Var, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Payment.chooseCoupon")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = bx2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    bx2 bx2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof bx2)) {
                            bx2Var = (bx2) obj;
                        } else {
                            bx2Var = new bx2(this.mSwanApiContext);
                            this.mApis.put("-336396851", bx2Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(bx2Var, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Payment.getPaymentInfo")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = bx2Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    rw2 rw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof rw2)) {
                            rw2Var = (rw2) obj;
                        } else {
                            rw2Var = new rw2(this.mSwanApiContext);
                            this.mApis.put("1854689529", rw2Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(rw2Var, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Payment.requestThirdPayment")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = rw2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    bx2 bx2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof bx2)) {
                            bx2Var = (bx2) obj;
                        } else {
                            bx2Var = new bx2(this.mSwanApiContext);
                            this.mApis.put("-336396851", bx2Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(bx2Var, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Payment.setPaymentInfo")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 z = bx2Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    mz2 mz2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof mz2)) {
                            mz2Var = (mz2) obj;
                        } else {
                            mz2Var = new mz2(this.mSwanApiContext);
                            this.mApis.put("-254510461", mz2Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(mz2Var, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Plugin.invokePluginChooseAddress")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = mz2Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    mz2 mz2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof mz2)) {
                            mz2Var = (mz2) obj;
                        } else {
                            mz2Var = new mz2(this.mSwanApiContext);
                            this.mApis.put("-254510461", mz2Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(mz2Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 z = mz2Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    mz2 mz2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof mz2)) {
                            mz2Var = (mz2) obj;
                        } else {
                            mz2Var = new mz2(this.mSwanApiContext);
                            this.mApis.put("-254510461", mz2Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(mz2Var, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Plugin.invokePluginPayment")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = mz2Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    f82 f82Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof f82)) {
                            f82Var = (f82) obj;
                        } else {
                            f82Var = new f82(this.mSwanApiContext);
                            this.mApis.put("-2068479848", f82Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(f82Var, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Prefetch.prefetchResources")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = f82Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    x62 x62Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof x62)) {
                            x62Var = (x62) obj;
                        } else {
                            x62Var = new x62(this.mSwanApiContext);
                            this.mApis.put("423661539", x62Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(x62Var, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Preload.preloadStatus")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = x62Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    hg3 hg3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof hg3)) {
                            hg3Var = (hg3) obj;
                        } else {
                            hg3Var = new hg3(this.mSwanApiContext);
                            this.mApis.put("-1929343869", hg3Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(hg3Var, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "PrivateFile.uploadFileToBos")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 C = hg3Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    wt1 wt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof wt1)) {
                            wt1Var = (wt1) obj;
                        } else {
                            wt1Var = new wt1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", wt1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(wt1Var, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Router.hideModalPage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = wt1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    wt1 wt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof wt1)) {
                            wt1Var = (wt1) obj;
                        } else {
                            wt1Var = new wt1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", wt1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(wt1Var, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Router.navigateBack")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 B = wt1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    xt1 xt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof xt1)) {
                            xt1Var = (xt1) obj;
                        } else {
                            xt1Var = new xt1(this.mSwanApiContext);
                            this.mApis.put("1968522584", xt1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(xt1Var, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Router.navigateTo")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 H = xt1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    zt1 zt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof zt1)) {
                            zt1Var = (zt1) obj;
                        } else {
                            zt1Var = new zt1(this.mSwanApiContext);
                            this.mApis.put("1317280190", zt1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(zt1Var, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Router.reLaunch")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = zt1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    au1 au1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof au1)) {
                            au1Var = (au1) obj;
                        } else {
                            au1Var = new au1(this.mSwanApiContext);
                            this.mApis.put("-420075743", au1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(au1Var, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Router.reLoadErrorPage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = au1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    yt1 yt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof yt1)) {
                            yt1Var = (yt1) obj;
                        } else {
                            yt1Var = new yt1(this.mSwanApiContext);
                            this.mApis.put("1792515533", yt1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(yt1Var, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Router.redirectTo")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 D = yt1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    xt1 xt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof xt1)) {
                            xt1Var = (xt1) obj;
                        } else {
                            xt1Var = new xt1(this.mSwanApiContext);
                            this.mApis.put("1968522584", xt1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(xt1Var, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Router.showModalPage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 J = xt1Var.J(str);
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    du1 du1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof du1)) {
                            du1Var = (du1) obj;
                        } else {
                            du1Var = new du1(this.mSwanApiContext);
                            this.mApis.put("-594895721", du1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(du1Var, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Setting.getAppInfoSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 F = du1Var.F();
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    du1 du1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof du1)) {
                            du1Var = (du1) obj;
                        } else {
                            du1Var = new du1(this.mSwanApiContext);
                            this.mApis.put("-594895721", du1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(du1Var, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Setting.getSlaveIdSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 H = du1Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    cu1 cu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof cu1)) {
                            cu1Var = (cu1) obj;
                        } else {
                            cu1Var = new cu1(this.mSwanApiContext);
                            this.mApis.put("450273045", cu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(cu1Var, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Setting.isAllowedAdOpenAppSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = cu1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    du1 du1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof du1)) {
                            du1Var = (du1) obj;
                        } else {
                            du1Var = new du1(this.mSwanApiContext);
                            this.mApis.put("-594895721", du1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(du1Var, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Setting.getSetting")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 G = du1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    du1 du1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof du1)) {
                            du1Var = (du1) obj;
                        } else {
                            du1Var = new du1(this.mSwanApiContext);
                            this.mApis.put("-594895721", du1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(du1Var, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Setting.getSwanId")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 I = du1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    du1 du1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof du1)) {
                            du1Var = (du1) obj;
                        } else {
                            du1Var = new du1(this.mSwanApiContext);
                            this.mApis.put("-594895721", du1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(du1Var, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Setting.getUserInfo")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 J = du1Var.J(str);
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    bb3 bb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof bb3)) {
                            bb3Var = (bb3) obj;
                        } else {
                            bb3Var = new bb3(this.mSwanApiContext);
                            this.mApis.put("712777136", bb3Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(bb3Var, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = bb3Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    gu1 gu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", gu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(gu1Var, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = gu1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    gu1 gu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", gu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(gu1Var, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorageSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 C = gu1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    fu1 fu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("130910081", fu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(fu1Var, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.clearStorage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = fu1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    fu1 fu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("130910081", fu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(fu1Var, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.clearStorageSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 C = fu1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    gu1 gu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", gu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(gu1Var, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfo")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 G = gu1Var.G();
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    gu1 gu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", gu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(gu1Var, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfoSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 J = gu1Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    fu1 fu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("130910081", fu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(fu1Var, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.getStorageInfo")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 G = fu1Var.G();
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    fu1 fu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("130910081", fu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(fu1Var, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.getStorageInfoSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 J = fu1Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    gu1 gu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", gu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(gu1Var, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.getGlobalStorage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 D = gu1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    gu1 gu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", gu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(gu1Var, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 K = gu1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    fu1 fu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("130910081", fu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(fu1Var, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.getStorage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 D = fu1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    fu1 fu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("130910081", fu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(fu1Var, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.getStorageInfoAsync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 H = fu1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    fu1 fu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("130910081", fu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(fu1Var, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.getStorageSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 K = fu1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    gu1 gu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", gu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(gu1Var, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 R = gu1Var.R(str);
                        if (R == null) {
                            return "";
                        }
                        return R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    gu1 gu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", gu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(gu1Var, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorageSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 T = gu1Var.T(str);
                        if (T == null) {
                            return "";
                        }
                        return T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    fu1 fu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("130910081", fu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(fu1Var, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.removeStorage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 R = fu1Var.R(str);
                        if (R == null) {
                            return "";
                        }
                        return R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    fu1 fu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("130910081", fu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(fu1Var, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.removeStorageSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 T = fu1Var.T(str);
                        if (T == null) {
                            return "";
                        }
                        return T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    gu1 gu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", gu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(gu1Var, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.setGlobalStorage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 U = gu1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    gu1 gu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", gu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(gu1Var, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.setGlobalStorageSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 W = gu1Var.W(str);
                        if (W == null) {
                            return "";
                        }
                        return W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    fu1 fu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("130910081", fu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(fu1Var, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.setStorage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 U = fu1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    fu1 fu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("130910081", fu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(fu1Var, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Storage.setStorageSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 W = fu1Var.W(str);
                        if (W == null) {
                            return "";
                        }
                        return W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    iu1 iu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof iu1)) {
                            iu1Var = (iu1) obj;
                        } else {
                            iu1Var = new iu1(this.mSwanApiContext);
                            this.mApis.put("823117982", iu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(iu1Var, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Subscription.requestSubscribeFormId")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 E = iu1Var.E(str);
                        if (E == null) {
                            return "";
                        }
                        return E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    ju1 ju1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof ju1)) {
                            ju1Var = (ju1) obj;
                        } else {
                            ju1Var = new ju1(this.mSwanApiContext);
                            this.mApis.put("-947445811", ju1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ju1Var, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Subscription.subscribeService")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 F = ju1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    qu1 qu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof qu1)) {
                            qu1Var = (qu1) obj;
                        } else {
                            qu1Var = new qu1(this.mSwanApiContext);
                            this.mApis.put("1936205521", qu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(qu1Var, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.exitFullScreen")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = qu1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    pu1 pu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof pu1)) {
                            pu1Var = (pu1) obj;
                        } else {
                            pu1Var = new pu1(this.mSwanApiContext);
                            this.mApis.put("1694151270", pu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(pu1Var, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.getDeviceInfo")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = pu1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    ru1 ru1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof ru1)) {
                            ru1Var = (ru1) obj;
                        } else {
                            ru1Var = new ru1(this.mSwanApiContext);
                            this.mApis.put("-1321681619", ru1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ru1Var, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.getDeviceProfile")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = ru1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    su1 su1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof su1)) {
                            su1Var = (su1) obj;
                        } else {
                            su1Var = new su1(this.mSwanApiContext);
                            this.mApis.put("-1569246082", su1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(su1Var, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.makePhoneCall")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = su1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    uu1 uu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof uu1)) {
                            uu1Var = (uu1) obj;
                        } else {
                            uu1Var = new uu1(this.mSwanApiContext);
                            this.mApis.put("1099851202", uu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(uu1Var, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.openSMSPanel")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = uu1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    tu1 tu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof tu1)) {
                            tu1Var = (tu1) obj;
                        } else {
                            tu1Var = new tu1(this.mSwanApiContext);
                            this.mApis.put("-1707203360", tu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(tu1Var, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.requestFullScreen")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 F = tu1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    nu1 nu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof nu1)) {
                            nu1Var = (nu1) obj;
                        } else {
                            nu1Var = new nu1(this.mSwanApiContext);
                            this.mApis.put("-518757484", nu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(nu1Var, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.setClipboardData")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = nu1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    xt2 xt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof xt2)) {
                            xt2Var = (xt2) obj;
                        } else {
                            xt2Var = new xt2(this.mSwanApiContext);
                            this.mApis.put("1161486049", xt2Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(xt2Var, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.setErrorPageType")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = xt2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    xu1 xu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof xu1)) {
                            xu1Var = (xu1) obj;
                        } else {
                            xu1Var = new xu1(this.mSwanApiContext);
                            this.mApis.put("447234992", xu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(xu1Var, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.setMediaVolume")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 z = xu1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    lu1 lu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof lu1)) {
                            lu1Var = (lu1) obj;
                        } else {
                            lu1Var = new lu1(this.mSwanApiContext);
                            this.mApis.put("1372680763", lu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(lu1Var, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.startAccelerometer")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = lu1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    ou1 ou1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof ou1)) {
                            ou1Var = (ou1) obj;
                        } else {
                            ou1Var = new ou1(this.mSwanApiContext);
                            this.mApis.put("1689255576", ou1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ou1Var, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.startCompass")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = ou1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    mu1 mu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof mu1)) {
                            mu1Var = (mu1) obj;
                        } else {
                            mu1Var = new mu1(this.mSwanApiContext);
                            this.mApis.put("99997465", mu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(mu1Var, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.getBrightness")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = mu1Var.y();
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    nu1 nu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof nu1)) {
                            nu1Var = (nu1) obj;
                        } else {
                            nu1Var = new nu1(this.mSwanApiContext);
                            this.mApis.put("-518757484", nu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(nu1Var, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.getClipboardData")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = nu1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    xu1 xu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof xu1)) {
                            xu1Var = (xu1) obj;
                        } else {
                            xu1Var = new xu1(this.mSwanApiContext);
                            this.mApis.put("447234992", xu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(xu1Var, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.getMediaVolume")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = xu1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    lu1 lu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof lu1)) {
                            lu1Var = (lu1) obj;
                        } else {
                            lu1Var = new lu1(this.mSwanApiContext);
                            this.mApis.put("1372680763", lu1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(lu1Var, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.stopAccelerometer")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 B = lu1Var.B();
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    ou1 ou1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof ou1)) {
                            ou1Var = (ou1) obj;
                        } else {
                            ou1Var = new ou1(this.mSwanApiContext);
                            this.mApis.put("1689255576", ou1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ou1Var, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "System.stopCompass")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 z = ou1Var.z();
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    iv1 iv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof iv1)) {
                            iv1Var = (iv1) obj;
                        } else {
                            iv1Var = new iv1(this.mSwanApiContext);
                            this.mApis.put("201194468", iv1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(iv1Var, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.addToDesktop")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 B = iv1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    ev1 ev1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof ev1)) {
                            ev1Var = (ev1) obj;
                        } else {
                            ev1Var = new ev1(this.mSwanApiContext);
                            this.mApis.put("-1412306947", ev1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ev1Var, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.calcMD5")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = ev1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    fv1 fv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof fv1)) {
                            fv1Var = (fv1) obj;
                        } else {
                            fv1Var = new fv1(this.mSwanApiContext);
                            this.mApis.put("1626415364", fv1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(fv1Var, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.checkAppInstalled")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = fv1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    hv1 hv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof hv1)) {
                            hv1Var = (hv1) obj;
                        } else {
                            hv1Var = new hv1(this.mSwanApiContext);
                            this.mApis.put("-836768778", hv1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(hv1Var, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfo")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = hv1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    jv1 jv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof jv1)) {
                            jv1Var = (jv1) obj;
                        } else {
                            jv1Var = new jv1(this.mSwanApiContext);
                            this.mApis.put("-810858308", jv1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(jv1Var, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.getPerformanceLevel")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = jv1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    nv1 nv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof nv1)) {
                            nv1Var = (nv1) obj;
                        } else {
                            nv1Var = new nv1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", nv1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(nv1Var, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.getSystemInfoAsync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 I = nv1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    kv1 kv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof kv1)) {
                            kv1Var = (kv1) obj;
                        } else {
                            kv1Var = new kv1(this.mSwanApiContext);
                            this.mApis.put("-2097727681", kv1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(kv1Var, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.handleException")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = kv1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    gv1 gv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof gv1)) {
                            gv1Var = (gv1) obj;
                        } else {
                            gv1Var = new gv1(this.mSwanApiContext);
                            this.mApis.put("2084449317", gv1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(gv1Var, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.hasCloseHandler")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = gv1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    j83 j83Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof j83)) {
                            j83Var = (j83) obj;
                        } else {
                            j83Var = new j83(this.mSwanApiContext);
                            this.mApis.put("1031678042", j83Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(j83Var, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.hideCaptureScreenShareDialog")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 x = j83Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    lv1 lv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof lv1)) {
                            lv1Var = (lv1) obj;
                        } else {
                            lv1Var = new lv1(this.mSwanApiContext);
                            this.mApis.put("1751900130", lv1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(lv1Var, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.logToFile")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 y = lv1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    k73 k73Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof k73)) {
                            k73Var = (k73) obj;
                        } else {
                            k73Var = new k73(this.mSwanApiContext);
                            this.mApis.put("1748196865", k73Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(k73Var, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.preloadPackage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = k73Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    mv1 mv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof mv1)) {
                            mv1Var = (mv1) obj;
                        } else {
                            mv1Var = new mv1(this.mSwanApiContext);
                            this.mApis.put("589529211", mv1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(mv1Var, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.previewImage")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 B = mv1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    pv1 pv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof pv1)) {
                            pv1Var = (pv1) obj;
                        } else {
                            pv1Var = new pv1(this.mSwanApiContext);
                            this.mApis.put("-577481801", pv1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(pv1Var, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.ubcFlowJar")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 I = pv1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    nv1 nv1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof nv1)) {
                            nv1Var = (nv1) obj;
                        } else {
                            nv1Var = new nv1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", nv1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(nv1Var, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfoSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 E = nv1Var.E();
                        if (E == null) {
                            return "";
                        }
                        return E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    nv1 nv1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof nv1)) {
                            nv1Var = (nv1) obj;
                        } else {
                            nv1Var = new nv1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", nv1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(nv1Var, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.getSystemInfo")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 H = nv1Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    nv1 nv1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof nv1)) {
                            nv1Var = (nv1) obj;
                        } else {
                            nv1Var = new nv1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", nv1Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(nv1Var, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Utils.getSystemInfoSync")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 J = nv1Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(fs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public fs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fs1Var};
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
                    this.mSwanApiContext = fs1Var;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    ue3 ue3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ue3)) {
                            ue3Var = (ue3) obj;
                        } else {
                            ue3Var = new ue3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ue3Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ue3Var, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Wifi.connectWifi")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 A = ue3Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    ue3 ue3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ue3)) {
                            ue3Var = (ue3) obj;
                        } else {
                            ue3Var = new ue3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ue3Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ue3Var, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Wifi.getConnectedWifi")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 B = ue3Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    ue3 ue3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ue3)) {
                            ue3Var = (ue3) obj;
                        } else {
                            ue3Var = new ue3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ue3Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ue3Var, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Wifi.getWifiList")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 C = ue3Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    ue3 ue3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ue3)) {
                            ue3Var = (ue3) obj;
                        } else {
                            ue3Var = new ue3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ue3Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ue3Var, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Wifi.startWifi")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 G = ue3Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    ue3 ue3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ue3)) {
                            ue3Var = (ue3) obj;
                        } else {
                            ue3Var = new ue3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ue3Var);
                        }
                        Pair<Boolean, dw1> a = fw1.a(ue3Var, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((dw1) a.second).a();
                        }
                        if (l62.a(this.mSwanApiContext.f(), "Wifi.stopWifi")) {
                            return new ew1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        ew1 H = ue3Var.H(str);
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
