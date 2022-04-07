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
import com.repackage.ah1;
import com.repackage.aq2;
import com.repackage.bp1;
import com.repackage.bq1;
import com.repackage.c32;
import com.repackage.cq1;
import com.repackage.cq2;
import com.repackage.cr1;
import com.repackage.dp1;
import com.repackage.dq1;
import com.repackage.ep1;
import com.repackage.eq1;
import com.repackage.er1;
import com.repackage.fp1;
import com.repackage.fq1;
import com.repackage.g73;
import com.repackage.gp1;
import com.repackage.gt2;
import com.repackage.hp1;
import com.repackage.hq1;
import com.repackage.hs1;
import com.repackage.ip1;
import com.repackage.iq1;
import com.repackage.is1;
import com.repackage.jp1;
import com.repackage.jr1;
import com.repackage.js1;
import com.repackage.k42;
import com.repackage.ko1;
import com.repackage.kp1;
import com.repackage.kq1;
import com.repackage.kr1;
import com.repackage.ks1;
import com.repackage.lp1;
import com.repackage.lq1;
import com.repackage.lr1;
import com.repackage.mc3;
import com.repackage.md2;
import com.repackage.mo1;
import com.repackage.mp1;
import com.repackage.mr1;
import com.repackage.no1;
import com.repackage.np1;
import com.repackage.nq1;
import com.repackage.nr1;
import com.repackage.o43;
import com.repackage.oq1;
import com.repackage.or1;
import com.repackage.p33;
import com.repackage.po1;
import com.repackage.pr1;
import com.repackage.q22;
import com.repackage.qo1;
import com.repackage.qp1;
import com.repackage.qq1;
import com.repackage.qr1;
import com.repackage.ro1;
import com.repackage.rq1;
import com.repackage.rr1;
import com.repackage.rv2;
import com.repackage.so1;
import com.repackage.sq1;
import com.repackage.sr1;
import com.repackage.to1;
import com.repackage.tq1;
import com.repackage.uq1;
import com.repackage.ur1;
import com.repackage.vo1;
import com.repackage.vq1;
import com.repackage.wp1;
import com.repackage.wq1;
import com.repackage.ws2;
import com.repackage.xo1;
import com.repackage.xp1;
import com.repackage.xq1;
import com.repackage.yo1;
import com.repackage.yq1;
import com.repackage.za3;
import com.repackage.zn1;
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

    public static Map<String, Object> getV8ApiModules(final ko1 ko1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ko1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    qo1 qo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof qo1)) {
                            qo1Var = (qo1) obj;
                        } else {
                            qo1Var = new qo1(this.mSwanApiContext);
                            this.mApis.put("1930258908", qo1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(qo1Var, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Account.checkSession")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = qo1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    ro1 ro1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ro1)) {
                            ro1Var = (ro1) obj;
                        } else {
                            ro1Var = new ro1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ro1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(ro1Var, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Account.getLoginCode")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 C = ro1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    so1 so1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof so1)) {
                            so1Var = (so1) obj;
                        } else {
                            so1Var = new so1(this.mSwanApiContext);
                            this.mApis.put("1754780133", so1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(so1Var, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Account.getOpenId")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = so1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    zn1 zn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof zn1)) {
                            zn1Var = (zn1) obj;
                        } else {
                            zn1Var = new zn1(this.mSwanApiContext);
                            this.mApis.put("-343998465", zn1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(zn1Var, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Account.getUnionBDUSS")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = zn1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    po1 po1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof po1)) {
                            po1Var = (po1) obj;
                        } else {
                            po1Var = new po1(this.mSwanApiContext);
                            this.mApis.put("-337742792", po1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(po1Var, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Account.isBaiduAccountSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = po1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    ro1 ro1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ro1)) {
                            ro1Var = (ro1) obj;
                        } else {
                            ro1Var = new ro1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ro1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(ro1Var, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Account.isLoginSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 H = ro1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    ro1 ro1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ro1)) {
                            ro1Var = (ro1) obj;
                        } else {
                            ro1Var = new ro1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ro1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(ro1Var, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Account.login")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 I = ro1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    to1 to1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof to1)) {
                            to1Var = (to1) obj;
                        } else {
                            to1Var = new to1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", to1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(to1Var, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Basic.loadSubPackage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 F = to1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    to1 to1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof to1)) {
                            to1Var = (to1) obj;
                        } else {
                            to1Var = new to1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", to1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(to1Var, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Basic.loadSubPackages")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 G = to1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    ah1 ah1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof ah1)) {
                            ah1Var = (ah1) obj;
                        } else {
                            ah1Var = new ah1(this.mSwanApiContext);
                            this.mApis.put("1460300387", ah1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(ah1Var, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Bookshelf.deleteBookshelf")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 K = ah1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    ah1 ah1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof ah1)) {
                            ah1Var = (ah1) obj;
                        } else {
                            ah1Var = new ah1(this.mSwanApiContext);
                            this.mApis.put("1460300387", ah1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(ah1Var, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Bookshelf.insertBookshelf")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 P = ah1Var.P(str);
                        return P == null ? "" : P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    ah1 ah1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof ah1)) {
                            ah1Var = (ah1) obj;
                        } else {
                            ah1Var = new ah1(this.mSwanApiContext);
                            this.mApis.put("1460300387", ah1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(ah1Var, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Bookshelf.navigateToBookshelf")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 U = ah1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    ah1 ah1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof ah1)) {
                            ah1Var = (ah1) obj;
                        } else {
                            ah1Var = new ah1(this.mSwanApiContext);
                            this.mApis.put("1460300387", ah1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(ah1Var, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Bookshelf.queryBookshelf")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 V = ah1Var.V(str);
                        return V == null ? "" : V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    ah1 ah1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof ah1)) {
                            ah1Var = (ah1) obj;
                        } else {
                            ah1Var = new ah1(this.mSwanApiContext);
                            this.mApis.put("1460300387", ah1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(ah1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Bookshelf.updateBookshelfReadTime")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 X = ah1Var.X(str);
                        return X == null ? "" : X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    no1 no1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof no1)) {
                            no1Var = (no1) obj;
                        } else {
                            no1Var = new no1(this.mSwanApiContext);
                            this.mApis.put("-277316359", no1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(no1Var, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Coupon.getPlatformCoupons")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = no1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    no1 no1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof no1)) {
                            no1Var = (no1) obj;
                        } else {
                            no1Var = new no1(this.mSwanApiContext);
                            this.mApis.put("-277316359", no1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(no1Var, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Coupon.getUserCoupons")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 z = no1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    no1 no1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof no1)) {
                            no1Var = (no1) obj;
                        } else {
                            no1Var = new no1(this.mSwanApiContext);
                            this.mApis.put("-277316359", no1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(no1Var, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Coupon.takeCoupons")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 C = no1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    vo1 vo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof vo1)) {
                            vo1Var = (vo1) obj;
                        } else {
                            vo1Var = new vo1(this.mSwanApiContext);
                            this.mApis.put("-1225406515", vo1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(vo1Var, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Favorite.getFavorStatus")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = vo1Var.x(str);
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
                        Pair<Boolean, is1> a = ks1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Favorite.showFavoriteGuide")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 G = showFavoriteGuideApi.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    xo1 xo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof xo1)) {
                            xo1Var = (xo1) obj;
                        } else {
                            xo1Var = new xo1(this.mSwanApiContext);
                            this.mApis.put("-2057135077", xo1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(xo1Var, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "File.shareFile")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = xo1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    md2 md2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof md2)) {
                            md2Var = (md2) obj;
                        } else {
                            md2Var = new md2(this.mSwanApiContext);
                            this.mApis.put("2077414795", md2Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(md2Var, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "GameCenter.postGameCenterMessage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = md2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    md2 md2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof md2)) {
                            md2Var = (md2) obj;
                        } else {
                            md2Var = new md2(this.mSwanApiContext);
                            this.mApis.put("2077414795", md2Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(md2Var, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "GameCenter.postGameCenterMessageSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = md2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String download(String str) {
                    yo1 yo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof yo1)) {
                            yo1Var = (yo1) obj;
                        } else {
                            yo1Var = new yo1(this.mSwanApiContext);
                            this.mApis.put("-170124576", yo1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(yo1Var, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "HostDownloadManager.download")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = yo1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    yo1 yo1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof yo1)) {
                            yo1Var = (yo1) obj;
                        } else {
                            yo1Var = new yo1(this.mSwanApiContext);
                            this.mApis.put("-170124576", yo1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(yo1Var, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "HostDownloadManager.openDownloadCenter")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = yo1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    yo1 yo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof yo1)) {
                            yo1Var = (yo1) obj;
                        } else {
                            yo1Var = new yo1(this.mSwanApiContext);
                            this.mApis.put("-170124576", yo1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(yo1Var, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "HostDownloadManager.openFile")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 z = yo1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    yo1 yo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof yo1)) {
                            yo1Var = (yo1) obj;
                        } else {
                            yo1Var = new yo1(this.mSwanApiContext);
                            this.mApis.put("-170124576", yo1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(yo1Var, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "HostDownloadManager.query")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 query = yo1Var.query(str);
                        return query == null ? "" : query.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naImage", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    aq2 aq2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof aq2)) {
                            aq2Var = (aq2) obj;
                        } else {
                            aq2Var = new aq2(this.mSwanApiContext);
                            this.mApis.put("1445003743", aq2Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(aq2Var, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Image.callImageMenu")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = aq2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    bp1 bp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof bp1)) {
                            bp1Var = (bp1) obj;
                        } else {
                            bp1Var = new bp1(this.mSwanApiContext);
                            this.mApis.put("-1252730367", bp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(bp1Var, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Image.compressImage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = bp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", jp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(jp1Var, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.closeTabBar")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = jp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", jp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(jp1Var, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.closeTabBarRedDot")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = jp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    dp1 dp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof dp1)) {
                            dp1Var = (dp1) obj;
                        } else {
                            dp1Var = new dp1(this.mSwanApiContext);
                            this.mApis.put("5236036", dp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(dp1Var, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.hideLoading")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = dp1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    fp1 fp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof fp1)) {
                            fp1Var = (fp1) obj;
                        } else {
                            fp1Var = new fp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", fp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(fp1Var, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.hideNavigationBarLoading")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = fp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    kp1 kp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof kp1)) {
                            kp1Var = (kp1) obj;
                        } else {
                            kp1Var = new kp1(this.mSwanApiContext);
                            this.mApis.put("1159492510", kp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(kp1Var, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.hideToast")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 K = kp1Var.K();
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    hp1 hp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof hp1)) {
                            hp1Var = (hp1) obj;
                        } else {
                            hp1Var = new hp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", hp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(hp1Var, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.openMultiPicker")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 G = hp1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    hp1 hp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof hp1)) {
                            hp1Var = (hp1) obj;
                        } else {
                            hp1Var = new hp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", hp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(hp1Var, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.openPicker")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 H = hp1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", jp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(jp1Var, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.openTabBar")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 C = jp1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    gp1 gp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("-1750613704", gp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(gp1Var, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.pageScrollTo")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = gp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    fp1 fp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof fp1)) {
                            fp1Var = (fp1) obj;
                        } else {
                            fp1Var = new fp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", fp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(fp1Var, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.setNavigationBarColor")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 z = fp1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    fp1 fp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof fp1)) {
                            fp1Var = (fp1) obj;
                        } else {
                            fp1Var = new fp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", fp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(fp1Var, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.setNavigationBarTitle")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = fp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", jp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(jp1Var, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.setTabBarItem")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 D = jp1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    hp1 hp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof hp1)) {
                            hp1Var = (hp1) obj;
                        } else {
                            hp1Var = new hp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", hp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(hp1Var, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.showDatePickerView")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 L = hp1Var.L(str);
                        return L == null ? "" : L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    lp1 lp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof lp1)) {
                            lp1Var = (lp1) obj;
                        } else {
                            lp1Var = new lp1(this.mSwanApiContext);
                            this.mApis.put("1172469410", lp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(lp1Var, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.showHalfScreenWebview")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 K = lp1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    dp1 dp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof dp1)) {
                            dp1Var = (dp1) obj;
                        } else {
                            dp1Var = new dp1(this.mSwanApiContext);
                            this.mApis.put("5236036", dp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(dp1Var, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.showLoading")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = dp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    ep1 ep1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof ep1)) {
                            ep1Var = (ep1) obj;
                        } else {
                            ep1Var = new ep1(this.mSwanApiContext);
                            this.mApis.put("1913747800", ep1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(ep1Var, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.showModal")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = ep1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    fp1 fp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof fp1)) {
                            fp1Var = (fp1) obj;
                        } else {
                            fp1Var = new fp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", fp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(fp1Var, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.showNavigationBarLoading")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 B = fp1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    kp1 kp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof kp1)) {
                            kp1Var = (kp1) obj;
                        } else {
                            kp1Var = new kp1(this.mSwanApiContext);
                            this.mApis.put("1159492510", kp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(kp1Var, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.showToast")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 Q = kp1Var.Q(str);
                        return Q == null ? "" : Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("1165118609", ip1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(ip1Var, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.stopPullDownRefresh")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = ip1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    hp1 hp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof hp1)) {
                            hp1Var = (hp1) obj;
                        } else {
                            hp1Var = new hp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", hp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(hp1Var, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.updateMultiPicker")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 M = hp1Var.M(str);
                        return M == null ? "" : M.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    mp1 mp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof mp1)) {
                            mp1Var = (mp1) obj;
                        } else {
                            mp1Var = new mp1(this.mSwanApiContext);
                            this.mApis.put("-137346255", mp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(mp1Var, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Keyboard.startKeyboardHeightChange")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 C = mp1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    mp1 mp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof mp1)) {
                            mp1Var = (mp1) obj;
                        } else {
                            mp1Var = new mp1(this.mSwanApiContext);
                            this.mApis.put("-137346255", mp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(mp1Var, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Keyboard.stopKeyboardHeightChange")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 D = mp1Var.D();
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    np1 np1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof np1)) {
                            np1Var = (np1) obj;
                        } else {
                            np1Var = new np1(this.mSwanApiContext);
                            this.mApis.put("-397373095", np1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(np1Var, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "LocationService.getLocation")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = np1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    np1 np1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof np1)) {
                            np1Var = (np1) obj;
                        } else {
                            np1Var = new np1(this.mSwanApiContext);
                            this.mApis.put("-397373095", np1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(np1Var, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "LocationService.startLocationUpdate")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = np1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    np1 np1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof np1)) {
                            np1Var = (np1) obj;
                        } else {
                            np1Var = new np1(this.mSwanApiContext);
                            this.mApis.put("-397373095", np1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(np1Var, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "LocationService.stopLocationUpdate")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 B = np1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    er1 er1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof er1)) {
                            er1Var = (er1) obj;
                        } else {
                            er1Var = new er1(this.mSwanApiContext);
                            this.mApis.put("538070032", er1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(er1Var, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = er1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String callService(String str) {
                    qp1 qp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof qp1)) {
                            qp1Var = (qp1) obj;
                        } else {
                            qp1Var = new qp1(this.mSwanApiContext);
                            this.mApis.put("-1076509454", qp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(qp1Var, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Network.callService")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = qp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    xp1 xp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof xp1)) {
                            xp1Var = (xp1) obj;
                        } else {
                            xp1Var = new xp1(this.mSwanApiContext);
                            this.mApis.put("968563034", xp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(xp1Var, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Network.cancelRequest")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 D = xp1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    wp1 wp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof wp1)) {
                            wp1Var = (wp1) obj;
                        } else {
                            wp1Var = new wp1(this.mSwanApiContext);
                            this.mApis.put("453220699", wp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(wp1Var, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Network.getNetworkType")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = wp1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    wp1 wp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof wp1)) {
                            wp1Var = (wp1) obj;
                        } else {
                            wp1Var = new wp1(this.mSwanApiContext);
                            this.mApis.put("453220699", wp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(wp1Var, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Network.networkStatusChange")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = wp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                @JavascriptInterface
                public String request(JsObject jsObject) {
                    InterceptResult invokeL2;
                    xp1 xp1Var;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && (invokeL2 = interceptable2.invokeL(1048580, this, jsObject)) != null) {
                        return (String) invokeL2.objValue;
                    }
                    try {
                        hs1.c().a("request");
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof xp1)) {
                            xp1Var = (xp1) obj;
                        } else {
                            xp1Var = new xp1(this.mSwanApiContext);
                            this.mApis.put("968563034", xp1Var);
                        }
                        Pair<Boolean, is1> a2 = ks1.a(xp1Var, "swanAPI/request");
                        if (((Boolean) a2.first).booleanValue()) {
                            a = ((is1) a2.second).a();
                        } else if (q22.a(this.mSwanApiContext.h(), "Network.request")) {
                            a = new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        } else {
                            Pair<is1, JSONObject> t = mo1.t(jsObject);
                            if (!((is1) t.first).isSuccess()) {
                                a = ((is1) t.first).a();
                            } else {
                                JSONObject jSONObject = (JSONObject) t.second;
                                if (jSONObject == null) {
                                    a = is1.a.a();
                                } else {
                                    js1 V = xp1Var.V(jSONObject);
                                    a = V == null ? "" : V.a();
                                }
                            }
                        }
                        return a;
                    } finally {
                    }
                }
            });
            hashMap.put("_naPayment", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    gt2 gt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof gt2)) {
                            gt2Var = (gt2) obj;
                        } else {
                            gt2Var = new gt2(this.mSwanApiContext);
                            this.mApis.put("-336396851", gt2Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(gt2Var, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Payment.chooseCoupon")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = gt2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    gt2 gt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof gt2)) {
                            gt2Var = (gt2) obj;
                        } else {
                            gt2Var = new gt2(this.mSwanApiContext);
                            this.mApis.put("-336396851", gt2Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(gt2Var, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Payment.getPaymentInfo")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = gt2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    ws2 ws2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof ws2)) {
                            ws2Var = (ws2) obj;
                        } else {
                            ws2Var = new ws2(this.mSwanApiContext);
                            this.mApis.put("1854689529", ws2Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(ws2Var, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Payment.requestThirdPayment")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = ws2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    gt2 gt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof gt2)) {
                            gt2Var = (gt2) obj;
                        } else {
                            gt2Var = new gt2(this.mSwanApiContext);
                            this.mApis.put("-336396851", gt2Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(gt2Var, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Payment.setPaymentInfo")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 z = gt2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    rv2 rv2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof rv2)) {
                            rv2Var = (rv2) obj;
                        } else {
                            rv2Var = new rv2(this.mSwanApiContext);
                            this.mApis.put("-254510461", rv2Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(rv2Var, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Plugin.invokePluginChooseAddress")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = rv2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    rv2 rv2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof rv2)) {
                            rv2Var = (rv2) obj;
                        } else {
                            rv2Var = new rv2(this.mSwanApiContext);
                            this.mApis.put("-254510461", rv2Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(rv2Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 z = rv2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    rv2 rv2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof rv2)) {
                            rv2Var = (rv2) obj;
                        } else {
                            rv2Var = new rv2(this.mSwanApiContext);
                            this.mApis.put("-254510461", rv2Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(rv2Var, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Plugin.invokePluginPayment")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = rv2Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    k42 k42Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof k42)) {
                            k42Var = (k42) obj;
                        } else {
                            k42Var = new k42(this.mSwanApiContext);
                            this.mApis.put("-2068479848", k42Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(k42Var, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Prefetch.prefetchResources")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = k42Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    c32 c32Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof c32)) {
                            c32Var = (c32) obj;
                        } else {
                            c32Var = new c32(this.mSwanApiContext);
                            this.mApis.put("423661539", c32Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(c32Var, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Preload.preloadStatus")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = c32Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    mc3 mc3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof mc3)) {
                            mc3Var = (mc3) obj;
                        } else {
                            mc3Var = new mc3(this.mSwanApiContext);
                            this.mApis.put("-1929343869", mc3Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(mc3Var, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "PrivateFile.uploadFileToBos")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 C = mc3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    bq1 bq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof bq1)) {
                            bq1Var = (bq1) obj;
                        } else {
                            bq1Var = new bq1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", bq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(bq1Var, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Router.hideModalPage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = bq1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    bq1 bq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof bq1)) {
                            bq1Var = (bq1) obj;
                        } else {
                            bq1Var = new bq1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", bq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(bq1Var, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Router.navigateBack")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 B = bq1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    cq1 cq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof cq1)) {
                            cq1Var = (cq1) obj;
                        } else {
                            cq1Var = new cq1(this.mSwanApiContext);
                            this.mApis.put("1968522584", cq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(cq1Var, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Router.navigateTo")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 H = cq1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    eq1 eq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof eq1)) {
                            eq1Var = (eq1) obj;
                        } else {
                            eq1Var = new eq1(this.mSwanApiContext);
                            this.mApis.put("1317280190", eq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(eq1Var, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Router.reLaunch")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = eq1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    fq1 fq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof fq1)) {
                            fq1Var = (fq1) obj;
                        } else {
                            fq1Var = new fq1(this.mSwanApiContext);
                            this.mApis.put("-420075743", fq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(fq1Var, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Router.reLoadErrorPage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = fq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    dq1 dq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof dq1)) {
                            dq1Var = (dq1) obj;
                        } else {
                            dq1Var = new dq1(this.mSwanApiContext);
                            this.mApis.put("1792515533", dq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(dq1Var, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Router.redirectTo")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 D = dq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    cq1 cq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof cq1)) {
                            cq1Var = (cq1) obj;
                        } else {
                            cq1Var = new cq1(this.mSwanApiContext);
                            this.mApis.put("1968522584", cq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(cq1Var, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Router.showModalPage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 J = cq1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    iq1 iq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof iq1)) {
                            iq1Var = (iq1) obj;
                        } else {
                            iq1Var = new iq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", iq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(iq1Var, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Setting.getAppInfoSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 F = iq1Var.F();
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    iq1 iq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof iq1)) {
                            iq1Var = (iq1) obj;
                        } else {
                            iq1Var = new iq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", iq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(iq1Var, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Setting.getSetting")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 G = iq1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    iq1 iq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof iq1)) {
                            iq1Var = (iq1) obj;
                        } else {
                            iq1Var = new iq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", iq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(iq1Var, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Setting.getSlaveIdSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 H = iq1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    iq1 iq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof iq1)) {
                            iq1Var = (iq1) obj;
                        } else {
                            iq1Var = new iq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", iq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(iq1Var, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Setting.getSwanId")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 I = iq1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    iq1 iq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof iq1)) {
                            iq1Var = (iq1) obj;
                        } else {
                            iq1Var = new iq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", iq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(iq1Var, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Setting.getUserInfo")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 J = iq1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    hq1 hq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof hq1)) {
                            hq1Var = (hq1) obj;
                        } else {
                            hq1Var = new hq1(this.mSwanApiContext);
                            this.mApis.put("450273045", hq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(hq1Var, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Setting.isAllowedAdOpenAppSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = hq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    g73 g73Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof g73)) {
                            g73Var = (g73) obj;
                        } else {
                            g73Var = new g73(this.mSwanApiContext);
                            this.mApis.put("712777136", g73Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(g73Var, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = g73Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    lq1 lq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lq1)) {
                            lq1Var = (lq1) obj;
                        } else {
                            lq1Var = new lq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(lq1Var, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.clearGlobalStorage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = lq1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    lq1 lq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lq1)) {
                            lq1Var = (lq1) obj;
                        } else {
                            lq1Var = new lq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(lq1Var, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.clearGlobalStorageSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 C = lq1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    kq1 kq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("130910081", kq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(kq1Var, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.clearStorage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = kq1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    kq1 kq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("130910081", kq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(kq1Var, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.clearStorageSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 C = kq1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    lq1 lq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lq1)) {
                            lq1Var = (lq1) obj;
                        } else {
                            lq1Var = new lq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(lq1Var, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.getGlobalStorage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 D = lq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    lq1 lq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lq1)) {
                            lq1Var = (lq1) obj;
                        } else {
                            lq1Var = new lq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(lq1Var, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.getGlobalStorageInfo")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 G = lq1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    lq1 lq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lq1)) {
                            lq1Var = (lq1) obj;
                        } else {
                            lq1Var = new lq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(lq1Var, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.getGlobalStorageInfoSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 J = lq1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    lq1 lq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lq1)) {
                            lq1Var = (lq1) obj;
                        } else {
                            lq1Var = new lq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(lq1Var, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.getGlobalStorageSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 K = lq1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    kq1 kq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("130910081", kq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(kq1Var, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.getStorage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 D = kq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    kq1 kq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("130910081", kq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(kq1Var, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.getStorageInfo")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 G = kq1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    kq1 kq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("130910081", kq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(kq1Var, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.getStorageInfoAsync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 H = kq1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    kq1 kq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("130910081", kq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(kq1Var, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.getStorageInfoSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 J = kq1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    kq1 kq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("130910081", kq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(kq1Var, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.getStorageSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 K = kq1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    lq1 lq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lq1)) {
                            lq1Var = (lq1) obj;
                        } else {
                            lq1Var = new lq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(lq1Var, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.removeGlobalStorage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 R = lq1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    lq1 lq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lq1)) {
                            lq1Var = (lq1) obj;
                        } else {
                            lq1Var = new lq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(lq1Var, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.removeGlobalStorageSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 T = lq1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    kq1 kq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("130910081", kq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(kq1Var, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.removeStorage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 R = kq1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    kq1 kq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("130910081", kq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(kq1Var, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.removeStorageSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 T = kq1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    lq1 lq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lq1)) {
                            lq1Var = (lq1) obj;
                        } else {
                            lq1Var = new lq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(lq1Var, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.setGlobalStorage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 U = lq1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    lq1 lq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lq1)) {
                            lq1Var = (lq1) obj;
                        } else {
                            lq1Var = new lq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(lq1Var, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.setGlobalStorageSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 W = lq1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    kq1 kq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("130910081", kq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(kq1Var, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.setStorage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 U = kq1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    kq1 kq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("130910081", kq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(kq1Var, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.setStorageSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 W = kq1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    nq1 nq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof nq1)) {
                            nq1Var = (nq1) obj;
                        } else {
                            nq1Var = new nq1(this.mSwanApiContext);
                            this.mApis.put("823117982", nq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(nq1Var, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Subscription.requestSubscribeFormId")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 E = nq1Var.E(str);
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    oq1 oq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof oq1)) {
                            oq1Var = (oq1) obj;
                        } else {
                            oq1Var = new oq1(this.mSwanApiContext);
                            this.mApis.put("-947445811", oq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(oq1Var, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Subscription.subscribeService")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 F = oq1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    vq1 vq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("1936205521", vq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(vq1Var, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.exitFullScreen")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = vq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    rq1 rq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof rq1)) {
                            rq1Var = (rq1) obj;
                        } else {
                            rq1Var = new rq1(this.mSwanApiContext);
                            this.mApis.put("99997465", rq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(rq1Var, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.getBrightness")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = rq1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    sq1 sq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof sq1)) {
                            sq1Var = (sq1) obj;
                        } else {
                            sq1Var = new sq1(this.mSwanApiContext);
                            this.mApis.put("-518757484", sq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(sq1Var, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.getClipboardData")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = sq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    uq1 uq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof uq1)) {
                            uq1Var = (uq1) obj;
                        } else {
                            uq1Var = new uq1(this.mSwanApiContext);
                            this.mApis.put("1694151270", uq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(uq1Var, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.getDeviceInfo")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = uq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    wq1 wq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof wq1)) {
                            wq1Var = (wq1) obj;
                        } else {
                            wq1Var = new wq1(this.mSwanApiContext);
                            this.mApis.put("-1321681619", wq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(wq1Var, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.getDeviceProfile")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = wq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    cr1 cr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("447234992", cr1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(cr1Var, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.getMediaVolume")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = cr1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    xq1 xq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof xq1)) {
                            xq1Var = (xq1) obj;
                        } else {
                            xq1Var = new xq1(this.mSwanApiContext);
                            this.mApis.put("-1569246082", xq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(xq1Var, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.makePhoneCall")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = xq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    zq1 zq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof zq1)) {
                            zq1Var = (zq1) obj;
                        } else {
                            zq1Var = new zq1(this.mSwanApiContext);
                            this.mApis.put("1099851202", zq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(zq1Var, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.openSMSPanel")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = zq1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    yq1 yq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof yq1)) {
                            yq1Var = (yq1) obj;
                        } else {
                            yq1Var = new yq1(this.mSwanApiContext);
                            this.mApis.put("-1707203360", yq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(yq1Var, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.requestFullScreen")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 F = yq1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    sq1 sq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof sq1)) {
                            sq1Var = (sq1) obj;
                        } else {
                            sq1Var = new sq1(this.mSwanApiContext);
                            this.mApis.put("-518757484", sq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(sq1Var, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.setClipboardData")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = sq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    cq2 cq2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof cq2)) {
                            cq2Var = (cq2) obj;
                        } else {
                            cq2Var = new cq2(this.mSwanApiContext);
                            this.mApis.put("1161486049", cq2Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(cq2Var, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.setErrorPageType")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = cq2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    cr1 cr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("447234992", cr1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(cr1Var, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.setMediaVolume")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 z = cr1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    qq1 qq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof qq1)) {
                            qq1Var = (qq1) obj;
                        } else {
                            qq1Var = new qq1(this.mSwanApiContext);
                            this.mApis.put("1372680763", qq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(qq1Var, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.startAccelerometer")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = qq1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    tq1 tq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof tq1)) {
                            tq1Var = (tq1) obj;
                        } else {
                            tq1Var = new tq1(this.mSwanApiContext);
                            this.mApis.put("1689255576", tq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(tq1Var, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.startCompass")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = tq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    qq1 qq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof qq1)) {
                            qq1Var = (qq1) obj;
                        } else {
                            qq1Var = new qq1(this.mSwanApiContext);
                            this.mApis.put("1372680763", qq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(qq1Var, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.stopAccelerometer")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 B = qq1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    tq1 tq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof tq1)) {
                            tq1Var = (tq1) obj;
                        } else {
                            tq1Var = new tq1(this.mSwanApiContext);
                            this.mApis.put("1689255576", tq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(tq1Var, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.stopCompass")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 z = tq1Var.z();
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    nr1 nr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof nr1)) {
                            nr1Var = (nr1) obj;
                        } else {
                            nr1Var = new nr1(this.mSwanApiContext);
                            this.mApis.put("201194468", nr1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(nr1Var, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.addToDesktop")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 B = nr1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    jr1 jr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof jr1)) {
                            jr1Var = (jr1) obj;
                        } else {
                            jr1Var = new jr1(this.mSwanApiContext);
                            this.mApis.put("-1412306947", jr1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(jr1Var, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.calcMD5")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = jr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    kr1 kr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof kr1)) {
                            kr1Var = (kr1) obj;
                        } else {
                            kr1Var = new kr1(this.mSwanApiContext);
                            this.mApis.put("1626415364", kr1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(kr1Var, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.checkAppInstalled")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = kr1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    mr1 mr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof mr1)) {
                            mr1Var = (mr1) obj;
                        } else {
                            mr1Var = new mr1(this.mSwanApiContext);
                            this.mApis.put("-836768778", mr1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(mr1Var, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.getCommonSysInfo")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = mr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    sr1 sr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof sr1)) {
                            sr1Var = (sr1) obj;
                        } else {
                            sr1Var = new sr1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", sr1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(sr1Var, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.getCommonSysInfoSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 E = sr1Var.E();
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    or1 or1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof or1)) {
                            or1Var = (or1) obj;
                        } else {
                            or1Var = new or1(this.mSwanApiContext);
                            this.mApis.put("-810858308", or1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(or1Var, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.getPerformanceLevel")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = or1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    sr1 sr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof sr1)) {
                            sr1Var = (sr1) obj;
                        } else {
                            sr1Var = new sr1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", sr1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(sr1Var, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.getSystemInfo")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 H = sr1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    sr1 sr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof sr1)) {
                            sr1Var = (sr1) obj;
                        } else {
                            sr1Var = new sr1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", sr1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(sr1Var, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.getSystemInfoAsync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 I = sr1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    sr1 sr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof sr1)) {
                            sr1Var = (sr1) obj;
                        } else {
                            sr1Var = new sr1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", sr1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(sr1Var, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.getSystemInfoSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 J = sr1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    pr1 pr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof pr1)) {
                            pr1Var = (pr1) obj;
                        } else {
                            pr1Var = new pr1(this.mSwanApiContext);
                            this.mApis.put("-2097727681", pr1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(pr1Var, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.handleException")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = pr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    lr1 lr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof lr1)) {
                            lr1Var = (lr1) obj;
                        } else {
                            lr1Var = new lr1(this.mSwanApiContext);
                            this.mApis.put("2084449317", lr1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(lr1Var, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.hasCloseHandler")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = lr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    o43 o43Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof o43)) {
                            o43Var = (o43) obj;
                        } else {
                            o43Var = new o43(this.mSwanApiContext);
                            this.mApis.put("1031678042", o43Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(o43Var, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.hideCaptureScreenShareDialog")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = o43Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    qr1 qr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof qr1)) {
                            qr1Var = (qr1) obj;
                        } else {
                            qr1Var = new qr1(this.mSwanApiContext);
                            this.mApis.put("1751900130", qr1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(qr1Var, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.logToFile")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = qr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    p33 p33Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof p33)) {
                            p33Var = (p33) obj;
                        } else {
                            p33Var = new p33(this.mSwanApiContext);
                            this.mApis.put("1748196865", p33Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(p33Var, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.preloadPackage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = p33Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    rr1 rr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof rr1)) {
                            rr1Var = (rr1) obj;
                        } else {
                            rr1Var = new rr1(this.mSwanApiContext);
                            this.mApis.put("589529211", rr1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(rr1Var, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.previewImage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 B = rr1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    ur1 ur1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof ur1)) {
                            ur1Var = (ur1) obj;
                        } else {
                            ur1Var = new ur1(this.mSwanApiContext);
                            this.mApis.put("-577481801", ur1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(ur1Var, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.ubcFlowJar")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 I = ur1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    za3 za3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof za3)) {
                            za3Var = (za3) obj;
                        } else {
                            za3Var = new za3(this.mSwanApiContext);
                            this.mApis.put("1879401452", za3Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(za3Var, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Wifi.connectWifi")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = za3Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    za3 za3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof za3)) {
                            za3Var = (za3) obj;
                        } else {
                            za3Var = new za3(this.mSwanApiContext);
                            this.mApis.put("1879401452", za3Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(za3Var, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Wifi.getConnectedWifi")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 B = za3Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    za3 za3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof za3)) {
                            za3Var = (za3) obj;
                        } else {
                            za3Var = new za3(this.mSwanApiContext);
                            this.mApis.put("1879401452", za3Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(za3Var, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Wifi.getWifiList")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 C = za3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    za3 za3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof za3)) {
                            za3Var = (za3) obj;
                        } else {
                            za3Var = new za3(this.mSwanApiContext);
                            this.mApis.put("1879401452", za3Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(za3Var, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Wifi.startWifi")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 G = za3Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    za3 za3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof za3)) {
                            za3Var = (za3) obj;
                        } else {
                            za3Var = new za3(this.mSwanApiContext);
                            this.mApis.put("1879401452", za3Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(za3Var, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Wifi.stopWifi")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 H = za3Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static Map<String, Object> getWebviewApiModules(final ko1 ko1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ko1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    qo1 qo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof qo1)) {
                            qo1Var = (qo1) obj;
                        } else {
                            qo1Var = new qo1(this.mSwanApiContext);
                            this.mApis.put("1930258908", qo1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(qo1Var, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Account.checkSession")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = qo1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    ro1 ro1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ro1)) {
                            ro1Var = (ro1) obj;
                        } else {
                            ro1Var = new ro1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ro1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(ro1Var, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Account.getLoginCode")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 C = ro1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    so1 so1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof so1)) {
                            so1Var = (so1) obj;
                        } else {
                            so1Var = new so1(this.mSwanApiContext);
                            this.mApis.put("1754780133", so1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(so1Var, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Account.getOpenId")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = so1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    zn1 zn1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof zn1)) {
                            zn1Var = (zn1) obj;
                        } else {
                            zn1Var = new zn1(this.mSwanApiContext);
                            this.mApis.put("-343998465", zn1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(zn1Var, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Account.getUnionBDUSS")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = zn1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    po1 po1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof po1)) {
                            po1Var = (po1) obj;
                        } else {
                            po1Var = new po1(this.mSwanApiContext);
                            this.mApis.put("-337742792", po1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(po1Var, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Account.isBaiduAccountSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = po1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    ro1 ro1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ro1)) {
                            ro1Var = (ro1) obj;
                        } else {
                            ro1Var = new ro1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ro1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(ro1Var, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Account.isLoginSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 H = ro1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    ro1 ro1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ro1)) {
                            ro1Var = (ro1) obj;
                        } else {
                            ro1Var = new ro1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ro1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(ro1Var, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Account.login")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 I = ro1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    to1 to1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof to1)) {
                            to1Var = (to1) obj;
                        } else {
                            to1Var = new to1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", to1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(to1Var, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Basic.loadSubPackage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 F = to1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    to1 to1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof to1)) {
                            to1Var = (to1) obj;
                        } else {
                            to1Var = new to1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", to1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(to1Var, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Basic.loadSubPackages")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 G = to1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    ah1 ah1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof ah1)) {
                            ah1Var = (ah1) obj;
                        } else {
                            ah1Var = new ah1(this.mSwanApiContext);
                            this.mApis.put("1460300387", ah1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(ah1Var, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Bookshelf.deleteBookshelf")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 K = ah1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    ah1 ah1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof ah1)) {
                            ah1Var = (ah1) obj;
                        } else {
                            ah1Var = new ah1(this.mSwanApiContext);
                            this.mApis.put("1460300387", ah1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(ah1Var, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Bookshelf.insertBookshelf")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 P = ah1Var.P(str);
                        return P == null ? "" : P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    ah1 ah1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof ah1)) {
                            ah1Var = (ah1) obj;
                        } else {
                            ah1Var = new ah1(this.mSwanApiContext);
                            this.mApis.put("1460300387", ah1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(ah1Var, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Bookshelf.navigateToBookshelf")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 U = ah1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    ah1 ah1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof ah1)) {
                            ah1Var = (ah1) obj;
                        } else {
                            ah1Var = new ah1(this.mSwanApiContext);
                            this.mApis.put("1460300387", ah1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(ah1Var, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Bookshelf.queryBookshelf")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 V = ah1Var.V(str);
                        return V == null ? "" : V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    ah1 ah1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof ah1)) {
                            ah1Var = (ah1) obj;
                        } else {
                            ah1Var = new ah1(this.mSwanApiContext);
                            this.mApis.put("1460300387", ah1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(ah1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Bookshelf.updateBookshelfReadTime")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 X = ah1Var.X(str);
                        return X == null ? "" : X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    no1 no1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof no1)) {
                            no1Var = (no1) obj;
                        } else {
                            no1Var = new no1(this.mSwanApiContext);
                            this.mApis.put("-277316359", no1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(no1Var, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Coupon.getPlatformCoupons")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = no1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    no1 no1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof no1)) {
                            no1Var = (no1) obj;
                        } else {
                            no1Var = new no1(this.mSwanApiContext);
                            this.mApis.put("-277316359", no1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(no1Var, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Coupon.getUserCoupons")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 z = no1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    no1 no1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof no1)) {
                            no1Var = (no1) obj;
                        } else {
                            no1Var = new no1(this.mSwanApiContext);
                            this.mApis.put("-277316359", no1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(no1Var, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Coupon.takeCoupons")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 C = no1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    vo1 vo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof vo1)) {
                            vo1Var = (vo1) obj;
                        } else {
                            vo1Var = new vo1(this.mSwanApiContext);
                            this.mApis.put("-1225406515", vo1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(vo1Var, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Favorite.getFavorStatus")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = vo1Var.x(str);
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
                        Pair<Boolean, is1> a = ks1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Favorite.showFavoriteGuide")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 G = showFavoriteGuideApi.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    xo1 xo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof xo1)) {
                            xo1Var = (xo1) obj;
                        } else {
                            xo1Var = new xo1(this.mSwanApiContext);
                            this.mApis.put("-2057135077", xo1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(xo1Var, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "File.shareFile")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = xo1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    md2 md2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof md2)) {
                            md2Var = (md2) obj;
                        } else {
                            md2Var = new md2(this.mSwanApiContext);
                            this.mApis.put("2077414795", md2Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(md2Var, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "GameCenter.postGameCenterMessage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = md2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    md2 md2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof md2)) {
                            md2Var = (md2) obj;
                        } else {
                            md2Var = new md2(this.mSwanApiContext);
                            this.mApis.put("2077414795", md2Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(md2Var, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "GameCenter.postGameCenterMessageSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = md2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String download(String str) {
                    yo1 yo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof yo1)) {
                            yo1Var = (yo1) obj;
                        } else {
                            yo1Var = new yo1(this.mSwanApiContext);
                            this.mApis.put("-170124576", yo1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(yo1Var, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "HostDownloadManager.download")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = yo1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    yo1 yo1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof yo1)) {
                            yo1Var = (yo1) obj;
                        } else {
                            yo1Var = new yo1(this.mSwanApiContext);
                            this.mApis.put("-170124576", yo1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(yo1Var, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "HostDownloadManager.openDownloadCenter")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = yo1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    yo1 yo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof yo1)) {
                            yo1Var = (yo1) obj;
                        } else {
                            yo1Var = new yo1(this.mSwanApiContext);
                            this.mApis.put("-170124576", yo1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(yo1Var, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "HostDownloadManager.openFile")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 z = yo1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    yo1 yo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof yo1)) {
                            yo1Var = (yo1) obj;
                        } else {
                            yo1Var = new yo1(this.mSwanApiContext);
                            this.mApis.put("-170124576", yo1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(yo1Var, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "HostDownloadManager.query")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 query = yo1Var.query(str);
                        return query == null ? "" : query.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naImage", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    aq2 aq2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof aq2)) {
                            aq2Var = (aq2) obj;
                        } else {
                            aq2Var = new aq2(this.mSwanApiContext);
                            this.mApis.put("1445003743", aq2Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(aq2Var, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Image.callImageMenu")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = aq2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    bp1 bp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof bp1)) {
                            bp1Var = (bp1) obj;
                        } else {
                            bp1Var = new bp1(this.mSwanApiContext);
                            this.mApis.put("-1252730367", bp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(bp1Var, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Image.compressImage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = bp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", jp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(jp1Var, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.closeTabBar")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = jp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", jp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(jp1Var, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.closeTabBarRedDot")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = jp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    dp1 dp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof dp1)) {
                            dp1Var = (dp1) obj;
                        } else {
                            dp1Var = new dp1(this.mSwanApiContext);
                            this.mApis.put("5236036", dp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(dp1Var, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.hideLoading")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = dp1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    fp1 fp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof fp1)) {
                            fp1Var = (fp1) obj;
                        } else {
                            fp1Var = new fp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", fp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(fp1Var, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.hideNavigationBarLoading")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = fp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    kp1 kp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof kp1)) {
                            kp1Var = (kp1) obj;
                        } else {
                            kp1Var = new kp1(this.mSwanApiContext);
                            this.mApis.put("1159492510", kp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(kp1Var, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.hideToast")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 K = kp1Var.K();
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    hp1 hp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof hp1)) {
                            hp1Var = (hp1) obj;
                        } else {
                            hp1Var = new hp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", hp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(hp1Var, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.openMultiPicker")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 G = hp1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    hp1 hp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof hp1)) {
                            hp1Var = (hp1) obj;
                        } else {
                            hp1Var = new hp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", hp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(hp1Var, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.openPicker")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 H = hp1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", jp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(jp1Var, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.openTabBar")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 C = jp1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    gp1 gp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("-1750613704", gp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(gp1Var, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.pageScrollTo")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = gp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    fp1 fp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof fp1)) {
                            fp1Var = (fp1) obj;
                        } else {
                            fp1Var = new fp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", fp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(fp1Var, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.setNavigationBarColor")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 z = fp1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    fp1 fp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof fp1)) {
                            fp1Var = (fp1) obj;
                        } else {
                            fp1Var = new fp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", fp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(fp1Var, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.setNavigationBarTitle")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = fp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", jp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(jp1Var, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.setTabBarItem")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 D = jp1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    hp1 hp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof hp1)) {
                            hp1Var = (hp1) obj;
                        } else {
                            hp1Var = new hp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", hp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(hp1Var, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.showDatePickerView")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 L = hp1Var.L(str);
                        return L == null ? "" : L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    lp1 lp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof lp1)) {
                            lp1Var = (lp1) obj;
                        } else {
                            lp1Var = new lp1(this.mSwanApiContext);
                            this.mApis.put("1172469410", lp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(lp1Var, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.showHalfScreenWebview")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 K = lp1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    dp1 dp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof dp1)) {
                            dp1Var = (dp1) obj;
                        } else {
                            dp1Var = new dp1(this.mSwanApiContext);
                            this.mApis.put("5236036", dp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(dp1Var, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.showLoading")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = dp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    ep1 ep1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof ep1)) {
                            ep1Var = (ep1) obj;
                        } else {
                            ep1Var = new ep1(this.mSwanApiContext);
                            this.mApis.put("1913747800", ep1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(ep1Var, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.showModal")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = ep1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    fp1 fp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof fp1)) {
                            fp1Var = (fp1) obj;
                        } else {
                            fp1Var = new fp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", fp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(fp1Var, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.showNavigationBarLoading")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 B = fp1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    kp1 kp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof kp1)) {
                            kp1Var = (kp1) obj;
                        } else {
                            kp1Var = new kp1(this.mSwanApiContext);
                            this.mApis.put("1159492510", kp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(kp1Var, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.showToast")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 Q = kp1Var.Q(str);
                        return Q == null ? "" : Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("1165118609", ip1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(ip1Var, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.stopPullDownRefresh")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = ip1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    hp1 hp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof hp1)) {
                            hp1Var = (hp1) obj;
                        } else {
                            hp1Var = new hp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", hp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(hp1Var, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Interaction.updateMultiPicker")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 M = hp1Var.M(str);
                        return M == null ? "" : M.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    mp1 mp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof mp1)) {
                            mp1Var = (mp1) obj;
                        } else {
                            mp1Var = new mp1(this.mSwanApiContext);
                            this.mApis.put("-137346255", mp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(mp1Var, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Keyboard.startKeyboardHeightChange")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 C = mp1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    mp1 mp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof mp1)) {
                            mp1Var = (mp1) obj;
                        } else {
                            mp1Var = new mp1(this.mSwanApiContext);
                            this.mApis.put("-137346255", mp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(mp1Var, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Keyboard.stopKeyboardHeightChange")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 D = mp1Var.D();
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    np1 np1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof np1)) {
                            np1Var = (np1) obj;
                        } else {
                            np1Var = new np1(this.mSwanApiContext);
                            this.mApis.put("-397373095", np1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(np1Var, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "LocationService.getLocation")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = np1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    np1 np1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof np1)) {
                            np1Var = (np1) obj;
                        } else {
                            np1Var = new np1(this.mSwanApiContext);
                            this.mApis.put("-397373095", np1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(np1Var, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "LocationService.startLocationUpdate")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = np1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    np1 np1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof np1)) {
                            np1Var = (np1) obj;
                        } else {
                            np1Var = new np1(this.mSwanApiContext);
                            this.mApis.put("-397373095", np1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(np1Var, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "LocationService.stopLocationUpdate")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 B = np1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    er1 er1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof er1)) {
                            er1Var = (er1) obj;
                        } else {
                            er1Var = new er1(this.mSwanApiContext);
                            this.mApis.put("538070032", er1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(er1Var, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = er1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String callService(String str) {
                    qp1 qp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof qp1)) {
                            qp1Var = (qp1) obj;
                        } else {
                            qp1Var = new qp1(this.mSwanApiContext);
                            this.mApis.put("-1076509454", qp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(qp1Var, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Network.callService")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = qp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    xp1 xp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof xp1)) {
                            xp1Var = (xp1) obj;
                        } else {
                            xp1Var = new xp1(this.mSwanApiContext);
                            this.mApis.put("968563034", xp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(xp1Var, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Network.cancelRequest")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 D = xp1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    wp1 wp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof wp1)) {
                            wp1Var = (wp1) obj;
                        } else {
                            wp1Var = new wp1(this.mSwanApiContext);
                            this.mApis.put("453220699", wp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(wp1Var, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Network.getNetworkType")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = wp1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    wp1 wp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof wp1)) {
                            wp1Var = (wp1) obj;
                        } else {
                            wp1Var = new wp1(this.mSwanApiContext);
                            this.mApis.put("453220699", wp1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(wp1Var, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Network.networkStatusChange")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = wp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                @JavascriptInterface
                public String request(String str) {
                    InterceptResult invokeL2;
                    xp1 xp1Var;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && (invokeL2 = interceptable2.invokeL(1048580, this, str)) != null) {
                        return (String) invokeL2.objValue;
                    }
                    try {
                        hs1.c().a("request");
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof xp1)) {
                            xp1Var = (xp1) obj;
                        } else {
                            xp1Var = new xp1(this.mSwanApiContext);
                            this.mApis.put("968563034", xp1Var);
                        }
                        Pair<Boolean, is1> a2 = ks1.a(xp1Var, "swanAPI/request");
                        if (((Boolean) a2.first).booleanValue()) {
                            a = ((is1) a2.second).a();
                        } else if (q22.a(this.mSwanApiContext.h(), "Network.request")) {
                            a = new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        } else {
                            Pair<is1, JSONObject> u = mo1.u(str);
                            if (!((is1) u.first).isSuccess()) {
                                a = ((is1) u.first).a();
                            } else {
                                JSONObject jSONObject = (JSONObject) u.second;
                                if (jSONObject == null) {
                                    a = is1.a.a();
                                } else {
                                    js1 V = xp1Var.V(jSONObject);
                                    a = V == null ? "" : V.a();
                                }
                            }
                        }
                        return a;
                    } finally {
                    }
                }
            });
            hashMap.put("_naPayment", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    gt2 gt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof gt2)) {
                            gt2Var = (gt2) obj;
                        } else {
                            gt2Var = new gt2(this.mSwanApiContext);
                            this.mApis.put("-336396851", gt2Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(gt2Var, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Payment.chooseCoupon")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = gt2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    gt2 gt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof gt2)) {
                            gt2Var = (gt2) obj;
                        } else {
                            gt2Var = new gt2(this.mSwanApiContext);
                            this.mApis.put("-336396851", gt2Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(gt2Var, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Payment.getPaymentInfo")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = gt2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    ws2 ws2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof ws2)) {
                            ws2Var = (ws2) obj;
                        } else {
                            ws2Var = new ws2(this.mSwanApiContext);
                            this.mApis.put("1854689529", ws2Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(ws2Var, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Payment.requestThirdPayment")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = ws2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    gt2 gt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof gt2)) {
                            gt2Var = (gt2) obj;
                        } else {
                            gt2Var = new gt2(this.mSwanApiContext);
                            this.mApis.put("-336396851", gt2Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(gt2Var, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Payment.setPaymentInfo")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 z = gt2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    rv2 rv2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof rv2)) {
                            rv2Var = (rv2) obj;
                        } else {
                            rv2Var = new rv2(this.mSwanApiContext);
                            this.mApis.put("-254510461", rv2Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(rv2Var, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Plugin.invokePluginChooseAddress")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = rv2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    rv2 rv2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof rv2)) {
                            rv2Var = (rv2) obj;
                        } else {
                            rv2Var = new rv2(this.mSwanApiContext);
                            this.mApis.put("-254510461", rv2Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(rv2Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 z = rv2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    rv2 rv2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof rv2)) {
                            rv2Var = (rv2) obj;
                        } else {
                            rv2Var = new rv2(this.mSwanApiContext);
                            this.mApis.put("-254510461", rv2Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(rv2Var, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Plugin.invokePluginPayment")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = rv2Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    k42 k42Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof k42)) {
                            k42Var = (k42) obj;
                        } else {
                            k42Var = new k42(this.mSwanApiContext);
                            this.mApis.put("-2068479848", k42Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(k42Var, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Prefetch.prefetchResources")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = k42Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    c32 c32Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof c32)) {
                            c32Var = (c32) obj;
                        } else {
                            c32Var = new c32(this.mSwanApiContext);
                            this.mApis.put("423661539", c32Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(c32Var, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Preload.preloadStatus")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = c32Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    mc3 mc3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof mc3)) {
                            mc3Var = (mc3) obj;
                        } else {
                            mc3Var = new mc3(this.mSwanApiContext);
                            this.mApis.put("-1929343869", mc3Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(mc3Var, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "PrivateFile.uploadFileToBos")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 C = mc3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    bq1 bq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof bq1)) {
                            bq1Var = (bq1) obj;
                        } else {
                            bq1Var = new bq1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", bq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(bq1Var, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Router.hideModalPage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = bq1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    bq1 bq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof bq1)) {
                            bq1Var = (bq1) obj;
                        } else {
                            bq1Var = new bq1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", bq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(bq1Var, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Router.navigateBack")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 B = bq1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    cq1 cq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof cq1)) {
                            cq1Var = (cq1) obj;
                        } else {
                            cq1Var = new cq1(this.mSwanApiContext);
                            this.mApis.put("1968522584", cq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(cq1Var, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Router.navigateTo")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 H = cq1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    eq1 eq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof eq1)) {
                            eq1Var = (eq1) obj;
                        } else {
                            eq1Var = new eq1(this.mSwanApiContext);
                            this.mApis.put("1317280190", eq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(eq1Var, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Router.reLaunch")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = eq1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    fq1 fq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof fq1)) {
                            fq1Var = (fq1) obj;
                        } else {
                            fq1Var = new fq1(this.mSwanApiContext);
                            this.mApis.put("-420075743", fq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(fq1Var, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Router.reLoadErrorPage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = fq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    dq1 dq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof dq1)) {
                            dq1Var = (dq1) obj;
                        } else {
                            dq1Var = new dq1(this.mSwanApiContext);
                            this.mApis.put("1792515533", dq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(dq1Var, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Router.redirectTo")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 D = dq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    cq1 cq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof cq1)) {
                            cq1Var = (cq1) obj;
                        } else {
                            cq1Var = new cq1(this.mSwanApiContext);
                            this.mApis.put("1968522584", cq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(cq1Var, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Router.showModalPage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 J = cq1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    iq1 iq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof iq1)) {
                            iq1Var = (iq1) obj;
                        } else {
                            iq1Var = new iq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", iq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(iq1Var, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Setting.getAppInfoSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 F = iq1Var.F();
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    iq1 iq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof iq1)) {
                            iq1Var = (iq1) obj;
                        } else {
                            iq1Var = new iq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", iq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(iq1Var, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Setting.getSetting")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 G = iq1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    iq1 iq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof iq1)) {
                            iq1Var = (iq1) obj;
                        } else {
                            iq1Var = new iq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", iq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(iq1Var, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Setting.getSlaveIdSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 H = iq1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    iq1 iq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof iq1)) {
                            iq1Var = (iq1) obj;
                        } else {
                            iq1Var = new iq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", iq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(iq1Var, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Setting.getSwanId")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 I = iq1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    iq1 iq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof iq1)) {
                            iq1Var = (iq1) obj;
                        } else {
                            iq1Var = new iq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", iq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(iq1Var, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Setting.getUserInfo")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 J = iq1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    hq1 hq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof hq1)) {
                            hq1Var = (hq1) obj;
                        } else {
                            hq1Var = new hq1(this.mSwanApiContext);
                            this.mApis.put("450273045", hq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(hq1Var, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Setting.isAllowedAdOpenAppSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = hq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    g73 g73Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof g73)) {
                            g73Var = (g73) obj;
                        } else {
                            g73Var = new g73(this.mSwanApiContext);
                            this.mApis.put("712777136", g73Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(g73Var, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = g73Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    lq1 lq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lq1)) {
                            lq1Var = (lq1) obj;
                        } else {
                            lq1Var = new lq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(lq1Var, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.clearGlobalStorage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = lq1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    lq1 lq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lq1)) {
                            lq1Var = (lq1) obj;
                        } else {
                            lq1Var = new lq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(lq1Var, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.clearGlobalStorageSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 C = lq1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    kq1 kq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("130910081", kq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(kq1Var, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.clearStorage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = kq1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    kq1 kq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("130910081", kq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(kq1Var, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.clearStorageSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 C = kq1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    lq1 lq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lq1)) {
                            lq1Var = (lq1) obj;
                        } else {
                            lq1Var = new lq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(lq1Var, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.getGlobalStorage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 D = lq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    lq1 lq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lq1)) {
                            lq1Var = (lq1) obj;
                        } else {
                            lq1Var = new lq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(lq1Var, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.getGlobalStorageInfo")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 G = lq1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    lq1 lq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lq1)) {
                            lq1Var = (lq1) obj;
                        } else {
                            lq1Var = new lq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(lq1Var, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.getGlobalStorageInfoSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 J = lq1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    lq1 lq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lq1)) {
                            lq1Var = (lq1) obj;
                        } else {
                            lq1Var = new lq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(lq1Var, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.getGlobalStorageSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 K = lq1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    kq1 kq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("130910081", kq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(kq1Var, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.getStorage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 D = kq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    kq1 kq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("130910081", kq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(kq1Var, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.getStorageInfo")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 G = kq1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    kq1 kq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("130910081", kq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(kq1Var, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.getStorageInfoAsync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 H = kq1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    kq1 kq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("130910081", kq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(kq1Var, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.getStorageInfoSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 J = kq1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    kq1 kq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("130910081", kq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(kq1Var, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.getStorageSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 K = kq1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    lq1 lq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lq1)) {
                            lq1Var = (lq1) obj;
                        } else {
                            lq1Var = new lq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(lq1Var, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.removeGlobalStorage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 R = lq1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    lq1 lq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lq1)) {
                            lq1Var = (lq1) obj;
                        } else {
                            lq1Var = new lq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(lq1Var, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.removeGlobalStorageSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 T = lq1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    kq1 kq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("130910081", kq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(kq1Var, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.removeStorage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 R = kq1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    kq1 kq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("130910081", kq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(kq1Var, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.removeStorageSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 T = kq1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    lq1 lq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lq1)) {
                            lq1Var = (lq1) obj;
                        } else {
                            lq1Var = new lq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(lq1Var, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.setGlobalStorage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 U = lq1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    lq1 lq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof lq1)) {
                            lq1Var = (lq1) obj;
                        } else {
                            lq1Var = new lq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", lq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(lq1Var, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.setGlobalStorageSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 W = lq1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    kq1 kq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("130910081", kq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(kq1Var, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.setStorage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 U = kq1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    kq1 kq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof kq1)) {
                            kq1Var = (kq1) obj;
                        } else {
                            kq1Var = new kq1(this.mSwanApiContext);
                            this.mApis.put("130910081", kq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(kq1Var, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Storage.setStorageSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 W = kq1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    nq1 nq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof nq1)) {
                            nq1Var = (nq1) obj;
                        } else {
                            nq1Var = new nq1(this.mSwanApiContext);
                            this.mApis.put("823117982", nq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(nq1Var, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Subscription.requestSubscribeFormId")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 E = nq1Var.E(str);
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    oq1 oq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof oq1)) {
                            oq1Var = (oq1) obj;
                        } else {
                            oq1Var = new oq1(this.mSwanApiContext);
                            this.mApis.put("-947445811", oq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(oq1Var, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Subscription.subscribeService")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 F = oq1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    vq1 vq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("1936205521", vq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(vq1Var, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.exitFullScreen")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = vq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    rq1 rq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof rq1)) {
                            rq1Var = (rq1) obj;
                        } else {
                            rq1Var = new rq1(this.mSwanApiContext);
                            this.mApis.put("99997465", rq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(rq1Var, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.getBrightness")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = rq1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    sq1 sq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof sq1)) {
                            sq1Var = (sq1) obj;
                        } else {
                            sq1Var = new sq1(this.mSwanApiContext);
                            this.mApis.put("-518757484", sq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(sq1Var, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.getClipboardData")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = sq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    uq1 uq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof uq1)) {
                            uq1Var = (uq1) obj;
                        } else {
                            uq1Var = new uq1(this.mSwanApiContext);
                            this.mApis.put("1694151270", uq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(uq1Var, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.getDeviceInfo")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = uq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    wq1 wq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof wq1)) {
                            wq1Var = (wq1) obj;
                        } else {
                            wq1Var = new wq1(this.mSwanApiContext);
                            this.mApis.put("-1321681619", wq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(wq1Var, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.getDeviceProfile")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = wq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    cr1 cr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("447234992", cr1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(cr1Var, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.getMediaVolume")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = cr1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    xq1 xq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof xq1)) {
                            xq1Var = (xq1) obj;
                        } else {
                            xq1Var = new xq1(this.mSwanApiContext);
                            this.mApis.put("-1569246082", xq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(xq1Var, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.makePhoneCall")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = xq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    zq1 zq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof zq1)) {
                            zq1Var = (zq1) obj;
                        } else {
                            zq1Var = new zq1(this.mSwanApiContext);
                            this.mApis.put("1099851202", zq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(zq1Var, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.openSMSPanel")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = zq1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    yq1 yq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof yq1)) {
                            yq1Var = (yq1) obj;
                        } else {
                            yq1Var = new yq1(this.mSwanApiContext);
                            this.mApis.put("-1707203360", yq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(yq1Var, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.requestFullScreen")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 F = yq1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    sq1 sq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof sq1)) {
                            sq1Var = (sq1) obj;
                        } else {
                            sq1Var = new sq1(this.mSwanApiContext);
                            this.mApis.put("-518757484", sq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(sq1Var, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.setClipboardData")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = sq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    cq2 cq2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof cq2)) {
                            cq2Var = (cq2) obj;
                        } else {
                            cq2Var = new cq2(this.mSwanApiContext);
                            this.mApis.put("1161486049", cq2Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(cq2Var, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.setErrorPageType")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = cq2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    cr1 cr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("447234992", cr1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(cr1Var, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.setMediaVolume")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 z = cr1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    qq1 qq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof qq1)) {
                            qq1Var = (qq1) obj;
                        } else {
                            qq1Var = new qq1(this.mSwanApiContext);
                            this.mApis.put("1372680763", qq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(qq1Var, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.startAccelerometer")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = qq1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    tq1 tq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof tq1)) {
                            tq1Var = (tq1) obj;
                        } else {
                            tq1Var = new tq1(this.mSwanApiContext);
                            this.mApis.put("1689255576", tq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(tq1Var, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.startCompass")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = tq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    qq1 qq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof qq1)) {
                            qq1Var = (qq1) obj;
                        } else {
                            qq1Var = new qq1(this.mSwanApiContext);
                            this.mApis.put("1372680763", qq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(qq1Var, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.stopAccelerometer")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 B = qq1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    tq1 tq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof tq1)) {
                            tq1Var = (tq1) obj;
                        } else {
                            tq1Var = new tq1(this.mSwanApiContext);
                            this.mApis.put("1689255576", tq1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(tq1Var, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "System.stopCompass")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 z = tq1Var.z();
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    nr1 nr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof nr1)) {
                            nr1Var = (nr1) obj;
                        } else {
                            nr1Var = new nr1(this.mSwanApiContext);
                            this.mApis.put("201194468", nr1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(nr1Var, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.addToDesktop")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 B = nr1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    jr1 jr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof jr1)) {
                            jr1Var = (jr1) obj;
                        } else {
                            jr1Var = new jr1(this.mSwanApiContext);
                            this.mApis.put("-1412306947", jr1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(jr1Var, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.calcMD5")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = jr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    kr1 kr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof kr1)) {
                            kr1Var = (kr1) obj;
                        } else {
                            kr1Var = new kr1(this.mSwanApiContext);
                            this.mApis.put("1626415364", kr1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(kr1Var, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.checkAppInstalled")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = kr1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    mr1 mr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof mr1)) {
                            mr1Var = (mr1) obj;
                        } else {
                            mr1Var = new mr1(this.mSwanApiContext);
                            this.mApis.put("-836768778", mr1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(mr1Var, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.getCommonSysInfo")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = mr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    sr1 sr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof sr1)) {
                            sr1Var = (sr1) obj;
                        } else {
                            sr1Var = new sr1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", sr1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(sr1Var, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.getCommonSysInfoSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 E = sr1Var.E();
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    or1 or1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof or1)) {
                            or1Var = (or1) obj;
                        } else {
                            or1Var = new or1(this.mSwanApiContext);
                            this.mApis.put("-810858308", or1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(or1Var, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.getPerformanceLevel")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = or1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    sr1 sr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof sr1)) {
                            sr1Var = (sr1) obj;
                        } else {
                            sr1Var = new sr1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", sr1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(sr1Var, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.getSystemInfo")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 H = sr1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    sr1 sr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof sr1)) {
                            sr1Var = (sr1) obj;
                        } else {
                            sr1Var = new sr1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", sr1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(sr1Var, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.getSystemInfoAsync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 I = sr1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    sr1 sr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof sr1)) {
                            sr1Var = (sr1) obj;
                        } else {
                            sr1Var = new sr1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", sr1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(sr1Var, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.getSystemInfoSync")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 J = sr1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    pr1 pr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof pr1)) {
                            pr1Var = (pr1) obj;
                        } else {
                            pr1Var = new pr1(this.mSwanApiContext);
                            this.mApis.put("-2097727681", pr1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(pr1Var, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.handleException")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = pr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    lr1 lr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof lr1)) {
                            lr1Var = (lr1) obj;
                        } else {
                            lr1Var = new lr1(this.mSwanApiContext);
                            this.mApis.put("2084449317", lr1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(lr1Var, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.hasCloseHandler")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = lr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    o43 o43Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof o43)) {
                            o43Var = (o43) obj;
                        } else {
                            o43Var = new o43(this.mSwanApiContext);
                            this.mApis.put("1031678042", o43Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(o43Var, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.hideCaptureScreenShareDialog")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 x = o43Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    qr1 qr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof qr1)) {
                            qr1Var = (qr1) obj;
                        } else {
                            qr1Var = new qr1(this.mSwanApiContext);
                            this.mApis.put("1751900130", qr1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(qr1Var, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.logToFile")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = qr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    p33 p33Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof p33)) {
                            p33Var = (p33) obj;
                        } else {
                            p33Var = new p33(this.mSwanApiContext);
                            this.mApis.put("1748196865", p33Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(p33Var, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.preloadPackage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = p33Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    rr1 rr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof rr1)) {
                            rr1Var = (rr1) obj;
                        } else {
                            rr1Var = new rr1(this.mSwanApiContext);
                            this.mApis.put("589529211", rr1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(rr1Var, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.previewImage")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 B = rr1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    ur1 ur1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof ur1)) {
                            ur1Var = (ur1) obj;
                        } else {
                            ur1Var = new ur1(this.mSwanApiContext);
                            this.mApis.put("-577481801", ur1Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(ur1Var, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Utils.ubcFlowJar")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 I = ur1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ko1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ko1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ko1Var;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    za3 za3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof za3)) {
                            za3Var = (za3) obj;
                        } else {
                            za3Var = new za3(this.mSwanApiContext);
                            this.mApis.put("1879401452", za3Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(za3Var, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Wifi.connectWifi")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 A = za3Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    za3 za3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof za3)) {
                            za3Var = (za3) obj;
                        } else {
                            za3Var = new za3(this.mSwanApiContext);
                            this.mApis.put("1879401452", za3Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(za3Var, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Wifi.getConnectedWifi")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 B = za3Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    za3 za3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof za3)) {
                            za3Var = (za3) obj;
                        } else {
                            za3Var = new za3(this.mSwanApiContext);
                            this.mApis.put("1879401452", za3Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(za3Var, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Wifi.getWifiList")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 C = za3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    za3 za3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof za3)) {
                            za3Var = (za3) obj;
                        } else {
                            za3Var = new za3(this.mSwanApiContext);
                            this.mApis.put("1879401452", za3Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(za3Var, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Wifi.startWifi")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 G = za3Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    za3 za3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof za3)) {
                            za3Var = (za3) obj;
                        } else {
                            za3Var = new za3(this.mSwanApiContext);
                            this.mApis.put("1879401452", za3Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(za3Var, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "Wifi.stopWifi")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 H = za3Var.H(str);
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
