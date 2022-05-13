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
import com.repackage.a43;
import com.repackage.ap1;
import com.repackage.as1;
import com.repackage.b32;
import com.repackage.bp1;
import com.repackage.bq1;
import com.repackage.br1;
import com.repackage.bs1;
import com.repackage.cp1;
import com.repackage.cr1;
import com.repackage.cs1;
import com.repackage.cw2;
import com.repackage.dp1;
import com.repackage.dr1;
import com.repackage.ds1;
import com.repackage.ep1;
import com.repackage.er1;
import com.repackage.fr1;
import com.repackage.fs1;
import com.repackage.gp1;
import com.repackage.gr1;
import com.repackage.hq1;
import com.repackage.hr1;
import com.repackage.ht2;
import com.repackage.ip1;
import com.repackage.iq1;
import com.repackage.ir1;
import com.repackage.jp1;
import com.repackage.jr1;
import com.repackage.kb3;
import com.repackage.ko1;
import com.repackage.kr1;
import com.repackage.lh1;
import com.repackage.lq2;
import com.repackage.mp1;
import com.repackage.mq1;
import com.repackage.n32;
import com.repackage.nq1;
import com.repackage.nq2;
import com.repackage.nr1;
import com.repackage.op1;
import com.repackage.oq1;
import com.repackage.pp1;
import com.repackage.pq1;
import com.repackage.pr1;
import com.repackage.qp1;
import com.repackage.qq1;
import com.repackage.r73;
import com.repackage.rp1;
import com.repackage.rt2;
import com.repackage.sp1;
import com.repackage.sq1;
import com.repackage.ss1;
import com.repackage.tp1;
import com.repackage.tq1;
import com.repackage.ts1;
import com.repackage.up1;
import com.repackage.ur1;
import com.repackage.us1;
import com.repackage.v42;
import com.repackage.vo1;
import com.repackage.vp1;
import com.repackage.vq1;
import com.repackage.vr1;
import com.repackage.vs1;
import com.repackage.wp1;
import com.repackage.wq1;
import com.repackage.wr1;
import com.repackage.xc3;
import com.repackage.xd2;
import com.repackage.xo1;
import com.repackage.xp1;
import com.repackage.xr1;
import com.repackage.yo1;
import com.repackage.yp1;
import com.repackage.yq1;
import com.repackage.yr1;
import com.repackage.z43;
import com.repackage.zq1;
import com.repackage.zr1;
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

    public static Map<String, Object> getV8ApiModules(final vo1 vo1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, vo1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    bp1 bp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof bp1)) {
                            bp1Var = (bp1) obj;
                        } else {
                            bp1Var = new bp1(this.mSwanApiContext);
                            this.mApis.put("1930258908", bp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(bp1Var, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Account.checkSession")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = bp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    cp1 cp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof cp1)) {
                            cp1Var = (cp1) obj;
                        } else {
                            cp1Var = new cp1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", cp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(cp1Var, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Account.getLoginCode")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 C = cp1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    dp1 dp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof dp1)) {
                            dp1Var = (dp1) obj;
                        } else {
                            dp1Var = new dp1(this.mSwanApiContext);
                            this.mApis.put("1754780133", dp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(dp1Var, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Account.getOpenId")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = dp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    ko1 ko1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof ko1)) {
                            ko1Var = (ko1) obj;
                        } else {
                            ko1Var = new ko1(this.mSwanApiContext);
                            this.mApis.put("-343998465", ko1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ko1Var, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Account.getUnionBDUSS")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = ko1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    ap1 ap1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof ap1)) {
                            ap1Var = (ap1) obj;
                        } else {
                            ap1Var = new ap1(this.mSwanApiContext);
                            this.mApis.put("-337742792", ap1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ap1Var, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Account.isBaiduAccountSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = ap1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    cp1 cp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof cp1)) {
                            cp1Var = (cp1) obj;
                        } else {
                            cp1Var = new cp1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", cp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(cp1Var, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Account.isLoginSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 H = cp1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    cp1 cp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof cp1)) {
                            cp1Var = (cp1) obj;
                        } else {
                            cp1Var = new cp1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", cp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(cp1Var, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Account.login")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 I = cp1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    ep1 ep1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof ep1)) {
                            ep1Var = (ep1) obj;
                        } else {
                            ep1Var = new ep1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", ep1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ep1Var, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Basic.loadSubPackage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 F = ep1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    ep1 ep1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof ep1)) {
                            ep1Var = (ep1) obj;
                        } else {
                            ep1Var = new ep1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", ep1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ep1Var, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Basic.loadSubPackages")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 G = ep1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    lh1 lh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof lh1)) {
                            lh1Var = (lh1) obj;
                        } else {
                            lh1Var = new lh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", lh1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(lh1Var, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Bookshelf.deleteBookshelf")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 K = lh1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    lh1 lh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof lh1)) {
                            lh1Var = (lh1) obj;
                        } else {
                            lh1Var = new lh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", lh1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(lh1Var, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Bookshelf.insertBookshelf")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 P = lh1Var.P(str);
                        return P == null ? "" : P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    lh1 lh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof lh1)) {
                            lh1Var = (lh1) obj;
                        } else {
                            lh1Var = new lh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", lh1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(lh1Var, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Bookshelf.navigateToBookshelf")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 U = lh1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    lh1 lh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof lh1)) {
                            lh1Var = (lh1) obj;
                        } else {
                            lh1Var = new lh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", lh1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(lh1Var, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Bookshelf.queryBookshelf")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 V = lh1Var.V(str);
                        return V == null ? "" : V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    lh1 lh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof lh1)) {
                            lh1Var = (lh1) obj;
                        } else {
                            lh1Var = new lh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", lh1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(lh1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Bookshelf.updateBookshelfReadTime")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 X = lh1Var.X(str);
                        return X == null ? "" : X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    yo1 yo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof yo1)) {
                            yo1Var = (yo1) obj;
                        } else {
                            yo1Var = new yo1(this.mSwanApiContext);
                            this.mApis.put("-277316359", yo1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(yo1Var, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Coupon.getPlatformCoupons")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = yo1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    yo1 yo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof yo1)) {
                            yo1Var = (yo1) obj;
                        } else {
                            yo1Var = new yo1(this.mSwanApiContext);
                            this.mApis.put("-277316359", yo1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(yo1Var, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Coupon.getUserCoupons")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 z = yo1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    yo1 yo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof yo1)) {
                            yo1Var = (yo1) obj;
                        } else {
                            yo1Var = new yo1(this.mSwanApiContext);
                            this.mApis.put("-277316359", yo1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(yo1Var, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Coupon.takeCoupons")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 C = yo1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    gp1 gp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("-1225406515", gp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(gp1Var, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Favorite.getFavorStatus")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = gp1Var.x(str);
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
                        Pair<Boolean, ts1> a = vs1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Favorite.showFavoriteGuide")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 G = showFavoriteGuideApi.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("-2057135077", ip1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ip1Var, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "File.shareFile")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = ip1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    xd2 xd2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof xd2)) {
                            xd2Var = (xd2) obj;
                        } else {
                            xd2Var = new xd2(this.mSwanApiContext);
                            this.mApis.put("2077414795", xd2Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(xd2Var, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "GameCenter.postGameCenterMessage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = xd2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    xd2 xd2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof xd2)) {
                            xd2Var = (xd2) obj;
                        } else {
                            xd2Var = new xd2(this.mSwanApiContext);
                            this.mApis.put("2077414795", xd2Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(xd2Var, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "GameCenter.postGameCenterMessageSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = xd2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String download(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-170124576", jp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(jp1Var, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "HostDownloadManager.download")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = jp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    jp1 jp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-170124576", jp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(jp1Var, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "HostDownloadManager.openDownloadCenter")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = jp1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-170124576", jp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(jp1Var, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "HostDownloadManager.openFile")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 z = jp1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-170124576", jp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(jp1Var, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "HostDownloadManager.query")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 query = jp1Var.query(str);
                        return query == null ? "" : query.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naImage", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    lq2 lq2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof lq2)) {
                            lq2Var = (lq2) obj;
                        } else {
                            lq2Var = new lq2(this.mSwanApiContext);
                            this.mApis.put("1445003743", lq2Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(lq2Var, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Image.callImageMenu")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = lq2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    mp1 mp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof mp1)) {
                            mp1Var = (mp1) obj;
                        } else {
                            mp1Var = new mp1(this.mSwanApiContext);
                            this.mApis.put("-1252730367", mp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(mp1Var, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Image.compressImage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = mp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    up1 up1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", up1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(up1Var, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.closeTabBar")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = up1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    up1 up1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", up1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(up1Var, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.closeTabBarRedDot")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = up1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    op1 op1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof op1)) {
                            op1Var = (op1) obj;
                        } else {
                            op1Var = new op1(this.mSwanApiContext);
                            this.mApis.put("5236036", op1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(op1Var, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.hideLoading")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = op1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    qp1 qp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof qp1)) {
                            qp1Var = (qp1) obj;
                        } else {
                            qp1Var = new qp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", qp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(qp1Var, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.hideNavigationBarLoading")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = qp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    vp1 vp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof vp1)) {
                            vp1Var = (vp1) obj;
                        } else {
                            vp1Var = new vp1(this.mSwanApiContext);
                            this.mApis.put("1159492510", vp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(vp1Var, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.hideToast")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 K = vp1Var.K();
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    sp1 sp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof sp1)) {
                            sp1Var = (sp1) obj;
                        } else {
                            sp1Var = new sp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", sp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(sp1Var, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.openMultiPicker")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 G = sp1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    sp1 sp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof sp1)) {
                            sp1Var = (sp1) obj;
                        } else {
                            sp1Var = new sp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", sp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(sp1Var, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.openPicker")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 H = sp1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    up1 up1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", up1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(up1Var, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.openTabBar")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 C = up1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    rp1 rp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof rp1)) {
                            rp1Var = (rp1) obj;
                        } else {
                            rp1Var = new rp1(this.mSwanApiContext);
                            this.mApis.put("-1750613704", rp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(rp1Var, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.pageScrollTo")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = rp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    qp1 qp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof qp1)) {
                            qp1Var = (qp1) obj;
                        } else {
                            qp1Var = new qp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", qp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(qp1Var, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.setNavigationBarColor")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 z = qp1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    qp1 qp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof qp1)) {
                            qp1Var = (qp1) obj;
                        } else {
                            qp1Var = new qp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", qp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(qp1Var, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.setNavigationBarTitle")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = qp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    up1 up1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", up1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(up1Var, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.setTabBarItem")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 D = up1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    sp1 sp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof sp1)) {
                            sp1Var = (sp1) obj;
                        } else {
                            sp1Var = new sp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", sp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(sp1Var, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.showDatePickerView")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 L = sp1Var.L(str);
                        return L == null ? "" : L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    wp1 wp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof wp1)) {
                            wp1Var = (wp1) obj;
                        } else {
                            wp1Var = new wp1(this.mSwanApiContext);
                            this.mApis.put("1172469410", wp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(wp1Var, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.showHalfScreenWebview")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 K = wp1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    op1 op1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof op1)) {
                            op1Var = (op1) obj;
                        } else {
                            op1Var = new op1(this.mSwanApiContext);
                            this.mApis.put("5236036", op1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(op1Var, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.showLoading")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = op1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    pp1 pp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof pp1)) {
                            pp1Var = (pp1) obj;
                        } else {
                            pp1Var = new pp1(this.mSwanApiContext);
                            this.mApis.put("1913747800", pp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(pp1Var, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.showModal")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = pp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    qp1 qp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof qp1)) {
                            qp1Var = (qp1) obj;
                        } else {
                            qp1Var = new qp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", qp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(qp1Var, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.showNavigationBarLoading")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 B = qp1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    vp1 vp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof vp1)) {
                            vp1Var = (vp1) obj;
                        } else {
                            vp1Var = new vp1(this.mSwanApiContext);
                            this.mApis.put("1159492510", vp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(vp1Var, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.showToast")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 Q = vp1Var.Q(str);
                        return Q == null ? "" : Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    tp1 tp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("1165118609", tp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(tp1Var, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.stopPullDownRefresh")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = tp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    sp1 sp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof sp1)) {
                            sp1Var = (sp1) obj;
                        } else {
                            sp1Var = new sp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", sp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(sp1Var, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.updateMultiPicker")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 M = sp1Var.M(str);
                        return M == null ? "" : M.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    xp1 xp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof xp1)) {
                            xp1Var = (xp1) obj;
                        } else {
                            xp1Var = new xp1(this.mSwanApiContext);
                            this.mApis.put("-137346255", xp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(xp1Var, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Keyboard.startKeyboardHeightChange")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 C = xp1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    xp1 xp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof xp1)) {
                            xp1Var = (xp1) obj;
                        } else {
                            xp1Var = new xp1(this.mSwanApiContext);
                            this.mApis.put("-137346255", xp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(xp1Var, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Keyboard.stopKeyboardHeightChange")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 D = xp1Var.D();
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    yp1 yp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof yp1)) {
                            yp1Var = (yp1) obj;
                        } else {
                            yp1Var = new yp1(this.mSwanApiContext);
                            this.mApis.put("-397373095", yp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(yp1Var, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "LocationService.getLocation")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = yp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    yp1 yp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof yp1)) {
                            yp1Var = (yp1) obj;
                        } else {
                            yp1Var = new yp1(this.mSwanApiContext);
                            this.mApis.put("-397373095", yp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(yp1Var, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "LocationService.startLocationUpdate")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = yp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    yp1 yp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof yp1)) {
                            yp1Var = (yp1) obj;
                        } else {
                            yp1Var = new yp1(this.mSwanApiContext);
                            this.mApis.put("-397373095", yp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(yp1Var, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "LocationService.stopLocationUpdate")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 B = yp1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    pr1 pr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof pr1)) {
                            pr1Var = (pr1) obj;
                        } else {
                            pr1Var = new pr1(this.mSwanApiContext);
                            this.mApis.put("538070032", pr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(pr1Var, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = pr1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String callService(String str) {
                    bq1 bq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof bq1)) {
                            bq1Var = (bq1) obj;
                        } else {
                            bq1Var = new bq1(this.mSwanApiContext);
                            this.mApis.put("-1076509454", bq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(bq1Var, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Network.callService")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = bq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    iq1 iq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof iq1)) {
                            iq1Var = (iq1) obj;
                        } else {
                            iq1Var = new iq1(this.mSwanApiContext);
                            this.mApis.put("968563034", iq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(iq1Var, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Network.cancelRequest")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 D = iq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    hq1 hq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof hq1)) {
                            hq1Var = (hq1) obj;
                        } else {
                            hq1Var = new hq1(this.mSwanApiContext);
                            this.mApis.put("453220699", hq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(hq1Var, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Network.getNetworkType")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = hq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    hq1 hq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof hq1)) {
                            hq1Var = (hq1) obj;
                        } else {
                            hq1Var = new hq1(this.mSwanApiContext);
                            this.mApis.put("453220699", hq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(hq1Var, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Network.networkStatusChange")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = hq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                @JavascriptInterface
                public String request(JsObject jsObject) {
                    InterceptResult invokeL2;
                    iq1 iq1Var;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && (invokeL2 = interceptable2.invokeL(1048580, this, jsObject)) != null) {
                        return (String) invokeL2.objValue;
                    }
                    try {
                        ss1.c().a("request");
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof iq1)) {
                            iq1Var = (iq1) obj;
                        } else {
                            iq1Var = new iq1(this.mSwanApiContext);
                            this.mApis.put("968563034", iq1Var);
                        }
                        Pair<Boolean, ts1> a2 = vs1.a(iq1Var, "swanAPI/request");
                        if (((Boolean) a2.first).booleanValue()) {
                            a = ((ts1) a2.second).a();
                        } else if (b32.a(this.mSwanApiContext.h(), "Network.request")) {
                            a = new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        } else {
                            Pair<ts1, JSONObject> t = xo1.t(jsObject);
                            if (!((ts1) t.first).isSuccess()) {
                                a = ((ts1) t.first).a();
                            } else {
                                JSONObject jSONObject = (JSONObject) t.second;
                                if (jSONObject == null) {
                                    a = ts1.a.a();
                                } else {
                                    us1 V = iq1Var.V(jSONObject);
                                    a = V == null ? "" : V.a();
                                }
                            }
                        }
                        return a;
                    } finally {
                    }
                }
            });
            hashMap.put("_naPayment", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    rt2 rt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof rt2)) {
                            rt2Var = (rt2) obj;
                        } else {
                            rt2Var = new rt2(this.mSwanApiContext);
                            this.mApis.put("-336396851", rt2Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(rt2Var, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Payment.chooseCoupon")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = rt2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    rt2 rt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof rt2)) {
                            rt2Var = (rt2) obj;
                        } else {
                            rt2Var = new rt2(this.mSwanApiContext);
                            this.mApis.put("-336396851", rt2Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(rt2Var, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Payment.getPaymentInfo")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = rt2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    ht2 ht2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof ht2)) {
                            ht2Var = (ht2) obj;
                        } else {
                            ht2Var = new ht2(this.mSwanApiContext);
                            this.mApis.put("1854689529", ht2Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ht2Var, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Payment.requestThirdPayment")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = ht2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    rt2 rt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof rt2)) {
                            rt2Var = (rt2) obj;
                        } else {
                            rt2Var = new rt2(this.mSwanApiContext);
                            this.mApis.put("-336396851", rt2Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(rt2Var, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Payment.setPaymentInfo")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 z = rt2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    cw2 cw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof cw2)) {
                            cw2Var = (cw2) obj;
                        } else {
                            cw2Var = new cw2(this.mSwanApiContext);
                            this.mApis.put("-254510461", cw2Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(cw2Var, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Plugin.invokePluginChooseAddress")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = cw2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    cw2 cw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof cw2)) {
                            cw2Var = (cw2) obj;
                        } else {
                            cw2Var = new cw2(this.mSwanApiContext);
                            this.mApis.put("-254510461", cw2Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(cw2Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 z = cw2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    cw2 cw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof cw2)) {
                            cw2Var = (cw2) obj;
                        } else {
                            cw2Var = new cw2(this.mSwanApiContext);
                            this.mApis.put("-254510461", cw2Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(cw2Var, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Plugin.invokePluginPayment")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = cw2Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    v42 v42Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof v42)) {
                            v42Var = (v42) obj;
                        } else {
                            v42Var = new v42(this.mSwanApiContext);
                            this.mApis.put("-2068479848", v42Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(v42Var, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Prefetch.prefetchResources")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = v42Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    n32 n32Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof n32)) {
                            n32Var = (n32) obj;
                        } else {
                            n32Var = new n32(this.mSwanApiContext);
                            this.mApis.put("423661539", n32Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(n32Var, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Preload.preloadStatus")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = n32Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    xc3 xc3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof xc3)) {
                            xc3Var = (xc3) obj;
                        } else {
                            xc3Var = new xc3(this.mSwanApiContext);
                            this.mApis.put("-1929343869", xc3Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(xc3Var, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "PrivateFile.uploadFileToBos")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 C = xc3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    mq1 mq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof mq1)) {
                            mq1Var = (mq1) obj;
                        } else {
                            mq1Var = new mq1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", mq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(mq1Var, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Router.hideModalPage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = mq1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    mq1 mq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof mq1)) {
                            mq1Var = (mq1) obj;
                        } else {
                            mq1Var = new mq1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", mq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(mq1Var, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Router.navigateBack")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 B = mq1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    nq1 nq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof nq1)) {
                            nq1Var = (nq1) obj;
                        } else {
                            nq1Var = new nq1(this.mSwanApiContext);
                            this.mApis.put("1968522584", nq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(nq1Var, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Router.navigateTo")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 H = nq1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    pq1 pq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof pq1)) {
                            pq1Var = (pq1) obj;
                        } else {
                            pq1Var = new pq1(this.mSwanApiContext);
                            this.mApis.put("1317280190", pq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(pq1Var, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Router.reLaunch")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = pq1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    qq1 qq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof qq1)) {
                            qq1Var = (qq1) obj;
                        } else {
                            qq1Var = new qq1(this.mSwanApiContext);
                            this.mApis.put("-420075743", qq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(qq1Var, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Router.reLoadErrorPage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = qq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    oq1 oq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof oq1)) {
                            oq1Var = (oq1) obj;
                        } else {
                            oq1Var = new oq1(this.mSwanApiContext);
                            this.mApis.put("1792515533", oq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(oq1Var, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Router.redirectTo")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 D = oq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    nq1 nq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof nq1)) {
                            nq1Var = (nq1) obj;
                        } else {
                            nq1Var = new nq1(this.mSwanApiContext);
                            this.mApis.put("1968522584", nq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(nq1Var, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Router.showModalPage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 J = nq1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    tq1 tq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof tq1)) {
                            tq1Var = (tq1) obj;
                        } else {
                            tq1Var = new tq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", tq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(tq1Var, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Setting.getAppInfoSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 F = tq1Var.F();
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    tq1 tq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof tq1)) {
                            tq1Var = (tq1) obj;
                        } else {
                            tq1Var = new tq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", tq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(tq1Var, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Setting.getSetting")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 G = tq1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    tq1 tq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof tq1)) {
                            tq1Var = (tq1) obj;
                        } else {
                            tq1Var = new tq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", tq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(tq1Var, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Setting.getSlaveIdSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 H = tq1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    tq1 tq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof tq1)) {
                            tq1Var = (tq1) obj;
                        } else {
                            tq1Var = new tq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", tq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(tq1Var, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Setting.getSwanId")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 I = tq1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    tq1 tq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof tq1)) {
                            tq1Var = (tq1) obj;
                        } else {
                            tq1Var = new tq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", tq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(tq1Var, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Setting.getUserInfo")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 J = tq1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    sq1 sq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof sq1)) {
                            sq1Var = (sq1) obj;
                        } else {
                            sq1Var = new sq1(this.mSwanApiContext);
                            this.mApis.put("450273045", sq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(sq1Var, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Setting.isAllowedAdOpenAppSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = sq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    r73 r73Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof r73)) {
                            r73Var = (r73) obj;
                        } else {
                            r73Var = new r73(this.mSwanApiContext);
                            this.mApis.put("712777136", r73Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(r73Var, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = r73Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    wq1 wq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof wq1)) {
                            wq1Var = (wq1) obj;
                        } else {
                            wq1Var = new wq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", wq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(wq1Var, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.clearGlobalStorage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = wq1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    wq1 wq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof wq1)) {
                            wq1Var = (wq1) obj;
                        } else {
                            wq1Var = new wq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", wq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(wq1Var, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.clearGlobalStorageSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 C = wq1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    vq1 vq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("130910081", vq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(vq1Var, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.clearStorage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = vq1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    vq1 vq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("130910081", vq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(vq1Var, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.clearStorageSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 C = vq1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    wq1 wq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof wq1)) {
                            wq1Var = (wq1) obj;
                        } else {
                            wq1Var = new wq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", wq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(wq1Var, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.getGlobalStorage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 D = wq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    wq1 wq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof wq1)) {
                            wq1Var = (wq1) obj;
                        } else {
                            wq1Var = new wq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", wq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(wq1Var, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.getGlobalStorageInfo")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 G = wq1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    wq1 wq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof wq1)) {
                            wq1Var = (wq1) obj;
                        } else {
                            wq1Var = new wq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", wq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(wq1Var, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.getGlobalStorageInfoSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 J = wq1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    wq1 wq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof wq1)) {
                            wq1Var = (wq1) obj;
                        } else {
                            wq1Var = new wq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", wq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(wq1Var, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.getGlobalStorageSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 K = wq1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    vq1 vq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("130910081", vq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(vq1Var, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.getStorage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 D = vq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    vq1 vq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("130910081", vq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(vq1Var, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.getStorageInfo")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 G = vq1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    vq1 vq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("130910081", vq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(vq1Var, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.getStorageInfoAsync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 H = vq1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    vq1 vq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("130910081", vq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(vq1Var, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.getStorageInfoSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 J = vq1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    vq1 vq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("130910081", vq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(vq1Var, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.getStorageSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 K = vq1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    wq1 wq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof wq1)) {
                            wq1Var = (wq1) obj;
                        } else {
                            wq1Var = new wq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", wq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(wq1Var, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.removeGlobalStorage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 R = wq1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    wq1 wq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof wq1)) {
                            wq1Var = (wq1) obj;
                        } else {
                            wq1Var = new wq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", wq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(wq1Var, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.removeGlobalStorageSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 T = wq1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    vq1 vq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("130910081", vq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(vq1Var, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.removeStorage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 R = vq1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    vq1 vq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("130910081", vq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(vq1Var, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.removeStorageSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 T = vq1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    wq1 wq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof wq1)) {
                            wq1Var = (wq1) obj;
                        } else {
                            wq1Var = new wq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", wq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(wq1Var, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.setGlobalStorage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 U = wq1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    wq1 wq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof wq1)) {
                            wq1Var = (wq1) obj;
                        } else {
                            wq1Var = new wq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", wq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(wq1Var, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.setGlobalStorageSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 W = wq1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    vq1 vq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("130910081", vq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(vq1Var, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.setStorage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 U = vq1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    vq1 vq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("130910081", vq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(vq1Var, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.setStorageSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 W = vq1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    yq1 yq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof yq1)) {
                            yq1Var = (yq1) obj;
                        } else {
                            yq1Var = new yq1(this.mSwanApiContext);
                            this.mApis.put("823117982", yq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(yq1Var, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Subscription.requestSubscribeFormId")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 E = yq1Var.E(str);
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    zq1 zq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof zq1)) {
                            zq1Var = (zq1) obj;
                        } else {
                            zq1Var = new zq1(this.mSwanApiContext);
                            this.mApis.put("-947445811", zq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(zq1Var, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Subscription.subscribeService")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 F = zq1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    gr1 gr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof gr1)) {
                            gr1Var = (gr1) obj;
                        } else {
                            gr1Var = new gr1(this.mSwanApiContext);
                            this.mApis.put("1936205521", gr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(gr1Var, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.exitFullScreen")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = gr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    cr1 cr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("99997465", cr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(cr1Var, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.getBrightness")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = cr1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    dr1 dr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof dr1)) {
                            dr1Var = (dr1) obj;
                        } else {
                            dr1Var = new dr1(this.mSwanApiContext);
                            this.mApis.put("-518757484", dr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(dr1Var, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.getClipboardData")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = dr1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    fr1 fr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof fr1)) {
                            fr1Var = (fr1) obj;
                        } else {
                            fr1Var = new fr1(this.mSwanApiContext);
                            this.mApis.put("1694151270", fr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(fr1Var, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.getDeviceInfo")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = fr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    hr1 hr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof hr1)) {
                            hr1Var = (hr1) obj;
                        } else {
                            hr1Var = new hr1(this.mSwanApiContext);
                            this.mApis.put("-1321681619", hr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(hr1Var, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.getDeviceProfile")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = hr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    nr1 nr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof nr1)) {
                            nr1Var = (nr1) obj;
                        } else {
                            nr1Var = new nr1(this.mSwanApiContext);
                            this.mApis.put("447234992", nr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(nr1Var, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.getMediaVolume")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = nr1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    ir1 ir1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof ir1)) {
                            ir1Var = (ir1) obj;
                        } else {
                            ir1Var = new ir1(this.mSwanApiContext);
                            this.mApis.put("-1569246082", ir1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ir1Var, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.makePhoneCall")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = ir1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    kr1 kr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof kr1)) {
                            kr1Var = (kr1) obj;
                        } else {
                            kr1Var = new kr1(this.mSwanApiContext);
                            this.mApis.put("1099851202", kr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(kr1Var, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.openSMSPanel")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = kr1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    jr1 jr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof jr1)) {
                            jr1Var = (jr1) obj;
                        } else {
                            jr1Var = new jr1(this.mSwanApiContext);
                            this.mApis.put("-1707203360", jr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(jr1Var, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.requestFullScreen")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 F = jr1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    dr1 dr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof dr1)) {
                            dr1Var = (dr1) obj;
                        } else {
                            dr1Var = new dr1(this.mSwanApiContext);
                            this.mApis.put("-518757484", dr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(dr1Var, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.setClipboardData")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = dr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    nq2 nq2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof nq2)) {
                            nq2Var = (nq2) obj;
                        } else {
                            nq2Var = new nq2(this.mSwanApiContext);
                            this.mApis.put("1161486049", nq2Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(nq2Var, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.setErrorPageType")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = nq2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    nr1 nr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof nr1)) {
                            nr1Var = (nr1) obj;
                        } else {
                            nr1Var = new nr1(this.mSwanApiContext);
                            this.mApis.put("447234992", nr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(nr1Var, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.setMediaVolume")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 z = nr1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("1372680763", br1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(br1Var, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.startAccelerometer")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = br1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    er1 er1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof er1)) {
                            er1Var = (er1) obj;
                        } else {
                            er1Var = new er1(this.mSwanApiContext);
                            this.mApis.put("1689255576", er1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(er1Var, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.startCompass")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = er1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    br1 br1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("1372680763", br1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(br1Var, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.stopAccelerometer")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 B = br1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    er1 er1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof er1)) {
                            er1Var = (er1) obj;
                        } else {
                            er1Var = new er1(this.mSwanApiContext);
                            this.mApis.put("1689255576", er1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(er1Var, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.stopCompass")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 z = er1Var.z();
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    yr1 yr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof yr1)) {
                            yr1Var = (yr1) obj;
                        } else {
                            yr1Var = new yr1(this.mSwanApiContext);
                            this.mApis.put("201194468", yr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(yr1Var, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.addToDesktop")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 B = yr1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    ur1 ur1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof ur1)) {
                            ur1Var = (ur1) obj;
                        } else {
                            ur1Var = new ur1(this.mSwanApiContext);
                            this.mApis.put("-1412306947", ur1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ur1Var, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.calcMD5")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = ur1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    vr1 vr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof vr1)) {
                            vr1Var = (vr1) obj;
                        } else {
                            vr1Var = new vr1(this.mSwanApiContext);
                            this.mApis.put("1626415364", vr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(vr1Var, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.checkAppInstalled")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = vr1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    xr1 xr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof xr1)) {
                            xr1Var = (xr1) obj;
                        } else {
                            xr1Var = new xr1(this.mSwanApiContext);
                            this.mApis.put("-836768778", xr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(xr1Var, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.getCommonSysInfo")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = xr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    ds1 ds1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof ds1)) {
                            ds1Var = (ds1) obj;
                        } else {
                            ds1Var = new ds1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", ds1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ds1Var, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.getCommonSysInfoSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 E = ds1Var.E();
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    zr1 zr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof zr1)) {
                            zr1Var = (zr1) obj;
                        } else {
                            zr1Var = new zr1(this.mSwanApiContext);
                            this.mApis.put("-810858308", zr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(zr1Var, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.getPerformanceLevel")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = zr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    ds1 ds1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof ds1)) {
                            ds1Var = (ds1) obj;
                        } else {
                            ds1Var = new ds1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", ds1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ds1Var, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.getSystemInfo")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 H = ds1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    ds1 ds1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof ds1)) {
                            ds1Var = (ds1) obj;
                        } else {
                            ds1Var = new ds1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", ds1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ds1Var, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.getSystemInfoAsync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 I = ds1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    ds1 ds1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof ds1)) {
                            ds1Var = (ds1) obj;
                        } else {
                            ds1Var = new ds1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", ds1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ds1Var, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.getSystemInfoSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 J = ds1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    as1 as1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof as1)) {
                            as1Var = (as1) obj;
                        } else {
                            as1Var = new as1(this.mSwanApiContext);
                            this.mApis.put("-2097727681", as1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(as1Var, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.handleException")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = as1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    wr1 wr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof wr1)) {
                            wr1Var = (wr1) obj;
                        } else {
                            wr1Var = new wr1(this.mSwanApiContext);
                            this.mApis.put("2084449317", wr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(wr1Var, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.hasCloseHandler")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = wr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    z43 z43Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof z43)) {
                            z43Var = (z43) obj;
                        } else {
                            z43Var = new z43(this.mSwanApiContext);
                            this.mApis.put("1031678042", z43Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(z43Var, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.hideCaptureScreenShareDialog")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = z43Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    bs1 bs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof bs1)) {
                            bs1Var = (bs1) obj;
                        } else {
                            bs1Var = new bs1(this.mSwanApiContext);
                            this.mApis.put("1751900130", bs1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(bs1Var, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.logToFile")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = bs1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    a43 a43Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof a43)) {
                            a43Var = (a43) obj;
                        } else {
                            a43Var = new a43(this.mSwanApiContext);
                            this.mApis.put("1748196865", a43Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(a43Var, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.preloadPackage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = a43Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    cs1 cs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof cs1)) {
                            cs1Var = (cs1) obj;
                        } else {
                            cs1Var = new cs1(this.mSwanApiContext);
                            this.mApis.put("589529211", cs1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(cs1Var, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.previewImage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 B = cs1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    fs1 fs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof fs1)) {
                            fs1Var = (fs1) obj;
                        } else {
                            fs1Var = new fs1(this.mSwanApiContext);
                            this.mApis.put("-577481801", fs1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(fs1Var, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.ubcFlowJar")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 I = fs1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    kb3 kb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof kb3)) {
                            kb3Var = (kb3) obj;
                        } else {
                            kb3Var = new kb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", kb3Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(kb3Var, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Wifi.connectWifi")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = kb3Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    kb3 kb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof kb3)) {
                            kb3Var = (kb3) obj;
                        } else {
                            kb3Var = new kb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", kb3Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(kb3Var, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Wifi.getConnectedWifi")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 B = kb3Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    kb3 kb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof kb3)) {
                            kb3Var = (kb3) obj;
                        } else {
                            kb3Var = new kb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", kb3Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(kb3Var, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Wifi.getWifiList")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 C = kb3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    kb3 kb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof kb3)) {
                            kb3Var = (kb3) obj;
                        } else {
                            kb3Var = new kb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", kb3Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(kb3Var, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Wifi.startWifi")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 G = kb3Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    kb3 kb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof kb3)) {
                            kb3Var = (kb3) obj;
                        } else {
                            kb3Var = new kb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", kb3Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(kb3Var, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Wifi.stopWifi")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 H = kb3Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static Map<String, Object> getWebviewApiModules(final vo1 vo1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, vo1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    bp1 bp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof bp1)) {
                            bp1Var = (bp1) obj;
                        } else {
                            bp1Var = new bp1(this.mSwanApiContext);
                            this.mApis.put("1930258908", bp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(bp1Var, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Account.checkSession")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = bp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    cp1 cp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof cp1)) {
                            cp1Var = (cp1) obj;
                        } else {
                            cp1Var = new cp1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", cp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(cp1Var, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Account.getLoginCode")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 C = cp1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    dp1 dp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof dp1)) {
                            dp1Var = (dp1) obj;
                        } else {
                            dp1Var = new dp1(this.mSwanApiContext);
                            this.mApis.put("1754780133", dp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(dp1Var, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Account.getOpenId")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = dp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    ko1 ko1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof ko1)) {
                            ko1Var = (ko1) obj;
                        } else {
                            ko1Var = new ko1(this.mSwanApiContext);
                            this.mApis.put("-343998465", ko1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ko1Var, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Account.getUnionBDUSS")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = ko1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    ap1 ap1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof ap1)) {
                            ap1Var = (ap1) obj;
                        } else {
                            ap1Var = new ap1(this.mSwanApiContext);
                            this.mApis.put("-337742792", ap1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ap1Var, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Account.isBaiduAccountSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = ap1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    cp1 cp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof cp1)) {
                            cp1Var = (cp1) obj;
                        } else {
                            cp1Var = new cp1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", cp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(cp1Var, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Account.isLoginSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 H = cp1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    cp1 cp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof cp1)) {
                            cp1Var = (cp1) obj;
                        } else {
                            cp1Var = new cp1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", cp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(cp1Var, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Account.login")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 I = cp1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    ep1 ep1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof ep1)) {
                            ep1Var = (ep1) obj;
                        } else {
                            ep1Var = new ep1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", ep1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ep1Var, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Basic.loadSubPackage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 F = ep1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    ep1 ep1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof ep1)) {
                            ep1Var = (ep1) obj;
                        } else {
                            ep1Var = new ep1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", ep1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ep1Var, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Basic.loadSubPackages")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 G = ep1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    lh1 lh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof lh1)) {
                            lh1Var = (lh1) obj;
                        } else {
                            lh1Var = new lh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", lh1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(lh1Var, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Bookshelf.deleteBookshelf")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 K = lh1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    lh1 lh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof lh1)) {
                            lh1Var = (lh1) obj;
                        } else {
                            lh1Var = new lh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", lh1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(lh1Var, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Bookshelf.insertBookshelf")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 P = lh1Var.P(str);
                        return P == null ? "" : P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    lh1 lh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof lh1)) {
                            lh1Var = (lh1) obj;
                        } else {
                            lh1Var = new lh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", lh1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(lh1Var, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Bookshelf.navigateToBookshelf")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 U = lh1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    lh1 lh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof lh1)) {
                            lh1Var = (lh1) obj;
                        } else {
                            lh1Var = new lh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", lh1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(lh1Var, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Bookshelf.queryBookshelf")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 V = lh1Var.V(str);
                        return V == null ? "" : V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    lh1 lh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof lh1)) {
                            lh1Var = (lh1) obj;
                        } else {
                            lh1Var = new lh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", lh1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(lh1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Bookshelf.updateBookshelfReadTime")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 X = lh1Var.X(str);
                        return X == null ? "" : X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    yo1 yo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof yo1)) {
                            yo1Var = (yo1) obj;
                        } else {
                            yo1Var = new yo1(this.mSwanApiContext);
                            this.mApis.put("-277316359", yo1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(yo1Var, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Coupon.getPlatformCoupons")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = yo1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    yo1 yo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof yo1)) {
                            yo1Var = (yo1) obj;
                        } else {
                            yo1Var = new yo1(this.mSwanApiContext);
                            this.mApis.put("-277316359", yo1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(yo1Var, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Coupon.getUserCoupons")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 z = yo1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    yo1 yo1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof yo1)) {
                            yo1Var = (yo1) obj;
                        } else {
                            yo1Var = new yo1(this.mSwanApiContext);
                            this.mApis.put("-277316359", yo1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(yo1Var, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Coupon.takeCoupons")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 C = yo1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    gp1 gp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("-1225406515", gp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(gp1Var, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Favorite.getFavorStatus")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = gp1Var.x(str);
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
                        Pair<Boolean, ts1> a = vs1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Favorite.showFavoriteGuide")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 G = showFavoriteGuideApi.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("-2057135077", ip1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ip1Var, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "File.shareFile")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = ip1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    xd2 xd2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof xd2)) {
                            xd2Var = (xd2) obj;
                        } else {
                            xd2Var = new xd2(this.mSwanApiContext);
                            this.mApis.put("2077414795", xd2Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(xd2Var, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "GameCenter.postGameCenterMessage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = xd2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    xd2 xd2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof xd2)) {
                            xd2Var = (xd2) obj;
                        } else {
                            xd2Var = new xd2(this.mSwanApiContext);
                            this.mApis.put("2077414795", xd2Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(xd2Var, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "GameCenter.postGameCenterMessageSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = xd2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String download(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-170124576", jp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(jp1Var, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "HostDownloadManager.download")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = jp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    jp1 jp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-170124576", jp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(jp1Var, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "HostDownloadManager.openDownloadCenter")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = jp1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-170124576", jp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(jp1Var, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "HostDownloadManager.openFile")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 z = jp1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-170124576", jp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(jp1Var, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "HostDownloadManager.query")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 query = jp1Var.query(str);
                        return query == null ? "" : query.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naImage", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    lq2 lq2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof lq2)) {
                            lq2Var = (lq2) obj;
                        } else {
                            lq2Var = new lq2(this.mSwanApiContext);
                            this.mApis.put("1445003743", lq2Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(lq2Var, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Image.callImageMenu")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = lq2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    mp1 mp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof mp1)) {
                            mp1Var = (mp1) obj;
                        } else {
                            mp1Var = new mp1(this.mSwanApiContext);
                            this.mApis.put("-1252730367", mp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(mp1Var, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Image.compressImage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = mp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    up1 up1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", up1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(up1Var, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.closeTabBar")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = up1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    up1 up1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", up1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(up1Var, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.closeTabBarRedDot")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = up1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    op1 op1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof op1)) {
                            op1Var = (op1) obj;
                        } else {
                            op1Var = new op1(this.mSwanApiContext);
                            this.mApis.put("5236036", op1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(op1Var, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.hideLoading")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = op1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    qp1 qp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof qp1)) {
                            qp1Var = (qp1) obj;
                        } else {
                            qp1Var = new qp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", qp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(qp1Var, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.hideNavigationBarLoading")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = qp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    vp1 vp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof vp1)) {
                            vp1Var = (vp1) obj;
                        } else {
                            vp1Var = new vp1(this.mSwanApiContext);
                            this.mApis.put("1159492510", vp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(vp1Var, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.hideToast")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 K = vp1Var.K();
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    sp1 sp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof sp1)) {
                            sp1Var = (sp1) obj;
                        } else {
                            sp1Var = new sp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", sp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(sp1Var, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.openMultiPicker")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 G = sp1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    sp1 sp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof sp1)) {
                            sp1Var = (sp1) obj;
                        } else {
                            sp1Var = new sp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", sp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(sp1Var, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.openPicker")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 H = sp1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    up1 up1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", up1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(up1Var, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.openTabBar")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 C = up1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    rp1 rp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof rp1)) {
                            rp1Var = (rp1) obj;
                        } else {
                            rp1Var = new rp1(this.mSwanApiContext);
                            this.mApis.put("-1750613704", rp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(rp1Var, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.pageScrollTo")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = rp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    qp1 qp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof qp1)) {
                            qp1Var = (qp1) obj;
                        } else {
                            qp1Var = new qp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", qp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(qp1Var, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.setNavigationBarColor")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 z = qp1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    qp1 qp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof qp1)) {
                            qp1Var = (qp1) obj;
                        } else {
                            qp1Var = new qp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", qp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(qp1Var, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.setNavigationBarTitle")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = qp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    up1 up1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", up1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(up1Var, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.setTabBarItem")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 D = up1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    sp1 sp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof sp1)) {
                            sp1Var = (sp1) obj;
                        } else {
                            sp1Var = new sp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", sp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(sp1Var, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.showDatePickerView")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 L = sp1Var.L(str);
                        return L == null ? "" : L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    wp1 wp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof wp1)) {
                            wp1Var = (wp1) obj;
                        } else {
                            wp1Var = new wp1(this.mSwanApiContext);
                            this.mApis.put("1172469410", wp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(wp1Var, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.showHalfScreenWebview")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 K = wp1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    op1 op1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof op1)) {
                            op1Var = (op1) obj;
                        } else {
                            op1Var = new op1(this.mSwanApiContext);
                            this.mApis.put("5236036", op1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(op1Var, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.showLoading")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = op1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    pp1 pp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof pp1)) {
                            pp1Var = (pp1) obj;
                        } else {
                            pp1Var = new pp1(this.mSwanApiContext);
                            this.mApis.put("1913747800", pp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(pp1Var, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.showModal")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = pp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    qp1 qp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof qp1)) {
                            qp1Var = (qp1) obj;
                        } else {
                            qp1Var = new qp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", qp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(qp1Var, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.showNavigationBarLoading")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 B = qp1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    vp1 vp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof vp1)) {
                            vp1Var = (vp1) obj;
                        } else {
                            vp1Var = new vp1(this.mSwanApiContext);
                            this.mApis.put("1159492510", vp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(vp1Var, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.showToast")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 Q = vp1Var.Q(str);
                        return Q == null ? "" : Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    tp1 tp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("1165118609", tp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(tp1Var, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.stopPullDownRefresh")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = tp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    sp1 sp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof sp1)) {
                            sp1Var = (sp1) obj;
                        } else {
                            sp1Var = new sp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", sp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(sp1Var, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Interaction.updateMultiPicker")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 M = sp1Var.M(str);
                        return M == null ? "" : M.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    xp1 xp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof xp1)) {
                            xp1Var = (xp1) obj;
                        } else {
                            xp1Var = new xp1(this.mSwanApiContext);
                            this.mApis.put("-137346255", xp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(xp1Var, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Keyboard.startKeyboardHeightChange")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 C = xp1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    xp1 xp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof xp1)) {
                            xp1Var = (xp1) obj;
                        } else {
                            xp1Var = new xp1(this.mSwanApiContext);
                            this.mApis.put("-137346255", xp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(xp1Var, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Keyboard.stopKeyboardHeightChange")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 D = xp1Var.D();
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    yp1 yp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof yp1)) {
                            yp1Var = (yp1) obj;
                        } else {
                            yp1Var = new yp1(this.mSwanApiContext);
                            this.mApis.put("-397373095", yp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(yp1Var, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "LocationService.getLocation")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = yp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    yp1 yp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof yp1)) {
                            yp1Var = (yp1) obj;
                        } else {
                            yp1Var = new yp1(this.mSwanApiContext);
                            this.mApis.put("-397373095", yp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(yp1Var, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "LocationService.startLocationUpdate")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = yp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    yp1 yp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof yp1)) {
                            yp1Var = (yp1) obj;
                        } else {
                            yp1Var = new yp1(this.mSwanApiContext);
                            this.mApis.put("-397373095", yp1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(yp1Var, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "LocationService.stopLocationUpdate")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 B = yp1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    pr1 pr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof pr1)) {
                            pr1Var = (pr1) obj;
                        } else {
                            pr1Var = new pr1(this.mSwanApiContext);
                            this.mApis.put("538070032", pr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(pr1Var, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = pr1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String callService(String str) {
                    bq1 bq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof bq1)) {
                            bq1Var = (bq1) obj;
                        } else {
                            bq1Var = new bq1(this.mSwanApiContext);
                            this.mApis.put("-1076509454", bq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(bq1Var, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Network.callService")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = bq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    iq1 iq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof iq1)) {
                            iq1Var = (iq1) obj;
                        } else {
                            iq1Var = new iq1(this.mSwanApiContext);
                            this.mApis.put("968563034", iq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(iq1Var, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Network.cancelRequest")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 D = iq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    hq1 hq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof hq1)) {
                            hq1Var = (hq1) obj;
                        } else {
                            hq1Var = new hq1(this.mSwanApiContext);
                            this.mApis.put("453220699", hq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(hq1Var, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Network.getNetworkType")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = hq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    hq1 hq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof hq1)) {
                            hq1Var = (hq1) obj;
                        } else {
                            hq1Var = new hq1(this.mSwanApiContext);
                            this.mApis.put("453220699", hq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(hq1Var, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Network.networkStatusChange")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = hq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                @JavascriptInterface
                public String request(String str) {
                    InterceptResult invokeL2;
                    iq1 iq1Var;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && (invokeL2 = interceptable2.invokeL(1048580, this, str)) != null) {
                        return (String) invokeL2.objValue;
                    }
                    try {
                        ss1.c().a("request");
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof iq1)) {
                            iq1Var = (iq1) obj;
                        } else {
                            iq1Var = new iq1(this.mSwanApiContext);
                            this.mApis.put("968563034", iq1Var);
                        }
                        Pair<Boolean, ts1> a2 = vs1.a(iq1Var, "swanAPI/request");
                        if (((Boolean) a2.first).booleanValue()) {
                            a = ((ts1) a2.second).a();
                        } else if (b32.a(this.mSwanApiContext.h(), "Network.request")) {
                            a = new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        } else {
                            Pair<ts1, JSONObject> u = xo1.u(str);
                            if (!((ts1) u.first).isSuccess()) {
                                a = ((ts1) u.first).a();
                            } else {
                                JSONObject jSONObject = (JSONObject) u.second;
                                if (jSONObject == null) {
                                    a = ts1.a.a();
                                } else {
                                    us1 V = iq1Var.V(jSONObject);
                                    a = V == null ? "" : V.a();
                                }
                            }
                        }
                        return a;
                    } finally {
                    }
                }
            });
            hashMap.put("_naPayment", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    rt2 rt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof rt2)) {
                            rt2Var = (rt2) obj;
                        } else {
                            rt2Var = new rt2(this.mSwanApiContext);
                            this.mApis.put("-336396851", rt2Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(rt2Var, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Payment.chooseCoupon")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = rt2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    rt2 rt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof rt2)) {
                            rt2Var = (rt2) obj;
                        } else {
                            rt2Var = new rt2(this.mSwanApiContext);
                            this.mApis.put("-336396851", rt2Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(rt2Var, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Payment.getPaymentInfo")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = rt2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    ht2 ht2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof ht2)) {
                            ht2Var = (ht2) obj;
                        } else {
                            ht2Var = new ht2(this.mSwanApiContext);
                            this.mApis.put("1854689529", ht2Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ht2Var, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Payment.requestThirdPayment")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = ht2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    rt2 rt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof rt2)) {
                            rt2Var = (rt2) obj;
                        } else {
                            rt2Var = new rt2(this.mSwanApiContext);
                            this.mApis.put("-336396851", rt2Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(rt2Var, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Payment.setPaymentInfo")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 z = rt2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    cw2 cw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof cw2)) {
                            cw2Var = (cw2) obj;
                        } else {
                            cw2Var = new cw2(this.mSwanApiContext);
                            this.mApis.put("-254510461", cw2Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(cw2Var, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Plugin.invokePluginChooseAddress")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = cw2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    cw2 cw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof cw2)) {
                            cw2Var = (cw2) obj;
                        } else {
                            cw2Var = new cw2(this.mSwanApiContext);
                            this.mApis.put("-254510461", cw2Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(cw2Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 z = cw2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    cw2 cw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof cw2)) {
                            cw2Var = (cw2) obj;
                        } else {
                            cw2Var = new cw2(this.mSwanApiContext);
                            this.mApis.put("-254510461", cw2Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(cw2Var, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Plugin.invokePluginPayment")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = cw2Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    v42 v42Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof v42)) {
                            v42Var = (v42) obj;
                        } else {
                            v42Var = new v42(this.mSwanApiContext);
                            this.mApis.put("-2068479848", v42Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(v42Var, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Prefetch.prefetchResources")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = v42Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    n32 n32Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof n32)) {
                            n32Var = (n32) obj;
                        } else {
                            n32Var = new n32(this.mSwanApiContext);
                            this.mApis.put("423661539", n32Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(n32Var, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Preload.preloadStatus")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = n32Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    xc3 xc3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof xc3)) {
                            xc3Var = (xc3) obj;
                        } else {
                            xc3Var = new xc3(this.mSwanApiContext);
                            this.mApis.put("-1929343869", xc3Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(xc3Var, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "PrivateFile.uploadFileToBos")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 C = xc3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    mq1 mq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof mq1)) {
                            mq1Var = (mq1) obj;
                        } else {
                            mq1Var = new mq1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", mq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(mq1Var, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Router.hideModalPage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = mq1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    mq1 mq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof mq1)) {
                            mq1Var = (mq1) obj;
                        } else {
                            mq1Var = new mq1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", mq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(mq1Var, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Router.navigateBack")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 B = mq1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    nq1 nq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof nq1)) {
                            nq1Var = (nq1) obj;
                        } else {
                            nq1Var = new nq1(this.mSwanApiContext);
                            this.mApis.put("1968522584", nq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(nq1Var, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Router.navigateTo")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 H = nq1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    pq1 pq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof pq1)) {
                            pq1Var = (pq1) obj;
                        } else {
                            pq1Var = new pq1(this.mSwanApiContext);
                            this.mApis.put("1317280190", pq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(pq1Var, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Router.reLaunch")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = pq1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    qq1 qq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof qq1)) {
                            qq1Var = (qq1) obj;
                        } else {
                            qq1Var = new qq1(this.mSwanApiContext);
                            this.mApis.put("-420075743", qq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(qq1Var, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Router.reLoadErrorPage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = qq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    oq1 oq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof oq1)) {
                            oq1Var = (oq1) obj;
                        } else {
                            oq1Var = new oq1(this.mSwanApiContext);
                            this.mApis.put("1792515533", oq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(oq1Var, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Router.redirectTo")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 D = oq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    nq1 nq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof nq1)) {
                            nq1Var = (nq1) obj;
                        } else {
                            nq1Var = new nq1(this.mSwanApiContext);
                            this.mApis.put("1968522584", nq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(nq1Var, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Router.showModalPage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 J = nq1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    tq1 tq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof tq1)) {
                            tq1Var = (tq1) obj;
                        } else {
                            tq1Var = new tq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", tq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(tq1Var, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Setting.getAppInfoSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 F = tq1Var.F();
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    tq1 tq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof tq1)) {
                            tq1Var = (tq1) obj;
                        } else {
                            tq1Var = new tq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", tq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(tq1Var, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Setting.getSetting")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 G = tq1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    tq1 tq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof tq1)) {
                            tq1Var = (tq1) obj;
                        } else {
                            tq1Var = new tq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", tq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(tq1Var, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Setting.getSlaveIdSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 H = tq1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    tq1 tq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof tq1)) {
                            tq1Var = (tq1) obj;
                        } else {
                            tq1Var = new tq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", tq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(tq1Var, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Setting.getSwanId")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 I = tq1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    tq1 tq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof tq1)) {
                            tq1Var = (tq1) obj;
                        } else {
                            tq1Var = new tq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", tq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(tq1Var, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Setting.getUserInfo")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 J = tq1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    sq1 sq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof sq1)) {
                            sq1Var = (sq1) obj;
                        } else {
                            sq1Var = new sq1(this.mSwanApiContext);
                            this.mApis.put("450273045", sq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(sq1Var, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Setting.isAllowedAdOpenAppSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = sq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    r73 r73Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof r73)) {
                            r73Var = (r73) obj;
                        } else {
                            r73Var = new r73(this.mSwanApiContext);
                            this.mApis.put("712777136", r73Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(r73Var, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = r73Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    wq1 wq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof wq1)) {
                            wq1Var = (wq1) obj;
                        } else {
                            wq1Var = new wq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", wq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(wq1Var, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.clearGlobalStorage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = wq1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    wq1 wq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof wq1)) {
                            wq1Var = (wq1) obj;
                        } else {
                            wq1Var = new wq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", wq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(wq1Var, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.clearGlobalStorageSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 C = wq1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    vq1 vq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("130910081", vq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(vq1Var, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.clearStorage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = vq1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    vq1 vq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("130910081", vq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(vq1Var, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.clearStorageSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 C = vq1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    wq1 wq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof wq1)) {
                            wq1Var = (wq1) obj;
                        } else {
                            wq1Var = new wq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", wq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(wq1Var, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.getGlobalStorage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 D = wq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    wq1 wq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof wq1)) {
                            wq1Var = (wq1) obj;
                        } else {
                            wq1Var = new wq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", wq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(wq1Var, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.getGlobalStorageInfo")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 G = wq1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    wq1 wq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof wq1)) {
                            wq1Var = (wq1) obj;
                        } else {
                            wq1Var = new wq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", wq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(wq1Var, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.getGlobalStorageInfoSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 J = wq1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    wq1 wq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof wq1)) {
                            wq1Var = (wq1) obj;
                        } else {
                            wq1Var = new wq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", wq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(wq1Var, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.getGlobalStorageSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 K = wq1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    vq1 vq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("130910081", vq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(vq1Var, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.getStorage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 D = vq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    vq1 vq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("130910081", vq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(vq1Var, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.getStorageInfo")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 G = vq1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    vq1 vq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("130910081", vq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(vq1Var, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.getStorageInfoAsync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 H = vq1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    vq1 vq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("130910081", vq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(vq1Var, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.getStorageInfoSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 J = vq1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    vq1 vq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("130910081", vq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(vq1Var, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.getStorageSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 K = vq1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    wq1 wq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof wq1)) {
                            wq1Var = (wq1) obj;
                        } else {
                            wq1Var = new wq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", wq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(wq1Var, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.removeGlobalStorage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 R = wq1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    wq1 wq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof wq1)) {
                            wq1Var = (wq1) obj;
                        } else {
                            wq1Var = new wq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", wq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(wq1Var, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.removeGlobalStorageSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 T = wq1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    vq1 vq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("130910081", vq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(vq1Var, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.removeStorage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 R = vq1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    vq1 vq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("130910081", vq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(vq1Var, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.removeStorageSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 T = vq1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    wq1 wq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof wq1)) {
                            wq1Var = (wq1) obj;
                        } else {
                            wq1Var = new wq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", wq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(wq1Var, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.setGlobalStorage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 U = wq1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    wq1 wq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof wq1)) {
                            wq1Var = (wq1) obj;
                        } else {
                            wq1Var = new wq1(this.mSwanApiContext);
                            this.mApis.put("-804054859", wq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(wq1Var, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.setGlobalStorageSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 W = wq1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    vq1 vq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("130910081", vq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(vq1Var, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.setStorage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 U = vq1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    vq1 vq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("130910081", vq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(vq1Var, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Storage.setStorageSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 W = vq1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    yq1 yq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof yq1)) {
                            yq1Var = (yq1) obj;
                        } else {
                            yq1Var = new yq1(this.mSwanApiContext);
                            this.mApis.put("823117982", yq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(yq1Var, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Subscription.requestSubscribeFormId")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 E = yq1Var.E(str);
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    zq1 zq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof zq1)) {
                            zq1Var = (zq1) obj;
                        } else {
                            zq1Var = new zq1(this.mSwanApiContext);
                            this.mApis.put("-947445811", zq1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(zq1Var, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Subscription.subscribeService")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 F = zq1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    gr1 gr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof gr1)) {
                            gr1Var = (gr1) obj;
                        } else {
                            gr1Var = new gr1(this.mSwanApiContext);
                            this.mApis.put("1936205521", gr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(gr1Var, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.exitFullScreen")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = gr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    cr1 cr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("99997465", cr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(cr1Var, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.getBrightness")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = cr1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    dr1 dr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof dr1)) {
                            dr1Var = (dr1) obj;
                        } else {
                            dr1Var = new dr1(this.mSwanApiContext);
                            this.mApis.put("-518757484", dr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(dr1Var, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.getClipboardData")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = dr1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    fr1 fr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof fr1)) {
                            fr1Var = (fr1) obj;
                        } else {
                            fr1Var = new fr1(this.mSwanApiContext);
                            this.mApis.put("1694151270", fr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(fr1Var, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.getDeviceInfo")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = fr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    hr1 hr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof hr1)) {
                            hr1Var = (hr1) obj;
                        } else {
                            hr1Var = new hr1(this.mSwanApiContext);
                            this.mApis.put("-1321681619", hr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(hr1Var, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.getDeviceProfile")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = hr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    nr1 nr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof nr1)) {
                            nr1Var = (nr1) obj;
                        } else {
                            nr1Var = new nr1(this.mSwanApiContext);
                            this.mApis.put("447234992", nr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(nr1Var, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.getMediaVolume")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = nr1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    ir1 ir1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof ir1)) {
                            ir1Var = (ir1) obj;
                        } else {
                            ir1Var = new ir1(this.mSwanApiContext);
                            this.mApis.put("-1569246082", ir1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ir1Var, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.makePhoneCall")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = ir1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    kr1 kr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof kr1)) {
                            kr1Var = (kr1) obj;
                        } else {
                            kr1Var = new kr1(this.mSwanApiContext);
                            this.mApis.put("1099851202", kr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(kr1Var, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.openSMSPanel")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = kr1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    jr1 jr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof jr1)) {
                            jr1Var = (jr1) obj;
                        } else {
                            jr1Var = new jr1(this.mSwanApiContext);
                            this.mApis.put("-1707203360", jr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(jr1Var, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.requestFullScreen")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 F = jr1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    dr1 dr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof dr1)) {
                            dr1Var = (dr1) obj;
                        } else {
                            dr1Var = new dr1(this.mSwanApiContext);
                            this.mApis.put("-518757484", dr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(dr1Var, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.setClipboardData")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = dr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    nq2 nq2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof nq2)) {
                            nq2Var = (nq2) obj;
                        } else {
                            nq2Var = new nq2(this.mSwanApiContext);
                            this.mApis.put("1161486049", nq2Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(nq2Var, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.setErrorPageType")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = nq2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    nr1 nr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof nr1)) {
                            nr1Var = (nr1) obj;
                        } else {
                            nr1Var = new nr1(this.mSwanApiContext);
                            this.mApis.put("447234992", nr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(nr1Var, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.setMediaVolume")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 z = nr1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("1372680763", br1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(br1Var, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.startAccelerometer")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = br1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    er1 er1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof er1)) {
                            er1Var = (er1) obj;
                        } else {
                            er1Var = new er1(this.mSwanApiContext);
                            this.mApis.put("1689255576", er1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(er1Var, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.startCompass")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = er1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    br1 br1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("1372680763", br1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(br1Var, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.stopAccelerometer")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 B = br1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    er1 er1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof er1)) {
                            er1Var = (er1) obj;
                        } else {
                            er1Var = new er1(this.mSwanApiContext);
                            this.mApis.put("1689255576", er1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(er1Var, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "System.stopCompass")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 z = er1Var.z();
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    yr1 yr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof yr1)) {
                            yr1Var = (yr1) obj;
                        } else {
                            yr1Var = new yr1(this.mSwanApiContext);
                            this.mApis.put("201194468", yr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(yr1Var, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.addToDesktop")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 B = yr1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    ur1 ur1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof ur1)) {
                            ur1Var = (ur1) obj;
                        } else {
                            ur1Var = new ur1(this.mSwanApiContext);
                            this.mApis.put("-1412306947", ur1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ur1Var, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.calcMD5")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = ur1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    vr1 vr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof vr1)) {
                            vr1Var = (vr1) obj;
                        } else {
                            vr1Var = new vr1(this.mSwanApiContext);
                            this.mApis.put("1626415364", vr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(vr1Var, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.checkAppInstalled")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = vr1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    xr1 xr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof xr1)) {
                            xr1Var = (xr1) obj;
                        } else {
                            xr1Var = new xr1(this.mSwanApiContext);
                            this.mApis.put("-836768778", xr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(xr1Var, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.getCommonSysInfo")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = xr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    ds1 ds1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof ds1)) {
                            ds1Var = (ds1) obj;
                        } else {
                            ds1Var = new ds1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", ds1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ds1Var, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.getCommonSysInfoSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 E = ds1Var.E();
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    zr1 zr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof zr1)) {
                            zr1Var = (zr1) obj;
                        } else {
                            zr1Var = new zr1(this.mSwanApiContext);
                            this.mApis.put("-810858308", zr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(zr1Var, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.getPerformanceLevel")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = zr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    ds1 ds1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof ds1)) {
                            ds1Var = (ds1) obj;
                        } else {
                            ds1Var = new ds1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", ds1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ds1Var, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.getSystemInfo")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 H = ds1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    ds1 ds1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof ds1)) {
                            ds1Var = (ds1) obj;
                        } else {
                            ds1Var = new ds1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", ds1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ds1Var, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.getSystemInfoAsync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 I = ds1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    ds1 ds1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof ds1)) {
                            ds1Var = (ds1) obj;
                        } else {
                            ds1Var = new ds1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", ds1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ds1Var, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.getSystemInfoSync")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 J = ds1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    as1 as1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof as1)) {
                            as1Var = (as1) obj;
                        } else {
                            as1Var = new as1(this.mSwanApiContext);
                            this.mApis.put("-2097727681", as1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(as1Var, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.handleException")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = as1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    wr1 wr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof wr1)) {
                            wr1Var = (wr1) obj;
                        } else {
                            wr1Var = new wr1(this.mSwanApiContext);
                            this.mApis.put("2084449317", wr1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(wr1Var, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.hasCloseHandler")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = wr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    z43 z43Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof z43)) {
                            z43Var = (z43) obj;
                        } else {
                            z43Var = new z43(this.mSwanApiContext);
                            this.mApis.put("1031678042", z43Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(z43Var, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.hideCaptureScreenShareDialog")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 x = z43Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    bs1 bs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof bs1)) {
                            bs1Var = (bs1) obj;
                        } else {
                            bs1Var = new bs1(this.mSwanApiContext);
                            this.mApis.put("1751900130", bs1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(bs1Var, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.logToFile")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = bs1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    a43 a43Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof a43)) {
                            a43Var = (a43) obj;
                        } else {
                            a43Var = new a43(this.mSwanApiContext);
                            this.mApis.put("1748196865", a43Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(a43Var, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.preloadPackage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = a43Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    cs1 cs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof cs1)) {
                            cs1Var = (cs1) obj;
                        } else {
                            cs1Var = new cs1(this.mSwanApiContext);
                            this.mApis.put("589529211", cs1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(cs1Var, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.previewImage")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 B = cs1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    fs1 fs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof fs1)) {
                            fs1Var = (fs1) obj;
                        } else {
                            fs1Var = new fs1(this.mSwanApiContext);
                            this.mApis.put("-577481801", fs1Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(fs1Var, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Utils.ubcFlowJar")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 I = fs1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public vo1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vo1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = vo1Var;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    kb3 kb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof kb3)) {
                            kb3Var = (kb3) obj;
                        } else {
                            kb3Var = new kb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", kb3Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(kb3Var, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Wifi.connectWifi")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 A = kb3Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    kb3 kb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof kb3)) {
                            kb3Var = (kb3) obj;
                        } else {
                            kb3Var = new kb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", kb3Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(kb3Var, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Wifi.getConnectedWifi")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 B = kb3Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    kb3 kb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof kb3)) {
                            kb3Var = (kb3) obj;
                        } else {
                            kb3Var = new kb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", kb3Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(kb3Var, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Wifi.getWifiList")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 C = kb3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    kb3 kb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof kb3)) {
                            kb3Var = (kb3) obj;
                        } else {
                            kb3Var = new kb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", kb3Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(kb3Var, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Wifi.startWifi")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 G = kb3Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    kb3 kb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof kb3)) {
                            kb3Var = (kb3) obj;
                        } else {
                            kb3Var = new kb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", kb3Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(kb3Var, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "Wifi.stopWifi")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 H = kb3Var.H(str);
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
