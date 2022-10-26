package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.tieba.as1;
import com.baidu.tieba.at1;
import com.baidu.tieba.au1;
import com.baidu.tieba.bs1;
import com.baidu.tieba.bu1;
import com.baidu.tieba.ce3;
import com.baidu.tieba.cr1;
import com.baidu.tieba.cu1;
import com.baidu.tieba.dk1;
import com.baidu.tieba.dt2;
import com.baidu.tieba.es1;
import com.baidu.tieba.et1;
import com.baidu.tieba.f62;
import com.baidu.tieba.ft1;
import com.baidu.tieba.ft2;
import com.baidu.tieba.fu1;
import com.baidu.tieba.gs1;
import com.baidu.tieba.gt1;
import com.baidu.tieba.hs1;
import com.baidu.tieba.ht1;
import com.baidu.tieba.hu1;
import com.baidu.tieba.is1;
import com.baidu.tieba.it1;
import com.baidu.tieba.ja3;
import com.baidu.tieba.js1;
import com.baidu.tieba.jw2;
import com.baidu.tieba.ks1;
import com.baidu.tieba.kt1;
import com.baidu.tieba.kv1;
import com.baidu.tieba.ls1;
import com.baidu.tieba.lt1;
import com.baidu.tieba.lv1;
import com.baidu.tieba.ms1;
import com.baidu.tieba.mu1;
import com.baidu.tieba.mv1;
import com.baidu.tieba.n72;
import com.baidu.tieba.nr1;
import com.baidu.tieba.ns1;
import com.baidu.tieba.nt1;
import com.baidu.tieba.nu1;
import com.baidu.tieba.nv1;
import com.baidu.tieba.os1;
import com.baidu.tieba.ot1;
import com.baidu.tieba.ou1;
import com.baidu.tieba.pf3;
import com.baidu.tieba.pg2;
import com.baidu.tieba.pr1;
import com.baidu.tieba.ps1;
import com.baidu.tieba.pu1;
import com.baidu.tieba.qr1;
import com.baidu.tieba.qs1;
import com.baidu.tieba.qt1;
import com.baidu.tieba.qu1;
import com.baidu.tieba.r73;
import com.baidu.tieba.rt1;
import com.baidu.tieba.ru1;
import com.baidu.tieba.s63;
import com.baidu.tieba.sr1;
import com.baidu.tieba.su1;
import com.baidu.tieba.t52;
import com.baidu.tieba.tr1;
import com.baidu.tieba.ts1;
import com.baidu.tieba.tt1;
import com.baidu.tieba.tu1;
import com.baidu.tieba.ur1;
import com.baidu.tieba.ut1;
import com.baidu.tieba.uu1;
import com.baidu.tieba.uy2;
import com.baidu.tieba.vr1;
import com.baidu.tieba.vt1;
import com.baidu.tieba.vu1;
import com.baidu.tieba.wr1;
import com.baidu.tieba.wt1;
import com.baidu.tieba.xt1;
import com.baidu.tieba.xu1;
import com.baidu.tieba.yr1;
import com.baidu.tieba.yt1;
import com.baidu.tieba.zs1;
import com.baidu.tieba.zt1;
import com.baidu.tieba.zv2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
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

    public static Map getV8ApiModules(final nr1 nr1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, nr1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    tr1 tr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof tr1)) {
                            tr1Var = (tr1) obj;
                        } else {
                            tr1Var = new tr1(this.mSwanApiContext);
                            this.mApis.put("1930258908", tr1Var);
                        }
                        Pair a = nv1.a(tr1Var, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Account.checkSession")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = tr1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    ur1 ur1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ur1)) {
                            ur1Var = (ur1) obj;
                        } else {
                            ur1Var = new ur1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ur1Var);
                        }
                        Pair a = nv1.a(ur1Var, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Account.getLoginCode")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 C = ur1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    vr1 vr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof vr1)) {
                            vr1Var = (vr1) obj;
                        } else {
                            vr1Var = new vr1(this.mSwanApiContext);
                            this.mApis.put("1754780133", vr1Var);
                        }
                        Pair a = nv1.a(vr1Var, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Account.getOpenId")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = vr1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    cr1 cr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("-343998465", cr1Var);
                        }
                        Pair a = nv1.a(cr1Var, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Account.getUnionBDUSS")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = cr1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    ur1 ur1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ur1)) {
                            ur1Var = (ur1) obj;
                        } else {
                            ur1Var = new ur1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ur1Var);
                        }
                        Pair a = nv1.a(ur1Var, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Account.login")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 I = ur1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    sr1 sr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof sr1)) {
                            sr1Var = (sr1) obj;
                        } else {
                            sr1Var = new sr1(this.mSwanApiContext);
                            this.mApis.put("-337742792", sr1Var);
                        }
                        Pair a = nv1.a(sr1Var, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Account.isBaiduAccountSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = sr1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    ur1 ur1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ur1)) {
                            ur1Var = (ur1) obj;
                        } else {
                            ur1Var = new ur1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ur1Var);
                        }
                        Pair a = nv1.a(ur1Var, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Account.isLoginSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 H = ur1Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    wr1 wr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof wr1)) {
                            wr1Var = (wr1) obj;
                        } else {
                            wr1Var = new wr1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", wr1Var);
                        }
                        Pair a = nv1.a(wr1Var, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Basic.loadSubPackage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 F = wr1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    wr1 wr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof wr1)) {
                            wr1Var = (wr1) obj;
                        } else {
                            wr1Var = new wr1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", wr1Var);
                        }
                        Pair a = nv1.a(wr1Var, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Basic.loadSubPackages")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 G = wr1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    dk1 dk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof dk1)) {
                            dk1Var = (dk1) obj;
                        } else {
                            dk1Var = new dk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", dk1Var);
                        }
                        Pair a = nv1.a(dk1Var, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Bookshelf.deleteBookshelf")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 K = dk1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    dk1 dk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof dk1)) {
                            dk1Var = (dk1) obj;
                        } else {
                            dk1Var = new dk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", dk1Var);
                        }
                        Pair a = nv1.a(dk1Var, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Bookshelf.insertBookshelf")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 P = dk1Var.P(str);
                        if (P == null) {
                            return "";
                        }
                        return P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    dk1 dk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof dk1)) {
                            dk1Var = (dk1) obj;
                        } else {
                            dk1Var = new dk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", dk1Var);
                        }
                        Pair a = nv1.a(dk1Var, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Bookshelf.navigateToBookshelf")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 U = dk1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    dk1 dk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof dk1)) {
                            dk1Var = (dk1) obj;
                        } else {
                            dk1Var = new dk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", dk1Var);
                        }
                        Pair a = nv1.a(dk1Var, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Bookshelf.queryBookshelf")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 V = dk1Var.V(str);
                        if (V == null) {
                            return "";
                        }
                        return V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    dk1 dk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof dk1)) {
                            dk1Var = (dk1) obj;
                        } else {
                            dk1Var = new dk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", dk1Var);
                        }
                        Pair a = nv1.a(dk1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Bookshelf.updateBookshelfReadTime")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 X = dk1Var.X(str);
                        if (X == null) {
                            return "";
                        }
                        return X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    qr1 qr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof qr1)) {
                            qr1Var = (qr1) obj;
                        } else {
                            qr1Var = new qr1(this.mSwanApiContext);
                            this.mApis.put("-277316359", qr1Var);
                        }
                        Pair a = nv1.a(qr1Var, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Coupon.getPlatformCoupons")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = qr1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    qr1 qr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof qr1)) {
                            qr1Var = (qr1) obj;
                        } else {
                            qr1Var = new qr1(this.mSwanApiContext);
                            this.mApis.put("-277316359", qr1Var);
                        }
                        Pair a = nv1.a(qr1Var, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Coupon.getUserCoupons")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 z = qr1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    qr1 qr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof qr1)) {
                            qr1Var = (qr1) obj;
                        } else {
                            qr1Var = new qr1(this.mSwanApiContext);
                            this.mApis.put("-277316359", qr1Var);
                        }
                        Pair a = nv1.a(qr1Var, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Coupon.takeCoupons")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 C = qr1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    yr1 yr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof yr1)) {
                            yr1Var = (yr1) obj;
                        } else {
                            yr1Var = new yr1(this.mSwanApiContext);
                            this.mApis.put("-1225406515", yr1Var);
                        }
                        Pair a = nv1.a(yr1Var, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Favorite.getFavorStatus")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = yr1Var.x(str);
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
                        Pair a = nv1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Favorite.showFavoriteGuide")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 G = showFavoriteGuideApi.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    as1 as1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof as1)) {
                            as1Var = (as1) obj;
                        } else {
                            as1Var = new as1(this.mSwanApiContext);
                            this.mApis.put("-2057135077", as1Var);
                        }
                        Pair a = nv1.a(as1Var, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "File.shareFile")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = as1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    pg2 pg2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof pg2)) {
                            pg2Var = (pg2) obj;
                        } else {
                            pg2Var = new pg2(this.mSwanApiContext);
                            this.mApis.put("2077414795", pg2Var);
                        }
                        Pair a = nv1.a(pg2Var, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = pg2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    pg2 pg2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof pg2)) {
                            pg2Var = (pg2) obj;
                        } else {
                            pg2Var = new pg2(this.mSwanApiContext);
                            this.mApis.put("2077414795", pg2Var);
                        }
                        Pair a = nv1.a(pg2Var, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessageSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = pg2Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String download(String str) {
                    bs1 bs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof bs1)) {
                            bs1Var = (bs1) obj;
                        } else {
                            bs1Var = new bs1(this.mSwanApiContext);
                            this.mApis.put("-170124576", bs1Var);
                        }
                        Pair a = nv1.a(bs1Var, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "HostDownloadManager.download")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = bs1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    bs1 bs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof bs1)) {
                            bs1Var = (bs1) obj;
                        } else {
                            bs1Var = new bs1(this.mSwanApiContext);
                            this.mApis.put("-170124576", bs1Var);
                        }
                        Pair a = nv1.a(bs1Var, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "HostDownloadManager.openFile")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 z = bs1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    bs1 bs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof bs1)) {
                            bs1Var = (bs1) obj;
                        } else {
                            bs1Var = new bs1(this.mSwanApiContext);
                            this.mApis.put("-170124576", bs1Var);
                        }
                        Pair a = nv1.a(bs1Var, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "HostDownloadManager.query")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 query = bs1Var.query(str);
                        if (query == null) {
                            return "";
                        }
                        return query.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    bs1 bs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof bs1)) {
                            bs1Var = (bs1) obj;
                        } else {
                            bs1Var = new bs1(this.mSwanApiContext);
                            this.mApis.put("-170124576", bs1Var);
                        }
                        Pair a = nv1.a(bs1Var, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "HostDownloadManager.openDownloadCenter")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = bs1Var.y();
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naImage", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    dt2 dt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof dt2)) {
                            dt2Var = (dt2) obj;
                        } else {
                            dt2Var = new dt2(this.mSwanApiContext);
                            this.mApis.put("1445003743", dt2Var);
                        }
                        Pair a = nv1.a(dt2Var, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Image.callImageMenu")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = dt2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    es1 es1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof es1)) {
                            es1Var = (es1) obj;
                        } else {
                            es1Var = new es1(this.mSwanApiContext);
                            this.mApis.put("-1252730367", es1Var);
                        }
                        Pair a = nv1.a(es1Var, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Image.compressImage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = es1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    ms1 ms1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ms1)) {
                            ms1Var = (ms1) obj;
                        } else {
                            ms1Var = new ms1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ms1Var);
                        }
                        Pair a = nv1.a(ms1Var, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.closeTabBar")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = ms1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    ms1 ms1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ms1)) {
                            ms1Var = (ms1) obj;
                        } else {
                            ms1Var = new ms1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ms1Var);
                        }
                        Pair a = nv1.a(ms1Var, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.closeTabBarRedDot")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = ms1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    is1 is1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof is1)) {
                            is1Var = (is1) obj;
                        } else {
                            is1Var = new is1(this.mSwanApiContext);
                            this.mApis.put("-246386074", is1Var);
                        }
                        Pair a = nv1.a(is1Var, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.hideNavigationBarLoading")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = is1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    ks1 ks1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ks1)) {
                            ks1Var = (ks1) obj;
                        } else {
                            ks1Var = new ks1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ks1Var);
                        }
                        Pair a = nv1.a(ks1Var, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.openMultiPicker")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 G = ks1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    ks1 ks1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ks1)) {
                            ks1Var = (ks1) obj;
                        } else {
                            ks1Var = new ks1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ks1Var);
                        }
                        Pair a = nv1.a(ks1Var, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.openPicker")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 H = ks1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    ms1 ms1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ms1)) {
                            ms1Var = (ms1) obj;
                        } else {
                            ms1Var = new ms1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ms1Var);
                        }
                        Pair a = nv1.a(ms1Var, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.openTabBar")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 C = ms1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    js1 js1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof js1)) {
                            js1Var = (js1) obj;
                        } else {
                            js1Var = new js1(this.mSwanApiContext);
                            this.mApis.put("-1750613704", js1Var);
                        }
                        Pair a = nv1.a(js1Var, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.pageScrollTo")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = js1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    is1 is1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof is1)) {
                            is1Var = (is1) obj;
                        } else {
                            is1Var = new is1(this.mSwanApiContext);
                            this.mApis.put("-246386074", is1Var);
                        }
                        Pair a = nv1.a(is1Var, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarColor")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 z = is1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    is1 is1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof is1)) {
                            is1Var = (is1) obj;
                        } else {
                            is1Var = new is1(this.mSwanApiContext);
                            this.mApis.put("-246386074", is1Var);
                        }
                        Pair a = nv1.a(is1Var, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarTitle")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = is1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    ms1 ms1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ms1)) {
                            ms1Var = (ms1) obj;
                        } else {
                            ms1Var = new ms1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ms1Var);
                        }
                        Pair a = nv1.a(ms1Var, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.setTabBarItem")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 D = ms1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    ks1 ks1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ks1)) {
                            ks1Var = (ks1) obj;
                        } else {
                            ks1Var = new ks1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ks1Var);
                        }
                        Pair a = nv1.a(ks1Var, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.showDatePickerView")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 L = ks1Var.L(str);
                        if (L == null) {
                            return "";
                        }
                        return L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    os1 os1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof os1)) {
                            os1Var = (os1) obj;
                        } else {
                            os1Var = new os1(this.mSwanApiContext);
                            this.mApis.put("1172469410", os1Var);
                        }
                        Pair a = nv1.a(os1Var, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.showHalfScreenWebview")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 K = os1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    gs1 gs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof gs1)) {
                            gs1Var = (gs1) obj;
                        } else {
                            gs1Var = new gs1(this.mSwanApiContext);
                            this.mApis.put("5236036", gs1Var);
                        }
                        Pair a = nv1.a(gs1Var, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.showLoading")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = gs1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    hs1 hs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof hs1)) {
                            hs1Var = (hs1) obj;
                        } else {
                            hs1Var = new hs1(this.mSwanApiContext);
                            this.mApis.put("1913747800", hs1Var);
                        }
                        Pair a = nv1.a(hs1Var, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.showModal")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = hs1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    is1 is1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof is1)) {
                            is1Var = (is1) obj;
                        } else {
                            is1Var = new is1(this.mSwanApiContext);
                            this.mApis.put("-246386074", is1Var);
                        }
                        Pair a = nv1.a(is1Var, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.showNavigationBarLoading")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 B = is1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    ns1 ns1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof ns1)) {
                            ns1Var = (ns1) obj;
                        } else {
                            ns1Var = new ns1(this.mSwanApiContext);
                            this.mApis.put("1159492510", ns1Var);
                        }
                        Pair a = nv1.a(ns1Var, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.showToast")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 Q = ns1Var.Q(str);
                        if (Q == null) {
                            return "";
                        }
                        return Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    ls1 ls1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof ls1)) {
                            ls1Var = (ls1) obj;
                        } else {
                            ls1Var = new ls1(this.mSwanApiContext);
                            this.mApis.put("1165118609", ls1Var);
                        }
                        Pair a = nv1.a(ls1Var, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.stopPullDownRefresh")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = ls1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    ks1 ks1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ks1)) {
                            ks1Var = (ks1) obj;
                        } else {
                            ks1Var = new ks1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ks1Var);
                        }
                        Pair a = nv1.a(ks1Var, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.updateMultiPicker")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 M = ks1Var.M(str);
                        if (M == null) {
                            return "";
                        }
                        return M.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    gs1 gs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof gs1)) {
                            gs1Var = (gs1) obj;
                        } else {
                            gs1Var = new gs1(this.mSwanApiContext);
                            this.mApis.put("5236036", gs1Var);
                        }
                        Pair a = nv1.a(gs1Var, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.hideLoading")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = gs1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    ns1 ns1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof ns1)) {
                            ns1Var = (ns1) obj;
                        } else {
                            ns1Var = new ns1(this.mSwanApiContext);
                            this.mApis.put("1159492510", ns1Var);
                        }
                        Pair a = nv1.a(ns1Var, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.hideToast")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 K = ns1Var.K();
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    ps1 ps1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof ps1)) {
                            ps1Var = (ps1) obj;
                        } else {
                            ps1Var = new ps1(this.mSwanApiContext);
                            this.mApis.put("-137346255", ps1Var);
                        }
                        Pair a = nv1.a(ps1Var, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Keyboard.startKeyboardHeightChange")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 C = ps1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    ps1 ps1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof ps1)) {
                            ps1Var = (ps1) obj;
                        } else {
                            ps1Var = new ps1(this.mSwanApiContext);
                            this.mApis.put("-137346255", ps1Var);
                        }
                        Pair a = nv1.a(ps1Var, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Keyboard.stopKeyboardHeightChange")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 D = ps1Var.D();
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    qs1 qs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof qs1)) {
                            qs1Var = (qs1) obj;
                        } else {
                            qs1Var = new qs1(this.mSwanApiContext);
                            this.mApis.put("-397373095", qs1Var);
                        }
                        Pair a = nv1.a(qs1Var, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "LocationService.getLocation")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = qs1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    qs1 qs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof qs1)) {
                            qs1Var = (qs1) obj;
                        } else {
                            qs1Var = new qs1(this.mSwanApiContext);
                            this.mApis.put("-397373095", qs1Var);
                        }
                        Pair a = nv1.a(qs1Var, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "LocationService.startLocationUpdate")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = qs1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    qs1 qs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof qs1)) {
                            qs1Var = (qs1) obj;
                        } else {
                            qs1Var = new qs1(this.mSwanApiContext);
                            this.mApis.put("-397373095", qs1Var);
                        }
                        Pair a = nv1.a(qs1Var, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "LocationService.stopLocationUpdate")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 B = qs1Var.B();
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    hu1 hu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("538070032", hu1Var);
                        }
                        Pair a = nv1.a(hu1Var, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = hu1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String callService(String str) {
                    ts1 ts1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof ts1)) {
                            ts1Var = (ts1) obj;
                        } else {
                            ts1Var = new ts1(this.mSwanApiContext);
                            this.mApis.put("-1076509454", ts1Var);
                        }
                        Pair a = nv1.a(ts1Var, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Network.callService")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = ts1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    at1 at1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("968563034", at1Var);
                        }
                        Pair a = nv1.a(at1Var, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Network.cancelRequest")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 D = at1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    zs1 zs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("453220699", zs1Var);
                        }
                        Pair a = nv1.a(zs1Var, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Network.networkStatusChange")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = zs1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    zs1 zs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("453220699", zs1Var);
                        }
                        Pair a = nv1.a(zs1Var, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Network.getNetworkType")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = zs1Var.x();
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
                    at1 at1Var;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, jsObject)) == null) {
                        try {
                            kv1.c().a("request");
                            Object obj = this.mApis.get("968563034");
                            if (obj != null && (obj instanceof at1)) {
                                at1Var = (at1) obj;
                            } else {
                                at1Var = new at1(this.mSwanApiContext);
                                this.mApis.put("968563034", at1Var);
                            }
                            Pair a2 = nv1.a(at1Var, "swanAPI/request");
                            if (((Boolean) a2.first).booleanValue()) {
                                a = ((lv1) a2.second).a();
                            } else if (t52.a(this.mSwanApiContext.f(), "Network.request")) {
                                a = new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            } else {
                                Pair t = pr1.t(jsObject);
                                if (!((lv1) t.first).isSuccess()) {
                                    a = ((lv1) t.first).a();
                                } else {
                                    JSONObject jSONObject = (JSONObject) t.second;
                                    if (jSONObject == null) {
                                        a = lv1.a.a();
                                    } else {
                                        mv1 V = at1Var.V(jSONObject);
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
            hashMap.put("_naPayment", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    jw2 jw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof jw2)) {
                            jw2Var = (jw2) obj;
                        } else {
                            jw2Var = new jw2(this.mSwanApiContext);
                            this.mApis.put("-336396851", jw2Var);
                        }
                        Pair a = nv1.a(jw2Var, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Payment.chooseCoupon")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = jw2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    jw2 jw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof jw2)) {
                            jw2Var = (jw2) obj;
                        } else {
                            jw2Var = new jw2(this.mSwanApiContext);
                            this.mApis.put("-336396851", jw2Var);
                        }
                        Pair a = nv1.a(jw2Var, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Payment.getPaymentInfo")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = jw2Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    zv2 zv2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof zv2)) {
                            zv2Var = (zv2) obj;
                        } else {
                            zv2Var = new zv2(this.mSwanApiContext);
                            this.mApis.put("1854689529", zv2Var);
                        }
                        Pair a = nv1.a(zv2Var, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Payment.requestThirdPayment")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = zv2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    jw2 jw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof jw2)) {
                            jw2Var = (jw2) obj;
                        } else {
                            jw2Var = new jw2(this.mSwanApiContext);
                            this.mApis.put("-336396851", jw2Var);
                        }
                        Pair a = nv1.a(jw2Var, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Payment.setPaymentInfo")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 z = jw2Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    uy2 uy2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof uy2)) {
                            uy2Var = (uy2) obj;
                        } else {
                            uy2Var = new uy2(this.mSwanApiContext);
                            this.mApis.put("-254510461", uy2Var);
                        }
                        Pair a = nv1.a(uy2Var, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Plugin.invokePluginChooseAddress")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = uy2Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    uy2 uy2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof uy2)) {
                            uy2Var = (uy2) obj;
                        } else {
                            uy2Var = new uy2(this.mSwanApiContext);
                            this.mApis.put("-254510461", uy2Var);
                        }
                        Pair a = nv1.a(uy2Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 z = uy2Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    uy2 uy2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof uy2)) {
                            uy2Var = (uy2) obj;
                        } else {
                            uy2Var = new uy2(this.mSwanApiContext);
                            this.mApis.put("-254510461", uy2Var);
                        }
                        Pair a = nv1.a(uy2Var, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Plugin.invokePluginPayment")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = uy2Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    n72 n72Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof n72)) {
                            n72Var = (n72) obj;
                        } else {
                            n72Var = new n72(this.mSwanApiContext);
                            this.mApis.put("-2068479848", n72Var);
                        }
                        Pair a = nv1.a(n72Var, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Prefetch.prefetchResources")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = n72Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    f62 f62Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof f62)) {
                            f62Var = (f62) obj;
                        } else {
                            f62Var = new f62(this.mSwanApiContext);
                            this.mApis.put("423661539", f62Var);
                        }
                        Pair a = nv1.a(f62Var, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Preload.preloadStatus")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = f62Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    pf3 pf3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof pf3)) {
                            pf3Var = (pf3) obj;
                        } else {
                            pf3Var = new pf3(this.mSwanApiContext);
                            this.mApis.put("-1929343869", pf3Var);
                        }
                        Pair a = nv1.a(pf3Var, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "PrivateFile.uploadFileToBos")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 C = pf3Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    et1 et1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof et1)) {
                            et1Var = (et1) obj;
                        } else {
                            et1Var = new et1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", et1Var);
                        }
                        Pair a = nv1.a(et1Var, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Router.hideModalPage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = et1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    et1 et1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof et1)) {
                            et1Var = (et1) obj;
                        } else {
                            et1Var = new et1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", et1Var);
                        }
                        Pair a = nv1.a(et1Var, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Router.navigateBack")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 B = et1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    ft1 ft1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("1968522584", ft1Var);
                        }
                        Pair a = nv1.a(ft1Var, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Router.navigateTo")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 H = ft1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    ht1 ht1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof ht1)) {
                            ht1Var = (ht1) obj;
                        } else {
                            ht1Var = new ht1(this.mSwanApiContext);
                            this.mApis.put("1317280190", ht1Var);
                        }
                        Pair a = nv1.a(ht1Var, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Router.reLaunch")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = ht1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    it1 it1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof it1)) {
                            it1Var = (it1) obj;
                        } else {
                            it1Var = new it1(this.mSwanApiContext);
                            this.mApis.put("-420075743", it1Var);
                        }
                        Pair a = nv1.a(it1Var, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Router.reLoadErrorPage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = it1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    gt1 gt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof gt1)) {
                            gt1Var = (gt1) obj;
                        } else {
                            gt1Var = new gt1(this.mSwanApiContext);
                            this.mApis.put("1792515533", gt1Var);
                        }
                        Pair a = nv1.a(gt1Var, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Router.redirectTo")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 D = gt1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    ft1 ft1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("1968522584", ft1Var);
                        }
                        Pair a = nv1.a(ft1Var, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Router.showModalPage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 J = ft1Var.J(str);
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    lt1 lt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof lt1)) {
                            lt1Var = (lt1) obj;
                        } else {
                            lt1Var = new lt1(this.mSwanApiContext);
                            this.mApis.put("-594895721", lt1Var);
                        }
                        Pair a = nv1.a(lt1Var, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Setting.getAppInfoSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 F = lt1Var.F();
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    lt1 lt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof lt1)) {
                            lt1Var = (lt1) obj;
                        } else {
                            lt1Var = new lt1(this.mSwanApiContext);
                            this.mApis.put("-594895721", lt1Var);
                        }
                        Pair a = nv1.a(lt1Var, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Setting.getSlaveIdSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 H = lt1Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    kt1 kt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof kt1)) {
                            kt1Var = (kt1) obj;
                        } else {
                            kt1Var = new kt1(this.mSwanApiContext);
                            this.mApis.put("450273045", kt1Var);
                        }
                        Pair a = nv1.a(kt1Var, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Setting.isAllowedAdOpenAppSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = kt1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    lt1 lt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof lt1)) {
                            lt1Var = (lt1) obj;
                        } else {
                            lt1Var = new lt1(this.mSwanApiContext);
                            this.mApis.put("-594895721", lt1Var);
                        }
                        Pair a = nv1.a(lt1Var, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Setting.getSetting")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 G = lt1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    lt1 lt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof lt1)) {
                            lt1Var = (lt1) obj;
                        } else {
                            lt1Var = new lt1(this.mSwanApiContext);
                            this.mApis.put("-594895721", lt1Var);
                        }
                        Pair a = nv1.a(lt1Var, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Setting.getSwanId")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 I = lt1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    lt1 lt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof lt1)) {
                            lt1Var = (lt1) obj;
                        } else {
                            lt1Var = new lt1(this.mSwanApiContext);
                            this.mApis.put("-594895721", lt1Var);
                        }
                        Pair a = nv1.a(lt1Var, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Setting.getUserInfo")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 J = lt1Var.J(str);
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    ja3 ja3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof ja3)) {
                            ja3Var = (ja3) obj;
                        } else {
                            ja3Var = new ja3(this.mSwanApiContext);
                            this.mApis.put("712777136", ja3Var);
                        }
                        Pair a = nv1.a(ja3Var, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = ja3Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    ot1 ot1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof ot1)) {
                            ot1Var = (ot1) obj;
                        } else {
                            ot1Var = new ot1(this.mSwanApiContext);
                            this.mApis.put("-804054859", ot1Var);
                        }
                        Pair a = nv1.a(ot1Var, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = ot1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    ot1 ot1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof ot1)) {
                            ot1Var = (ot1) obj;
                        } else {
                            ot1Var = new ot1(this.mSwanApiContext);
                            this.mApis.put("-804054859", ot1Var);
                        }
                        Pair a = nv1.a(ot1Var, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorageSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 C = ot1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    nt1 nt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("130910081", nt1Var);
                        }
                        Pair a = nv1.a(nt1Var, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.clearStorage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = nt1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    nt1 nt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("130910081", nt1Var);
                        }
                        Pair a = nv1.a(nt1Var, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.clearStorageSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 C = nt1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    ot1 ot1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof ot1)) {
                            ot1Var = (ot1) obj;
                        } else {
                            ot1Var = new ot1(this.mSwanApiContext);
                            this.mApis.put("-804054859", ot1Var);
                        }
                        Pair a = nv1.a(ot1Var, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfo")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 G = ot1Var.G();
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    ot1 ot1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof ot1)) {
                            ot1Var = (ot1) obj;
                        } else {
                            ot1Var = new ot1(this.mSwanApiContext);
                            this.mApis.put("-804054859", ot1Var);
                        }
                        Pair a = nv1.a(ot1Var, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfoSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 J = ot1Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    nt1 nt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("130910081", nt1Var);
                        }
                        Pair a = nv1.a(nt1Var, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.getStorageInfo")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 G = nt1Var.G();
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    nt1 nt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("130910081", nt1Var);
                        }
                        Pair a = nv1.a(nt1Var, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.getStorageInfoSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 J = nt1Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    ot1 ot1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof ot1)) {
                            ot1Var = (ot1) obj;
                        } else {
                            ot1Var = new ot1(this.mSwanApiContext);
                            this.mApis.put("-804054859", ot1Var);
                        }
                        Pair a = nv1.a(ot1Var, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.getGlobalStorage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 D = ot1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    ot1 ot1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof ot1)) {
                            ot1Var = (ot1) obj;
                        } else {
                            ot1Var = new ot1(this.mSwanApiContext);
                            this.mApis.put("-804054859", ot1Var);
                        }
                        Pair a = nv1.a(ot1Var, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 K = ot1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("130910081", nt1Var);
                        }
                        Pair a = nv1.a(nt1Var, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.getStorage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 D = nt1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("130910081", nt1Var);
                        }
                        Pair a = nv1.a(nt1Var, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.getStorageInfoAsync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 H = nt1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("130910081", nt1Var);
                        }
                        Pair a = nv1.a(nt1Var, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.getStorageSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 K = nt1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    ot1 ot1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof ot1)) {
                            ot1Var = (ot1) obj;
                        } else {
                            ot1Var = new ot1(this.mSwanApiContext);
                            this.mApis.put("-804054859", ot1Var);
                        }
                        Pair a = nv1.a(ot1Var, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 R = ot1Var.R(str);
                        if (R == null) {
                            return "";
                        }
                        return R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    ot1 ot1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof ot1)) {
                            ot1Var = (ot1) obj;
                        } else {
                            ot1Var = new ot1(this.mSwanApiContext);
                            this.mApis.put("-804054859", ot1Var);
                        }
                        Pair a = nv1.a(ot1Var, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorageSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 T = ot1Var.T(str);
                        if (T == null) {
                            return "";
                        }
                        return T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("130910081", nt1Var);
                        }
                        Pair a = nv1.a(nt1Var, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.removeStorage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 R = nt1Var.R(str);
                        if (R == null) {
                            return "";
                        }
                        return R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("130910081", nt1Var);
                        }
                        Pair a = nv1.a(nt1Var, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.removeStorageSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 T = nt1Var.T(str);
                        if (T == null) {
                            return "";
                        }
                        return T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    ot1 ot1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof ot1)) {
                            ot1Var = (ot1) obj;
                        } else {
                            ot1Var = new ot1(this.mSwanApiContext);
                            this.mApis.put("-804054859", ot1Var);
                        }
                        Pair a = nv1.a(ot1Var, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.setGlobalStorage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 U = ot1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    ot1 ot1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof ot1)) {
                            ot1Var = (ot1) obj;
                        } else {
                            ot1Var = new ot1(this.mSwanApiContext);
                            this.mApis.put("-804054859", ot1Var);
                        }
                        Pair a = nv1.a(ot1Var, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.setGlobalStorageSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 W = ot1Var.W(str);
                        if (W == null) {
                            return "";
                        }
                        return W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("130910081", nt1Var);
                        }
                        Pair a = nv1.a(nt1Var, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.setStorage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 U = nt1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("130910081", nt1Var);
                        }
                        Pair a = nv1.a(nt1Var, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.setStorageSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 W = nt1Var.W(str);
                        if (W == null) {
                            return "";
                        }
                        return W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    qt1 qt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof qt1)) {
                            qt1Var = (qt1) obj;
                        } else {
                            qt1Var = new qt1(this.mSwanApiContext);
                            this.mApis.put("823117982", qt1Var);
                        }
                        Pair a = nv1.a(qt1Var, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Subscription.requestSubscribeFormId")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 E = qt1Var.E(str);
                        if (E == null) {
                            return "";
                        }
                        return E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    rt1 rt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof rt1)) {
                            rt1Var = (rt1) obj;
                        } else {
                            rt1Var = new rt1(this.mSwanApiContext);
                            this.mApis.put("-947445811", rt1Var);
                        }
                        Pair a = nv1.a(rt1Var, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Subscription.subscribeService")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 F = rt1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    yt1 yt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof yt1)) {
                            yt1Var = (yt1) obj;
                        } else {
                            yt1Var = new yt1(this.mSwanApiContext);
                            this.mApis.put("1936205521", yt1Var);
                        }
                        Pair a = nv1.a(yt1Var, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.exitFullScreen")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = yt1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    xt1 xt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof xt1)) {
                            xt1Var = (xt1) obj;
                        } else {
                            xt1Var = new xt1(this.mSwanApiContext);
                            this.mApis.put("1694151270", xt1Var);
                        }
                        Pair a = nv1.a(xt1Var, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.getDeviceInfo")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = xt1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    zt1 zt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof zt1)) {
                            zt1Var = (zt1) obj;
                        } else {
                            zt1Var = new zt1(this.mSwanApiContext);
                            this.mApis.put("-1321681619", zt1Var);
                        }
                        Pair a = nv1.a(zt1Var, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.getDeviceProfile")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = zt1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    au1 au1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof au1)) {
                            au1Var = (au1) obj;
                        } else {
                            au1Var = new au1(this.mSwanApiContext);
                            this.mApis.put("-1569246082", au1Var);
                        }
                        Pair a = nv1.a(au1Var, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.makePhoneCall")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = au1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    cu1 cu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof cu1)) {
                            cu1Var = (cu1) obj;
                        } else {
                            cu1Var = new cu1(this.mSwanApiContext);
                            this.mApis.put("1099851202", cu1Var);
                        }
                        Pair a = nv1.a(cu1Var, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.openSMSPanel")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = cu1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    bu1 bu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof bu1)) {
                            bu1Var = (bu1) obj;
                        } else {
                            bu1Var = new bu1(this.mSwanApiContext);
                            this.mApis.put("-1707203360", bu1Var);
                        }
                        Pair a = nv1.a(bu1Var, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.requestFullScreen")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 F = bu1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    vt1 vt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof vt1)) {
                            vt1Var = (vt1) obj;
                        } else {
                            vt1Var = new vt1(this.mSwanApiContext);
                            this.mApis.put("-518757484", vt1Var);
                        }
                        Pair a = nv1.a(vt1Var, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.setClipboardData")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = vt1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    ft2 ft2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof ft2)) {
                            ft2Var = (ft2) obj;
                        } else {
                            ft2Var = new ft2(this.mSwanApiContext);
                            this.mApis.put("1161486049", ft2Var);
                        }
                        Pair a = nv1.a(ft2Var, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.setErrorPageType")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = ft2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    fu1 fu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("447234992", fu1Var);
                        }
                        Pair a = nv1.a(fu1Var, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.setMediaVolume")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 z = fu1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    tt1 tt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof tt1)) {
                            tt1Var = (tt1) obj;
                        } else {
                            tt1Var = new tt1(this.mSwanApiContext);
                            this.mApis.put("1372680763", tt1Var);
                        }
                        Pair a = nv1.a(tt1Var, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.startAccelerometer")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = tt1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    wt1 wt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof wt1)) {
                            wt1Var = (wt1) obj;
                        } else {
                            wt1Var = new wt1(this.mSwanApiContext);
                            this.mApis.put("1689255576", wt1Var);
                        }
                        Pair a = nv1.a(wt1Var, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.startCompass")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = wt1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    ut1 ut1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof ut1)) {
                            ut1Var = (ut1) obj;
                        } else {
                            ut1Var = new ut1(this.mSwanApiContext);
                            this.mApis.put("99997465", ut1Var);
                        }
                        Pair a = nv1.a(ut1Var, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.getBrightness")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = ut1Var.y();
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    vt1 vt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof vt1)) {
                            vt1Var = (vt1) obj;
                        } else {
                            vt1Var = new vt1(this.mSwanApiContext);
                            this.mApis.put("-518757484", vt1Var);
                        }
                        Pair a = nv1.a(vt1Var, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.getClipboardData")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = vt1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    fu1 fu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("447234992", fu1Var);
                        }
                        Pair a = nv1.a(fu1Var, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.getMediaVolume")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = fu1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    tt1 tt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof tt1)) {
                            tt1Var = (tt1) obj;
                        } else {
                            tt1Var = new tt1(this.mSwanApiContext);
                            this.mApis.put("1372680763", tt1Var);
                        }
                        Pair a = nv1.a(tt1Var, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.stopAccelerometer")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 B = tt1Var.B();
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    wt1 wt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof wt1)) {
                            wt1Var = (wt1) obj;
                        } else {
                            wt1Var = new wt1(this.mSwanApiContext);
                            this.mApis.put("1689255576", wt1Var);
                        }
                        Pair a = nv1.a(wt1Var, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.stopCompass")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 z = wt1Var.z();
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    qu1 qu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof qu1)) {
                            qu1Var = (qu1) obj;
                        } else {
                            qu1Var = new qu1(this.mSwanApiContext);
                            this.mApis.put("201194468", qu1Var);
                        }
                        Pair a = nv1.a(qu1Var, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.addToDesktop")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 B = qu1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    mu1 mu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof mu1)) {
                            mu1Var = (mu1) obj;
                        } else {
                            mu1Var = new mu1(this.mSwanApiContext);
                            this.mApis.put("-1412306947", mu1Var);
                        }
                        Pair a = nv1.a(mu1Var, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.calcMD5")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = mu1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    nu1 nu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof nu1)) {
                            nu1Var = (nu1) obj;
                        } else {
                            nu1Var = new nu1(this.mSwanApiContext);
                            this.mApis.put("1626415364", nu1Var);
                        }
                        Pair a = nv1.a(nu1Var, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.checkAppInstalled")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = nu1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    pu1 pu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof pu1)) {
                            pu1Var = (pu1) obj;
                        } else {
                            pu1Var = new pu1(this.mSwanApiContext);
                            this.mApis.put("-836768778", pu1Var);
                        }
                        Pair a = nv1.a(pu1Var, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfo")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = pu1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    ru1 ru1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof ru1)) {
                            ru1Var = (ru1) obj;
                        } else {
                            ru1Var = new ru1(this.mSwanApiContext);
                            this.mApis.put("-810858308", ru1Var);
                        }
                        Pair a = nv1.a(ru1Var, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.getPerformanceLevel")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = ru1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    vu1 vu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof vu1)) {
                            vu1Var = (vu1) obj;
                        } else {
                            vu1Var = new vu1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", vu1Var);
                        }
                        Pair a = nv1.a(vu1Var, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.getSystemInfoAsync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 I = vu1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    su1 su1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof su1)) {
                            su1Var = (su1) obj;
                        } else {
                            su1Var = new su1(this.mSwanApiContext);
                            this.mApis.put("-2097727681", su1Var);
                        }
                        Pair a = nv1.a(su1Var, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.handleException")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = su1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    ou1 ou1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof ou1)) {
                            ou1Var = (ou1) obj;
                        } else {
                            ou1Var = new ou1(this.mSwanApiContext);
                            this.mApis.put("2084449317", ou1Var);
                        }
                        Pair a = nv1.a(ou1Var, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.hasCloseHandler")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = ou1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    r73 r73Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof r73)) {
                            r73Var = (r73) obj;
                        } else {
                            r73Var = new r73(this.mSwanApiContext);
                            this.mApis.put("1031678042", r73Var);
                        }
                        Pair a = nv1.a(r73Var, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.hideCaptureScreenShareDialog")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = r73Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    tu1 tu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof tu1)) {
                            tu1Var = (tu1) obj;
                        } else {
                            tu1Var = new tu1(this.mSwanApiContext);
                            this.mApis.put("1751900130", tu1Var);
                        }
                        Pair a = nv1.a(tu1Var, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.logToFile")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = tu1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    s63 s63Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof s63)) {
                            s63Var = (s63) obj;
                        } else {
                            s63Var = new s63(this.mSwanApiContext);
                            this.mApis.put("1748196865", s63Var);
                        }
                        Pair a = nv1.a(s63Var, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.preloadPackage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = s63Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    uu1 uu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof uu1)) {
                            uu1Var = (uu1) obj;
                        } else {
                            uu1Var = new uu1(this.mSwanApiContext);
                            this.mApis.put("589529211", uu1Var);
                        }
                        Pair a = nv1.a(uu1Var, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.previewImage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 B = uu1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    xu1 xu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof xu1)) {
                            xu1Var = (xu1) obj;
                        } else {
                            xu1Var = new xu1(this.mSwanApiContext);
                            this.mApis.put("-577481801", xu1Var);
                        }
                        Pair a = nv1.a(xu1Var, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.ubcFlowJar")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 I = xu1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    vu1 vu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof vu1)) {
                            vu1Var = (vu1) obj;
                        } else {
                            vu1Var = new vu1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", vu1Var);
                        }
                        Pair a = nv1.a(vu1Var, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfoSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 E = vu1Var.E();
                        if (E == null) {
                            return "";
                        }
                        return E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    vu1 vu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof vu1)) {
                            vu1Var = (vu1) obj;
                        } else {
                            vu1Var = new vu1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", vu1Var);
                        }
                        Pair a = nv1.a(vu1Var, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.getSystemInfo")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 H = vu1Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    vu1 vu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof vu1)) {
                            vu1Var = (vu1) obj;
                        } else {
                            vu1Var = new vu1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", vu1Var);
                        }
                        Pair a = nv1.a(vu1Var, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.getSystemInfoSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 J = vu1Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    ce3 ce3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ce3)) {
                            ce3Var = (ce3) obj;
                        } else {
                            ce3Var = new ce3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ce3Var);
                        }
                        Pair a = nv1.a(ce3Var, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Wifi.connectWifi")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = ce3Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    ce3 ce3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ce3)) {
                            ce3Var = (ce3) obj;
                        } else {
                            ce3Var = new ce3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ce3Var);
                        }
                        Pair a = nv1.a(ce3Var, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Wifi.getConnectedWifi")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 B = ce3Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    ce3 ce3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ce3)) {
                            ce3Var = (ce3) obj;
                        } else {
                            ce3Var = new ce3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ce3Var);
                        }
                        Pair a = nv1.a(ce3Var, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Wifi.getWifiList")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 C = ce3Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    ce3 ce3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ce3)) {
                            ce3Var = (ce3) obj;
                        } else {
                            ce3Var = new ce3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ce3Var);
                        }
                        Pair a = nv1.a(ce3Var, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Wifi.startWifi")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 G = ce3Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    ce3 ce3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ce3)) {
                            ce3Var = (ce3) obj;
                        } else {
                            ce3Var = new ce3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ce3Var);
                        }
                        Pair a = nv1.a(ce3Var, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Wifi.stopWifi")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 H = ce3Var.H(str);
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

    public static Map getWebviewApiModules(final nr1 nr1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, nr1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    tr1 tr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof tr1)) {
                            tr1Var = (tr1) obj;
                        } else {
                            tr1Var = new tr1(this.mSwanApiContext);
                            this.mApis.put("1930258908", tr1Var);
                        }
                        Pair a = nv1.a(tr1Var, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Account.checkSession")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = tr1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    ur1 ur1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ur1)) {
                            ur1Var = (ur1) obj;
                        } else {
                            ur1Var = new ur1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ur1Var);
                        }
                        Pair a = nv1.a(ur1Var, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Account.getLoginCode")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 C = ur1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    vr1 vr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof vr1)) {
                            vr1Var = (vr1) obj;
                        } else {
                            vr1Var = new vr1(this.mSwanApiContext);
                            this.mApis.put("1754780133", vr1Var);
                        }
                        Pair a = nv1.a(vr1Var, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Account.getOpenId")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = vr1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    cr1 cr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("-343998465", cr1Var);
                        }
                        Pair a = nv1.a(cr1Var, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Account.getUnionBDUSS")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = cr1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    ur1 ur1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ur1)) {
                            ur1Var = (ur1) obj;
                        } else {
                            ur1Var = new ur1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ur1Var);
                        }
                        Pair a = nv1.a(ur1Var, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Account.login")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 I = ur1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    sr1 sr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof sr1)) {
                            sr1Var = (sr1) obj;
                        } else {
                            sr1Var = new sr1(this.mSwanApiContext);
                            this.mApis.put("-337742792", sr1Var);
                        }
                        Pair a = nv1.a(sr1Var, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Account.isBaiduAccountSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = sr1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    ur1 ur1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ur1)) {
                            ur1Var = (ur1) obj;
                        } else {
                            ur1Var = new ur1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ur1Var);
                        }
                        Pair a = nv1.a(ur1Var, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Account.isLoginSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 H = ur1Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    wr1 wr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof wr1)) {
                            wr1Var = (wr1) obj;
                        } else {
                            wr1Var = new wr1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", wr1Var);
                        }
                        Pair a = nv1.a(wr1Var, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Basic.loadSubPackage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 F = wr1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    wr1 wr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof wr1)) {
                            wr1Var = (wr1) obj;
                        } else {
                            wr1Var = new wr1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", wr1Var);
                        }
                        Pair a = nv1.a(wr1Var, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Basic.loadSubPackages")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 G = wr1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    dk1 dk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof dk1)) {
                            dk1Var = (dk1) obj;
                        } else {
                            dk1Var = new dk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", dk1Var);
                        }
                        Pair a = nv1.a(dk1Var, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Bookshelf.deleteBookshelf")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 K = dk1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    dk1 dk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof dk1)) {
                            dk1Var = (dk1) obj;
                        } else {
                            dk1Var = new dk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", dk1Var);
                        }
                        Pair a = nv1.a(dk1Var, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Bookshelf.insertBookshelf")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 P = dk1Var.P(str);
                        if (P == null) {
                            return "";
                        }
                        return P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    dk1 dk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof dk1)) {
                            dk1Var = (dk1) obj;
                        } else {
                            dk1Var = new dk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", dk1Var);
                        }
                        Pair a = nv1.a(dk1Var, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Bookshelf.navigateToBookshelf")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 U = dk1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    dk1 dk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof dk1)) {
                            dk1Var = (dk1) obj;
                        } else {
                            dk1Var = new dk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", dk1Var);
                        }
                        Pair a = nv1.a(dk1Var, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Bookshelf.queryBookshelf")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 V = dk1Var.V(str);
                        if (V == null) {
                            return "";
                        }
                        return V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    dk1 dk1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof dk1)) {
                            dk1Var = (dk1) obj;
                        } else {
                            dk1Var = new dk1(this.mSwanApiContext);
                            this.mApis.put("1460300387", dk1Var);
                        }
                        Pair a = nv1.a(dk1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Bookshelf.updateBookshelfReadTime")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 X = dk1Var.X(str);
                        if (X == null) {
                            return "";
                        }
                        return X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    qr1 qr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof qr1)) {
                            qr1Var = (qr1) obj;
                        } else {
                            qr1Var = new qr1(this.mSwanApiContext);
                            this.mApis.put("-277316359", qr1Var);
                        }
                        Pair a = nv1.a(qr1Var, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Coupon.getPlatformCoupons")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = qr1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    qr1 qr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof qr1)) {
                            qr1Var = (qr1) obj;
                        } else {
                            qr1Var = new qr1(this.mSwanApiContext);
                            this.mApis.put("-277316359", qr1Var);
                        }
                        Pair a = nv1.a(qr1Var, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Coupon.getUserCoupons")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 z = qr1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    qr1 qr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof qr1)) {
                            qr1Var = (qr1) obj;
                        } else {
                            qr1Var = new qr1(this.mSwanApiContext);
                            this.mApis.put("-277316359", qr1Var);
                        }
                        Pair a = nv1.a(qr1Var, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Coupon.takeCoupons")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 C = qr1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    yr1 yr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof yr1)) {
                            yr1Var = (yr1) obj;
                        } else {
                            yr1Var = new yr1(this.mSwanApiContext);
                            this.mApis.put("-1225406515", yr1Var);
                        }
                        Pair a = nv1.a(yr1Var, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Favorite.getFavorStatus")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = yr1Var.x(str);
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
                        Pair a = nv1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Favorite.showFavoriteGuide")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 G = showFavoriteGuideApi.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    as1 as1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof as1)) {
                            as1Var = (as1) obj;
                        } else {
                            as1Var = new as1(this.mSwanApiContext);
                            this.mApis.put("-2057135077", as1Var);
                        }
                        Pair a = nv1.a(as1Var, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "File.shareFile")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = as1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    pg2 pg2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof pg2)) {
                            pg2Var = (pg2) obj;
                        } else {
                            pg2Var = new pg2(this.mSwanApiContext);
                            this.mApis.put("2077414795", pg2Var);
                        }
                        Pair a = nv1.a(pg2Var, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = pg2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    pg2 pg2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof pg2)) {
                            pg2Var = (pg2) obj;
                        } else {
                            pg2Var = new pg2(this.mSwanApiContext);
                            this.mApis.put("2077414795", pg2Var);
                        }
                        Pair a = nv1.a(pg2Var, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessageSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = pg2Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String download(String str) {
                    bs1 bs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof bs1)) {
                            bs1Var = (bs1) obj;
                        } else {
                            bs1Var = new bs1(this.mSwanApiContext);
                            this.mApis.put("-170124576", bs1Var);
                        }
                        Pair a = nv1.a(bs1Var, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "HostDownloadManager.download")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = bs1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    bs1 bs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof bs1)) {
                            bs1Var = (bs1) obj;
                        } else {
                            bs1Var = new bs1(this.mSwanApiContext);
                            this.mApis.put("-170124576", bs1Var);
                        }
                        Pair a = nv1.a(bs1Var, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "HostDownloadManager.openFile")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 z = bs1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    bs1 bs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof bs1)) {
                            bs1Var = (bs1) obj;
                        } else {
                            bs1Var = new bs1(this.mSwanApiContext);
                            this.mApis.put("-170124576", bs1Var);
                        }
                        Pair a = nv1.a(bs1Var, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "HostDownloadManager.query")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 query = bs1Var.query(str);
                        if (query == null) {
                            return "";
                        }
                        return query.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    bs1 bs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof bs1)) {
                            bs1Var = (bs1) obj;
                        } else {
                            bs1Var = new bs1(this.mSwanApiContext);
                            this.mApis.put("-170124576", bs1Var);
                        }
                        Pair a = nv1.a(bs1Var, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "HostDownloadManager.openDownloadCenter")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = bs1Var.y();
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naImage", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    dt2 dt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof dt2)) {
                            dt2Var = (dt2) obj;
                        } else {
                            dt2Var = new dt2(this.mSwanApiContext);
                            this.mApis.put("1445003743", dt2Var);
                        }
                        Pair a = nv1.a(dt2Var, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Image.callImageMenu")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = dt2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    es1 es1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof es1)) {
                            es1Var = (es1) obj;
                        } else {
                            es1Var = new es1(this.mSwanApiContext);
                            this.mApis.put("-1252730367", es1Var);
                        }
                        Pair a = nv1.a(es1Var, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Image.compressImage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = es1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    ms1 ms1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ms1)) {
                            ms1Var = (ms1) obj;
                        } else {
                            ms1Var = new ms1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ms1Var);
                        }
                        Pair a = nv1.a(ms1Var, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.closeTabBar")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = ms1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    ms1 ms1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ms1)) {
                            ms1Var = (ms1) obj;
                        } else {
                            ms1Var = new ms1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ms1Var);
                        }
                        Pair a = nv1.a(ms1Var, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.closeTabBarRedDot")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = ms1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    is1 is1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof is1)) {
                            is1Var = (is1) obj;
                        } else {
                            is1Var = new is1(this.mSwanApiContext);
                            this.mApis.put("-246386074", is1Var);
                        }
                        Pair a = nv1.a(is1Var, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.hideNavigationBarLoading")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = is1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    ks1 ks1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ks1)) {
                            ks1Var = (ks1) obj;
                        } else {
                            ks1Var = new ks1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ks1Var);
                        }
                        Pair a = nv1.a(ks1Var, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.openMultiPicker")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 G = ks1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    ks1 ks1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ks1)) {
                            ks1Var = (ks1) obj;
                        } else {
                            ks1Var = new ks1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ks1Var);
                        }
                        Pair a = nv1.a(ks1Var, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.openPicker")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 H = ks1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    ms1 ms1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ms1)) {
                            ms1Var = (ms1) obj;
                        } else {
                            ms1Var = new ms1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ms1Var);
                        }
                        Pair a = nv1.a(ms1Var, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.openTabBar")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 C = ms1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    js1 js1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof js1)) {
                            js1Var = (js1) obj;
                        } else {
                            js1Var = new js1(this.mSwanApiContext);
                            this.mApis.put("-1750613704", js1Var);
                        }
                        Pair a = nv1.a(js1Var, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.pageScrollTo")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = js1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    is1 is1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof is1)) {
                            is1Var = (is1) obj;
                        } else {
                            is1Var = new is1(this.mSwanApiContext);
                            this.mApis.put("-246386074", is1Var);
                        }
                        Pair a = nv1.a(is1Var, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarColor")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 z = is1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    is1 is1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof is1)) {
                            is1Var = (is1) obj;
                        } else {
                            is1Var = new is1(this.mSwanApiContext);
                            this.mApis.put("-246386074", is1Var);
                        }
                        Pair a = nv1.a(is1Var, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarTitle")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = is1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    ms1 ms1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ms1)) {
                            ms1Var = (ms1) obj;
                        } else {
                            ms1Var = new ms1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ms1Var);
                        }
                        Pair a = nv1.a(ms1Var, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.setTabBarItem")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 D = ms1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    ks1 ks1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ks1)) {
                            ks1Var = (ks1) obj;
                        } else {
                            ks1Var = new ks1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ks1Var);
                        }
                        Pair a = nv1.a(ks1Var, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.showDatePickerView")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 L = ks1Var.L(str);
                        if (L == null) {
                            return "";
                        }
                        return L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    os1 os1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof os1)) {
                            os1Var = (os1) obj;
                        } else {
                            os1Var = new os1(this.mSwanApiContext);
                            this.mApis.put("1172469410", os1Var);
                        }
                        Pair a = nv1.a(os1Var, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.showHalfScreenWebview")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 K = os1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    gs1 gs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof gs1)) {
                            gs1Var = (gs1) obj;
                        } else {
                            gs1Var = new gs1(this.mSwanApiContext);
                            this.mApis.put("5236036", gs1Var);
                        }
                        Pair a = nv1.a(gs1Var, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.showLoading")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = gs1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    hs1 hs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof hs1)) {
                            hs1Var = (hs1) obj;
                        } else {
                            hs1Var = new hs1(this.mSwanApiContext);
                            this.mApis.put("1913747800", hs1Var);
                        }
                        Pair a = nv1.a(hs1Var, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.showModal")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = hs1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    is1 is1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof is1)) {
                            is1Var = (is1) obj;
                        } else {
                            is1Var = new is1(this.mSwanApiContext);
                            this.mApis.put("-246386074", is1Var);
                        }
                        Pair a = nv1.a(is1Var, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.showNavigationBarLoading")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 B = is1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    ns1 ns1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof ns1)) {
                            ns1Var = (ns1) obj;
                        } else {
                            ns1Var = new ns1(this.mSwanApiContext);
                            this.mApis.put("1159492510", ns1Var);
                        }
                        Pair a = nv1.a(ns1Var, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.showToast")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 Q = ns1Var.Q(str);
                        if (Q == null) {
                            return "";
                        }
                        return Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    ls1 ls1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof ls1)) {
                            ls1Var = (ls1) obj;
                        } else {
                            ls1Var = new ls1(this.mSwanApiContext);
                            this.mApis.put("1165118609", ls1Var);
                        }
                        Pair a = nv1.a(ls1Var, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.stopPullDownRefresh")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = ls1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    ks1 ks1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ks1)) {
                            ks1Var = (ks1) obj;
                        } else {
                            ks1Var = new ks1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ks1Var);
                        }
                        Pair a = nv1.a(ks1Var, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.updateMultiPicker")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 M = ks1Var.M(str);
                        if (M == null) {
                            return "";
                        }
                        return M.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    gs1 gs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof gs1)) {
                            gs1Var = (gs1) obj;
                        } else {
                            gs1Var = new gs1(this.mSwanApiContext);
                            this.mApis.put("5236036", gs1Var);
                        }
                        Pair a = nv1.a(gs1Var, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.hideLoading")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = gs1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    ns1 ns1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof ns1)) {
                            ns1Var = (ns1) obj;
                        } else {
                            ns1Var = new ns1(this.mSwanApiContext);
                            this.mApis.put("1159492510", ns1Var);
                        }
                        Pair a = nv1.a(ns1Var, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Interaction.hideToast")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 K = ns1Var.K();
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    ps1 ps1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof ps1)) {
                            ps1Var = (ps1) obj;
                        } else {
                            ps1Var = new ps1(this.mSwanApiContext);
                            this.mApis.put("-137346255", ps1Var);
                        }
                        Pair a = nv1.a(ps1Var, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Keyboard.startKeyboardHeightChange")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 C = ps1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    ps1 ps1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof ps1)) {
                            ps1Var = (ps1) obj;
                        } else {
                            ps1Var = new ps1(this.mSwanApiContext);
                            this.mApis.put("-137346255", ps1Var);
                        }
                        Pair a = nv1.a(ps1Var, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Keyboard.stopKeyboardHeightChange")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 D = ps1Var.D();
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    qs1 qs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof qs1)) {
                            qs1Var = (qs1) obj;
                        } else {
                            qs1Var = new qs1(this.mSwanApiContext);
                            this.mApis.put("-397373095", qs1Var);
                        }
                        Pair a = nv1.a(qs1Var, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "LocationService.getLocation")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = qs1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    qs1 qs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof qs1)) {
                            qs1Var = (qs1) obj;
                        } else {
                            qs1Var = new qs1(this.mSwanApiContext);
                            this.mApis.put("-397373095", qs1Var);
                        }
                        Pair a = nv1.a(qs1Var, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "LocationService.startLocationUpdate")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = qs1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    qs1 qs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof qs1)) {
                            qs1Var = (qs1) obj;
                        } else {
                            qs1Var = new qs1(this.mSwanApiContext);
                            this.mApis.put("-397373095", qs1Var);
                        }
                        Pair a = nv1.a(qs1Var, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "LocationService.stopLocationUpdate")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 B = qs1Var.B();
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    hu1 hu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("538070032", hu1Var);
                        }
                        Pair a = nv1.a(hu1Var, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = hu1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String callService(String str) {
                    ts1 ts1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof ts1)) {
                            ts1Var = (ts1) obj;
                        } else {
                            ts1Var = new ts1(this.mSwanApiContext);
                            this.mApis.put("-1076509454", ts1Var);
                        }
                        Pair a = nv1.a(ts1Var, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Network.callService")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = ts1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    at1 at1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("968563034", at1Var);
                        }
                        Pair a = nv1.a(at1Var, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Network.cancelRequest")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 D = at1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    zs1 zs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("453220699", zs1Var);
                        }
                        Pair a = nv1.a(zs1Var, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Network.networkStatusChange")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = zs1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    zs1 zs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("453220699", zs1Var);
                        }
                        Pair a = nv1.a(zs1Var, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Network.getNetworkType")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = zs1Var.x();
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
                    at1 at1Var;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        try {
                            kv1.c().a("request");
                            Object obj = this.mApis.get("968563034");
                            if (obj != null && (obj instanceof at1)) {
                                at1Var = (at1) obj;
                            } else {
                                at1Var = new at1(this.mSwanApiContext);
                                this.mApis.put("968563034", at1Var);
                            }
                            Pair a2 = nv1.a(at1Var, "swanAPI/request");
                            if (((Boolean) a2.first).booleanValue()) {
                                a = ((lv1) a2.second).a();
                            } else if (t52.a(this.mSwanApiContext.f(), "Network.request")) {
                                a = new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            } else {
                                Pair u = pr1.u(str);
                                if (!((lv1) u.first).isSuccess()) {
                                    a = ((lv1) u.first).a();
                                } else {
                                    JSONObject jSONObject = (JSONObject) u.second;
                                    if (jSONObject == null) {
                                        a = lv1.a.a();
                                    } else {
                                        mv1 V = at1Var.V(jSONObject);
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
            hashMap.put("_naPayment", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    jw2 jw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof jw2)) {
                            jw2Var = (jw2) obj;
                        } else {
                            jw2Var = new jw2(this.mSwanApiContext);
                            this.mApis.put("-336396851", jw2Var);
                        }
                        Pair a = nv1.a(jw2Var, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Payment.chooseCoupon")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = jw2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    jw2 jw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof jw2)) {
                            jw2Var = (jw2) obj;
                        } else {
                            jw2Var = new jw2(this.mSwanApiContext);
                            this.mApis.put("-336396851", jw2Var);
                        }
                        Pair a = nv1.a(jw2Var, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Payment.getPaymentInfo")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = jw2Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    zv2 zv2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof zv2)) {
                            zv2Var = (zv2) obj;
                        } else {
                            zv2Var = new zv2(this.mSwanApiContext);
                            this.mApis.put("1854689529", zv2Var);
                        }
                        Pair a = nv1.a(zv2Var, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Payment.requestThirdPayment")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = zv2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    jw2 jw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof jw2)) {
                            jw2Var = (jw2) obj;
                        } else {
                            jw2Var = new jw2(this.mSwanApiContext);
                            this.mApis.put("-336396851", jw2Var);
                        }
                        Pair a = nv1.a(jw2Var, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Payment.setPaymentInfo")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 z = jw2Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    uy2 uy2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof uy2)) {
                            uy2Var = (uy2) obj;
                        } else {
                            uy2Var = new uy2(this.mSwanApiContext);
                            this.mApis.put("-254510461", uy2Var);
                        }
                        Pair a = nv1.a(uy2Var, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Plugin.invokePluginChooseAddress")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = uy2Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    uy2 uy2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof uy2)) {
                            uy2Var = (uy2) obj;
                        } else {
                            uy2Var = new uy2(this.mSwanApiContext);
                            this.mApis.put("-254510461", uy2Var);
                        }
                        Pair a = nv1.a(uy2Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 z = uy2Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    uy2 uy2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof uy2)) {
                            uy2Var = (uy2) obj;
                        } else {
                            uy2Var = new uy2(this.mSwanApiContext);
                            this.mApis.put("-254510461", uy2Var);
                        }
                        Pair a = nv1.a(uy2Var, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Plugin.invokePluginPayment")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = uy2Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    n72 n72Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof n72)) {
                            n72Var = (n72) obj;
                        } else {
                            n72Var = new n72(this.mSwanApiContext);
                            this.mApis.put("-2068479848", n72Var);
                        }
                        Pair a = nv1.a(n72Var, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Prefetch.prefetchResources")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = n72Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    f62 f62Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof f62)) {
                            f62Var = (f62) obj;
                        } else {
                            f62Var = new f62(this.mSwanApiContext);
                            this.mApis.put("423661539", f62Var);
                        }
                        Pair a = nv1.a(f62Var, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Preload.preloadStatus")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = f62Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    pf3 pf3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof pf3)) {
                            pf3Var = (pf3) obj;
                        } else {
                            pf3Var = new pf3(this.mSwanApiContext);
                            this.mApis.put("-1929343869", pf3Var);
                        }
                        Pair a = nv1.a(pf3Var, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "PrivateFile.uploadFileToBos")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 C = pf3Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    et1 et1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof et1)) {
                            et1Var = (et1) obj;
                        } else {
                            et1Var = new et1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", et1Var);
                        }
                        Pair a = nv1.a(et1Var, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Router.hideModalPage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = et1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    et1 et1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof et1)) {
                            et1Var = (et1) obj;
                        } else {
                            et1Var = new et1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", et1Var);
                        }
                        Pair a = nv1.a(et1Var, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Router.navigateBack")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 B = et1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    ft1 ft1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("1968522584", ft1Var);
                        }
                        Pair a = nv1.a(ft1Var, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Router.navigateTo")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 H = ft1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    ht1 ht1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof ht1)) {
                            ht1Var = (ht1) obj;
                        } else {
                            ht1Var = new ht1(this.mSwanApiContext);
                            this.mApis.put("1317280190", ht1Var);
                        }
                        Pair a = nv1.a(ht1Var, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Router.reLaunch")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = ht1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    it1 it1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof it1)) {
                            it1Var = (it1) obj;
                        } else {
                            it1Var = new it1(this.mSwanApiContext);
                            this.mApis.put("-420075743", it1Var);
                        }
                        Pair a = nv1.a(it1Var, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Router.reLoadErrorPage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = it1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    gt1 gt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof gt1)) {
                            gt1Var = (gt1) obj;
                        } else {
                            gt1Var = new gt1(this.mSwanApiContext);
                            this.mApis.put("1792515533", gt1Var);
                        }
                        Pair a = nv1.a(gt1Var, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Router.redirectTo")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 D = gt1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    ft1 ft1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("1968522584", ft1Var);
                        }
                        Pair a = nv1.a(ft1Var, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Router.showModalPage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 J = ft1Var.J(str);
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    lt1 lt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof lt1)) {
                            lt1Var = (lt1) obj;
                        } else {
                            lt1Var = new lt1(this.mSwanApiContext);
                            this.mApis.put("-594895721", lt1Var);
                        }
                        Pair a = nv1.a(lt1Var, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Setting.getAppInfoSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 F = lt1Var.F();
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    lt1 lt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof lt1)) {
                            lt1Var = (lt1) obj;
                        } else {
                            lt1Var = new lt1(this.mSwanApiContext);
                            this.mApis.put("-594895721", lt1Var);
                        }
                        Pair a = nv1.a(lt1Var, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Setting.getSlaveIdSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 H = lt1Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    kt1 kt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof kt1)) {
                            kt1Var = (kt1) obj;
                        } else {
                            kt1Var = new kt1(this.mSwanApiContext);
                            this.mApis.put("450273045", kt1Var);
                        }
                        Pair a = nv1.a(kt1Var, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Setting.isAllowedAdOpenAppSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = kt1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    lt1 lt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof lt1)) {
                            lt1Var = (lt1) obj;
                        } else {
                            lt1Var = new lt1(this.mSwanApiContext);
                            this.mApis.put("-594895721", lt1Var);
                        }
                        Pair a = nv1.a(lt1Var, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Setting.getSetting")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 G = lt1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    lt1 lt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof lt1)) {
                            lt1Var = (lt1) obj;
                        } else {
                            lt1Var = new lt1(this.mSwanApiContext);
                            this.mApis.put("-594895721", lt1Var);
                        }
                        Pair a = nv1.a(lt1Var, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Setting.getSwanId")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 I = lt1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    lt1 lt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof lt1)) {
                            lt1Var = (lt1) obj;
                        } else {
                            lt1Var = new lt1(this.mSwanApiContext);
                            this.mApis.put("-594895721", lt1Var);
                        }
                        Pair a = nv1.a(lt1Var, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Setting.getUserInfo")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 J = lt1Var.J(str);
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    ja3 ja3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof ja3)) {
                            ja3Var = (ja3) obj;
                        } else {
                            ja3Var = new ja3(this.mSwanApiContext);
                            this.mApis.put("712777136", ja3Var);
                        }
                        Pair a = nv1.a(ja3Var, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = ja3Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    ot1 ot1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof ot1)) {
                            ot1Var = (ot1) obj;
                        } else {
                            ot1Var = new ot1(this.mSwanApiContext);
                            this.mApis.put("-804054859", ot1Var);
                        }
                        Pair a = nv1.a(ot1Var, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = ot1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    ot1 ot1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof ot1)) {
                            ot1Var = (ot1) obj;
                        } else {
                            ot1Var = new ot1(this.mSwanApiContext);
                            this.mApis.put("-804054859", ot1Var);
                        }
                        Pair a = nv1.a(ot1Var, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorageSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 C = ot1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    nt1 nt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("130910081", nt1Var);
                        }
                        Pair a = nv1.a(nt1Var, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.clearStorage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = nt1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    nt1 nt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("130910081", nt1Var);
                        }
                        Pair a = nv1.a(nt1Var, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.clearStorageSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 C = nt1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    ot1 ot1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof ot1)) {
                            ot1Var = (ot1) obj;
                        } else {
                            ot1Var = new ot1(this.mSwanApiContext);
                            this.mApis.put("-804054859", ot1Var);
                        }
                        Pair a = nv1.a(ot1Var, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfo")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 G = ot1Var.G();
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    ot1 ot1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof ot1)) {
                            ot1Var = (ot1) obj;
                        } else {
                            ot1Var = new ot1(this.mSwanApiContext);
                            this.mApis.put("-804054859", ot1Var);
                        }
                        Pair a = nv1.a(ot1Var, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfoSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 J = ot1Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    nt1 nt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("130910081", nt1Var);
                        }
                        Pair a = nv1.a(nt1Var, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.getStorageInfo")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 G = nt1Var.G();
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    nt1 nt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("130910081", nt1Var);
                        }
                        Pair a = nv1.a(nt1Var, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.getStorageInfoSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 J = nt1Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    ot1 ot1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof ot1)) {
                            ot1Var = (ot1) obj;
                        } else {
                            ot1Var = new ot1(this.mSwanApiContext);
                            this.mApis.put("-804054859", ot1Var);
                        }
                        Pair a = nv1.a(ot1Var, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.getGlobalStorage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 D = ot1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    ot1 ot1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof ot1)) {
                            ot1Var = (ot1) obj;
                        } else {
                            ot1Var = new ot1(this.mSwanApiContext);
                            this.mApis.put("-804054859", ot1Var);
                        }
                        Pair a = nv1.a(ot1Var, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 K = ot1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("130910081", nt1Var);
                        }
                        Pair a = nv1.a(nt1Var, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.getStorage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 D = nt1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("130910081", nt1Var);
                        }
                        Pair a = nv1.a(nt1Var, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.getStorageInfoAsync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 H = nt1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("130910081", nt1Var);
                        }
                        Pair a = nv1.a(nt1Var, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.getStorageSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 K = nt1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    ot1 ot1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof ot1)) {
                            ot1Var = (ot1) obj;
                        } else {
                            ot1Var = new ot1(this.mSwanApiContext);
                            this.mApis.put("-804054859", ot1Var);
                        }
                        Pair a = nv1.a(ot1Var, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 R = ot1Var.R(str);
                        if (R == null) {
                            return "";
                        }
                        return R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    ot1 ot1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof ot1)) {
                            ot1Var = (ot1) obj;
                        } else {
                            ot1Var = new ot1(this.mSwanApiContext);
                            this.mApis.put("-804054859", ot1Var);
                        }
                        Pair a = nv1.a(ot1Var, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorageSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 T = ot1Var.T(str);
                        if (T == null) {
                            return "";
                        }
                        return T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("130910081", nt1Var);
                        }
                        Pair a = nv1.a(nt1Var, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.removeStorage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 R = nt1Var.R(str);
                        if (R == null) {
                            return "";
                        }
                        return R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("130910081", nt1Var);
                        }
                        Pair a = nv1.a(nt1Var, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.removeStorageSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 T = nt1Var.T(str);
                        if (T == null) {
                            return "";
                        }
                        return T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    ot1 ot1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof ot1)) {
                            ot1Var = (ot1) obj;
                        } else {
                            ot1Var = new ot1(this.mSwanApiContext);
                            this.mApis.put("-804054859", ot1Var);
                        }
                        Pair a = nv1.a(ot1Var, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.setGlobalStorage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 U = ot1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    ot1 ot1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof ot1)) {
                            ot1Var = (ot1) obj;
                        } else {
                            ot1Var = new ot1(this.mSwanApiContext);
                            this.mApis.put("-804054859", ot1Var);
                        }
                        Pair a = nv1.a(ot1Var, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.setGlobalStorageSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 W = ot1Var.W(str);
                        if (W == null) {
                            return "";
                        }
                        return W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("130910081", nt1Var);
                        }
                        Pair a = nv1.a(nt1Var, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.setStorage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 U = nt1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("130910081", nt1Var);
                        }
                        Pair a = nv1.a(nt1Var, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Storage.setStorageSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 W = nt1Var.W(str);
                        if (W == null) {
                            return "";
                        }
                        return W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    qt1 qt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof qt1)) {
                            qt1Var = (qt1) obj;
                        } else {
                            qt1Var = new qt1(this.mSwanApiContext);
                            this.mApis.put("823117982", qt1Var);
                        }
                        Pair a = nv1.a(qt1Var, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Subscription.requestSubscribeFormId")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 E = qt1Var.E(str);
                        if (E == null) {
                            return "";
                        }
                        return E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    rt1 rt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof rt1)) {
                            rt1Var = (rt1) obj;
                        } else {
                            rt1Var = new rt1(this.mSwanApiContext);
                            this.mApis.put("-947445811", rt1Var);
                        }
                        Pair a = nv1.a(rt1Var, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Subscription.subscribeService")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 F = rt1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    yt1 yt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof yt1)) {
                            yt1Var = (yt1) obj;
                        } else {
                            yt1Var = new yt1(this.mSwanApiContext);
                            this.mApis.put("1936205521", yt1Var);
                        }
                        Pair a = nv1.a(yt1Var, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.exitFullScreen")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = yt1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    xt1 xt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof xt1)) {
                            xt1Var = (xt1) obj;
                        } else {
                            xt1Var = new xt1(this.mSwanApiContext);
                            this.mApis.put("1694151270", xt1Var);
                        }
                        Pair a = nv1.a(xt1Var, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.getDeviceInfo")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = xt1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    zt1 zt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof zt1)) {
                            zt1Var = (zt1) obj;
                        } else {
                            zt1Var = new zt1(this.mSwanApiContext);
                            this.mApis.put("-1321681619", zt1Var);
                        }
                        Pair a = nv1.a(zt1Var, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.getDeviceProfile")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = zt1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    au1 au1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof au1)) {
                            au1Var = (au1) obj;
                        } else {
                            au1Var = new au1(this.mSwanApiContext);
                            this.mApis.put("-1569246082", au1Var);
                        }
                        Pair a = nv1.a(au1Var, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.makePhoneCall")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = au1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    cu1 cu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof cu1)) {
                            cu1Var = (cu1) obj;
                        } else {
                            cu1Var = new cu1(this.mSwanApiContext);
                            this.mApis.put("1099851202", cu1Var);
                        }
                        Pair a = nv1.a(cu1Var, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.openSMSPanel")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = cu1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    bu1 bu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof bu1)) {
                            bu1Var = (bu1) obj;
                        } else {
                            bu1Var = new bu1(this.mSwanApiContext);
                            this.mApis.put("-1707203360", bu1Var);
                        }
                        Pair a = nv1.a(bu1Var, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.requestFullScreen")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 F = bu1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    vt1 vt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof vt1)) {
                            vt1Var = (vt1) obj;
                        } else {
                            vt1Var = new vt1(this.mSwanApiContext);
                            this.mApis.put("-518757484", vt1Var);
                        }
                        Pair a = nv1.a(vt1Var, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.setClipboardData")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = vt1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    ft2 ft2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof ft2)) {
                            ft2Var = (ft2) obj;
                        } else {
                            ft2Var = new ft2(this.mSwanApiContext);
                            this.mApis.put("1161486049", ft2Var);
                        }
                        Pair a = nv1.a(ft2Var, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.setErrorPageType")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = ft2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    fu1 fu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("447234992", fu1Var);
                        }
                        Pair a = nv1.a(fu1Var, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.setMediaVolume")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 z = fu1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    tt1 tt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof tt1)) {
                            tt1Var = (tt1) obj;
                        } else {
                            tt1Var = new tt1(this.mSwanApiContext);
                            this.mApis.put("1372680763", tt1Var);
                        }
                        Pair a = nv1.a(tt1Var, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.startAccelerometer")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = tt1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    wt1 wt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof wt1)) {
                            wt1Var = (wt1) obj;
                        } else {
                            wt1Var = new wt1(this.mSwanApiContext);
                            this.mApis.put("1689255576", wt1Var);
                        }
                        Pair a = nv1.a(wt1Var, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.startCompass")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = wt1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    ut1 ut1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof ut1)) {
                            ut1Var = (ut1) obj;
                        } else {
                            ut1Var = new ut1(this.mSwanApiContext);
                            this.mApis.put("99997465", ut1Var);
                        }
                        Pair a = nv1.a(ut1Var, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.getBrightness")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = ut1Var.y();
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    vt1 vt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof vt1)) {
                            vt1Var = (vt1) obj;
                        } else {
                            vt1Var = new vt1(this.mSwanApiContext);
                            this.mApis.put("-518757484", vt1Var);
                        }
                        Pair a = nv1.a(vt1Var, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.getClipboardData")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = vt1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    fu1 fu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("447234992", fu1Var);
                        }
                        Pair a = nv1.a(fu1Var, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.getMediaVolume")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = fu1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    tt1 tt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof tt1)) {
                            tt1Var = (tt1) obj;
                        } else {
                            tt1Var = new tt1(this.mSwanApiContext);
                            this.mApis.put("1372680763", tt1Var);
                        }
                        Pair a = nv1.a(tt1Var, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.stopAccelerometer")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 B = tt1Var.B();
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    wt1 wt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof wt1)) {
                            wt1Var = (wt1) obj;
                        } else {
                            wt1Var = new wt1(this.mSwanApiContext);
                            this.mApis.put("1689255576", wt1Var);
                        }
                        Pair a = nv1.a(wt1Var, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "System.stopCompass")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 z = wt1Var.z();
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    qu1 qu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof qu1)) {
                            qu1Var = (qu1) obj;
                        } else {
                            qu1Var = new qu1(this.mSwanApiContext);
                            this.mApis.put("201194468", qu1Var);
                        }
                        Pair a = nv1.a(qu1Var, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.addToDesktop")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 B = qu1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    mu1 mu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof mu1)) {
                            mu1Var = (mu1) obj;
                        } else {
                            mu1Var = new mu1(this.mSwanApiContext);
                            this.mApis.put("-1412306947", mu1Var);
                        }
                        Pair a = nv1.a(mu1Var, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.calcMD5")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = mu1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    nu1 nu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof nu1)) {
                            nu1Var = (nu1) obj;
                        } else {
                            nu1Var = new nu1(this.mSwanApiContext);
                            this.mApis.put("1626415364", nu1Var);
                        }
                        Pair a = nv1.a(nu1Var, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.checkAppInstalled")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = nu1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    pu1 pu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof pu1)) {
                            pu1Var = (pu1) obj;
                        } else {
                            pu1Var = new pu1(this.mSwanApiContext);
                            this.mApis.put("-836768778", pu1Var);
                        }
                        Pair a = nv1.a(pu1Var, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfo")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = pu1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    ru1 ru1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof ru1)) {
                            ru1Var = (ru1) obj;
                        } else {
                            ru1Var = new ru1(this.mSwanApiContext);
                            this.mApis.put("-810858308", ru1Var);
                        }
                        Pair a = nv1.a(ru1Var, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.getPerformanceLevel")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = ru1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    vu1 vu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof vu1)) {
                            vu1Var = (vu1) obj;
                        } else {
                            vu1Var = new vu1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", vu1Var);
                        }
                        Pair a = nv1.a(vu1Var, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.getSystemInfoAsync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 I = vu1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    su1 su1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof su1)) {
                            su1Var = (su1) obj;
                        } else {
                            su1Var = new su1(this.mSwanApiContext);
                            this.mApis.put("-2097727681", su1Var);
                        }
                        Pair a = nv1.a(su1Var, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.handleException")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = su1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    ou1 ou1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof ou1)) {
                            ou1Var = (ou1) obj;
                        } else {
                            ou1Var = new ou1(this.mSwanApiContext);
                            this.mApis.put("2084449317", ou1Var);
                        }
                        Pair a = nv1.a(ou1Var, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.hasCloseHandler")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = ou1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    r73 r73Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof r73)) {
                            r73Var = (r73) obj;
                        } else {
                            r73Var = new r73(this.mSwanApiContext);
                            this.mApis.put("1031678042", r73Var);
                        }
                        Pair a = nv1.a(r73Var, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.hideCaptureScreenShareDialog")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 x = r73Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    tu1 tu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof tu1)) {
                            tu1Var = (tu1) obj;
                        } else {
                            tu1Var = new tu1(this.mSwanApiContext);
                            this.mApis.put("1751900130", tu1Var);
                        }
                        Pair a = nv1.a(tu1Var, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.logToFile")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = tu1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    s63 s63Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof s63)) {
                            s63Var = (s63) obj;
                        } else {
                            s63Var = new s63(this.mSwanApiContext);
                            this.mApis.put("1748196865", s63Var);
                        }
                        Pair a = nv1.a(s63Var, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.preloadPackage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = s63Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    uu1 uu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof uu1)) {
                            uu1Var = (uu1) obj;
                        } else {
                            uu1Var = new uu1(this.mSwanApiContext);
                            this.mApis.put("589529211", uu1Var);
                        }
                        Pair a = nv1.a(uu1Var, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.previewImage")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 B = uu1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    xu1 xu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof xu1)) {
                            xu1Var = (xu1) obj;
                        } else {
                            xu1Var = new xu1(this.mSwanApiContext);
                            this.mApis.put("-577481801", xu1Var);
                        }
                        Pair a = nv1.a(xu1Var, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.ubcFlowJar")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 I = xu1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    vu1 vu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof vu1)) {
                            vu1Var = (vu1) obj;
                        } else {
                            vu1Var = new vu1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", vu1Var);
                        }
                        Pair a = nv1.a(vu1Var, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfoSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 E = vu1Var.E();
                        if (E == null) {
                            return "";
                        }
                        return E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    vu1 vu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof vu1)) {
                            vu1Var = (vu1) obj;
                        } else {
                            vu1Var = new vu1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", vu1Var);
                        }
                        Pair a = nv1.a(vu1Var, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.getSystemInfo")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 H = vu1Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    vu1 vu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof vu1)) {
                            vu1Var = (vu1) obj;
                        } else {
                            vu1Var = new vu1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", vu1Var);
                        }
                        Pair a = nv1.a(vu1Var, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Utils.getSystemInfoSync")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 J = vu1Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    ce3 ce3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ce3)) {
                            ce3Var = (ce3) obj;
                        } else {
                            ce3Var = new ce3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ce3Var);
                        }
                        Pair a = nv1.a(ce3Var, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Wifi.connectWifi")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 A = ce3Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    ce3 ce3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ce3)) {
                            ce3Var = (ce3) obj;
                        } else {
                            ce3Var = new ce3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ce3Var);
                        }
                        Pair a = nv1.a(ce3Var, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Wifi.getConnectedWifi")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 B = ce3Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    ce3 ce3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ce3)) {
                            ce3Var = (ce3) obj;
                        } else {
                            ce3Var = new ce3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ce3Var);
                        }
                        Pair a = nv1.a(ce3Var, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Wifi.getWifiList")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 C = ce3Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    ce3 ce3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ce3)) {
                            ce3Var = (ce3) obj;
                        } else {
                            ce3Var = new ce3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ce3Var);
                        }
                        Pair a = nv1.a(ce3Var, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Wifi.startWifi")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 G = ce3Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    ce3 ce3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ce3)) {
                            ce3Var = (ce3) obj;
                        } else {
                            ce3Var = new ce3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ce3Var);
                        }
                        Pair a = nv1.a(ce3Var, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "Wifi.stopWifi")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 H = ce3Var.H(str);
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
