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
import com.repackage.a22;
import com.repackage.ap1;
import com.repackage.ap2;
import com.repackage.aq1;
import com.repackage.bo1;
import com.repackage.bp1;
import com.repackage.co1;
import com.repackage.cp1;
import com.repackage.cq1;
import com.repackage.do1;
import com.repackage.dp1;
import com.repackage.e63;
import com.repackage.eo1;
import com.repackage.es2;
import com.repackage.fo1;
import com.repackage.fp1;
import com.repackage.fr1;
import com.repackage.go1;
import com.repackage.gp1;
import com.repackage.gr1;
import com.repackage.ho1;
import com.repackage.hq1;
import com.repackage.hr1;
import com.repackage.i32;
import com.repackage.in1;
import com.repackage.io1;
import com.repackage.ip1;
import com.repackage.iq1;
import com.repackage.ir1;
import com.repackage.jo1;
import com.repackage.jp1;
import com.repackage.jq1;
import com.repackage.kb3;
import com.repackage.kc2;
import com.repackage.kn1;
import com.repackage.ko1;
import com.repackage.kq1;
import com.repackage.ln1;
import com.repackage.lo1;
import com.repackage.lp1;
import com.repackage.lq1;
import com.repackage.m33;
import com.repackage.mp1;
import com.repackage.mq1;
import com.repackage.n23;
import com.repackage.nn1;
import com.repackage.nq1;
import com.repackage.o12;
import com.repackage.on1;
import com.repackage.oo1;
import com.repackage.op1;
import com.repackage.oq1;
import com.repackage.pn1;
import com.repackage.pp1;
import com.repackage.pq1;
import com.repackage.pu2;
import com.repackage.qn1;
import com.repackage.qp1;
import com.repackage.qq1;
import com.repackage.rn1;
import com.repackage.rp1;
import com.repackage.sp1;
import com.repackage.sq1;
import com.repackage.tn1;
import com.repackage.tp1;
import com.repackage.uo1;
import com.repackage.up1;
import com.repackage.ur2;
import com.repackage.vn1;
import com.repackage.vo1;
import com.repackage.vp1;
import com.repackage.wn1;
import com.repackage.wp1;
import com.repackage.x93;
import com.repackage.xm1;
import com.repackage.xp1;
import com.repackage.yf1;
import com.repackage.yo2;
import com.repackage.zn1;
import com.repackage.zo1;
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

    public static Map<String, Object> getV8ApiModules(final in1 in1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, in1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    on1 on1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof on1)) {
                            on1Var = (on1) obj;
                        } else {
                            on1Var = new on1(this.mSwanApiContext);
                            this.mApis.put("1930258908", on1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(on1Var, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Account.checkSession")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = on1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    pn1 pn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof pn1)) {
                            pn1Var = (pn1) obj;
                        } else {
                            pn1Var = new pn1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", pn1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(pn1Var, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Account.getLoginCode")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 C = pn1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    qn1 qn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof qn1)) {
                            qn1Var = (qn1) obj;
                        } else {
                            qn1Var = new qn1(this.mSwanApiContext);
                            this.mApis.put("1754780133", qn1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(qn1Var, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Account.getOpenId")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = qn1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    xm1 xm1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof xm1)) {
                            xm1Var = (xm1) obj;
                        } else {
                            xm1Var = new xm1(this.mSwanApiContext);
                            this.mApis.put("-343998465", xm1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(xm1Var, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Account.getUnionBDUSS")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = xm1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    nn1 nn1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof nn1)) {
                            nn1Var = (nn1) obj;
                        } else {
                            nn1Var = new nn1(this.mSwanApiContext);
                            this.mApis.put("-337742792", nn1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(nn1Var, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Account.isBaiduAccountSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = nn1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    pn1 pn1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof pn1)) {
                            pn1Var = (pn1) obj;
                        } else {
                            pn1Var = new pn1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", pn1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(pn1Var, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Account.isLoginSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 H = pn1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    pn1 pn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof pn1)) {
                            pn1Var = (pn1) obj;
                        } else {
                            pn1Var = new pn1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", pn1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(pn1Var, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Account.login")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 I = pn1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    rn1 rn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof rn1)) {
                            rn1Var = (rn1) obj;
                        } else {
                            rn1Var = new rn1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", rn1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(rn1Var, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Basic.loadSubPackage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 F = rn1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    rn1 rn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof rn1)) {
                            rn1Var = (rn1) obj;
                        } else {
                            rn1Var = new rn1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", rn1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(rn1Var, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Basic.loadSubPackages")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 G = rn1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    yf1 yf1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof yf1)) {
                            yf1Var = (yf1) obj;
                        } else {
                            yf1Var = new yf1(this.mSwanApiContext);
                            this.mApis.put("1460300387", yf1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(yf1Var, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Bookshelf.deleteBookshelf")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 K = yf1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    yf1 yf1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof yf1)) {
                            yf1Var = (yf1) obj;
                        } else {
                            yf1Var = new yf1(this.mSwanApiContext);
                            this.mApis.put("1460300387", yf1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(yf1Var, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Bookshelf.insertBookshelf")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 P = yf1Var.P(str);
                        return P == null ? "" : P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    yf1 yf1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof yf1)) {
                            yf1Var = (yf1) obj;
                        } else {
                            yf1Var = new yf1(this.mSwanApiContext);
                            this.mApis.put("1460300387", yf1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(yf1Var, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Bookshelf.navigateToBookshelf")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 U = yf1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    yf1 yf1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof yf1)) {
                            yf1Var = (yf1) obj;
                        } else {
                            yf1Var = new yf1(this.mSwanApiContext);
                            this.mApis.put("1460300387", yf1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(yf1Var, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Bookshelf.queryBookshelf")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 V = yf1Var.V(str);
                        return V == null ? "" : V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    yf1 yf1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof yf1)) {
                            yf1Var = (yf1) obj;
                        } else {
                            yf1Var = new yf1(this.mSwanApiContext);
                            this.mApis.put("1460300387", yf1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(yf1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Bookshelf.updateBookshelfReadTime")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 X = yf1Var.X(str);
                        return X == null ? "" : X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    ln1 ln1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof ln1)) {
                            ln1Var = (ln1) obj;
                        } else {
                            ln1Var = new ln1(this.mSwanApiContext);
                            this.mApis.put("-277316359", ln1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ln1Var, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Coupon.getPlatformCoupons")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = ln1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    ln1 ln1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof ln1)) {
                            ln1Var = (ln1) obj;
                        } else {
                            ln1Var = new ln1(this.mSwanApiContext);
                            this.mApis.put("-277316359", ln1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ln1Var, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Coupon.getUserCoupons")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 z = ln1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    ln1 ln1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof ln1)) {
                            ln1Var = (ln1) obj;
                        } else {
                            ln1Var = new ln1(this.mSwanApiContext);
                            this.mApis.put("-277316359", ln1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ln1Var, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Coupon.takeCoupons")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 C = ln1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    tn1 tn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof tn1)) {
                            tn1Var = (tn1) obj;
                        } else {
                            tn1Var = new tn1(this.mSwanApiContext);
                            this.mApis.put("-1225406515", tn1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(tn1Var, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Favorite.getFavorStatus")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = tn1Var.x(str);
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
                        Pair<Boolean, gr1> a = ir1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Favorite.showFavoriteGuide")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 G = showFavoriteGuideApi.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    vn1 vn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof vn1)) {
                            vn1Var = (vn1) obj;
                        } else {
                            vn1Var = new vn1(this.mSwanApiContext);
                            this.mApis.put("-2057135077", vn1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(vn1Var, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "File.shareFile")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = vn1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    kc2 kc2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof kc2)) {
                            kc2Var = (kc2) obj;
                        } else {
                            kc2Var = new kc2(this.mSwanApiContext);
                            this.mApis.put("2077414795", kc2Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(kc2Var, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "GameCenter.postGameCenterMessage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = kc2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    kc2 kc2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof kc2)) {
                            kc2Var = (kc2) obj;
                        } else {
                            kc2Var = new kc2(this.mSwanApiContext);
                            this.mApis.put("2077414795", kc2Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(kc2Var, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "GameCenter.postGameCenterMessageSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = kc2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String download(String str) {
                    wn1 wn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof wn1)) {
                            wn1Var = (wn1) obj;
                        } else {
                            wn1Var = new wn1(this.mSwanApiContext);
                            this.mApis.put("-170124576", wn1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(wn1Var, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "HostDownloadManager.download")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = wn1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    wn1 wn1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof wn1)) {
                            wn1Var = (wn1) obj;
                        } else {
                            wn1Var = new wn1(this.mSwanApiContext);
                            this.mApis.put("-170124576", wn1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(wn1Var, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "HostDownloadManager.openDownloadCenter")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = wn1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    wn1 wn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof wn1)) {
                            wn1Var = (wn1) obj;
                        } else {
                            wn1Var = new wn1(this.mSwanApiContext);
                            this.mApis.put("-170124576", wn1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(wn1Var, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "HostDownloadManager.openFile")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 z = wn1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    wn1 wn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof wn1)) {
                            wn1Var = (wn1) obj;
                        } else {
                            wn1Var = new wn1(this.mSwanApiContext);
                            this.mApis.put("-170124576", wn1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(wn1Var, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "HostDownloadManager.query")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 query = wn1Var.query(str);
                        return query == null ? "" : query.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naImage", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    yo2 yo2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof yo2)) {
                            yo2Var = (yo2) obj;
                        } else {
                            yo2Var = new yo2(this.mSwanApiContext);
                            this.mApis.put("1445003743", yo2Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(yo2Var, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Image.callImageMenu")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = yo2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    zn1 zn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof zn1)) {
                            zn1Var = (zn1) obj;
                        } else {
                            zn1Var = new zn1(this.mSwanApiContext);
                            this.mApis.put("-1252730367", zn1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(zn1Var, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Image.compressImage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = zn1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    ho1 ho1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ho1)) {
                            ho1Var = (ho1) obj;
                        } else {
                            ho1Var = new ho1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ho1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ho1Var, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.closeTabBar")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = ho1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    ho1 ho1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ho1)) {
                            ho1Var = (ho1) obj;
                        } else {
                            ho1Var = new ho1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ho1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ho1Var, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.closeTabBarRedDot")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = ho1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    bo1 bo1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof bo1)) {
                            bo1Var = (bo1) obj;
                        } else {
                            bo1Var = new bo1(this.mSwanApiContext);
                            this.mApis.put("5236036", bo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(bo1Var, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.hideLoading")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = bo1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    do1 do1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof do1)) {
                            do1Var = (do1) obj;
                        } else {
                            do1Var = new do1(this.mSwanApiContext);
                            this.mApis.put("-246386074", do1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(do1Var, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.hideNavigationBarLoading")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = do1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    io1 io1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof io1)) {
                            io1Var = (io1) obj;
                        } else {
                            io1Var = new io1(this.mSwanApiContext);
                            this.mApis.put("1159492510", io1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(io1Var, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.hideToast")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 K = io1Var.K();
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    fo1 fo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof fo1)) {
                            fo1Var = (fo1) obj;
                        } else {
                            fo1Var = new fo1(this.mSwanApiContext);
                            this.mApis.put("-108978463", fo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(fo1Var, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.openMultiPicker")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 G = fo1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    fo1 fo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof fo1)) {
                            fo1Var = (fo1) obj;
                        } else {
                            fo1Var = new fo1(this.mSwanApiContext);
                            this.mApis.put("-108978463", fo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(fo1Var, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.openPicker")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 H = fo1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    ho1 ho1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ho1)) {
                            ho1Var = (ho1) obj;
                        } else {
                            ho1Var = new ho1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ho1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ho1Var, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.openTabBar")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 C = ho1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    eo1 eo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof eo1)) {
                            eo1Var = (eo1) obj;
                        } else {
                            eo1Var = new eo1(this.mSwanApiContext);
                            this.mApis.put("-1750613704", eo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(eo1Var, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.pageScrollTo")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = eo1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    do1 do1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof do1)) {
                            do1Var = (do1) obj;
                        } else {
                            do1Var = new do1(this.mSwanApiContext);
                            this.mApis.put("-246386074", do1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(do1Var, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.setNavigationBarColor")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 z = do1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    do1 do1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof do1)) {
                            do1Var = (do1) obj;
                        } else {
                            do1Var = new do1(this.mSwanApiContext);
                            this.mApis.put("-246386074", do1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(do1Var, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.setNavigationBarTitle")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = do1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    ho1 ho1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ho1)) {
                            ho1Var = (ho1) obj;
                        } else {
                            ho1Var = new ho1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ho1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ho1Var, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.setTabBarItem")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 D = ho1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    fo1 fo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof fo1)) {
                            fo1Var = (fo1) obj;
                        } else {
                            fo1Var = new fo1(this.mSwanApiContext);
                            this.mApis.put("-108978463", fo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(fo1Var, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.showDatePickerView")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 L = fo1Var.L(str);
                        return L == null ? "" : L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    jo1 jo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof jo1)) {
                            jo1Var = (jo1) obj;
                        } else {
                            jo1Var = new jo1(this.mSwanApiContext);
                            this.mApis.put("1172469410", jo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(jo1Var, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.showHalfScreenWebview")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 K = jo1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    bo1 bo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof bo1)) {
                            bo1Var = (bo1) obj;
                        } else {
                            bo1Var = new bo1(this.mSwanApiContext);
                            this.mApis.put("5236036", bo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(bo1Var, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.showLoading")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = bo1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    co1 co1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof co1)) {
                            co1Var = (co1) obj;
                        } else {
                            co1Var = new co1(this.mSwanApiContext);
                            this.mApis.put("1913747800", co1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(co1Var, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.showModal")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = co1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    do1 do1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof do1)) {
                            do1Var = (do1) obj;
                        } else {
                            do1Var = new do1(this.mSwanApiContext);
                            this.mApis.put("-246386074", do1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(do1Var, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.showNavigationBarLoading")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 B = do1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    io1 io1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof io1)) {
                            io1Var = (io1) obj;
                        } else {
                            io1Var = new io1(this.mSwanApiContext);
                            this.mApis.put("1159492510", io1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(io1Var, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.showToast")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 Q = io1Var.Q(str);
                        return Q == null ? "" : Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    go1 go1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof go1)) {
                            go1Var = (go1) obj;
                        } else {
                            go1Var = new go1(this.mSwanApiContext);
                            this.mApis.put("1165118609", go1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(go1Var, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.stopPullDownRefresh")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = go1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    fo1 fo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof fo1)) {
                            fo1Var = (fo1) obj;
                        } else {
                            fo1Var = new fo1(this.mSwanApiContext);
                            this.mApis.put("-108978463", fo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(fo1Var, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.updateMultiPicker")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 M = fo1Var.M(str);
                        return M == null ? "" : M.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    ko1 ko1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof ko1)) {
                            ko1Var = (ko1) obj;
                        } else {
                            ko1Var = new ko1(this.mSwanApiContext);
                            this.mApis.put("-137346255", ko1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ko1Var, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Keyboard.startKeyboardHeightChange")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 C = ko1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    ko1 ko1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof ko1)) {
                            ko1Var = (ko1) obj;
                        } else {
                            ko1Var = new ko1(this.mSwanApiContext);
                            this.mApis.put("-137346255", ko1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ko1Var, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Keyboard.stopKeyboardHeightChange")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 D = ko1Var.D();
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    lo1 lo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof lo1)) {
                            lo1Var = (lo1) obj;
                        } else {
                            lo1Var = new lo1(this.mSwanApiContext);
                            this.mApis.put("-397373095", lo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(lo1Var, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "LocationService.getLocation")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = lo1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    lo1 lo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof lo1)) {
                            lo1Var = (lo1) obj;
                        } else {
                            lo1Var = new lo1(this.mSwanApiContext);
                            this.mApis.put("-397373095", lo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(lo1Var, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "LocationService.startLocationUpdate")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = lo1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    lo1 lo1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof lo1)) {
                            lo1Var = (lo1) obj;
                        } else {
                            lo1Var = new lo1(this.mSwanApiContext);
                            this.mApis.put("-397373095", lo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(lo1Var, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "LocationService.stopLocationUpdate")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 B = lo1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    cq1 cq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof cq1)) {
                            cq1Var = (cq1) obj;
                        } else {
                            cq1Var = new cq1(this.mSwanApiContext);
                            this.mApis.put("538070032", cq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(cq1Var, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = cq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String callService(String str) {
                    oo1 oo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof oo1)) {
                            oo1Var = (oo1) obj;
                        } else {
                            oo1Var = new oo1(this.mSwanApiContext);
                            this.mApis.put("-1076509454", oo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(oo1Var, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Network.callService")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = oo1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    vo1 vo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof vo1)) {
                            vo1Var = (vo1) obj;
                        } else {
                            vo1Var = new vo1(this.mSwanApiContext);
                            this.mApis.put("968563034", vo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(vo1Var, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Network.cancelRequest")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 D = vo1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    uo1 uo1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof uo1)) {
                            uo1Var = (uo1) obj;
                        } else {
                            uo1Var = new uo1(this.mSwanApiContext);
                            this.mApis.put("453220699", uo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(uo1Var, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Network.getNetworkType")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = uo1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    uo1 uo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof uo1)) {
                            uo1Var = (uo1) obj;
                        } else {
                            uo1Var = new uo1(this.mSwanApiContext);
                            this.mApis.put("453220699", uo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(uo1Var, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Network.networkStatusChange")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = uo1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                @JavascriptInterface
                public String request(JsObject jsObject) {
                    InterceptResult invokeL2;
                    vo1 vo1Var;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && (invokeL2 = interceptable2.invokeL(1048580, this, jsObject)) != null) {
                        return (String) invokeL2.objValue;
                    }
                    try {
                        fr1.c().a("request");
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof vo1)) {
                            vo1Var = (vo1) obj;
                        } else {
                            vo1Var = new vo1(this.mSwanApiContext);
                            this.mApis.put("968563034", vo1Var);
                        }
                        Pair<Boolean, gr1> a2 = ir1.a(vo1Var, "swanAPI/request");
                        if (((Boolean) a2.first).booleanValue()) {
                            a = ((gr1) a2.second).a();
                        } else if (o12.a(this.mSwanApiContext.h(), "Network.request")) {
                            a = new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        } else {
                            Pair<gr1, JSONObject> t = kn1.t(jsObject);
                            if (!((gr1) t.first).isSuccess()) {
                                a = ((gr1) t.first).a();
                            } else {
                                JSONObject jSONObject = (JSONObject) t.second;
                                if (jSONObject == null) {
                                    a = gr1.a.a();
                                } else {
                                    hr1 V = vo1Var.V(jSONObject);
                                    a = V == null ? "" : V.a();
                                }
                            }
                        }
                        return a;
                    } finally {
                    }
                }
            });
            hashMap.put("_naPayment", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    es2 es2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof es2)) {
                            es2Var = (es2) obj;
                        } else {
                            es2Var = new es2(this.mSwanApiContext);
                            this.mApis.put("-336396851", es2Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(es2Var, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Payment.chooseCoupon")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = es2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    es2 es2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof es2)) {
                            es2Var = (es2) obj;
                        } else {
                            es2Var = new es2(this.mSwanApiContext);
                            this.mApis.put("-336396851", es2Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(es2Var, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Payment.getPaymentInfo")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = es2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    ur2 ur2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof ur2)) {
                            ur2Var = (ur2) obj;
                        } else {
                            ur2Var = new ur2(this.mSwanApiContext);
                            this.mApis.put("1854689529", ur2Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ur2Var, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Payment.requestThirdPayment")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = ur2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    es2 es2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof es2)) {
                            es2Var = (es2) obj;
                        } else {
                            es2Var = new es2(this.mSwanApiContext);
                            this.mApis.put("-336396851", es2Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(es2Var, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Payment.setPaymentInfo")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 z = es2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    pu2 pu2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof pu2)) {
                            pu2Var = (pu2) obj;
                        } else {
                            pu2Var = new pu2(this.mSwanApiContext);
                            this.mApis.put("-254510461", pu2Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(pu2Var, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Plugin.invokePluginChooseAddress")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = pu2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    pu2 pu2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof pu2)) {
                            pu2Var = (pu2) obj;
                        } else {
                            pu2Var = new pu2(this.mSwanApiContext);
                            this.mApis.put("-254510461", pu2Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(pu2Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 z = pu2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    pu2 pu2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof pu2)) {
                            pu2Var = (pu2) obj;
                        } else {
                            pu2Var = new pu2(this.mSwanApiContext);
                            this.mApis.put("-254510461", pu2Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(pu2Var, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Plugin.invokePluginPayment")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = pu2Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    i32 i32Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof i32)) {
                            i32Var = (i32) obj;
                        } else {
                            i32Var = new i32(this.mSwanApiContext);
                            this.mApis.put("-2068479848", i32Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(i32Var, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Prefetch.prefetchResources")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = i32Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    a22 a22Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof a22)) {
                            a22Var = (a22) obj;
                        } else {
                            a22Var = new a22(this.mSwanApiContext);
                            this.mApis.put("423661539", a22Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(a22Var, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Preload.preloadStatus")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = a22Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    kb3 kb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof kb3)) {
                            kb3Var = (kb3) obj;
                        } else {
                            kb3Var = new kb3(this.mSwanApiContext);
                            this.mApis.put("-1929343869", kb3Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(kb3Var, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "PrivateFile.uploadFileToBos")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 C = kb3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    zo1 zo1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof zo1)) {
                            zo1Var = (zo1) obj;
                        } else {
                            zo1Var = new zo1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", zo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(zo1Var, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Router.hideModalPage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = zo1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    zo1 zo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof zo1)) {
                            zo1Var = (zo1) obj;
                        } else {
                            zo1Var = new zo1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", zo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(zo1Var, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Router.navigateBack")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 B = zo1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    ap1 ap1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof ap1)) {
                            ap1Var = (ap1) obj;
                        } else {
                            ap1Var = new ap1(this.mSwanApiContext);
                            this.mApis.put("1968522584", ap1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ap1Var, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Router.navigateTo")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 H = ap1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    cp1 cp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof cp1)) {
                            cp1Var = (cp1) obj;
                        } else {
                            cp1Var = new cp1(this.mSwanApiContext);
                            this.mApis.put("1317280190", cp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(cp1Var, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Router.reLaunch")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = cp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    dp1 dp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof dp1)) {
                            dp1Var = (dp1) obj;
                        } else {
                            dp1Var = new dp1(this.mSwanApiContext);
                            this.mApis.put("-420075743", dp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(dp1Var, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Router.reLoadErrorPage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = dp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    bp1 bp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof bp1)) {
                            bp1Var = (bp1) obj;
                        } else {
                            bp1Var = new bp1(this.mSwanApiContext);
                            this.mApis.put("1792515533", bp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(bp1Var, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Router.redirectTo")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 D = bp1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    ap1 ap1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof ap1)) {
                            ap1Var = (ap1) obj;
                        } else {
                            ap1Var = new ap1(this.mSwanApiContext);
                            this.mApis.put("1968522584", ap1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ap1Var, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Router.showModalPage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 J = ap1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    gp1 gp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("-594895721", gp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(gp1Var, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Setting.getAppInfoSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 F = gp1Var.F();
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    gp1 gp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("-594895721", gp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(gp1Var, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Setting.getSetting")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 G = gp1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    gp1 gp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("-594895721", gp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(gp1Var, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Setting.getSlaveIdSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 H = gp1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    gp1 gp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("-594895721", gp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(gp1Var, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Setting.getSwanId")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 I = gp1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    gp1 gp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("-594895721", gp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(gp1Var, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Setting.getUserInfo")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 J = gp1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    fp1 fp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof fp1)) {
                            fp1Var = (fp1) obj;
                        } else {
                            fp1Var = new fp1(this.mSwanApiContext);
                            this.mApis.put("450273045", fp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(fp1Var, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Setting.isAllowedAdOpenAppSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = fp1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    e63 e63Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof e63)) {
                            e63Var = (e63) obj;
                        } else {
                            e63Var = new e63(this.mSwanApiContext);
                            this.mApis.put("712777136", e63Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(e63Var, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = e63Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    jp1 jp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-804054859", jp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(jp1Var, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.clearGlobalStorage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = jp1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    jp1 jp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-804054859", jp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(jp1Var, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.clearGlobalStorageSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 C = jp1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    ip1 ip1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("130910081", ip1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ip1Var, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.clearStorage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = ip1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    ip1 ip1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("130910081", ip1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ip1Var, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.clearStorageSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 C = ip1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-804054859", jp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(jp1Var, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.getGlobalStorage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 D = jp1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    jp1 jp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-804054859", jp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(jp1Var, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.getGlobalStorageInfo")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 G = jp1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    jp1 jp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-804054859", jp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(jp1Var, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.getGlobalStorageInfoSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 J = jp1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-804054859", jp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(jp1Var, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.getGlobalStorageSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 K = jp1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("130910081", ip1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ip1Var, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.getStorage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 D = ip1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    ip1 ip1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("130910081", ip1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ip1Var, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.getStorageInfo")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 G = ip1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("130910081", ip1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ip1Var, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.getStorageInfoAsync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 H = ip1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    ip1 ip1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("130910081", ip1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ip1Var, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.getStorageInfoSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 J = ip1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("130910081", ip1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ip1Var, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.getStorageSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 K = ip1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-804054859", jp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(jp1Var, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.removeGlobalStorage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 R = jp1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-804054859", jp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(jp1Var, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.removeGlobalStorageSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 T = jp1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("130910081", ip1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ip1Var, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.removeStorage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 R = ip1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("130910081", ip1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ip1Var, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.removeStorageSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 T = ip1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-804054859", jp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(jp1Var, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.setGlobalStorage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 U = jp1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-804054859", jp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(jp1Var, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.setGlobalStorageSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 W = jp1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("130910081", ip1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ip1Var, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.setStorage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 U = ip1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("130910081", ip1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ip1Var, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.setStorageSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 W = ip1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    lp1 lp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof lp1)) {
                            lp1Var = (lp1) obj;
                        } else {
                            lp1Var = new lp1(this.mSwanApiContext);
                            this.mApis.put("823117982", lp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(lp1Var, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Subscription.requestSubscribeFormId")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 E = lp1Var.E(str);
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    mp1 mp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof mp1)) {
                            mp1Var = (mp1) obj;
                        } else {
                            mp1Var = new mp1(this.mSwanApiContext);
                            this.mApis.put("-947445811", mp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(mp1Var, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Subscription.subscribeService")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 F = mp1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    tp1 tp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("1936205521", tp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(tp1Var, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.exitFullScreen")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = tp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    pp1 pp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof pp1)) {
                            pp1Var = (pp1) obj;
                        } else {
                            pp1Var = new pp1(this.mSwanApiContext);
                            this.mApis.put("99997465", pp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(pp1Var, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.getBrightness")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = pp1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    qp1 qp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof qp1)) {
                            qp1Var = (qp1) obj;
                        } else {
                            qp1Var = new qp1(this.mSwanApiContext);
                            this.mApis.put("-518757484", qp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(qp1Var, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.getClipboardData")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = qp1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    sp1 sp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof sp1)) {
                            sp1Var = (sp1) obj;
                        } else {
                            sp1Var = new sp1(this.mSwanApiContext);
                            this.mApis.put("1694151270", sp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(sp1Var, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.getDeviceInfo")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = sp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    up1 up1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-1321681619", up1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(up1Var, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.getDeviceProfile")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = up1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    aq1 aq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof aq1)) {
                            aq1Var = (aq1) obj;
                        } else {
                            aq1Var = new aq1(this.mSwanApiContext);
                            this.mApis.put("447234992", aq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(aq1Var, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.getMediaVolume")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = aq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    vp1 vp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof vp1)) {
                            vp1Var = (vp1) obj;
                        } else {
                            vp1Var = new vp1(this.mSwanApiContext);
                            this.mApis.put("-1569246082", vp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(vp1Var, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.makePhoneCall")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = vp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    xp1 xp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof xp1)) {
                            xp1Var = (xp1) obj;
                        } else {
                            xp1Var = new xp1(this.mSwanApiContext);
                            this.mApis.put("1099851202", xp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(xp1Var, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.openSMSPanel")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = xp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    wp1 wp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof wp1)) {
                            wp1Var = (wp1) obj;
                        } else {
                            wp1Var = new wp1(this.mSwanApiContext);
                            this.mApis.put("-1707203360", wp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(wp1Var, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.requestFullScreen")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 F = wp1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    qp1 qp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof qp1)) {
                            qp1Var = (qp1) obj;
                        } else {
                            qp1Var = new qp1(this.mSwanApiContext);
                            this.mApis.put("-518757484", qp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(qp1Var, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.setClipboardData")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = qp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    ap2 ap2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof ap2)) {
                            ap2Var = (ap2) obj;
                        } else {
                            ap2Var = new ap2(this.mSwanApiContext);
                            this.mApis.put("1161486049", ap2Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ap2Var, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.setErrorPageType")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = ap2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    aq1 aq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof aq1)) {
                            aq1Var = (aq1) obj;
                        } else {
                            aq1Var = new aq1(this.mSwanApiContext);
                            this.mApis.put("447234992", aq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(aq1Var, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.setMediaVolume")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 z = aq1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    op1 op1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof op1)) {
                            op1Var = (op1) obj;
                        } else {
                            op1Var = new op1(this.mSwanApiContext);
                            this.mApis.put("1372680763", op1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(op1Var, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.startAccelerometer")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = op1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    rp1 rp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof rp1)) {
                            rp1Var = (rp1) obj;
                        } else {
                            rp1Var = new rp1(this.mSwanApiContext);
                            this.mApis.put("1689255576", rp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(rp1Var, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.startCompass")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = rp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    op1 op1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof op1)) {
                            op1Var = (op1) obj;
                        } else {
                            op1Var = new op1(this.mSwanApiContext);
                            this.mApis.put("1372680763", op1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(op1Var, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.stopAccelerometer")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 B = op1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    rp1 rp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof rp1)) {
                            rp1Var = (rp1) obj;
                        } else {
                            rp1Var = new rp1(this.mSwanApiContext);
                            this.mApis.put("1689255576", rp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(rp1Var, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.stopCompass")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 z = rp1Var.z();
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    lq1 lq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof lq1)) {
                            lq1Var = (lq1) obj;
                        } else {
                            lq1Var = new lq1(this.mSwanApiContext);
                            this.mApis.put("201194468", lq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(lq1Var, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.addToDesktop")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 B = lq1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    hq1 hq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof hq1)) {
                            hq1Var = (hq1) obj;
                        } else {
                            hq1Var = new hq1(this.mSwanApiContext);
                            this.mApis.put("-1412306947", hq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(hq1Var, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.calcMD5")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = hq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    iq1 iq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof iq1)) {
                            iq1Var = (iq1) obj;
                        } else {
                            iq1Var = new iq1(this.mSwanApiContext);
                            this.mApis.put("1626415364", iq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(iq1Var, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.checkAppInstalled")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = iq1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    kq1 kq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("-836768778", kq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(kq1Var, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.getCommonSysInfo")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = kq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    qq1 qq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof qq1)) {
                            qq1Var = (qq1) obj;
                        } else {
                            qq1Var = new qq1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", qq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(qq1Var, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.getCommonSysInfoSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 E = qq1Var.E();
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    mq1 mq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof mq1)) {
                            mq1Var = (mq1) obj;
                        } else {
                            mq1Var = new mq1(this.mSwanApiContext);
                            this.mApis.put("-810858308", mq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(mq1Var, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.getPerformanceLevel")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = mq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    qq1 qq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof qq1)) {
                            qq1Var = (qq1) obj;
                        } else {
                            qq1Var = new qq1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", qq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(qq1Var, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.getSystemInfo")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 H = qq1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    qq1 qq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof qq1)) {
                            qq1Var = (qq1) obj;
                        } else {
                            qq1Var = new qq1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", qq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(qq1Var, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.getSystemInfoAsync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 I = qq1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    qq1 qq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof qq1)) {
                            qq1Var = (qq1) obj;
                        } else {
                            qq1Var = new qq1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", qq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(qq1Var, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.getSystemInfoSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 J = qq1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    nq1 nq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof nq1)) {
                            nq1Var = (nq1) obj;
                        } else {
                            nq1Var = new nq1(this.mSwanApiContext);
                            this.mApis.put("-2097727681", nq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(nq1Var, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.handleException")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = nq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    jq1 jq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof jq1)) {
                            jq1Var = (jq1) obj;
                        } else {
                            jq1Var = new jq1(this.mSwanApiContext);
                            this.mApis.put("2084449317", jq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(jq1Var, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.hasCloseHandler")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = jq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    m33 m33Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof m33)) {
                            m33Var = (m33) obj;
                        } else {
                            m33Var = new m33(this.mSwanApiContext);
                            this.mApis.put("1031678042", m33Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(m33Var, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.hideCaptureScreenShareDialog")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = m33Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    oq1 oq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof oq1)) {
                            oq1Var = (oq1) obj;
                        } else {
                            oq1Var = new oq1(this.mSwanApiContext);
                            this.mApis.put("1751900130", oq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(oq1Var, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.logToFile")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = oq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    n23 n23Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof n23)) {
                            n23Var = (n23) obj;
                        } else {
                            n23Var = new n23(this.mSwanApiContext);
                            this.mApis.put("1748196865", n23Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(n23Var, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.preloadPackage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = n23Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    pq1 pq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof pq1)) {
                            pq1Var = (pq1) obj;
                        } else {
                            pq1Var = new pq1(this.mSwanApiContext);
                            this.mApis.put("589529211", pq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(pq1Var, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.previewImage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 B = pq1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    sq1 sq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof sq1)) {
                            sq1Var = (sq1) obj;
                        } else {
                            sq1Var = new sq1(this.mSwanApiContext);
                            this.mApis.put("-577481801", sq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(sq1Var, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.ubcFlowJar")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 I = sq1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    x93 x93Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof x93)) {
                            x93Var = (x93) obj;
                        } else {
                            x93Var = new x93(this.mSwanApiContext);
                            this.mApis.put("1879401452", x93Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(x93Var, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Wifi.connectWifi")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = x93Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    x93 x93Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof x93)) {
                            x93Var = (x93) obj;
                        } else {
                            x93Var = new x93(this.mSwanApiContext);
                            this.mApis.put("1879401452", x93Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(x93Var, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Wifi.getConnectedWifi")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 B = x93Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    x93 x93Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof x93)) {
                            x93Var = (x93) obj;
                        } else {
                            x93Var = new x93(this.mSwanApiContext);
                            this.mApis.put("1879401452", x93Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(x93Var, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Wifi.getWifiList")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 C = x93Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    x93 x93Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof x93)) {
                            x93Var = (x93) obj;
                        } else {
                            x93Var = new x93(this.mSwanApiContext);
                            this.mApis.put("1879401452", x93Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(x93Var, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Wifi.startWifi")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 G = x93Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    x93 x93Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof x93)) {
                            x93Var = (x93) obj;
                        } else {
                            x93Var = new x93(this.mSwanApiContext);
                            this.mApis.put("1879401452", x93Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(x93Var, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Wifi.stopWifi")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 H = x93Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static Map<String, Object> getWebviewApiModules(final in1 in1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, in1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    on1 on1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof on1)) {
                            on1Var = (on1) obj;
                        } else {
                            on1Var = new on1(this.mSwanApiContext);
                            this.mApis.put("1930258908", on1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(on1Var, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Account.checkSession")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = on1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    pn1 pn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof pn1)) {
                            pn1Var = (pn1) obj;
                        } else {
                            pn1Var = new pn1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", pn1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(pn1Var, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Account.getLoginCode")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 C = pn1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    qn1 qn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof qn1)) {
                            qn1Var = (qn1) obj;
                        } else {
                            qn1Var = new qn1(this.mSwanApiContext);
                            this.mApis.put("1754780133", qn1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(qn1Var, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Account.getOpenId")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = qn1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    xm1 xm1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof xm1)) {
                            xm1Var = (xm1) obj;
                        } else {
                            xm1Var = new xm1(this.mSwanApiContext);
                            this.mApis.put("-343998465", xm1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(xm1Var, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Account.getUnionBDUSS")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = xm1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    nn1 nn1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof nn1)) {
                            nn1Var = (nn1) obj;
                        } else {
                            nn1Var = new nn1(this.mSwanApiContext);
                            this.mApis.put("-337742792", nn1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(nn1Var, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Account.isBaiduAccountSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = nn1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    pn1 pn1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof pn1)) {
                            pn1Var = (pn1) obj;
                        } else {
                            pn1Var = new pn1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", pn1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(pn1Var, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Account.isLoginSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 H = pn1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    pn1 pn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof pn1)) {
                            pn1Var = (pn1) obj;
                        } else {
                            pn1Var = new pn1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", pn1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(pn1Var, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Account.login")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 I = pn1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    rn1 rn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof rn1)) {
                            rn1Var = (rn1) obj;
                        } else {
                            rn1Var = new rn1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", rn1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(rn1Var, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Basic.loadSubPackage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 F = rn1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    rn1 rn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof rn1)) {
                            rn1Var = (rn1) obj;
                        } else {
                            rn1Var = new rn1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", rn1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(rn1Var, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Basic.loadSubPackages")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 G = rn1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    yf1 yf1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof yf1)) {
                            yf1Var = (yf1) obj;
                        } else {
                            yf1Var = new yf1(this.mSwanApiContext);
                            this.mApis.put("1460300387", yf1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(yf1Var, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Bookshelf.deleteBookshelf")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 K = yf1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    yf1 yf1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof yf1)) {
                            yf1Var = (yf1) obj;
                        } else {
                            yf1Var = new yf1(this.mSwanApiContext);
                            this.mApis.put("1460300387", yf1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(yf1Var, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Bookshelf.insertBookshelf")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 P = yf1Var.P(str);
                        return P == null ? "" : P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    yf1 yf1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof yf1)) {
                            yf1Var = (yf1) obj;
                        } else {
                            yf1Var = new yf1(this.mSwanApiContext);
                            this.mApis.put("1460300387", yf1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(yf1Var, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Bookshelf.navigateToBookshelf")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 U = yf1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    yf1 yf1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof yf1)) {
                            yf1Var = (yf1) obj;
                        } else {
                            yf1Var = new yf1(this.mSwanApiContext);
                            this.mApis.put("1460300387", yf1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(yf1Var, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Bookshelf.queryBookshelf")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 V = yf1Var.V(str);
                        return V == null ? "" : V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    yf1 yf1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof yf1)) {
                            yf1Var = (yf1) obj;
                        } else {
                            yf1Var = new yf1(this.mSwanApiContext);
                            this.mApis.put("1460300387", yf1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(yf1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Bookshelf.updateBookshelfReadTime")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 X = yf1Var.X(str);
                        return X == null ? "" : X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    ln1 ln1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof ln1)) {
                            ln1Var = (ln1) obj;
                        } else {
                            ln1Var = new ln1(this.mSwanApiContext);
                            this.mApis.put("-277316359", ln1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ln1Var, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Coupon.getPlatformCoupons")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = ln1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    ln1 ln1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof ln1)) {
                            ln1Var = (ln1) obj;
                        } else {
                            ln1Var = new ln1(this.mSwanApiContext);
                            this.mApis.put("-277316359", ln1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ln1Var, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Coupon.getUserCoupons")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 z = ln1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    ln1 ln1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof ln1)) {
                            ln1Var = (ln1) obj;
                        } else {
                            ln1Var = new ln1(this.mSwanApiContext);
                            this.mApis.put("-277316359", ln1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ln1Var, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Coupon.takeCoupons")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 C = ln1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    tn1 tn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof tn1)) {
                            tn1Var = (tn1) obj;
                        } else {
                            tn1Var = new tn1(this.mSwanApiContext);
                            this.mApis.put("-1225406515", tn1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(tn1Var, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Favorite.getFavorStatus")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = tn1Var.x(str);
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
                        Pair<Boolean, gr1> a = ir1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Favorite.showFavoriteGuide")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 G = showFavoriteGuideApi.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    vn1 vn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof vn1)) {
                            vn1Var = (vn1) obj;
                        } else {
                            vn1Var = new vn1(this.mSwanApiContext);
                            this.mApis.put("-2057135077", vn1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(vn1Var, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "File.shareFile")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = vn1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    kc2 kc2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof kc2)) {
                            kc2Var = (kc2) obj;
                        } else {
                            kc2Var = new kc2(this.mSwanApiContext);
                            this.mApis.put("2077414795", kc2Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(kc2Var, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "GameCenter.postGameCenterMessage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = kc2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    kc2 kc2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof kc2)) {
                            kc2Var = (kc2) obj;
                        } else {
                            kc2Var = new kc2(this.mSwanApiContext);
                            this.mApis.put("2077414795", kc2Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(kc2Var, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "GameCenter.postGameCenterMessageSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = kc2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String download(String str) {
                    wn1 wn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof wn1)) {
                            wn1Var = (wn1) obj;
                        } else {
                            wn1Var = new wn1(this.mSwanApiContext);
                            this.mApis.put("-170124576", wn1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(wn1Var, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "HostDownloadManager.download")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = wn1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    wn1 wn1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof wn1)) {
                            wn1Var = (wn1) obj;
                        } else {
                            wn1Var = new wn1(this.mSwanApiContext);
                            this.mApis.put("-170124576", wn1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(wn1Var, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "HostDownloadManager.openDownloadCenter")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = wn1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    wn1 wn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof wn1)) {
                            wn1Var = (wn1) obj;
                        } else {
                            wn1Var = new wn1(this.mSwanApiContext);
                            this.mApis.put("-170124576", wn1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(wn1Var, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "HostDownloadManager.openFile")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 z = wn1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    wn1 wn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof wn1)) {
                            wn1Var = (wn1) obj;
                        } else {
                            wn1Var = new wn1(this.mSwanApiContext);
                            this.mApis.put("-170124576", wn1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(wn1Var, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "HostDownloadManager.query")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 query = wn1Var.query(str);
                        return query == null ? "" : query.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naImage", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    yo2 yo2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof yo2)) {
                            yo2Var = (yo2) obj;
                        } else {
                            yo2Var = new yo2(this.mSwanApiContext);
                            this.mApis.put("1445003743", yo2Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(yo2Var, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Image.callImageMenu")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = yo2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    zn1 zn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof zn1)) {
                            zn1Var = (zn1) obj;
                        } else {
                            zn1Var = new zn1(this.mSwanApiContext);
                            this.mApis.put("-1252730367", zn1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(zn1Var, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Image.compressImage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = zn1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    ho1 ho1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ho1)) {
                            ho1Var = (ho1) obj;
                        } else {
                            ho1Var = new ho1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ho1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ho1Var, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.closeTabBar")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = ho1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    ho1 ho1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ho1)) {
                            ho1Var = (ho1) obj;
                        } else {
                            ho1Var = new ho1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ho1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ho1Var, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.closeTabBarRedDot")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = ho1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    bo1 bo1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof bo1)) {
                            bo1Var = (bo1) obj;
                        } else {
                            bo1Var = new bo1(this.mSwanApiContext);
                            this.mApis.put("5236036", bo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(bo1Var, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.hideLoading")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = bo1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    do1 do1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof do1)) {
                            do1Var = (do1) obj;
                        } else {
                            do1Var = new do1(this.mSwanApiContext);
                            this.mApis.put("-246386074", do1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(do1Var, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.hideNavigationBarLoading")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = do1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    io1 io1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof io1)) {
                            io1Var = (io1) obj;
                        } else {
                            io1Var = new io1(this.mSwanApiContext);
                            this.mApis.put("1159492510", io1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(io1Var, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.hideToast")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 K = io1Var.K();
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    fo1 fo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof fo1)) {
                            fo1Var = (fo1) obj;
                        } else {
                            fo1Var = new fo1(this.mSwanApiContext);
                            this.mApis.put("-108978463", fo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(fo1Var, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.openMultiPicker")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 G = fo1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    fo1 fo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof fo1)) {
                            fo1Var = (fo1) obj;
                        } else {
                            fo1Var = new fo1(this.mSwanApiContext);
                            this.mApis.put("-108978463", fo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(fo1Var, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.openPicker")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 H = fo1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    ho1 ho1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ho1)) {
                            ho1Var = (ho1) obj;
                        } else {
                            ho1Var = new ho1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ho1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ho1Var, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.openTabBar")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 C = ho1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    eo1 eo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof eo1)) {
                            eo1Var = (eo1) obj;
                        } else {
                            eo1Var = new eo1(this.mSwanApiContext);
                            this.mApis.put("-1750613704", eo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(eo1Var, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.pageScrollTo")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = eo1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    do1 do1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof do1)) {
                            do1Var = (do1) obj;
                        } else {
                            do1Var = new do1(this.mSwanApiContext);
                            this.mApis.put("-246386074", do1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(do1Var, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.setNavigationBarColor")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 z = do1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    do1 do1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof do1)) {
                            do1Var = (do1) obj;
                        } else {
                            do1Var = new do1(this.mSwanApiContext);
                            this.mApis.put("-246386074", do1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(do1Var, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.setNavigationBarTitle")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = do1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    ho1 ho1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof ho1)) {
                            ho1Var = (ho1) obj;
                        } else {
                            ho1Var = new ho1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", ho1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ho1Var, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.setTabBarItem")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 D = ho1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    fo1 fo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof fo1)) {
                            fo1Var = (fo1) obj;
                        } else {
                            fo1Var = new fo1(this.mSwanApiContext);
                            this.mApis.put("-108978463", fo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(fo1Var, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.showDatePickerView")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 L = fo1Var.L(str);
                        return L == null ? "" : L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    jo1 jo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof jo1)) {
                            jo1Var = (jo1) obj;
                        } else {
                            jo1Var = new jo1(this.mSwanApiContext);
                            this.mApis.put("1172469410", jo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(jo1Var, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.showHalfScreenWebview")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 K = jo1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    bo1 bo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof bo1)) {
                            bo1Var = (bo1) obj;
                        } else {
                            bo1Var = new bo1(this.mSwanApiContext);
                            this.mApis.put("5236036", bo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(bo1Var, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.showLoading")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = bo1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    co1 co1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof co1)) {
                            co1Var = (co1) obj;
                        } else {
                            co1Var = new co1(this.mSwanApiContext);
                            this.mApis.put("1913747800", co1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(co1Var, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.showModal")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = co1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    do1 do1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof do1)) {
                            do1Var = (do1) obj;
                        } else {
                            do1Var = new do1(this.mSwanApiContext);
                            this.mApis.put("-246386074", do1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(do1Var, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.showNavigationBarLoading")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 B = do1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    io1 io1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof io1)) {
                            io1Var = (io1) obj;
                        } else {
                            io1Var = new io1(this.mSwanApiContext);
                            this.mApis.put("1159492510", io1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(io1Var, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.showToast")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 Q = io1Var.Q(str);
                        return Q == null ? "" : Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    go1 go1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof go1)) {
                            go1Var = (go1) obj;
                        } else {
                            go1Var = new go1(this.mSwanApiContext);
                            this.mApis.put("1165118609", go1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(go1Var, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.stopPullDownRefresh")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = go1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    fo1 fo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof fo1)) {
                            fo1Var = (fo1) obj;
                        } else {
                            fo1Var = new fo1(this.mSwanApiContext);
                            this.mApis.put("-108978463", fo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(fo1Var, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Interaction.updateMultiPicker")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 M = fo1Var.M(str);
                        return M == null ? "" : M.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    ko1 ko1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof ko1)) {
                            ko1Var = (ko1) obj;
                        } else {
                            ko1Var = new ko1(this.mSwanApiContext);
                            this.mApis.put("-137346255", ko1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ko1Var, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Keyboard.startKeyboardHeightChange")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 C = ko1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    ko1 ko1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof ko1)) {
                            ko1Var = (ko1) obj;
                        } else {
                            ko1Var = new ko1(this.mSwanApiContext);
                            this.mApis.put("-137346255", ko1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ko1Var, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Keyboard.stopKeyboardHeightChange")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 D = ko1Var.D();
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    lo1 lo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof lo1)) {
                            lo1Var = (lo1) obj;
                        } else {
                            lo1Var = new lo1(this.mSwanApiContext);
                            this.mApis.put("-397373095", lo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(lo1Var, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "LocationService.getLocation")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = lo1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    lo1 lo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof lo1)) {
                            lo1Var = (lo1) obj;
                        } else {
                            lo1Var = new lo1(this.mSwanApiContext);
                            this.mApis.put("-397373095", lo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(lo1Var, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "LocationService.startLocationUpdate")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = lo1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    lo1 lo1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof lo1)) {
                            lo1Var = (lo1) obj;
                        } else {
                            lo1Var = new lo1(this.mSwanApiContext);
                            this.mApis.put("-397373095", lo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(lo1Var, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "LocationService.stopLocationUpdate")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 B = lo1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    cq1 cq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof cq1)) {
                            cq1Var = (cq1) obj;
                        } else {
                            cq1Var = new cq1(this.mSwanApiContext);
                            this.mApis.put("538070032", cq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(cq1Var, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = cq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String callService(String str) {
                    oo1 oo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof oo1)) {
                            oo1Var = (oo1) obj;
                        } else {
                            oo1Var = new oo1(this.mSwanApiContext);
                            this.mApis.put("-1076509454", oo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(oo1Var, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Network.callService")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = oo1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    vo1 vo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof vo1)) {
                            vo1Var = (vo1) obj;
                        } else {
                            vo1Var = new vo1(this.mSwanApiContext);
                            this.mApis.put("968563034", vo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(vo1Var, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Network.cancelRequest")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 D = vo1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    uo1 uo1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof uo1)) {
                            uo1Var = (uo1) obj;
                        } else {
                            uo1Var = new uo1(this.mSwanApiContext);
                            this.mApis.put("453220699", uo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(uo1Var, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Network.getNetworkType")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = uo1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    uo1 uo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof uo1)) {
                            uo1Var = (uo1) obj;
                        } else {
                            uo1Var = new uo1(this.mSwanApiContext);
                            this.mApis.put("453220699", uo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(uo1Var, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Network.networkStatusChange")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = uo1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                @JavascriptInterface
                public String request(String str) {
                    InterceptResult invokeL2;
                    vo1 vo1Var;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && (invokeL2 = interceptable2.invokeL(1048580, this, str)) != null) {
                        return (String) invokeL2.objValue;
                    }
                    try {
                        fr1.c().a("request");
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof vo1)) {
                            vo1Var = (vo1) obj;
                        } else {
                            vo1Var = new vo1(this.mSwanApiContext);
                            this.mApis.put("968563034", vo1Var);
                        }
                        Pair<Boolean, gr1> a2 = ir1.a(vo1Var, "swanAPI/request");
                        if (((Boolean) a2.first).booleanValue()) {
                            a = ((gr1) a2.second).a();
                        } else if (o12.a(this.mSwanApiContext.h(), "Network.request")) {
                            a = new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        } else {
                            Pair<gr1, JSONObject> u = kn1.u(str);
                            if (!((gr1) u.first).isSuccess()) {
                                a = ((gr1) u.first).a();
                            } else {
                                JSONObject jSONObject = (JSONObject) u.second;
                                if (jSONObject == null) {
                                    a = gr1.a.a();
                                } else {
                                    hr1 V = vo1Var.V(jSONObject);
                                    a = V == null ? "" : V.a();
                                }
                            }
                        }
                        return a;
                    } finally {
                    }
                }
            });
            hashMap.put("_naPayment", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    es2 es2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof es2)) {
                            es2Var = (es2) obj;
                        } else {
                            es2Var = new es2(this.mSwanApiContext);
                            this.mApis.put("-336396851", es2Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(es2Var, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Payment.chooseCoupon")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = es2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    es2 es2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof es2)) {
                            es2Var = (es2) obj;
                        } else {
                            es2Var = new es2(this.mSwanApiContext);
                            this.mApis.put("-336396851", es2Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(es2Var, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Payment.getPaymentInfo")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = es2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    ur2 ur2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof ur2)) {
                            ur2Var = (ur2) obj;
                        } else {
                            ur2Var = new ur2(this.mSwanApiContext);
                            this.mApis.put("1854689529", ur2Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ur2Var, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Payment.requestThirdPayment")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = ur2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    es2 es2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof es2)) {
                            es2Var = (es2) obj;
                        } else {
                            es2Var = new es2(this.mSwanApiContext);
                            this.mApis.put("-336396851", es2Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(es2Var, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Payment.setPaymentInfo")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 z = es2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    pu2 pu2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof pu2)) {
                            pu2Var = (pu2) obj;
                        } else {
                            pu2Var = new pu2(this.mSwanApiContext);
                            this.mApis.put("-254510461", pu2Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(pu2Var, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Plugin.invokePluginChooseAddress")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = pu2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    pu2 pu2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof pu2)) {
                            pu2Var = (pu2) obj;
                        } else {
                            pu2Var = new pu2(this.mSwanApiContext);
                            this.mApis.put("-254510461", pu2Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(pu2Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 z = pu2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    pu2 pu2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof pu2)) {
                            pu2Var = (pu2) obj;
                        } else {
                            pu2Var = new pu2(this.mSwanApiContext);
                            this.mApis.put("-254510461", pu2Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(pu2Var, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Plugin.invokePluginPayment")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = pu2Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    i32 i32Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof i32)) {
                            i32Var = (i32) obj;
                        } else {
                            i32Var = new i32(this.mSwanApiContext);
                            this.mApis.put("-2068479848", i32Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(i32Var, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Prefetch.prefetchResources")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = i32Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    a22 a22Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof a22)) {
                            a22Var = (a22) obj;
                        } else {
                            a22Var = new a22(this.mSwanApiContext);
                            this.mApis.put("423661539", a22Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(a22Var, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Preload.preloadStatus")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = a22Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    kb3 kb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof kb3)) {
                            kb3Var = (kb3) obj;
                        } else {
                            kb3Var = new kb3(this.mSwanApiContext);
                            this.mApis.put("-1929343869", kb3Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(kb3Var, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "PrivateFile.uploadFileToBos")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 C = kb3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    zo1 zo1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof zo1)) {
                            zo1Var = (zo1) obj;
                        } else {
                            zo1Var = new zo1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", zo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(zo1Var, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Router.hideModalPage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = zo1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    zo1 zo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof zo1)) {
                            zo1Var = (zo1) obj;
                        } else {
                            zo1Var = new zo1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", zo1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(zo1Var, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Router.navigateBack")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 B = zo1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    ap1 ap1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof ap1)) {
                            ap1Var = (ap1) obj;
                        } else {
                            ap1Var = new ap1(this.mSwanApiContext);
                            this.mApis.put("1968522584", ap1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ap1Var, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Router.navigateTo")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 H = ap1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    cp1 cp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof cp1)) {
                            cp1Var = (cp1) obj;
                        } else {
                            cp1Var = new cp1(this.mSwanApiContext);
                            this.mApis.put("1317280190", cp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(cp1Var, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Router.reLaunch")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = cp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    dp1 dp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof dp1)) {
                            dp1Var = (dp1) obj;
                        } else {
                            dp1Var = new dp1(this.mSwanApiContext);
                            this.mApis.put("-420075743", dp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(dp1Var, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Router.reLoadErrorPage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = dp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    bp1 bp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof bp1)) {
                            bp1Var = (bp1) obj;
                        } else {
                            bp1Var = new bp1(this.mSwanApiContext);
                            this.mApis.put("1792515533", bp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(bp1Var, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Router.redirectTo")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 D = bp1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    ap1 ap1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof ap1)) {
                            ap1Var = (ap1) obj;
                        } else {
                            ap1Var = new ap1(this.mSwanApiContext);
                            this.mApis.put("1968522584", ap1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ap1Var, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Router.showModalPage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 J = ap1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    gp1 gp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("-594895721", gp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(gp1Var, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Setting.getAppInfoSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 F = gp1Var.F();
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    gp1 gp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("-594895721", gp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(gp1Var, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Setting.getSetting")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 G = gp1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    gp1 gp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("-594895721", gp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(gp1Var, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Setting.getSlaveIdSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 H = gp1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    gp1 gp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("-594895721", gp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(gp1Var, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Setting.getSwanId")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 I = gp1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    gp1 gp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("-594895721", gp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(gp1Var, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Setting.getUserInfo")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 J = gp1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    fp1 fp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof fp1)) {
                            fp1Var = (fp1) obj;
                        } else {
                            fp1Var = new fp1(this.mSwanApiContext);
                            this.mApis.put("450273045", fp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(fp1Var, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Setting.isAllowedAdOpenAppSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = fp1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    e63 e63Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof e63)) {
                            e63Var = (e63) obj;
                        } else {
                            e63Var = new e63(this.mSwanApiContext);
                            this.mApis.put("712777136", e63Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(e63Var, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = e63Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    jp1 jp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-804054859", jp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(jp1Var, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.clearGlobalStorage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = jp1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    jp1 jp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-804054859", jp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(jp1Var, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.clearGlobalStorageSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 C = jp1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    ip1 ip1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("130910081", ip1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ip1Var, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.clearStorage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = ip1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    ip1 ip1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("130910081", ip1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ip1Var, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.clearStorageSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 C = ip1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-804054859", jp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(jp1Var, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.getGlobalStorage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 D = jp1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    jp1 jp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-804054859", jp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(jp1Var, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.getGlobalStorageInfo")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 G = jp1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    jp1 jp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-804054859", jp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(jp1Var, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.getGlobalStorageInfoSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 J = jp1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-804054859", jp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(jp1Var, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.getGlobalStorageSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 K = jp1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("130910081", ip1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ip1Var, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.getStorage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 D = ip1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    ip1 ip1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("130910081", ip1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ip1Var, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.getStorageInfo")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 G = ip1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("130910081", ip1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ip1Var, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.getStorageInfoAsync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 H = ip1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    ip1 ip1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("130910081", ip1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ip1Var, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.getStorageInfoSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 J = ip1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("130910081", ip1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ip1Var, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.getStorageSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 K = ip1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-804054859", jp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(jp1Var, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.removeGlobalStorage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 R = jp1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-804054859", jp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(jp1Var, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.removeGlobalStorageSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 T = jp1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("130910081", ip1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ip1Var, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.removeStorage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 R = ip1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("130910081", ip1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ip1Var, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.removeStorageSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 T = ip1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-804054859", jp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(jp1Var, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.setGlobalStorage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 U = jp1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-804054859", jp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(jp1Var, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.setGlobalStorageSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 W = jp1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("130910081", ip1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ip1Var, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.setStorage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 U = ip1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("130910081", ip1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ip1Var, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Storage.setStorageSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 W = ip1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    lp1 lp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof lp1)) {
                            lp1Var = (lp1) obj;
                        } else {
                            lp1Var = new lp1(this.mSwanApiContext);
                            this.mApis.put("823117982", lp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(lp1Var, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Subscription.requestSubscribeFormId")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 E = lp1Var.E(str);
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    mp1 mp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof mp1)) {
                            mp1Var = (mp1) obj;
                        } else {
                            mp1Var = new mp1(this.mSwanApiContext);
                            this.mApis.put("-947445811", mp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(mp1Var, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Subscription.subscribeService")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 F = mp1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    tp1 tp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("1936205521", tp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(tp1Var, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.exitFullScreen")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = tp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    pp1 pp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof pp1)) {
                            pp1Var = (pp1) obj;
                        } else {
                            pp1Var = new pp1(this.mSwanApiContext);
                            this.mApis.put("99997465", pp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(pp1Var, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.getBrightness")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = pp1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    qp1 qp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof qp1)) {
                            qp1Var = (qp1) obj;
                        } else {
                            qp1Var = new qp1(this.mSwanApiContext);
                            this.mApis.put("-518757484", qp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(qp1Var, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.getClipboardData")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = qp1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    sp1 sp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof sp1)) {
                            sp1Var = (sp1) obj;
                        } else {
                            sp1Var = new sp1(this.mSwanApiContext);
                            this.mApis.put("1694151270", sp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(sp1Var, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.getDeviceInfo")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = sp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    up1 up1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-1321681619", up1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(up1Var, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.getDeviceProfile")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = up1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    aq1 aq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof aq1)) {
                            aq1Var = (aq1) obj;
                        } else {
                            aq1Var = new aq1(this.mSwanApiContext);
                            this.mApis.put("447234992", aq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(aq1Var, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.getMediaVolume")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = aq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    vp1 vp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof vp1)) {
                            vp1Var = (vp1) obj;
                        } else {
                            vp1Var = new vp1(this.mSwanApiContext);
                            this.mApis.put("-1569246082", vp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(vp1Var, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.makePhoneCall")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = vp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    xp1 xp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof xp1)) {
                            xp1Var = (xp1) obj;
                        } else {
                            xp1Var = new xp1(this.mSwanApiContext);
                            this.mApis.put("1099851202", xp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(xp1Var, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.openSMSPanel")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = xp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    wp1 wp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof wp1)) {
                            wp1Var = (wp1) obj;
                        } else {
                            wp1Var = new wp1(this.mSwanApiContext);
                            this.mApis.put("-1707203360", wp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(wp1Var, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.requestFullScreen")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 F = wp1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    qp1 qp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof qp1)) {
                            qp1Var = (qp1) obj;
                        } else {
                            qp1Var = new qp1(this.mSwanApiContext);
                            this.mApis.put("-518757484", qp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(qp1Var, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.setClipboardData")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = qp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    ap2 ap2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof ap2)) {
                            ap2Var = (ap2) obj;
                        } else {
                            ap2Var = new ap2(this.mSwanApiContext);
                            this.mApis.put("1161486049", ap2Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ap2Var, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.setErrorPageType")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = ap2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    aq1 aq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof aq1)) {
                            aq1Var = (aq1) obj;
                        } else {
                            aq1Var = new aq1(this.mSwanApiContext);
                            this.mApis.put("447234992", aq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(aq1Var, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.setMediaVolume")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 z = aq1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    op1 op1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof op1)) {
                            op1Var = (op1) obj;
                        } else {
                            op1Var = new op1(this.mSwanApiContext);
                            this.mApis.put("1372680763", op1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(op1Var, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.startAccelerometer")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = op1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    rp1 rp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof rp1)) {
                            rp1Var = (rp1) obj;
                        } else {
                            rp1Var = new rp1(this.mSwanApiContext);
                            this.mApis.put("1689255576", rp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(rp1Var, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.startCompass")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = rp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    op1 op1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof op1)) {
                            op1Var = (op1) obj;
                        } else {
                            op1Var = new op1(this.mSwanApiContext);
                            this.mApis.put("1372680763", op1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(op1Var, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.stopAccelerometer")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 B = op1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    rp1 rp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof rp1)) {
                            rp1Var = (rp1) obj;
                        } else {
                            rp1Var = new rp1(this.mSwanApiContext);
                            this.mApis.put("1689255576", rp1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(rp1Var, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "System.stopCompass")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 z = rp1Var.z();
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    lq1 lq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof lq1)) {
                            lq1Var = (lq1) obj;
                        } else {
                            lq1Var = new lq1(this.mSwanApiContext);
                            this.mApis.put("201194468", lq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(lq1Var, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.addToDesktop")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 B = lq1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    hq1 hq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof hq1)) {
                            hq1Var = (hq1) obj;
                        } else {
                            hq1Var = new hq1(this.mSwanApiContext);
                            this.mApis.put("-1412306947", hq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(hq1Var, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.calcMD5")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = hq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    iq1 iq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof iq1)) {
                            iq1Var = (iq1) obj;
                        } else {
                            iq1Var = new iq1(this.mSwanApiContext);
                            this.mApis.put("1626415364", iq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(iq1Var, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.checkAppInstalled")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = iq1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    kq1 kq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("-836768778", kq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(kq1Var, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.getCommonSysInfo")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = kq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    qq1 qq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof qq1)) {
                            qq1Var = (qq1) obj;
                        } else {
                            qq1Var = new qq1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", qq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(qq1Var, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.getCommonSysInfoSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 E = qq1Var.E();
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    mq1 mq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof mq1)) {
                            mq1Var = (mq1) obj;
                        } else {
                            mq1Var = new mq1(this.mSwanApiContext);
                            this.mApis.put("-810858308", mq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(mq1Var, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.getPerformanceLevel")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = mq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    qq1 qq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof qq1)) {
                            qq1Var = (qq1) obj;
                        } else {
                            qq1Var = new qq1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", qq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(qq1Var, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.getSystemInfo")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 H = qq1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    qq1 qq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof qq1)) {
                            qq1Var = (qq1) obj;
                        } else {
                            qq1Var = new qq1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", qq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(qq1Var, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.getSystemInfoAsync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 I = qq1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    qq1 qq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof qq1)) {
                            qq1Var = (qq1) obj;
                        } else {
                            qq1Var = new qq1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", qq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(qq1Var, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.getSystemInfoSync")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 J = qq1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    nq1 nq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof nq1)) {
                            nq1Var = (nq1) obj;
                        } else {
                            nq1Var = new nq1(this.mSwanApiContext);
                            this.mApis.put("-2097727681", nq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(nq1Var, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.handleException")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = nq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    jq1 jq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof jq1)) {
                            jq1Var = (jq1) obj;
                        } else {
                            jq1Var = new jq1(this.mSwanApiContext);
                            this.mApis.put("2084449317", jq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(jq1Var, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.hasCloseHandler")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = jq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    m33 m33Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof m33)) {
                            m33Var = (m33) obj;
                        } else {
                            m33Var = new m33(this.mSwanApiContext);
                            this.mApis.put("1031678042", m33Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(m33Var, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.hideCaptureScreenShareDialog")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 x = m33Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    oq1 oq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof oq1)) {
                            oq1Var = (oq1) obj;
                        } else {
                            oq1Var = new oq1(this.mSwanApiContext);
                            this.mApis.put("1751900130", oq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(oq1Var, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.logToFile")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = oq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    n23 n23Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof n23)) {
                            n23Var = (n23) obj;
                        } else {
                            n23Var = new n23(this.mSwanApiContext);
                            this.mApis.put("1748196865", n23Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(n23Var, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.preloadPackage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = n23Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    pq1 pq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof pq1)) {
                            pq1Var = (pq1) obj;
                        } else {
                            pq1Var = new pq1(this.mSwanApiContext);
                            this.mApis.put("589529211", pq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(pq1Var, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.previewImage")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 B = pq1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    sq1 sq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof sq1)) {
                            sq1Var = (sq1) obj;
                        } else {
                            sq1Var = new sq1(this.mSwanApiContext);
                            this.mApis.put("-577481801", sq1Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(sq1Var, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Utils.ubcFlowJar")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 I = sq1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    x93 x93Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof x93)) {
                            x93Var = (x93) obj;
                        } else {
                            x93Var = new x93(this.mSwanApiContext);
                            this.mApis.put("1879401452", x93Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(x93Var, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Wifi.connectWifi")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 A = x93Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    x93 x93Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof x93)) {
                            x93Var = (x93) obj;
                        } else {
                            x93Var = new x93(this.mSwanApiContext);
                            this.mApis.put("1879401452", x93Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(x93Var, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Wifi.getConnectedWifi")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 B = x93Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    x93 x93Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof x93)) {
                            x93Var = (x93) obj;
                        } else {
                            x93Var = new x93(this.mSwanApiContext);
                            this.mApis.put("1879401452", x93Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(x93Var, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Wifi.getWifiList")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 C = x93Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    x93 x93Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof x93)) {
                            x93Var = (x93) obj;
                        } else {
                            x93Var = new x93(this.mSwanApiContext);
                            this.mApis.put("1879401452", x93Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(x93Var, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Wifi.startWifi")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 G = x93Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    x93 x93Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof x93)) {
                            x93Var = (x93) obj;
                        } else {
                            x93Var = new x93(this.mSwanApiContext);
                            this.mApis.put("1879401452", x93Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(x93Var, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "Wifi.stopWifi")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 H = x93Var.H(str);
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
