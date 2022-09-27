package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.tieba.as1;
import com.baidu.tieba.au1;
import com.baidu.tieba.be3;
import com.baidu.tieba.br1;
import com.baidu.tieba.bu1;
import com.baidu.tieba.ck1;
import com.baidu.tieba.ct2;
import com.baidu.tieba.ds1;
import com.baidu.tieba.dt1;
import com.baidu.tieba.e62;
import com.baidu.tieba.et1;
import com.baidu.tieba.et2;
import com.baidu.tieba.eu1;
import com.baidu.tieba.fs1;
import com.baidu.tieba.ft1;
import com.baidu.tieba.gs1;
import com.baidu.tieba.gt1;
import com.baidu.tieba.gu1;
import com.baidu.tieba.hs1;
import com.baidu.tieba.ht1;
import com.baidu.tieba.ia3;
import com.baidu.tieba.is1;
import com.baidu.tieba.iw2;
import com.baidu.tieba.js1;
import com.baidu.tieba.jt1;
import com.baidu.tieba.jv1;
import com.baidu.tieba.ks1;
import com.baidu.tieba.kt1;
import com.baidu.tieba.kv1;
import com.baidu.tieba.ls1;
import com.baidu.tieba.lu1;
import com.baidu.tieba.lv1;
import com.baidu.tieba.m72;
import com.baidu.tieba.mr1;
import com.baidu.tieba.ms1;
import com.baidu.tieba.mt1;
import com.baidu.tieba.mu1;
import com.baidu.tieba.mv1;
import com.baidu.tieba.ns1;
import com.baidu.tieba.nt1;
import com.baidu.tieba.nu1;
import com.baidu.tieba.of3;
import com.baidu.tieba.og2;
import com.baidu.tieba.or1;
import com.baidu.tieba.os1;
import com.baidu.tieba.ou1;
import com.baidu.tieba.pr1;
import com.baidu.tieba.ps1;
import com.baidu.tieba.pt1;
import com.baidu.tieba.pu1;
import com.baidu.tieba.q73;
import com.baidu.tieba.qt1;
import com.baidu.tieba.qu1;
import com.baidu.tieba.r63;
import com.baidu.tieba.rr1;
import com.baidu.tieba.ru1;
import com.baidu.tieba.s52;
import com.baidu.tieba.sr1;
import com.baidu.tieba.ss1;
import com.baidu.tieba.st1;
import com.baidu.tieba.su1;
import com.baidu.tieba.tr1;
import com.baidu.tieba.tt1;
import com.baidu.tieba.tu1;
import com.baidu.tieba.ty2;
import com.baidu.tieba.ur1;
import com.baidu.tieba.ut1;
import com.baidu.tieba.uu1;
import com.baidu.tieba.vr1;
import com.baidu.tieba.vt1;
import com.baidu.tieba.wt1;
import com.baidu.tieba.wu1;
import com.baidu.tieba.xr1;
import com.baidu.tieba.xt1;
import com.baidu.tieba.ys1;
import com.baidu.tieba.yt1;
import com.baidu.tieba.yv2;
import com.baidu.tieba.zr1;
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

    public static Map<String, Object> getV8ApiModules(final mr1 mr1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, mr1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    sr1 sr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof sr1)) {
                            sr1Var = (sr1) obj;
                        } else {
                            sr1Var = new sr1(this.mSwanApiContext);
                            this.mApis.put("1930258908", sr1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(sr1Var, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Account.checkSession")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = sr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    tr1 tr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof tr1)) {
                            tr1Var = (tr1) obj;
                        } else {
                            tr1Var = new tr1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", tr1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(tr1Var, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Account.getLoginCode")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 C = tr1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    ur1 ur1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof ur1)) {
                            ur1Var = (ur1) obj;
                        } else {
                            ur1Var = new ur1(this.mSwanApiContext);
                            this.mApis.put("1754780133", ur1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ur1Var, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Account.getOpenId")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = ur1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-343998465", br1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(br1Var, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Account.getUnionBDUSS")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = br1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    rr1 rr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof rr1)) {
                            rr1Var = (rr1) obj;
                        } else {
                            rr1Var = new rr1(this.mSwanApiContext);
                            this.mApis.put("-337742792", rr1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(rr1Var, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Account.isBaiduAccountSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = rr1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    tr1 tr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof tr1)) {
                            tr1Var = (tr1) obj;
                        } else {
                            tr1Var = new tr1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", tr1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(tr1Var, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Account.isLoginSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 H = tr1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    tr1 tr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof tr1)) {
                            tr1Var = (tr1) obj;
                        } else {
                            tr1Var = new tr1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", tr1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(tr1Var, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Account.login")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 I = tr1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    vr1 vr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof vr1)) {
                            vr1Var = (vr1) obj;
                        } else {
                            vr1Var = new vr1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", vr1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(vr1Var, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Basic.loadSubPackage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 F = vr1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    vr1 vr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof vr1)) {
                            vr1Var = (vr1) obj;
                        } else {
                            vr1Var = new vr1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", vr1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(vr1Var, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Basic.loadSubPackages")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 G = vr1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    ck1 ck1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof ck1)) {
                            ck1Var = (ck1) obj;
                        } else {
                            ck1Var = new ck1(this.mSwanApiContext);
                            this.mApis.put("1460300387", ck1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ck1Var, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Bookshelf.deleteBookshelf")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 K = ck1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    ck1 ck1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof ck1)) {
                            ck1Var = (ck1) obj;
                        } else {
                            ck1Var = new ck1(this.mSwanApiContext);
                            this.mApis.put("1460300387", ck1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ck1Var, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Bookshelf.insertBookshelf")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 P = ck1Var.P(str);
                        return P == null ? "" : P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    ck1 ck1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof ck1)) {
                            ck1Var = (ck1) obj;
                        } else {
                            ck1Var = new ck1(this.mSwanApiContext);
                            this.mApis.put("1460300387", ck1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ck1Var, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Bookshelf.navigateToBookshelf")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 U = ck1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    ck1 ck1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof ck1)) {
                            ck1Var = (ck1) obj;
                        } else {
                            ck1Var = new ck1(this.mSwanApiContext);
                            this.mApis.put("1460300387", ck1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ck1Var, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Bookshelf.queryBookshelf")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 V = ck1Var.V(str);
                        return V == null ? "" : V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    ck1 ck1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof ck1)) {
                            ck1Var = (ck1) obj;
                        } else {
                            ck1Var = new ck1(this.mSwanApiContext);
                            this.mApis.put("1460300387", ck1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ck1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Bookshelf.updateBookshelfReadTime")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 X = ck1Var.X(str);
                        return X == null ? "" : X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    pr1 pr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof pr1)) {
                            pr1Var = (pr1) obj;
                        } else {
                            pr1Var = new pr1(this.mSwanApiContext);
                            this.mApis.put("-277316359", pr1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(pr1Var, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Coupon.getPlatformCoupons")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = pr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    pr1 pr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof pr1)) {
                            pr1Var = (pr1) obj;
                        } else {
                            pr1Var = new pr1(this.mSwanApiContext);
                            this.mApis.put("-277316359", pr1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(pr1Var, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Coupon.getUserCoupons")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 z = pr1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    pr1 pr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof pr1)) {
                            pr1Var = (pr1) obj;
                        } else {
                            pr1Var = new pr1(this.mSwanApiContext);
                            this.mApis.put("-277316359", pr1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(pr1Var, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Coupon.takeCoupons")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 C = pr1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    xr1 xr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof xr1)) {
                            xr1Var = (xr1) obj;
                        } else {
                            xr1Var = new xr1(this.mSwanApiContext);
                            this.mApis.put("-1225406515", xr1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(xr1Var, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Favorite.getFavorStatus")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = xr1Var.x(str);
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
                        Pair<Boolean, kv1> a = mv1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Favorite.showFavoriteGuide")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 G = showFavoriteGuideApi.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    zr1 zr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof zr1)) {
                            zr1Var = (zr1) obj;
                        } else {
                            zr1Var = new zr1(this.mSwanApiContext);
                            this.mApis.put("-2057135077", zr1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(zr1Var, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "File.shareFile")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = zr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    og2 og2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof og2)) {
                            og2Var = (og2) obj;
                        } else {
                            og2Var = new og2(this.mSwanApiContext);
                            this.mApis.put("2077414795", og2Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(og2Var, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = og2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    og2 og2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof og2)) {
                            og2Var = (og2) obj;
                        } else {
                            og2Var = new og2(this.mSwanApiContext);
                            this.mApis.put("2077414795", og2Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(og2Var, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessageSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = og2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String download(String str) {
                    as1 as1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof as1)) {
                            as1Var = (as1) obj;
                        } else {
                            as1Var = new as1(this.mSwanApiContext);
                            this.mApis.put("-170124576", as1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(as1Var, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "HostDownloadManager.download")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = as1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    as1 as1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof as1)) {
                            as1Var = (as1) obj;
                        } else {
                            as1Var = new as1(this.mSwanApiContext);
                            this.mApis.put("-170124576", as1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(as1Var, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "HostDownloadManager.openDownloadCenter")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = as1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    as1 as1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof as1)) {
                            as1Var = (as1) obj;
                        } else {
                            as1Var = new as1(this.mSwanApiContext);
                            this.mApis.put("-170124576", as1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(as1Var, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "HostDownloadManager.openFile")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 z = as1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    as1 as1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof as1)) {
                            as1Var = (as1) obj;
                        } else {
                            as1Var = new as1(this.mSwanApiContext);
                            this.mApis.put("-170124576", as1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(as1Var, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "HostDownloadManager.query")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 query = as1Var.query(str);
                        return query == null ? "" : query.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naImage", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    ct2 ct2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof ct2)) {
                            ct2Var = (ct2) obj;
                        } else {
                            ct2Var = new ct2(this.mSwanApiContext);
                            this.mApis.put("1445003743", ct2Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ct2Var, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Image.callImageMenu")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = ct2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    ds1 ds1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof ds1)) {
                            ds1Var = (ds1) obj;
                        } else {
                            ds1Var = new ds1(this.mSwanApiContext);
                            this.mApis.put("-1252730367", ds1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ds1Var, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Image.compressImage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = ds1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    ls1 ls1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ls1)) {
                            ls1Var = (ls1) obj;
                        } else {
                            ls1Var = new ls1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ls1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ls1Var, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.closeTabBar")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = ls1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    ls1 ls1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ls1)) {
                            ls1Var = (ls1) obj;
                        } else {
                            ls1Var = new ls1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ls1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ls1Var, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.closeTabBarRedDot")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = ls1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    fs1 fs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof fs1)) {
                            fs1Var = (fs1) obj;
                        } else {
                            fs1Var = new fs1(this.mSwanApiContext);
                            this.mApis.put("5236036", fs1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(fs1Var, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.hideLoading")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = fs1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    hs1 hs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof hs1)) {
                            hs1Var = (hs1) obj;
                        } else {
                            hs1Var = new hs1(this.mSwanApiContext);
                            this.mApis.put("-246386074", hs1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(hs1Var, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.hideNavigationBarLoading")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = hs1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    ms1 ms1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof ms1)) {
                            ms1Var = (ms1) obj;
                        } else {
                            ms1Var = new ms1(this.mSwanApiContext);
                            this.mApis.put("1159492510", ms1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ms1Var, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.hideToast")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 K = ms1Var.K();
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    js1 js1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof js1)) {
                            js1Var = (js1) obj;
                        } else {
                            js1Var = new js1(this.mSwanApiContext);
                            this.mApis.put("-108978463", js1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(js1Var, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.openMultiPicker")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 G = js1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    js1 js1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof js1)) {
                            js1Var = (js1) obj;
                        } else {
                            js1Var = new js1(this.mSwanApiContext);
                            this.mApis.put("-108978463", js1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(js1Var, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.openPicker")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 H = js1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    ls1 ls1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ls1)) {
                            ls1Var = (ls1) obj;
                        } else {
                            ls1Var = new ls1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ls1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ls1Var, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.openTabBar")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 C = ls1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    is1 is1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof is1)) {
                            is1Var = (is1) obj;
                        } else {
                            is1Var = new is1(this.mSwanApiContext);
                            this.mApis.put("-1750613704", is1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(is1Var, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.pageScrollTo")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = is1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    hs1 hs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof hs1)) {
                            hs1Var = (hs1) obj;
                        } else {
                            hs1Var = new hs1(this.mSwanApiContext);
                            this.mApis.put("-246386074", hs1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(hs1Var, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarColor")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 z = hs1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    hs1 hs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof hs1)) {
                            hs1Var = (hs1) obj;
                        } else {
                            hs1Var = new hs1(this.mSwanApiContext);
                            this.mApis.put("-246386074", hs1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(hs1Var, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarTitle")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = hs1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    ls1 ls1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ls1)) {
                            ls1Var = (ls1) obj;
                        } else {
                            ls1Var = new ls1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ls1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ls1Var, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.setTabBarItem")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 D = ls1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    js1 js1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof js1)) {
                            js1Var = (js1) obj;
                        } else {
                            js1Var = new js1(this.mSwanApiContext);
                            this.mApis.put("-108978463", js1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(js1Var, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.showDatePickerView")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 L = js1Var.L(str);
                        return L == null ? "" : L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    ns1 ns1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof ns1)) {
                            ns1Var = (ns1) obj;
                        } else {
                            ns1Var = new ns1(this.mSwanApiContext);
                            this.mApis.put("1172469410", ns1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ns1Var, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.showHalfScreenWebview")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 K = ns1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    fs1 fs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof fs1)) {
                            fs1Var = (fs1) obj;
                        } else {
                            fs1Var = new fs1(this.mSwanApiContext);
                            this.mApis.put("5236036", fs1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(fs1Var, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.showLoading")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = fs1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    gs1 gs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof gs1)) {
                            gs1Var = (gs1) obj;
                        } else {
                            gs1Var = new gs1(this.mSwanApiContext);
                            this.mApis.put("1913747800", gs1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(gs1Var, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.showModal")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = gs1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    hs1 hs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof hs1)) {
                            hs1Var = (hs1) obj;
                        } else {
                            hs1Var = new hs1(this.mSwanApiContext);
                            this.mApis.put("-246386074", hs1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(hs1Var, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.showNavigationBarLoading")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 B = hs1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    ms1 ms1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof ms1)) {
                            ms1Var = (ms1) obj;
                        } else {
                            ms1Var = new ms1(this.mSwanApiContext);
                            this.mApis.put("1159492510", ms1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ms1Var, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.showToast")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 Q = ms1Var.Q(str);
                        return Q == null ? "" : Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    ks1 ks1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof ks1)) {
                            ks1Var = (ks1) obj;
                        } else {
                            ks1Var = new ks1(this.mSwanApiContext);
                            this.mApis.put("1165118609", ks1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ks1Var, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.stopPullDownRefresh")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = ks1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    js1 js1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof js1)) {
                            js1Var = (js1) obj;
                        } else {
                            js1Var = new js1(this.mSwanApiContext);
                            this.mApis.put("-108978463", js1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(js1Var, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.updateMultiPicker")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 M = js1Var.M(str);
                        return M == null ? "" : M.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    os1 os1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof os1)) {
                            os1Var = (os1) obj;
                        } else {
                            os1Var = new os1(this.mSwanApiContext);
                            this.mApis.put("-137346255", os1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(os1Var, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Keyboard.startKeyboardHeightChange")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 C = os1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    os1 os1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof os1)) {
                            os1Var = (os1) obj;
                        } else {
                            os1Var = new os1(this.mSwanApiContext);
                            this.mApis.put("-137346255", os1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(os1Var, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Keyboard.stopKeyboardHeightChange")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 D = os1Var.D();
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    ps1 ps1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof ps1)) {
                            ps1Var = (ps1) obj;
                        } else {
                            ps1Var = new ps1(this.mSwanApiContext);
                            this.mApis.put("-397373095", ps1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ps1Var, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "LocationService.getLocation")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = ps1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    ps1 ps1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof ps1)) {
                            ps1Var = (ps1) obj;
                        } else {
                            ps1Var = new ps1(this.mSwanApiContext);
                            this.mApis.put("-397373095", ps1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ps1Var, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "LocationService.startLocationUpdate")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = ps1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    ps1 ps1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof ps1)) {
                            ps1Var = (ps1) obj;
                        } else {
                            ps1Var = new ps1(this.mSwanApiContext);
                            this.mApis.put("-397373095", ps1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ps1Var, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "LocationService.stopLocationUpdate")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 B = ps1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    gu1 gu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("538070032", gu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(gu1Var, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = gu1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String callService(String str) {
                    ss1 ss1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof ss1)) {
                            ss1Var = (ss1) obj;
                        } else {
                            ss1Var = new ss1(this.mSwanApiContext);
                            this.mApis.put("-1076509454", ss1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ss1Var, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Network.callService")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = ss1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    zs1 zs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("968563034", zs1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(zs1Var, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Network.cancelRequest")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 D = zs1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    ys1 ys1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof ys1)) {
                            ys1Var = (ys1) obj;
                        } else {
                            ys1Var = new ys1(this.mSwanApiContext);
                            this.mApis.put("453220699", ys1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ys1Var, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Network.getNetworkType")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = ys1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    ys1 ys1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof ys1)) {
                            ys1Var = (ys1) obj;
                        } else {
                            ys1Var = new ys1(this.mSwanApiContext);
                            this.mApis.put("453220699", ys1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ys1Var, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Network.networkStatusChange")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = ys1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                @JavascriptInterface
                public String request(JsObject jsObject) {
                    InterceptResult invokeL2;
                    zs1 zs1Var;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && (invokeL2 = interceptable2.invokeL(1048580, this, jsObject)) != null) {
                        return (String) invokeL2.objValue;
                    }
                    try {
                        jv1.c().a("request");
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("968563034", zs1Var);
                        }
                        Pair<Boolean, kv1> a2 = mv1.a(zs1Var, "swanAPI/request");
                        if (((Boolean) a2.first).booleanValue()) {
                            a = ((kv1) a2.second).a();
                        } else if (s52.a(this.mSwanApiContext.f(), "Network.request")) {
                            a = new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        } else {
                            Pair<kv1, JSONObject> t = or1.t(jsObject);
                            if (!((kv1) t.first).isSuccess()) {
                                a = ((kv1) t.first).a();
                            } else {
                                JSONObject jSONObject = (JSONObject) t.second;
                                if (jSONObject == null) {
                                    a = kv1.a.a();
                                } else {
                                    lv1 V = zs1Var.V(jSONObject);
                                    a = V == null ? "" : V.a();
                                }
                            }
                        }
                        return a;
                    } finally {
                    }
                }
            });
            hashMap.put("_naPayment", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    iw2 iw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof iw2)) {
                            iw2Var = (iw2) obj;
                        } else {
                            iw2Var = new iw2(this.mSwanApiContext);
                            this.mApis.put("-336396851", iw2Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(iw2Var, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Payment.chooseCoupon")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = iw2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    iw2 iw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof iw2)) {
                            iw2Var = (iw2) obj;
                        } else {
                            iw2Var = new iw2(this.mSwanApiContext);
                            this.mApis.put("-336396851", iw2Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(iw2Var, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Payment.getPaymentInfo")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = iw2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    yv2 yv2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof yv2)) {
                            yv2Var = (yv2) obj;
                        } else {
                            yv2Var = new yv2(this.mSwanApiContext);
                            this.mApis.put("1854689529", yv2Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(yv2Var, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Payment.requestThirdPayment")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = yv2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    iw2 iw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof iw2)) {
                            iw2Var = (iw2) obj;
                        } else {
                            iw2Var = new iw2(this.mSwanApiContext);
                            this.mApis.put("-336396851", iw2Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(iw2Var, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Payment.setPaymentInfo")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 z = iw2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    ty2 ty2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof ty2)) {
                            ty2Var = (ty2) obj;
                        } else {
                            ty2Var = new ty2(this.mSwanApiContext);
                            this.mApis.put("-254510461", ty2Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ty2Var, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Plugin.invokePluginChooseAddress")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = ty2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    ty2 ty2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof ty2)) {
                            ty2Var = (ty2) obj;
                        } else {
                            ty2Var = new ty2(this.mSwanApiContext);
                            this.mApis.put("-254510461", ty2Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ty2Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 z = ty2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    ty2 ty2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof ty2)) {
                            ty2Var = (ty2) obj;
                        } else {
                            ty2Var = new ty2(this.mSwanApiContext);
                            this.mApis.put("-254510461", ty2Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ty2Var, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Plugin.invokePluginPayment")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = ty2Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    m72 m72Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof m72)) {
                            m72Var = (m72) obj;
                        } else {
                            m72Var = new m72(this.mSwanApiContext);
                            this.mApis.put("-2068479848", m72Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(m72Var, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Prefetch.prefetchResources")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = m72Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    e62 e62Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof e62)) {
                            e62Var = (e62) obj;
                        } else {
                            e62Var = new e62(this.mSwanApiContext);
                            this.mApis.put("423661539", e62Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(e62Var, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Preload.preloadStatus")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = e62Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    of3 of3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof of3)) {
                            of3Var = (of3) obj;
                        } else {
                            of3Var = new of3(this.mSwanApiContext);
                            this.mApis.put("-1929343869", of3Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(of3Var, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "PrivateFile.uploadFileToBos")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 C = of3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    dt1 dt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof dt1)) {
                            dt1Var = (dt1) obj;
                        } else {
                            dt1Var = new dt1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", dt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(dt1Var, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Router.hideModalPage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = dt1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    dt1 dt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof dt1)) {
                            dt1Var = (dt1) obj;
                        } else {
                            dt1Var = new dt1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", dt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(dt1Var, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Router.navigateBack")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 B = dt1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    et1 et1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof et1)) {
                            et1Var = (et1) obj;
                        } else {
                            et1Var = new et1(this.mSwanApiContext);
                            this.mApis.put("1968522584", et1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(et1Var, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Router.navigateTo")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 H = et1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    gt1 gt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof gt1)) {
                            gt1Var = (gt1) obj;
                        } else {
                            gt1Var = new gt1(this.mSwanApiContext);
                            this.mApis.put("1317280190", gt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(gt1Var, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Router.reLaunch")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = gt1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    ht1 ht1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof ht1)) {
                            ht1Var = (ht1) obj;
                        } else {
                            ht1Var = new ht1(this.mSwanApiContext);
                            this.mApis.put("-420075743", ht1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ht1Var, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Router.reLoadErrorPage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = ht1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    ft1 ft1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("1792515533", ft1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ft1Var, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Router.redirectTo")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 D = ft1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    et1 et1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof et1)) {
                            et1Var = (et1) obj;
                        } else {
                            et1Var = new et1(this.mSwanApiContext);
                            this.mApis.put("1968522584", et1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(et1Var, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Router.showModalPage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 J = et1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    kt1 kt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof kt1)) {
                            kt1Var = (kt1) obj;
                        } else {
                            kt1Var = new kt1(this.mSwanApiContext);
                            this.mApis.put("-594895721", kt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(kt1Var, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Setting.getAppInfoSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 F = kt1Var.F();
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    kt1 kt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof kt1)) {
                            kt1Var = (kt1) obj;
                        } else {
                            kt1Var = new kt1(this.mSwanApiContext);
                            this.mApis.put("-594895721", kt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(kt1Var, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Setting.getSetting")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 G = kt1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    kt1 kt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof kt1)) {
                            kt1Var = (kt1) obj;
                        } else {
                            kt1Var = new kt1(this.mSwanApiContext);
                            this.mApis.put("-594895721", kt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(kt1Var, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Setting.getSlaveIdSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 H = kt1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    kt1 kt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof kt1)) {
                            kt1Var = (kt1) obj;
                        } else {
                            kt1Var = new kt1(this.mSwanApiContext);
                            this.mApis.put("-594895721", kt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(kt1Var, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Setting.getSwanId")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 I = kt1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    kt1 kt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof kt1)) {
                            kt1Var = (kt1) obj;
                        } else {
                            kt1Var = new kt1(this.mSwanApiContext);
                            this.mApis.put("-594895721", kt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(kt1Var, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Setting.getUserInfo")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 J = kt1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    jt1 jt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof jt1)) {
                            jt1Var = (jt1) obj;
                        } else {
                            jt1Var = new jt1(this.mSwanApiContext);
                            this.mApis.put("450273045", jt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(jt1Var, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Setting.isAllowedAdOpenAppSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = jt1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    ia3 ia3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof ia3)) {
                            ia3Var = (ia3) obj;
                        } else {
                            ia3Var = new ia3(this.mSwanApiContext);
                            this.mApis.put("712777136", ia3Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ia3Var, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = ia3Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    nt1 nt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("-804054859", nt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(nt1Var, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = nt1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    nt1 nt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("-804054859", nt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(nt1Var, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorageSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 C = nt1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    mt1 mt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("130910081", mt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(mt1Var, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.clearStorage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = mt1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    mt1 mt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("130910081", mt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(mt1Var, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.clearStorageSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 C = mt1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("-804054859", nt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(nt1Var, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.getGlobalStorage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 D = nt1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    nt1 nt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("-804054859", nt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(nt1Var, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfo")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 G = nt1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    nt1 nt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("-804054859", nt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(nt1Var, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfoSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 J = nt1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("-804054859", nt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(nt1Var, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 K = nt1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    mt1 mt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("130910081", mt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(mt1Var, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.getStorage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 D = mt1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    mt1 mt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("130910081", mt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(mt1Var, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.getStorageInfo")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 G = mt1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    mt1 mt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("130910081", mt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(mt1Var, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.getStorageInfoAsync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 H = mt1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    mt1 mt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("130910081", mt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(mt1Var, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.getStorageInfoSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 J = mt1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    mt1 mt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("130910081", mt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(mt1Var, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.getStorageSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 K = mt1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("-804054859", nt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(nt1Var, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 R = nt1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("-804054859", nt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(nt1Var, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorageSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 T = nt1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    mt1 mt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("130910081", mt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(mt1Var, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.removeStorage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 R = mt1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    mt1 mt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("130910081", mt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(mt1Var, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.removeStorageSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 T = mt1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("-804054859", nt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(nt1Var, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.setGlobalStorage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 U = nt1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("-804054859", nt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(nt1Var, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.setGlobalStorageSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 W = nt1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    mt1 mt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("130910081", mt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(mt1Var, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.setStorage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 U = mt1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    mt1 mt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("130910081", mt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(mt1Var, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.setStorageSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 W = mt1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    pt1 pt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof pt1)) {
                            pt1Var = (pt1) obj;
                        } else {
                            pt1Var = new pt1(this.mSwanApiContext);
                            this.mApis.put("823117982", pt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(pt1Var, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Subscription.requestSubscribeFormId")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 E = pt1Var.E(str);
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    qt1 qt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof qt1)) {
                            qt1Var = (qt1) obj;
                        } else {
                            qt1Var = new qt1(this.mSwanApiContext);
                            this.mApis.put("-947445811", qt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(qt1Var, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Subscription.subscribeService")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 F = qt1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    xt1 xt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof xt1)) {
                            xt1Var = (xt1) obj;
                        } else {
                            xt1Var = new xt1(this.mSwanApiContext);
                            this.mApis.put("1936205521", xt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(xt1Var, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.exitFullScreen")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = xt1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    tt1 tt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof tt1)) {
                            tt1Var = (tt1) obj;
                        } else {
                            tt1Var = new tt1(this.mSwanApiContext);
                            this.mApis.put("99997465", tt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(tt1Var, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.getBrightness")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = tt1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    ut1 ut1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof ut1)) {
                            ut1Var = (ut1) obj;
                        } else {
                            ut1Var = new ut1(this.mSwanApiContext);
                            this.mApis.put("-518757484", ut1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ut1Var, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.getClipboardData")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = ut1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    wt1 wt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof wt1)) {
                            wt1Var = (wt1) obj;
                        } else {
                            wt1Var = new wt1(this.mSwanApiContext);
                            this.mApis.put("1694151270", wt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(wt1Var, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.getDeviceInfo")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = wt1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    yt1 yt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof yt1)) {
                            yt1Var = (yt1) obj;
                        } else {
                            yt1Var = new yt1(this.mSwanApiContext);
                            this.mApis.put("-1321681619", yt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(yt1Var, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.getDeviceProfile")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = yt1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    eu1 eu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof eu1)) {
                            eu1Var = (eu1) obj;
                        } else {
                            eu1Var = new eu1(this.mSwanApiContext);
                            this.mApis.put("447234992", eu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(eu1Var, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.getMediaVolume")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = eu1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    zt1 zt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof zt1)) {
                            zt1Var = (zt1) obj;
                        } else {
                            zt1Var = new zt1(this.mSwanApiContext);
                            this.mApis.put("-1569246082", zt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(zt1Var, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.makePhoneCall")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = zt1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    bu1 bu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof bu1)) {
                            bu1Var = (bu1) obj;
                        } else {
                            bu1Var = new bu1(this.mSwanApiContext);
                            this.mApis.put("1099851202", bu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(bu1Var, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.openSMSPanel")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = bu1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    au1 au1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof au1)) {
                            au1Var = (au1) obj;
                        } else {
                            au1Var = new au1(this.mSwanApiContext);
                            this.mApis.put("-1707203360", au1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(au1Var, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.requestFullScreen")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 F = au1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    ut1 ut1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof ut1)) {
                            ut1Var = (ut1) obj;
                        } else {
                            ut1Var = new ut1(this.mSwanApiContext);
                            this.mApis.put("-518757484", ut1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ut1Var, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.setClipboardData")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = ut1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    et2 et2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof et2)) {
                            et2Var = (et2) obj;
                        } else {
                            et2Var = new et2(this.mSwanApiContext);
                            this.mApis.put("1161486049", et2Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(et2Var, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.setErrorPageType")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = et2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    eu1 eu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof eu1)) {
                            eu1Var = (eu1) obj;
                        } else {
                            eu1Var = new eu1(this.mSwanApiContext);
                            this.mApis.put("447234992", eu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(eu1Var, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.setMediaVolume")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 z = eu1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    st1 st1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof st1)) {
                            st1Var = (st1) obj;
                        } else {
                            st1Var = new st1(this.mSwanApiContext);
                            this.mApis.put("1372680763", st1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(st1Var, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.startAccelerometer")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = st1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    vt1 vt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof vt1)) {
                            vt1Var = (vt1) obj;
                        } else {
                            vt1Var = new vt1(this.mSwanApiContext);
                            this.mApis.put("1689255576", vt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(vt1Var, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.startCompass")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = vt1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    st1 st1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof st1)) {
                            st1Var = (st1) obj;
                        } else {
                            st1Var = new st1(this.mSwanApiContext);
                            this.mApis.put("1372680763", st1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(st1Var, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.stopAccelerometer")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 B = st1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    vt1 vt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof vt1)) {
                            vt1Var = (vt1) obj;
                        } else {
                            vt1Var = new vt1(this.mSwanApiContext);
                            this.mApis.put("1689255576", vt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(vt1Var, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.stopCompass")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 z = vt1Var.z();
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    pu1 pu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof pu1)) {
                            pu1Var = (pu1) obj;
                        } else {
                            pu1Var = new pu1(this.mSwanApiContext);
                            this.mApis.put("201194468", pu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(pu1Var, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.addToDesktop")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 B = pu1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    lu1 lu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof lu1)) {
                            lu1Var = (lu1) obj;
                        } else {
                            lu1Var = new lu1(this.mSwanApiContext);
                            this.mApis.put("-1412306947", lu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(lu1Var, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.calcMD5")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = lu1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    mu1 mu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof mu1)) {
                            mu1Var = (mu1) obj;
                        } else {
                            mu1Var = new mu1(this.mSwanApiContext);
                            this.mApis.put("1626415364", mu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(mu1Var, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.checkAppInstalled")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = mu1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    ou1 ou1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof ou1)) {
                            ou1Var = (ou1) obj;
                        } else {
                            ou1Var = new ou1(this.mSwanApiContext);
                            this.mApis.put("-836768778", ou1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ou1Var, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfo")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = ou1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    uu1 uu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof uu1)) {
                            uu1Var = (uu1) obj;
                        } else {
                            uu1Var = new uu1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", uu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(uu1Var, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfoSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 E = uu1Var.E();
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    qu1 qu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof qu1)) {
                            qu1Var = (qu1) obj;
                        } else {
                            qu1Var = new qu1(this.mSwanApiContext);
                            this.mApis.put("-810858308", qu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(qu1Var, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.getPerformanceLevel")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = qu1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    uu1 uu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof uu1)) {
                            uu1Var = (uu1) obj;
                        } else {
                            uu1Var = new uu1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", uu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(uu1Var, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.getSystemInfo")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 H = uu1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    uu1 uu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof uu1)) {
                            uu1Var = (uu1) obj;
                        } else {
                            uu1Var = new uu1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", uu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(uu1Var, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.getSystemInfoAsync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 I = uu1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    uu1 uu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof uu1)) {
                            uu1Var = (uu1) obj;
                        } else {
                            uu1Var = new uu1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", uu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(uu1Var, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.getSystemInfoSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 J = uu1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    ru1 ru1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof ru1)) {
                            ru1Var = (ru1) obj;
                        } else {
                            ru1Var = new ru1(this.mSwanApiContext);
                            this.mApis.put("-2097727681", ru1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ru1Var, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.handleException")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = ru1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    nu1 nu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof nu1)) {
                            nu1Var = (nu1) obj;
                        } else {
                            nu1Var = new nu1(this.mSwanApiContext);
                            this.mApis.put("2084449317", nu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(nu1Var, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.hasCloseHandler")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = nu1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    q73 q73Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof q73)) {
                            q73Var = (q73) obj;
                        } else {
                            q73Var = new q73(this.mSwanApiContext);
                            this.mApis.put("1031678042", q73Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(q73Var, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.hideCaptureScreenShareDialog")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = q73Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    su1 su1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof su1)) {
                            su1Var = (su1) obj;
                        } else {
                            su1Var = new su1(this.mSwanApiContext);
                            this.mApis.put("1751900130", su1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(su1Var, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.logToFile")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = su1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    r63 r63Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof r63)) {
                            r63Var = (r63) obj;
                        } else {
                            r63Var = new r63(this.mSwanApiContext);
                            this.mApis.put("1748196865", r63Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(r63Var, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.preloadPackage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = r63Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    tu1 tu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof tu1)) {
                            tu1Var = (tu1) obj;
                        } else {
                            tu1Var = new tu1(this.mSwanApiContext);
                            this.mApis.put("589529211", tu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(tu1Var, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.previewImage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 B = tu1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    wu1 wu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof wu1)) {
                            wu1Var = (wu1) obj;
                        } else {
                            wu1Var = new wu1(this.mSwanApiContext);
                            this.mApis.put("-577481801", wu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(wu1Var, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.ubcFlowJar")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 I = wu1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    be3 be3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof be3)) {
                            be3Var = (be3) obj;
                        } else {
                            be3Var = new be3(this.mSwanApiContext);
                            this.mApis.put("1879401452", be3Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(be3Var, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Wifi.connectWifi")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = be3Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    be3 be3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof be3)) {
                            be3Var = (be3) obj;
                        } else {
                            be3Var = new be3(this.mSwanApiContext);
                            this.mApis.put("1879401452", be3Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(be3Var, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Wifi.getConnectedWifi")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 B = be3Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    be3 be3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof be3)) {
                            be3Var = (be3) obj;
                        } else {
                            be3Var = new be3(this.mSwanApiContext);
                            this.mApis.put("1879401452", be3Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(be3Var, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Wifi.getWifiList")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 C = be3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    be3 be3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof be3)) {
                            be3Var = (be3) obj;
                        } else {
                            be3Var = new be3(this.mSwanApiContext);
                            this.mApis.put("1879401452", be3Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(be3Var, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Wifi.startWifi")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 G = be3Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    be3 be3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof be3)) {
                            be3Var = (be3) obj;
                        } else {
                            be3Var = new be3(this.mSwanApiContext);
                            this.mApis.put("1879401452", be3Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(be3Var, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Wifi.stopWifi")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 H = be3Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static Map<String, Object> getWebviewApiModules(final mr1 mr1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, mr1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    sr1 sr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof sr1)) {
                            sr1Var = (sr1) obj;
                        } else {
                            sr1Var = new sr1(this.mSwanApiContext);
                            this.mApis.put("1930258908", sr1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(sr1Var, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Account.checkSession")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = sr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    tr1 tr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof tr1)) {
                            tr1Var = (tr1) obj;
                        } else {
                            tr1Var = new tr1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", tr1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(tr1Var, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Account.getLoginCode")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 C = tr1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    ur1 ur1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof ur1)) {
                            ur1Var = (ur1) obj;
                        } else {
                            ur1Var = new ur1(this.mSwanApiContext);
                            this.mApis.put("1754780133", ur1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ur1Var, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Account.getOpenId")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = ur1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-343998465", br1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(br1Var, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Account.getUnionBDUSS")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = br1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    rr1 rr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof rr1)) {
                            rr1Var = (rr1) obj;
                        } else {
                            rr1Var = new rr1(this.mSwanApiContext);
                            this.mApis.put("-337742792", rr1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(rr1Var, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Account.isBaiduAccountSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = rr1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    tr1 tr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof tr1)) {
                            tr1Var = (tr1) obj;
                        } else {
                            tr1Var = new tr1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", tr1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(tr1Var, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Account.isLoginSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 H = tr1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    tr1 tr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof tr1)) {
                            tr1Var = (tr1) obj;
                        } else {
                            tr1Var = new tr1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", tr1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(tr1Var, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Account.login")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 I = tr1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    vr1 vr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof vr1)) {
                            vr1Var = (vr1) obj;
                        } else {
                            vr1Var = new vr1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", vr1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(vr1Var, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Basic.loadSubPackage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 F = vr1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    vr1 vr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof vr1)) {
                            vr1Var = (vr1) obj;
                        } else {
                            vr1Var = new vr1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", vr1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(vr1Var, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Basic.loadSubPackages")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 G = vr1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    ck1 ck1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof ck1)) {
                            ck1Var = (ck1) obj;
                        } else {
                            ck1Var = new ck1(this.mSwanApiContext);
                            this.mApis.put("1460300387", ck1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ck1Var, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Bookshelf.deleteBookshelf")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 K = ck1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    ck1 ck1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof ck1)) {
                            ck1Var = (ck1) obj;
                        } else {
                            ck1Var = new ck1(this.mSwanApiContext);
                            this.mApis.put("1460300387", ck1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ck1Var, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Bookshelf.insertBookshelf")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 P = ck1Var.P(str);
                        return P == null ? "" : P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    ck1 ck1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof ck1)) {
                            ck1Var = (ck1) obj;
                        } else {
                            ck1Var = new ck1(this.mSwanApiContext);
                            this.mApis.put("1460300387", ck1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ck1Var, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Bookshelf.navigateToBookshelf")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 U = ck1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    ck1 ck1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof ck1)) {
                            ck1Var = (ck1) obj;
                        } else {
                            ck1Var = new ck1(this.mSwanApiContext);
                            this.mApis.put("1460300387", ck1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ck1Var, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Bookshelf.queryBookshelf")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 V = ck1Var.V(str);
                        return V == null ? "" : V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    ck1 ck1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof ck1)) {
                            ck1Var = (ck1) obj;
                        } else {
                            ck1Var = new ck1(this.mSwanApiContext);
                            this.mApis.put("1460300387", ck1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ck1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Bookshelf.updateBookshelfReadTime")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 X = ck1Var.X(str);
                        return X == null ? "" : X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    pr1 pr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof pr1)) {
                            pr1Var = (pr1) obj;
                        } else {
                            pr1Var = new pr1(this.mSwanApiContext);
                            this.mApis.put("-277316359", pr1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(pr1Var, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Coupon.getPlatformCoupons")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = pr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    pr1 pr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof pr1)) {
                            pr1Var = (pr1) obj;
                        } else {
                            pr1Var = new pr1(this.mSwanApiContext);
                            this.mApis.put("-277316359", pr1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(pr1Var, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Coupon.getUserCoupons")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 z = pr1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    pr1 pr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof pr1)) {
                            pr1Var = (pr1) obj;
                        } else {
                            pr1Var = new pr1(this.mSwanApiContext);
                            this.mApis.put("-277316359", pr1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(pr1Var, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Coupon.takeCoupons")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 C = pr1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    xr1 xr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof xr1)) {
                            xr1Var = (xr1) obj;
                        } else {
                            xr1Var = new xr1(this.mSwanApiContext);
                            this.mApis.put("-1225406515", xr1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(xr1Var, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Favorite.getFavorStatus")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = xr1Var.x(str);
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
                        Pair<Boolean, kv1> a = mv1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Favorite.showFavoriteGuide")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 G = showFavoriteGuideApi.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    zr1 zr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof zr1)) {
                            zr1Var = (zr1) obj;
                        } else {
                            zr1Var = new zr1(this.mSwanApiContext);
                            this.mApis.put("-2057135077", zr1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(zr1Var, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "File.shareFile")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = zr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    og2 og2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof og2)) {
                            og2Var = (og2) obj;
                        } else {
                            og2Var = new og2(this.mSwanApiContext);
                            this.mApis.put("2077414795", og2Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(og2Var, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = og2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    og2 og2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof og2)) {
                            og2Var = (og2) obj;
                        } else {
                            og2Var = new og2(this.mSwanApiContext);
                            this.mApis.put("2077414795", og2Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(og2Var, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessageSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = og2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String download(String str) {
                    as1 as1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof as1)) {
                            as1Var = (as1) obj;
                        } else {
                            as1Var = new as1(this.mSwanApiContext);
                            this.mApis.put("-170124576", as1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(as1Var, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "HostDownloadManager.download")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = as1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    as1 as1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof as1)) {
                            as1Var = (as1) obj;
                        } else {
                            as1Var = new as1(this.mSwanApiContext);
                            this.mApis.put("-170124576", as1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(as1Var, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "HostDownloadManager.openDownloadCenter")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = as1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    as1 as1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof as1)) {
                            as1Var = (as1) obj;
                        } else {
                            as1Var = new as1(this.mSwanApiContext);
                            this.mApis.put("-170124576", as1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(as1Var, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "HostDownloadManager.openFile")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 z = as1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    as1 as1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof as1)) {
                            as1Var = (as1) obj;
                        } else {
                            as1Var = new as1(this.mSwanApiContext);
                            this.mApis.put("-170124576", as1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(as1Var, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "HostDownloadManager.query")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 query = as1Var.query(str);
                        return query == null ? "" : query.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naImage", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    ct2 ct2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof ct2)) {
                            ct2Var = (ct2) obj;
                        } else {
                            ct2Var = new ct2(this.mSwanApiContext);
                            this.mApis.put("1445003743", ct2Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ct2Var, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Image.callImageMenu")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = ct2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    ds1 ds1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof ds1)) {
                            ds1Var = (ds1) obj;
                        } else {
                            ds1Var = new ds1(this.mSwanApiContext);
                            this.mApis.put("-1252730367", ds1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ds1Var, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Image.compressImage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = ds1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    ls1 ls1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ls1)) {
                            ls1Var = (ls1) obj;
                        } else {
                            ls1Var = new ls1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ls1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ls1Var, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.closeTabBar")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = ls1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    ls1 ls1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ls1)) {
                            ls1Var = (ls1) obj;
                        } else {
                            ls1Var = new ls1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ls1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ls1Var, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.closeTabBarRedDot")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = ls1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    fs1 fs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof fs1)) {
                            fs1Var = (fs1) obj;
                        } else {
                            fs1Var = new fs1(this.mSwanApiContext);
                            this.mApis.put("5236036", fs1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(fs1Var, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.hideLoading")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = fs1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    hs1 hs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof hs1)) {
                            hs1Var = (hs1) obj;
                        } else {
                            hs1Var = new hs1(this.mSwanApiContext);
                            this.mApis.put("-246386074", hs1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(hs1Var, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.hideNavigationBarLoading")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = hs1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    ms1 ms1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof ms1)) {
                            ms1Var = (ms1) obj;
                        } else {
                            ms1Var = new ms1(this.mSwanApiContext);
                            this.mApis.put("1159492510", ms1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ms1Var, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.hideToast")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 K = ms1Var.K();
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    js1 js1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof js1)) {
                            js1Var = (js1) obj;
                        } else {
                            js1Var = new js1(this.mSwanApiContext);
                            this.mApis.put("-108978463", js1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(js1Var, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.openMultiPicker")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 G = js1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    js1 js1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof js1)) {
                            js1Var = (js1) obj;
                        } else {
                            js1Var = new js1(this.mSwanApiContext);
                            this.mApis.put("-108978463", js1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(js1Var, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.openPicker")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 H = js1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    ls1 ls1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ls1)) {
                            ls1Var = (ls1) obj;
                        } else {
                            ls1Var = new ls1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ls1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ls1Var, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.openTabBar")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 C = ls1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    is1 is1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof is1)) {
                            is1Var = (is1) obj;
                        } else {
                            is1Var = new is1(this.mSwanApiContext);
                            this.mApis.put("-1750613704", is1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(is1Var, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.pageScrollTo")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = is1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    hs1 hs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof hs1)) {
                            hs1Var = (hs1) obj;
                        } else {
                            hs1Var = new hs1(this.mSwanApiContext);
                            this.mApis.put("-246386074", hs1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(hs1Var, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarColor")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 z = hs1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    hs1 hs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof hs1)) {
                            hs1Var = (hs1) obj;
                        } else {
                            hs1Var = new hs1(this.mSwanApiContext);
                            this.mApis.put("-246386074", hs1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(hs1Var, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarTitle")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = hs1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    ls1 ls1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ls1)) {
                            ls1Var = (ls1) obj;
                        } else {
                            ls1Var = new ls1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ls1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ls1Var, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.setTabBarItem")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 D = ls1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    js1 js1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof js1)) {
                            js1Var = (js1) obj;
                        } else {
                            js1Var = new js1(this.mSwanApiContext);
                            this.mApis.put("-108978463", js1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(js1Var, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.showDatePickerView")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 L = js1Var.L(str);
                        return L == null ? "" : L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    ns1 ns1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof ns1)) {
                            ns1Var = (ns1) obj;
                        } else {
                            ns1Var = new ns1(this.mSwanApiContext);
                            this.mApis.put("1172469410", ns1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ns1Var, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.showHalfScreenWebview")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 K = ns1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    fs1 fs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof fs1)) {
                            fs1Var = (fs1) obj;
                        } else {
                            fs1Var = new fs1(this.mSwanApiContext);
                            this.mApis.put("5236036", fs1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(fs1Var, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.showLoading")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = fs1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    gs1 gs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof gs1)) {
                            gs1Var = (gs1) obj;
                        } else {
                            gs1Var = new gs1(this.mSwanApiContext);
                            this.mApis.put("1913747800", gs1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(gs1Var, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.showModal")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = gs1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    hs1 hs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof hs1)) {
                            hs1Var = (hs1) obj;
                        } else {
                            hs1Var = new hs1(this.mSwanApiContext);
                            this.mApis.put("-246386074", hs1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(hs1Var, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.showNavigationBarLoading")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 B = hs1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    ms1 ms1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof ms1)) {
                            ms1Var = (ms1) obj;
                        } else {
                            ms1Var = new ms1(this.mSwanApiContext);
                            this.mApis.put("1159492510", ms1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ms1Var, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.showToast")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 Q = ms1Var.Q(str);
                        return Q == null ? "" : Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    ks1 ks1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof ks1)) {
                            ks1Var = (ks1) obj;
                        } else {
                            ks1Var = new ks1(this.mSwanApiContext);
                            this.mApis.put("1165118609", ks1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ks1Var, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.stopPullDownRefresh")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = ks1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    js1 js1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof js1)) {
                            js1Var = (js1) obj;
                        } else {
                            js1Var = new js1(this.mSwanApiContext);
                            this.mApis.put("-108978463", js1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(js1Var, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Interaction.updateMultiPicker")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 M = js1Var.M(str);
                        return M == null ? "" : M.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    os1 os1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof os1)) {
                            os1Var = (os1) obj;
                        } else {
                            os1Var = new os1(this.mSwanApiContext);
                            this.mApis.put("-137346255", os1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(os1Var, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Keyboard.startKeyboardHeightChange")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 C = os1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    os1 os1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof os1)) {
                            os1Var = (os1) obj;
                        } else {
                            os1Var = new os1(this.mSwanApiContext);
                            this.mApis.put("-137346255", os1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(os1Var, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Keyboard.stopKeyboardHeightChange")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 D = os1Var.D();
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    ps1 ps1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof ps1)) {
                            ps1Var = (ps1) obj;
                        } else {
                            ps1Var = new ps1(this.mSwanApiContext);
                            this.mApis.put("-397373095", ps1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ps1Var, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "LocationService.getLocation")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = ps1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    ps1 ps1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof ps1)) {
                            ps1Var = (ps1) obj;
                        } else {
                            ps1Var = new ps1(this.mSwanApiContext);
                            this.mApis.put("-397373095", ps1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ps1Var, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "LocationService.startLocationUpdate")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = ps1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    ps1 ps1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof ps1)) {
                            ps1Var = (ps1) obj;
                        } else {
                            ps1Var = new ps1(this.mSwanApiContext);
                            this.mApis.put("-397373095", ps1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ps1Var, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "LocationService.stopLocationUpdate")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 B = ps1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    gu1 gu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("538070032", gu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(gu1Var, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = gu1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String callService(String str) {
                    ss1 ss1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof ss1)) {
                            ss1Var = (ss1) obj;
                        } else {
                            ss1Var = new ss1(this.mSwanApiContext);
                            this.mApis.put("-1076509454", ss1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ss1Var, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Network.callService")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = ss1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    zs1 zs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("968563034", zs1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(zs1Var, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Network.cancelRequest")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 D = zs1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    ys1 ys1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof ys1)) {
                            ys1Var = (ys1) obj;
                        } else {
                            ys1Var = new ys1(this.mSwanApiContext);
                            this.mApis.put("453220699", ys1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ys1Var, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Network.getNetworkType")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = ys1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    ys1 ys1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof ys1)) {
                            ys1Var = (ys1) obj;
                        } else {
                            ys1Var = new ys1(this.mSwanApiContext);
                            this.mApis.put("453220699", ys1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ys1Var, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Network.networkStatusChange")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = ys1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                @JavascriptInterface
                public String request(String str) {
                    InterceptResult invokeL2;
                    zs1 zs1Var;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && (invokeL2 = interceptable2.invokeL(1048580, this, str)) != null) {
                        return (String) invokeL2.objValue;
                    }
                    try {
                        jv1.c().a("request");
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("968563034", zs1Var);
                        }
                        Pair<Boolean, kv1> a2 = mv1.a(zs1Var, "swanAPI/request");
                        if (((Boolean) a2.first).booleanValue()) {
                            a = ((kv1) a2.second).a();
                        } else if (s52.a(this.mSwanApiContext.f(), "Network.request")) {
                            a = new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        } else {
                            Pair<kv1, JSONObject> u = or1.u(str);
                            if (!((kv1) u.first).isSuccess()) {
                                a = ((kv1) u.first).a();
                            } else {
                                JSONObject jSONObject = (JSONObject) u.second;
                                if (jSONObject == null) {
                                    a = kv1.a.a();
                                } else {
                                    lv1 V = zs1Var.V(jSONObject);
                                    a = V == null ? "" : V.a();
                                }
                            }
                        }
                        return a;
                    } finally {
                    }
                }
            });
            hashMap.put("_naPayment", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    iw2 iw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof iw2)) {
                            iw2Var = (iw2) obj;
                        } else {
                            iw2Var = new iw2(this.mSwanApiContext);
                            this.mApis.put("-336396851", iw2Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(iw2Var, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Payment.chooseCoupon")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = iw2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    iw2 iw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof iw2)) {
                            iw2Var = (iw2) obj;
                        } else {
                            iw2Var = new iw2(this.mSwanApiContext);
                            this.mApis.put("-336396851", iw2Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(iw2Var, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Payment.getPaymentInfo")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = iw2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    yv2 yv2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof yv2)) {
                            yv2Var = (yv2) obj;
                        } else {
                            yv2Var = new yv2(this.mSwanApiContext);
                            this.mApis.put("1854689529", yv2Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(yv2Var, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Payment.requestThirdPayment")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = yv2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    iw2 iw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof iw2)) {
                            iw2Var = (iw2) obj;
                        } else {
                            iw2Var = new iw2(this.mSwanApiContext);
                            this.mApis.put("-336396851", iw2Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(iw2Var, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Payment.setPaymentInfo")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 z = iw2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    ty2 ty2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof ty2)) {
                            ty2Var = (ty2) obj;
                        } else {
                            ty2Var = new ty2(this.mSwanApiContext);
                            this.mApis.put("-254510461", ty2Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ty2Var, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Plugin.invokePluginChooseAddress")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = ty2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    ty2 ty2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof ty2)) {
                            ty2Var = (ty2) obj;
                        } else {
                            ty2Var = new ty2(this.mSwanApiContext);
                            this.mApis.put("-254510461", ty2Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ty2Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 z = ty2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    ty2 ty2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof ty2)) {
                            ty2Var = (ty2) obj;
                        } else {
                            ty2Var = new ty2(this.mSwanApiContext);
                            this.mApis.put("-254510461", ty2Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ty2Var, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Plugin.invokePluginPayment")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = ty2Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    m72 m72Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof m72)) {
                            m72Var = (m72) obj;
                        } else {
                            m72Var = new m72(this.mSwanApiContext);
                            this.mApis.put("-2068479848", m72Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(m72Var, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Prefetch.prefetchResources")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = m72Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    e62 e62Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof e62)) {
                            e62Var = (e62) obj;
                        } else {
                            e62Var = new e62(this.mSwanApiContext);
                            this.mApis.put("423661539", e62Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(e62Var, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Preload.preloadStatus")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = e62Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    of3 of3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof of3)) {
                            of3Var = (of3) obj;
                        } else {
                            of3Var = new of3(this.mSwanApiContext);
                            this.mApis.put("-1929343869", of3Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(of3Var, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "PrivateFile.uploadFileToBos")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 C = of3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    dt1 dt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof dt1)) {
                            dt1Var = (dt1) obj;
                        } else {
                            dt1Var = new dt1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", dt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(dt1Var, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Router.hideModalPage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = dt1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    dt1 dt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof dt1)) {
                            dt1Var = (dt1) obj;
                        } else {
                            dt1Var = new dt1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", dt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(dt1Var, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Router.navigateBack")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 B = dt1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    et1 et1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof et1)) {
                            et1Var = (et1) obj;
                        } else {
                            et1Var = new et1(this.mSwanApiContext);
                            this.mApis.put("1968522584", et1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(et1Var, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Router.navigateTo")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 H = et1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    gt1 gt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof gt1)) {
                            gt1Var = (gt1) obj;
                        } else {
                            gt1Var = new gt1(this.mSwanApiContext);
                            this.mApis.put("1317280190", gt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(gt1Var, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Router.reLaunch")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = gt1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    ht1 ht1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof ht1)) {
                            ht1Var = (ht1) obj;
                        } else {
                            ht1Var = new ht1(this.mSwanApiContext);
                            this.mApis.put("-420075743", ht1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ht1Var, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Router.reLoadErrorPage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = ht1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    ft1 ft1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("1792515533", ft1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ft1Var, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Router.redirectTo")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 D = ft1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    et1 et1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof et1)) {
                            et1Var = (et1) obj;
                        } else {
                            et1Var = new et1(this.mSwanApiContext);
                            this.mApis.put("1968522584", et1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(et1Var, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Router.showModalPage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 J = et1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    kt1 kt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof kt1)) {
                            kt1Var = (kt1) obj;
                        } else {
                            kt1Var = new kt1(this.mSwanApiContext);
                            this.mApis.put("-594895721", kt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(kt1Var, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Setting.getAppInfoSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 F = kt1Var.F();
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    kt1 kt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof kt1)) {
                            kt1Var = (kt1) obj;
                        } else {
                            kt1Var = new kt1(this.mSwanApiContext);
                            this.mApis.put("-594895721", kt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(kt1Var, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Setting.getSetting")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 G = kt1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    kt1 kt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof kt1)) {
                            kt1Var = (kt1) obj;
                        } else {
                            kt1Var = new kt1(this.mSwanApiContext);
                            this.mApis.put("-594895721", kt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(kt1Var, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Setting.getSlaveIdSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 H = kt1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    kt1 kt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof kt1)) {
                            kt1Var = (kt1) obj;
                        } else {
                            kt1Var = new kt1(this.mSwanApiContext);
                            this.mApis.put("-594895721", kt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(kt1Var, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Setting.getSwanId")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 I = kt1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    kt1 kt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof kt1)) {
                            kt1Var = (kt1) obj;
                        } else {
                            kt1Var = new kt1(this.mSwanApiContext);
                            this.mApis.put("-594895721", kt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(kt1Var, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Setting.getUserInfo")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 J = kt1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    jt1 jt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof jt1)) {
                            jt1Var = (jt1) obj;
                        } else {
                            jt1Var = new jt1(this.mSwanApiContext);
                            this.mApis.put("450273045", jt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(jt1Var, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Setting.isAllowedAdOpenAppSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = jt1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    ia3 ia3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof ia3)) {
                            ia3Var = (ia3) obj;
                        } else {
                            ia3Var = new ia3(this.mSwanApiContext);
                            this.mApis.put("712777136", ia3Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ia3Var, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = ia3Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    nt1 nt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("-804054859", nt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(nt1Var, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = nt1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    nt1 nt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("-804054859", nt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(nt1Var, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorageSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 C = nt1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    mt1 mt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("130910081", mt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(mt1Var, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.clearStorage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = mt1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    mt1 mt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("130910081", mt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(mt1Var, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.clearStorageSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 C = mt1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("-804054859", nt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(nt1Var, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.getGlobalStorage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 D = nt1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    nt1 nt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("-804054859", nt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(nt1Var, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfo")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 G = nt1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    nt1 nt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("-804054859", nt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(nt1Var, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfoSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 J = nt1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("-804054859", nt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(nt1Var, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 K = nt1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    mt1 mt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("130910081", mt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(mt1Var, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.getStorage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 D = mt1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    mt1 mt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("130910081", mt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(mt1Var, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.getStorageInfo")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 G = mt1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    mt1 mt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("130910081", mt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(mt1Var, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.getStorageInfoAsync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 H = mt1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    mt1 mt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("130910081", mt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(mt1Var, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.getStorageInfoSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 J = mt1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    mt1 mt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("130910081", mt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(mt1Var, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.getStorageSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 K = mt1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("-804054859", nt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(nt1Var, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 R = nt1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("-804054859", nt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(nt1Var, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorageSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 T = nt1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    mt1 mt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("130910081", mt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(mt1Var, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.removeStorage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 R = mt1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    mt1 mt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("130910081", mt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(mt1Var, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.removeStorageSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 T = mt1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("-804054859", nt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(nt1Var, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.setGlobalStorage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 U = nt1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("-804054859", nt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(nt1Var, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.setGlobalStorageSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 W = nt1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    mt1 mt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("130910081", mt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(mt1Var, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.setStorage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 U = mt1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    mt1 mt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("130910081", mt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(mt1Var, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Storage.setStorageSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 W = mt1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    pt1 pt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof pt1)) {
                            pt1Var = (pt1) obj;
                        } else {
                            pt1Var = new pt1(this.mSwanApiContext);
                            this.mApis.put("823117982", pt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(pt1Var, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Subscription.requestSubscribeFormId")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 E = pt1Var.E(str);
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    qt1 qt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof qt1)) {
                            qt1Var = (qt1) obj;
                        } else {
                            qt1Var = new qt1(this.mSwanApiContext);
                            this.mApis.put("-947445811", qt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(qt1Var, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Subscription.subscribeService")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 F = qt1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    xt1 xt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof xt1)) {
                            xt1Var = (xt1) obj;
                        } else {
                            xt1Var = new xt1(this.mSwanApiContext);
                            this.mApis.put("1936205521", xt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(xt1Var, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.exitFullScreen")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = xt1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    tt1 tt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof tt1)) {
                            tt1Var = (tt1) obj;
                        } else {
                            tt1Var = new tt1(this.mSwanApiContext);
                            this.mApis.put("99997465", tt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(tt1Var, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.getBrightness")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = tt1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    ut1 ut1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof ut1)) {
                            ut1Var = (ut1) obj;
                        } else {
                            ut1Var = new ut1(this.mSwanApiContext);
                            this.mApis.put("-518757484", ut1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ut1Var, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.getClipboardData")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = ut1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    wt1 wt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof wt1)) {
                            wt1Var = (wt1) obj;
                        } else {
                            wt1Var = new wt1(this.mSwanApiContext);
                            this.mApis.put("1694151270", wt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(wt1Var, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.getDeviceInfo")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = wt1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    yt1 yt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof yt1)) {
                            yt1Var = (yt1) obj;
                        } else {
                            yt1Var = new yt1(this.mSwanApiContext);
                            this.mApis.put("-1321681619", yt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(yt1Var, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.getDeviceProfile")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = yt1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    eu1 eu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof eu1)) {
                            eu1Var = (eu1) obj;
                        } else {
                            eu1Var = new eu1(this.mSwanApiContext);
                            this.mApis.put("447234992", eu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(eu1Var, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.getMediaVolume")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = eu1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    zt1 zt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof zt1)) {
                            zt1Var = (zt1) obj;
                        } else {
                            zt1Var = new zt1(this.mSwanApiContext);
                            this.mApis.put("-1569246082", zt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(zt1Var, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.makePhoneCall")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = zt1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    bu1 bu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof bu1)) {
                            bu1Var = (bu1) obj;
                        } else {
                            bu1Var = new bu1(this.mSwanApiContext);
                            this.mApis.put("1099851202", bu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(bu1Var, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.openSMSPanel")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = bu1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    au1 au1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof au1)) {
                            au1Var = (au1) obj;
                        } else {
                            au1Var = new au1(this.mSwanApiContext);
                            this.mApis.put("-1707203360", au1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(au1Var, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.requestFullScreen")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 F = au1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    ut1 ut1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof ut1)) {
                            ut1Var = (ut1) obj;
                        } else {
                            ut1Var = new ut1(this.mSwanApiContext);
                            this.mApis.put("-518757484", ut1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ut1Var, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.setClipboardData")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = ut1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    et2 et2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof et2)) {
                            et2Var = (et2) obj;
                        } else {
                            et2Var = new et2(this.mSwanApiContext);
                            this.mApis.put("1161486049", et2Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(et2Var, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.setErrorPageType")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = et2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    eu1 eu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof eu1)) {
                            eu1Var = (eu1) obj;
                        } else {
                            eu1Var = new eu1(this.mSwanApiContext);
                            this.mApis.put("447234992", eu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(eu1Var, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.setMediaVolume")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 z = eu1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    st1 st1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof st1)) {
                            st1Var = (st1) obj;
                        } else {
                            st1Var = new st1(this.mSwanApiContext);
                            this.mApis.put("1372680763", st1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(st1Var, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.startAccelerometer")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = st1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    vt1 vt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof vt1)) {
                            vt1Var = (vt1) obj;
                        } else {
                            vt1Var = new vt1(this.mSwanApiContext);
                            this.mApis.put("1689255576", vt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(vt1Var, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.startCompass")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = vt1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    st1 st1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof st1)) {
                            st1Var = (st1) obj;
                        } else {
                            st1Var = new st1(this.mSwanApiContext);
                            this.mApis.put("1372680763", st1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(st1Var, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.stopAccelerometer")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 B = st1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    vt1 vt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof vt1)) {
                            vt1Var = (vt1) obj;
                        } else {
                            vt1Var = new vt1(this.mSwanApiContext);
                            this.mApis.put("1689255576", vt1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(vt1Var, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "System.stopCompass")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 z = vt1Var.z();
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    pu1 pu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof pu1)) {
                            pu1Var = (pu1) obj;
                        } else {
                            pu1Var = new pu1(this.mSwanApiContext);
                            this.mApis.put("201194468", pu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(pu1Var, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.addToDesktop")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 B = pu1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    lu1 lu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof lu1)) {
                            lu1Var = (lu1) obj;
                        } else {
                            lu1Var = new lu1(this.mSwanApiContext);
                            this.mApis.put("-1412306947", lu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(lu1Var, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.calcMD5")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = lu1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    mu1 mu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof mu1)) {
                            mu1Var = (mu1) obj;
                        } else {
                            mu1Var = new mu1(this.mSwanApiContext);
                            this.mApis.put("1626415364", mu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(mu1Var, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.checkAppInstalled")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = mu1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    ou1 ou1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof ou1)) {
                            ou1Var = (ou1) obj;
                        } else {
                            ou1Var = new ou1(this.mSwanApiContext);
                            this.mApis.put("-836768778", ou1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ou1Var, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfo")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = ou1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    uu1 uu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof uu1)) {
                            uu1Var = (uu1) obj;
                        } else {
                            uu1Var = new uu1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", uu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(uu1Var, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfoSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 E = uu1Var.E();
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    qu1 qu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof qu1)) {
                            qu1Var = (qu1) obj;
                        } else {
                            qu1Var = new qu1(this.mSwanApiContext);
                            this.mApis.put("-810858308", qu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(qu1Var, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.getPerformanceLevel")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = qu1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    uu1 uu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof uu1)) {
                            uu1Var = (uu1) obj;
                        } else {
                            uu1Var = new uu1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", uu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(uu1Var, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.getSystemInfo")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 H = uu1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    uu1 uu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof uu1)) {
                            uu1Var = (uu1) obj;
                        } else {
                            uu1Var = new uu1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", uu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(uu1Var, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.getSystemInfoAsync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 I = uu1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    uu1 uu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof uu1)) {
                            uu1Var = (uu1) obj;
                        } else {
                            uu1Var = new uu1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", uu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(uu1Var, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.getSystemInfoSync")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 J = uu1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    ru1 ru1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof ru1)) {
                            ru1Var = (ru1) obj;
                        } else {
                            ru1Var = new ru1(this.mSwanApiContext);
                            this.mApis.put("-2097727681", ru1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(ru1Var, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.handleException")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = ru1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    nu1 nu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof nu1)) {
                            nu1Var = (nu1) obj;
                        } else {
                            nu1Var = new nu1(this.mSwanApiContext);
                            this.mApis.put("2084449317", nu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(nu1Var, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.hasCloseHandler")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = nu1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    q73 q73Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof q73)) {
                            q73Var = (q73) obj;
                        } else {
                            q73Var = new q73(this.mSwanApiContext);
                            this.mApis.put("1031678042", q73Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(q73Var, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.hideCaptureScreenShareDialog")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 x = q73Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    su1 su1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof su1)) {
                            su1Var = (su1) obj;
                        } else {
                            su1Var = new su1(this.mSwanApiContext);
                            this.mApis.put("1751900130", su1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(su1Var, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.logToFile")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 y = su1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    r63 r63Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof r63)) {
                            r63Var = (r63) obj;
                        } else {
                            r63Var = new r63(this.mSwanApiContext);
                            this.mApis.put("1748196865", r63Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(r63Var, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.preloadPackage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = r63Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    tu1 tu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof tu1)) {
                            tu1Var = (tu1) obj;
                        } else {
                            tu1Var = new tu1(this.mSwanApiContext);
                            this.mApis.put("589529211", tu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(tu1Var, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.previewImage")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 B = tu1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    wu1 wu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof wu1)) {
                            wu1Var = (wu1) obj;
                        } else {
                            wu1Var = new wu1(this.mSwanApiContext);
                            this.mApis.put("-577481801", wu1Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(wu1Var, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Utils.ubcFlowJar")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 I = wu1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(mr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public mr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = mr1Var;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    be3 be3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof be3)) {
                            be3Var = (be3) obj;
                        } else {
                            be3Var = new be3(this.mSwanApiContext);
                            this.mApis.put("1879401452", be3Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(be3Var, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Wifi.connectWifi")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 A = be3Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    be3 be3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof be3)) {
                            be3Var = (be3) obj;
                        } else {
                            be3Var = new be3(this.mSwanApiContext);
                            this.mApis.put("1879401452", be3Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(be3Var, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Wifi.getConnectedWifi")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 B = be3Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    be3 be3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof be3)) {
                            be3Var = (be3) obj;
                        } else {
                            be3Var = new be3(this.mSwanApiContext);
                            this.mApis.put("1879401452", be3Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(be3Var, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Wifi.getWifiList")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 C = be3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    be3 be3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof be3)) {
                            be3Var = (be3) obj;
                        } else {
                            be3Var = new be3(this.mSwanApiContext);
                            this.mApis.put("1879401452", be3Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(be3Var, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Wifi.startWifi")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 G = be3Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    be3 be3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof be3)) {
                            be3Var = (be3) obj;
                        } else {
                            be3Var = new be3(this.mSwanApiContext);
                            this.mApis.put("1879401452", be3Var);
                        }
                        Pair<Boolean, kv1> a = mv1.a(be3Var, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((kv1) a.second).a();
                        }
                        if (s52.a(this.mSwanApiContext.f(), "Wifi.stopWifi")) {
                            return new lv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        lv1 H = be3Var.H(str);
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
