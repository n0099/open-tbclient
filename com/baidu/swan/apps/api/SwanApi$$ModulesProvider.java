package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ap1;
import com.repackage.aq1;
import com.repackage.b32;
import com.repackage.bq1;
import com.repackage.bq2;
import com.repackage.br1;
import com.repackage.cp1;
import com.repackage.cq1;
import com.repackage.dp1;
import com.repackage.dq1;
import com.repackage.dr1;
import com.repackage.ep1;
import com.repackage.eq1;
import com.repackage.f73;
import com.repackage.fp1;
import com.repackage.ft2;
import com.repackage.gp1;
import com.repackage.gq1;
import com.repackage.gs1;
import com.repackage.hp1;
import com.repackage.hq1;
import com.repackage.hs1;
import com.repackage.ip1;
import com.repackage.ir1;
import com.repackage.is1;
import com.repackage.j42;
import com.repackage.jo1;
import com.repackage.jp1;
import com.repackage.jq1;
import com.repackage.jr1;
import com.repackage.js1;
import com.repackage.kp1;
import com.repackage.kq1;
import com.repackage.kr1;
import com.repackage.lc3;
import com.repackage.ld2;
import com.repackage.lo1;
import com.repackage.lp1;
import com.repackage.lr1;
import com.repackage.mo1;
import com.repackage.mp1;
import com.repackage.mq1;
import com.repackage.mr1;
import com.repackage.n43;
import com.repackage.nq1;
import com.repackage.nr1;
import com.repackage.o33;
import com.repackage.oo1;
import com.repackage.or1;
import com.repackage.p22;
import com.repackage.po1;
import com.repackage.pp1;
import com.repackage.pq1;
import com.repackage.pr1;
import com.repackage.qo1;
import com.repackage.qq1;
import com.repackage.qr1;
import com.repackage.qv2;
import com.repackage.ro1;
import com.repackage.rq1;
import com.repackage.rr1;
import com.repackage.so1;
import com.repackage.sq1;
import com.repackage.tq1;
import com.repackage.tr1;
import com.repackage.uo1;
import com.repackage.uq1;
import com.repackage.vp1;
import com.repackage.vq1;
import com.repackage.vs2;
import com.repackage.wo1;
import com.repackage.wp1;
import com.repackage.wq1;
import com.repackage.xo1;
import com.repackage.xq1;
import com.repackage.ya3;
import com.repackage.yn1;
import com.repackage.yq1;
import com.repackage.zg1;
import com.repackage.zp2;
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

    public static Map<String, Object> getV8ApiModules(final jo1 jo1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jo1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    po1 po1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof po1)) {
                            po1Var = (po1) obj;
                        } else {
                            po1Var = new po1(this.mSwanApiContext);
                            this.mApis.put("1930258908", po1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(po1Var, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Account.checkSession")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = po1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    qo1 qo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof qo1)) {
                            qo1Var = (qo1) obj;
                        } else {
                            qo1Var = new qo1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", qo1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(qo1Var, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Account.getLoginCode")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 C = qo1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    ro1 ro1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof ro1)) {
                            ro1Var = (ro1) obj;
                        } else {
                            ro1Var = new ro1(this.mSwanApiContext);
                            this.mApis.put("1754780133", ro1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ro1Var, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Account.getOpenId")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = ro1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    yn1 yn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof yn1)) {
                            yn1Var = (yn1) obj;
                        } else {
                            yn1Var = new yn1(this.mSwanApiContext);
                            this.mApis.put("-343998465", yn1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(yn1Var, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Account.getUnionBDUSS")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = yn1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    oo1 oo1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof oo1)) {
                            oo1Var = (oo1) obj;
                        } else {
                            oo1Var = new oo1(this.mSwanApiContext);
                            this.mApis.put("-337742792", oo1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(oo1Var, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Account.isBaiduAccountSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = oo1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    qo1 qo1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof qo1)) {
                            qo1Var = (qo1) obj;
                        } else {
                            qo1Var = new qo1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", qo1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(qo1Var, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Account.isLoginSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 H = qo1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    qo1 qo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof qo1)) {
                            qo1Var = (qo1) obj;
                        } else {
                            qo1Var = new qo1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", qo1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(qo1Var, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Account.login")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 I = qo1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    so1 so1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof so1)) {
                            so1Var = (so1) obj;
                        } else {
                            so1Var = new so1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", so1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(so1Var, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Basic.loadSubPackage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 F = so1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    so1 so1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof so1)) {
                            so1Var = (so1) obj;
                        } else {
                            so1Var = new so1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", so1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(so1Var, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Basic.loadSubPackages")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 G = so1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    zg1 zg1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof zg1)) {
                            zg1Var = (zg1) obj;
                        } else {
                            zg1Var = new zg1(this.mSwanApiContext);
                            this.mApis.put("1460300387", zg1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(zg1Var, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Bookshelf.deleteBookshelf")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 K = zg1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    zg1 zg1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof zg1)) {
                            zg1Var = (zg1) obj;
                        } else {
                            zg1Var = new zg1(this.mSwanApiContext);
                            this.mApis.put("1460300387", zg1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(zg1Var, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Bookshelf.insertBookshelf")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 P = zg1Var.P(str);
                        return P == null ? "" : P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    zg1 zg1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof zg1)) {
                            zg1Var = (zg1) obj;
                        } else {
                            zg1Var = new zg1(this.mSwanApiContext);
                            this.mApis.put("1460300387", zg1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(zg1Var, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Bookshelf.navigateToBookshelf")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 U = zg1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    zg1 zg1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof zg1)) {
                            zg1Var = (zg1) obj;
                        } else {
                            zg1Var = new zg1(this.mSwanApiContext);
                            this.mApis.put("1460300387", zg1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(zg1Var, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Bookshelf.queryBookshelf")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 V = zg1Var.V(str);
                        return V == null ? "" : V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    zg1 zg1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof zg1)) {
                            zg1Var = (zg1) obj;
                        } else {
                            zg1Var = new zg1(this.mSwanApiContext);
                            this.mApis.put("1460300387", zg1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(zg1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Bookshelf.updateBookshelfReadTime")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 X = zg1Var.X(str);
                        return X == null ? "" : X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    mo1 mo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof mo1)) {
                            mo1Var = (mo1) obj;
                        } else {
                            mo1Var = new mo1(this.mSwanApiContext);
                            this.mApis.put("-277316359", mo1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(mo1Var, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Coupon.getPlatformCoupons")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = mo1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    mo1 mo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof mo1)) {
                            mo1Var = (mo1) obj;
                        } else {
                            mo1Var = new mo1(this.mSwanApiContext);
                            this.mApis.put("-277316359", mo1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(mo1Var, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Coupon.getUserCoupons")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 z = mo1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    mo1 mo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof mo1)) {
                            mo1Var = (mo1) obj;
                        } else {
                            mo1Var = new mo1(this.mSwanApiContext);
                            this.mApis.put("-277316359", mo1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(mo1Var, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Coupon.takeCoupons")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 C = mo1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    uo1 uo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof uo1)) {
                            uo1Var = (uo1) obj;
                        } else {
                            uo1Var = new uo1(this.mSwanApiContext);
                            this.mApis.put("-1225406515", uo1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(uo1Var, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Favorite.getFavorStatus")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = uo1Var.x(str);
                        return x == null ? "" : x.a();
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
                        Pair<Boolean, hs1> a = js1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Favorite.showFavoriteGuide")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 G = showFavoriteGuideApi.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    wo1 wo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof wo1)) {
                            wo1Var = (wo1) obj;
                        } else {
                            wo1Var = new wo1(this.mSwanApiContext);
                            this.mApis.put("-2057135077", wo1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(wo1Var, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "File.shareFile")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = wo1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    ld2 ld2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof ld2)) {
                            ld2Var = (ld2) obj;
                        } else {
                            ld2Var = new ld2(this.mSwanApiContext);
                            this.mApis.put("2077414795", ld2Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ld2Var, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "GameCenter.postGameCenterMessage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = ld2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    ld2 ld2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof ld2)) {
                            ld2Var = (ld2) obj;
                        } else {
                            ld2Var = new ld2(this.mSwanApiContext);
                            this.mApis.put("2077414795", ld2Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ld2Var, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "GameCenter.postGameCenterMessageSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = ld2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String download(String str) {
                    xo1 xo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof xo1)) {
                            xo1Var = (xo1) obj;
                        } else {
                            xo1Var = new xo1(this.mSwanApiContext);
                            this.mApis.put("-170124576", xo1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(xo1Var, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "HostDownloadManager.download")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = xo1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    xo1 xo1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof xo1)) {
                            xo1Var = (xo1) obj;
                        } else {
                            xo1Var = new xo1(this.mSwanApiContext);
                            this.mApis.put("-170124576", xo1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(xo1Var, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "HostDownloadManager.openDownloadCenter")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = xo1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    xo1 xo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof xo1)) {
                            xo1Var = (xo1) obj;
                        } else {
                            xo1Var = new xo1(this.mSwanApiContext);
                            this.mApis.put("-170124576", xo1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(xo1Var, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "HostDownloadManager.openFile")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 z = xo1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    xo1 xo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof xo1)) {
                            xo1Var = (xo1) obj;
                        } else {
                            xo1Var = new xo1(this.mSwanApiContext);
                            this.mApis.put("-170124576", xo1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(xo1Var, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "HostDownloadManager.query")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 query = xo1Var.query(str);
                        return query == null ? "" : query.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naImage", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    zp2 zp2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof zp2)) {
                            zp2Var = (zp2) obj;
                        } else {
                            zp2Var = new zp2(this.mSwanApiContext);
                            this.mApis.put("1445003743", zp2Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(zp2Var, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Image.callImageMenu")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = zp2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    ap1 ap1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof ap1)) {
                            ap1Var = (ap1) obj;
                        } else {
                            ap1Var = new ap1(this.mSwanApiContext);
                            this.mApis.put("-1252730367", ap1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ap1Var, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Image.compressImage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = ap1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ip1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ip1Var, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.closeTabBar")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = ip1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ip1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ip1Var, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.closeTabBarRedDot")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = ip1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    cp1 cp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof cp1)) {
                            cp1Var = (cp1) obj;
                        } else {
                            cp1Var = new cp1(this.mSwanApiContext);
                            this.mApis.put("5236036", cp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(cp1Var, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.hideLoading")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = cp1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    ep1 ep1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof ep1)) {
                            ep1Var = (ep1) obj;
                        } else {
                            ep1Var = new ep1(this.mSwanApiContext);
                            this.mApis.put("-246386074", ep1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ep1Var, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.hideNavigationBarLoading")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = ep1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    jp1 jp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("1159492510", jp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(jp1Var, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.hideToast")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 K = jp1Var.K();
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    gp1 gp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", gp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(gp1Var, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.openMultiPicker")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 G = gp1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    gp1 gp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", gp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(gp1Var, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.openPicker")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 H = gp1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ip1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ip1Var, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.openTabBar")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 C = ip1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    fp1 fp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof fp1)) {
                            fp1Var = (fp1) obj;
                        } else {
                            fp1Var = new fp1(this.mSwanApiContext);
                            this.mApis.put("-1750613704", fp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(fp1Var, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.pageScrollTo")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = fp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    ep1 ep1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof ep1)) {
                            ep1Var = (ep1) obj;
                        } else {
                            ep1Var = new ep1(this.mSwanApiContext);
                            this.mApis.put("-246386074", ep1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ep1Var, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.setNavigationBarColor")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 z = ep1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    ep1 ep1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof ep1)) {
                            ep1Var = (ep1) obj;
                        } else {
                            ep1Var = new ep1(this.mSwanApiContext);
                            this.mApis.put("-246386074", ep1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ep1Var, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.setNavigationBarTitle")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = ep1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ip1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ip1Var, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.setTabBarItem")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 D = ip1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    gp1 gp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", gp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(gp1Var, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.showDatePickerView")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 L = gp1Var.L(str);
                        return L == null ? "" : L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    kp1 kp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof kp1)) {
                            kp1Var = (kp1) obj;
                        } else {
                            kp1Var = new kp1(this.mSwanApiContext);
                            this.mApis.put("1172469410", kp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(kp1Var, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.showHalfScreenWebview")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 K = kp1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    cp1 cp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof cp1)) {
                            cp1Var = (cp1) obj;
                        } else {
                            cp1Var = new cp1(this.mSwanApiContext);
                            this.mApis.put("5236036", cp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(cp1Var, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.showLoading")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = cp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    dp1 dp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof dp1)) {
                            dp1Var = (dp1) obj;
                        } else {
                            dp1Var = new dp1(this.mSwanApiContext);
                            this.mApis.put("1913747800", dp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(dp1Var, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.showModal")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = dp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    ep1 ep1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof ep1)) {
                            ep1Var = (ep1) obj;
                        } else {
                            ep1Var = new ep1(this.mSwanApiContext);
                            this.mApis.put("-246386074", ep1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ep1Var, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.showNavigationBarLoading")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 B = ep1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("1159492510", jp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(jp1Var, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.showToast")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 Q = jp1Var.Q(str);
                        return Q == null ? "" : Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    hp1 hp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof hp1)) {
                            hp1Var = (hp1) obj;
                        } else {
                            hp1Var = new hp1(this.mSwanApiContext);
                            this.mApis.put("1165118609", hp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(hp1Var, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.stopPullDownRefresh")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = hp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    gp1 gp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", gp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(gp1Var, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.updateMultiPicker")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 M = gp1Var.M(str);
                        return M == null ? "" : M.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    lp1 lp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof lp1)) {
                            lp1Var = (lp1) obj;
                        } else {
                            lp1Var = new lp1(this.mSwanApiContext);
                            this.mApis.put("-137346255", lp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(lp1Var, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Keyboard.startKeyboardHeightChange")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 C = lp1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    lp1 lp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof lp1)) {
                            lp1Var = (lp1) obj;
                        } else {
                            lp1Var = new lp1(this.mSwanApiContext);
                            this.mApis.put("-137346255", lp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(lp1Var, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Keyboard.stopKeyboardHeightChange")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 D = lp1Var.D();
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    mp1 mp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof mp1)) {
                            mp1Var = (mp1) obj;
                        } else {
                            mp1Var = new mp1(this.mSwanApiContext);
                            this.mApis.put("-397373095", mp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(mp1Var, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "LocationService.getLocation")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = mp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    mp1 mp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof mp1)) {
                            mp1Var = (mp1) obj;
                        } else {
                            mp1Var = new mp1(this.mSwanApiContext);
                            this.mApis.put("-397373095", mp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(mp1Var, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "LocationService.startLocationUpdate")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = mp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    mp1 mp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof mp1)) {
                            mp1Var = (mp1) obj;
                        } else {
                            mp1Var = new mp1(this.mSwanApiContext);
                            this.mApis.put("-397373095", mp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(mp1Var, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "LocationService.stopLocationUpdate")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 B = mp1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    dr1 dr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof dr1)) {
                            dr1Var = (dr1) obj;
                        } else {
                            dr1Var = new dr1(this.mSwanApiContext);
                            this.mApis.put("538070032", dr1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(dr1Var, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = dr1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String callService(String str) {
                    pp1 pp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof pp1)) {
                            pp1Var = (pp1) obj;
                        } else {
                            pp1Var = new pp1(this.mSwanApiContext);
                            this.mApis.put("-1076509454", pp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(pp1Var, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Network.callService")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = pp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    wp1 wp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof wp1)) {
                            wp1Var = (wp1) obj;
                        } else {
                            wp1Var = new wp1(this.mSwanApiContext);
                            this.mApis.put("968563034", wp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(wp1Var, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Network.cancelRequest")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 D = wp1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    vp1 vp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof vp1)) {
                            vp1Var = (vp1) obj;
                        } else {
                            vp1Var = new vp1(this.mSwanApiContext);
                            this.mApis.put("453220699", vp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(vp1Var, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Network.getNetworkType")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = vp1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    vp1 vp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof vp1)) {
                            vp1Var = (vp1) obj;
                        } else {
                            vp1Var = new vp1(this.mSwanApiContext);
                            this.mApis.put("453220699", vp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(vp1Var, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Network.networkStatusChange")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = vp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                @JavascriptInterface
                public String request(JsObject jsObject) {
                    InterceptResult invokeL2;
                    wp1 wp1Var;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && (invokeL2 = interceptable2.invokeL(1048580, this, jsObject)) != null) {
                        return (String) invokeL2.objValue;
                    }
                    try {
                        gs1.c().a("request");
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof wp1)) {
                            wp1Var = (wp1) obj;
                        } else {
                            wp1Var = new wp1(this.mSwanApiContext);
                            this.mApis.put("968563034", wp1Var);
                        }
                        Pair<Boolean, hs1> a2 = js1.a(wp1Var, "swanAPI/request");
                        if (((Boolean) a2.first).booleanValue()) {
                            a = ((hs1) a2.second).a();
                        } else if (p22.a(this.mSwanApiContext.g(), "Network.request")) {
                            a = new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        } else {
                            Pair<hs1, JSONObject> t = lo1.t(jsObject);
                            if (!((hs1) t.first).isSuccess()) {
                                a = ((hs1) t.first).a();
                            } else {
                                JSONObject jSONObject = (JSONObject) t.second;
                                if (jSONObject == null) {
                                    a = hs1.a.a();
                                } else {
                                    is1 V = wp1Var.V(jSONObject);
                                    a = V == null ? "" : V.a();
                                }
                            }
                        }
                        return a;
                    } finally {
                    }
                }
            });
            hashMap.put("_naPayment", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    ft2 ft2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof ft2)) {
                            ft2Var = (ft2) obj;
                        } else {
                            ft2Var = new ft2(this.mSwanApiContext);
                            this.mApis.put("-336396851", ft2Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ft2Var, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Payment.chooseCoupon")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = ft2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    ft2 ft2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof ft2)) {
                            ft2Var = (ft2) obj;
                        } else {
                            ft2Var = new ft2(this.mSwanApiContext);
                            this.mApis.put("-336396851", ft2Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ft2Var, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Payment.getPaymentInfo")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = ft2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    vs2 vs2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof vs2)) {
                            vs2Var = (vs2) obj;
                        } else {
                            vs2Var = new vs2(this.mSwanApiContext);
                            this.mApis.put("1854689529", vs2Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(vs2Var, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Payment.requestThirdPayment")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = vs2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    ft2 ft2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof ft2)) {
                            ft2Var = (ft2) obj;
                        } else {
                            ft2Var = new ft2(this.mSwanApiContext);
                            this.mApis.put("-336396851", ft2Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ft2Var, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Payment.setPaymentInfo")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 z = ft2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    qv2 qv2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof qv2)) {
                            qv2Var = (qv2) obj;
                        } else {
                            qv2Var = new qv2(this.mSwanApiContext);
                            this.mApis.put("-254510461", qv2Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(qv2Var, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Plugin.invokePluginChooseAddress")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = qv2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    qv2 qv2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof qv2)) {
                            qv2Var = (qv2) obj;
                        } else {
                            qv2Var = new qv2(this.mSwanApiContext);
                            this.mApis.put("-254510461", qv2Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(qv2Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 z = qv2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    qv2 qv2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof qv2)) {
                            qv2Var = (qv2) obj;
                        } else {
                            qv2Var = new qv2(this.mSwanApiContext);
                            this.mApis.put("-254510461", qv2Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(qv2Var, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Plugin.invokePluginPayment")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = qv2Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    j42 j42Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof j42)) {
                            j42Var = (j42) obj;
                        } else {
                            j42Var = new j42(this.mSwanApiContext);
                            this.mApis.put("-2068479848", j42Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(j42Var, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Prefetch.prefetchResources")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = j42Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    b32 b32Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof b32)) {
                            b32Var = (b32) obj;
                        } else {
                            b32Var = new b32(this.mSwanApiContext);
                            this.mApis.put("423661539", b32Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(b32Var, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Preload.preloadStatus")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = b32Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    lc3 lc3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof lc3)) {
                            lc3Var = (lc3) obj;
                        } else {
                            lc3Var = new lc3(this.mSwanApiContext);
                            this.mApis.put("-1929343869", lc3Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(lc3Var, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "PrivateFile.uploadFileToBos")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 C = lc3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    aq1 aq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof aq1)) {
                            aq1Var = (aq1) obj;
                        } else {
                            aq1Var = new aq1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", aq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(aq1Var, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Router.hideModalPage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = aq1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    aq1 aq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof aq1)) {
                            aq1Var = (aq1) obj;
                        } else {
                            aq1Var = new aq1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", aq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(aq1Var, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Router.navigateBack")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 B = aq1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    bq1 bq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof bq1)) {
                            bq1Var = (bq1) obj;
                        } else {
                            bq1Var = new bq1(this.mSwanApiContext);
                            this.mApis.put("1968522584", bq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(bq1Var, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Router.navigateTo")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 H = bq1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    dq1 dq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof dq1)) {
                            dq1Var = (dq1) obj;
                        } else {
                            dq1Var = new dq1(this.mSwanApiContext);
                            this.mApis.put("1317280190", dq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(dq1Var, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Router.reLaunch")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = dq1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    eq1 eq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof eq1)) {
                            eq1Var = (eq1) obj;
                        } else {
                            eq1Var = new eq1(this.mSwanApiContext);
                            this.mApis.put("-420075743", eq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(eq1Var, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Router.reLoadErrorPage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = eq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    cq1 cq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof cq1)) {
                            cq1Var = (cq1) obj;
                        } else {
                            cq1Var = new cq1(this.mSwanApiContext);
                            this.mApis.put("1792515533", cq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(cq1Var, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Router.redirectTo")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 D = cq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    bq1 bq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof bq1)) {
                            bq1Var = (bq1) obj;
                        } else {
                            bq1Var = new bq1(this.mSwanApiContext);
                            this.mApis.put("1968522584", bq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(bq1Var, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Router.showModalPage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 J = bq1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    hq1 hq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof hq1)) {
                            hq1Var = (hq1) obj;
                        } else {
                            hq1Var = new hq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", hq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(hq1Var, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Setting.getAppInfoSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 F = hq1Var.F();
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    hq1 hq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof hq1)) {
                            hq1Var = (hq1) obj;
                        } else {
                            hq1Var = new hq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", hq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(hq1Var, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Setting.getSetting")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 G = hq1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    hq1 hq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof hq1)) {
                            hq1Var = (hq1) obj;
                        } else {
                            hq1Var = new hq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", hq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(hq1Var, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Setting.getSlaveIdSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 H = hq1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    hq1 hq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof hq1)) {
                            hq1Var = (hq1) obj;
                        } else {
                            hq1Var = new hq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", hq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(hq1Var, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Setting.getSwanId")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 I = hq1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    hq1 hq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof hq1)) {
                            hq1Var = (hq1) obj;
                        } else {
                            hq1Var = new hq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", hq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(hq1Var, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Setting.getUserInfo")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 J = hq1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    gq1 gq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof gq1)) {
                            gq1Var = (gq1) obj;
                        } else {
                            gq1Var = new gq1(this.mSwanApiContext);
                            this.mApis.put("450273045", gq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(gq1Var, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Setting.isAllowedAdOpenAppSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = gq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    f73 f73Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof f73)) {
                            f73Var = (f73) obj;
                        } else {
                            f73Var = new f73(this.mSwanApiContext);
                            this.mApis.put("712777136", f73Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(f73Var, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = f73Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    kq1 kq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", kq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(kq1Var, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.clearGlobalStorage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = kq1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    kq1 kq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", kq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(kq1Var, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.clearGlobalStorageSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 C = kq1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    jq1 jq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof jq1)) {
                            jq1Var = (jq1) obj;
                        } else {
                            jq1Var = new jq1(this.mSwanApiContext);
                            this.mApis.put("130910081", jq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(jq1Var, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.clearStorage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = jq1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    jq1 jq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof jq1)) {
                            jq1Var = (jq1) obj;
                        } else {
                            jq1Var = new jq1(this.mSwanApiContext);
                            this.mApis.put("130910081", jq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(jq1Var, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.clearStorageSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 C = jq1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    kq1 kq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", kq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(kq1Var, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.getGlobalStorage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 D = kq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    kq1 kq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", kq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(kq1Var, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.getGlobalStorageInfo")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 G = kq1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    kq1 kq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", kq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(kq1Var, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.getGlobalStorageInfoSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 J = kq1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    kq1 kq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", kq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(kq1Var, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.getGlobalStorageSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 K = kq1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    jq1 jq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof jq1)) {
                            jq1Var = (jq1) obj;
                        } else {
                            jq1Var = new jq1(this.mSwanApiContext);
                            this.mApis.put("130910081", jq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(jq1Var, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.getStorage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 D = jq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    jq1 jq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof jq1)) {
                            jq1Var = (jq1) obj;
                        } else {
                            jq1Var = new jq1(this.mSwanApiContext);
                            this.mApis.put("130910081", jq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(jq1Var, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.getStorageInfo")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 G = jq1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    jq1 jq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof jq1)) {
                            jq1Var = (jq1) obj;
                        } else {
                            jq1Var = new jq1(this.mSwanApiContext);
                            this.mApis.put("130910081", jq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(jq1Var, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.getStorageInfoAsync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 H = jq1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    jq1 jq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof jq1)) {
                            jq1Var = (jq1) obj;
                        } else {
                            jq1Var = new jq1(this.mSwanApiContext);
                            this.mApis.put("130910081", jq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(jq1Var, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.getStorageInfoSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 J = jq1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    jq1 jq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof jq1)) {
                            jq1Var = (jq1) obj;
                        } else {
                            jq1Var = new jq1(this.mSwanApiContext);
                            this.mApis.put("130910081", jq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(jq1Var, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.getStorageSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 K = jq1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    kq1 kq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", kq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(kq1Var, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.removeGlobalStorage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 R = kq1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    kq1 kq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", kq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(kq1Var, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.removeGlobalStorageSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 T = kq1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    jq1 jq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof jq1)) {
                            jq1Var = (jq1) obj;
                        } else {
                            jq1Var = new jq1(this.mSwanApiContext);
                            this.mApis.put("130910081", jq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(jq1Var, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.removeStorage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 R = jq1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    jq1 jq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof jq1)) {
                            jq1Var = (jq1) obj;
                        } else {
                            jq1Var = new jq1(this.mSwanApiContext);
                            this.mApis.put("130910081", jq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(jq1Var, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.removeStorageSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 T = jq1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    kq1 kq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", kq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(kq1Var, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.setGlobalStorage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 U = kq1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    kq1 kq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", kq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(kq1Var, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.setGlobalStorageSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 W = kq1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    jq1 jq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof jq1)) {
                            jq1Var = (jq1) obj;
                        } else {
                            jq1Var = new jq1(this.mSwanApiContext);
                            this.mApis.put("130910081", jq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(jq1Var, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.setStorage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 U = jq1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    jq1 jq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof jq1)) {
                            jq1Var = (jq1) obj;
                        } else {
                            jq1Var = new jq1(this.mSwanApiContext);
                            this.mApis.put("130910081", jq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(jq1Var, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.setStorageSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 W = jq1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    mq1 mq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof mq1)) {
                            mq1Var = (mq1) obj;
                        } else {
                            mq1Var = new mq1(this.mSwanApiContext);
                            this.mApis.put("823117982", mq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(mq1Var, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Subscription.requestSubscribeFormId")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 E = mq1Var.E(str);
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    nq1 nq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof nq1)) {
                            nq1Var = (nq1) obj;
                        } else {
                            nq1Var = new nq1(this.mSwanApiContext);
                            this.mApis.put("-947445811", nq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(nq1Var, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Subscription.subscribeService")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 F = nq1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    uq1 uq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof uq1)) {
                            uq1Var = (uq1) obj;
                        } else {
                            uq1Var = new uq1(this.mSwanApiContext);
                            this.mApis.put("1936205521", uq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(uq1Var, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.exitFullScreen")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = uq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    qq1 qq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof qq1)) {
                            qq1Var = (qq1) obj;
                        } else {
                            qq1Var = new qq1(this.mSwanApiContext);
                            this.mApis.put("99997465", qq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(qq1Var, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.getBrightness")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = qq1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    rq1 rq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof rq1)) {
                            rq1Var = (rq1) obj;
                        } else {
                            rq1Var = new rq1(this.mSwanApiContext);
                            this.mApis.put("-518757484", rq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(rq1Var, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.getClipboardData")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = rq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    tq1 tq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof tq1)) {
                            tq1Var = (tq1) obj;
                        } else {
                            tq1Var = new tq1(this.mSwanApiContext);
                            this.mApis.put("1694151270", tq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(tq1Var, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.getDeviceInfo")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = tq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    vq1 vq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("-1321681619", vq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(vq1Var, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.getDeviceProfile")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = vq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    br1 br1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("447234992", br1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(br1Var, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.getMediaVolume")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = br1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    wq1 wq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof wq1)) {
                            wq1Var = (wq1) obj;
                        } else {
                            wq1Var = new wq1(this.mSwanApiContext);
                            this.mApis.put("-1569246082", wq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(wq1Var, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.makePhoneCall")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = wq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    yq1 yq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof yq1)) {
                            yq1Var = (yq1) obj;
                        } else {
                            yq1Var = new yq1(this.mSwanApiContext);
                            this.mApis.put("1099851202", yq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(yq1Var, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.openSMSPanel")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = yq1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    xq1 xq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof xq1)) {
                            xq1Var = (xq1) obj;
                        } else {
                            xq1Var = new xq1(this.mSwanApiContext);
                            this.mApis.put("-1707203360", xq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(xq1Var, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.requestFullScreen")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 F = xq1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    rq1 rq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof rq1)) {
                            rq1Var = (rq1) obj;
                        } else {
                            rq1Var = new rq1(this.mSwanApiContext);
                            this.mApis.put("-518757484", rq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(rq1Var, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.setClipboardData")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = rq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    bq2 bq2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof bq2)) {
                            bq2Var = (bq2) obj;
                        } else {
                            bq2Var = new bq2(this.mSwanApiContext);
                            this.mApis.put("1161486049", bq2Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(bq2Var, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.setErrorPageType")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = bq2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("447234992", br1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(br1Var, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.setMediaVolume")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 z = br1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    pq1 pq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof pq1)) {
                            pq1Var = (pq1) obj;
                        } else {
                            pq1Var = new pq1(this.mSwanApiContext);
                            this.mApis.put("1372680763", pq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(pq1Var, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.startAccelerometer")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = pq1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    sq1 sq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof sq1)) {
                            sq1Var = (sq1) obj;
                        } else {
                            sq1Var = new sq1(this.mSwanApiContext);
                            this.mApis.put("1689255576", sq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(sq1Var, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.startCompass")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = sq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    pq1 pq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof pq1)) {
                            pq1Var = (pq1) obj;
                        } else {
                            pq1Var = new pq1(this.mSwanApiContext);
                            this.mApis.put("1372680763", pq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(pq1Var, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.stopAccelerometer")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 B = pq1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    sq1 sq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof sq1)) {
                            sq1Var = (sq1) obj;
                        } else {
                            sq1Var = new sq1(this.mSwanApiContext);
                            this.mApis.put("1689255576", sq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(sq1Var, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.stopCompass")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 z = sq1Var.z();
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    mr1 mr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof mr1)) {
                            mr1Var = (mr1) obj;
                        } else {
                            mr1Var = new mr1(this.mSwanApiContext);
                            this.mApis.put("201194468", mr1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(mr1Var, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.addToDesktop")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 B = mr1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    ir1 ir1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof ir1)) {
                            ir1Var = (ir1) obj;
                        } else {
                            ir1Var = new ir1(this.mSwanApiContext);
                            this.mApis.put("-1412306947", ir1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ir1Var, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.calcMD5")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = ir1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    jr1 jr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof jr1)) {
                            jr1Var = (jr1) obj;
                        } else {
                            jr1Var = new jr1(this.mSwanApiContext);
                            this.mApis.put("1626415364", jr1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(jr1Var, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.checkAppInstalled")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = jr1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    lr1 lr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof lr1)) {
                            lr1Var = (lr1) obj;
                        } else {
                            lr1Var = new lr1(this.mSwanApiContext);
                            this.mApis.put("-836768778", lr1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(lr1Var, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.getCommonSysInfo")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = lr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    rr1 rr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof rr1)) {
                            rr1Var = (rr1) obj;
                        } else {
                            rr1Var = new rr1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", rr1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(rr1Var, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.getCommonSysInfoSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 E = rr1Var.E();
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    nr1 nr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof nr1)) {
                            nr1Var = (nr1) obj;
                        } else {
                            nr1Var = new nr1(this.mSwanApiContext);
                            this.mApis.put("-810858308", nr1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(nr1Var, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.getPerformanceLevel")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = nr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    rr1 rr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof rr1)) {
                            rr1Var = (rr1) obj;
                        } else {
                            rr1Var = new rr1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", rr1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(rr1Var, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.getSystemInfo")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 H = rr1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    rr1 rr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof rr1)) {
                            rr1Var = (rr1) obj;
                        } else {
                            rr1Var = new rr1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", rr1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(rr1Var, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.getSystemInfoAsync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 I = rr1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    rr1 rr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof rr1)) {
                            rr1Var = (rr1) obj;
                        } else {
                            rr1Var = new rr1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", rr1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(rr1Var, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.getSystemInfoSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 J = rr1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    or1 or1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof or1)) {
                            or1Var = (or1) obj;
                        } else {
                            or1Var = new or1(this.mSwanApiContext);
                            this.mApis.put("-2097727681", or1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(or1Var, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.handleException")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = or1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    kr1 kr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof kr1)) {
                            kr1Var = (kr1) obj;
                        } else {
                            kr1Var = new kr1(this.mSwanApiContext);
                            this.mApis.put("2084449317", kr1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(kr1Var, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.hasCloseHandler")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = kr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    n43 n43Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof n43)) {
                            n43Var = (n43) obj;
                        } else {
                            n43Var = new n43(this.mSwanApiContext);
                            this.mApis.put("1031678042", n43Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(n43Var, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.hideCaptureScreenShareDialog")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = n43Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    pr1 pr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof pr1)) {
                            pr1Var = (pr1) obj;
                        } else {
                            pr1Var = new pr1(this.mSwanApiContext);
                            this.mApis.put("1751900130", pr1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(pr1Var, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.logToFile")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = pr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    o33 o33Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof o33)) {
                            o33Var = (o33) obj;
                        } else {
                            o33Var = new o33(this.mSwanApiContext);
                            this.mApis.put("1748196865", o33Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(o33Var, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.preloadPackage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = o33Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    qr1 qr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof qr1)) {
                            qr1Var = (qr1) obj;
                        } else {
                            qr1Var = new qr1(this.mSwanApiContext);
                            this.mApis.put("589529211", qr1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(qr1Var, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.previewImage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 B = qr1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    tr1 tr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof tr1)) {
                            tr1Var = (tr1) obj;
                        } else {
                            tr1Var = new tr1(this.mSwanApiContext);
                            this.mApis.put("-577481801", tr1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(tr1Var, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.ubcFlowJar")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 I = tr1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    ya3 ya3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ya3)) {
                            ya3Var = (ya3) obj;
                        } else {
                            ya3Var = new ya3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ya3Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ya3Var, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Wifi.connectWifi")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = ya3Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    ya3 ya3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ya3)) {
                            ya3Var = (ya3) obj;
                        } else {
                            ya3Var = new ya3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ya3Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ya3Var, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Wifi.getConnectedWifi")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 B = ya3Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    ya3 ya3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ya3)) {
                            ya3Var = (ya3) obj;
                        } else {
                            ya3Var = new ya3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ya3Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ya3Var, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Wifi.getWifiList")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 C = ya3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    ya3 ya3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ya3)) {
                            ya3Var = (ya3) obj;
                        } else {
                            ya3Var = new ya3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ya3Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ya3Var, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Wifi.startWifi")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 G = ya3Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    ya3 ya3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ya3)) {
                            ya3Var = (ya3) obj;
                        } else {
                            ya3Var = new ya3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ya3Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ya3Var, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Wifi.stopWifi")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 H = ya3Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static Map<String, Object> getWebviewApiModules(final jo1 jo1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jo1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    po1 po1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof po1)) {
                            po1Var = (po1) obj;
                        } else {
                            po1Var = new po1(this.mSwanApiContext);
                            this.mApis.put("1930258908", po1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(po1Var, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Account.checkSession")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = po1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    qo1 qo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof qo1)) {
                            qo1Var = (qo1) obj;
                        } else {
                            qo1Var = new qo1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", qo1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(qo1Var, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Account.getLoginCode")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 C = qo1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    ro1 ro1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof ro1)) {
                            ro1Var = (ro1) obj;
                        } else {
                            ro1Var = new ro1(this.mSwanApiContext);
                            this.mApis.put("1754780133", ro1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ro1Var, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Account.getOpenId")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = ro1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    yn1 yn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof yn1)) {
                            yn1Var = (yn1) obj;
                        } else {
                            yn1Var = new yn1(this.mSwanApiContext);
                            this.mApis.put("-343998465", yn1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(yn1Var, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Account.getUnionBDUSS")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = yn1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    oo1 oo1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof oo1)) {
                            oo1Var = (oo1) obj;
                        } else {
                            oo1Var = new oo1(this.mSwanApiContext);
                            this.mApis.put("-337742792", oo1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(oo1Var, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Account.isBaiduAccountSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = oo1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    qo1 qo1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof qo1)) {
                            qo1Var = (qo1) obj;
                        } else {
                            qo1Var = new qo1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", qo1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(qo1Var, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Account.isLoginSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 H = qo1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    qo1 qo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof qo1)) {
                            qo1Var = (qo1) obj;
                        } else {
                            qo1Var = new qo1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", qo1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(qo1Var, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Account.login")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 I = qo1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    so1 so1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof so1)) {
                            so1Var = (so1) obj;
                        } else {
                            so1Var = new so1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", so1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(so1Var, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Basic.loadSubPackage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 F = so1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    so1 so1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof so1)) {
                            so1Var = (so1) obj;
                        } else {
                            so1Var = new so1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", so1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(so1Var, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Basic.loadSubPackages")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 G = so1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    zg1 zg1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof zg1)) {
                            zg1Var = (zg1) obj;
                        } else {
                            zg1Var = new zg1(this.mSwanApiContext);
                            this.mApis.put("1460300387", zg1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(zg1Var, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Bookshelf.deleteBookshelf")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 K = zg1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    zg1 zg1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof zg1)) {
                            zg1Var = (zg1) obj;
                        } else {
                            zg1Var = new zg1(this.mSwanApiContext);
                            this.mApis.put("1460300387", zg1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(zg1Var, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Bookshelf.insertBookshelf")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 P = zg1Var.P(str);
                        return P == null ? "" : P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    zg1 zg1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof zg1)) {
                            zg1Var = (zg1) obj;
                        } else {
                            zg1Var = new zg1(this.mSwanApiContext);
                            this.mApis.put("1460300387", zg1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(zg1Var, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Bookshelf.navigateToBookshelf")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 U = zg1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    zg1 zg1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof zg1)) {
                            zg1Var = (zg1) obj;
                        } else {
                            zg1Var = new zg1(this.mSwanApiContext);
                            this.mApis.put("1460300387", zg1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(zg1Var, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Bookshelf.queryBookshelf")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 V = zg1Var.V(str);
                        return V == null ? "" : V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    zg1 zg1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof zg1)) {
                            zg1Var = (zg1) obj;
                        } else {
                            zg1Var = new zg1(this.mSwanApiContext);
                            this.mApis.put("1460300387", zg1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(zg1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Bookshelf.updateBookshelfReadTime")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 X = zg1Var.X(str);
                        return X == null ? "" : X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    mo1 mo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof mo1)) {
                            mo1Var = (mo1) obj;
                        } else {
                            mo1Var = new mo1(this.mSwanApiContext);
                            this.mApis.put("-277316359", mo1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(mo1Var, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Coupon.getPlatformCoupons")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = mo1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    mo1 mo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof mo1)) {
                            mo1Var = (mo1) obj;
                        } else {
                            mo1Var = new mo1(this.mSwanApiContext);
                            this.mApis.put("-277316359", mo1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(mo1Var, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Coupon.getUserCoupons")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 z = mo1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    mo1 mo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof mo1)) {
                            mo1Var = (mo1) obj;
                        } else {
                            mo1Var = new mo1(this.mSwanApiContext);
                            this.mApis.put("-277316359", mo1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(mo1Var, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Coupon.takeCoupons")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 C = mo1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    uo1 uo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof uo1)) {
                            uo1Var = (uo1) obj;
                        } else {
                            uo1Var = new uo1(this.mSwanApiContext);
                            this.mApis.put("-1225406515", uo1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(uo1Var, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Favorite.getFavorStatus")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = uo1Var.x(str);
                        return x == null ? "" : x.a();
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
                        Pair<Boolean, hs1> a = js1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Favorite.showFavoriteGuide")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 G = showFavoriteGuideApi.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    wo1 wo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof wo1)) {
                            wo1Var = (wo1) obj;
                        } else {
                            wo1Var = new wo1(this.mSwanApiContext);
                            this.mApis.put("-2057135077", wo1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(wo1Var, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "File.shareFile")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = wo1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    ld2 ld2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof ld2)) {
                            ld2Var = (ld2) obj;
                        } else {
                            ld2Var = new ld2(this.mSwanApiContext);
                            this.mApis.put("2077414795", ld2Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ld2Var, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "GameCenter.postGameCenterMessage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = ld2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    ld2 ld2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof ld2)) {
                            ld2Var = (ld2) obj;
                        } else {
                            ld2Var = new ld2(this.mSwanApiContext);
                            this.mApis.put("2077414795", ld2Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ld2Var, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "GameCenter.postGameCenterMessageSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = ld2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String download(String str) {
                    xo1 xo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof xo1)) {
                            xo1Var = (xo1) obj;
                        } else {
                            xo1Var = new xo1(this.mSwanApiContext);
                            this.mApis.put("-170124576", xo1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(xo1Var, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "HostDownloadManager.download")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = xo1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    xo1 xo1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof xo1)) {
                            xo1Var = (xo1) obj;
                        } else {
                            xo1Var = new xo1(this.mSwanApiContext);
                            this.mApis.put("-170124576", xo1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(xo1Var, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "HostDownloadManager.openDownloadCenter")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = xo1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    xo1 xo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof xo1)) {
                            xo1Var = (xo1) obj;
                        } else {
                            xo1Var = new xo1(this.mSwanApiContext);
                            this.mApis.put("-170124576", xo1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(xo1Var, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "HostDownloadManager.openFile")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 z = xo1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    xo1 xo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof xo1)) {
                            xo1Var = (xo1) obj;
                        } else {
                            xo1Var = new xo1(this.mSwanApiContext);
                            this.mApis.put("-170124576", xo1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(xo1Var, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "HostDownloadManager.query")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 query = xo1Var.query(str);
                        return query == null ? "" : query.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naImage", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    zp2 zp2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof zp2)) {
                            zp2Var = (zp2) obj;
                        } else {
                            zp2Var = new zp2(this.mSwanApiContext);
                            this.mApis.put("1445003743", zp2Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(zp2Var, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Image.callImageMenu")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = zp2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    ap1 ap1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof ap1)) {
                            ap1Var = (ap1) obj;
                        } else {
                            ap1Var = new ap1(this.mSwanApiContext);
                            this.mApis.put("-1252730367", ap1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ap1Var, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Image.compressImage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = ap1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ip1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ip1Var, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.closeTabBar")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = ip1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ip1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ip1Var, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.closeTabBarRedDot")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = ip1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    cp1 cp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof cp1)) {
                            cp1Var = (cp1) obj;
                        } else {
                            cp1Var = new cp1(this.mSwanApiContext);
                            this.mApis.put("5236036", cp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(cp1Var, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.hideLoading")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = cp1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    ep1 ep1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof ep1)) {
                            ep1Var = (ep1) obj;
                        } else {
                            ep1Var = new ep1(this.mSwanApiContext);
                            this.mApis.put("-246386074", ep1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ep1Var, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.hideNavigationBarLoading")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = ep1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    jp1 jp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("1159492510", jp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(jp1Var, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.hideToast")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 K = jp1Var.K();
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    gp1 gp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", gp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(gp1Var, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.openMultiPicker")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 G = gp1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    gp1 gp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", gp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(gp1Var, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.openPicker")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 H = gp1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ip1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ip1Var, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.openTabBar")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 C = ip1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    fp1 fp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof fp1)) {
                            fp1Var = (fp1) obj;
                        } else {
                            fp1Var = new fp1(this.mSwanApiContext);
                            this.mApis.put("-1750613704", fp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(fp1Var, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.pageScrollTo")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = fp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    ep1 ep1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof ep1)) {
                            ep1Var = (ep1) obj;
                        } else {
                            ep1Var = new ep1(this.mSwanApiContext);
                            this.mApis.put("-246386074", ep1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ep1Var, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.setNavigationBarColor")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 z = ep1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    ep1 ep1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof ep1)) {
                            ep1Var = (ep1) obj;
                        } else {
                            ep1Var = new ep1(this.mSwanApiContext);
                            this.mApis.put("-246386074", ep1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ep1Var, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.setNavigationBarTitle")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = ep1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ip1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ip1Var, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.setTabBarItem")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 D = ip1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    gp1 gp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", gp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(gp1Var, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.showDatePickerView")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 L = gp1Var.L(str);
                        return L == null ? "" : L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    kp1 kp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof kp1)) {
                            kp1Var = (kp1) obj;
                        } else {
                            kp1Var = new kp1(this.mSwanApiContext);
                            this.mApis.put("1172469410", kp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(kp1Var, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.showHalfScreenWebview")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 K = kp1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    cp1 cp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof cp1)) {
                            cp1Var = (cp1) obj;
                        } else {
                            cp1Var = new cp1(this.mSwanApiContext);
                            this.mApis.put("5236036", cp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(cp1Var, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.showLoading")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = cp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    dp1 dp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof dp1)) {
                            dp1Var = (dp1) obj;
                        } else {
                            dp1Var = new dp1(this.mSwanApiContext);
                            this.mApis.put("1913747800", dp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(dp1Var, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.showModal")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = dp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    ep1 ep1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof ep1)) {
                            ep1Var = (ep1) obj;
                        } else {
                            ep1Var = new ep1(this.mSwanApiContext);
                            this.mApis.put("-246386074", ep1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ep1Var, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.showNavigationBarLoading")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 B = ep1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("1159492510", jp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(jp1Var, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.showToast")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 Q = jp1Var.Q(str);
                        return Q == null ? "" : Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    hp1 hp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof hp1)) {
                            hp1Var = (hp1) obj;
                        } else {
                            hp1Var = new hp1(this.mSwanApiContext);
                            this.mApis.put("1165118609", hp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(hp1Var, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.stopPullDownRefresh")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = hp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    gp1 gp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", gp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(gp1Var, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Interaction.updateMultiPicker")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 M = gp1Var.M(str);
                        return M == null ? "" : M.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    lp1 lp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof lp1)) {
                            lp1Var = (lp1) obj;
                        } else {
                            lp1Var = new lp1(this.mSwanApiContext);
                            this.mApis.put("-137346255", lp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(lp1Var, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Keyboard.startKeyboardHeightChange")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 C = lp1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    lp1 lp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof lp1)) {
                            lp1Var = (lp1) obj;
                        } else {
                            lp1Var = new lp1(this.mSwanApiContext);
                            this.mApis.put("-137346255", lp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(lp1Var, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Keyboard.stopKeyboardHeightChange")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 D = lp1Var.D();
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    mp1 mp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof mp1)) {
                            mp1Var = (mp1) obj;
                        } else {
                            mp1Var = new mp1(this.mSwanApiContext);
                            this.mApis.put("-397373095", mp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(mp1Var, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "LocationService.getLocation")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = mp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    mp1 mp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof mp1)) {
                            mp1Var = (mp1) obj;
                        } else {
                            mp1Var = new mp1(this.mSwanApiContext);
                            this.mApis.put("-397373095", mp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(mp1Var, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "LocationService.startLocationUpdate")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = mp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    mp1 mp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof mp1)) {
                            mp1Var = (mp1) obj;
                        } else {
                            mp1Var = new mp1(this.mSwanApiContext);
                            this.mApis.put("-397373095", mp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(mp1Var, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "LocationService.stopLocationUpdate")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 B = mp1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    dr1 dr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof dr1)) {
                            dr1Var = (dr1) obj;
                        } else {
                            dr1Var = new dr1(this.mSwanApiContext);
                            this.mApis.put("538070032", dr1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(dr1Var, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = dr1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String callService(String str) {
                    pp1 pp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof pp1)) {
                            pp1Var = (pp1) obj;
                        } else {
                            pp1Var = new pp1(this.mSwanApiContext);
                            this.mApis.put("-1076509454", pp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(pp1Var, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Network.callService")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = pp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    wp1 wp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof wp1)) {
                            wp1Var = (wp1) obj;
                        } else {
                            wp1Var = new wp1(this.mSwanApiContext);
                            this.mApis.put("968563034", wp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(wp1Var, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Network.cancelRequest")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 D = wp1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    vp1 vp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof vp1)) {
                            vp1Var = (vp1) obj;
                        } else {
                            vp1Var = new vp1(this.mSwanApiContext);
                            this.mApis.put("453220699", vp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(vp1Var, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Network.getNetworkType")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = vp1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    vp1 vp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof vp1)) {
                            vp1Var = (vp1) obj;
                        } else {
                            vp1Var = new vp1(this.mSwanApiContext);
                            this.mApis.put("453220699", vp1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(vp1Var, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Network.networkStatusChange")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = vp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                @JavascriptInterface
                public String request(String str) {
                    InterceptResult invokeL2;
                    wp1 wp1Var;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && (invokeL2 = interceptable2.invokeL(1048580, this, str)) != null) {
                        return (String) invokeL2.objValue;
                    }
                    try {
                        gs1.c().a("request");
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof wp1)) {
                            wp1Var = (wp1) obj;
                        } else {
                            wp1Var = new wp1(this.mSwanApiContext);
                            this.mApis.put("968563034", wp1Var);
                        }
                        Pair<Boolean, hs1> a2 = js1.a(wp1Var, "swanAPI/request");
                        if (((Boolean) a2.first).booleanValue()) {
                            a = ((hs1) a2.second).a();
                        } else if (p22.a(this.mSwanApiContext.g(), "Network.request")) {
                            a = new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        } else {
                            Pair<hs1, JSONObject> u = lo1.u(str);
                            if (!((hs1) u.first).isSuccess()) {
                                a = ((hs1) u.first).a();
                            } else {
                                JSONObject jSONObject = (JSONObject) u.second;
                                if (jSONObject == null) {
                                    a = hs1.a.a();
                                } else {
                                    is1 V = wp1Var.V(jSONObject);
                                    a = V == null ? "" : V.a();
                                }
                            }
                        }
                        return a;
                    } finally {
                    }
                }
            });
            hashMap.put("_naPayment", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    ft2 ft2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof ft2)) {
                            ft2Var = (ft2) obj;
                        } else {
                            ft2Var = new ft2(this.mSwanApiContext);
                            this.mApis.put("-336396851", ft2Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ft2Var, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Payment.chooseCoupon")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = ft2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    ft2 ft2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof ft2)) {
                            ft2Var = (ft2) obj;
                        } else {
                            ft2Var = new ft2(this.mSwanApiContext);
                            this.mApis.put("-336396851", ft2Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ft2Var, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Payment.getPaymentInfo")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = ft2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    vs2 vs2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof vs2)) {
                            vs2Var = (vs2) obj;
                        } else {
                            vs2Var = new vs2(this.mSwanApiContext);
                            this.mApis.put("1854689529", vs2Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(vs2Var, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Payment.requestThirdPayment")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = vs2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    ft2 ft2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof ft2)) {
                            ft2Var = (ft2) obj;
                        } else {
                            ft2Var = new ft2(this.mSwanApiContext);
                            this.mApis.put("-336396851", ft2Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ft2Var, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Payment.setPaymentInfo")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 z = ft2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    qv2 qv2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof qv2)) {
                            qv2Var = (qv2) obj;
                        } else {
                            qv2Var = new qv2(this.mSwanApiContext);
                            this.mApis.put("-254510461", qv2Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(qv2Var, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Plugin.invokePluginChooseAddress")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = qv2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    qv2 qv2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof qv2)) {
                            qv2Var = (qv2) obj;
                        } else {
                            qv2Var = new qv2(this.mSwanApiContext);
                            this.mApis.put("-254510461", qv2Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(qv2Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 z = qv2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    qv2 qv2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof qv2)) {
                            qv2Var = (qv2) obj;
                        } else {
                            qv2Var = new qv2(this.mSwanApiContext);
                            this.mApis.put("-254510461", qv2Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(qv2Var, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Plugin.invokePluginPayment")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = qv2Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    j42 j42Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof j42)) {
                            j42Var = (j42) obj;
                        } else {
                            j42Var = new j42(this.mSwanApiContext);
                            this.mApis.put("-2068479848", j42Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(j42Var, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Prefetch.prefetchResources")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = j42Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    b32 b32Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof b32)) {
                            b32Var = (b32) obj;
                        } else {
                            b32Var = new b32(this.mSwanApiContext);
                            this.mApis.put("423661539", b32Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(b32Var, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Preload.preloadStatus")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = b32Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    lc3 lc3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof lc3)) {
                            lc3Var = (lc3) obj;
                        } else {
                            lc3Var = new lc3(this.mSwanApiContext);
                            this.mApis.put("-1929343869", lc3Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(lc3Var, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "PrivateFile.uploadFileToBos")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 C = lc3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    aq1 aq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof aq1)) {
                            aq1Var = (aq1) obj;
                        } else {
                            aq1Var = new aq1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", aq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(aq1Var, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Router.hideModalPage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = aq1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    aq1 aq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof aq1)) {
                            aq1Var = (aq1) obj;
                        } else {
                            aq1Var = new aq1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", aq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(aq1Var, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Router.navigateBack")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 B = aq1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    bq1 bq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof bq1)) {
                            bq1Var = (bq1) obj;
                        } else {
                            bq1Var = new bq1(this.mSwanApiContext);
                            this.mApis.put("1968522584", bq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(bq1Var, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Router.navigateTo")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 H = bq1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    dq1 dq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof dq1)) {
                            dq1Var = (dq1) obj;
                        } else {
                            dq1Var = new dq1(this.mSwanApiContext);
                            this.mApis.put("1317280190", dq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(dq1Var, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Router.reLaunch")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = dq1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    eq1 eq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof eq1)) {
                            eq1Var = (eq1) obj;
                        } else {
                            eq1Var = new eq1(this.mSwanApiContext);
                            this.mApis.put("-420075743", eq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(eq1Var, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Router.reLoadErrorPage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = eq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    cq1 cq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof cq1)) {
                            cq1Var = (cq1) obj;
                        } else {
                            cq1Var = new cq1(this.mSwanApiContext);
                            this.mApis.put("1792515533", cq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(cq1Var, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Router.redirectTo")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 D = cq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    bq1 bq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof bq1)) {
                            bq1Var = (bq1) obj;
                        } else {
                            bq1Var = new bq1(this.mSwanApiContext);
                            this.mApis.put("1968522584", bq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(bq1Var, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Router.showModalPage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 J = bq1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    hq1 hq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof hq1)) {
                            hq1Var = (hq1) obj;
                        } else {
                            hq1Var = new hq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", hq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(hq1Var, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Setting.getAppInfoSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 F = hq1Var.F();
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    hq1 hq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof hq1)) {
                            hq1Var = (hq1) obj;
                        } else {
                            hq1Var = new hq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", hq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(hq1Var, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Setting.getSetting")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 G = hq1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    hq1 hq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof hq1)) {
                            hq1Var = (hq1) obj;
                        } else {
                            hq1Var = new hq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", hq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(hq1Var, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Setting.getSlaveIdSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 H = hq1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    hq1 hq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof hq1)) {
                            hq1Var = (hq1) obj;
                        } else {
                            hq1Var = new hq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", hq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(hq1Var, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Setting.getSwanId")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 I = hq1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    hq1 hq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof hq1)) {
                            hq1Var = (hq1) obj;
                        } else {
                            hq1Var = new hq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", hq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(hq1Var, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Setting.getUserInfo")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 J = hq1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    gq1 gq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof gq1)) {
                            gq1Var = (gq1) obj;
                        } else {
                            gq1Var = new gq1(this.mSwanApiContext);
                            this.mApis.put("450273045", gq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(gq1Var, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Setting.isAllowedAdOpenAppSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = gq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    f73 f73Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof f73)) {
                            f73Var = (f73) obj;
                        } else {
                            f73Var = new f73(this.mSwanApiContext);
                            this.mApis.put("712777136", f73Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(f73Var, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = f73Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    kq1 kq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", kq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(kq1Var, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.clearGlobalStorage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = kq1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    kq1 kq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", kq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(kq1Var, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.clearGlobalStorageSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 C = kq1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    jq1 jq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof jq1)) {
                            jq1Var = (jq1) obj;
                        } else {
                            jq1Var = new jq1(this.mSwanApiContext);
                            this.mApis.put("130910081", jq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(jq1Var, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.clearStorage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = jq1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    jq1 jq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof jq1)) {
                            jq1Var = (jq1) obj;
                        } else {
                            jq1Var = new jq1(this.mSwanApiContext);
                            this.mApis.put("130910081", jq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(jq1Var, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.clearStorageSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 C = jq1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    kq1 kq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", kq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(kq1Var, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.getGlobalStorage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 D = kq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    kq1 kq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", kq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(kq1Var, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.getGlobalStorageInfo")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 G = kq1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    kq1 kq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", kq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(kq1Var, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.getGlobalStorageInfoSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 J = kq1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    kq1 kq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", kq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(kq1Var, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.getGlobalStorageSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 K = kq1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    jq1 jq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof jq1)) {
                            jq1Var = (jq1) obj;
                        } else {
                            jq1Var = new jq1(this.mSwanApiContext);
                            this.mApis.put("130910081", jq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(jq1Var, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.getStorage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 D = jq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    jq1 jq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof jq1)) {
                            jq1Var = (jq1) obj;
                        } else {
                            jq1Var = new jq1(this.mSwanApiContext);
                            this.mApis.put("130910081", jq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(jq1Var, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.getStorageInfo")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 G = jq1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    jq1 jq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof jq1)) {
                            jq1Var = (jq1) obj;
                        } else {
                            jq1Var = new jq1(this.mSwanApiContext);
                            this.mApis.put("130910081", jq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(jq1Var, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.getStorageInfoAsync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 H = jq1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    jq1 jq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof jq1)) {
                            jq1Var = (jq1) obj;
                        } else {
                            jq1Var = new jq1(this.mSwanApiContext);
                            this.mApis.put("130910081", jq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(jq1Var, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.getStorageInfoSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 J = jq1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    jq1 jq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof jq1)) {
                            jq1Var = (jq1) obj;
                        } else {
                            jq1Var = new jq1(this.mSwanApiContext);
                            this.mApis.put("130910081", jq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(jq1Var, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.getStorageSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 K = jq1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    kq1 kq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", kq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(kq1Var, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.removeGlobalStorage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 R = kq1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    kq1 kq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", kq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(kq1Var, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.removeGlobalStorageSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 T = kq1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    jq1 jq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof jq1)) {
                            jq1Var = (jq1) obj;
                        } else {
                            jq1Var = new jq1(this.mSwanApiContext);
                            this.mApis.put("130910081", jq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(jq1Var, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.removeStorage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 R = jq1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    jq1 jq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof jq1)) {
                            jq1Var = (jq1) obj;
                        } else {
                            jq1Var = new jq1(this.mSwanApiContext);
                            this.mApis.put("130910081", jq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(jq1Var, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.removeStorageSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 T = jq1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    kq1 kq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", kq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(kq1Var, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.setGlobalStorage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 U = kq1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    kq1 kq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", kq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(kq1Var, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.setGlobalStorageSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 W = kq1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    jq1 jq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof jq1)) {
                            jq1Var = (jq1) obj;
                        } else {
                            jq1Var = new jq1(this.mSwanApiContext);
                            this.mApis.put("130910081", jq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(jq1Var, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.setStorage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 U = jq1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    jq1 jq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof jq1)) {
                            jq1Var = (jq1) obj;
                        } else {
                            jq1Var = new jq1(this.mSwanApiContext);
                            this.mApis.put("130910081", jq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(jq1Var, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Storage.setStorageSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 W = jq1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    mq1 mq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof mq1)) {
                            mq1Var = (mq1) obj;
                        } else {
                            mq1Var = new mq1(this.mSwanApiContext);
                            this.mApis.put("823117982", mq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(mq1Var, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Subscription.requestSubscribeFormId")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 E = mq1Var.E(str);
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    nq1 nq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof nq1)) {
                            nq1Var = (nq1) obj;
                        } else {
                            nq1Var = new nq1(this.mSwanApiContext);
                            this.mApis.put("-947445811", nq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(nq1Var, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Subscription.subscribeService")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 F = nq1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    uq1 uq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof uq1)) {
                            uq1Var = (uq1) obj;
                        } else {
                            uq1Var = new uq1(this.mSwanApiContext);
                            this.mApis.put("1936205521", uq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(uq1Var, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.exitFullScreen")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = uq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    qq1 qq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof qq1)) {
                            qq1Var = (qq1) obj;
                        } else {
                            qq1Var = new qq1(this.mSwanApiContext);
                            this.mApis.put("99997465", qq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(qq1Var, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.getBrightness")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = qq1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    rq1 rq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof rq1)) {
                            rq1Var = (rq1) obj;
                        } else {
                            rq1Var = new rq1(this.mSwanApiContext);
                            this.mApis.put("-518757484", rq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(rq1Var, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.getClipboardData")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = rq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    tq1 tq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof tq1)) {
                            tq1Var = (tq1) obj;
                        } else {
                            tq1Var = new tq1(this.mSwanApiContext);
                            this.mApis.put("1694151270", tq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(tq1Var, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.getDeviceInfo")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = tq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    vq1 vq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("-1321681619", vq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(vq1Var, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.getDeviceProfile")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = vq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    br1 br1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("447234992", br1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(br1Var, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.getMediaVolume")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = br1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    wq1 wq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof wq1)) {
                            wq1Var = (wq1) obj;
                        } else {
                            wq1Var = new wq1(this.mSwanApiContext);
                            this.mApis.put("-1569246082", wq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(wq1Var, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.makePhoneCall")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = wq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    yq1 yq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof yq1)) {
                            yq1Var = (yq1) obj;
                        } else {
                            yq1Var = new yq1(this.mSwanApiContext);
                            this.mApis.put("1099851202", yq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(yq1Var, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.openSMSPanel")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = yq1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    xq1 xq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof xq1)) {
                            xq1Var = (xq1) obj;
                        } else {
                            xq1Var = new xq1(this.mSwanApiContext);
                            this.mApis.put("-1707203360", xq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(xq1Var, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.requestFullScreen")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 F = xq1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    rq1 rq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof rq1)) {
                            rq1Var = (rq1) obj;
                        } else {
                            rq1Var = new rq1(this.mSwanApiContext);
                            this.mApis.put("-518757484", rq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(rq1Var, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.setClipboardData")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = rq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    bq2 bq2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof bq2)) {
                            bq2Var = (bq2) obj;
                        } else {
                            bq2Var = new bq2(this.mSwanApiContext);
                            this.mApis.put("1161486049", bq2Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(bq2Var, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.setErrorPageType")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = bq2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("447234992", br1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(br1Var, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.setMediaVolume")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 z = br1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    pq1 pq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof pq1)) {
                            pq1Var = (pq1) obj;
                        } else {
                            pq1Var = new pq1(this.mSwanApiContext);
                            this.mApis.put("1372680763", pq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(pq1Var, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.startAccelerometer")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = pq1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    sq1 sq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof sq1)) {
                            sq1Var = (sq1) obj;
                        } else {
                            sq1Var = new sq1(this.mSwanApiContext);
                            this.mApis.put("1689255576", sq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(sq1Var, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.startCompass")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = sq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    pq1 pq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof pq1)) {
                            pq1Var = (pq1) obj;
                        } else {
                            pq1Var = new pq1(this.mSwanApiContext);
                            this.mApis.put("1372680763", pq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(pq1Var, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.stopAccelerometer")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 B = pq1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    sq1 sq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof sq1)) {
                            sq1Var = (sq1) obj;
                        } else {
                            sq1Var = new sq1(this.mSwanApiContext);
                            this.mApis.put("1689255576", sq1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(sq1Var, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "System.stopCompass")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 z = sq1Var.z();
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    mr1 mr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof mr1)) {
                            mr1Var = (mr1) obj;
                        } else {
                            mr1Var = new mr1(this.mSwanApiContext);
                            this.mApis.put("201194468", mr1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(mr1Var, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.addToDesktop")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 B = mr1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    ir1 ir1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof ir1)) {
                            ir1Var = (ir1) obj;
                        } else {
                            ir1Var = new ir1(this.mSwanApiContext);
                            this.mApis.put("-1412306947", ir1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ir1Var, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.calcMD5")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = ir1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    jr1 jr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof jr1)) {
                            jr1Var = (jr1) obj;
                        } else {
                            jr1Var = new jr1(this.mSwanApiContext);
                            this.mApis.put("1626415364", jr1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(jr1Var, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.checkAppInstalled")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = jr1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    lr1 lr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof lr1)) {
                            lr1Var = (lr1) obj;
                        } else {
                            lr1Var = new lr1(this.mSwanApiContext);
                            this.mApis.put("-836768778", lr1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(lr1Var, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.getCommonSysInfo")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = lr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    rr1 rr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof rr1)) {
                            rr1Var = (rr1) obj;
                        } else {
                            rr1Var = new rr1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", rr1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(rr1Var, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.getCommonSysInfoSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 E = rr1Var.E();
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    nr1 nr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof nr1)) {
                            nr1Var = (nr1) obj;
                        } else {
                            nr1Var = new nr1(this.mSwanApiContext);
                            this.mApis.put("-810858308", nr1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(nr1Var, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.getPerformanceLevel")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = nr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    rr1 rr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof rr1)) {
                            rr1Var = (rr1) obj;
                        } else {
                            rr1Var = new rr1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", rr1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(rr1Var, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.getSystemInfo")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 H = rr1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    rr1 rr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof rr1)) {
                            rr1Var = (rr1) obj;
                        } else {
                            rr1Var = new rr1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", rr1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(rr1Var, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.getSystemInfoAsync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 I = rr1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    rr1 rr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof rr1)) {
                            rr1Var = (rr1) obj;
                        } else {
                            rr1Var = new rr1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", rr1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(rr1Var, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.getSystemInfoSync")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 J = rr1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    or1 or1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof or1)) {
                            or1Var = (or1) obj;
                        } else {
                            or1Var = new or1(this.mSwanApiContext);
                            this.mApis.put("-2097727681", or1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(or1Var, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.handleException")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = or1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    kr1 kr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof kr1)) {
                            kr1Var = (kr1) obj;
                        } else {
                            kr1Var = new kr1(this.mSwanApiContext);
                            this.mApis.put("2084449317", kr1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(kr1Var, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.hasCloseHandler")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = kr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    n43 n43Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof n43)) {
                            n43Var = (n43) obj;
                        } else {
                            n43Var = new n43(this.mSwanApiContext);
                            this.mApis.put("1031678042", n43Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(n43Var, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.hideCaptureScreenShareDialog")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 x = n43Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    pr1 pr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof pr1)) {
                            pr1Var = (pr1) obj;
                        } else {
                            pr1Var = new pr1(this.mSwanApiContext);
                            this.mApis.put("1751900130", pr1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(pr1Var, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.logToFile")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 y = pr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    o33 o33Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof o33)) {
                            o33Var = (o33) obj;
                        } else {
                            o33Var = new o33(this.mSwanApiContext);
                            this.mApis.put("1748196865", o33Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(o33Var, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.preloadPackage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = o33Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    qr1 qr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof qr1)) {
                            qr1Var = (qr1) obj;
                        } else {
                            qr1Var = new qr1(this.mSwanApiContext);
                            this.mApis.put("589529211", qr1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(qr1Var, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.previewImage")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 B = qr1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    tr1 tr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof tr1)) {
                            tr1Var = (tr1) obj;
                        } else {
                            tr1Var = new tr1(this.mSwanApiContext);
                            this.mApis.put("-577481801", tr1Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(tr1Var, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Utils.ubcFlowJar")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 I = tr1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(jo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public jo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jo1Var};
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
                    this.mSwanApiContext = jo1Var;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    ya3 ya3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ya3)) {
                            ya3Var = (ya3) obj;
                        } else {
                            ya3Var = new ya3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ya3Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ya3Var, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Wifi.connectWifi")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 A = ya3Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    ya3 ya3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ya3)) {
                            ya3Var = (ya3) obj;
                        } else {
                            ya3Var = new ya3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ya3Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ya3Var, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Wifi.getConnectedWifi")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 B = ya3Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    ya3 ya3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ya3)) {
                            ya3Var = (ya3) obj;
                        } else {
                            ya3Var = new ya3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ya3Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ya3Var, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Wifi.getWifiList")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 C = ya3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    ya3 ya3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ya3)) {
                            ya3Var = (ya3) obj;
                        } else {
                            ya3Var = new ya3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ya3Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ya3Var, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Wifi.startWifi")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 G = ya3Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    ya3 ya3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ya3)) {
                            ya3Var = (ya3) obj;
                        } else {
                            ya3Var = new ya3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ya3Var);
                        }
                        Pair<Boolean, hs1> a = js1.a(ya3Var, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((hs1) a.second).a();
                        }
                        if (p22.a(this.mSwanApiContext.g(), "Wifi.stopWifi")) {
                            return new is1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        is1 H = ya3Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}
