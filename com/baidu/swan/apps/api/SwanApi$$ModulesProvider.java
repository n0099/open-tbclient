package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.tieba.al1;
import com.baidu.tieba.au2;
import com.baidu.tieba.bt1;
import com.baidu.tieba.bu1;
import com.baidu.tieba.c72;
import com.baidu.tieba.cu1;
import com.baidu.tieba.cu2;
import com.baidu.tieba.cv1;
import com.baidu.tieba.dt1;
import com.baidu.tieba.du1;
import com.baidu.tieba.et1;
import com.baidu.tieba.eu1;
import com.baidu.tieba.ev1;
import com.baidu.tieba.ft1;
import com.baidu.tieba.fu1;
import com.baidu.tieba.gb3;
import com.baidu.tieba.gt1;
import com.baidu.tieba.gx2;
import com.baidu.tieba.ht1;
import com.baidu.tieba.hu1;
import com.baidu.tieba.hw1;
import com.baidu.tieba.it1;
import com.baidu.tieba.iu1;
import com.baidu.tieba.iw1;
import com.baidu.tieba.jt1;
import com.baidu.tieba.jv1;
import com.baidu.tieba.jw1;
import com.baidu.tieba.k82;
import com.baidu.tieba.ks1;
import com.baidu.tieba.kt1;
import com.baidu.tieba.ku1;
import com.baidu.tieba.kv1;
import com.baidu.tieba.kw1;
import com.baidu.tieba.lt1;
import com.baidu.tieba.lu1;
import com.baidu.tieba.lv1;
import com.baidu.tieba.mg3;
import com.baidu.tieba.mh2;
import com.baidu.tieba.ms1;
import com.baidu.tieba.mt1;
import com.baidu.tieba.mv1;
import com.baidu.tieba.ns1;
import com.baidu.tieba.nt1;
import com.baidu.tieba.nu1;
import com.baidu.tieba.nv1;
import com.baidu.tieba.o83;
import com.baidu.tieba.ou1;
import com.baidu.tieba.ov1;
import com.baidu.tieba.p73;
import com.baidu.tieba.ps1;
import com.baidu.tieba.pv1;
import com.baidu.tieba.q62;
import com.baidu.tieba.qs1;
import com.baidu.tieba.qt1;
import com.baidu.tieba.qu1;
import com.baidu.tieba.qv1;
import com.baidu.tieba.rs1;
import com.baidu.tieba.ru1;
import com.baidu.tieba.rv1;
import com.baidu.tieba.rz2;
import com.baidu.tieba.ss1;
import com.baidu.tieba.su1;
import com.baidu.tieba.sv1;
import com.baidu.tieba.ts1;
import com.baidu.tieba.tu1;
import com.baidu.tieba.uu1;
import com.baidu.tieba.uv1;
import com.baidu.tieba.vs1;
import com.baidu.tieba.vu1;
import com.baidu.tieba.wt1;
import com.baidu.tieba.wu1;
import com.baidu.tieba.ww2;
import com.baidu.tieba.xs1;
import com.baidu.tieba.xt1;
import com.baidu.tieba.xu1;
import com.baidu.tieba.ys1;
import com.baidu.tieba.yu1;
import com.baidu.tieba.ze3;
import com.baidu.tieba.zr1;
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
/* loaded from: classes3.dex */
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

    public static Map<String, Object> getV8ApiModules(final ks1 ks1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ks1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    qs1 qs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof qs1)) {
                            qs1Var = (qs1) obj;
                        } else {
                            qs1Var = new qs1(this.mSwanApiContext);
                            this.mApis.put("1930258908", qs1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(qs1Var, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Account.checkSession")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = qs1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    rs1 rs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof rs1)) {
                            rs1Var = (rs1) obj;
                        } else {
                            rs1Var = new rs1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", rs1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(rs1Var, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Account.getLoginCode")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 C = rs1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    ss1 ss1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof ss1)) {
                            ss1Var = (ss1) obj;
                        } else {
                            ss1Var = new ss1(this.mSwanApiContext);
                            this.mApis.put("1754780133", ss1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ss1Var, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Account.getOpenId")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = ss1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    zr1 zr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof zr1)) {
                            zr1Var = (zr1) obj;
                        } else {
                            zr1Var = new zr1(this.mSwanApiContext);
                            this.mApis.put("-343998465", zr1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(zr1Var, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Account.getUnionBDUSS")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = zr1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    rs1 rs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof rs1)) {
                            rs1Var = (rs1) obj;
                        } else {
                            rs1Var = new rs1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", rs1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(rs1Var, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Account.login")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 I = rs1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    ps1 ps1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof ps1)) {
                            ps1Var = (ps1) obj;
                        } else {
                            ps1Var = new ps1(this.mSwanApiContext);
                            this.mApis.put("-337742792", ps1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ps1Var, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Account.isBaiduAccountSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = ps1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    rs1 rs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof rs1)) {
                            rs1Var = (rs1) obj;
                        } else {
                            rs1Var = new rs1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", rs1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(rs1Var, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Account.isLoginSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 H = rs1Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    ts1 ts1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof ts1)) {
                            ts1Var = (ts1) obj;
                        } else {
                            ts1Var = new ts1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", ts1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ts1Var, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Basic.loadSubPackage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 F = ts1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    ts1 ts1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof ts1)) {
                            ts1Var = (ts1) obj;
                        } else {
                            ts1Var = new ts1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", ts1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ts1Var, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Basic.loadSubPackages")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 G = ts1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    al1 al1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof al1)) {
                            al1Var = (al1) obj;
                        } else {
                            al1Var = new al1(this.mSwanApiContext);
                            this.mApis.put("1460300387", al1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(al1Var, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Bookshelf.deleteBookshelf")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 K = al1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    al1 al1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof al1)) {
                            al1Var = (al1) obj;
                        } else {
                            al1Var = new al1(this.mSwanApiContext);
                            this.mApis.put("1460300387", al1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(al1Var, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Bookshelf.insertBookshelf")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 P = al1Var.P(str);
                        if (P == null) {
                            return "";
                        }
                        return P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    al1 al1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof al1)) {
                            al1Var = (al1) obj;
                        } else {
                            al1Var = new al1(this.mSwanApiContext);
                            this.mApis.put("1460300387", al1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(al1Var, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Bookshelf.navigateToBookshelf")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 U = al1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    al1 al1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof al1)) {
                            al1Var = (al1) obj;
                        } else {
                            al1Var = new al1(this.mSwanApiContext);
                            this.mApis.put("1460300387", al1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(al1Var, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Bookshelf.queryBookshelf")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 V = al1Var.V(str);
                        if (V == null) {
                            return "";
                        }
                        return V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    al1 al1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof al1)) {
                            al1Var = (al1) obj;
                        } else {
                            al1Var = new al1(this.mSwanApiContext);
                            this.mApis.put("1460300387", al1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(al1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Bookshelf.updateBookshelfReadTime")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 X = al1Var.X(str);
                        if (X == null) {
                            return "";
                        }
                        return X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    ns1 ns1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof ns1)) {
                            ns1Var = (ns1) obj;
                        } else {
                            ns1Var = new ns1(this.mSwanApiContext);
                            this.mApis.put("-277316359", ns1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ns1Var, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Coupon.getPlatformCoupons")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = ns1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    ns1 ns1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof ns1)) {
                            ns1Var = (ns1) obj;
                        } else {
                            ns1Var = new ns1(this.mSwanApiContext);
                            this.mApis.put("-277316359", ns1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ns1Var, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Coupon.getUserCoupons")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 z = ns1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    ns1 ns1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof ns1)) {
                            ns1Var = (ns1) obj;
                        } else {
                            ns1Var = new ns1(this.mSwanApiContext);
                            this.mApis.put("-277316359", ns1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ns1Var, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Coupon.takeCoupons")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 C = ns1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    vs1 vs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof vs1)) {
                            vs1Var = (vs1) obj;
                        } else {
                            vs1Var = new vs1(this.mSwanApiContext);
                            this.mApis.put("-1225406515", vs1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(vs1Var, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Favorite.getFavorStatus")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = vs1Var.x(str);
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
                        Pair<Boolean, iw1> a = kw1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Favorite.showFavoriteGuide")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 G = showFavoriteGuideApi.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    xs1 xs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof xs1)) {
                            xs1Var = (xs1) obj;
                        } else {
                            xs1Var = new xs1(this.mSwanApiContext);
                            this.mApis.put("-2057135077", xs1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(xs1Var, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "File.shareFile")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = xs1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    mh2 mh2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof mh2)) {
                            mh2Var = (mh2) obj;
                        } else {
                            mh2Var = new mh2(this.mSwanApiContext);
                            this.mApis.put("2077414795", mh2Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(mh2Var, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = mh2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    mh2 mh2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof mh2)) {
                            mh2Var = (mh2) obj;
                        } else {
                            mh2Var = new mh2(this.mSwanApiContext);
                            this.mApis.put("2077414795", mh2Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(mh2Var, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessageSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = mh2Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String download(String str) {
                    ys1 ys1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof ys1)) {
                            ys1Var = (ys1) obj;
                        } else {
                            ys1Var = new ys1(this.mSwanApiContext);
                            this.mApis.put("-170124576", ys1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ys1Var, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "HostDownloadManager.download")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = ys1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    ys1 ys1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof ys1)) {
                            ys1Var = (ys1) obj;
                        } else {
                            ys1Var = new ys1(this.mSwanApiContext);
                            this.mApis.put("-170124576", ys1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ys1Var, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "HostDownloadManager.openFile")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 z = ys1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    ys1 ys1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof ys1)) {
                            ys1Var = (ys1) obj;
                        } else {
                            ys1Var = new ys1(this.mSwanApiContext);
                            this.mApis.put("-170124576", ys1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ys1Var, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "HostDownloadManager.query")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 query = ys1Var.query(str);
                        if (query == null) {
                            return "";
                        }
                        return query.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    ys1 ys1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof ys1)) {
                            ys1Var = (ys1) obj;
                        } else {
                            ys1Var = new ys1(this.mSwanApiContext);
                            this.mApis.put("-170124576", ys1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ys1Var, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "HostDownloadManager.openDownloadCenter")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = ys1Var.y();
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naImage", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    au2 au2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof au2)) {
                            au2Var = (au2) obj;
                        } else {
                            au2Var = new au2(this.mSwanApiContext);
                            this.mApis.put("1445003743", au2Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(au2Var, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Image.callImageMenu")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = au2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    bt1 bt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof bt1)) {
                            bt1Var = (bt1) obj;
                        } else {
                            bt1Var = new bt1(this.mSwanApiContext);
                            this.mApis.put("-1252730367", bt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(bt1Var, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Image.compressImage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = bt1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    jt1 jt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof jt1)) {
                            jt1Var = (jt1) obj;
                        } else {
                            jt1Var = new jt1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", jt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(jt1Var, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.closeTabBar")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = jt1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    jt1 jt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof jt1)) {
                            jt1Var = (jt1) obj;
                        } else {
                            jt1Var = new jt1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", jt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(jt1Var, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.closeTabBarRedDot")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = jt1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    ft1 ft1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("-246386074", ft1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ft1Var, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.hideNavigationBarLoading")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = ft1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    ht1 ht1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ht1)) {
                            ht1Var = (ht1) obj;
                        } else {
                            ht1Var = new ht1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ht1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ht1Var, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.openMultiPicker")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 G = ht1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    ht1 ht1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ht1)) {
                            ht1Var = (ht1) obj;
                        } else {
                            ht1Var = new ht1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ht1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ht1Var, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.openPicker")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 H = ht1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    jt1 jt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof jt1)) {
                            jt1Var = (jt1) obj;
                        } else {
                            jt1Var = new jt1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", jt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(jt1Var, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.openTabBar")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 C = jt1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    gt1 gt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof gt1)) {
                            gt1Var = (gt1) obj;
                        } else {
                            gt1Var = new gt1(this.mSwanApiContext);
                            this.mApis.put("-1750613704", gt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(gt1Var, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.pageScrollTo")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = gt1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    ft1 ft1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("-246386074", ft1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ft1Var, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarColor")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 z = ft1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    ft1 ft1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("-246386074", ft1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ft1Var, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarTitle")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = ft1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    jt1 jt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof jt1)) {
                            jt1Var = (jt1) obj;
                        } else {
                            jt1Var = new jt1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", jt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(jt1Var, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.setTabBarItem")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 D = jt1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    ht1 ht1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ht1)) {
                            ht1Var = (ht1) obj;
                        } else {
                            ht1Var = new ht1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ht1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ht1Var, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.showDatePickerView")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 L = ht1Var.L(str);
                        if (L == null) {
                            return "";
                        }
                        return L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    lt1 lt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof lt1)) {
                            lt1Var = (lt1) obj;
                        } else {
                            lt1Var = new lt1(this.mSwanApiContext);
                            this.mApis.put("1172469410", lt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(lt1Var, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.showHalfScreenWebview")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 K = lt1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    dt1 dt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof dt1)) {
                            dt1Var = (dt1) obj;
                        } else {
                            dt1Var = new dt1(this.mSwanApiContext);
                            this.mApis.put("5236036", dt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(dt1Var, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.showLoading")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = dt1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    et1 et1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof et1)) {
                            et1Var = (et1) obj;
                        } else {
                            et1Var = new et1(this.mSwanApiContext);
                            this.mApis.put("1913747800", et1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(et1Var, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.showModal")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = et1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    ft1 ft1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("-246386074", ft1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ft1Var, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.showNavigationBarLoading")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 B = ft1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    kt1 kt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof kt1)) {
                            kt1Var = (kt1) obj;
                        } else {
                            kt1Var = new kt1(this.mSwanApiContext);
                            this.mApis.put("1159492510", kt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(kt1Var, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.showToast")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 Q = kt1Var.Q(str);
                        if (Q == null) {
                            return "";
                        }
                        return Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    it1 it1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof it1)) {
                            it1Var = (it1) obj;
                        } else {
                            it1Var = new it1(this.mSwanApiContext);
                            this.mApis.put("1165118609", it1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(it1Var, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.stopPullDownRefresh")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = it1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    ht1 ht1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ht1)) {
                            ht1Var = (ht1) obj;
                        } else {
                            ht1Var = new ht1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ht1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ht1Var, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.updateMultiPicker")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 M = ht1Var.M(str);
                        if (M == null) {
                            return "";
                        }
                        return M.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    dt1 dt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof dt1)) {
                            dt1Var = (dt1) obj;
                        } else {
                            dt1Var = new dt1(this.mSwanApiContext);
                            this.mApis.put("5236036", dt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(dt1Var, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.hideLoading")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = dt1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    kt1 kt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof kt1)) {
                            kt1Var = (kt1) obj;
                        } else {
                            kt1Var = new kt1(this.mSwanApiContext);
                            this.mApis.put("1159492510", kt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(kt1Var, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.hideToast")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 K = kt1Var.K();
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    mt1 mt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("-137346255", mt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(mt1Var, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Keyboard.startKeyboardHeightChange")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 C = mt1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    mt1 mt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("-137346255", mt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(mt1Var, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Keyboard.stopKeyboardHeightChange")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 D = mt1Var.D();
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("-397373095", nt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(nt1Var, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "LocationService.getLocation")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = nt1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("-397373095", nt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(nt1Var, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "LocationService.startLocationUpdate")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = nt1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    nt1 nt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("-397373095", nt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(nt1Var, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "LocationService.stopLocationUpdate")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 B = nt1Var.B();
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    ev1 ev1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof ev1)) {
                            ev1Var = (ev1) obj;
                        } else {
                            ev1Var = new ev1(this.mSwanApiContext);
                            this.mApis.put("538070032", ev1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ev1Var, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = ev1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String callService(String str) {
                    qt1 qt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof qt1)) {
                            qt1Var = (qt1) obj;
                        } else {
                            qt1Var = new qt1(this.mSwanApiContext);
                            this.mApis.put("-1076509454", qt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(qt1Var, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Network.callService")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = qt1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    xt1 xt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof xt1)) {
                            xt1Var = (xt1) obj;
                        } else {
                            xt1Var = new xt1(this.mSwanApiContext);
                            this.mApis.put("968563034", xt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(xt1Var, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Network.cancelRequest")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 D = xt1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    wt1 wt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof wt1)) {
                            wt1Var = (wt1) obj;
                        } else {
                            wt1Var = new wt1(this.mSwanApiContext);
                            this.mApis.put("453220699", wt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(wt1Var, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Network.networkStatusChange")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = wt1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    wt1 wt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof wt1)) {
                            wt1Var = (wt1) obj;
                        } else {
                            wt1Var = new wt1(this.mSwanApiContext);
                            this.mApis.put("453220699", wt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(wt1Var, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Network.getNetworkType")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = wt1Var.x();
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
                    xt1 xt1Var;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, jsObject)) == null) {
                        try {
                            hw1.c().a("request");
                            Object obj = this.mApis.get("968563034");
                            if (obj != null && (obj instanceof xt1)) {
                                xt1Var = (xt1) obj;
                            } else {
                                xt1Var = new xt1(this.mSwanApiContext);
                                this.mApis.put("968563034", xt1Var);
                            }
                            Pair<Boolean, iw1> a2 = kw1.a(xt1Var, "swanAPI/request");
                            if (((Boolean) a2.first).booleanValue()) {
                                a = ((iw1) a2.second).a();
                            } else if (q62.a(this.mSwanApiContext.f(), "Network.request")) {
                                a = new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            } else {
                                Pair<iw1, JSONObject> t = ms1.t(jsObject);
                                if (!((iw1) t.first).isSuccess()) {
                                    a = ((iw1) t.first).a();
                                } else {
                                    JSONObject jSONObject = (JSONObject) t.second;
                                    if (jSONObject == null) {
                                        a = iw1.a.a();
                                    } else {
                                        jw1 V = xt1Var.V(jSONObject);
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
            hashMap.put("_naPayment", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    gx2 gx2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof gx2)) {
                            gx2Var = (gx2) obj;
                        } else {
                            gx2Var = new gx2(this.mSwanApiContext);
                            this.mApis.put("-336396851", gx2Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(gx2Var, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Payment.chooseCoupon")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = gx2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    gx2 gx2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof gx2)) {
                            gx2Var = (gx2) obj;
                        } else {
                            gx2Var = new gx2(this.mSwanApiContext);
                            this.mApis.put("-336396851", gx2Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(gx2Var, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Payment.getPaymentInfo")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = gx2Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    ww2 ww2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof ww2)) {
                            ww2Var = (ww2) obj;
                        } else {
                            ww2Var = new ww2(this.mSwanApiContext);
                            this.mApis.put("1854689529", ww2Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ww2Var, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Payment.requestThirdPayment")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = ww2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    gx2 gx2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof gx2)) {
                            gx2Var = (gx2) obj;
                        } else {
                            gx2Var = new gx2(this.mSwanApiContext);
                            this.mApis.put("-336396851", gx2Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(gx2Var, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Payment.setPaymentInfo")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 z = gx2Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    rz2 rz2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof rz2)) {
                            rz2Var = (rz2) obj;
                        } else {
                            rz2Var = new rz2(this.mSwanApiContext);
                            this.mApis.put("-254510461", rz2Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(rz2Var, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Plugin.invokePluginChooseAddress")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = rz2Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    rz2 rz2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof rz2)) {
                            rz2Var = (rz2) obj;
                        } else {
                            rz2Var = new rz2(this.mSwanApiContext);
                            this.mApis.put("-254510461", rz2Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(rz2Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 z = rz2Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    rz2 rz2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof rz2)) {
                            rz2Var = (rz2) obj;
                        } else {
                            rz2Var = new rz2(this.mSwanApiContext);
                            this.mApis.put("-254510461", rz2Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(rz2Var, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Plugin.invokePluginPayment")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = rz2Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    k82 k82Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof k82)) {
                            k82Var = (k82) obj;
                        } else {
                            k82Var = new k82(this.mSwanApiContext);
                            this.mApis.put("-2068479848", k82Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(k82Var, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Prefetch.prefetchResources")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = k82Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    c72 c72Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof c72)) {
                            c72Var = (c72) obj;
                        } else {
                            c72Var = new c72(this.mSwanApiContext);
                            this.mApis.put("423661539", c72Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(c72Var, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Preload.preloadStatus")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = c72Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    mg3 mg3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof mg3)) {
                            mg3Var = (mg3) obj;
                        } else {
                            mg3Var = new mg3(this.mSwanApiContext);
                            this.mApis.put("-1929343869", mg3Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(mg3Var, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "PrivateFile.uploadFileToBos")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 C = mg3Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    bu1 bu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof bu1)) {
                            bu1Var = (bu1) obj;
                        } else {
                            bu1Var = new bu1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", bu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(bu1Var, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Router.hideModalPage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = bu1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    bu1 bu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof bu1)) {
                            bu1Var = (bu1) obj;
                        } else {
                            bu1Var = new bu1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", bu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(bu1Var, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Router.navigateBack")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 B = bu1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    cu1 cu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof cu1)) {
                            cu1Var = (cu1) obj;
                        } else {
                            cu1Var = new cu1(this.mSwanApiContext);
                            this.mApis.put("1968522584", cu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(cu1Var, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Router.navigateTo")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 H = cu1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    eu1 eu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof eu1)) {
                            eu1Var = (eu1) obj;
                        } else {
                            eu1Var = new eu1(this.mSwanApiContext);
                            this.mApis.put("1317280190", eu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(eu1Var, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Router.reLaunch")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = eu1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    fu1 fu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("-420075743", fu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(fu1Var, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Router.reLoadErrorPage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = fu1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    du1 du1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof du1)) {
                            du1Var = (du1) obj;
                        } else {
                            du1Var = new du1(this.mSwanApiContext);
                            this.mApis.put("1792515533", du1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(du1Var, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Router.redirectTo")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 D = du1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    cu1 cu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof cu1)) {
                            cu1Var = (cu1) obj;
                        } else {
                            cu1Var = new cu1(this.mSwanApiContext);
                            this.mApis.put("1968522584", cu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(cu1Var, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Router.showModalPage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 J = cu1Var.J(str);
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    iu1 iu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof iu1)) {
                            iu1Var = (iu1) obj;
                        } else {
                            iu1Var = new iu1(this.mSwanApiContext);
                            this.mApis.put("-594895721", iu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(iu1Var, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Setting.getAppInfoSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 F = iu1Var.F();
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    iu1 iu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof iu1)) {
                            iu1Var = (iu1) obj;
                        } else {
                            iu1Var = new iu1(this.mSwanApiContext);
                            this.mApis.put("-594895721", iu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(iu1Var, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Setting.getSlaveIdSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 H = iu1Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    hu1 hu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("450273045", hu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(hu1Var, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Setting.isAllowedAdOpenAppSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = hu1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    iu1 iu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof iu1)) {
                            iu1Var = (iu1) obj;
                        } else {
                            iu1Var = new iu1(this.mSwanApiContext);
                            this.mApis.put("-594895721", iu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(iu1Var, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Setting.getSetting")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 G = iu1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    iu1 iu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof iu1)) {
                            iu1Var = (iu1) obj;
                        } else {
                            iu1Var = new iu1(this.mSwanApiContext);
                            this.mApis.put("-594895721", iu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(iu1Var, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Setting.getSwanId")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 I = iu1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    iu1 iu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof iu1)) {
                            iu1Var = (iu1) obj;
                        } else {
                            iu1Var = new iu1(this.mSwanApiContext);
                            this.mApis.put("-594895721", iu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(iu1Var, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Setting.getUserInfo")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 J = iu1Var.J(str);
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    gb3 gb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof gb3)) {
                            gb3Var = (gb3) obj;
                        } else {
                            gb3Var = new gb3(this.mSwanApiContext);
                            this.mApis.put("712777136", gb3Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(gb3Var, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = gb3Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    lu1 lu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lu1)) {
                            lu1Var = (lu1) obj;
                        } else {
                            lu1Var = new lu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(lu1Var, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = lu1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    lu1 lu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lu1)) {
                            lu1Var = (lu1) obj;
                        } else {
                            lu1Var = new lu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(lu1Var, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorageSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 C = lu1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    ku1 ku1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ku1)) {
                            ku1Var = (ku1) obj;
                        } else {
                            ku1Var = new ku1(this.mSwanApiContext);
                            this.mApis.put("130910081", ku1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ku1Var, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.clearStorage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = ku1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    ku1 ku1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ku1)) {
                            ku1Var = (ku1) obj;
                        } else {
                            ku1Var = new ku1(this.mSwanApiContext);
                            this.mApis.put("130910081", ku1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ku1Var, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.clearStorageSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 C = ku1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    lu1 lu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lu1)) {
                            lu1Var = (lu1) obj;
                        } else {
                            lu1Var = new lu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(lu1Var, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfo")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 G = lu1Var.G();
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    lu1 lu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lu1)) {
                            lu1Var = (lu1) obj;
                        } else {
                            lu1Var = new lu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(lu1Var, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfoSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 J = lu1Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    ku1 ku1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ku1)) {
                            ku1Var = (ku1) obj;
                        } else {
                            ku1Var = new ku1(this.mSwanApiContext);
                            this.mApis.put("130910081", ku1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ku1Var, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.getStorageInfo")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 G = ku1Var.G();
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    ku1 ku1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ku1)) {
                            ku1Var = (ku1) obj;
                        } else {
                            ku1Var = new ku1(this.mSwanApiContext);
                            this.mApis.put("130910081", ku1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ku1Var, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.getStorageInfoSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 J = ku1Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    lu1 lu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lu1)) {
                            lu1Var = (lu1) obj;
                        } else {
                            lu1Var = new lu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(lu1Var, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.getGlobalStorage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 D = lu1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    lu1 lu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lu1)) {
                            lu1Var = (lu1) obj;
                        } else {
                            lu1Var = new lu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(lu1Var, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 K = lu1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    ku1 ku1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ku1)) {
                            ku1Var = (ku1) obj;
                        } else {
                            ku1Var = new ku1(this.mSwanApiContext);
                            this.mApis.put("130910081", ku1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ku1Var, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.getStorage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 D = ku1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    ku1 ku1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ku1)) {
                            ku1Var = (ku1) obj;
                        } else {
                            ku1Var = new ku1(this.mSwanApiContext);
                            this.mApis.put("130910081", ku1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ku1Var, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.getStorageInfoAsync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 H = ku1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    ku1 ku1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ku1)) {
                            ku1Var = (ku1) obj;
                        } else {
                            ku1Var = new ku1(this.mSwanApiContext);
                            this.mApis.put("130910081", ku1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ku1Var, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.getStorageSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 K = ku1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    lu1 lu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lu1)) {
                            lu1Var = (lu1) obj;
                        } else {
                            lu1Var = new lu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(lu1Var, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 R = lu1Var.R(str);
                        if (R == null) {
                            return "";
                        }
                        return R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    lu1 lu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lu1)) {
                            lu1Var = (lu1) obj;
                        } else {
                            lu1Var = new lu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(lu1Var, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorageSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 T = lu1Var.T(str);
                        if (T == null) {
                            return "";
                        }
                        return T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    ku1 ku1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ku1)) {
                            ku1Var = (ku1) obj;
                        } else {
                            ku1Var = new ku1(this.mSwanApiContext);
                            this.mApis.put("130910081", ku1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ku1Var, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.removeStorage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 R = ku1Var.R(str);
                        if (R == null) {
                            return "";
                        }
                        return R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    ku1 ku1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ku1)) {
                            ku1Var = (ku1) obj;
                        } else {
                            ku1Var = new ku1(this.mSwanApiContext);
                            this.mApis.put("130910081", ku1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ku1Var, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.removeStorageSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 T = ku1Var.T(str);
                        if (T == null) {
                            return "";
                        }
                        return T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    lu1 lu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lu1)) {
                            lu1Var = (lu1) obj;
                        } else {
                            lu1Var = new lu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(lu1Var, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.setGlobalStorage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 U = lu1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    lu1 lu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lu1)) {
                            lu1Var = (lu1) obj;
                        } else {
                            lu1Var = new lu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(lu1Var, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.setGlobalStorageSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 W = lu1Var.W(str);
                        if (W == null) {
                            return "";
                        }
                        return W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    ku1 ku1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ku1)) {
                            ku1Var = (ku1) obj;
                        } else {
                            ku1Var = new ku1(this.mSwanApiContext);
                            this.mApis.put("130910081", ku1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ku1Var, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.setStorage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 U = ku1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    ku1 ku1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ku1)) {
                            ku1Var = (ku1) obj;
                        } else {
                            ku1Var = new ku1(this.mSwanApiContext);
                            this.mApis.put("130910081", ku1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ku1Var, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.setStorageSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 W = ku1Var.W(str);
                        if (W == null) {
                            return "";
                        }
                        return W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    nu1 nu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof nu1)) {
                            nu1Var = (nu1) obj;
                        } else {
                            nu1Var = new nu1(this.mSwanApiContext);
                            this.mApis.put("823117982", nu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(nu1Var, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Subscription.requestSubscribeFormId")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 E = nu1Var.E(str);
                        if (E == null) {
                            return "";
                        }
                        return E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    ou1 ou1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof ou1)) {
                            ou1Var = (ou1) obj;
                        } else {
                            ou1Var = new ou1(this.mSwanApiContext);
                            this.mApis.put("-947445811", ou1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ou1Var, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Subscription.subscribeService")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 F = ou1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    vu1 vu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof vu1)) {
                            vu1Var = (vu1) obj;
                        } else {
                            vu1Var = new vu1(this.mSwanApiContext);
                            this.mApis.put("1936205521", vu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(vu1Var, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.exitFullScreen")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = vu1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    uu1 uu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof uu1)) {
                            uu1Var = (uu1) obj;
                        } else {
                            uu1Var = new uu1(this.mSwanApiContext);
                            this.mApis.put("1694151270", uu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(uu1Var, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.getDeviceInfo")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = uu1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    wu1 wu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof wu1)) {
                            wu1Var = (wu1) obj;
                        } else {
                            wu1Var = new wu1(this.mSwanApiContext);
                            this.mApis.put("-1321681619", wu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(wu1Var, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.getDeviceProfile")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = wu1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    xu1 xu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof xu1)) {
                            xu1Var = (xu1) obj;
                        } else {
                            xu1Var = new xu1(this.mSwanApiContext);
                            this.mApis.put("-1569246082", xu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(xu1Var, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.makePhoneCall")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = xu1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    zu1 zu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof zu1)) {
                            zu1Var = (zu1) obj;
                        } else {
                            zu1Var = new zu1(this.mSwanApiContext);
                            this.mApis.put("1099851202", zu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(zu1Var, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.openSMSPanel")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = zu1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    yu1 yu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof yu1)) {
                            yu1Var = (yu1) obj;
                        } else {
                            yu1Var = new yu1(this.mSwanApiContext);
                            this.mApis.put("-1707203360", yu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(yu1Var, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.requestFullScreen")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 F = yu1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    su1 su1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof su1)) {
                            su1Var = (su1) obj;
                        } else {
                            su1Var = new su1(this.mSwanApiContext);
                            this.mApis.put("-518757484", su1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(su1Var, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.setClipboardData")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = su1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    cu2 cu2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof cu2)) {
                            cu2Var = (cu2) obj;
                        } else {
                            cu2Var = new cu2(this.mSwanApiContext);
                            this.mApis.put("1161486049", cu2Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(cu2Var, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.setErrorPageType")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = cu2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    cv1 cv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof cv1)) {
                            cv1Var = (cv1) obj;
                        } else {
                            cv1Var = new cv1(this.mSwanApiContext);
                            this.mApis.put("447234992", cv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(cv1Var, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.setMediaVolume")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 z = cv1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    qu1 qu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof qu1)) {
                            qu1Var = (qu1) obj;
                        } else {
                            qu1Var = new qu1(this.mSwanApiContext);
                            this.mApis.put("1372680763", qu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(qu1Var, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.startAccelerometer")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = qu1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    tu1 tu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof tu1)) {
                            tu1Var = (tu1) obj;
                        } else {
                            tu1Var = new tu1(this.mSwanApiContext);
                            this.mApis.put("1689255576", tu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(tu1Var, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.startCompass")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = tu1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    ru1 ru1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof ru1)) {
                            ru1Var = (ru1) obj;
                        } else {
                            ru1Var = new ru1(this.mSwanApiContext);
                            this.mApis.put("99997465", ru1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ru1Var, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.getBrightness")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = ru1Var.y();
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    su1 su1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof su1)) {
                            su1Var = (su1) obj;
                        } else {
                            su1Var = new su1(this.mSwanApiContext);
                            this.mApis.put("-518757484", su1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(su1Var, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.getClipboardData")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = su1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    cv1 cv1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof cv1)) {
                            cv1Var = (cv1) obj;
                        } else {
                            cv1Var = new cv1(this.mSwanApiContext);
                            this.mApis.put("447234992", cv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(cv1Var, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.getMediaVolume")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = cv1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    qu1 qu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof qu1)) {
                            qu1Var = (qu1) obj;
                        } else {
                            qu1Var = new qu1(this.mSwanApiContext);
                            this.mApis.put("1372680763", qu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(qu1Var, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.stopAccelerometer")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 B = qu1Var.B();
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    tu1 tu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof tu1)) {
                            tu1Var = (tu1) obj;
                        } else {
                            tu1Var = new tu1(this.mSwanApiContext);
                            this.mApis.put("1689255576", tu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(tu1Var, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.stopCompass")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 z = tu1Var.z();
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    nv1 nv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof nv1)) {
                            nv1Var = (nv1) obj;
                        } else {
                            nv1Var = new nv1(this.mSwanApiContext);
                            this.mApis.put("201194468", nv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(nv1Var, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.addToDesktop")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 B = nv1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    jv1 jv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof jv1)) {
                            jv1Var = (jv1) obj;
                        } else {
                            jv1Var = new jv1(this.mSwanApiContext);
                            this.mApis.put("-1412306947", jv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(jv1Var, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.calcMD5")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = jv1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    kv1 kv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof kv1)) {
                            kv1Var = (kv1) obj;
                        } else {
                            kv1Var = new kv1(this.mSwanApiContext);
                            this.mApis.put("1626415364", kv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(kv1Var, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.checkAppInstalled")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = kv1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    mv1 mv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof mv1)) {
                            mv1Var = (mv1) obj;
                        } else {
                            mv1Var = new mv1(this.mSwanApiContext);
                            this.mApis.put("-836768778", mv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(mv1Var, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfo")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = mv1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    ov1 ov1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof ov1)) {
                            ov1Var = (ov1) obj;
                        } else {
                            ov1Var = new ov1(this.mSwanApiContext);
                            this.mApis.put("-810858308", ov1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ov1Var, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.getPerformanceLevel")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = ov1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    sv1 sv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof sv1)) {
                            sv1Var = (sv1) obj;
                        } else {
                            sv1Var = new sv1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", sv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(sv1Var, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.getSystemInfoAsync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 I = sv1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    pv1 pv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof pv1)) {
                            pv1Var = (pv1) obj;
                        } else {
                            pv1Var = new pv1(this.mSwanApiContext);
                            this.mApis.put("-2097727681", pv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(pv1Var, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.handleException")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = pv1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    lv1 lv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof lv1)) {
                            lv1Var = (lv1) obj;
                        } else {
                            lv1Var = new lv1(this.mSwanApiContext);
                            this.mApis.put("2084449317", lv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(lv1Var, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.hasCloseHandler")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = lv1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    o83 o83Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof o83)) {
                            o83Var = (o83) obj;
                        } else {
                            o83Var = new o83(this.mSwanApiContext);
                            this.mApis.put("1031678042", o83Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(o83Var, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.hideCaptureScreenShareDialog")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = o83Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    qv1 qv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof qv1)) {
                            qv1Var = (qv1) obj;
                        } else {
                            qv1Var = new qv1(this.mSwanApiContext);
                            this.mApis.put("1751900130", qv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(qv1Var, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.logToFile")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = qv1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    p73 p73Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof p73)) {
                            p73Var = (p73) obj;
                        } else {
                            p73Var = new p73(this.mSwanApiContext);
                            this.mApis.put("1748196865", p73Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(p73Var, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.preloadPackage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = p73Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    rv1 rv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof rv1)) {
                            rv1Var = (rv1) obj;
                        } else {
                            rv1Var = new rv1(this.mSwanApiContext);
                            this.mApis.put("589529211", rv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(rv1Var, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.previewImage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 B = rv1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    uv1 uv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof uv1)) {
                            uv1Var = (uv1) obj;
                        } else {
                            uv1Var = new uv1(this.mSwanApiContext);
                            this.mApis.put("-577481801", uv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(uv1Var, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.ubcFlowJar")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 I = uv1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    sv1 sv1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof sv1)) {
                            sv1Var = (sv1) obj;
                        } else {
                            sv1Var = new sv1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", sv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(sv1Var, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfoSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 E = sv1Var.E();
                        if (E == null) {
                            return "";
                        }
                        return E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    sv1 sv1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof sv1)) {
                            sv1Var = (sv1) obj;
                        } else {
                            sv1Var = new sv1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", sv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(sv1Var, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.getSystemInfo")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 H = sv1Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    sv1 sv1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof sv1)) {
                            sv1Var = (sv1) obj;
                        } else {
                            sv1Var = new sv1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", sv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(sv1Var, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.getSystemInfoSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 J = sv1Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    ze3 ze3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ze3)) {
                            ze3Var = (ze3) obj;
                        } else {
                            ze3Var = new ze3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ze3Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ze3Var, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Wifi.connectWifi")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = ze3Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    ze3 ze3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ze3)) {
                            ze3Var = (ze3) obj;
                        } else {
                            ze3Var = new ze3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ze3Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ze3Var, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Wifi.getConnectedWifi")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 B = ze3Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    ze3 ze3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ze3)) {
                            ze3Var = (ze3) obj;
                        } else {
                            ze3Var = new ze3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ze3Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ze3Var, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Wifi.getWifiList")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 C = ze3Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    ze3 ze3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ze3)) {
                            ze3Var = (ze3) obj;
                        } else {
                            ze3Var = new ze3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ze3Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ze3Var, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Wifi.startWifi")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 G = ze3Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    ze3 ze3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ze3)) {
                            ze3Var = (ze3) obj;
                        } else {
                            ze3Var = new ze3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ze3Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ze3Var, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Wifi.stopWifi")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 H = ze3Var.H(str);
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

    public static Map<String, Object> getWebviewApiModules(final ks1 ks1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ks1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    qs1 qs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof qs1)) {
                            qs1Var = (qs1) obj;
                        } else {
                            qs1Var = new qs1(this.mSwanApiContext);
                            this.mApis.put("1930258908", qs1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(qs1Var, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Account.checkSession")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = qs1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    rs1 rs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof rs1)) {
                            rs1Var = (rs1) obj;
                        } else {
                            rs1Var = new rs1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", rs1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(rs1Var, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Account.getLoginCode")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 C = rs1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    ss1 ss1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof ss1)) {
                            ss1Var = (ss1) obj;
                        } else {
                            ss1Var = new ss1(this.mSwanApiContext);
                            this.mApis.put("1754780133", ss1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ss1Var, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Account.getOpenId")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = ss1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    zr1 zr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof zr1)) {
                            zr1Var = (zr1) obj;
                        } else {
                            zr1Var = new zr1(this.mSwanApiContext);
                            this.mApis.put("-343998465", zr1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(zr1Var, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Account.getUnionBDUSS")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = zr1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    rs1 rs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof rs1)) {
                            rs1Var = (rs1) obj;
                        } else {
                            rs1Var = new rs1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", rs1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(rs1Var, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Account.login")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 I = rs1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    ps1 ps1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof ps1)) {
                            ps1Var = (ps1) obj;
                        } else {
                            ps1Var = new ps1(this.mSwanApiContext);
                            this.mApis.put("-337742792", ps1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ps1Var, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Account.isBaiduAccountSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = ps1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    rs1 rs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof rs1)) {
                            rs1Var = (rs1) obj;
                        } else {
                            rs1Var = new rs1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", rs1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(rs1Var, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Account.isLoginSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 H = rs1Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    ts1 ts1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof ts1)) {
                            ts1Var = (ts1) obj;
                        } else {
                            ts1Var = new ts1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", ts1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ts1Var, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Basic.loadSubPackage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 F = ts1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    ts1 ts1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof ts1)) {
                            ts1Var = (ts1) obj;
                        } else {
                            ts1Var = new ts1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", ts1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ts1Var, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Basic.loadSubPackages")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 G = ts1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    al1 al1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof al1)) {
                            al1Var = (al1) obj;
                        } else {
                            al1Var = new al1(this.mSwanApiContext);
                            this.mApis.put("1460300387", al1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(al1Var, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Bookshelf.deleteBookshelf")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 K = al1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    al1 al1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof al1)) {
                            al1Var = (al1) obj;
                        } else {
                            al1Var = new al1(this.mSwanApiContext);
                            this.mApis.put("1460300387", al1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(al1Var, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Bookshelf.insertBookshelf")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 P = al1Var.P(str);
                        if (P == null) {
                            return "";
                        }
                        return P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    al1 al1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof al1)) {
                            al1Var = (al1) obj;
                        } else {
                            al1Var = new al1(this.mSwanApiContext);
                            this.mApis.put("1460300387", al1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(al1Var, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Bookshelf.navigateToBookshelf")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 U = al1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    al1 al1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof al1)) {
                            al1Var = (al1) obj;
                        } else {
                            al1Var = new al1(this.mSwanApiContext);
                            this.mApis.put("1460300387", al1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(al1Var, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Bookshelf.queryBookshelf")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 V = al1Var.V(str);
                        if (V == null) {
                            return "";
                        }
                        return V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    al1 al1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof al1)) {
                            al1Var = (al1) obj;
                        } else {
                            al1Var = new al1(this.mSwanApiContext);
                            this.mApis.put("1460300387", al1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(al1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Bookshelf.updateBookshelfReadTime")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 X = al1Var.X(str);
                        if (X == null) {
                            return "";
                        }
                        return X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    ns1 ns1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof ns1)) {
                            ns1Var = (ns1) obj;
                        } else {
                            ns1Var = new ns1(this.mSwanApiContext);
                            this.mApis.put("-277316359", ns1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ns1Var, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Coupon.getPlatformCoupons")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = ns1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    ns1 ns1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof ns1)) {
                            ns1Var = (ns1) obj;
                        } else {
                            ns1Var = new ns1(this.mSwanApiContext);
                            this.mApis.put("-277316359", ns1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ns1Var, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Coupon.getUserCoupons")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 z = ns1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    ns1 ns1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof ns1)) {
                            ns1Var = (ns1) obj;
                        } else {
                            ns1Var = new ns1(this.mSwanApiContext);
                            this.mApis.put("-277316359", ns1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ns1Var, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Coupon.takeCoupons")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 C = ns1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    vs1 vs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof vs1)) {
                            vs1Var = (vs1) obj;
                        } else {
                            vs1Var = new vs1(this.mSwanApiContext);
                            this.mApis.put("-1225406515", vs1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(vs1Var, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Favorite.getFavorStatus")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = vs1Var.x(str);
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
                        Pair<Boolean, iw1> a = kw1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Favorite.showFavoriteGuide")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 G = showFavoriteGuideApi.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    xs1 xs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof xs1)) {
                            xs1Var = (xs1) obj;
                        } else {
                            xs1Var = new xs1(this.mSwanApiContext);
                            this.mApis.put("-2057135077", xs1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(xs1Var, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "File.shareFile")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = xs1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    mh2 mh2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof mh2)) {
                            mh2Var = (mh2) obj;
                        } else {
                            mh2Var = new mh2(this.mSwanApiContext);
                            this.mApis.put("2077414795", mh2Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(mh2Var, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = mh2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    mh2 mh2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof mh2)) {
                            mh2Var = (mh2) obj;
                        } else {
                            mh2Var = new mh2(this.mSwanApiContext);
                            this.mApis.put("2077414795", mh2Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(mh2Var, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessageSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = mh2Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String download(String str) {
                    ys1 ys1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof ys1)) {
                            ys1Var = (ys1) obj;
                        } else {
                            ys1Var = new ys1(this.mSwanApiContext);
                            this.mApis.put("-170124576", ys1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ys1Var, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "HostDownloadManager.download")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = ys1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    ys1 ys1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof ys1)) {
                            ys1Var = (ys1) obj;
                        } else {
                            ys1Var = new ys1(this.mSwanApiContext);
                            this.mApis.put("-170124576", ys1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ys1Var, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "HostDownloadManager.openFile")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 z = ys1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    ys1 ys1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof ys1)) {
                            ys1Var = (ys1) obj;
                        } else {
                            ys1Var = new ys1(this.mSwanApiContext);
                            this.mApis.put("-170124576", ys1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ys1Var, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "HostDownloadManager.query")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 query = ys1Var.query(str);
                        if (query == null) {
                            return "";
                        }
                        return query.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    ys1 ys1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof ys1)) {
                            ys1Var = (ys1) obj;
                        } else {
                            ys1Var = new ys1(this.mSwanApiContext);
                            this.mApis.put("-170124576", ys1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ys1Var, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "HostDownloadManager.openDownloadCenter")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = ys1Var.y();
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naImage", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    au2 au2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof au2)) {
                            au2Var = (au2) obj;
                        } else {
                            au2Var = new au2(this.mSwanApiContext);
                            this.mApis.put("1445003743", au2Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(au2Var, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Image.callImageMenu")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = au2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    bt1 bt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof bt1)) {
                            bt1Var = (bt1) obj;
                        } else {
                            bt1Var = new bt1(this.mSwanApiContext);
                            this.mApis.put("-1252730367", bt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(bt1Var, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Image.compressImage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = bt1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    jt1 jt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof jt1)) {
                            jt1Var = (jt1) obj;
                        } else {
                            jt1Var = new jt1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", jt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(jt1Var, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.closeTabBar")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = jt1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    jt1 jt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof jt1)) {
                            jt1Var = (jt1) obj;
                        } else {
                            jt1Var = new jt1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", jt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(jt1Var, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.closeTabBarRedDot")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = jt1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    ft1 ft1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("-246386074", ft1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ft1Var, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.hideNavigationBarLoading")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = ft1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    ht1 ht1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ht1)) {
                            ht1Var = (ht1) obj;
                        } else {
                            ht1Var = new ht1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ht1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ht1Var, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.openMultiPicker")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 G = ht1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    ht1 ht1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ht1)) {
                            ht1Var = (ht1) obj;
                        } else {
                            ht1Var = new ht1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ht1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ht1Var, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.openPicker")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 H = ht1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    jt1 jt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof jt1)) {
                            jt1Var = (jt1) obj;
                        } else {
                            jt1Var = new jt1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", jt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(jt1Var, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.openTabBar")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 C = jt1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    gt1 gt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof gt1)) {
                            gt1Var = (gt1) obj;
                        } else {
                            gt1Var = new gt1(this.mSwanApiContext);
                            this.mApis.put("-1750613704", gt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(gt1Var, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.pageScrollTo")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = gt1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    ft1 ft1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("-246386074", ft1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ft1Var, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarColor")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 z = ft1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    ft1 ft1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("-246386074", ft1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ft1Var, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarTitle")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = ft1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    jt1 jt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof jt1)) {
                            jt1Var = (jt1) obj;
                        } else {
                            jt1Var = new jt1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", jt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(jt1Var, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.setTabBarItem")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 D = jt1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    ht1 ht1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ht1)) {
                            ht1Var = (ht1) obj;
                        } else {
                            ht1Var = new ht1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ht1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ht1Var, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.showDatePickerView")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 L = ht1Var.L(str);
                        if (L == null) {
                            return "";
                        }
                        return L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    lt1 lt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof lt1)) {
                            lt1Var = (lt1) obj;
                        } else {
                            lt1Var = new lt1(this.mSwanApiContext);
                            this.mApis.put("1172469410", lt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(lt1Var, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.showHalfScreenWebview")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 K = lt1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    dt1 dt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof dt1)) {
                            dt1Var = (dt1) obj;
                        } else {
                            dt1Var = new dt1(this.mSwanApiContext);
                            this.mApis.put("5236036", dt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(dt1Var, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.showLoading")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = dt1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    et1 et1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof et1)) {
                            et1Var = (et1) obj;
                        } else {
                            et1Var = new et1(this.mSwanApiContext);
                            this.mApis.put("1913747800", et1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(et1Var, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.showModal")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = et1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    ft1 ft1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("-246386074", ft1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ft1Var, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.showNavigationBarLoading")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 B = ft1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    kt1 kt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof kt1)) {
                            kt1Var = (kt1) obj;
                        } else {
                            kt1Var = new kt1(this.mSwanApiContext);
                            this.mApis.put("1159492510", kt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(kt1Var, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.showToast")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 Q = kt1Var.Q(str);
                        if (Q == null) {
                            return "";
                        }
                        return Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    it1 it1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof it1)) {
                            it1Var = (it1) obj;
                        } else {
                            it1Var = new it1(this.mSwanApiContext);
                            this.mApis.put("1165118609", it1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(it1Var, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.stopPullDownRefresh")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = it1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    ht1 ht1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ht1)) {
                            ht1Var = (ht1) obj;
                        } else {
                            ht1Var = new ht1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ht1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ht1Var, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.updateMultiPicker")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 M = ht1Var.M(str);
                        if (M == null) {
                            return "";
                        }
                        return M.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    dt1 dt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof dt1)) {
                            dt1Var = (dt1) obj;
                        } else {
                            dt1Var = new dt1(this.mSwanApiContext);
                            this.mApis.put("5236036", dt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(dt1Var, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.hideLoading")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = dt1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    kt1 kt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof kt1)) {
                            kt1Var = (kt1) obj;
                        } else {
                            kt1Var = new kt1(this.mSwanApiContext);
                            this.mApis.put("1159492510", kt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(kt1Var, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Interaction.hideToast")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 K = kt1Var.K();
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    mt1 mt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("-137346255", mt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(mt1Var, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Keyboard.startKeyboardHeightChange")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 C = mt1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    mt1 mt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("-137346255", mt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(mt1Var, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Keyboard.stopKeyboardHeightChange")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 D = mt1Var.D();
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("-397373095", nt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(nt1Var, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "LocationService.getLocation")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = nt1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("-397373095", nt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(nt1Var, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "LocationService.startLocationUpdate")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = nt1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    nt1 nt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("-397373095", nt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(nt1Var, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "LocationService.stopLocationUpdate")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 B = nt1Var.B();
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    ev1 ev1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof ev1)) {
                            ev1Var = (ev1) obj;
                        } else {
                            ev1Var = new ev1(this.mSwanApiContext);
                            this.mApis.put("538070032", ev1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ev1Var, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = ev1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String callService(String str) {
                    qt1 qt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof qt1)) {
                            qt1Var = (qt1) obj;
                        } else {
                            qt1Var = new qt1(this.mSwanApiContext);
                            this.mApis.put("-1076509454", qt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(qt1Var, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Network.callService")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = qt1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    xt1 xt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof xt1)) {
                            xt1Var = (xt1) obj;
                        } else {
                            xt1Var = new xt1(this.mSwanApiContext);
                            this.mApis.put("968563034", xt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(xt1Var, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Network.cancelRequest")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 D = xt1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    wt1 wt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof wt1)) {
                            wt1Var = (wt1) obj;
                        } else {
                            wt1Var = new wt1(this.mSwanApiContext);
                            this.mApis.put("453220699", wt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(wt1Var, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Network.networkStatusChange")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = wt1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    wt1 wt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof wt1)) {
                            wt1Var = (wt1) obj;
                        } else {
                            wt1Var = new wt1(this.mSwanApiContext);
                            this.mApis.put("453220699", wt1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(wt1Var, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Network.getNetworkType")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = wt1Var.x();
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
                    xt1 xt1Var;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        try {
                            hw1.c().a("request");
                            Object obj = this.mApis.get("968563034");
                            if (obj != null && (obj instanceof xt1)) {
                                xt1Var = (xt1) obj;
                            } else {
                                xt1Var = new xt1(this.mSwanApiContext);
                                this.mApis.put("968563034", xt1Var);
                            }
                            Pair<Boolean, iw1> a2 = kw1.a(xt1Var, "swanAPI/request");
                            if (((Boolean) a2.first).booleanValue()) {
                                a = ((iw1) a2.second).a();
                            } else if (q62.a(this.mSwanApiContext.f(), "Network.request")) {
                                a = new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            } else {
                                Pair<iw1, JSONObject> u = ms1.u(str);
                                if (!((iw1) u.first).isSuccess()) {
                                    a = ((iw1) u.first).a();
                                } else {
                                    JSONObject jSONObject = (JSONObject) u.second;
                                    if (jSONObject == null) {
                                        a = iw1.a.a();
                                    } else {
                                        jw1 V = xt1Var.V(jSONObject);
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
            hashMap.put("_naPayment", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    gx2 gx2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof gx2)) {
                            gx2Var = (gx2) obj;
                        } else {
                            gx2Var = new gx2(this.mSwanApiContext);
                            this.mApis.put("-336396851", gx2Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(gx2Var, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Payment.chooseCoupon")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = gx2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    gx2 gx2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof gx2)) {
                            gx2Var = (gx2) obj;
                        } else {
                            gx2Var = new gx2(this.mSwanApiContext);
                            this.mApis.put("-336396851", gx2Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(gx2Var, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Payment.getPaymentInfo")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = gx2Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    ww2 ww2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof ww2)) {
                            ww2Var = (ww2) obj;
                        } else {
                            ww2Var = new ww2(this.mSwanApiContext);
                            this.mApis.put("1854689529", ww2Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ww2Var, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Payment.requestThirdPayment")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = ww2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    gx2 gx2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof gx2)) {
                            gx2Var = (gx2) obj;
                        } else {
                            gx2Var = new gx2(this.mSwanApiContext);
                            this.mApis.put("-336396851", gx2Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(gx2Var, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Payment.setPaymentInfo")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 z = gx2Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    rz2 rz2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof rz2)) {
                            rz2Var = (rz2) obj;
                        } else {
                            rz2Var = new rz2(this.mSwanApiContext);
                            this.mApis.put("-254510461", rz2Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(rz2Var, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Plugin.invokePluginChooseAddress")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = rz2Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    rz2 rz2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof rz2)) {
                            rz2Var = (rz2) obj;
                        } else {
                            rz2Var = new rz2(this.mSwanApiContext);
                            this.mApis.put("-254510461", rz2Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(rz2Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 z = rz2Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    rz2 rz2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof rz2)) {
                            rz2Var = (rz2) obj;
                        } else {
                            rz2Var = new rz2(this.mSwanApiContext);
                            this.mApis.put("-254510461", rz2Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(rz2Var, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Plugin.invokePluginPayment")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = rz2Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    k82 k82Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof k82)) {
                            k82Var = (k82) obj;
                        } else {
                            k82Var = new k82(this.mSwanApiContext);
                            this.mApis.put("-2068479848", k82Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(k82Var, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Prefetch.prefetchResources")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = k82Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    c72 c72Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof c72)) {
                            c72Var = (c72) obj;
                        } else {
                            c72Var = new c72(this.mSwanApiContext);
                            this.mApis.put("423661539", c72Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(c72Var, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Preload.preloadStatus")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = c72Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    mg3 mg3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof mg3)) {
                            mg3Var = (mg3) obj;
                        } else {
                            mg3Var = new mg3(this.mSwanApiContext);
                            this.mApis.put("-1929343869", mg3Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(mg3Var, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "PrivateFile.uploadFileToBos")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 C = mg3Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    bu1 bu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof bu1)) {
                            bu1Var = (bu1) obj;
                        } else {
                            bu1Var = new bu1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", bu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(bu1Var, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Router.hideModalPage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = bu1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    bu1 bu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof bu1)) {
                            bu1Var = (bu1) obj;
                        } else {
                            bu1Var = new bu1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", bu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(bu1Var, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Router.navigateBack")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 B = bu1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    cu1 cu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof cu1)) {
                            cu1Var = (cu1) obj;
                        } else {
                            cu1Var = new cu1(this.mSwanApiContext);
                            this.mApis.put("1968522584", cu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(cu1Var, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Router.navigateTo")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 H = cu1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    eu1 eu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof eu1)) {
                            eu1Var = (eu1) obj;
                        } else {
                            eu1Var = new eu1(this.mSwanApiContext);
                            this.mApis.put("1317280190", eu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(eu1Var, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Router.reLaunch")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = eu1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    fu1 fu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("-420075743", fu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(fu1Var, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Router.reLoadErrorPage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = fu1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    du1 du1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof du1)) {
                            du1Var = (du1) obj;
                        } else {
                            du1Var = new du1(this.mSwanApiContext);
                            this.mApis.put("1792515533", du1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(du1Var, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Router.redirectTo")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 D = du1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    cu1 cu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof cu1)) {
                            cu1Var = (cu1) obj;
                        } else {
                            cu1Var = new cu1(this.mSwanApiContext);
                            this.mApis.put("1968522584", cu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(cu1Var, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Router.showModalPage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 J = cu1Var.J(str);
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    iu1 iu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof iu1)) {
                            iu1Var = (iu1) obj;
                        } else {
                            iu1Var = new iu1(this.mSwanApiContext);
                            this.mApis.put("-594895721", iu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(iu1Var, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Setting.getAppInfoSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 F = iu1Var.F();
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    iu1 iu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof iu1)) {
                            iu1Var = (iu1) obj;
                        } else {
                            iu1Var = new iu1(this.mSwanApiContext);
                            this.mApis.put("-594895721", iu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(iu1Var, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Setting.getSlaveIdSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 H = iu1Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    hu1 hu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("450273045", hu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(hu1Var, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Setting.isAllowedAdOpenAppSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = hu1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    iu1 iu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof iu1)) {
                            iu1Var = (iu1) obj;
                        } else {
                            iu1Var = new iu1(this.mSwanApiContext);
                            this.mApis.put("-594895721", iu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(iu1Var, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Setting.getSetting")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 G = iu1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    iu1 iu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof iu1)) {
                            iu1Var = (iu1) obj;
                        } else {
                            iu1Var = new iu1(this.mSwanApiContext);
                            this.mApis.put("-594895721", iu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(iu1Var, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Setting.getSwanId")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 I = iu1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    iu1 iu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof iu1)) {
                            iu1Var = (iu1) obj;
                        } else {
                            iu1Var = new iu1(this.mSwanApiContext);
                            this.mApis.put("-594895721", iu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(iu1Var, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Setting.getUserInfo")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 J = iu1Var.J(str);
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    gb3 gb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof gb3)) {
                            gb3Var = (gb3) obj;
                        } else {
                            gb3Var = new gb3(this.mSwanApiContext);
                            this.mApis.put("712777136", gb3Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(gb3Var, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = gb3Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    lu1 lu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lu1)) {
                            lu1Var = (lu1) obj;
                        } else {
                            lu1Var = new lu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(lu1Var, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = lu1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    lu1 lu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lu1)) {
                            lu1Var = (lu1) obj;
                        } else {
                            lu1Var = new lu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(lu1Var, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorageSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 C = lu1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    ku1 ku1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ku1)) {
                            ku1Var = (ku1) obj;
                        } else {
                            ku1Var = new ku1(this.mSwanApiContext);
                            this.mApis.put("130910081", ku1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ku1Var, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.clearStorage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = ku1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    ku1 ku1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ku1)) {
                            ku1Var = (ku1) obj;
                        } else {
                            ku1Var = new ku1(this.mSwanApiContext);
                            this.mApis.put("130910081", ku1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ku1Var, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.clearStorageSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 C = ku1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    lu1 lu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lu1)) {
                            lu1Var = (lu1) obj;
                        } else {
                            lu1Var = new lu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(lu1Var, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfo")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 G = lu1Var.G();
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    lu1 lu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lu1)) {
                            lu1Var = (lu1) obj;
                        } else {
                            lu1Var = new lu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(lu1Var, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfoSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 J = lu1Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    ku1 ku1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ku1)) {
                            ku1Var = (ku1) obj;
                        } else {
                            ku1Var = new ku1(this.mSwanApiContext);
                            this.mApis.put("130910081", ku1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ku1Var, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.getStorageInfo")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 G = ku1Var.G();
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    ku1 ku1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ku1)) {
                            ku1Var = (ku1) obj;
                        } else {
                            ku1Var = new ku1(this.mSwanApiContext);
                            this.mApis.put("130910081", ku1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ku1Var, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.getStorageInfoSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 J = ku1Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    lu1 lu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lu1)) {
                            lu1Var = (lu1) obj;
                        } else {
                            lu1Var = new lu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(lu1Var, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.getGlobalStorage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 D = lu1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    lu1 lu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lu1)) {
                            lu1Var = (lu1) obj;
                        } else {
                            lu1Var = new lu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(lu1Var, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 K = lu1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    ku1 ku1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ku1)) {
                            ku1Var = (ku1) obj;
                        } else {
                            ku1Var = new ku1(this.mSwanApiContext);
                            this.mApis.put("130910081", ku1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ku1Var, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.getStorage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 D = ku1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    ku1 ku1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ku1)) {
                            ku1Var = (ku1) obj;
                        } else {
                            ku1Var = new ku1(this.mSwanApiContext);
                            this.mApis.put("130910081", ku1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ku1Var, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.getStorageInfoAsync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 H = ku1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    ku1 ku1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ku1)) {
                            ku1Var = (ku1) obj;
                        } else {
                            ku1Var = new ku1(this.mSwanApiContext);
                            this.mApis.put("130910081", ku1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ku1Var, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.getStorageSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 K = ku1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    lu1 lu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lu1)) {
                            lu1Var = (lu1) obj;
                        } else {
                            lu1Var = new lu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(lu1Var, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 R = lu1Var.R(str);
                        if (R == null) {
                            return "";
                        }
                        return R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    lu1 lu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lu1)) {
                            lu1Var = (lu1) obj;
                        } else {
                            lu1Var = new lu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(lu1Var, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorageSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 T = lu1Var.T(str);
                        if (T == null) {
                            return "";
                        }
                        return T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    ku1 ku1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ku1)) {
                            ku1Var = (ku1) obj;
                        } else {
                            ku1Var = new ku1(this.mSwanApiContext);
                            this.mApis.put("130910081", ku1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ku1Var, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.removeStorage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 R = ku1Var.R(str);
                        if (R == null) {
                            return "";
                        }
                        return R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    ku1 ku1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ku1)) {
                            ku1Var = (ku1) obj;
                        } else {
                            ku1Var = new ku1(this.mSwanApiContext);
                            this.mApis.put("130910081", ku1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ku1Var, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.removeStorageSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 T = ku1Var.T(str);
                        if (T == null) {
                            return "";
                        }
                        return T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    lu1 lu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lu1)) {
                            lu1Var = (lu1) obj;
                        } else {
                            lu1Var = new lu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(lu1Var, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.setGlobalStorage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 U = lu1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    lu1 lu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lu1)) {
                            lu1Var = (lu1) obj;
                        } else {
                            lu1Var = new lu1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(lu1Var, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.setGlobalStorageSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 W = lu1Var.W(str);
                        if (W == null) {
                            return "";
                        }
                        return W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    ku1 ku1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ku1)) {
                            ku1Var = (ku1) obj;
                        } else {
                            ku1Var = new ku1(this.mSwanApiContext);
                            this.mApis.put("130910081", ku1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ku1Var, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.setStorage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 U = ku1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    ku1 ku1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ku1)) {
                            ku1Var = (ku1) obj;
                        } else {
                            ku1Var = new ku1(this.mSwanApiContext);
                            this.mApis.put("130910081", ku1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ku1Var, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Storage.setStorageSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 W = ku1Var.W(str);
                        if (W == null) {
                            return "";
                        }
                        return W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    nu1 nu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof nu1)) {
                            nu1Var = (nu1) obj;
                        } else {
                            nu1Var = new nu1(this.mSwanApiContext);
                            this.mApis.put("823117982", nu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(nu1Var, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Subscription.requestSubscribeFormId")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 E = nu1Var.E(str);
                        if (E == null) {
                            return "";
                        }
                        return E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    ou1 ou1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof ou1)) {
                            ou1Var = (ou1) obj;
                        } else {
                            ou1Var = new ou1(this.mSwanApiContext);
                            this.mApis.put("-947445811", ou1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ou1Var, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Subscription.subscribeService")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 F = ou1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    vu1 vu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof vu1)) {
                            vu1Var = (vu1) obj;
                        } else {
                            vu1Var = new vu1(this.mSwanApiContext);
                            this.mApis.put("1936205521", vu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(vu1Var, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.exitFullScreen")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = vu1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    uu1 uu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof uu1)) {
                            uu1Var = (uu1) obj;
                        } else {
                            uu1Var = new uu1(this.mSwanApiContext);
                            this.mApis.put("1694151270", uu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(uu1Var, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.getDeviceInfo")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = uu1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    wu1 wu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof wu1)) {
                            wu1Var = (wu1) obj;
                        } else {
                            wu1Var = new wu1(this.mSwanApiContext);
                            this.mApis.put("-1321681619", wu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(wu1Var, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.getDeviceProfile")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = wu1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    xu1 xu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof xu1)) {
                            xu1Var = (xu1) obj;
                        } else {
                            xu1Var = new xu1(this.mSwanApiContext);
                            this.mApis.put("-1569246082", xu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(xu1Var, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.makePhoneCall")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = xu1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    zu1 zu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof zu1)) {
                            zu1Var = (zu1) obj;
                        } else {
                            zu1Var = new zu1(this.mSwanApiContext);
                            this.mApis.put("1099851202", zu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(zu1Var, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.openSMSPanel")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = zu1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    yu1 yu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof yu1)) {
                            yu1Var = (yu1) obj;
                        } else {
                            yu1Var = new yu1(this.mSwanApiContext);
                            this.mApis.put("-1707203360", yu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(yu1Var, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.requestFullScreen")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 F = yu1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    su1 su1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof su1)) {
                            su1Var = (su1) obj;
                        } else {
                            su1Var = new su1(this.mSwanApiContext);
                            this.mApis.put("-518757484", su1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(su1Var, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.setClipboardData")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = su1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    cu2 cu2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof cu2)) {
                            cu2Var = (cu2) obj;
                        } else {
                            cu2Var = new cu2(this.mSwanApiContext);
                            this.mApis.put("1161486049", cu2Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(cu2Var, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.setErrorPageType")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = cu2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    cv1 cv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof cv1)) {
                            cv1Var = (cv1) obj;
                        } else {
                            cv1Var = new cv1(this.mSwanApiContext);
                            this.mApis.put("447234992", cv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(cv1Var, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.setMediaVolume")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 z = cv1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    qu1 qu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof qu1)) {
                            qu1Var = (qu1) obj;
                        } else {
                            qu1Var = new qu1(this.mSwanApiContext);
                            this.mApis.put("1372680763", qu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(qu1Var, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.startAccelerometer")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = qu1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    tu1 tu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof tu1)) {
                            tu1Var = (tu1) obj;
                        } else {
                            tu1Var = new tu1(this.mSwanApiContext);
                            this.mApis.put("1689255576", tu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(tu1Var, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.startCompass")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = tu1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    ru1 ru1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof ru1)) {
                            ru1Var = (ru1) obj;
                        } else {
                            ru1Var = new ru1(this.mSwanApiContext);
                            this.mApis.put("99997465", ru1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ru1Var, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.getBrightness")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = ru1Var.y();
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    su1 su1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof su1)) {
                            su1Var = (su1) obj;
                        } else {
                            su1Var = new su1(this.mSwanApiContext);
                            this.mApis.put("-518757484", su1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(su1Var, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.getClipboardData")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = su1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    cv1 cv1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof cv1)) {
                            cv1Var = (cv1) obj;
                        } else {
                            cv1Var = new cv1(this.mSwanApiContext);
                            this.mApis.put("447234992", cv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(cv1Var, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.getMediaVolume")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = cv1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    qu1 qu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof qu1)) {
                            qu1Var = (qu1) obj;
                        } else {
                            qu1Var = new qu1(this.mSwanApiContext);
                            this.mApis.put("1372680763", qu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(qu1Var, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.stopAccelerometer")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 B = qu1Var.B();
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    tu1 tu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof tu1)) {
                            tu1Var = (tu1) obj;
                        } else {
                            tu1Var = new tu1(this.mSwanApiContext);
                            this.mApis.put("1689255576", tu1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(tu1Var, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "System.stopCompass")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 z = tu1Var.z();
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    nv1 nv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof nv1)) {
                            nv1Var = (nv1) obj;
                        } else {
                            nv1Var = new nv1(this.mSwanApiContext);
                            this.mApis.put("201194468", nv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(nv1Var, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.addToDesktop")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 B = nv1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    jv1 jv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof jv1)) {
                            jv1Var = (jv1) obj;
                        } else {
                            jv1Var = new jv1(this.mSwanApiContext);
                            this.mApis.put("-1412306947", jv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(jv1Var, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.calcMD5")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = jv1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    kv1 kv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof kv1)) {
                            kv1Var = (kv1) obj;
                        } else {
                            kv1Var = new kv1(this.mSwanApiContext);
                            this.mApis.put("1626415364", kv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(kv1Var, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.checkAppInstalled")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = kv1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    mv1 mv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof mv1)) {
                            mv1Var = (mv1) obj;
                        } else {
                            mv1Var = new mv1(this.mSwanApiContext);
                            this.mApis.put("-836768778", mv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(mv1Var, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfo")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = mv1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    ov1 ov1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof ov1)) {
                            ov1Var = (ov1) obj;
                        } else {
                            ov1Var = new ov1(this.mSwanApiContext);
                            this.mApis.put("-810858308", ov1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ov1Var, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.getPerformanceLevel")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = ov1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    sv1 sv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof sv1)) {
                            sv1Var = (sv1) obj;
                        } else {
                            sv1Var = new sv1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", sv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(sv1Var, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.getSystemInfoAsync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 I = sv1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    pv1 pv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof pv1)) {
                            pv1Var = (pv1) obj;
                        } else {
                            pv1Var = new pv1(this.mSwanApiContext);
                            this.mApis.put("-2097727681", pv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(pv1Var, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.handleException")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = pv1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    lv1 lv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof lv1)) {
                            lv1Var = (lv1) obj;
                        } else {
                            lv1Var = new lv1(this.mSwanApiContext);
                            this.mApis.put("2084449317", lv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(lv1Var, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.hasCloseHandler")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = lv1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    o83 o83Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof o83)) {
                            o83Var = (o83) obj;
                        } else {
                            o83Var = new o83(this.mSwanApiContext);
                            this.mApis.put("1031678042", o83Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(o83Var, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.hideCaptureScreenShareDialog")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 x = o83Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    qv1 qv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof qv1)) {
                            qv1Var = (qv1) obj;
                        } else {
                            qv1Var = new qv1(this.mSwanApiContext);
                            this.mApis.put("1751900130", qv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(qv1Var, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.logToFile")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = qv1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    p73 p73Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof p73)) {
                            p73Var = (p73) obj;
                        } else {
                            p73Var = new p73(this.mSwanApiContext);
                            this.mApis.put("1748196865", p73Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(p73Var, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.preloadPackage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = p73Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    rv1 rv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof rv1)) {
                            rv1Var = (rv1) obj;
                        } else {
                            rv1Var = new rv1(this.mSwanApiContext);
                            this.mApis.put("589529211", rv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(rv1Var, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.previewImage")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 B = rv1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    uv1 uv1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof uv1)) {
                            uv1Var = (uv1) obj;
                        } else {
                            uv1Var = new uv1(this.mSwanApiContext);
                            this.mApis.put("-577481801", uv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(uv1Var, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.ubcFlowJar")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 I = uv1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    sv1 sv1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof sv1)) {
                            sv1Var = (sv1) obj;
                        } else {
                            sv1Var = new sv1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", sv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(sv1Var, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfoSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 E = sv1Var.E();
                        if (E == null) {
                            return "";
                        }
                        return E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    sv1 sv1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof sv1)) {
                            sv1Var = (sv1) obj;
                        } else {
                            sv1Var = new sv1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", sv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(sv1Var, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.getSystemInfo")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 H = sv1Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    sv1 sv1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof sv1)) {
                            sv1Var = (sv1) obj;
                        } else {
                            sv1Var = new sv1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", sv1Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(sv1Var, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Utils.getSystemInfoSync")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 J = sv1Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    ze3 ze3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ze3)) {
                            ze3Var = (ze3) obj;
                        } else {
                            ze3Var = new ze3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ze3Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ze3Var, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Wifi.connectWifi")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 A = ze3Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    ze3 ze3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ze3)) {
                            ze3Var = (ze3) obj;
                        } else {
                            ze3Var = new ze3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ze3Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ze3Var, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Wifi.getConnectedWifi")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 B = ze3Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    ze3 ze3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ze3)) {
                            ze3Var = (ze3) obj;
                        } else {
                            ze3Var = new ze3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ze3Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ze3Var, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Wifi.getWifiList")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 C = ze3Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    ze3 ze3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ze3)) {
                            ze3Var = (ze3) obj;
                        } else {
                            ze3Var = new ze3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ze3Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ze3Var, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Wifi.startWifi")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 G = ze3Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    ze3 ze3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ze3)) {
                            ze3Var = (ze3) obj;
                        } else {
                            ze3Var = new ze3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ze3Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ze3Var, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "Wifi.stopWifi")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 H = ze3Var.H(str);
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
