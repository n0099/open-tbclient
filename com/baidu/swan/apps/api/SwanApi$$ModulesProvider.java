package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.tieba.aq1;
import com.baidu.tieba.as1;
import com.baidu.tieba.at1;
import com.baidu.tieba.b52;
import com.baidu.tieba.bp1;
import com.baidu.tieba.bq1;
import com.baidu.tieba.br1;
import com.baidu.tieba.bs1;
import com.baidu.tieba.bt1;
import com.baidu.tieba.cq1;
import com.baidu.tieba.cr1;
import com.baidu.tieba.cs1;
import com.baidu.tieba.dd3;
import com.baidu.tieba.de2;
import com.baidu.tieba.dp1;
import com.baidu.tieba.dq1;
import com.baidu.tieba.ds1;
import com.baidu.tieba.ep1;
import com.baidu.tieba.eq1;
import com.baidu.tieba.er1;
import com.baidu.tieba.es1;
import com.baidu.tieba.f53;
import com.baidu.tieba.fr1;
import com.baidu.tieba.fs1;
import com.baidu.tieba.g43;
import com.baidu.tieba.gp1;
import com.baidu.tieba.gs1;
import com.baidu.tieba.h32;
import com.baidu.tieba.hp1;
import com.baidu.tieba.hq1;
import com.baidu.tieba.hr1;
import com.baidu.tieba.hs1;
import com.baidu.tieba.ip1;
import com.baidu.tieba.ir1;
import com.baidu.tieba.is1;
import com.baidu.tieba.iw2;
import com.baidu.tieba.jp1;
import com.baidu.tieba.jr1;
import com.baidu.tieba.js1;
import com.baidu.tieba.kp1;
import com.baidu.tieba.kr1;
import com.baidu.tieba.lr1;
import com.baidu.tieba.ls1;
import com.baidu.tieba.mp1;
import com.baidu.tieba.mr1;
import com.baidu.tieba.nq1;
import com.baidu.tieba.nr1;
import com.baidu.tieba.nt2;
import com.baidu.tieba.op1;
import com.baidu.tieba.oq1;
import com.baidu.tieba.or1;
import com.baidu.tieba.pp1;
import com.baidu.tieba.pr1;
import com.baidu.tieba.qb3;
import com.baidu.tieba.qo1;
import com.baidu.tieba.qr1;
import com.baidu.tieba.rh1;
import com.baidu.tieba.rq2;
import com.baidu.tieba.sp1;
import com.baidu.tieba.sq1;
import com.baidu.tieba.t32;
import com.baidu.tieba.tq1;
import com.baidu.tieba.tq2;
import com.baidu.tieba.tr1;
import com.baidu.tieba.up1;
import com.baidu.tieba.uq1;
import com.baidu.tieba.vp1;
import com.baidu.tieba.vq1;
import com.baidu.tieba.vr1;
import com.baidu.tieba.wp1;
import com.baidu.tieba.wq1;
import com.baidu.tieba.x73;
import com.baidu.tieba.xp1;
import com.baidu.tieba.xt2;
import com.baidu.tieba.yp1;
import com.baidu.tieba.yq1;
import com.baidu.tieba.ys1;
import com.baidu.tieba.zp1;
import com.baidu.tieba.zq1;
import com.baidu.tieba.zs1;
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

    public static Map<String, Object> getV8ApiModules(final bp1 bp1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bp1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    hp1 hp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof hp1)) {
                            hp1Var = (hp1) obj;
                        } else {
                            hp1Var = new hp1(this.mSwanApiContext);
                            this.mApis.put("1930258908", hp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(hp1Var, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Account.checkSession")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = hp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ip1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(ip1Var, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Account.getLoginCode")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 C = ip1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("1754780133", jp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(jp1Var, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Account.getOpenId")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = jp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    qo1 qo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof qo1)) {
                            qo1Var = (qo1) obj;
                        } else {
                            qo1Var = new qo1(this.mSwanApiContext);
                            this.mApis.put("-343998465", qo1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(qo1Var, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Account.getUnionBDUSS")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = qo1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    gp1 gp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("-337742792", gp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(gp1Var, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Account.isBaiduAccountSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = gp1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    ip1 ip1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ip1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(ip1Var, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Account.isLoginSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 H = ip1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ip1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(ip1Var, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Account.login")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 I = ip1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    kp1 kp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof kp1)) {
                            kp1Var = (kp1) obj;
                        } else {
                            kp1Var = new kp1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", kp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(kp1Var, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Basic.loadSubPackage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 F = kp1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    kp1 kp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof kp1)) {
                            kp1Var = (kp1) obj;
                        } else {
                            kp1Var = new kp1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", kp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(kp1Var, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Basic.loadSubPackages")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 G = kp1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    rh1 rh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof rh1)) {
                            rh1Var = (rh1) obj;
                        } else {
                            rh1Var = new rh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", rh1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(rh1Var, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Bookshelf.deleteBookshelf")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 K = rh1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    rh1 rh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof rh1)) {
                            rh1Var = (rh1) obj;
                        } else {
                            rh1Var = new rh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", rh1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(rh1Var, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Bookshelf.insertBookshelf")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 P = rh1Var.P(str);
                        return P == null ? "" : P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    rh1 rh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof rh1)) {
                            rh1Var = (rh1) obj;
                        } else {
                            rh1Var = new rh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", rh1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(rh1Var, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Bookshelf.navigateToBookshelf")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 U = rh1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    rh1 rh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof rh1)) {
                            rh1Var = (rh1) obj;
                        } else {
                            rh1Var = new rh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", rh1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(rh1Var, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Bookshelf.queryBookshelf")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 V = rh1Var.V(str);
                        return V == null ? "" : V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    rh1 rh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof rh1)) {
                            rh1Var = (rh1) obj;
                        } else {
                            rh1Var = new rh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", rh1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(rh1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Bookshelf.updateBookshelfReadTime")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 X = rh1Var.X(str);
                        return X == null ? "" : X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    ep1 ep1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof ep1)) {
                            ep1Var = (ep1) obj;
                        } else {
                            ep1Var = new ep1(this.mSwanApiContext);
                            this.mApis.put("-277316359", ep1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(ep1Var, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Coupon.getPlatformCoupons")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = ep1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    ep1 ep1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof ep1)) {
                            ep1Var = (ep1) obj;
                        } else {
                            ep1Var = new ep1(this.mSwanApiContext);
                            this.mApis.put("-277316359", ep1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(ep1Var, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Coupon.getUserCoupons")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 z = ep1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    ep1 ep1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof ep1)) {
                            ep1Var = (ep1) obj;
                        } else {
                            ep1Var = new ep1(this.mSwanApiContext);
                            this.mApis.put("-277316359", ep1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(ep1Var, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Coupon.takeCoupons")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 C = ep1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    mp1 mp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof mp1)) {
                            mp1Var = (mp1) obj;
                        } else {
                            mp1Var = new mp1(this.mSwanApiContext);
                            this.mApis.put("-1225406515", mp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(mp1Var, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Favorite.getFavorStatus")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = mp1Var.x(str);
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
                        Pair<Boolean, zs1> a = bt1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Favorite.showFavoriteGuide")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 G = showFavoriteGuideApi.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    op1 op1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof op1)) {
                            op1Var = (op1) obj;
                        } else {
                            op1Var = new op1(this.mSwanApiContext);
                            this.mApis.put("-2057135077", op1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(op1Var, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "File.shareFile")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = op1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    de2 de2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof de2)) {
                            de2Var = (de2) obj;
                        } else {
                            de2Var = new de2(this.mSwanApiContext);
                            this.mApis.put("2077414795", de2Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(de2Var, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = de2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    de2 de2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof de2)) {
                            de2Var = (de2) obj;
                        } else {
                            de2Var = new de2(this.mSwanApiContext);
                            this.mApis.put("2077414795", de2Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(de2Var, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessageSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = de2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String download(String str) {
                    pp1 pp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof pp1)) {
                            pp1Var = (pp1) obj;
                        } else {
                            pp1Var = new pp1(this.mSwanApiContext);
                            this.mApis.put("-170124576", pp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(pp1Var, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "HostDownloadManager.download")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = pp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    pp1 pp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof pp1)) {
                            pp1Var = (pp1) obj;
                        } else {
                            pp1Var = new pp1(this.mSwanApiContext);
                            this.mApis.put("-170124576", pp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(pp1Var, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "HostDownloadManager.openDownloadCenter")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = pp1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    pp1 pp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof pp1)) {
                            pp1Var = (pp1) obj;
                        } else {
                            pp1Var = new pp1(this.mSwanApiContext);
                            this.mApis.put("-170124576", pp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(pp1Var, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "HostDownloadManager.openFile")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 z = pp1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    pp1 pp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof pp1)) {
                            pp1Var = (pp1) obj;
                        } else {
                            pp1Var = new pp1(this.mSwanApiContext);
                            this.mApis.put("-170124576", pp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(pp1Var, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "HostDownloadManager.query")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 query = pp1Var.query(str);
                        return query == null ? "" : query.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naImage", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    rq2 rq2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof rq2)) {
                            rq2Var = (rq2) obj;
                        } else {
                            rq2Var = new rq2(this.mSwanApiContext);
                            this.mApis.put("1445003743", rq2Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(rq2Var, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Image.callImageMenu")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = rq2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    sp1 sp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof sp1)) {
                            sp1Var = (sp1) obj;
                        } else {
                            sp1Var = new sp1(this.mSwanApiContext);
                            this.mApis.put("-1252730367", sp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(sp1Var, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Image.compressImage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = sp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    aq1 aq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof aq1)) {
                            aq1Var = (aq1) obj;
                        } else {
                            aq1Var = new aq1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", aq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(aq1Var, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.closeTabBar")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = aq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    aq1 aq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof aq1)) {
                            aq1Var = (aq1) obj;
                        } else {
                            aq1Var = new aq1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", aq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(aq1Var, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.closeTabBarRedDot")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = aq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    up1 up1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("5236036", up1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(up1Var, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.hideLoading")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = up1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    wp1 wp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof wp1)) {
                            wp1Var = (wp1) obj;
                        } else {
                            wp1Var = new wp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", wp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(wp1Var, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.hideNavigationBarLoading")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = wp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    bq1 bq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof bq1)) {
                            bq1Var = (bq1) obj;
                        } else {
                            bq1Var = new bq1(this.mSwanApiContext);
                            this.mApis.put("1159492510", bq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(bq1Var, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.hideToast")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 K = bq1Var.K();
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    yp1 yp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof yp1)) {
                            yp1Var = (yp1) obj;
                        } else {
                            yp1Var = new yp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", yp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(yp1Var, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.openMultiPicker")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 G = yp1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    yp1 yp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof yp1)) {
                            yp1Var = (yp1) obj;
                        } else {
                            yp1Var = new yp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", yp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(yp1Var, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.openPicker")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 H = yp1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    aq1 aq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof aq1)) {
                            aq1Var = (aq1) obj;
                        } else {
                            aq1Var = new aq1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", aq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(aq1Var, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.openTabBar")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 C = aq1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    xp1 xp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof xp1)) {
                            xp1Var = (xp1) obj;
                        } else {
                            xp1Var = new xp1(this.mSwanApiContext);
                            this.mApis.put("-1750613704", xp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(xp1Var, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.pageScrollTo")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = xp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    wp1 wp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof wp1)) {
                            wp1Var = (wp1) obj;
                        } else {
                            wp1Var = new wp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", wp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(wp1Var, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarColor")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 z = wp1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    wp1 wp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof wp1)) {
                            wp1Var = (wp1) obj;
                        } else {
                            wp1Var = new wp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", wp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(wp1Var, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarTitle")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = wp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    aq1 aq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof aq1)) {
                            aq1Var = (aq1) obj;
                        } else {
                            aq1Var = new aq1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", aq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(aq1Var, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.setTabBarItem")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 D = aq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    yp1 yp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof yp1)) {
                            yp1Var = (yp1) obj;
                        } else {
                            yp1Var = new yp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", yp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(yp1Var, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.showDatePickerView")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 L = yp1Var.L(str);
                        return L == null ? "" : L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    cq1 cq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof cq1)) {
                            cq1Var = (cq1) obj;
                        } else {
                            cq1Var = new cq1(this.mSwanApiContext);
                            this.mApis.put("1172469410", cq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(cq1Var, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.showHalfScreenWebview")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 K = cq1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    up1 up1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("5236036", up1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(up1Var, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.showLoading")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = up1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    vp1 vp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof vp1)) {
                            vp1Var = (vp1) obj;
                        } else {
                            vp1Var = new vp1(this.mSwanApiContext);
                            this.mApis.put("1913747800", vp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(vp1Var, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.showModal")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = vp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    wp1 wp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof wp1)) {
                            wp1Var = (wp1) obj;
                        } else {
                            wp1Var = new wp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", wp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(wp1Var, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.showNavigationBarLoading")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 B = wp1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    bq1 bq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof bq1)) {
                            bq1Var = (bq1) obj;
                        } else {
                            bq1Var = new bq1(this.mSwanApiContext);
                            this.mApis.put("1159492510", bq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(bq1Var, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.showToast")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 Q = bq1Var.Q(str);
                        return Q == null ? "" : Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    zp1 zp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof zp1)) {
                            zp1Var = (zp1) obj;
                        } else {
                            zp1Var = new zp1(this.mSwanApiContext);
                            this.mApis.put("1165118609", zp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(zp1Var, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.stopPullDownRefresh")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = zp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    yp1 yp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof yp1)) {
                            yp1Var = (yp1) obj;
                        } else {
                            yp1Var = new yp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", yp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(yp1Var, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.updateMultiPicker")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 M = yp1Var.M(str);
                        return M == null ? "" : M.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    dq1 dq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof dq1)) {
                            dq1Var = (dq1) obj;
                        } else {
                            dq1Var = new dq1(this.mSwanApiContext);
                            this.mApis.put("-137346255", dq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(dq1Var, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Keyboard.startKeyboardHeightChange")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 C = dq1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    dq1 dq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof dq1)) {
                            dq1Var = (dq1) obj;
                        } else {
                            dq1Var = new dq1(this.mSwanApiContext);
                            this.mApis.put("-137346255", dq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(dq1Var, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Keyboard.stopKeyboardHeightChange")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 D = dq1Var.D();
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    eq1 eq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof eq1)) {
                            eq1Var = (eq1) obj;
                        } else {
                            eq1Var = new eq1(this.mSwanApiContext);
                            this.mApis.put("-397373095", eq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(eq1Var, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "LocationService.getLocation")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = eq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    eq1 eq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof eq1)) {
                            eq1Var = (eq1) obj;
                        } else {
                            eq1Var = new eq1(this.mSwanApiContext);
                            this.mApis.put("-397373095", eq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(eq1Var, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "LocationService.startLocationUpdate")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = eq1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    eq1 eq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof eq1)) {
                            eq1Var = (eq1) obj;
                        } else {
                            eq1Var = new eq1(this.mSwanApiContext);
                            this.mApis.put("-397373095", eq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(eq1Var, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "LocationService.stopLocationUpdate")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 B = eq1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    vr1 vr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof vr1)) {
                            vr1Var = (vr1) obj;
                        } else {
                            vr1Var = new vr1(this.mSwanApiContext);
                            this.mApis.put("538070032", vr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(vr1Var, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = vr1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String callService(String str) {
                    hq1 hq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof hq1)) {
                            hq1Var = (hq1) obj;
                        } else {
                            hq1Var = new hq1(this.mSwanApiContext);
                            this.mApis.put("-1076509454", hq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(hq1Var, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Network.callService")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = hq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    oq1 oq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof oq1)) {
                            oq1Var = (oq1) obj;
                        } else {
                            oq1Var = new oq1(this.mSwanApiContext);
                            this.mApis.put("968563034", oq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(oq1Var, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Network.cancelRequest")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 D = oq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    nq1 nq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof nq1)) {
                            nq1Var = (nq1) obj;
                        } else {
                            nq1Var = new nq1(this.mSwanApiContext);
                            this.mApis.put("453220699", nq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(nq1Var, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Network.getNetworkType")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = nq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    nq1 nq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof nq1)) {
                            nq1Var = (nq1) obj;
                        } else {
                            nq1Var = new nq1(this.mSwanApiContext);
                            this.mApis.put("453220699", nq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(nq1Var, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Network.networkStatusChange")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = nq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                @JavascriptInterface
                public String request(JsObject jsObject) {
                    InterceptResult invokeL2;
                    oq1 oq1Var;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && (invokeL2 = interceptable2.invokeL(1048580, this, jsObject)) != null) {
                        return (String) invokeL2.objValue;
                    }
                    try {
                        ys1.c().a("request");
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof oq1)) {
                            oq1Var = (oq1) obj;
                        } else {
                            oq1Var = new oq1(this.mSwanApiContext);
                            this.mApis.put("968563034", oq1Var);
                        }
                        Pair<Boolean, zs1> a2 = bt1.a(oq1Var, "swanAPI/request");
                        if (((Boolean) a2.first).booleanValue()) {
                            a = ((zs1) a2.second).a();
                        } else if (h32.a(this.mSwanApiContext.e(), "Network.request")) {
                            a = new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        } else {
                            Pair<zs1, JSONObject> t = dp1.t(jsObject);
                            if (!((zs1) t.first).isSuccess()) {
                                a = ((zs1) t.first).a();
                            } else {
                                JSONObject jSONObject = (JSONObject) t.second;
                                if (jSONObject == null) {
                                    a = zs1.a.a();
                                } else {
                                    at1 V = oq1Var.V(jSONObject);
                                    a = V == null ? "" : V.a();
                                }
                            }
                        }
                        return a;
                    } finally {
                    }
                }
            });
            hashMap.put("_naPayment", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    xt2 xt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof xt2)) {
                            xt2Var = (xt2) obj;
                        } else {
                            xt2Var = new xt2(this.mSwanApiContext);
                            this.mApis.put("-336396851", xt2Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(xt2Var, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Payment.chooseCoupon")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = xt2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    xt2 xt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof xt2)) {
                            xt2Var = (xt2) obj;
                        } else {
                            xt2Var = new xt2(this.mSwanApiContext);
                            this.mApis.put("-336396851", xt2Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(xt2Var, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Payment.getPaymentInfo")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = xt2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    nt2 nt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof nt2)) {
                            nt2Var = (nt2) obj;
                        } else {
                            nt2Var = new nt2(this.mSwanApiContext);
                            this.mApis.put("1854689529", nt2Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(nt2Var, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Payment.requestThirdPayment")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = nt2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    xt2 xt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof xt2)) {
                            xt2Var = (xt2) obj;
                        } else {
                            xt2Var = new xt2(this.mSwanApiContext);
                            this.mApis.put("-336396851", xt2Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(xt2Var, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Payment.setPaymentInfo")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 z = xt2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    iw2 iw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof iw2)) {
                            iw2Var = (iw2) obj;
                        } else {
                            iw2Var = new iw2(this.mSwanApiContext);
                            this.mApis.put("-254510461", iw2Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(iw2Var, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Plugin.invokePluginChooseAddress")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = iw2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    iw2 iw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof iw2)) {
                            iw2Var = (iw2) obj;
                        } else {
                            iw2Var = new iw2(this.mSwanApiContext);
                            this.mApis.put("-254510461", iw2Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(iw2Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 z = iw2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    iw2 iw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof iw2)) {
                            iw2Var = (iw2) obj;
                        } else {
                            iw2Var = new iw2(this.mSwanApiContext);
                            this.mApis.put("-254510461", iw2Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(iw2Var, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Plugin.invokePluginPayment")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = iw2Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    b52 b52Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof b52)) {
                            b52Var = (b52) obj;
                        } else {
                            b52Var = new b52(this.mSwanApiContext);
                            this.mApis.put("-2068479848", b52Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(b52Var, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Prefetch.prefetchResources")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = b52Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    t32 t32Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof t32)) {
                            t32Var = (t32) obj;
                        } else {
                            t32Var = new t32(this.mSwanApiContext);
                            this.mApis.put("423661539", t32Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(t32Var, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Preload.preloadStatus")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = t32Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    dd3 dd3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof dd3)) {
                            dd3Var = (dd3) obj;
                        } else {
                            dd3Var = new dd3(this.mSwanApiContext);
                            this.mApis.put("-1929343869", dd3Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(dd3Var, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "PrivateFile.uploadFileToBos")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 C = dd3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    sq1 sq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof sq1)) {
                            sq1Var = (sq1) obj;
                        } else {
                            sq1Var = new sq1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", sq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(sq1Var, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Router.hideModalPage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = sq1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    sq1 sq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof sq1)) {
                            sq1Var = (sq1) obj;
                        } else {
                            sq1Var = new sq1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", sq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(sq1Var, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Router.navigateBack")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 B = sq1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    tq1 tq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof tq1)) {
                            tq1Var = (tq1) obj;
                        } else {
                            tq1Var = new tq1(this.mSwanApiContext);
                            this.mApis.put("1968522584", tq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(tq1Var, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Router.navigateTo")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 H = tq1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    vq1 vq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("1317280190", vq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(vq1Var, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Router.reLaunch")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = vq1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    wq1 wq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof wq1)) {
                            wq1Var = (wq1) obj;
                        } else {
                            wq1Var = new wq1(this.mSwanApiContext);
                            this.mApis.put("-420075743", wq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(wq1Var, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Router.reLoadErrorPage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = wq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    uq1 uq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof uq1)) {
                            uq1Var = (uq1) obj;
                        } else {
                            uq1Var = new uq1(this.mSwanApiContext);
                            this.mApis.put("1792515533", uq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(uq1Var, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Router.redirectTo")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 D = uq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    tq1 tq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof tq1)) {
                            tq1Var = (tq1) obj;
                        } else {
                            tq1Var = new tq1(this.mSwanApiContext);
                            this.mApis.put("1968522584", tq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(tq1Var, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Router.showModalPage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 J = tq1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    zq1 zq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof zq1)) {
                            zq1Var = (zq1) obj;
                        } else {
                            zq1Var = new zq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", zq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(zq1Var, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Setting.getAppInfoSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 F = zq1Var.F();
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    zq1 zq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof zq1)) {
                            zq1Var = (zq1) obj;
                        } else {
                            zq1Var = new zq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", zq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(zq1Var, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Setting.getSetting")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 G = zq1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    zq1 zq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof zq1)) {
                            zq1Var = (zq1) obj;
                        } else {
                            zq1Var = new zq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", zq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(zq1Var, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Setting.getSlaveIdSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 H = zq1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    zq1 zq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof zq1)) {
                            zq1Var = (zq1) obj;
                        } else {
                            zq1Var = new zq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", zq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(zq1Var, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Setting.getSwanId")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 I = zq1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    zq1 zq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof zq1)) {
                            zq1Var = (zq1) obj;
                        } else {
                            zq1Var = new zq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", zq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(zq1Var, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Setting.getUserInfo")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 J = zq1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    yq1 yq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof yq1)) {
                            yq1Var = (yq1) obj;
                        } else {
                            yq1Var = new yq1(this.mSwanApiContext);
                            this.mApis.put("450273045", yq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(yq1Var, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Setting.isAllowedAdOpenAppSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = yq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    x73 x73Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof x73)) {
                            x73Var = (x73) obj;
                        } else {
                            x73Var = new x73(this.mSwanApiContext);
                            this.mApis.put("712777136", x73Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(x73Var, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = x73Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    cr1 cr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("-804054859", cr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(cr1Var, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = cr1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    cr1 cr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("-804054859", cr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(cr1Var, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorageSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 C = cr1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    br1 br1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("130910081", br1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(br1Var, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.clearStorage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = br1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    br1 br1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("130910081", br1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(br1Var, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.clearStorageSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 C = br1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    cr1 cr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("-804054859", cr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(cr1Var, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.getGlobalStorage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 D = cr1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    cr1 cr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("-804054859", cr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(cr1Var, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfo")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 G = cr1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    cr1 cr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("-804054859", cr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(cr1Var, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfoSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 J = cr1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    cr1 cr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("-804054859", cr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(cr1Var, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 K = cr1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("130910081", br1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(br1Var, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.getStorage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 D = br1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    br1 br1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("130910081", br1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(br1Var, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.getStorageInfo")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 G = br1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("130910081", br1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(br1Var, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.getStorageInfoAsync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 H = br1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    br1 br1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("130910081", br1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(br1Var, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.getStorageInfoSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 J = br1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("130910081", br1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(br1Var, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.getStorageSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 K = br1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    cr1 cr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("-804054859", cr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(cr1Var, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 R = cr1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    cr1 cr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("-804054859", cr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(cr1Var, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorageSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 T = cr1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("130910081", br1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(br1Var, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.removeStorage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 R = br1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("130910081", br1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(br1Var, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.removeStorageSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 T = br1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    cr1 cr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("-804054859", cr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(cr1Var, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.setGlobalStorage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 U = cr1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    cr1 cr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("-804054859", cr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(cr1Var, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.setGlobalStorageSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 W = cr1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("130910081", br1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(br1Var, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.setStorage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 U = br1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("130910081", br1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(br1Var, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.setStorageSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 W = br1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    er1 er1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof er1)) {
                            er1Var = (er1) obj;
                        } else {
                            er1Var = new er1(this.mSwanApiContext);
                            this.mApis.put("823117982", er1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(er1Var, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Subscription.requestSubscribeFormId")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 E = er1Var.E(str);
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    fr1 fr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof fr1)) {
                            fr1Var = (fr1) obj;
                        } else {
                            fr1Var = new fr1(this.mSwanApiContext);
                            this.mApis.put("-947445811", fr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(fr1Var, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Subscription.subscribeService")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 F = fr1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    mr1 mr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof mr1)) {
                            mr1Var = (mr1) obj;
                        } else {
                            mr1Var = new mr1(this.mSwanApiContext);
                            this.mApis.put("1936205521", mr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(mr1Var, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.exitFullScreen")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = mr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    ir1 ir1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof ir1)) {
                            ir1Var = (ir1) obj;
                        } else {
                            ir1Var = new ir1(this.mSwanApiContext);
                            this.mApis.put("99997465", ir1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(ir1Var, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.getBrightness")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = ir1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    jr1 jr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof jr1)) {
                            jr1Var = (jr1) obj;
                        } else {
                            jr1Var = new jr1(this.mSwanApiContext);
                            this.mApis.put("-518757484", jr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(jr1Var, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.getClipboardData")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = jr1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    lr1 lr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof lr1)) {
                            lr1Var = (lr1) obj;
                        } else {
                            lr1Var = new lr1(this.mSwanApiContext);
                            this.mApis.put("1694151270", lr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(lr1Var, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.getDeviceInfo")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = lr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    nr1 nr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof nr1)) {
                            nr1Var = (nr1) obj;
                        } else {
                            nr1Var = new nr1(this.mSwanApiContext);
                            this.mApis.put("-1321681619", nr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(nr1Var, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.getDeviceProfile")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = nr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    tr1 tr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof tr1)) {
                            tr1Var = (tr1) obj;
                        } else {
                            tr1Var = new tr1(this.mSwanApiContext);
                            this.mApis.put("447234992", tr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(tr1Var, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.getMediaVolume")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = tr1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    or1 or1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof or1)) {
                            or1Var = (or1) obj;
                        } else {
                            or1Var = new or1(this.mSwanApiContext);
                            this.mApis.put("-1569246082", or1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(or1Var, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.makePhoneCall")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = or1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    qr1 qr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof qr1)) {
                            qr1Var = (qr1) obj;
                        } else {
                            qr1Var = new qr1(this.mSwanApiContext);
                            this.mApis.put("1099851202", qr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(qr1Var, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.openSMSPanel")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = qr1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    pr1 pr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof pr1)) {
                            pr1Var = (pr1) obj;
                        } else {
                            pr1Var = new pr1(this.mSwanApiContext);
                            this.mApis.put("-1707203360", pr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(pr1Var, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.requestFullScreen")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 F = pr1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    jr1 jr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof jr1)) {
                            jr1Var = (jr1) obj;
                        } else {
                            jr1Var = new jr1(this.mSwanApiContext);
                            this.mApis.put("-518757484", jr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(jr1Var, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.setClipboardData")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = jr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    tq2 tq2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof tq2)) {
                            tq2Var = (tq2) obj;
                        } else {
                            tq2Var = new tq2(this.mSwanApiContext);
                            this.mApis.put("1161486049", tq2Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(tq2Var, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.setErrorPageType")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = tq2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    tr1 tr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof tr1)) {
                            tr1Var = (tr1) obj;
                        } else {
                            tr1Var = new tr1(this.mSwanApiContext);
                            this.mApis.put("447234992", tr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(tr1Var, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.setMediaVolume")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 z = tr1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    hr1 hr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof hr1)) {
                            hr1Var = (hr1) obj;
                        } else {
                            hr1Var = new hr1(this.mSwanApiContext);
                            this.mApis.put("1372680763", hr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(hr1Var, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.startAccelerometer")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = hr1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    kr1 kr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof kr1)) {
                            kr1Var = (kr1) obj;
                        } else {
                            kr1Var = new kr1(this.mSwanApiContext);
                            this.mApis.put("1689255576", kr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(kr1Var, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.startCompass")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = kr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    hr1 hr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof hr1)) {
                            hr1Var = (hr1) obj;
                        } else {
                            hr1Var = new hr1(this.mSwanApiContext);
                            this.mApis.put("1372680763", hr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(hr1Var, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.stopAccelerometer")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 B = hr1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    kr1 kr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof kr1)) {
                            kr1Var = (kr1) obj;
                        } else {
                            kr1Var = new kr1(this.mSwanApiContext);
                            this.mApis.put("1689255576", kr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(kr1Var, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.stopCompass")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 z = kr1Var.z();
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    es1 es1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof es1)) {
                            es1Var = (es1) obj;
                        } else {
                            es1Var = new es1(this.mSwanApiContext);
                            this.mApis.put("201194468", es1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(es1Var, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.addToDesktop")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 B = es1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    as1 as1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof as1)) {
                            as1Var = (as1) obj;
                        } else {
                            as1Var = new as1(this.mSwanApiContext);
                            this.mApis.put("-1412306947", as1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(as1Var, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.calcMD5")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = as1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    bs1 bs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof bs1)) {
                            bs1Var = (bs1) obj;
                        } else {
                            bs1Var = new bs1(this.mSwanApiContext);
                            this.mApis.put("1626415364", bs1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(bs1Var, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.checkAppInstalled")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = bs1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    ds1 ds1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof ds1)) {
                            ds1Var = (ds1) obj;
                        } else {
                            ds1Var = new ds1(this.mSwanApiContext);
                            this.mApis.put("-836768778", ds1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(ds1Var, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfo")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = ds1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    js1 js1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof js1)) {
                            js1Var = (js1) obj;
                        } else {
                            js1Var = new js1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", js1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(js1Var, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfoSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 E = js1Var.E();
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    fs1 fs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof fs1)) {
                            fs1Var = (fs1) obj;
                        } else {
                            fs1Var = new fs1(this.mSwanApiContext);
                            this.mApis.put("-810858308", fs1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(fs1Var, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.getPerformanceLevel")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = fs1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    js1 js1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof js1)) {
                            js1Var = (js1) obj;
                        } else {
                            js1Var = new js1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", js1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(js1Var, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.getSystemInfo")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 H = js1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    js1 js1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof js1)) {
                            js1Var = (js1) obj;
                        } else {
                            js1Var = new js1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", js1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(js1Var, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.getSystemInfoAsync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 I = js1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    js1 js1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof js1)) {
                            js1Var = (js1) obj;
                        } else {
                            js1Var = new js1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", js1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(js1Var, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.getSystemInfoSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 J = js1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    gs1 gs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof gs1)) {
                            gs1Var = (gs1) obj;
                        } else {
                            gs1Var = new gs1(this.mSwanApiContext);
                            this.mApis.put("-2097727681", gs1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(gs1Var, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.handleException")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = gs1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    cs1 cs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof cs1)) {
                            cs1Var = (cs1) obj;
                        } else {
                            cs1Var = new cs1(this.mSwanApiContext);
                            this.mApis.put("2084449317", cs1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(cs1Var, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.hasCloseHandler")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = cs1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    f53 f53Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof f53)) {
                            f53Var = (f53) obj;
                        } else {
                            f53Var = new f53(this.mSwanApiContext);
                            this.mApis.put("1031678042", f53Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(f53Var, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.hideCaptureScreenShareDialog")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = f53Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    hs1 hs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof hs1)) {
                            hs1Var = (hs1) obj;
                        } else {
                            hs1Var = new hs1(this.mSwanApiContext);
                            this.mApis.put("1751900130", hs1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(hs1Var, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.logToFile")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = hs1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    g43 g43Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof g43)) {
                            g43Var = (g43) obj;
                        } else {
                            g43Var = new g43(this.mSwanApiContext);
                            this.mApis.put("1748196865", g43Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(g43Var, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.preloadPackage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = g43Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    is1 is1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof is1)) {
                            is1Var = (is1) obj;
                        } else {
                            is1Var = new is1(this.mSwanApiContext);
                            this.mApis.put("589529211", is1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(is1Var, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.previewImage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 B = is1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    ls1 ls1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof ls1)) {
                            ls1Var = (ls1) obj;
                        } else {
                            ls1Var = new ls1(this.mSwanApiContext);
                            this.mApis.put("-577481801", ls1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(ls1Var, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.ubcFlowJar")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 I = ls1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    qb3 qb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof qb3)) {
                            qb3Var = (qb3) obj;
                        } else {
                            qb3Var = new qb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", qb3Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(qb3Var, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Wifi.connectWifi")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = qb3Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    qb3 qb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof qb3)) {
                            qb3Var = (qb3) obj;
                        } else {
                            qb3Var = new qb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", qb3Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(qb3Var, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Wifi.getConnectedWifi")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 B = qb3Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    qb3 qb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof qb3)) {
                            qb3Var = (qb3) obj;
                        } else {
                            qb3Var = new qb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", qb3Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(qb3Var, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Wifi.getWifiList")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 C = qb3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    qb3 qb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof qb3)) {
                            qb3Var = (qb3) obj;
                        } else {
                            qb3Var = new qb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", qb3Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(qb3Var, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Wifi.startWifi")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 G = qb3Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    qb3 qb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof qb3)) {
                            qb3Var = (qb3) obj;
                        } else {
                            qb3Var = new qb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", qb3Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(qb3Var, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Wifi.stopWifi")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 H = qb3Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static Map<String, Object> getWebviewApiModules(final bp1 bp1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bp1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    hp1 hp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof hp1)) {
                            hp1Var = (hp1) obj;
                        } else {
                            hp1Var = new hp1(this.mSwanApiContext);
                            this.mApis.put("1930258908", hp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(hp1Var, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Account.checkSession")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = hp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ip1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(ip1Var, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Account.getLoginCode")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 C = ip1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("1754780133", jp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(jp1Var, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Account.getOpenId")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = jp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    qo1 qo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof qo1)) {
                            qo1Var = (qo1) obj;
                        } else {
                            qo1Var = new qo1(this.mSwanApiContext);
                            this.mApis.put("-343998465", qo1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(qo1Var, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Account.getUnionBDUSS")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = qo1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    gp1 gp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("-337742792", gp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(gp1Var, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Account.isBaiduAccountSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = gp1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    ip1 ip1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ip1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(ip1Var, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Account.isLoginSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 H = ip1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ip1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(ip1Var, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Account.login")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 I = ip1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    kp1 kp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof kp1)) {
                            kp1Var = (kp1) obj;
                        } else {
                            kp1Var = new kp1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", kp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(kp1Var, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Basic.loadSubPackage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 F = kp1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    kp1 kp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof kp1)) {
                            kp1Var = (kp1) obj;
                        } else {
                            kp1Var = new kp1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", kp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(kp1Var, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Basic.loadSubPackages")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 G = kp1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    rh1 rh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof rh1)) {
                            rh1Var = (rh1) obj;
                        } else {
                            rh1Var = new rh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", rh1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(rh1Var, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Bookshelf.deleteBookshelf")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 K = rh1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    rh1 rh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof rh1)) {
                            rh1Var = (rh1) obj;
                        } else {
                            rh1Var = new rh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", rh1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(rh1Var, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Bookshelf.insertBookshelf")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 P = rh1Var.P(str);
                        return P == null ? "" : P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    rh1 rh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof rh1)) {
                            rh1Var = (rh1) obj;
                        } else {
                            rh1Var = new rh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", rh1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(rh1Var, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Bookshelf.navigateToBookshelf")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 U = rh1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    rh1 rh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof rh1)) {
                            rh1Var = (rh1) obj;
                        } else {
                            rh1Var = new rh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", rh1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(rh1Var, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Bookshelf.queryBookshelf")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 V = rh1Var.V(str);
                        return V == null ? "" : V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    rh1 rh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof rh1)) {
                            rh1Var = (rh1) obj;
                        } else {
                            rh1Var = new rh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", rh1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(rh1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Bookshelf.updateBookshelfReadTime")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 X = rh1Var.X(str);
                        return X == null ? "" : X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    ep1 ep1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof ep1)) {
                            ep1Var = (ep1) obj;
                        } else {
                            ep1Var = new ep1(this.mSwanApiContext);
                            this.mApis.put("-277316359", ep1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(ep1Var, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Coupon.getPlatformCoupons")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = ep1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    ep1 ep1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof ep1)) {
                            ep1Var = (ep1) obj;
                        } else {
                            ep1Var = new ep1(this.mSwanApiContext);
                            this.mApis.put("-277316359", ep1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(ep1Var, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Coupon.getUserCoupons")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 z = ep1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    ep1 ep1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof ep1)) {
                            ep1Var = (ep1) obj;
                        } else {
                            ep1Var = new ep1(this.mSwanApiContext);
                            this.mApis.put("-277316359", ep1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(ep1Var, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Coupon.takeCoupons")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 C = ep1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    mp1 mp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof mp1)) {
                            mp1Var = (mp1) obj;
                        } else {
                            mp1Var = new mp1(this.mSwanApiContext);
                            this.mApis.put("-1225406515", mp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(mp1Var, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Favorite.getFavorStatus")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = mp1Var.x(str);
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
                        Pair<Boolean, zs1> a = bt1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Favorite.showFavoriteGuide")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 G = showFavoriteGuideApi.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    op1 op1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof op1)) {
                            op1Var = (op1) obj;
                        } else {
                            op1Var = new op1(this.mSwanApiContext);
                            this.mApis.put("-2057135077", op1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(op1Var, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "File.shareFile")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = op1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    de2 de2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof de2)) {
                            de2Var = (de2) obj;
                        } else {
                            de2Var = new de2(this.mSwanApiContext);
                            this.mApis.put("2077414795", de2Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(de2Var, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = de2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    de2 de2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof de2)) {
                            de2Var = (de2) obj;
                        } else {
                            de2Var = new de2(this.mSwanApiContext);
                            this.mApis.put("2077414795", de2Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(de2Var, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessageSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = de2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String download(String str) {
                    pp1 pp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof pp1)) {
                            pp1Var = (pp1) obj;
                        } else {
                            pp1Var = new pp1(this.mSwanApiContext);
                            this.mApis.put("-170124576", pp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(pp1Var, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "HostDownloadManager.download")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = pp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    pp1 pp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof pp1)) {
                            pp1Var = (pp1) obj;
                        } else {
                            pp1Var = new pp1(this.mSwanApiContext);
                            this.mApis.put("-170124576", pp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(pp1Var, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "HostDownloadManager.openDownloadCenter")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = pp1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    pp1 pp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof pp1)) {
                            pp1Var = (pp1) obj;
                        } else {
                            pp1Var = new pp1(this.mSwanApiContext);
                            this.mApis.put("-170124576", pp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(pp1Var, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "HostDownloadManager.openFile")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 z = pp1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    pp1 pp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof pp1)) {
                            pp1Var = (pp1) obj;
                        } else {
                            pp1Var = new pp1(this.mSwanApiContext);
                            this.mApis.put("-170124576", pp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(pp1Var, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "HostDownloadManager.query")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 query = pp1Var.query(str);
                        return query == null ? "" : query.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naImage", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    rq2 rq2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof rq2)) {
                            rq2Var = (rq2) obj;
                        } else {
                            rq2Var = new rq2(this.mSwanApiContext);
                            this.mApis.put("1445003743", rq2Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(rq2Var, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Image.callImageMenu")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = rq2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    sp1 sp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof sp1)) {
                            sp1Var = (sp1) obj;
                        } else {
                            sp1Var = new sp1(this.mSwanApiContext);
                            this.mApis.put("-1252730367", sp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(sp1Var, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Image.compressImage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = sp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    aq1 aq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof aq1)) {
                            aq1Var = (aq1) obj;
                        } else {
                            aq1Var = new aq1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", aq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(aq1Var, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.closeTabBar")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = aq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    aq1 aq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof aq1)) {
                            aq1Var = (aq1) obj;
                        } else {
                            aq1Var = new aq1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", aq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(aq1Var, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.closeTabBarRedDot")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = aq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    up1 up1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("5236036", up1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(up1Var, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.hideLoading")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = up1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    wp1 wp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof wp1)) {
                            wp1Var = (wp1) obj;
                        } else {
                            wp1Var = new wp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", wp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(wp1Var, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.hideNavigationBarLoading")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = wp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    bq1 bq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof bq1)) {
                            bq1Var = (bq1) obj;
                        } else {
                            bq1Var = new bq1(this.mSwanApiContext);
                            this.mApis.put("1159492510", bq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(bq1Var, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.hideToast")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 K = bq1Var.K();
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    yp1 yp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof yp1)) {
                            yp1Var = (yp1) obj;
                        } else {
                            yp1Var = new yp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", yp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(yp1Var, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.openMultiPicker")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 G = yp1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    yp1 yp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof yp1)) {
                            yp1Var = (yp1) obj;
                        } else {
                            yp1Var = new yp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", yp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(yp1Var, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.openPicker")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 H = yp1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    aq1 aq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof aq1)) {
                            aq1Var = (aq1) obj;
                        } else {
                            aq1Var = new aq1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", aq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(aq1Var, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.openTabBar")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 C = aq1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    xp1 xp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof xp1)) {
                            xp1Var = (xp1) obj;
                        } else {
                            xp1Var = new xp1(this.mSwanApiContext);
                            this.mApis.put("-1750613704", xp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(xp1Var, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.pageScrollTo")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = xp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    wp1 wp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof wp1)) {
                            wp1Var = (wp1) obj;
                        } else {
                            wp1Var = new wp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", wp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(wp1Var, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarColor")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 z = wp1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    wp1 wp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof wp1)) {
                            wp1Var = (wp1) obj;
                        } else {
                            wp1Var = new wp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", wp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(wp1Var, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarTitle")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = wp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    aq1 aq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof aq1)) {
                            aq1Var = (aq1) obj;
                        } else {
                            aq1Var = new aq1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", aq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(aq1Var, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.setTabBarItem")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 D = aq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    yp1 yp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof yp1)) {
                            yp1Var = (yp1) obj;
                        } else {
                            yp1Var = new yp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", yp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(yp1Var, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.showDatePickerView")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 L = yp1Var.L(str);
                        return L == null ? "" : L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    cq1 cq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof cq1)) {
                            cq1Var = (cq1) obj;
                        } else {
                            cq1Var = new cq1(this.mSwanApiContext);
                            this.mApis.put("1172469410", cq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(cq1Var, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.showHalfScreenWebview")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 K = cq1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    up1 up1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("5236036", up1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(up1Var, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.showLoading")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = up1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    vp1 vp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof vp1)) {
                            vp1Var = (vp1) obj;
                        } else {
                            vp1Var = new vp1(this.mSwanApiContext);
                            this.mApis.put("1913747800", vp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(vp1Var, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.showModal")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = vp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    wp1 wp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof wp1)) {
                            wp1Var = (wp1) obj;
                        } else {
                            wp1Var = new wp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", wp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(wp1Var, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.showNavigationBarLoading")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 B = wp1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    bq1 bq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof bq1)) {
                            bq1Var = (bq1) obj;
                        } else {
                            bq1Var = new bq1(this.mSwanApiContext);
                            this.mApis.put("1159492510", bq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(bq1Var, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.showToast")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 Q = bq1Var.Q(str);
                        return Q == null ? "" : Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    zp1 zp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof zp1)) {
                            zp1Var = (zp1) obj;
                        } else {
                            zp1Var = new zp1(this.mSwanApiContext);
                            this.mApis.put("1165118609", zp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(zp1Var, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.stopPullDownRefresh")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = zp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    yp1 yp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof yp1)) {
                            yp1Var = (yp1) obj;
                        } else {
                            yp1Var = new yp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", yp1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(yp1Var, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Interaction.updateMultiPicker")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 M = yp1Var.M(str);
                        return M == null ? "" : M.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    dq1 dq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof dq1)) {
                            dq1Var = (dq1) obj;
                        } else {
                            dq1Var = new dq1(this.mSwanApiContext);
                            this.mApis.put("-137346255", dq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(dq1Var, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Keyboard.startKeyboardHeightChange")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 C = dq1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    dq1 dq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof dq1)) {
                            dq1Var = (dq1) obj;
                        } else {
                            dq1Var = new dq1(this.mSwanApiContext);
                            this.mApis.put("-137346255", dq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(dq1Var, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Keyboard.stopKeyboardHeightChange")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 D = dq1Var.D();
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    eq1 eq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof eq1)) {
                            eq1Var = (eq1) obj;
                        } else {
                            eq1Var = new eq1(this.mSwanApiContext);
                            this.mApis.put("-397373095", eq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(eq1Var, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "LocationService.getLocation")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = eq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    eq1 eq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof eq1)) {
                            eq1Var = (eq1) obj;
                        } else {
                            eq1Var = new eq1(this.mSwanApiContext);
                            this.mApis.put("-397373095", eq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(eq1Var, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "LocationService.startLocationUpdate")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = eq1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    eq1 eq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof eq1)) {
                            eq1Var = (eq1) obj;
                        } else {
                            eq1Var = new eq1(this.mSwanApiContext);
                            this.mApis.put("-397373095", eq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(eq1Var, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "LocationService.stopLocationUpdate")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 B = eq1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    vr1 vr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof vr1)) {
                            vr1Var = (vr1) obj;
                        } else {
                            vr1Var = new vr1(this.mSwanApiContext);
                            this.mApis.put("538070032", vr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(vr1Var, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = vr1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String callService(String str) {
                    hq1 hq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof hq1)) {
                            hq1Var = (hq1) obj;
                        } else {
                            hq1Var = new hq1(this.mSwanApiContext);
                            this.mApis.put("-1076509454", hq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(hq1Var, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Network.callService")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = hq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    oq1 oq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof oq1)) {
                            oq1Var = (oq1) obj;
                        } else {
                            oq1Var = new oq1(this.mSwanApiContext);
                            this.mApis.put("968563034", oq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(oq1Var, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Network.cancelRequest")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 D = oq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    nq1 nq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof nq1)) {
                            nq1Var = (nq1) obj;
                        } else {
                            nq1Var = new nq1(this.mSwanApiContext);
                            this.mApis.put("453220699", nq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(nq1Var, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Network.getNetworkType")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = nq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    nq1 nq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof nq1)) {
                            nq1Var = (nq1) obj;
                        } else {
                            nq1Var = new nq1(this.mSwanApiContext);
                            this.mApis.put("453220699", nq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(nq1Var, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Network.networkStatusChange")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = nq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                @JavascriptInterface
                public String request(String str) {
                    InterceptResult invokeL2;
                    oq1 oq1Var;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && (invokeL2 = interceptable2.invokeL(1048580, this, str)) != null) {
                        return (String) invokeL2.objValue;
                    }
                    try {
                        ys1.c().a("request");
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof oq1)) {
                            oq1Var = (oq1) obj;
                        } else {
                            oq1Var = new oq1(this.mSwanApiContext);
                            this.mApis.put("968563034", oq1Var);
                        }
                        Pair<Boolean, zs1> a2 = bt1.a(oq1Var, "swanAPI/request");
                        if (((Boolean) a2.first).booleanValue()) {
                            a = ((zs1) a2.second).a();
                        } else if (h32.a(this.mSwanApiContext.e(), "Network.request")) {
                            a = new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        } else {
                            Pair<zs1, JSONObject> u = dp1.u(str);
                            if (!((zs1) u.first).isSuccess()) {
                                a = ((zs1) u.first).a();
                            } else {
                                JSONObject jSONObject = (JSONObject) u.second;
                                if (jSONObject == null) {
                                    a = zs1.a.a();
                                } else {
                                    at1 V = oq1Var.V(jSONObject);
                                    a = V == null ? "" : V.a();
                                }
                            }
                        }
                        return a;
                    } finally {
                    }
                }
            });
            hashMap.put("_naPayment", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    xt2 xt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof xt2)) {
                            xt2Var = (xt2) obj;
                        } else {
                            xt2Var = new xt2(this.mSwanApiContext);
                            this.mApis.put("-336396851", xt2Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(xt2Var, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Payment.chooseCoupon")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = xt2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    xt2 xt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof xt2)) {
                            xt2Var = (xt2) obj;
                        } else {
                            xt2Var = new xt2(this.mSwanApiContext);
                            this.mApis.put("-336396851", xt2Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(xt2Var, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Payment.getPaymentInfo")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = xt2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    nt2 nt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof nt2)) {
                            nt2Var = (nt2) obj;
                        } else {
                            nt2Var = new nt2(this.mSwanApiContext);
                            this.mApis.put("1854689529", nt2Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(nt2Var, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Payment.requestThirdPayment")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = nt2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    xt2 xt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof xt2)) {
                            xt2Var = (xt2) obj;
                        } else {
                            xt2Var = new xt2(this.mSwanApiContext);
                            this.mApis.put("-336396851", xt2Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(xt2Var, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Payment.setPaymentInfo")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 z = xt2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    iw2 iw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof iw2)) {
                            iw2Var = (iw2) obj;
                        } else {
                            iw2Var = new iw2(this.mSwanApiContext);
                            this.mApis.put("-254510461", iw2Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(iw2Var, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Plugin.invokePluginChooseAddress")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = iw2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    iw2 iw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof iw2)) {
                            iw2Var = (iw2) obj;
                        } else {
                            iw2Var = new iw2(this.mSwanApiContext);
                            this.mApis.put("-254510461", iw2Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(iw2Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 z = iw2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    iw2 iw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof iw2)) {
                            iw2Var = (iw2) obj;
                        } else {
                            iw2Var = new iw2(this.mSwanApiContext);
                            this.mApis.put("-254510461", iw2Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(iw2Var, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Plugin.invokePluginPayment")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = iw2Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    b52 b52Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof b52)) {
                            b52Var = (b52) obj;
                        } else {
                            b52Var = new b52(this.mSwanApiContext);
                            this.mApis.put("-2068479848", b52Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(b52Var, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Prefetch.prefetchResources")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = b52Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    t32 t32Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof t32)) {
                            t32Var = (t32) obj;
                        } else {
                            t32Var = new t32(this.mSwanApiContext);
                            this.mApis.put("423661539", t32Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(t32Var, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Preload.preloadStatus")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = t32Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    dd3 dd3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof dd3)) {
                            dd3Var = (dd3) obj;
                        } else {
                            dd3Var = new dd3(this.mSwanApiContext);
                            this.mApis.put("-1929343869", dd3Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(dd3Var, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "PrivateFile.uploadFileToBos")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 C = dd3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    sq1 sq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof sq1)) {
                            sq1Var = (sq1) obj;
                        } else {
                            sq1Var = new sq1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", sq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(sq1Var, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Router.hideModalPage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = sq1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    sq1 sq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof sq1)) {
                            sq1Var = (sq1) obj;
                        } else {
                            sq1Var = new sq1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", sq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(sq1Var, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Router.navigateBack")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 B = sq1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    tq1 tq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof tq1)) {
                            tq1Var = (tq1) obj;
                        } else {
                            tq1Var = new tq1(this.mSwanApiContext);
                            this.mApis.put("1968522584", tq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(tq1Var, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Router.navigateTo")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 H = tq1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    vq1 vq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("1317280190", vq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(vq1Var, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Router.reLaunch")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = vq1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    wq1 wq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof wq1)) {
                            wq1Var = (wq1) obj;
                        } else {
                            wq1Var = new wq1(this.mSwanApiContext);
                            this.mApis.put("-420075743", wq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(wq1Var, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Router.reLoadErrorPage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = wq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    uq1 uq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof uq1)) {
                            uq1Var = (uq1) obj;
                        } else {
                            uq1Var = new uq1(this.mSwanApiContext);
                            this.mApis.put("1792515533", uq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(uq1Var, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Router.redirectTo")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 D = uq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    tq1 tq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof tq1)) {
                            tq1Var = (tq1) obj;
                        } else {
                            tq1Var = new tq1(this.mSwanApiContext);
                            this.mApis.put("1968522584", tq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(tq1Var, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Router.showModalPage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 J = tq1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    zq1 zq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof zq1)) {
                            zq1Var = (zq1) obj;
                        } else {
                            zq1Var = new zq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", zq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(zq1Var, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Setting.getAppInfoSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 F = zq1Var.F();
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    zq1 zq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof zq1)) {
                            zq1Var = (zq1) obj;
                        } else {
                            zq1Var = new zq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", zq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(zq1Var, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Setting.getSetting")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 G = zq1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    zq1 zq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof zq1)) {
                            zq1Var = (zq1) obj;
                        } else {
                            zq1Var = new zq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", zq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(zq1Var, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Setting.getSlaveIdSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 H = zq1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    zq1 zq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof zq1)) {
                            zq1Var = (zq1) obj;
                        } else {
                            zq1Var = new zq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", zq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(zq1Var, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Setting.getSwanId")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 I = zq1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    zq1 zq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof zq1)) {
                            zq1Var = (zq1) obj;
                        } else {
                            zq1Var = new zq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", zq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(zq1Var, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Setting.getUserInfo")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 J = zq1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    yq1 yq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof yq1)) {
                            yq1Var = (yq1) obj;
                        } else {
                            yq1Var = new yq1(this.mSwanApiContext);
                            this.mApis.put("450273045", yq1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(yq1Var, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Setting.isAllowedAdOpenAppSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = yq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    x73 x73Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof x73)) {
                            x73Var = (x73) obj;
                        } else {
                            x73Var = new x73(this.mSwanApiContext);
                            this.mApis.put("712777136", x73Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(x73Var, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = x73Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    cr1 cr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("-804054859", cr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(cr1Var, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = cr1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    cr1 cr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("-804054859", cr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(cr1Var, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorageSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 C = cr1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    br1 br1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("130910081", br1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(br1Var, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.clearStorage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = br1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    br1 br1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("130910081", br1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(br1Var, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.clearStorageSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 C = br1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    cr1 cr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("-804054859", cr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(cr1Var, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.getGlobalStorage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 D = cr1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    cr1 cr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("-804054859", cr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(cr1Var, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfo")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 G = cr1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    cr1 cr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("-804054859", cr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(cr1Var, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfoSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 J = cr1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    cr1 cr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("-804054859", cr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(cr1Var, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 K = cr1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("130910081", br1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(br1Var, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.getStorage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 D = br1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    br1 br1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("130910081", br1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(br1Var, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.getStorageInfo")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 G = br1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("130910081", br1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(br1Var, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.getStorageInfoAsync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 H = br1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    br1 br1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("130910081", br1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(br1Var, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.getStorageInfoSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 J = br1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("130910081", br1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(br1Var, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.getStorageSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 K = br1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    cr1 cr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("-804054859", cr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(cr1Var, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 R = cr1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    cr1 cr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("-804054859", cr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(cr1Var, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorageSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 T = cr1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("130910081", br1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(br1Var, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.removeStorage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 R = br1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("130910081", br1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(br1Var, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.removeStorageSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 T = br1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    cr1 cr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("-804054859", cr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(cr1Var, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.setGlobalStorage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 U = cr1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    cr1 cr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("-804054859", cr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(cr1Var, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.setGlobalStorageSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 W = cr1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("130910081", br1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(br1Var, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.setStorage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 U = br1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("130910081", br1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(br1Var, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Storage.setStorageSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 W = br1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    er1 er1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof er1)) {
                            er1Var = (er1) obj;
                        } else {
                            er1Var = new er1(this.mSwanApiContext);
                            this.mApis.put("823117982", er1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(er1Var, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Subscription.requestSubscribeFormId")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 E = er1Var.E(str);
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    fr1 fr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof fr1)) {
                            fr1Var = (fr1) obj;
                        } else {
                            fr1Var = new fr1(this.mSwanApiContext);
                            this.mApis.put("-947445811", fr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(fr1Var, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Subscription.subscribeService")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 F = fr1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    mr1 mr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof mr1)) {
                            mr1Var = (mr1) obj;
                        } else {
                            mr1Var = new mr1(this.mSwanApiContext);
                            this.mApis.put("1936205521", mr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(mr1Var, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.exitFullScreen")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = mr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    ir1 ir1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof ir1)) {
                            ir1Var = (ir1) obj;
                        } else {
                            ir1Var = new ir1(this.mSwanApiContext);
                            this.mApis.put("99997465", ir1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(ir1Var, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.getBrightness")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = ir1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    jr1 jr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof jr1)) {
                            jr1Var = (jr1) obj;
                        } else {
                            jr1Var = new jr1(this.mSwanApiContext);
                            this.mApis.put("-518757484", jr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(jr1Var, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.getClipboardData")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = jr1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    lr1 lr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof lr1)) {
                            lr1Var = (lr1) obj;
                        } else {
                            lr1Var = new lr1(this.mSwanApiContext);
                            this.mApis.put("1694151270", lr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(lr1Var, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.getDeviceInfo")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = lr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    nr1 nr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof nr1)) {
                            nr1Var = (nr1) obj;
                        } else {
                            nr1Var = new nr1(this.mSwanApiContext);
                            this.mApis.put("-1321681619", nr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(nr1Var, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.getDeviceProfile")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = nr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    tr1 tr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof tr1)) {
                            tr1Var = (tr1) obj;
                        } else {
                            tr1Var = new tr1(this.mSwanApiContext);
                            this.mApis.put("447234992", tr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(tr1Var, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.getMediaVolume")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = tr1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    or1 or1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof or1)) {
                            or1Var = (or1) obj;
                        } else {
                            or1Var = new or1(this.mSwanApiContext);
                            this.mApis.put("-1569246082", or1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(or1Var, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.makePhoneCall")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = or1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    qr1 qr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof qr1)) {
                            qr1Var = (qr1) obj;
                        } else {
                            qr1Var = new qr1(this.mSwanApiContext);
                            this.mApis.put("1099851202", qr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(qr1Var, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.openSMSPanel")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = qr1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    pr1 pr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof pr1)) {
                            pr1Var = (pr1) obj;
                        } else {
                            pr1Var = new pr1(this.mSwanApiContext);
                            this.mApis.put("-1707203360", pr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(pr1Var, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.requestFullScreen")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 F = pr1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    jr1 jr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof jr1)) {
                            jr1Var = (jr1) obj;
                        } else {
                            jr1Var = new jr1(this.mSwanApiContext);
                            this.mApis.put("-518757484", jr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(jr1Var, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.setClipboardData")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = jr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    tq2 tq2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof tq2)) {
                            tq2Var = (tq2) obj;
                        } else {
                            tq2Var = new tq2(this.mSwanApiContext);
                            this.mApis.put("1161486049", tq2Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(tq2Var, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.setErrorPageType")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = tq2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    tr1 tr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof tr1)) {
                            tr1Var = (tr1) obj;
                        } else {
                            tr1Var = new tr1(this.mSwanApiContext);
                            this.mApis.put("447234992", tr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(tr1Var, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.setMediaVolume")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 z = tr1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    hr1 hr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof hr1)) {
                            hr1Var = (hr1) obj;
                        } else {
                            hr1Var = new hr1(this.mSwanApiContext);
                            this.mApis.put("1372680763", hr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(hr1Var, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.startAccelerometer")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = hr1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    kr1 kr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof kr1)) {
                            kr1Var = (kr1) obj;
                        } else {
                            kr1Var = new kr1(this.mSwanApiContext);
                            this.mApis.put("1689255576", kr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(kr1Var, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.startCompass")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = kr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    hr1 hr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof hr1)) {
                            hr1Var = (hr1) obj;
                        } else {
                            hr1Var = new hr1(this.mSwanApiContext);
                            this.mApis.put("1372680763", hr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(hr1Var, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.stopAccelerometer")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 B = hr1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    kr1 kr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof kr1)) {
                            kr1Var = (kr1) obj;
                        } else {
                            kr1Var = new kr1(this.mSwanApiContext);
                            this.mApis.put("1689255576", kr1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(kr1Var, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "System.stopCompass")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 z = kr1Var.z();
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    es1 es1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof es1)) {
                            es1Var = (es1) obj;
                        } else {
                            es1Var = new es1(this.mSwanApiContext);
                            this.mApis.put("201194468", es1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(es1Var, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.addToDesktop")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 B = es1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    as1 as1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof as1)) {
                            as1Var = (as1) obj;
                        } else {
                            as1Var = new as1(this.mSwanApiContext);
                            this.mApis.put("-1412306947", as1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(as1Var, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.calcMD5")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = as1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    bs1 bs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof bs1)) {
                            bs1Var = (bs1) obj;
                        } else {
                            bs1Var = new bs1(this.mSwanApiContext);
                            this.mApis.put("1626415364", bs1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(bs1Var, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.checkAppInstalled")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = bs1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    ds1 ds1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof ds1)) {
                            ds1Var = (ds1) obj;
                        } else {
                            ds1Var = new ds1(this.mSwanApiContext);
                            this.mApis.put("-836768778", ds1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(ds1Var, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfo")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = ds1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    js1 js1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof js1)) {
                            js1Var = (js1) obj;
                        } else {
                            js1Var = new js1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", js1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(js1Var, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfoSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 E = js1Var.E();
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    fs1 fs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof fs1)) {
                            fs1Var = (fs1) obj;
                        } else {
                            fs1Var = new fs1(this.mSwanApiContext);
                            this.mApis.put("-810858308", fs1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(fs1Var, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.getPerformanceLevel")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = fs1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    js1 js1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof js1)) {
                            js1Var = (js1) obj;
                        } else {
                            js1Var = new js1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", js1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(js1Var, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.getSystemInfo")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 H = js1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    js1 js1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof js1)) {
                            js1Var = (js1) obj;
                        } else {
                            js1Var = new js1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", js1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(js1Var, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.getSystemInfoAsync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 I = js1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    js1 js1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof js1)) {
                            js1Var = (js1) obj;
                        } else {
                            js1Var = new js1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", js1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(js1Var, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.getSystemInfoSync")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 J = js1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    gs1 gs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof gs1)) {
                            gs1Var = (gs1) obj;
                        } else {
                            gs1Var = new gs1(this.mSwanApiContext);
                            this.mApis.put("-2097727681", gs1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(gs1Var, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.handleException")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = gs1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    cs1 cs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof cs1)) {
                            cs1Var = (cs1) obj;
                        } else {
                            cs1Var = new cs1(this.mSwanApiContext);
                            this.mApis.put("2084449317", cs1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(cs1Var, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.hasCloseHandler")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = cs1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    f53 f53Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof f53)) {
                            f53Var = (f53) obj;
                        } else {
                            f53Var = new f53(this.mSwanApiContext);
                            this.mApis.put("1031678042", f53Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(f53Var, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.hideCaptureScreenShareDialog")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 x = f53Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    hs1 hs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof hs1)) {
                            hs1Var = (hs1) obj;
                        } else {
                            hs1Var = new hs1(this.mSwanApiContext);
                            this.mApis.put("1751900130", hs1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(hs1Var, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.logToFile")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = hs1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    g43 g43Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof g43)) {
                            g43Var = (g43) obj;
                        } else {
                            g43Var = new g43(this.mSwanApiContext);
                            this.mApis.put("1748196865", g43Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(g43Var, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.preloadPackage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = g43Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    is1 is1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof is1)) {
                            is1Var = (is1) obj;
                        } else {
                            is1Var = new is1(this.mSwanApiContext);
                            this.mApis.put("589529211", is1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(is1Var, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.previewImage")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 B = is1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    ls1 ls1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof ls1)) {
                            ls1Var = (ls1) obj;
                        } else {
                            ls1Var = new ls1(this.mSwanApiContext);
                            this.mApis.put("-577481801", ls1Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(ls1Var, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Utils.ubcFlowJar")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 I = ls1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    qb3 qb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof qb3)) {
                            qb3Var = (qb3) obj;
                        } else {
                            qb3Var = new qb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", qb3Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(qb3Var, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Wifi.connectWifi")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 A = qb3Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    qb3 qb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof qb3)) {
                            qb3Var = (qb3) obj;
                        } else {
                            qb3Var = new qb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", qb3Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(qb3Var, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Wifi.getConnectedWifi")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 B = qb3Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    qb3 qb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof qb3)) {
                            qb3Var = (qb3) obj;
                        } else {
                            qb3Var = new qb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", qb3Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(qb3Var, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Wifi.getWifiList")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 C = qb3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    qb3 qb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof qb3)) {
                            qb3Var = (qb3) obj;
                        } else {
                            qb3Var = new qb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", qb3Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(qb3Var, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Wifi.startWifi")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 G = qb3Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    qb3 qb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof qb3)) {
                            qb3Var = (qb3) obj;
                        } else {
                            qb3Var = new qb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", qb3Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(qb3Var, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "Wifi.stopWifi")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 H = qb3Var.H(str);
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
