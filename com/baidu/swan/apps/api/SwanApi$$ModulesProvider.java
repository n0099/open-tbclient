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
import com.repackage.ao1;
import com.repackage.aq1;
import com.repackage.ar1;
import com.repackage.av2;
import com.repackage.bo1;
import com.repackage.bq1;
import com.repackage.br1;
import com.repackage.co1;
import com.repackage.cq1;
import com.repackage.dq1;
import com.repackage.dr1;
import com.repackage.eo1;
import com.repackage.eq1;
import com.repackage.fp1;
import com.repackage.fq1;
import com.repackage.fs2;
import com.repackage.go1;
import com.repackage.gp1;
import com.repackage.gq1;
import com.repackage.ho1;
import com.repackage.hq1;
import com.repackage.ia3;
import com.repackage.in1;
import com.repackage.iq1;
import com.repackage.jg1;
import com.repackage.jp2;
import com.repackage.ko1;
import com.repackage.kp1;
import com.repackage.l22;
import com.repackage.lp1;
import com.repackage.lp2;
import com.repackage.lq1;
import com.repackage.mo1;
import com.repackage.mp1;
import com.repackage.no1;
import com.repackage.np1;
import com.repackage.nq1;
import com.repackage.oo1;
import com.repackage.op1;
import com.repackage.p63;
import com.repackage.po1;
import com.repackage.ps2;
import com.repackage.qo1;
import com.repackage.qp1;
import com.repackage.qr1;
import com.repackage.ro1;
import com.repackage.rp1;
import com.repackage.rr1;
import com.repackage.so1;
import com.repackage.sq1;
import com.repackage.sr1;
import com.repackage.t32;
import com.repackage.tn1;
import com.repackage.to1;
import com.repackage.tp1;
import com.repackage.tq1;
import com.repackage.tr1;
import com.repackage.uo1;
import com.repackage.up1;
import com.repackage.uq1;
import com.repackage.vb3;
import com.repackage.vc2;
import com.repackage.vn1;
import com.repackage.vo1;
import com.repackage.vq1;
import com.repackage.wn1;
import com.repackage.wo1;
import com.repackage.wp1;
import com.repackage.wq1;
import com.repackage.x33;
import com.repackage.xp1;
import com.repackage.xq1;
import com.repackage.y23;
import com.repackage.yn1;
import com.repackage.yq1;
import com.repackage.z12;
import com.repackage.zn1;
import com.repackage.zo1;
import com.repackage.zp1;
import com.repackage.zq1;
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

    public static Map<String, Object> getV8ApiModules(final tn1 tn1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tn1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    zn1 zn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof zn1)) {
                            zn1Var = (zn1) obj;
                        } else {
                            zn1Var = new zn1(this.mSwanApiContext);
                            this.mApis.put("1930258908", zn1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(zn1Var, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Account.checkSession")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = zn1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    ao1 ao1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ao1)) {
                            ao1Var = (ao1) obj;
                        } else {
                            ao1Var = new ao1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ao1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ao1Var, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Account.getLoginCode")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 C = ao1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    bo1 bo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof bo1)) {
                            bo1Var = (bo1) obj;
                        } else {
                            bo1Var = new bo1(this.mSwanApiContext);
                            this.mApis.put("1754780133", bo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(bo1Var, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Account.getOpenId")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = bo1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    in1 in1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof in1)) {
                            in1Var = (in1) obj;
                        } else {
                            in1Var = new in1(this.mSwanApiContext);
                            this.mApis.put("-343998465", in1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(in1Var, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Account.getUnionBDUSS")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = in1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    yn1 yn1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof yn1)) {
                            yn1Var = (yn1) obj;
                        } else {
                            yn1Var = new yn1(this.mSwanApiContext);
                            this.mApis.put("-337742792", yn1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(yn1Var, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Account.isBaiduAccountSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = yn1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    ao1 ao1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ao1)) {
                            ao1Var = (ao1) obj;
                        } else {
                            ao1Var = new ao1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ao1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ao1Var, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Account.isLoginSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 H = ao1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    ao1 ao1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ao1)) {
                            ao1Var = (ao1) obj;
                        } else {
                            ao1Var = new ao1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ao1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ao1Var, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Account.login")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 I = ao1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    co1 co1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof co1)) {
                            co1Var = (co1) obj;
                        } else {
                            co1Var = new co1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", co1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(co1Var, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Basic.loadSubPackage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 F = co1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    co1 co1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof co1)) {
                            co1Var = (co1) obj;
                        } else {
                            co1Var = new co1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", co1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(co1Var, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Basic.loadSubPackages")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 G = co1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    jg1 jg1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof jg1)) {
                            jg1Var = (jg1) obj;
                        } else {
                            jg1Var = new jg1(this.mSwanApiContext);
                            this.mApis.put("1460300387", jg1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(jg1Var, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Bookshelf.deleteBookshelf")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 K = jg1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    jg1 jg1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof jg1)) {
                            jg1Var = (jg1) obj;
                        } else {
                            jg1Var = new jg1(this.mSwanApiContext);
                            this.mApis.put("1460300387", jg1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(jg1Var, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Bookshelf.insertBookshelf")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 P = jg1Var.P(str);
                        return P == null ? "" : P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    jg1 jg1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof jg1)) {
                            jg1Var = (jg1) obj;
                        } else {
                            jg1Var = new jg1(this.mSwanApiContext);
                            this.mApis.put("1460300387", jg1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(jg1Var, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Bookshelf.navigateToBookshelf")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 U = jg1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    jg1 jg1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof jg1)) {
                            jg1Var = (jg1) obj;
                        } else {
                            jg1Var = new jg1(this.mSwanApiContext);
                            this.mApis.put("1460300387", jg1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(jg1Var, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Bookshelf.queryBookshelf")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 V = jg1Var.V(str);
                        return V == null ? "" : V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    jg1 jg1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof jg1)) {
                            jg1Var = (jg1) obj;
                        } else {
                            jg1Var = new jg1(this.mSwanApiContext);
                            this.mApis.put("1460300387", jg1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(jg1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Bookshelf.updateBookshelfReadTime")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 X = jg1Var.X(str);
                        return X == null ? "" : X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    wn1 wn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof wn1)) {
                            wn1Var = (wn1) obj;
                        } else {
                            wn1Var = new wn1(this.mSwanApiContext);
                            this.mApis.put("-277316359", wn1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(wn1Var, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Coupon.getPlatformCoupons")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = wn1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    wn1 wn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof wn1)) {
                            wn1Var = (wn1) obj;
                        } else {
                            wn1Var = new wn1(this.mSwanApiContext);
                            this.mApis.put("-277316359", wn1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(wn1Var, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Coupon.getUserCoupons")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 z = wn1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    wn1 wn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof wn1)) {
                            wn1Var = (wn1) obj;
                        } else {
                            wn1Var = new wn1(this.mSwanApiContext);
                            this.mApis.put("-277316359", wn1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(wn1Var, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Coupon.takeCoupons")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 C = wn1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    eo1 eo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof eo1)) {
                            eo1Var = (eo1) obj;
                        } else {
                            eo1Var = new eo1(this.mSwanApiContext);
                            this.mApis.put("-1225406515", eo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(eo1Var, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Favorite.getFavorStatus")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = eo1Var.x(str);
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
                        Pair<Boolean, rr1> a = tr1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Favorite.showFavoriteGuide")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 G = showFavoriteGuideApi.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    go1 go1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof go1)) {
                            go1Var = (go1) obj;
                        } else {
                            go1Var = new go1(this.mSwanApiContext);
                            this.mApis.put("-2057135077", go1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(go1Var, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "File.shareFile")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = go1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    vc2 vc2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof vc2)) {
                            vc2Var = (vc2) obj;
                        } else {
                            vc2Var = new vc2(this.mSwanApiContext);
                            this.mApis.put("2077414795", vc2Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(vc2Var, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "GameCenter.postGameCenterMessage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = vc2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    vc2 vc2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof vc2)) {
                            vc2Var = (vc2) obj;
                        } else {
                            vc2Var = new vc2(this.mSwanApiContext);
                            this.mApis.put("2077414795", vc2Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(vc2Var, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "GameCenter.postGameCenterMessageSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = vc2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String download(String str) {
                    ho1 ho1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof ho1)) {
                            ho1Var = (ho1) obj;
                        } else {
                            ho1Var = new ho1(this.mSwanApiContext);
                            this.mApis.put("-170124576", ho1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ho1Var, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "HostDownloadManager.download")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = ho1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    ho1 ho1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof ho1)) {
                            ho1Var = (ho1) obj;
                        } else {
                            ho1Var = new ho1(this.mSwanApiContext);
                            this.mApis.put("-170124576", ho1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ho1Var, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "HostDownloadManager.openDownloadCenter")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = ho1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    ho1 ho1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof ho1)) {
                            ho1Var = (ho1) obj;
                        } else {
                            ho1Var = new ho1(this.mSwanApiContext);
                            this.mApis.put("-170124576", ho1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ho1Var, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "HostDownloadManager.openFile")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 z = ho1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    ho1 ho1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof ho1)) {
                            ho1Var = (ho1) obj;
                        } else {
                            ho1Var = new ho1(this.mSwanApiContext);
                            this.mApis.put("-170124576", ho1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ho1Var, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "HostDownloadManager.query")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 query = ho1Var.query(str);
                        return query == null ? "" : query.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naImage", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    jp2 jp2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof jp2)) {
                            jp2Var = (jp2) obj;
                        } else {
                            jp2Var = new jp2(this.mSwanApiContext);
                            this.mApis.put("1445003743", jp2Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(jp2Var, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Image.callImageMenu")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = jp2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    ko1 ko1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof ko1)) {
                            ko1Var = (ko1) obj;
                        } else {
                            ko1Var = new ko1(this.mSwanApiContext);
                            this.mApis.put("-1252730367", ko1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ko1Var, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Image.compressImage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = ko1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    so1 so1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof so1)) {
                            so1Var = (so1) obj;
                        } else {
                            so1Var = new so1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", so1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(so1Var, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.closeTabBar")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = so1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    so1 so1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof so1)) {
                            so1Var = (so1) obj;
                        } else {
                            so1Var = new so1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", so1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(so1Var, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.closeTabBarRedDot")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = so1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    mo1 mo1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof mo1)) {
                            mo1Var = (mo1) obj;
                        } else {
                            mo1Var = new mo1(this.mSwanApiContext);
                            this.mApis.put("5236036", mo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(mo1Var, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.hideLoading")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = mo1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    oo1 oo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof oo1)) {
                            oo1Var = (oo1) obj;
                        } else {
                            oo1Var = new oo1(this.mSwanApiContext);
                            this.mApis.put("-246386074", oo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(oo1Var, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.hideNavigationBarLoading")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = oo1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    to1 to1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof to1)) {
                            to1Var = (to1) obj;
                        } else {
                            to1Var = new to1(this.mSwanApiContext);
                            this.mApis.put("1159492510", to1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(to1Var, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.hideToast")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 K = to1Var.K();
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    qo1 qo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof qo1)) {
                            qo1Var = (qo1) obj;
                        } else {
                            qo1Var = new qo1(this.mSwanApiContext);
                            this.mApis.put("-108978463", qo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(qo1Var, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.openMultiPicker")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 G = qo1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    qo1 qo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof qo1)) {
                            qo1Var = (qo1) obj;
                        } else {
                            qo1Var = new qo1(this.mSwanApiContext);
                            this.mApis.put("-108978463", qo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(qo1Var, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.openPicker")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 H = qo1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    so1 so1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof so1)) {
                            so1Var = (so1) obj;
                        } else {
                            so1Var = new so1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", so1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(so1Var, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.openTabBar")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 C = so1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    po1 po1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof po1)) {
                            po1Var = (po1) obj;
                        } else {
                            po1Var = new po1(this.mSwanApiContext);
                            this.mApis.put("-1750613704", po1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(po1Var, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.pageScrollTo")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = po1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    oo1 oo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof oo1)) {
                            oo1Var = (oo1) obj;
                        } else {
                            oo1Var = new oo1(this.mSwanApiContext);
                            this.mApis.put("-246386074", oo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(oo1Var, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.setNavigationBarColor")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 z = oo1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    oo1 oo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof oo1)) {
                            oo1Var = (oo1) obj;
                        } else {
                            oo1Var = new oo1(this.mSwanApiContext);
                            this.mApis.put("-246386074", oo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(oo1Var, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.setNavigationBarTitle")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = oo1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    so1 so1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof so1)) {
                            so1Var = (so1) obj;
                        } else {
                            so1Var = new so1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", so1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(so1Var, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.setTabBarItem")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 D = so1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    qo1 qo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof qo1)) {
                            qo1Var = (qo1) obj;
                        } else {
                            qo1Var = new qo1(this.mSwanApiContext);
                            this.mApis.put("-108978463", qo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(qo1Var, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.showDatePickerView")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 L = qo1Var.L(str);
                        return L == null ? "" : L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    uo1 uo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof uo1)) {
                            uo1Var = (uo1) obj;
                        } else {
                            uo1Var = new uo1(this.mSwanApiContext);
                            this.mApis.put("1172469410", uo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(uo1Var, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.showHalfScreenWebview")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 K = uo1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    mo1 mo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof mo1)) {
                            mo1Var = (mo1) obj;
                        } else {
                            mo1Var = new mo1(this.mSwanApiContext);
                            this.mApis.put("5236036", mo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(mo1Var, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.showLoading")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = mo1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    no1 no1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof no1)) {
                            no1Var = (no1) obj;
                        } else {
                            no1Var = new no1(this.mSwanApiContext);
                            this.mApis.put("1913747800", no1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(no1Var, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.showModal")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = no1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    oo1 oo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof oo1)) {
                            oo1Var = (oo1) obj;
                        } else {
                            oo1Var = new oo1(this.mSwanApiContext);
                            this.mApis.put("-246386074", oo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(oo1Var, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.showNavigationBarLoading")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 B = oo1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    to1 to1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof to1)) {
                            to1Var = (to1) obj;
                        } else {
                            to1Var = new to1(this.mSwanApiContext);
                            this.mApis.put("1159492510", to1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(to1Var, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.showToast")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 Q = to1Var.Q(str);
                        return Q == null ? "" : Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    ro1 ro1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof ro1)) {
                            ro1Var = (ro1) obj;
                        } else {
                            ro1Var = new ro1(this.mSwanApiContext);
                            this.mApis.put("1165118609", ro1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ro1Var, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.stopPullDownRefresh")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = ro1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    qo1 qo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof qo1)) {
                            qo1Var = (qo1) obj;
                        } else {
                            qo1Var = new qo1(this.mSwanApiContext);
                            this.mApis.put("-108978463", qo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(qo1Var, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.updateMultiPicker")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 M = qo1Var.M(str);
                        return M == null ? "" : M.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    vo1 vo1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof vo1)) {
                            vo1Var = (vo1) obj;
                        } else {
                            vo1Var = new vo1(this.mSwanApiContext);
                            this.mApis.put("-137346255", vo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(vo1Var, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Keyboard.startKeyboardHeightChange")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 C = vo1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    vo1 vo1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof vo1)) {
                            vo1Var = (vo1) obj;
                        } else {
                            vo1Var = new vo1(this.mSwanApiContext);
                            this.mApis.put("-137346255", vo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(vo1Var, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Keyboard.stopKeyboardHeightChange")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 D = vo1Var.D();
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    wo1 wo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof wo1)) {
                            wo1Var = (wo1) obj;
                        } else {
                            wo1Var = new wo1(this.mSwanApiContext);
                            this.mApis.put("-397373095", wo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(wo1Var, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "LocationService.getLocation")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = wo1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    wo1 wo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof wo1)) {
                            wo1Var = (wo1) obj;
                        } else {
                            wo1Var = new wo1(this.mSwanApiContext);
                            this.mApis.put("-397373095", wo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(wo1Var, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "LocationService.startLocationUpdate")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = wo1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    wo1 wo1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof wo1)) {
                            wo1Var = (wo1) obj;
                        } else {
                            wo1Var = new wo1(this.mSwanApiContext);
                            this.mApis.put("-397373095", wo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(wo1Var, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "LocationService.stopLocationUpdate")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 B = wo1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    nq1 nq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof nq1)) {
                            nq1Var = (nq1) obj;
                        } else {
                            nq1Var = new nq1(this.mSwanApiContext);
                            this.mApis.put("538070032", nq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(nq1Var, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = nq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String callService(String str) {
                    zo1 zo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof zo1)) {
                            zo1Var = (zo1) obj;
                        } else {
                            zo1Var = new zo1(this.mSwanApiContext);
                            this.mApis.put("-1076509454", zo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(zo1Var, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Network.callService")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = zo1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    gp1 gp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("968563034", gp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(gp1Var, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Network.cancelRequest")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 D = gp1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    fp1 fp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof fp1)) {
                            fp1Var = (fp1) obj;
                        } else {
                            fp1Var = new fp1(this.mSwanApiContext);
                            this.mApis.put("453220699", fp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(fp1Var, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Network.getNetworkType")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = fp1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    fp1 fp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof fp1)) {
                            fp1Var = (fp1) obj;
                        } else {
                            fp1Var = new fp1(this.mSwanApiContext);
                            this.mApis.put("453220699", fp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(fp1Var, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Network.networkStatusChange")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = fp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                @JavascriptInterface
                public String request(JsObject jsObject) {
                    InterceptResult invokeL2;
                    gp1 gp1Var;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && (invokeL2 = interceptable2.invokeL(1048580, this, jsObject)) != null) {
                        return (String) invokeL2.objValue;
                    }
                    try {
                        qr1.c().a("request");
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("968563034", gp1Var);
                        }
                        Pair<Boolean, rr1> a2 = tr1.a(gp1Var, "swanAPI/request");
                        if (((Boolean) a2.first).booleanValue()) {
                            a = ((rr1) a2.second).a();
                        } else if (z12.a(this.mSwanApiContext.h(), "Network.request")) {
                            a = new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        } else {
                            Pair<rr1, JSONObject> t = vn1.t(jsObject);
                            if (!((rr1) t.first).isSuccess()) {
                                a = ((rr1) t.first).a();
                            } else {
                                JSONObject jSONObject = (JSONObject) t.second;
                                if (jSONObject == null) {
                                    a = rr1.a.a();
                                } else {
                                    sr1 V = gp1Var.V(jSONObject);
                                    a = V == null ? "" : V.a();
                                }
                            }
                        }
                        return a;
                    } finally {
                    }
                }
            });
            hashMap.put("_naPayment", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    ps2 ps2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof ps2)) {
                            ps2Var = (ps2) obj;
                        } else {
                            ps2Var = new ps2(this.mSwanApiContext);
                            this.mApis.put("-336396851", ps2Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ps2Var, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Payment.chooseCoupon")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = ps2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    ps2 ps2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof ps2)) {
                            ps2Var = (ps2) obj;
                        } else {
                            ps2Var = new ps2(this.mSwanApiContext);
                            this.mApis.put("-336396851", ps2Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ps2Var, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Payment.getPaymentInfo")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = ps2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    fs2 fs2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof fs2)) {
                            fs2Var = (fs2) obj;
                        } else {
                            fs2Var = new fs2(this.mSwanApiContext);
                            this.mApis.put("1854689529", fs2Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(fs2Var, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Payment.requestThirdPayment")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = fs2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    ps2 ps2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof ps2)) {
                            ps2Var = (ps2) obj;
                        } else {
                            ps2Var = new ps2(this.mSwanApiContext);
                            this.mApis.put("-336396851", ps2Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ps2Var, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Payment.setPaymentInfo")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 z = ps2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    av2 av2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof av2)) {
                            av2Var = (av2) obj;
                        } else {
                            av2Var = new av2(this.mSwanApiContext);
                            this.mApis.put("-254510461", av2Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(av2Var, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Plugin.invokePluginChooseAddress")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = av2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    av2 av2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof av2)) {
                            av2Var = (av2) obj;
                        } else {
                            av2Var = new av2(this.mSwanApiContext);
                            this.mApis.put("-254510461", av2Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(av2Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 z = av2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    av2 av2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof av2)) {
                            av2Var = (av2) obj;
                        } else {
                            av2Var = new av2(this.mSwanApiContext);
                            this.mApis.put("-254510461", av2Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(av2Var, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Plugin.invokePluginPayment")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = av2Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    t32 t32Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof t32)) {
                            t32Var = (t32) obj;
                        } else {
                            t32Var = new t32(this.mSwanApiContext);
                            this.mApis.put("-2068479848", t32Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(t32Var, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Prefetch.prefetchResources")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = t32Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    l22 l22Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof l22)) {
                            l22Var = (l22) obj;
                        } else {
                            l22Var = new l22(this.mSwanApiContext);
                            this.mApis.put("423661539", l22Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(l22Var, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Preload.preloadStatus")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = l22Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    vb3 vb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof vb3)) {
                            vb3Var = (vb3) obj;
                        } else {
                            vb3Var = new vb3(this.mSwanApiContext);
                            this.mApis.put("-1929343869", vb3Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(vb3Var, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "PrivateFile.uploadFileToBos")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 C = vb3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    kp1 kp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof kp1)) {
                            kp1Var = (kp1) obj;
                        } else {
                            kp1Var = new kp1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", kp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(kp1Var, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Router.hideModalPage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = kp1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    kp1 kp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof kp1)) {
                            kp1Var = (kp1) obj;
                        } else {
                            kp1Var = new kp1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", kp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(kp1Var, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Router.navigateBack")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 B = kp1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    lp1 lp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof lp1)) {
                            lp1Var = (lp1) obj;
                        } else {
                            lp1Var = new lp1(this.mSwanApiContext);
                            this.mApis.put("1968522584", lp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(lp1Var, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Router.navigateTo")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 H = lp1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    np1 np1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof np1)) {
                            np1Var = (np1) obj;
                        } else {
                            np1Var = new np1(this.mSwanApiContext);
                            this.mApis.put("1317280190", np1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(np1Var, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Router.reLaunch")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = np1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    op1 op1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof op1)) {
                            op1Var = (op1) obj;
                        } else {
                            op1Var = new op1(this.mSwanApiContext);
                            this.mApis.put("-420075743", op1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(op1Var, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Router.reLoadErrorPage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = op1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    mp1 mp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof mp1)) {
                            mp1Var = (mp1) obj;
                        } else {
                            mp1Var = new mp1(this.mSwanApiContext);
                            this.mApis.put("1792515533", mp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(mp1Var, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Router.redirectTo")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 D = mp1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    lp1 lp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof lp1)) {
                            lp1Var = (lp1) obj;
                        } else {
                            lp1Var = new lp1(this.mSwanApiContext);
                            this.mApis.put("1968522584", lp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(lp1Var, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Router.showModalPage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 J = lp1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    rp1 rp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof rp1)) {
                            rp1Var = (rp1) obj;
                        } else {
                            rp1Var = new rp1(this.mSwanApiContext);
                            this.mApis.put("-594895721", rp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(rp1Var, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Setting.getAppInfoSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 F = rp1Var.F();
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    rp1 rp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof rp1)) {
                            rp1Var = (rp1) obj;
                        } else {
                            rp1Var = new rp1(this.mSwanApiContext);
                            this.mApis.put("-594895721", rp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(rp1Var, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Setting.getSetting")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 G = rp1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    rp1 rp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof rp1)) {
                            rp1Var = (rp1) obj;
                        } else {
                            rp1Var = new rp1(this.mSwanApiContext);
                            this.mApis.put("-594895721", rp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(rp1Var, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Setting.getSlaveIdSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 H = rp1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    rp1 rp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof rp1)) {
                            rp1Var = (rp1) obj;
                        } else {
                            rp1Var = new rp1(this.mSwanApiContext);
                            this.mApis.put("-594895721", rp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(rp1Var, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Setting.getSwanId")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 I = rp1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    rp1 rp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof rp1)) {
                            rp1Var = (rp1) obj;
                        } else {
                            rp1Var = new rp1(this.mSwanApiContext);
                            this.mApis.put("-594895721", rp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(rp1Var, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Setting.getUserInfo")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 J = rp1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    qp1 qp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof qp1)) {
                            qp1Var = (qp1) obj;
                        } else {
                            qp1Var = new qp1(this.mSwanApiContext);
                            this.mApis.put("450273045", qp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(qp1Var, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Setting.isAllowedAdOpenAppSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = qp1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    p63 p63Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof p63)) {
                            p63Var = (p63) obj;
                        } else {
                            p63Var = new p63(this.mSwanApiContext);
                            this.mApis.put("712777136", p63Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(p63Var, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = p63Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    up1 up1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-804054859", up1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(up1Var, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.clearGlobalStorage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = up1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    up1 up1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-804054859", up1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(up1Var, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.clearGlobalStorageSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 C = up1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    tp1 tp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("130910081", tp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(tp1Var, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.clearStorage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = tp1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    tp1 tp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("130910081", tp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(tp1Var, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.clearStorageSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 C = tp1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    up1 up1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-804054859", up1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(up1Var, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.getGlobalStorage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 D = up1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    up1 up1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-804054859", up1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(up1Var, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.getGlobalStorageInfo")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 G = up1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    up1 up1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-804054859", up1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(up1Var, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.getGlobalStorageInfoSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 J = up1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    up1 up1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-804054859", up1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(up1Var, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.getGlobalStorageSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 K = up1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    tp1 tp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("130910081", tp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(tp1Var, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.getStorage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 D = tp1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    tp1 tp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("130910081", tp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(tp1Var, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.getStorageInfo")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 G = tp1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    tp1 tp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("130910081", tp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(tp1Var, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.getStorageInfoAsync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 H = tp1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    tp1 tp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("130910081", tp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(tp1Var, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.getStorageInfoSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 J = tp1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    tp1 tp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("130910081", tp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(tp1Var, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.getStorageSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 K = tp1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    up1 up1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-804054859", up1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(up1Var, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.removeGlobalStorage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 R = up1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    up1 up1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-804054859", up1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(up1Var, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.removeGlobalStorageSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 T = up1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    tp1 tp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("130910081", tp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(tp1Var, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.removeStorage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 R = tp1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    tp1 tp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("130910081", tp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(tp1Var, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.removeStorageSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 T = tp1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    up1 up1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-804054859", up1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(up1Var, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.setGlobalStorage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 U = up1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    up1 up1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-804054859", up1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(up1Var, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.setGlobalStorageSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 W = up1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    tp1 tp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("130910081", tp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(tp1Var, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.setStorage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 U = tp1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    tp1 tp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("130910081", tp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(tp1Var, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.setStorageSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 W = tp1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    wp1 wp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof wp1)) {
                            wp1Var = (wp1) obj;
                        } else {
                            wp1Var = new wp1(this.mSwanApiContext);
                            this.mApis.put("823117982", wp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(wp1Var, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Subscription.requestSubscribeFormId")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 E = wp1Var.E(str);
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    xp1 xp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof xp1)) {
                            xp1Var = (xp1) obj;
                        } else {
                            xp1Var = new xp1(this.mSwanApiContext);
                            this.mApis.put("-947445811", xp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(xp1Var, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Subscription.subscribeService")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 F = xp1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    eq1 eq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof eq1)) {
                            eq1Var = (eq1) obj;
                        } else {
                            eq1Var = new eq1(this.mSwanApiContext);
                            this.mApis.put("1936205521", eq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(eq1Var, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.exitFullScreen")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = eq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    aq1 aq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof aq1)) {
                            aq1Var = (aq1) obj;
                        } else {
                            aq1Var = new aq1(this.mSwanApiContext);
                            this.mApis.put("99997465", aq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(aq1Var, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.getBrightness")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = aq1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    bq1 bq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof bq1)) {
                            bq1Var = (bq1) obj;
                        } else {
                            bq1Var = new bq1(this.mSwanApiContext);
                            this.mApis.put("-518757484", bq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(bq1Var, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.getClipboardData")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = bq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    dq1 dq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof dq1)) {
                            dq1Var = (dq1) obj;
                        } else {
                            dq1Var = new dq1(this.mSwanApiContext);
                            this.mApis.put("1694151270", dq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(dq1Var, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.getDeviceInfo")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = dq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    fq1 fq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof fq1)) {
                            fq1Var = (fq1) obj;
                        } else {
                            fq1Var = new fq1(this.mSwanApiContext);
                            this.mApis.put("-1321681619", fq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(fq1Var, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.getDeviceProfile")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = fq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    lq1 lq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof lq1)) {
                            lq1Var = (lq1) obj;
                        } else {
                            lq1Var = new lq1(this.mSwanApiContext);
                            this.mApis.put("447234992", lq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(lq1Var, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.getMediaVolume")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = lq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    gq1 gq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof gq1)) {
                            gq1Var = (gq1) obj;
                        } else {
                            gq1Var = new gq1(this.mSwanApiContext);
                            this.mApis.put("-1569246082", gq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(gq1Var, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.makePhoneCall")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = gq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    iq1 iq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof iq1)) {
                            iq1Var = (iq1) obj;
                        } else {
                            iq1Var = new iq1(this.mSwanApiContext);
                            this.mApis.put("1099851202", iq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(iq1Var, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.openSMSPanel")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = iq1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    hq1 hq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof hq1)) {
                            hq1Var = (hq1) obj;
                        } else {
                            hq1Var = new hq1(this.mSwanApiContext);
                            this.mApis.put("-1707203360", hq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(hq1Var, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.requestFullScreen")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 F = hq1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    bq1 bq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof bq1)) {
                            bq1Var = (bq1) obj;
                        } else {
                            bq1Var = new bq1(this.mSwanApiContext);
                            this.mApis.put("-518757484", bq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(bq1Var, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.setClipboardData")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = bq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    lp2 lp2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof lp2)) {
                            lp2Var = (lp2) obj;
                        } else {
                            lp2Var = new lp2(this.mSwanApiContext);
                            this.mApis.put("1161486049", lp2Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(lp2Var, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.setErrorPageType")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = lp2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    lq1 lq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof lq1)) {
                            lq1Var = (lq1) obj;
                        } else {
                            lq1Var = new lq1(this.mSwanApiContext);
                            this.mApis.put("447234992", lq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(lq1Var, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.setMediaVolume")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 z = lq1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    zp1 zp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof zp1)) {
                            zp1Var = (zp1) obj;
                        } else {
                            zp1Var = new zp1(this.mSwanApiContext);
                            this.mApis.put("1372680763", zp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(zp1Var, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.startAccelerometer")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = zp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    cq1 cq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof cq1)) {
                            cq1Var = (cq1) obj;
                        } else {
                            cq1Var = new cq1(this.mSwanApiContext);
                            this.mApis.put("1689255576", cq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(cq1Var, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.startCompass")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = cq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    zp1 zp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof zp1)) {
                            zp1Var = (zp1) obj;
                        } else {
                            zp1Var = new zp1(this.mSwanApiContext);
                            this.mApis.put("1372680763", zp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(zp1Var, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.stopAccelerometer")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 B = zp1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    cq1 cq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof cq1)) {
                            cq1Var = (cq1) obj;
                        } else {
                            cq1Var = new cq1(this.mSwanApiContext);
                            this.mApis.put("1689255576", cq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(cq1Var, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.stopCompass")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 z = cq1Var.z();
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    wq1 wq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof wq1)) {
                            wq1Var = (wq1) obj;
                        } else {
                            wq1Var = new wq1(this.mSwanApiContext);
                            this.mApis.put("201194468", wq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(wq1Var, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.addToDesktop")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 B = wq1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    sq1 sq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof sq1)) {
                            sq1Var = (sq1) obj;
                        } else {
                            sq1Var = new sq1(this.mSwanApiContext);
                            this.mApis.put("-1412306947", sq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(sq1Var, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.calcMD5")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = sq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    tq1 tq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof tq1)) {
                            tq1Var = (tq1) obj;
                        } else {
                            tq1Var = new tq1(this.mSwanApiContext);
                            this.mApis.put("1626415364", tq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(tq1Var, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.checkAppInstalled")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = tq1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    vq1 vq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("-836768778", vq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(vq1Var, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.getCommonSysInfo")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = vq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    br1 br1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", br1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(br1Var, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.getCommonSysInfoSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 E = br1Var.E();
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    xq1 xq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof xq1)) {
                            xq1Var = (xq1) obj;
                        } else {
                            xq1Var = new xq1(this.mSwanApiContext);
                            this.mApis.put("-810858308", xq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(xq1Var, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.getPerformanceLevel")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = xq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    br1 br1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", br1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(br1Var, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.getSystemInfo")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 H = br1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", br1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(br1Var, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.getSystemInfoAsync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 I = br1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    br1 br1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", br1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(br1Var, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.getSystemInfoSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 J = br1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    yq1 yq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof yq1)) {
                            yq1Var = (yq1) obj;
                        } else {
                            yq1Var = new yq1(this.mSwanApiContext);
                            this.mApis.put("-2097727681", yq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(yq1Var, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.handleException")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = yq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    uq1 uq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof uq1)) {
                            uq1Var = (uq1) obj;
                        } else {
                            uq1Var = new uq1(this.mSwanApiContext);
                            this.mApis.put("2084449317", uq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(uq1Var, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.hasCloseHandler")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = uq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    x33 x33Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof x33)) {
                            x33Var = (x33) obj;
                        } else {
                            x33Var = new x33(this.mSwanApiContext);
                            this.mApis.put("1031678042", x33Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(x33Var, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.hideCaptureScreenShareDialog")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = x33Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    zq1 zq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof zq1)) {
                            zq1Var = (zq1) obj;
                        } else {
                            zq1Var = new zq1(this.mSwanApiContext);
                            this.mApis.put("1751900130", zq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(zq1Var, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.logToFile")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = zq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    y23 y23Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof y23)) {
                            y23Var = (y23) obj;
                        } else {
                            y23Var = new y23(this.mSwanApiContext);
                            this.mApis.put("1748196865", y23Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(y23Var, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.preloadPackage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = y23Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    ar1 ar1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof ar1)) {
                            ar1Var = (ar1) obj;
                        } else {
                            ar1Var = new ar1(this.mSwanApiContext);
                            this.mApis.put("589529211", ar1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ar1Var, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.previewImage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 B = ar1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    dr1 dr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof dr1)) {
                            dr1Var = (dr1) obj;
                        } else {
                            dr1Var = new dr1(this.mSwanApiContext);
                            this.mApis.put("-577481801", dr1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(dr1Var, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.ubcFlowJar")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 I = dr1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    ia3 ia3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ia3)) {
                            ia3Var = (ia3) obj;
                        } else {
                            ia3Var = new ia3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ia3Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ia3Var, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Wifi.connectWifi")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = ia3Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    ia3 ia3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ia3)) {
                            ia3Var = (ia3) obj;
                        } else {
                            ia3Var = new ia3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ia3Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ia3Var, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Wifi.getConnectedWifi")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 B = ia3Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    ia3 ia3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ia3)) {
                            ia3Var = (ia3) obj;
                        } else {
                            ia3Var = new ia3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ia3Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ia3Var, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Wifi.getWifiList")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 C = ia3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    ia3 ia3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ia3)) {
                            ia3Var = (ia3) obj;
                        } else {
                            ia3Var = new ia3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ia3Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ia3Var, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Wifi.startWifi")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 G = ia3Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    ia3 ia3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ia3)) {
                            ia3Var = (ia3) obj;
                        } else {
                            ia3Var = new ia3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ia3Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ia3Var, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Wifi.stopWifi")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 H = ia3Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static Map<String, Object> getWebviewApiModules(final tn1 tn1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, tn1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    zn1 zn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof zn1)) {
                            zn1Var = (zn1) obj;
                        } else {
                            zn1Var = new zn1(this.mSwanApiContext);
                            this.mApis.put("1930258908", zn1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(zn1Var, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Account.checkSession")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = zn1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    ao1 ao1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ao1)) {
                            ao1Var = (ao1) obj;
                        } else {
                            ao1Var = new ao1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ao1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ao1Var, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Account.getLoginCode")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 C = ao1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    bo1 bo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof bo1)) {
                            bo1Var = (bo1) obj;
                        } else {
                            bo1Var = new bo1(this.mSwanApiContext);
                            this.mApis.put("1754780133", bo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(bo1Var, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Account.getOpenId")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = bo1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    in1 in1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof in1)) {
                            in1Var = (in1) obj;
                        } else {
                            in1Var = new in1(this.mSwanApiContext);
                            this.mApis.put("-343998465", in1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(in1Var, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Account.getUnionBDUSS")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = in1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    yn1 yn1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof yn1)) {
                            yn1Var = (yn1) obj;
                        } else {
                            yn1Var = new yn1(this.mSwanApiContext);
                            this.mApis.put("-337742792", yn1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(yn1Var, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Account.isBaiduAccountSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = yn1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    ao1 ao1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ao1)) {
                            ao1Var = (ao1) obj;
                        } else {
                            ao1Var = new ao1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ao1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ao1Var, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Account.isLoginSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 H = ao1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    ao1 ao1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ao1)) {
                            ao1Var = (ao1) obj;
                        } else {
                            ao1Var = new ao1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ao1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ao1Var, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Account.login")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 I = ao1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    co1 co1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof co1)) {
                            co1Var = (co1) obj;
                        } else {
                            co1Var = new co1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", co1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(co1Var, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Basic.loadSubPackage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 F = co1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    co1 co1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof co1)) {
                            co1Var = (co1) obj;
                        } else {
                            co1Var = new co1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", co1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(co1Var, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Basic.loadSubPackages")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 G = co1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    jg1 jg1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof jg1)) {
                            jg1Var = (jg1) obj;
                        } else {
                            jg1Var = new jg1(this.mSwanApiContext);
                            this.mApis.put("1460300387", jg1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(jg1Var, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Bookshelf.deleteBookshelf")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 K = jg1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    jg1 jg1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof jg1)) {
                            jg1Var = (jg1) obj;
                        } else {
                            jg1Var = new jg1(this.mSwanApiContext);
                            this.mApis.put("1460300387", jg1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(jg1Var, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Bookshelf.insertBookshelf")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 P = jg1Var.P(str);
                        return P == null ? "" : P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    jg1 jg1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof jg1)) {
                            jg1Var = (jg1) obj;
                        } else {
                            jg1Var = new jg1(this.mSwanApiContext);
                            this.mApis.put("1460300387", jg1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(jg1Var, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Bookshelf.navigateToBookshelf")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 U = jg1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    jg1 jg1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof jg1)) {
                            jg1Var = (jg1) obj;
                        } else {
                            jg1Var = new jg1(this.mSwanApiContext);
                            this.mApis.put("1460300387", jg1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(jg1Var, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Bookshelf.queryBookshelf")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 V = jg1Var.V(str);
                        return V == null ? "" : V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    jg1 jg1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof jg1)) {
                            jg1Var = (jg1) obj;
                        } else {
                            jg1Var = new jg1(this.mSwanApiContext);
                            this.mApis.put("1460300387", jg1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(jg1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Bookshelf.updateBookshelfReadTime")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 X = jg1Var.X(str);
                        return X == null ? "" : X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    wn1 wn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof wn1)) {
                            wn1Var = (wn1) obj;
                        } else {
                            wn1Var = new wn1(this.mSwanApiContext);
                            this.mApis.put("-277316359", wn1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(wn1Var, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Coupon.getPlatformCoupons")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = wn1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    wn1 wn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof wn1)) {
                            wn1Var = (wn1) obj;
                        } else {
                            wn1Var = new wn1(this.mSwanApiContext);
                            this.mApis.put("-277316359", wn1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(wn1Var, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Coupon.getUserCoupons")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 z = wn1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    wn1 wn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof wn1)) {
                            wn1Var = (wn1) obj;
                        } else {
                            wn1Var = new wn1(this.mSwanApiContext);
                            this.mApis.put("-277316359", wn1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(wn1Var, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Coupon.takeCoupons")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 C = wn1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    eo1 eo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof eo1)) {
                            eo1Var = (eo1) obj;
                        } else {
                            eo1Var = new eo1(this.mSwanApiContext);
                            this.mApis.put("-1225406515", eo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(eo1Var, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Favorite.getFavorStatus")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = eo1Var.x(str);
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
                        Pair<Boolean, rr1> a = tr1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Favorite.showFavoriteGuide")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 G = showFavoriteGuideApi.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    go1 go1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof go1)) {
                            go1Var = (go1) obj;
                        } else {
                            go1Var = new go1(this.mSwanApiContext);
                            this.mApis.put("-2057135077", go1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(go1Var, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "File.shareFile")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = go1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    vc2 vc2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof vc2)) {
                            vc2Var = (vc2) obj;
                        } else {
                            vc2Var = new vc2(this.mSwanApiContext);
                            this.mApis.put("2077414795", vc2Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(vc2Var, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "GameCenter.postGameCenterMessage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = vc2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    vc2 vc2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof vc2)) {
                            vc2Var = (vc2) obj;
                        } else {
                            vc2Var = new vc2(this.mSwanApiContext);
                            this.mApis.put("2077414795", vc2Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(vc2Var, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "GameCenter.postGameCenterMessageSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = vc2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String download(String str) {
                    ho1 ho1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof ho1)) {
                            ho1Var = (ho1) obj;
                        } else {
                            ho1Var = new ho1(this.mSwanApiContext);
                            this.mApis.put("-170124576", ho1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ho1Var, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "HostDownloadManager.download")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = ho1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    ho1 ho1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof ho1)) {
                            ho1Var = (ho1) obj;
                        } else {
                            ho1Var = new ho1(this.mSwanApiContext);
                            this.mApis.put("-170124576", ho1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ho1Var, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "HostDownloadManager.openDownloadCenter")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = ho1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    ho1 ho1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof ho1)) {
                            ho1Var = (ho1) obj;
                        } else {
                            ho1Var = new ho1(this.mSwanApiContext);
                            this.mApis.put("-170124576", ho1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ho1Var, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "HostDownloadManager.openFile")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 z = ho1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    ho1 ho1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof ho1)) {
                            ho1Var = (ho1) obj;
                        } else {
                            ho1Var = new ho1(this.mSwanApiContext);
                            this.mApis.put("-170124576", ho1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ho1Var, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "HostDownloadManager.query")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 query = ho1Var.query(str);
                        return query == null ? "" : query.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naImage", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    jp2 jp2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof jp2)) {
                            jp2Var = (jp2) obj;
                        } else {
                            jp2Var = new jp2(this.mSwanApiContext);
                            this.mApis.put("1445003743", jp2Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(jp2Var, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Image.callImageMenu")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = jp2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    ko1 ko1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof ko1)) {
                            ko1Var = (ko1) obj;
                        } else {
                            ko1Var = new ko1(this.mSwanApiContext);
                            this.mApis.put("-1252730367", ko1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ko1Var, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Image.compressImage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = ko1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    so1 so1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof so1)) {
                            so1Var = (so1) obj;
                        } else {
                            so1Var = new so1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", so1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(so1Var, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.closeTabBar")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = so1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    so1 so1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof so1)) {
                            so1Var = (so1) obj;
                        } else {
                            so1Var = new so1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", so1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(so1Var, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.closeTabBarRedDot")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = so1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    mo1 mo1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof mo1)) {
                            mo1Var = (mo1) obj;
                        } else {
                            mo1Var = new mo1(this.mSwanApiContext);
                            this.mApis.put("5236036", mo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(mo1Var, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.hideLoading")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = mo1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    oo1 oo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof oo1)) {
                            oo1Var = (oo1) obj;
                        } else {
                            oo1Var = new oo1(this.mSwanApiContext);
                            this.mApis.put("-246386074", oo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(oo1Var, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.hideNavigationBarLoading")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = oo1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    to1 to1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof to1)) {
                            to1Var = (to1) obj;
                        } else {
                            to1Var = new to1(this.mSwanApiContext);
                            this.mApis.put("1159492510", to1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(to1Var, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.hideToast")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 K = to1Var.K();
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    qo1 qo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof qo1)) {
                            qo1Var = (qo1) obj;
                        } else {
                            qo1Var = new qo1(this.mSwanApiContext);
                            this.mApis.put("-108978463", qo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(qo1Var, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.openMultiPicker")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 G = qo1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    qo1 qo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof qo1)) {
                            qo1Var = (qo1) obj;
                        } else {
                            qo1Var = new qo1(this.mSwanApiContext);
                            this.mApis.put("-108978463", qo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(qo1Var, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.openPicker")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 H = qo1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    so1 so1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof so1)) {
                            so1Var = (so1) obj;
                        } else {
                            so1Var = new so1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", so1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(so1Var, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.openTabBar")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 C = so1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    po1 po1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof po1)) {
                            po1Var = (po1) obj;
                        } else {
                            po1Var = new po1(this.mSwanApiContext);
                            this.mApis.put("-1750613704", po1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(po1Var, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.pageScrollTo")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = po1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    oo1 oo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof oo1)) {
                            oo1Var = (oo1) obj;
                        } else {
                            oo1Var = new oo1(this.mSwanApiContext);
                            this.mApis.put("-246386074", oo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(oo1Var, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.setNavigationBarColor")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 z = oo1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    oo1 oo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof oo1)) {
                            oo1Var = (oo1) obj;
                        } else {
                            oo1Var = new oo1(this.mSwanApiContext);
                            this.mApis.put("-246386074", oo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(oo1Var, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.setNavigationBarTitle")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = oo1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    so1 so1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof so1)) {
                            so1Var = (so1) obj;
                        } else {
                            so1Var = new so1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", so1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(so1Var, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.setTabBarItem")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 D = so1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    qo1 qo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof qo1)) {
                            qo1Var = (qo1) obj;
                        } else {
                            qo1Var = new qo1(this.mSwanApiContext);
                            this.mApis.put("-108978463", qo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(qo1Var, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.showDatePickerView")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 L = qo1Var.L(str);
                        return L == null ? "" : L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    uo1 uo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof uo1)) {
                            uo1Var = (uo1) obj;
                        } else {
                            uo1Var = new uo1(this.mSwanApiContext);
                            this.mApis.put("1172469410", uo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(uo1Var, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.showHalfScreenWebview")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 K = uo1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    mo1 mo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof mo1)) {
                            mo1Var = (mo1) obj;
                        } else {
                            mo1Var = new mo1(this.mSwanApiContext);
                            this.mApis.put("5236036", mo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(mo1Var, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.showLoading")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = mo1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    no1 no1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof no1)) {
                            no1Var = (no1) obj;
                        } else {
                            no1Var = new no1(this.mSwanApiContext);
                            this.mApis.put("1913747800", no1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(no1Var, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.showModal")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = no1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    oo1 oo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof oo1)) {
                            oo1Var = (oo1) obj;
                        } else {
                            oo1Var = new oo1(this.mSwanApiContext);
                            this.mApis.put("-246386074", oo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(oo1Var, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.showNavigationBarLoading")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 B = oo1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    to1 to1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof to1)) {
                            to1Var = (to1) obj;
                        } else {
                            to1Var = new to1(this.mSwanApiContext);
                            this.mApis.put("1159492510", to1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(to1Var, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.showToast")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 Q = to1Var.Q(str);
                        return Q == null ? "" : Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    ro1 ro1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof ro1)) {
                            ro1Var = (ro1) obj;
                        } else {
                            ro1Var = new ro1(this.mSwanApiContext);
                            this.mApis.put("1165118609", ro1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ro1Var, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.stopPullDownRefresh")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = ro1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    qo1 qo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof qo1)) {
                            qo1Var = (qo1) obj;
                        } else {
                            qo1Var = new qo1(this.mSwanApiContext);
                            this.mApis.put("-108978463", qo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(qo1Var, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Interaction.updateMultiPicker")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 M = qo1Var.M(str);
                        return M == null ? "" : M.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    vo1 vo1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof vo1)) {
                            vo1Var = (vo1) obj;
                        } else {
                            vo1Var = new vo1(this.mSwanApiContext);
                            this.mApis.put("-137346255", vo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(vo1Var, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Keyboard.startKeyboardHeightChange")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 C = vo1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    vo1 vo1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof vo1)) {
                            vo1Var = (vo1) obj;
                        } else {
                            vo1Var = new vo1(this.mSwanApiContext);
                            this.mApis.put("-137346255", vo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(vo1Var, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Keyboard.stopKeyboardHeightChange")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 D = vo1Var.D();
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    wo1 wo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof wo1)) {
                            wo1Var = (wo1) obj;
                        } else {
                            wo1Var = new wo1(this.mSwanApiContext);
                            this.mApis.put("-397373095", wo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(wo1Var, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "LocationService.getLocation")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = wo1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    wo1 wo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof wo1)) {
                            wo1Var = (wo1) obj;
                        } else {
                            wo1Var = new wo1(this.mSwanApiContext);
                            this.mApis.put("-397373095", wo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(wo1Var, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "LocationService.startLocationUpdate")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = wo1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    wo1 wo1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof wo1)) {
                            wo1Var = (wo1) obj;
                        } else {
                            wo1Var = new wo1(this.mSwanApiContext);
                            this.mApis.put("-397373095", wo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(wo1Var, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "LocationService.stopLocationUpdate")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 B = wo1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    nq1 nq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof nq1)) {
                            nq1Var = (nq1) obj;
                        } else {
                            nq1Var = new nq1(this.mSwanApiContext);
                            this.mApis.put("538070032", nq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(nq1Var, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = nq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String callService(String str) {
                    zo1 zo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof zo1)) {
                            zo1Var = (zo1) obj;
                        } else {
                            zo1Var = new zo1(this.mSwanApiContext);
                            this.mApis.put("-1076509454", zo1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(zo1Var, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Network.callService")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = zo1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    gp1 gp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("968563034", gp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(gp1Var, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Network.cancelRequest")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 D = gp1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    fp1 fp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof fp1)) {
                            fp1Var = (fp1) obj;
                        } else {
                            fp1Var = new fp1(this.mSwanApiContext);
                            this.mApis.put("453220699", fp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(fp1Var, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Network.getNetworkType")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = fp1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    fp1 fp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof fp1)) {
                            fp1Var = (fp1) obj;
                        } else {
                            fp1Var = new fp1(this.mSwanApiContext);
                            this.mApis.put("453220699", fp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(fp1Var, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Network.networkStatusChange")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = fp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                @JavascriptInterface
                public String request(String str) {
                    InterceptResult invokeL2;
                    gp1 gp1Var;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && (invokeL2 = interceptable2.invokeL(1048580, this, str)) != null) {
                        return (String) invokeL2.objValue;
                    }
                    try {
                        qr1.c().a("request");
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("968563034", gp1Var);
                        }
                        Pair<Boolean, rr1> a2 = tr1.a(gp1Var, "swanAPI/request");
                        if (((Boolean) a2.first).booleanValue()) {
                            a = ((rr1) a2.second).a();
                        } else if (z12.a(this.mSwanApiContext.h(), "Network.request")) {
                            a = new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        } else {
                            Pair<rr1, JSONObject> u = vn1.u(str);
                            if (!((rr1) u.first).isSuccess()) {
                                a = ((rr1) u.first).a();
                            } else {
                                JSONObject jSONObject = (JSONObject) u.second;
                                if (jSONObject == null) {
                                    a = rr1.a.a();
                                } else {
                                    sr1 V = gp1Var.V(jSONObject);
                                    a = V == null ? "" : V.a();
                                }
                            }
                        }
                        return a;
                    } finally {
                    }
                }
            });
            hashMap.put("_naPayment", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    ps2 ps2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof ps2)) {
                            ps2Var = (ps2) obj;
                        } else {
                            ps2Var = new ps2(this.mSwanApiContext);
                            this.mApis.put("-336396851", ps2Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ps2Var, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Payment.chooseCoupon")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = ps2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    ps2 ps2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof ps2)) {
                            ps2Var = (ps2) obj;
                        } else {
                            ps2Var = new ps2(this.mSwanApiContext);
                            this.mApis.put("-336396851", ps2Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ps2Var, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Payment.getPaymentInfo")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = ps2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    fs2 fs2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof fs2)) {
                            fs2Var = (fs2) obj;
                        } else {
                            fs2Var = new fs2(this.mSwanApiContext);
                            this.mApis.put("1854689529", fs2Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(fs2Var, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Payment.requestThirdPayment")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = fs2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    ps2 ps2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof ps2)) {
                            ps2Var = (ps2) obj;
                        } else {
                            ps2Var = new ps2(this.mSwanApiContext);
                            this.mApis.put("-336396851", ps2Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ps2Var, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Payment.setPaymentInfo")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 z = ps2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    av2 av2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof av2)) {
                            av2Var = (av2) obj;
                        } else {
                            av2Var = new av2(this.mSwanApiContext);
                            this.mApis.put("-254510461", av2Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(av2Var, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Plugin.invokePluginChooseAddress")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = av2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    av2 av2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof av2)) {
                            av2Var = (av2) obj;
                        } else {
                            av2Var = new av2(this.mSwanApiContext);
                            this.mApis.put("-254510461", av2Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(av2Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 z = av2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    av2 av2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof av2)) {
                            av2Var = (av2) obj;
                        } else {
                            av2Var = new av2(this.mSwanApiContext);
                            this.mApis.put("-254510461", av2Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(av2Var, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Plugin.invokePluginPayment")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = av2Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    t32 t32Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof t32)) {
                            t32Var = (t32) obj;
                        } else {
                            t32Var = new t32(this.mSwanApiContext);
                            this.mApis.put("-2068479848", t32Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(t32Var, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Prefetch.prefetchResources")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = t32Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    l22 l22Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof l22)) {
                            l22Var = (l22) obj;
                        } else {
                            l22Var = new l22(this.mSwanApiContext);
                            this.mApis.put("423661539", l22Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(l22Var, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Preload.preloadStatus")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = l22Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    vb3 vb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof vb3)) {
                            vb3Var = (vb3) obj;
                        } else {
                            vb3Var = new vb3(this.mSwanApiContext);
                            this.mApis.put("-1929343869", vb3Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(vb3Var, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "PrivateFile.uploadFileToBos")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 C = vb3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    kp1 kp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof kp1)) {
                            kp1Var = (kp1) obj;
                        } else {
                            kp1Var = new kp1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", kp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(kp1Var, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Router.hideModalPage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = kp1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    kp1 kp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof kp1)) {
                            kp1Var = (kp1) obj;
                        } else {
                            kp1Var = new kp1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", kp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(kp1Var, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Router.navigateBack")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 B = kp1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    lp1 lp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof lp1)) {
                            lp1Var = (lp1) obj;
                        } else {
                            lp1Var = new lp1(this.mSwanApiContext);
                            this.mApis.put("1968522584", lp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(lp1Var, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Router.navigateTo")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 H = lp1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    np1 np1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof np1)) {
                            np1Var = (np1) obj;
                        } else {
                            np1Var = new np1(this.mSwanApiContext);
                            this.mApis.put("1317280190", np1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(np1Var, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Router.reLaunch")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = np1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    op1 op1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof op1)) {
                            op1Var = (op1) obj;
                        } else {
                            op1Var = new op1(this.mSwanApiContext);
                            this.mApis.put("-420075743", op1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(op1Var, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Router.reLoadErrorPage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = op1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    mp1 mp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof mp1)) {
                            mp1Var = (mp1) obj;
                        } else {
                            mp1Var = new mp1(this.mSwanApiContext);
                            this.mApis.put("1792515533", mp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(mp1Var, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Router.redirectTo")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 D = mp1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    lp1 lp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof lp1)) {
                            lp1Var = (lp1) obj;
                        } else {
                            lp1Var = new lp1(this.mSwanApiContext);
                            this.mApis.put("1968522584", lp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(lp1Var, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Router.showModalPage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 J = lp1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    rp1 rp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof rp1)) {
                            rp1Var = (rp1) obj;
                        } else {
                            rp1Var = new rp1(this.mSwanApiContext);
                            this.mApis.put("-594895721", rp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(rp1Var, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Setting.getAppInfoSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 F = rp1Var.F();
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    rp1 rp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof rp1)) {
                            rp1Var = (rp1) obj;
                        } else {
                            rp1Var = new rp1(this.mSwanApiContext);
                            this.mApis.put("-594895721", rp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(rp1Var, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Setting.getSetting")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 G = rp1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    rp1 rp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof rp1)) {
                            rp1Var = (rp1) obj;
                        } else {
                            rp1Var = new rp1(this.mSwanApiContext);
                            this.mApis.put("-594895721", rp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(rp1Var, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Setting.getSlaveIdSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 H = rp1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    rp1 rp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof rp1)) {
                            rp1Var = (rp1) obj;
                        } else {
                            rp1Var = new rp1(this.mSwanApiContext);
                            this.mApis.put("-594895721", rp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(rp1Var, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Setting.getSwanId")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 I = rp1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    rp1 rp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof rp1)) {
                            rp1Var = (rp1) obj;
                        } else {
                            rp1Var = new rp1(this.mSwanApiContext);
                            this.mApis.put("-594895721", rp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(rp1Var, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Setting.getUserInfo")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 J = rp1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    qp1 qp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof qp1)) {
                            qp1Var = (qp1) obj;
                        } else {
                            qp1Var = new qp1(this.mSwanApiContext);
                            this.mApis.put("450273045", qp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(qp1Var, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Setting.isAllowedAdOpenAppSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = qp1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    p63 p63Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof p63)) {
                            p63Var = (p63) obj;
                        } else {
                            p63Var = new p63(this.mSwanApiContext);
                            this.mApis.put("712777136", p63Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(p63Var, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = p63Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    up1 up1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-804054859", up1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(up1Var, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.clearGlobalStorage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = up1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    up1 up1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-804054859", up1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(up1Var, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.clearGlobalStorageSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 C = up1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    tp1 tp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("130910081", tp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(tp1Var, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.clearStorage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = tp1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    tp1 tp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("130910081", tp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(tp1Var, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.clearStorageSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 C = tp1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    up1 up1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-804054859", up1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(up1Var, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.getGlobalStorage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 D = up1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    up1 up1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-804054859", up1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(up1Var, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.getGlobalStorageInfo")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 G = up1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    up1 up1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-804054859", up1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(up1Var, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.getGlobalStorageInfoSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 J = up1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    up1 up1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-804054859", up1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(up1Var, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.getGlobalStorageSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 K = up1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    tp1 tp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("130910081", tp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(tp1Var, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.getStorage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 D = tp1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    tp1 tp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("130910081", tp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(tp1Var, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.getStorageInfo")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 G = tp1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    tp1 tp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("130910081", tp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(tp1Var, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.getStorageInfoAsync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 H = tp1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    tp1 tp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("130910081", tp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(tp1Var, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.getStorageInfoSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 J = tp1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    tp1 tp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("130910081", tp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(tp1Var, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.getStorageSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 K = tp1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    up1 up1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-804054859", up1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(up1Var, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.removeGlobalStorage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 R = up1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    up1 up1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-804054859", up1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(up1Var, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.removeGlobalStorageSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 T = up1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    tp1 tp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("130910081", tp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(tp1Var, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.removeStorage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 R = tp1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    tp1 tp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("130910081", tp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(tp1Var, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.removeStorageSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 T = tp1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    up1 up1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-804054859", up1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(up1Var, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.setGlobalStorage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 U = up1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    up1 up1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-804054859", up1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(up1Var, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.setGlobalStorageSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 W = up1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    tp1 tp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("130910081", tp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(tp1Var, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.setStorage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 U = tp1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    tp1 tp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("130910081", tp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(tp1Var, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Storage.setStorageSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 W = tp1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    wp1 wp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof wp1)) {
                            wp1Var = (wp1) obj;
                        } else {
                            wp1Var = new wp1(this.mSwanApiContext);
                            this.mApis.put("823117982", wp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(wp1Var, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Subscription.requestSubscribeFormId")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 E = wp1Var.E(str);
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    xp1 xp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof xp1)) {
                            xp1Var = (xp1) obj;
                        } else {
                            xp1Var = new xp1(this.mSwanApiContext);
                            this.mApis.put("-947445811", xp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(xp1Var, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Subscription.subscribeService")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 F = xp1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    eq1 eq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof eq1)) {
                            eq1Var = (eq1) obj;
                        } else {
                            eq1Var = new eq1(this.mSwanApiContext);
                            this.mApis.put("1936205521", eq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(eq1Var, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.exitFullScreen")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = eq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    aq1 aq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof aq1)) {
                            aq1Var = (aq1) obj;
                        } else {
                            aq1Var = new aq1(this.mSwanApiContext);
                            this.mApis.put("99997465", aq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(aq1Var, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.getBrightness")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = aq1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    bq1 bq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof bq1)) {
                            bq1Var = (bq1) obj;
                        } else {
                            bq1Var = new bq1(this.mSwanApiContext);
                            this.mApis.put("-518757484", bq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(bq1Var, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.getClipboardData")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = bq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    dq1 dq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof dq1)) {
                            dq1Var = (dq1) obj;
                        } else {
                            dq1Var = new dq1(this.mSwanApiContext);
                            this.mApis.put("1694151270", dq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(dq1Var, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.getDeviceInfo")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = dq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    fq1 fq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof fq1)) {
                            fq1Var = (fq1) obj;
                        } else {
                            fq1Var = new fq1(this.mSwanApiContext);
                            this.mApis.put("-1321681619", fq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(fq1Var, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.getDeviceProfile")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = fq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    lq1 lq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof lq1)) {
                            lq1Var = (lq1) obj;
                        } else {
                            lq1Var = new lq1(this.mSwanApiContext);
                            this.mApis.put("447234992", lq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(lq1Var, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.getMediaVolume")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = lq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    gq1 gq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof gq1)) {
                            gq1Var = (gq1) obj;
                        } else {
                            gq1Var = new gq1(this.mSwanApiContext);
                            this.mApis.put("-1569246082", gq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(gq1Var, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.makePhoneCall")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = gq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    iq1 iq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof iq1)) {
                            iq1Var = (iq1) obj;
                        } else {
                            iq1Var = new iq1(this.mSwanApiContext);
                            this.mApis.put("1099851202", iq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(iq1Var, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.openSMSPanel")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = iq1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    hq1 hq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof hq1)) {
                            hq1Var = (hq1) obj;
                        } else {
                            hq1Var = new hq1(this.mSwanApiContext);
                            this.mApis.put("-1707203360", hq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(hq1Var, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.requestFullScreen")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 F = hq1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    bq1 bq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof bq1)) {
                            bq1Var = (bq1) obj;
                        } else {
                            bq1Var = new bq1(this.mSwanApiContext);
                            this.mApis.put("-518757484", bq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(bq1Var, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.setClipboardData")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = bq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    lp2 lp2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof lp2)) {
                            lp2Var = (lp2) obj;
                        } else {
                            lp2Var = new lp2(this.mSwanApiContext);
                            this.mApis.put("1161486049", lp2Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(lp2Var, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.setErrorPageType")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = lp2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    lq1 lq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof lq1)) {
                            lq1Var = (lq1) obj;
                        } else {
                            lq1Var = new lq1(this.mSwanApiContext);
                            this.mApis.put("447234992", lq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(lq1Var, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.setMediaVolume")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 z = lq1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    zp1 zp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof zp1)) {
                            zp1Var = (zp1) obj;
                        } else {
                            zp1Var = new zp1(this.mSwanApiContext);
                            this.mApis.put("1372680763", zp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(zp1Var, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.startAccelerometer")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = zp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    cq1 cq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof cq1)) {
                            cq1Var = (cq1) obj;
                        } else {
                            cq1Var = new cq1(this.mSwanApiContext);
                            this.mApis.put("1689255576", cq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(cq1Var, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.startCompass")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = cq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    zp1 zp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof zp1)) {
                            zp1Var = (zp1) obj;
                        } else {
                            zp1Var = new zp1(this.mSwanApiContext);
                            this.mApis.put("1372680763", zp1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(zp1Var, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.stopAccelerometer")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 B = zp1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    cq1 cq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof cq1)) {
                            cq1Var = (cq1) obj;
                        } else {
                            cq1Var = new cq1(this.mSwanApiContext);
                            this.mApis.put("1689255576", cq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(cq1Var, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "System.stopCompass")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 z = cq1Var.z();
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    wq1 wq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof wq1)) {
                            wq1Var = (wq1) obj;
                        } else {
                            wq1Var = new wq1(this.mSwanApiContext);
                            this.mApis.put("201194468", wq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(wq1Var, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.addToDesktop")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 B = wq1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    sq1 sq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof sq1)) {
                            sq1Var = (sq1) obj;
                        } else {
                            sq1Var = new sq1(this.mSwanApiContext);
                            this.mApis.put("-1412306947", sq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(sq1Var, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.calcMD5")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = sq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    tq1 tq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof tq1)) {
                            tq1Var = (tq1) obj;
                        } else {
                            tq1Var = new tq1(this.mSwanApiContext);
                            this.mApis.put("1626415364", tq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(tq1Var, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.checkAppInstalled")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = tq1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    vq1 vq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("-836768778", vq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(vq1Var, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.getCommonSysInfo")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = vq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    br1 br1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", br1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(br1Var, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.getCommonSysInfoSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 E = br1Var.E();
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    xq1 xq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof xq1)) {
                            xq1Var = (xq1) obj;
                        } else {
                            xq1Var = new xq1(this.mSwanApiContext);
                            this.mApis.put("-810858308", xq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(xq1Var, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.getPerformanceLevel")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = xq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    br1 br1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", br1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(br1Var, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.getSystemInfo")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 H = br1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", br1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(br1Var, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.getSystemInfoAsync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 I = br1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    br1 br1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", br1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(br1Var, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.getSystemInfoSync")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 J = br1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    yq1 yq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof yq1)) {
                            yq1Var = (yq1) obj;
                        } else {
                            yq1Var = new yq1(this.mSwanApiContext);
                            this.mApis.put("-2097727681", yq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(yq1Var, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.handleException")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = yq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    uq1 uq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof uq1)) {
                            uq1Var = (uq1) obj;
                        } else {
                            uq1Var = new uq1(this.mSwanApiContext);
                            this.mApis.put("2084449317", uq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(uq1Var, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.hasCloseHandler")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = uq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    x33 x33Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof x33)) {
                            x33Var = (x33) obj;
                        } else {
                            x33Var = new x33(this.mSwanApiContext);
                            this.mApis.put("1031678042", x33Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(x33Var, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.hideCaptureScreenShareDialog")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 x = x33Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    zq1 zq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof zq1)) {
                            zq1Var = (zq1) obj;
                        } else {
                            zq1Var = new zq1(this.mSwanApiContext);
                            this.mApis.put("1751900130", zq1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(zq1Var, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.logToFile")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = zq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    y23 y23Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof y23)) {
                            y23Var = (y23) obj;
                        } else {
                            y23Var = new y23(this.mSwanApiContext);
                            this.mApis.put("1748196865", y23Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(y23Var, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.preloadPackage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = y23Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    ar1 ar1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof ar1)) {
                            ar1Var = (ar1) obj;
                        } else {
                            ar1Var = new ar1(this.mSwanApiContext);
                            this.mApis.put("589529211", ar1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ar1Var, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.previewImage")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 B = ar1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    dr1 dr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof dr1)) {
                            dr1Var = (dr1) obj;
                        } else {
                            dr1Var = new dr1(this.mSwanApiContext);
                            this.mApis.put("-577481801", dr1Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(dr1Var, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Utils.ubcFlowJar")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 I = dr1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    ia3 ia3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ia3)) {
                            ia3Var = (ia3) obj;
                        } else {
                            ia3Var = new ia3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ia3Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ia3Var, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Wifi.connectWifi")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 A = ia3Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    ia3 ia3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ia3)) {
                            ia3Var = (ia3) obj;
                        } else {
                            ia3Var = new ia3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ia3Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ia3Var, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Wifi.getConnectedWifi")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 B = ia3Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    ia3 ia3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ia3)) {
                            ia3Var = (ia3) obj;
                        } else {
                            ia3Var = new ia3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ia3Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ia3Var, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Wifi.getWifiList")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 C = ia3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    ia3 ia3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ia3)) {
                            ia3Var = (ia3) obj;
                        } else {
                            ia3Var = new ia3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ia3Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ia3Var, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Wifi.startWifi")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 G = ia3Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    ia3 ia3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof ia3)) {
                            ia3Var = (ia3) obj;
                        } else {
                            ia3Var = new ia3(this.mSwanApiContext);
                            this.mApis.put("1879401452", ia3Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ia3Var, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "Wifi.stopWifi")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 H = ia3Var.H(str);
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
